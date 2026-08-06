package com.bytedance.trae.common.apphost.lifecycle;

import android.app.Activity;
import android.os.Bundle;
import com.bytedance.bdturing.methods.JsCallParser;
import com.bytedance.timonbase.scene.PageDataManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActivityStackManager.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001:\u0002%&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J*\u0010\u0015\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0016\u001a\u00020\f2\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018H&J\b\u0010\u001a\u001a\u00020\u0019H&J\b\u0010\u001b\u001a\u00020\u0019H&J\b\u0010\u001c\u001a\u00020\u0003H&J\u0014\u0010\u001d\u001a\u00020\u00032\n\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u001fH&J\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00020\f0!H&J\u0012\u0010\"\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010\fH&J\u0018\u0010$\u001a\u00020\u00192\u000e\u0010\u001e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u001fH&R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u0004\u0018\u00010\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u0012X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006'"}, d2 = {"Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;", "", "addAppBackGroundListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager$OnAppBackGroundListener;", "removeAppBackGroundListener", "addActivityLifecycleCallback", JsCallParser.VALUE_CALLBACK, "Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager$ActivityLifecycleCallbacks;", "removeActivityLifecycleCallback", "currentActivity", "Landroid/app/Activity;", "getCurrentActivity", "()Landroid/app/Activity;", "resumActivity", "getResumActivity", "activityCount", "", "getActivityCount", "()Ljava/lang/Integer;", "getPreviousActivity", "curActivity", "predicate", "Lkotlin/Function1;", "", "isAppBackground", "isAppPaused", "finishAllActivities", "finishActivitiesExcept", "clazz", "Ljava/lang/Class;", "getActivityList", "", "endActivity", "activity", "containActivity", "OnAppBackGroundListener", "ActivityLifecycleCallbacks", "apphost_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface ActivityStackManager {

    /* compiled from: ActivityStackManager.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager$ActivityLifecycleCallbacks;", "", "onCreate", "", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", PageDataManager.ON_RESUMED, PageDataManager.ON_PAUSED, PageDataManager.ON_STOPPED, "onPreDestroyed", "apphost_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface ActivityLifecycleCallbacks {

        /* compiled from: ActivityStackManager.kt */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class DefaultImpls {
            public static void onCreate(ActivityLifecycleCallbacks activityLifecycleCallbacks, Activity activity, Bundle bundle) {
                Intrinsics.checkNotNullParameter(activity, "activity");
            }

            public static void onPaused(ActivityLifecycleCallbacks activityLifecycleCallbacks, Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
            }

            public static void onPreDestroyed(ActivityLifecycleCallbacks activityLifecycleCallbacks, Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
            }

            public static void onResumed(ActivityLifecycleCallbacks activityLifecycleCallbacks, Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
            }

            public static void onStopped(ActivityLifecycleCallbacks activityLifecycleCallbacks, Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
            }
        }

        void onCreate(Activity activity, Bundle savedInstanceState);

        void onPaused(Activity activity);

        void onPreDestroyed(Activity activity);

        void onResumed(Activity activity);

        void onStopped(Activity activity);
    }

    /* compiled from: ActivityStackManager.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager$OnAppBackGroundListener;", "", "onAppBackground", "", "onAppForeground", "onAllActivityDestroyed", "apphost_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface OnAppBackGroundListener {
        void onAllActivityDestroyed();

        void onAppBackground();

        void onAppForeground();
    }

    void addActivityLifecycleCallback(ActivityLifecycleCallbacks callback);

    void addAppBackGroundListener(OnAppBackGroundListener listener);

    boolean containActivity(Class<? extends Activity> clazz);

    void endActivity(Activity activity);

    void finishActivitiesExcept(Class<?> clazz);

    void finishAllActivities();

    Integer getActivityCount();

    List<Activity> getActivityList();

    Activity getCurrentActivity();

    Activity getPreviousActivity(Activity curActivity, Function1<? super Activity, Boolean> predicate);

    Activity getResumActivity();

    boolean isAppBackground();

    boolean isAppPaused();

    void removeActivityLifecycleCallback(ActivityLifecycleCallbacks callback);

    void removeAppBackGroundListener(OnAppBackGroundListener listener);

    /* compiled from: ActivityStackManager.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Activity getPreviousActivity$default(ActivityStackManager activityStackManager, Activity activity, Function1 function1, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPreviousActivity");
            }
            if ((i & 2) != 0) {
                function1 = null;
            }
            return activityStackManager.getPreviousActivity(activity, function1);
        }
    }
}
