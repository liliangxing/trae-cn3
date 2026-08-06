package com.bytedance.sdk.account.twiceverify;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.bytedance.ies.bullet.base.BulletSdk;
import com.bytedance.ies.bullet.service.base.api.IBulletUIComponent;
import com.bytedance.ies.bullet.service.base.api.IBulletUILifecycleListener;
import com.bytedance.ies.bullet.service.base.router.config.RouterOpenConfig;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class TwiceVerifyActivity extends Activity {
    private static final String KEY_DATA = "data";
    private static final String KEY_IS_START = "is_start";
    private static final String KEY_SCHEMA = "schema";
    private static final String KEY_URL = "url";
    private static final String TAG = "TwiceVerifyActivity";
    private boolean hasCallback = false;

    /* renamed from: com_bytedance_sdk_account_twiceverify_TwiceVerifyActivity__onStop$___twin___ */
    public void m8x3aa33a72() {
        super.onStop();
    }

    @Override // android.app.Activity
    protected void onStop() {
        m7xa4bf76c9(this);
    }

    public static void startIntent(Context context, String str, String str2, String str3) {
        Intent intent = new Intent(context, (Class<?>) TwiceVerifyActivity.class);
        intent.putExtra(KEY_IS_START, true);
        intent.putExtra(KEY_SCHEMA, str);
        intent.putExtra("url", str2);
        intent.putExtra("data", str3);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null && intent.getBooleanExtra(KEY_IS_START, false)) {
            TwiceVerifyLogHelper.m9d(TAG, "onCreate，is_start = true");
            if (openWebPage(intent.getStringExtra(KEY_SCHEMA), intent.getStringExtra("url"), intent.getStringExtra("data"))) {
                return;
            }
            callbackFailAndFinish();
            return;
        }
        TwiceVerifyLogHelper.m9d(TAG, "onCreate，is_start = false");
        callbackFailAndFinish();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();
        if (intent != null && intent.getBooleanExtra(KEY_IS_START, false)) {
            TwiceVerifyLogHelper.m9d(TAG, "onResume，is_start = true");
            intent.removeExtra(KEY_IS_START);
        } else {
            TwiceVerifyLogHelper.m9d(TAG, "onResume，is_start = false");
            callbackFailAndFinish();
        }
    }

    protected boolean openWebPage(String str, String str2, String str3) {
        boolean z;
        try {
            Uri build = Uri.parse(str).buildUpon().appendQueryParameter("url", str2).build();
            if (TwiceVerifyManager.getExternalDepend() != null) {
                z = TwiceVerifyManager.getExternalDepend().openSchema(build.toString(), null);
            } else {
                RouterOpenConfig routerOpenConfig = new RouterOpenConfig();
                routerOpenConfig.setUiLifecycleListener(new IBulletUILifecycleListener.Base() { // from class: com.bytedance.sdk.account.twiceverify.TwiceVerifyActivity.1
                    public void onClose(IBulletUIComponent iBulletUIComponent) {
                        TwiceVerifyLogHelper.m9d(TwiceVerifyActivity.TAG, "IBulletUILifecycleListener onClose called");
                        TwiceVerifyActivity.this.callbackFailAndFinish();
                    }
                });
                z = BulletSdk.INSTANCE.open(this, build, routerOpenConfig, "");
            }
        } catch (Throwable th) {
            TwiceVerifyLogHelper.m9d(TAG, "openWebPage crash: " + Log.getStackTraceString(th));
            z = false;
        }
        TwiceVerifyLogHelper.m9d(TAG, "openWebPage success: " + z);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackFailAndFinish() {
        if (this.hasCallback) {
            return;
        }
        this.hasCallback = true;
        TwiceVerifyManager.getInstance().onTwiceVerifyError();
        finish();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    /* renamed from: com_bytedance_sdk_account_twiceverify_TwiceVerifyActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop */
    public static void m7xa4bf76c9(TwiceVerifyActivity twiceVerifyActivity) {
        twiceVerifyActivity.m8x3aa33a72();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                twiceVerifyActivity.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }
}
