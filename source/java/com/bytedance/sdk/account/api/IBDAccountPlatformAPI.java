package com.bytedance.sdk.account.api;

import com.bytedance.sdk.account.CommonCallBack;
import com.bytedance.sdk.account.api.call.AbsApiCall;
import com.bytedance.sdk.account.api.call.BaseApiResponse;
import com.bytedance.sdk.account.api.call.PlatformAuthTokenResponse;
import com.bytedance.sdk.account.api.call.UserApiResponse;
import com.bytedance.sdk.account.api.callback.CanAwemeQuickLoginCallback;
import com.bytedance.sdk.account.api.response.AuthCodeAccessTokenResponse;
import com.bytedance.sdk.account.api.response.AuthLoginAuthorizeResponse;
import com.bytedance.sdk.account.api.response.GetOauthTokenResponse;
import com.bytedance.sdk.account.api.response.OpenTokenInfoResponse;
import com.bytedance.sdk.account.api.response.UpdateAuthorizeInfoResponse;
import com.bytedance.sdk.account.information.method.oauth_profile.OauthProfileCallback;
import com.ss.android.account.UserBindCallback;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface IBDAccountPlatformAPI {
    void authBindLoginWithProfileKey(String str, String str2, String str3, String str4, Map<String, String> map, UserBindCallback userBindCallback);

    void authChangeBind(String str, String str2, String str3, String str4, boolean z, boolean z2, Map<String, String> map, CommonCallBack<UserApiResponse> commonCallBack);

    void authChangeBindWithAuthCodeOrAccessToken(String str, String str2, String str3, String str4, boolean z, boolean z2, Map<String, String> map, CommonCallBack<UserApiResponse> commonCallBack);

    void authCodeAccessToken(String str, String str2, String str3, String str4, String str5, Map<String, String> map, CommonCallBack<AuthCodeAccessTokenResponse> commonCallBack);

    void authLoginAuthorize(Map<String, String> map, CommonCallBack<AuthLoginAuthorizeResponse> commonCallBack);

    void bindWithMobile(String str, String str2, String str3, String str4, String str5, String str6, String str7, long j, String str8, String str9, Map<String, String> map, UserBindCallback userBindCallback);

    void canAwemeQuickLogin(CanAwemeQuickLoginCallback canAwemeQuickLoginCallback);

    void getOauthProfile(String str, String str2, String str3, String str4, String str5, String str6, Map<String, String> map, OauthProfileCallback oauthProfileCallback);

    void getOauthProfileByAccessToken(String str, String str2, String str3, long j, Map<String, String> map, OauthProfileCallback oauthProfileCallback);

    void getOauthProfileByAccessToken(String str, String str2, String str3, String str4, long j, Map<String, String> map, OauthProfileCallback oauthProfileCallback);

    void getOauthProfileByCode(String str, String str2, String str3, long j, Map<String, String> map, OauthProfileCallback oauthProfileCallback);

    void getOauthToken(String str, String str2, String str3, Map<String, String> map, CommonCallBack<GetOauthTokenResponse> commonCallBack);

    void getOauthToken(String str, String str2, String[] strArr, Map<String, String> map, OauthTokenExtraParams oauthTokenExtraParams, CommonCallBack<GetOauthTokenResponse> commonCallBack);

    void getOauthToken(String str, String str2, String[] strArr, Map<String, String> map, boolean z, CommonCallBack<GetOauthTokenResponse> commonCallBack);

    void openTokenInfo(String str, String str2, Map<String, String> map, CommonCallBack<OpenTokenInfoResponse> commonCallBack);

    void platformAuthToken(String str, String str2, String str3, String str4, String str5, long j, Map map, AbsApiCall<PlatformAuthTokenResponse> absApiCall);

    void shareLogin(String str, String str2, String str3, Map map, AbsApiCall<UserApiResponse> absApiCall);

    void ssoCheckBindLogin(String str, String str2, String str3, Map<String, String> map, AbsApiCall<UserApiResponse> absApiCall);

    void ssoSwitchBindWithAuthToken(String str, String str2, String str3, long j, String str4, Map map, AbsApiCall<UserApiResponse> absApiCall);

    void ssoWithAccessTokenBind(String str, String str2, String str3, long j, Map map, UserBindCallback userBindCallback);

    void ssoWithAccessTokenBind(String str, String str2, String str3, String str4, long j, Map map, UserBindCallback userBindCallback);

    void ssoWithAccessTokenLogin(String str, String str2, String str3, long j, Map map, AbsApiCall<UserApiResponse> absApiCall);

    void ssoWithAccessTokenLogin(String str, String str2, String str3, String str4, long j, Map map, AbsApiCall<UserApiResponse> absApiCall);

    void ssoWithAccessTokenOnlyLogin(String str, String str2, String str3, long j, Map map, AbsApiCall<UserApiResponse> absApiCall);

    void ssoWithAuthCodeBind(String str, String str2, String str3, long j, Map map, UserBindCallback userBindCallback);

    void ssoWithAuthCodeBindMobileLogin(String str, String str2, String str3, String str4, boolean z, boolean z2, Map map, AbsApiCall<UserApiResponse> absApiCall);

    void ssoWithAuthCodeLogin(String str, String str2, String str3, long j, Map map, AbsApiCall<UserApiResponse> absApiCall);

    void ssoWithAuthCodeOnlyLogin(String str, String str2, String str3, long j, Map map, AbsApiCall<UserApiResponse> absApiCall);

    void ssoWithProfileKeyBind(String str, String str2, String str3, long j, Map map, UserBindCallback userBindCallback);

    void ssoWithProfileKeyLogin(String str, String str2, String str3, long j, Map map, AbsApiCall<UserApiResponse> absApiCall);

    void ssoWithProfileKeyRegister(String str, String str2, String str3, long j, Map map, UserBindCallback userBindCallback);

    void switchBindWithAccessToken(String str, String str2, String str3, long j, String str4, Map map, UserBindCallback userBindCallback);

    void switchBindWithAuthCode(String str, String str2, String str3, long j, String str4, Map map, UserBindCallback userBindCallback);

    void unbindPlatform(String str, int i, String str2, AbsApiCall<BaseApiResponse> absApiCall);

    void unbindPlatform(String str, AbsApiCall<BaseApiResponse> absApiCall);

    void unbindPlatform(String str, Map<String, String> map, AbsApiCall<BaseApiResponse> absApiCall);

    void updateAuthorizeInfo(String str, String str2, String str3, String str4, String str5, String str6, Map<String, String> map, CommonCallBack<UpdateAuthorizeInfoResponse> commonCallBack);

    void updateAuthorizeInfo(String str, String str2, String str3, Map<String, String> map, CommonCallBack<UpdateAuthorizeInfoResponse> commonCallBack);

    void webAuth(String str, Map map, UserBindCallback userBindCallback);
}
