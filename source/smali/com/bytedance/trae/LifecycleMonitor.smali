# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/LifecycleMonitor;
.super Landroidx/fragment/app/FragmentManager$FragmentLifecycleCallbacks;
.source "LifecycleMonitor.kt"

.implements Landroid/app/Application$ActivityLifecycleCallbacks;

.field public static final $stable:I
.field private static final DELAY_MILLIS:J
.field private static final EVENT_ACTIVITY_STACK_CREATED:Ljava/lang/String;
.field private static final EVENT_ACTIVITY_STACK_DESTROYED:Ljava/lang/String;
.field private static final EVENT_ENTER_BACKGROUND:Ljava/lang/String;
.field private static final EVENT_ENTER_FOREGROUND:Ljava/lang/String;
.field public static final INSTANCE:Lcom/bytedance/trae/LifecycleMonitor;
.field private static final TAG:Ljava/lang/String;
.field private static appContext:Landroid/content/Context;
.field private static background:Z
.field private static createdCount:I
.field private static final delayDestroyRunnable:Ljava/lang/Runnable;
.field private static final delayStopRunnable:Ljava/lang/Runnable;
.field private static destroyed:Z
.field private static firstCreated:Z
.field private static final handler$delegate:Lkotlin/Lazy;
.field private static processStartMillis:J
.field private static startedCount:I


.method public static synthetic $r8$lambda$KNh6mqR5pCpLcwoyyPdGX3eh_xM()void
    .registers 0
    # ins_size=0
    invoke-static Lcom/bytedance/trae/LifecycleMonitor;->delayStopRunnable$lambda$1()V
    return-void 
.end method

.method public static synthetic $r8$lambda$cYUWZptEnZC2iQPXCo-5ev6vaec()android.os.Handler
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/LifecycleMonitor;->handler_delegate$lambda$0()Landroid/os/Handler;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$nAkaTKscVhY_aFXY0u_EVx9HvOk()void
    .registers 0
    # ins_size=0
    invoke-static Lcom/bytedance/trae/LifecycleMonitor;->delayDestroyRunnable$lambda$2()V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/LifecycleMonitor;
    invoke-direct v0, Lcom/bytedance/trae/LifecycleMonitor;-><init>()V
    sput-object v0, Lcom/bytedance/trae/LifecycleMonitor;->INSTANCE Lcom/bytedance/trae/LifecycleMonitor;
    const/4 v0, 1
    sput-boolean v0, Lcom/bytedance/trae/LifecycleMonitor;->firstCreated Z
    sput-boolean v0, Lcom/bytedance/trae/LifecycleMonitor;->background Z
    sput-boolean v0, Lcom/bytedance/trae/LifecycleMonitor;->destroyed Z
    new-instance v0, Lcom/bytedance/trae/LifecycleMonitor$$ExternalSyntheticLambda0;
    invoke-direct v0, Lcom/bytedance/trae/LifecycleMonitor$$ExternalSyntheticLambda0;-><init>()V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/LifecycleMonitor;->handler$delegate Lkotlin/Lazy;
    new-instance v0, Lcom/bytedance/trae/LifecycleMonitor$$ExternalSyntheticLambda1;
    invoke-direct v0, Lcom/bytedance/trae/LifecycleMonitor$$ExternalSyntheticLambda1;-><init>()V
    sput-object v0, Lcom/bytedance/trae/LifecycleMonitor;->delayStopRunnable Ljava/lang/Runnable;
    new-instance v0, Lcom/bytedance/trae/LifecycleMonitor$$ExternalSyntheticLambda2;
    invoke-direct v0, Lcom/bytedance/trae/LifecycleMonitor$$ExternalSyntheticLambda2;-><init>()V
    sput-object v0, Lcom/bytedance/trae/LifecycleMonitor;->delayDestroyRunnable Ljava/lang/Runnable;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/LifecycleMonitor;->$stable I
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Landroidx/fragment/app/FragmentManager$FragmentLifecycleCallbacks;-><init>()V
    return-void 
.end method

.method private static final delayDestroyRunnable$lambda$2()void
    .registers 2
    # ins_size=0
    sget v0, Lcom/bytedance/trae/LifecycleMonitor;->createdCount I
    if-nez v0, +00ah
    sget-object v0, Lcom/bytedance/trae/LifecycleMonitor;->INSTANCE Lcom/bytedance/trae/LifecycleMonitor;
    const/4 v1, 1
    sput-boolean v1, Lcom/bytedance/trae/LifecycleMonitor;->destroyed Z
    invoke-direct v0, Lcom/bytedance/trae/LifecycleMonitor;->onActivityStackDestroyed()V
    return-void 
