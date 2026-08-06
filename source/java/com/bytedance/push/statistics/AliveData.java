package com.bytedance.push.statistics;

import java.util.concurrent.TimeUnit;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class AliveData {
    public long delay;
    public long endElapsedRealTime;
    public long endTs;
    public boolean isBackground;
    public boolean isForeground;
    public boolean isScreenOn;
    public boolean isUsbCharging;
    public String session;
    public long startElapsedRealTime;
    public long startTs;

    public long getAliveTime() {
        return this.endElapsedRealTime - this.startElapsedRealTime;
    }

    public boolean isBlock() {
        return (this.endTs - this.startTs) - this.delay > TimeUnit.SECONDS.toMillis(5L);
    }

    public String toString() {
        return "AliveData{startElapsedRealTime=" + this.startElapsedRealTime + ", startTs=" + this.startTs + ", endTs=" + this.endTs + ", endElapsedRealTime=" + this.endElapsedRealTime + ", isBackground=" + this.isBackground + ", session='" + this.session + "', delay=" + this.delay + ", isForeground=" + this.isForeground + ", isScreenOn=" + this.isScreenOn + ", isUsbCharging=" + this.isUsbCharging + AbstractJsonLexerKt.END_OBJ;
    }
}
