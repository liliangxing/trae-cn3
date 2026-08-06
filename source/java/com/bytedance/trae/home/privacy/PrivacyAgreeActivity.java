package com.bytedance.trae.home.privacy;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.core.view.WindowCompat;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.bytedance.trae.home.C0820R;
import com.bytedance.trae.home.MainActivity;
import com.bytedance.trae.home.zlink.ZlinkInitializer;
import com.bytedance.trae.utils.LocaleManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* compiled from: PrivacyAgreeActivity.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\u0012\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J\b\u0010\r\u001a\u00020\u0007H\u0002J\b\u0010\u000e\u001a\u00020\u0007H\u0002J\b\u0010\u000f\u001a\u00020\u0007H\u0002J\b\u0010\u0010\u001a\u00020\u0007H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/home/privacy/PrivacyAgreeActivity;", "Landroidx/activity/ComponentActivity;", "<init>", "()V", "handler", "Landroid/os/Handler;", "attachBaseContext", "", "base", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "showPrivacyDialog", "onPrivacyAccepted", "onPrivacyRefused", "onDestroy", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class PrivacyAgreeActivity extends ComponentActivity {
    public static final int $stable = 8;
    private final Handler handler = new Handler(Looper.getMainLooper());

    /* renamed from: com_bytedance_trae_home_privacy_PrivacyAgreeActivity__onStop$___twin___ */
    public void m873x1a758bbc() {
        super.onStop();
    }

    protected void onStop() {
        m872xe59d0bbf(this);
    }

    protected void attachBaseContext(Context base) {
        Context wrapContext;
        if (base != null && (wrapContext = LocaleManager.INSTANCE.wrapContext(base)) != null) {
            base = wrapContext;
        }
        super.attachBaseContext(base);
        Log.i(PrivacyManager.TAG, "PrivacyAgreeActivity attachBaseContext");
    }

    protected void onCreate(Bundle savedInstanceState) {
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        super.onCreate(savedInstanceState);
        Log.i(PrivacyManager.TAG, "PrivacyAgreeActivity onCreate");
        showPrivacyDialog();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void showPrivacyDialog() {
        Context context = (Context) this;
        PrivacyCache.INSTANCE.savePrivacyWindowShow(context);
        final Dialog dialog = new Dialog(context);
        View inflate = LayoutInflater.from(context).inflate(C0820R.layout.dialog_privacy, (ViewGroup) null);
        dialog.setContentView(inflate);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setLayout((int) (getResources().getDisplayMetrics().widthPixels * 0.85d), -2);
            window.setGravity(17);
            window.setDimAmount(0.5f);
        }
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        Intrinsics.checkNotNull(inflate);
        PrivacyDialogHelper.INSTANCE.setupMessageWithLinks(this, inflate);
        ((TextView) inflate.findViewById(C0820R.id.btn_agree)).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.privacy.PrivacyAgreeActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PrivacyAgreeActivity.showPrivacyDialog$lambda$2(dialog, this, view);
            }
        });
        ((TextView) inflate.findViewById(C0820R.id.btn_disagree)).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.privacy.PrivacyAgreeActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PrivacyAgreeActivity.showPrivacyDialog$lambda$3(dialog, this, view);
            }
        });
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showPrivacyDialog$lambda$2(Dialog dialog, PrivacyAgreeActivity privacyAgreeActivity, View view) {
        dialog.dismiss();
        privacyAgreeActivity.onPrivacyAccepted();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showPrivacyDialog$lambda$3(Dialog dialog, PrivacyAgreeActivity privacyAgreeActivity, View view) {
        dialog.dismiss();
        privacyAgreeActivity.onPrivacyRefused();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void onPrivacyAccepted() {
        Context context = (Context) this;
        PrivacyManager.INSTANCE.sendKillMySelfBroadcast(context);
        PrivacyCache.INSTANCE.savePrivacyWindowClick(context, true);
        PrivacyManager.INSTANCE.notifyAgree(true);
        ZlinkInitializer zlinkInitializer = ZlinkInitializer.INSTANCE;
        Application application = getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "getApplication(...)");
        zlinkInitializer.initAfterPrivacyAgreed(application);
        this.handler.postDelayed(new Runnable() { // from class: com.bytedance.trae.home.privacy.PrivacyAgreeActivity$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                PrivacyAgreeActivity.onPrivacyAccepted$lambda$4(PrivacyAgreeActivity.this);
            }
        }, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void onPrivacyAccepted$lambda$4(PrivacyAgreeActivity privacyAgreeActivity) {
        Intent intent = new Intent((Context) privacyAgreeActivity, (Class<?>) MainActivity.class);
        intent.setFlags(268468224);
        privacyAgreeActivity.startActivity(intent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void onPrivacyRefused() {
        Context context = (Context) this;
        PrivacyCache.INSTANCE.savePrivacyWindowClick(context, false);
        PrivacyManager.INSTANCE.sendKillMySelfBroadcast(context);
        this.handler.postDelayed(new Runnable() { // from class: com.bytedance.trae.home.privacy.PrivacyAgreeActivity$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                PrivacyAgreeActivity.onPrivacyRefused$lambda$5();
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onPrivacyRefused$lambda$5() {
        PrivacyManager.INSTANCE.exitProcess("user refused privacy agreement");
    }

    protected void onDestroy() {
        super.onDestroy();
        Process.killProcess(Process.myPid());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    /* renamed from: com_bytedance_trae_home_privacy_PrivacyAgreeActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop */
    public static void m872xe59d0bbf(PrivacyAgreeActivity privacyAgreeActivity) {
        privacyAgreeActivity.m873x1a758bbc();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                ((Activity) privacyAgreeActivity).getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }
}
