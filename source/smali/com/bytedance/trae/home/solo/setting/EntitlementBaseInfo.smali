# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;
.super Ljava/lang/Object;
.source "UserEntStatusApi.kt"

.field public static final $stable:I
.field private final chargeAmount:Ljava/lang/Long;
.field private final currency:Ljava/lang/Integer;
.field private final endTime:Ljava/lang/Long;
.field private final entStatus:Ljava/lang/Integer;
.field private final entitlementId:Ljava/lang/String;
.field private final productExtra:Lcom/bytedance/trae/home/solo/setting/EntProductExtra;
.field private final productId:Ljava/lang/Long;
.field private final productType:Ljava/lang/Integer;
.field private final quota:Lcom/bytedance/trae/home/solo/setting/EntQuota;
.field private final startTime:Ljava/lang/Long;
.field private final userId:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>()void
    .registers 15
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
    const/16 v12, 2047
    const/4 v13, 0
    move-object v0, v14
    invoke-direct/range v0 ... v13, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Lcom/bytedance/trae/home/solo/setting/EntQuota; Ljava/lang/Long; Ljava/lang/Long; Lcom/bytedance/trae/home/solo/setting/EntProductExtra; Ljava/lang/Long; Ljava/lang/Integer; Ljava/lang/Long; Ljava/lang/Integer; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(java.lang.String  java.lang.String  java.lang.Integer  com.bytedance.trae.home.solo.setting.EntQuota  java.lang.Long  java.lang.Long  com.bytedance.trae.home.solo.setting.EntProductExtra  java.lang.Long  java.lang.Integer  java.lang.Long  java.lang.Integer)void
    .registers 12
    # ins_size=12
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->entitlementId Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->userId Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->productType Ljava/lang/Integer;
    iput-object v4, v0, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->quota Lcom/bytedance/trae/home/solo/setting/EntQuota;
    iput-object v5, v0, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->startTime Ljava/lang/Long;
    iput-object v6, v0, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->endTime Ljava/lang/Long;
    iput-object v7, v0, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->productExtra Lcom/bytedance/trae/home/solo/setting/EntProductExtra;
    iput-object v8, v0, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->chargeAmount Ljava/lang/Long;
    iput-object v9, v0, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->currency Ljava/lang/Integer;
    iput-object v10, v0, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->productId Ljava/lang/Long;
    iput-object v11, v0, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->entStatus Ljava/lang/Integer;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  java.lang.String  java.lang.Integer  com.bytedance.trae.home.solo.setting.EntQuota  java.lang.Long  java.lang.Long  com.bytedance.trae.home.solo.setting.EntProductExtra  java.lang.Long  java.lang.Integer  java.lang.Long  java.lang.Integer  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 26
    # ins_size=14
    move/from16 v0, v24
    and-int/lit8 v1, v0, 1
    const/4 v2, 0
    if-eqz v1, +004h
    move-object v1, v2
    goto +2h
    move-object v1, v13
    and-int/lit8 v3, v0, 2
    if-eqz v3, +004h
    move-object v3, v2
    goto +2h
    move-object v3, v14
    and-int/lit8 v4, v0, 4
    if-eqz v4, +004h
    move-object v4, v2
    goto +2h
    move-object v4, v15
    and-int/lit8 v5, v0, 8
    if-eqz v5, +004h
    move-object v5, v2
    goto +3h
    move-object/from16 v5, v16
    and-int/lit8 v6, v0, 16
    if-eqz v6, +004h
    move-object v6, v2
    goto +3h
    move-object/from16 v6, v17
    and-int/lit8 v7, v0, 32
    if-eqz v7, +004h
    move-object v7, v2
    goto +3h
    move-object/from16 v7, v18
    and-int/lit8 v8, v0, 64
    if-eqz v8, +004h
    move-object v8, v2
    goto +3h
    move-object/from16 v8, v19
    and-int/lit16 v9, v0, 128
    if-eqz v9, +004h
    move-object v9, v2
    goto +3h
    move-object/from16 v9, v20
    and-int/lit16 v10, v0, 256
    if-eqz v10, +004h
    move-object v10, v2
    goto +3h
    move-object/from16 v10, v21
    and-int/lit16 v11, v0, 512
    if-eqz v11, +004h
    move-object v11, v2
    goto +3h
    move-object/from16 v11, v22
    and-int/lit16 v0, v0, 1024
    if-eqz v0, +003h
    goto +3h
    move-object/from16 v2, v23
    move-object v13, v12
    move-object v14, v1
    move-object v15, v3
    move-object/from16 v16, v4
    move-object/from16 v17, v5
    move-object/from16 v18, v6
    move-object/from16 v19, v7
    move-object/from16 v20, v8
    move-object/from16 v21, v9
    move-object/from16 v22, v10
    move-object/from16 v23, v11
    move-object/from16 v24, v2
    invoke-direct/range v13 ... v24, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Lcom/bytedance/trae/home/solo/setting/EntQuota; Ljava/lang/Long; Ljava/lang/Long; Lcom/bytedance/trae/home/solo/setting/EntProductExtra; Ljava/lang/Long; Ljava/lang/Integer; Ljava/lang/Long; Ljava/lang/Integer;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.home.solo.setting.EntitlementBaseInfo  java.lang.String  java.lang.String  java.lang.Integer  com.bytedance.trae.home.solo.setting.EntQuota  java.lang.Long  java.lang.Long  com.bytedance.trae.home.solo.setting.EntProductExtra  java.lang.Long  java.lang.Integer  java.lang.Long  java.lang.Integer  int  java.lang.Object)com.bytedance.trae.home.solo.setting.EntitlementBaseInfo
    .registers 26
    # ins_size=14
    move-object v0, v12
    move/from16 v1, v24
    and-int/lit8 v2, v1, 1
    if-eqz v2, +005h
    iget-object v2, v0, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->entitlementId Ljava/lang/String;
    goto +2h
    move-object v2, v13
    and-int/lit8 v3, v1, 2
    if-eqz v3, +005h
    iget-object v3, v0, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->userId Ljava/lang/String;
    goto +2h
    move-object v3, v14
    and-int/lit8 v4, v1, 4
    if-eqz v4, +005h
    iget-object v4, v0, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->productType Ljava/lang/Integer;
    goto +2h
    move-object v4, v15
    and-int/lit8 v5, v1, 8
    if-eqz v5, +005h
    iget-object v5, v0, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->quota Lcom/bytedance/trae/home/solo/setting/EntQuota;
    goto +3h
    move-object/from16 v5, v16
    and-int/lit8 v6, v1, 16
    if-eqz v6, +005h
    iget-object v6, v0, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->startTime Ljava/lang/Long;
    goto +3h
    move-object/from16 v6, v17
    and-int/lit8 v7, v1, 32
    if-eqz v7, +005h
    iget-object v7, v0, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->endTime Ljava/lang/Long;
    goto +3h
    move-object/from16 v7, v18
    and-int/lit8 v8, v1, 64
    if-eqz v8, +005h
    iget-object v8, v0, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->productExtra Lcom/bytedance/trae/home/solo/setting/EntProductExtra;
    goto +3h
    move-object/from16 v8, v19
    and-int/lit16 v9, v1, 128
    if-eqz v9, +005h
    iget-object v9, v0, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->chargeAmount Ljava/lang/Long;
    goto +3h
    move-object/from16 v9, v20
    and-int/lit16 v10, v1, 256
    if-eqz v10, +005h
    iget-object v10, v0, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->currency Ljava/lang/Integer;
    goto +3h
    move-object/from16 v10, v21
    and-int/lit16 v11, v1, 512
    if-eqz v11, +005h
    iget-object v11, v0, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->productId Ljava/lang/Long;
    goto +3h
    move-object/from16 v11, v22
    and-int/lit16 v1, v1, 1024
    if-eqz v1, +005h
    iget-object v1, v0, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->entStatus Ljava/lang/Integer;
    goto +3h
    move-object/from16 v1, v23
    move-object v13, v2
    move-object v14, v3
    move-object v15, v4
    move-object/from16 v16, v5
    move-object/from16 v17, v6
    move-object/from16 v18, v7
    move-object/from16 v19, v8
    move-object/from16 v20, v9
    move-object/from16 v21, v10
    move-object/from16 v22, v11
    move-object/from16 v23, v1
    invoke-virtual/range v12 ... v23, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->copy(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Lcom/bytedance/trae/home/solo/setting/EntQuota; Ljava/lang/Long; Ljava/lang/Long; Lcom/bytedance/trae/home/solo/setting/EntProductExtra; Ljava/lang/Long; Ljava/lang/Integer; Ljava/lang/Long; Ljava/lang/Integer;)Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->entitlementId Ljava/lang/String;
    return-object v0
