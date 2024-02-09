package network;

import org.junit.jupiter.api.Test;

import java.io.IOException;

class ServiceTest {

    static final private int port = 12345;

    @Test
    void sendData() throws IOException {
        Service test = new Service(0);
        byte[] dataSend = {1, 2, 3};
        test.sendData(dataSend, port);
    }

    @Test
    void receiveData() throws IOException {
        Service test = new Service(port);
        test.receiveData();
    }
}