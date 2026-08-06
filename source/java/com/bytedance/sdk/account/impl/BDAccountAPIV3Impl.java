package com.bytedance.sdk.account.impl;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.account.CommonCallBack;
import com.bytedance.sdk.account.api.IBDAccountAPIV3;
import com.bytedance.sdk.account.api.call.AbsApiCall;
import com.bytedance.sdk.account.api.call.BaseApiResponse;
import com.bytedance.sdk.account.api.call.CheckMobileRegisterResponse;
import com.bytedance.sdk.account.api.call.UserApiResponse;
import com.bytedance.sdk.account.api.callback.AuthTicketCallback;
import com.bytedance.sdk.account.api.callback.CanChainQuickLoginCallback;
import com.bytedance.sdk.account.api.callback.CanDeviceOneLoginCallback;
import com.bytedance.sdk.account.api.callback.CancelCloseAccountCallback;
import com.bytedance.sdk.account.api.callback.CancelDoCallback;
import com.bytedance.sdk.account.api.callback.CancelIndexCallback;
import com.bytedance.sdk.account.api.callback.CancelPostCallback;
import com.bytedance.sdk.account.api.callback.CheckCodeCallback;
import com.bytedance.sdk.account.api.callback.CheckMobileUnusableCallback;
import com.bytedance.sdk.account.api.callback.CheckPwdCallback;
import com.bytedance.sdk.account.api.callback.DeviceOneLoginContinueCallback;
import com.bytedance.sdk.account.api.callback.GetAvailableWaysCallback;
import com.bytedance.sdk.account.api.callback.LoginByTicketCallback;
import com.bytedance.sdk.account.api.callback.MobileHasSetPasswordCallback;
import com.bytedance.sdk.account.api.callback.SafeVerifyCallback;
import com.bytedance.sdk.account.api.callback.TicketResetPasswordCallback;
import com.bytedance.sdk.account.api.callback.UpdatePwdCallback;
import com.bytedance.sdk.account.api.response.CanDeviceOneLoginResponse;
import com.bytedance.sdk.account.job.CanDeviceOneLoginJob;
import com.bytedance.sdk.account.job.CancelCloseAccountJob;
import com.bytedance.sdk.account.job.CancelDoJob;
import com.bytedance.sdk.account.job.CancelIndexJob;
import com.bytedance.sdk.account.job.CancelPostJob;
import com.bytedance.sdk.account.job.CheckCodeJob;
import com.bytedance.sdk.account.job.CheckMobileUnusableJob;
import com.bytedance.sdk.account.job.CheckPwdJob;
import com.bytedance.sdk.account.job.DeviceOneLoginContinueJob;
import com.bytedance.sdk.account.job.GetAuthTicketJob;
import com.bytedance.sdk.account.job.GetAvailableWaysJob;
import com.bytedance.sdk.account.job.HistoryMobileCardLoginJob;
import com.bytedance.sdk.account.job.LoginByTicketJob;
import com.bytedance.sdk.account.job.MaskMobileOneLoginJob;
import com.bytedance.sdk.account.job.MobileHasSetPasswordJob;
import com.bytedance.sdk.account.job.QuickAuthLoginJob;
import com.bytedance.sdk.account.job.QuickValidateMobileLoginJob;
import com.bytedance.sdk.account.job.SafeVerifyJob;
import com.bytedance.sdk.account.job.TicketResetPasswordJob;
import com.bytedance.sdk.account.job.UpdatePwdJob;
import com.bytedance.sdk.account.job.VerifyTickerLoginJob;
import com.bytedance.sdk.account.mobile.thread.BindLoginThread;
import com.bytedance.sdk.account.mobile.thread.BindMobileApiThread;
import com.bytedance.sdk.account.mobile.thread.BindMobileNoPassApiThread;
import com.bytedance.sdk.account.mobile.thread.ChangeMobileNumApiThread;
import com.bytedance.sdk.account.mobile.thread.ChangePasswordApiThread;
import com.bytedance.sdk.account.mobile.thread.CheckMobileRegisterApiThread;
import com.bytedance.sdk.account.mobile.thread.EmailLoginApiThread;
import com.bytedance.sdk.account.mobile.thread.LoginApiThread;
import com.bytedance.sdk.account.mobile.thread.OneBindMobileApiThread;
import com.bytedance.sdk.account.mobile.thread.OneForceBindLoginApiThread;
import com.bytedance.sdk.account.mobile.thread.QuickLoginApiThread;
import com.bytedance.sdk.account.mobile.thread.QuickLoginContinueApiThread;
import com.bytedance.sdk.account.mobile.thread.QuickLoginOnlyApiThread;
import com.bytedance.sdk.account.mobile.thread.RecentOneLoginThread;
import com.bytedance.sdk.account.mobile.thread.RegisterApiThread;
import com.bytedance.sdk.account.mobile.thread.ResetPasswordApiThread;
import com.bytedance.sdk.account.mobile.thread.SendCodeApiThread;
import com.bytedance.sdk.account.mobile.thread.SendVoiceCodeApiThread;
import com.bytedance.sdk.account.mobile.thread.SetpassThread;
import com.bytedance.sdk.account.mobile.thread.UnbindMobileApiThread;
import com.bytedance.sdk.account.mobile.thread.UserPasswordLoginApiThread;
import com.bytedance.sdk.account.mobile.thread.ValidateCodeThread;
import com.bytedance.sdk.account.mobile.thread.call.BindLoginCallback;
import com.bytedance.sdk.account.mobile.thread.call.BindMobileCallback;
import com.bytedance.sdk.account.mobile.thread.call.ChangeMobileNumCallback;
import com.bytedance.sdk.account.mobile.thread.call.ChangePasswordCallback;
import com.bytedance.sdk.account.mobile.thread.call.EmailLoginQueryCallback;
import com.bytedance.sdk.account.mobile.thread.call.LoginQueryCallback;
import com.bytedance.sdk.account.mobile.thread.call.OneBindMobileCallback;
import com.bytedance.sdk.account.mobile.thread.call.OneForceBindMobileCallback;
import com.bytedance.sdk.account.mobile.thread.call.QuickLoginCallback;
import com.bytedance.sdk.account.mobile.thread.call.QuickLoginContinueCallback;
import com.bytedance.sdk.account.mobile.thread.call.QuickLoginOnlyCallback;
import com.bytedance.sdk.account.mobile.thread.call.RecentOneLoginCallback;
import com.bytedance.sdk.account.mobile.thread.call.RegisterCallback;
import com.bytedance.sdk.account.mobile.thread.call.ResetPasswordCallback;
import com.bytedance.sdk.account.mobile.thread.call.SendCodeCallback;
import com.bytedance.sdk.account.mobile.thread.call.SetPassCall;
import com.bytedance.sdk.account.mobile.thread.call.UnbindMobileCallback;
import com.bytedance.sdk.account.mobile.thread.call.UserPasswordLoginQueryCallback;
import com.bytedance.sdk.account.mobile.thread.call.ValidateCodeCallBack;
import com.bytedance.sdk.account.save.BDSaveImpl;
import com.bytedance.sdk.account.save.SaveService;
import com.bytedance.sdk.account.save.callback.DeleteCallback;
import com.bytedance.sdk.account.save.callback.QueryCallback;
import com.bytedance.sdk.account.save.entity.LoginInfo;
import com.bytedance.sdk.account.save.entity.LoginType;
import com.bytedance.sdk.account.sso.ChainLoginThread;
import com.bytedance.sdk.account.sso.CheckChainLoginThread;
import com.ss.android.account.TTAccountInit;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class BDAccountAPIV3Impl implements IBDAccountAPIV3 {
    private static volatile IBDAccountAPIV3 sInstance;
    private Context mContext = TTAccountInit.getConfig().getApplicationContext();

    private BDAccountAPIV3Impl() {
    }

    public static IBDAccountAPIV3 instance() {
        if (sInstance == null) {
            synchronized (BDAccountAPIV3Impl.class) {
                if (sInstance == null) {
                    sInstance = new BDAccountAPIV3Impl();
                }
            }
        }
        return sInstance;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void sendCodeForLogin(String str, SendCodeCallback sendCodeCallback) {
        SendCodeApiThread.sendCode(this.mContext, str, null, 24, sendCodeCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void sendCodeForBind(String str, SendCodeCallback sendCodeCallback) {
        SendCodeApiThread.sendCode(this.mContext, str, null, 8, sendCodeCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void sendCode(String str, String str2, int i, SendCodeCallback sendCodeCallback) {
        SendCodeApiThread.sendCode(this.mContext, str, str2, i, sendCodeCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void sendCode2(String str, int i, SendCodeCallback sendCodeCallback) {
        SendCodeApiThread.sendCode(this.mContext, str, null, i, sendCodeCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void sendCode2(String str, int i, Map<String, String> map, SendCodeCallback sendCodeCallback) {
        SendCodeApiThread.sendCode(this.mContext, str, null, i, 0, null, -1, 0, null, null, map, sendCodeCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void sendCode(String str, String str2, int i, int i2, SendCodeCallback sendCodeCallback) {
        SendCodeApiThread.sendCode(this.mContext, str, str2, i, i2, -1, sendCodeCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void sendCode2(String str, int i, int i2, SendCodeCallback sendCodeCallback) {
        SendCodeApiThread.sendCode(this.mContext, str, null, i, i2, -1, sendCodeCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void sendCode(String str, String str2, int i, int i2, int i3, SendCodeCallback sendCodeCallback) {
        SendCodeApiThread.sendCode(this.mContext, str, str2, i, i2, i3, sendCodeCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void sendCode2(String str, int i, int i2, int i3, SendCodeCallback sendCodeCallback) {
        SendCodeApiThread.sendCode(this.mContext, str, null, i, i2, i3, sendCodeCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void sendCode(String str, String str2, int i, int i2, String str3, int i3, int i4, SendCodeCallback sendCodeCallback) {
        SendCodeApiThread.sendCode(this.mContext, str, str2, i, i2, str3, i3, i4, sendCodeCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void sendCode2(String str, int i, int i2, String str2, int i3, int i4, SendCodeCallback sendCodeCallback) {
        SendCodeApiThread.sendCode(this.mContext, str, null, i, i2, str2, i3, i4, sendCodeCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void sendCode(String str, String str2, int i, int i2, String str3, int i3, int i4, String str4, String str5, SendCodeCallback sendCodeCallback) {
        SendCodeApiThread.sendCode(this.mContext, str, str2, i, i2, str3, i3, i4, str4, str5, sendCodeCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void sendCode2(String str, int i, int i2, String str2, int i3, int i4, String str3, String str4, SendCodeCallback sendCodeCallback) {
        SendCodeApiThread.sendCode(this.mContext, str, null, i, i2, str2, i3, i4, str3, str4, sendCodeCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void sendCode(String str, String str2, String str3, int i, SendCodeCallback sendCodeCallback) {
        SendCodeApiThread.sendCode(this.mContext, str, str2, str3, i, sendCodeCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void sendCode2(String str, String str2, int i, SendCodeCallback sendCodeCallback) {
        SendCodeApiThread.sendCode(this.mContext, str, str2, null, i, sendCodeCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void sendCode(String str, String str2, int i, int i2, String str3, int i3, int i4, String str4, String str5, Map map, SendCodeCallback sendCodeCallback) {
        SendCodeApiThread.sendCode(this.mContext, str, str2, i, i2, str3, i3, i4, str4, str5, map, sendCodeCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void sendCode2(String str, int i, int i2, String str2, int i3, int i4, String str3, String str4, Map map, SendCodeCallback sendCodeCallback) {
        SendCodeApiThread.sendCode(this.mContext, str, null, i, i2, str2, i3, i4, str3, str4, map, sendCodeCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void sendCode(int i, String str, String str2, int i2, int i3, String str3, String str4, String str5, SendCodeCallback sendCodeCallback) {
        SendCodeApiThread.sendCode(this.mContext, i, str, str2, i2, i3, str3, str4, str5, sendCodeCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void sendVoiceCode(String str, String str2, int i, SendCodeCallback sendCodeCallback) {
        SendVoiceCodeApiThread.sendVoiceCode(this.mContext, str, str2, i, (Map<String, String>) null, sendCodeCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void sendVoiceCode(String str, String str2, int i, Map<String, String> map, SendCodeCallback sendCodeCallback) {
        SendVoiceCodeApiThread.sendVoiceCode(this.mContext, str, str2, i, map, sendCodeCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void sendVoiceCode(String str, String str2, int i, int i2, SendCodeCallback sendCodeCallback) {
        SendVoiceCodeApiThread.sendVoiceCode(this.mContext, str, str2, i, i2, null, sendCodeCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void sendVoiceCode(String str, String str2, int i, int i2, Map<String, String> map, SendCodeCallback sendCodeCallback) {
        SendVoiceCodeApiThread.sendVoiceCode(this.mContext, str, str2, i, i2, map, sendCodeCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void register(String str, String str2, String str3, String str4, RegisterCallback registerCallback) {
        SaveService.cacheLoginInfo(2, str);
        RegisterApiThread.register(this.mContext, str, str2, str3, str4, registerCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void login(String str, String str2, String str3, LoginQueryCallback loginQueryCallback) {
        login(str, str2, str3, null, loginQueryCallback);
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void login(String str, String str2, String str3, Map<String, String> map, LoginQueryCallback loginQueryCallback) {
        SaveService.cacheLoginInfo(3, str);
        LoginApiThread.login(this.mContext, str, str2, str3, map, loginQueryCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void quickLogin(String str, String str2, String str3, QuickLoginCallback quickLoginCallback) {
        quickLogin(str, str2, null, str3, quickLoginCallback);
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void quickLogin(String str, String str2, Integer num, String str3, QuickLoginCallback quickLoginCallback) {
        quickLogin(str, str2, num, str3, null, quickLoginCallback);
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void quickLogin(String str, String str2, Integer num, String str3, Map<String, String> map, QuickLoginCallback quickLoginCallback) {
        SaveService.cacheLoginInfo(2, str);
        QuickLoginApiThread.quickLogin(this.mContext, str, str2, num, str3, map, quickLoginCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void quickLoginOnly(String str, String str2, String str3, QuickLoginOnlyCallback quickLoginOnlyCallback) {
        quickLoginOnly(str, str2, str3, null, quickLoginOnlyCallback);
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void quickLoginOnly(String str, String str2, String str3, Map<String, String> map, QuickLoginOnlyCallback quickLoginOnlyCallback) {
        SaveService.cacheLoginInfo(2, str);
        QuickLoginOnlyApiThread.quickLoginOnly(this.mContext, str, str2, str3, map, quickLoginOnlyCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void quickLoginContinue(String str, String str2, QuickLoginContinueCallback quickLoginContinueCallback) {
        quickLoginContinue(str, str2, null, quickLoginContinueCallback);
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void quickLoginContinue(String str, String str2, Map<String, String> map, QuickLoginContinueCallback quickLoginContinueCallback) {
        SaveService.cacheLoginInfo(2, str);
        QuickLoginContinueApiThread.quickLoginContinue(this.mContext, str, str2, map, quickLoginContinueCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void quickLoginContinue(String str, String str2, int i, Map map, QuickLoginContinueCallback quickLoginContinueCallback) {
        SaveService.cacheLoginInfo(2, str);
        QuickLoginContinueApiThread.quickLoginContinue(this.mContext, str, str2, i, map, quickLoginContinueCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void resetPassword(String str, String str2, String str3, String str4, ResetPasswordCallback resetPasswordCallback) {
        resetPassword(str, str2, str3, str4, true, resetPasswordCallback);
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void resetPassword(String str, String str2, String str3, String str4, boolean z, ResetPasswordCallback resetPasswordCallback) {
        resetPassword(str, str2, str3, str4, z, null, resetPasswordCallback);
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void resetPassword(String str, String str2, String str3, String str4, boolean z, Map<String, String> map, ResetPasswordCallback resetPasswordCallback) {
        ResetPasswordApiThread.resetPassword(this.mContext, str, str2, str3, str4, z, map, resetPasswordCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void bindMobile(String str, String str2, String str3, String str4, BindMobileCallback bindMobileCallback) {
        bindMobile(str, str2, str3, str4, 0, bindMobileCallback);
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void bindMobile(String str, String str2, String str3, String str4, int i, BindMobileCallback bindMobileCallback) {
        bindMobile(str, str2, str3, str4, i, null, bindMobileCallback);
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void bindMobile(String str, String str2, String str3, String str4, int i, Map<String, String> map, BindMobileCallback bindMobileCallback) {
        BindMobileApiThread.bindMobile(this.mContext, str, str2, str3, str4, i, map, bindMobileCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void bindMobileNoPassword(String str, String str2, String str3, int i, BindMobileCallback bindMobileCallback) {
        BindMobileNoPassApiThread.bindMobileNoPass(this.mContext, str, str2, null, str3, i, bindMobileCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void bindMobileNoPassword(String str, String str2, String str3, int i, String str4, BindMobileCallback bindMobileCallback) {
        bindMobileNoPassword(str, str2, str3, i, str4, null, null, bindMobileCallback);
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void bindMobileNoPassword(String str, String str2, String str3, int i, String str4, String str5, Map<String, String> map, BindMobileCallback bindMobileCallback) {
        BindMobileNoPassApiThread.bindMobileNoPass(this.mContext, str, str2, null, str3, i, str4, str5, map, bindMobileCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void unbindMobile(String str, UnbindMobileCallback unbindMobileCallback) {
        UnbindMobileApiThread.unbindMobile(this.mContext, str, unbindMobileCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    @Deprecated
    public void accountLogin(String str, String str2, String str3, int i, UserPasswordLoginQueryCallback userPasswordLoginQueryCallback) {
        UserPasswordLoginApiThread.userPasswordLogin(this.mContext, null, null, null, str, str2, null, str3, i, userPasswordLoginQueryCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void accountUserNameLogin(String str, String str2, String str3, UserPasswordLoginQueryCallback userPasswordLoginQueryCallback) {
        accountUserNameLogin(str, str2, str3, null, userPasswordLoginQueryCallback);
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void accountUserNameLogin(String str, String str2, String str3, Map<String, String> map, UserPasswordLoginQueryCallback userPasswordLoginQueryCallback) {
        SaveService.cacheLoginInfo(5, str);
        UserPasswordLoginApiThread.userPasswordLogin(this.mContext, null, null, str, null, str2, null, str3, 0, map, userPasswordLoginQueryCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void accountMobileLogin(String str, String str2, String str3, UserPasswordLoginQueryCallback userPasswordLoginQueryCallback) {
        accountMobileLogin(str, str2, str3, null, userPasswordLoginQueryCallback);
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void accountMobileLogin(String str, String str2, String str3, Map<String, String> map, UserPasswordLoginQueryCallback userPasswordLoginQueryCallback) {
        SaveService.cacheLoginInfo(3, str);
        UserPasswordLoginApiThread.userPasswordLogin(this.mContext, str, null, null, null, str2, null, str3, 0, map, userPasswordLoginQueryCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void requestValidateSMSCode(String str, int i, boolean z, ValidateCodeCallBack validateCodeCallBack) {
        ValidateCodeThread.validateCode(this.mContext, str, i, z, validateCodeCallBack).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void requestValidateSMSCode(String str, int i, boolean z, int i2, String str2, ValidateCodeCallBack validateCodeCallBack) {
        ValidateCodeThread.validateCode(this.mContext, str, i, z, i2, str2, validateCodeCallBack).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void requestValidateSMSCode(String str, int i, boolean z, Map<String, String> map, ValidateCodeCallBack validateCodeCallBack) {
        ValidateCodeThread.validateCode(this.mContext, str, i, z, map, validateCodeCallBack).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void requestValidateSMSCode(String str, int i, boolean z, int i2, String str2, Map<String, String> map, ValidateCodeCallBack validateCodeCallBack) {
        ValidateCodeThread.validateCode(this.mContext, str, i, z, i2, str2, map, validateCodeCallBack).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void setPassword(String str, String str2, SetPassCall setPassCall) {
        SetpassThread.setPassword(this.mContext, str, str2, setPassCall).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void setPassword(String str, String str2, Map<String, String> map, SetPassCall setPassCall) {
        SetpassThread.setPassword(this.mContext, str, str2, map, setPassCall).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void checkCode(String str, String str2, int i, CheckCodeCallback checkCodeCallback) {
        CheckCodeJob.checkCode(this.mContext, str, str2, i, checkCodeCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void checkCode(String str, String str2, int i, Map map, CheckCodeCallback checkCodeCallback) {
        CheckCodeJob.checkCode(this.mContext, str, str2, i, map, checkCodeCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void ticketResetPassword(String str, String str2, TicketResetPasswordCallback ticketResetPasswordCallback) {
        TicketResetPasswordJob.resetPassword(this.mContext, str, str2, ticketResetPasswordCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void ticketResetPassword(String str, String str2, Map<String, String> map, TicketResetPasswordCallback ticketResetPasswordCallback) {
        TicketResetPasswordJob.resetPassword(this.mContext, str, str2, map, ticketResetPasswordCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void changePassword(String str, String str2, String str3, ChangePasswordCallback changePasswordCallback) {
        ChangePasswordApiThread.changePassword(this.mContext, str, str2, str3, changePasswordCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void changePassword(String str, String str2, String str3, Map<String, String> map, ChangePasswordCallback changePasswordCallback) {
        ChangePasswordApiThread.changePassword(this.mContext, str, str2, str3, map, changePasswordCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void changeMobileNum(String str, String str2, String str3, String str4, Map map, ChangeMobileNumCallback changeMobileNumCallback) {
        ChangeMobileNumApiThread.changeMobilenum(this.mContext, str, str2, str3, str4, map, changeMobileNumCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void changeMobileNum(String str, String str2, String str3, String str4, ChangeMobileNumCallback changeMobileNumCallback) {
        ChangeMobileNumApiThread.changeMobilenum(this.mContext, str, str2, str3, str4, changeMobileNumCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void changeMobileNum(String str, String str2, String str3, ChangeMobileNumCallback changeMobileNumCallback) {
        ChangeMobileNumApiThread.changeMobilenum(this.mContext, str, str2, str3, changeMobileNumCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void cancelPost(String str, String str2, String str3, String str4, CancelPostCallback cancelPostCallback) {
        CancelPostJob.cancelPost(this.mContext, str, str2, str3, str4, cancelPostCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void cancelDo(boolean z, CancelDoCallback cancelDoCallback) {
        CancelDoJob.cancelDo(this.mContext, z, cancelDoCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void cancelIndex(CancelIndexCallback cancelIndexCallback) {
        CancelIndexJob.cancelIndex(this.mContext, cancelIndexCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void checkPwd(String str, CheckPwdCallback checkPwdCallback) {
        CheckPwdJob.checkPwd(this.mContext, str, checkPwdCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void checkPwd(String str, Map<String, String> map, CheckPwdCallback checkPwdCallback) {
        CheckPwdJob.checkPwd(this.mContext, str, map, checkPwdCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void updatePwd(String str, String str2, UpdatePwdCallback updatePwdCallback) {
        UpdatePwdJob.updatePwd(this.mContext, str, str2, updatePwdCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void updatePwd(String str, String str2, Map<String, String> map, UpdatePwdCallback updatePwdCallback) {
        UpdatePwdJob.updatePwd(this.mContext, str, str2, map, updatePwdCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void cancelCloseAccountWithToken(String str, CancelCloseAccountCallback cancelCloseAccountCallback) {
        CancelCloseAccountJob.cancelCloseAccountWithToken(this.mContext, str, cancelCloseAccountCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void checkMobileUnusable(String str, String str2, String str3, CheckMobileUnusableCallback checkMobileUnusableCallback) {
        CheckMobileUnusableJob.checkMobileUnusable(this.mContext, str, str2, str3, checkMobileUnusableCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void checkMobileRegister(String str, AbsApiCall<CheckMobileRegisterResponse> absApiCall) {
        CheckMobileRegisterApiThread.checkMobileRegister(this.mContext, str, absApiCall).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void mobileHasSetPassword(String str, String str2, MobileHasSetPasswordCallback mobileHasSetPasswordCallback) {
        MobileHasSetPasswordJob.mobileHasSetPassword(this.mContext, str, str2, mobileHasSetPasswordCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void getAuthTicket(String str, String str2, AuthTicketCallback authTicketCallback) {
        GetAuthTicketJob.getAuthTicket(this.mContext, str, str2, authTicketCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void loginByAuthTicket(String str, LoginByTicketCallback loginByTicketCallback) {
        SaveService.cacheLoginInfo(1, null);
        LoginByTicketJob.loginByAuthTicket(this.mContext, str, loginByTicketCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void quickAuthlogin(String str, String str2, Integer num, LoginByTicketCallback loginByTicketCallback) {
        SaveService.cacheLoginInfo(1, null);
        QuickAuthLoginJob.quickAuthlogin(this.mContext, str, str2, num, null, null, loginByTicketCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void quickAuthlogin(String str, String str2, LoginByTicketCallback loginByTicketCallback) {
        SaveService.cacheLoginInfo(1, null);
        QuickAuthLoginJob.quickAuthlogin(this.mContext, str, str2, null, null, null, loginByTicketCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void quickAuthlogin(String str, String str2, String str3, Map<String, String> map, LoginByTicketCallback loginByTicketCallback) {
        SaveService.cacheLoginInfo(1, null);
        QuickAuthLoginJob.quickAuthlogin(this.mContext, str, str2, null, str3, map, loginByTicketCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void quickAuthLoginOnly(String str, String str2, Map<String, String> map, LoginByTicketCallback loginByTicketCallback) {
        SaveService.cacheLoginInfo(1, null);
        QuickAuthLoginJob.quickAuthloginOnly(this.mContext, str, str2, map, loginByTicketCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void quickAuthLoginContinue(String str, int i, Map map, LoginByTicketCallback loginByTicketCallback) {
        SaveService.cacheLoginInfo(1, null);
        QuickAuthLoginJob.quickAuthloginContinue(this.mContext, str, i, map, loginByTicketCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void quickAuthLoginContinue(String str, Map map, LoginByTicketCallback loginByTicketCallback) {
        SaveService.cacheLoginInfo(1, null);
        QuickAuthLoginJob.quickAuthloginContinue(this.mContext, str, -1, map, loginByTicketCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void quickValidateMobileLogin(String str, String str2, String str3, String str4, Map<String, String> map, CommonCallBack<UserApiResponse> commonCallBack) {
        SaveService.cacheLoginInfo(1, null);
        QuickValidateMobileLoginJob.quickValidateMobileLogin(this.mContext, str, str2, str3, str4, map, commonCallBack).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void oneBindMobile(String str, String str2, String str3, int i, Map<String, String> map, OneBindMobileCallback oneBindMobileCallback) {
        OneBindMobileApiThread.oneBindMobile(this.mContext, str, str2, str3, i, map, oneBindMobileCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void oneForceBindLogin(String str, String str2, String str3, int i, OneForceBindMobileCallback oneForceBindMobileCallback) {
        oneForceBindLogin(str, str2, str3, i, null, null, oneForceBindMobileCallback);
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void oneForceBindLogin(String str, String str2, String str3, int i, String str4, Map<String, String> map, OneForceBindMobileCallback oneForceBindMobileCallback) {
        OneForceBindLoginApiThread.oneForceBindLogin(this.mContext, str, str2, str3, i, str4, map, oneForceBindMobileCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void chainLogin(String str, String str2, Map map, AbsApiCall<UserApiResponse> absApiCall) {
        ChainLoginThread.chainLogin(this.mContext, str, str2, map, absApiCall).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void canChainLogin(CanChainQuickLoginCallback canChainQuickLoginCallback) {
        CheckChainLoginThread.canChainLogin(this.mContext, canChainQuickLoginCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void maskMobileOneLogin(String str, Map<String, String> map, CommonCallBack<UserApiResponse> commonCallBack) {
        MaskMobileOneLoginJob.maskQuickLogin(this.mContext, str, map, commonCallBack).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void canDeviceOneLogin(String str, boolean z, String str2, Integer num, Long l, String str3, CanDeviceOneLoginCallback canDeviceOneLoginCallback) {
        CanDeviceOneLoginJob.canDeviceOneLogin(this.mContext, str, z, str2, num, l, str3, canDeviceOneLoginCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void canDeviceOneLogin(final CanDeviceOneLoginCallback canDeviceOneLoginCallback) {
        BDSaveImpl.instance().queryLatest(new QueryCallback() { // from class: com.bytedance.sdk.account.impl.BDAccountAPIV3Impl.1
            @Override // com.bytedance.sdk.account.save.callback.QueryCallback
            public void onSuccess(LoginInfo loginInfo) {
                int type = loginInfo.getType();
                if (type == 7) {
                    SaveService.deleteLatest(new DeleteCallback() { // from class: com.bytedance.sdk.account.impl.BDAccountAPIV3Impl.1.1
                        @Override // com.bytedance.sdk.account.save.callback.DeleteCallback
                        public void onSuccess() {
                            BDAccountAPIV3Impl.this.canDeviceOneLogin(canDeviceOneLoginCallback);
                        }

                        @Override // com.bytedance.sdk.account.save.callback.DeleteCallback
                        public void onError(int i, String str) {
                            CanDeviceOneLoginResponse canDeviceOneLoginResponse = new CanDeviceOneLoginResponse(false, BaseApiResponse.API_CAN_DEVICE_ONE_LOGIN);
                            canDeviceOneLoginResponse.error = i;
                            canDeviceOneLoginResponse.mDetailErrorMsg = str;
                            canDeviceOneLoginCallback.onError(canDeviceOneLoginResponse, i);
                        }
                    });
                    return;
                }
                int serverType = LoginType.serverType(type);
                String info = type == 6 ? loginInfo.getInfo() : null;
                String valueOf = String.valueOf(loginInfo.getUid());
                String secUid = loginInfo.getSecUid();
                if (!TextUtils.isEmpty(secUid)) {
                    CanDeviceOneLoginJob.canDeviceOneLogin(BDAccountAPIV3Impl.this.mContext, secUid, true, null, Integer.valueOf(serverType), Long.valueOf(loginInfo.getTime()), info, canDeviceOneLoginCallback).start();
                } else {
                    CanDeviceOneLoginJob.canDeviceOneLogin(BDAccountAPIV3Impl.this.mContext, valueOf, false, null, Integer.valueOf(serverType), Long.valueOf(loginInfo.getTime()), info, canDeviceOneLoginCallback).start();
                }
            }

            @Override // com.bytedance.sdk.account.save.callback.QueryCallback
            public void onError(int i, String str) {
                CanDeviceOneLoginResponse canDeviceOneLoginResponse = new CanDeviceOneLoginResponse(false, BaseApiResponse.API_CAN_DEVICE_ONE_LOGIN);
                canDeviceOneLoginResponse.error = i;
                canDeviceOneLoginResponse.mDetailErrorMsg = str;
                canDeviceOneLoginCallback.onError(canDeviceOneLoginResponse, i);
            }
        });
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void deviceOneLoginContinue(String str, DeviceOneLoginContinueCallback deviceOneLoginContinueCallback) {
        deviceOneLoginContinue(str, null, deviceOneLoginContinueCallback);
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void deviceOneLoginContinue(String str, Map<String, String> map, DeviceOneLoginContinueCallback deviceOneLoginContinueCallback) {
        SaveService.cacheLoginInfo(7, null);
        DeviceOneLoginContinueJob.deviceOneLoginContinue(this.mContext, str, map, deviceOneLoginContinueCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void recentOneLogin(String str, boolean z, String str2, Integer num, Long l, String str3, RecentOneLoginCallback recentOneLoginCallback) {
        recentOneLogin(str, z, str2, num, l, str3, null, recentOneLoginCallback);
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void recentOneLogin(String str, boolean z, String str2, Integer num, Long l, String str3, Map<String, String> map, RecentOneLoginCallback recentOneLoginCallback) {
        SaveService.cacheLoginInfo(7, null);
        RecentOneLoginThread.recentOneLogin(this.mContext, str, z, str2, num, l, str3, map, recentOneLoginCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void recentOneLogin(RecentOneLoginCallback recentOneLoginCallback) {
        recentOneLogin(null, recentOneLoginCallback);
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void recentOneLogin(final Map<String, String> map, final RecentOneLoginCallback recentOneLoginCallback) {
        BDSaveImpl.instance().queryLatest(new QueryCallback() { // from class: com.bytedance.sdk.account.impl.BDAccountAPIV3Impl.2
            @Override // com.bytedance.sdk.account.save.callback.QueryCallback
            public void onSuccess(LoginInfo loginInfo) {
                int type = loginInfo.getType();
                if (type == 7) {
                    SaveService.deleteLatest(new DeleteCallback() { // from class: com.bytedance.sdk.account.impl.BDAccountAPIV3Impl.2.1
                        @Override // com.bytedance.sdk.account.save.callback.DeleteCallback
                        public void onSuccess() {
                            BDAccountAPIV3Impl.this.recentOneLogin(map, recentOneLoginCallback);
                        }

                        @Override // com.bytedance.sdk.account.save.callback.DeleteCallback
                        public void onError(int i, String str) {
                            UserApiResponse userApiResponse = new UserApiResponse(false, BaseApiResponse.API_DEVICE_ONE_LOGIN);
                            userApiResponse.error = i;
                            userApiResponse.mDetailErrorMsg = str;
                            recentOneLoginCallback.onError(userApiResponse, i);
                        }
                    });
                    return;
                }
                int serverType = LoginType.serverType(type);
                String info = type == 6 ? loginInfo.getInfo() : null;
                String valueOf = String.valueOf(loginInfo.getUid());
                String secUid = loginInfo.getSecUid();
                if (!TextUtils.isEmpty(secUid)) {
                    RecentOneLoginThread.recentOneLogin(BDAccountAPIV3Impl.this.mContext, secUid, true, null, Integer.valueOf(serverType), Long.valueOf(loginInfo.getTime()), info, map, recentOneLoginCallback).start();
                } else {
                    RecentOneLoginThread.recentOneLogin(BDAccountAPIV3Impl.this.mContext, valueOf, false, null, Integer.valueOf(serverType), Long.valueOf(loginInfo.getTime()), info, map, recentOneLoginCallback).start();
                }
            }

            @Override // com.bytedance.sdk.account.save.callback.QueryCallback
            public void onError(int i, String str) {
                UserApiResponse userApiResponse = new UserApiResponse(false, BaseApiResponse.API_DEVICE_ONE_LOGIN);
                userApiResponse.error = i;
                userApiResponse.mDetailErrorMsg = str;
                recentOneLoginCallback.onError(userApiResponse, i);
            }
        });
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void bindLogin(String str, String str2, String str3, String str4, BindLoginCallback bindLoginCallback) {
        SaveService.cacheLoginInfo(2, str);
        BindLoginThread.bindLogin(this.mContext, str, str2, str3, str4, bindLoginCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void bindLogin(String str, String str2, String str3, String str4, Map map, BindLoginCallback bindLoginCallback) {
        SaveService.cacheLoginInfo(2, str);
        BindLoginThread.bindLogin(this.mContext, str, str2, str3, str4, map, bindLoginCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void loginWithEmail(String str, String str2, String str3, EmailLoginQueryCallback emailLoginQueryCallback) {
        loginWithEmail(str, str2, str3, null, emailLoginQueryCallback);
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void loginWithEmail(String str, String str2, String str3, Map<String, String> map, EmailLoginQueryCallback emailLoginQueryCallback) {
        SaveService.cacheLoginInfo(4, str);
        EmailLoginApiThread.emailLogin(this.mContext, str, str2, str3, map, emailLoginQueryCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void historyMobileCardLogin(String str, String[] strArr, Map<String, String> map, CommonCallBack<UserApiResponse> commonCallBack) {
        HistoryMobileCardLoginJob.mobileCardLogin(this.mContext, str, strArr, map, commonCallBack).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void safeVerify(String str, String str2, String str3, String str4, SafeVerifyCallback safeVerifyCallback) {
        safeVerify(str, str2, str3, str4, null, safeVerifyCallback);
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void safeVerify(String str, String str2, String str3, String str4, Map<String, String> map, SafeVerifyCallback safeVerifyCallback) {
        SafeVerifyJob.safeVerify(this.mContext, str, str2, str3, str4, map, safeVerifyCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void getAvailableWays(int i, String str, GetAvailableWaysCallback getAvailableWaysCallback) {
        GetAvailableWaysJob.getAvailableWays(this.mContext, i, str, getAvailableWaysCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountAPIV3
    public void loginByVerifyTicket(String str, String str2, Map<String, String> map, CommonCallBack<UserApiResponse> commonCallBack) {
        VerifyTickerLoginJob.loginByVerifyTicket(this.mContext, str, str2, map, commonCallBack).start();
    }
}
