# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/traeauth/TraeResponse;
.super Ljava/lang/Object;
.source "TraeAuthModels.kt"

.field private final responseMetadata:Lcom/bytedance/trae/login/traeauth/TraeResponseMetadata;
.field private final result:Ljava/lang/Object;


.method public constructor <init>()void
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 3
    invoke-direct v2, v0, v0, v1, v0, Lcom/bytedance/trae/login/traeauth/TraeResponse;-><init>(Lcom/bytedance/trae/login/traeauth/TraeResponseMetadata; Ljava/lang/Object; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(com.bytedance.trae.login.traeauth.TraeResponseMetadata  java.lang.Object)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/login/traeauth/TraeResponse;->responseMetadata Lcom/bytedance/trae/login/traeauth/TraeResponseMetadata;
    iput-object v2, v0, Lcom/bytedance/trae/login/traeauth/TraeResponse;->result Ljava/lang/Object;
    return-void 
.end method

.method public synthetic constructor <init>(com.bytedance.trae.login.traeauth.TraeResponseMetadata  java.lang.Object  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 6
    # ins_size=5
    and-int/lit8 v5, v4, 1
    const/4 v0, 0
    if-eqz v5, +003h
    move-object v2, v0
    and-int/lit8 v4, v4, 2
    if-eqz v4, +003h
    move-object v3, v0
    invoke-direct v1, v2, v3, Lcom/bytedance/trae/login/traeauth/TraeResponse;-><init>(Lcom/bytedance/trae/login/traeauth/TraeResponseMetadata; Ljava/lang/Object;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.login.traeauth.TraeResponse  com.bytedance.trae.login.traeauth.TraeResponseMetadata  java.lang.Object  int  java.lang.Object)com.bytedance.trae.login.traeauth.TraeResponse
    .registers 5
    # ins_size=5
    and-int/lit8 v4, v3, 1
    if-eqz v4, +004h
    iget-object v1, v0, Lcom/bytedance/trae/login/traeauth/TraeResponse;->responseMetadata Lcom/bytedance/trae/login/traeauth/TraeResponseMetadata;
    and-int/lit8 v3, v3, 2
    if-eqz v3, +004h
    iget-object v2, v0, Lcom/bytedance/trae/login/traeauth/TraeResponse;->result Ljava/lang/Object;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/traeauth/TraeResponse;->copy(Lcom/bytedance/trae/login/traeauth/TraeResponseMetadata; Ljava/lang/Object;)Lcom/bytedance/trae/login/traeauth/TraeResponse;
    move-result-object v0
    return-object v0
.end method

.method public final component1()com.bytedance.trae.login.traeauth.TraeResponseMetadata
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeResponse;->responseMetadata Lcom/bytedance/trae/login/traeauth/TraeResponseMetadata;
    return-object v0
.end method

.method public final component2()java.lang.Object
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeResponse;->result Ljava/lang/Object;
    return-object v0
.end method

.method public final copy(com.bytedance.trae.login.traeauth.TraeResponseMetadata  java.lang.Object)com.bytedance.trae.login.traeauth.TraeResponse
    .registers 4
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/login/traeauth/TraeResponse;
    invoke-direct v0, v2, v3, Lcom/bytedance/trae/login/traeauth/TraeResponse;-><init>(Lcom/bytedance/trae/login/traeauth/TraeResponseMetadata; Ljava/lang/Object;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/login/traeauth/TraeResponse;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/login/traeauth/TraeResponse;
    iget-object v1, v4, Lcom/bytedance/trae/login/traeauth/TraeResponse;->responseMetadata Lcom/bytedance/trae/login/traeauth/TraeResponseMetadata;
    iget-object v3, v5, Lcom/bytedance/trae/login/traeauth/TraeResponse;->responseMetadata Lcom/bytedance/trae/login/traeauth/TraeResponseMetadata;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/login/traeauth/TraeResponse;->result Ljava/lang/Object;
    iget-object v5, v5, Lcom/bytedance/trae/login/traeauth/TraeResponse;->result Ljava/lang/Object;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getResponseMetadata()com.bytedance.trae.login.traeauth.TraeResponseMetadata
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeResponse;->responseMetadata Lcom/bytedance/trae/login/traeauth/TraeResponseMetadata;
    return-object v0
.end method

.method public final getResult()java.lang.Object
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeResponse;->result Ljava/lang/Object;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/login/traeauth/TraeResponse;->responseMetadata Lcom/bytedance/trae/login/traeauth/TraeResponseMetadata;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeResponseMetadata;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/login/traeauth/TraeResponse;->result Ljava/lang/Object;
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
    const-string v1, "TraeResponse(responseMetadata="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/login/traeauth/TraeResponse;->responseMetadata Lcom/bytedance/trae/login/traeauth/TraeResponseMetadata;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", result="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/login/traeauth/TraeResponse;->result Ljava/lang/Object;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
