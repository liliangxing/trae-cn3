package com.huawei;

import android.text.TextUtils;
import com.bytedance.common.push.ThreadPlus;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.utils.Logger;
import com.huawei.hms.push.HmsMessageService;
import com.huawei.hms.push.RemoteMessage;
import com.p032hw.HWPushAdapter;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class MessageService extends HmsMessageService {
    private final String TAG = "HW-MessageService";

    @Override // com.huawei.hms.push.HmsMessageService
    public void onNewToken(String str) {
        super.onNewToken(str);
        ThreadPlus.submitRunnable(new GetTokenAndUploadRunnable(getApplicationContext(), str));
    }

    @Override // com.huawei.hms.push.HmsMessageService
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Logger.i("HW-MessageService", "onMessageReceived is called");
        if (remoteMessage == null) {
            Logger.e("HW-MessageService", "Received message entity is null!");
            return;
        }
        String data = remoteMessage.getData();
        if (TextUtils.isEmpty(data)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(data);
            JSONObject jSONObject2 = new JSONObject(jSONObject.optString("android_payload"));
            jSONObject2.put("voip_params", jSONObject.optString("voip_params"));
            jSONObject2.put("push_show_type", jSONObject.optInt("push_show_type"));
            PushSupporter.pushHandler().handlePassThroughMsg(jSONObject2, HWPushAdapter.getHwPush(), (String) null);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
