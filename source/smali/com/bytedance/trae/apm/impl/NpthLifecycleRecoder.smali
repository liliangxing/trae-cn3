# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;
.super Landroidx/fragment/app/FragmentManager$FragmentLifecycleCallbacks;
.source "NpthLifecycleRecoder.kt"

.implements Landroid/app/Application$ActivityLifecycleCallbacks;

.field private static final DELAY_MILLIS:J
.field public static final INSTANCE:Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;
.field private static final TAG:Ljava/lang/String;
.field private static appContext:Landroid/content/Context;
.field private static background:Z
.field private static createdCount:I
.field private static final delayDestroyRunnable:Ljava/lang/Runnable;
.field private static final delayStopRunnable:Ljava/lang/Runnable;
.field private static destroyed:Z
.field private static firstCreated:Z
.field private static final handler$delegate:Lkotlin/Lazy;
.field private static final lifecycleData:Ljava/util/concurrent/CopyOnWriteArrayList;
.field private static maxLifeCycleCount:I
.field private static startedCount:I
.field private static final timeFormatter:Ljava/text/SimpleDateFormat;


.method public static synthetic $r8$lambda$2aCWtYT6dfsW19abX7Dwuw92Nqg()android.os.Handler
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->handler_delegate$lambda$0()Landroid/os/Handler;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$qk6MHX4NPbxiK2-db8AomKIJ7YI()void
    .registers 0
    # ins_size=0
    invoke-static Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->delayStopRunnable$lambda$1()V
    return-void 
.end method

.method public static synthetic $r8$lambda$sbPyhL9R1XyabHYyqEBjBuH34RQ()void
    .registers 0
    # ins_size=0
    invoke-static Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->delayDestroyRunnable$lambda$2()V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;
    invoke-direct v0, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;-><init>()V
    sput-object v0, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->INSTANCE Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;
    const/4 v0, 1
    sput-boolean v0, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->firstCreated Z
    sput-boolean v0, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->background Z
    sput-boolean v0, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->destroyed Z
    new-instance v0, Ljava/util/concurrent/CopyOnWriteArrayList;
    invoke-direct v0, Ljava/util/concurrent/CopyOnWriteArrayList;-><init>()V
    sput-object v0, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->lifecycleData Ljava/util/concurrent/CopyOnWriteArrayList;
    const/16 v0, 100
    sput v0, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->maxLifeCycleCount I
    new-instance v0, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder$$ExternalSyntheticLambda0;
    invoke-direct v0, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder$$ExternalSyntheticLambda0;-><init>()V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->handler$delegate Lkotlin/Lazy;
    new-instance v0, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder$$ExternalSyntheticLambda1;
    invoke-direct v0, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder$$ExternalSyntheticLambda1;-><init>()V
    sput-object v0, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->delayStopRunnable Ljava/lang/Runnable;
    new-instance v0, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder$$ExternalSyntheticLambda2;
    invoke-direct v0, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder$$ExternalSyntheticLambda2;-><init>()V
    sput-object v0, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->delayDestroyRunnable Ljava/lang/Runnable;
    new-instance v0, Ljava/text/SimpleDateFormat;
    const-string/jumbo v1, yyyy-MM-dd HH:mm:ss
    invoke-static Ljava/util/Locale;->getDefault()Ljava/util/Locale;
    move-result-object v2
    invoke-direct v0, v1, v2, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String; Ljava/util/Locale;)V
    sput-object v0, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->timeFormatter Ljava/text/SimpleDateFormat;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Landroidx/fragment/app/FragmentManager$FragmentLifecycleCallbacks;-><init>()V
    return-void 
.end method

.method private final addLifecycleData(java.lang.String)void
    .registers 4
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->lifecycleData Ljava/util/concurrent/CopyOnWriteArrayList;
    invoke-virtual v0, v3, Ljava/util/concurrent/CopyOnWriteArrayList;->add(Ljava/lang/Object;)Z
    invoke-virtual v0, Ljava/util/concurrent/CopyOnWriteArrayList;->size()I
    move-result v3
    sget v1, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->maxLifeCycleCount I
    if-le v3, v1, +006h
    const/4 v3, 0
    invoke-virtual v0, v3, Ljava/util/concurrent/CopyOnWriteArrayList;->remove(I)Ljava/lang/Object;
    return-void 
.end method

.method private static final delayDestroyRunnable$lambda$2()void
    .registers 1
    # ins_size=0
    sget v0, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->createdCount I
    if-nez v0, +005h
    const/4 v0, 1
    sput-boolean v0, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->destroyed Z
    return-void 
