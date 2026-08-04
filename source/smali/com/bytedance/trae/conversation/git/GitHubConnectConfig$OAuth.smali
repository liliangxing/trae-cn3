# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$OAuth;
.super Ljava/lang/Object;
.source "GitHubConnectConfig.kt"

.implements Ljava/io/Serializable;

.field private final authorizeEndpoint:Ljava/lang/String;
.field private final clientId:Ljava/lang/String;
.field private final redirectUri:Ljava/lang/String;
.field private final scope:Ljava/lang/String;


.method public constructor <init>(java.lang.String  java.lang.String  java.lang.String  java.lang.String)void
    .registers 6
    # ins_size=5
    const-string v0, "clientId"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "redirectUri"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, scope
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "authorizeEndpoint"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$OAuth;->clientId Ljava/lang/String;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$OAuth;->redirectUri Ljava/lang/String;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$OAuth;->scope Ljava/lang/String;
    iput-object v5, v1, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$OAuth;->authorizeEndpoint Ljava/lang/String;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  java.lang.String  java.lang.String  java.lang.String  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 4
    if-eqz v6, +005h
    const-string/jumbo v3, repo read:user
    and-int/lit8 v5, v5, 8
    if-eqz v5, +004h
    const-string v4, "https://github.com/login/oauth/authorize"
    invoke-direct v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$OAuth;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.git.GitHubConnectConfig$OAuth  java.lang.String  java.lang.String  java.lang.String  java.lang.String  int  java.lang.Object)com.bytedance.trae.conversation.git.GitHubConnectConfig$OAuth
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 1
    if-eqz v6, +004h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$OAuth;->clientId Ljava/lang/String;
    and-int/lit8 v6, v5, 2
    if-eqz v6, +004h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$OAuth;->redirectUri Ljava/lang/String;
    and-int/lit8 v6, v5, 4
    if-eqz v6, +004h
    iget-object v3, v0, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$OAuth;->scope Ljava/lang/String;
    and-int/lit8 v5, v5, 8
    if-eqz v5, +004h
    iget-object v4, v0, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$OAuth;->authorizeEndpoint Ljava/lang/String;
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$OAuth;->copy(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$OAuth;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$OAuth;->clientId Ljava/lang/String;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$OAuth;->redirectUri Ljava/lang/String;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$OAuth;->scope Ljava/lang/String;
    return-object v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$OAuth;->authorizeEndpoint Ljava/lang/String;
    return-object v0
.end method

.method public final copy(java.lang.String  java.lang.String  java.lang.String  java.lang.String)com.bytedance.trae.conversation.git.GitHubConnectConfig$OAuth
    .registers 6
    # ins_size=5
    const-string v0, "clientId"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "redirectUri"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, scope
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "authorizeEndpoint"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$OAuth;
    invoke-direct v0, v2, v3, v4, v5, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$OAuth;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$OAuth;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$OAuth;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$OAuth;->clientId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$OAuth;->clientId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$OAuth;->redirectUri Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$OAuth;->redirectUri Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$OAuth;->scope Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$OAuth;->scope Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$OAuth;->authorizeEndpoint Ljava/lang/String;
    iget-object v5, v5, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$OAuth;->authorizeEndpoint Ljava/lang/String;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getAuthorizeEndpoint()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$OAuth;->authorizeEndpoint Ljava/lang/String;
    return-object v0
.end method

.method public final getClientId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$OAuth;->clientId Ljava/lang/String;
    return-object v0
.end method

.method public final getRedirectUri()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$OAuth;->redirectUri Ljava/lang/String;
    return-object v0
.end method

.method public final getScope()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$OAuth;->scope Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$OAuth;->clientId Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$OAuth;->redirectUri Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$OAuth;->scope Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$OAuth;->authorizeEndpoint Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "OAuth(clientId="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$OAuth;->clientId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", redirectUri="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$OAuth;->redirectUri Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", scope="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$OAuth;->scope Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", authorizeEndpoint="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$OAuth;->authorizeEndpoint Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
