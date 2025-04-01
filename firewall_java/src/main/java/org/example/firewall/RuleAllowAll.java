package org.example.firewall;

public class RuleAllowAll implements FirewallRule {
    @Override
    public boolean apply(Packet packet) {
        return true;
    }
}
