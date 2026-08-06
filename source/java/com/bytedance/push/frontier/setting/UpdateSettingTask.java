package com.bytedance.push.frontier.setting;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.utility.NetworkClient;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.frontier.FrontierSupporter;
import com.bytedance.push.frontier.interfaze.OnFrontierSettingUpdateListener;
import com.bytedance.push.settings.PushOnlineSettings;
import com.bytedance.push.settings.SettingsManager;
import com.bytedance.push.utils.Logger;
import com.ss.android.message.util.ToolUtils;
import com.ss.android.pushmanager.MessageConstants;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class UpdateSettingTask {
    public synchronized void runTasks(Context context, OnFrontierSettingUpdateListener onFrontierSettingUpdateListener) {
        FrontierLocalSetting frontierLocalSetting = (FrontierLocalSetting) SettingsManager.obtain(context, FrontierLocalSetting.class);
        PushOnlineSettings pushOnlineSettings = (PushOnlineSettings) SettingsManager.obtain(context, PushOnlineSettings.class);
        long currentTimeMillis = ToolUtils.currentTimeMillis();
        boolean z = true;
        boolean z2 = Math.abs(currentTimeMillis - frontierLocalSetting.getLastRequestSettingTime()) / 60000 < pushOnlineSettings.getUpdateFrontierSettingIntervalTimeInMinute();
        FrontierSetting frontierSetting = frontierLocalSetting.getFrontierSetting();
        if (frontierSetting == null || !frontierSetting.isValid()) {
            z = false;
        }
        if (!z || !z2) {
            String addUrlParam = ToolUtils.addUrlParam(MessageConstants.getUpdateFrontierSettingUrl(), PushSupporter.get().getCommonParams());
            NetworkClient.ReqContext reqContext = new NetworkClient.ReqContext();
            reqContext.addCommonParams = false;
            try {
                if (parseResponse(NetworkClient.getDefault().post(addUrlParam, new ArrayList(), ToolUtils.addNetworkTagToHeader((Map) null), reqContext), context, currentTimeMillis, frontierLocalSetting, onFrontierSettingUpdateListener)) {
                    return;
                }
            } catch (Throwable th) {
                th.printStackTrace();
                doWithRequestFailed(context, 301, th.getLocalizedMessage(), currentTimeMillis);
            }
        }
        onFrontierSettingUpdateListener.onFrontierSettingUpdate(frontierSetting);
    }

    private boolean parseResponse(String str, Context context, long j, FrontierLocalSetting frontierLocalSetting, OnFrontierSettingUpdateListener onFrontierSettingUpdateListener) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            doWithRequestFailed(context, 304, str, j);
            return false;
        }
        JSONObject jSONObject = new JSONObject(str);
        if (!TextUtils.equals("success", jSONObject.optString("message"))) {
            doWithRequestFailed(context, 302, str, j);
            return false;
        }
        FrontierSetting parse = FrontierSetting.parse(jSONObject.optJSONObject(FrontierLocalSetting.KEY_FRONTIER_SETTING));
        if (parse == null || !parse.isValid()) {
            doWithRequestFailed(context, 303, str, j);
            return false;
        }
        frontierLocalSetting.setLastRequestSettingTime(ToolUtils.currentTimeMillis());
        frontierLocalSetting.setFrontierSetting(parse);
        doWithRequestSuccess(j);
        onFrontierSettingUpdateListener.onFrontierSettingUpdate(parse);
        return true;
    }

    private void doWithRequestSuccess(long j) {
        FrontierSupporter.get().getFrontierMonitor().onRequestFrontierSettingSuccess(ToolUtils.currentTimeMillis() - j);
    }

    private void doWithRequestFailed(Context context, int i, String str, long j) {
        Logger.m270e("request frontier setting failed, errorCode: " + i + " response: " + str);
        FrontierSupporter.get().getFrontierMonitor().onRequestFrontierSettingFailed(i, str, ToolUtils.currentTimeMillis() - j);
    }
}
