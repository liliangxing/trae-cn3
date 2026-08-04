# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/applog/api/AppLogConfigInfo;
.super Ljava/lang/Object;
.source "AppLogConfigInfo.kt"

.field private final appId:I
.field private final appName:Ljava/lang/String;
.field private final channel:Ljava/lang/String;
.field private final defaultColdStartReportDelay:J
.field private final defaultReportInterval:J
.field private final defaultSentryColdStartSamplingRate:I
.field private final defaultSentryEnabled:Z
.field private final filterEnable:Z
.field private final isBoe:Z
.field private final newMonitorEnabled:Z
.field private final newMonitorInDebugMode:Z
.field private final packByLengthEnabled:Z
.field private final packMultiQueryEnabled:Z
.field private final realtimeEventOptEnabled:Z
.field private final samplingEnable:Z
.field private final updateVersionCode:I
.field private final versionCode:I
.field private final versionName:Ljava/lang/String;


.method public constructor <init>(int  java.lang.String  int  java.lang.String  int  java.lang.String  boolean  boolean  boolean  boolean  boolean  boolean  int  long  long  boolean  boolean  boolean)void
    .registers 26
    # ins_size=21
    move-object v0, v5
    move-object v1, v7
    move-object v2, v9
    move-object v3, v11
    const-string v4, "appName"
    invoke-static v7, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v4, versionName
    invoke-static v9, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v4, "channel"
    invoke-static v11, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v5, Ljava/lang/Object;-><init>()V
    move v4, v6
    iput v4, v0, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->appId I
    iput-object v1, v0, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->appName Ljava/lang/String;
    move v1, v8
    iput v1, v0, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->versionCode I
    iput-object v2, v0, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->versionName Ljava/lang/String;
    move v1, v10
    iput v1, v0, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->updateVersionCode I
    iput-object v3, v0, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->channel Ljava/lang/String;
    move v1, v12
    iput-boolean v1, v0, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->isBoe Z
    move v1, v13
    iput-boolean v1, v0, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->filterEnable Z
    move v1, v14
    iput-boolean v1, v0, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->samplingEnable Z
    move v1, v15
    iput-boolean v1, v0, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->newMonitorEnabled Z
    move/from16 v1, v16
    iput-boolean v1, v0, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->newMonitorInDebugMode Z
    move/from16 v1, v17
    iput-boolean v1, v0, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->defaultSentryEnabled Z
    move/from16 v1, v18
    iput v1, v0, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->defaultSentryColdStartSamplingRate I
    move-wide/from16 v1, v19
    iput-wide v1, v0, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->defaultColdStartReportDelay J
    move-wide/from16 v1, v21
    iput-wide v1, v0, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->defaultReportInterval J
    move/from16 v1, v23
    iput-boolean v1, v0, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->packByLengthEnabled Z
    move/from16 v1, v24
    iput-boolean v1, v0, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->realtimeEventOptEnabled Z
    move/from16 v1, v25
    iput-boolean v1, v0, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->packMultiQueryEnabled Z
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.applog.api.AppLogConfigInfo  int  java.lang.String  int  java.lang.String  int  java.lang.String  boolean  boolean  boolean  boolean  boolean  boolean  int  long  long  boolean  boolean  boolean  int  java.lang.Object)com.bytedance.trae.applog.api.AppLogConfigInfo
    .registers 40
    # ins_size=23
    move-object/from16 v0, v17
    move/from16 v1, v38
    and-int/lit8 v2, v1, 1
    if-eqz v2, +005h
    iget v2, v0, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->appId I
    goto +3h
    move/from16 v2, v18
    and-int/lit8 v3, v1, 2
    if-eqz v3, +005h
    iget-object v3, v0, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->appName Ljava/lang/String;
    goto +3h
    move-object/from16 v3, v19
    and-int/lit8 v4, v1, 4
    if-eqz v4, +005h
    iget v4, v0, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->versionCode I
    goto +3h
    move/from16 v4, v20
    and-int/lit8 v5, v1, 8
    if-eqz v5, +005h
    iget-object v5, v0, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->versionName Ljava/lang/String;
    goto +3h
    move-object/from16 v5, v21
    and-int/lit8 v6, v1, 16
    if-eqz v6, +005h
    iget v6, v0, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->updateVersionCode I
    goto +3h
    move/from16 v6, v22
    and-int/lit8 v7, v1, 32
    if-eqz v7, +005h
    iget-object v7, v0, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->channel Ljava/lang/String;
    goto +3h
    move-object/from16 v7, v23
    and-int/lit8 v8, v1, 64
    if-eqz v8, +005h
    iget-boolean v8, v0, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->isBoe Z
    goto +3h
    move/from16 v8, v24
    and-int/lit16 v9, v1, 128
    if-eqz v9, +005h
    iget-boolean v9, v0, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->filterEnable Z
    goto +3h
    move/from16 v9, v25
    and-int/lit16 v10, v1, 256
    if-eqz v10, +005h
    iget-boolean v10, v0, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->samplingEnable Z
    goto +3h
    move/from16 v10, v26
    and-int/lit16 v11, v1, 512
    if-eqz v11, +005h
    iget-boolean v11, v0, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->newMonitorEnabled Z
    goto +3h
    move/from16 v11, v27
    and-int/lit16 v12, v1, 1024
    if-eqz v12, +005h
    iget-boolean v12, v0, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->newMonitorInDebugMode Z
    goto +3h
    move/from16 v12, v28
    and-int/lit16 v13, v1, 2048
    if-eqz v13, +005h
    iget-boolean v13, v0, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->defaultSentryEnabled Z
    goto +3h
    move/from16 v13, v29
    and-int/lit16 v14, v1, 4096
    if-eqz v14, +005h
    iget v14, v0, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->defaultSentryColdStartSamplingRate I
    goto +3h
    move/from16 v14, v30
    and-int/lit16 v15, v1, 8192
    move/from16 v30, v14
    if-eqz v15, +005h
    iget-wide v14, v0, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->defaultColdStartReportDelay J
    goto +3h
    move-wide/from16 v14, v31
    move-wide/from16 v31, v14
    and-int/lit16 v14, v1, 16384
    if-eqz v14, +005h
    iget-wide v14, v0, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->defaultReportInterval J
    goto +3h
    move-wide/from16 v14, v33
    const v16, 32768
    and-int v16, v1, v16
    move-wide/from16 v33, v14
    if-eqz v16, +005h
    iget-boolean v14, v0, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->packByLengthEnabled Z
    goto +3h
    move/from16 v14, v35
    const/high16 v15, 65536
    and-int/2addr v15, v1
    if-eqz v15, +005h
    iget-boolean v15, v0, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->realtimeEventOptEnabled Z
    goto +3h
    move/from16 v15, v36
    const/high16 v16, 131072
    and-int v1, v1, v16
    if-eqz v1, +005h
    iget-boolean v1, v0, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->packMultiQueryEnabled Z
    goto +3h
    move/from16 v1, v37
    move/from16 v18, v2
    move-object/from16 v19, v3
    move/from16 v20, v4
    move-object/from16 v21, v5
    move/from16 v22, v6
    move-object/from16 v23, v7
    move/from16 v24, v8
    move/from16 v25, v9
    move/from16 v26, v10
    move/from16 v27, v11
    move/from16 v28, v12
    move/from16 v29, v13
    move/from16 v35, v14
    move/from16 v36, v15
    move/from16 v37, v1
    invoke-virtual/range v17 ... v37, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->copy(I Ljava/lang/String; I Ljava/lang/String; I Ljava/lang/String; Z Z Z Z Z Z I J J Z Z Z)Lcom/bytedance/trae/applog/api/AppLogConfigInfo;
    move-result-object v0
    return-object v0
