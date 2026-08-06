package com.bytedance.annie.pro.p002ui;

import android.app.Activity;
import android.os.Bundle;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.anniex.R;
import com.bytedance.sdk.xbridge.cn.ui.utils.StatusBarUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* compiled from: AnnieProActivity.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\nH\u0002J\u0012\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/annie/pro/ui/AnnieProActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "mSchema", "", "getMSchema$anniex_release", "()Ljava/lang/String;", "setMSchema$anniex_release", "(Ljava/lang/String;)V", "initFragment", "", "initParams", "initUI", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class AnnieProActivity extends AppCompatActivity {
    public static final String BUNDLE_KEY_SCHEMA = "schema";
    private String mSchema;

    public void com_bytedance_annie_pro_ui_AnnieProActivity__onStop$___twin___() {
        super.onStop();
    }

    protected void onStop() {
        m61x410e0364(this);
    }

    /* renamed from: getMSchema$anniex_release, reason: from getter */
    public final String getMSchema() {
        return this.mSchema;
    }

    public final void setMSchema$anniex_release(String str) {
        this.mSchema = str;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_annie_pro);
        initParams();
        initFragment();
        initUI();
    }

    private final void initParams() {
        this.mSchema = getIntent().getStringExtra("schema");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initUI() {
        Activity activity = (Activity) this;
        StatusBarUtils.INSTANCE.setTransparentSystemUI(activity);
        StatusBarUtils.INSTANCE.trySetStatusBar(activity, getWindow(), true);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.hide();
        }
    }

    private final void initFragment() {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "supportFragmentManager.beginTransaction()");
        beginTransaction.add(R.id.annie_pro_fragment_container, new AnnieProFragment());
        beginTransaction.commit();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    /* renamed from: com_bytedance_annie_pro_ui_AnnieProActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop */
    public static void m61x410e0364(AnnieProActivity annieProActivity) {
        annieProActivity.com_bytedance_annie_pro_ui_AnnieProActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                ((Activity) annieProActivity).getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }
}
