package com.bytedance.trae.home.solo.task;

import android.app.Activity;
import android.os.Bundle;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.bytedance.trae.common.activity.TraeCommonAppCompatActivity;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.home.C0820R;
import kotlin.Metadata;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* compiled from: TaskActivity.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014¨\u0006\n"}, d2 = {"Lcom/bytedance/trae/home/solo/task/TaskActivity;", "Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;", "<init>", "()V", "getDecorViewBackgroundColor", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TaskActivity extends TraeCommonAppCompatActivity {
    public static final int $stable = 0;

    /* renamed from: com_bytedance_trae_home_solo_task_TaskActivity__onStop$___twin___ */
    public void m879xfe22a438() {
        super.onStop();
    }

    protected void onStop() {
        m878x9cc2d0c3(this);
    }

    @Override // com.bytedance.trae.common.activity.TraeCommonAppCompatActivity
    public int getDecorViewBackgroundColor() {
        return getColor(C0591R.color.trae_bg_bg_base_secondary);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.trae.common.activity.TraeCommonAppCompatActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0820R.layout.activity_task);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(C0820R.id.fragment_container, new TaskFragment()).commit();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    /* renamed from: com_bytedance_trae_home_solo_task_TaskActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop */
    public static void m878x9cc2d0c3(TaskActivity taskActivity) {
        taskActivity.m879xfe22a438();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                ((Activity) taskActivity).getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }
}
