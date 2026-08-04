# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/api/LoginDeviceInfo;
.super Ljava/lang/Object;
.source "ILoginService.kt"

.field private final boundProducts:Ljava/util/List;
.field private final clientVersion:Ljava/lang/String;
.field private final currentDevice:Z
.field private final deviceId:Ljava/lang/String;
.field private final deviceModel:Ljava/lang/String;
.field private final deviceName:Ljava/lang/String;
.field private final deviceType:Ljava/lang/String;
.field private final firstBoundAt:Ljava/lang/Long;
.field private final lastActiveAt:Ljava/lang/Long;
.field private final lastLoginIp:Ljava/lang/String;
.field private final osVersion:Ljava/lang/String;
.field private final platformCode:Ljava/lang/String;
.field private final status:Ljava/lang/String;


.method public constructor <init>(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Long  java.lang.Long  boolean  java.util.List)void
    .registers 15
    # ins_size=14
    const-string v0, "boundProducts"
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->deviceId Ljava/lang/String;
    iput-object v3, v1, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->deviceName Ljava/lang/String;
    iput-object v4, v1, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->deviceType Ljava/lang/String;
    iput-object v5, v1, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->platformCode Ljava/lang/String;
    iput-object v6, v1, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->clientVersion Ljava/lang/String;
    iput-object v7, v1, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->deviceModel Ljava/lang/String;
    iput-object v8, v1, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->osVersion Ljava/lang/String;
    iput-object v9, v1, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->lastLoginIp Ljava/lang/String;
    iput-object v10, v1, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->status Ljava/lang/String;
    iput-object v11, v1, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->firstBoundAt Ljava/lang/Long;
    iput-object v12, v1, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->lastActiveAt Ljava/lang/Long;
    iput-boolean v13, v1, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->currentDevice Z
    iput-object v14, v1, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->boundProducts Ljava/util/List;
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.login.api.LoginDeviceInfo  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Long  java.lang.Long  boolean  java.util.List  int  java.lang.Object)com.bytedance.trae.login.api.LoginDeviceInfo
    .registers 30
    # ins_size=16
    move-object v0, v14
    move/from16 v1, v28
    and-int/lit8 v2, v1, 1
    if-eqz v2, +005h
    iget-object v2, v0, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->deviceId Ljava/lang/String;
    goto +2h
    move-object v2, v15
    and-int/lit8 v3, v1, 2
    if-eqz v3, +005h
    iget-object v3, v0, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->deviceName Ljava/lang/String;
    goto +3h
    move-object/from16 v3, v16
    and-int/lit8 v4, v1, 4
    if-eqz v4, +005h
    iget-object v4, v0, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->deviceType Ljava/lang/String;
    goto +3h
    move-object/from16 v4, v17
    and-int/lit8 v5, v1, 8
    if-eqz v5, +005h
    iget-object v5, v0, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->platformCode Ljava/lang/String;
    goto +3h
    move-object/from16 v5, v18
    and-int/lit8 v6, v1, 16
    if-eqz v6, +005h
    iget-object v6, v0, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->clientVersion Ljava/lang/String;
    goto +3h
    move-object/from16 v6, v19
    and-int/lit8 v7, v1, 32
    if-eqz v7, +005h
    iget-object v7, v0, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->deviceModel Ljava/lang/String;
    goto +3h
    move-object/from16 v7, v20
    and-int/lit8 v8, v1, 64
    if-eqz v8, +005h
    iget-object v8, v0, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->osVersion Ljava/lang/String;
    goto +3h
    move-object/from16 v8, v21
    and-int/lit16 v9, v1, 128
    if-eqz v9, +005h
    iget-object v9, v0, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->lastLoginIp Ljava/lang/String;
    goto +3h
    move-object/from16 v9, v22
    and-int/lit16 v10, v1, 256
    if-eqz v10, +005h
    iget-object v10, v0, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->status Ljava/lang/String;
    goto +3h
    move-object/from16 v10, v23
    and-int/lit16 v11, v1, 512
    if-eqz v11, +005h
    iget-object v11, v0, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->firstBoundAt Ljava/lang/Long;
    goto +3h
    move-object/from16 v11, v24
    and-int/lit16 v12, v1, 1024
    if-eqz v12, +005h
    iget-object v12, v0, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->lastActiveAt Ljava/lang/Long;
    goto +3h
    move-object/from16 v12, v25
    and-int/lit16 v13, v1, 2048
    if-eqz v13, +005h
    iget-boolean v13, v0, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->currentDevice Z
    goto +3h
    move/from16 v13, v26
    and-int/lit16 v1, v1, 4096
    if-eqz v1, +005h
    iget-object v1, v0, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->boundProducts Ljava/util/List;
    goto +3h
    move-object/from16 v1, v27
    move-object v15, v2
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
    move/from16 v26, v13
    move-object/from16 v27, v1
    invoke-virtual/range v14 ... v27, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->copy(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/Long; Z Ljava/util/List;)Lcom/bytedance/trae/login/api/LoginDeviceInfo;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->deviceId Ljava/lang/String;
    return-object v0