.end method

.method public final component1()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->appId I
    return v0
.end method

.method public final component10()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->newMonitorEnabled Z
    return v0
.end method

.method public final component11()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->newMonitorInDebugMode Z
    return v0
.end method

.method public final component12()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->defaultSentryEnabled Z
    return v0
.end method

.method public final component13()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->defaultSentryColdStartSamplingRate I
    return v0
.end method

.method public final component14()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->defaultColdStartReportDelay J
    return-wide v0
.end method

.method public final component15()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->defaultReportInterval J
    return-wide v0
.end method

.method public final component16()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->packByLengthEnabled Z
    return v0
.end method

.method public final component17()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->realtimeEventOptEnabled Z
    return v0
.end method

.method public final component18()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->packMultiQueryEnabled Z
    return v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->appName Ljava/lang/String;
    return-object v0
.end method

.method public final component3()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->versionCode I
    return v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->versionName Ljava/lang/String;
    return-object v0
.end method

.method public final component5()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->updateVersionCode I
    return v0
.end method

.method public final component6()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->channel Ljava/lang/String;
    return-object v0
.end method

.method public final component7()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->isBoe Z
    return v0
.end method

.method public final component8()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->filterEnable Z
    return v0
.end method

.method public final component9()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->samplingEnable Z
    return v0
