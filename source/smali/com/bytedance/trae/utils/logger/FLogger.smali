# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/utils/logger/FLogger;
.super Ljava/lang/Object;
.source "FLogger.kt"

.implements Lcom/bytedance/trae/utils/logger/ILogger;

.field public static final INSTANCE:Lcom/bytedance/trae/utils/logger/FLogger;
.field private static impl:Lcom/bytedance/trae/utils/logger/ILogger;
.field private static final spiImpl$delegate:Lkotlin/Lazy;


.method public static synthetic $r8$lambda$D9EIKBL0AvqziyMMehR-GJacFVE()com.bytedance.trae.utils.logger.ILogger
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/utils/logger/FLogger;->spiImpl_delegate$lambda$0()Lcom/bytedance/trae/utils/logger/ILogger;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/utils/logger/FLogger;
    invoke-direct v0, Lcom/bytedance/trae/utils/logger/FLogger;-><init>()V
    sput-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v0, Lcom/bytedance/trae/utils/logger/FLogger$$ExternalSyntheticLambda0;
    invoke-direct v0, Lcom/bytedance/trae/utils/logger/FLogger$$ExternalSyntheticLambda0;-><init>()V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->spiImpl$delegate Lkotlin/Lazy;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final getImpl()com.bytedance.trae.utils.logger.ILogger
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->impl Lcom/bytedance/trae/utils/logger/ILogger;
    if-nez v0, +006h
    invoke-direct v1, Lcom/bytedance/trae/utils/logger/FLogger;->getSpiImpl()Lcom/bytedance/trae/utils/logger/ILogger;
    move-result-object v0
    return-object v0
.end method

.method private final getSpiImpl()com.bytedance.trae.utils.logger.ILogger
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->spiImpl$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/utils/logger/ILogger;
    return-object v0
.end method

.method private static final spiImpl_delegate$lambda$0()com.bytedance.trae.utils.logger.ILogger
    .registers 2
    # ins_size=0
    const-class v0, Lcom/bytedance/trae/utils/logger/ILogger;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/utils/logger/ILogger;
    invoke-virtual v0, v1, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/utils/logger/ILogger;
    return-object v0
.end method

.method public d(java.lang.String  java.lang.String)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, tag
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Lcom/bytedance/trae/utils/logger/FLogger;->getImpl()Lcom/bytedance/trae/utils/logger/ILogger;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v2, v3, Lcom/bytedance/trae/utils/logger/ILogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public e(java.lang.String  java.lang.String)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, tag
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Lcom/bytedance/trae/utils/logger/FLogger;->getImpl()Lcom/bytedance/trae/utils/logger/ILogger;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v2, v3, Lcom/bytedance/trae/utils/logger/ILogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public e(java.lang.String  java.lang.String  java.lang.Throwable)void
    .registers 5
    # ins_size=4
    const-string/jumbo v0, tag
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Lcom/bytedance/trae/utils/logger/FLogger;->getImpl()Lcom/bytedance/trae/utils/logger/ILogger;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v2, v3, v4, Lcom/bytedance/trae/utils/logger/ILogger;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-void 
.end method

.method public getDirPath()java.lang.String
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/utils/logger/FLogger;->getImpl()Lcom/bytedance/trae/utils/logger/ILogger;
    move-result-object v0
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/utils/logger/ILogger;->getDirPath()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    const-string v0, ""
    return-object v0
.end method

.method public i(java.lang.String  java.lang.String)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, tag
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Lcom/bytedance/trae/utils/logger/FLogger;->getImpl()Lcom/bytedance/trae/utils/logger/ILogger;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v2, v3, Lcom/bytedance/trae/utils/logger/ILogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public isDebug()boolean
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/utils/logger/FLogger;->getImpl()Lcom/bytedance/trae/utils/logger/ILogger;
    move-result-object v0
    if-eqz v0, +007h
    invoke-interface v0, Lcom/bytedance/trae/utils/logger/ILogger;->isDebug()Z
    move-result v0
    goto +2h
    const/4 v0, 0
    return v0
.end method

.method public isInitSuccess()boolean
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/utils/logger/FLogger;->getImpl()Lcom/bytedance/trae/utils/logger/ILogger;
    move-result-object v0
    if-eqz v0, +007h
    invoke-interface v0, Lcom/bytedance/trae/utils/logger/ILogger;->isInitSuccess()Z
    move-result v0
    goto +2h
    const/4 v0, 0
    return v0
