package com.bytedance.ies.bullet.core.container;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.ies.bullet.service.base.YieldError;
import com.bytedance.push.proxy.ActivityTaskManagerHooker;
import com.bytedance.trae.login.activity.PhoneBindActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BulletActivityWrapper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u0001:\u0001=B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u0016J*\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u001a\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u001a\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010\"\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010#\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J5\u0010$\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u000e\u0010%\u001a\n\u0012\u0006\b\u0001\u0012\u00020'0&2\u0006\u0010(\u001a\u00020)H\u0016¢\u0006\u0002\u0010*J\u001a\u0010+\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010,\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J\u001a\u0010-\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010.\u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010/\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u00100\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u00101\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00102\u001a\u000203H\u0016J\u0010\u00104\u001a\u00020\u00102\u0006\u00105\u001a\u00020\nH\u0016J\u0010\u00106\u001a\u00020\u00102\u0006\u00105\u001a\u00020\nH\u0016J\u0010\u00107\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0018\u00107\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u00108\u001a\u0002032\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u00109\u001a\u00020\u00102\u0006\u0010:\u001a\u00020\u001bH\u0016J\u0018\u0010;\u001a\u00020\u00102\u0006\u0010:\u001a\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010<\u001a\u00020\u00102\u0006\u00105\u001a\u00020\nH\u0016R\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00030\u00030\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/bytedance/ies/bullet/core/container/BulletActivityWrapper;", "Lcom/bytedance/ies/bullet/core/container/IBulletActivityWrapper;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "activityRef", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "delegates", "", "Lcom/bytedance/ies/bullet/core/container/IBulletActivityDelegate;", "getDelegates", "()Ljava/util/List;", "localDelegates", "", PhoneBindActivity.MODE_BIND, "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "doBackPress", "finish", "getActivity", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(Landroid/app/Activity;I[Ljava/lang/String;[I)V", "onRestoreInstanceState", "onResume", "onSaveInstanceState", "outState", "onStart", "onStop", "onWindowFocusChanged", "hasFocus", "", "registerDelegate", "delegate", "registerDelegateAtFirst", "setResult", "shouldInterceptBackPressedEvent", ActivityTaskManagerHooker.METHOD_START_ACTIVITY, "intent", "startActivityForResult", "unregisterDelegate", "BulletLifecycleObserver", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class BulletActivityWrapper implements IBulletActivityWrapper {
    private final WeakReference<Activity> activityRef;
    private final List<IBulletActivityDelegate> localDelegates;

    public BulletActivityWrapper(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activityRef = new WeakReference<>(activity);
        this.localDelegates = new ArrayList();
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletActivityDelegate
    public void onRequestPermissionsResult(Activity activity, int requestCode, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        Iterator<T> it = getDelegates().iterator();
        while (it.hasNext()) {
            try {
                ((IBulletActivityDelegate) it.next()).onRequestPermissionsResult(activity, requestCode, permissions, grantResults);
            } catch (YieldError unused) {
            }
        }
    }

    /* compiled from: BulletActivityWrapper.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0002\u0010\u0007J(\u0010\u000b\u001a\u00020\f2\u001d\u0010\r\u001a\u0019\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\u0002\b\u0010H\u0082\bJ\b\u0010\u0011\u001a\u00020\fH\u0007J\b\u0010\u0012\u001a\u00020\fH\u0007J\b\u0010\u0013\u001a\u00020\fH\u0007J\b\u0010\u0014\u001a\u00020\fH\u0007J\b\u0010\u0015\u001a\u00020\fH\u0007J\b\u0010\u0016\u001a\u00020\fH\u0007R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ies/bullet/core/container/BulletActivityWrapper$BulletLifecycleObserver;", "Landroidx/lifecycle/LifecycleObserver;", "hostRef", "Ljava/lang/ref/WeakReference;", "Lcom/bytedance/ies/bullet/core/container/BulletActivityWrapper;", "lifecycleOwnerRef", "Landroidx/lifecycle/LifecycleOwner;", "(Ljava/lang/ref/WeakReference;Ljava/lang/ref/WeakReference;)V", "getHostRef", "()Ljava/lang/ref/WeakReference;", "getLifecycleOwnerRef", "callHost", "", "runnable", "Lkotlin/Function2;", "Landroid/app/Activity;", "Lkotlin/ExtensionFunctionType;", "onCreate", "onDestroy", "onPause", "onResume", "onStart", "onStop", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    private static final class BulletLifecycleObserver implements LifecycleObserver {
        private final WeakReference<BulletActivityWrapper> hostRef;
        private final WeakReference<LifecycleOwner> lifecycleOwnerRef;

        public BulletLifecycleObserver(WeakReference<BulletActivityWrapper> weakReference, WeakReference<LifecycleOwner> weakReference2) {
            Intrinsics.checkNotNullParameter(weakReference, "hostRef");
            Intrinsics.checkNotNullParameter(weakReference2, "lifecycleOwnerRef");
            this.hostRef = weakReference;
            this.lifecycleOwnerRef = weakReference2;
        }

        public final WeakReference<BulletActivityWrapper> getHostRef() {
            return this.hostRef;
        }

        public final WeakReference<LifecycleOwner> getLifecycleOwnerRef() {
            return this.lifecycleOwnerRef;
        }

        private final void callHost(Function2<? super BulletActivityWrapper, ? super Activity, Unit> runnable) {
            Activity activity;
            BulletActivityWrapper bulletActivityWrapper = this.hostRef.get();
            if (bulletActivityWrapper == null || (activity = bulletActivityWrapper.getActivity()) == null) {
                return;
            }
            runnable.invoke(bulletActivityWrapper, activity);
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
        public final void onCreate() {
            BulletActivityWrapper bulletActivityWrapper;
            Activity activity;
            if (this.hostRef.get() == null || (bulletActivityWrapper = this.hostRef.get()) == null || (activity = bulletActivityWrapper.getActivity()) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(bulletActivityWrapper, "callHost$lambda$1$lambda$0");
            bulletActivityWrapper.onCreate(activity, null);
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        public final void onStart() {
            BulletActivityWrapper bulletActivityWrapper;
            Activity activity;
            if (this.hostRef.get() == null || (bulletActivityWrapper = this.hostRef.get()) == null || (activity = bulletActivityWrapper.getActivity()) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(bulletActivityWrapper, "callHost$lambda$1$lambda$0");
            bulletActivityWrapper.onStart(activity);
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
        public final void onResume() {
            BulletActivityWrapper bulletActivityWrapper;
            Activity activity;
            if (this.hostRef.get() == null || (bulletActivityWrapper = this.hostRef.get()) == null || (activity = bulletActivityWrapper.getActivity()) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(bulletActivityWrapper, "callHost$lambda$1$lambda$0");
            bulletActivityWrapper.onResume(activity);
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
        public final void onPause() {
            BulletActivityWrapper bulletActivityWrapper;
            Activity activity;
            if (this.hostRef.get() == null || (bulletActivityWrapper = this.hostRef.get()) == null || (activity = bulletActivityWrapper.getActivity()) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(bulletActivityWrapper, "callHost$lambda$1$lambda$0");
            bulletActivityWrapper.onPause(activity);
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
        public final void onStop() {
            BulletActivityWrapper bulletActivityWrapper;
            Activity activity;
            if (this.hostRef.get() == null || (bulletActivityWrapper = this.hostRef.get()) == null || (activity = bulletActivityWrapper.getActivity()) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(bulletActivityWrapper, "callHost$lambda$1$lambda$0");
            bulletActivityWrapper.onStop(activity);
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public final void onDestroy() {
            BulletActivityWrapper bulletActivityWrapper;
            Activity activity;
            Lifecycle lifecycle;
            if (this.hostRef.get() == null || (bulletActivityWrapper = this.hostRef.get()) == null || (activity = bulletActivityWrapper.getActivity()) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(bulletActivityWrapper, "callHost$lambda$1$lambda$0");
            bulletActivityWrapper.onDestroy(activity);
            LifecycleOwner lifecycleOwner = this.lifecycleOwnerRef.get();
            if (lifecycleOwner == null || (lifecycle = lifecycleOwner.getLifecycle()) == null) {
                return;
            }
            lifecycle.removeObserver(this);
        }
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletActivityWrapper
    public void bind(LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        lifecycleOwner.getLifecycle().addObserver(new BulletLifecycleObserver(new WeakReference(this), new WeakReference(lifecycleOwner)));
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletActivityDelegate
    public void onConfigurationChanged(Activity activity, Configuration newConfig) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Iterator<T> it = getDelegates().iterator();
        while (it.hasNext()) {
            try {
                ((IBulletActivityDelegate) it.next()).onConfigurationChanged(activity, newConfig);
            } catch (YieldError unused) {
            }
        }
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletActivityDelegate
    public void onCreate(Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Iterator<T> it = getDelegates().iterator();
        while (it.hasNext()) {
            try {
                ((IBulletActivityDelegate) it.next()).onCreate(activity, savedInstanceState);
            } catch (YieldError unused) {
            }
        }
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletActivityDelegate
    public void onStart(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Iterator<T> it = getDelegates().iterator();
        while (it.hasNext()) {
            try {
                ((IBulletActivityDelegate) it.next()).onStart(activity);
            } catch (YieldError unused) {
            }
        }
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletActivityDelegate
    public void onResume(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Iterator<T> it = getDelegates().iterator();
        while (it.hasNext()) {
            try {
                ((IBulletActivityDelegate) it.next()).onResume(activity);
            } catch (YieldError unused) {
            }
        }
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletActivityDelegate
    public void onPause(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Iterator<T> it = getDelegates().iterator();
        while (it.hasNext()) {
            try {
                ((IBulletActivityDelegate) it.next()).onPause(activity);
            } catch (YieldError unused) {
            }
        }
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletActivityDelegate
    public void onStop(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Iterator<T> it = getDelegates().iterator();
        while (it.hasNext()) {
            try {
                ((IBulletActivityDelegate) it.next()).onStop(activity);
            } catch (YieldError unused) {
            }
        }
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletActivityDelegate
    public void onDestroy(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Iterator<T> it = getDelegates().iterator();
        while (it.hasNext()) {
            try {
                ((IBulletActivityDelegate) it.next()).onDestroy(activity);
            } catch (YieldError unused) {
            }
        }
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletActivityDelegate
    public void onSaveInstanceState(Activity activity, Bundle outState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Iterator<T> it = getDelegates().iterator();
        while (it.hasNext()) {
            try {
                ((IBulletActivityDelegate) it.next()).onSaveInstanceState(activity, outState);
            } catch (YieldError unused) {
            }
        }
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletActivityDelegate
    public void onRestoreInstanceState(Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Iterator<T> it = getDelegates().iterator();
        while (it.hasNext()) {
            try {
                ((IBulletActivityDelegate) it.next()).onRestoreInstanceState(activity, savedInstanceState);
            } catch (YieldError unused) {
            }
        }
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletActivityDelegate
    public void onWindowFocusChanged(Activity activity, boolean hasFocus) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Iterator<T> it = getDelegates().iterator();
        while (it.hasNext()) {
            try {
                ((IBulletActivityDelegate) it.next()).onWindowFocusChanged(activity, hasFocus);
            } catch (YieldError unused) {
            }
        }
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletActivityDelegate
    public void onActivityResult(Activity activity, int requestCode, int resultCode, Intent data) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Iterator<T> it = getDelegates().iterator();
        while (it.hasNext()) {
            try {
                ((IBulletActivityDelegate) it.next()).onActivityResult(activity, requestCode, resultCode, data);
            } catch (YieldError unused) {
            }
        }
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletActivityDelegate
    public boolean shouldInterceptBackPressedEvent(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Iterator<T> it = getDelegates().iterator();
        while (it.hasNext()) {
            try {
                return ((IBulletActivityDelegate) it.next()).shouldInterceptBackPressedEvent(activity);
            } catch (YieldError unused) {
            }
        }
        return false;
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletActivityWrapper
    public List<IBulletActivityDelegate> getDelegates() {
        return CollectionsKt.toList(this.localDelegates);
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletActivityWrapper
    public void registerDelegate(IBulletActivityDelegate delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        if (this.localDelegates.contains(delegate)) {
            return;
        }
        this.localDelegates.add(delegate);
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletActivityWrapper
    public void registerDelegateAtFirst(IBulletActivityDelegate delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.localDelegates.add(0, delegate);
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletActivityWrapper
    public void unregisterDelegate(IBulletActivityDelegate delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.localDelegates.remove(delegate);
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletActivityWrapper
    public void startActivity(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Activity activity = this.activityRef.get();
        if (activity != null) {
            activity.startActivity(intent);
        }
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletActivityWrapper
    public void startActivityForResult(Intent intent, int requestCode) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Activity activity = this.activityRef.get();
        if (activity != null) {
            activity.startActivityForResult(intent, requestCode);
        }
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletActivityWrapper
    public void setResult(int resultCode) {
        Activity activity = this.activityRef.get();
        if (activity != null) {
            activity.setResult(resultCode);
        }
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletActivityWrapper
    public void setResult(int resultCode, Intent data) {
        Intrinsics.checkNotNullParameter(data, "data");
        Activity activity = this.activityRef.get();
        if (activity != null) {
            activity.setResult(resultCode, data);
        }
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletActivityWrapper
    public Activity getActivity() {
        return this.activityRef.get();
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletActivityWrapper
    public void doBackPress() {
        Activity activity = this.activityRef.get();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletActivityWrapper
    public void finish() {
        Activity activity = this.activityRef.get();
        if (activity != null) {
            activity.finish();
        }
    }
}
