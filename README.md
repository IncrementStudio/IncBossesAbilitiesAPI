# IncBossesAbilitiesAPI
**IncBossesAbilitiesAPI** - это API для самостоятельной разработки собственных способностей для плагина IncBosses, которые могут быть использованы для настройки поведения боссов

## Подключение
### Maven
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
<dependencies>
    <dependency>
        <groupId>com.github.IncrementStudio</groupId>
        <artifactId>IncBossesAbilitiesAPI</artifactId>
        <version>main-SNAPSHOT</version>
        <scope>compile</scope>
    </dependency>
</dependencies>
```
### Gradle
```groovy
repositories {
    maven { url 'https://jitpack.io' }
}
dependencies {
    compileOnly "com.github.IncrementStudio:IncBossesAbilitiesAPI:main-SNAPSHOT"
}
```
## Основа
После того как API было успешно подключено к проекту, вы должны унаследовать ваш главный класс не от **JavaPlugin**, а от **AbilityPlugin**
```java
package com.example.ability;

import ru.incrementstudio.incbosses.api.AbilityPlugin;

public class Main extends AbilityPlugin {
    
}
```
Далее вы должны реализовать метод `AbilityBase getAbility(Boss, Phase, FileConfiguration, ConfigurationSection)`, который должен возвращать экземпляр класса, унаследованного от **AbilityBase**, представляющий реализацию вашей способности. Давайте создадим этот класс
```java
package com.example.ability;

import ru.incrementstudio.incbosses.api.AbilityBase;

public class Ability extends AbilityBase {
    public Ability(Boss boss, Phase phase, FileConfiguration bossConfig, ConfigurationSection abilityConfig) {
        super(boss, phase, bossConfig, abilityConfig);
    }
}
```
К его реализации мы вернёмся позже. Пока что метод `getAbility` просто будет возвращать экземпляр этого класса
```java
package com.example.ability;

import ru.incrementstudio.incbosses.api.AbilityPlugin;
import ru.incrementstudio.incbosses.api.bosses.Boss;

public class Main extends AbilityPlugin {
    @Override
    public AbilityBase getAbility(Boss boss, Phase phase, FileConfiguration bossConfig, ConfigurationSection abilityConfig) {
        return new Ability(boss, phase, bossConfig, abilityConfig);
    }
}
```
Помимо обязательного метода `getAbility`, **AbilityPlugin** содержит и другие методы, которые можно реализовать по желанию:
- `void onAbilityEnable()` и `void onAbilityDisable()` - Аналоги `onEnable()` и `onDisable()` соответственно, использование которых не рекомендуется, так как их переопределение может нарушить работу способности
- `String getAbilityName()` - Как понятно из названия, данный метод возвращает имя способности, которое по умолчанию берётся из config.yml

Ко всему прочему **AbilityPlugin** имеет три статических метода:
- `AbilityPlugin getInstance()` - Возвращает экземпляр класса **AbilityPlugin**
- `Logger logger()` - Возвращает экземпляр класса **Logger**, используемый для вывода в консоль
- `ConfigManager getConfigManager()` - Возвращает экземпляр класса **ConfigManager**, используемый для управления конфигами способности
Поздравляю! Теперь у вас есть основа способности, которая, правда, пока ничего не делает. Давайте исправим это!
## Реализация способности: Теория
Когда босс меняет фазу, все способности внутри неё запускаются, а способности предыдущей фазы останавливаются. Запуск и остановка способности сопровождается вызовами методов `void start(StartReason)` и `void stop(StopReason)` соответственно. Данные функции принимают причину запуска/остановки способности:
- `StartReason.SPAWN` - Способность была запущена при спавне босса
- `StartReason.PHASE_CHANGING` - Способность была запущена из-за смены фазы
* `StopReason.DEATH` - Способность была остановлена из-за смерти босса
* `StopReason.PHASE_CHANGING` - Способность была остановлена из-за смены фазы
Имея такой небольшой набор входных данных можно создавать воистину уникальные способности!

Однако какие данные мы вообще имеем? Давайте посмотрим, что мы получаем в конструкторе **Ability**
```java
public Ability(Boss boss, Phase phase, FileConfiguration bossConfig, ConfigurationSection abilityConfig)
```
- `boss` - это экземпляр класса **Boss**, который используется для управления боссом
- `phase` - это экземпляр класса **Phase**, который используется для управления фазой
- `bossConfig` - это конфигурация всего босса
- `abilityConfig` - это конфигурация конкретно данной способности

*Классы **Boss** и **Phase** будут рассмотрены ниже*

Все эти данные также передаются в конструктор родительского класса **AbilityBase**, где сохраняются в одноимённые `protected` переменные, что позволяет вам использовать эти данные в любом месте вашего класса **Ability**
### Boss
**Boss** - это класс, который позволяет взаимодействовать и получать информацию о боссе. Его конструктор принимает один параметр - уникальный идентификатор босса.

У него есть следующие методы, благодаря которым можно взаимодействовать с боссом:
- `boolean equals(Object)`
- `int getId()`
- `BossData getData()`
- `LivingEntity getEntity()`
- `void kill()`
- `void isKilled()`
- `Player getKiller()`
- `Phase getCurrentPhase()`
- `List<Phase> getPhases()`
- `void changePhase(Phase)`
- `Map<UUID, Double> getDamageMap()`
- `BossDeathType getDeathType()`
- `BossSpawnType getSpawnType()`
### Phase
## Реализация способности: Практика
Пришло время вернуться к нашему классу **Ability**

Для примера мы создадим способность, которая при старте наносит заданный урон всем игрокам в радиусе, указанном в конфиге босса, а если способность вызвана ещё и при спавне босса, то она ко всему прочему создаёт 50 частиц драконьего дыханья в позиции босса. Возможно это звучит запутанно и сложно, но на самом деле это довольно просто реализовать!

**Ну что ж, приступим!**
### Работа с конфигами

Как вы помните, у нас среди входных данных есть `bossConfig` и `abilityConfig`, что это такое?

Всё просто! `bossConfig` - это полная конфигурация всего босса, а `abilityConfig` - это конфигурация конкретно данной способности. Вот пример:
```yaml
type: WITHER_SKELETON
health: 100
...
start-phase:
  type: SPECIFIC
  phase: first
