package org.example.firewall;

public class RuleBlockPattern implements FirewallRule {
    private String blockedPattern;

    public RuleBlockPattern(String blockedPattern) {
        this.blockedPattern = blockedPattern;
    }

    @Override
    public boolean apply(Packet packet) {
        return !packet.getPayload().contains(blockedPattern);
    }
}
