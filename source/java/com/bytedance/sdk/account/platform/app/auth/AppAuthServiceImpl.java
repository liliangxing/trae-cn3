package com.bytedance.sdk.account.platform.app.auth;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import com.bytedance.sdk.account.platform.api.IAppAuthService;
import com.bytedance.sdk.account.platform.base.AuthorizeCallback;
import com.bytedance.sdk.account.platform.base.AuthorizeErrorResponse;
import com.bytedance.sdk.account.platform.base.AuthorizeMonitorUtil;
import com.bytedance.sdk.account.platform.base.Request;
import net.openid.appauth.AuthState;
import net.openid.appauth.AuthorizationException;
import net.openid.appauth.AuthorizationRequest;
import net.openid.appauth.AuthorizationResponse;
import net.openid.appauth.AuthorizationService;
import net.openid.appauth.AuthorizationServiceConfiguration;
import net.openid.appauth.TokenResponse;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class AppAuthServiceImpl implements IAppAuthService {
    private static final int CODE_REQ = 100;
    private static final String ERROR_MSG = "response null";
    private static final String ERROR_MSG_CONTEXT = "context null";
    private static final String ERROR_MSG_DATA_NULL = "activity result null";
    private static final String PLATFORM = "app_auth";
    private String clientId;
    private AuthorizationServiceConfiguration serviceConfiguration;

    public AppAuthServiceImpl(String str, String str2, String str3) {
        try {
            this.clientId = str3;
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !Patterns.WEB_URL.matcher(str).matches() || !Patterns.WEB_URL.matcher(str2).matches()) {
                return;
            }
            this.serviceConfiguration = new AuthorizationServiceConfiguration(Uri.parse(str), Uri.parse(str2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public AppAuthServiceImpl(String str, String str2) {
        try {
            this.clientId = str2;
            if (TextUtils.isEmpty(str) || !Patterns.WEB_URL.matcher(str2).matches()) {
                return;
            }
            AuthorizationServiceConfiguration.fetchFromIssuer(Uri.parse(str), new AuthorizationServiceConfiguration.RetrieveConfigurationCallback() { // from class: com.bytedance.sdk.account.platform.app.auth.AppAuthServiceImpl.1
                public void onFetchConfigurationCompleted(AuthorizationServiceConfiguration authorizationServiceConfiguration, AuthorizationException authorizationException) {
                    if (authorizationException == null) {
                        AppAuthServiceImpl.this.serviceConfiguration = authorizationServiceConfiguration;
                    } else {
                        authorizationException.printStackTrace();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x006b, code lost:
    
        if (r8.responseType.equals("id_token") != false) goto L27;
     */
    @Override // com.bytedance.sdk.account.platform.api.IAppAuthService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public IAppAuthService.CallbackHandler authorize(Activity activity, Request request, AuthorizeCallback authorizeCallback) {
        Uri parse;
        if (request != null && request.redirectUri != null) {
            parse = request.redirectUri;
        } else {
            String packageName = (activity == null || activity.getApplicationContext() == null) ? null : activity.getApplicationContext().getPackageName();
            parse = !TextUtils.isEmpty(packageName) ? Uri.parse(packageName + ":/oauth2callback") : null;
        }
        if (this.serviceConfiguration == null || TextUtils.isEmpty(this.clientId) || request == null || parse == null) {
            return null;
        }
        String str = "token";
        if (!TextUtils.isEmpty(request.responseType)) {
            String str2 = request.responseType.equals("code") ? "code" : "id_token";
            str = str2;
        }
        AuthorizationRequest.Builder builder = new AuthorizationRequest.Builder(this.serviceConfiguration, this.clientId, str, parse);
        builder.setScopes(request.scopes);
        builder.setState(request.state);
        AuthorizationRequest build = builder.build();
        AuthorizationService authorizationService = new AuthorizationService(activity);
        activity.startActivityForResult(authorizationService.getAuthorizationRequestIntent(build), 100);
        return new AppAuthHandlerImpl(activity, authorizationService, authorizeCallback);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private static class AppAuthHandlerImpl implements IAppAuthService.CallbackHandler {
        AuthorizationService authorizationService;
        AuthorizeCallback callback;
        Context context;

        private AppAuthHandlerImpl(Context context, AuthorizationService authorizationService, AuthorizeCallback authorizeCallback) {
            this.context = context;
            this.authorizationService = authorizationService;
            this.callback = authorizeCallback;
        }

        @Override // com.bytedance.sdk.account.platform.base.ActivityResultHandler
        public void onActivityResult(int i, int i2, Intent intent) {
            if (i == 100) {
                handleAuthorizationResponse(intent);
            }
        }

        @Override // com.bytedance.sdk.account.platform.api.IAppAuthService.CallbackHandler
        public void onDestroy() {
            if (this.callback != null) {
                this.callback = null;
            }
            if (this.context != null) {
                this.context = null;
            }
            AuthorizationService authorizationService = this.authorizationService;
            if (authorizationService != null) {
                authorizationService.dispose();
            }
        }

        private void handleAuthorizationResponse(Intent intent) {
            try {
                if (intent == null) {
                    if (this.callback != null) {
                        AuthorizeMonitorUtil.onPlatformAuthEvent(AppAuthServiceImpl.PLATFORM, 0, null, AppAuthServiceImpl.ERROR_MSG_DATA_NULL, false, null);
                        this.callback.onError(new AuthorizeErrorResponse(AppAuthServiceImpl.ERROR_MSG_DATA_NULL));
                        return;
                    }
                    return;
                }
                AuthorizationResponse fromIntent = AuthorizationResponse.fromIntent(intent);
                AuthorizationException fromIntent2 = AuthorizationException.fromIntent(intent);
                final AuthState authState = new AuthState(fromIntent, fromIntent2);
                if (fromIntent != null) {
                    if (this.context == null) {
                        if (this.callback != null) {
                            AuthorizeMonitorUtil.onPlatformAuthEvent(AppAuthServiceImpl.PLATFORM, 0, null, AppAuthServiceImpl.ERROR_MSG_CONTEXT, false, null);
                            this.callback.onError(new AuthorizeErrorResponse(AppAuthServiceImpl.ERROR_MSG_CONTEXT));
                            return;
                        }
                        return;
                    }
                    this.authorizationService.performTokenRequest(fromIntent.createTokenExchangeRequest(), new AuthorizationService.TokenResponseCallback() { // from class: com.bytedance.sdk.account.platform.app.auth.AppAuthServiceImpl.AppAuthHandlerImpl.1
                        public void onTokenRequestCompleted(TokenResponse tokenResponse, AuthorizationException authorizationException) {
                            if (authorizationException != null) {
                                AuthorizeErrorResponse authorizeErrorResponse = new AuthorizeErrorResponse(authorizationException.code, authorizationException.error, authorizationException.errorDescription);
                                if (AppAuthHandlerImpl.this.callback != null) {
                                    AuthorizeMonitorUtil.onPlatformAuthEvent(AppAuthServiceImpl.PLATFORM, 0, authorizeErrorResponse.platformErrorCode, authorizeErrorResponse.platformErrorMsg + ", " + authorizeErrorResponse.platformErrorDetail, authorizeErrorResponse.isCancel, null);
                                    AppAuthHandlerImpl.this.callback.onError(authorizeErrorResponse);
                                    return;
                                }
                                return;
                            }
                            if (tokenResponse != null) {
                                authState.update(tokenResponse, authorizationException);
                                if (AppAuthHandlerImpl.this.callback != null) {
                                    AuthorizeMonitorUtil.onPlatformAuthEvent(AppAuthServiceImpl.PLATFORM, 1, null, null, false, null);
                                    AppAuthHandlerImpl.this.callback.onSuccess(AppAuthHandlerImpl.this.toBundleResult(authState));
                                }
                            }
                        }
                    });
                    return;
                }
                if (fromIntent2 != null) {
                    AuthorizeErrorResponse authorizeErrorResponse = new AuthorizeErrorResponse(fromIntent2.code, fromIntent2.error, fromIntent2.errorDescription);
                    if (fromIntent2.code == AuthorizationException.GeneralErrors.PROGRAM_CANCELED_AUTH_FLOW.code) {
                        authorizeErrorResponse.isCancel = true;
                    }
                    if (this.callback != null) {
                        AuthorizeMonitorUtil.onPlatformAuthEvent(AppAuthServiceImpl.PLATFORM, 0, authorizeErrorResponse.platformErrorCode, authorizeErrorResponse.platformErrorMsg + ", " + authorizeErrorResponse.platformErrorDetail, authorizeErrorResponse.isCancel, null);
                        this.callback.onError(authorizeErrorResponse);
                        return;
                    }
                    return;
                }
                if (this.callback != null) {
                    AuthorizeMonitorUtil.onPlatformAuthEvent(AppAuthServiceImpl.PLATFORM, 0, null, "response null", false, null);
                    this.callback.onError(new AuthorizeErrorResponse("response null"));
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.callback != null) {
                    AuthorizeMonitorUtil.onPlatformAuthEvent(AppAuthServiceImpl.PLATFORM, 0, null, e.getMessage(), false, null);
                    this.callback.onError(new AuthorizeErrorResponse(e.getMessage()));
                }
            }
        }

        private void addString(Bundle bundle, String str, String str2) {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            bundle.putString(str, str2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Bundle toBundleResult(AuthState authState) {
            if (authState == null) {
                return null;
            }
            Bundle bundle = new Bundle();
            AuthorizationResponse lastAuthorizationResponse = authState.getLastAuthorizationResponse();
            if (lastAuthorizationResponse != null) {
                addString(bundle, "auth_code", lastAuthorizationResponse.authorizationCode);
                addString(bundle, "state", lastAuthorizationResponse.state);
            }
            addString(bundle, "scope", authState.getScope());
            addString(bundle, "id_token", authState.getIdToken());
            addString(bundle, "access_token", authState.getAccessToken());
            if (authState.getAccessTokenExpirationTime() != null) {
                bundle.putLong(IAppAuthService.ResponseKey.ACCESS_TOKEN_EXPIRATION_TIME, authState.getAccessTokenExpirationTime().longValue());
            }
            addString(bundle, "refresh_token", authState.getRefreshToken());
            return bundle;
        }
    }
}
