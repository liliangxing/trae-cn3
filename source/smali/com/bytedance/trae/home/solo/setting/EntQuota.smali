# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/EntQuota;
.super Ljava/lang/Object;
.source "UserEntStatusApi.kt"

.field public static final $stable:I
.field private final advancedModelRequestLimit:Ljava/lang/Long;
.field private final autoCompletionLimit:Ljava/lang/Long;
.field private final basicUsageLimit:Ljava/lang/Long;
.field private final bonusUsageLimit:Ljava/lang/Long;
.field private final creditsLimit:Ljava/lang/Long;
.field private final enableEarlyAccess:Ljava/lang/Boolean;
.field private final enableRalphLoop:Ljava/lang/Boolean;
.field private final enableSoloAgent:Ljava/lang/Boolean;
.field private final enableSoloBuilder:Ljava/lang/Boolean;
.field private final enableSoloBuilderV1:Ljava/lang/Boolean;
.field private final enableSoloCoder:Ljava/lang/Boolean;
.field private final enableSoloLite:Ljava/lang/Boolean;
.field private final enableSoloWeb:Ljava/lang/Boolean;
.field private final enableSuperModel:Ljava/lang/Boolean;
.field private final noBonusQuota:Ljava/lang/Boolean;
.field private final premiumModelFastRequestLimit:Ljava/lang/Long;
.field private final premiumModelSlowRequestLimit:Ljava/lang/Long;
.field private final soloAgentParallelLimit:Ljava/lang/Integer;


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>()void
    .registers 22
    # ins_size=1
    move-object/from16 v0, v21
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const v19, 262143
    const/16 v20, 0
    invoke-direct/range v0 ... v20, Lcom/bytedance/trae/home/solo/setting/EntQuota;-><init>(Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Integer; Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Long; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(java.lang.Long  java.lang.Long  java.lang.Long  java.lang.Long  java.lang.Boolean  java.lang.Boolean  java.lang.Boolean  java.lang.Boolean  java.lang.Long  java.lang.Long  java.lang.Boolean  java.lang.Boolean  java.lang.Integer  java.lang.Boolean  java.lang.Boolean  java.lang.Boolean  java.lang.Boolean  java.lang.Long)void
    .registers 21
    # ins_size=19
    move-object v0, v2
    invoke-direct v2, Ljava/lang/Object;-><init>()V
    move-object v1, v3
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/EntQuota;->advancedModelRequestLimit Ljava/lang/Long;
    move-object v1, v4
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/EntQuota;->autoCompletionLimit Ljava/lang/Long;
    move-object v1, v5
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/EntQuota;->premiumModelFastRequestLimit Ljava/lang/Long;
    move-object v1, v6
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/EntQuota;->premiumModelSlowRequestLimit Ljava/lang/Long;
    move-object v1, v7
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/EntQuota;->enableSuperModel Ljava/lang/Boolean;
    move-object v1, v8
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/EntQuota;->enableSoloBuilder Ljava/lang/Boolean;
    move-object v1, v9
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/EntQuota;->enableSoloCoder Ljava/lang/Boolean;
    move-object v1, v10
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/EntQuota;->enableSoloBuilderV1 Ljava/lang/Boolean;
    move-object v1, v11
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/EntQuota;->basicUsageLimit Ljava/lang/Long;
    move-object v1, v12
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/EntQuota;->bonusUsageLimit Ljava/lang/Long;
    move-object v1, v13
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/EntQuota;->enableEarlyAccess Ljava/lang/Boolean;
    move-object v1, v14
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/EntQuota;->enableSoloAgent Ljava/lang/Boolean;
    move-object v1, v15
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/EntQuota;->soloAgentParallelLimit Ljava/lang/Integer;
    move-object/from16 v1, v16
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/EntQuota;->enableSoloWeb Ljava/lang/Boolean;
    move-object/from16 v1, v17
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/EntQuota;->enableSoloLite Ljava/lang/Boolean;
    move-object/from16 v1, v18
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/EntQuota;->noBonusQuota Ljava/lang/Boolean;
    move-object/from16 v1, v19
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/EntQuota;->enableRalphLoop Ljava/lang/Boolean;
    move-object/from16 v1, v20
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/EntQuota;->creditsLimit Ljava/lang/Long;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.Long  java.lang.Long  java.lang.Long  java.lang.Long  java.lang.Boolean  java.lang.Boolean  java.lang.Boolean  java.lang.Boolean  java.lang.Long  java.lang.Long  java.lang.Boolean  java.lang.Boolean  java.lang.Integer  java.lang.Boolean  java.lang.Boolean  java.lang.Boolean  java.lang.Boolean  java.lang.Long  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 40
    # ins_size=21
    move/from16 v0, v38
    and-int/lit8 v1, v0, 1
    if-eqz v1, +004h
    const/4 v1, 0
    goto +3h
    move-object/from16 v1, v20
    and-int/lit8 v3, v0, 2
    if-eqz v3, +004h
    const/4 v3, 0
    goto +3h
    move-object/from16 v3, v21
    and-int/lit8 v4, v0, 4
    if-eqz v4, +004h
    const/4 v4, 0
    goto +3h
    move-object/from16 v4, v22
    and-int/lit8 v5, v0, 8
    if-eqz v5, +004h
    const/4 v5, 0
    goto +3h
    move-object/from16 v5, v23
    and-int/lit8 v6, v0, 16
    if-eqz v6, +004h
    const/4 v6, 0
    goto +3h
    move-object/from16 v6, v24
    and-int/lit8 v7, v0, 32
    if-eqz v7, +004h
    const/4 v7, 0
    goto +3h
    move-object/from16 v7, v25
    and-int/lit8 v8, v0, 64
    if-eqz v8, +004h
    const/4 v8, 0
    goto +3h
    move-object/from16 v8, v26
    and-int/lit16 v9, v0, 128
    if-eqz v9, +004h
    const/4 v9, 0
    goto +3h
    move-object/from16 v9, v27
    and-int/lit16 v10, v0, 256
    if-eqz v10, +004h
    const/4 v10, 0
    goto +3h
    move-object/from16 v10, v28
    and-int/lit16 v11, v0, 512
    if-eqz v11, +004h
    const/4 v11, 0
    goto +3h
    move-object/from16 v11, v29
    and-int/lit16 v12, v0, 1024
    if-eqz v12, +004h
    const/4 v12, 0
    goto +3h
    move-object/from16 v12, v30
    and-int/lit16 v13, v0, 2048
    if-eqz v13, +004h
    const/4 v13, 0
    goto +3h
    move-object/from16 v13, v31
    and-int/lit16 v14, v0, 4096
    if-eqz v14, +004h
    const/4 v14, 0
    goto +3h
    move-object/from16 v14, v32
    and-int/lit16 v15, v0, 8192
    if-eqz v15, +004h
    const/4 v15, 0
    goto +3h
    move-object/from16 v15, v33
    and-int/lit16 v2, v0, 16384
    if-eqz v2, +004h
    const/4 v2, 0
    goto +3h
    move-object/from16 v2, v34
    const v16, 32768
    and-int v16, v0, v16
    if-eqz v16, +005h
    const/16 v16, 0
    goto +3h
    move-object/from16 v16, v35
    const/high16 v17, 65536
    and-int v17, v0, v17
    if-eqz v17, +005h
    const/16 v17, 0
    goto +3h
    move-object/from16 v17, v36
    const/high16 v18, 131072
    and-int v0, v0, v18
    if-eqz v0, +004h
    const/4 v0, 0
    goto +3h
    move-object/from16 v0, v37
    move-object/from16 v20, v19
    move-object/from16 v21, v1
    move-object/from16 v22, v3
    move-object/from16 v23, v4
    move-object/from16 v24, v5
    move-object/from16 v25, v6
    move-object/from16 v26, v7
    move-object/from16 v27, v8
    move-object/from16 v28, v9
    move-object/from16 v29, v10
    move-object/from16 v30, v11
    move-object/from16 v31, v12
    move-object/from16 v32, v13
    move-object/from16 v33, v14
    move-object/from16 v34, v15
    move-object/from16 v35, v2
    move-object/from16 v36, v16
    move-object/from16 v37, v17
    move-object/from16 v38, v0
    invoke-direct/range v20 ... v38, Lcom/bytedance/trae/home/solo/setting/EntQuota;-><init>(Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Integer; Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Long;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.home.solo.setting.EntQuota  java.lang.Long  java.lang.Long  java.lang.Long  java.lang.Long  java.lang.Boolean  java.lang.Boolean  java.lang.Boolean  java.lang.Boolean  java.lang.Long  java.lang.Long  java.lang.Boolean  java.lang.Boolean  java.lang.Integer  java.lang.Boolean  java.lang.Boolean  java.lang.Boolean  java.lang.Boolean  java.lang.Long  int  java.lang.Object)com.bytedance.trae.home.solo.setting.EntQuota
    .registers 38
    # ins_size=21
    move-object/from16 v0, v17
    move/from16 v1, v36
    and-int/lit8 v2, v1, 1
    if-eqz v2, +005h
    iget-object v2, v0, Lcom/bytedance/trae/home/solo/setting/EntQuota;->advancedModelRequestLimit Ljava/lang/Long;
    goto +3h
    move-object/from16 v2, v18
    and-int/lit8 v3, v1, 2
    if-eqz v3, +005h
    iget-object v3, v0, Lcom/bytedance/trae/home/solo/setting/EntQuota;->autoCompletionLimit Ljava/lang/Long;
    goto +3h
    move-object/from16 v3, v19
    and-int/lit8 v4, v1, 4
    if-eqz v4, +005h
    iget-object v4, v0, Lcom/bytedance/trae/home/solo/setting/EntQuota;->premiumModelFastRequestLimit Ljava/lang/Long;
    goto +3h
    move-object/from16 v4, v20
    and-int/lit8 v5, v1, 8
    if-eqz v5, +005h
    iget-object v5, v0, Lcom/bytedance/trae/home/solo/setting/EntQuota;->premiumModelSlowRequestLimit Ljava/lang/Long;
    goto +3h
    move-object/from16 v5, v21
    and-int/lit8 v6, v1, 16
    if-eqz v6, +005h
    iget-object v6, v0, Lcom/bytedance/trae/home/solo/setting/EntQuota;->enableSuperModel Ljava/lang/Boolean;
    goto +3h
    move-object/from16 v6, v22
    and-int/lit8 v7, v1, 32
    if-eqz v7, +005h
    iget-object v7, v0, Lcom/bytedance/trae/home/solo/setting/EntQuota;->enableSoloBuilder Ljava/lang/Boolean;
    goto +3h
    move-object/from16 v7, v23
    and-int/lit8 v8, v1, 64
    if-eqz v8, +005h
    iget-object v8, v0, Lcom/bytedance/trae/home/solo/setting/EntQuota;->enableSoloCoder Ljava/lang/Boolean;
    goto +3h
    move-object/from16 v8, v24
    and-int/lit16 v9, v1, 128
    if-eqz v9, +005h
    iget-object v9, v0, Lcom/bytedance/trae/home/solo/setting/EntQuota;->enableSoloBuilderV1 Ljava/lang/Boolean;
    goto +3h
    move-object/from16 v9, v25
    and-int/lit16 v10, v1, 256
    if-eqz v10, +005h
    iget-object v10, v0, Lcom/bytedance/trae/home/solo/setting/EntQuota;->basicUsageLimit Ljava/lang/Long;
    goto +3h
    move-object/from16 v10, v26
    and-int/lit16 v11, v1, 512
    if-eqz v11, +005h
    iget-object v11, v0, Lcom/bytedance/trae/home/solo/setting/EntQuota;->bonusUsageLimit Ljava/lang/Long;
    goto +3h
    move-object/from16 v11, v27
    and-int/lit16 v12, v1, 1024
    if-eqz v12, +005h
    iget-object v12, v0, Lcom/bytedance/trae/home/solo/setting/EntQuota;->enableEarlyAccess Ljava/lang/Boolean;
    goto +3h
    move-object/from16 v12, v28
    and-int/lit16 v13, v1, 2048
    if-eqz v13, +005h
    iget-object v13, v0, Lcom/bytedance/trae/home/solo/setting/EntQuota;->enableSoloAgent Ljava/lang/Boolean;
    goto +3h
    move-object/from16 v13, v29
    and-int/lit16 v14, v1, 4096
    if-eqz v14, +005h
    iget-object v14, v0, Lcom/bytedance/trae/home/solo/setting/EntQuota;->soloAgentParallelLimit Ljava/lang/Integer;
    goto +3h
    move-object/from16 v14, v30
    and-int/lit16 v15, v1, 8192
    if-eqz v15, +005h
    iget-object v15, v0, Lcom/bytedance/trae/home/solo/setting/EntQuota;->enableSoloWeb Ljava/lang/Boolean;
    goto +3h
    move-object/from16 v15, v31
    move-object/from16 v31, v15
    and-int/lit16 v15, v1, 16384
    if-eqz v15, +005h
    iget-object v15, v0, Lcom/bytedance/trae/home/solo/setting/EntQuota;->enableSoloLite Ljava/lang/Boolean;
    goto +3h
    move-object/from16 v15, v32
    const v16, 32768
    and-int v16, v1, v16
    move-object/from16 v32, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/home/solo/setting/EntQuota;->noBonusQuota Ljava/lang/Boolean;
    goto +3h
    move-object/from16 v15, v33
    const/high16 v16, 65536
    and-int v16, v1, v16
    move-object/from16 v33, v15
    if-eqz v16, +005h
    iget-object v15, v0, Lcom/bytedance/trae/home/solo/setting/EntQuota;->enableRalphLoop Ljava/lang/Boolean;
    goto +3h
    move-object/from16 v15, v34
    const/high16 v16, 131072
    and-int v1, v1, v16
    if-eqz v1, +005h
    iget-object v1, v0, Lcom/bytedance/trae/home/solo/setting/EntQuota;->creditsLimit Ljava/lang/Long;
    goto +3h
    move-object/from16 v1, v35
    move-object/from16 v18, v2
    move-object/from16 v19, v3
    move-object/from16 v20, v4
    move-object/from16 v21, v5
    move-object/from16 v22, v6
    move-object/from16 v23, v7
    move-object/from16 v24, v8
    move-object/from16 v25, v9
    move-object/from16 v26, v10
    move-object/from16 v27, v11
    move-object/from16 v28, v12
    move-object/from16 v29, v13
    move-object/from16 v30, v14
    move-object/from16 v34, v15
    move-object/from16 v35, v1
    invoke-virtual/range v17 ... v35, Lcom/bytedance/trae/home/solo/setting/EntQuota;->copy(Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Integer; Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Long;)Lcom/bytedance/trae/home/solo/setting/EntQuota;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntQuota;->advancedModelRequestLimit Ljava/lang/Long;
    return-object v0
.end method

.method public final component10()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntQuota;->bonusUsageLimit Ljava/lang/Long;
    return-object v0
.end method

.method public final component11()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntQuota;->enableEarlyAccess Ljava/lang/Boolean;
    return-object v0
.end method

.method public final component12()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntQuota;->enableSoloAgent Ljava/lang/Boolean;
    return-object v0
.end method

.method public final component13()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntQuota;->soloAgentParallelLimit Ljava/lang/Integer;
    return-object v0
.end method

.method public final component14()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntQuota;->enableSoloWeb Ljava/lang/Boolean;
    return-object v0
.end method

.method public final component15()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntQuota;->enableSoloLite Ljava/lang/Boolean;
    return-object v0
.end method

.method public final component16()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntQuota;->noBonusQuota Ljava/lang/Boolean;
    return-object v0
.end method

.method public final component17()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntQuota;->enableRalphLoop Ljava/lang/Boolean;
    return-object v0
.end method

.method public final component18()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntQuota;->creditsLimit Ljava/lang/Long;
    return-object v0
.end method

.method public final component2()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntQuota;->autoCompletionLimit Ljava/lang/Long;
    return-object v0
.end method

.method public final component3()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntQuota;->premiumModelFastRequestLimit Ljava/lang/Long;
    return-object v0
.end method

.method public final component4()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntQuota;->premiumModelSlowRequestLimit Ljava/lang/Long;
    return-object v0
.end method

.method public final component5()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntQuota;->enableSuperModel Ljava/lang/Boolean;
    return-object v0
.end method

.method public final component6()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntQuota;->enableSoloBuilder Ljava/lang/Boolean;
    return-object v0
.end method

.method public final component7()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntQuota;->enableSoloCoder Ljava/lang/Boolean;
    return-object v0
.end method

.method public final component8()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntQuota;->enableSoloBuilderV1 Ljava/lang/Boolean;
    return-object v0
.end method

.method public final component9()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntQuota;->basicUsageLimit Ljava/lang/Long;
    return-object v0
.end method

.method public final copy(java.lang.Long  java.lang.Long  java.lang.Long  java.lang.Long  java.lang.Boolean  java.lang.Boolean  java.lang.Boolean  java.lang.Boolean  java.lang.Long  java.lang.Long  java.lang.Boolean  java.lang.Boolean  java.lang.Integer  java.lang.Boolean  java.lang.Boolean  java.lang.Boolean  java.lang.Boolean  java.lang.Long)com.bytedance.trae.home.solo.setting.EntQuota
    .registers 39
    # ins_size=19
    move-object/from16 v1, v21
    move-object/from16 v2, v22
    move-object/from16 v3, v23
    move-object/from16 v4, v24
    move-object/from16 v5, v25
    move-object/from16 v6, v26
    move-object/from16 v7, v27
    move-object/from16 v8, v28
    move-object/from16 v9, v29
    move-object/from16 v10, v30
    move-object/from16 v11, v31
    move-object/from16 v12, v32
    move-object/from16 v13, v33
    move-object/from16 v14, v34
    move-object/from16 v15, v35
    move-object/from16 v16, v36
    move-object/from16 v17, v37
    move-object/from16 v18, v38
    new-instance v19, Lcom/bytedance/trae/home/solo/setting/EntQuota;
    move-object/from16 v0, v19
    invoke-direct/range v0 ... v18, Lcom/bytedance/trae/home/solo/setting/EntQuota;-><init>(Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Integer; Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Long;)V
    return-object v19
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/home/solo/setting/EntQuota;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/home/solo/setting/EntQuota;
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/EntQuota;->advancedModelRequestLimit Ljava/lang/Long;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/EntQuota;->advancedModelRequestLimit Ljava/lang/Long;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/EntQuota;->autoCompletionLimit Ljava/lang/Long;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/EntQuota;->autoCompletionLimit Ljava/lang/Long;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/EntQuota;->premiumModelFastRequestLimit Ljava/lang/Long;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/EntQuota;->premiumModelFastRequestLimit Ljava/lang/Long;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/EntQuota;->premiumModelSlowRequestLimit Ljava/lang/Long;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/EntQuota;->premiumModelSlowRequestLimit Ljava/lang/Long;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/EntQuota;->enableSuperModel Ljava/lang/Boolean;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/EntQuota;->enableSuperModel Ljava/lang/Boolean;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/EntQuota;->enableSoloBuilder Ljava/lang/Boolean;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/EntQuota;->enableSoloBuilder Ljava/lang/Boolean;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/EntQuota;->enableSoloCoder Ljava/lang/Boolean;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/EntQuota;->enableSoloCoder Ljava/lang/Boolean;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/EntQuota;->enableSoloBuilderV1 Ljava/lang/Boolean;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/EntQuota;->enableSoloBuilderV1 Ljava/lang/Boolean;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/EntQuota;->basicUsageLimit Ljava/lang/Long;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/EntQuota;->basicUsageLimit Ljava/lang/Long;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/EntQuota;->bonusUsageLimit Ljava/lang/Long;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/EntQuota;->bonusUsageLimit Ljava/lang/Long;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/EntQuota;->enableEarlyAccess Ljava/lang/Boolean;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/EntQuota;->enableEarlyAccess Ljava/lang/Boolean;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/EntQuota;->enableSoloAgent Ljava/lang/Boolean;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/EntQuota;->enableSoloAgent Ljava/lang/Boolean;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/EntQuota;->soloAgentParallelLimit Ljava/lang/Integer;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/EntQuota;->soloAgentParallelLimit Ljava/lang/Integer;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/EntQuota;->enableSoloWeb Ljava/lang/Boolean;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/EntQuota;->enableSoloWeb Ljava/lang/Boolean;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/EntQuota;->enableSoloLite Ljava/lang/Boolean;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/EntQuota;->enableSoloLite Ljava/lang/Boolean;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/EntQuota;->noBonusQuota Ljava/lang/Boolean;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/EntQuota;->noBonusQuota Ljava/lang/Boolean;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/EntQuota;->enableRalphLoop Ljava/lang/Boolean;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/EntQuota;->enableRalphLoop Ljava/lang/Boolean;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/EntQuota;->creditsLimit Ljava/lang/Long;
    iget-object v5, v5, Lcom/bytedance/trae/home/solo/setting/EntQuota;->creditsLimit Ljava/lang/Long;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getAdvancedModelRequestLimit()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntQuota;->advancedModelRequestLimit Ljava/lang/Long;
    return-object v0
.end method

.method public final getAutoCompletionLimit()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntQuota;->autoCompletionLimit Ljava/lang/Long;
    return-object v0
.end method

.method public final getBasicUsageLimit()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntQuota;->basicUsageLimit Ljava/lang/Long;
    return-object v0
.end method

.method public final getBonusUsageLimit()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntQuota;->bonusUsageLimit Ljava/lang/Long;
    return-object v0
.end method

.method public final getCreditsLimit()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntQuota;->creditsLimit Ljava/lang/Long;
    return-object v0
.end method

.method public final getEnableEarlyAccess()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntQuota;->enableEarlyAccess Ljava/lang/Boolean;
    return-object v0
.end method

.method public final getEnableRalphLoop()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntQuota;->enableRalphLoop Ljava/lang/Boolean;
    return-object v0
.end method

.method public final getEnableSoloAgent()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntQuota;->enableSoloAgent Ljava/lang/Boolean;
    return-object v0
.end method

.method public final getEnableSoloBuilder()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntQuota;->enableSoloBuilder Ljava/lang/Boolean;
    return-object v0
.end method

.method public final getEnableSoloBuilderV1()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntQuota;->enableSoloBuilderV1 Ljava/lang/Boolean;
    return-object v0
.end method

.method public final getEnableSoloCoder()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntQuota;->enableSoloCoder Ljava/lang/Boolean;
    return-object v0
.end method

.method public final getEnableSoloLite()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntQuota;->enableSoloLite Ljava/lang/Boolean;
    return-object v0
.end method

.method public final getEnableSoloWeb()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntQuota;->enableSoloWeb Ljava/lang/Boolean;
    return-object v0
.end method

.method public final getEnableSuperModel()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntQuota;->enableSuperModel Ljava/lang/Boolean;
    return-object v0
.end method

.method public final getNoBonusQuota()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntQuota;->noBonusQuota Ljava/lang/Boolean;
    return-object v0
.end method

.method public final getPremiumModelFastRequestLimit()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntQuota;->premiumModelFastRequestLimit Ljava/lang/Long;
    return-object v0
.end method

.method public final getPremiumModelSlowRequestLimit()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntQuota;->premiumModelSlowRequestLimit Ljava/lang/Long;
    return-object v0
.end method

.method public final getSoloAgentParallelLimit()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntQuota;->soloAgentParallelLimit Ljava/lang/Integer;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/setting/EntQuota;->advancedModelRequestLimit Ljava/lang/Long;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Ljava/lang/Object;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntQuota;->autoCompletionLimit Ljava/lang/Long;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntQuota;->premiumModelFastRequestLimit Ljava/lang/Long;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntQuota;->premiumModelSlowRequestLimit Ljava/lang/Long;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntQuota;->enableSuperModel Ljava/lang/Boolean;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntQuota;->enableSoloBuilder Ljava/lang/Boolean;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntQuota;->enableSoloCoder Ljava/lang/Boolean;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntQuota;->enableSoloBuilderV1 Ljava/lang/Boolean;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntQuota;->basicUsageLimit Ljava/lang/Long;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntQuota;->bonusUsageLimit Ljava/lang/Long;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntQuota;->enableEarlyAccess Ljava/lang/Boolean;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntQuota;->enableSoloAgent Ljava/lang/Boolean;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntQuota;->soloAgentParallelLimit Ljava/lang/Integer;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntQuota;->enableSoloWeb Ljava/lang/Boolean;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntQuota;->enableSoloLite Ljava/lang/Boolean;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntQuota;->noBonusQuota Ljava/lang/Boolean;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntQuota;->enableRalphLoop Ljava/lang/Boolean;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntQuota;->creditsLimit Ljava/lang/Long;
    if-nez v2, +003h
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "EntQuota(advancedModelRequestLimit="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/setting/EntQuota;->advancedModelRequestLimit Ljava/lang/Long;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", autoCompletionLimit="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntQuota;->autoCompletionLimit Ljava/lang/Long;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", premiumModelFastRequestLimit="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntQuota;->premiumModelFastRequestLimit Ljava/lang/Long;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", premiumModelSlowRequestLimit="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntQuota;->premiumModelSlowRequestLimit Ljava/lang/Long;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", enableSuperModel="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntQuota;->enableSuperModel Ljava/lang/Boolean;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", enableSoloBuilder="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntQuota;->enableSoloBuilder Ljava/lang/Boolean;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", enableSoloCoder="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntQuota;->enableSoloCoder Ljava/lang/Boolean;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", enableSoloBuilderV1="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntQuota;->enableSoloBuilderV1 Ljava/lang/Boolean;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", basicUsageLimit="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntQuota;->basicUsageLimit Ljava/lang/Long;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", bonusUsageLimit="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntQuota;->bonusUsageLimit Ljava/lang/Long;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", enableEarlyAccess="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntQuota;->enableEarlyAccess Ljava/lang/Boolean;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", enableSoloAgent="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/setting/EntQuota;->enableSoloAgent Ljava/lang/Boolean;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", soloAgentParallelLimit="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntQuota;->soloAgentParallelLimit Ljava/lang/Integer;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", enableSoloWeb="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntQuota;->enableSoloWeb Ljava/lang/Boolean;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", enableSoloLite="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntQuota;->enableSoloLite Ljava/lang/Boolean;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", noBonusQuota="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntQuota;->noBonusQuota Ljava/lang/Boolean;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", enableRalphLoop="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntQuota;->enableRalphLoop Ljava/lang/Boolean;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", creditsLimit="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntQuota;->creditsLimit Ljava/lang/Long;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const/16 v2, 41
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
