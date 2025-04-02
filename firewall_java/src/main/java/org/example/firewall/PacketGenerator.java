package org.example.firewall;

import java.util.Random;

public class PacketGenerator {
    private final Random random = new Random();

    public Packet generatePacket() {
        String sourceIp = generateRandomIp();
        String destinationIp = generateRandomIp();
        String protocol = random.nextBoolean() ? "TCP" : "UDP";
        String payload = random.nextInt(10) < 2 ? "MALICIOUS" : "NORMAL";

        return new Packet(sourceIp, destinationIp, protocol, payload);
    }

    private String generateRandomIp() {
        return random.nextInt(256) + "." + random.nextInt(256) + "." + random.nextInt(256) + "." + random.nextInt(256);
    }
}
