package com.bytedance.trae.login.bytecloud;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.bytedance.trae.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* compiled from: BytecloudLoginActivity.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\u0005H\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/trae/login/bytecloud/BytecloudLoginActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "Landroid/content/Intent;", "handleIntent", "navigateToMainActivity", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class BytecloudLoginActivity extends AppCompatActivity {
    private static final String MAIN_ACTIVITY_CLASS = "com.bytedance.trae.home.MainActivity";
    private static final String TAG = "BytecloudLoginActivity";

    /* renamed from: com_bytedance_trae_login_bytecloud_BytecloudLoginActivity__onStop$___twin___ */
    public void m406x16b20ebd() {
        super.onStop();
    }

    protected void onStop() {
        m405xc659055e(this);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "getIntent(...)");
        handleIntent(intent);
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            handleIntent(intent);
        }
    }

    private final void handleIntent(Intent intent) {
        Uri data = intent.getData();
        if (data == null) {
            FLogger.INSTANCE.mo426e(TAG, "回调 Intent 无 data URI");
            finish();
            return;
        }
        String redirectUri = BytecloudAuthManager.INSTANCE.getRedirectUri();
        String uri = data.toString();
        Intrinsics.checkNotNullExpressionValue(uri, "toString(...)");
        if (!StringsKt.startsWith$default(uri, redirectUri, false, 2, (Object) null)) {
            FLogger.INSTANCE.mo426e(TAG, "非法回调 URI, expected=" + redirectUri);
            finish();
        } else {
            FLogger.INSTANCE.mo428i(TAG, "收到 ByteCloud 回调: " + data.getScheme() + "://" + data.getHost() + data.getPath());
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new BytecloudLoginActivity$handleIntent$1(data, System.currentTimeMillis(), this, null), 3, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void navigateToMainActivity() {
        Intent intent = new Intent();
        intent.setClassName((Context) this, MAIN_ACTIVITY_CLASS);
        intent.setFlags(268468224);
        intent.putExtra("from_login_success", true);
        startActivity(intent);
        finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    /* renamed from: com_bytedance_trae_login_bytecloud_BytecloudLoginActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop */
    public static void m405xc659055e(BytecloudLoginActivity bytecloudLoginActivity) {
        bytecloudLoginActivity.m406x16b20ebd();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                ((Activity) bytecloudLoginActivity).getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }
}
