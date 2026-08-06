package com.ss.android.common.lib;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.common.applog.AppLog;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class MobClickCombiner {
    private static IAgent sAgent;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface IAgent {
        void init(Context context);

        void onEvent(Context context, String str);

        void onEvent(Context context, String str, String str2);

        void onPause(Context context);

        void onResume(Context context);

        void setAgentChannel(String str);

        void setCustomVersion(String str);

        void setCustomVersionCode(int i);
    }

    public static void setAgent(IAgent iAgent) {
        sAgent = iAgent;
    }

    public static synchronized void init(Context context) {
        synchronized (MobClickCombiner.class) {
            IAgent iAgent = sAgent;
            if (iAgent != null) {
                iAgent.init(context);
            }
        }
    }

    public static void onEventWithoutAgent(Context context, String str) {
        if (TextUtils.isEmpty(str) || context == null) {
            return;
        }
        AppLog.onEvent(context, str);
    }

    public static void onEvent(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (context != null) {
            AppLog.onEvent(context, str);
        }
        IAgent iAgent = sAgent;
        if (iAgent != null) {
            iAgent.onEvent(context, str);
        }
    }

    public static void onEventCount(Context context, String str, String str2, int i) {
        if (TextUtils.isEmpty(str) || context == null) {
            return;
        }
        AppLog.onEvent(context, "event_v1", str, str2, i, 0L);
    }

    public static void onEventWithoutAgent(Context context, String str, String str2, long j, long j2) {
        onEventWithoutAgent(context, "event_v1", str, str2, j, j2, null);
    }

    public static void onEvent(Context context, String str, String str2, long j, long j2) {
        onEvent(context, "event_v1", str, str2, j, j2, null);
    }

    public static void onEventWithoutAgent(Context context, String str, String str2, String str3, long j, long j2) {
        onEventWithoutAgent(context, str, str2, str3, j, j2, null);
    }

    public static void onEvent(Context context, String str, String str2, String str3, long j, long j2) {
        onEvent(context, str, str2, str3, j, j2, null);
    }

    public static void onEventWithoutAgent(Context context, String str, String str2, long j, long j2, JSONObject jSONObject) {
        onEventWithoutAgent(context, "event_v1", str, str2, j, j2, jSONObject);
    }

    public static void onEvent(Context context, String str, String str2, long j, long j2, JSONObject jSONObject) {
        onEvent(context, "event_v1", str, str2, j, j2, jSONObject);
    }

    public static void onEventWithoutAgent(Context context, String str, String str2, String str3, long j, long j2, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        String str4 = TextUtils.isEmpty(str) ? "event_v1" : str;
        if (context != null) {
            AppLog.onEvent(context, str4, str2, str3, j, j2, jSONObject);
        }
    }

    public static void onEvent(Context context, String str, String str2, String str3, long j, long j2, JSONObject jSONObject) {
        IAgent iAgent;
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        String str4 = TextUtils.isEmpty(str) ? "event_v1" : str;
        if (context != null) {
            AppLog.onEvent(context, str4, str2, str3, j, j2, jSONObject);
            if ("event_v1".equals(str4) && (iAgent = sAgent) != null && "event_v1".equals(str4)) {
                if (TextUtils.isEmpty(str3)) {
                    iAgent.onEvent(context, str2);
                } else {
                    iAgent.onEvent(context, str2, str3);
                }
            }
        }
    }

    public static void onEventWithoutAgent(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str) || context == null) {
            return;
        }
        AppLog.onEvent(context, str, str2);
    }

    public static void onEvent(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str) || context == null) {
            return;
        }
        AppLog.onEvent(context, str, str2);
        IAgent iAgent = sAgent;
        if (iAgent != null) {
            if (TextUtils.isEmpty(str2)) {
                iAgent.onEvent(context, str);
            } else {
                iAgent.onEvent(context, str, str2);
            }
        }
    }

    public static void onResumeWithoutAgent(Context context) {
        AppLog.onResume(context);
    }

    public static void onResume(Context context) {
        AppLog.onResume(context);
        IAgent iAgent = sAgent;
        if (iAgent != null) {
            iAgent.onResume(context);
        }
    }

    public static void onPauseWithoutAgent(Context context) {
        AppLog.onPause(context);
    }

    public static void onPause(Context context) {
        AppLog.onPause(context);
        IAgent iAgent = sAgent;
        if (iAgent != null) {
            iAgent.onPause(context);
        }
    }

    public static void setVersionInfo(String str, int i) {
        IAgent iAgent = sAgent;
        if (iAgent != null) {
            iAgent.setCustomVersion(str);
            iAgent.setCustomVersionCode(i);
        }
    }

    public static void setCustomVersion(String str) {
        IAgent iAgent = sAgent;
        if (iAgent != null) {
            iAgent.setCustomVersion(str);
        }
    }

    public static void setAgentChannel(String str) {
        IAgent iAgent = sAgent;
        if (iAgent != null) {
            iAgent.setAgentChannel(str);
        }
    }
}
