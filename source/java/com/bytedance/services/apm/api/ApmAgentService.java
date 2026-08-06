package com.bytedance.services.apm.api;

import com.bytedance.news.common.service.manager.ServiceCreator;
import com.bytedance.news.common.service.manager.ServiceManager;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class ApmAgentService {
    protected static IApmAgent sInstance;
    protected static volatile boolean sIsStrictMode;

    protected ApmAgentService() {
    }

    public static void injectService() {
        try {
            final IApmAgent iApmAgent = (IApmAgent) Class.forName("com.bytedance.apm.impl.ApmAgentServiceImpl").newInstance();
            ServiceManager.registerService(IApmAgent.class, (ServiceCreator) new ServiceCreator<IApmAgent>() { // from class: com.bytedance.services.apm.api.ApmAgentService.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.bytedance.news.common.service.manager.ServiceCreator
                public IApmAgent create() {
                    return IApmAgent.this;
                }
            });
        } catch (Throwable unused) {
        }
    }

    public static void setApmAgentService(IApmAgent iApmAgent) {
        sInstance = iApmAgent;
    }

    public static void monitorEventSafely(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        IApmAgent iApmAgent = sInstance;
        if (iApmAgent == null) {
            if (sIsStrictMode) {
                throw new RuntimeException("implement IApmAgent and set sInstance first");
            }
        } else {
            iApmAgent.monitorEvent(str, jSONObject, jSONObject2, jSONObject3);
        }
    }

    public static void monitorLogSafely(String str, JSONObject jSONObject) {
        IApmAgent iApmAgent = sInstance;
        if (iApmAgent == null) {
            if (sIsStrictMode) {
                throw new RuntimeException("implement IApmAgent and set sInstance first");
            }
        } else {
            iApmAgent.monitorLog(str, jSONObject);
        }
    }

    @Deprecated
    public static void monitorStatusRateSafely(String str, int i, JSONObject jSONObject) {
        IApmAgent iApmAgent = sInstance;
        if (iApmAgent == null) {
            if (sIsStrictMode) {
                throw new RuntimeException("implement IApmAgent and set sInstance first");
            }
        } else {
            iApmAgent.monitorStatusRate(str, i, jSONObject);
        }
    }

    @Deprecated
    public static void monitorDurationSafely(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        IApmAgent iApmAgent = sInstance;
        if (iApmAgent == null) {
            if (sIsStrictMode) {
                throw new RuntimeException("implement IApmAgent and set sInstance first");
            }
        } else {
            iApmAgent.monitorDuration(str, jSONObject, jSONObject2);
        }
    }

    @Deprecated
    public static void monitorStatusAndDurationSafely(String str, int i, JSONObject jSONObject, JSONObject jSONObject2) {
        IApmAgent iApmAgent = sInstance;
        if (iApmAgent == null) {
            if (sIsStrictMode) {
                throw new RuntimeException("implement IApmAgent and set sInstance first");
            }
        } else {
            iApmAgent.monitorStatusAndDuration(str, i, jSONObject, jSONObject2);
        }
    }

    public static boolean isImplInjected() {
        return sInstance != null;
    }

    public static boolean isIsStrictMode() {
        return sIsStrictMode;
    }

    public static void setIsStrictMode(boolean z) {
        sIsStrictMode = z;
    }
}
