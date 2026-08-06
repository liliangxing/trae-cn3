package com.bytedance.sdk.account.error.handler.impl;

import android.text.TextUtils;
import com.bytedance.sdk.account.bus.util.AccountBusUtils;
import com.bytedance.sdk.account.error.handler.ErrorHandler;
import com.ss.android.LogHelper;
import com.ss.android.ShowDialogActivity;
import com.ss.android.TTAccountConfig;
import com.ss.android.account.BdTruingManager;
import com.ss.android.account.TTAccountInit;
import com.ss.android.account.dbtring.IBdTruing;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: CaptchaErrorHandler.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J8\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¨\u0006\u0012"}, d2 = {"Lcom/bytedance/sdk/account/error/handler/impl/CaptchaErrorHandler;", "Lcom/bytedance/sdk/account/error/handler/ErrorHandler;", "()V", "checkBdTuringVersion", "", "getName", "", "handle", "", "error", "", "requestParams", "", "responseRawJson", "Lorg/json/JSONObject;", "callback", "Lcom/bytedance/sdk/account/error/handler/ErrorHandler$HandlerCallback;", "Companion", "account-sdk-core_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class CaptchaErrorHandler implements ErrorHandler {
    private static final String TAG = "CaptchaErrorHandler";
    private static boolean hadCheckBDTuringVersion;
    private static boolean needAccountSDKShowCaptcha = true;

    @Override // com.bytedance.sdk.account.error.handler.ErrorHandler
    public String getName() {
        return "captcha";
    }

    @Override // com.bytedance.sdk.account.error.handler.ErrorHandler
    public boolean handle(int error, Map<String, String> requestParams, JSONObject responseRawJson, final ErrorHandler.HandlerCallback callback) {
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        if (responseRawJson == null) {
            return false;
        }
        checkBdTuringVersion();
        String optString = responseRawJson.optString("verify_center_decision_conf");
        if (TextUtils.isEmpty(optString)) {
            JSONObject optJSONObject = responseRawJson.optJSONObject("data");
            optString = optJSONObject != null ? optJSONObject.optString("verify_center_decision_conf") : null;
        }
        BdTruingManager inst = BdTruingManager.getInst();
        Intrinsics.checkExpressionValueIsNotNull(inst, "BdTruingManager.getInst()");
        IBdTruing bdTruing = inst.getBdTruing();
        if (!needAccountSDKShowCaptcha || (!(error == 1104 || error == 1105 || !TextUtils.isEmpty(optString)) || bdTruing == null || bdTruing.forceDisable())) {
            return false;
        }
        bdTruing.showVerifyDialog(error, optString, new IBdTruing.IAccountBdTuringCallback() { // from class: com.bytedance.sdk.account.error.handler.impl.CaptchaErrorHandler$handle$1
            public void onFail() {
                ErrorHandler.HandlerCallback.this.onHandlerResult(false, false, null);
            }

            public void onSuccess() {
                ErrorHandler.HandlerCallback.this.onHandlerResult(true, true, null);
            }
        });
        return true;
    }

    private final void checkBdTuringVersion() {
        String str;
        if (hadCheckBDTuringVersion) {
            return;
        }
        try {
            Class<?> cls = Class.forName("com.bytedance.bdturing.reflect.VersionUtils");
            str = cls.getMethod("getVersionName", new Class[0]).invoke(cls.newInstance(), new Object[0]).toString();
        } catch (Throwable th) {
            th.printStackTrace();
            str = "";
        }
        boolean z = TextUtils.isEmpty(str) || AccountBusUtils.compareVersion("3.1.0", str) > 0;
        needAccountSDKShowCaptcha = z;
        if (z) {
            BdTruingManager inst = BdTruingManager.getInst();
            Intrinsics.checkExpressionValueIsNotNull(inst, "BdTruingManager.getInst()");
            if (inst.getBdTruing() != null) {
                BdTruingManager inst2 = BdTruingManager.getInst();
                Intrinsics.checkExpressionValueIsNotNull(inst2, "BdTruingManager.getInst()");
                if (inst2.getBdTruing().enableShowVersionCheckDialog()) {
                    TTAccountConfig config = TTAccountInit.getConfig();
                    Intrinsics.checkExpressionValueIsNotNull(config, "TTAccountInit.getConfig()");
                    if (config.isLocalTest()) {
                        TTAccountConfig config2 = TTAccountInit.getConfig();
                        Intrinsics.checkExpressionValueIsNotNull(config2, "TTAccountInit.getConfig()");
                        ShowDialogActivity.showDialog(config2.getApplicationContext(), "未接入验证码SDK或版本过低", "请升级验证码SDK到3.1.0版本以上！");
                    } else {
                        LogHelper.e(TAG, "未接入验证码SDK或版本过低，请升级验证码SDK到3.1.0版本以上！");
                    }
                }
            }
        }
        hadCheckBDTuringVersion = true;
    }
}
