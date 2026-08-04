# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;
.super Ljava/lang/Object;
.source "EnterpriseAuthModels.kt"

.field private final code:I
.field private final data:Ljava/lang/Object;
.field private final hostInfo:Lcom/bytedance/trae/login/enterprise/EnterpriseHostInfo;
.field private final message:Ljava/lang/String;


.method public constructor <init>()void
    .registers 8
    # ins_size=1
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/16 v5, 15
    const/4 v6, 0
    move-object v0, v7
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;-><init>(I Ljava/lang/String; Ljava/lang/Object; Lcom/bytedance/trae/login/enterprise/EnterpriseHostInfo; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(int  java.lang.String  java.lang.Object  com.bytedance.trae.login.enterprise.EnterpriseHostInfo)void
    .registers 5
    # ins_size=5
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput v1, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;->code I
    iput-object v2, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;->message Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;->data Ljava/lang/Object;
    iput-object v4, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;->hostInfo Lcom/bytedance/trae/login/enterprise/EnterpriseHostInfo;
    return-void 
.end method

.method public synthetic constructor <init>(int  java.lang.String  java.lang.Object  com.bytedance.trae.login.enterprise.EnterpriseHostInfo  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 8
    # ins_size=7
    and-int/lit8 v7, v6, 1
    if-eqz v7, +003h
    const/4 v2, -1
    and-int/lit8 v7, v6, 2
    const/4 v0, 0
    if-eqz v7, +003h
    move-object v3, v0
    and-int/lit8 v7, v6, 4
    if-eqz v7, +003h
    move-object v4, v0
    and-int/lit8 v6, v6, 8
    if-eqz v6, +003h
    move-object v5, v0
    invoke-direct v1, v2, v3, v4, v5, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;-><init>(I Ljava/lang/String; Ljava/lang/Object; Lcom/bytedance/trae/login/enterprise/EnterpriseHostInfo;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.login.enterprise.EnterpriseResponse  int  java.lang.String  java.lang.Object  com.bytedance.trae.login.enterprise.EnterpriseHostInfo  int  java.lang.Object)com.bytedance.trae.login.enterprise.EnterpriseResponse
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 1
    if-eqz v6, +004h
    iget v1, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;->code I
    and-int/lit8 v6, v5, 2
    if-eqz v6, +004h
    iget-object v2, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;->message Ljava/lang/String;
    and-int/lit8 v6, v5, 4
    if-eqz v6, +004h
    iget-object v3, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;->data Ljava/lang/Object;
    and-int/lit8 v5, v5, 8
    if-eqz v5, +004h
    iget-object v4, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;->hostInfo Lcom/bytedance/trae/login/enterprise/EnterpriseHostInfo;
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;->copy(I Ljava/lang/String; Ljava/lang/Object; Lcom/bytedance/trae/login/enterprise/EnterpriseHostInfo;)Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;
    move-result-object v0
    return-object v0
.end method

.method public final component1()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;->code I
    return v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;->message Ljava/lang/String;
    return-object v0
.end method

.method public final component3()java.lang.Object
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;->data Ljava/lang/Object;
    return-object v0
.end method

.method public final component4()com.bytedance.trae.login.enterprise.EnterpriseHostInfo
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;->hostInfo Lcom/bytedance/trae/login/enterprise/EnterpriseHostInfo;
    return-object v0
.end method

.method public final copy(int  java.lang.String  java.lang.Object  com.bytedance.trae.login.enterprise.EnterpriseHostInfo)com.bytedance.trae.login.enterprise.EnterpriseResponse
    .registers 6
    # ins_size=5
    new-instance v0, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;
    invoke-direct v0, v2, v3, v4, v5, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;-><init>(I Ljava/lang/String; Ljava/lang/Object; Lcom/bytedance/trae/login/enterprise/EnterpriseHostInfo;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;
    iget v1, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;->code I
    iget v3, v5, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;->code I
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;->message Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;->message Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;->data Ljava/lang/Object;
    iget-object v3, v5, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;->data Ljava/lang/Object;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;->hostInfo Lcom/bytedance/trae/login/enterprise/EnterpriseHostInfo;
    iget-object v5, v5, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;->hostInfo Lcom/bytedance/trae/login/enterprise/EnterpriseHostInfo;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getCode()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;->code I
    return v0
.end method

.method public final getData()java.lang.Object
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;->data Ljava/lang/Object;
    return-object v0
.end method

.method public final getHostInfo()com.bytedance.trae.login.enterprise.EnterpriseHostInfo
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;->hostInfo Lcom/bytedance/trae/login/enterprise/EnterpriseHostInfo;
    return-object v0
.end method

.method public final getMessage()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;->message Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget v0, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;->code I
    invoke-static v0, Ljava/lang/Integer;->hashCode(I)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;->message Ljava/lang/String;
    const/4 v2, 0
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;->data Ljava/lang/Object;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;->hostInfo Lcom/bytedance/trae/login/enterprise/EnterpriseHostInfo;
    if-nez v1, +003h
    goto +5h
    invoke-virtual v1, Lcom/bytedance/trae/login/enterprise/EnterpriseHostInfo;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "EnterpriseResponse(code="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget v1, v2, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;->code I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", message="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;->message Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", data="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;->data Ljava/lang/Object;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", hostInfo="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;->hostInfo Lcom/bytedance/trae/login/enterprise/EnterpriseHostInfo;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
