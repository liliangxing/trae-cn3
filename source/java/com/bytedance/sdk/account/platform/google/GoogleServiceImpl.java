package com.bytedance.sdk.account.platform.google;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.account.platform.api.IAppAuthService;
import com.bytedance.sdk.account.platform.api.IGoogleService;
import com.bytedance.sdk.account.platform.base.AuthorizeCallback;
import com.bytedance.sdk.account.platform.base.AuthorizeErrorResponse;
import com.bytedance.sdk.account.platform.base.AuthorizeFramework;
import com.bytedance.sdk.account.platform.base.AuthorizeMonitorUtil;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.bytedance.sdk.account.platform.base.Request;
import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.auth.api.identity.BeginSignInResult;
import com.google.android.gms.auth.api.identity.Identity;
import com.google.android.gms.auth.api.identity.SignInCredential;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class GoogleServiceImpl implements IGoogleService {
    private static final String PLATFORM = "google";
    public static final int REQUEST_CODE_ONE_TAP = 2301;
    public static final int REQUEST_CODE_SIGIN = 2300;
    private static BeginSignInResult oneTapSignInResult;
    private String appId;
    private Context mContext;
    private GoogleSignInClient mGoogleSignInClient;
    private GoogleSignInOptions mGso;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GoogleServiceImpl(Context context, String str) {
        this.appId = str;
        this.mContext = context;
        this.mGso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken(str).requestEmail().build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class GoogleHandlerImpl implements IGoogleService.CallbackHandler {
        Activity activity;
        AuthorizeCallback callback;
        IAppAuthService.CallbackHandler callbackHandler;
        String nonce;

        private GoogleHandlerImpl(Activity activity, String str, AuthorizeCallback authorizeCallback) {
            this.activity = activity;
            this.nonce = str;
            this.callback = authorizeCallback;
        }

        private GoogleHandlerImpl(Activity activity, IAppAuthService.CallbackHandler callbackHandler) {
            this.activity = activity;
            this.callbackHandler = callbackHandler;
        }

        @Override // com.bytedance.sdk.account.platform.base.ActivityResultHandler
        public void onActivityResult(int i, int i2, Intent intent) {
            if (this.callback == null) {
                IAppAuthService.CallbackHandler callbackHandler = this.callbackHandler;
                if (callbackHandler != null) {
                    callbackHandler.onActivityResult(i, i2, intent);
                    return;
                }
                return;
            }
            if (i == 2300) {
                handleSignInResult(intent);
            } else if (i == 2301) {
                handleOneTapResult(intent);
            }
        }

        private void handleSignInResult(Intent intent) {
            try {
                GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) GoogleSignIn.getSignedInAccountFromIntent(intent).getResult(ApiException.class);
                String id = googleSignInAccount.getId();
                String idToken = googleSignInAccount.getIdToken();
                String displayName = googleSignInAccount.getDisplayName();
                String familyName = googleSignInAccount.getFamilyName();
                String givenName = googleSignInAccount.getGivenName();
                String serverAuthCode = googleSignInAccount.getServerAuthCode();
                String email = googleSignInAccount.getEmail();
                Uri photoUrl = googleSignInAccount.getPhotoUrl();
                Set grantedScopes = googleSignInAccount.getGrantedScopes();
                StringBuilder sb = new StringBuilder();
                Iterator it = grantedScopes.iterator();
                while (it.hasNext()) {
                    sb.append(((Scope) it.next()).getScopeUri()).append(',');
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                Bundle bundle = new Bundle();
                bundle.putString("id", id);
                bundle.putString(IGoogleService.ResponseKey.ID_TOKEN, idToken);
                bundle.putString(IGoogleService.ResponseKey.DISPLAY_NAME, displayName);
                bundle.putString(IGoogleService.ResponseKey.FAMILY_NAME, familyName);
                bundle.putString(IGoogleService.ResponseKey.GIVEN_NAME, givenName);
                bundle.putString(IGoogleService.ResponseKey.SERVER_AUTH_CODE, serverAuthCode);
                bundle.putString("email", email);
                if (photoUrl != null) {
                    bundle.putString(IGoogleService.ResponseKey.PROFILE_PICTURE_URI, photoUrl.toString());
                }
                bundle.putString(IGoogleService.ResponseKey.GRANTED_SCOPES, sb.toString());
                callbackSuccess(bundle);
            } catch (ApiException e) {
                callbackError(e.getStatusCode() + "", e.getMessage(), 16 == e.getStatusCode());
            }
        }

        private void handleOneTapResult(Intent intent) {
            try {
                SignInCredential signInCredentialFromIntent = Identity.getSignInClient(this.activity).getSignInCredentialFromIntent(intent);
                String googleIdToken = signInCredentialFromIntent.getGoogleIdToken();
                String id = signInCredentialFromIntent.getId();
                String displayName = signInCredentialFromIntent.getDisplayName();
                String familyName = signInCredentialFromIntent.getFamilyName();
                String givenName = signInCredentialFromIntent.getGivenName();
                String phoneNumber = signInCredentialFromIntent.getPhoneNumber();
                String password = signInCredentialFromIntent.getPassword();
                Uri profilePictureUri = signInCredentialFromIntent.getProfilePictureUri();
                Bundle bundle = new Bundle();
                bundle.putString("id", id);
                bundle.putString(IGoogleService.ResponseKey.ID_TOKEN, googleIdToken);
                bundle.putString(IGoogleService.ResponseKey.DISPLAY_NAME, displayName);
                bundle.putString(IGoogleService.ResponseKey.FAMILY_NAME, familyName);
                bundle.putString(IGoogleService.ResponseKey.GIVEN_NAME, givenName);
                bundle.putString(IGoogleService.ResponseKey.PHONE_NUMBER, phoneNumber);
                bundle.putString(IGoogleService.ResponseKey.PASSWORD, password);
                if (profilePictureUri != null) {
                    bundle.putString(IGoogleService.ResponseKey.PROFILE_PICTURE_URI, profilePictureUri.toString());
                }
                bundle.putString("nonce", this.nonce);
                callbackSuccess(bundle);
            } catch (ApiException e) {
                callbackError("" + e.getStatusCode(), "handle google one tap result fail", e.getStatusCode() == 16);
            }
        }

        private void callbackSuccess(Bundle bundle) {
            this.nonce = null;
            AuthorizeMonitorUtil.onPlatformAuthEvent(GoogleServiceImpl.PLATFORM, 1, null, null, false, null);
            AuthorizeCallback authorizeCallback = this.callback;
            if (authorizeCallback != null) {
                authorizeCallback.onSuccess(bundle);
            }
            this.callback = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void callbackError(String str, String str2, boolean z) {
            this.nonce = null;
            AuthorizeErrorResponse authorizeErrorResponse = new AuthorizeErrorResponse(str, str2);
            authorizeErrorResponse.isCancel = z;
            AuthorizeMonitorUtil.onPlatformAuthEvent(GoogleServiceImpl.PLATFORM, 0, authorizeErrorResponse.platformErrorCode, authorizeErrorResponse.platformErrorMsg, authorizeErrorResponse.isCancel, null);
            AuthorizeCallback authorizeCallback = this.callback;
            if (authorizeCallback != null) {
                authorizeCallback.onError(authorizeErrorResponse);
            }
            this.callback = null;
        }

        @Override // com.bytedance.sdk.account.platform.api.IGoogleService.CallbackHandler
        public void onDestroy() {
            BeginSignInResult unused = GoogleServiceImpl.oneTapSignInResult = null;
        }
    }

    @Override // com.bytedance.sdk.account.platform.api.IGoogleService
    public IGoogleService.CallbackHandler authorize(Activity activity, int i, AuthorizeCallback authorizeCallback) {
        return authorize(activity, i, null, false, authorizeCallback);
    }

    @Override // com.bytedance.sdk.account.platform.api.IGoogleService
    public IGoogleService.CallbackHandler authorize(Activity activity, int i, Set<String> set, boolean z, AuthorizeCallback authorizeCallback) {
        if (set != null) {
            GoogleSignInOptions.Builder requestEmail = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken(this.appId).requestEmail();
            for (String str : set) {
                if (!TextUtils.isEmpty(str)) {
                    requestEmail.requestScopes(new Scope(str), new Scope[0]);
                }
            }
            if (z) {
                requestEmail.requestServerAuthCode(this.appId);
            }
            this.mGso = requestEmail.build();
        }
        if (i == 0) {
            return authorize(activity, authorizeCallback);
        }
        if (i == 1) {
            if (isGooglePlayServiceAvailable()) {
                return authorize(activity, authorizeCallback);
            }
            return webAuthorize(activity, authorizeCallback);
        }
        return webAuthorize(activity, authorizeCallback);
    }

    @Override // com.bytedance.sdk.account.platform.api.IGoogleService
    public void canShowGoogleOneTap(Activity activity, Bundle bundle, final IGoogleService.CheckOneTapCallback checkOneTapCallback) {
        boolean z;
        if (!isGooglePlayServiceAvailable()) {
            if (checkOneTapCallback != null) {
                checkOneTapCallback.onResult(-1, "google service unavailable");
                return;
            }
            return;
        }
        String str = null;
        boolean z2 = false;
        if (bundle != null) {
            boolean z3 = bundle.getBoolean(IGoogleService.RequestKey.FILTER_BY_AUTHORIZED_ACCOUNTS, false);
            boolean z4 = bundle.getBoolean(IGoogleService.RequestKey.AUTO_SELECT_ENABLED, false);
            str = bundle.getString("nonce", null);
            z = z4;
            z2 = z3;
        } else {
            z = false;
        }
        Identity.getSignInClient(activity).beginSignIn(BeginSignInRequest.builder().setGoogleIdTokenRequestOptions(BeginSignInRequest.GoogleIdTokenRequestOptions.builder().setSupported(true).setNonce(str).setServerClientId(this.appId).setFilterByAuthorizedAccounts(z2).build()).setAutoSelectEnabled(z).build()).addOnSuccessListener(new OnSuccessListener<BeginSignInResult>() { // from class: com.bytedance.sdk.account.platform.google.GoogleServiceImpl.3
            public void onSuccess(BeginSignInResult beginSignInResult) {
                Log.d("GoogleServiceImpl", "authorizeOneTap onSuccess" + beginSignInResult.getPendingIntent());
                BeginSignInResult unused = GoogleServiceImpl.oneTapSignInResult = beginSignInResult;
                IGoogleService.CheckOneTapCallback checkOneTapCallback2 = checkOneTapCallback;
                if (checkOneTapCallback2 != null) {
                    checkOneTapCallback2.onResult(0, "");
                }
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: com.bytedance.sdk.account.platform.google.GoogleServiceImpl.2
            public void onFailure(Exception exc) {
                Log.d("GoogleServiceImpl", "authorizeOneTap onFailure", exc);
                IGoogleService.CheckOneTapCallback checkOneTapCallback2 = checkOneTapCallback;
                if (checkOneTapCallback2 != null) {
                    checkOneTapCallback2.onResult(-1, "start google one tap sign in fail");
                }
            }
        }).addOnCanceledListener(new OnCanceledListener() { // from class: com.bytedance.sdk.account.platform.google.GoogleServiceImpl.1
            public void onCanceled() {
                Log.d("GoogleServiceImpl", "authorizeOneTap onCanceled");
                IGoogleService.CheckOneTapCallback checkOneTapCallback2 = checkOneTapCallback;
                if (checkOneTapCallback2 != null) {
                    checkOneTapCallback2.onResult(-2, "user cancel");
                }
            }
        });
    }

    @Override // com.bytedance.sdk.account.platform.api.IGoogleService
    public IGoogleService.CallbackHandler authorizeOneTap(final Activity activity, Bundle bundle, AuthorizeCallback authorizeCallback) {
        final GoogleHandlerImpl googleHandlerImpl = new GoogleHandlerImpl(activity, bundle != null ? bundle.getString("nonce", null) : null, authorizeCallback);
        BeginSignInResult beginSignInResult = oneTapSignInResult;
        if (beginSignInResult != null) {
            realShowGoogleOneTap(activity, beginSignInResult, googleHandlerImpl);
            oneTapSignInResult = null;
        } else {
            canShowGoogleOneTap(activity, bundle, new IGoogleService.CheckOneTapCallback() { // from class: com.bytedance.sdk.account.platform.google.GoogleServiceImpl.4
                @Override // com.bytedance.sdk.account.platform.api.IGoogleService.CheckOneTapCallback
                public void onResult(int i, String str) {
                    if (i == 0) {
                        GoogleServiceImpl.this.realShowGoogleOneTap(activity, GoogleServiceImpl.oneTapSignInResult, googleHandlerImpl);
                    } else {
                        googleHandlerImpl.callbackError(i + "", str, i == 2);
                    }
                }
            });
        }
        return googleHandlerImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void realShowGoogleOneTap(Activity activity, BeginSignInResult beginSignInResult, GoogleHandlerImpl googleHandlerImpl) {
        try {
            activity.startIntentSenderForResult(beginSignInResult.getPendingIntent().getIntentSender(), REQUEST_CODE_ONE_TAP, null, 0, 0, 0);
        } catch (Exception e) {
            e.printStackTrace();
            if (googleHandlerImpl != null) {
                googleHandlerImpl.callbackError(OnekeyLoginConstants.ErrorCode.ERROR_CODE_UNKNOW, "show google one tap page fail", false);
            }
        }
    }

    private IGoogleService.CallbackHandler webAuthorize(Activity activity, AuthorizeCallback authorizeCallback) {
        HashSet hashSet = new HashSet();
        hashSet.add(IAppAuthService.Scope.PROFILE);
        Request build = new Request.Builder().setResponseType("code").setScopes(hashSet).setState("app_auth").build();
        IAppAuthService iAppAuthService = (IAppAuthService) AuthorizeFramework.getService(IAppAuthService.class);
        if (iAppAuthService != null) {
            return new GoogleHandlerImpl(activity, iAppAuthService.authorize(activity, build, authorizeCallback));
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private IGoogleService.CallbackHandler authorize(Activity activity, AuthorizeCallback authorizeCallback) {
        GoogleSignInClient client = GoogleSignIn.getClient(this.mContext, this.mGso);
        this.mGoogleSignInClient = client;
        activity.startActivityForResult(client.getSignInIntent(), REQUEST_CODE_SIGIN);
        return new GoogleHandlerImpl(activity, null, authorizeCallback);
    }

    private void onStart(Activity activity) {
        GoogleSignIn.getLastSignedInAccount(activity);
    }

    @Override // com.bytedance.sdk.account.platform.api.IGoogleService
    public void googleSignOut(Activity activity) {
        try {
            GoogleSignInClient client = GoogleSignIn.getClient(this.mContext, this.mGso);
            this.mGoogleSignInClient = client;
            client.signOut().addOnCompleteListener(new OnCompleteListener<Void>() { // from class: com.bytedance.sdk.account.platform.google.GoogleServiceImpl.5
                public void onComplete(Task<Void> task) {
                    GoogleServiceImpl.this.mGoogleSignInClient = null;
                }
            });
            Identity.getSignInClient(activity).signOut();
        } catch (Exception unused) {
            this.mGoogleSignInClient = null;
        }
    }

    @Override // com.bytedance.sdk.account.platform.api.IGoogleService
    public void revokeAccess() {
        try {
            GoogleSignInClient client = GoogleSignIn.getClient(this.mContext, this.mGso);
            this.mGoogleSignInClient = client;
            client.revokeAccess();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.bytedance.sdk.account.platform.api.IGoogleService
    public boolean isGooglePlayServiceAvailable() {
        try {
            return GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this.mContext) == 0;
        } catch (Exception unused) {
            return false;
        }
    }
}
