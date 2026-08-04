# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public abstract Lcom/bytedance/trae/conversation/git/GitHubConnectorError;
.super Ljava/lang/Exception;
.source "GitHubConnectorError.kt"


.method private constructor <init>(java.lang.String)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/git/GitHubConnectorError;-><init>(Ljava/lang/String;)V
    return-void 
.end method

.method public final localizedMessage(android.content.Context)java.lang.String
    .registers 7
    # ins_size=2
    const-string v0, "context"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    instance-of v0, v5, Lcom/bytedance/trae/conversation/git/GitHubConnectorError$InvalidAuthorizeUrl;
    const-string v1, "getString(...)"
    if-eqz v0, +00dh
    sget v0, Lcom/bytedance/trae/multilanguage/R$string;->trae_github_error_invalid_authorize_url I
    invoke-virtual v6, v0, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v6
    invoke-static v6, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto/16 +08bh
    instance-of v0, v5, Lcom/bytedance/trae/conversation/git/GitHubConnectorError$OAuthCancelled;
    if-eqz v0, +00dh
    sget v0, Lcom/bytedance/trae/multilanguage/R$string;->trae_github_error_oauth_cancelled I
    invoke-virtual v6, v0, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v6
    invoke-static v6, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto/16 +07ch
    instance-of v0, v5, Lcom/bytedance/trae/conversation/git/GitHubConnectorError$OAuthFailed;
    const/4 v2, 0
    const/4 v3, 1
    if-eqz v0, +017h
    sget v0, Lcom/bytedance/trae/multilanguage/R$string;->trae_github_error_oauth_failed I
    new-array v3, v3, [Ljava/lang/Object;
    move-object v4, v5
    check-cast v4, Lcom/bytedance/trae/conversation/git/GitHubConnectorError$OAuthFailed;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/git/GitHubConnectorError$OAuthFailed;->getDescription()Ljava/lang/String;
    move-result-object v4
    aput-object v4, v3, v2
    invoke-virtual v6, v0, v3, Landroid/content/Context;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v6
    invoke-static v6, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +60h
    instance-of v0, v5, Lcom/bytedance/trae/conversation/git/GitHubConnectorError$CallbackMissingUrl;
    if-eqz v0, +00ch
    sget v0, Lcom/bytedance/trae/multilanguage/R$string;->trae_github_error_callback_missing_url I
    invoke-virtual v6, v0, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v6
    invoke-static v6, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +52h
    instance-of v0, v5, Lcom/bytedance/trae/conversation/git/GitHubConnectorError$CallbackMissingCode;
    if-eqz v0, +00ch
    sget v0, Lcom/bytedance/trae/multilanguage/R$string;->trae_github_error_callback_missing_code I
    invoke-virtual v6, v0, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v6
    invoke-static v6, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +44h
    instance-of v0, v5, Lcom/bytedance/trae/conversation/git/GitHubConnectorError$InvalidUrl;
    if-eqz v0, +017h
    sget v0, Lcom/bytedance/trae/multilanguage/R$string;->trae_github_error_invalid_url I
    new-array v3, v3, [Ljava/lang/Object;
    move-object v4, v5
    check-cast v4, Lcom/bytedance/trae/conversation/git/GitHubConnectorError$InvalidUrl;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/git/GitHubConnectorError$InvalidUrl;->getUrl()Ljava/lang/String;
    move-result-object v4
    aput-object v4, v3, v2
    invoke-virtual v6, v0, v3, Landroid/content/Context;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v6
    invoke-static v6, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +2bh
    instance-of v0, v5, Lcom/bytedance/trae/conversation/git/GitHubConnectorError$BackendError;
    if-eqz v0, +01bh
    sget v0, Lcom/bytedance/trae/multilanguage/R$string;->trae_github_error_backend_error I
    new-array v3, v3, [Ljava/lang/Object;
    move-object v4, v5
    check-cast v4, Lcom/bytedance/trae/conversation/git/GitHubConnectorError$BackendError;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/git/GitHubConnectorError$BackendError;->getStatusCode()I
    move-result v4
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    aput-object v4, v3, v2
    invoke-virtual v6, v0, v3, Landroid/content/Context;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v6
    invoke-static v6, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +eh
    instance-of v0, v5, Lcom/bytedance/trae/conversation/git/GitHubConnectorError$DecodingFailed;
    if-eqz v0, +00ch
    sget v0, Lcom/bytedance/trae/multilanguage/R$string;->trae_github_error_decoding_failed I
    invoke-virtual v6, v0, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v6
    invoke-static v6, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v6
    new-instance v6, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v6, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v6
.end method
