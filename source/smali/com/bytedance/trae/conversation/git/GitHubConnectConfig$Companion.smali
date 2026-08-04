# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$Companion;
.super Ljava/lang/Object;
.source "GitHubConnectConfig.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$Companion;-><init>()V
    return-void 
.end method

.method public final shared(android.content.Context)com.bytedance.trae.conversation.git.GitHubConnectConfig
    .registers 11
    # ins_size=2
    const-string v0, "context"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v0
    if-eqz v0, +005h
    const-string v1, "Iv23li49AhCcfdXa9zKZ"
    goto +3h
    const-string v1, "Iv23liZK8tzQx0m4bCRd"
    move-object v3, v1
    if-eqz v0, +006h
    const-string/jumbo v0, trae-ai
    goto +4h
    const-string/jumbo v0, trae-ai-cn
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v10, Landroid/content/Context;->getPackageName()Ljava/lang/String;
    move-result-object v10
    invoke-virtual v1, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    const-string v1, "://github-connector-callback"
    invoke-virtual v10, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    new-instance v10, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig;
    new-instance v1, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$OAuth;
    const/4 v5, 0
    const/4 v6, 0
    const/16 v7, 12
    const/4 v8, 0
    move-object v2, v1
    invoke-direct/range v2 ... v8, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$OAuth;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    new-instance v2, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$GitHubApp;
    invoke-direct v2, v0, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$GitHubApp;-><init>(Ljava/lang/String;)V
    invoke-direct v10, v1, v2, Lcom/bytedance/trae/conversation/git/GitHubConnectConfig;-><init>(Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$OAuth; Lcom/bytedance/trae/conversation/git/GitHubConnectConfig$GitHubApp;)V
    return-object v10
.end method
