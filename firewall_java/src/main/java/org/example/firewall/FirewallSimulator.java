package org.example.firewall;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FirewallSimulator {
    public static void main(String[] args) {
        Firewall firewall = new Firewall();
        PacketGenerator packetGenerator = new PacketGenerator();
        ExecutorService executorService = Executors.newFixedThreadPool(8);
        final int totalPackets = 10000;

        for(int i = 0; i < totalPackets; i++) {
            executorService.execute(() -> {
                Packet packet = packetGenerator.generatePacket();
                if(!firewall.filter(packet)) {
                    System.out.println("Packet " + packet + " not accepted");
                } else {
                    System.out.println("Packet " + packet + " accepted");
                }
            });
        }

        executorService.shutdown();
        try {
            if(!executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("Timed out waiting for packet process to finish");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