.end method

.method private static final delayStopRunnable$lambda$1()void
    .registers 2
    # ins_size=0
    sget v0, Lcom/bytedance/trae/LifecycleMonitor;->startedCount I
    if-nez v0, +00ah
    sget-object v0, Lcom/bytedance/trae/LifecycleMonitor;->INSTANCE Lcom/bytedance/trae/LifecycleMonitor;
    const/4 v1, 1
    sput-boolean v1, Lcom/bytedance/trae/LifecycleMonitor;->background Z
    invoke-direct v0, Lcom/bytedance/trae/LifecycleMonitor;->onAppBackground()V
    return-void 
.end method

.method private final from(android.app.Activity)java.lang.Comparable
    .registers 4
    # ins_size=2
    const/4 v0, 0
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    if-eqz v3, +007h
    invoke-virtual v3, Landroid/app/Activity;->getReferrer()Landroid/net/Uri;
    move-result-object v3
    goto +2h
    move-object v3, v0
    check-cast v3, Ljava/lang/Comparable;
    invoke-static v3, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    goto +ch
    move-exception v3
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v3, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v3
    invoke-static v3, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    invoke-static v3, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +003h
    goto +2h
    move-object v0, v3
    check-cast v0, Ljava/lang/Comparable;
    if-nez v0, +008h
    const-string/jumbo v3, unknown_null
    move-object v0, v3
    check-cast v0, Ljava/lang/Comparable;
    return-object v0
    :try_start_0x1
.end method

.method private final getHandler()android.os.Handler
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/LifecycleMonitor;->handler$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Landroid/os/Handler;
    return-object v0
.end method

.method private static final handler_delegate$lambda$0()android.os.Handler
    .registers 2
    # ins_size=0
    new-instance v0, Landroid/os/Handler;
    invoke-static Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;
    move-result-object v1
    invoke-direct v0, v1, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V
    return-object v0
.end method

.method private final log(java.lang.Object  java.lang.String)void
    .registers 3
    # ins_size=3
    return-void 
.end method

.method private final onActivityStackCreated()void
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/LifecycleMonitor;->appContext Landroid/content/Context;
    const-string v1, "onActivityStackCreated"
    invoke-direct v2, v0, v1, Lcom/bytedance/trae/LifecycleMonitor;->log(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    const-string v1, "flow_activity_stack_created"
    invoke-virtual v0, v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String;)V
    return-void 
.end method

.method private final onActivityStackDestroyed()void
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/LifecycleMonitor;->appContext Landroid/content/Context;
    const-string v1, "onActivityStackDestroyed"
    invoke-direct v2, v0, v1, Lcom/bytedance/trae/LifecycleMonitor;->log(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    const-string v1, "flow_activity_stack_destroyed"
    invoke-virtual v0, v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String;)V
    return-void 
.end method

.method private final onAppBackground()void
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/LifecycleMonitor;->appContext Landroid/content/Context;
    const-string v1, "onAppBackground"
    invoke-direct v2, v0, v1, Lcom/bytedance/trae/LifecycleMonitor;->log(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    const-string v1, "flow_enter_background"
    invoke-virtual v0, v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String;)V
    return-void 
.end method

.method private final onAppForeground()void
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/LifecycleMonitor;->appContext Landroid/content/Context;
    const-string v1, "onAppForeground"
    invoke-direct v2, v0, v1, Lcom/bytedance/trae/LifecycleMonitor;->log(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    const-string v1, "flow_enter_foreground"
    invoke-virtual v0, v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String;)V
    return-void 
.end method

.method private final simpleName(java.lang.Object)java.lang.String
    .registers 4
    # ins_size=2
    if-nez v3, +005h
    const-string v3, "null"
    goto +28h
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v3, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 64
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v3, Ljava/lang/Object;->hashCode()I
    move-result v3
    invoke-static v3, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    return-object v3
.end method