.end method

.method public final component10()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->productId Ljava/lang/Long;
    return-object v0
.end method

.method public final component11()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->entStatus Ljava/lang/Integer;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->userId Ljava/lang/String;
    return-object v0
.end method

.method public final component3()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->productType Ljava/lang/Integer;
    return-object v0
.end method

.method public final component4()com.bytedance.trae.home.solo.setting.EntQuota
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->quota Lcom/bytedance/trae/home/solo/setting/EntQuota;
    return-object v0
.end method

.method public final component5()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->startTime Ljava/lang/Long;
    return-object v0
.end method

.method public final component6()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->endTime Ljava/lang/Long;
    return-object v0
.end method

.method public final component7()com.bytedance.trae.home.solo.setting.EntProductExtra
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->productExtra Lcom/bytedance/trae/home/solo/setting/EntProductExtra;
    return-object v0
.end method

.method public final component8()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->chargeAmount Ljava/lang/Long;
    return-object v0
.end method

.method public final component9()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->currency Ljava/lang/Integer;
    return-object v0
.end method

.method public final copy(java.lang.String  java.lang.String  java.lang.Integer  com.bytedance.trae.home.solo.setting.EntQuota  java.lang.Long  java.lang.Long  com.bytedance.trae.home.solo.setting.EntProductExtra  java.lang.Long  java.lang.Integer  java.lang.Long  java.lang.Integer)com.bytedance.trae.home.solo.setting.EntitlementBaseInfo
    .registers 25
    # ins_size=12
    new-instance v12, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;
    move-object v0, v12
    move-object v1, v14
    move-object v2, v15
    move-object/from16 v3, v16
    move-object/from16 v4, v17
    move-object/from16 v5, v18
    move-object/from16 v6, v19
    move-object/from16 v7, v20
    move-object/from16 v8, v21
    move-object/from16 v9, v22
    move-object/from16 v10, v23
    move-object/from16 v11, v24
    invoke-direct/range v0 ... v11, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Lcom/bytedance/trae/home/solo/setting/EntQuota; Ljava/lang/Long; Ljava/lang/Long; Lcom/bytedance/trae/home/solo/setting/EntProductExtra; Ljava/lang/Long; Ljava/lang/Integer; Ljava/lang/Long; Ljava/lang/Integer;)V
    return-object v12
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->entitlementId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->entitlementId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->userId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->userId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->productType Ljava/lang/Integer;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->productType Ljava/lang/Integer;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->quota Lcom/bytedance/trae/home/solo/setting/EntQuota;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->quota Lcom/bytedance/trae/home/solo/setting/EntQuota;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->startTime Ljava/lang/Long;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->startTime Ljava/lang/Long;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->endTime Ljava/lang/Long;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->endTime Ljava/lang/Long;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->productExtra Lcom/bytedance/trae/home/solo/setting/EntProductExtra;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->productExtra Lcom/bytedance/trae/home/solo/setting/EntProductExtra;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->chargeAmount Ljava/lang/Long;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->chargeAmount Ljava/lang/Long;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->currency Ljava/lang/Integer;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->currency Ljava/lang/Integer;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->productId Ljava/lang/Long;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->productId Ljava/lang/Long;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->entStatus Ljava/lang/Integer;
    iget-object v5, v5, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->entStatus Ljava/lang/Integer;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getChargeAmount()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->chargeAmount Ljava/lang/Long;
    return-object v0
