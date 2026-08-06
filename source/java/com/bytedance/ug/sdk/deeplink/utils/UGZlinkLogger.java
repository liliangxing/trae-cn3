package com.bytedance.ug.sdk.deeplink.utils;

import android.content.ClipData;
import android.net.Uri;
import android.util.Pair;
import com.bytedance.ug.sdk.deeplink.ZlinkApi;
import com.bytedance.ug.sdk.deeplink.helper.AppFrontBackHelper;
import com.bytedance.ug.sdk.deeplink.utils.UGLogger;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class UGZlinkLogger {
    private static UGLogger.LogContext clipBoardInvokeContext;

    public static void startClipBoardInvoke() {
        clipBoardInvokeContext = new UGLogger.LogContext();
    }

    public static void onLinkParseStart(Uri uri, UGLogger.LogContext logContext) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("is_init", ZlinkApi.INSTANCE.isInited());
            jSONObject.put("uri", uri.toString());
            UGLogger.m455i("start to parse link", UGLogger.MODULE_LINK_INVOKE, jSONObject, logContext);
        } catch (Exception unused) {
        }
    }

    public static void onLinkParseSuccess(int i, String str, UGLogger.LogContext logContext) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", i);
            jSONObject.put("scheme", str);
            UGLogger.m455i("parse link success", UGLogger.MODULE_LINK_INVOKE, jSONObject, logContext);
        } catch (Exception unused) {
        }
    }

    public static void onLinkParseFail(int i, String str, UGLogger.LogContext logContext) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", i);
            jSONObject.put("url", str);
            UGLogger.m452e("parse link fail", UGLogger.MODULE_LINK_INVOKE, jSONObject, logContext);
        } catch (Exception unused) {
        }
    }

    public static void onLinkInvokeEnd(int i, String str, UGLogger.LogContext logContext) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", i);
            jSONObject.put("scheme", str);
            UGLogger.m455i("link invoke end", UGLogger.MODULE_LINK_INVOKE, jSONObject, logContext);
        } catch (Exception unused) {
        }
    }

    public static void onClipBoardStart() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("is_init", ZlinkApi.INSTANCE.isInited());
            UGLogger.m455i("start to check clipboard", UGLogger.MODULE_CLIPBOARD_INVOKE, jSONObject, clipBoardInvokeContext);
        } catch (Exception unused) {
        }
    }

    public static void onForbidCheckClipBoard() {
        try {
            UGLogger.m452e("forbid to check clipboard", UGLogger.MODULE_CLIPBOARD_INVOKE, new JSONObject(), clipBoardInvokeContext);
        } catch (Exception unused) {
        }
    }

    public static void onGetClipData(Pair<Boolean, ClipData> pair) {
        try {
            UGLogger.m453i("start to get clipboard data : " + pair.first + " ,cache clip data: " + (pair.second == null), UGLogger.MODULE_CLIPBOARD_INVOKE, clipBoardInvokeContext);
        } catch (Exception unused) {
        }
    }

    public static void onClipDataEmpty() {
        ThreadUtils.runInMainThread(new Runnable() { // from class: com.bytedance.ug.sdk.deeplink.utils.UGZlinkLogger.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("is_focus", AppFrontBackHelper.getInstance().getTopActivity() != null && AppFrontBackHelper.getInstance().getTopActivity().hasWindowFocus());
                    UGLogger.m452e("clipboard text is null", UGLogger.MODULE_CLIPBOARD_INVOKE, jSONObject, UGZlinkLogger.clipBoardInvokeContext);
                } catch (Exception unused) {
                }
            }
        });
    }

    public static void onRepeatScheme() {
        try {
            UGLogger.m452e("repeat scheme", UGLogger.MODULE_CLIPBOARD_INVOKE, new JSONObject(), clipBoardInvokeContext);
        } catch (Exception unused) {
        }
    }

    public static void onDidEmpty() {
        try {
            UGLogger.m453i("did is empty", UGLogger.MODULE_CLIPBOARD_INVOKE, clipBoardInvokeContext);
        } catch (Exception unused) {
        }
    }

    public static void onRequestSchemeError(int i, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i);
            jSONObject.put("message", str);
            UGLogger.m452e("request scheme error", UGLogger.MODULE_CLIPBOARD_INVOKE, jSONObject, clipBoardInvokeContext);
        } catch (Exception unused) {
        }
    }

    public static void onRequestSchemeSuccess(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("scheme", str);
            UGLogger.m455i("request scheme success", UGLogger.MODULE_CLIPBOARD_INVOKE, jSONObject, clipBoardInvokeContext);
        } catch (Exception unused) {
        }
    }

    public static void onSchemeNotInList() {
        try {
            UGLogger.m452e("scheme not in schemeList", UGLogger.MODULE_CLIPBOARD_INVOKE, new JSONObject(), clipBoardInvokeContext);
        } catch (Exception unused) {
        }
    }

    public static void onClipBoardCheckEnd(boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("is_match", z);
            UGLogger.m455i("check clipboard end", UGLogger.MODULE_CLIPBOARD_INVOKE, jSONObject, clipBoardInvokeContext);
        } catch (Exception unused) {
        }
    }
}
