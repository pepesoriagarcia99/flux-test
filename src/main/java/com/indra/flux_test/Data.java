package com.indra.flux_test;

import java.time.Instant;

public class Data {
    private final long seqNo;
    private final Instant timestamp;

    public Data(long seqNo, Instant timestamp) {
        this.seqNo = seqNo;
        this.timestamp = timestamp;
    }
}
