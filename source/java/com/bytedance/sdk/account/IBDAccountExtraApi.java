package com.bytedance.sdk.account;

import com.bytedance.sdk.account.api.call.AbsApiCall;
import com.bytedance.sdk.account.api.call.BaseApiResponse;
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
import com.bytedance.sdk.account.mobile.thread.call.EmailCheckRegisterCallback;
import com.bytedance.sdk.account.mobile.thread.call.EmailRegisterQueryCallback;
import com.bytedance.sdk.account.mobile.thread.call.EmailRegisterVerifyCallback;
import com.bytedance.sdk.account.mobile.thread.call.EmailSendCodeCallback;
import com.bytedance.sdk.account.mobile.thread.call.UserPasswordLoginQueryCallback;
import com.bytedance.sdk.account.mobile.thread.call.UserPasswordRegisterQueryCallback;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface IBDAccountExtraApi {
    void accountEmailLogin(String str, String str2, String str3, UserPasswordLoginQueryCallback userPasswordLoginQueryCallback);

    void accountEmailLogin(String str, String str2, String str3, Map<String, String> map, UserPasswordLoginQueryCallback userPasswordLoginQueryCallback);

    void accountUserNameRegister(String str, String str2, UserPasswordRegisterQueryCallback userPasswordRegisterQueryCallback);

    void accountUserNameRegister(String str, String str2, Map<String, String> map, UserPasswordRegisterQueryCallback userPasswordRegisterQueryCallback);

    void bindEmail(String str, String str2, BindEmailCallback bindEmailCallback);

    void changeBindEmail(String str, String str2, String str3, String str4, Map<String, String> map, CommonCallBack<EmailChangeBindResponse> commonCallBack);

    void emailChangePassword(String str, String str2, String str3, Map<String, String> map, CommonCallBack<UserApiResponse> commonCallBack);

    void emailCheckCode(String str, String str2, int i, Map map, String str3, CheckCodeCallback checkCodeCallback);

    void emailCheckRegister(String str, Map map, String str2, EmailCheckRegisterCallback emailCheckRegisterCallback);

    void emailRegisterCodeVerify(String str, String str2, int i, int i2, Map<String, String> map, CommonCallBack<EmailRegisterCodeVerifyResponse> commonCallBack);

    void emailRegisterVerify(String str, String str2, int i, Map map, String str3, EmailRegisterVerifyCallback emailRegisterVerifyCallback);

    void emailRegisterVerifyLogin(String str, String str2, int i, Map map, String str3, EmailRegisterVerifyCallback emailRegisterVerifyCallback);

    void emailSendCode(String str, String str2, String str3, int i, int i2, String str4, Map<String, String> map, EmailSendCodeCallback emailSendCodeCallback);

    void emailSendCode(String str, String str2, String str3, int i, String str4, Map map, String str5, EmailSendCodeCallback emailSendCodeCallback);

    void emailTicketRegister(String str, String str2, int i, int i2, Map<String, String> map, CommonCallBack<UserApiResponse> commonCallBack);

    void emailTicketResetPassword(String str, String str2, Map map, String str3, TicketResetPasswordCallback ticketResetPasswordCallback);

    void getLoginGuideStrategy(Map<String, String> map, CommonCallBack<BaseApiResponse> commonCallBack);

    void logoutOthers(AbsApiCall<LogoutOthersApiResponse> absApiCall);

    void multiLogout(String str, Map<String, String> map, AbsApiCall<MultiLogoutApiResponse> absApiCall);

    void registerWithEmail(String str, String str2, String str3, String str4, EmailRegisterQueryCallback emailRegisterQueryCallback);

    void registerWithEmail(String str, String str2, String str3, String str4, Map<String, String> map, EmailRegisterQueryCallback emailRegisterQueryCallback);

    void removeAccount(String str, AccountRemoveCallback accountRemoveCallback);

    void sensitiveCheck(Map<String, String> map, CommonCallBack<SensitiveCheckResponse> commonCallBack);

    void switchAuth(String str, SwitchAuthCallback switchAuthCallback);

    void switchAuth(String str, Map<String, String> map, SwitchAuthCallback switchAuthCallback);

    void switchAuthWithSecUid(String str, Map<String, String> map, SwitchAuthCallback switchAuthCallback);

    void verifyEmail(int i, String str, VerifyEmailCallback verifyEmailCallback);

    void verifyEmail(int i, String str, Map<String, String> map, VerifyEmailCallback verifyEmailCallback);
}
