package com.bytedance.common.wschannel.heartbeat.monitor;

import com.bytedance.common.wschannel.heartbeat.smart.state.StateType;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes3.dex */
public class HeartBeatHprof {
    private long currentPingInterval;
    private StateType currentStateType;

    public HeartBeatHprof(StateType stateType, long j) {
        this.currentStateType = stateType;
        this.currentPingInterval = j;
    }

    public StateType getCurrentStateType() {
        return this.currentStateType;
    }

    public long getCurrentPingInterval() {
        return this.currentPingInterval;
    }

    public String toString() {
        return "HeartBeatHprof{currentStateType=" + this.currentStateType + ", currentPingInterval=" + this.currentPingInterval + AbstractJsonLexerKt.END_OBJ;
    }
}
