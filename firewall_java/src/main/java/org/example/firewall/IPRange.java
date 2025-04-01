package org.example.firewall;

public class IPRange {
    private long start;
    private long end;

    public IPRange(long start, long end) {
        this.start = start;
        this.end = end;
    }

    public long getStart() {
        return start;
    }

    public long getEnd() {
        return end;
    }

    public boolean contains(long ip) {
        return start <= ip && ip <= end;
    }

    public int compareTo(IPRange ipRange) {
        return Long.compare(start, ipRange.start);
    }
}
