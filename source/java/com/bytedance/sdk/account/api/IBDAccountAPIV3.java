package com.bytedance.sdk.account.api;

import com.bytedance.sdk.account.CommonCallBack;
import com.bytedance.sdk.account.api.call.AbsApiCall;
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
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface IBDAccountAPIV3 {
    public static final int DEFAULT_RESEND_TIME = 30;
    public static final int OP_ERROR_USER_EXIST = 1001;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface Scenario extends ISendCodeScenario {
    }

    @Deprecated
    void accountLogin(String str, String str2, String str3, int i, UserPasswordLoginQueryCallback userPasswordLoginQueryCallback);

    void accountMobileLogin(String str, String str2, String str3, UserPasswordLoginQueryCallback userPasswordLoginQueryCallback);

    void accountMobileLogin(String str, String str2, String str3, Map<String, String> map, UserPasswordLoginQueryCallback userPasswordLoginQueryCallback);

    void accountUserNameLogin(String str, String str2, String str3, UserPasswordLoginQueryCallback userPasswordLoginQueryCallback);

    void accountUserNameLogin(String str, String str2, String str3, Map<String, String> map, UserPasswordLoginQueryCallback userPasswordLoginQueryCallback);

    void bindLogin(String str, String str2, String str3, String str4, BindLoginCallback bindLoginCallback);

    void bindLogin(String str, String str2, String str3, String str4, Map map, BindLoginCallback bindLoginCallback);

    void bindMobile(String str, String str2, String str3, String str4, int i, BindMobileCallback bindMobileCallback);

    void bindMobile(String str, String str2, String str3, String str4, int i, Map<String, String> map, BindMobileCallback bindMobileCallback);

    void bindMobile(String str, String str2, String str3, String str4, BindMobileCallback bindMobileCallback);

    void bindMobileNoPassword(String str, String str2, String str3, int i, BindMobileCallback bindMobileCallback);

    void bindMobileNoPassword(String str, String str2, String str3, int i, String str4, BindMobileCallback bindMobileCallback);

    void bindMobileNoPassword(String str, String str2, String str3, int i, String str4, String str5, Map<String, String> map, BindMobileCallback bindMobileCallback);

    void canChainLogin(CanChainQuickLoginCallback canChainQuickLoginCallback);

    void canDeviceOneLogin(CanDeviceOneLoginCallback canDeviceOneLoginCallback);

    void canDeviceOneLogin(String str, boolean z, String str2, Integer num, Long l, String str3, CanDeviceOneLoginCallback canDeviceOneLoginCallback);

    void cancelCloseAccountWithToken(String str, CancelCloseAccountCallback cancelCloseAccountCallback);

    void cancelDo(boolean z, CancelDoCallback cancelDoCallback);

    void cancelIndex(CancelIndexCallback cancelIndexCallback);

    void cancelPost(String str, String str2, String str3, String str4, CancelPostCallback cancelPostCallback);

    void chainLogin(String str, String str2, Map map, AbsApiCall<UserApiResponse> absApiCall);

    void changeMobileNum(String str, String str2, String str3, ChangeMobileNumCallback changeMobileNumCallback);

    void changeMobileNum(String str, String str2, String str3, String str4, ChangeMobileNumCallback changeMobileNumCallback);

    void changeMobileNum(String str, String str2, String str3, String str4, Map map, ChangeMobileNumCallback changeMobileNumCallback);

    void changePassword(String str, String str2, String str3, ChangePasswordCallback changePasswordCallback);

    void changePassword(String str, String str2, String str3, Map<String, String> map, ChangePasswordCallback changePasswordCallback);

    void checkCode(String str, String str2, int i, CheckCodeCallback checkCodeCallback);

    void checkCode(String str, String str2, int i, Map map, CheckCodeCallback checkCodeCallback);

    void checkMobileRegister(String str, AbsApiCall<CheckMobileRegisterResponse> absApiCall);

    void checkMobileUnusable(String str, String str2, String str3, CheckMobileUnusableCallback checkMobileUnusableCallback);

    void checkPwd(String str, CheckPwdCallback checkPwdCallback);

    void checkPwd(String str, Map<String, String> map, CheckPwdCallback checkPwdCallback);

    void deviceOneLoginContinue(String str, DeviceOneLoginContinueCallback deviceOneLoginContinueCallback);

    void deviceOneLoginContinue(String str, Map<String, String> map, DeviceOneLoginContinueCallback deviceOneLoginContinueCallback);

    void getAuthTicket(String str, String str2, AuthTicketCallback authTicketCallback);

    void getAvailableWays(int i, String str, GetAvailableWaysCallback getAvailableWaysCallback);

    void historyMobileCardLogin(String str, String[] strArr, Map<String, String> map, CommonCallBack<UserApiResponse> commonCallBack);

    void login(String str, String str2, String str3, LoginQueryCallback loginQueryCallback);

    void login(String str, String str2, String str3, Map<String, String> map, LoginQueryCallback loginQueryCallback);

    void loginByAuthTicket(String str, LoginByTicketCallback loginByTicketCallback);

    void loginByVerifyTicket(String str, String str2, Map<String, String> map, CommonCallBack<UserApiResponse> commonCallBack);

    void loginWithEmail(String str, String str2, String str3, EmailLoginQueryCallback emailLoginQueryCallback);

    void loginWithEmail(String str, String str2, String str3, Map<String, String> map, EmailLoginQueryCallback emailLoginQueryCallback);

    void maskMobileOneLogin(String str, Map<String, String> map, CommonCallBack<UserApiResponse> commonCallBack);

    void mobileHasSetPassword(String str, String str2, MobileHasSetPasswordCallback mobileHasSetPasswordCallback);

    void oneBindMobile(String str, String str2, String str3, int i, Map<String, String> map, OneBindMobileCallback oneBindMobileCallback);

    void oneForceBindLogin(String str, String str2, String str3, int i, OneForceBindMobileCallback oneForceBindMobileCallback);

    void oneForceBindLogin(String str, String str2, String str3, int i, String str4, Map<String, String> map, OneForceBindMobileCallback oneForceBindMobileCallback);

    void quickAuthLoginContinue(String str, int i, Map map, LoginByTicketCallback loginByTicketCallback);

    void quickAuthLoginContinue(String str, Map map, LoginByTicketCallback loginByTicketCallback);

    void quickAuthLoginOnly(String str, String str2, Map<String, String> map, LoginByTicketCallback loginByTicketCallback);

    void quickAuthlogin(String str, String str2, LoginByTicketCallback loginByTicketCallback);

    void quickAuthlogin(String str, String str2, Integer num, LoginByTicketCallback loginByTicketCallback);

    void quickAuthlogin(String str, String str2, String str3, Map<String, String> map, LoginByTicketCallback loginByTicketCallback);

    void quickLogin(String str, String str2, Integer num, String str3, QuickLoginCallback quickLoginCallback);

    void quickLogin(String str, String str2, Integer num, String str3, Map<String, String> map, QuickLoginCallback quickLoginCallback);

    void quickLogin(String str, String str2, String str3, QuickLoginCallback quickLoginCallback);

    void quickLoginContinue(String str, String str2, int i, Map map, QuickLoginContinueCallback quickLoginContinueCallback);

    void quickLoginContinue(String str, String str2, QuickLoginContinueCallback quickLoginContinueCallback);

    void quickLoginContinue(String str, String str2, Map<String, String> map, QuickLoginContinueCallback quickLoginContinueCallback);

    void quickLoginOnly(String str, String str2, String str3, QuickLoginOnlyCallback quickLoginOnlyCallback);

    void quickLoginOnly(String str, String str2, String str3, Map<String, String> map, QuickLoginOnlyCallback quickLoginOnlyCallback);

    void quickValidateMobileLogin(String str, String str2, String str3, String str4, Map<String, String> map, CommonCallBack<UserApiResponse> commonCallBack);

    void recentOneLogin(RecentOneLoginCallback recentOneLoginCallback);

    void recentOneLogin(String str, boolean z, String str2, Integer num, Long l, String str3, RecentOneLoginCallback recentOneLoginCallback);

    void recentOneLogin(String str, boolean z, String str2, Integer num, Long l, String str3, Map<String, String> map, RecentOneLoginCallback recentOneLoginCallback);

    void recentOneLogin(Map<String, String> map, RecentOneLoginCallback recentOneLoginCallback);

    void register(String str, String str2, String str3, String str4, RegisterCallback registerCallback);

    void requestValidateSMSCode(String str, int i, boolean z, int i2, String str2, ValidateCodeCallBack validateCodeCallBack);

    void requestValidateSMSCode(String str, int i, boolean z, int i2, String str2, Map<String, String> map, ValidateCodeCallBack validateCodeCallBack);

    void requestValidateSMSCode(String str, int i, boolean z, ValidateCodeCallBack validateCodeCallBack);

    void requestValidateSMSCode(String str, int i, boolean z, Map<String, String> map, ValidateCodeCallBack validateCodeCallBack);

    void resetPassword(String str, String str2, String str3, String str4, ResetPasswordCallback resetPasswordCallback);

    void resetPassword(String str, String str2, String str3, String str4, boolean z, ResetPasswordCallback resetPasswordCallback);

    void resetPassword(String str, String str2, String str3, String str4, boolean z, Map<String, String> map, ResetPasswordCallback resetPasswordCallback);

    void safeVerify(String str, String str2, String str3, String str4, SafeVerifyCallback safeVerifyCallback);

    void safeVerify(String str, String str2, String str3, String str4, Map<String, String> map, SafeVerifyCallback safeVerifyCallback);

    void sendCode(int i, String str, String str2, int i2, int i3, String str3, String str4, String str5, SendCodeCallback sendCodeCallback);

    @Deprecated
    void sendCode(String str, String str2, int i, int i2, int i3, SendCodeCallback sendCodeCallback);

    @Deprecated
    void sendCode(String str, String str2, int i, int i2, SendCodeCallback sendCodeCallback);

    @Deprecated
    void sendCode(String str, String str2, int i, int i2, String str3, int i3, int i4, SendCodeCallback sendCodeCallback);

    @Deprecated
    void sendCode(String str, String str2, int i, int i2, String str3, int i3, int i4, String str4, String str5, SendCodeCallback sendCodeCallback);

    @Deprecated
    void sendCode(String str, String str2, int i, int i2, String str3, int i3, int i4, String str4, String str5, Map map, SendCodeCallback sendCodeCallback);

    @Deprecated
    void sendCode(String str, String str2, int i, SendCodeCallback sendCodeCallback);

    @Deprecated
    void sendCode(String str, String str2, String str3, int i, SendCodeCallback sendCodeCallback);

    void sendCode2(String str, int i, int i2, int i3, SendCodeCallback sendCodeCallback);

    void sendCode2(String str, int i, int i2, SendCodeCallback sendCodeCallback);

    void sendCode2(String str, int i, int i2, String str2, int i3, int i4, SendCodeCallback sendCodeCallback);

    void sendCode2(String str, int i, int i2, String str2, int i3, int i4, String str3, String str4, SendCodeCallback sendCodeCallback);

    void sendCode2(String str, int i, int i2, String str2, int i3, int i4, String str3, String str4, Map map, SendCodeCallback sendCodeCallback);

    void sendCode2(String str, int i, SendCodeCallback sendCodeCallback);

    void sendCode2(String str, int i, Map<String, String> map, SendCodeCallback sendCodeCallback);

    void sendCode2(String str, String str2, int i, SendCodeCallback sendCodeCallback);

    void sendCodeForBind(String str, SendCodeCallback sendCodeCallback);

    void sendCodeForLogin(String str, SendCodeCallback sendCodeCallback);

    void sendVoiceCode(String str, String str2, int i, int i2, SendCodeCallback sendCodeCallback);

    void sendVoiceCode(String str, String str2, int i, int i2, Map<String, String> map, SendCodeCallback sendCodeCallback);

    void sendVoiceCode(String str, String str2, int i, SendCodeCallback sendCodeCallback);

    void sendVoiceCode(String str, String str2, int i, Map<String, String> map, SendCodeCallback sendCodeCallback);

    void setPassword(String str, String str2, SetPassCall setPassCall);

    void setPassword(String str, String str2, Map<String, String> map, SetPassCall setPassCall);

    void ticketResetPassword(String str, String str2, TicketResetPasswordCallback ticketResetPasswordCallback);

    void ticketResetPassword(String str, String str2, Map<String, String> map, TicketResetPasswordCallback ticketResetPasswordCallback);

    @Deprecated
    void unbindMobile(String str, UnbindMobileCallback unbindMobileCallback);

    void updatePwd(String str, String str2, UpdatePwdCallback updatePwdCallback);

    void updatePwd(String str, String str2, Map<String, String> map, UpdatePwdCallback updatePwdCallback);
}
