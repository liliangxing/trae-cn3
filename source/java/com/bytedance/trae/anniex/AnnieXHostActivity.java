package com.bytedance.trae.anniex;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.anniex.container.ui.AnnieXPageHelper;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.bytedance.trae.C0568R;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* compiled from: AnnieXHostActivity.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010\u000e\u001a\u00020\u000bH\u0014J\b\u0010\u000f\u001a\u00020\u000bH\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/bytedance/trae/anniex/AnnieXHostActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "annieXPageHelper", "Lcom/bytedance/android/anniex/container/ui/AnnieXPageHelper;", "getAnnieXPageHelper", "()Lcom/bytedance/android/anniex/container/ui/AnnieXPageHelper;", "annieXPageHelper$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "finish", "app_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class AnnieXHostActivity extends AppCompatActivity {
    public static final int $stable = 8;

    /* renamed from: annieXPageHelper$delegate, reason: from kotlin metadata */
    private final Lazy annieXPageHelper = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.anniex.AnnieXHostActivity$$ExternalSyntheticLambda0
        public final Object invoke() {
            AnnieXPageHelper annieXPageHelper_delegate$lambda$0;
            annieXPageHelper_delegate$lambda$0 = AnnieXHostActivity.annieXPageHelper_delegate$lambda$0();
            return annieXPageHelper_delegate$lambda$0;
        }
    });

    public void com_bytedance_trae_anniex_AnnieXHostActivity__onStop$___twin___() {
        super.onStop();
    }

    protected void onStop() {
        m777x377abceb(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AnnieXPageHelper getAnnieXPageHelper() {
        return (AnnieXPageHelper) this.annieXPageHelper.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AnnieXPageHelper annieXPageHelper_delegate$lambda$0() {
        return new AnnieXPageHelper();
    }

    protected void onCreate(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            savedInstanceState.clear();
        }
        super.onCreate(savedInstanceState);
        setContentView(C0568R.layout.activity_anniex_host);
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "getIntent(...)");
        getAnnieXPageHelper().onCreate((FragmentActivity) this, intent, C0568R.id.anniex_container);
        getOnBackPressedDispatcher().addCallback((LifecycleOwner) this, new OnBackPressedCallback() { // from class: com.bytedance.trae.anniex.AnnieXHostActivity$onCreate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(true);
            }

            public void handleOnBackPressed() {
                AnnieXPageHelper annieXPageHelper;
                annieXPageHelper = AnnieXHostActivity.this.getAnnieXPageHelper();
                annieXPageHelper.onBackPressed();
            }
        });
    }

    protected void onDestroy() {
        super.onDestroy();
        getAnnieXPageHelper().onDestroy();
    }

    public void finish() {
        super.finish();
        getAnnieXPageHelper().finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    /* renamed from: com_bytedance_trae_anniex_AnnieXHostActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop */
    public static void m777x377abceb(AnnieXHostActivity annieXHostActivity) {
        annieXHostActivity.com_bytedance_trae_anniex_AnnieXHostActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                ((Activity) annieXHostActivity).getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }
}
