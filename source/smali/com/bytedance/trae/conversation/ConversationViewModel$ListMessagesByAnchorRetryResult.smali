# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRetryResult;
.super Ljava/lang/Object;
.source "ConversationViewModel.kt"

.field private final request:Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRequest;
.field private final result:Lcom/bytedance/trae/network/response/HttpDataResult;


.method public constructor <init>(com.bytedance.trae.network.response.HttpDataResult  com.bytedance.trae.conversation.ConversationViewModel$ListMessagesByAnchorRequest)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, result
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, request
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRetryResult;->result Lcom/bytedance/trae/network/response/HttpDataResult;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRetryResult;->request Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRequest;
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.ConversationViewModel$ListMessagesByAnchorRetryResult  com.bytedance.trae.network.response.HttpDataResult  com.bytedance.trae.conversation.ConversationViewModel$ListMessagesByAnchorRequest  int  java.lang.Object)com.bytedance.trae.conversation.ConversationViewModel$ListMessagesByAnchorRetryResult
    .registers 5
    # ins_size=5
    and-int/lit8 v4, v3, 1
    if-eqz v4, +004h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRetryResult;->result Lcom/bytedance/trae/network/response/HttpDataResult;
    and-int/lit8 v3, v3, 2
    if-eqz v3, +004h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRetryResult;->request Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRequest;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRetryResult;->copy(Lcom/bytedance/trae/network/response/HttpDataResult; Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRequest;)Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRetryResult;
    move-result-object v0
    return-object v0
.end method

.method public final component1()com.bytedance.trae.network.response.HttpDataResult
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRetryResult;->result Lcom/bytedance/trae/network/response/HttpDataResult;
    return-object v0
.end method

.method public final component2()com.bytedance.trae.conversation.ConversationViewModel$ListMessagesByAnchorRequest
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRetryResult;->request Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRequest;
    return-object v0
.end method

.method public final copy(com.bytedance.trae.network.response.HttpDataResult  com.bytedance.trae.conversation.ConversationViewModel$ListMessagesByAnchorRequest)com.bytedance.trae.conversation.ConversationViewModel$ListMessagesByAnchorRetryResult
    .registers 4
    # ins_size=3
    const-string/jumbo v0, result
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, request
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRetryResult;
    invoke-direct v0, v2, v3, Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRetryResult;-><init>(Lcom/bytedance/trae/network/response/HttpDataResult; Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRequest;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRetryResult;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRetryResult;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRetryResult;->result Lcom/bytedance/trae/network/response/HttpDataResult;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRetryResult;->result Lcom/bytedance/trae/network/response/HttpDataResult;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRetryResult;->request Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRequest;
    iget-object v5, v5, Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRetryResult;->request Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRequest;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getRequest()com.bytedance.trae.conversation.ConversationViewModel$ListMessagesByAnchorRequest
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRetryResult;->request Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRequest;
    return-object v0
.end method

.method public final getResult()com.bytedance.trae.network.response.HttpDataResult
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRetryResult;->result Lcom/bytedance/trae/network/response/HttpDataResult;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRetryResult;->result Lcom/bytedance/trae/network/response/HttpDataResult;
    invoke-virtual v0, Lcom/bytedance/trae/network/response/HttpDataResult;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRetryResult;->request Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRequest;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRequest;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "ListMessagesByAnchorRetryResult(result="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRetryResult;->result Lcom/bytedance/trae/network/response/HttpDataResult;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", request="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRetryResult;->request Lcom/bytedance/trae/conversation/ConversationViewModel$ListMessagesByAnchorRequest;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
