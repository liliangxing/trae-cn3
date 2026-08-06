package com.bytedance.sdk.account;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.account.api.BDAccountEvent;
import com.bytedance.sdk.account.api.IBDAccount;
import com.bytedance.sdk.account.api.call.AbsApiCall;
import com.bytedance.sdk.account.api.call.BaseApiResponse;
import com.bytedance.sdk.account.api.call.LogoutApiResponse;
import com.bytedance.sdk.account.api.call.LogoutOthersApiResponse;
import com.bytedance.sdk.account.api.call.MultiLogoutApiResponse;
import com.bytedance.sdk.account.api.call.UserApiResponse;
import com.bytedance.sdk.account.api.callback.AccountRemoveCallback;
import com.bytedance.sdk.account.api.callback.BindEmailCallback;
import com.bytedance.sdk.account.api.callback.CheckCodeCallback;
import com.bytedance.sdk.account.api.callback.SwitchAuthCallback;
import com.bytedance.sdk.account.api.callback.TicketResetPasswordCallback;
import com.bytedance.sdk.account.api.callback.VerifyEmailCallback;
import com.bytedance.sdk.account.api.response.EmailChangeBindResponse;
import com.bytedance.sdk.account.api.response.EmailRegisterCodeVerifyResponse;
import com.bytedance.sdk.account.api.response.SensitiveCheckResponse;
import com.bytedance.sdk.account.api.response.SwitchAuthResponse;
import com.bytedance.sdk.account.impl.BDAccountCoreApiImpl;
import com.bytedance.sdk.account.impl.BDAccountDelegateInner;
import com.bytedance.sdk.account.job.AccountRemoveJob;
import com.bytedance.sdk.account.job.BindEmailJob;
import com.bytedance.sdk.account.job.CheckCodeJob;
import com.bytedance.sdk.account.job.EmailChangeBindJob;
import com.bytedance.sdk.account.job.EmailChangePasswordJob;
import com.bytedance.sdk.account.job.EmailRegisterCodeVerifyJob;
import com.bytedance.sdk.account.job.EmailTicketRegisterJob;
import com.bytedance.sdk.account.job.GetLoginGuideStrategyJob;
import com.bytedance.sdk.account.job.SensitiveCheckJob;
import com.bytedance.sdk.account.job.SwitchAuthJob;
import com.bytedance.sdk.account.job.TicketResetPasswordJob;
import com.bytedance.sdk.account.job.VerifyEmailJob;
import com.bytedance.sdk.account.mobile.thread.EmailCheckRegisterApiThread;
import com.bytedance.sdk.account.mobile.thread.EmailRegisterApiThread;
import com.bytedance.sdk.account.mobile.thread.EmailRegisterVerifyApiThread;
import com.bytedance.sdk.account.mobile.thread.EmailSendCodeApiThread;
import com.bytedance.sdk.account.mobile.thread.LogoutOthersThread;
import com.bytedance.sdk.account.mobile.thread.UserPasswordLoginApiThread;
import com.bytedance.sdk.account.mobile.thread.UserPasswordRegisterApiThread;
import com.bytedance.sdk.account.mobile.thread.call.EmailCheckRegisterCallback;
import com.bytedance.sdk.account.mobile.thread.call.EmailRegisterQueryCallback;
import com.bytedance.sdk.account.mobile.thread.call.EmailRegisterVerifyCallback;
import com.bytedance.sdk.account.mobile.thread.call.EmailSendCodeCallback;
import com.bytedance.sdk.account.mobile.thread.call.UserPasswordLoginQueryCallback;
import com.bytedance.sdk.account.mobile.thread.call.UserPasswordRegisterQueryCallback;
import com.bytedance.sdk.account.save.SaveService;
import com.ss.android.account.TTAccountInit;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class BDAccountExtraApiImpl implements IBDAccountExtraApi {
    private static volatile IBDAccountExtraApi sInstance;
    private Context mContext = TTAccountInit.getConfig().getApplicationContext();

    private BDAccountExtraApiImpl() {
    }

    public static IBDAccountExtraApi instance() {
        if (sInstance == null) {
            synchronized (BDAccountExtraApiImpl.class) {
                if (sInstance == null) {
                    sInstance = new BDAccountExtraApiImpl();
                }
            }
        }
        return sInstance;
    }

    @Override // com.bytedance.sdk.account.IBDAccountExtraApi
    public void registerWithEmail(String str, String str2, String str3, String str4, EmailRegisterQueryCallback emailRegisterQueryCallback) {
        registerWithEmail(str, str2, str3, str4, null, emailRegisterQueryCallback);
    }

    @Override // com.bytedance.sdk.account.IBDAccountExtraApi
    public void registerWithEmail(String str, String str2, String str3, String str4, Map<String, String> map, EmailRegisterQueryCallback emailRegisterQueryCallback) {
        SaveService.cacheLoginInfo(4, str);
        EmailRegisterApiThread.emailRegister(this.mContext, str, str2, str3, str4, map, emailRegisterQueryCallback).start();
    }

    @Override // com.bytedance.sdk.account.IBDAccountExtraApi
    public void emailCheckCode(String str, String str2, int i, Map map, String str3, CheckCodeCallback checkCodeCallback) {
        CheckCodeJob.checkEmailCode(this.mContext, str, str2, i, map, str3, checkCodeCallback).start();
    }

    @Override // com.bytedance.sdk.account.IBDAccountExtraApi
    public void emailTicketResetPassword(String str, String str2, Map map, String str3, TicketResetPasswordCallback ticketResetPasswordCallback) {
        TicketResetPasswordJob.resetEmailPassword(this.mContext, str, str2, map, str3, ticketResetPasswordCallback).start();
    }

    @Override // com.bytedance.sdk.account.IBDAccountExtraApi
    public void emailSendCode(String str, String str2, String str3, int i, String str4, Map map, String str5, EmailSendCodeCallback emailSendCodeCallback) {
        EmailSendCodeApiThread.emailSendCode(this.mContext, str, str2, str3, i, str4, map, str5, emailSendCodeCallback).start();
    }

    @Override // com.bytedance.sdk.account.IBDAccountExtraApi
    public void emailSendCode(String str, String str2, String str3, int i, int i2, String str4, Map<String, String> map, EmailSendCodeCallback emailSendCodeCallback) {
        EmailSendCodeApiThread.emailSendCodeWithLoginType(this.mContext, str, str2, str3, i, i2, str4, map, emailSendCodeCallback).start();
    }

    @Override // com.bytedance.sdk.account.IBDAccountExtraApi
    public void emailRegisterVerify(String str, String str2, int i, Map map, String str3, EmailRegisterVerifyCallback emailRegisterVerifyCallback) {
        SaveService.cacheLoginInfo(4, str);
        EmailRegisterVerifyApiThread.emailRegisterVerify(this.mContext, str, str2, i, map, str3, emailRegisterVerifyCallback).start();
    }

    @Override // com.bytedance.sdk.account.IBDAccountExtraApi
    public void emailRegisterVerifyLogin(String str, String str2, int i, Map map, String str3, EmailRegisterVerifyCallback emailRegisterVerifyCallback) {
        SaveService.cacheLoginInfo(4, str);
        EmailRegisterVerifyApiThread.emailRegisterVerifyLogin(this.mContext, str, str2, i, map, str3, emailRegisterVerifyCallback).start();
    }

    @Override // com.bytedance.sdk.account.IBDAccountExtraApi
    public void emailRegisterCodeVerify(String str, String str2, int i, int i2, Map<String, String> map, CommonCallBack<EmailRegisterCodeVerifyResponse> commonCallBack) {
        EmailRegisterCodeVerifyJob.emailRegisterCodeVerify(this.mContext, str, str2, i, i2, map, commonCallBack).start();
    }

    @Override // com.bytedance.sdk.account.IBDAccountExtraApi
    public void emailTicketRegister(String str, String str2, int i, int i2, Map<String, String> map, CommonCallBack<UserApiResponse> commonCallBack) {
        EmailTicketRegisterJob.register(this.mContext, str, str2, i, i2, map, commonCallBack).start();
    }

    @Override // com.bytedance.sdk.account.IBDAccountExtraApi
    public void emailCheckRegister(String str, Map map, String str2, EmailCheckRegisterCallback emailCheckRegisterCallback) {
        EmailCheckRegisterApiThread.emailCheckRegister(this.mContext, str, map, str2, emailCheckRegisterCallback).start();
    }

    @Override // com.bytedance.sdk.account.IBDAccountExtraApi
    public void emailChangePassword(String str, String str2, String str3, Map<String, String> map, CommonCallBack<UserApiResponse> commonCallBack) {
        EmailChangePasswordJob.emailChangePassword(this.mContext, str, str2, str3, map, commonCallBack).start();
    }

    @Override // com.bytedance.sdk.account.IBDAccountExtraApi
    public void bindEmail(String str, String str2, BindEmailCallback bindEmailCallback) {
        BindEmailJob.bindEmail(this.mContext, str, str2, bindEmailCallback).start();
    }

    @Override // com.bytedance.sdk.account.IBDAccountExtraApi
    public void verifyEmail(int i, String str, VerifyEmailCallback verifyEmailCallback) {
        VerifyEmailJob.verifyEmail(this.mContext, i, str, verifyEmailCallback).start();
    }

    @Override // com.bytedance.sdk.account.IBDAccountExtraApi
    public void verifyEmail(int i, String str, Map<String, String> map, VerifyEmailCallback verifyEmailCallback) {
        VerifyEmailJob.verifyEmail(this.mContext, i, str, map, verifyEmailCallback).start();
    }

    @Override // com.bytedance.sdk.account.IBDAccountExtraApi
    public void changeBindEmail(String str, String str2, String str3, String str4, Map<String, String> map, CommonCallBack<EmailChangeBindResponse> commonCallBack) {
        EmailChangeBindJob.emailChangeBind(this.mContext, str, str2, str3, str4, map, commonCallBack).start();
    }

    @Override // com.bytedance.sdk.account.IBDAccountExtraApi
    public void accountUserNameRegister(String str, String str2, UserPasswordRegisterQueryCallback userPasswordRegisterQueryCallback) {
        accountUserNameRegister(str, str2, null, userPasswordRegisterQueryCallback);
    }

    @Override // com.bytedance.sdk.account.IBDAccountExtraApi
    public void accountUserNameRegister(String str, String str2, Map<String, String> map, UserPasswordRegisterQueryCallback userPasswordRegisterQueryCallback) {
        SaveService.cacheLoginInfo(5, str);
        UserPasswordRegisterApiThread.userPasswordRegister(this.mContext, str, str2, map, userPasswordRegisterQueryCallback).start();
    }

    @Override // com.bytedance.sdk.account.IBDAccountExtraApi
    public void switchAuth(String str, SwitchAuthCallback switchAuthCallback) {
        switchAuth(str, null, switchAuthCallback);
    }

    @Override // com.bytedance.sdk.account.IBDAccountExtraApi
    public void switchAuth(String str, Map<String, String> map, SwitchAuthCallback switchAuthCallback) {
        SwitchAuthJob.switchAuth(this.mContext, str, map, switchAuthCallback).start();
    }

    @Override // com.bytedance.sdk.account.IBDAccountExtraApi
    public void switchAuthWithSecUid(String str, Map<String, String> map, SwitchAuthCallback switchAuthCallback) {
        SwitchAuthJob.switchAuthWithSecUid(this.mContext, str, map, switchAuthCallback).start();
    }

    @Override // com.bytedance.sdk.account.IBDAccountExtraApi
    public void logoutOthers(AbsApiCall<LogoutOthersApiResponse> absApiCall) {
        LogoutOthersThread.logoutOthers(this.mContext, absApiCall).start();
    }

    @Override // com.bytedance.sdk.account.IBDAccountExtraApi
    public void removeAccount(String str, AccountRemoveCallback accountRemoveCallback) {
        AccountRemoveJob.removeAccount(this.mContext, str, accountRemoveCallback).start();
    }

    @Override // com.bytedance.sdk.account.IBDAccountExtraApi
    public void getLoginGuideStrategy(Map<String, String> map, CommonCallBack<BaseApiResponse> commonCallBack) {
        GetLoginGuideStrategyJob.getLoginGuideStrategy(this.mContext, map, commonCallBack).start();
    }

    @Override // com.bytedance.sdk.account.IBDAccountExtraApi
    public void accountEmailLogin(String str, String str2, String str3, UserPasswordLoginQueryCallback userPasswordLoginQueryCallback) {
        accountEmailLogin(str, str2, str3, null, userPasswordLoginQueryCallback);
    }

    @Override // com.bytedance.sdk.account.IBDAccountExtraApi
    public void accountEmailLogin(String str, String str2, String str3, Map<String, String> map, UserPasswordLoginQueryCallback userPasswordLoginQueryCallback) {
        SaveService.cacheLoginInfo(4, str);
        UserPasswordLoginApiThread.userPasswordLogin(this.mContext, null, str, null, null, str2, null, str3, 0, map, userPasswordLoginQueryCallback).start();
    }

    @Override // com.bytedance.sdk.account.IBDAccountExtraApi
    public void sensitiveCheck(Map<String, String> map, CommonCallBack<SensitiveCheckResponse> commonCallBack) {
        SensitiveCheckJob.sensitiveCheck(this.mContext, map, commonCallBack).start();
    }

    @Override // com.bytedance.sdk.account.IBDAccountExtraApi
    public void multiLogout(final String str, final Map<String, String> map, final AbsApiCall<MultiLogoutApiResponse> absApiCall) {
        final AbsApiCall<MultiLogoutApiResponse> absApiCall2 = new AbsApiCall<MultiLogoutApiResponse>() { // from class: com.bytedance.sdk.account.BDAccountExtraApiImpl.1
            @Override // com.bytedance.sdk.account.api.call.AbsApiCall
            public void onResponse(MultiLogoutApiResponse multiLogoutApiResponse) {
                absApiCall.onResponse(multiLogoutApiResponse);
                IBDAccount instance = BDAccountDelegateInner.instance(BDAccountExtraApiImpl.this.mContext);
                if (instance.isLogin()) {
                    return;
                }
                instance.invalidateSession(false);
                BDAccountEvent bDAccountEvent = new BDAccountEvent(3);
                bDAccountEvent.extra = new HashMap();
                bDAccountEvent.extra.put("logout_type", multiLogoutApiResponse.mLogoutType);
                instance.notifyBDAccountEvent(bDAccountEvent);
            }
        };
        BDAccountCoreApiImpl.instance().logout(str, map, new AbsApiCall<LogoutApiResponse>() { // from class: com.bytedance.sdk.account.BDAccountExtraApiImpl.2
            @Override // com.bytedance.sdk.account.api.call.AbsApiCall
            public void onResponse(LogoutApiResponse logoutApiResponse) {
                MultiLogoutApiResponse multiLogoutApiResponse = new MultiLogoutApiResponse(logoutApiResponse, "logout", str);
                if (multiLogoutApiResponse.mMultiLogoutType == 1 && !TextUtils.isEmpty(multiLogoutApiResponse.mToSecUid)) {
                    switchAccount(multiLogoutApiResponse.mToSecUid, map, absApiCall2);
                } else if (multiLogoutApiResponse.mMultiLogoutType == 2) {
                    BDAccountExtraApiImpl.this.logoutOthers(new AbsApiCall<LogoutOthersApiResponse>() { // from class: com.bytedance.sdk.account.BDAccountExtraApiImpl.2.1
                        @Override // com.bytedance.sdk.account.api.call.AbsApiCall
                        public void onResponse(LogoutOthersApiResponse logoutOthersApiResponse) {
                            absApiCall2.onResponse(new MultiLogoutApiResponse(logoutOthersApiResponse, "logout_all", str));
                        }
                    });
                } else {
                    absApiCall2.onResponse(multiLogoutApiResponse);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void switchAccount(String str2, final Map<String, String> map2, final AbsApiCall<MultiLogoutApiResponse> absApiCall3) {
                BDAccountExtraApiImpl.this.switchAuthWithSecUid(str2, map2, new SwitchAuthCallback() { // from class: com.bytedance.sdk.account.BDAccountExtraApiImpl.2.2
                    @Override // com.bytedance.sdk.account.CommonCallBack
                    public void onSuccess(SwitchAuthResponse switchAuthResponse) {
                        absApiCall3.onResponse(new MultiLogoutApiResponse(switchAuthResponse, "switch", str));
                    }

                    @Override // com.bytedance.sdk.account.CommonCallBack
                    public void onError(SwitchAuthResponse switchAuthResponse, int i) {
                        MultiLogoutApiResponse multiLogoutApiResponse = new MultiLogoutApiResponse(switchAuthResponse, "switch", str);
                        if (!TextUtils.isEmpty(multiLogoutApiResponse.mToSecUid)) {
                            switchAccount(multiLogoutApiResponse.mToSecUid, map2, absApiCall3);
                        } else {
                            absApiCall3.onResponse(multiLogoutApiResponse);
                        }
                    }
                });
            }
        });
    }
}
