# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/ActivityManager;
.super Ljava/lang/Object;
.source "ActivityManager.kt"

.implements Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;
.implements Landroid/app/Application$ActivityLifecycleCallbacks;

.field public static final $stable:I
.field public static final Companion:Lcom/bytedance/trae/ActivityManager$Companion;
.field public static final TAG:Ljava/lang/String;
.field private final activityCallbacks:Ljava/util/concurrent/CopyOnWriteArrayList;
.field private final activityStack:Ljava/util/Stack;
.field private final appBackgroundListeners:Ljava/util/concurrent/CopyOnWriteArrayList;
.field private isBackground:Z
.field private isPaused:Z
.field private lastForegroundTime:J
.field private resumeActivity:Landroid/app/Activity;
.field private final startedActivityStack:Ljava/util/Stack;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/ActivityManager$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/ActivityManager$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/ActivityManager;->Companion Lcom/bytedance/trae/ActivityManager$Companion;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/ActivityManager;->$stable I
    return-void 
.end method

.method public constructor <init>(android.app.Application)void
    .registers 3
    # ins_size=2
    const-string v0, "application"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    move-object v0, v1
    check-cast v0, Landroid/app/Application$ActivityLifecycleCallbacks;
    invoke-virtual v2, v0, Landroid/app/Application;->registerActivityLifecycleCallbacks(Landroid/app/Application$ActivityLifecycleCallbacks;)V
    new-instance v2, Ljava/util/Stack;
    invoke-direct v2, Ljava/util/Stack;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/ActivityManager;->activityStack Ljava/util/Stack;
    new-instance v2, Ljava/util/Stack;
    invoke-direct v2, Ljava/util/Stack;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/ActivityManager;->startedActivityStack Ljava/util/Stack;
    const/4 v2, 1
    iput-boolean v2, v1, Lcom/bytedance/trae/ActivityManager;->isBackground Z
    iput-boolean v2, v1, Lcom/bytedance/trae/ActivityManager;->isPaused Z
    new-instance v2, Ljava/util/concurrent/CopyOnWriteArrayList;
    invoke-direct v2, Ljava/util/concurrent/CopyOnWriteArrayList;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/ActivityManager;->appBackgroundListeners Ljava/util/concurrent/CopyOnWriteArrayList;
    new-instance v2, Ljava/util/concurrent/CopyOnWriteArrayList;
    invoke-direct v2, Ljava/util/concurrent/CopyOnWriteArrayList;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/ActivityManager;->activityCallbacks Ljava/util/concurrent/CopyOnWriteArrayList;
    return-void 
.end method

.method private final popActivity(android.app.Activity)void
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/ActivityManager;->activityStack Ljava/util/Stack;
    invoke-virtual v0, v2, Ljava/util/Stack;->remove(Ljava/lang/Object;)Z
    return-void 
.end method

.method private final pushActivity(android.app.Activity)void
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/ActivityManager;->activityStack Ljava/util/Stack;
    invoke-virtual v0, v2, Ljava/util/Stack;->add(Ljava/lang/Object;)Z
    return-void 
.end method

.method public synchronized addActivityLifecycleCallback(com.bytedance.trae.common.apphost.lifecycle.ActivityStackManager$ActivityLifecycleCallbacks)void
    .registers 3
    # ins_size=2
    monitor-enter v1
    const-string v0, "callback"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/ActivityManager;->activityCallbacks Ljava/util/concurrent/CopyOnWriteArrayList;
    invoke-virtual v0, v2, Ljava/util/concurrent/CopyOnWriteArrayList;->contains(Ljava/lang/Object;)Z
    move-result v0
    xor-int/lit8 v0, v0, 1
    if-eqz v0, +003h
    goto +2h
    const/4 v2, 0
    if-eqz v2, +007h
    iget-object v0, v1, Lcom/bytedance/trae/ActivityManager;->activityCallbacks Ljava/util/concurrent/CopyOnWriteArrayList;
    invoke-virtual v0, v2, Ljava/util/concurrent/CopyOnWriteArrayList;->add(Ljava/lang/Object;)Z
    monitor-exit v1
    return-void 
    move-exception v2
    monitor-exit v1
    throw v2
    :try_start_0x1
