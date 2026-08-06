package com.bytedance.sdk.account.impl;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.account.CommonCallBack;
import com.bytedance.sdk.account.ThirdPartyNetConstants;
import com.bytedance.sdk.account.api.AccountErrorCode;
import com.bytedance.sdk.account.api.IBDAccountPlatformAPI;
import com.bytedance.sdk.account.api.OauthTokenExtraParams;
import com.bytedance.sdk.account.api.call.AbsApiCall;
import com.bytedance.sdk.account.api.call.BaseApiResponse;
import com.bytedance.sdk.account.api.call.PlatformAuthTokenResponse;
import com.bytedance.sdk.account.api.call.UserApiResponse;
import com.bytedance.sdk.account.api.callback.CanAwemeQuickLoginCallback;
import com.bytedance.sdk.account.api.callback.GetAccountInfoCallback;
import com.bytedance.sdk.account.api.response.AuthCodeAccessTokenResponse;
import com.bytedance.sdk.account.api.response.AuthLoginAuthorizeResponse;
import com.bytedance.sdk.account.api.response.GetAccountInfoResponse;
import com.bytedance.sdk.account.api.response.GetOauthTokenResponse;
import com.bytedance.sdk.account.api.response.OpenTokenInfoResponse;
import com.bytedance.sdk.account.api.response.UpdateAuthorizeInfoResponse;
import com.bytedance.sdk.account.information.method.oauth_profile.OauthProfileCallback;
import com.bytedance.sdk.account.information.method.oauth_profile.OauthProfileJob;
import com.bytedance.sdk.account.job.CanAwemeQuickLoginJob;
import com.bytedance.sdk.account.job.GetOauthTokenJob;
import com.bytedance.sdk.account.job.UpdateAuthorizeInfoJob;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import com.bytedance.sdk.account.platform.api.ITaptapService;
import com.bytedance.sdk.account.save.SaveService;
import com.bytedance.sdk.account.settings.AuthExpirationConfigManager;
import com.bytedance.sdk.account.sso.AuthBindLoginThread;
import com.bytedance.sdk.account.sso.AuthChangeBindThread;
import com.bytedance.sdk.account.sso.AuthCodeAccessTokenThread;
import com.bytedance.sdk.account.sso.AuthLoginAuthorizeThread;
import com.bytedance.sdk.account.sso.OpenTokenInfoThread;
import com.bytedance.sdk.account.sso.PlatformAuthTokenThread;
import com.bytedance.sdk.account.sso.SsoApiAuthRegisterThread;
import com.bytedance.sdk.account.sso.SsoApiBindThread;
import com.bytedance.sdk.account.sso.SsoApiLoginThread;
import com.bytedance.sdk.account.sso.SsoApiOnlyLoginThread;
import com.bytedance.sdk.account.sso.SsoApiSwitchBindThread;
import com.bytedance.sdk.account.sso.SsoApiUnbindTrhead;
import com.bytedance.sdk.account.sso.SsoCheckBindLoginThread;
import com.bytedance.sdk.account.sso.WebAuthUserThread;
import com.bytedance.sdk.account.user.IBDAccountUserEntity;
import com.bytedance.timonbase.scene.PageDataManager;
import com.ss.android.LogHelper;
import com.ss.android.account.TTAccountInit;
import com.ss.android.account.UserBindCallback;
import com.ss.android.account.model2.BDAccountPlatformEntity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class BDAccountPlatformImpl implements IBDAccountPlatformAPI {
    private static final String TAG = "BDAccountPlatformImpl";
    private static volatile IBDAccountPlatformAPI sInstance;
    private final HashMap<String, ArrayList<WeakReference<CommonCallBack<GetOauthTokenResponse>>>> getOauthTokenCallbacks = new HashMap<>();
    private final HashMap<String, AtomicBoolean> getOauthTokenLock = new HashMap<>();
    Context mContext = TTAccountInit.getConfig().getApplicationContext();

    private BDAccountPlatformImpl() {
    }

    public static IBDAccountPlatformAPI instance() {
        if (sInstance == null) {
            synchronized (BDAccountPlatformImpl.class) {
                if (sInstance == null) {
                    sInstance = new BDAccountPlatformImpl();
                }
            }
        }
        return sInstance;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void unbindPlatform(String str, AbsApiCall<BaseApiResponse> absApiCall) {
        SsoApiUnbindTrhead.withUnbind(this.mContext, str, null, getUnbindCallback(absApiCall)).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void unbindPlatform(String str, Map<String, String> map, AbsApiCall<BaseApiResponse> absApiCall) {
        SsoApiUnbindTrhead.withUnbind(this.mContext, str, map, getUnbindCallback(absApiCall)).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void unbindPlatform(String str, int i, String str2, AbsApiCall<BaseApiResponse> absApiCall) {
        SsoApiUnbindTrhead.withUnbind(this.mContext, str, i, str2, getUnbindCallback(absApiCall)).start();
    }

    private AbsApiCall<BaseApiResponse> getUnbindCallback(final AbsApiCall<BaseApiResponse> absApiCall) {
        return AuthExpirationConfigManager.isEnable() ? new AbsApiCall<BaseApiResponse>() { // from class: com.bytedance.sdk.account.impl.BDAccountPlatformImpl.1
            @Override // com.bytedance.sdk.account.api.call.AbsApiCall
            public void onResponse(final BaseApiResponse baseApiResponse) {
                if (!baseApiResponse.success) {
                    AbsApiCall absApiCall2 = absApiCall;
                    if (absApiCall2 != null) {
                        absApiCall2.onResponse(baseApiResponse);
                        return;
                    }
                    return;
                }
                BDAccountCoreApiImpl.instance().getNewAccountInfo("normal", new GetAccountInfoCallback() { // from class: com.bytedance.sdk.account.impl.BDAccountPlatformImpl.1.1
                    @Override // com.bytedance.sdk.account.CommonCallBack
                    public void onSuccess(GetAccountInfoResponse getAccountInfoResponse) {
                        if (absApiCall != null) {
                            absApiCall.onResponse(getAccountInfoResponse);
                        }
                    }

                    @Override // com.bytedance.sdk.account.CommonCallBack
                    public void onError(GetAccountInfoResponse getAccountInfoResponse, int i) {
                        if (absApiCall != null) {
                            absApiCall.onResponse(baseApiResponse);
                        }
                    }
                });
            }
        } : absApiCall;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void ssoWithAuthCodeLogin(String str, String str2, String str3, long j, Map map, AbsApiCall<UserApiResponse> absApiCall) {
        SaveService.cacheLoginInfo(6, str2);
        SsoApiLoginThread.withAuthCodeLogin(this.mContext, str, str2, str3, String.valueOf(j), map, absApiCall).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void ssoWithAccessTokenLogin(String str, String str2, String str3, long j, Map map, AbsApiCall<UserApiResponse> absApiCall) {
        SaveService.cacheLoginInfo(6, str2);
        SsoApiLoginThread.withAccessTokenLogin(this.mContext, str, str2, str3, String.valueOf(j), map, absApiCall).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void ssoWithAccessTokenLogin(String str, String str2, String str3, String str4, long j, Map map, AbsApiCall<UserApiResponse> absApiCall) {
        SaveService.cacheLoginInfo(6, str2);
        SsoApiLoginThread.withAccessTokenLogin(this.mContext, str, str2, str3, str4, String.valueOf(j), map, absApiCall).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void ssoCheckBindLogin(String str, String str2, String str3, Map<String, String> map, AbsApiCall<UserApiResponse> absApiCall) {
        SaveService.cacheLoginInfo(6, str2);
        SsoCheckBindLoginThread.checkoutBindLogin(this.mContext, str, str2, str3, map, absApiCall).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void ssoWithProfileKeyLogin(String str, String str2, String str3, long j, Map map, AbsApiCall<UserApiResponse> absApiCall) {
        SaveService.cacheLoginInfo(6, str2);
        SsoApiLoginThread.withProfileKeyLogin(this.mContext, str, str2, str3, String.valueOf(j), map, absApiCall).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void ssoWithAuthCodeOnlyLogin(String str, String str2, String str3, long j, Map map, AbsApiCall<UserApiResponse> absApiCall) {
        SaveService.cacheLoginInfo(6, str2);
        SsoApiOnlyLoginThread.withAuthCodeOnlyLogin(this.mContext, str, str2, str3, String.valueOf(j), map, absApiCall).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void ssoWithAccessTokenOnlyLogin(String str, String str2, String str3, long j, Map map, AbsApiCall<UserApiResponse> absApiCall) {
        SaveService.cacheLoginInfo(6, str2);
        SsoApiOnlyLoginThread.withAccessTokenOnlyLogin(this.mContext, str, str2, str3, String.valueOf(j), map, absApiCall).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void ssoWithAuthCodeBindMobileLogin(String str, String str2, String str3, String str4, boolean z, boolean z2, Map map, AbsApiCall<UserApiResponse> absApiCall) {
        SaveService.cacheLoginInfo(6, str2);
        SsoApiLoginThread.withAuthCodeBindMobileLogin(this.mContext, str, str2, str3, str4, z, z2, map, absApiCall).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void shareLogin(String str, String str2, String str3, Map map, AbsApiCall<UserApiResponse> absApiCall) {
        SaveService.cacheLoginInfo(6, str3);
        SsoApiLoginThread.shareLogin(this.mContext, str, str2, str3, map, absApiCall).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void ssoSwitchBindWithAuthToken(String str, String str2, String str3, long j, String str4, Map map, AbsApiCall<UserApiResponse> absApiCall) {
        SsoApiSwitchBindThread.withAuthTokenSwitchBind(this.mContext, str, str2, str3, String.valueOf(j), str4, map, absApiCall).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void switchBindWithAccessToken(String str, String str2, String str3, long j, String str4, Map map, UserBindCallback userBindCallback) {
        SsoApiSwitchBindThread.withAccessTokenSwitchBind(this.mContext, str, str2, str3, String.valueOf(j), str4, map, userBindCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void switchBindWithAuthCode(String str, String str2, String str3, long j, String str4, Map map, UserBindCallback userBindCallback) {
        SsoApiSwitchBindThread.withAuthCodeSwitchBind(this.mContext, str, str2, str3, String.valueOf(j), str4, map, userBindCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void ssoWithAuthCodeBind(String str, String str2, String str3, long j, Map map, UserBindCallback userBindCallback) {
        SsoApiBindThread.withAuthCodeBind(this.mContext, str, str2, str3, String.valueOf(j), map, userBindCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void ssoWithAccessTokenBind(String str, String str2, String str3, long j, Map map, UserBindCallback userBindCallback) {
        SsoApiBindThread.withAccessTokenBind(this.mContext, str, str2, str3, String.valueOf(j), map, userBindCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void ssoWithAccessTokenBind(String str, String str2, String str3, String str4, long j, Map map, UserBindCallback userBindCallback) {
        SsoApiBindThread.withAccessTokenBind(this.mContext, str, str2, str3, str4, String.valueOf(j), map, userBindCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void ssoWithProfileKeyBind(String str, String str2, String str3, long j, Map map, UserBindCallback userBindCallback) {
        SsoApiBindThread.withProfileKeyBind(this.mContext, str, str2, str3, String.valueOf(j), map, userBindCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void bindWithMobile(String str, String str2, String str3, String str4, String str5, String str6, String str7, long j, String str8, String str9, Map<String, String> map, UserBindCallback userBindCallback) {
        SsoApiBindThread.bindWithMobile(this.mContext, str, str2, str3, str4, str5, str6, str7, String.valueOf(j), str8, str9, map, userBindCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void ssoWithProfileKeyRegister(String str, String str2, String str3, long j, Map map, UserBindCallback userBindCallback) {
        SaveService.cacheLoginInfo(6, str2);
        SsoApiAuthRegisterThread.withProfileKey(this.mContext, str, str2, str3, String.valueOf(j), map, userBindCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void webAuth(String str, Map map, UserBindCallback userBindCallback) {
        WebAuthUserThread.withAuthUser(this.mContext, str, userBindCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void platformAuthToken(String str, String str2, String str3, String str4, String str5, long j, Map map, AbsApiCall<PlatformAuthTokenResponse> absApiCall) {
        PlatformAuthTokenThread.withAuthCode(this.mContext, str, str2, str3, str4, str5, String.valueOf(j), map, absApiCall).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void canAwemeQuickLogin(CanAwemeQuickLoginCallback canAwemeQuickLoginCallback) {
        CanAwemeQuickLoginJob.canAwemeQuickLogin(this.mContext, canAwemeQuickLoginCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void getOauthProfile(String str, String str2, String str3, String str4, String str5, String str6, Map<String, String> map, OauthProfileCallback oauthProfileCallback) {
        OauthProfileJob.getOauthProfile(this.mContext, str, str2, str3, str4, str5, str6, map, oauthProfileCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void getOauthProfileByCode(String str, String str2, String str3, long j, Map<String, String> map, OauthProfileCallback oauthProfileCallback) {
        OauthProfileJob.getOauthProfile(this.mContext, str, str2, str3, null, null, String.valueOf(j), map, oauthProfileCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void getOauthProfileByAccessToken(String str, String str2, String str3, long j, Map<String, String> map, OauthProfileCallback oauthProfileCallback) {
        OauthProfileJob.getOauthProfile(this.mContext, str, str2, null, str3, null, String.valueOf(j), map, oauthProfileCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void getOauthProfileByAccessToken(String str, String str2, String str3, String str4, long j, Map<String, String> map, OauthProfileCallback oauthProfileCallback) {
        OauthProfileJob.getOauthProfile(this.mContext, str, str2, null, str3, str4, String.valueOf(j), map, oauthProfileCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void authBindLoginWithProfileKey(String str, String str2, String str3, String str4, Map<String, String> map, UserBindCallback userBindCallback) {
        AuthBindLoginThread.authBindLoginWithProfileKey(this.mContext, str, str2, str3, str4, map, userBindCallback).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void getOauthToken(String str, String str2, String str3, Map<String, String> map, CommonCallBack<GetOauthTokenResponse> commonCallBack) {
        getOauthToken(str, str2, new String[]{str3}, map, true, commonCallBack);
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void getOauthToken(String str, String str2, String[] strArr, Map<String, String> map, boolean z, CommonCallBack<GetOauthTokenResponse> commonCallBack) {
        OauthTokenExtraParams oauthTokenExtraParams;
        if (map == null || map.isEmpty()) {
            oauthTokenExtraParams = null;
        } else {
            String remove = map.remove(ThirdPartyNetConstants.KEY_TRIGGER_SCENE);
            String remove2 = map.remove("enter_from");
            String remove3 = map.remove("trigger_path");
            String remove4 = map.remove("client_key");
            if (remove == null) {
                remove = "";
            }
            oauthTokenExtraParams = new OauthTokenExtraParams(remove, remove2, remove3, remove4, z);
        }
        getOauthToken(str, str2, strArr, map, oauthTokenExtraParams, commonCallBack);
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void getOauthToken(String str, final String str2, String[] strArr, Map<String, String> map, OauthTokenExtraParams oauthTokenExtraParams, CommonCallBack<GetOauthTokenResponse> commonCallBack) {
        Map<String, String> hashMap = map == null ? new HashMap() : map;
        OauthTokenExtraParams oauthTokenExtraParams2 = oauthTokenExtraParams == null ? new OauthTokenExtraParams("", "", "", "", true) : oauthTokenExtraParams;
        synchronized (this.getOauthTokenCallbacks) {
            LogHelper.d(TAG, String.format("getOauthToken: getOauthTokenCallbacksLock 竞争成功, %s callback 添加到列表", str2));
            if (!this.getOauthTokenCallbacks.containsKey(str2)) {
                LogHelper.d(TAG, "not contain " + str2 + ", add new list in callbacks");
                this.getOauthTokenCallbacks.put(str2, new ArrayList<>());
            } else {
                LogHelper.d(TAG, "contains " + str2);
            }
            this.getOauthTokenCallbacks.get(str2).add(new WeakReference<>(commonCallBack));
        }
        if (!this.getOauthTokenLock.containsKey(str2)) {
            synchronized (this.getOauthTokenLock) {
                if (!this.getOauthTokenLock.containsKey(str2)) {
                    LogHelper.d(TAG, "add new atomic boolean");
                    this.getOauthTokenLock.put(str2, new AtomicBoolean(false));
                }
            }
        }
        if (this.getOauthTokenLock.get(str2).compareAndSet(false, true)) {
            final HashMap hashMap2 = new HashMap();
            hashMap2.put(ThirdPartyNetConstants.KEY_TRIGGER_SCENE, oauthTokenExtraParams2.getTriggerScene());
            hashMap2.put("enter_from", oauthTokenExtraParams2.getEnterFrom());
            hashMap2.put("trigger_path", oauthTokenExtraParams2.getTriggerPath());
            hashMap2.put("client_key", oauthTokenExtraParams2.getClientKey());
            hashMap.put(ThirdPartyNetConstants.KEY_TRIGGER_SCENE, oauthTokenExtraParams2.getTriggerScene());
            getOauthTokenInner(str, str2, strArr, hashMap2, hashMap, oauthTokenExtraParams2, new CommonCallBack<GetOauthTokenResponse>() { // from class: com.bytedance.sdk.account.impl.BDAccountPlatformImpl.2
                @Override // com.bytedance.sdk.account.CommonCallBack
                public void onSuccess(GetOauthTokenResponse getOauthTokenResponse) {
                    BDAccountPlatformImpl.this.callbackGetOauthToken(hashMap2, str2, getOauthTokenResponse);
                }

                @Override // com.bytedance.sdk.account.CommonCallBack
                public void onError(GetOauthTokenResponse getOauthTokenResponse, int i) {
                    BDAccountPlatformImpl.this.callbackGetOauthToken(hashMap2, str2, getOauthTokenResponse);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackGetOauthToken(Map<String, String> map, String str, GetOauthTokenResponse getOauthTokenResponse) {
        ArrayList arrayList;
        synchronized (this.getOauthTokenCallbacks) {
            LogHelper.d(TAG, "getOauthToken: getOauthTokenCallbacksLock 竞争成功, 进行 callback,pid=" + str);
            ArrayList<WeakReference<CommonCallBack<GetOauthTokenResponse>>> arrayList2 = this.getOauthTokenCallbacks.get(str);
            if (arrayList2 == null || arrayList2.isEmpty()) {
                arrayList = null;
            } else {
                arrayList = new ArrayList(arrayList2);
                arrayList2.clear();
            }
            this.getOauthTokenLock.get(str).set(false);
        }
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                CommonCallBack commonCallBack = (CommonCallBack) ((WeakReference) it.next()).get();
                if (commonCallBack != null) {
                    commonCallBack.onResponse(getOauthTokenResponse);
                }
            }
        }
        if (!TextUtils.isEmpty(getOauthTokenResponse.oauthTokenResult)) {
            JSONObject jSONObject = new JSONObject(map);
            try {
                jSONObject.put(PageDataManager.EXTRA_STATUS, getOauthTokenResponse.oauthTokenResult);
                if (!TextUtils.isEmpty(getOauthTokenResponse.oauthTokenVersion)) {
                    jSONObject.put("api_version", getOauthTokenResponse.oauthTokenVersion);
                }
                if (TextUtils.equals("fail", getOauthTokenResponse.oauthTokenResult)) {
                    jSONObject.put("error_code", getOauthTokenResponse.error);
                    if (TextUtils.isEmpty(getOauthTokenResponse.errorMsg)) {
                        jSONObject.put("fail_info", getOauthTokenResponse.mDetailErrorMsg);
                    } else {
                        jSONObject.put("fail_info", getOauthTokenResponse.errorMsg);
                    }
                }
            } catch (JSONException unused) {
            }
            AccountMonitorUtil.onEventV3("passport_get_oauth_token_request_response", jSONObject);
        }
        JSONObject jSONObject2 = new JSONObject(map);
        try {
            if (getOauthTokenResponse.success) {
                jSONObject2.put(PageDataManager.EXTRA_STATUS, "success");
            } else {
                jSONObject2.put(PageDataManager.EXTRA_STATUS, "fail");
                jSONObject2.put("error_code", getOauthTokenResponse.error);
                if (TextUtils.isEmpty(getOauthTokenResponse.errorMsg)) {
                    jSONObject2.put("fail_info", getOauthTokenResponse.mDetailErrorMsg);
                } else {
                    jSONObject2.put("fail_info", getOauthTokenResponse.errorMsg);
                }
            }
            jSONObject2.put("is_login", BDAccountDelegateInner.instance().isLogin() ? 1 : 0);
            if (getOauthTokenResponse.bindStatus >= 0) {
                jSONObject2.put("is_bind", getOauthTokenResponse.bindStatus);
            }
            if (getOauthTokenResponse.tokenValid >= 0) {
                jSONObject2.put("token_valid", getOauthTokenResponse.tokenValid);
            }
            if (!TextUtils.isEmpty(getOauthTokenResponse.tokenInfoResult)) {
                jSONObject2.put("token_info_result", getOauthTokenResponse.tokenInfoResult);
            }
            if (!TextUtils.isEmpty(getOauthTokenResponse.oauthTokenResult)) {
                jSONObject2.put("oauth_token_result", getOauthTokenResponse.oauthTokenResult);
            }
        } catch (JSONException unused2) {
        }
        AccountMonitorUtil.onEventV3("passport_get_oauth_token", jSONObject2);
    }

    private void getOauthTokenInner(String str, final String str2, String[] strArr, final Map<String, String> map, final Map<String, String> map2, OauthTokenExtraParams oauthTokenExtraParams, final CommonCallBack<GetOauthTokenResponse> commonCallBack) {
        LogHelper.d(TAG, String.format("getOauthToken: getOauthTokenInner 开始, pid=%s", str2));
        if (!BDAccountDelegateInner.instance(this.mContext).isLogin()) {
            LogHelper.d(TAG, "getOauthTokenInner: 用户不在登录态下, 不进行请求, callback");
            GetOauthTokenResponse getOauthTokenResponse = new GetOauthTokenResponse(false, strArr[0], str2);
            getOauthTokenResponse.mDetailErrorCode = -1;
            getOauthTokenResponse.mDetailErrorMsg = "not login";
            commonCallBack.onError(getOauthTokenResponse, getOauthTokenResponse.mDetailErrorCode);
            return;
        }
        final BDAccountPlatformEntity validEntity = getValidEntity(strArr, str2);
        if (validEntity == null || !validEntity.mLogin) {
            LogHelper.d(TAG, "getOauthTokenInner: 没有相关绑定关系, callback");
            String str3 = validEntity == null ? strArr[0] : validEntity.mName;
            GetOauthTokenResponse getOauthTokenResponse2 = new GetOauthTokenResponse(false, str3, str2);
            getOauthTokenResponse2.error = AccountErrorCode.ERROR_THIRD_AUTH_UNBIND;
            getOauthTokenResponse2.mDetailErrorCode = AccountErrorCode.ERROR_THIRD_AUTH_UNBIND;
            getOauthTokenResponse2.mDetailErrorMsg = String.format("not bind %s", str3);
            getOauthTokenResponse2.bindStatus = 0;
            commonCallBack.onError(getOauthTokenResponse2, getOauthTokenResponse2.mDetailErrorCode);
            return;
        }
        String accessTokenWithExpirationCheck = validEntity.getAccessTokenWithExpirationCheck();
        final GetOauthTokenResponse getOauthTokenResponse3 = new GetOauthTokenResponse(true, validEntity.mName, str2);
        getOauthTokenResponse3.accessToken = accessTokenWithExpirationCheck;
        getOauthTokenResponse3.openId = validEntity.getOpenIdWithExpirationCheck();
        getOauthTokenResponse3.scopes = validEntity.getScopeWithExpirationCheck();
        getOauthTokenResponse3.expiresIn = validEntity.mExpireIn;
        getOauthTokenResponse3.refreshTime = validEntity.refreshTime;
        if (AuthExpirationConfigManager.isEnable()) {
            if (oauthTokenExtraParams.getImmediate()) {
                GetOauthTokenJob.getOauthTokenV2(this.mContext, str2, validEntity.mName, accessTokenWithExpirationCheck, map2, new CommonCallBack<GetOauthTokenResponse>() { // from class: com.bytedance.sdk.account.impl.BDAccountPlatformImpl.3
                    @Override // com.bytedance.sdk.account.CommonCallBack
                    public void onSuccess(GetOauthTokenResponse getOauthTokenResponse4) {
                        getOauthTokenResponse4.tokenInfoResult = "success";
                        getOauthTokenResponse4.oauthTokenVersion = ITaptapService.TAPTAP_VERSION_V2;
                        commonCallBack.onSuccess(getOauthTokenResponse4);
                    }

                    @Override // com.bytedance.sdk.account.CommonCallBack
                    public void onError(GetOauthTokenResponse getOauthTokenResponse4, int i) {
                        getOauthTokenResponse4.tokenInfoResult = "fail";
                        getOauthTokenResponse4.oauthTokenVersion = ITaptapService.TAPTAP_VERSION_V2;
                        commonCallBack.onError(getOauthTokenResponse4, i);
                    }
                }).start();
                return;
            } else {
                if (System.currentTimeMillis() > validEntity.refreshAt) {
                    GetOauthTokenJob.getOauthTokenV2(this.mContext, str2, validEntity.mName, accessTokenWithExpirationCheck, map2, new CommonCallBack<GetOauthTokenResponse>() { // from class: com.bytedance.sdk.account.impl.BDAccountPlatformImpl.4
                        @Override // com.bytedance.sdk.account.CommonCallBack
                        public void onSuccess(GetOauthTokenResponse getOauthTokenResponse4) {
                            getOauthTokenResponse4.oauthTokenResult = "success";
                            getOauthTokenResponse4.oauthTokenVersion = ITaptapService.TAPTAP_VERSION_V2;
                            getOauthTokenResponse4.tokenValid = 0;
                            commonCallBack.onSuccess(getOauthTokenResponse4);
                        }

                        @Override // com.bytedance.sdk.account.CommonCallBack
                        public void onError(GetOauthTokenResponse getOauthTokenResponse4, int i) {
                            getOauthTokenResponse4.oauthTokenResult = "fail";
                            getOauthTokenResponse4.oauthTokenVersion = ITaptapService.TAPTAP_VERSION_V2;
                            getOauthTokenResponse4.tokenValid = 0;
                            commonCallBack.onError(getOauthTokenResponse4, i);
                        }
                    }).start();
                    return;
                }
                LogHelper.d(TAG, "getOauthTokenInner: access token 缓存不为空, 本地判断在有效期内, 直接返回");
                getOauthTokenResponse3.tokenValid = 1;
                commonCallBack.onSuccess(getOauthTokenResponse3);
                return;
            }
        }
        if (TextUtils.isEmpty(accessTokenWithExpirationCheck)) {
            LogHelper.d(TAG, "getOauthTokenInner: access token 缓存为空, getOauthToken 进行网络请求");
            GetOauthTokenJob.getOauthToken(this.mContext, str2, validEntity.mName, map2, new CommonCallBack<GetOauthTokenResponse>() { // from class: com.bytedance.sdk.account.impl.BDAccountPlatformImpl.5
                @Override // com.bytedance.sdk.account.CommonCallBack
                public void onSuccess(GetOauthTokenResponse getOauthTokenResponse4) {
                    getOauthTokenResponse4.oauthTokenResult = "success";
                    getOauthTokenResponse4.oauthTokenVersion = "v1";
                    getOauthTokenResponse4.tokenValid = 0;
                    commonCallBack.onSuccess(getOauthTokenResponse4);
                }

                @Override // com.bytedance.sdk.account.CommonCallBack
                public void onError(GetOauthTokenResponse getOauthTokenResponse4, int i) {
                    getOauthTokenResponse4.oauthTokenResult = "fail";
                    getOauthTokenResponse4.oauthTokenVersion = "v1";
                    getOauthTokenResponse4.tokenValid = 0;
                    commonCallBack.onError(getOauthTokenResponse4, i);
                }
            }).start();
            return;
        }
        LogHelper.d(TAG, "getOauthTokenInner: access token 缓存不为空, 调用 openTokenInfo 接口进行有效期验证");
        HashMap hashMap = new HashMap();
        hashMap.put("enable_ticket_guard", "1");
        hashMap.put(ThirdPartyNetConstants.KEY_TRIGGER_SCENE, oauthTokenExtraParams.getTriggerScene());
        openTokenInfo(str, accessTokenWithExpirationCheck, hashMap, new CommonCallBack<OpenTokenInfoResponse>() { // from class: com.bytedance.sdk.account.impl.BDAccountPlatformImpl.6
            @Override // com.bytedance.sdk.account.CommonCallBack
            public void onSuccess(OpenTokenInfoResponse openTokenInfoResponse) {
                LogHelper.d(BDAccountPlatformImpl.TAG, "getOauthTokenInner: onSuccess: openTokenInfo 成功");
                JSONObject jSONObject = new JSONObject(map);
                try {
                    jSONObject.put(PageDataManager.EXTRA_STATUS, "success");
                } catch (JSONException unused) {
                }
                AccountMonitorUtil.onEventV3("passport_token_info_request_response", jSONObject);
                getOauthTokenResponse3.tokenValid = 1;
                getOauthTokenResponse3.tokenInfoResult = "success";
                commonCallBack.onSuccess(getOauthTokenResponse3);
            }

            @Override // com.bytedance.sdk.account.CommonCallBack
            public void onError(OpenTokenInfoResponse openTokenInfoResponse, int i) {
                LogHelper.d(BDAccountPlatformImpl.TAG, "getOauthTokenInner: onError: openTokenInfo 失败, getOauthToken 进行网络请求");
                GetOauthTokenJob.getOauthToken(BDAccountPlatformImpl.this.mContext, str2, validEntity.mName, map2, new CommonCallBack<GetOauthTokenResponse>() { // from class: com.bytedance.sdk.account.impl.BDAccountPlatformImpl.6.1
                    @Override // com.bytedance.sdk.account.CommonCallBack
                    public void onSuccess(GetOauthTokenResponse getOauthTokenResponse4) {
                        getOauthTokenResponse4.tokenValid = 0;
                        getOauthTokenResponse4.oauthTokenResult = "success";
                        getOauthTokenResponse4.oauthTokenVersion = "v1";
                        getOauthTokenResponse4.tokenInfoResult = "fail";
                        commonCallBack.onSuccess(getOauthTokenResponse4);
                    }

                    @Override // com.bytedance.sdk.account.CommonCallBack
                    public void onError(GetOauthTokenResponse getOauthTokenResponse4, int i2) {
                        getOauthTokenResponse4.tokenValid = 0;
                        getOauthTokenResponse4.oauthTokenResult = "fail";
                        getOauthTokenResponse4.oauthTokenVersion = "v1";
                        getOauthTokenResponse4.tokenInfoResult = "fail";
                        commonCallBack.onError(getOauthTokenResponse4, i2);
                    }
                }).start();
                JSONObject jSONObject = new JSONObject(map);
                try {
                    jSONObject.put(PageDataManager.EXTRA_STATUS, "fail");
                    jSONObject.put("error_code", i);
                    jSONObject.put("fail_info", openTokenInfoResponse.errorMsg);
                } catch (JSONException unused) {
                }
                AccountMonitorUtil.onEventV3("passport_token_info_request_response", jSONObject);
            }
        });
    }

    private BDAccountPlatformEntity getValidEntity(String[] strArr, String str) {
        IBDAccountUserEntity userInfo;
        BDAccountPlatformEntity bDAccountPlatformEntity;
        if (strArr == null || strArr.length == 0 || (userInfo = BDAccountDelegateInner.instance().getUserInfo()) == null) {
            return null;
        }
        Map<String, Map<String, BDAccountPlatformEntity>> map = userInfo.thirdPlatform;
        for (String str2 : strArr) {
            Map<String, BDAccountPlatformEntity> map2 = map.get(str2);
            if (map2 != null && (bDAccountPlatformEntity = map2.get(str)) != null) {
                return bDAccountPlatformEntity;
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void updateAuthorizeInfo(String str, String str2, String str3, Map<String, String> map, CommonCallBack<UpdateAuthorizeInfoResponse> commonCallBack) {
        UpdateAuthorizeInfoJob.updateAuthorizeInfo(this.mContext, str, null, null, null, null, str2, str3, map, commonCallBack).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void updateAuthorizeInfo(String str, String str2, String str3, String str4, String str5, String str6, Map<String, String> map, CommonCallBack<UpdateAuthorizeInfoResponse> commonCallBack) {
        UpdateAuthorizeInfoJob.updateAuthorizeInfo(this.mContext, null, str, str2, str3, str4, str5, str6, map, commonCallBack).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void authChangeBind(String str, String str2, String str3, String str4, boolean z, boolean z2, Map<String, String> map, CommonCallBack<UserApiResponse> commonCallBack) {
        AuthChangeBindThread.authChangeBind(this.mContext, str, str2, null, null, str3, str4, z, z2, map, commonCallBack).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void authChangeBindWithAuthCodeOrAccessToken(String str, String str2, String str3, String str4, boolean z, boolean z2, Map<String, String> map, CommonCallBack<UserApiResponse> commonCallBack) {
        AuthChangeBindThread.authChangeBind(this.mContext, str, str2, str3, str4, null, null, z, z2, map, commonCallBack).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void authLoginAuthorize(Map<String, String> map, CommonCallBack<AuthLoginAuthorizeResponse> commonCallBack) {
        AuthLoginAuthorizeThread.authLoginAuthorize(this.mContext, map, commonCallBack).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void authCodeAccessToken(String str, String str2, String str3, String str4, String str5, Map<String, String> map, CommonCallBack<AuthCodeAccessTokenResponse> commonCallBack) {
        AuthCodeAccessTokenThread.authCodeAccessToken(this.mContext, str, str2, str3, str4, str5, map, commonCallBack).start();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccountPlatformAPI
    public void openTokenInfo(String str, String str2, Map<String, String> map, CommonCallBack<OpenTokenInfoResponse> commonCallBack) {
        OpenTokenInfoThread.openTokenInfo(this.mContext, str, str2, map, commonCallBack).start();
    }
}
