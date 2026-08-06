package com.ss.alive.monitor;

import android.content.Context;
import android.content.Intent;
import com.bytedance.push.utils.Logger;
import com.ss.android.pushmanager.MessageConstants;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class LocalPushHelper {
    private static final String TAG = "handlerSendMonitorResponse";

    public static void handlerSendMonitorResponse(Context context, JSONObject jSONObject) {
        JSONArray optJSONArray;
        JSONArray optJSONArray2;
        try {
            if (jSONObject.optInt("code", -1) != 0 || (optJSONArray = jSONObject.optJSONArray("actions")) == null) {
                return;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null && "show_messge".equals(optJSONObject.optString("action_type")) && (optJSONArray2 = optJSONObject.optJSONArray("messages")) != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        try {
                            String optString = optJSONArray2.optString(i2);
                            if (Logger.debug()) {
                                Logger.d(TAG, "push msg : " + optString);
                            }
                            JSONObject jSONObject2 = new JSONObject(optString);
                            jSONObject2.put("is_local_push", 1);
                            Intent intent = new Intent(MessageConstants.MESSAGE_ACTION);
                            intent.putExtra(MessageConstants.MESSAGE_KEY_DATA, jSONObject2.toString());
                            intent.setPackage(context.getPackageName());
                            context.startService(intent);
                        } catch (Throwable th) {
                            Logger.e(TAG, th.getMessage(), th);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Logger.d(TAG, e.getMessage(), e);
        }
    }
}
