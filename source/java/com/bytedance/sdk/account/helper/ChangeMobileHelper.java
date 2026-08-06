package com.bytedance.sdk.account.helper;

import com.bytedance.sdk.account.AccountSdkCallback;
import com.bytedance.sdk.account.api.callback.CheckCodeCallback;
import com.bytedance.sdk.account.api.callback.CheckMobileUnusableCallback;
import com.bytedance.sdk.account.api.callback.GetAvailableWaysCallback;
import com.bytedance.sdk.account.api.callback.SafeVerifyCallback;
import com.bytedance.sdk.account.impl.BDAccountAPIV3Impl;
import com.bytedance.sdk.account.impl.BDAccountCommonApiImpl;
import com.bytedance.sdk.account.mobile.thread.call.ChangeMobileNumCallback;
import com.bytedance.sdk.account.mobile.thread.call.ValidateCodeCallBack;
import com.bytedance.sdk.account.param.SendCodeParam;
import com.bytedance.sdk.account.response.SendCodeResponseData;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class ChangeMobileHelper {
    public static void checkSafeEnvBeforeSendCodeToOld(SafeVerifyCallback safeVerifyCallback) {
        BDAccountAPIV3Impl.instance().safeVerify(null, "change_mobile_without_old_mobile", "change_mobile_without_old_mobile", null, safeVerifyCallback);
    }

    public static void checkSafeEnvBeforeValidateOld(String str, SafeVerifyCallback safeVerifyCallback) {
        BDAccountAPIV3Impl.instance().safeVerify(null, "change_mobile", "change_mobile", str, safeVerifyCallback);
    }

    public static void checkOldPhoneUnusable(String str, CheckMobileUnusableCallback checkMobileUnusableCallback) {
        BDAccountAPIV3Impl.instance().checkMobileUnusable(str, null, null, checkMobileUnusableCallback);
    }

    public static void sendCodeToOld(String str, AccountSdkCallback<SendCodeResponseData> accountSdkCallback) {
        BDAccountCommonApiImpl.instance().sendCode(new SendCodeParam.Builder(str, 28).build(), accountSdkCallback);
    }

    public static void sendCodeToOld(AccountSdkCallback<SendCodeResponseData> accountSdkCallback) {
        BDAccountCommonApiImpl.instance().sendCode(new SendCodeParam.Builder(null, 22).build(), accountSdkCallback);
    }

    public static void validateOld(String str, boolean z, ValidateCodeCallBack validateCodeCallBack) {
        BDAccountAPIV3Impl.instance().requestValidateSMSCode(str, z ? 28 : 22, true, validateCodeCallBack);
    }

    public static void sendCodeToNew(String str, String str2, boolean z, AccountSdkCallback<SendCodeResponseData> accountSdkCallback) {
        BDAccountCommonApiImpl.instance().sendCode(new SendCodeParam.Builder(str, 20).setUnbindExist(z).setTicket(str2).setCheckRegister(1).build(), accountSdkCallback);
    }

    public static void changeBind(String str, String str2, String str3, ChangeMobileNumCallback changeMobileNumCallback) {
        BDAccountAPIV3Impl.instance().changeMobileNum(str, str2, null, str3, changeMobileNumCallback);
    }

    public static void sendCodeToNewIgnoreConflict(String str, String str2, AccountSdkCallback<SendCodeResponseData> accountSdkCallback) {
        BDAccountCommonApiImpl.instance().sendCode(new SendCodeParam.Builder(str, 26).setTicket(str2).setCheckRegister(1).build(), accountSdkCallback);
    }

    public static void validateCodeForNew(String str, String str2, CheckCodeCallback checkCodeCallback) {
        BDAccountAPIV3Impl.instance().checkCode(str, str2, 26, checkCodeCallback);
    }

    public static void getAvailableVerifyWays(boolean z, String str, GetAvailableWaysCallback getAvailableWaysCallback) {
        BDAccountAPIV3Impl.instance().getAvailableWays(z ? 1 : 0, str, getAvailableWaysCallback);
    }
}
