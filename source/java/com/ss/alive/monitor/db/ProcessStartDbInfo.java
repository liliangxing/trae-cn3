package com.ss.alive.monitor.db;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes7.dex */
public class ProcessStartDbInfo {
    public String dataJson;
    public long endTime;
    public long id;

    public String toString() {
        return "ProcessStartDbInfo{id=" + this.id + ", dataJson='" + this.dataJson + "', endTime=" + this.endTime + AbstractJsonLexerKt.END_OBJ;
    }
}
