package com.bytedance.frameworks.baselib.network.http.cronet;

import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.TTDelayStateManager;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.SsCronetHttpClient;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class TTAppStateManager {
    private static final String TAG = "TTAppStateManager";
    private static volatile AppStartState sAppStartState = AppStartState.NormalStart;
    private static volatile AppStartState sAppDelayState = AppStartState.Default;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public enum AppStartState {
        NormalStart(-1),
        ColdStart(0),
        HotStart(1),
        WarmStart(2),
        WeakNet(3),
        Default(4);

        final int state;

        AppStartState(int i) {
            this.state = i;
        }

        public int getValue() {
            return this.state;
        }
    }

    public static int getAppStartUpState() {
        return sAppStartState.state;
    }

    public static AppStartState getAppDelayState() {
        return sAppDelayState;
    }

    public static void setAppStartUpState(AppStartState appStartState) {
        try {
            sAppStartState = appStartState;
            TTDelayStateManager.setAppStartUpState(appStartState.getValue());
            ICronetClient cronetClient = SsCronetHttpClient.getCronetClient();
            if (cronetClient != null) {
                int i = appStartState.state;
                if (Logger.debug()) {
                    Logger.d(TAG, "Set app start-up state: " + i);
                }
                if (i < 0 || i > 2) {
                    return;
                }
                cronetClient.setAppStartUpState(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setAppDelayState(AppStartState appStartState) {
        sAppDelayState = appStartState;
    }
}