.method public onActivityCreated(android.app.Activity  android.os.Bundle)void
    .registers 8
    # ins_size=3
    const-string v0, "activity"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget v0, Lcom/bytedance/trae/LifecycleMonitor;->createdCount I
    const/4 v1, 1
    add-int/2addr v0, v1
    sput v0, Lcom/bytedance/trae/LifecycleMonitor;->createdCount I
    const/4 v2, 0
    if-ne v0, v1, +015h
    sget-boolean v0, Lcom/bytedance/trae/LifecycleMonitor;->destroyed Z
    if-eqz v0, +008h
    sput-boolean v2, Lcom/bytedance/trae/LifecycleMonitor;->destroyed Z
    invoke-direct v5, Lcom/bytedance/trae/LifecycleMonitor;->onActivityStackCreated()V
    goto +ah
    invoke-direct v5, Lcom/bytedance/trae/LifecycleMonitor;->getHandler()Landroid/os/Handler;
    move-result-object v0
    sget-object v3, Lcom/bytedance/trae/LifecycleMonitor;->delayDestroyRunnable Ljava/lang/Runnable;
    invoke-virtual v0, v3, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V
    if-eqz v7, +004h
    move v7, v1
    goto +2h
    move v7, v2
    invoke-virtual v6, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;
    move-result-object v0
    sget-boolean v3, Lcom/bytedance/trae/LifecycleMonitor;->firstCreated Z
    const-string v4, "normal create"
    if-eqz v3, +011h
    sput-boolean v2, Lcom/bytedance/trae/LifecycleMonitor;->firstCreated Z
    if-eqz v7, +004h
    const-string v4, "maybe app recreate"
    sget-wide v2, Lcom/bytedance/trae/LifecycleMonitor;->processStartMillis J
    invoke-static v2, v3, Lcom/bytedance/trae/init/task/base/InitTaskHelperKt;->checkSuspiciousTask(J)V
    invoke-static v7, v0, Lcom/bytedance/trae/init/task/base/InitTaskHelperKt;->monitorProcessRecreate(Z Ljava/lang/String;)V
    goto +8h
    if-eqz v7, +004h
    const-string v4, "maybe activity recreate"
    invoke-static v7, v0, Lcom/bytedance/trae/init/task/base/InitTaskHelperKt;->monitorActivityRecreate(Z Ljava/lang/String;)V
    new-instance v7, Ljava/lang/StringBuilder;
    const-string v0, "onActivityCreated, refer:"
    invoke-direct v7, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-direct v5, v6, Lcom/bytedance/trae/LifecycleMonitor;->from(Landroid/app/Activity;)Ljava/lang/Comparable;
    move-result-object v0
    invoke-virtual v7, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v0, ", "
    invoke-virtual v7, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    invoke-direct v5, v6, v7, Lcom/bytedance/trae/LifecycleMonitor;->log(Ljava/lang/Object; Ljava/lang/String;)V
    instance-of v7, v6, Landroidx/fragment/app/FragmentActivity;
    if-eqz v7, +005h
    check-cast v6, Landroidx/fragment/app/FragmentActivity;
    goto +2h
    const/4 v6, 0
    if-eqz v6, +00eh
    invoke-virtual v6, Landroidx/fragment/app/FragmentActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v6
    if-eqz v6, +008h
    move-object v7, v5
    check-cast v7, Landroidx/fragment/app/FragmentManager$FragmentLifecycleCallbacks;
    invoke-virtual v6, v7, v1, Landroidx/fragment/app/FragmentManager;->registerFragmentLifecycleCallbacks(Landroidx/fragment/app/FragmentManager$FragmentLifecycleCallbacks; Z)V
    return-void 
.end method

.method public onActivityDestroyed(android.app.Activity)void
    .registers 5
    # ins_size=2
    const-string v0, "activity"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onActivityDestroyed"
    invoke-direct v3, v4, v0, Lcom/bytedance/trae/LifecycleMonitor;->log(Ljava/lang/Object; Ljava/lang/String;)V
    sget v4, Lcom/bytedance/trae/LifecycleMonitor;->createdCount I
    add-int/lit8 v4, v4, -1
    sput v4, Lcom/bytedance/trae/LifecycleMonitor;->createdCount I
    if-nez v4, +011h
    sget-boolean v4, Lcom/bytedance/trae/LifecycleMonitor;->destroyed Z
    if-nez v4, +00dh
    invoke-direct v3, Lcom/bytedance/trae/LifecycleMonitor;->getHandler()Landroid/os/Handler;
    move-result-object v4
    sget-object v0, Lcom/bytedance/trae/LifecycleMonitor;->delayDestroyRunnable Ljava/lang/Runnable;
    const-wide/16 v1, 300
    invoke-virtual v4, v0, v1, v2, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable; J)Z
    return-void 
.end method

