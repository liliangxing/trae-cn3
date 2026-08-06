package com.bytedance.sdk.account.legacy;

import com.bytedance.sdk.account.api.callback.CheckEvnCallback;
import com.bytedance.sdk.account.api.callback.DeleteDeviceCallback;
import com.bytedance.sdk.account.api.callback.GetLoginDevicesCallback;
import com.bytedance.sdk.account.api.callback.SwitchTicketCallback;
import com.bytedance.sdk.account.mobile.thread.call.MobilePassAuthCallback;
import com.bytedance.sdk.account.mobile.thread.call.MobileQuickAuthCallback;
import com.bytedance.sdk.account.mobile.thread.call.RefreshCaptchaCallback;
import com.bytedance.sdk.account.mobile.thread.call.VerifyDeviceCallBack;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface IBDAccountLegacyApi {
    void checkEnv(int i, CheckEvnCallback checkEvnCallback);

    void deleteDevice(String str, DeleteDeviceCallback deleteDeviceCallback);

    void getLoginDevices(GetLoginDevicesCallback getLoginDevicesCallback);

    void mobilePassAuth(String str, String str2, String str3, String str4, MobilePassAuthCallback mobilePassAuthCallback);

    void mobileQuickAuth(String str, String str2, String str3, MobileQuickAuthCallback mobileQuickAuthCallback);

    void mobileQuickAuth(String str, String str2, String str3, Map<String, String> map, MobileQuickAuthCallback mobileQuickAuthCallback);

    @Deprecated
    void refreshCaptcha(int i, RefreshCaptchaCallback refreshCaptchaCallback);

    void refreshCaptcha(RefreshCaptchaCallback refreshCaptchaCallback);

    void switchTicket(String str, SwitchTicketCallback switchTicketCallback);

    void verifyDevice(VerifyDeviceCallBack verifyDeviceCallBack);
}
