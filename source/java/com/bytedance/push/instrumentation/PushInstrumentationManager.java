package com.bytedance.push.instrumentation;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class PushInstrumentationManager {
    private static volatile PushInstrumentationManager pushInstrumentationManager;
    private Map<String, InstrumentationListener> mInstrumentationListenerMap = new HashMap();

    public static PushInstrumentationManager getInstance() {
        if (pushInstrumentationManager == null) {
            synchronized (PushInstrumentationManager.class) {
                if (pushInstrumentationManager == null) {
                    pushInstrumentationManager = new PushInstrumentationManager();
                }
            }
        }
        return pushInstrumentationManager;
    }

    private PushInstrumentationManager() {
    }

    public void registerInstrumentationListener(String str, InstrumentationListener instrumentationListener) {
        if (TextUtils.isEmpty(str) || instrumentationListener == null) {
            return;
        }
        this.mInstrumentationListenerMap.put(str, instrumentationListener);
    }

    public InstrumentationListener getInstrumentationListener(String str) {
        return this.mInstrumentationListenerMap.get(str);
    }
}
