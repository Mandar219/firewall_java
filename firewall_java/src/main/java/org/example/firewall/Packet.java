package org.example.firewall;

public class Packet {
    private String sourceIp;
    private String destinationIp;
    private String protocol;
    private String payload;

    public Packet(String sourceIp, String destinationIp, String protocol, String payload) {
        this.sourceIp = sourceIp;
        this.destinationIp = destinationIp;
        this.protocol = protocol;
        this.payload = payload;
    }

    public String getSourceIp() {
        return sourceIp;
    }

    public String getDestinationIp() {
        return destinationIp;
    }

    public String getProtocol() {
        return protocol;
    }

    public String getPayload() {
        return payload;
    }

    @Override
    public String toString() {
        return "Packet{" +
                "sourceIp='" + sourceIp + '\'' +
                ", destinationIp='" + destinationIp + '\'' +
                ", protocol='" + protocol + '\'' +
                ", payload='" + payload + '\'' +
                '}';
    }
}
