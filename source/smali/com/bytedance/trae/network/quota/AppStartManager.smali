# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/network/quota/AppStartManager;
.super Ljava/lang/Object;
.source "AppStartManager.kt"

.implements Landroid/app/Application$ActivityLifecycleCallbacks;
.implements Lcom/ss/android/ugc/quota/launch/IBDNetworkLaunchMonitor;

.field public static final INSTANCE:Lcom/bytedance/trae/network/quota/AppStartManager;
.field private static final TAG:Ljava/lang/String;
.field private static bridge finishAll:Z
.field private static bridge hasEverForeground:Z
.field private static bridge initialized:Z
.field private static bridge isActivityCreated:Z
.field private static bridge lastStartState:Lcom/bytedance/trae/network/quota/AppStartState;
.field private static final listeners:Ljava/util/concurrent/CopyOnWriteArraySet;
.field private static bridge startedActivityCount:I


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/network/quota/AppStartManager;
    invoke-direct v0, Lcom/bytedance/trae/network/quota/AppStartManager;-><init>()V
    sput-object v0, Lcom/bytedance/trae/network/quota/AppStartManager;->INSTANCE Lcom/bytedance/trae/network/quota/AppStartManager;
    sget-object v0, Lcom/bytedance/trae/network/quota/AppStartState;->NormalStart Lcom/bytedance/trae/network/quota/AppStartState;
    sput-object v0, Lcom/bytedance/trae/network/quota/AppStartManager;->lastStartState Lcom/bytedance/trae/network/quota/AppStartState;
    new-instance v0, Ljava/util/concurrent/CopyOnWriteArraySet;
    invoke-direct v0, Ljava/util/concurrent/CopyOnWriteArraySet;-><init>()V
    sput-object v0, Lcom/bytedance/trae/network/quota/AppStartManager;->listeners Ljava/util/concurrent/CopyOnWriteArraySet;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final notifyListeners(com.bytedance.trae.network.quota.AppStartState)void
    .registers 5
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/network/quota/AppStartManager;->listeners Ljava/util/concurrent/CopyOnWriteArraySet;
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +023h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lkotlin/jvm/functions/Function1;
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-interface v1, v4, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v1, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    goto +ch
    move-exception v1
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v1, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v1
    invoke-static v1, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    invoke-static v1, Lkotlin/Result;->exceptionOrNull-impl(Ljava/lang/Object;)Ljava/lang/Throwable;
    goto -26h
    return-void 
    :try_start_0x14
.end method

.method private final updateStartState(com.bytedance.trae.network.quota.AppStartState)void
    .registers 2
    # ins_size=2
    sput-object v1, Lcom/bytedance/trae/network/quota/AppStartManager;->lastStartState Lcom/bytedance/trae/network/quota/AppStartState;
    invoke-direct v0, v1, Lcom/bytedance/trae/network/quota/AppStartManager;->notifyListeners(Lcom/bytedance/trae/network/quota/AppStartState;)V
    return-void 
.end method

.method public final addListener(kotlin.jvm.functions.Function1)void
    .registers 3
    # ins_size=2
    const-string v0, "listener"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/network/quota/AppStartManager;->listeners Ljava/util/concurrent/CopyOnWriteArraySet;
    invoke-virtual v0, v2, Ljava/util/concurrent/CopyOnWriteArraySet;->add(Ljava/lang/Object;)Z
    return-void 
.end method

.method public currentLaunchType()int
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/quota/AppStartManager;->lastStartState Lcom/bytedance/trae/network/quota/AppStartState;
    invoke-virtual v0, Lcom/bytedance/trae/network/quota/AppStartState;->getValue()I
    move-result v0
    return v0
.end method

.method public final getLastStartState()com.bytedance.trae.network.quota.AppStartState
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/quota/AppStartManager;->lastStartState Lcom/bytedance/trae/network/quota/AppStartState;
    return-object v0
.end method

