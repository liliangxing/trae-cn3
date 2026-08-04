# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;
.super Ljava/lang/Object;
.source "TraeAuthModels.kt"

.field private final clientId:Ljava/lang/String;
.field private final deviceBindStatus:Ljava/lang/String;
.field private final isDeviceLimit:Ljava/lang/Boolean;
.field private final refreshExpireAt:Ljava/lang/Long;
.field private final refreshToken:Ljava/lang/String;
.field private final token:Ljava/lang/String;
.field private final tokenExpireAt:Ljava/lang/Long;
.field private final tokenExpireDuration:Ljava/lang/Long;


.method public constructor <init>()void
    .registers 12
    # ins_size=1
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/16 v9, 255
    const/4 v10, 0
    move-object v0, v11
    invoke-direct/range v0 ... v10, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;-><init>(Ljava/lang/Boolean; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(java.lang.Boolean  java.lang.String  java.lang.String  java.lang.Long  java.lang.String  java.lang.Long  java.lang.Long  java.lang.String)void
    .registers 9
    # ins_size=9
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->isDeviceLimit Ljava/lang/Boolean;
    iput-object v2, v0, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->clientId Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->token Ljava/lang/String;
    iput-object v4, v0, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->tokenExpireAt Ljava/lang/Long;
    iput-object v5, v0, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->refreshToken Ljava/lang/String;
    iput-object v6, v0, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->refreshExpireAt Ljava/lang/Long;
    iput-object v7, v0, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->tokenExpireDuration Ljava/lang/Long;
    iput-object v8, v0, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->deviceBindStatus Ljava/lang/String;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.Boolean  java.lang.String  java.lang.String  java.lang.Long  java.lang.String  java.lang.Long  java.lang.Long  java.lang.String  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 20
    # ins_size=11
    move/from16 v0, v18
    and-int/lit8 v1, v0, 1
    const/4 v2, 0
    if-eqz v1, +004h
    move-object v1, v2
    goto +2h
    move-object v1, v10
    and-int/lit8 v3, v0, 2
    if-eqz v3, +004h
    move-object v3, v2
    goto +2h
    move-object v3, v11
    and-int/lit8 v4, v0, 4
    if-eqz v4, +004h
    move-object v4, v2
    goto +2h
    move-object v4, v12
    and-int/lit8 v5, v0, 8
    if-eqz v5, +004h
    move-object v5, v2
    goto +2h
    move-object v5, v13
    and-int/lit8 v6, v0, 16
    if-eqz v6, +004h
    move-object v6, v2
    goto +2h
    move-object v6, v14
    and-int/lit8 v7, v0, 32
    if-eqz v7, +004h
    move-object v7, v2
    goto +2h
    move-object v7, v15
    and-int/lit8 v8, v0, 64
    if-eqz v8, +004h
    move-object v8, v2
    goto +3h
    move-object/from16 v8, v16
    and-int/lit16 v0, v0, 128
    if-eqz v0, +003h
    goto +3h
    move-object/from16 v2, v17
    move-object v10, v9
    move-object v11, v1
    move-object v12, v3
    move-object v13, v4
    move-object v14, v5
    move-object v15, v6
    move-object/from16 v16, v7
    move-object/from16 v17, v8
    move-object/from16 v18, v2
    invoke-direct/range v10 ... v18, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;-><init>(Ljava/lang/Boolean; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.login.traeauth.TraeExchangeTokenResult  java.lang.Boolean  java.lang.String  java.lang.String  java.lang.Long  java.lang.String  java.lang.Long  java.lang.Long  java.lang.String  int  java.lang.Object)com.bytedance.trae.login.traeauth.TraeExchangeTokenResult
    .registers 20
    # ins_size=11
    move-object v0, v9
    move/from16 v1, v18
    and-int/lit8 v2, v1, 1
    if-eqz v2, +005h
    iget-object v2, v0, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->isDeviceLimit Ljava/lang/Boolean;
    goto +2h
    move-object v2, v10
    and-int/lit8 v3, v1, 2
    if-eqz v3, +005h
    iget-object v3, v0, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->clientId Ljava/lang/String;
    goto +2h
    move-object v3, v11
    and-int/lit8 v4, v1, 4
    if-eqz v4, +005h
    iget-object v4, v0, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->token Ljava/lang/String;
    goto +2h
    move-object v4, v12
    and-int/lit8 v5, v1, 8
    if-eqz v5, +005h
    iget-object v5, v0, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->tokenExpireAt Ljava/lang/Long;
    goto +2h
    move-object v5, v13
    and-int/lit8 v6, v1, 16
    if-eqz v6, +005h
    iget-object v6, v0, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->refreshToken Ljava/lang/String;
    goto +2h
    move-object v6, v14
    and-int/lit8 v7, v1, 32
    if-eqz v7, +005h
    iget-object v7, v0, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->refreshExpireAt Ljava/lang/Long;
    goto +2h
    move-object v7, v15
    and-int/lit8 v8, v1, 64
    if-eqz v8, +005h
    iget-object v8, v0, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->tokenExpireDuration Ljava/lang/Long;
    goto +3h
    move-object/from16 v8, v16
    and-int/lit16 v1, v1, 128
    if-eqz v1, +005h
    iget-object v1, v0, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->deviceBindStatus Ljava/lang/String;
    goto +3h
    move-object/from16 v1, v17
    move-object v10, v2
    move-object v11, v3
    move-object v12, v4
    move-object v13, v5
    move-object v14, v6
    move-object v15, v7
    move-object/from16 v16, v8
    move-object/from16 v17, v1
    invoke-virtual/range v9 ... v17, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->copy(Ljava/lang/Boolean; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/String;)Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->isDeviceLimit Ljava/lang/Boolean;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->clientId Ljava/lang/String;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->token Ljava/lang/String;
    return-object v0
.end method

.method public final component4()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->tokenExpireAt Ljava/lang/Long;
    return-object v0
.end method

.method public final component5()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->refreshToken Ljava/lang/String;
    return-object v0
.end method

.method public final component6()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->refreshExpireAt Ljava/lang/Long;
    return-object v0
.end method

.method public final component7()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->tokenExpireDuration Ljava/lang/Long;
    return-object v0
.end method

.method public final component8()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->deviceBindStatus Ljava/lang/String;
    return-object v0
.end method

.method public final copy(java.lang.Boolean  java.lang.String  java.lang.String  java.lang.Long  java.lang.String  java.lang.Long  java.lang.Long  java.lang.String)com.bytedance.trae.login.traeauth.TraeExchangeTokenResult
    .registers 19
    # ins_size=9
    new-instance v9, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;
    move-object v0, v9
    move-object v1, v11
    move-object v2, v12
    move-object v3, v13
    move-object v4, v14
    move-object v5, v15
    move-object/from16 v6, v16
    move-object/from16 v7, v17
    move-object/from16 v8, v18
    invoke-direct/range v0 ... v8, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;-><init>(Ljava/lang/Boolean; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/String;)V
    return-object v9
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;
    iget-object v1, v4, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->isDeviceLimit Ljava/lang/Boolean;
    iget-object v3, v5, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->isDeviceLimit Ljava/lang/Boolean;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->clientId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->clientId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->token Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->token Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->tokenExpireAt Ljava/lang/Long;
    iget-object v3, v5, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->tokenExpireAt Ljava/lang/Long;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->refreshToken Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->refreshToken Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->refreshExpireAt Ljava/lang/Long;
    iget-object v3, v5, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->refreshExpireAt Ljava/lang/Long;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->tokenExpireDuration Ljava/lang/Long;
    iget-object v3, v5, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->tokenExpireDuration Ljava/lang/Long;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->deviceBindStatus Ljava/lang/String;
    iget-object v5, v5, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->deviceBindStatus Ljava/lang/String;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getClientId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->clientId Ljava/lang/String;
    return-object v0
.end method

.method public final getDeviceBindStatus()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->deviceBindStatus Ljava/lang/String;
    return-object v0
.end method

.method public final getRefreshExpireAt()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->refreshExpireAt Ljava/lang/Long;
    return-object v0
.end method

.method public final getRefreshToken()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->refreshToken Ljava/lang/String;
    return-object v0
.end method

.method public final getToken()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->token Ljava/lang/String;
    return-object v0
.end method

.method public final getTokenExpireAt()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->tokenExpireAt Ljava/lang/Long;
    return-object v0
.end method

.method public final getTokenExpireDuration()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->tokenExpireDuration Ljava/lang/Long;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->isDeviceLimit Ljava/lang/Boolean;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Ljava/lang/Object;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->clientId Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->token Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->tokenExpireAt Ljava/lang/Long;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->refreshToken Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->refreshExpireAt Ljava/lang/Long;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->tokenExpireDuration Ljava/lang/Long;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->deviceBindStatus Ljava/lang/String;
    if-nez v2, +003h
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public final isDeviceLimit()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->isDeviceLimit Ljava/lang/Boolean;
    return-object v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "TraeExchangeTokenResult(isDeviceLimit="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->isDeviceLimit Ljava/lang/Boolean;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", clientId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->clientId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", token="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->token Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", tokenExpireAt="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->tokenExpireAt Ljava/lang/Long;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", refreshToken="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->refreshToken Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", refreshExpireAt="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->refreshExpireAt Ljava/lang/Long;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", tokenExpireDuration="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->tokenExpireDuration Ljava/lang/Long;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", deviceBindStatus="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;->deviceBindStatus Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
