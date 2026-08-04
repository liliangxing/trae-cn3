# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public interface abstract Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;
.super Ljava/lang/Object;
.source "ActivityStackManager.kt"


.method public abstract addActivityLifecycleCallback(com.bytedance.trae.common.apphost.lifecycle.ActivityStackManager$ActivityLifecycleCallbacks)void
    # abstract or native
.end method

.method public abstract addAppBackGroundListener(com.bytedance.trae.common.apphost.lifecycle.ActivityStackManager$OnAppBackGroundListener)void
    # abstract or native
.end method

.method public abstract containActivity(java.lang.Class)boolean
    # abstract or native
.end method

.method public abstract endActivity(android.app.Activity)void
    # abstract or native
.end method

.method public abstract finishActivitiesExcept(java.lang.Class)void
    # abstract or native
.end method

.method public abstract finishAllActivities()void
    # abstract or native
.end method

.method public abstract getActivityCount()java.lang.Integer
    # abstract or native
.end method

.method public abstract getActivityList()java.util.List
    # abstract or native
.end method

.method public abstract getCurrentActivity()android.app.Activity
    # abstract or native
.end method

.method public abstract getPreviousActivity(android.app.Activity  kotlin.jvm.functions.Function1)android.app.Activity
    # abstract or native
.end method

.method public abstract getResumActivity()android.app.Activity
    # abstract or native
.end method

.method public abstract isAppBackground()boolean
    # abstract or native
.end method

.method public abstract isAppPaused()boolean
    # abstract or native
.end method

.method public abstract removeActivityLifecycleCallback(com.bytedance.trae.common.apphost.lifecycle.ActivityStackManager$ActivityLifecycleCallbacks)void
    # abstract or native
.end method

.method public abstract removeAppBackGroundListener(com.bytedance.trae.common.apphost.lifecycle.ActivityStackManager$OnAppBackGroundListener)void
    # abstract or native
.end method
