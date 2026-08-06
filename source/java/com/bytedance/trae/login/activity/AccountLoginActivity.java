package com.bytedance.trae.login.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.Toast;
import androidx.browser.customtabs.CustomTabsIntent;
import com.bytedance.ies.bullet.kit.resourceloader.loader.CDNLoader;
import com.bytedance.push.event.sync.ISignalReportConstants;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.common.activity.TraeCommonAppCompatActivity;
import com.bytedance.trae.login.AccountUtils;
import com.bytedance.trae.login.C0820R;
import com.bytedance.trae.login.DeletionPendingDialogHelper;
import com.bytedance.trae.login.DeviceOverLimitDialog;
import com.bytedance.trae.login.IPhoneOneKeyCallback;
import com.bytedance.trae.login.PhoneLogin;
import com.bytedance.trae.login.PhoneOneKeyInfo;
import com.bytedance.trae.login.PhoneOneKeyInit;
import com.bytedance.trae.login.PhoneOneKeyPlatform;
import com.bytedance.trae.login.activity.AccountLoginActivity;
import com.bytedance.trae.login.api.AccountStatus;
import com.bytedance.trae.login.api.IAccountCallback;
import com.bytedance.trae.login.api.IDouyinLoginService;
import com.bytedance.trae.login.api.LoginPlatform;
import com.bytedance.trae.login.bytecloud.BytecloudAuthManager;
import com.bytedance.trae.login.bytecloud.BytecloudLoginHelper;
import com.bytedance.trae.login.enterprise.EnterpriseLoginActivity;
import com.bytedance.trae.login.fragment.BytecloudSsoHost;
import com.bytedance.trae.login.fragment.LoginEntryFragment;
import com.bytedance.trae.login.fragment.OneClickLoginCallback;
import com.bytedance.trae.login.fragment.OneClickLoginFragment;
import com.bytedance.trae.login.fragment.PhoneLoginFragment;
import com.bytedance.trae.login.service.AccountHelper;
import com.bytedance.trae.login.tracker.LoginTracker;
import com.bytedance.trae.login.traeauth.ListDevicesResult;
import com.bytedance.trae.login.traeauth.TraeAuthException;
import com.bytedance.trae.login.traeauth.TraeAuthManager;
import com.bytedance.trae.multilanguage.C0882R;
import com.bytedance.trae.platform.model.FixedStepName;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class AccountLoginActivity extends TraeCommonAppCompatActivity implements OneClickLoginCallback {
    private static final String EXT_FAILED_STEP = "failed_step";
    private static final String FAILED_STEP_TRAE_AUTH_AFTER_DOUYIN_AUTH = "trae_auth_after_douyin_auth";
    static final String MAIN_ACTIVITY_CLASS = "com.bytedance.trae.home.MainActivity";
    private static final String TAG_ENTRY = "tag_login_entry";
    private static final String TAG_ONE_CLICK = "tag_one_click_login";
    private static final String TAG_PHONE_LOGIN = "tag_phone_login";
    private static final String TAG_VERIFY_CODE = "tag_verify_code";
    private static final ExecutorService ioExecutor = Executors.newSingleThreadExecutor();
    private PhoneOneKeyInfo accountPhoneOneKeyInfo;
    private FrameLayout loginLoadingOverlay;
    private ConnectivityManager.NetworkCallback networkCallback;
    private final PhoneLogin phoneLogin = new PhoneLogin();
    private boolean isBytedanceNetwork = false;
    private boolean isLoginSuccess = false;
    private boolean phoneLoginAgreementChecked = false;
    private boolean isNavigatingAway = false;
    private boolean isNavigatingToVerifyCode = false;
    private int resumeCount = 0;
    private boolean hasClickedLogin = false;
    private boolean hasEnteredTraeAuth = false;
    private String lastClickedLoginType = "";
    private volatile boolean isWaitingForDouyinResult = false;

    /* renamed from: com_bytedance_trae_login_activity_AccountLoginActivity__onStop$___twin___ */
    public void m379x3d65ec1() {
        super.onStop();
    }

    @Override // com.bytedance.trae.login.fragment.OneClickLoginCallback
    public void onPrivacyClicked() {
    }

    protected void onStop() {
        m378x55f127da(this);
    }

    @Override // com.bytedance.trae.login.fragment.OneClickLoginCallback
    public void onTermsClicked() {
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0820R.layout.trae_activity_account_login);
        this.loginLoadingOverlay = (FrameLayout) findViewById(C0820R.id.login_loading_overlay);
        if (bundle == null) {
            IApplog.Companion.reportEvent("icube_login_start", (JSONObject) null);
            reportLoginStartToSlardar();
            reportLoginPageView();
            String stringExtra = getIntent().getStringExtra(TraeAuthManager.STAGE_PAGE_SOURCE);
            if (stringExtra == null) {
                stringExtra = "cold_launch";
            }
            TraeAuthManager.INSTANCE.reportLoginFunnel(TraeAuthManager.STAGE_PAGE_SOURCE, TraeAuthManager.PLATFORM_UNSELECTED, null, stringExtra, null, null);
        }
        PhoneOneKeyInit.INSTANCE.init();
        showLoginEntryFragment();
        checkBytecloudNetwork();
        registerNetworkCallback();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkBytecloudNetwork() {
        if (BytecloudAuthManager.INSTANCE.hasEverSeenIntranet()) {
            this.isBytedanceNetwork = true;
            notifyCurrentFragmentSso();
        }
        BytecloudLoginHelper.checkBytedanceNetwork(this, new BytecloudLoginHelper.NetworkCheckCallback() { // from class: com.bytedance.trae.login.activity.AccountLoginActivity$$ExternalSyntheticLambda6
            @Override // com.bytedance.trae.login.bytecloud.BytecloudLoginHelper.NetworkCheckCallback
            public final void onResult(boolean z) {
                AccountLoginActivity.this.m380xd41bf0f4(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$checkBytecloudNetwork$0$com-bytedance-trae-login-activity-AccountLoginActivity */
    public /* synthetic */ void m380xd41bf0f4(boolean z) {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        this.isBytedanceNetwork = z;
        if (z) {
            notifyCurrentFragmentSso();
        }
    }

    private void recheckBytecloudNetwork() {
        if (BytecloudAuthManager.INSTANCE.resetNetworkCache()) {
            checkBytecloudNetwork();
        }
    }

    private void registerNetworkCallback() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService("connectivity");
            if (connectivityManager == null) {
                return;
            }
            NetworkRequest build = new NetworkRequest.Builder().addCapability(12).build();
            C08211 c08211 = new C08211();
            this.networkCallback = c08211;
            connectivityManager.registerNetworkCallback(build, c08211);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.trae.login.activity.AccountLoginActivity$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public class C08211 extends ConnectivityManager.NetworkCallback {
        C08211() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            AccountLoginActivity.this.runOnUiThread(new Runnable() { // from class: com.bytedance.trae.login.activity.AccountLoginActivity$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    AccountLoginActivity.C08211.this.m387x2f6c8e0();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$onAvailable$0$com-bytedance-trae-login-activity-AccountLoginActivity$1 */
        public /* synthetic */ void m387x2f6c8e0() {
            BytecloudAuthManager.INSTANCE.forceResetNetworkCache();
            AccountLoginActivity.this.checkBytecloudNetwork();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$onLost$1$com-bytedance-trae-login-activity-AccountLoginActivity$1 */
        public /* synthetic */ void m388x23e8654c() {
            AccountLoginActivity.this.isBytedanceNetwork = false;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            AccountLoginActivity.this.runOnUiThread(new Runnable() { // from class: com.bytedance.trae.login.activity.AccountLoginActivity$1$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    AccountLoginActivity.C08211.this.m388x23e8654c();
                }
            });
        }
    }

    private void unregisterNetworkCallback() {
        if (this.networkCallback == null) {
            return;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService("connectivity");
            if (connectivityManager != null) {
                connectivityManager.unregisterNetworkCallback(this.networkCallback);
            }
        } catch (Exception unused) {
        }
        this.networkCallback = null;
    }

    public boolean isBytedanceNetwork() {
        return this.isBytedanceNetwork;
    }

    private void notifyCurrentFragmentSso() {
        BytecloudSsoHost findFragmentById = getSupportFragmentManager().findFragmentById(C0820R.id.fragment_container);
        if (findFragmentById instanceof BytecloudSsoHost) {
            findFragmentById.showBytecloudSso(new Function0() { // from class: com.bytedance.trae.login.activity.AccountLoginActivity$$ExternalSyntheticLambda7
                public final Object invoke() {
                    return AccountLoginActivity.this.m384x8294ab53();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$notifyCurrentFragmentSso$1$com-bytedance-trae-login-activity-AccountLoginActivity */
    public /* synthetic */ Unit m384x8294ab53() {
        openBytecloudLogin();
        return Unit.INSTANCE;
    }

    public void openBytecloudLogin() {
        this.hasClickedLogin = true;
        this.hasEnteredTraeAuth = false;
        this.lastClickedLoginType = "bytecloud";
        TraeAuthManager.INSTANCE.reportLoginFunnel(TraeAuthManager.STAGE_LOGIN_METHOD_SELECTED, "bytecloud");
        BytecloudLoginHelper.checkIntranetRealTime(this, new BytecloudLoginHelper.NetworkCheckCallback() { // from class: com.bytedance.trae.login.activity.AccountLoginActivity$$ExternalSyntheticLambda4
            @Override // com.bytedance.trae.login.bytecloud.BytecloudLoginHelper.NetworkCheckCallback
            public final void onResult(boolean z) {
                AccountLoginActivity.this.m385x2652b7bb(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: lambda$openBytecloudLogin$2$com-bytedance-trae-login-activity-AccountLoginActivity */
    public /* synthetic */ void m385x2652b7bb(boolean z) {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        if (!z) {
            Toast.makeText((Context) this, (CharSequence) getString(C0882R.string.trae_login_bytecloud_not_in_intranet), 0).show();
            return;
        }
        this.isNavigatingAway = true;
        new CustomTabsIntent.Builder().build().launchUrl(this, Uri.parse(BytecloudAuthManager.INSTANCE.buildLoginUrl()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void openEnterpriseLogin() {
        this.hasClickedLogin = true;
        this.lastClickedLoginType = "enterprise";
        this.isNavigatingAway = true;
        TraeAuthManager.INSTANCE.reportLoginFunnel(TraeAuthManager.STAGE_LOGIN_METHOD_SELECTED, "enterprise");
        startActivity(new Intent((Context) this, (Class<?>) EnterpriseLoginActivity.class));
    }

    public void notifyVerifyCodeNavigation() {
        this.isNavigatingToVerifyCode = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isOneKeyInfoValid(PhoneOneKeyInfo phoneOneKeyInfo) {
        return (phoneOneKeyInfo == null || TextUtils.isEmpty(phoneOneKeyInfo.getMaskPhone()) || phoneOneKeyInfo.getCarrier() == null) ? false : true;
    }

    private void tryOneClickLogin() {
        PhoneOneKeyInfo preLoadOneKeyInfo = AccountUtils.INSTANCE.getPreLoadOneKeyInfo();
        if (isOneKeyInfoValid(preLoadOneKeyInfo)) {
            this.accountPhoneOneKeyInfo = preLoadOneKeyInfo;
            TraeAuthManager.INSTANCE.reportLoginFunnel(TraeAuthManager.STAGE_PRELOAD_RESULT, TraeAuthManager.PLATFORM_ONE_CLICK, null, "cache_hit", null, null);
            showOneClickLoginFragment(preLoadOneKeyInfo.getMaskPhone(), preLoadOneKeyInfo.getCarrier());
            TraeAuthManager.INSTANCE.reportLoginFunnel(TraeAuthManager.STAGE_VIEW_SHOWN, TraeAuthManager.PLATFORM_ONE_CLICK, null, null, null, null);
            return;
        }
        showPhoneLoginFragment();
        TraeAuthManager.INSTANCE.reportLoginFunnel(TraeAuthManager.STAGE_VIEW_SHOWN, TraeAuthManager.PLATFORM_PHONE, null, null, null, null);
        this.phoneLogin.getPhoneInfo(LoginPlatform.PHONE, new C08222());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.trae.login.activity.AccountLoginActivity$2 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public class C08222 implements IPhoneOneKeyCallback {
        C08222() {
        }

        @Override // com.bytedance.trae.login.IPhoneOneKeyCallback
        public void onGetPhoneOneKeyInfoSuccess(final PhoneOneKeyInfo phoneOneKeyInfo) {
            if (AccountLoginActivity.this.isFinishing() || AccountLoginActivity.this.isDestroyed()) {
                return;
            }
            if (AccountLoginActivity.this.isOneKeyInfoValid(phoneOneKeyInfo)) {
                AccountLoginActivity.this.accountPhoneOneKeyInfo = phoneOneKeyInfo;
                TraeAuthManager.INSTANCE.reportLoginFunnel(TraeAuthManager.STAGE_PRELOAD_RESULT, TraeAuthManager.PLATFORM_ONE_CLICK, null, "async_success", null, null);
                AccountLoginActivity.this.runOnUiThread(new Runnable() { // from class: com.bytedance.trae.login.activity.AccountLoginActivity$2$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        AccountLoginActivity.C08222.this.m389x4930b406(phoneOneKeyInfo);
                    }
                });
                return;
            }
            TraeAuthManager.INSTANCE.reportLoginFunnel(TraeAuthManager.STAGE_PRELOAD_RESULT, TraeAuthManager.PLATFORM_ONE_CLICK, null, "async_invalid", null, null);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$onGetPhoneOneKeyInfoSuccess$0$com-bytedance-trae-login-activity-AccountLoginActivity$2 */
        public /* synthetic */ void m389x4930b406(PhoneOneKeyInfo phoneOneKeyInfo) {
            if (AccountLoginActivity.this.isFinishing() || AccountLoginActivity.this.isDestroyed() || !(AccountLoginActivity.this.getSupportFragmentManager().findFragmentById(C0820R.id.fragment_container) instanceof PhoneLoginFragment) || AccountLoginActivity.this.getSupportFragmentManager().isStateSaved()) {
                return;
            }
            AccountLoginActivity.this.getSupportFragmentManager().popBackStackImmediate();
            AccountLoginActivity.this.showOneClickLoginFragment(phoneOneKeyInfo.getMaskPhone(), phoneOneKeyInfo.getCarrier());
            TraeAuthManager.INSTANCE.reportLoginFunnel(TraeAuthManager.STAGE_VIEW_SHOWN, TraeAuthManager.PLATFORM_ONE_CLICK, null, null, null, null);
        }

        @Override // com.bytedance.trae.login.IPhoneOneKeyCallback
        public void onGetPhoneOneKeyInfoFailure(int i, String str, String str2) {
            if (AccountLoginActivity.this.isFinishing() || AccountLoginActivity.this.isDestroyed()) {
                return;
            }
            TraeAuthManager.INSTANCE.reportLoginFunnel(TraeAuthManager.STAGE_PRELOAD_RESULT, TraeAuthManager.PLATFORM_ONE_CLICK, null, "async_fail", str, str2);
        }
    }

    public void showOneClickLoginFragment(String str, PhoneOneKeyPlatform phoneOneKeyPlatform) {
        OneClickLoginFragment newInstance = OneClickLoginFragment.INSTANCE.newInstance(str, phoneOneKeyPlatform);
        newInstance.setOneClickLoginCallback(this);
        getSupportFragmentManager().beginTransaction().replace(C0820R.id.fragment_container, newInstance, TAG_ONE_CLICK).addToBackStack((String) null).commitAllowingStateLoss();
    }

    public void showPhoneLoginFragment() {
        getSupportFragmentManager().beginTransaction().replace(C0820R.id.fragment_container, PhoneLoginFragment.INSTANCE.newInstance(), TAG_PHONE_LOGIN).addToBackStack((String) null).commitAllowingStateLoss();
    }

    private void showLoginEntryFragment() {
        getSupportFragmentManager().beginTransaction().replace(C0820R.id.fragment_container, LoginEntryFragment.INSTANCE.newInstance(), TAG_ENTRY).commitAllowingStateLoss();
    }

    public void onPhoneLoginClicked(boolean z) {
        this.hasClickedLogin = true;
        this.hasEnteredTraeAuth = false;
        this.lastClickedLoginType = TraeAuthManager.PLATFORM_PHONE;
        this.phoneLoginAgreementChecked = z;
        TraeAuthManager.INSTANCE.reportLoginFunnel(TraeAuthManager.STAGE_PHONE_LOGIN_CLICKED, TraeAuthManager.PLATFORM_PHONE);
        tryOneClickLogin();
    }

    public boolean isPhoneLoginAgreementChecked() {
        return this.phoneLoginAgreementChecked;
    }

    public void notifyLoginClicked(String str) {
        this.hasClickedLogin = true;
        this.hasEnteredTraeAuth = false;
        this.lastClickedLoginType = str;
    }

    public void handleLoginSuccess() {
        this.hasEnteredTraeAuth = true;
        navigateToMainActivity();
    }

    protected void onResume() {
        super.onResume();
        this.resumeCount++;
        this.isNavigatingAway = false;
        this.isNavigatingToVerifyCode = false;
        if (this.isWaitingForDouyinResult) {
            showLoginLoading(true);
        }
        TraeAuthManager.INSTANCE.reportLoginFunnel(TraeAuthManager.STAGE_PAGE_RESUME, TraeAuthManager.PLATFORM_UNSELECTED, null, "resume_" + this.resumeCount, null, null);
        recheckBytecloudNetwork();
    }

    protected void onPause() {
        String str;
        super.onPause();
        if (this.isLoginSuccess) {
            return;
        }
        if (this.isNavigatingToVerifyCode) {
            str = "verify_code_navigate";
        } else if (isFinishing()) {
            str = "back_pressed";
        } else {
            str = this.isNavigatingAway ? "sso_navigate" : FixedStepName.SWITCH_BACKGROUND;
        }
        TraeAuthManager.INSTANCE.reportLoginFunnel(TraeAuthManager.STAGE_PAGE_PAUSE, TraeAuthManager.PLATFORM_UNSELECTED, null, str, null, null);
    }

    @Override // com.bytedance.trae.login.fragment.OneClickLoginCallback
    public void onSwitchAccount() {
        TraeAuthManager.INSTANCE.reportLoginFunnel(TraeAuthManager.STAGE_ONE_CLICK_SWITCH_TO_PHONE, TraeAuthManager.PLATFORM_ONE_CLICK, null, "switch_to_phone", null, null);
        showPhoneLoginFragment();
    }

    @Override // com.bytedance.trae.login.fragment.OneClickLoginCallback
    public void onOneClickLogin() {
        this.hasClickedLogin = true;
        this.hasEnteredTraeAuth = false;
        this.lastClickedLoginType = "phone_oneclick";
        TraeAuthManager.INSTANCE.reportLoginFunnel(TraeAuthManager.STAGE_LOGIN_METHOD_SELECTED, TraeAuthManager.PLATFORM_ONE_CLICK);
        this.phoneLogin.doOneKeyLogin(new C08233(), null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.trae.login.activity.AccountLoginActivity$3 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public class C08233 implements IAccountCallback {
        C08233() {
        }

        @Override // com.bytedance.trae.login.api.IAccountCallback
        public void onDeviceOverLimit(String str, Map<String, ?> map) {
            AccountLoginActivity.this.listDevicesAndNotify(map);
        }

        @Override // com.bytedance.trae.login.api.IAccountCallback
        public void onSuccess(LoginPlatform loginPlatform, String str, Boolean bool) {
            OneClickLoginFragment findFragmentByTag;
            if (AccountLoginActivity.this.isFinishing() || (findFragmentByTag = AccountLoginActivity.this.getSupportFragmentManager().findFragmentByTag(AccountLoginActivity.TAG_ONE_CLICK)) == null) {
                return;
            }
            findFragmentByTag.notifyLoginResult(true, null, null);
        }

        @Override // com.bytedance.trae.login.api.IAccountCallback
        public void onFailed(LoginPlatform loginPlatform, int i, String str, String str2, Throwable th, String str3, Integer num, String str4, Map<String, Object> map) {
            if (AccountLoginActivity.this.isFinishing()) {
                return;
            }
            if (i == 1075) {
                String str5 = map != null ? (String) map.get("cancel_token") : null;
                if (str5 != null && !str5.isEmpty()) {
                    DeletionPendingDialogHelper.INSTANCE.show(AccountLoginActivity.this, str5, new Function0() { // from class: com.bytedance.trae.login.activity.AccountLoginActivity$3$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            return AccountLoginActivity.C08233.this.m390xa27f2c76();
                        }
                    }, new Function0() { // from class: com.bytedance.trae.login.activity.AccountLoginActivity$3$$ExternalSyntheticLambda1
                        public final Object invoke() {
                            return AccountLoginActivity.C08233.this.m391x2f6c4395();
                        }
                    });
                    return;
                }
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(ISignalReportConstants.KEY_REASON, str != null ? str : "one_click_login_failed");
                jSONObject.put(CDNLoader.DIAGNOSE_ERROR_CODE, String.valueOf(i));
                jSONObject.put("login_platform", TraeAuthManager.PLATFORM_ONE_CLICK);
            } catch (Exception unused) {
            }
            IApplog.Companion.reportEvent("icube_login_failure", jSONObject);
            TraeAuthManager.INSTANCE.reportLoginFunnel(TraeAuthManager.STAGE_PASSPORT_FAIL, TraeAuthManager.PLATFORM_ONE_CLICK, null, null, String.valueOf(i), str != null ? str : "one_click_login_failed");
            OneClickLoginFragment findFragmentByTag = AccountLoginActivity.this.getSupportFragmentManager().findFragmentByTag(AccountLoginActivity.TAG_ONE_CLICK);
            if (findFragmentByTag != null) {
                findFragmentByTag.notifyLoginResult(false, Integer.valueOf(i), str);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$onFailed$0$com-bytedance-trae-login-activity-AccountLoginActivity$3 */
        public /* synthetic */ Unit m390xa27f2c76() {
            AccountLoginActivity.this.hasEnteredTraeAuth = true;
            AccountLoginActivity.this.navigateToMainActivity();
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$onFailed$1$com-bytedance-trae-login-activity-AccountLoginActivity$3 */
        public /* synthetic */ Unit m391x2f6c4395() {
            OneClickLoginFragment findFragmentByTag = AccountLoginActivity.this.getSupportFragmentManager().findFragmentByTag(AccountLoginActivity.TAG_ONE_CLICK);
            if (findFragmentByTag != null) {
                findFragmentByTag.resetLoginLoadingState();
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDouyinLogin() {
        this.hasClickedLogin = true;
        this.hasEnteredTraeAuth = false;
        this.lastClickedLoginType = "douyin";
        this.isWaitingForDouyinResult = true;
        IDouyinLoginService iDouyinLoginService = ServiceManager.get() != null ? (IDouyinLoginService) ServiceManager.get().getService(IDouyinLoginService.class) : null;
        if (iDouyinLoginService == null) {
            this.isWaitingForDouyinResult = false;
            TraeAuthManager.INSTANCE.reportLoginFunnel(TraeAuthManager.STAGE_DOUYIN_AUTH_SERVICE_UNAVAILABLE, "douyin");
            Toast.makeText((Context) this, C0820R.string.trae_douyin_service_unavailable, 0).show();
            return;
        }
        iDouyinLoginService.authorize(this, new C08244(), null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.trae.login.activity.AccountLoginActivity$4 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public class C08244 implements IAccountCallback {
        C08244() {
        }

        @Override // com.bytedance.trae.login.api.IAccountCallback
        public void onDeviceOverLimit(String str, Map<String, ?> map) {
            AccountLoginActivity.this.runOnUiThread(new Runnable() { // from class: com.bytedance.trae.login.activity.AccountLoginActivity$4$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    AccountLoginActivity.C08244.this.m392x8251c41b();
                }
            });
            AccountLoginActivity.this.listDevicesAndNotify(map);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$onDeviceOverLimit$0$com-bytedance-trae-login-activity-AccountLoginActivity$4 */
        public /* synthetic */ void m392x8251c41b() {
            AccountLoginActivity.this.isWaitingForDouyinResult = false;
            AccountLoginActivity.this.showLoginLoading(false);
        }

        @Override // com.bytedance.trae.login.api.IAccountCallback
        public void onSuccess(LoginPlatform loginPlatform, String str, Boolean bool) {
            if (AccountLoginActivity.this.isFinishing()) {
                return;
            }
            AccountLoginActivity.this.hasEnteredTraeAuth = true;
            AccountLoginActivity.this.runOnUiThread(new Runnable() { // from class: com.bytedance.trae.login.activity.AccountLoginActivity$4$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    AccountLoginActivity.C08244.this.m398x29e6d88();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$onSuccess$1$com-bytedance-trae-login-activity-AccountLoginActivity$4 */
        public /* synthetic */ void m398x29e6d88() {
            AccountLoginActivity.this.isWaitingForDouyinResult = false;
            AccountLoginActivity.this.showLoginLoading(false);
            AccountLoginActivity.this.navigateToMainActivity();
        }

        @Override // com.bytedance.trae.login.api.IAccountCallback
        public void onFailed(LoginPlatform loginPlatform, int i, String str, String str2, Throwable th, final String str3, Integer num, String str4, Map<String, Object> map) {
            final String str5 = str;
            if (AccountLoginActivity.this.isFinishing()) {
                return;
            }
            Object obj = map != null ? map.get(AccountLoginActivity.EXT_FAILED_STEP) : null;
            String str6 = obj instanceof String ? (String) obj : null;
            if (AccountLoginActivity.FAILED_STEP_TRAE_AUTH_AFTER_DOUYIN_AUTH.equals(str6)) {
                AccountLoginActivity.this.hasEnteredTraeAuth = true;
                TraeAuthManager.INSTANCE.reportLoginFunnel(TraeAuthManager.STAGE_DOUYIN_AUTH_TRAE_AUTH_FAIL, "douyin", null, str6, String.valueOf(i), str5 != null ? str5 : "douyin_trae_auth_failed");
                AccountLoginActivity.this.runOnUiThread(new Runnable() { // from class: com.bytedance.trae.login.activity.AccountLoginActivity$4$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        AccountLoginActivity.C08244.this.m393xbc595ab5(str5);
                    }
                });
                return;
            }
            if (i == 1075) {
                String str7 = map != null ? (String) map.get("cancel_token") : null;
                if (str7 != null && !str7.isEmpty()) {
                    AccountLoginActivity.this.runOnUiThread(new Runnable() { // from class: com.bytedance.trae.login.activity.AccountLoginActivity$4$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            AccountLoginActivity.C08244.this.m394x494671d4();
                        }
                    });
                    DeletionPendingDialogHelper.INSTANCE.show(AccountLoginActivity.this, str7, new Function0() { // from class: com.bytedance.trae.login.activity.AccountLoginActivity$4$$ExternalSyntheticLambda3
                        public final Object invoke() {
                            return AccountLoginActivity.C08244.this.m395xd63388f3();
                        }
                    }, null, "douyin");
                    return;
                }
            }
            if (str3 != null && !str3.isEmpty()) {
                AccountLoginActivity.this.hasEnteredTraeAuth = true;
                TraeAuthManager.INSTANCE.reportLoginFunnel(TraeAuthManager.STAGE_DOUYIN_AUTH_NEED_BIND, "douyin");
                TraeAuthManager.INSTANCE.reportLoginFunnel(TraeAuthManager.STAGE_DOUYIN_BIND_PHONE_SHOWN, "douyin");
                AccountLoginActivity.this.runOnUiThread(new Runnable() { // from class: com.bytedance.trae.login.activity.AccountLoginActivity$4$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() {
                        AccountLoginActivity.C08244.this.m396x6320a012(str3);
                    }
                });
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(ISignalReportConstants.KEY_REASON, str5 != null ? str5 : "douyin_login_failed");
                jSONObject.put(CDNLoader.DIAGNOSE_ERROR_CODE, String.valueOf(i));
                jSONObject.put("login_platform", "douyin");
            } catch (Exception unused) {
            }
            IApplog.Companion.reportEvent("icube_login_failure", jSONObject);
            TraeAuthManager traeAuthManager = TraeAuthManager.INSTANCE;
            String valueOf = String.valueOf(i);
            if (str5 == null) {
                str5 = "douyin_login_failed";
            }
            traeAuthManager.reportLoginFunnel(TraeAuthManager.STAGE_DOUYIN_AUTH_CANCELLED, "douyin", null, null, valueOf, str5);
            AccountLoginActivity.this.runOnUiThread(new Runnable() { // from class: com.bytedance.trae.login.activity.AccountLoginActivity$4$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    AccountLoginActivity.C08244.this.m397xf00db731();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Type inference failed for: r0v2, types: [android.content.Context, com.bytedance.trae.login.activity.AccountLoginActivity] */
        /* renamed from: lambda$onFailed$2$com-bytedance-trae-login-activity-AccountLoginActivity$4 */
        public /* synthetic */ void m393xbc595ab5(String str) {
            AccountLoginActivity.this.isWaitingForDouyinResult = false;
            AccountLoginActivity.this.showLoginLoading(false);
            ?? r0 = AccountLoginActivity.this;
            if (str == null) {
                str = r0.getString(C0820R.string.trae_douyin_auth_failed);
            }
            Toast.makeText((Context) r0, str, 0).show();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$onFailed$3$com-bytedance-trae-login-activity-AccountLoginActivity$4 */
        public /* synthetic */ void m394x494671d4() {
            AccountLoginActivity.this.isWaitingForDouyinResult = false;
            AccountLoginActivity.this.showLoginLoading(false);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$onFailed$4$com-bytedance-trae-login-activity-AccountLoginActivity$4 */
        public /* synthetic */ Unit m395xd63388f3() {
            AccountLoginActivity.this.hasEnteredTraeAuth = true;
            AccountLoginActivity.this.navigateToMainActivity();
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$onFailed$5$com-bytedance-trae-login-activity-AccountLoginActivity$4 */
        public /* synthetic */ void m396x6320a012(String str) {
            AccountLoginActivity.this.isWaitingForDouyinResult = false;
            AccountLoginActivity.this.showLoginLoading(false);
            AccountLoginActivity.this.navigateToPhoneBindForDouyin(str);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Type inference failed for: r0v2, types: [android.content.Context, com.bytedance.trae.login.activity.AccountLoginActivity] */
        /* renamed from: lambda$onFailed$6$com-bytedance-trae-login-activity-AccountLoginActivity$4 */
        public /* synthetic */ void m397xf00db731() {
            AccountLoginActivity.this.isWaitingForDouyinResult = false;
            AccountLoginActivity.this.showLoginLoading(false);
            ?? r0 = AccountLoginActivity.this;
            Toast.makeText((Context) r0, r0.getString(C0820R.string.trae_douyin_authorize_cancelled), 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void navigateToPhoneBindForDouyin(String str) {
        DouyinBindPhoneActivity.INSTANCE.start(this, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoginLoading(boolean z) {
        FrameLayout frameLayout = this.loginLoadingOverlay;
        if (frameLayout != null) {
            frameLayout.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.bytedance.trae.login.fragment.OneClickLoginCallback
    public void onDeviceLimitLoginContinue(Map<String, Object> map, String str) {
        boolean z = false;
        if (map != null) {
            try {
                if (map.containsKey("is_new_user")) {
                    z = ((Boolean) map.get("is_new_user")).booleanValue();
                }
            } catch (Throwable unused) {
            }
        }
        AccountHelper.INSTANCE.setIsNewUser(z);
        final LoginPlatform resolveLoginPlatform = resolveLoginPlatform(str);
        TraeAuthManager.INSTANCE.onLoginContinueByDeviceLimit(new TraeAuthManager.TraeAuthCallback() { // from class: com.bytedance.trae.login.activity.AccountLoginActivity.5
            @Override // com.bytedance.trae.login.traeauth.TraeAuthManager.TraeAuthCallback
            public void deviceOverLimit(String str2) {
            }

            @Override // com.bytedance.trae.login.traeauth.TraeAuthManager.TraeAuthCallback
            public void onSuccess() {
                AccountHelper.INSTANCE.loginStatusChanged(AccountStatus.LOGGED_IN, "", resolveLoginPlatform);
                if (AccountLoginActivity.this.isFinishing()) {
                    return;
                }
                OneClickLoginFragment findFragmentByTag = AccountLoginActivity.this.getSupportFragmentManager().findFragmentByTag(AccountLoginActivity.TAG_ONE_CLICK);
                if (findFragmentByTag == null) {
                    AccountLoginActivity.this.hasEnteredTraeAuth = true;
                    AccountLoginActivity.this.navigateToMainActivity();
                } else {
                    findFragmentByTag.notifyLoginResult(true, null, null);
                }
            }

            /* JADX WARN: Type inference failed for: r3v7, types: [android.content.Context, com.bytedance.trae.login.activity.AccountLoginActivity] */
            @Override // com.bytedance.trae.login.traeauth.TraeAuthManager.TraeAuthCallback
            public void onFailure(String str2, String str3) {
                if (AccountLoginActivity.this.isFinishing()) {
                    return;
                }
                OneClickLoginFragment findFragmentByTag = AccountLoginActivity.this.getSupportFragmentManager().findFragmentByTag(AccountLoginActivity.TAG_ONE_CLICK);
                if (findFragmentByTag != null) {
                    findFragmentByTag.notifyLoginResult(false, -1, str3);
                    return;
                }
                ?? r3 = AccountLoginActivity.this;
                if (str3 == null) {
                    str3 = r3.getString(C0820R.string.trae_douyin_bind_login_fail);
                }
                Toast.makeText((Context) r3, str3, 0).show();
            }
        }, str);
    }

    private LoginPlatform resolveLoginPlatform(String str) {
        if ("douyin".equals(str)) {
            return LoginPlatform.DOUYIN;
        }
        if ("bytecloud".equals(str)) {
            return LoginPlatform.BYTECLOUD;
        }
        return LoginPlatform.PHONE;
    }

    @Override // com.bytedance.trae.login.fragment.OneClickLoginCallback
    public void onLoginSuccess() {
        this.hasEnteredTraeAuth = true;
        navigateToMainActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void navigateToMainActivity() {
        this.isLoginSuccess = true;
        Intent intent = new Intent();
        intent.setClassName((Context) this, MAIN_ACTIVITY_CLASS);
        intent.setFlags(268468224);
        intent.putExtra("from_login_success", true);
        startActivity(intent);
        finish();
    }

    private void reportLoginStartToSlardar() {
        TraeAuthManager.INSTANCE.reportLoginFunnel(TraeAuthManager.STAGE_START, TraeAuthManager.PLATFORM_UNSELECTED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void listDevicesAndNotify(final Map<String, ?> map) {
        final String normalizeLoginPlatformType = normalizeLoginPlatformType(this.lastClickedLoginType);
        ioExecutor.execute(new Runnable() { // from class: com.bytedance.trae.login.activity.AccountLoginActivity$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AccountLoginActivity.this.m383x7657809c(map, normalizeLoginPlatformType);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$listDevicesAndNotify$6$com-bytedance-trae-login-activity-AccountLoginActivity */
    public /* synthetic */ void m383x7657809c(final Map map, final String str) {
        final String str2;
        try {
            final ListDevicesResult listDevicesResult = (ListDevicesResult) BuildersKt.runBlocking(Dispatchers.getIO(), new Function2() { // from class: com.bytedance.trae.login.activity.AccountLoginActivity$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    return AccountLoginActivity.lambda$listDevicesAndNotify$3((CoroutineScope) obj, (Continuation) obj2);
                }
            });
            runOnUiThread(new Runnable() { // from class: com.bytedance.trae.login.activity.AccountLoginActivity$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    AccountLoginActivity.this.m381x73eadade(listDevicesResult, map, str);
                }
            });
        } catch (Throwable th) {
            Throwable th2 = th;
            while (th2.getCause() != null && th2.getCause() != th2 && !(th2 instanceof TraeAuthException)) {
                th2 = th2.getCause();
            }
            if (th2 instanceof TraeAuthException) {
                TraeAuthException traeAuthException = (TraeAuthException) th2;
                traeAuthException.getMessage();
                str2 = traeAuthException.getMessage();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(ISignalReportConstants.KEY_REASON, str + "_list_device_error");
                    jSONObject.put(CDNLoader.DIAGNOSE_ERROR_CODE, traeAuthException.getCode());
                    jSONObject.put("login_platform", str);
                } catch (Exception unused) {
                }
                IApplog.Companion.reportEvent("icube_login_failure", jSONObject);
                TraeAuthManager.INSTANCE.reportLoginFunnel(TraeAuthManager.STAGE_LOGIN_FAILURE, str, null, "list_device_list", "-1", str2);
            } else {
                String str3 = "unknown_error: " + th.getClass().getSimpleName();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put(ISignalReportConstants.KEY_REASON, str + "_login_unknown_error");
                    jSONObject2.put(CDNLoader.DIAGNOSE_ERROR_CODE, -1);
                    jSONObject2.put("error_class", th.getClass().getName());
                    jSONObject2.put(CDNLoader.DIAGNOSE_ERROR_MESSAGE, th.getMessage() != null ? th.getMessage() : "");
                    jSONObject2.put("login_platform", str);
                } catch (Exception unused2) {
                }
                IApplog.Companion.reportEvent("icube_login_failure", jSONObject2);
                TraeAuthManager.INSTANCE.reportLoginFunnel(TraeAuthManager.STAGE_LOGIN_FAILURE, str, null, "list_device_list", "-1", str3);
                str2 = str3;
            }
            runOnUiThread(new Runnable() { // from class: com.bytedance.trae.login.activity.AccountLoginActivity$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    AccountLoginActivity.this.m382x75212dbd(str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object lambda$listDevicesAndNotify$3(CoroutineScope coroutineScope, Continuation continuation) {
        try {
            return TraeAuthManager.INSTANCE.listDevices(continuation);
        } catch (TraeAuthException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$listDevicesAndNotify$4$com-bytedance-trae-login-activity-AccountLoginActivity */
    public /* synthetic */ void m381x73eadade(ListDevicesResult listDevicesResult, Map map, String str) {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        OneClickLoginFragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(TAG_ONE_CLICK);
        if (findFragmentByTag != null) {
            findFragmentByTag.notifyDeviceOffline(listDevicesResult, map);
        } else {
            showDeviceOverLimitDialog(listDevicesResult, map, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: lambda$listDevicesAndNotify$5$com-bytedance-trae-login-activity-AccountLoginActivity */
    public /* synthetic */ void m382x75212dbd(String str) {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        OneClickLoginFragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(TAG_ONE_CLICK);
        if (findFragmentByTag != null) {
            findFragmentByTag.notifyLoginResult(false, -1, str);
        } else {
            Toast.makeText((Context) this, (CharSequence) str, 0).show();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showDeviceOverLimitDialog(ListDevicesResult listDevicesResult, final Map<String, ?> map, final String str) {
        DeviceOverLimitDialog.INSTANCE.show(this, listDevicesResult, DeviceOverLimitDialog.Scene.LOGIN, new DeviceOverLimitDialog.Callback() { // from class: com.bytedance.trae.login.activity.AccountLoginActivity$$ExternalSyntheticLambda5
            @Override // com.bytedance.trae.login.DeviceOverLimitDialog.Callback
            public final void onResult(boolean z) {
                AccountLoginActivity.this.m386x335ea71a(map, str, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: lambda$showDeviceOverLimitDialog$7$com-bytedance-trae-login-activity-AccountLoginActivity */
    public /* synthetic */ void m386x335ea71a(Map map, String str, boolean z) {
        if (z) {
            onDeviceLimitLoginContinue(toObjectMap(map), normalizeLoginPlatformType(str));
        } else {
            TraeAuthManager.INSTANCE.reportLoginFunnel(TraeAuthManager.STAGE_DEVICE_LIMIT_DISMISSED, normalizeLoginPlatformType(str));
            Toast.makeText((Context) this, (CharSequence) getString(C0882R.string.trae_device_over_limit), 0).show();
        }
    }

    private String normalizeLoginPlatformType(String str) {
        return "douyin".equals(str) ? "douyin" : "bytecloud".equals(str) ? "bytecloud" : (TraeAuthManager.PLATFORM_ONE_CLICK.equals(str) || "phone_oneclick".equals(str)) ? TraeAuthManager.PLATFORM_ONE_CLICK : TraeAuthManager.PLATFORM_PHONE;
    }

    private Map<String, Object> toObjectMap(Map<String, ?> map) {
        HashMap hashMap = new HashMap();
        if (map == null) {
            return hashMap;
        }
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            Object value = entry.getValue();
            if (value != null) {
                hashMap.put(entry.getKey(), value);
            }
        }
        return hashMap;
    }

    private void reportLoginPageView() {
        String stringExtra = getIntent().getStringExtra("login_enter_from");
        if (stringExtra == null || stringExtra.isEmpty()) {
            stringExtra = "onboarding";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("enter_from", stringExtra);
        } catch (Exception unused) {
        }
        IApplog.Companion.reportEvent("login_page_view", jSONObject);
    }

    protected void onDestroy() {
        if (this.hasClickedLogin && !this.hasEnteredTraeAuth) {
            LoginTracker.INSTANCE.trackLoginResult(false, this.lastClickedLoginType, "cancelled");
        }
        if (!this.isLoginSuccess && !this.isNavigatingToVerifyCode) {
            TraeAuthManager.INSTANCE.reportLoginFunnel(TraeAuthManager.STAGE_PAGE_EXIT, TraeAuthManager.PLATFORM_UNSELECTED, null, null, null, null);
        }
        unregisterNetworkCallback();
        super.onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    /* renamed from: com_bytedance_trae_login_activity_AccountLoginActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop */
    public static void m378x55f127da(AccountLoginActivity accountLoginActivity) {
        accountLoginActivity.m379x3d65ec1();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                ((Activity) accountLoginActivity).getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }
}
