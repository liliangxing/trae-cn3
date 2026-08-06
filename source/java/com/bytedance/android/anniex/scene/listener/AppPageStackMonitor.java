package com.bytedance.android.anniex.scene.listener;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.anniex.scene.core.SceneManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AppPageStackMonitor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000 \u00152\u00020\u0001:\u0002\u0015\u0016B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u001a\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\rH\u0016J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/anniex/scene/listener/AppPageStackMonitor;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "()V", "isInit", "", "init", "", "application", "Landroid/app/Application;", "onActivityCreated", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivitySaveInstanceState", "outState", "onActivityStarted", "onActivityStopped", "Companion", "FragmentStackCallback", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AppPageStackMonitor implements Application.ActivityLifecycleCallbacks {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "AppPageStackMonitor";
    private static AppPageStackMonitor instance;
    private boolean isInit;

    public /* synthetic */ AppPageStackMonitor(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(outState, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    private AppPageStackMonitor() {
    }

    /* compiled from: AppPageStackMonitor.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/android/anniex/scene/listener/AppPageStackMonitor$Companion;", "", "()V", "TAG", "", "instance", "Lcom/bytedance/android/anniex/scene/listener/AppPageStackMonitor;", "getInstance", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AppPageStackMonitor getInstance() {
            if (AppPageStackMonitor.instance == null) {
                AppPageStackMonitor.instance = new AppPageStackMonitor(null);
            }
            AppPageStackMonitor appPageStackMonitor = AppPageStackMonitor.instance;
            Intrinsics.checkNotNull(appPageStackMonitor);
            return appPageStackMonitor;
        }
    }

    public final void init(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        if (!this.isInit) {
            application.registerActivityLifecycleCallbacks(this);
        }
        this.isInit = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        String simpleName = activity.getClass().getSimpleName();
        if (activity instanceof FragmentActivity) {
            ((FragmentActivity) activity).getSupportFragmentManager().registerFragmentLifecycleCallbacks(new FragmentStackCallback(), true);
        }
        SceneManager companion = SceneManager.INSTANCE.getInstance();
        Intrinsics.checkNotNullExpressionValue(simpleName, "activityName");
        companion.sendPageAttachEvent(simpleName);
    }

    /* compiled from: AppPageStackMonitor.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/android/anniex/scene/listener/AppPageStackMonitor$FragmentStackCallback;", "Landroidx/fragment/app/FragmentManager$FragmentLifecycleCallbacks;", "(Lcom/bytedance/android/anniex/scene/listener/AppPageStackMonitor;)V", "onFragmentDestroyed", "", "fm", "Landroidx/fragment/app/FragmentManager;", "f", "Landroidx/fragment/app/Fragment;", "onFragmentDetached", "onFragmentPaused", "onFragmentResumed", "onFragmentStopped", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public final class FragmentStackCallback extends FragmentManager.FragmentLifecycleCallbacks {
        @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
        public void onFragmentDestroyed(FragmentManager fm, Fragment f) {
            Intrinsics.checkNotNullParameter(fm, "fm");
            Intrinsics.checkNotNullParameter(f, "f");
        }

        public FragmentStackCallback() {
        }

        @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
        public void onFragmentResumed(FragmentManager fm, Fragment f) {
            Intrinsics.checkNotNullParameter(fm, "fm");
            Intrinsics.checkNotNullParameter(f, "f");
            super.onFragmentResumed(fm, f);
            String simpleName = f.getClass().getSimpleName();
            SceneManager companion = SceneManager.INSTANCE.getInstance();
            Intrinsics.checkNotNullExpressionValue(simpleName, "fragmentName");
            companion.sendPageAttachEvent(simpleName);
        }

        @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
        public void onFragmentPaused(FragmentManager fm, Fragment f) {
            Intrinsics.checkNotNullParameter(fm, "fm");
            Intrinsics.checkNotNullParameter(f, "f");
            super.onFragmentPaused(fm, f);
        }

        @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
        public void onFragmentDetached(FragmentManager fm, Fragment f) {
            Intrinsics.checkNotNullParameter(fm, "fm");
            Intrinsics.checkNotNullParameter(f, "f");
            super.onFragmentDetached(fm, f);
        }

        @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
        public void onFragmentStopped(FragmentManager fm, Fragment f) {
            Intrinsics.checkNotNullParameter(fm, "fm");
            Intrinsics.checkNotNullParameter(f, "f");
            super.onFragmentStopped(fm, f);
        }
    }
}