.end method

.method public synchronized addAppBackGroundListener(com.bytedance.trae.common.apphost.lifecycle.ActivityStackManager$OnAppBackGroundListener)void
    .registers 3
    # ins_size=2
    monitor-enter v1
    const-string v0, "listener"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/ActivityManager;->appBackgroundListeners Ljava/util/concurrent/CopyOnWriteArrayList;
    invoke-virtual v0, v2, Ljava/util/concurrent/CopyOnWriteArrayList;->contains(Ljava/lang/Object;)Z
    move-result v0
    xor-int/lit8 v0, v0, 1
    if-eqz v0, +003h
    goto +2h
    const/4 v2, 0
    if-eqz v2, +007h
    iget-object v0, v1, Lcom/bytedance/trae/ActivityManager;->appBackgroundListeners Ljava/util/concurrent/CopyOnWriteArrayList;
    invoke-virtual v0, v2, Ljava/util/concurrent/CopyOnWriteArrayList;->add(Ljava/lang/Object;)Z
    monitor-exit v1
    return-void 
    move-exception v2
    monitor-exit v1
    throw v2
    :try_start_0x1
.end method

.method public final backPressActivity(java.lang.Class)void
    .registers 5
    # ins_size=2
    const-string v0, "clazz"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v3, Lcom/bytedance/trae/ActivityManager;->activityStack Ljava/util/Stack;
    invoke-virtual v0, Ljava/util/Stack;->iterator()Ljava/util/Iterator;
    move-result-object v0
    const-string v1, "iterator(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +029h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Landroid/app/Activity;
    invoke-virtual v1, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v2
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, -014h
    instance-of v4, v1, Landroidx/activity/ComponentActivity;
    if-eqz v4, +00dh
    move-object v4, v1
    check-cast v4, Landroidx/activity/ComponentActivity;
    invoke-virtual v4, Landroidx/activity/ComponentActivity;->getOnBackPressedDispatcher()Landroidx/activity/OnBackPressedDispatcher;
    move-result-object v4
    invoke-virtual v4, Landroidx/activity/OnBackPressedDispatcher;->onBackPressed()V
    goto +4h
    invoke-virtual v1, Landroid/app/Activity;->finish()V
    iget-object v4, v3, Lcom/bytedance/trae/ActivityManager;->activityStack Ljava/util/Stack;
    invoke-virtual v4, v1, Ljava/util/Stack;->remove(Ljava/lang/Object;)Z
    return-void 
.end method

.method public containActivity(java.lang.Class)boolean
    .registers 4
    # ins_size=2
    const-string v0, "clazz"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v2, Lcom/bytedance/trae/ActivityManager;->activityStack Ljava/util/Stack;
    invoke-virtual v0, Ljava/util/Stack;->iterator()Ljava/util/Iterator;
    move-result-object v0
    const-string v1, "iterator(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +014h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Landroid/app/Activity;
    invoke-virtual v1, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v1
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, -014h
    const/4 v3, 1
    return v3
    const/4 v3, 0
    return v3
.end method

.method public endActivity(android.app.Activity)void
    .registers 3
    # ins_size=2
    if-eqz v2, +00ah
    invoke-virtual v2, Landroid/app/Activity;->finish()V
    iget-object v0, v1, Lcom/bytedance/trae/ActivityManager;->activityStack Ljava/util/Stack;
    invoke-virtual v0, v2, Ljava/util/Stack;->remove(Ljava/lang/Object;)Z
    return-void 
.end method

