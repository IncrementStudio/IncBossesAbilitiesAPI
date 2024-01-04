# IncBossesAbilitiesAPI
**IncBossesAbilitiesAPI** - это API для самостоятельной разработки собственных способностей для плагина IncBosses, которые могут быть использованы для настройки поведения боссов

## Содержание
- [Подключение](#подключение)
  - [Maven](#maven)
  - [Gradle](#gradle)
- [Основа](#основа)
- [Реализация способности: Теория](#реализация-способности-теория)
  - [Boss](#boss)
  - [BossData](#bossdata)
  - [Phase](#phase)
  - [PhaseData](#phasedata)
- [Реализация способности: Практика](#реализация-способности-практика)
  - [Работа с конфигами](#работа-с-конфигами)
  - [Метод start](#метод-start)
- [Пара напутственных слов](#пара-напутственных-слов)

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
public class Main extends AbilityPlugin {
    
}
```
Далее вы должны реализовать метод `AbilityBase getAbility(Boss, Phase, FileConfiguration, ConfigurationSection)`, который должен возвращать экземпляр класса, унаследованного от **AbilityBase**, представляющий реализацию вашей способности. Давайте создадим этот класс
```java
public class Ability extends AbilityBase {
    public Ability(Boss boss, Phase phase, FileConfiguration bossConfig, ConfigurationSection abilityConfig) {
        super(boss, phase, bossConfig, abilityConfig);
    }
}
```
К его реализации мы вернёмся позже. Пока что метод `getAbility` просто будет возвращать экземпляр этого класса
```java
public class Main extends AbilityPlugin {
    @Override
    public AbilityBase getAbility(Boss boss, Phase phase, FileConfiguration bossConfig, ConfigurationSection abilityConfig) {
        return new Ability(boss, phase, bossConfig, abilityConfig);
    }
}
```
Помимо обязательного метода `getAbility`, **AbilityPlugin** содержит и другие методы, которые можно реализовать по желанию:
- `void onAbilityEnable()` и `void onAbilityDisable()` - Аналоги `onEnable()` и `onDisable()` соответственно
- `String getAbilityName()` - Как понятно из названия, данный метод возвращает имя способности, которое по умолчанию равно названию плагина

Ко всему прочему **AbilityPlugin** имеет три статических метода:
- `AbilityPlugin getInstance()` - Возвращает экземпляр класса **AbilityPlugin**
- `Logger logger()` - Возвращает экземпляр класса **Logger**, используемый для вывода в консоль
- `ConfigManager getConfigManager()` - Возвращает экземпляр класса **ConfigManager**, используемый для управления конфигами способности

Давайте переопределим метод `getAbilityName` и самостоятельно укажем имя способности
```java
public class Main extends AbilityPlugin {
    @Override
    public AbilityBase getAbility(Boss boss, Phase phase, FileConfiguration bossConfig, ConfigurationSection abilityConfig) {
        return new Ability(boss, phase, bossConfig, abilityConfig);
    }
    
    @Override
    public String getAbilityName() {
        return "Example";
    }
}
```

Поздравляю! Теперь у вас есть основа способности, которая, правда, пока ничего не делает. Давайте исправим это!
## Реализация способности: Теория
Когда босс меняет фазу, все способности внутри неё запускаются, а способности предыдущей фазы останавливаются. Запуск и остановка способности сопровождается вызовами методов `void start(StartReason)` и `void stop(StopReason)` соответственно. Данные функции принимают причину запуска/остановки способности:
- `StartReason.SPAWN` - Способность была запущена при спавне босса
- `StartReason.PHASE_CHANGING` - Способность была запущена из-за смены фазы
* `StopReason.DEATH` - Способность была остановлена из-за смерти босса
* `StopReason.PHASE_CHANGING` - Способность была остановлена из-за смены фазы

Имея такой небольшой набор входных данных можно создавать воистину уникальные способности!

Однако какие данные мы вообще имеем? Давайте посмотрим, что мы получаем в конструкторе **AbilityBase**
```java
public AbilityBase(Boss boss, Phase phase, FileConfiguration bossConfig, ConfigurationSection abilityConfig)
```
- `boss` - это экземпляр класса **Boss**, который используется для управления боссом
- `phase` - это экземпляр класса **Phase**, который используется для управления фазой
- `bossConfig` - это конфигурация всего босса
- `abilityConfig` - это конфигурация конкретно данной способности

*Классы **Boss** и **Phase** будут рассмотрены ниже*

Все эти данные сохраняются в одноимённые `protected` переменные, что позволяет вам использовать эти данные в любом месте вашего класса **Ability**
### Boss
**Boss** - это класс, который позволяет взаимодействовать и получать информацию о боссе. Его конструктор принимает один параметр - уникальный идентификатор босса.

У него есть такие методы:
- `boolean equals(Object)` - метод, сравнивающий двух боссов (сравниваются по id)
- `int getId()` - метод, возвращающий уникальный id босса
- `BossData getData()` - метод, возвращающий экземпляр класса BossData, который используется для получения базовой информации о боссе
- `LivingEntity getEntity()` - метод, возвращающий сущность босса
- `void kill()` - метод, убивающий босса
- `void isKilled()` - метод, который позволяет узнать, убит ли босс
- `Player getLastDamager()` - метод, возвращающий игрока, который на текущий момент был последним, кто нанёс урон боссу
- `Phase getCurrentPhase()` - метод, возвращающий текущую фазу босса
- `List<Phase> getPhases()` - метод, возвращающий все фазы босса
- `void changePhase(int)` - метод, меняющий фазу босса на фазу, которой соответствует переданный id
- `Map<String, Double> getDamageMap()` - метод, возвращающий таблицу урона босса, где ключ - ник игрока, а значение - нанесённый им урон
- `BossDeathType getDeathType()` - метод, возвращающий тип смерти босса (возвращает null, если босс ещё не убит)
  - `BossDeathType.PLAYER` - босс побеждён игроком
  - `BossDeathType.COMMAND` - босс убит командой
  - `BossDeathType.TIME` - время на убийство босса закончилось
  - `BossDeathType.OTHER` - другая причина (падение в бездну, удушье в блоках и тд)
- `BossSpawnType getSpawnType()` - метод, возвращающий тип спавна босса
  - `BossSpawnType.AUTO` - босс заспавнен автоматически
  - `BossSpawnType.COMMAND` - босс заспавнен командой
### BossData
**BossData** - это класс, который позволяет получать базовую информацию о боссе - информацию, указанную в конфиге. Его конструктор принимает один параметр - самого босса или его уникальный идентификатор.

Он имеет следующие методы:
- `String getName()` - метод, возвращающий фактическое имя босса (название файла конфигурации этого босса без расширения)
- `String getBossName()` - метод, возвращающий имя босса, используемое в сообщениях и подставляемое на место *%boss_name%*
- `String getDisplayName()` - метод, возвращающий строку, отображаемую над головой босса
- `EntityType getEntityType()` - метод, возвращающий тип сущности босса
- `double getHealth()` - метод, возвращающий начальное количество здоровья босса
- `boolean isGlowing()` - метод, позволяющий определить, накладывается ли на босса эффект свечения
- `boolean isBaby()` - метод, позволяющий определить, является ли босс ребёнком
- `List<PhaseData> getPhaseDatas()` - метод, возвращающий базовую информацию обо всех фазах босса
- `ItemStack getMainHand()` - метод, возвращающий предмет в основной руке босса
- `ItemStack getOffHand()` - метод, возвращающий предмет во второй руке босса
- `ItemStack getHelmet()` - метод, возвращающий предмет в слоте головы босса
- `ItemStack getChestplate()` - метод, возвращающий предмет в слоте нагрудника босса
- `ItemStack getLeggings()` - метод, возвращающий предмет в слоте штанов босса
- `ItemStack getBoots()` - метод, возвращающий предмет в слоте ботинок босса
### Phase
**Phase** - это класс, который позволяет взаимодействовать и получать информацию о фазе. Его конструктор принимает два параметра - уникальный идентификатор босса (или его самого) и уникальный идентификатор фазы.

Данный класс содержит следующие методы:
- `boolean equals(Object)` - метод, сравнивающий две фазы (сравниваются по id босса и фазы)
- `int getId()` - метод, возвращающий уникальный id фазы
- `Boss getBoss()` - метод, возвращающий босса, которому принадлежит фаза
- `PhaseData getData()` - метод, возвращающий базовую информацию о фазе
- `double getLifetime()` - метод, возвращающий время активности фазы в секундах,
### PhaseData
**PhaseData** - это класс, который позволяет получать базовую информацию о фазе - информацию, указанную в конфиге. Его конструктор принимает один параметр - фазу или два параметра - уникальный идентификатор босса (или самого босса) и уникальный идентификатор фазы.

Он включает в себя данные методы:
- `String getName()` - метод, возвращающий фактическое имя фазы (название конфигурационной секции этой фазы)
- `String getPhaseName()` - метод, возвращающий название фазы, используемое в сообщениях и подставляемое на место *%phase_name%*
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
Это конфигурация босса, и она вся будет доступна в переменной `bossConfig`. Способность с именем *Example* - это наша способность, и нам нужно получить какие-то входные значения для неё. Вот тут нам на помощь приходит `abilityConfig`, в ней хранится секция конфига, которая принадлежит данной способности в данной фазе, то есть `phases.first.abilities.example` (значение `ability` должно быть всегда. Благодаря ему IncBosses определяет, какую способность надо запустить)

Теперь вернёмся к нашей ситуации. Нам нужно получить из конфига значение радиуса области, в которой игрокам будет наноситься урон, а также само количество урона.

В конфиг нашего босса, а конкретнее в секцию способности мы добавим два значения: `radius` и `damage`
```yaml
example:
  ability: Example
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
