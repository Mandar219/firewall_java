package org.example.firewall;

public interface FirewallRule {
    /**
     * Applies rule to given packet
     * @param packet
     * @return true if packet is allowed else false
     */
    boolean apply(Packet packet);
}
