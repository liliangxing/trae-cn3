package com.bytedance.apm.entity;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes3.dex */
public class TrafficLogEntity {
    private int front;
    private int netType;
    private int send;
    private long sid;
    private long time;
    private long value;

    public TrafficLogEntity(long j, int i, int i2, int i3, long j2) {
        this.value = j;
        this.netType = i2;
        this.send = i3;
        this.front = i;
        this.time = j2;
    }

    public TrafficLogEntity(long j, int i, int i2, int i3, long j2, long j3) {
        this.value = j;
        this.netType = i2;
        this.send = i3;
        this.front = i;
        this.time = j2;
        this.sid = j3;
    }

    public long getValue() {
        return this.value;
    }

    public int getNetType() {
        return this.netType;
    }

    public int getSend() {
        return this.send;
    }

    public int getFront() {
        return this.front;
    }

    public long getTime() {
        return this.time;
    }

    public long getSid() {
        return this.sid;
    }

    public String toString() {
        return "TrafficLogEntity{value=" + this.value + ", netType=" + this.netType + ", send=" + this.send + ", front=" + this.front + ", time=" + this.time + ", sid=" + this.sid + AbstractJsonLexerKt.END_OBJ;
    }
}
