package com.google.android.gms.auth.api.signin.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.sysoptimizer.BadParcelableCrashOptimizer;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.example.memorycollector.BuildConfig;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInStatusCodes;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.common.api.Status;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* compiled from: com.google.android.gms:play-services-auth@@20.5.0 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class SignInHubActivity extends FragmentActivity {
    private static boolean zba;
    private boolean zbb = false;
    private SignInConfiguration zbc;
    private boolean zbd;
    private int zbe;
    private Intent zbf;

    private final void zbc() {
        getSupportLoaderManager().initLoader(0, (Bundle) null, new zbw(this, null));
        zba = false;
    }

    private final void zbd(int i) {
        Status status = new Status(i);
        Intent intent = new Intent();
        intent.putExtra("googleSignInStatus", status);
        setResult(0, intent);
        finish();
        zba = false;
    }

    private final void zbe(String str) {
        Intent intent = new Intent(str);
        if (str.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN")) {
            intent.setPackage("com.google.android.gms");
        } else {
            intent.setPackage(getPackageName());
        }
        intent.putExtra("config", this.zbc);
        try {
            startActivityForResult(intent, 40962);
        } catch (ActivityNotFoundException unused) {
            this.zbb = true;
            Log.w("AuthSignInClient", "Could not launch sign in Intent. Google Play Service is probably being updated...");
            zbd(17);
        }
    }

    /* renamed from: com_google_android_gms_auth_api_signin_internal_SignInHubActivity__onStop$___twin___ */
    public void m508x2003b490() {
        super.onStop();
    }

    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected final void onActivityResult(int i, int i2, Intent intent) {
        if (this.zbb) {
            return;
        }
        setResult(0);
        if (i != 40962) {
            return;
        }
        if (intent != null) {
            SignInAccount signInAccount = (SignInAccount) intent.getParcelableExtra(GoogleSignInApi.EXTRA_SIGN_IN_ACCOUNT);
            if (signInAccount == null || signInAccount.zba() == null) {
                if (intent.hasExtra("errorCode")) {
                    int intExtra = intent.getIntExtra("errorCode", 8);
                    if (intExtra == 13) {
                        intExtra = GoogleSignInStatusCodes.SIGN_IN_CANCELLED;
                    }
                    zbd(intExtra);
                    return;
                }
            } else {
                GoogleSignInAccount zba2 = signInAccount.zba();
                zbn zbc = zbn.zbc(this);
                GoogleSignInOptions zba3 = this.zbc.zba();
                zba2.getClass();
                zbc.zbe(zba3, zba2);
                intent.removeExtra(GoogleSignInApi.EXTRA_SIGN_IN_ACCOUNT);
                intent.putExtra("googleSignInAccount", zba2);
                this.zbd = true;
                this.zbe = i2;
                this.zbf = intent;
                zbc();
                return;
            }
        }
        zbd(8);
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        String action = intent.getAction();
        action.getClass();
        if ("com.google.android.gms.auth.NO_IMPL".equals(action)) {
            zbd(GoogleSignInStatusCodes.SIGN_IN_FAILED);
            return;
        }
        if (action.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN") || action.equals("com.google.android.gms.auth.APPAUTH_SIGN_IN")) {
            Bundle m506xd404683b = m506xd404683b(intent, "config");
            m506xd404683b.getClass();
            SignInConfiguration signInConfiguration = (SignInConfiguration) m506xd404683b.getParcelable("config");
            if (signInConfiguration == null) {
                Log.e("AuthSignInClient", "Activity started with invalid configuration.");
                setResult(0);
                finish();
                return;
            }
            this.zbc = signInConfiguration;
            if (bundle == null) {
                if (zba) {
                    setResult(0);
                    zbd(GoogleSignInStatusCodes.SIGN_IN_CURRENTLY_IN_PROGRESS);
                    return;
                } else {
                    zba = true;
                    zbe(action);
                    return;
                }
            }
            boolean z = bundle.getBoolean("signingInGoogleApiClients");
            this.zbd = z;
            if (z) {
                this.zbe = bundle.getInt("signInResultCode");
                Intent intent2 = (Intent) bundle.getParcelable("signInResultData");
                intent2.getClass();
                this.zbf = intent2;
                zbc();
                return;
            }
            return;
        }
        Log.e("AuthSignInClient", "Unknown action: ".concat(String.valueOf(intent.getAction())));
        finish();
    }

    public final void onDestroy() {
        super.onDestroy();
        zba = false;
    }

    protected final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("signingInGoogleApiClients", this.zbd);
        if (this.zbd) {
            bundle.putInt("signInResultCode", this.zbe);
            bundle.putParcelable("signInResultData", this.zbf);
        }
    }

    protected void onStop() {
        m507x61b1976b(this);
    }

    @Proxy("getBundleExtra")
    @TargetClass("android.content.Intent")
    /* renamed from: INVOKEVIRTUAL_com_google_android_gms_auth_api_signin_internal_SignInHubActivity_com_bytedance_sysoptimizer_BadParcelableLancet_getBundleExtra */
    public static Bundle m506xd404683b(Intent intent, String str) {
        Bundle bundleExtra = intent.getBundleExtra(str);
        Context context = BadParcelableCrashOptimizer.getContext();
        if (bundleExtra != null && context != null) {
            bundleExtra.setClassLoader(context.getClassLoader());
        }
        return bundleExtra;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = BuildConfig.ONLINE, value = "onStop")
    /* renamed from: com_google_android_gms_auth_api_signin_internal_SignInHubActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop */
    public static void m507x61b1976b(SignInHubActivity signInHubActivity) {
        signInHubActivity.m508x2003b490();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                ((Activity) signInHubActivity).getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }
}
