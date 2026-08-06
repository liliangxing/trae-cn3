package com.bytedance.ug.sdk.share.impl.utils;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.ug.sdk.deeplink.CommonConstants;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.api.entity.ShareResult;
import com.bytedance.ug.sdk.share.api.entity.ShareStrategy;
import com.bytedance.ug.sdk.share.api.entity.TokenInfoBean;
import com.bytedance.ug.sdk.share.impl.config.ShareConfigManager;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class UGShareLogger {
    public static void onShareStart(ShareContent shareContent) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (shareContent != null) {
                jSONObject.put("platform", shareContent.getShareChanelType());
                jSONObject.put("share_type", ShareStrategy.getStrategyStr(shareContent.getShareStrategy()));
            }
            UGLogger.m484i("share to platform start", UGLogger.MODULE_SHARE, jSONObject, shareContent != null ? shareContent.getLogContext() : null);
        } catch (Exception unused) {
        }
    }

    public static void onShareFinish(ShareResult shareResult, ShareContent shareContent) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (shareResult != null) {
                jSONObject.put("platform", shareResult.channelType);
                jSONObject.put("error", shareResult.errorCode);
                jSONObject.put("original_error_code", shareResult.detailErrorCode);
                jSONObject.put("original_sub_error_code", shareResult.detailSubErrorCode);
            }
            UGLogger.m484i("share to platform finish", UGLogger.MODULE_SHARE, jSONObject, shareContent != null ? shareContent.getLogContext() : null);
        } catch (Exception unused) {
        }
    }

    public static void onCheckAlbumParse(boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("album_parse_switch", z ? 1 : 0);
            jSONObject.put("brand", Build.BRAND);
            jSONObject.put("system_version", Build.VERSION.SDK_INT);
            UGLogger.m484i("checkImageToken start", UGLogger.MODULE_REFLOW, jSONObject, UGLogger.getRecordingLogContext());
        } catch (Exception unused) {
        }
    }

    public static void onCheckTextTokenParse(boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("token_parse_switch", z ? 1 : 0);
            jSONObject.put("brand", Build.BRAND);
            jSONObject.put("system_version", Build.VERSION.SDK_INT);
            UGLogger.m484i("check text token parse enable status", UGLogger.MODULE_REFLOW, jSONObject, UGLogger.getRecordingLogContext());
        } catch (JSONException unused) {
        }
    }

    public static void onGetShareInfo(String str, String str2, ShareContent shareContent, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("share_panel_id", str);
            jSONObject2.put("resource_id", str2);
            jSONObject2.put("is_local_mode", ShareConfigManager.getInstance().isLocalMode() ? 1 : 0);
            jSONObject2.put(CommonConstants.KEY_DID, ShareConfigManager.getInstance().getDeviceId());
            jSONObject2.put("app_id", ShareConfigManager.getInstance().getAppId());
            jSONObject2.put("data", jSONObject);
            UGLogger.m484i("request share data info", UGLogger.MODULE_SHARE, jSONObject2, shareContent != null ? shareContent.getLogContext() : null);
        } catch (JSONException unused) {
        }
    }

    public static void onClipboardEmpty() {
        MainThreadUtils.runOnMainThread(new Runnable() { // from class: com.bytedance.ug.sdk.share.impl.utils.UGShareLogger.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("is_focus", ShareConfigManager.getInstance().getTopActivity() != null && ShareConfigManager.getInstance().getTopActivity().hasWindowFocus());
                    UGLogger.m484i("clipboard text is null", UGLogger.MODULE_REFLOW, jSONObject, UGLogger.getRecordingLogContext());
                } catch (Exception unused) {
                }
            }
        });
    }

    public static void onTokenParseFailed(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("error_reason", str);
            UGLogger.m484i("parse token error", UGLogger.MODULE_REFLOW, jSONObject, UGLogger.getRecordingLogContext());
        } catch (Exception unused) {
        }
    }

    public static void onCheckTokenByClientRules(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", TextUtils.isEmpty(str) ? 0 : 1);
            jSONObject.put("command", str);
            UGLogger.m484i("check command with client token reg", UGLogger.MODULE_REFLOW, jSONObject, UGLogger.getRecordingLogContext());
        } catch (Exception unused) {
        }
    }

    public static void onCheckTokenByServerRules(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", TextUtils.isEmpty(str) ? 0 : 1);
            jSONObject.put("command", str);
            UGLogger.m484i("check command with server token reg", UGLogger.MODULE_REFLOW, jSONObject, UGLogger.getRecordingLogContext());
        } catch (Exception unused) {
        }
    }

    public static void onSelfTokenReflow() {
        UGLogger.m482i("cache text is equal to clipboard text", UGLogger.MODULE_REFLOW, UGLogger.getRecordingLogContext());
    }

    public static void onHandleTokenStart() {
        UGLogger.startRecord();
        UGLogger.m482i("handleToken start", UGLogger.MODULE_REFLOW, UGLogger.getRecordingLogContext());
    }

    public static void onShareInfoSuccess(ShareContent shareContent) {
        UGLogger.m484i("request share data info success", UGLogger.MODULE_SHARE, null, shareContent != null ? shareContent.getLogContext() : null);
    }

    public static void onShareInfoFailed(String str, ShareContent shareContent) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("error", str);
            UGLogger.m481e("request share data info fail", UGLogger.MODULE_SHARE, jSONObject, shareContent.getLogContext());
        } catch (JSONException unused) {
        }
    }

    public static void onRequestParseToken() {
        UGLogger.m482i("request flow request", UGLogger.MODULE_REFLOW, UGLogger.getRecordingLogContext());
    }

    public static void onRequestParseTokenSuccess(TokenInfoBean tokenInfoBean) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (tokenInfoBean != null) {
                jSONObject.put("data", tokenInfoBean);
            }
            UGLogger.m484i("parse token success", UGLogger.MODULE_REFLOW, jSONObject, UGLogger.getRecordingLogContext());
        } catch (Exception unused) {
        }
    }

    public static void onInterceptRecognizeToken() {
        UGLogger.m482i("show intercept recognize token dialog", UGLogger.MODULE_REFLOW, UGLogger.getRecordingLogContext());
    }

    public static void onShowRecognizeTokenDialog() {
        UGLogger.m482i("show normal recognize token dialog", UGLogger.MODULE_REFLOW, UGLogger.getRecordingLogContext());
    }
}