.end method

.method public perfSceneTraceStart(java.lang.String  java.lang.String  java.lang.String)void
    .registers 5
    # ins_size=4
    const-string/jumbo v0, tag
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Lcom/bytedance/trae/utils/logger/FLogger;->getImpl()Lcom/bytedance/trae/utils/logger/ILogger;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v2, v3, v4, Lcom/bytedance/trae/utils/logger/ILogger;->perfSceneTraceStart(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public perfTSceneTraceEnd(java.lang.String  java.lang.String  java.lang.String)void
    .registers 5
    # ins_size=4
    const-string/jumbo v0, tag
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Lcom/bytedance/trae/utils/logger/FLogger;->getImpl()Lcom/bytedance/trae/utils/logger/ILogger;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v2, v3, v4, Lcom/bytedance/trae/utils/logger/ILogger;->perfTSceneTraceEnd(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public perfTraceLog(java.lang.String  java.lang.String)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, tag
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Lcom/bytedance/trae/utils/logger/FLogger;->getImpl()Lcom/bytedance/trae/utils/logger/ILogger;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v2, v3, Lcom/bytedance/trae/utils/logger/ILogger;->perfTraceLog(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public final setLogger(com.bytedance.trae.utils.logger.ILogger)void
    .registers 2
    # ins_size=2
    sput-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->impl Lcom/bytedance/trae/utils/logger/ILogger;
    return-void 
.end method

.method public uploadALog(java.lang.String  long  long  kotlin.jvm.functions.Function1)void
    .registers 15
    # ins_size=7
    const-string/jumbo v0, scene
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v8, Lcom/bytedance/trae/utils/logger/FLogger;->getImpl()Lcom/bytedance/trae/utils/logger/ILogger;
    move-result-object v1
    if-eqz v1, +009h
    move-object v2, v9
    move-wide v3, v10
    move-wide v5, v12
    move-object v7, v14
    invoke-interface/range v1 ... v7, Lcom/bytedance/trae/utils/logger/ILogger;->uploadALog(Ljava/lang/String; J J Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method

.method public uploadAllLog(java.lang.String  kotlin.jvm.functions.Function1)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, scene
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Lcom/bytedance/trae/utils/logger/FLogger;->getImpl()Lcom/bytedance/trae/utils/logger/ILogger;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v2, v3, Lcom/bytedance/trae/utils/logger/ILogger;->uploadAllLog(Ljava/lang/String; Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method

.method public uploadAllLogV2(java.lang.String  kotlin.jvm.functions.Function3)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, scene
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Lcom/bytedance/trae/utils/logger/FLogger;->getImpl()Lcom/bytedance/trae/utils/logger/ILogger;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v2, v3, Lcom/bytedance/trae/utils/logger/ILogger;->uploadAllLogV2(Ljava/lang/String; Lkotlin/jvm/functions/Function3;)V
    return-void 
.end method

.method public v(java.lang.String  java.lang.String)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, tag
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Lcom/bytedance/trae/utils/logger/FLogger;->getImpl()Lcom/bytedance/trae/utils/logger/ILogger;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v2, v3, Lcom/bytedance/trae/utils/logger/ILogger;->v(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public w(java.lang.String  java.lang.String)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, tag
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Lcom/bytedance/trae/utils/logger/FLogger;->getImpl()Lcom/bytedance/trae/utils/logger/ILogger;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v2, v3, Lcom/bytedance/trae/utils/logger/ILogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public w(java.lang.String  java.lang.String  java.lang.Throwable)void
    .registers 5
    # ins_size=4
    const-string/jumbo v0, tag
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Lcom/bytedance/trae/utils/logger/FLogger;->getImpl()Lcom/bytedance/trae/utils/logger/ILogger;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v2, v3, v4, Lcom/bytedance/trae/utils/logger/ILogger;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-void 
.end method

.method public w(java.lang.String  java.lang.Throwable)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, tag
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Lcom/bytedance/trae/utils/logger/FLogger;->getImpl()Lcom/bytedance/trae/utils/logger/ILogger;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v2, v3, Lcom/bytedance/trae/utils/logger/ILogger;->w(Ljava/lang/String; Ljava/lang/Throwable;)V
    return-void 
.end method