.end method

.method public final component10()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->firstBoundAt Ljava/lang/Long;
    return-object v0
.end method

.method public final component11()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->lastActiveAt Ljava/lang/Long;
    return-object v0
.end method

.method public final component12()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->currentDevice Z
    return v0
.end method

.method public final component13()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->boundProducts Ljava/util/List;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->deviceName Ljava/lang/String;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->deviceType Ljava/lang/String;
    return-object v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->platformCode Ljava/lang/String;
    return-object v0
.end method

.method public final component5()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->clientVersion Ljava/lang/String;
    return-object v0
.end method

.method public final component6()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->deviceModel Ljava/lang/String;
    return-object v0
.end method

.method public final component7()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->osVersion Ljava/lang/String;
    return-object v0
.end method

.method public final component8()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->lastLoginIp Ljava/lang/String;
    return-object v0
.end method

.method public final component9()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->status Ljava/lang/String;
    return-object v0
.end method

.method public final copy(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Long  java.lang.Long  boolean  java.util.List)com.bytedance.trae.login.api.LoginDeviceInfo
    .registers 29
    # ins_size=14
    const-string v0, "boundProducts"
    move-object/from16 v14, v28
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/login/api/LoginDeviceInfo;
    move-object v1, v0
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
    move/from16 v13, v27
    invoke-direct/range v1 ... v14, Lcom/bytedance/trae/login/api/LoginDeviceInfo;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/Long; Z Ljava/util/List;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/login/api/LoginDeviceInfo;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/login/api/LoginDeviceInfo;
    iget-object v1, v4, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->deviceId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->deviceId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->deviceName Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->deviceName Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->deviceType Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->deviceType Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->platformCode Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->platformCode Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->clientVersion Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->clientVersion Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->deviceModel Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->deviceModel Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->osVersion Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->osVersion Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->lastLoginIp Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->lastLoginIp Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->status Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->status Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->firstBoundAt Ljava/lang/Long;
    iget-object v3, v5, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->firstBoundAt Ljava/lang/Long;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->lastActiveAt Ljava/lang/Long;
    iget-object v3, v5, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->lastActiveAt Ljava/lang/Long;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->currentDevice Z
    iget-boolean v3, v5, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->currentDevice Z
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->boundProducts Ljava/util/List;
    iget-object v5, v5, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->boundProducts Ljava/util/List;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getBoundProducts()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->boundProducts Ljava/util/List;
    return-object v0
.end method

.method public final getClientVersion()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->clientVersion Ljava/lang/String;
    return-object v0
.end method

.method public final getCurrentDevice()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->currentDevice Z
    return v0
.end method

.method public final getDeviceId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->deviceId Ljava/lang/String;
    return-object v0
.end method

.method public final getDeviceModel()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->deviceModel Ljava/lang/String;
    return-object v0
.end method

.method public final getDeviceName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->deviceName Ljava/lang/String;
    return-object v0
.end method

.method public final getDeviceType()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->deviceType Ljava/lang/String;
    return-object v0
.end method

.method public final getFirstBoundAt()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->firstBoundAt Ljava/lang/Long;
    return-object v0
.end method

.method public final getLastActiveAt()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->lastActiveAt Ljava/lang/Long;
    return-object v0
.end method

.method public final getLastLoginIp()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->lastLoginIp Ljava/lang/String;
    return-object v0
.end method

.method public final getOsVersion()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->osVersion Ljava/lang/String;
    return-object v0
.end method

.method public final getPlatformCode()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->platformCode Ljava/lang/String;
    return-object v0
.end method

.method public final getStatus()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->status Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->deviceId Ljava/lang/String;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->deviceName Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->deviceType Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->platformCode Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->clientVersion Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->deviceModel Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->osVersion Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->lastLoginIp Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->status Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->firstBoundAt Ljava/lang/Long;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->lastActiveAt Ljava/lang/Long;
    if-nez v2, +003h
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v3, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->currentDevice Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->boundProducts Ljava/util/List;
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "LoginDeviceInfo(deviceId="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v3, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->deviceId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", deviceName="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->deviceName Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", deviceType="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->deviceType Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", platformCode="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->platformCode Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", clientVersion="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->clientVersion Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", deviceModel="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->deviceModel Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", osVersion="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->osVersion Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", lastLoginIp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->lastLoginIp Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", status="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->status Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", firstBoundAt="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->firstBoundAt Ljava/lang/Long;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", lastActiveAt="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->lastActiveAt Ljava/lang/Long;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", currentDevice="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    iget-boolean v1, v3, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->currentDevice Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", boundProducts="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/login/api/LoginDeviceInfo;->boundProducts Ljava/util/List;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const/16 v2, 41
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
