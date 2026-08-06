package com.bytedance.ug.sdk.deeplink.settings;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.pia.core.metrics.ErrorType;
import com.bytedance.ug.sdk.deeplink.CommonConstants;
import com.bytedance.ug.sdk.deeplink.GlobalContext;
import com.bytedance.ug.sdk.deeplink.HostCommonServices;
import com.bytedance.ug.sdk.deeplink.IZlinkDepend;
import com.bytedance.ug.sdk.deeplink.utils.EventUtil;
import com.bytedance.ug.sdk.deeplink.utils.NetworkUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class RequestServiceImpl {
    private static final String GET_SETTINGS_URL_V3 = "https://zlink.ugsdk.cn/service/settings/v3/";
    private static final String KEY_MESSAGE = "message";
    private static final int RESULT_DEMOTION = 2;
    private static final int RESULT_FAIL = 0;
    private static final int RESULT_SUCCESS = 1;
    private static final String STATUS_DEMOTION = "demotion";
    private static final String STATUS_SUCCESS = "success";
    private static final AtomicBoolean isRequested = new AtomicBoolean(false);

    RequestServiceImpl() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setIsRequested() {
        isRequested.compareAndSet(false, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isRequested() {
        return isRequested.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:5:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void request(String str) {
        int i;
        long currentTimeMillis = System.currentTimeMillis();
        String executePostRequest = NetworkUtils.getInstance().executePostRequest(createUriBuilder().toString());
        JSONObject jSONObject = null;
        if (TextUtils.isEmpty(executePostRequest)) {
            i = 0;
        } else {
            try {
                JSONObject jSONObject2 = new JSONObject(executePostRequest);
                if (isSettingsRequestSuccess(jSONObject2)) {
                    i = 1;
                } else {
                    i = isSettingRequestDemotion(jSONObject2) ? 2 : 0;
                }
                if (i != 0) {
                    try {
                        JSONObject optJSONObject = jSONObject2.optJSONObject("data");
                        if (optJSONObject == null) {
                            optJSONObject = new JSONObject();
                        }
                        jSONObject = optJSONObject.optJSONObject(ErrorType.SETTINGS);
                        if (jSONObject != null) {
                            jSONObject.put(CommonConstants.KEY_SETTINGS_TIME, optJSONObject.optLong(CommonConstants.KEY_SETTINGS_TIME, 0L));
                        }
                    } catch (JSONException e) {
                        e = e;
                        e.printStackTrace();
                        if (jSONObject == null) {
                        }
                        ZlinkSettingsManager.doAfterSettingsRequest(i != 0, jSONObject);
                        EventUtil.sendEverySettingResultEvent(i, currentTimeMillis, str);
                    }
                }
            } catch (JSONException e2) {
                e = e2;
                i = 0;
            }
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        ZlinkSettingsManager.doAfterSettingsRequest(i != 0, jSONObject);
        EventUtil.sendEverySettingResultEvent(i, currentTimeMillis, str);
    }

    private static boolean isSettingsRequestSuccess(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        return "success".equalsIgnoreCase(jSONObject.optString("message"));
    }

    private static boolean isSettingRequestDemotion(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        return STATUS_DEMOTION.equalsIgnoreCase(jSONObject.optString("message"));
    }

    private static Uri.Builder createUriBuilder() {
        String settingHost = HostCommonServices.getSettingHost();
        Uri.Builder buildUpon = Uri.parse(settingHost != null ? settingHost + "service/settings/v3/" : GET_SETTINGS_URL_V3).buildUpon();
        buildUpon.appendQueryParameter("caller_name", CommonConstants.ZLINK);
        IZlinkDepend zlinkDepend = HostCommonServices.getZlinkDepend();
        if (zlinkDepend != null && !TextUtils.isEmpty(zlinkDepend.getAppId())) {
            buildUpon.appendQueryParameter(CommonConstants.KEY_AID, zlinkDepend.getAppId());
        }
        buildUpon.appendQueryParameter(CommonConstants.KEY_DEVICE_PLATFORM, "android");
        buildUpon.appendQueryParameter("zlink_sdk_version", "1.1.6");
        appendSettingsTime(buildUpon);
        return buildUpon;
    }

    private static void appendSettingsTime(Uri.Builder builder) {
        if (builder == null) {
            return;
        }
        builder.appendQueryParameter(CommonConstants.KEY_SETTINGS_TIME, Long.toString(ZlinkSettingsApi.getSettingsTime(GlobalContext.INSTANCE.getApplication())));
    }
}