.method public final init(android.app.Application)void
    .registers 4
    # ins_size=2
    const-string v0, "app"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-boolean v0, Lcom/bytedance/trae/network/quota/AppStartManager;->initialized Z
    if-eqz v0, +003h
    return-void 
    monitor-enter v2
    sget-boolean v0, Lcom/bytedance/trae/network/quota/AppStartManager;->initialized Z
    if-eqz v0, +004h
    monitor-exit v2
    return-void 
    sget-object v0, Lcom/bytedance/trae/network/quota/AppStartManager;->INSTANCE Lcom/bytedance/trae/network/quota/AppStartManager;
    const/4 v1, 1
    sput-boolean v1, Lcom/bytedance/trae/network/quota/AppStartManager;->initialized Z
    move-object v1, v0
    check-cast v1, Landroid/app/Application$ActivityLifecycleCallbacks;
    invoke-virtual v3, v1, Landroid/app/Application;->registerActivityLifecycleCallbacks(Landroid/app/Application$ActivityLifecycleCallbacks;)V
    sget-object v3, Lcom/bytedance/trae/network/quota/AppInfoProvider;->INSTANCE Lcom/bytedance/trae/network/quota/AppInfoProvider;
    invoke-virtual v3, Lcom/bytedance/trae/network/quota/AppInfoProvider;->init()V
    sget-object v3, Lcom/bytedance/frameworks/baselib/network/http/cronet/TTAppStateManager$AppStartState;->ColdStart Lcom/bytedance/frameworks/baselib/network/http/cronet/TTAppStateManager$AppStartState;
    invoke-static v3, Lcom/bytedance/frameworks/baselib/network/http/cronet/TTAppStateManager;->setAppStartUpState(Lcom/bytedance/frameworks/baselib/network/http/cronet/TTAppStateManager$AppStartState;)V
    sget-object v3, Lcom/bytedance/trae/network/quota/AppStartState;->ColdStart Lcom/bytedance/trae/network/quota/AppStartState;
    invoke-direct v0, v3, Lcom/bytedance/trae/network/quota/AppStartManager;->updateStartState(Lcom/bytedance/trae/network/quota/AppStartState;)V
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    monitor-exit v2
    return-void 
    move-exception v3
    monitor-exit v2
    throw v3
    :try_start_0xb
    :try_start_0x11
.end method

.method public onActivityCreated(android.app.Activity  android.os.Bundle)void
    .registers 3
    # ins_size=3
    const-string v2, "activity"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v1, 1
    sput-boolean v1, Lcom/bytedance/trae/network/quota/AppStartManager;->isActivityCreated Z
    return-void 
.end method

.method public onActivityDestroyed(android.app.Activity)void
    .registers 3
    # ins_size=2
    const-string v0, "activity"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget v2, Lcom/bytedance/trae/network/quota/AppStartManager;->startedActivityCount I
    if-gtz v2, +008h
    const/4 v2, 0
    sput-boolean v2, Lcom/bytedance/trae/network/quota/AppStartManager;->isActivityCreated Z
    const/4 v2, 1
    sput-boolean v2, Lcom/bytedance/trae/network/quota/AppStartManager;->finishAll Z
    return-void 
.end method

.method public onActivityPaused(android.app.Activity)void
    .registers 3
    # ins_size=2
    const-string v0, "activity"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method

.method public onActivityResumed(android.app.Activity)void
    .registers 3
    # ins_size=2
    const-string v0, "activity"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method

.method public onActivitySaveInstanceState(android.app.Activity  android.os.Bundle)void
    .registers 4
    # ins_size=3
    const-string v0, "activity"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v2, outState
    invoke-static v3, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method

