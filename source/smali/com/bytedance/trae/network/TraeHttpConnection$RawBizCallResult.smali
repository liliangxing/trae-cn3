# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/network/TraeHttpConnection$RawBizCallResult;
.super Ljava/lang/Object;
.source "TraeHttpConnection.kt"

.field private final body:Ljava/lang/String;
.field private final result:Lcom/bytedance/trae/network/response/HttpDataResult;
.field private final ssResponse:Lcom/bytedance/retrofit2/SsResponse;


.method public constructor <init>(com.bytedance.trae.network.response.HttpDataResult  java.lang.String  com.bytedance.retrofit2.SsResponse)void
    .registers 5
    # ins_size=4
    const-string/jumbo v0, result
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/network/TraeHttpConnection$RawBizCallResult;->result Lcom/bytedance/trae/network/response/HttpDataResult;
    iput-object v3, v1, Lcom/bytedance/trae/network/TraeHttpConnection$RawBizCallResult;->body Ljava/lang/String;
    iput-object v4, v1, Lcom/bytedance/trae/network/TraeHttpConnection$RawBizCallResult;->ssResponse Lcom/bytedance/retrofit2/SsResponse;
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.network.TraeHttpConnection$RawBizCallResult  com.bytedance.trae.network.response.HttpDataResult  java.lang.String  com.bytedance.retrofit2.SsResponse  int  java.lang.Object)com.bytedance.trae.network.TraeHttpConnection$RawBizCallResult
    .registers 6
    # ins_size=6
    and-int/lit8 v5, v4, 1
    if-eqz v5, +004h
    iget-object v1, v0, Lcom/bytedance/trae/network/TraeHttpConnection$RawBizCallResult;->result Lcom/bytedance/trae/network/response/HttpDataResult;
    and-int/lit8 v5, v4, 2
    if-eqz v5, +004h
    iget-object v2, v0, Lcom/bytedance/trae/network/TraeHttpConnection$RawBizCallResult;->body Ljava/lang/String;
    and-int/lit8 v4, v4, 4
    if-eqz v4, +004h
    iget-object v3, v0, Lcom/bytedance/trae/network/TraeHttpConnection$RawBizCallResult;->ssResponse Lcom/bytedance/retrofit2/SsResponse;
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/network/TraeHttpConnection$RawBizCallResult;->copy(Lcom/bytedance/trae/network/response/HttpDataResult; Ljava/lang/String; Lcom/bytedance/retrofit2/SsResponse;)Lcom/bytedance/trae/network/TraeHttpConnection$RawBizCallResult;
    move-result-object v0
    return-object v0
.end method

.method public final component1()com.bytedance.trae.network.response.HttpDataResult
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/network/TraeHttpConnection$RawBizCallResult;->result Lcom/bytedance/trae/network/response/HttpDataResult;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/network/TraeHttpConnection$RawBizCallResult;->body Ljava/lang/String;
    return-object v0
.end method

.method public final component3()com.bytedance.retrofit2.SsResponse
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/network/TraeHttpConnection$RawBizCallResult;->ssResponse Lcom/bytedance/retrofit2/SsResponse;
    return-object v0
.end method

.method public final copy(com.bytedance.trae.network.response.HttpDataResult  java.lang.String  com.bytedance.retrofit2.SsResponse)com.bytedance.trae.network.TraeHttpConnection$RawBizCallResult
    .registers 5
    # ins_size=4
    const-string/jumbo v0, result
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/network/TraeHttpConnection$RawBizCallResult;
    invoke-direct v0, v2, v3, v4, Lcom/bytedance/trae/network/TraeHttpConnection$RawBizCallResult;-><init>(Lcom/bytedance/trae/network/response/HttpDataResult; Ljava/lang/String; Lcom/bytedance/retrofit2/SsResponse;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/network/TraeHttpConnection$RawBizCallResult;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/network/TraeHttpConnection$RawBizCallResult;
    iget-object v1, v4, Lcom/bytedance/trae/network/TraeHttpConnection$RawBizCallResult;->result Lcom/bytedance/trae/network/response/HttpDataResult;
    iget-object v3, v5, Lcom/bytedance/trae/network/TraeHttpConnection$RawBizCallResult;->result Lcom/bytedance/trae/network/response/HttpDataResult;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/network/TraeHttpConnection$RawBizCallResult;->body Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/network/TraeHttpConnection$RawBizCallResult;->body Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/network/TraeHttpConnection$RawBizCallResult;->ssResponse Lcom/bytedance/retrofit2/SsResponse;
    iget-object v5, v5, Lcom/bytedance/trae/network/TraeHttpConnection$RawBizCallResult;->ssResponse Lcom/bytedance/retrofit2/SsResponse;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getBody()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/network/TraeHttpConnection$RawBizCallResult;->body Ljava/lang/String;
    return-object v0
.end method

.method public final getResult()com.bytedance.trae.network.response.HttpDataResult
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/network/TraeHttpConnection$RawBizCallResult;->result Lcom/bytedance/trae/network/response/HttpDataResult;
    return-object v0
.end method

.method public final getSsResponse()com.bytedance.retrofit2.SsResponse
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/network/TraeHttpConnection$RawBizCallResult;->ssResponse Lcom/bytedance/retrofit2/SsResponse;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/network/TraeHttpConnection$RawBizCallResult;->result Lcom/bytedance/trae/network/response/HttpDataResult;
    invoke-virtual v0, Lcom/bytedance/trae/network/response/HttpDataResult;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/network/TraeHttpConnection$RawBizCallResult;->body Ljava/lang/String;
    const/4 v2, 0
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/network/TraeHttpConnection$RawBizCallResult;->ssResponse Lcom/bytedance/retrofit2/SsResponse;
    if-nez v1, +003h
    goto +5h
    invoke-virtual v1, Lcom/bytedance/retrofit2/SsResponse;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "RawBizCallResult(result="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/network/TraeHttpConnection$RawBizCallResult;->result Lcom/bytedance/trae/network/response/HttpDataResult;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", body="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/network/TraeHttpConnection$RawBizCallResult;->body Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", ssResponse="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/network/TraeHttpConnection$RawBizCallResult;->ssResponse Lcom/bytedance/retrofit2/SsResponse;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
