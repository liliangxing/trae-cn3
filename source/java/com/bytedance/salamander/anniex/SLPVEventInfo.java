package com.bytedance.salamander.anniex;

import com.bytedance.rts.foundation.Date;
import com.bytedance.rts.foundation.Float64;
import kotlin.Metadata;

/* compiled from: AnniexMonitorEventTypingsInfoPvEvent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/salamander/anniex/SLPVEventInfo;", "Lcom/bytedance/salamander/anniex/IEventInfo;", "()V", "invoke_ts", "", "getInvoke_ts", "()J", "setInvoke_ts", "(J)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public class SLPVEventInfo implements IEventInfo {
    private long invoke_ts = Float64.INSTANCE.toInt64(Date.INSTANCE.now_v2());

    public long getInvoke_ts() {
        return this.invoke_ts;
    }

    public void setInvoke_ts(long j) {
        this.invoke_ts = j;
    }
}
