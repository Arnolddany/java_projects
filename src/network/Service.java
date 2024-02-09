package network;

import java.io.IOException;
import java.net.*;
import java.util.Arrays;

public class Service {
    private DatagramSocket socket;
    private InetAddress address;
    private byte[] dataSend = new byte[1234];
    private byte[] dataReceive = new byte[65535];

    int port;

    public Service(int port) throws SocketException, UnknownHostException {
        this.socket = new DatagramSocket(port);
        this.port = port;
        this.address = InetAddress.getLocalHost();
    }

    public void sendData(byte[] dataSend) throws IOException {
        DatagramPacket packet = new DatagramPacket(dataSend, dataSend.length, InetAddress.getLocalHost(), this.port);
        socket.send(packet);
        System.out.println("Отправлено!");
    }

    public void sendData(byte[] dataSend, int port) throws IOException {
        DatagramPacket packet = new DatagramPacket(dataSend, dataSend.length, InetAddress.getLocalHost(), port);
        socket.send(packet);
        System.out.println("Отправлено!");
    }

    public void receiveData() throws IOException {
        DatagramPacket packet = new DatagramPacket(dataReceive, dataReceive.length);
        socket.receive(packet);
        System.out.printf("Получено %d байт: %s\n", packet.getLength(), Arrays.toString(Arrays.copyOf(packet.getData(), packet.getLength())));
    }
}