.end method

.method private static final delayStopRunnable$lambda$1()void
    .registers 2
    # ins_size=0
    sget v0, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->startedCount I
    if-nez v0, +00ah
    sget-object v0, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->INSTANCE Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;
    const/4 v1, 1
    sput-boolean v1, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->background Z
    invoke-direct v0, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->onAppBackground()V
    return-void 
.end method

.method private final getClassPrefix(android.app.Activity)java.lang.String
    .registers 2
    # ins_size=2
    if-nez v1, +005h
    const-string v1, "null"
    goto +5h
    invoke-direct v0, v1, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->simpleName(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v1
    return-object v1
.end method

.method private final getClassPrefix(androidx.fragment.app.Fragment)java.lang.String
    .registers 4
    # ins_size=2
    if-nez v3, +005h
    const-string v3, "null"
    goto +29h
    invoke-virtual v3, Landroidx/fragment/app/Fragment;->getActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v0
    if-eqz v0, +007h
    invoke-direct v2, v0, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->simpleName(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v0
    goto +3h
    const-string v0, ""
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v1, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 32
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-direct v2, v3, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->simpleName(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    return-object v3
.end method

.method private final getCurTime()java.lang.String
    .registers 5
    # ins_size=1
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v0
    sget-object v2, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->timeFormatter Ljava/text/SimpleDateFormat;
    new-instance v3, Ljava/util/Date;
    invoke-direct v3, v0, v1, Ljava/util/Date;-><init>(J)V
    invoke-virtual v2, v3, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;
    move-result-object v0
    goto +5h
    invoke-static v0, v1, Ljava/lang/String;->valueOf(J)Ljava/lang/String;
    move-result-object v0
    return-object v0
    :try_start_0x4
.end method

.method private final getHandler()android.os.Handler
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->handler$delegate Lkotlin/Lazy;
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
    .registers 6
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "["
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-direct v3, v4, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->simpleName(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v4
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v1, "] "
    invoke-virtual v4, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    const-string v5, "LifecycleRecorder"
    invoke-virtual v0, v5, v4, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method private final onAppBackground()void
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->appContext Landroid/content/Context;
    const-string v1, "onAppBackground"
    invoke-direct v2, v0, v1, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->recordLifecycle(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic onAppCreate$default(com.bytedance.trae.apm.impl.NpthLifecycleRecoder  android.app.Application  int  int  java.lang.Object)void
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +004h
    const/16 v2, 1000
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->onAppCreate(Landroid/app/Application; I)V
    return-void 
.end method

.method private final onAppForeground()void
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->appContext Landroid/content/Context;
    const-string v1, "onAppForeground"
    invoke-direct v2, v0, v1, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->recordLifecycle(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method

.method private final recordLifecycle(java.lang.Object  java.lang.String)void
    .registers 6
    # ins_size=3
    instance-of v0, v4, Landroid/app/Activity;
    const-string v1, "] "
    const-string v2, "["
    if-eqz v0, +01eh
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    check-cast v4, Landroid/app/Activity;
    invoke-direct v3, v4, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->getClassPrefix(Landroid/app/Activity;)Ljava/lang/String;
    move-result-object v4
    invoke-virtual v0, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    goto +3ah
    instance-of v0, v4, Landroidx/fragment/app/Fragment;
    if-eqz v0, +01eh
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    check-cast v4, Landroidx/fragment/app/Fragment;
    invoke-direct v3, v4, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->getClassPrefix(Landroidx/fragment/app/Fragment;)Ljava/lang/String;
    move-result-object v4
    invoke-virtual v0, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    goto +1ah
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-direct v3, v4, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->simpleName(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v4
    invoke-virtual v0, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-static v4, Lcom/bytedance/trae/utils/StringKt;->isNotNullOrEmpty(Ljava/lang/String;)Z
    move-result v5
    if-eqz v5, +022h
    new-instance v5, Ljava/lang/StringBuilder;
    const-string v0, "
"
    invoke-direct v5, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-direct v3, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->getCurTime()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v5, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    const/16 v0, 32
    invoke-virtual v5, v0, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-direct v3, v4, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->addLifecycleData(Ljava/lang/String;)V
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

.method public final getLifecycleData()java.util.List
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->lifecycleData Ljava/util/concurrent/CopyOnWriteArrayList;
    check-cast v0, Ljava/util/List;
    return-object v0
.end method

.method public onActivityCreated(android.app.Activity  android.os.Bundle)void
    .registers 7
    # ins_size=3
    const-string v0, "activity"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget v0, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->createdCount I
    const/4 v1, 1
    add-int/2addr v0, v1
    sput v0, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->createdCount I
    const/4 v2, 0
    if-ne v0, v1, +012h
    sget-boolean v0, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->destroyed Z
    if-eqz v0, +005h
    sput-boolean v2, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->destroyed Z
    goto +ah
    invoke-direct v4, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->getHandler()Landroid/os/Handler;
    move-result-object v0
    sget-object v3, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->delayDestroyRunnable Ljava/lang/Runnable;
    invoke-virtual v0, v3, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V
    if-eqz v6, +004h
    move v6, v1
    goto +2h
    move v6, v2
    sget-boolean v0, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->firstCreated Z
    const-string v3, "normal create"
    if-eqz v0, +009h
    sput-boolean v2, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->firstCreated Z
    if-eqz v6, +009h
    const-string v3, "maybe app recreate"
    goto +5h
    if-eqz v6, +004h
    const-string v3, "maybe activity recreate"
    const-string v6, "onActivityCreated, desc: "
    invoke-virtual v6, v3, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v6
    invoke-direct v4, v5, v6, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->log(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v6, "onActivityCreated"
    invoke-direct v4, v5, v6, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->recordLifecycle(Ljava/lang/Object; Ljava/lang/String;)V
    instance-of v6, v5, Landroidx/fragment/app/FragmentActivity;
    if-eqz v6, +005h
    check-cast v5, Landroidx/fragment/app/FragmentActivity;
    goto +2h
    const/4 v5, 0
    if-eqz v5, +00eh
    invoke-virtual v5, Landroidx/fragment/app/FragmentActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v5
    if-eqz v5, +008h
    move-object v6, v4
    check-cast v6, Landroidx/fragment/app/FragmentManager$FragmentLifecycleCallbacks;
    invoke-virtual v5, v6, v1, Landroidx/fragment/app/FragmentManager;->registerFragmentLifecycleCallbacks(Landroidx/fragment/app/FragmentManager$FragmentLifecycleCallbacks; Z)V
    return-void 
.end method

.method public onActivityDestroyed(android.app.Activity)void
    .registers 5
    # ins_size=2
    const-string v0, "activity"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onActivityDestroyed"
    invoke-direct v3, v4, v0, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->recordLifecycle(Ljava/lang/Object; Ljava/lang/String;)V
    sget v4, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->createdCount I
    add-int/lit8 v4, v4, -1
    sput v4, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->createdCount I
    if-nez v4, +011h
    sget-boolean v4, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->destroyed Z
    if-nez v4, +00dh
    invoke-direct v3, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->getHandler()Landroid/os/Handler;
    move-result-object v4
    sget-object v0, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->delayDestroyRunnable Ljava/lang/Runnable;
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
    invoke-direct v1, v2, v0, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->recordLifecycle(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method

.method public onActivityResumed(android.app.Activity)void
    .registers 3
    # ins_size=2
    const-string v0, "activity"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onActivityResumed"
    invoke-direct v1, v2, v0, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->recordLifecycle(Ljava/lang/Object; Ljava/lang/String;)V
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
    invoke-direct v1, v2, v3, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->recordLifecycle(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method

.method public onActivityStarted(android.app.Activity)void
    .registers 3
    # ins_size=2
    const-string v0, "activity"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onActivityStarted"
    invoke-direct v1, v2, v0, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->recordLifecycle(Ljava/lang/Object; Ljava/lang/String;)V
    sget v2, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->startedCount I
    const/4 v0, 1
    add-int/2addr v2, v0
    sput v2, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->startedCount I
    if-ne v2, v0, +016h
    sget-boolean v2, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->background Z
    if-eqz v2, +009h
    const/4 v2, 0
    sput-boolean v2, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->background Z
    invoke-direct v1, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->onAppForeground()V
    goto +ah
    invoke-direct v1, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->getHandler()Landroid/os/Handler;
    move-result-object v2
    sget-object v0, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->delayStopRunnable Ljava/lang/Runnable;
    invoke-virtual v2, v0, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V
    return-void 
.end method

.method public onActivityStopped(android.app.Activity)void
    .registers 5
    # ins_size=2
    const-string v0, "activity"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onActivityStopped"
    invoke-direct v3, v4, v0, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->recordLifecycle(Ljava/lang/Object; Ljava/lang/String;)V
    sget v4, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->startedCount I
    add-int/lit8 v4, v4, -1
    sput v4, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->startedCount I
    if-nez v4, +011h
    sget-boolean v4, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->background Z
    if-nez v4, +00dh
    invoke-direct v3, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->getHandler()Landroid/os/Handler;
    move-result-object v4
    sget-object v0, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->delayStopRunnable Ljava/lang/Runnable;
    const-wide/16 v1, 300
    invoke-virtual v4, v0, v1, v2, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable; J)Z
    return-void 
.end method

.method public final onAppCreate(android.app.Application  int)void
    .registers 5
    # ins_size=3
    const-string v0, "app"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v0, v3
    check-cast v0, Landroid/content/Context;
    sput-object v0, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->appContext Landroid/content/Context;
    sput v4, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->maxLifeCycleCount I
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v0, "onAppCreate, process:"
    invoke-direct v4, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-static Lcom/bytedance/apm/ApmContext;->getCurrentProcessName()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v4, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v0, ", "
    invoke-virtual v4, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getAppId()I
    move-result v0
    invoke-virtual v4, v0, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v4
    const/16 v0, 32
    invoke-virtual v4, v0, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v4
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getBuildChannel()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v4, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v0, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v4
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getVersionName()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v4, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v0, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v4
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getVersionCode()I
    move-result v1
    invoke-virtual v4, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v0, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v4
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isDebug()Z
    move-result v0
    invoke-virtual v4, v0, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-direct v2, v3, v4, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->log(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v4, "onAppCreate"
    invoke-direct v2, v3, v4, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->recordLifecycle(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v4, v2
    check-cast v4, Landroid/app/Application$ActivityLifecycleCallbacks;
    invoke-virtual v3, v4, Landroid/app/Application;->registerActivityLifecycleCallbacks(Landroid/app/Application$ActivityLifecycleCallbacks;)V
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
    invoke-direct v1, v4, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->simpleName(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v4
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v4, ", parentFragment:"
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v3, Landroidx/fragment/app/Fragment;->getParentFragment()Landroidx/fragment/app/Fragment;
    move-result-object v4
    invoke-direct v1, v4, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->simpleName(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v4
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-direct v1, v3, v2, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->log(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v2, "onFragmentAttached"
    invoke-direct v1, v3, v2, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->recordLifecycle(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method

.method public onFragmentCreated(androidx.fragment.app.FragmentManager  androidx.fragment.app.Fragment  android.os.Bundle)void
    .registers 4
    # ins_size=4
    const-string v3, "fm"
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "f"
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "onFragmentCreated"
    invoke-direct v0, v2, v1, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->recordLifecycle(Ljava/lang/Object; Ljava/lang/String;)V
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
    invoke-direct v1, v3, v2, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->recordLifecycle(Ljava/lang/Object; Ljava/lang/String;)V
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
    invoke-direct v1, v3, v2, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->recordLifecycle(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method

.method public onFragmentPaused(androidx.fragment.app.FragmentManager  androidx.fragment.app.Fragment)void
    .registers 4
    # ins_size=3
    const-string v0, "fm"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v2, "f"
    invoke-static v3, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v2, "onFragmentPaused"
    invoke-direct v1, v3, v2, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->recordLifecycle(Ljava/lang/Object; Ljava/lang/String;)V
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
    invoke-direct v1, v3, v2, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->recordLifecycle(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method

.method public onFragmentSaveInstanceState(androidx.fragment.app.FragmentManager  androidx.fragment.app.Fragment  android.os.Bundle)void
    .registers 5
    # ins_size=4
    const-string v0, "fm"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v2, "f"
    invoke-static v3, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v2, "outState"
    invoke-static v4, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v2, "onFragmentSaveInstanceState"
    invoke-direct v1, v3, v2, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->recordLifecycle(Ljava/lang/Object; Ljava/lang/String;)V
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
    invoke-direct v1, v3, v2, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->recordLifecycle(Ljava/lang/Object; Ljava/lang/String;)V
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
    invoke-direct v1, v3, v2, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->recordLifecycle(Ljava/lang/Object; Ljava/lang/String;)V
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
    invoke-direct v0, v2, v1, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->recordLifecycle(Ljava/lang/Object; Ljava/lang/String;)V
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
    invoke-direct v1, v3, v2, Lcom/bytedance/trae/apm/impl/NpthLifecycleRecoder;->recordLifecycle(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method