phases:
  first:
    abilities:
      example:
        ability: Example
```
Это конфигурация босса, и она вся будет доступна в переменной `bossConfig`. Способность с именем *Example* - это наша способность, и нам нужно получить какие-то входные значения для неё. Вот тут нам на помощь приходит `abilityConfig`, в ней хранится секция конфига, которая принадлежит конкретно данной способности, то есть `phases.first.abilities.example` (значение `ability` должно быть всегда. Благодаря ему IncBosses определяет, какую способность надо запустить)

Теперь вернёмся к нашей ситуации. Нам нужно получить из конфига значение радиуса области, в которой игрокам будет наноситься урон, а также само количество урона.

В конфиг нашего босса, а конкретнее в секцию способности мы добавим два значения: `radius` и `damage`
```yaml
example:
  ability: ExampleAbility
  radius: 2.5
  damage: 5
```
Теперь через `abilityConfig` мы можем получать доступ к данным значениям. Давайте создадим в классе **Ability** одноимённые переменные и инициализируем их в конструкторе:
```java
public class Ability extends AbilityBase {
    private double radius, damage;
    
    public Ability(Boss boss, Phase phase, FileConfiguration bossConfig, ConfigurationSection abilityConfig) {
        super(boss, phase, bossConfig, abilityConfig);
        radius = abilityConfig.getDouble("radius");
        damage = abilityConfig.getDouble("damage");
    }
}
```
Теперь у нас есть нужные нам значения из конфига!
### Метод start
Как уже упоминалось выше, почти вся логика способности пишется в методах `start` и `stop`, однако для нашей способности будет использоваться только метод `start`. Давайте же создадим его!

```java
import ru.incrementstudio.incbosses.api.StartReason;

public class Ability extends AbilityBase {
    private double radius, damage;

    public Ability(Boss boss, Phase phase, FileConfiguration bossConfig, ConfigurationSection abilityConfig) {
        super(boss, phase, bossConfig, abilityConfig);
        radius = abilityConfig.getDouble("radius");
        damage = abilityConfig.getDouble("damage");
    }

    public void start(StartReason reason) {

    }
}
```
Именно тут мы и будем создавать всю реализацию нашей способности. Начнём с того, что при старте, не зависимо от причины, будем наносить заданный урон всем игрокам в заданном радиусе:
```java
public void start(StartReason reason) {
    LivingEntity bossEntity = boss.getEntity();
    List<Player> players = bossEntity.getNearbyEntities(radius, radius, radius).stream()
        .filter(x -> x instanceof Player)
        .filter(x -> x.getLocation().distance(bossEntity.getLocation()) <= radius)
        .map(x -> (Player) x)
        .collect(Collectors.toList());
    for (Player player : players)
        player.damage(damage);
}
```
Далее нам достаточно просто реализовать создание 50 частиц дыханья дракона, если способность вызвана при спавне босса:
```java
public void start(StartReason reason) {
    LivingEntity bossEntity = boss.getEntity();
    List<Player> players = bossEntity.getNearbyEntities(radius, radius, radius).stream()
        .filter(x -> x instanceof Player)
        .filter(x -> x.getLocation().distance(bossEntity.getLocation()) <= radius)
        .map(x -> (Player) x)
        .collect(Collectors.toList());
    for (Player player : players)
        player.damage(damage);
    if (reason == StartReason.SPAWN)
        bossEntity.getWorld().spawnParticle(Particle.DRAGON_BREATH, bossEntity.getLocation(), 50);
}
```
**Поздравляю!** Ваша первая способность готова!!!

Теперь вам достаточно просто собрать проект в *.jar* файл, перенести его в папку *IncBosses\abilities* и использовать при настройке боссов!
## Пара напутственных слов
Возможно пример был скудным и не таким уж впечатляющим, но уверяем вас, при должном старании и хоть капельке воображения, можно реализовать **ОЧЕНЬ** впечатляющие способности. **IncBossesAbilitiesAPI** позволяет вам применять свою фантазию на максимум и создавать таких боссов, о которых вы даже не мечтали! Творите и помните, что единственное ограничение - ваша фантазия!!!
<p align="right">С наилучшими пожеланиями<br>Команда IncrementStudio++</p>