.end method

.method public final getCurrency()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->currency Ljava/lang/Integer;
    return-object v0
.end method

.method public final getEndTime()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->endTime Ljava/lang/Long;
    return-object v0
.end method

.method public final getEntStatus()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->entStatus Ljava/lang/Integer;
    return-object v0
.end method

.method public final getEntitlementId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->entitlementId Ljava/lang/String;
    return-object v0
.end method

.method public final getProductExtra()com.bytedance.trae.home.solo.setting.EntProductExtra
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->productExtra Lcom/bytedance/trae/home/solo/setting/EntProductExtra;
    return-object v0
.end method

.method public final getProductId()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->productId Ljava/lang/Long;
    return-object v0
.end method

.method public final getProductType()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->productType Ljava/lang/Integer;
    return-object v0
.end method

.method public final getQuota()com.bytedance.trae.home.solo.setting.EntQuota
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->quota Lcom/bytedance/trae/home/solo/setting/EntQuota;
    return-object v0
.end method

.method public final getStartTime()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->startTime Ljava/lang/Long;
    return-object v0
.end method

.method public final getUserId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->userId Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->entitlementId Ljava/lang/String;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->userId Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->productType Ljava/lang/Integer;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->quota Lcom/bytedance/trae/home/solo/setting/EntQuota;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/EntQuota;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->startTime Ljava/lang/Long;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->endTime Ljava/lang/Long;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->productExtra Lcom/bytedance/trae/home/solo/setting/EntProductExtra;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/EntProductExtra;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->chargeAmount Ljava/lang/Long;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->currency Ljava/lang/Integer;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->productId Ljava/lang/Long;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->entStatus Ljava/lang/Integer;
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
    const-string v1, "EntitlementBaseInfo(entitlementId="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->entitlementId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", userId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->userId Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", productType="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->productType Ljava/lang/Integer;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", quota="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->quota Lcom/bytedance/trae/home/solo/setting/EntQuota;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", startTime="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->startTime Ljava/lang/Long;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", endTime="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->endTime Ljava/lang/Long;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", productExtra="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->productExtra Lcom/bytedance/trae/home/solo/setting/EntProductExtra;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", chargeAmount="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->chargeAmount Ljava/lang/Long;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", currency="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->currency Ljava/lang/Integer;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", productId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->productId Ljava/lang/Long;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", entStatus="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/EntitlementBaseInfo;->entStatus Ljava/lang/Integer;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const/16 v2, 41
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
