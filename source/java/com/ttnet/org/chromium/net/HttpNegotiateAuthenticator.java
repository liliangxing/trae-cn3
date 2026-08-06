package com.ttnet.org.chromium.net;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import androidx.core.content.ContextCompat;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.ss.android.socialbase.appdownloader.constants.Constants;
import com.ttnet.org.chromium.base.ApplicationStatus;
import com.ttnet.org.chromium.base.ContextUtils;
import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import java.io.IOException;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

@JNINamespace("net::android")
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class HttpNegotiateAuthenticator {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "net_auth";
    private final String mAccountType;
    private Bundle mSpnegoContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface Natives {
        void setResult(long j, HttpNegotiateAuthenticator httpNegotiateAuthenticator, int i, String str);
    }

    private void requestTokenWithActivity(Context context, Activity activity, RequestData requestData, String[] strArr) {
    }

    private void requestTokenWithoutActivity(Context context, RequestData requestData, String[] strArr) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class RequestData {
        public Account account;
        public AccountManager accountManager;
        public String authTokenType;
        public long nativeResultObject;
        public Bundle options;

        RequestData() {
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    class GetAccountsCallback implements AccountManagerCallback<Account[]> {
        private final RequestData mRequestData;

        public GetAccountsCallback(RequestData requestData) {
            this.mRequestData = requestData;
        }

        @Override // android.accounts.AccountManagerCallback
        public void run(AccountManagerFuture<Account[]> accountManagerFuture) {
            try {
                Account[] result = accountManagerFuture.getResult();
                if (result.length == 0) {
                    Log.m285w(HttpNegotiateAuthenticator.TAG, "ERR_MISSING_AUTH_CREDENTIALS: No account provided for the kerberos authentication. Please verify the configuration policies and that the CONTACTS runtime permission is granted. ", new Object[0]);
                    HttpNegotiateAuthenticatorJni.get().setResult(this.mRequestData.nativeResultObject, HttpNegotiateAuthenticator.this, NetError.ERR_MISSING_AUTH_CREDENTIALS, null);
                } else if (result.length > 1) {
                    Log.m285w(HttpNegotiateAuthenticator.TAG, "ERR_MISSING_AUTH_CREDENTIALS: Found %d accounts eligible for the kerberos authentication. Please fix the configuration by providing a single account.", Integer.valueOf(result.length));
                    HttpNegotiateAuthenticatorJni.get().setResult(this.mRequestData.nativeResultObject, HttpNegotiateAuthenticator.this, NetError.ERR_MISSING_AUTH_CREDENTIALS, null);
                }
            } catch (AuthenticatorException | OperationCanceledException | IOException e) {
                Log.m285w(HttpNegotiateAuthenticator.TAG, "ERR_UNEXPECTED: Error while attempting to retrieve accounts.", e);
                HttpNegotiateAuthenticatorJni.get().setResult(this.mRequestData.nativeResultObject, HttpNegotiateAuthenticator.this, -9, null);
            }
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    class GetTokenCallback implements AccountManagerCallback<Bundle> {
        private final RequestData mRequestData;

        public GetTokenCallback(RequestData requestData) {
            this.mRequestData = requestData;
        }

        @Override // android.accounts.AccountManagerCallback
        public void run(AccountManagerFuture<Bundle> accountManagerFuture) {
            try {
                Bundle result = accountManagerFuture.getResult();
                if (!result.containsKey(Constants.INTENT)) {
                    HttpNegotiateAuthenticator.this.processResult(result, this.mRequestData);
                } else {
                    final Context applicationContext = ContextUtils.getApplicationContext();
                    m435xe6b1875(applicationContext, new BroadcastReceiver() { // from class: com.ttnet.org.chromium.net.HttpNegotiateAuthenticator.GetTokenCallback.1
                        @Override // android.content.BroadcastReceiver
                        public void onReceive(Context context, Intent intent) {
                            m436x621ae2a1(applicationContext, this);
                            GetTokenCallback.this.mRequestData.accountManager.getAuthToken(GetTokenCallback.this.mRequestData.account, GetTokenCallback.this.mRequestData.authTokenType, GetTokenCallback.this.mRequestData.options, true, (AccountManagerCallback<Bundle>) new GetTokenCallback(GetTokenCallback.this.mRequestData), (Handler) null);
                        }

                        @Proxy("unregisterReceiver")
                        @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
                        /* renamed from: INVOKEVIRTUAL_com_ttnet_org_chromium_net_HttpNegotiateAuthenticator$GetTokenCallback$1_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver */
                        public static void m436x621ae2a1(Context context, BroadcastReceiver broadcastReceiver) {
                            ReceiverRegisterLancet.loge(broadcastReceiver, false);
                            context.unregisterReceiver(broadcastReceiver);
                        }
                    }, new IntentFilter("android.accounts.LOGIN_ACCOUNTS_CHANGED"));
                }
            } catch (AuthenticatorException | OperationCanceledException | IOException e) {
                Log.m285w(HttpNegotiateAuthenticator.TAG, "ERR_UNEXPECTED: Error while attempting to obtain a token.", e);
                HttpNegotiateAuthenticatorJni.get().setResult(this.mRequestData.nativeResultObject, HttpNegotiateAuthenticator.this, -9, null);
            }
        }

        @Proxy("registerReceiver")
        @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
        @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator"})
        /* renamed from: INVOKEVIRTUAL_com_ttnet_org_chromium_net_HttpNegotiateAuthenticator$GetTokenCallback_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver */
        public static Intent m435xe6b1875(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
            if (ReceiverRegisterCrashOptimizer.fixedOpen()) {
                ReceiverRegisterCrashOptimizer.doHWReceiverFix();
            }
            try {
                if (ReceiverRegisterCrashOptimizer.doRegisterHandler()) {
                    ReceiverRegisterLancet.initHandler();
                    Context context2 = context;
                    return context.registerReceiver(broadcastReceiver, intentFilter, null, ReceiverRegisterLancet.sReceiverHandler);
                }
                if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null && ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(intentFilter)) {
                    ReceiverRegisterLancet.initProxyHandler();
                    Context context3 = context;
                    return ContextCompat.registerReceiver(context, broadcastReceiver, intentFilter, (String) null, ReceiverRegisterLancet.sProxyHandler, 2);
                }
                return context.registerReceiver(broadcastReceiver, intentFilter);
            } catch (Exception e) {
                if (!ReceiverRegisterCrashOptimizer.fixedOpen()) {
                    throw e;
                }
                return ReceiverRegisterCrashOptimizer.registerReceiver(broadcastReceiver, intentFilter);
            }
        }
    }

    protected HttpNegotiateAuthenticator(String str) {
        this.mAccountType = str;
    }

    static HttpNegotiateAuthenticator create(String str) {
        return new HttpNegotiateAuthenticator(str);
    }

    void getNextAuthToken(long j, String str, String str2, boolean z) {
        Context applicationContext = ContextUtils.getApplicationContext();
        RequestData requestData = new RequestData();
        requestData.authTokenType = HttpNegotiateConstants.SPNEGO_TOKEN_TYPE_BASE + str;
        requestData.accountManager = AccountManager.get(applicationContext);
        requestData.nativeResultObject = j;
        String[] strArr = {HttpNegotiateConstants.SPNEGO_FEATURE};
        requestData.options = new Bundle();
        if (str2 != null) {
            requestData.options.putString(HttpNegotiateConstants.KEY_INCOMING_AUTH_TOKEN, str2);
        }
        if (this.mSpnegoContext != null) {
            requestData.options.putBundle(HttpNegotiateConstants.KEY_SPNEGO_CONTEXT, this.mSpnegoContext);
        }
        requestData.options.putBoolean(HttpNegotiateConstants.KEY_CAN_DELEGATE, z);
        Activity lastTrackedFocusedActivity = ApplicationStatus.getLastTrackedFocusedActivity();
        if (lastTrackedFocusedActivity == null) {
            requestTokenWithoutActivity(applicationContext, requestData, strArr);
        } else {
            requestTokenWithActivity(applicationContext, lastTrackedFocusedActivity, requestData, strArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processResult(Bundle bundle, RequestData requestData) {
        this.mSpnegoContext = bundle.getBundle(HttpNegotiateConstants.KEY_SPNEGO_CONTEXT);
        int i = -9;
        switch (bundle.getInt(HttpNegotiateConstants.KEY_SPNEGO_RESULT, 1)) {
            case 0:
                i = 0;
                break;
            case 2:
                i = -3;
                break;
            case 3:
                i = NetError.ERR_UNEXPECTED_SECURITY_LIBRARY_STATUS;
                break;
            case 4:
                i = NetError.ERR_INVALID_RESPONSE;
                break;
            case 5:
                i = NetError.ERR_INVALID_AUTH_CREDENTIALS;
                break;
            case 6:
                i = NetError.ERR_UNSUPPORTED_AUTH_SCHEME;
                break;
            case 7:
                i = NetError.ERR_MISSING_AUTH_CREDENTIALS;
                break;
            case 8:
                i = NetError.ERR_UNDOCUMENTED_SECURITY_LIBRARY_STATUS;
                break;
            case 9:
                i = NetError.ERR_MALFORMED_IDENTITY;
                break;
        }
        HttpNegotiateAuthenticatorJni.get().setResult(requestData.nativeResultObject, this, i, bundle.getString("authtoken"));
    }

    boolean lacksPermission(Context context, String str, boolean z) {
        return (z || context.checkPermission(str, Process.myPid(), Process.myUid()) == 0) ? false : true;
    }
}
