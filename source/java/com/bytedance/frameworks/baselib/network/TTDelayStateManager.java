package com.bytedance.frameworks.baselib.network;

import com.bytedance.common.utility.Logger;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class TTDelayStateManager {
    private static final String TAG = "TTDelayStateManager";
    private static volatile AppStartState sAppStartState = AppStartState.NormalStart;
    private static final AtomicBoolean sRequestTagDelayEnabled = new AtomicBoolean(false);
    private static final AtomicLong sAppStateChangeTimeSec = new AtomicLong(0);
    private static final AtomicLong sColdStartDurationSec = new AtomicLong(0);
    private static final AtomicLong sHotStartDurationSec = new AtomicLong(0);
    private static final AtomicLong sWarmStartDurationSec = new AtomicLong(0);

    /* loaded from: classes2.dex */
    public enum AppStartState {
        NormalStart(-1),
        ColdStart(0),
        HotStart(1),
        WarmStart(2);

        final int state;

        AppStartState(int i) {
            this.state = i;
        }

        public int getValue() {
            return this.state;
        }
    }

    public static AppStartState getCurrentStartUpState() {
        if (Logger.debug()) {
            Logger.d(TAG, "get coldDuration hostDuration warmDuration " + sColdStartDurationSec.get() + sHotStartDurationSec.get() + sWarmStartDurationSec.get());
        }
        int i = AnonymousClass1.$SwitchMap$com$bytedance$frameworks$baselib$network$TTDelayStateManager$AppStartState[sAppStartState.ordinal()];
        if (i == 1) {
            if (isCurrentAppStateExpired(sAppStateChangeTimeSec.get(), sColdStartDurationSec.get())) {
                sAppStartState = AppStartState.NormalStart;
            }
            return sAppStartState;
        }
        if (i == 2) {
            if (isCurrentAppStateExpired(sAppStateChangeTimeSec.get(), sHotStartDurationSec.get())) {
                sAppStartState = AppStartState.NormalStart;
            }
            return sAppStartState;
        }
        if (i == 3) {
            if (isCurrentAppStateExpired(sAppStateChangeTimeSec.get(), sWarmStartDurationSec.get())) {
                sAppStartState = AppStartState.NormalStart;
            }
            return sAppStartState;
        }
        return sAppStartState;
    }

    /* renamed from: com.bytedance.frameworks.baselib.network.TTDelayStateManager$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$frameworks$baselib$network$TTDelayStateManager$AppStartState;

        static {
            int[] iArr = new int[AppStartState.values().length];
            $SwitchMap$com$bytedance$frameworks$baselib$network$TTDelayStateManager$AppStartState = iArr;
            try {
                iArr[AppStartState.ColdStart.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$bytedance$frameworks$baselib$network$TTDelayStateManager$AppStartState[AppStartState.HotStart.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$bytedance$frameworks$baselib$network$TTDelayStateManager$AppStartState[AppStartState.WarmStart.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static AppStartState getAppStartUpState() {
        return sAppStartState;
    }

    public static boolean getRequestTagDelayEnabled() {
        return sRequestTagDelayEnabled.get();
    }

    private static boolean isCurrentAppStateExpired(long j, long j2) {
        return (System.currentTimeMillis() / 1000) - j > j2;
    }

    public static void onServerConfigChanged(JSONObject jSONObject) {
        sRequestTagDelayEnabled.set(jSONObject.optInt("request_tag_enabled") > 0);
        AtomicLong atomicLong = sColdStartDurationSec;
        atomicLong.set(jSONObject.optInt("cold_start_seconds"));
        AtomicLong atomicLong2 = sHotStartDurationSec;
        atomicLong2.set(jSONObject.optInt("hot_start_seconds"));
        AtomicLong atomicLong3 = sWarmStartDurationSec;
        atomicLong3.set(jSONObject.optInt("warm_start_seconds"));
        if (Logger.debug()) {
            Logger.d(TAG, "set coldDuration hostDuration warmDuration " + atomicLong.get() + atomicLong2.get() + atomicLong3.get());
        }
    }

    public static void setAppStartUpState(int i) {
        sAppStateChangeTimeSec.set(System.currentTimeMillis() / 1000);
        if (i == 0) {
            sAppStartState = AppStartState.ColdStart;
            return;
        }
        if (i == 1) {
            sAppStartState = AppStartState.HotStart;
        } else if (i == 2) {
            sAppStartState = AppStartState.WarmStart;
        } else {
            sAppStartState = AppStartState.NormalStart;
        }
    }
}
