package com.bytedance.android.monitorV2.util;

import com.bytedance.android.monitorV2.constant.MonitorGlobalSp;
import com.bytedance.android.sdk.bdticketguard.TicketGuardApiKt;
import com.bytedance.apm.ApmContext;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

/* compiled from: ContextUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/monitorV2/util/ContextUtils;", "", "()V", "appRunTimeStep", "", "isReinstall", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ContextUtils {
    public static final ContextUtils INSTANCE = new ContextUtils();

    private ContextUtils() {
    }

    public final boolean isReinstall() {
        boolean z = MonitorGlobalSp.getBoolean(MonitorGlobalSp.MONITOR_IS_REINSTALL, false);
        if (!z) {
            MonitorGlobalSp.putBoolean(MonitorGlobalSp.MONITOR_IS_REINSTALL, true);
        }
        return !z;
    }

    public final String appRunTimeStep() {
        long seconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - ApmContext.getInitTimeStamp());
        if (0 <= seconds && seconds < 3) {
            return "0";
        }
        if (3 <= seconds && seconds < 5) {
            return "1";
        }
        if (5 <= seconds && seconds < 10) {
            return TicketGuardApiKt.TICKET_GUARD_ITERATION_VERSION;
        }
        if (10 <= seconds && seconds < 30) {
            return TicketGuardApiKt.TICKET_GUARD_VERSION;
        }
        return 30 <= seconds && seconds < 60 ? "4" : "5";
    }
}