.end method

.method public final copy(int  java.lang.String  int  java.lang.String  int  java.lang.String  boolean  boolean  boolean  boolean  boolean  boolean  int  long  long  boolean  boolean  boolean)com.bytedance.trae.applog.api.AppLogConfigInfo
    .registers 43
    # ins_size=21
    move/from16 v1, v23
    move-object/from16 v2, v24
    move/from16 v3, v25
    move-object/from16 v4, v26
    move/from16 v5, v27
    move-object/from16 v6, v28
    move/from16 v7, v29
    move/from16 v8, v30
    move/from16 v9, v31
    move/from16 v10, v32
    move/from16 v11, v33
    move/from16 v12, v34
    move/from16 v13, v35
    move-wide/from16 v14, v36
    move-wide/from16 v16, v38
    move/from16 v18, v40
    move/from16 v19, v41
    move/from16 v20, v42
    const-string v0, "appName"
    move-object/from16 v1, v24
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, versionName
    move-object/from16 v1, v26
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "channel"
    move-object/from16 v1, v28
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v21, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;
    move-object/from16 v0, v21
    move/from16 v1, v23
    invoke-direct/range v0 ... v20, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;-><init>(I Ljava/lang/String; I Ljava/lang/String; I Ljava/lang/String; Z Z Z Z Z Z I J J Z Z Z)V
    return-object v21
.end method

.method public equals(java.lang.Object)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 1
    if-ne v7, v8, +003h
    return v0
    instance-of v1, v8, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v8, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;
    iget v1, v7, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->appId I
    iget v3, v8, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->appId I
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->appName Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->appName Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->versionCode I
    iget v3, v8, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->versionCode I
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->versionName Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->versionName Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->updateVersionCode I
    iget v3, v8, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->updateVersionCode I
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->channel Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->channel Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-boolean v1, v7, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->isBoe Z
    iget-boolean v3, v8, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->isBoe Z
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v7, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->filterEnable Z
    iget-boolean v3, v8, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->filterEnable Z
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v7, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->samplingEnable Z
    iget-boolean v3, v8, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->samplingEnable Z
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v7, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->newMonitorEnabled Z
    iget-boolean v3, v8, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->newMonitorEnabled Z
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v7, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->newMonitorInDebugMode Z
    iget-boolean v3, v8, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->newMonitorInDebugMode Z
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v7, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->defaultSentryEnabled Z
    iget-boolean v3, v8, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->defaultSentryEnabled Z
    if-eq v1, v3, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->defaultSentryColdStartSamplingRate I
    iget v3, v8, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->defaultSentryColdStartSamplingRate I
    if-eq v1, v3, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->defaultColdStartReportDelay J
    iget-wide v5, v8, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->defaultColdStartReportDelay J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->defaultReportInterval J
    iget-wide v5, v8, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->defaultReportInterval J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-boolean v1, v7, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->packByLengthEnabled Z
    iget-boolean v3, v8, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->packByLengthEnabled Z
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v7, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->realtimeEventOptEnabled Z
    iget-boolean v3, v8, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->realtimeEventOptEnabled Z
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v7, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->packMultiQueryEnabled Z
    iget-boolean v8, v8, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->packMultiQueryEnabled Z
    if-eq v1, v8, +003h
    return v2
    return v0
