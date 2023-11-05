package ru.incrementstudio.incbosses.api.internection;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class OneTimeHandler {
    public OneTimeHandler(InputStream stream) throws IOException {
        DataInputStream in = new DataInputStream(stream);
        int length = in.readInt();
        if (length > 0) {
            byte[] data = new byte[length];
            in.read(data, 0, length);
            dataHandler(data);
        }
    }

    public void dataHandler(byte[] data) { }
}
