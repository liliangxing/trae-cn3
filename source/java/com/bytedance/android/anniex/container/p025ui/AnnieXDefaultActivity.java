package com.bytedance.android.anniex.container.p025ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.anniex.C0840R;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* compiled from: AnnieXDefaultActivity.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0012\u0010\f\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u000f\u001a\u00020\nH\u0014R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/anniex/container/ui/AnnieXDefaultActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "annieXPageHelper", "Lcom/bytedance/android/anniex/container/ui/AnnieXPageHelper;", "getAnnieXPageHelper", "()Lcom/bytedance/android/anniex/container/ui/AnnieXPageHelper;", "annieXPageHelper$delegate", "Lkotlin/Lazy;", "finish", "", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXDefaultActivity extends AppCompatActivity {

    /* renamed from: annieXPageHelper$delegate, reason: from kotlin metadata */
    private final Lazy annieXPageHelper = LazyKt.lazy(new Function0<AnnieXPageHelper>() { // from class: com.bytedance.android.anniex.container.ui.AnnieXDefaultActivity$annieXPageHelper$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final AnnieXPageHelper m3302invoke() {
            return new AnnieXPageHelper();
        }
    });

    /* renamed from: com_bytedance_android_anniex_container_ui_AnnieXDefaultActivity__onStop$___twin___ */
    public void m1267x586d56b1() {
        super.onStop();
    }

    protected void onStop() {
        m1266x39ab65ea(this);
    }

    private final AnnieXPageHelper getAnnieXPageHelper() {
        return (AnnieXPageHelper) this.annieXPageHelper.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0840R.layout.activity_anniex_default);
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        getAnnieXPageHelper().onCreate((FragmentActivity) this, intent, C0840R.id.annie_x_container);
    }

    protected void onDestroy() {
        super.onDestroy();
        getAnnieXPageHelper().onDestroy();
    }

    public void onBackPressed() {
        getAnnieXPageHelper().onBackPressed();
    }

    public void finish() {
        super.finish();
        getAnnieXPageHelper().finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    /* renamed from: com_bytedance_android_anniex_container_ui_AnnieXDefaultActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop */
    public static void m1266x39ab65ea(AnnieXDefaultActivity annieXDefaultActivity) {
        annieXDefaultActivity.m1267x586d56b1();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                ((Activity) annieXDefaultActivity).getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }
}
