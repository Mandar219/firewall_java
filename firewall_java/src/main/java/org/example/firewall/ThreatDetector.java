package org.example.firewall;

public class ThreatDetector {
    public static boolean isMalicious(Packet packet) {
        return "MALICIOUS".equalsIgnoreCase(packet.getPayload());
    }
}
