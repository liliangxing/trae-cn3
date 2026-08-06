package com.bytedance.upc.common.activity;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.bytedance.upc.common.thread.ThreadPlus;
import com.huawei.hms.framework.common.BundleUtil;
import com.lynx.tasm.DefaultLogicExecutor;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActivityLifeObserver.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0007J\u001a\u0010\u001a\u001a\u00020\u00122\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010J\u0016\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0006\u0010\u0019\u001a\u00020\u0007J\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bJ\u0006\u0010\u001e\u001a\u00020\u0011J\u001a\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\t2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010#\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\tH\u0016J\u0010\u0010$\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\tH\u0016J\u0010\u0010%\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\tH\u0016J\u0018\u0010&\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\t2\u0006\u0010'\u001a\u00020\"H\u0016J\u0010\u0010(\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\tH\u0016J\u0010\u0010)\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\tH\u0016J\b\u0010*\u001a\u00020\u0012H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R/\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\f\u0012\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b0\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR-\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00100\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0016\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/bytedance/upc/common/activity/ActivityLifeObserver;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "()V", "mActivityCount", "", "mActivityRecord", "", "", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "getMActivityRecord", "()Ljava/util/Map;", "mActivityRecord$delegate", "Lkotlin/Lazy;", "mAppEnterBackgroundObList", "", "Lkotlin/Function1;", "", "", "getMAppEnterBackgroundObList", "()Ljava/util/List;", "mAppEnterBackgroundObList$delegate", "mIsForeground", "mTopActivityRef", "activityExist", DefaultLogicExecutor.GLOBAL_EVENT_NAME, "addAppEnterBackgroundOb", "ob", "getActivity", "getTopActivityRef", "isForeground", "onActivityCreated", "activity", "savedInstanceState", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivitySaveInstanceState", "outState", "onActivityStarted", "onActivityStopped", "onAppEnterBackgroundOb", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class ActivityLifeObserver implements Application.ActivityLifecycleCallbacks {
    private static int mActivityCount;
    private static WeakReference<Activity> mTopActivityRef;
    public static final ActivityLifeObserver INSTANCE = new ActivityLifeObserver();
    private static boolean mIsForeground = true;

    /* renamed from: mAppEnterBackgroundObList$delegate, reason: from kotlin metadata */
    private static final Lazy mAppEnterBackgroundObList = LazyKt.lazy(new Function0<List<Function1<? super Boolean, ? extends Unit>>>() { // from class: com.bytedance.upc.common.activity.ActivityLifeObserver$mAppEnterBackgroundObList$2
        public final List<Function1<Boolean, Unit>> invoke() {
            return new ArrayList();
        }
    });

    /* renamed from: mActivityRecord$delegate, reason: from kotlin metadata */
    private static final Lazy mActivityRecord = LazyKt.lazy(new Function0<Map<String, WeakReference<Activity>>>() { // from class: com.bytedance.upc.common.activity.ActivityLifeObserver$mActivityRecord$2
        public final Map<String, WeakReference<Activity>> invoke() {
            return new LinkedHashMap();
        }
    });

    private final Map<String, WeakReference<Activity>> getMActivityRecord() {
        return (Map) mActivityRecord.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<Function1<Boolean, Unit>> getMAppEnterBackgroundObList() {
        return (List) mAppEnterBackgroundObList.getValue();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        Intrinsics.checkParameterIsNotNull(outState, "outState");
    }

    private ActivityLifeObserver() {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        try {
            getMActivityRecord().put(activity.getPackageName() + BundleUtil.UNDERLINE_TAG + activity.getClass().getName(), new WeakReference<>(activity));
        } catch (Throwable unused) {
        }
        mActivityCount++;
        if (mIsForeground) {
            return;
        }
        mIsForeground = true;
        onAppEnterBackgroundOb();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        mTopActivityRef = new WeakReference<>(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        int i = mActivityCount - 1;
        mActivityCount = i;
        if (i <= 0) {
            mIsForeground = false;
            onAppEnterBackgroundOb();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        try {
            getMActivityRecord().remove(activity.getPackageName() + BundleUtil.UNDERLINE_TAG + activity.getClass().getName());
        } catch (Throwable unused) {
        }
    }

    private final void onAppEnterBackgroundOb() {
        ThreadPlus.INSTANCE.submit(new Function0<Unit>() { // from class: com.bytedance.upc.common.activity.ActivityLifeObserver$onAppEnterBackgroundOb$1
            public /* bridge */ /* synthetic */ Object invoke() {
                m2601invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2601invoke() {
                List<Function1> mAppEnterBackgroundObList2;
                boolean z;
                try {
                    Result.Companion companion = Result.Companion;
                    mAppEnterBackgroundObList2 = ActivityLifeObserver.INSTANCE.getMAppEnterBackgroundObList();
                    for (Function1 function1 : mAppEnterBackgroundObList2) {
                        ActivityLifeObserver activityLifeObserver = ActivityLifeObserver.INSTANCE;
                        z = ActivityLifeObserver.mIsForeground;
                        function1.invoke(Boolean.valueOf(!z));
                    }
                    Result.constructor-impl(Unit.INSTANCE);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    Result.constructor-impl(ResultKt.createFailure(th));
                }
            }
        });
    }

    public final WeakReference<Activity> getTopActivityRef() {
        return mTopActivityRef;
    }

    public final boolean isForeground() {
        return mIsForeground;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void addAppEnterBackgroundOb(Function1<? super Boolean, Unit> ob) {
        Intrinsics.checkParameterIsNotNull(ob, "ob");
        getMAppEnterBackgroundObList().add(ob);
    }

    public final boolean activityExist(String name) {
        Intrinsics.checkParameterIsNotNull(name, DefaultLogicExecutor.GLOBAL_EVENT_NAME);
        return getMActivityRecord().containsKey(name);
    }

    public final WeakReference<Activity> getActivity(String name) {
        Intrinsics.checkParameterIsNotNull(name, DefaultLogicExecutor.GLOBAL_EVENT_NAME);
        return getMActivityRecord().get(name);
    }
}
