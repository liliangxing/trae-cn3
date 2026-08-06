package com.bytedance.apm;

import com.bytedance.crash.entity.ScheduleMsgItem;
import java.util.List;

/* loaded from: classes3.dex */
public class LooperMonitorApi {
    private static LooperMonitorImpl sImpl;

    /* loaded from: classes3.dex */
    public interface LooperMonitorImpl {
        List<ScheduleMsgItem> dumpMainLooperHistoryMsg();

        ScheduleMsgItem getDispatchingMsg();
    }

    public static LooperMonitorImpl getLooperMonitorImpl() {
        return sImpl;
    }

    static void setLooperMonitorImpl(LooperMonitorImpl looperMonitorImpl) {
        sImpl = looperMonitorImpl;
    }
}
