package com.bytedance.sdk.account;

import com.bytedance.sdk.account.api.callback.AccountAuthorizeCallback;
import com.bytedance.sdk.account.api.callback.AuthorizeQRCodeLoginCallback;
import com.bytedance.sdk.account.api.callback.BindEmailForDeviceLoginCallback;
import com.bytedance.sdk.account.api.callback.BindVisitorAccountCallback;
import com.bytedance.sdk.account.api.callback.CheckQRCodeStatusCallback;
import com.bytedance.sdk.account.api.callback.GenerateUserInfoTicketCallback;
import com.bytedance.sdk.account.api.callback.GetQRCodeCallback;
import com.bytedance.sdk.account.api.callback.GetTvQRCodeCallback;
import com.bytedance.sdk.account.api.callback.LoginByTicketAfterRegisterCallback;
import com.bytedance.sdk.account.api.callback.ScanQRCodeCallback;
import com.bytedance.sdk.account.api.callback.TVCheckQRConnectCallback;
import com.bytedance.sdk.account.api.callback.UserDeviceLoginCallback;
import com.bytedance.sdk.account.api.callback.VerifyAccountPasswordCallback;
import com.bytedance.sdk.account.api.response.CheckVisitorUpgradeResponse;
import com.bytedance.sdk.account.mobile.thread.call.UserPasswordLoginQueryCallback;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface IBDAccountSpecialApi {
    void authorizeQRCodeLogin(String str, String str2, String str3, AuthorizeQRCodeLoginCallback authorizeQRCodeLoginCallback);

    void authorizeQRCodeLogin(String str, String str2, String str3, String str4, Map<String, String> map, AuthorizeQRCodeLoginCallback authorizeQRCodeLoginCallback);

    void authorizeQRCodeLogin(String str, String str2, String str3, Map<String, String> map, AuthorizeQRCodeLoginCallback authorizeQRCodeLoginCallback);

    void authorizeScanQRCode(String str, ScanQRCodeCallback scanQRCodeCallback);

    void authorizeScanQRCode(String str, Map<String, String> map, ScanQRCodeCallback scanQRCodeCallback);

    void bindEmailForDeviceLogin(String str, String str2, BindEmailForDeviceLoginCallback bindEmailForDeviceLoginCallback);

    void bindEmailForDeviceLogin(String str, String str2, Map<String, String> map, BindEmailForDeviceLoginCallback bindEmailForDeviceLoginCallback);

    void bindVisitorAccount(BindVisitorAccountCallback bindVisitorAccountCallback);

    void checkQRCodeStatus(String str, String str2, int i, String str3, Map<String, String> map, CheckQRCodeStatusCallback checkQRCodeStatusCallback);

    void checkQRCodeStatus(String str, String str2, CheckQRCodeStatusCallback checkQRCodeStatusCallback);

    void checkQRConnect(String str, String str2, TVCheckQRConnectCallback tVCheckQRConnectCallback);

    void checkVisitorUpgrade(Map<String, String> map, CommonCallBack<CheckVisitorUpgradeResponse> commonCallBack);

    void emailAuthorize(String str, String str2, String str3, AccountAuthorizeCallback accountAuthorizeCallback);

    void emailLoginWithToken(String str, String str2, String str3, String str4, UserPasswordLoginQueryCallback userPasswordLoginQueryCallback);

    void generateUserInfoTicket(String str, String str2, GenerateUserInfoTicketCallback generateUserInfoTicketCallback);

    void generateUserInfoTicket(String str, String str2, Map<String, String> map, GenerateUserInfoTicketCallback generateUserInfoTicketCallback);

    void getQRCode(String str, int i, String str2, Map<String, String> map, GetQRCodeCallback getQRCodeCallback);

    void getQRCode(String str, GetQRCodeCallback getQRCodeCallback);

    void getTvQRCode(String str, GetTvQRCodeCallback getTvQRCodeCallback);

    void loginByTicketAfterRegister(String str, String str2, LoginByTicketAfterRegisterCallback loginByTicketAfterRegisterCallback);

    void loginByTicketAfterRegister(String str, String str2, Map<String, String> map, LoginByTicketAfterRegisterCallback loginByTicketAfterRegisterCallback);

    void mobileAuthorize(String str, String str2, String str3, AccountAuthorizeCallback accountAuthorizeCallback);

    void mobileLoginWithToken(String str, String str2, String str3, String str4, UserPasswordLoginQueryCallback userPasswordLoginQueryCallback);

    void ssoAuthorizeQRCodeLogin(String str, String str2, String str3, String str4, Map<String, String> map, AuthorizeQRCodeLoginCallback authorizeQRCodeLoginCallback);

    void ssoAuthorizeScanQRCode(String str, Map<String, String> map, ScanQRCodeCallback scanQRCodeCallback);

    void userDeviceLogin(UserDeviceLoginCallback userDeviceLoginCallback);

    void userDeviceLogin(Map<String, String> map, UserDeviceLoginCallback userDeviceLoginCallback);

    void userNameLoginWithToken(String str, String str2, String str3, String str4, UserPasswordLoginQueryCallback userPasswordLoginQueryCallback);

    void usernameAuthorize(String str, String str2, String str3, AccountAuthorizeCallback accountAuthorizeCallback);

    void verifyEmailPassword(String str, String str2, String str3, VerifyAccountPasswordCallback verifyAccountPasswordCallback);

    void verifyEmailPassword(String str, String str2, String str3, Map<String, String> map, VerifyAccountPasswordCallback verifyAccountPasswordCallback);

    void verifyMobilePassword(String str, String str2, String str3, VerifyAccountPasswordCallback verifyAccountPasswordCallback);

    void verifyMobilePassword(String str, String str2, String str3, Map<String, String> map, VerifyAccountPasswordCallback verifyAccountPasswordCallback);

    void verifyUserNamePassword(String str, String str2, String str3, VerifyAccountPasswordCallback verifyAccountPasswordCallback);

    void verifyUserNamePassword(String str, String str2, String str3, Map<String, String> map, VerifyAccountPasswordCallback verifyAccountPasswordCallback);
}
