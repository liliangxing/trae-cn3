package com.bytedance.ug.sdk.deeplink;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.ug.sdk.deeplink.api.internal.IClipboardInternalApi;
import com.bytedance.ug.sdk.deeplink.callback.CallbackManager;
import com.bytedance.ug.sdk.deeplink.settings.ZlinkSettingsApi;
import com.bytedance.ug.sdk.deeplink.utils.CommonUtils;
import com.bytedance.ug.sdk.deeplink.utils.EventUtil;
import com.bytedance.ug.sdk.deeplink.utils.NetworkUtils;
import com.bytedance.ug.sdk.deeplink.utils.ThreadUtils;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class FingerPrintUtil {
    private static final String TAG = "FingerPrintUtil";
    private final String FINGER_PRINT_REQUEST_URL;
    private final AtomicBoolean isNeedRequested;

    private FingerPrintUtil() {
        this.FINGER_PRINT_REQUEST_URL = "https://zlink.toutiao.com/api/get_deeplink_data";
        this.isNeedRequested = new AtomicBoolean(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class SingleHolder {
        private static final FingerPrintUtil fingerPrintUtil = new FingerPrintUtil();

        private SingleHolder() {
        }
    }

    public static FingerPrintUtil getInstance() {
        return SingleHolder.fingerPrintUtil;
    }

    public void checkSchemeWithDevicePrint(final Context context, final String str) {
        if (this.isNeedRequested.compareAndSet(true, false) && ZlinkSettingsApi.isEnableDevicePrint(context)) {
            if (CommonUtils.isFirstStartAfterInstalled(context, CommonConstants.KEY_NOT_FIRST_INSTALLED) || CommonUtils.isJumpFromBaidu) {
                ThreadUtils.executeAsync(new Runnable() { // from class: com.bytedance.ug.sdk.deeplink.FingerPrintUtil.1
                    @Override // java.lang.Runnable
                    public void run() {
                        String requestDeepLinkData = FingerPrintUtil.this.requestDeepLinkData(context, str);
                        FingerPrintUtil.this.tryOnEvent(str, requestDeepLinkData);
                        CallbackManager.callBackForCheckClipboard(requestDeepLinkData, "", null, true);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryOnEvent(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            IClipboardInternalApi iClipboardInternalApi = (IClipboardInternalApi) UgServiceManager.INSTANCE.getInternalApi(IClipboardInternalApi.class);
            IClipboardChecker clipboardCheckerWithType = iClipboardInternalApi != null ? iClipboardInternalApi.getClipboardCheckerWithType("scheme") : null;
            if (clipboardCheckerWithType != null ? clipboardCheckerWithType.isSelf(str2) : false) {
                GlobalContext.INSTANCE.setUriType(UriType.DEVICE_PRINT);
                EventUtil.sendActivationEvent(UriType.DEVICE_PRINT, str2, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String requestDeepLinkData(Context context, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        String str2 = null;
        try {
            String str3 = "https://zlink.toutiao.com/api/get_deeplink_data";
            Uri.Builder createBuilder = createBuilder(context);
            if (createBuilder != null) {
                createBuilder.appendQueryParameter("scheme", str);
                str3 = createBuilder.toString();
            }
            str2 = NetworkUtils.getInstance().executeGetRequest(str3, new HashMap(), true, 2000L);
            if (str2 == null) {
                EventUtil.sendFingerPrintEvent(currentTimeMillis, 0, "request error, response is null");
                return "";
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return parseResponse(str2, currentTimeMillis);
    }

    private String parseResponse(String str, long j) {
        String str2;
        JSONObject jSONObject;
        str2 = "";
        if (TextUtils.isEmpty(str)) {
            EventUtil.sendFingerPrintEvent(j, 0, "response empty");
            return "";
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            e.printStackTrace();
            jSONObject = null;
        }
        if (jSONObject == null) {
            EventUtil.sendFingerPrintEvent(j, 0, "response not json");
            return "";
        }
        if (jSONObject.optInt("code") == 0) {
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            str2 = optJSONObject != null ? optJSONObject.optString("scheme") : "";
            EventUtil.sendFingerPrintEvent(j, 1, "success");
        } else {
            EventUtil.sendFingerPrintEvent(j, 0, jSONObject.optString("message"));
        }
        return str2;
    }

    private Uri.Builder createBuilder(Context context) {
        Uri.Builder buildUpon = Uri.parse("https://zlink.toutiao.com/api/get_deeplink_data").buildUpon();
        IZlinkDepend zlinkDepend = HostCommonServices.getZlinkDepend();
        if (zlinkDepend != null) {
            buildUpon.appendQueryParameter(CommonConstants.KEY_AID, zlinkDepend.getAppId());
            String deviceId = zlinkDepend.getDeviceId();
            if (TextUtils.isEmpty(deviceId)) {
                deviceId = "";
            }
            buildUpon.appendQueryParameter(CommonConstants.KEY_DEVICE_ID, deviceId);
        }
        buildUpon.appendQueryParameter("os", "android");
        buildUpon.appendQueryParameter("db", Build.BRAND);
        buildUpon.appendQueryParameter("dm", Build.MODEL);
        if (context != null) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            Display defaultDisplay = windowManager != null ? windowManager.getDefaultDisplay() : null;
            if (defaultDisplay != null) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                defaultDisplay.getMetrics(displayMetrics);
                int i = displayMetrics.widthPixels;
                int i2 = displayMetrics.heightPixels;
                buildUpon.appendQueryParameter("sw", "" + i);
                buildUpon.appendQueryParameter("sh", "" + i2);
            }
        }
        return buildUpon;
    }
}
