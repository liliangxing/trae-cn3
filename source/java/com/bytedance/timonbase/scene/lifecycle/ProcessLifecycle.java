package com.bytedance.timonbase.scene.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.bytedance.timonbase.scene.config.SenseConfigManager;
import com.bytedance.timonbase.scene.lifecycle.ProcessLifecycle;
import com.bytedance.timonbase.scene.synchronizer.AppForegroundStatusSynchronizer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProcessLifecycle.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000W\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0001\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001$B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0001¢\u0006\u0002\b\u0016J\u0006\u0010\u0017\u001a\u00020\u0018J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u0004\u0018\u00010\rJ\u0015\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0001¢\u0006\u0002\b\u001dJ\u000e\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u0018J\u0006\u0010 \u001a\u00020\u0010J\u000e\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\bJ\u000e\u0010#\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\bR\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bj\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/bytedance/timonbase/scene/lifecycle/ProcessLifecycle;", "", "()V", "activityLifecycleCallbacks", "com/bytedance/timonbase/scene/lifecycle/ProcessLifecycle$activityLifecycleCallbacks$1", "Lcom/bytedance/timonbase/scene/lifecycle/ProcessLifecycle$activityLifecycleCallbacks$1;", "callbackSet", "Ljava/util/LinkedHashSet;", "Lcom/bytedance/timonbase/scene/lifecycle/ProcessLifecycle$Callbacks;", "Lkotlin/collections/LinkedHashSet;", "foregroundActivities", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "lastAppForegroundState", "", "lastProcessForegroundState", "deInitialize", "", "application", "Landroid/app/Application;", "deInitialize$timonbase_release", "getAppInBackgroundTime", "", "getForegroundState", "Lcom/bytedance/timonbase/scene/lifecycle/ForegroundState;", "getTopActivity", "initialize", "initialize$timonbase_release", "isAppBackground", "tolerableDuration", "isProcessBackground", "registerLifecycleCallbacks", "callbacks", "unregisterLifecycleCallbacks", "Callbacks", "timonbase_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ProcessLifecycle {
    private static boolean lastAppForegroundState;
    private static boolean lastProcessForegroundState;
    public static final ProcessLifecycle INSTANCE = new ProcessLifecycle();
    private static final HashMap<Integer, String> foregroundActivities = new HashMap<>();
    private static final LinkedHashSet<Callbacks> callbackSet = new LinkedHashSet<>();
    private static final ProcessLifecycle$activityLifecycleCallbacks$1 activityLifecycleCallbacks = new SimpleActivityLifecycleCallbacks() { // from class: com.bytedance.timonbase.scene.lifecycle.ProcessLifecycle$activityLifecycleCallbacks$1
        @Override // com.bytedance.timonbase.scene.lifecycle.SimpleActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            HashMap hashMap;
            boolean z;
            boolean z2;
            LinkedHashSet linkedHashSet;
            LinkedHashSet linkedHashSet2;
            Intrinsics.checkParameterIsNotNull(activity, "activity");
            ProcessLifecycle processLifecycle = ProcessLifecycle.INSTANCE;
            hashMap = ProcessLifecycle.foregroundActivities;
            Integer valueOf = Integer.valueOf(activity.hashCode());
            String simpleName = activity.getClass().getSimpleName();
            Intrinsics.checkExpressionValueIsNotNull(simpleName, "activity::class.java.simpleName");
            hashMap.put(valueOf, simpleName);
            ProcessLifecycle processLifecycle2 = ProcessLifecycle.INSTANCE;
            z = ProcessLifecycle.lastProcessForegroundState;
            if (!z) {
                ForegroundHolder.INSTANCE.setForeground$timonbase_release(true);
                ProcessLifecycle processLifecycle3 = ProcessLifecycle.INSTANCE;
                linkedHashSet2 = ProcessLifecycle.callbackSet;
                Iterator it = linkedHashSet2.iterator();
                while (it.hasNext()) {
                    ((ProcessLifecycle.Callbacks) it.next()).onProcessForeground();
                }
            }
            ProcessLifecycle processLifecycle4 = ProcessLifecycle.INSTANCE;
            z2 = ProcessLifecycle.lastAppForegroundState;
            if (!z2) {
                ProcessLifecycle processLifecycle5 = ProcessLifecycle.INSTANCE;
                linkedHashSet = ProcessLifecycle.callbackSet;
                Iterator it2 = linkedHashSet.iterator();
                while (it2.hasNext()) {
                    ((ProcessLifecycle.Callbacks) it2.next()).onAppForeground();
                }
            }
            ProcessLifecycle processLifecycle6 = ProcessLifecycle.INSTANCE;
            ProcessLifecycle.lastProcessForegroundState = true;
            ProcessLifecycle processLifecycle7 = ProcessLifecycle.INSTANCE;
            ProcessLifecycle.lastAppForegroundState = true;
        }

        @Override // com.bytedance.timonbase.scene.lifecycle.SimpleActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            HashMap hashMap;
            boolean z;
            boolean z2;
            LinkedHashSet linkedHashSet;
            LinkedHashSet linkedHashSet2;
            Intrinsics.checkParameterIsNotNull(activity, "activity");
            ProcessLifecycle processLifecycle = ProcessLifecycle.INSTANCE;
            hashMap = ProcessLifecycle.foregroundActivities;
            Integer valueOf = Integer.valueOf(activity.hashCode());
            String simpleName = activity.getClass().getSimpleName();
            Intrinsics.checkExpressionValueIsNotNull(simpleName, "activity::class.java.simpleName");
            hashMap.put(valueOf, simpleName);
            ProcessLifecycle processLifecycle2 = ProcessLifecycle.INSTANCE;
            z = ProcessLifecycle.lastProcessForegroundState;
            if (!z) {
                ForegroundHolder.INSTANCE.setForeground$timonbase_release(true);
                ProcessLifecycle processLifecycle3 = ProcessLifecycle.INSTANCE;
                linkedHashSet2 = ProcessLifecycle.callbackSet;
                Iterator it = linkedHashSet2.iterator();
                while (it.hasNext()) {
                    ((ProcessLifecycle.Callbacks) it.next()).onProcessForeground();
                }
            }
            ProcessLifecycle processLifecycle4 = ProcessLifecycle.INSTANCE;
            z2 = ProcessLifecycle.lastAppForegroundState;
            if (!z2) {
                ProcessLifecycle processLifecycle5 = ProcessLifecycle.INSTANCE;
                linkedHashSet = ProcessLifecycle.callbackSet;
                Iterator it2 = linkedHashSet.iterator();
                while (it2.hasNext()) {
                    ((ProcessLifecycle.Callbacks) it2.next()).onAppForeground();
                }
            }
            ProcessLifecycle processLifecycle6 = ProcessLifecycle.INSTANCE;
            ProcessLifecycle.lastProcessForegroundState = true;
            ProcessLifecycle processLifecycle7 = ProcessLifecycle.INSTANCE;
            ProcessLifecycle.lastAppForegroundState = true;
        }

        @Override // com.bytedance.timonbase.scene.lifecycle.SimpleActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            HashMap hashMap;
            HashMap hashMap2;
            ForegroundState foregroundState;
            boolean z;
            LinkedHashSet linkedHashSet;
            boolean z2;
            LinkedHashSet linkedHashSet2;
            Intrinsics.checkParameterIsNotNull(activity, "activity");
            ProcessLifecycle processLifecycle = ProcessLifecycle.INSTANCE;
            hashMap = ProcessLifecycle.foregroundActivities;
            hashMap.remove(Integer.valueOf(activity.hashCode()));
            ProcessLifecycle processLifecycle2 = ProcessLifecycle.INSTANCE;
            hashMap2 = ProcessLifecycle.foregroundActivities;
            boolean z3 = !hashMap2.isEmpty();
            if (!z3) {
                ProcessLifecycle processLifecycle3 = ProcessLifecycle.INSTANCE;
                z2 = ProcessLifecycle.lastProcessForegroundState;
                if (z2 != z3) {
                    ForegroundHolder.INSTANCE.setForeground$timonbase_release(false);
                    ProcessLifecycle processLifecycle4 = ProcessLifecycle.INSTANCE;
                    linkedHashSet2 = ProcessLifecycle.callbackSet;
                    Iterator it = linkedHashSet2.iterator();
                    while (it.hasNext()) {
                        ((ProcessLifecycle.Callbacks) it.next()).onProcessBackground();
                    }
                }
            }
            foregroundState = ProcessLifecycle.INSTANCE.getForegroundState();
            boolean foreground = foregroundState.getForeground();
            if (!foreground) {
                ProcessLifecycle processLifecycle5 = ProcessLifecycle.INSTANCE;
                z = ProcessLifecycle.lastAppForegroundState;
                if (z != foreground) {
                    ProcessLifecycle processLifecycle6 = ProcessLifecycle.INSTANCE;
                    linkedHashSet = ProcessLifecycle.callbackSet;
                    Iterator it2 = linkedHashSet.iterator();
                    while (it2.hasNext()) {
                        ((ProcessLifecycle.Callbacks) it2.next()).onAppBackground();
                    }
                }
            }
            ProcessLifecycle processLifecycle7 = ProcessLifecycle.INSTANCE;
            ProcessLifecycle.lastAppForegroundState = foreground;
            ProcessLifecycle processLifecycle8 = ProcessLifecycle.INSTANCE;
            ProcessLifecycle.lastProcessForegroundState = z3;
        }

        @Override // com.bytedance.timonbase.scene.lifecycle.SimpleActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            HashMap hashMap;
            HashMap hashMap2;
            ForegroundState foregroundState;
            boolean z;
            LinkedHashSet linkedHashSet;
            boolean z2;
            LinkedHashSet linkedHashSet2;
            Intrinsics.checkParameterIsNotNull(activity, "activity");
            ProcessLifecycle processLifecycle = ProcessLifecycle.INSTANCE;
            hashMap = ProcessLifecycle.foregroundActivities;
            hashMap.remove(Integer.valueOf(activity.hashCode()));
            ProcessLifecycle processLifecycle2 = ProcessLifecycle.INSTANCE;
            hashMap2 = ProcessLifecycle.foregroundActivities;
            boolean z3 = !hashMap2.isEmpty();
            if (!z3) {
                ProcessLifecycle processLifecycle3 = ProcessLifecycle.INSTANCE;
                z2 = ProcessLifecycle.lastProcessForegroundState;
                if (z2 != z3) {
                    ForegroundHolder.INSTANCE.setForeground$timonbase_release(false);
                    ProcessLifecycle processLifecycle4 = ProcessLifecycle.INSTANCE;
                    linkedHashSet2 = ProcessLifecycle.callbackSet;
                    Iterator it = linkedHashSet2.iterator();
                    while (it.hasNext()) {
                        ((ProcessLifecycle.Callbacks) it.next()).onProcessBackground();
                    }
                }
            }
            foregroundState = ProcessLifecycle.INSTANCE.getForegroundState();
            boolean foreground = foregroundState.getForeground();
            if (!foreground) {
                ProcessLifecycle processLifecycle5 = ProcessLifecycle.INSTANCE;
                z = ProcessLifecycle.lastAppForegroundState;
                if (z != foreground) {
                    ProcessLifecycle processLifecycle6 = ProcessLifecycle.INSTANCE;
                    linkedHashSet = ProcessLifecycle.callbackSet;
                    Iterator it2 = linkedHashSet.iterator();
                    while (it2.hasNext()) {
                        ((ProcessLifecycle.Callbacks) it2.next()).onAppBackground();
                    }
                }
            }
            ProcessLifecycle processLifecycle7 = ProcessLifecycle.INSTANCE;
            ProcessLifecycle.lastAppForegroundState = foreground;
            ProcessLifecycle processLifecycle8 = ProcessLifecycle.INSTANCE;
            ProcessLifecycle.lastProcessForegroundState = z3;
        }
    };

    /* compiled from: ProcessLifecycle.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, d2 = {"Lcom/bytedance/timonbase/scene/lifecycle/ProcessLifecycle$Callbacks;", "", "onAppBackground", "", "onAppForeground", "onProcessBackground", "onProcessForeground", "timonbase_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface Callbacks {
        void onAppBackground();

        void onAppForeground();

        void onProcessBackground();

        void onProcessForeground();
    }

    private ProcessLifecycle() {
    }

    public final String getTopActivity() {
        HashMap<Integer, String> hashMap = foregroundActivities;
        Intrinsics.checkExpressionValueIsNotNull(hashMap.values(), "foregroundActivities.values");
        if (!r1.isEmpty()) {
            return hashMap.values().iterator().next();
        }
        return null;
    }

    public final boolean isAppBackground(long tolerableDuration) {
        ForegroundState foregroundState = getForegroundState();
        return !foregroundState.getForeground() && System.currentTimeMillis() - foregroundState.getTime() >= tolerableDuration;
    }

    public final boolean isProcessBackground() {
        return getTopActivity() == null;
    }

    public final void registerLifecycleCallbacks(Callbacks callbacks) {
        Intrinsics.checkParameterIsNotNull(callbacks, "callbacks");
        LinkedHashSet<Callbacks> linkedHashSet = callbackSet;
        synchronized (linkedHashSet) {
            linkedHashSet.add(callbacks);
        }
    }

    public final void unregisterLifecycleCallbacks(Callbacks callbacks) {
        Intrinsics.checkParameterIsNotNull(callbacks, "callbacks");
        LinkedHashSet<Callbacks> linkedHashSet = callbackSet;
        synchronized (linkedHashSet) {
            linkedHashSet.remove(callbacks);
        }
    }

    public final long getAppInBackgroundTime() {
        if (isAppBackground(SenseConfigManager.INSTANCE.backgroundTolerableDuration())) {
            return System.currentTimeMillis() - getForegroundState().getTime();
        }
        return 0L;
    }

    public final void initialize$timonbase_release(Application application) {
        Intrinsics.checkParameterIsNotNull(application, "application");
        application.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    public final void deInitialize$timonbase_release(Application application) {
        Intrinsics.checkParameterIsNotNull(application, "application");
        application.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ForegroundState getForegroundState() {
        if (SenseConfigManager.INSTANCE.foregroundUseBroadcast()) {
            return AppForegroundStatusSynchronizer.INSTANCE.getCurrentSenseStatus();
        }
        return ForegroundHolder.INSTANCE.getForegroundState();
    }
}
