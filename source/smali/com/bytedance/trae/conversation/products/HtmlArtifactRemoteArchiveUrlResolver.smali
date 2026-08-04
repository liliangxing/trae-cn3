# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;
.super Ljava/lang/Object;
.source "HtmlArtifactRemoteArchiveUrlResolver.kt"

.field private static final Companion:Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$Companion;
.field private static final DEFAULT_SANDBOX_READY_TIMEOUT_MS:J
.field private static final TAG:Ljava/lang/String;
.field private final sandboxReadyTimeoutMs:J
.field private final sandboxStatusSource:Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteSandboxStatusSource;
.field private final sessionClient:Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteSessionClient;
.field private workSpace:Ljava/lang/String;
.field private final xttTokenProvider:Lkotlin/jvm/functions/Function0;


.method public static synthetic $r8$lambda$c5SDg-Ypw-XZ8EMvC5iO9Tkle94()java.lang.String
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;->_init_$lambda$0()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;->Companion Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 9
    # ins_size=1
    const/4 v1, 0
    const/4 v2, 0
    const-wide/16 v3, 0
    const/4 v5, 0
    const/16 v6, 15
    const/4 v7, 0
    move-object v0, v8
    invoke-direct/range v0 ... v7, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;-><init>(Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteSessionClient; Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteSandboxStatusSource; J Lkotlin/jvm/functions/Function0; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(com.bytedance.trae.conversation.products.HtmlArtifactRemoteSessionClient  com.bytedance.trae.conversation.products.HtmlArtifactRemoteSandboxStatusSource  long  kotlin.jvm.functions.Function0)void
    .registers 7
    # ins_size=6
    const-string/jumbo v0, sessionClient
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, sandboxStatusSource
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, xttTokenProvider
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;->sessionClient Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteSessionClient;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;->sandboxStatusSource Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteSandboxStatusSource;
    iput-wide v4, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;->sandboxReadyTimeoutMs J
    iput-object v6, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;->xttTokenProvider Lkotlin/jvm/functions/Function0;
    const-string v2, ""
    iput-object v2, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;->workSpace Ljava/lang/String;
    return-void 
.end method

.method public synthetic constructor <init>(com.bytedance.trae.conversation.products.HtmlArtifactRemoteSessionClient  com.bytedance.trae.conversation.products.HtmlArtifactRemoteSandboxStatusSource  long  kotlin.jvm.functions.Function0  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 11
    # ins_size=8
    and-int/lit8 v10, v9, 1
    if-eqz v10, +006h
    sget-object v4, Lcom/bytedance/trae/conversation/products/DefaultHtmlArtifactRemoteSessionClient;->INSTANCE Lcom/bytedance/trae/conversation/products/DefaultHtmlArtifactRemoteSessionClient;
    check-cast v4, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteSessionClient;
    and-int/lit8 v10, v9, 2
    if-eqz v10, +006h
    sget-object v5, Lcom/bytedance/trae/conversation/products/DefaultHtmlArtifactRemoteSandboxStatusSource;->INSTANCE Lcom/bytedance/trae/conversation/products/DefaultHtmlArtifactRemoteSandboxStatusSource;
    check-cast v5, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteSandboxStatusSource;
    move-object v10, v5
    and-int/lit8 v5, v9, 4
    if-eqz v5, +005h
    const-wide/32 v6, 60000
    move-wide v0, v6
    and-int/lit8 v5, v9, 8
    if-eqz v5, +007h
    new-instance v8, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$$ExternalSyntheticLambda0;
    invoke-direct v8, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$$ExternalSyntheticLambda0;-><init>()V
    move-object v2, v8
    move-object v5, v3
    move-object v6, v4
    move-object v7, v10
    move-wide v8, v0
    move-object v10, v2
    invoke-direct/range v5 ... v10, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;-><init>(Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteSessionClient; Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteSandboxStatusSource; J Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method private static final _init_$lambda$0()java.lang.String
    .registers 2
    # ins_size=0
    const-class v0, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v0, v1, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/api/ILoginService;
    if-eqz v0, +007h
    invoke-interface v0, Lcom/bytedance/trae/login/api/ILoginService;->getXTToken()Ljava/lang/String;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    if-nez v0, +004h
    const-string v0, ""
    return-object v0
.end method

.method public static final synthetic access$describeForLog(com.bytedance.trae.conversation.products.HtmlArtifactRemoteArchiveUrlResolver  com.bytedance.trae.conversation.products.RealtimeSandboxStatusUpdate)java.lang.String
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;->describeForLog(Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatusUpdate;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$getSandboxReadyTimeoutMs$p(com.bytedance.trae.conversation.products.HtmlArtifactRemoteArchiveUrlResolver)long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;->sandboxReadyTimeoutMs J
    return-wide v0
.end method

.method public static final synthetic access$getSandboxStatusSource$p(com.bytedance.trae.conversation.products.HtmlArtifactRemoteArchiveUrlResolver)com.bytedance.trae.conversation.products.HtmlArtifactRemoteSandboxStatusSource
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;->sandboxStatusSource Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteSandboxStatusSource;
    return-object v0
.end method

.method public static final synthetic access$getSessionOrNull(com.bytedance.trae.conversation.products.HtmlArtifactRemoteArchiveUrlResolver  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;->getSessionOrNull(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$logD(com.bytedance.trae.conversation.products.HtmlArtifactRemoteArchiveUrlResolver  java.lang.String)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;->logD(Ljava/lang/String;)V
    return-void 
.end method

.method public static final synthetic access$waitForSandboxReady(com.bytedance.trae.conversation.products.HtmlArtifactRemoteArchiveUrlResolver  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;->waitForSandboxReady(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$wakeupSandbox(com.bytedance.trae.conversation.products.HtmlArtifactRemoteArchiveUrlResolver  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;->wakeupSandbox(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$wakeupSandboxAndWaitForReady(com.bytedance.trae.conversation.products.HtmlArtifactRemoteArchiveUrlResolver  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;->wakeupSandboxAndWaitForReady(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method private final buildArchiveUrl(com.bytedance.trae.im.service.ChatSessionResponse  java.lang.String  java.lang.String)java.lang.String
    .registers 6
    # ins_size=4
    invoke-virtual v3, Lcom/bytedance/trae/im/service/ChatSessionResponse;->getExplorerUrl()Ljava/lang/String;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    if-eqz v1, +00bh
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-nez v1, +003h
    goto +3h
    const/4 v1, 0
    goto +2h
    const/4 v1, 1
    if-eqz v1, +017h
    new-instance v3, Ljava/lang/StringBuilder;
    const-string/jumbo v4, resolve: explorerUrl is empty, chatSessionId=
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;->logE(Ljava/lang/String;)V
    const/4 v3, 0
    return-object v3
    invoke-virtual v3, Lcom/bytedance/trae/im/service/ChatSessionResponse;->getWorkspacePath()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v4, v3, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;->normalizeFilePath(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    sget-object v4, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;->Companion Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget$Companion;
    invoke-virtual v4, v3, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget$Companion;->fromPreviewPath(Ljava/lang/String;)Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;
    move-result-object v3
    new-instance v4, Ljava/lang/StringBuilder;
    const-string/jumbo v5, resolve: /archive.zip path=
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;->getRemoteArchivePath()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v5, " filename="
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v3, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;->getArchiveFileName()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-direct v2, v4, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;->logD(Ljava/lang/String;)V
    sget-object v4, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlBuilder;->INSTANCE Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlBuilder;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;->getRemoteArchivePath()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v3, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;->getArchiveFileName()Ljava/lang/String;
    move-result-object v3
    iget-object v1, v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;->xttTokenProvider Lkotlin/jvm/functions/Function0;
    invoke-interface v1, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/String;
    invoke-virtual v4, v0, v5, v3, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlBuilder;->build(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    return-object v3
.end method

.method private final describeForLog(com.bytedance.trae.conversation.products.RealtimeSandboxStatusUpdate)java.lang.String
    .registers 4
    # ins_size=2
    if-nez v3, +005h
    const-string v3, "null"
    return-object v3
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "conversationId="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatusUpdate;->getConversationId()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", cliConversationId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v3, Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatusUpdate;->getCliConversationId()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", sandboxName="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v3, Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatusUpdate;->getSandboxName()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", sandboxType="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v3, Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatusUpdate;->getSandboxType()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", status="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v3, Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatusUpdate;->getStatus()Ljava/lang/Integer;
    move-result-object v3
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;->statusForLog(Ljava/lang/Integer;)Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    return-object v3
.end method

.method private final getSessionOrNull(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 12
    # ins_size=3
    instance-of v0, v11, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$getSessionOrNull$1;
    if-eqz v0, +012h
    move-object v0, v11
    check-cast v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$getSessionOrNull$1;
    iget v1, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$getSessionOrNull$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v11, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$getSessionOrNull$1;->label I
    sub-int/2addr v11, v2
    iput v11, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$getSessionOrNull$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$getSessionOrNull$1;
    invoke-direct v0, v9, v11, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$getSessionOrNull$1;-><init>(Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver; Lkotlin/coroutines/Continuation;)V
    iget-object v11, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$getSessionOrNull$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$getSessionOrNull$1;->label I
    const-string v3, "GET /api/remote/v1/chat_sessions/"
    const/4 v4, 1
    if-eqz v2, +018h
    if-ne v2, v4, +00eh
    iget-object v10, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$getSessionOrNull$1;->L$1 Ljava/lang/Object;
    check-cast v10, Ljava/lang/String;
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$getSessionOrNull$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;
    invoke-static v11, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +32h
    new-instance v10, Ljava/lang/IllegalStateException;
    const-string v11, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v10, v11, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v10
    invoke-static v11, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    new-instance v11, Ljava/lang/StringBuilder;
    invoke-direct v11, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v11, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    const-string v2, " request"
    invoke-virtual v11, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-virtual v11, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v11
    invoke-direct v9, v11, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;->logD(Ljava/lang/String;)V
    iget-object v11, v9, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;->sessionClient Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteSessionClient;
    iput-object v9, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$getSessionOrNull$1;->L$0 Ljava/lang/Object;
    iput-object v10, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$getSessionOrNull$1;->L$1 Ljava/lang/Object;
    iput v4, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$getSessionOrNull$1;->label I
    invoke-interface v11, v10, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteSessionClient;->getChatSession(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v11
    if-ne v11, v1, +003h
    return-object v1
    move-object v0, v9
    check-cast v11, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v1, v11, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    const-string v2, ", msg="
    const/4 v5, 0
    if-eqz v1, +146h
    check-cast v11, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v11, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v11
    invoke-virtual v11, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/im/service/ChatSessionResponse;
    new-instance v6, Ljava/lang/StringBuilder;
    invoke-direct v6, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v6, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    const-string v3, " response: bizCode="
    invoke-virtual v10, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v11, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v7
    invoke-virtual v10, v7, v8, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v11, Lcom/bytedance/trae/network/response/BizResponse;->getMsg()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v10, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    const-string v2, ", message="
    invoke-virtual v10, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v11, Lcom/bytedance/trae/network/response/BizResponse;->getMessage()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v10, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    const-string v2, ", logId="
    invoke-virtual v10, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-direct v0, v11, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;->logIdForLog(Lcom/bytedance/trae/network/response/BizResponse;)Ljava/lang/String;
    move-result-object v11
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    const-string v11, ", responseChatSessionId="
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/im/service/ChatSessionResponse;->getChatSessionId()Ljava/lang/String;
    move-result-object v11
    goto +2h
    move-object v11, v5
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    const-string v11, ", title="
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/im/service/ChatSessionResponse;->getTitle()Ljava/lang/String;
    move-result-object v11
    goto +2h
    move-object v11, v5
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    const-string v11, ", status="
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/im/service/ChatSessionResponse;->getStatus()Ljava/lang/Integer;
    move-result-object v11
    goto +2h
    move-object v11, v5
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v10
    const-string v11, ", mode="
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/im/service/ChatSessionResponse;->getMode()Ljava/lang/String;
    move-result-object v11
    goto +2h
    move-object v11, v5
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    const-string v11, ", sandboxPresent="
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/im/service/ChatSessionResponse;->getSandbox()Lcom/bytedance/trae/im/service/ChatSessionSandbox;
    move-result-object v11
    goto +2h
    move-object v11, v5
    const/4 v2, 0
    if-eqz v11, +004h
    move v11, v4
    goto +2h
    move v11, v2
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v10
    const-string v11, ", sandboxName="
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    if-eqz v1, +00dh
    invoke-virtual v1, Lcom/bytedance/trae/im/service/ChatSessionResponse;->getSandbox()Lcom/bytedance/trae/im/service/ChatSessionSandbox;
    move-result-object v11
    if-eqz v11, +007h
    invoke-virtual v11, Lcom/bytedance/trae/im/service/ChatSessionSandbox;->getName()Ljava/lang/String;
    move-result-object v11
    goto +2h
    move-object v11, v5
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    const-string v11, ", allocationStatus="
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    if-eqz v1, +00dh
    invoke-virtual v1, Lcom/bytedance/trae/im/service/ChatSessionResponse;->getSandbox()Lcom/bytedance/trae/im/service/ChatSessionSandbox;
    move-result-object v10
    if-eqz v10, +007h
    invoke-virtual v10, Lcom/bytedance/trae/im/service/ChatSessionSandbox;->getAllocationStatus()Ljava/lang/Integer;
    move-result-object v10
    goto +2h
    move-object v10, v5
    invoke-direct v0, v10, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;->statusForLog(Ljava/lang/Integer;)Ljava/lang/String;
    move-result-object v10
    invoke-virtual v6, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    const-string v11, ", explorerUrlPresent="
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/im/service/ChatSessionResponse;->getExplorerUrl()Ljava/lang/String;
    move-result-object v11
    goto +2h
    move-object v11, v5
    check-cast v11, Ljava/lang/CharSequence;
    if-eqz v11, +00bh
    invoke-interface v11, Ljava/lang/CharSequence;->length()I
    move-result v11
    if-nez v11, +003h
    goto +3h
    move v11, v2
    goto +2h
    move v11, v4
    xor-int/2addr v11, v4
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v10
    const-string v11, ", previewUrlPresent="
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/im/service/ChatSessionResponse;->getPreviewUrl()Ljava/lang/String;
    move-result-object v11
    goto +2h
    move-object v11, v5
    check-cast v11, Ljava/lang/CharSequence;
    if-eqz v11, +008h
    invoke-interface v11, Ljava/lang/CharSequence;->length()I
    move-result v11
    if-nez v11, +003h
    move v2, v4
    xor-int/lit8 v11, v2, 1
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v10
    const-string v11, ", workspacePath="
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/im/service/ChatSessionResponse;->getWorkspacePath()Ljava/lang/String;
    move-result-object v11
    goto +2h
    move-object v11, v5
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v10
    invoke-direct v0, v10, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;->logD(Ljava/lang/String;)V
    if-eqz v1, +006h
    invoke-virtual v1, Lcom/bytedance/trae/im/service/ChatSessionResponse;->getWorkspacePath()Ljava/lang/String;
    move-result-object v5
    if-nez v5, +004h
    const-string v5, ""
    iput-object v5, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;->workSpace Ljava/lang/String;
    move-object v5, v1
    goto +63h
    instance-of v1, v11, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v1, +061h
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    const-string v1, " failed: code="
    invoke-virtual v10, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    check-cast v11, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v11, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getCode()I
    move-result v1
    invoke-virtual v10, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v11, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getMsg()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v10, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    const-string v1, ", throwable="
    invoke-virtual v10, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v11, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getThrowable()Ljava/lang/Throwable;
    move-result-object v1
    if-eqz v1, +00dh
    invoke-virtual v1, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v1
    if-eqz v1, +007h
    invoke-virtual v1, Ljava/lang/Class;->getName()Ljava/lang/String;
    move-result-object v1
    goto +2h
    move-object v1, v5
    invoke-virtual v10, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    const-string v1, ": "
    invoke-virtual v10, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v11, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getThrowable()Ljava/lang/Throwable;
    move-result-object v11
    if-eqz v11, +007h
    invoke-virtual v11, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v11
    goto +2h
    move-object v11, v5
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v10
    invoke-direct v0, v10, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;->logE(Ljava/lang/String;)V
    return-object v5
    new-instance v10, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v10, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v10
.end method

.method private final hasSandboxInfo(com.bytedance.trae.im.service.ChatSessionResponse)boolean
    .registers 2
    # ins_size=2
    invoke-virtual v1, Lcom/bytedance/trae/im/service/ChatSessionResponse;->getSandbox()Lcom/bytedance/trae/im/service/ChatSessionSandbox;
    move-result-object v1
    if-eqz v1, +004h
    const/4 v1, 1
    goto +2h
    const/4 v1, 0
    return v1
.end method

.method private final isSandboxReady(com.bytedance.trae.im.service.ChatSessionResponse)boolean
    .registers 4
    # ins_size=2
    invoke-virtual v3, Lcom/bytedance/trae/im/service/ChatSessionResponse;->getSandbox()Lcom/bytedance/trae/im/service/ChatSessionSandbox;
    move-result-object v3
    const/4 v0, 0
    if-eqz v3, +016h
    invoke-virtual v3, Lcom/bytedance/trae/im/service/ChatSessionSandbox;->getAllocationStatus()Ljava/lang/Integer;
    move-result-object v3
    sget-object v1, Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;->READY Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;->getValue()I
    move-result v1
    if-nez v3, +003h
    goto +8h
    invoke-virtual v3, Ljava/lang/Integer;->intValue()I
    move-result v3
    if-ne v3, v1, +003h
    const/4 v0, 1
    return v0
.end method

.method private final logD(java.lang.String)void
    .registers 4
    # ins_size=2
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v2
    check-cast v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "HtmlArtifactRemoteArchiveUrlResolver"
    invoke-virtual v0, v1, v3, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v3, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    goto +bh
    move-exception v3
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v3, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v3
    invoke-static v3, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
    :try_start_0x0
.end method

.method private final logE(java.lang.String)void
    .registers 4
    # ins_size=2
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v2
    check-cast v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "HtmlArtifactRemoteArchiveUrlResolver"
    invoke-virtual v0, v1, v3, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v3, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    goto +bh
    move-exception v3
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v3, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v3
    invoke-static v3, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
    :try_start_0x0
.end method

.method private final logIdForLog(com.bytedance.trae.network.response.BizResponse)java.lang.String
    .registers 7
    # ins_size=2
    invoke-virtual v6, Lcom/bytedance/trae/network/response/BizResponse;->getSSResponse()Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v6
    const/4 v0, 0
    if-eqz v6, +033h
    invoke-virtual v6, Lcom/bytedance/retrofit2/SsResponse;->headers()Ljava/util/List;
    move-result-object v6
    if-eqz v6, +02dh
    check-cast v6, Ljava/lang/Iterable;
    invoke-interface v6, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v6
    invoke-interface v6, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +018h
    invoke-interface v6, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Lcom/bytedance/retrofit2/client/Header;
    invoke-virtual v2, Lcom/bytedance/retrofit2/client/Header;->getName()Ljava/lang/String;
    move-result-object v2
    const-string/jumbo v3, x-tt-logid
    const/4 v4, 1
    invoke-static v2, v3, v4, Lkotlin/text/StringsKt;->equals(Ljava/lang/String; Ljava/lang/String; Z)Z
    move-result v2
    if-eqz v2, -019h
    goto +2h
    move-object v1, v0
    check-cast v1, Lcom/bytedance/retrofit2/client/Header;
    if-eqz v1, +006h
    invoke-virtual v1, Lcom/bytedance/retrofit2/client/Header;->getValue()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic normalizeFilePath$default(com.bytedance.trae.conversation.products.HtmlArtifactRemoteArchiveUrlResolver  java.lang.String  java.lang.String  int  java.lang.Object)java.lang.String
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +003h
    const/4 v2, 0
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;->normalizeFilePath(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic resolve$default(com.bytedance.trae.conversation.products.HtmlArtifactRemoteArchiveUrlResolver  java.lang.String  java.lang.String  com.bytedance.trae.conversation.products.HtmlArtifactRemoteArchiveResolveMode  kotlin.coroutines.Continuation  int  java.lang.Object)java.lang.Object
    .registers 7
    # ins_size=7
    and-int/lit8 v5, v5, 4
    if-eqz v5, +004h
    sget-object v3, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveResolveMode;->ENSURE_SANDBOX_READY Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveResolveMode;
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;->resolve(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveResolveMode; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method private final statusForLog(java.lang.Integer)java.lang.String
    .registers 4
    # ins_size=2
    if-nez v3, +005h
    const-string v3, "null"
    goto +26h
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 40
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v3, Ljava/lang/Integer;->intValue()I
    move-result v3
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;->statusName(I)Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const/16 v0, 41
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    return-object v3
.end method

.method private final statusName(int)java.lang.String
    .registers 3
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;->UNKNOWN Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;->getValue()I
    move-result v0
    if-ne v2, v0, +005h
    const-string v2, "Unknown"
    goto +3ah
    sget-object v0, Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;->SUBMITTED Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;->getValue()I
    move-result v0
    if-ne v2, v0, +005h
    const-string v2, "Submitted"
    goto +2fh
    sget-object v0, Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;->INITIALIZING Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;->getValue()I
    move-result v0
    if-ne v2, v0, +005h
    const-string v2, "Initializing"
    goto +24h
    sget-object v0, Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;->READY Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;->getValue()I
    move-result v0
    if-ne v2, v0, +005h
    const-string v2, "Ready"
    goto +19h
    sget-object v0, Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;->TERMINATING Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;->getValue()I
    move-result v0
    if-ne v2, v0, +005h
    const-string v2, "Terminating"
    goto +eh
    sget-object v0, Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;->TERMINATED Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;->getValue()I
    move-result v0
    if-ne v2, v0, +005h
    const-string v2, "Terminated"
    goto +3h
    const-string v2, "Unrecognized"
    return-object v2
.end method

.method private final waitForSandboxReady(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 18
    # ins_size=3
    move-object v6, v15
    move-object/from16 v0, v17
    instance-of v1, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$1;
    if-eqz v1, +012h
    move-object v1, v0
    check-cast v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$1;
    iget v2, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$1;->label I
    const/high16 v3, -2147483648
    and-int/2addr v2, v3
    if-eqz v2, +008h
    iget v0, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$1;->label I
    sub-int/2addr v0, v3
    iput v0, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$1;->label I
    goto +6h
    new-instance v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$1;
    invoke-direct v1, v15, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$1;-><init>(Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver; Lkotlin/coroutines/Continuation;)V
    move-object v7, v1
    iget-object v0, v7, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v8
    iget v1, v7, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$1;->label I
    const/4 v9, 1
    if-eqz v1, +023h
    if-ne v1, v9, +019h
    iget-object v1, v7, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$1;->L$3 Ljava/lang/Object;
    check-cast v1, Lkotlin/jvm/internal/Ref$ObjectRef;
    iget-object v2, v7, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$1;->L$2 Ljava/lang/Object;
    check-cast v2, Lkotlin/jvm/internal/Ref$ObjectRef;
    iget-object v3, v7, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$1;->L$1 Ljava/lang/Object;
    check-cast v3, Ljava/lang/String;
    iget-object v4, v7, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$1;->L$0 Ljava/lang/Object;
    check-cast v4, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v11, v1
    move-object v1, v0
    move-object v0, v3
    goto +3bh
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v1, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v1, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    new-instance v10, Lkotlin/jvm/internal/Ref$ObjectRef;
    invoke-direct v10, Lkotlin/jvm/internal/Ref$ObjectRef;-><init>()V
    new-instance v11, Lkotlin/jvm/internal/Ref$ObjectRef;
    invoke-direct v11, Lkotlin/jvm/internal/Ref$ObjectRef;-><init>()V
    iget-wide v12, v6, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;->sandboxReadyTimeoutMs J
    new-instance v14, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1;
    const/4 v5, 0
    move-object v0, v14
    move-object v1, v15
    move-object/from16 v2, v16
    move-object v3, v10
    move-object v4, v11
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1;-><init>(Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver; Ljava/lang/String; Lkotlin/jvm/internal/Ref$ObjectRef; Lkotlin/jvm/internal/Ref$ObjectRef; Lkotlin/coroutines/Continuation;)V
    check-cast v14, Lkotlin/jvm/functions/Function2;
    iput-object v6, v7, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$1;->L$0 Ljava/lang/Object;
    move-object/from16 v0, v16
    iput-object v0, v7, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$1;->L$1 Ljava/lang/Object;
    iput-object v10, v7, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$1;->L$2 Ljava/lang/Object;
    iput-object v11, v7, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$1;->L$3 Ljava/lang/Object;
    iput v9, v7, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$1;->label I
    invoke-static v12, v13, v14, v7, Lkotlinx/coroutines/TimeoutKt;->withTimeoutOrNull(J Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    if-ne v1, v8, +003h
    return-object v8
    move-object v4, v6
    move-object v2, v10
    check-cast v1, Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatusUpdate;
    if-eqz v1, +028h
    new-instance v2, Ljava/lang/StringBuilder;
    const-string/jumbo v3, resolve: sandbox ready received, chatSessionId=
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v2, ", "
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-direct v4, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;->describeForLog(Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatusUpdate;)Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-direct v4, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;->logD(Ljava/lang/String;)V
    invoke-static v9, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v0
    return-object v0
    new-instance v1, Ljava/lang/StringBuilder;
    const-string/jumbo v3, resolve: wait sandbox ready timeout, chatSessionId=
    invoke-direct v1, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", timeoutMs="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-wide v7, v4, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;->sandboxReadyTimeoutMs J
    invoke-virtual v0, v7, v8, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", lastMatchingUpdate="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v11, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    check-cast v1, Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatusUpdate;
    invoke-direct v4, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;->describeForLog(Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatusUpdate;)Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", lastAnyUpdate="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    check-cast v1, Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatusUpdate;
    invoke-direct v4, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;->describeForLog(Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatusUpdate;)Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-direct v4, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;->logE(Ljava/lang/String;)V
    const/4 v0, 0
    invoke-static v0, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v0
    return-object v0
.end method

.method private final wakeupSandbox(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 9
    # ins_size=3
    instance-of v0, v8, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$wakeupSandbox$1;
    if-eqz v0, +012h
    move-object v0, v8
    check-cast v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$wakeupSandbox$1;
    iget v1, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$wakeupSandbox$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v8, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$wakeupSandbox$1;->label I
    sub-int/2addr v8, v2
    iput v8, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$wakeupSandbox$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$wakeupSandbox$1;
    invoke-direct v0, v6, v8, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$wakeupSandbox$1;-><init>(Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver; Lkotlin/coroutines/Continuation;)V
    iget-object v8, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$wakeupSandbox$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$wakeupSandbox$1;->label I
    const/4 v3, 1
    const-string v4, "POST /api/remote/v1/chat_sessions/"
    if-eqz v2, +018h
    if-ne v2, v3, +00eh
    iget-object v7, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$wakeupSandbox$1;->L$1 Ljava/lang/Object;
    check-cast v7, Ljava/lang/String;
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$wakeupSandbox$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +32h
    new-instance v7, Ljava/lang/IllegalStateException;
    const-string v8, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v7, v8, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v7
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    new-instance v8, Ljava/lang/StringBuilder;
    invoke-direct v8, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v8, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    const-string v2, "/wakeup_sandbox request"
    invoke-virtual v8, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v8
    invoke-direct v6, v8, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;->logD(Ljava/lang/String;)V
    iget-object v8, v6, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;->sessionClient Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteSessionClient;
    iput-object v6, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$wakeupSandbox$1;->L$0 Ljava/lang/Object;
    iput-object v7, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$wakeupSandbox$1;->L$1 Ljava/lang/Object;
    iput v3, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$wakeupSandbox$1;->label I
    invoke-interface v8, v7, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteSessionClient;->wakeupSandbox(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v8
    if-ne v8, v1, +003h
    return-object v1
    move-object v0, v6
    check-cast v8, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v1, v8, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    const-string v2, ", msg="
    if-eqz v1, +09ch
    check-cast v8, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v8, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v8
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v3, "/wakeup_sandbox response: bizCode="
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v8, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v3
    invoke-virtual v1, v3, v4, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v8, Lcom/bytedance/trae/network/response/BizResponse;->getMsg()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v3, ", message="
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v8, Lcom/bytedance/trae/network/response/BizResponse;->getMessage()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v4, ", logId="
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-direct v0, v8, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;->logIdForLog(Lcom/bytedance/trae/network/response/BizResponse;)Ljava/lang/String;
    move-result-object v4
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v4, ", isSuccess="
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v8, Lcom/bytedance/trae/network/response/BizResponse;->isSuccess()Z
    move-result v4
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;->logD(Ljava/lang/String;)V
    invoke-virtual v8, Lcom/bytedance/trae/network/response/BizResponse;->isSuccess()Z
    move-result v1
    if-nez v1, +09dh
    new-instance v1, Ljava/lang/StringBuilder;
    const-string/jumbo v4, resolve: wakeup sandbox biz failed, chatSessionId=
    invoke-direct v1, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v1, ", bizCode="
    invoke-virtual v7, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v8, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v4
    invoke-virtual v7, v4, v5, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v8, Lcom/bytedance/trae/network/response/BizResponse;->getMsg()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v7, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v8, Lcom/bytedance/trae/network/response/BizResponse;->getMessage()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    invoke-direct v0, v7, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;->logE(Ljava/lang/String;)V
    goto +62h
    instance-of v1, v8, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v1, +062h
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v1, "/wakeup_sandbox failed: code="
    invoke-virtual v7, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    check-cast v8, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v8, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getCode()I
    move-result v1
    invoke-virtual v7, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v8, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getMsg()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v7, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v1, ", throwable="
    invoke-virtual v7, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v8, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getThrowable()Ljava/lang/Throwable;
    move-result-object v1
    const/4 v2, 0
    if-eqz v1, +00dh
    invoke-virtual v1, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v1
    if-eqz v1, +007h
    invoke-virtual v1, Ljava/lang/Class;->getName()Ljava/lang/String;
    move-result-object v1
    goto +2h
    move-object v1, v2
    invoke-virtual v7, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v1, ": "
    invoke-virtual v7, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v8, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getThrowable()Ljava/lang/Throwable;
    move-result-object v8
    if-eqz v8, +006h
    invoke-virtual v8, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v7, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    invoke-direct v0, v7, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;->logE(Ljava/lang/String;)V
    sget-object v7, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v7
    new-instance v7, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v7, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v7
.end method

.method private final wakeupSandboxAndWaitForReady(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 5
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$wakeupSandboxAndWaitForReady$2;
    const/4 v1, 0
    invoke-direct v0, v2, v3, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$wakeupSandboxAndWaitForReady$2;-><init>(Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v0, Lkotlin/jvm/functions/Function2;
    invoke-static v0, v4, Lkotlinx/coroutines/CoroutineScopeKt;->coroutineScope(Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v3
    return-object v3
.end method

.method public final getWorkSpace()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;->workSpace Ljava/lang/String;
    return-object v0
.end method

.method public final normalizeFilePath(java.lang.String  java.lang.String)java.lang.String
    .registers 11
    # ins_size=3
    const-string v0, "filePath"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v0, v10
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v1, 1
    const/4 v2, 0
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    move v0, v2
    goto +2h
    move v0, v1
    const-string/jumbo v3, substring(...)
    const/4 v4, 0
    const-string v5, "/"
    const/4 v6, 2
    if-nez v0, +059h
    invoke-static v10, v5, v2, v6, v4, Lkotlin/text/StringsKt;->endsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +004h
    move-object v0, v10
    goto +14h
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v0, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v7, 47
    invoke-virtual v0, v7, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-static v10, v5, v2, v6, v4, Lkotlin/text/StringsKt;->endsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v7
    if-eqz v7, +006h
    invoke-static v10, v1, Lkotlin/text/StringsKt;->dropLast(Ljava/lang/String; I)Ljava/lang/String;
    move-result-object v10
    new-array v7, v6, [Ljava/lang/String;
    aput-object v0, v7, v2
    aput-object v10, v7, v1
    invoke-static v7, Lkotlin/collections/CollectionsKt;->listOf([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v10
    invoke-interface v10, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v10
    invoke-interface v10, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +020h
    invoke-interface v10, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/String;
    invoke-static v9, v0, v2, v6, v4, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v7
    if-eqz v7, -010h
    invoke-virtual v0, Ljava/lang/String;->length()I
    move-result v10
    invoke-virtual v9, v10, Ljava/lang/String;->substring(I)Ljava/lang/String;
    move-result-object v9
    invoke-static v9, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v5, Ljava/lang/CharSequence;
    invoke-static v9, v5, Lkotlin/text/StringsKt;->removePrefix(Ljava/lang/String; Ljava/lang/CharSequence;)Ljava/lang/String;
    move-result-object v9
    return-object v9
    invoke-static v9, v5, v2, v6, v4, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v10
    if-eqz v10, +009h
    invoke-virtual v9, v1, Ljava/lang/String;->substring(I)Ljava/lang/String;
    move-result-object v9
    invoke-static v9, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v9
.end method

.method public final resolve(java.lang.String  java.lang.String  com.bytedance.trae.conversation.products.HtmlArtifactRemoteArchiveResolveMode  kotlin.coroutines.Continuation)java.lang.Object
    .registers 13
    # ins_size=5
    instance-of v0, v12, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$resolve$1;
    if-eqz v0, +012h
    move-object v0, v12
    check-cast v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$resolve$1;
    iget v1, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$resolve$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v12, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$resolve$1;->label I
    sub-int/2addr v12, v2
    iput v12, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$resolve$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$resolve$1;
    invoke-direct v0, v8, v12, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$resolve$1;-><init>(Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver; Lkotlin/coroutines/Continuation;)V
    iget-object v12, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$resolve$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$resolve$1;->label I
    const/4 v3, 2
    const/4 v4, 1
    const/4 v5, 0
    if-eqz v2, +039h
    if-eq v2, v4, +021h
    if-ne v2, v3, +017h
    iget-object v9, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$resolve$1;->L$3 Ljava/lang/Object;
    check-cast v9, Lcom/bytedance/trae/im/service/ChatSessionResponse;
    iget-object v10, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$resolve$1;->L$2 Ljava/lang/Object;
    check-cast v10, Ljava/lang/String;
    iget-object v11, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$resolve$1;->L$1 Ljava/lang/Object;
    check-cast v11, Ljava/lang/String;
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$resolve$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;
    invoke-static v12, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +0ddh
    new-instance v9, Ljava/lang/IllegalStateException;
    const-string v10, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v9, v10, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v9
    iget-object v9, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$resolve$1;->L$3 Ljava/lang/Object;
    move-object v11, v9
    check-cast v11, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveResolveMode;
    iget-object v9, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$resolve$1;->L$2 Ljava/lang/Object;
    move-object v10, v9
    check-cast v10, Ljava/lang/String;
    iget-object v9, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$resolve$1;->L$1 Ljava/lang/Object;
    check-cast v9, Ljava/lang/String;
    iget-object v2, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$resolve$1;->L$0 Ljava/lang/Object;
    check-cast v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;
    invoke-static v12, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +16h
    invoke-static v12, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iput-object v8, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$resolve$1;->L$0 Ljava/lang/Object;
    iput-object v9, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$resolve$1;->L$1 Ljava/lang/Object;
    iput-object v10, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$resolve$1;->L$2 Ljava/lang/Object;
    iput-object v11, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$resolve$1;->L$3 Ljava/lang/Object;
    iput v4, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$resolve$1;->label I
    invoke-direct v8, v9, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;->getSessionOrNull(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v12
    if-ne v12, v1, +003h
    return-object v1
    move-object v2, v8
    check-cast v12, Lcom/bytedance/trae/im/service/ChatSessionResponse;
    if-nez v12, +003h
    return-object v5
    invoke-direct v2, v12, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;->isSandboxReady(Lcom/bytedance/trae/im/service/ChatSessionResponse;)Z
    move-result v6
    if-nez v6, +00eh
    sget-object v6, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveResolveMode;->DIRECT_ARCHIVE Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveResolveMode;
    if-ne v11, v6, +009h
    invoke-direct v2, v12, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;->hasSandboxInfo(Lcom/bytedance/trae/im/service/ChatSessionResponse;)Z
    move-result v6
    if-eqz v6, +003h
    goto +2h
    const/4 v4, 0
    const-string v6, ", allocationStatus="
    if-eqz v4, +048h
    new-instance v0, Ljava/lang/StringBuilder;
    const-string/jumbo v1, resolve: skip sandbox wakeup, chatSessionId=
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", mode="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v11
    const-string v0, ", sandboxPresent="
    invoke-virtual v11, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-direct v2, v12, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;->hasSandboxInfo(Lcom/bytedance/trae/im/service/ChatSessionResponse;)Z
    move-result v0
    invoke-virtual v11, v0, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-virtual v11, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-virtual v12, Lcom/bytedance/trae/im/service/ChatSessionResponse;->getSandbox()Lcom/bytedance/trae/im/service/ChatSessionSandbox;
    move-result-object v0
    if-eqz v0, +006h
    invoke-virtual v0, Lcom/bytedance/trae/im/service/ChatSessionSandbox;->getAllocationStatus()Ljava/lang/Integer;
    move-result-object v5
    invoke-direct v2, v5, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;->statusForLog(Ljava/lang/Integer;)Ljava/lang/String;
    move-result-object v0
    invoke-virtual v11, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-virtual v11, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v11
    invoke-direct v2, v11, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;->logD(Ljava/lang/String;)V
    invoke-direct v2, v12, v10, v9, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;->buildArchiveUrl(Lcom/bytedance/trae/im/service/ChatSessionResponse; Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v9
    return-object v9
    new-instance v11, Ljava/lang/StringBuilder;
    const-string/jumbo v4, resolve: sandbox not ready, chatSessionId=
    invoke-direct v11, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v11, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-virtual v11, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-virtual v12, Lcom/bytedance/trae/im/service/ChatSessionResponse;->getSandbox()Lcom/bytedance/trae/im/service/ChatSessionSandbox;
    move-result-object v4
    if-eqz v4, +007h
    invoke-virtual v4, Lcom/bytedance/trae/im/service/ChatSessionSandbox;->getAllocationStatus()Ljava/lang/Integer;
    move-result-object v4
    goto +2h
    move-object v4, v5
    invoke-direct v2, v4, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;->statusForLog(Ljava/lang/Integer;)Ljava/lang/String;
    move-result-object v4
    invoke-virtual v11, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    const-string v4, ", request wakeup"
    invoke-virtual v11, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-virtual v11, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v11
    invoke-direct v2, v11, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;->logD(Ljava/lang/String;)V
    iput-object v2, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$resolve$1;->L$0 Ljava/lang/Object;
    iput-object v9, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$resolve$1;->L$1 Ljava/lang/Object;
    iput-object v10, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$resolve$1;->L$2 Ljava/lang/Object;
    iput-object v12, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$resolve$1;->L$3 Ljava/lang/Object;
    iput v3, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$resolve$1;->label I
    invoke-direct v2, v9, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;->wakeupSandboxAndWaitForReady(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v11
    if-ne v11, v1, +003h
    return-object v1
    move-object v0, v2
    move-object v7, v11
    move-object v11, v9
    move-object v9, v12
    move-object v12, v7
    check-cast v12, Ljava/lang/Boolean;
    invoke-virtual v12, Ljava/lang/Boolean;->booleanValue()Z
    move-result v12
    if-nez v12, +003h
    return-object v5
    invoke-direct v0, v9, v10, v11, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;->buildArchiveUrl(Lcom/bytedance/trae/im/service/ChatSessionResponse; Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v9
    return-object v9
.end method

.method public final setWorkSpace(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string v0, "<set-?>"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;->workSpace Ljava/lang/String;
    return-void 
.end method
