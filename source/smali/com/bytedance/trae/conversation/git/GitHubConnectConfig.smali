# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/git/GitHubConnectConfig;
.super Ljava/lang/Object;
.source "GitHubConnectConfig.kt"

.implements Ljava/io/Serializable;

.field private static final APP_SLUG_CN:Ljava/lang/String;
.field private static final APP_SLUG_OVERSEA:Ljava/lang/String;
.field private static final CLIENT_ID_CN:Ljava/lang/String;
.field private static final CLIENT_ID_OVERSEA:Ljava/lang/String;
.field public static final Companion:Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$Companion;
.field private final gitHubApp:Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$GitHubApp;
.field private final oauth:Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$OAuth;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig;->Companion Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$Companion;
    return-void 
.end method

.method public constructor <init>(com.bytedance.trae.conversation.git.GitHubConnectConfig$OAuth  com.bytedance.trae.conversation.git.GitHubConnectConfig$GitHubApp)void
    .registers 4
    # ins_size=3
    const-string v0, "oauth"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "gitHubApp"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig;->oauth Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$OAuth;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig;->gitHubApp Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$GitHubApp;
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.git.GitHubConnectConfig  com.bytedance.trae.conversation.git.GitHubConnectConfig$OAuth  com.bytedance.trae.conversation.git.GitHubConnectConfig$GitHubApp  int  java.lang.Object)com.bytedance.trae.conversation.git.GitHubConnectConfig
    .registers 5
    # ins_size=5
    and-int/lit8 v4, v3, 1
    if-eqz v4, +004h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig;->oauth Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$OAuth;
    and-int/lit8 v3, v3, 2
    if-eqz v3, +004h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig;->gitHubApp Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$GitHubApp;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig;->copy(Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$OAuth; Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$GitHubApp;)Lcom/bytedance/trae/conversation/git/GitHubConnectConfig;
    move-result-object v0
    return-object v0
.end method

.method public final component1()com.bytedance.trae.conversation.git.GitHubConnectConfig$OAuth
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig;->oauth Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$OAuth;
    return-object v0
.end method

.method public final component2()com.bytedance.trae.conversation.git.GitHubConnectConfig$GitHubApp
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig;->gitHubApp Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$GitHubApp;
    return-object v0
.end method

.method public final copy(com.bytedance.trae.conversation.git.GitHubConnectConfig$OAuth  com.bytedance.trae.conversation.git.GitHubConnectConfig$GitHubApp)com.bytedance.trae.conversation.git.GitHubConnectConfig
    .registers 4
    # ins_size=3
    const-string v0, "oauth"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "gitHubApp"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig;
    invoke-direct v0, v2, v3, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig;-><init>(Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$OAuth; Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$GitHubApp;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig;->oauth Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$OAuth;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig;->oauth Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$OAuth;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig;->gitHubApp Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$GitHubApp;
    iget-object v5, v5, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig;->gitHubApp Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$GitHubApp;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getGitHubApp()com.bytedance.trae.conversation.git.GitHubConnectConfig$GitHubApp
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig;->gitHubApp Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$GitHubApp;
    return-object v0
.end method

.method public final getOauth()com.bytedance.trae.conversation.git.GitHubConnectConfig$OAuth
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig;->oauth Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$OAuth;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig;->oauth Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$OAuth;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$OAuth;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig;->gitHubApp Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$GitHubApp;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$GitHubApp;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "GitHubConnectConfig(oauth="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig;->oauth Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$OAuth;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", gitHubApp="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig;->gitHubApp Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$GitHubApp;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
