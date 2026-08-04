# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewRetryPolicy;
.super Ljava/lang/Object;
.source "HtmlArtifactPreviewRetryPolicy.kt"

.field private static final HTTP_STATUS_SERVICE_UNAVAILABLE:I
.field public static final INSTANCE:Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewRetryPolicy;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewRetryPolicy;
    invoke-direct v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewRetryPolicy;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewRetryPolicy;->INSTANCE Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewRetryPolicy;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final isSessionOfflineArchiveError(java.lang.String)boolean
    .registers 7
    # ins_size=2
    check-cast v6, Ljava/lang/CharSequence;
    const/4 v0, 1
    const/4 v1, 0
    if-eqz v6, +00bh
    invoke-static v6, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    if-eqz v2, +003h
    goto +3h
    move v2, v1
    goto +2h
    move v2, v0
    if-eqz v2, +003h
    return v1
    const-string v2, ""code":101"
    check-cast v2, Ljava/lang/CharSequence;
    const/4 v3, 2
    const/4 v4, 0
    invoke-static v6, v2, v1, v3, v4, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z I Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +022h
    const-string v2, "code=101"
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v6, v2, v1, v3, v4, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z I Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +018h
    const-string v2, "SessionOffline"
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v6, v2, v1, v3, v4, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z I Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +00eh
    const-string v2, "Archive download is disabled in offline mode"
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v6, v2, v1, v3, v4, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z I Ljava/lang/Object;)Z
    move-result v6
    if-eqz v6, +003h
    goto +2h
    move v0, v1
    return v0
.end method

.method private final requiresSandboxReady(com.bytedance.trae.conversation.products.HtmlArtifactPreviewFailure)boolean
    .registers 6
    # ins_size=2
    instance-of v0, v5, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewFailure$UrlUnavailable;
    const/4 v1, 1
    if-eqz v0, +003h
    goto +23h
    instance-of v0, v5, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewFailure$ArchiveDownload;
    const/4 v2, 0
    if-eqz v0, +01eh
    check-cast v5, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewFailure$ArchiveDownload;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewFailure$ArchiveDownload;->getHttpStatusCode()Ljava/lang/Integer;
    move-result-object v0
    if-nez v0, +003h
    goto +9h
    invoke-virtual v0, Ljava/lang/Integer;->intValue()I
    move-result v0
    const/16 v3, 503
    if-eq v0, v3, +00eh
    invoke-virtual v5, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewFailure$ArchiveDownload;->getMessage()Ljava/lang/String;
    move-result-object v5
    invoke-direct v4, v5, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewRetryPolicy;->isSessionOfflineArchiveError(Ljava/lang/String;)Z
    move-result v5
    if-eqz v5, +003h
    goto +2h
    move v1, v2
    return v1
.end method

.method public final nextRemoteResolveMode(com.bytedance.trae.conversation.products.HtmlArtifactPreviewFailure)com.bytedance.trae.conversation.products.HtmlArtifactRemoteArchiveResolveMode
    .registers 3
    # ins_size=2
    const-string v0, "failure"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewRetryPolicy;->requiresSandboxReady(Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewFailure;)Z
    move-result v2
    if-eqz v2, +005h
    sget-object v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveResolveMode;->ENSURE_SANDBOX_READY Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveResolveMode;
    goto +3h
    sget-object v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveResolveMode;->DIRECT_ARCHIVE Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveResolveMode;
    return-object v2
.end method
