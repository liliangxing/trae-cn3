package com.bytedance.push.msg.callback;

import android.text.TextUtils;
import com.bytedance.common.push.BaseJson;
import com.bytedance.common.push.ThreadPlus;
import com.bytedance.common.support.impl.PushNetworkClient;
import com.bytedance.common.utility.NetworkClient;
import com.bytedance.ies.xbridge.base.runtime.utils.XBridgeAPIRequestUtils;
import com.bytedance.push.PushBody;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.event.sync.ISignalReportConstants;
import com.bytedance.push.interfaze.IMessageCallbackService;
import com.bytedance.push.settings.msg.callback.MsgCallbackSettingsModel;
import com.bytedance.push.utils.Logger;
import com.bytedance.trae.push.api.PushConst;
import com.ss.android.message.util.ToolUtils;
import com.ss.android.pushmanager.MessageConstants;
import com.ss.android.pushmanager.setting.PushSetting;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class MessageCallbackServiceImpl extends BaseJson implements IMessageCallbackService {
    private final String TAG = "MessageCallbackServiceImpl";
    private ClickHelper mClickHelper = new ClickHelper();

    private MsgCallbackSettingsModel getMsgCallbackSettingsModel() {
        return PushSetting.getInstance().getPushOnLineSettings().getMsgCallbackSettings();
    }

    @Override // com.bytedance.push.interfaze.IMessageCallbackService
    public void onMessageArrive(PushBody pushBody, JSONObject jSONObject) {
        if (pushBody == null) {
            Logger.m278w("MessageCallbackServiceImpl", "not callback message arrive because body is null");
            return;
        }
        if (pushBody.callbackArrive) {
            Logger.m268d("MessageCallbackServiceImpl", "callback message arrive because body.callbackArrive is true,msgId is " + pushBody.f84id);
            callbackArrive(jSONObject);
        } else if (getMsgCallbackSettingsModel().callbackMsgArrive) {
            Logger.m268d("MessageCallbackServiceImpl", "callback message arrive because MsgCallbackSettings.callbackMsgArrive is true,msgId is " + pushBody.f84id);
            callbackArrive(jSONObject);
        } else {
            Logger.m268d("MessageCallbackServiceImpl", "not callback message arrive");
        }
    }

    @Override // com.bytedance.push.interfaze.IMessageCallbackService
    public void onMessageClick(boolean z, JSONObject jSONObject) {
        if (jSONObject == null) {
            Logger.m278w("MessageCallbackServiceImpl", "not callback message click because param is null");
            return;
        }
        if (z) {
            Logger.m268d("MessageCallbackServiceImpl", "callback message click because body.callbackClick is true,param is " + jSONObject);
            callbackClick(jSONObject);
        } else if (getMsgCallbackSettingsModel().callbackMsgClick) {
            Logger.m268d("MessageCallbackServiceImpl", "callback message click because MsgCallbackSettings.callbackMsgClick is true, param is " + jSONObject);
            callbackClick(jSONObject);
        } else {
            Logger.m268d("MessageCallbackServiceImpl", "not callback message click");
        }
    }

    private String convertMsTimeToSTime(String str) {
        try {
            return String.valueOf(Long.parseLong(str) / 1000);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private void callbackArrive(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        add(jSONObject2, "client_time", convertMsTimeToSTime(jSONObject.optString("client_time")));
        add(jSONObject2, "rid", jSONObject.optString(PushConst.KEY_RULE_ID));
        add(jSONObject2, "rid64", jSONObject.optString("rule_id64"));
        add(jSONObject2, PushConst.KEY_GROUP_ID, jSONObject.optString("ttpush_group_id"));
        add(jSONObject2, "sender", jSONObject.optString("sender"));
        callback(IMessageCallbackService.EVENT_TYPE_SHOW, jSONObject2);
    }

    private void callbackClick(JSONObject jSONObject) {
        String optString = jSONObject.optString("rule_id64");
        String optString2 = jSONObject.optString("sender");
        if (this.mClickHelper.isDoubleClick(optString, optString2)) {
            Logger.m268d("MessageCallbackServiceImpl", "not callback message click because mClickHelper.isDoubleClick,rid64:" + optString + " sender:" + optString2);
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        add(jSONObject2, "client_time", convertMsTimeToSTime(jSONObject.optString("client_time")));
        add(jSONObject2, "rid", jSONObject.optString(PushConst.KEY_RULE_ID));
        add(jSONObject2, "click_position", jSONObject.optString("click_position"));
        add(jSONObject2, PushConst.KEY_GROUP_ID, jSONObject.optString("ttpush_group_id"));
        try {
            add(jSONObject2, "rid64", Long.parseLong(optString));
            add(jSONObject2, "sender", Integer.parseInt(optString2));
        } catch (NumberFormatException unused) {
            Logger.m271e("MessageCallbackServiceImpl", "error when parse rid64 and sender to int,rid64:" + optString + " sender:" + optString2);
        }
        callback(IMessageCallbackService.EVENT_TYPE_CLICK, jSONObject2);
    }

    private void callback(final String str, final JSONObject jSONObject) {
        ThreadPlus.submitRunnable(new Runnable() { // from class: com.bytedance.push.msg.callback.MessageCallbackServiceImpl.1
            /* JADX WARN: Removed duplicated region for block: B:12:0x007b  */
            /* JADX WARN: Removed duplicated region for block: B:9:0x0060  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                byte[] bArr;
                String addUrlParam;
                Map<String, String> commonParams = PushSupporter.get().getCommonParams();
                String str2 = null;
                r3 = null;
                byte[] bytes = null;
                if (TextUtils.equals(str, IMessageCallbackService.EVENT_TYPE_CLICK)) {
                    addUrlParam = ToolUtils.addUrlParam(MessageConstants.getMsgClickCallbackUrl(), commonParams);
                    JSONObject jSONObject2 = jSONObject;
                    if (jSONObject2 != null) {
                        bytes = jSONObject2.toString().getBytes();
                    }
                } else if (TextUtils.equals(str, IMessageCallbackService.EVENT_TYPE_SHOW)) {
                    addUrlParam = ToolUtils.addUrlParam(MessageConstants.getMsgArriveCallbackUrl(), commonParams);
                    if (jSONObject != null) {
                        JSONArray jSONArray = new JSONArray();
                        jSONArray.put(jSONObject);
                        bytes = jSONArray.toString().getBytes();
                    }
                } else {
                    bArr = null;
                    if (!TextUtils.isEmpty(str2)) {
                        Logger.m271e("MessageCallbackServiceImpl", "failed callback " + str + " because url is null");
                        return;
                    }
                    NetworkClient.ReqContext reqContext = new NetworkClient.ReqContext();
                    reqContext.addCommonParams = false;
                    try {
                        HashMap hashMap = new HashMap();
                        hashMap.put(XBridgeAPIRequestUtils.CONTENT_TYPE, "application/json");
                        JSONObject jSONObject3 = new JSONObject(PushNetworkClient.getDefault().post(str2, bArr, ToolUtils.addNetworkTagToHeader(hashMap), reqContext));
                        Logger.m268d("MessageCallbackServiceImpl", "finished callback " + str + ",code:" + jSONObject3.optInt("code") + " reason:" + jSONObject3.optString(ISignalReportConstants.KEY_REASON) + " errMsg:" + jSONObject3.optString("err_msg"));
                        return;
                    } catch (Throwable th) {
                        Logger.m271e("MessageCallbackServiceImpl", "error when callback " + str + " :" + th.getLocalizedMessage());
                        return;
                    }
                }
                byte[] bArr2 = bytes;
                str2 = addUrlParam;
                bArr = bArr2;
                if (!TextUtils.isEmpty(str2)) {
                }
            }
        });
    }
}
