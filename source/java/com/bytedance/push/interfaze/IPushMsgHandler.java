package com.bytedance.push.interfaze;

import android.content.Context;
import android.content.Intent;
import com.bytedance.push.PushBody;
import com.bytedance.push.PushNotificationMessage;
import com.bytedance.push.client.intelligence.ClientIntelligenceShowResult;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface IPushMsgHandler {
    ClientIntelligenceShowResult handleMessageShow(PushNotificationMessage pushNotificationMessage);

    void handlePassThroughMsg(String str, int i, String str2);

    void handlePassThroughMsg(JSONObject jSONObject, int i, String str);

    void handlePassThroughMsg(JSONObject jSONObject, int i, String str, boolean z);

    boolean onClickMsg(Context context, String str, int i, String str2);

    boolean showNotification(int i, PushBody pushBody, boolean z, boolean z2, boolean z3, String str, long j);

    void trackClickPush(Context context, long j, String str, String str2, boolean z, JSONObject jSONObject, boolean z2);

    void trackClickPush(Context context, Intent intent, String str, JSONObject jSONObject);

    void trackClickPush(Context context, PushBody pushBody, boolean z, JSONObject jSONObject);

    void trySupplyIntentData(Intent intent);
}