.method public onActivityStarted(android.app.Activity)void
    .registers 5
    # ins_size=2
    const-string v0, "activity"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget v4, Lcom/bytedance/trae/network/quota/AppStartManager;->startedActivityCount I
    const/4 v0, 0
    const/4 v1, 1
    if-lez v4, +004h
    move v4, v1
    goto +2h
    move v4, v0
    sget v2, Lcom/bytedance/trae/network/quota/AppStartManager;->startedActivityCount I
    add-int/2addr v2, v1
    sput v2, Lcom/bytedance/trae/network/quota/AppStartManager;->startedActivityCount I
    if-nez v4, +02ah
    sget-boolean v4, Lcom/bytedance/trae/network/quota/AppStartManager;->hasEverForeground Z
    if-nez v4, +004h
    const/4 v4, 0
    goto +1ah
    sget-boolean v4, Lcom/bytedance/trae/network/quota/AppStartManager;->isActivityCreated Z
    if-eqz v4, +010h
    sget-boolean v4, Lcom/bytedance/trae/network/quota/AppStartManager;->finishAll Z
    if-eqz v4, +00ch
    sput-boolean v0, Lcom/bytedance/trae/network/quota/AppStartManager;->finishAll Z
    sget-object v4, Lcom/bytedance/frameworks/baselib/network/http/cronet/TTAppStateManager$AppStartState;->WarmStart Lcom/bytedance/frameworks/baselib/network/http/cronet/TTAppStateManager$AppStartState;
    invoke-static v4, Lcom/bytedance/frameworks/baselib/network/http/cronet/TTAppStateManager;->setAppStartUpState(Lcom/bytedance/frameworks/baselib/network/http/cronet/TTAppStateManager$AppStartState;)V
    sget-object v4, Lcom/bytedance/trae/network/quota/AppStartState;->WarmStart Lcom/bytedance/trae/network/quota/AppStartState;
    goto +8h
    sget-object v4, Lcom/bytedance/frameworks/baselib/network/http/cronet/TTAppStateManager$AppStartState;->HotStart Lcom/bytedance/frameworks/baselib/network/http/cronet/TTAppStateManager$AppStartState;
    invoke-static v4, Lcom/bytedance/frameworks/baselib/network/http/cronet/TTAppStateManager;->setAppStartUpState(Lcom/bytedance/frameworks/baselib/network/http/cronet/TTAppStateManager$AppStartState;)V
    sget-object v4, Lcom/bytedance/trae/network/quota/AppStartState;->HotStart Lcom/bytedance/trae/network/quota/AppStartState;
    sput-boolean v1, Lcom/bytedance/trae/network/quota/AppStartManager;->hasEverForeground Z
    if-eqz v4, +007h
    sget-object v0, Lcom/bytedance/trae/network/quota/AppStartManager;->INSTANCE Lcom/bytedance/trae/network/quota/AppStartManager;
    invoke-direct v0, v4, Lcom/bytedance/trae/network/quota/AppStartManager;->updateStartState(Lcom/bytedance/trae/network/quota/AppStartState;)V
    return-void 
.end method

.method public onActivityStopped(android.app.Activity)void
    .registers 3
    # ins_size=2
    const-string v0, "activity"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget v2, Lcom/bytedance/trae/network/quota/AppStartManager;->startedActivityCount I
    add-int/lit8 v2, v2, -1
    sput v2, Lcom/bytedance/trae/network/quota/AppStartManager;->startedActivityCount I
    sget v2, Lcom/bytedance/trae/network/quota/AppStartManager;->startedActivityCount I
    if-gtz v2, +005h
    const/4 v2, 0
    sput v2, Lcom/bytedance/trae/network/quota/AppStartManager;->startedActivityCount I
    return-void 
.end method

.method public final removeListener(kotlin.jvm.functions.Function1)void
    .registers 3
    # ins_size=2
    const-string v0, "listener"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/network/quota/AppStartManager;->listeners Ljava/util/concurrent/CopyOnWriteArraySet;
    invoke-virtual v0, v2, Ljava/util/concurrent/CopyOnWriteArraySet;->remove(Ljava/lang/Object;)Z
    return-void 
.end method