.method public finishActivitiesExcept(java.lang.Class)void
    .registers 5
    # ins_size=2
    const-string v0, "clazz"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v3, Lcom/bytedance/trae/ActivityManager;->activityStack Ljava/util/Stack;
    invoke-virtual v0, Ljava/util/Stack;->iterator()Ljava/util/Iterator;
    move-result-object v0
    const-string v1, "iterator(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +015h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Landroid/app/Activity;
    invoke-virtual v4, v1, Ljava/lang/Class;->isInstance(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, -010h
    invoke-virtual v1, Landroid/app/Activity;->finish()V
    invoke-interface v0, Ljava/util/Iterator;->remove()V
    goto -18h
    return-void 
.end method

.method public finishAllActivities()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/ActivityManager;->activityStack Ljava/util/Stack;
    invoke-virtual v0, Ljava/util/Stack;->iterator()Ljava/util/Iterator;
    move-result-object v0
    const-string v1, "iterator(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +00ch
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Landroid/app/Activity;
    invoke-virtual v1, Landroid/app/Activity;->finish()V
    goto -fh
    iget-object v0, v2, Lcom/bytedance/trae/ActivityManager;->activityStack Ljava/util/Stack;
    invoke-virtual v0, Ljava/util/Stack;->clear()V
    return-void 
.end method

.method public final finishFirstTopActivity(java.lang.Class)void
    .registers 5
    # ins_size=2
    const-string v0, "clazz"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v3, Lcom/bytedance/trae/ActivityManager;->activityStack Ljava/util/Stack;
    check-cast v0, Ljava/util/List;
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v1
    invoke-interface v0, v1, Ljava/util/List;->listIterator(I)Ljava/util/ListIterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/ListIterator;->hasPrevious()Z
    move-result v1
    if-eqz v1, +014h
    invoke-interface v0, Ljava/util/ListIterator;->previous()Ljava/lang/Object;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Landroid/app/Activity;
    invoke-virtual v2, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v2
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, -015h
    goto +2h
    const/4 v1, 0
    check-cast v1, Landroid/app/Activity;
    if-eqz v1, +00ah
    invoke-virtual v1, Landroid/app/Activity;->finish()V
    iget-object v4, v3, Lcom/bytedance/trae/ActivityManager;->activityStack Ljava/util/Stack;
    invoke-virtual v4, v1, Ljava/util/Stack;->remove(Ljava/lang/Object;)Z
    return-void 
.end method

.method public getActivityCount()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/ActivityManager;->activityStack Ljava/util/Stack;
    invoke-virtual v0, Ljava/util/Stack;->size()I
    move-result v0
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    return-object v0
.end method

.method public getActivityList()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/ActivityManager;->activityStack Ljava/util/Stack;
    check-cast v0, Ljava/lang/Iterable;
    invoke-static v0, Lkotlin/collections/CollectionsKt;->toList(Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v0
    return-object v0
.end method

.method public getCurrentActivity()android.app.Activity
    .registers 3
    # ins_size=1
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v2
    check-cast v0, Lcom/bytedance/trae/ActivityManager;
    iget-object v0, v2, Lcom/bytedance/trae/ActivityManager;->startedActivityStack Ljava/util/Stack;
    check-cast v0, Ljava/util/List;
    invoke-static v0, Lkotlin/collections/CollectionsKt;->lastOrNull(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Landroid/app/Activity;
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    goto +ch
    move-exception v0
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +003h
    const/4 v0, 0
    check-cast v0, Landroid/app/Activity;
    return-object v0
    :try_start_0x0
.end method

.method public getPreviousActivity(android.app.Activity  kotlin.jvm.functions.Function1)android.app.Activity
    .registers 8
    # ins_size=3
    const-string v0, "curActivity"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v5, Lcom/bytedance/trae/ActivityManager;->activityStack Ljava/util/Stack;
    invoke-virtual v0, Ljava/util/Stack;->size()I
    move-result v0
    const/4 v1, 1
    sub-int/2addr v0, v1
    const/4 v2, 0
    if-ltz v0, +034h
    if-eqz v2, +026h
    iget-object v3, v5, Lcom/bytedance/trae/ActivityManager;->activityStack Ljava/util/Stack;
    invoke-virtual v3, v0, Ljava/util/Stack;->get(I)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Landroid/app/Activity;
    if-eqz v7, +010h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-interface v7, v3, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Ljava/lang/Boolean;
    invoke-virtual v4, Ljava/lang/Boolean;->booleanValue()Z
    move-result v4
    goto +2h
    move v4, v1
    if-eqz v4, +014h
    if-eqz v3, +012h
    invoke-virtual v3, Landroid/app/Activity;->isFinishing()Z
    move-result v4
    if-nez v4, +00ch
    return-object v3
    iget-object v3, v5, Lcom/bytedance/trae/ActivityManager;->activityStack Ljava/util/Stack;
    invoke-virtual v3, v0, Ljava/util/Stack;->get(I)Ljava/lang/Object;
    move-result-object v3
    if-ne v3, v6, +003h
    move v2, v1
    add-int/lit8 v0, v0, -1
    goto -33h
    const/4 v6, 0
    return-object v6
.end method

.method public getResumActivity()android.app.Activity
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/ActivityManager;->resumeActivity Landroid/app/Activity;
    return-object v0
.end method

.method public isAppBackground()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/ActivityManager;->isBackground Z
    return v0
.end method

.method public isAppPaused()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/ActivityManager;->isPaused Z
    return v0
.end method

.method public final lastForegroundTime()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/ActivityManager;->lastForegroundTime J
    return-wide v0
.end method

.method public onActivityCreated(android.app.Activity  android.os.Bundle)void
    .registers 5
    # ins_size=3
    const-string v0, "activity"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v2, v3, Lcom/bytedance/trae/ActivityManager;->pushActivity(Landroid/app/Activity;)V
    iget-object v0, v2, Lcom/bytedance/trae/ActivityManager;->activityCallbacks Ljava/util/concurrent/CopyOnWriteArrayList;
    invoke-virtual v0, Ljava/util/concurrent/CopyOnWriteArrayList;->iterator()Ljava/util/Iterator;
    move-result-object v0
    const-string v1, "iterator(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +00ch
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager$ActivityLifecycleCallbacks;
    invoke-interface v1, v3, v4, Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager$ActivityLifecycleCallbacks;->onCreate(Landroid/app/Activity; Landroid/os/Bundle;)V
    goto -fh
    return-void 
.end method

.method public onActivityDestroyed(android.app.Activity)void
    .registers 3
    # ins_size=2
    const-string v0, "activity"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, Lcom/bytedance/trae/ActivityManager;->popActivity(Landroid/app/Activity;)V
    iget-object v2, v1, Lcom/bytedance/trae/ActivityManager;->activityStack Ljava/util/Stack;
    invoke-virtual v2, Ljava/util/Stack;->isEmpty()Z
    move-result v2
    if-eqz v2, +01dh
    iget-object v2, v1, Lcom/bytedance/trae/ActivityManager;->appBackgroundListeners Ljava/util/concurrent/CopyOnWriteArrayList;
    invoke-virtual v2, Ljava/util/concurrent/CopyOnWriteArrayList;->iterator()Ljava/util/Iterator;
    move-result-object v2
    const-string v0, "iterator(...)"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +00ch
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager$OnAppBackGroundListener;
    invoke-interface v0, Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager$OnAppBackGroundListener;->onAllActivityDestroyed()V
    goto -fh
    return-void 
.end method

.method public onActivityPaused(android.app.Activity)void
    .registers 4
    # ins_size=2
    const-string v0, "activity"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 1
    iput-boolean v0, v2, Lcom/bytedance/trae/ActivityManager;->isPaused Z
    iget-object v0, v2, Lcom/bytedance/trae/ActivityManager;->activityCallbacks Ljava/util/concurrent/CopyOnWriteArrayList;
    invoke-virtual v0, Ljava/util/concurrent/CopyOnWriteArrayList;->iterator()Ljava/util/Iterator;
    move-result-object v0
    const-string v1, "iterator(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +00ch
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager$ActivityLifecycleCallbacks;
    invoke-interface v1, v3, Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager$ActivityLifecycleCallbacks;->onPaused(Landroid/app/Activity;)V
    goto -fh
    const/4 v3, 0
    iput-object v3, v2, Lcom/bytedance/trae/ActivityManager;->resumeActivity Landroid/app/Activity;
    return-void 
.end method

.method public onActivityPreDestroyed(android.app.Activity)void
    .registers 4
    # ins_size=2
    const-string v0, "activity"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v2, Lcom/bytedance/trae/ActivityManager;->activityCallbacks Ljava/util/concurrent/CopyOnWriteArrayList;
    invoke-virtual v0, Ljava/util/concurrent/CopyOnWriteArrayList;->iterator()Ljava/util/Iterator;
    move-result-object v0
    const-string v1, "iterator(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +00ch
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager$ActivityLifecycleCallbacks;
    invoke-interface v1, v3, Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager$ActivityLifecycleCallbacks;->onPreDestroyed(Landroid/app/Activity;)V
    goto -fh
    return-void 
.end method

.method public synchronized onActivityResumed(android.app.Activity)void
    .registers 5
    # ins_size=2
    monitor-enter v3
    const-string v0, "activity"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 0
    iput-boolean v0, v3, Lcom/bytedance/trae/ActivityManager;->isPaused Z
    iget-boolean v1, v3, Lcom/bytedance/trae/ActivityManager;->isBackground Z
    if-eqz v1, +025h
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v1
    iput-wide v1, v3, Lcom/bytedance/trae/ActivityManager;->lastForegroundTime J
    iput-boolean v0, v3, Lcom/bytedance/trae/ActivityManager;->isBackground Z
    iget-object v0, v3, Lcom/bytedance/trae/ActivityManager;->appBackgroundListeners Ljava/util/concurrent/CopyOnWriteArrayList;
    invoke-virtual v0, Ljava/util/concurrent/CopyOnWriteArrayList;->iterator()Ljava/util/Iterator;
    move-result-object v0
    const-string v1, "iterator(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +00ch
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager$OnAppBackGroundListener;
    invoke-interface v1, Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager$OnAppBackGroundListener;->onAppForeground()V
    goto -fh
    iget-object v0, v3, Lcom/bytedance/trae/ActivityManager;->activityCallbacks Ljava/util/concurrent/CopyOnWriteArrayList;
    invoke-virtual v0, Ljava/util/concurrent/CopyOnWriteArrayList;->iterator()Ljava/util/Iterator;
    move-result-object v0
    const-string v1, "iterator(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +00ch
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager$ActivityLifecycleCallbacks;
    invoke-interface v1, v4, Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager$ActivityLifecycleCallbacks;->onResumed(Landroid/app/Activity;)V
    goto -fh
    iput-object v4, v3, Lcom/bytedance/trae/ActivityManager;->resumeActivity Landroid/app/Activity;
    monitor-exit v3
    return-void 
    move-exception v4
    monitor-exit v3
    throw v4
    :try_start_0x1
.end method

.method public onActivitySaveInstanceState(android.app.Activity  android.os.Bundle)void
    .registers 4
    # ins_size=3
    const-string v0, "activity"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v2, "outState"
    invoke-static v3, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method

.method public onActivityStarted(android.app.Activity)void
    .registers 3
    # ins_size=2
    const-string v0, "activity"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/ActivityManager;->startedActivityStack Ljava/util/Stack;
    invoke-virtual v0, v2, Ljava/util/Stack;->add(Ljava/lang/Object;)Z
    return-void 
.end method

.method public synchronized onActivityStopped(android.app.Activity)void
    .registers 4
    # ins_size=2
    monitor-enter v2
    const-string v0, "activity"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v2, Lcom/bytedance/trae/ActivityManager;->startedActivityStack Ljava/util/Stack;
    invoke-virtual v0, v3, Ljava/util/Stack;->remove(Ljava/lang/Object;)Z
    iget-boolean v0, v2, Lcom/bytedance/trae/ActivityManager;->isBackground Z
    if-nez v0, +028h
    iget-object v0, v2, Lcom/bytedance/trae/ActivityManager;->startedActivityStack Ljava/util/Stack;
    invoke-virtual v0, Ljava/util/Stack;->isEmpty()Z
    move-result v0
    if-eqz v0, +020h
    const/4 v0, 1
    iput-boolean v0, v2, Lcom/bytedance/trae/ActivityManager;->isBackground Z
    iget-object v0, v2, Lcom/bytedance/trae/ActivityManager;->appBackgroundListeners Ljava/util/concurrent/CopyOnWriteArrayList;
    invoke-virtual v0, Ljava/util/concurrent/CopyOnWriteArrayList;->iterator()Ljava/util/Iterator;
    move-result-object v0
    const-string v1, "iterator(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +00ch
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager$OnAppBackGroundListener;
    invoke-interface v1, Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager$OnAppBackGroundListener;->onAppBackground()V
    goto -fh
    iget-object v0, v2, Lcom/bytedance/trae/ActivityManager;->activityCallbacks Ljava/util/concurrent/CopyOnWriteArrayList;
    invoke-virtual v0, Ljava/util/concurrent/CopyOnWriteArrayList;->iterator()Ljava/util/Iterator;
    move-result-object v0
    const-string v1, "iterator(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +00ch
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager$ActivityLifecycleCallbacks;
    invoke-interface v1, v3, Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager$ActivityLifecycleCallbacks;->onStopped(Landroid/app/Activity;)V
    goto -fh
    monitor-exit v2
    return-void 
    move-exception v3
    monitor-exit v2
    throw v3
    :try_start_0x1
.end method

.method public synchronized removeActivityLifecycleCallback(com.bytedance.trae.common.apphost.lifecycle.ActivityStackManager$ActivityLifecycleCallbacks)void
    .registers 3
    # ins_size=2
    monitor-enter v1
    const-string v0, "callback"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/ActivityManager;->activityCallbacks Ljava/util/concurrent/CopyOnWriteArrayList;
    invoke-virtual v0, v2, Ljava/util/concurrent/CopyOnWriteArrayList;->contains(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    goto +2h
    const/4 v2, 0
    if-eqz v2, +007h
    iget-object v0, v1, Lcom/bytedance/trae/ActivityManager;->activityCallbacks Ljava/util/concurrent/CopyOnWriteArrayList;
    invoke-virtual v0, v2, Ljava/util/concurrent/CopyOnWriteArrayList;->remove(Ljava/lang/Object;)Z
    monitor-exit v1
    return-void 
    move-exception v2
    monitor-exit v1
    throw v2
    :try_start_0x1
.end method

.method public synchronized removeAppBackGroundListener(com.bytedance.trae.common.apphost.lifecycle.ActivityStackManager$OnAppBackGroundListener)void
    .registers 3
    # ins_size=2
    monitor-enter v1
    const-string v0, "listener"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/ActivityManager;->appBackgroundListeners Ljava/util/concurrent/CopyOnWriteArrayList;
    invoke-virtual v0, v2, Ljava/util/concurrent/CopyOnWriteArrayList;->contains(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    goto +2h
    const/4 v2, 0
    if-eqz v2, +007h
    iget-object v0, v1, Lcom/bytedance/trae/ActivityManager;->appBackgroundListeners Ljava/util/concurrent/CopyOnWriteArrayList;
    invoke-virtual v0, v2, Ljava/util/concurrent/CopyOnWriteArrayList;->remove(Ljava/lang/Object;)Z
    monitor-exit v1
    return-void 
    move-exception v2
    monitor-exit v1
    throw v2
    :try_start_0x1
.end method
