package com.bytedance.ug.sdk.share.impl.event;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.notification.Constants;
import com.bytedance.ug.sdk.deeplink.CommonConstants;
import com.bytedance.ug.sdk.share.BuildConfig;
import com.bytedance.ug.sdk.share.impl.config.ShareConfigManager;
import com.bytedance.ug.sdk.share.impl.utils.AppLogUtils;
import com.bytedance.ug.sdk.share.impl.utils.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class MonitorEvent {
    public static long mPanelClickTime;

    public static void monitorPanelShow(int i, long j, String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(CommonConstants.TOTAL_DURATION, j);
            jSONObject.put("status", i);
            jSONObject.put("failed_reason", str2);
            jSONObject.put("panel_id", str);
            addCommonParams(jSONObject);
            AppLogUtils.onEventV3("ug_sdk_share_panel_show_performance", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void monitorPanelClick(int i, long j) {
        try {
            JSONObject jSONObject = new JSONObject();
            addCommonParams(jSONObject);
            jSONObject.put(CommonConstants.TOTAL_DURATION, j);
            jSONObject.put("status", i);
            AppLogUtils.onEventV3("ug_sdk_share_channel_clicked_failed", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void monitorShareFileDownload(int i, String str, long j) {
        try {
            JSONObject jSONObject = new JSONObject();
            addCommonParams(jSONObject);
            jSONObject.put("status", i);
            jSONObject.put("url", str);
            jSONObject.put(CommonConstants.TOTAL_DURATION, j);
            AppLogUtils.onEventV3("ug_sdk_share_file_download", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void monitorShareVideoDownload(int i, String str, long j) {
        try {
            JSONObject jSONObject = new JSONObject();
            addCommonParams(jSONObject);
            jSONObject.put("url", str);
            jSONObject.put("status", i);
            jSONObject.put(CommonConstants.TOTAL_DURATION, j);
            AppLogUtils.onEventV3("ug_sdk_share_video_download", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void monitorShareImageDownload(int i, String str, long j) {
        try {
            JSONObject jSONObject = new JSONObject();
            addCommonParams(jSONObject);
            jSONObject.put("url", str);
            jSONObject.put("status", i);
            jSONObject.put(CommonConstants.TOTAL_DURATION, j);
            AppLogUtils.onEventV3("ug_sdk_share_image_download", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void monitorShareInit(int i, long j) {
        try {
            JSONObject jSONObject = new JSONObject();
            addCommonParams(jSONObject);
            jSONObject.put("status", i);
            jSONObject.put(CommonConstants.TOTAL_DURATION, j);
            AppLogUtils.onEventV3("ug_sdk_share_init", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void monitorShareTokenIdentification(int i, long j) {
        try {
            JSONObject jSONObject = new JSONObject();
            addCommonParams(jSONObject);
            jSONObject.put("status", i);
            jSONObject.put(CommonConstants.TOTAL_DURATION, j);
            AppLogUtils.onEventV3("ug_sdk_share_token_identification", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void monitorShareImageTokenIdentification(int i, long j) {
        try {
            JSONObject jSONObject = new JSONObject();
            addCommonParams(jSONObject);
            jSONObject.put("status", i);
            jSONObject.put(CommonConstants.TOTAL_DURATION, j);
            AppLogUtils.onEventV3("ug_sdk_share_image_token_identification", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void addCommonParams(JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            String deviceId = ShareConfigManager.getInstance().getDeviceId();
            if (!TextUtils.isEmpty(deviceId)) {
                jSONObject.put("ug_share_did", deviceId);
            }
            String appId = ShareConfigManager.getInstance().getAppId();
            if (!TextUtils.isEmpty(appId)) {
                jSONObject.put("ug_share_aid", appId);
            }
            jSONObject.put(Constants.NOTIFICATION_TAG, "ug_sdk_share");
            jSONObject.put("ug_share_v_code", String.valueOf(BuildConfig.SHARE_VERSION_CODE));
            jSONObject.put("ug_share_v_name", BuildConfig.SHARE_VERSION_NAME);
            jSONObject.put("ug_share_os_api", String.valueOf(Build.VERSION.SDK_INT));
            jSONObject.put("ug_share_platform", "android");
            jSONObject.put("params_for_special", "performance");
        } catch (JSONException e) {
            Logger.m465e(e.toString());
        }
    }
}