.end method

.method public final getAppId()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->appId I
    return v0
.end method

.method public final getAppName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->appName Ljava/lang/String;
    return-object v0
.end method

.method public final getChannel()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->channel Ljava/lang/String;
    return-object v0
.end method

.method public final getDefaultColdStartReportDelay()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->defaultColdStartReportDelay J
    return-wide v0
.end method

.method public final getDefaultReportInterval()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->defaultReportInterval J
    return-wide v0
.end method

.method public final getDefaultSentryColdStartSamplingRate()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->defaultSentryColdStartSamplingRate I
    return v0
.end method

.method public final getDefaultSentryEnabled()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->defaultSentryEnabled Z
    return v0
.end method

.method public final getFilterEnable()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->filterEnable Z
    return v0
.end method

.method public final getNewMonitorEnabled()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->newMonitorEnabled Z
    return v0
.end method

.method public final getNewMonitorInDebugMode()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->newMonitorInDebugMode Z
    return v0
.end method

.method public final getPackByLengthEnabled()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->packByLengthEnabled Z
    return v0
.end method

.method public final getPackMultiQueryEnabled()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->packMultiQueryEnabled Z
    return v0
.end method

.method public final getRealtimeEventOptEnabled()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->realtimeEventOptEnabled Z
    return v0
.end method

.method public final getSamplingEnable()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->samplingEnable Z
    return v0
.end method

.method public final getUpdateVersionCode()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->updateVersionCode I
    return v0
.end method

.method public final getVersionCode()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->versionCode I
    return v0
.end method

.method public final getVersionName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->versionName Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget v0, v3, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->appId I
    invoke-static v0, Ljava/lang/Integer;->hashCode(I)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->appName Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->versionCode I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->versionName Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->updateVersionCode I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->channel Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v3, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->isBoe Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v3, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->filterEnable Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v3, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->samplingEnable Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v3, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->newMonitorEnabled Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v3, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->newMonitorInDebugMode Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v3, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->defaultSentryEnabled Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->defaultSentryColdStartSamplingRate I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->defaultColdStartReportDelay J
    invoke-static v1, v2, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->defaultReportInterval J
    invoke-static v1, v2, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v3, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->packByLengthEnabled Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v3, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->realtimeEventOptEnabled Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v3, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->packMultiQueryEnabled Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public final isBoe()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->isBoe Z
    return v0
.end method

.method public toString()java.lang.String
    .registers 5
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "AppLogConfigInfo(appId="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget v1, v4, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->appId I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", appName="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->appName Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", versionCode="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->versionCode I
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", versionName="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->versionName Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", updateVersionCode="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->updateVersionCode I
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", channel="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->channel Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", isBoe="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-boolean v2, v4, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->isBoe Z
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", filterEnable="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-boolean v2, v4, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->filterEnable Z
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", samplingEnable="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-boolean v2, v4, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->samplingEnable Z
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", newMonitorEnabled="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-boolean v2, v4, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->newMonitorEnabled Z
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", newMonitorInDebugMode="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-boolean v2, v4, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->newMonitorInDebugMode Z
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", defaultSentryEnabled="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    iget-boolean v1, v4, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->defaultSentryEnabled Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", defaultSentryColdStartSamplingRate="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->defaultSentryColdStartSamplingRate I
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", defaultColdStartReportDelay="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->defaultColdStartReportDelay J
    invoke-virtual v1, v2, v3, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", defaultReportInterval="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->defaultReportInterval J
    invoke-virtual v1, v2, v3, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", packByLengthEnabled="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-boolean v2, v4, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->packByLengthEnabled Z
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", realtimeEventOptEnabled="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-boolean v2, v4, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->realtimeEventOptEnabled Z
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", packMultiQueryEnabled="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-boolean v2, v4, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->packMultiQueryEnabled Z
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    const/16 v2, 41
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
