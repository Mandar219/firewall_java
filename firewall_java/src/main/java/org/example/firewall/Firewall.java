package org.example.firewall;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Firewall {
    private final List<IPRange> blockedIPAddressesList = new ArrayList<>();
    private final List<FirewallRule> rules = new ArrayList<>();

    public Firewall() {
        long startIP = ipToLong("192.168.1.0");
        long endIP = ipToLong("192.168.1.255");

        blockedIPAddressesList.add(new IPRange(startIP, endIP));
        Collections.sort(blockedIPAddressesList);

        rules.add(new RuleBlockProtocol("UDP"));
        rules.add(new RuleBlockPattern("FORBIDDEN"));
        rules.add(new RuleAllowAll());
    }

    private long ipToLong(String ip) {
        String[] parts = ip.split("\\.");
        long result = 0;
        for (String part : parts) {
            result = result << 8;
            result |= Integer.parseInt(part) & 0xFF;
        }
        return result;
    }

    public boolean filter(Packet packet) {
        long sourceIP = ipToLong(packet.getSourceIp());
        long destinationIP = ipToLong(packet.getDestinationIp());

        if(isBlacklisted(sourceIP) || isBlacklisted(destinationIP)) {
            return false;
        }

        for(FirewallRule rule : rules) {
            if(!rule.apply(packet)) {
                return false;
            }
        }

        return !ThreatDetector.isMalicious(packet);
    }

    private boolean isBlacklisted(long ip) {
        int idx = Collections.binarySearch(blockedIPAddressesList, new IPRange(ip, ip));

        if(idx >= 0) {
            return true;
        } else {
            int insertPos = -idx - 1;
            if(insertPos > 0 && blockedIPAddressesList.get(insertPos - 1).contains(ip)) {
                return true;
            }
            if(insertPos < blockedIPAddressesList.size() && blockedIPAddressesList.get(insertPos).contains(ip)) {
                return true;
            }
            return false;
        }
    }
}