.method public onActivityPaused(android.app.Activity)void
    .registers 3
    # ins_size=2
    const-string v0, "activity"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onActivityPaused"
    invoke-direct v1, v2, v0, Lcom/bytedance/trae/LifecycleMonitor;->log(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method

.method public onActivityPreCreated(android.app.Activity  android.os.Bundle)void
    .registers 3
    # ins_size=3
    const-string v2, "activity"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v2, "onActivityPreCreated"
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/LifecycleMonitor;->log(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method

.method public onActivityResumed(android.app.Activity)void
    .registers 3
    # ins_size=2
    const-string v0, "activity"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onActivityResumed"
    invoke-direct v1, v2, v0, Lcom/bytedance/trae/LifecycleMonitor;->log(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method

.method public onActivitySaveInstanceState(android.app.Activity  android.os.Bundle)void
    .registers 4
    # ins_size=3
    const-string v0, "activity"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "outState"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v3, "onActivitySaveInstanceState"
    invoke-direct v1, v2, v3, Lcom/bytedance/trae/LifecycleMonitor;->log(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method

.method public onActivityStarted(android.app.Activity)void
    .registers 3
    # ins_size=2
    const-string v0, "activity"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onActivityStarted"
    invoke-direct v1, v2, v0, Lcom/bytedance/trae/LifecycleMonitor;->log(Ljava/lang/Object; Ljava/lang/String;)V
    sget v2, Lcom/bytedance/trae/LifecycleMonitor;->startedCount I
    const/4 v0, 1
    add-int/2addr v2, v0
    sput v2, Lcom/bytedance/trae/LifecycleMonitor;->startedCount I
    if-ne v2, v0, +016h
    sget-boolean v2, Lcom/bytedance/trae/LifecycleMonitor;->background Z
    if-eqz v2, +009h
    const/4 v2, 0
    sput-boolean v2, Lcom/bytedance/trae/LifecycleMonitor;->background Z
    invoke-direct v1, Lcom/bytedance/trae/LifecycleMonitor;->onAppForeground()V
    goto +ah
    invoke-direct v1, Lcom/bytedance/trae/LifecycleMonitor;->getHandler()Landroid/os/Handler;
    move-result-object v2
    sget-object v0, Lcom/bytedance/trae/LifecycleMonitor;->delayStopRunnable Ljava/lang/Runnable;
    invoke-virtual v2, v0, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V
    return-void 
.end method

.method public onActivityStopped(android.app.Activity)void
    .registers 5
    # ins_size=2
    const-string v0, "activity"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onActivityStopped"
    invoke-direct v3, v4, v0, Lcom/bytedance/trae/LifecycleMonitor;->log(Ljava/lang/Object; Ljava/lang/String;)V
    sget v4, Lcom/bytedance/trae/LifecycleMonitor;->startedCount I
    add-int/lit8 v4, v4, -1
    sput v4, Lcom/bytedance/trae/LifecycleMonitor;->startedCount I
    if-nez v4, +011h
    sget-boolean v4, Lcom/bytedance/trae/LifecycleMonitor;->background Z
    if-nez v4, +00dh
    invoke-direct v3, Lcom/bytedance/trae/LifecycleMonitor;->getHandler()Landroid/os/Handler;
    move-result-object v4
    sget-object v0, Lcom/bytedance/trae/LifecycleMonitor;->delayStopRunnable Ljava/lang/Runnable;
    const-wide/16 v1, 300
    invoke-virtual v4, v0, v1, v2, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable; J)Z
    return-void 
.end method

.method public final onAppAttachBaseContext(android.app.Application)void
    .registers 4
    # ins_size=2
    const-string v0, "app"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v0
    sput-wide v0, Lcom/bytedance/trae/LifecycleMonitor;->processStartMillis J
    move-object v0, v3
    check-cast v0, Landroid/content/Context;
    sput-object v0, Lcom/bytedance/trae/LifecycleMonitor;->appContext Landroid/content/Context;
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "attachBaseContext, process:"
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-static Lcom/bytedance/apm/ApmContext;->getCurrentProcessName()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-direct v2, v3, v0, Lcom/bytedance/trae/LifecycleMonitor;->log(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method

.method public final onAppCreate(android.app.Application)void
    .registers 3
    # ins_size=2
    const-string v0, "app"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v0, v1
    check-cast v0, Landroid/app/Application$ActivityLifecycleCallbacks;
    invoke-virtual v2, v0, Landroid/app/Application;->registerActivityLifecycleCallbacks(Landroid/app/Application$ActivityLifecycleCallbacks;)V
    sget-object v2, Lcom/bytedance/trae/init/task/util/AppDeviceEnv;->INSTANCE Lcom/bytedance/trae/init/task/util/AppDeviceEnv;
    invoke-virtual v2, Lcom/bytedance/trae/init/task/util/AppDeviceEnv;->report()V
    return-void 
.end method

.method public onFragmentAttached(androidx.fragment.app.FragmentManager  androidx.fragment.app.Fragment  android.content.Context)void
    .registers 5
    # ins_size=4
    const-string v0, "fm"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v2, "f"
    invoke-static v3, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v2, "context"
    invoke-static v4, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v4, "onFragmentAttached, hostActivity:"
    invoke-direct v2, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, Landroidx/fragment/app/Fragment;->getActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v4
    invoke-direct v1, v4, Lcom/bytedance/trae/LifecycleMonitor;->simpleName(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v4
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v4, ", parentFragment:"
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v3, Landroidx/fragment/app/Fragment;->getParentFragment()Landroidx/fragment/app/Fragment;
    move-result-object v4
    invoke-direct v1, v4, Lcom/bytedance/trae/LifecycleMonitor;->simpleName(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v4
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-direct v1, v3, v2, Lcom/bytedance/trae/LifecycleMonitor;->log(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method

.method public onFragmentCreated(androidx.fragment.app.FragmentManager  androidx.fragment.app.Fragment  android.os.Bundle)void
    .registers 5
    # ins_size=4
    const-string v0, "fm"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v2, "f"
    invoke-static v3, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    if-nez v4, +005h
    const-string v2, "="
    goto +3h
    const-string v2, "!="
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v0, "onFragmentCreated, savedInstanceState"
    invoke-direct v4, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v4, "null"
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-direct v1, v3, v2, Lcom/bytedance/trae/LifecycleMonitor;->log(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method

.method public onFragmentDestroyed(androidx.fragment.app.FragmentManager  androidx.fragment.app.Fragment)void
    .registers 4
    # ins_size=3
    const-string v0, "fm"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v2, "f"
    invoke-static v3, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v2, "onFragmentDestroyed"
    invoke-direct v1, v3, v2, Lcom/bytedance/trae/LifecycleMonitor;->log(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method

.method public onFragmentDetached(androidx.fragment.app.FragmentManager  androidx.fragment.app.Fragment)void
    .registers 4
    # ins_size=3
    const-string v0, "fm"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v2, "f"
    invoke-static v3, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v2, "onFragmentDetached"
    invoke-direct v1, v3, v2, Lcom/bytedance/trae/LifecycleMonitor;->log(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method

.method public onFragmentResumed(androidx.fragment.app.FragmentManager  androidx.fragment.app.Fragment)void
    .registers 4
    # ins_size=3
    const-string v0, "fm"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v2, "f"
    invoke-static v3, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v2, "onFragmentResumed"
    invoke-direct v1, v3, v2, Lcom/bytedance/trae/LifecycleMonitor;->log(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method

.method public onFragmentStarted(androidx.fragment.app.FragmentManager  androidx.fragment.app.Fragment)void
    .registers 4
    # ins_size=3
    const-string v0, "fm"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v2, "f"
    invoke-static v3, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v2, "onFragmentStarted"
    invoke-direct v1, v3, v2, Lcom/bytedance/trae/LifecycleMonitor;->log(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method

.method public onFragmentStopped(androidx.fragment.app.FragmentManager  androidx.fragment.app.Fragment)void
    .registers 4
    # ins_size=3
    const-string v0, "fm"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v2, "f"
    invoke-static v3, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v2, "onFragmentStopped"
    invoke-direct v1, v3, v2, Lcom/bytedance/trae/LifecycleMonitor;->log(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method

.method public onFragmentViewCreated(androidx.fragment.app.FragmentManager  androidx.fragment.app.Fragment  android.view.View  android.os.Bundle)void
    .registers 5
    # ins_size=5
    const-string v4, "fm"
    invoke-static v1, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "f"
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v1, v
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "onFragmentViewCreated"
    invoke-direct v0, v2, v1, Lcom/bytedance/trae/LifecycleMonitor;->log(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method

.method public onFragmentViewDestroyed(androidx.fragment.app.FragmentManager  androidx.fragment.app.Fragment)void
    .registers 4
    # ins_size=3
    const-string v0, "fm"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v2, "f"
    invoke-static v3, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v2, "onFragmentViewDestroyed"
    invoke-direct v1, v3, v2, Lcom/bytedance/trae/LifecycleMonitor;->log(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method
