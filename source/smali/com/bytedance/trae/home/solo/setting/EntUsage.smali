# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/EntUsage;
.super Ljava/lang/Object;
.source "UserEntStatusApi.kt"

.field public static final $stable:I
.field private final advancedModelAmount:Ljava/lang/Double;
.field private final advancedModelRequestUsage:Ljava/lang/Long;
.field private final autoCompletionAmount:Ljava/lang/Double;
.field private final autoCompletionUsage:Ljava/lang/Long;
.field private final basicUsageAmount:Ljava/lang/Double;
.field private final bonusUsageAmount:Ljava/lang/Double;
.field private final creditsAmount:Ljava/lang/Double;
.field private final isFlashConsuming:Ljava/lang/Boolean;
.field private final premiumModelFastAmount:Ljava/lang/Double;
.field private final premiumModelFastRequestUsage:Ljava/lang/Long;
.field private final premiumModelSlowAmount:Ljava/lang/Double;
.field private final premiumModelSlowRequestUsage:Ljava/lang/Long;


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>()void
    .registers 16
    # ins_size=1
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
    const/16 v13, 4095
    const/4 v14, 0
    move-object v0, v15
    invoke-direct/range v0 ... v14, Lcom/bytedance/trae/home/solo/setting/EntUsage;-><init>(Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Boolean; Ljava/lang/Double; Ljava/lang/Double; Ljava/lang/Double; Ljava/lang/Double; Ljava/lang/Double; Ljava/lang/Double; Ljava/lang/Double; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(java.lang.Long  java.lang.Long  java.lang.Long  java.lang.Long  java.lang.Boolean  java.lang.Double  java.lang.Double  java.lang.Double  java.lang.Double  java.lang.Double  java.lang.Double  java.lang.Double)void
    .registers 13
    # ins_size=13
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/EntUsage;->advancedModelRequestUsage Ljava/lang/Long;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/EntUsage;->autoCompletionUsage Ljava/lang/Long;
    iput-object v3, v0, Lcom/bytedance/trae/home/solo/setting/EntUsage;->premiumModelFastRequestUsage Ljava/lang/Long;
    iput-object v4, v0, Lcom/bytedance/trae/home/solo/setting/EntUsage;->premiumModelSlowRequestUsage Ljava/lang/Long;
    iput-object v5, v0, Lcom/bytedance/trae/home/solo/setting/EntUsage;->isFlashConsuming Ljava/lang/Boolean;
    iput-object v6, v0, Lcom/bytedance/trae/home/solo/setting/EntUsage;->autoCompletionAmount Ljava/lang/Double;
    iput-object v7, v0, Lcom/bytedance/trae/home/solo/setting/EntUsage;->advancedModelAmount Ljava/lang/Double;
    iput-object v8, v0, Lcom/bytedance/trae/home/solo/setting/EntUsage;->premiumModelFastAmount Ljava/lang/Double;
    iput-object v9, v0, Lcom/bytedance/trae/home/solo/setting/EntUsage;->premiumModelSlowAmount Ljava/lang/Double;
    iput-object v10, v0, Lcom/bytedance/trae/home/solo/setting/EntUsage;->basicUsageAmount Ljava/lang/Double;
    iput-object v11, v0, Lcom/bytedance/trae/home/solo/setting/EntUsage;->bonusUsageAmount Ljava/lang/Double;
    iput-object v12, v0, Lcom/bytedance/trae/home/solo/setting/EntUsage;->creditsAmount Ljava/lang/Double;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.Long  java.lang.Long  java.lang.Long  java.lang.Long  java.lang.Boolean  java.lang.Double  java.lang.Double  java.lang.Double  java.lang.Double  java.lang.Double  java.lang.Double  java.lang.Double  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 28
    # ins_size=15
    move/from16 v0, v26
    and-int/lit8 v1, v0, 1
    const/4 v2, 0
    if-eqz v1, +004h
    move-object v1, v2
    goto +2h
    move-object v1, v14
    and-int/lit8 v3, v0, 2
    if-eqz v3, +004h
    move-object v3, v2
    goto +2h
    move-object v3, v15
    and-int/lit8 v4, v0, 4
    if-eqz v4, +004h
    move-object v4, v2
    goto +3h
    move-object/from16 v4, v16
    and-int/lit8 v5, v0, 8
    if-eqz v5, +004h
    move-object v5, v2
    goto +3h
    move-object/from16 v5, v17
    and-int/lit8 v6, v0, 16
    if-eqz v6, +004h
    move-object v6, v2
    goto +3h
    move-object/from16 v6, v18
    and-int/lit8 v7, v0, 32
    if-eqz v7, +004h
    move-object v7, v2
    goto +3h
    move-object/from16 v7, v19
    and-int/lit8 v8, v0, 64
    if-eqz v8, +004h
    move-object v8, v2
    goto +3h
    move-object/from16 v8, v20
    and-int/lit16 v9, v0, 128
    if-eqz v9, +004h
    move-object v9, v2
    goto +3h
    move-object/from16 v9, v21
    and-int/lit16 v10, v0, 256
    if-eqz v10, +004h
    move-object v10, v2
    goto +3h
    move-object/from16 v10, v22
    and-int/lit16 v11, v0, 512
    if-eqz v11, +004h
    move-object v11, v2
    goto +3h
    move-object/from16 v11, v23
    and-int/lit16 v12, v0, 1024
    if-eqz v12, +004h
    move-object v12, v2
    goto +3h
    move-object/from16 v12, v24
    and-int/lit16 v0, v0, 2048
    if-eqz v0, +003h
    goto +3h
    move-object/from16 v2, v25
    move-object v14, v13
    move-object v15, v1
    move-object/from16 v16, v3
    move-object/from16 v17, v4
    move-object/from16 v18, v5
    move-object/from16 v19, v6
    move-object/from16 v20, v7
    move-object/from16 v21, v8
    move-object/from16 v22, v9
    move-object/from16 v23, v10
    move-object/from16 v24, v11
    move-object/from16 v25, v12
    move-object/from16 v26, v2
    invoke-direct/range v14 ... v26, Lcom/bytedance/trae/home/solo/setting/EntUsage;-><init>(Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Boolean; Ljava/lang/Double; Ljava/lang/Double; Ljava/lang/Double; Ljava/lang/Double; Ljava/lang/Double; Ljava/lang/Double; Ljava/lang/Double;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.home.solo.setting.EntUsage  java.lang.Long  java.lang.Long  java.lang.Long  java.lang.Long  java.lang.Boolean  java.lang.Double  java.lang.Double  java.lang.Double  java.lang.Double  java.lang.Double  java.lang.Double  java.lang.Double  int  java.lang.Object)com.bytedance.trae.home.solo.setting.EntUsage
    .registers 28
    # ins_size=15
    move-object v0, v13
    move/from16 v1, v26
    and-int/lit8 v2, v1, 1
    if-eqz v2, +005h
    iget-object v2, v0, Lcom/bytedance/trae/home/solo/setting/EntUsage;->advancedModelRequestUsage Ljava/lang/Long;
    goto +2h
    move-object v2, v14
    and-int/lit8 v3, v1, 2
    if-eqz v3, +005h
    iget-object v3, v0, Lcom/bytedance/trae/home/solo/setting/EntUsage;->autoCompletionUsage Ljava/lang/Long;
    goto +2h
    move-object v3, v15
    and-int/lit8 v4, v1, 4
    if-eqz v4, +005h
    iget-object v4, v0, Lcom/bytedance/trae/home/solo/setting/EntUsage;->premiumModelFastRequestUsage Ljava/lang/Long;
    goto +3h
    move-object/from16 v4, v16
    and-int/lit8 v5, v1, 8
    if-eqz v5, +005h
    iget-object v5, v0, Lcom/bytedance/trae/home/solo/setting/EntUsage;->premiumModelSlowRequestUsage Ljava/lang/Long;
    goto +3h
    move-object/from16 v5, v17
    and-int/lit8 v6, v1, 16
    if-eqz v6, +005h
    iget-object v6, v0, Lcom/bytedance/trae/home/solo/setting/EntUsage;->isFlashConsuming Ljava/lang/Boolean;
    goto +3h
    move-object/from16 v6, v18
    and-int/lit8 v7, v1, 32
    if-eqz v7, +005h
    iget-object v7, v0, Lcom/bytedance/trae/home/solo/setting/EntUsage;->autoCompletionAmount Ljava/lang/Double;
    goto +3h
    move-object/from16 v7, v19
    and-int/lit8 v8, v1, 64
    if-eqz v8, +005h
    iget-object v8, v0, Lcom/bytedance/trae/home/solo/setting/EntUsage;->advancedModelAmount Ljava/lang/Double;
    goto +3h
    move-object/from16 v8, v20
    and-int/lit16 v9, v1, 128
    if-eqz v9, +005h
    iget-object v9, v0, Lcom/bytedance/trae/home/solo/setting/EntUsage;->premiumModelFastAmount Ljava/lang/Double;
    goto +3h
    move-object/from16 v9, v21
    and-int/lit16 v10, v1, 256
    if-eqz v10, +005h
    iget-object v10, v0, Lcom/bytedance/trae/home/solo/setting/EntUsage;->premiumModelSlowAmount Ljava/lang/Double;
    goto +3h
    move-object/from16 v10, v22
    and-int/lit16 v11, v1, 512
    if-eqz v11, +005h
    iget-object v11, v0, Lcom/bytedance/trae/home/solo/setting/EntUsage;->basicUsageAmount Ljava/lang/Double;
    goto +3h
    move-object/from16 v11, v23
    and-int/lit16 v12, v1, 1024
    if-eqz v12, +005h
    iget-object v12, v0, Lcom/bytedance/trae/home/solo/setting/EntUsage;->bonusUsageAmount Ljava/lang/Double;
    goto +3h
    move-object/from16 v12, v24
    and-int/lit16 v1, v1, 2048
    if-eqz v1, +005h
    iget-object v1, v0, Lcom/bytedance/trae/home/solo/setting/EntUsage;->creditsAmount Ljava/lang/Double;
    goto +3h
    move-object/from16 v1, v25
    move-object v14, v2
    move-object v15, v3
    move-object/from16 v16, v4
    move-object/from16 v17, v5
    move-object/from16 v18, v6
    move-object/from16 v19, v7
    move-object/from16 v20, v8
    move-object/from16 v21, v9
    move-object/from16 v22, v10
    move-object/from16 v23, v11
    move-object/from16 v24, v12
    move-object/from16 v25, v1
    invoke-virtual/range v13 ... v25, Lcom/bytedance/trae/home/solo/setting/EntUsage;->copy(Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Boolean; Ljava/lang/Double; Ljava/lang/Double; Ljava/lang/Double; Ljava/lang/Double; Ljava/lang/Double; Ljava/lang/Double; Ljava/lang/Double;)Lcom/bytedance/trae/home/solo/setting/EntUsage;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntUsage;->advancedModelRequestUsage Ljava/lang/Long;
    return-object v0
.end method

.method public final component10()java.lang.Double
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntUsage;->basicUsageAmount Ljava/lang/Double;
    return-object v0
.end method

.method public final component11()java.lang.Double
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntUsage;->bonusUsageAmount Ljava/lang/Double;
    return-object v0
.end method

.method public final component12()java.lang.Double
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntUsage;->creditsAmount Ljava/lang/Double;
    return-object v0
.end method

.method public final component2()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntUsage;->autoCompletionUsage Ljava/lang/Long;
    return-object v0
.end method

.method public final component3()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntUsage;->premiumModelFastRequestUsage Ljava/lang/Long;
    return-object v0
.end method

.method public final component4()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntUsage;->premiumModelSlowRequestUsage Ljava/lang/Long;
    return-object v0
.end method

.method public final component5()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntUsage;->isFlashConsuming Ljava/lang/Boolean;
    return-object v0
.end method

.method public final component6()java.lang.Double
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntUsage;->autoCompletionAmount Ljava/lang/Double;
    return-object v0
.end method

.method public final component7()java.lang.Double
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntUsage;->advancedModelAmount Ljava/lang/Double;
    return-object v0
.end method

.method public final component8()java.lang.Double
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntUsage;->premiumModelFastAmount Ljava/lang/Double;
    return-object v0
.end method

.method public final component9()java.lang.Double
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntUsage;->premiumModelSlowAmount Ljava/lang/Double;
    return-object v0
.end method

.method public final copy(java.lang.Long  java.lang.Long  java.lang.Long  java.lang.Long  java.lang.Boolean  java.lang.Double  java.lang.Double  java.lang.Double  java.lang.Double  java.lang.Double  java.lang.Double  java.lang.Double)com.bytedance.trae.home.solo.setting.EntUsage
    .registers 27
    # ins_size=13
    new-instance v13, Lcom/bytedance/trae/home/solo/setting/EntUsage;
    move-object v0, v13
    move-object v1, v15
    move-object/from16 v2, v16
    move-object/from16 v3, v17
    move-object/from16 v4, v18
    move-object/from16 v5, v19
    move-object/from16 v6, v20
    move-object/from16 v7, v21
    move-object/from16 v8, v22
    move-object/from16 v9, v23
    move-object/from16 v10, v24
    move-object/from16 v11, v25
    move-object/from16 v12, v26
    invoke-direct/range v0 ... v12, Lcom/bytedance/trae/home/solo/setting/EntUsage;-><init>(Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Boolean; Ljava/lang/Double; Ljava/lang/Double; Ljava/lang/Double; Ljava/lang/Double; Ljava/lang/Double; Ljava/lang/Double; Ljava/lang/Double;)V
    return-object v13
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/home/solo/setting/EntUsage;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/home/solo/setting/EntUsage;
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/EntUsage;->advancedModelRequestUsage Ljava/lang/Long;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/EntUsage;->advancedModelRequestUsage Ljava/lang/Long;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/EntUsage;->autoCompletionUsage Ljava/lang/Long;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/EntUsage;->autoCompletionUsage Ljava/lang/Long;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/EntUsage;->premiumModelFastRequestUsage Ljava/lang/Long;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/EntUsage;->premiumModelFastRequestUsage Ljava/lang/Long;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/EntUsage;->premiumModelSlowRequestUsage Ljava/lang/Long;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/EntUsage;->premiumModelSlowRequestUsage Ljava/lang/Long;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/EntUsage;->isFlashConsuming Ljava/lang/Boolean;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/EntUsage;->isFlashConsuming Ljava/lang/Boolean;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/EntUsage;->autoCompletionAmount Ljava/lang/Double;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/EntUsage;->autoCompletionAmount Ljava/lang/Double;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/EntUsage;->advancedModelAmount Ljava/lang/Double;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/EntUsage;->advancedModelAmount Ljava/lang/Double;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/EntUsage;->premiumModelFastAmount Ljava/lang/Double;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/EntUsage;->premiumModelFastAmount Ljava/lang/Double;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/EntUsage;->premiumModelSlowAmount Ljava/lang/Double;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/EntUsage;->premiumModelSlowAmount Ljava/lang/Double;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/EntUsage;->basicUsageAmount Ljava/lang/Double;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/EntUsage;->basicUsageAmount Ljava/lang/Double;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/EntUsage;->bonusUsageAmount Ljava/lang/Double;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/EntUsage;->bonusUsageAmount Ljava/lang/Double;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/EntUsage;->creditsAmount Ljava/lang/Double;
    iget-object v5, v5, Lcom/bytedance/trae/home/solo/setting/EntUsage;->creditsAmount Ljava/lang/Double;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getAdvancedModelAmount()java.lang.Double
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntUsage;->advancedModelAmount Ljava/lang/Double;
    return-object v0
.end method

.method public final getAdvancedModelRequestUsage()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntUsage;->advancedModelRequestUsage Ljava/lang/Long;
    return-object v0
.end method

.method public final getAutoCompletionAmount()java.lang.Double
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntUsage;->autoCompletionAmount Ljava/lang/Double;
    return-object v0
.end method

.method public final getAutoCompletionUsage()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntUsage;->autoCompletionUsage Ljava/lang/Long;
    return-object v0
.end method

.method public final getBasicUsageAmount()java.lang.Double
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntUsage;->basicUsageAmount Ljava/lang/Double;
    return-object v0
.end method

.method public final getBonusUsageAmount()java.lang.Double
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntUsage;->bonusUsageAmount Ljava/lang/Double;
    return-object v0
.end method

.method public final getCreditsAmount()java.lang.Double
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntUsage;->creditsAmount Ljava/lang/Double;
    return-object v0
.end method

.method public final getPremiumModelFastAmount()java.lang.Double
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntUsage;->premiumModelFastAmount Ljava/lang/Double;
    return-object v0
.end method

.method public final getPremiumModelFastRequestUsage()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntUsage;->premiumModelFastRequestUsage Ljava/lang/Long;
    return-object v0
.end method

.method public final getPremiumModelSlowAmount()java.lang.Double
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntUsage;->premiumModelSlowAmount Ljava/lang/Double;
    return-object v0
.end method

.method public final getPremiumModelSlowRequestUsage()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntUsage;->premiumModelSlowRequestUsage Ljava/lang/Long;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/setting/EntUsage;->advancedModelRequestUsage Ljava/lang/Long;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Ljava/lang/Object;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntUsage;->autoCompletionUsage Ljava/lang/Long;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntUsage;->premiumModelFastRequestUsage Ljava/lang/Long;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntUsage;->premiumModelSlowRequestUsage Ljava/lang/Long;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntUsage;->isFlashConsuming Ljava/lang/Boolean;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntUsage;->autoCompletionAmount Ljava/lang/Double;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntUsage;->advancedModelAmount Ljava/lang/Double;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntUsage;->premiumModelFastAmount Ljava/lang/Double;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntUsage;->premiumModelSlowAmount Ljava/lang/Double;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntUsage;->basicUsageAmount Ljava/lang/Double;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntUsage;->bonusUsageAmount Ljava/lang/Double;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntUsage;->creditsAmount Ljava/lang/Double;
    if-nez v2, +003h
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public final isFlashConsuming()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntUsage;->isFlashConsuming Ljava/lang/Boolean;
    return-object v0
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "EntUsage(advancedModelRequestUsage="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/setting/EntUsage;->advancedModelRequestUsage Ljava/lang/Long;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", autoCompletionUsage="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntUsage;->autoCompletionUsage Ljava/lang/Long;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", premiumModelFastRequestUsage="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntUsage;->premiumModelFastRequestUsage Ljava/lang/Long;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", premiumModelSlowRequestUsage="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntUsage;->premiumModelSlowRequestUsage Ljava/lang/Long;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", isFlashConsuming="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntUsage;->isFlashConsuming Ljava/lang/Boolean;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", autoCompletionAmount="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntUsage;->autoCompletionAmount Ljava/lang/Double;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", advancedModelAmount="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntUsage;->advancedModelAmount Ljava/lang/Double;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", premiumModelFastAmount="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntUsage;->premiumModelFastAmount Ljava/lang/Double;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", premiumModelSlowAmount="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntUsage;->premiumModelSlowAmount Ljava/lang/Double;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", basicUsageAmount="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntUsage;->basicUsageAmount Ljava/lang/Double;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", bonusUsageAmount="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntUsage;->bonusUsageAmount Ljava/lang/Double;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", creditsAmount="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/setting/EntUsage;->creditsAmount Ljava/lang/Double;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const/16 v2, 41
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
