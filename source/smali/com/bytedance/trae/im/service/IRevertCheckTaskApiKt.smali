# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/service/IRevertCheckTaskApiKt;
.super Ljava/lang/Object;
.source "IRevertCheckTaskApi.kt"


.method public static final synthetic access$toHttpResultPreservingBizError(com.bytedance.trae.network.TraeHttpConnection$RawBizCallResult)com.bytedance.trae.network.response.HttpDataResult
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/im/service/IRevertCheckTaskApiKt;->toHttpResultPreservingBizError(Lcom/bytedance/trae/network/TraeHttpConnection$RawBizCallResult;)Lcom/bytedance/trae/network/response/HttpDataResult;
    move-result-object v0
    return-object v0
.end method

.method private static final toHttpResultPreservingBizError(com.bytedance.trae.network.TraeHttpConnection$RawBizCallResult)com.bytedance.trae.network.response.HttpDataResult
    .registers 10
    # ins_size=1
    invoke-virtual v9, Lcom/bytedance/trae/network/TraeHttpConnection$RawBizCallResult;->getResult()Lcom/bytedance/trae/network/response/HttpDataResult;
    move-result-object v0
    invoke-virtual v9, Lcom/bytedance/trae/network/TraeHttpConnection$RawBizCallResult;->getSsResponse()Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v9
    if-eqz v9, +00bh
    invoke-virtual v9, Lcom/bytedance/retrofit2/SsResponse;->code()I
    move-result v9
    invoke-static v9, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v9
    goto +2h
    const/4 v9, 0
    instance-of v1, v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v1, +03eh
    if-eqz v9, +03ch
    const/16 v1, 200
    invoke-virtual v9, Ljava/lang/Integer;->intValue()I
    move-result v9
    if-eq v9, v1, +034h
    new-instance v9, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v1
    long-to-int v3, v1
    invoke-virtual v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/network/response/BizResponse;->getMessage()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +010h
    invoke-virtual v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->getMsg()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    const-string v0, "Empty response body"
    move-object v4, v0
    goto +2h
    move-object v4, v1
    const/4 v5, 0
    const/4 v6, 0
    const/16 v7, 8
    const/4 v8, 0
    move-object v2, v9
    invoke-direct/range v2 ... v8, Lcom/bytedance/trae/network/response/HttpDataResult$Error;-><init>(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object v0, v9
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult;
    return-object v0
.end method
