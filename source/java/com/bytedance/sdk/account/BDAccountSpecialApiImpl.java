package com.bytedance.sdk.account;

import android.content.Context;
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
import com.bytedance.sdk.account.job.AccountAuthorizeJob;
import com.bytedance.sdk.account.job.AuthorizeQRCodeLoginJob;
import com.bytedance.sdk.account.job.BindEmailForDeviceLogin;
import com.bytedance.sdk.account.job.BindVisitorAccountJob;
import com.bytedance.sdk.account.job.CheckQRCodeStatusJob;
import com.bytedance.sdk.account.job.CheckVisitorUpgradeJob;
import com.bytedance.sdk.account.job.GenerateUserInfoTicketJob;
import com.bytedance.sdk.account.job.GetQRCodeJob;
import com.bytedance.sdk.account.job.GetTvQRCodeJob;
import com.bytedance.sdk.account.job.LoginByTicketAfterRegisterJob;
import com.bytedance.sdk.account.job.ScanQRCodeJob;
import com.bytedance.sdk.account.job.SsoAuthorizeQRCodeLoginJob;
import com.bytedance.sdk.account.job.SsoScanQRCodeJob;
import com.bytedance.sdk.account.job.TVCheckQRConnectJob;
import com.bytedance.sdk.account.job.UserDeviceLoginJob;
import com.bytedance.sdk.account.job.VerifyAccountPasswordJob;
import com.bytedance.sdk.account.mobile.thread.UserPasswordLoginApiThread;
import com.bytedance.sdk.account.mobile.thread.call.UserPasswordLoginQueryCallback;
import com.bytedance.sdk.account.save.SaveService;
import com.ss.android.account.TTAccountInit;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class BDAccountSpecialApiImpl implements IBDAccountSpecialApi {
    private static volatile IBDAccountSpecialApi sInstance;
    private Context mContext = TTAccountInit.getConfig().getApplicationContext();

    private BDAccountSpecialApiImpl() {
    }

    public static IBDAccountSpecialApi instance() {
        if (sInstance == null) {
            synchronized (BDAccountSpecialApiImpl.class) {
                if (sInstance == null) {
                    sInstance = new BDAccountSpecialApiImpl();
                }
            }
        }
        return sInstance;
    }

    @Override // com.bytedance.sdk.account.IBDAccountSpecialApi
    public void getTvQRCode(String str, GetTvQRCodeCallback getTvQRCodeCallback) {
        GetTvQRCodeJob.getTvQRCode(this.mContext, str, getTvQRCodeCallback).start();
    }

    @Override // com.bytedance.sdk.account.IBDAccountSpecialApi
    public void checkQRConnect(String str, String str2, TVCheckQRConnectCallback tVCheckQRConnectCallback) {
        TVCheckQRConnectJob.checkQRConnect(this.mContext, str, str2, tVCheckQRConnectCallback).start();
    }

    @Override // com.bytedance.sdk.account.IBDAccountSpecialApi
    public void getQRCode(String str, GetQRCodeCallback getQRCodeCallback) {
        GetQRCodeJob.getQRCode(this.mContext, str, 0, null, null, getQRCodeCallback).start();
    }

    @Override // com.bytedance.sdk.account.IBDAccountSpecialApi
    public void getQRCode(String str, int i, String str2, Map<String, String> map, GetQRCodeCallback getQRCodeCallback) {
        GetQRCodeJob.getQRCode(this.mContext, str, i, str2, map, getQRCodeCallback).start();
    }

    @Override // com.bytedance.sdk.account.IBDAccountSpecialApi
    public void checkQRCodeStatus(String str, String str2, CheckQRCodeStatusCallback checkQRCodeStatusCallback) {
        CheckQRCodeStatusJob.checkQRCodeStatus(this.mContext, str, str2, 0, null, null, checkQRCodeStatusCallback).start();
    }

    @Override // com.bytedance.sdk.account.IBDAccountSpecialApi
    public void checkQRCodeStatus(String str, String str2, int i, String str3, Map<String, String> map, CheckQRCodeStatusCallback checkQRCodeStatusCallback) {
        CheckQRCodeStatusJob.checkQRCodeStatus(this.mContext, str, str2, i, str3, map, checkQRCodeStatusCallback).start();
    }

    @Override // com.bytedance.sdk.account.IBDAccountSpecialApi
    public void authorizeScanQRCode(String str, ScanQRCodeCallback scanQRCodeCallback) {
        ScanQRCodeJob.scanQRCode(this.mContext, str, null, scanQRCodeCallback).start();
    }

    @Override // com.bytedance.sdk.account.IBDAccountSpecialApi
    public void authorizeScanQRCode(String str, Map<String, String> map, ScanQRCodeCallback scanQRCodeCallback) {
        ScanQRCodeJob.scanQRCode(this.mContext, str, map, scanQRCodeCallback).start();
    }

    @Override // com.bytedance.sdk.account.IBDAccountSpecialApi
    public void ssoAuthorizeScanQRCode(String str, Map<String, String> map, ScanQRCodeCallback scanQRCodeCallback) {
        SsoScanQRCodeJob.scanQRCode(this.mContext, str, map, scanQRCodeCallback).start();
    }

    @Override // com.bytedance.sdk.account.IBDAccountSpecialApi
    public void authorizeQRCodeLogin(String str, String str2, String str3, AuthorizeQRCodeLoginCallback authorizeQRCodeLoginCallback) {
        AuthorizeQRCodeLoginJob.authorizeLogin(this.mContext, str, str2, str3, null, authorizeQRCodeLoginCallback).start();
    }

    @Override // com.bytedance.sdk.account.IBDAccountSpecialApi
    public void authorizeQRCodeLogin(String str, String str2, String str3, Map<String, String> map, AuthorizeQRCodeLoginCallback authorizeQRCodeLoginCallback) {
        AuthorizeQRCodeLoginJob.authorizeLogin(this.mContext, str, str2, str3, map, authorizeQRCodeLoginCallback).start();
    }

    @Override // com.bytedance.sdk.account.IBDAccountSpecialApi
    public void authorizeQRCodeLogin(String str, String str2, String str3, String str4, Map<String, String> map, AuthorizeQRCodeLoginCallback authorizeQRCodeLoginCallback) {
        AuthorizeQRCodeLoginJob.authorizeLoginWithConfirmedUrl(this.mContext, str, str2, str3, str4, map, authorizeQRCodeLoginCallback).start();
    }

    @Override // com.bytedance.sdk.account.IBDAccountSpecialApi
    public void ssoAuthorizeQRCodeLogin(String str, String str2, String str3, String str4, Map<String, String> map, AuthorizeQRCodeLoginCallback authorizeQRCodeLoginCallback) {
        SsoAuthorizeQRCodeLoginJob.authorizeLoginWithConfirmedUrl(this.mContext, str, str2, str3, str4, map, authorizeQRCodeLoginCallback).start();
    }

    @Override // com.bytedance.sdk.account.IBDAccountSpecialApi
    public void mobileAuthorize(String str, String str2, String str3, AccountAuthorizeCallback accountAuthorizeCallback) {
        AccountAuthorizeJob.accountAuthorize(this.mContext, str, null, null, str2, str3, accountAuthorizeCallback).start();
    }

    @Override // com.bytedance.sdk.account.IBDAccountSpecialApi
    public void usernameAuthorize(String str, String str2, String str3, AccountAuthorizeCallback accountAuthorizeCallback) {
        AccountAuthorizeJob.accountAuthorize(this.mContext, null, str, null, str2, str3, accountAuthorizeCallback).start();
    }

    @Override // com.bytedance.sdk.account.IBDAccountSpecialApi
    public void emailAuthorize(String str, String str2, String str3, AccountAuthorizeCallback accountAuthorizeCallback) {
        AccountAuthorizeJob.accountAuthorize(this.mContext, null, null, str, str2, str3, accountAuthorizeCallback).start();
    }

    @Override // com.bytedance.sdk.account.IBDAccountSpecialApi
    public void userDeviceLogin(UserDeviceLoginCallback userDeviceLoginCallback) {
        userDeviceLogin(null, userDeviceLoginCallback);
    }

    @Override // com.bytedance.sdk.account.IBDAccountSpecialApi
    public void userDeviceLogin(Map<String, String> map, UserDeviceLoginCallback userDeviceLoginCallback) {
        UserDeviceLoginJob.userDeviceLogin(this.mContext, map, userDeviceLoginCallback).start();
    }

    @Override // com.bytedance.sdk.account.IBDAccountSpecialApi
    public void bindVisitorAccount(BindVisitorAccountCallback bindVisitorAccountCallback) {
        BindVisitorAccountJob.bindVisitorAccount(this.mContext, bindVisitorAccountCallback).start();
    }

    @Override // com.bytedance.sdk.account.IBDAccountSpecialApi
    public void checkVisitorUpgrade(Map<String, String> map, CommonCallBack<CheckVisitorUpgradeResponse> commonCallBack) {
        CheckVisitorUpgradeJob.checkVisitorUpgrade(this.mContext, map, commonCallBack).start();
    }

    @Override // com.bytedance.sdk.account.IBDAccountSpecialApi
    public void userNameLoginWithToken(String str, String str2, String str3, String str4, UserPasswordLoginQueryCallback userPasswordLoginQueryCallback) {
        SaveService.cacheLoginInfo(5, str);
        UserPasswordLoginApiThread.userPasswordLogin(this.mContext, null, null, str, null, str2, str3, str4, 0, userPasswordLoginQueryCallback).start();
    }

    @Override // com.bytedance.sdk.account.IBDAccountSpecialApi
    public void emailLoginWithToken(String str, String str2, String str3, String str4, UserPasswordLoginQueryCallback userPasswordLoginQueryCallback) {
        SaveService.cacheLoginInfo(4, str);
        UserPasswordLoginApiThread.userPasswordLogin(this.mContext, null, str, null, null, str2, str3, str4, 0, userPasswordLoginQueryCallback).start();
    }

    @Override // com.bytedance.sdk.account.IBDAccountSpecialApi
    public void mobileLoginWithToken(String str, String str2, String str3, String str4, UserPasswordLoginQueryCallback userPasswordLoginQueryCallback) {
        SaveService.cacheLoginInfo(3, str);
        UserPasswordLoginApiThread.userPasswordLogin(this.mContext, str, null, null, null, str2, str3, str4, 0, userPasswordLoginQueryCallback).start();
    }

    @Override // com.bytedance.sdk.account.IBDAccountSpecialApi
    public void verifyUserNamePassword(String str, String str2, String str3, VerifyAccountPasswordCallback verifyAccountPasswordCallback) {
        verifyUserNamePassword(str, str2, str3, null, verifyAccountPasswordCallback);
    }

    @Override // com.bytedance.sdk.account.IBDAccountSpecialApi
    public void verifyUserNamePassword(String str, String str2, String str3, Map<String, String> map, VerifyAccountPasswordCallback verifyAccountPasswordCallback) {
        VerifyAccountPasswordJob.verifyAccountPassword(this.mContext, str, null, null, str2, str3, map, verifyAccountPasswordCallback).start();
    }

    @Override // com.bytedance.sdk.account.IBDAccountSpecialApi
    public void verifyMobilePassword(String str, String str2, String str3, VerifyAccountPasswordCallback verifyAccountPasswordCallback) {
        verifyMobilePassword(str, str2, str3, null, verifyAccountPasswordCallback);
    }

    @Override // com.bytedance.sdk.account.IBDAccountSpecialApi
    public void verifyMobilePassword(String str, String str2, String str3, Map<String, String> map, VerifyAccountPasswordCallback verifyAccountPasswordCallback) {
        VerifyAccountPasswordJob.verifyAccountPassword(this.mContext, null, str, null, str2, str3, map, verifyAccountPasswordCallback).start();
    }

    @Override // com.bytedance.sdk.account.IBDAccountSpecialApi
    public void verifyEmailPassword(String str, String str2, String str3, VerifyAccountPasswordCallback verifyAccountPasswordCallback) {
        verifyEmailPassword(str, str2, str3, null, verifyAccountPasswordCallback);
    }

    @Override // com.bytedance.sdk.account.IBDAccountSpecialApi
    public void verifyEmailPassword(String str, String str2, String str3, Map<String, String> map, VerifyAccountPasswordCallback verifyAccountPasswordCallback) {
        VerifyAccountPasswordJob.verifyAccountPassword(this.mContext, null, null, str, str2, str3, map, verifyAccountPasswordCallback).start();
    }

    @Override // com.bytedance.sdk.account.IBDAccountSpecialApi
    public void generateUserInfoTicket(String str, String str2, GenerateUserInfoTicketCallback generateUserInfoTicketCallback) {
        generateUserInfoTicket(str, str2, null, generateUserInfoTicketCallback);
    }

    @Override // com.bytedance.sdk.account.IBDAccountSpecialApi
    public void generateUserInfoTicket(String str, String str2, Map<String, String> map, GenerateUserInfoTicketCallback generateUserInfoTicketCallback) {
        GenerateUserInfoTicketJob.generateUserInfoTicket(this.mContext, str, str2, map, generateUserInfoTicketCallback).start();
    }

    @Override // com.bytedance.sdk.account.IBDAccountSpecialApi
    public void loginByTicketAfterRegister(String str, String str2, LoginByTicketAfterRegisterCallback loginByTicketAfterRegisterCallback) {
        loginByTicketAfterRegister(str, str2, null, loginByTicketAfterRegisterCallback);
    }

    @Override // com.bytedance.sdk.account.IBDAccountSpecialApi
    public void loginByTicketAfterRegister(String str, String str2, Map<String, String> map, LoginByTicketAfterRegisterCallback loginByTicketAfterRegisterCallback) {
        SaveService.cacheLoginInfo(2, str2);
        LoginByTicketAfterRegisterJob.loginByTicketAfterRegister(this.mContext, str, str2, map, loginByTicketAfterRegisterCallback).start();
    }

    @Override // com.bytedance.sdk.account.IBDAccountSpecialApi
    public void bindEmailForDeviceLogin(String str, String str2, BindEmailForDeviceLoginCallback bindEmailForDeviceLoginCallback) {
        bindEmailForDeviceLogin(str, str2, null, bindEmailForDeviceLoginCallback);
    }

    @Override // com.bytedance.sdk.account.IBDAccountSpecialApi
    public void bindEmailForDeviceLogin(String str, String str2, Map<String, String> map, BindEmailForDeviceLoginCallback bindEmailForDeviceLoginCallback) {
        BindEmailForDeviceLogin.bindEmailForDeviceLogin(this.mContext, str, str2, map, bindEmailForDeviceLoginCallback).start();
    }
}
