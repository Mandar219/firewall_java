package org.example.firewall;

public class RuleBlockProtocol implements FirewallRule {
    private String blockedProtocol;

    public RuleBlockProtocol(String blockedProtocol) {
        this.blockedProtocol = blockedProtocol;
    }

    @Override
    public boolean apply(Packet packet) {
        // Block the packet if its protocol matches the blocked protocol.
        return !packet.getProtocol().equalsIgnoreCase(blockedProtocol);
    }
}
