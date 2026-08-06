package com.bytedance.praisedialoglib.utils;

import android.util.Log;
import com.bytedance.praisedialoglib.manager.PraiseDialogCfgManager;
import com.vivo.push.PushClientConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class EventReportUtil {
    public static final String EVENT_NAME_JUMP_MARKET = "evaluate_jump_market";
    public static final String EVENT_NAME_POP_BAD = "evaluate_pop_bad";
    public static final String EVENT_NAME_POP_CLOSE = "evaluate_pop_close";
    public static final String EVENT_NAME_POP_FORCE_CLOSE = "evaluate_pop_force_close";
    public static final String EVENT_NAME_POP_GOOD = "evaluate_pop_good";
    public static final String EVENT_NAME_POP_SHOW = "evaluate_pop_show";
    private static final String TAG = "EventReportUtil";

    public static void onEvent(String str, String str2) {
        Log.d(TAG, "onEvent() called with: event = [" + str + "], from = [" + str2 + "]");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("trigger", str2);
            PraiseDialogCfgManager.getInstance().onEvent(str, jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void onMarketEvent(String str) {
        Log.d(TAG, "onMarketEvent() called with: pkgName = [" + str + "]");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(PushClientConstants.TAG_PKG_NAME, str);
            PraiseDialogCfgManager.getInstance().onEvent(EVENT_NAME_JUMP_MARKET, jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
