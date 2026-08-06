package com.bytedance.sdk.account.legacy;

import android.content.Context;
import com.bytedance.sdk.account.api.callback.CheckEvnCallback;
import com.bytedance.sdk.account.api.callback.DeleteDeviceCallback;
import com.bytedance.sdk.account.api.callback.GetLoginDevicesCallback;
import com.bytedance.sdk.account.api.callback.SwitchTicketCallback;
import com.bytedance.sdk.account.job.CheckEnvJob;
import com.bytedance.sdk.account.job.DeleteDeviceJob;
import com.bytedance.sdk.account.job.GetLoginDevicesJob;
import com.bytedance.sdk.account.job.SwitchTicketJob;
import com.bytedance.sdk.account.mobile.thread.MobilePassAuthThread;
import com.bytedance.sdk.account.mobile.thread.MobileQuickAuthThread;
import com.bytedance.sdk.account.mobile.thread.RefreshCaptchaApiThread;
import com.bytedance.sdk.account.mobile.thread.VerifyDeviceThread;
import com.bytedance.sdk.account.mobile.thread.call.MobilePassAuthCallback;
import com.bytedance.sdk.account.mobile.thread.call.MobileQuickAuthCallback;
import com.bytedance.sdk.account.mobile.thread.call.RefreshCaptchaCallback;
import com.bytedance.sdk.account.mobile.thread.call.VerifyDeviceCallBack;
import com.ss.android.account.TTAccountInit;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class BDAccountLegacyApiImpl implements IBDAccountLegacyApi {
    private static volatile IBDAccountLegacyApi sInstance;
    private Context mContext = TTAccountInit.getConfig().getApplicationContext();

    private BDAccountLegacyApiImpl() {
    }

    public static IBDAccountLegacyApi instance() {
        if (sInstance == null) {
            synchronized (BDAccountLegacyApiImpl.class) {
                if (sInstance == null) {
                    sInstance = new BDAccountLegacyApiImpl();
                }
            }
        }
        return sInstance;
    }

    @Override // com.bytedance.sdk.account.legacy.IBDAccountLegacyApi
    public void refreshCaptcha(RefreshCaptchaCallback refreshCaptchaCallback) {
        RefreshCaptchaApiThread.refreshCaptcha(this.mContext, refreshCaptchaCallback).start();
    }

    @Override // com.bytedance.sdk.account.legacy.IBDAccountLegacyApi
    @Deprecated
    public void refreshCaptcha(int i, RefreshCaptchaCallback refreshCaptchaCallback) {
        RefreshCaptchaApiThread.refreshCaptcha(this.mContext, i, refreshCaptchaCallback).start();
    }

    @Override // com.bytedance.sdk.account.legacy.IBDAccountLegacyApi
    public void verifyDevice(VerifyDeviceCallBack verifyDeviceCallBack) {
        VerifyDeviceThread.verifyDevice(this.mContext, verifyDeviceCallBack).start();
    }

    @Override // com.bytedance.sdk.account.legacy.IBDAccountLegacyApi
    public void mobilePassAuth(String str, String str2, String str3, String str4, MobilePassAuthCallback mobilePassAuthCallback) {
        MobilePassAuthThread.passAuth(this.mContext, str, str2, str3, str4, mobilePassAuthCallback).start();
    }

    @Override // com.bytedance.sdk.account.legacy.IBDAccountLegacyApi
    public void mobileQuickAuth(String str, String str2, String str3, MobileQuickAuthCallback mobileQuickAuthCallback) {
        MobileQuickAuthThread.quickAuth(this.mContext, str, str2, str3, mobileQuickAuthCallback).start();
    }

    @Override // com.bytedance.sdk.account.legacy.IBDAccountLegacyApi
    public void mobileQuickAuth(String str, String str2, String str3, Map<String, String> map, MobileQuickAuthCallback mobileQuickAuthCallback) {
        MobileQuickAuthThread.quickAuth(this.mContext, str, str2, str3, map, mobileQuickAuthCallback).start();
    }

    @Override // com.bytedance.sdk.account.legacy.IBDAccountLegacyApi
    public void switchTicket(String str, SwitchTicketCallback switchTicketCallback) {
        SwitchTicketJob.switchTicket(this.mContext, str, switchTicketCallback).start();
    }

    @Override // com.bytedance.sdk.account.legacy.IBDAccountLegacyApi
    public void checkEnv(int i, CheckEvnCallback checkEvnCallback) {
        CheckEnvJob.checkEnv(this.mContext, i, checkEvnCallback).start();
    }

    @Override // com.bytedance.sdk.account.legacy.IBDAccountLegacyApi
    public void getLoginDevices(GetLoginDevicesCallback getLoginDevicesCallback) {
        GetLoginDevicesJob.getLoginDevices(this.mContext, getLoginDevicesCallback).start();
    }

    @Override // com.bytedance.sdk.account.legacy.IBDAccountLegacyApi
    public void deleteDevice(String str, DeleteDeviceCallback deleteDeviceCallback) {
        DeleteDeviceJob.deleteDevice(this.mContext, str, deleteDeviceCallback).start();
    }
}
