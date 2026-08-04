# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/enterprise/EnterpriseExchangeTokenResult;
.super Ljava/lang/Object;
.source "EnterpriseAuthModels.kt"

.field private final refreshExpireAt:Ljava/lang/Long;
.field private final refreshToken:Ljava/lang/String;
.field private final token:Ljava/lang/String;
.field private final tokenExpireAt:Ljava/lang/Long;
.field private final tokenExpireDuration:Ljava/lang/Long;


.method public constructor <init>()void
    .registers 9
    # ins_size=1
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/16 v6, 31
    const/4 v7, 0
    move-object v0, v8
    invoke-direct/range v0 ... v7, Lcom/bytedance/trae/login/enterprise/EnterpriseExchangeTokenResult;-><init>(Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/Long; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(java.lang.String  java.lang.Long  java.lang.String  java.lang.Long  java.lang.Long)void
    .registers 6
    # ins_size=6
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseExchangeTokenResult;->token Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseExchangeTokenResult;->tokenExpireAt Ljava/lang/Long;
    iput-object v3, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseExchangeTokenResult;->refreshToken Ljava/lang/String;
    iput-object v4, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseExchangeTokenResult;->refreshExpireAt Ljava/lang/Long;
    iput-object v5, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseExchangeTokenResult;->tokenExpireDuration Ljava/lang/Long;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  java.lang.Long  java.lang.String  java.lang.Long  java.lang.Long  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 12
    # ins_size=8
    and-int/lit8 v11, v10, 1
    const/4 v0, 0
    if-eqz v11, +004h
    move-object v11, v0
    goto +2h
    move-object v11, v5
    and-int/lit8 v5, v10, 2
    if-eqz v5, +004h
    move-object v1, v0
    goto +2h
    move-object v1, v6
    and-int/lit8 v5, v10, 4
    if-eqz v5, +004h
    move-object v2, v0
    goto +2h
    move-object v2, v7
    and-int/lit8 v5, v10, 8
    if-eqz v5, +004h
    move-object v3, v0
    goto +2h
    move-object v3, v8
    and-int/lit8 v5, v10, 16
    if-eqz v5, +004h
    move-object v10, v0
    goto +2h
    move-object v10, v9
    move-object v5, v4
    move-object v6, v11
    move-object v7, v1
    move-object v8, v2
    move-object v9, v3
    invoke-direct/range v5 ... v10, Lcom/bytedance/trae/login/enterprise/EnterpriseExchangeTokenResult;-><init>(Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/Long;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.login.enterprise.EnterpriseExchangeTokenResult  java.lang.String  java.lang.Long  java.lang.String  java.lang.Long  java.lang.Long  int  java.lang.Object)com.bytedance.trae.login.enterprise.EnterpriseExchangeTokenResult
    .registers 11
    # ins_size=8
    and-int/lit8 v10, v9, 1
    if-eqz v10, +004h
    iget-object v4, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseExchangeTokenResult;->token Ljava/lang/String;
    and-int/lit8 v10, v9, 2
    if-eqz v10, +004h
    iget-object v5, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseExchangeTokenResult;->tokenExpireAt Ljava/lang/Long;
    move-object v10, v5
    and-int/lit8 v5, v9, 4
    if-eqz v5, +004h
    iget-object v6, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseExchangeTokenResult;->refreshToken Ljava/lang/String;
    move-object v0, v6
    and-int/lit8 v5, v9, 8
    if-eqz v5, +004h
    iget-object v7, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseExchangeTokenResult;->refreshExpireAt Ljava/lang/Long;
    move-object v1, v7
    and-int/lit8 v5, v9, 16
    if-eqz v5, +004h
    iget-object v8, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseExchangeTokenResult;->tokenExpireDuration Ljava/lang/Long;
    move-object v2, v8
    move-object v5, v3
    move-object v6, v4
    move-object v7, v10
    move-object v8, v0
    move-object v9, v1
    move-object v10, v2
    invoke-virtual/range v5 ... v10, Lcom/bytedance/trae/login/enterprise/EnterpriseExchangeTokenResult;->copy(Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/Long;)Lcom/bytedance/trae/login/enterprise/EnterpriseExchangeTokenResult;
    move-result-object v3
    return-object v3
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseExchangeTokenResult;->token Ljava/lang/String;
    return-object v0
.end method

.method public final component2()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseExchangeTokenResult;->tokenExpireAt Ljava/lang/Long;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseExchangeTokenResult;->refreshToken Ljava/lang/String;
    return-object v0
.end method

.method public final component4()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseExchangeTokenResult;->refreshExpireAt Ljava/lang/Long;
    return-object v0
.end method

.method public final component5()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseExchangeTokenResult;->tokenExpireDuration Ljava/lang/Long;
    return-object v0
.end method

.method public final copy(java.lang.String  java.lang.Long  java.lang.String  java.lang.Long  java.lang.Long)com.bytedance.trae.login.enterprise.EnterpriseExchangeTokenResult
    .registers 13
    # ins_size=6
    new-instance v6, Lcom/bytedance/trae/login/enterprise/EnterpriseExchangeTokenResult;
    move-object v0, v6
    move-object v1, v8
    move-object v2, v9
    move-object v3, v10
    move-object v4, v11
    move-object v5, v12
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/login/enterprise/EnterpriseExchangeTokenResult;-><init>(Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/Long;)V
    return-object v6
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/login/enterprise/EnterpriseExchangeTokenResult;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/login/enterprise/EnterpriseExchangeTokenResult;
    iget-object v1, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseExchangeTokenResult;->token Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/login/enterprise/EnterpriseExchangeTokenResult;->token Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseExchangeTokenResult;->tokenExpireAt Ljava/lang/Long;
    iget-object v3, v5, Lcom/bytedance/trae/login/enterprise/EnterpriseExchangeTokenResult;->tokenExpireAt Ljava/lang/Long;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseExchangeTokenResult;->refreshToken Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/login/enterprise/EnterpriseExchangeTokenResult;->refreshToken Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseExchangeTokenResult;->refreshExpireAt Ljava/lang/Long;
    iget-object v3, v5, Lcom/bytedance/trae/login/enterprise/EnterpriseExchangeTokenResult;->refreshExpireAt Ljava/lang/Long;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseExchangeTokenResult;->tokenExpireDuration Ljava/lang/Long;
    iget-object v5, v5, Lcom/bytedance/trae/login/enterprise/EnterpriseExchangeTokenResult;->tokenExpireDuration Ljava/lang/Long;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getRefreshExpireAt()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseExchangeTokenResult;->refreshExpireAt Ljava/lang/Long;
    return-object v0
.end method

.method public final getRefreshToken()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseExchangeTokenResult;->refreshToken Ljava/lang/String;
    return-object v0
.end method

.method public final getToken()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseExchangeTokenResult;->token Ljava/lang/String;
    return-object v0
.end method

.method public final getTokenExpireAt()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseExchangeTokenResult;->tokenExpireAt Ljava/lang/Long;
    return-object v0
.end method

.method public final getTokenExpireDuration()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseExchangeTokenResult;->tokenExpireDuration Ljava/lang/Long;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseExchangeTokenResult;->token Ljava/lang/String;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseExchangeTokenResult;->tokenExpireAt Ljava/lang/Long;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseExchangeTokenResult;->refreshToken Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseExchangeTokenResult;->refreshExpireAt Ljava/lang/Long;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseExchangeTokenResult;->tokenExpireDuration Ljava/lang/Long;
    if-nez v2, +003h
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "EnterpriseExchangeTokenResult(token="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/login/enterprise/EnterpriseExchangeTokenResult;->token Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", tokenExpireAt="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/login/enterprise/EnterpriseExchangeTokenResult;->tokenExpireAt Ljava/lang/Long;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", refreshToken="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/login/enterprise/EnterpriseExchangeTokenResult;->refreshToken Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", refreshExpireAt="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/login/enterprise/EnterpriseExchangeTokenResult;->refreshExpireAt Ljava/lang/Long;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", tokenExpireDuration="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/login/enterprise/EnterpriseExchangeTokenResult;->tokenExpireDuration Ljava/lang/Long;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
