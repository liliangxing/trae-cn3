# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/service/IChatSessionApi$Companion$ChatSessionRawParseResult;
.super Ljava/lang/Object;
.source "IChatSessionApi.kt"

.field private final bizResp:Lcom/bytedance/trae/network/response/BizResponse;
.field private final dataPresent:Z
.field private final hasSandboxKey:Z
.field private final sandboxJson:Ljava/lang/String;


.method public constructor <init>(com.bytedance.trae.network.response.BizResponse  boolean  boolean  java.lang.String)void
    .registers 6
    # ins_size=5
    const-string v0, "bizResp"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion$ChatSessionRawParseResult;->bizResp Lcom/bytedance/trae/network/response/BizResponse;
    iput-boolean v3, v1, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion$ChatSessionRawParseResult;->dataPresent Z
    iput-boolean v4, v1, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion$ChatSessionRawParseResult;->hasSandboxKey Z
    iput-object v5, v1, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion$ChatSessionRawParseResult;->sandboxJson Ljava/lang/String;
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.im.service.IChatSessionApi$Companion$ChatSessionRawParseResult  com.bytedance.trae.network.response.BizResponse  boolean  boolean  java.lang.String  int  java.lang.Object)com.bytedance.trae.im.service.IChatSessionApi$Companion$ChatSessionRawParseResult
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 1
    if-eqz v6, +004h
    iget-object v1, v0, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion$ChatSessionRawParseResult;->bizResp Lcom/bytedance/trae/network/response/BizResponse;
    and-int/lit8 v6, v5, 2
    if-eqz v6, +004h
    iget-boolean v2, v0, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion$ChatSessionRawParseResult;->dataPresent Z
    and-int/lit8 v6, v5, 4
    if-eqz v6, +004h
    iget-boolean v3, v0, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion$ChatSessionRawParseResult;->hasSandboxKey Z
    and-int/lit8 v5, v5, 8
    if-eqz v5, +004h
    iget-object v4, v0, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion$ChatSessionRawParseResult;->sandboxJson Ljava/lang/String;
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion$ChatSessionRawParseResult;->copy(Lcom/bytedance/trae/network/response/BizResponse; Z Z Ljava/lang/String;)Lcom/bytedance/trae/im/service/IChatSessionApi$Companion$ChatSessionRawParseResult;
    move-result-object v0
    return-object v0
.end method

.method public final component1()com.bytedance.trae.network.response.BizResponse
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion$ChatSessionRawParseResult;->bizResp Lcom/bytedance/trae/network/response/BizResponse;
    return-object v0
.end method

.method public final component2()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion$ChatSessionRawParseResult;->dataPresent Z
    return v0
.end method

.method public final component3()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion$ChatSessionRawParseResult;->hasSandboxKey Z
    return v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion$ChatSessionRawParseResult;->sandboxJson Ljava/lang/String;
    return-object v0
.end method

.method public final copy(com.bytedance.trae.network.response.BizResponse  boolean  boolean  java.lang.String)com.bytedance.trae.im.service.IChatSessionApi$Companion$ChatSessionRawParseResult
    .registers 6
    # ins_size=5
    const-string v0, "bizResp"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion$ChatSessionRawParseResult;
    invoke-direct v0, v2, v3, v4, v5, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion$ChatSessionRawParseResult;-><init>(Lcom/bytedance/trae/network/response/BizResponse; Z Z Ljava/lang/String;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion$ChatSessionRawParseResult;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion$ChatSessionRawParseResult;
    iget-object v1, v4, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion$ChatSessionRawParseResult;->bizResp Lcom/bytedance/trae/network/response/BizResponse;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion$ChatSessionRawParseResult;->bizResp Lcom/bytedance/trae/network/response/BizResponse;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion$ChatSessionRawParseResult;->dataPresent Z
    iget-boolean v3, v5, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion$ChatSessionRawParseResult;->dataPresent Z
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion$ChatSessionRawParseResult;->hasSandboxKey Z
    iget-boolean v3, v5, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion$ChatSessionRawParseResult;->hasSandboxKey Z
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion$ChatSessionRawParseResult;->sandboxJson Ljava/lang/String;
    iget-object v5, v5, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion$ChatSessionRawParseResult;->sandboxJson Ljava/lang/String;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getBizResp()com.bytedance.trae.network.response.BizResponse
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion$ChatSessionRawParseResult;->bizResp Lcom/bytedance/trae/network/response/BizResponse;
    return-object v0
.end method

.method public final getDataPresent()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion$ChatSessionRawParseResult;->dataPresent Z
    return v0
.end method

.method public final getHasSandboxKey()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion$ChatSessionRawParseResult;->hasSandboxKey Z
    return v0
.end method

.method public final getSandboxJson()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion$ChatSessionRawParseResult;->sandboxJson Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion$ChatSessionRawParseResult;->bizResp Lcom/bytedance/trae/network/response/BizResponse;
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion$ChatSessionRawParseResult;->dataPresent Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion$ChatSessionRawParseResult;->hasSandboxKey Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion$ChatSessionRawParseResult;->sandboxJson Ljava/lang/String;
    if-nez v1, +004h
    const/4 v1, 0
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "ChatSessionRawParseResult(bizResp="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion$ChatSessionRawParseResult;->bizResp Lcom/bytedance/trae/network/response/BizResponse;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", dataPresent="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion$ChatSessionRawParseResult;->dataPresent Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", hasSandboxKey="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion$ChatSessionRawParseResult;->hasSandboxKey Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", sandboxJson="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion$ChatSessionRawParseResult;->sandboxJson Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
