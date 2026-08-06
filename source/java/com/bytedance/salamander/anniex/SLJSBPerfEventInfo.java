package com.bytedance.salamander.anniex;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnniexMonitorEventTypingsInfoJsbPerfEvent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/salamander/anniex/SLJSBPerfEventInfo;", "Lcom/bytedance/salamander/anniex/IEventInfo;", "()V", "info", "Lcom/bytedance/salamander/anniex/SLInfoCategory;", "getInfo", "()Lcom/bytedance/salamander/anniex/SLInfoCategory;", "setInfo", "(Lcom/bytedance/salamander/anniex/SLInfoCategory;)V", "perf", "Lcom/bytedance/salamander/anniex/SLInfoPerf;", "getPerf", "()Lcom/bytedance/salamander/anniex/SLInfoPerf;", "setPerf", "(Lcom/bytedance/salamander/anniex/SLInfoPerf;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public class SLJSBPerfEventInfo implements IEventInfo {
    private SLInfoCategory info = new SLInfoCategory();
    private SLInfoPerf perf = new SLInfoPerf();

    public SLInfoCategory getInfo() {
        return this.info;
    }

    public void setInfo(SLInfoCategory sLInfoCategory) {
        Intrinsics.checkNotNullParameter(sLInfoCategory, "<set-?>");
        this.info = sLInfoCategory;
    }

    public SLInfoPerf getPerf() {
        return this.perf;
    }

    public void setPerf(SLInfoPerf sLInfoPerf) {
        Intrinsics.checkNotNullParameter(sLInfoPerf, "<set-?>");
        this.perf = sLInfoPerf;
    }
}
