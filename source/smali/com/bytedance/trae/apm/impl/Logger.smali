# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/apm/impl/Logger;
.super Ljava/lang/Object;
.source "LoggerImpl.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/apm/impl/Logger;
.field private static final TAG:Ljava/lang/String;
.field private static debug:Z
.field private static bridge inited:Z
.field private static final pendingLogs:Ljava/util/List;


.method public static synthetic $r8$lambda$HNG4CYVIRwrVX0pz18OEO27ZWQQ()void
    .registers 0
    # ins_size=0
    invoke-static Lcom/bytedance/trae/apm/impl/Logger;->initAlog$lambda$2()V
    return-void 
.end method

.method public static synthetic $r8$lambda$S6EzN7E-cLseyOesH6vM-5cY5cs(kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function3  boolean  org.json.JSONObject)void
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/apm/impl/Logger;->uploadALogInternal$lambda$8(Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function3; Z Lorg/json/JSONObject;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$sgFSyVuqCP_kQYF3JASp4XSt3jI(kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function3)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/apm/impl/Logger;->uploadALogInternal$lambda$4(Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function3;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/apm/impl/Logger;
    invoke-direct v0, Lcom/bytedance/trae/apm/impl/Logger;-><init>()V
    sput-object v0, Lcom/bytedance/trae/apm/impl/Logger;->INSTANCE Lcom/bytedance/trae/apm/impl/Logger;
    const/4 v0, 1
    sput-boolean v0, Lcom/bytedance/trae/apm/impl/Logger;->debug Z
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/List;
    sput-object v0, Lcom/bytedance/trae/apm/impl/Logger;->pendingLogs Ljava/util/List;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final addLogToPendingList(int  java.lang.String  java.lang.String  java.lang.Throwable)void
    .registers 16
    # ins_size=5
    sget-object v0, Lcom/bytedance/trae/apm/impl/Logger;->pendingLogs Ljava/util/List;
    monitor-enter v0
    new-instance v10, Lcom/bytedance/trae/apm/impl/Logger$LogInfo;
    const-wide/16 v6, 0
    const/16 v8, 16
    const/4 v9, 0
    move-object v1, v10
    move v2, v12
    move-object v3, v13
    move-object v4, v14
    move-object v5, v15
    invoke-direct/range v1 ... v9, Lcom/bytedance/trae/apm/impl/Logger$LogInfo;-><init>(I Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable; J I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v10, Ljava/util/List;->add(Ljava/lang/Object;)Z
    monitor-exit v0
    return-void 
    move-exception v12
    monitor-exit v0
    throw v12
    :try_start_0x3
.end method

.method private final initAlog(boolean  int  int  android.content.Context)void
    .registers 6
    # ins_size=5
    new-instance v0, Lcom/ss/android/agilelogger/ALogConfig$Builder;
    invoke-direct v0, v5, Lcom/ss/android/agilelogger/ALogConfig$Builder;-><init>(Landroid/content/Context;)V
    mul-int/lit16 v4, v4, 1024
    mul-int/lit16 v4, v4, 1024
    invoke-virtual v0, v4, Lcom/ss/android/agilelogger/ALogConfig$Builder;->setMaxDirSize(I)Lcom/ss/android/agilelogger/ALogConfig$Builder;
    move-result-object v4
    const/high16 v5, 2097152
    invoke-virtual v4, v5, Lcom/ss/android/agilelogger/ALogConfig$Builder;->setPerSize(I)Lcom/ss/android/agilelogger/ALogConfig$Builder;
    move-result-object v4
    const/4 v5, 1
    invoke-virtual v4, v5, Lcom/ss/android/agilelogger/ALogConfig$Builder;->setOffloadMainThreadWrite(Z)Lcom/ss/android/agilelogger/ALogConfig$Builder;
    move-result-object v4
    invoke-virtual v4, v5, Lcom/ss/android/agilelogger/ALogConfig$Builder;->setEnableOffloadInAllProcess(Z)Lcom/ss/android/agilelogger/ALogConfig$Builder;
    move-result-object v4
    invoke-virtual v4, v5, Lcom/ss/android/agilelogger/ALogConfig$Builder;->setNewThreadPoolImplementation(Z)Lcom/ss/android/agilelogger/ALogConfig$Builder;
    move-result-object v4
    invoke-virtual v4, Lcom/ss/android/agilelogger/ALogConfig$Builder;->build()Lcom/ss/android/agilelogger/ALogConfig;
    move-result-object v4
    invoke-static v4, Lcom/ss/android/agilelogger/ALog;->init(Lcom/ss/android/agilelogger/ALogConfig;)Z
    invoke-static v2, Lcom/ss/android/agilelogger/ALog;->setDebug(Z)V
    invoke-static v3, Lcom/ss/android/agilelogger/ALog;->changeLevel(I)V
    sget-object v3, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v3
    if-nez v3, +02eh
    new-instance v3, Lcom/bytedance/trae/apm/impl/Logger$initAlog$1;
    invoke-direct v3, Lcom/bytedance/trae/apm/impl/Logger$initAlog$1;-><init>()V
    check-cast v3, Lcom/monitor/cloudmessage/callback/IAlogConsumer;
    invoke-static v3, Lcom/monitor/cloudmessage/CloudMessageManager;->setAlogConsumerSafely(Lcom/monitor/cloudmessage/callback/IAlogConsumer;)V
    invoke-static Lcom/ss/android/agilelogger/ALog;->isInitSuccess()Z
    move-result v3
    if-eqz v3, +01eh
    const-string v3, "Logger"
    const-string v4, "alog enableALogCollector"
    invoke-static v3, v4, Lcom/ss/android/agilelogger/ALog;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v3, Lcom/ss/android/agilelogger/ALog;->sConfig Lcom/ss/android/agilelogger/ALogConfig;
    invoke-virtual v3, Lcom/ss/android/agilelogger/ALogConfig;->getLogDirPath()Ljava/lang/String;
    move-result-object v3
    new-instance v4, Lcom/bytedance/trae/apm/impl/Logger$$ExternalSyntheticLambda0;
    invoke-direct v4, Lcom/bytedance/trae/apm/impl/Logger$$ExternalSyntheticLambda0;-><init>()V
    new-instance v5, Lcom/bytedance/crash/alog/DefaultAlogUploadStrategy;
    invoke-direct v5, Lcom/bytedance/crash/alog/DefaultAlogUploadStrategy;-><init>()V
    check-cast v5, Lcom/bytedance/crash/alog/IAlogUploadStrategy;
    invoke-static v3, v4, v5, Lcom/bytedance/crash/Npth;->enableALogCollector(Ljava/lang/String; Lcom/bytedance/crash/alog/IALogCrashObserver; Lcom/bytedance/crash/alog/IAlogUploadStrategy;)V
    sget-object v3, Lcom/bytedance/trae/apm/impl/ALogServiceImpl;->Companion Lcom/bytedance/trae/apm/impl/ALogServiceImpl$Companion;
    invoke-virtual v3, v2, Lcom/bytedance/trae/apm/impl/ALogServiceImpl$Companion;->initService(Z)V
    return-void 
.end method

.method private static final initAlog$lambda$2()void
    .registers 2
    # ins_size=0
    const-string v0, "Logger"
    const-string v1, "app happen crash, upload alog"
    invoke-static v0, v1, Lcom/ss/android/agilelogger/ALog;->e(Ljava/lang/String; Ljava/lang/String;)V
    invoke-static Lcom/ss/android/agilelogger/ALog;->asyncFlush()V
    return-void 
.end method

.method private final submitPendingLogs()void
    .registers 8
    # ins_size=1
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/List;
    sget-object v1, Lcom/bytedance/trae/apm/impl/Logger;->pendingLogs Ljava/util/List;
    monitor-enter v1
    move-object v2, v1
    check-cast v2, Ljava/util/Collection;
    invoke-interface v0, v2, Ljava/util/List;->addAll(Ljava/util/Collection;)Z
    invoke-interface v1, Ljava/util/List;->clear()V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    monitor-exit v1
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +08bh
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/apm/impl/Logger$LogInfo;
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v1, Lcom/bytedance/trae/apm/impl/Logger$LogInfo;->getMessage()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", <pending:"
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v3
    invoke-virtual v1, Lcom/bytedance/trae/apm/impl/Logger$LogInfo;->getMillis()J
    move-result-wide v5
    sub-long/2addr v3, v5
    invoke-virtual v2, v3, v4, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, "ms>"
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, Lcom/bytedance/trae/apm/impl/Logger$LogInfo;->getLevel()I
    move-result v3
    const/4 v4, 2
    if-eq v3, v4, +049h
    const/4 v4, 3
    if-eq v3, v4, +03bh
    const/4 v4, 4
    if-eq v3, v4, +02eh
    const/4 v4, 5
    if-eq v3, v4, +01dh
    const/4 v4, 6
    if-ne v3, v4, +010h
    sget-object v3, Lcom/bytedance/trae/apm/impl/Logger;->INSTANCE Lcom/bytedance/trae/apm/impl/Logger;
    invoke-virtual v1, Lcom/bytedance/trae/apm/impl/Logger$LogInfo;->getTag()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v1, Lcom/bytedance/trae/apm/impl/Logger$LogInfo;->getTh()Ljava/lang/Throwable;
    move-result-object v1
    invoke-virtual v3, v4, v2, v1, Lcom/bytedance/trae/apm/impl/Logger;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    goto -56h
    new-instance v0, Ljava/lang/IllegalArgumentException;
    invoke-virtual v1, Lcom/bytedance/trae/apm/impl/Logger$LogInfo;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-direct v0, v1, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V
    throw v0
    sget-object v3, Lcom/bytedance/trae/apm/impl/Logger;->INSTANCE Lcom/bytedance/trae/apm/impl/Logger;
    invoke-virtual v1, Lcom/bytedance/trae/apm/impl/Logger$LogInfo;->getTag()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v1, Lcom/bytedance/trae/apm/impl/Logger$LogInfo;->getTh()Ljava/lang/Throwable;
    move-result-object v1
    invoke-virtual v3, v4, v2, v1, Lcom/bytedance/trae/apm/impl/Logger;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    goto -6eh
    sget-object v3, Lcom/bytedance/trae/apm/impl/Logger;->INSTANCE Lcom/bytedance/trae/apm/impl/Logger;
    invoke-virtual v1, Lcom/bytedance/trae/apm/impl/Logger$LogInfo;->getTag()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v3, v1, v2, Lcom/bytedance/trae/apm/impl/Logger;->i(Ljava/lang/String; Ljava/lang/String;)V
    goto -78h
    sget-object v3, Lcom/bytedance/trae/apm/impl/Logger;->INSTANCE Lcom/bytedance/trae/apm/impl/Logger;
    invoke-virtual v1, Lcom/bytedance/trae/apm/impl/Logger$LogInfo;->getTag()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v3, v1, v2, Lcom/bytedance/trae/apm/impl/Logger;->d(Ljava/lang/String; Ljava/lang/String;)V
    goto/16 -082h
    sget-object v3, Lcom/bytedance/trae/apm/impl/Logger;->INSTANCE Lcom/bytedance/trae/apm/impl/Logger;
    invoke-virtual v1, Lcom/bytedance/trae/apm/impl/Logger$LogInfo;->getTag()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v3, v1, v2, Lcom/bytedance/trae/apm/impl/Logger;->v(Ljava/lang/String; Ljava/lang/String;)V
    goto/16 -08dh
    return-void 
    move-exception v0
    monitor-exit v1
    throw v0
    :try_start_0xa
.end method

.method private final uploadALogInternal(java.lang.String  long  long  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function3)void
    .registers 21
    # ins_size=8
    move-object/from16 v0, v19
    move-object/from16 v1, v20
    const-string/jumbo v2, uploadALogInternal: called
    const-string v3, "Logger"
    invoke-static v3, v2, Landroid/util/Log;->i(Ljava/lang/String; Ljava/lang/String;)I
    new-instance v2, Ljava/lang/StringBuilder;
    const-string/jumbo v4, uploadALogInternal: scene = 
    invoke-direct v2, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    move-object v4, v14
    invoke-virtual v2, v14, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v5, ", startTime = "
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    move-wide v6, v15
    invoke-virtual v2, v6, v7, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v5, ", endTime = "
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    move-wide/from16 v8, v17
    invoke-virtual v2, v8, v9, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-static v3, v2, Landroid/util/Log;->i(Ljava/lang/String; Ljava/lang/String;)I
    sget-object v2, Lcom/ss/android/agilelogger/ALog;->sConfig Lcom/ss/android/agilelogger/ALogConfig;
    if-eqz v2, +028h
    sget-object v2, Lcom/ss/android/agilelogger/ALog;->sConfig Lcom/ss/android/agilelogger/ALogConfig;
    invoke-virtual v2, Lcom/ss/android/agilelogger/ALogConfig;->getLogDirPath()Ljava/lang/String;
    move-result-object v2
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z
    move-result v2
    if-nez v2, +01ah
    sget-object v2, Lcom/ss/android/agilelogger/ALog;->sConfig Lcom/ss/android/agilelogger/ALogConfig;
    invoke-virtual v2, Lcom/ss/android/agilelogger/ALogConfig;->getLogDirPath()Ljava/lang/String;
    move-result-object v5
    new-instance v11, Lcom/bytedance/trae/apm/impl/Logger$$ExternalSyntheticLambda1;
    invoke-direct v11, v0, v1, Lcom/bytedance/trae/apm/impl/Logger$$ExternalSyntheticLambda1;-><init>(Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function3;)V
    new-instance v12, Lcom/bytedance/trae/apm/impl/Logger$$ExternalSyntheticLambda2;
    invoke-direct v12, v0, v1, Lcom/bytedance/trae/apm/impl/Logger$$ExternalSyntheticLambda2;-><init>(Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function3;)V
    move-wide v6, v15
    move-wide/from16 v8, v17
    move-object v10, v14
    invoke-static/range v5 ... v12, Lcom/bytedance/apm/ApmAgent;->activeUploadAlog(Ljava/lang/String; J J Ljava/lang/String; Lcom/bytedance/apm/alog/IALogActiveUploadObserver; Lcom/bytedance/apm/alog/IALogActiveUploadCallback;)V
    goto +58h
    sget-object v2, Lcom/ss/android/agilelogger/ALog;->sConfig Lcom/ss/android/agilelogger/ALogConfig;
    const/4 v4, 0
    if-nez v2, +01dh
    if-eqz v0, +009h
    invoke-static v4, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v2
    invoke-interface v0, v2, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    if-eqz v1, +00fh
    invoke-static v4, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v0
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v2
    const-string v4, "log config is null"
    invoke-interface v1, v0, v2, v4, Lkotlin/jvm/functions/Function3;->invoke(Ljava/lang/Object; Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const-string v0, "ALog.sConfig is null"
    goto +1ch
    if-eqz v0, +009h
    invoke-static v4, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v2
    invoke-interface v0, v2, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    if-eqz v1, +010h
    invoke-static v4, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v0
    const/4 v2, 4
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v2
    const-string v4, "log file is null"
    invoke-interface v1, v0, v2, v4, Lkotlin/jvm/functions/Function3;->invoke(Ljava/lang/Object; Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const-string v0, "Alog logDirPath is empty!"
    const-string v1, "[uploadAlogInternal] Error : "
    invoke-virtual v1, v0, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    new-instance v1, Ljava/lang/StringBuilder;
    const-string/jumbo v2, uploadALogInternal: failed, 
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-static v3, v1, Landroid/util/Log;->i(Ljava/lang/String; Ljava/lang/String;)I
    invoke-static v3, v0, Landroid/util/Log;->w(Ljava/lang/String; Ljava/lang/String;)I
    return-void 
.end method

.method private static final uploadALogInternal$lambda$4(kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function3)void
    .registers 5
    # ins_size=2
    invoke-static Lcom/ss/android/agilelogger/ALog;->asyncFlush()V
    const-wide/16 v0, 1000
    invoke-static v0, v1, Ljava/lang/Thread;->sleep(J)V
    goto +24h
    move-exception v0
    const-string v1, "[uploadAlogInternal] Error in flush Alog to file!"
    check-cast v0, Ljava/lang/Throwable;
    const-string v2, "Logger"
    invoke-static v2, v1, v0, Landroid/util/Log;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)I
    const/4 v0, 0
    if-eqz v3, +009h
    invoke-static v0, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v1
    invoke-interface v3, v1, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    if-eqz v4, +00fh
    invoke-static v0, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v3
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string v1, ""
    invoke-interface v4, v3, v0, v1, Lkotlin/jvm/functions/Function3;->invoke(Ljava/lang/Object; Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
    :try_start_0x0
.end method

.method private static final uploadALogInternal$lambda$8(kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function3  boolean  org.json.JSONObject)void
    .registers 12
    # ins_size=4
    new-instance v0, Ljava/lang/StringBuilder;
    const-string/jumbo v1, uploadALogInternal: onCallback called, success = 
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v10, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", ret = "
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    const-string v1, "Logger"
    invoke-static v1, v0, Landroid/util/Log;->w(Ljava/lang/String; Ljava/lang/String;)I
    const/4 v0, -1
    const/4 v2, 1
    invoke-static v2, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v3
    const/4 v4, 0
    invoke-static v4, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v5
    if-eqz v10, +077h
    new-instance v10, Ljava/io/File;
    sget-object v11, Lcom/ss/android/agilelogger/ALog;->sConfig Lcom/ss/android/agilelogger/ALogConfig;
    invoke-virtual v11, Lcom/ss/android/agilelogger/ALogConfig;->getLogDirPath()Ljava/lang/String;
    move-result-object v11
    invoke-direct v10, v11, Ljava/io/File;-><init>(Ljava/lang/String;)V
    invoke-virtual v10, Ljava/io/File;->exists()Z
    move-result v11
    if-eqz v11, +00ah
    invoke-virtual v10, Ljava/io/File;->listFiles()[Ljava/io/File;
    move-result-object v11
    if-eqz v11, +004h
    move v11, v2
    goto +2h
    move v11, v4
    if-eqz v11, +003h
    goto +2h
    const/4 v10, 0
    if-eqz v10, +046h
    invoke-virtual v10, Ljava/io/File;->listFiles()[Ljava/io/File;
    move-result-object v10
    if-eqz v10, +040h
    new-instance v11, Ljava/util/ArrayList;
    invoke-direct v11, Ljava/util/ArrayList;-><init>()V
    check-cast v11, Ljava/util/Collection;
    array-length v1, v10
    move v5, v4
    if-ge v5, v1, +01bh
    aget-object v6, v10, v5
    invoke-virtual v6, Ljava/io/File;->exists()Z
    move-result v7
    if-eqz v7, +00ah
    invoke-virtual v6, Ljava/io/File;->isFile()Z
    move-result v7
    if-eqz v7, +004h
    move v7, v2
    goto +2h
    move v7, v4
    if-eqz v7, +005h
    invoke-interface v11, v6, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    add-int/lit8 v5, v5, 1
    goto -1ah
    check-cast v11, Ljava/util/List;
    check-cast v11, Ljava/lang/Iterable;
    invoke-interface v11, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v10
    invoke-interface v10, Ljava/util/Iterator;->hasNext()Z
    move-result v11
    if-eqz v11, +00eh
    invoke-interface v10, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v11
    check-cast v11, Ljava/io/File;
    if-eqz v11, -00ch
    invoke-virtual v11, Ljava/io/File;->delete()Z
    goto -11h
    if-eqz v8, +005h
    invoke-interface v8, v3, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    if-eqz v9, +065h
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v8
    const-string v10, ""
    invoke-interface v9, v3, v8, v10, Lkotlin/jvm/functions/Function3;->invoke(Ljava/lang/Object; Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    goto +5ah
    if-eqz v11, +043h
    new-instance v10, Ljava/lang/StringBuilder;
    const-string/jumbo v3, uploadALogInternal: ret = 
    invoke-direct v10, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v10
    invoke-static v1, v10, Landroid/util/Log;->i(Ljava/lang/String; Ljava/lang/String;)I
    const-string v10, "code"
    invoke-virtual v11, v10, v4, Lorg/json/JSONObject;->optInt(Ljava/lang/String; I)I
    move-result v10
    if-eq v10, v0, +007h
    const/4 v0, 5
    if-ne v10, v0, +003h
    goto +2h
    move v2, v4
    if-eqz v8, +009h
    invoke-static v2, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v0
    invoke-interface v8, v0, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    if-eqz v9, +02eh
    invoke-static v2, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v8
    invoke-static v10, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v10
    invoke-virtual v11, Lorg/json/JSONObject;->toString()Ljava/lang/String;
    move-result-object v11
    const-string/jumbo v0, toString(...)
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v9, v8, v10, v11, Lkotlin/jvm/functions/Function3;->invoke(Ljava/lang/Object; Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    goto +17h
    const-string/jumbo v10, uploadALogInternal: ret = null
    invoke-static v1, v10, Landroid/util/Log;->i(Ljava/lang/String; Ljava/lang/String;)I
    if-eqz v8, +005h
    invoke-interface v8, v5, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    if-eqz v9, +00bh
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v8
    const-string v10, "log config is null"
    invoke-interface v9, v5, v8, v10, Lkotlin/jvm/functions/Function3;->invoke(Ljava/lang/Object; Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method public static synthetic uploadAllLog$default(com.bytedance.trae.apm.impl.Logger  java.lang.String  kotlin.jvm.functions.Function1  int  java.lang.Object)void
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +003h
    const/4 v2, 0
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/apm/impl/Logger;->uploadAllLog(Ljava/lang/String; Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method

.method public final d(java.lang.String  java.lang.String)void
    .registers 5
    # ins_size=3
    const-string/jumbo v0, tag
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-boolean v0, Lcom/bytedance/trae/apm/impl/Logger;->inited Z
    if-nez v0, +008h
    const/4 v0, 3
    const/4 v1, 0
    invoke-direct v2, v0, v3, v4, v1, Lcom/bytedance/trae/apm/impl/Logger;->addLogToPendingList(I Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-void 
    if-nez v4, +004h
    const-string v4, ""
    invoke-static v3, v4, Lcom/ss/android/agilelogger/ALog;->d(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public final e(java.lang.String  java.lang.String)void
    .registers 5
    # ins_size=3
    const-string/jumbo v0, tag
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-boolean v0, Lcom/bytedance/trae/apm/impl/Logger;->inited Z
    if-nez v0, +008h
    const/4 v0, 6
    const/4 v1, 0
    invoke-direct v2, v0, v3, v4, v1, Lcom/bytedance/trae/apm/impl/Logger;->addLogToPendingList(I Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-void 
    if-nez v4, +004h
    const-string v4, ""
    invoke-static v3, v4, Lcom/ss/android/agilelogger/ALog;->e(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public final e(java.lang.String  java.lang.String  java.lang.Throwable)void
    .registers 5
    # ins_size=4
    const-string/jumbo v0, tag
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-boolean v0, Lcom/bytedance/trae/apm/impl/Logger;->inited Z
    if-nez v0, +007h
    const/4 v0, 6
    invoke-direct v1, v0, v2, v3, v4, Lcom/bytedance/trae/apm/impl/Logger;->addLogToPendingList(I Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-void 
    if-nez v3, +004h
    const-string v3, ""
    invoke-static v2, v3, v4, Lcom/ss/android/agilelogger/ALog;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-void 
.end method

.method public final getDirPath()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/ss/android/agilelogger/ALog;->sConfig Lcom/ss/android/agilelogger/ALogConfig;
    if-eqz v0, +008h
    invoke-virtual v0, Lcom/ss/android/agilelogger/ALogConfig;->getLogDirPath()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    const-string v0, ""
    return-object v0
.end method

.method public final i(java.lang.String  java.lang.String)void
    .registers 5
    # ins_size=3
    const-string/jumbo v0, tag
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-boolean v0, Lcom/bytedance/trae/apm/impl/Logger;->inited Z
    if-nez v0, +008h
    const/4 v0, 4
    const/4 v1, 0
    invoke-direct v2, v0, v3, v4, v1, Lcom/bytedance/trae/apm/impl/Logger;->addLogToPendingList(I Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-void 
    if-nez v4, +004h
    const-string v4, ""
    invoke-static v3, v4, Lcom/ss/android/agilelogger/ALog;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public final initLogAndALog(boolean  int  android.content.Context)void
    .registers 5
    # ins_size=4
    const-string v0, "context"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sput-boolean v2, Lcom/bytedance/trae/apm/impl/Logger;->debug Z
    const/4 v0, 3
    invoke-direct v1, v2, v0, v3, v4, Lcom/bytedance/trae/apm/impl/Logger;->initAlog(Z I I Landroid/content/Context;)V
    const/4 v2, 1
    sput-boolean v2, Lcom/bytedance/trae/apm/impl/Logger;->inited Z
    invoke-direct v1, Lcom/bytedance/trae/apm/impl/Logger;->submitPendingLogs()V
    return-void 
.end method

.method public final isDebug()boolean
    .registers 2
    # ins_size=1
    sget-boolean v0, Lcom/bytedance/trae/apm/impl/Logger;->debug Z
    return v0
.end method

.method public final isInitSuccess()boolean
    .registers 2
    # ins_size=1
    invoke-static Lcom/ss/android/agilelogger/ALog;->isInitSuccess()Z
    move-result v0
    return v0
.end method

.method public final uploadALog(java.lang.String  long  long  kotlin.jvm.functions.Function1)void
    .registers 16
    # ins_size=7
    const-string/jumbo v0, scene
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v8, 0
    move-object v1, v9
    move-object v2, v10
    move-wide v3, v11
    move-wide v5, v13
    move-object v7, v15
    invoke-direct/range v1 ... v8, Lcom/bytedance/trae/apm/impl/Logger;->uploadALogInternal(Ljava/lang/String; J J Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function3;)V
    return-void 
.end method

.method public final uploadAllLog(java.lang.String  kotlin.jvm.functions.Function1)void
    .registers 12
    # ins_size=3
    const-string/jumbo v0, scene
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "Logger"
    const-string/jumbo v1, uploadALogData: called
    invoke-virtual v9, v0, v1, Lcom/bytedance/trae/apm/impl/Logger;->d(Ljava/lang/String; Ljava/lang/String;)V
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v0
    const/16 v3, 1000
    int-to-long v3, v3
    div-long/2addr v0, v3
    const/16 v5, 10800
    int-to-long v5, v5
    sub-long v5, v0, v5
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v0
    div-long v7, v0, v3
    const/4 v0, 0
    move-object v1, v9
    move-object v2, v10
    move-wide v3, v5
    move-wide v5, v7
    move-object v7, v11
    move-object v8, v0
    invoke-direct/range v1 ... v8, Lcom/bytedance/trae/apm/impl/Logger;->uploadALogInternal(Ljava/lang/String; J J Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function3;)V
    return-void 
.end method

.method public final uploadAllLogV2(java.lang.String  kotlin.jvm.functions.Function3)void
    .registers 12
    # ins_size=3
    const-string/jumbo v0, scene
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "Logger"
    const-string/jumbo v1, uploadALogData: called
    invoke-virtual v9, v0, v1, Lcom/bytedance/trae/apm/impl/Logger;->d(Ljava/lang/String; Ljava/lang/String;)V
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v0
    const/16 v3, 1000
    int-to-long v3, v3
    div-long/2addr v0, v3
    const/16 v5, 10800
    int-to-long v5, v5
    sub-long v5, v0, v5
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v0
    div-long v7, v0, v3
    const/4 v0, 0
    move-object v1, v9
    move-object v2, v10
    move-wide v3, v5
    move-wide v5, v7
    move-object v7, v0
    move-object v8, v11
    invoke-direct/range v1 ... v8, Lcom/bytedance/trae/apm/impl/Logger;->uploadALogInternal(Ljava/lang/String; J J Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function3;)V
    return-void 
.end method

.method public final v(java.lang.String  java.lang.String)void
    .registers 5
    # ins_size=3
    const-string/jumbo v0, tag
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-boolean v0, Lcom/bytedance/trae/apm/impl/Logger;->inited Z
    if-nez v0, +008h
    const/4 v0, 2
    const/4 v1, 0
    invoke-direct v2, v0, v3, v4, v1, Lcom/bytedance/trae/apm/impl/Logger;->addLogToPendingList(I Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-void 
    if-nez v4, +004h
    const-string v4, ""
    invoke-static v3, v4, Lcom/ss/android/agilelogger/ALog;->v(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public final w(java.lang.String  java.lang.String)void
    .registers 5
    # ins_size=3
    const-string/jumbo v0, tag
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-boolean v0, Lcom/bytedance/trae/apm/impl/Logger;->inited Z
    if-nez v0, +008h
    const/4 v0, 5
    const/4 v1, 0
    invoke-direct v2, v0, v3, v4, v1, Lcom/bytedance/trae/apm/impl/Logger;->addLogToPendingList(I Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-void 
    if-nez v4, +004h
    const-string v4, ""
    invoke-static v3, v4, Lcom/ss/android/agilelogger/ALog;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public final w(java.lang.String  java.lang.String  java.lang.Throwable)void
    .registers 5
    # ins_size=4
    const-string/jumbo v0, tag
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-boolean v0, Lcom/bytedance/trae/apm/impl/Logger;->inited Z
    if-nez v0, +007h
    const/4 v0, 5
    invoke-direct v1, v0, v2, v3, v4, Lcom/bytedance/trae/apm/impl/Logger;->addLogToPendingList(I Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-void 
    if-nez v3, +004h
    const-string v3, ""
    invoke-static v2, v3, v4, Lcom/ss/android/agilelogger/ALog;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-void 
.end method

.method public final w(java.lang.String  java.lang.Throwable)void
    .registers 5
    # ins_size=3
    const-string/jumbo v0, tag
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-boolean v0, Lcom/bytedance/trae/apm/impl/Logger;->inited Z
    if-nez v0, +008h
    const/4 v0, 5
    const/4 v1, 0
    invoke-direct v2, v0, v3, v1, v4, Lcom/bytedance/trae/apm/impl/Logger;->addLogToPendingList(I Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-void 
    const-string v0, ""
    invoke-static v3, v0, v4, Lcom/ss/android/agilelogger/ALog;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-void 
.end method
