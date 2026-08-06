package com.bytedance.timonbase.scene;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.SystemClock;
import com.bytedance.timon.foundation.interfaces.TimonBackgroundReferee;
import com.bytedance.timonbase.TMLogger;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AppBackgroundReferee.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0001!B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001c\u0010\u0010\u001a\u00020\u000f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0007H\u0016J\b\u0010\u0013\u001a\u00020\tH\u0016J\u001a\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u0018H\u0016J\u0010\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u001c\u0010 \u001a\u00020\u000f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000f0\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/bytedance/timonbase/scene/AppBackgroundReferee;", "Lcom/bytedance/timon/foundation/interfaces/TimonBackgroundReferee;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_appEnterBackgroundTime", "", "_isAppBackground", "", "activityStartCount", "", "statusChangedListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lkotlin/Function1;", "", "addStatusChangeListener", "listener", "enterBackgroundTimeStamp", "isAppBackground", "onActivityCreated", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivitySaveInstanceState", "outState", "onActivityStarted", "onActivityStopped", "removeStatusChangeListener", "Companion", "timonbase_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class AppBackgroundReferee implements TimonBackgroundReferee, Application.ActivityLifecycleCallbacks {
    private static final String TAG = "AppBackgroundReferee";
    private long _appEnterBackgroundTime;
    private boolean _isAppBackground;
    private int activityStartCount;
    private final CopyOnWriteArrayList<Function1<Boolean, Unit>> statusChangedListeners;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        Intrinsics.checkParameterIsNotNull(outState, "outState");
    }

    public AppBackgroundReferee(Application application) {
        Intrinsics.checkParameterIsNotNull(application, "application");
        this._isAppBackground = true;
        this.statusChangedListeners = new CopyOnWriteArrayList<>();
        this._appEnterBackgroundTime = 0L;
        application.registerActivityLifecycleCallbacks(this);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        if (this.activityStartCount == 0 && this._isAppBackground) {
            this._isAppBackground = false;
            this._appEnterBackgroundTime = 0L;
            Iterator<T> it = this.statusChangedListeners.iterator();
            while (it.hasNext()) {
                ((Function1) it.next()).invoke(false);
            }
            TMLogger.INSTANCE.m219d(TAG, "切到前台 isAppBackground:" + this._isAppBackground + ",appEnterBackgroundTime:" + this._appEnterBackgroundTime);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        int i = this.activityStartCount + 1;
        this.activityStartCount = i;
        if (i == 1 && this._isAppBackground) {
            this._isAppBackground = false;
            this._appEnterBackgroundTime = 0L;
            Iterator<T> it = this.statusChangedListeners.iterator();
            while (it.hasNext()) {
                ((Function1) it.next()).invoke(false);
            }
            TMLogger.INSTANCE.m219d(TAG, "切到前台 isAppBackground:" + this._isAppBackground + ",appEnterBackgroundTime:" + this._appEnterBackgroundTime);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        int i = this.activityStartCount - 1;
        this.activityStartCount = i;
        if (i == 0) {
            this._isAppBackground = true;
            this._appEnterBackgroundTime = SystemClock.elapsedRealtime();
            Iterator<T> it = this.statusChangedListeners.iterator();
            while (it.hasNext()) {
                ((Function1) it.next()).invoke(true);
            }
            TMLogger.INSTANCE.m219d(TAG, "切到后台 isAppBackground:" + this._isAppBackground + ",appEnterBackgroundTime:" + this._appEnterBackgroundTime);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        if (this.activityStartCount != 0 || this._isAppBackground) {
            return;
        }
        this._isAppBackground = true;
        this._appEnterBackgroundTime = SystemClock.elapsedRealtime();
        Iterator<T> it = this.statusChangedListeners.iterator();
        while (it.hasNext()) {
            ((Function1) it.next()).invoke(true);
        }
        TMLogger.INSTANCE.m219d(TAG, "切到后台 isAppBackground:" + this._isAppBackground + ",appEnterBackgroundTime:" + this._appEnterBackgroundTime);
    }

    @Override // com.bytedance.timon.foundation.interfaces.TimonBackgroundReferee
    /* renamed from: isAppBackground, reason: from getter */
    public boolean get_isAppBackground() {
        return this._isAppBackground;
    }

    @Override // com.bytedance.timon.foundation.interfaces.TimonBackgroundReferee
    /* renamed from: enterBackgroundTimeStamp, reason: from getter */
    public long get_appEnterBackgroundTime() {
        return this._appEnterBackgroundTime;
    }

    @Override // com.bytedance.timon.foundation.interfaces.TimonBackgroundReferee
    public void addStatusChangeListener(Function1<? super Boolean, Unit> listener) {
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        this.statusChangedListeners.add(listener);
    }

    @Override // com.bytedance.timon.foundation.interfaces.TimonBackgroundReferee
    public void removeStatusChangeListener(Function1<? super Boolean, Unit> listener) {
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        this.statusChangedListeners.remove(listener);
    }
}
