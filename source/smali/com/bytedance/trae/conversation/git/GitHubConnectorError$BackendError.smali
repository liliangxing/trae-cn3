# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/git/GitHubConnectorError$BackendError;
.super Lcom/bytedance/trae/conversation/git/GitHubConnectorError;
.source "GitHubConnectorError.kt"

.field private final body:Ljava/lang/String;
.field private final statusCode:I


.method public constructor <init>(int  java.lang.String)void
    .registers 5
    # ins_size=3
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "Backend request failed (HTTP "
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ")."
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    const/4 v1, 0
    invoke-direct v2, v0, v1, Lcom/bytedance/trae/conversation/git/GitHubConnectorError;-><init>(Ljava/lang/String; Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput v3, v2, Lcom/bytedance/trae/conversation/git/GitHubConnectorError$BackendError;->statusCode I
    iput-object v4, v2, Lcom/bytedance/trae/conversation/git/GitHubConnectorError$BackendError;->body Ljava/lang/String;
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.git.GitHubConnectorError$BackendError  int  java.lang.String  int  java.lang.Object)com.bytedance.trae.conversation.git.GitHubConnectorError$BackendError
    .registers 5
    # ins_size=5
    and-int/lit8 v4, v3, 1
    if-eqz v4, +004h
    iget v1, v0, Lcom/bytedance/trae/conversation/git/GitHubConnectorError$BackendError;->statusCode I
    and-int/lit8 v3, v3, 2
    if-eqz v3, +004h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/git/GitHubConnectorError$BackendError;->body Ljava/lang/String;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/git/GitHubConnectorError$BackendError;->copy(I Ljava/lang/String;)Lcom/bytedance/trae/conversation/git/GitHubConnectorError$BackendError;
    move-result-object v0
    return-object v0
.end method

.method public final component1()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/git/GitHubConnectorError$BackendError;->statusCode I
    return v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/git/GitHubConnectorError$BackendError;->body Ljava/lang/String;
    return-object v0
.end method

.method public final copy(int  java.lang.String)com.bytedance.trae.conversation.git.GitHubConnectorError$BackendError
    .registers 4
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/conversation/git/GitHubConnectorError$BackendError;
    invoke-direct v0, v2, v3, Lcom/bytedance/trae/conversation/git/GitHubConnectorError$BackendError;-><init>(I Ljava/lang/String;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/git/GitHubConnectorError$BackendError;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/git/GitHubConnectorError$BackendError;
    iget v1, v4, Lcom/bytedance/trae/conversation/git/GitHubConnectorError$BackendError;->statusCode I
    iget v3, v5, Lcom/bytedance/trae/conversation/git/GitHubConnectorError$BackendError;->statusCode I
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/git/GitHubConnectorError$BackendError;->body Ljava/lang/String;
    iget-object v5, v5, Lcom/bytedance/trae/conversation/git/GitHubConnectorError$BackendError;->body Ljava/lang/String;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getBody()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/git/GitHubConnectorError$BackendError;->body Ljava/lang/String;
    return-object v0
.end method

.method public final getStatusCode()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/git/GitHubConnectorError$BackendError;->statusCode I
    return v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget v0, v2, Lcom/bytedance/trae/conversation/git/GitHubConnectorError$BackendError;->statusCode I
    invoke-static v0, Ljava/lang/Integer;->hashCode(I)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/git/GitHubConnectorError$BackendError;->body Ljava/lang/String;
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
    const-string v1, "BackendError(statusCode="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget v1, v2, Lcom/bytedance/trae/conversation/git/GitHubConnectorError$BackendError;->statusCode I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", body="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/git/GitHubConnectorError$BackendError;->body Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
