package com.honor;

import com.bytedance.common.push.ThreadPlus;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.utils.Logger;
import com.hihonor.push.sdk.HonorMessageService;
import com.hihonor.push.sdk.HonorPushDataMsg;
import com.honor.runable.GetTokenAndUploadRunnable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class HonorMessageListenerService extends HonorMessageService {
    private final String TAG = "HonorMessageService";

    @Override // com.hihonor.push.sdk.HonorMessageService
    public void onNewToken(String str) {
        super.onNewToken(str);
        doUploadToken(str);
    }

    @Override // com.hihonor.push.sdk.HonorMessageService
    public void onMessageReceived(HonorPushDataMsg honorPushDataMsg) {
        super.onMessageReceived(honorPushDataMsg);
        if (honorPushDataMsg == null) {
            Logger.w("HonorMessageService", "HonorMessageService onMessageReceived Data is null");
            return;
        }
        Logger.d("HonorMessageService", "onMessageReceived msgId = " + honorPushDataMsg.getMsgId() + " , content = " + honorPushDataMsg.getData());
        String data = honorPushDataMsg.getData();
        try {
            JSONObject jSONObject = new JSONObject(data);
            JSONObject jSONObject2 = new JSONObject(jSONObject.optString("android_payload"));
            jSONObject2.put("voip_params", jSONObject.optString("voip_params"));
            jSONObject2.put("push_show_type", jSONObject.optInt("push_show_type"));
            PushSupporter.pushHandler().handlePassThroughMsg(jSONObject2, HonorPushAdapter.getHonorPush(), (String) null);
        } catch (JSONException e) {
            e.printStackTrace();
            PushSupporter.pushHandler().handlePassThroughMsg(data, HonorPushAdapter.getHonorPush(), (String) null);
        }
    }

    private void doUploadToken(String str) {
        ThreadPlus.submitRunnable(new GetTokenAndUploadRunnable(getApplicationContext(), str));
    }
}
