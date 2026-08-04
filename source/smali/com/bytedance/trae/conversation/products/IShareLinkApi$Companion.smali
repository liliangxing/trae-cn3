# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion;
.super Ljava/lang/Object;
.source "IShareLinkApi.kt"

.field static final synthetic $$INSTANCE:Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion;
    invoke-direct v0, Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion;->$$INSTANCE Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final createLocalShareLink(com.bytedance.trae.conversation.products.LocalShareLinkRequest  kotlin.coroutines.Continuation)java.lang.Object
    .registers 21
    # ins_size=3
    move-object/from16 v0, v20
    const-string v1, "createLocalShareLink success: code="
    instance-of v2, v0, Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion$createLocalShareLink$1;
    if-eqz v2, +014h
    move-object v2, v0
    check-cast v2, Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion$createLocalShareLink$1;
    iget v3, v2, Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion$createLocalShareLink$1;->label I
    const/high16 v4, -2147483648
    and-int/2addr v3, v4
    if-eqz v3, +00ah
    iget v0, v2, Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion$createLocalShareLink$1;->label I
    sub-int/2addr v0, v4
    iput v0, v2, Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion$createLocalShareLink$1;->label I
    move-object/from16 v3, v18
    goto +8h
    new-instance v2, Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion$createLocalShareLink$1;
    move-object/from16 v3, v18
    invoke-direct v2, v3, v0, Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion$createLocalShareLink$1;-><init>(Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion; Lkotlin/coroutines/Continuation;)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion$createLocalShareLink$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v4
    iget v5, v2, Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion$createLocalShareLink$1;->label I
    const/4 v6, 1
    const-string v7, "ShareLinkApi"
    if-eqz v5, +016h
    if-ne v5, v6, +00ch
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +58h
    move-exception v0
    goto/16 +0dch
    move-exception v0
    goto/16 +11dh
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v1, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v1, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v5, Ljava/lang/StringBuilder;
    const-string v8, "createLocalShareLink request: conversationId="
    invoke-direct v5, v8, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v19, Lcom/bytedance/trae/conversation/products/LocalShareLinkRequest;->getConversationId()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v5, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v8, ", target="
    invoke-virtual v5, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual/range v19, Lcom/bytedance/trae/conversation/products/LocalShareLinkRequest;->getTarget()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v5, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v0, v7, v5, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v8, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string/jumbo v9, share_link_local
    const-class v10, Lcom/bytedance/trae/conversation/products/IShareLinkApi;
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/16 v15, 60
    const/16 v16, 0
    invoke-static/range v8 ... v16, Lcom/bytedance/trae/network/TraeHttpConnection;->createService$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Lcom/bytedance/retrofit2/Converter$Factory; Ljava/lang/String; Ljava/util/Map; Z I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/products/IShareLinkApi;
    iput v6, v2, Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion$createLocalShareLink$1;->label I
    move-object/from16 v5, v19
    invoke-interface v0, v5, v2, Lcom/bytedance/trae/conversation/products/IShareLinkApi;->createLocalShareLink(Lcom/bytedance/trae/conversation/products/LocalShareLinkRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v4, +003h
    return-object v4
    check-cast v0, Lcom/bytedance/trae/network/response/BizResponse;
    if-nez v0, +025h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "createLocalShareLink response is null"
    invoke-virtual v0, v7, v1, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    const/16 v9, -1005
    const-string v10, "BizResponse is null"
    new-instance v1, Ljava/lang/Exception;
    const-string v2, "BizResponse is null"
    invoke-direct v1, v2, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V
    move-object v11, v1
    check-cast v11, Ljava/lang/Throwable;
    const/4 v12, 0
    const/16 v13, 8
    const/4 v14, 0
    move-object v8, v0
    invoke-direct/range v8 ... v14, Lcom/bytedance/trae/network/response/HttpDataResult$Error;-><init>(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult;
    goto/16 +0a4h
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v4, Ljava/lang/StringBuilder;
    invoke-direct v4, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v5
    invoke-virtual v4, v5, v6, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v4, ", msg="
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->getMsg()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v4, ", shareUrl="
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/conversation/products/LocalShareLinkData;
    const/4 v5, 0
    if-eqz v4, +007h
    invoke-virtual v4, Lcom/bytedance/trae/conversation/products/LocalShareLinkData;->getShareUrl()Ljava/lang/String;
    move-result-object v4
    goto +2h
    move-object v4, v5
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v2, v7, v1, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v1, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    new-instance v2, Lcom/bytedance/trae/network/response/BizResponse;
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v9
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->getMsg()Ljava/lang/String;
    move-result-object v11
    const/4 v12, 0
    const/4 v13, 0
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v14
    const/4 v15, 0
    const/16 v16, 44
    const/16 v17, 0
    move-object v8, v2
    invoke-direct/range v8 ... v17, Lcom/bytedance/trae/network/response/BizResponse;-><init>(J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Object; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-direct v1, v2, v5, Lcom/bytedance/trae/network/response/HttpDataResult$Success;-><init>(Lcom/bytedance/trae/network/response/BizResponse; Ljava/lang/Throwable;)V
    move-object v0, v1
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult;
    goto +44h
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v4, "createLocalShareLink error: "
    invoke-direct v2, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/Class;->getName()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v4, ": "
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v0, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v7, v2, v0, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    new-instance v1, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    const/16 v5, -1000
    invoke-virtual v0, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +004h
    const-string v2, ""
    move-object v6, v2
    const/4 v8, 0
    const/16 v9, 8
    const/4 v10, 0
    move-object v4, v1
    move-object v7, v0
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/network/response/HttpDataResult$Error;-><init>(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object v0, v1
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult;
    return-object v0
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v2, "createLocalShareLink cancelled"
    invoke-virtual v1, v7, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    throw v0
    :try_start_0x30
    :try_start_0x6b
.end method

.method public final createShareLink(com.bytedance.trae.conversation.products.ShareLinkRequest  kotlin.coroutines.Continuation)java.lang.Object
    .registers 25
    # ins_size=3
    move-object/from16 v0, v24
    const-string v1, "Cloud-IDE-JWT "
    const-string v2, "createShareLink success: code="
    instance-of v3, v0, Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion$createShareLink$1;
    if-eqz v3, +014h
    move-object v3, v0
    check-cast v3, Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion$createShareLink$1;
    iget v4, v3, Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion$createShareLink$1;->label I
    const/high16 v5, -2147483648
    and-int/2addr v4, v5
    if-eqz v4, +00ah
    iget v0, v3, Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion$createShareLink$1;->label I
    sub-int/2addr v0, v5
    iput v0, v3, Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion$createShareLink$1;->label I
    move-object/from16 v4, v22
    goto +8h
    new-instance v3, Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion$createShareLink$1;
    move-object/from16 v4, v22
    invoke-direct v3, v4, v0, Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion$createShareLink$1;-><init>(Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion; Lkotlin/coroutines/Continuation;)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion$createShareLink$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v5
    iget v6, v3, Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion$createShareLink$1;->label I
    const-string v7, ""
    const-string v8, ", title="
    const/4 v9, 1
    const/4 v10, 0
    const-string v11, "ShareLinkApi"
    if-eqz v6, +018h
    if-ne v6, v9, +00eh
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +0a0h
    move-exception v0
    move-object v8, v0
    goto/16 +158h
    move-exception v0
    goto/16 +196h
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v1, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v1, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v6, Ljava/lang/StringBuilder;
    const-string v12, "createShareLink request: chatSessionId="
    invoke-direct v6, v12, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v23, Lcom/bytedance/trae/conversation/products/ShareLinkRequest;->getChatSessionId()Ljava/lang/String;
    move-result-object v12
    invoke-virtual v6, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    const-string v12, ", artifactPath="
    invoke-virtual v6, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual/range v23, Lcom/bytedance/trae/conversation/products/ShareLinkRequest;->getArtifactPath()Ljava/lang/String;
    move-result-object v12
    invoke-virtual v6, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual/range v23, Lcom/bytedance/trae/conversation/products/ShareLinkRequest;->getTitle()Ljava/lang/String;
    move-result-object v12
    invoke-virtual v6, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v0, v11, v6, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v6, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v0, v6, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/api/ILoginService;
    if-eqz v0, +007h
    invoke-interface v0, Lcom/bytedance/trae/login/api/ILoginService;->getXTToken()Ljava/lang/String;
    move-result-object v0
    goto +2h
    move-object v0, v10
    if-nez v0, +003h
    move-object v0, v7
    new-array v6, v9, [Lkotlin/Pair;
    const-string v12, "authorization"
    new-instance v13, Ljava/lang/StringBuilder;
    invoke-direct v13, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v13, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-static v12, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/4 v1, 0
    aput-object v0, v6, v1
    invoke-static v6, Lkotlin/collections/MapsKt;->mutableMapOf([Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v17
    sget-object v12, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string/jumbo v13, share_link
    const-class v14, Lcom/bytedance/trae/conversation/products/IShareLinkApi;
    const/4 v15, 0
    sget-object v0, Lcom/bytedance/trae/network/HostResolver;->INSTANCE Lcom/bytedance/trae/network/HostResolver;
    sget-object v1, Lcom/bytedance/trae/network/HostType;->REMOTE Lcom/bytedance/trae/network/HostType;
    invoke-virtual v0, v1, Lcom/bytedance/trae/network/HostResolver;->getBaseUrl(Lcom/bytedance/trae/network/HostType;)Ljava/lang/String;
    move-result-object v16
    const/16 v18, 0
    const/16 v19, 36
    const/16 v20, 0
    invoke-static/range v12 ... v20, Lcom/bytedance/trae/network/TraeHttpConnection;->createService$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Lcom/bytedance/retrofit2/Converter$Factory; Ljava/lang/String; Ljava/util/Map; Z I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/products/IShareLinkApi;
    iput v9, v3, Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion$createShareLink$1;->label I
    move-object/from16 v1, v23
    invoke-interface v0, v1, v3, Lcom/bytedance/trae/conversation/products/IShareLinkApi;->createShareLink(Lcom/bytedance/trae/conversation/products/ShareLinkRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v5, +003h
    return-object v5
    check-cast v0, Lcom/bytedance/trae/network/response/BizResponse;
    if-nez v0, +027h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "createShareLink response is null"
    invoke-virtual v0, v11, v1, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    const/16 v13, -1005
    const-string v14, "BizResponse is null"
    new-instance v1, Ljava/lang/Exception;
    const-string v2, "BizResponse is null"
    invoke-direct v1, v2, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V
    move-object v15, v1
    check-cast v15, Ljava/lang/Throwable;
    const/16 v16, 0
    const/16 v17, 8
    const/16 v18, 0
    move-object v12, v0
    invoke-direct/range v12 ... v18, Lcom/bytedance/trae/network/response/HttpDataResult$Error;-><init>(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult;
    goto/16 +0d5h
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v5
    invoke-virtual v3, v5, v6, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", msg="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->getMsg()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", shareSessionId="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/products/ShareLinkData;
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/products/ShareLinkData;->getShareSessionId()Ljava/lang/String;
    move-result-object v3
    goto +2h
    move-object v3, v10
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/products/ShareLinkData;
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/products/ShareLinkData;->getTitle()Ljava/lang/String;
    move-result-object v3
    goto +2h
    move-object v3, v10
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", anonymous="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/products/ShareLinkData;
    if-eqz v3, +00bh
    invoke-virtual v3, Lcom/bytedance/trae/conversation/products/ShareLinkData;->getAnonymous()Z
    move-result v3
    invoke-static v3, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v3
    goto +2h
    move-object v3, v10
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v11, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v1, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    new-instance v2, Lcom/bytedance/trae/network/response/BizResponse;
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v13
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->getMsg()Ljava/lang/String;
    move-result-object v15
    const/16 v16, 0
    const/16 v17, 0
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v18
    const/16 v19, 0
    const/16 v20, 44
    const/16 v21, 0
    move-object v12, v2
    invoke-direct/range v12 ... v21, Lcom/bytedance/trae/network/response/BizResponse;-><init>(J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Object; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-direct v1, v2, v10, Lcom/bytedance/trae/network/response/HttpDataResult$Success;-><init>(Lcom/bytedance/trae/network/response/BizResponse; Ljava/lang/Throwable;)V
    move-object v0, v1
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult;
    goto +41h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "createShareLink error: "
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v8, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/Class;->getName()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ": "
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v8, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v11, v1, v8, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    new-instance v0, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    const/16 v6, -1000
    invoke-virtual v8, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +003h
    goto +2h
    move-object v7, v1
    const/4 v9, 0
    const/16 v10, 8
    const/4 v11, 0
    move-object v5, v0
    invoke-direct/range v5 ... v11, Lcom/bytedance/trae/network/response/HttpDataResult$Error;-><init>(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult;
    return-object v0
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v2, "createShareLink cancelled"
    invoke-virtual v1, v11, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    throw v0
    :try_start_0x37
    :try_start_0x80
.end method

.method public final getLocalShareLink(com.bytedance.trae.conversation.products.GetLocalShareLinkRequest  kotlin.coroutines.Continuation)java.lang.Object
    .registers 21
    # ins_size=3
    move-object/from16 v0, v20
    const-string v1, "getLocalShareLink success: code="
    instance-of v2, v0, Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion$getLocalShareLink$1;
    if-eqz v2, +014h
    move-object v2, v0
    check-cast v2, Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion$getLocalShareLink$1;
    iget v3, v2, Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion$getLocalShareLink$1;->label I
    const/high16 v4, -2147483648
    and-int/2addr v3, v4
    if-eqz v3, +00ah
    iget v0, v2, Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion$getLocalShareLink$1;->label I
    sub-int/2addr v0, v4
    iput v0, v2, Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion$getLocalShareLink$1;->label I
    move-object/from16 v3, v18
    goto +8h
    new-instance v2, Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion$getLocalShareLink$1;
    move-object/from16 v3, v18
    invoke-direct v2, v3, v0, Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion$getLocalShareLink$1;-><init>(Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion; Lkotlin/coroutines/Continuation;)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion$getLocalShareLink$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v4
    iget v5, v2, Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion$getLocalShareLink$1;->label I
    const/4 v6, 1
    const-string v7, "ShareLinkApi"
    if-eqz v5, +016h
    if-ne v5, v6, +00ch
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +58h
    move-exception v0
    goto/16 +0e2h
    move-exception v0
    goto/16 +123h
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v1, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v1, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v5, Ljava/lang/StringBuilder;
    const-string v8, "getLocalShareLink request: conversationId="
    invoke-direct v5, v8, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v19, Lcom/bytedance/trae/conversation/products/GetLocalShareLinkRequest;->getConversationId()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v5, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v8, ", target="
    invoke-virtual v5, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual/range v19, Lcom/bytedance/trae/conversation/products/GetLocalShareLinkRequest;->getTarget()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v5, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v0, v7, v5, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v8, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string/jumbo v9, share_link_local_get
    const-class v10, Lcom/bytedance/trae/conversation/products/IShareLinkApi;
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/16 v15, 60
    const/16 v16, 0
    invoke-static/range v8 ... v16, Lcom/bytedance/trae/network/TraeHttpConnection;->createService$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Lcom/bytedance/retrofit2/Converter$Factory; Ljava/lang/String; Ljava/util/Map; Z I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/products/IShareLinkApi;
    iput v6, v2, Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion$getLocalShareLink$1;->label I
    move-object/from16 v5, v19
    invoke-interface v0, v5, v2, Lcom/bytedance/trae/conversation/products/IShareLinkApi;->getLocalShareLink(Lcom/bytedance/trae/conversation/products/GetLocalShareLinkRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v4, +003h
    return-object v4
    check-cast v0, Lcom/bytedance/trae/network/response/BizResponse;
    if-nez v0, +025h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "getLocalShareLink response is null"
    invoke-virtual v0, v7, v1, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    const/16 v9, -1005
    const-string v10, "BizResponse is null"
    new-instance v1, Ljava/lang/Exception;
    const-string v2, "BizResponse is null"
    invoke-direct v1, v2, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V
    move-object v11, v1
    check-cast v11, Ljava/lang/Throwable;
    const/4 v12, 0
    const/16 v13, 8
    const/4 v14, 0
    move-object v8, v0
    invoke-direct/range v8 ... v14, Lcom/bytedance/trae/network/response/HttpDataResult$Error;-><init>(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult;
    goto/16 +0aah
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v4, Ljava/lang/StringBuilder;
    invoke-direct v4, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v5
    invoke-virtual v4, v5, v6, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v4, ", msg="
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->getMsg()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v4, ", shareId="
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/conversation/products/GetLocalShareLinkData;
    const/4 v5, 0
    if-eqz v4, +007h
    invoke-virtual v4, Lcom/bytedance/trae/conversation/products/GetLocalShareLinkData;->getShareId()Ljava/lang/String;
    move-result-object v4
    goto +2h
    move-object v4, v5
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const/16 v4, 44
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v2, v7, v1, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v1, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    new-instance v2, Lcom/bytedance/trae/network/response/BizResponse;
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v9
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->getMsg()Ljava/lang/String;
    move-result-object v11
    const/4 v12, 0
    const/4 v13, 0
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v14
    const/4 v15, 0
    const/16 v16, 44
    const/16 v17, 0
    move-object v8, v2
    invoke-direct/range v8 ... v17, Lcom/bytedance/trae/network/response/BizResponse;-><init>(J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Object; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-direct v1, v2, v5, Lcom/bytedance/trae/network/response/HttpDataResult$Success;-><init>(Lcom/bytedance/trae/network/response/BizResponse; Ljava/lang/Throwable;)V
    move-object v0, v1
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult;
    goto +44h
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v4, "getLocalShareLink error: "
    invoke-direct v2, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/Class;->getName()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v4, ": "
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v0, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v7, v2, v0, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    new-instance v1, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    const/16 v5, -1000
    invoke-virtual v0, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +004h
    const-string v2, ""
    move-object v6, v2
    const/4 v8, 0
    const/16 v9, 8
    const/4 v10, 0
    move-object v4, v1
    move-object v7, v0
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/network/response/HttpDataResult$Error;-><init>(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object v0, v1
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult;
    return-object v0
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v2, "getLocalShareLink cancelled"
    invoke-virtual v1, v7, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    throw v0
    :try_start_0x30
    :try_start_0x6b
.end method

.method public final getRemoteShareLink(java.lang.String  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 27
    # ins_size=4
    move-object/from16 v0, v24
    move-object/from16 v1, v25
    move-object/from16 v2, v26
    const-string v3, "Cloud-IDE-JWT "
    const-string v4, "getRemoteShareLink success: code="
    instance-of v5, v2, Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion$getRemoteShareLink$1;
    if-eqz v5, +014h
    move-object v5, v2
    check-cast v5, Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion$getRemoteShareLink$1;
    iget v6, v5, Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion$getRemoteShareLink$1;->label I
    const/high16 v7, -2147483648
    and-int/2addr v6, v7
    if-eqz v6, +00ah
    iget v2, v5, Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion$getRemoteShareLink$1;->label I
    sub-int/2addr v2, v7
    iput v2, v5, Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion$getRemoteShareLink$1;->label I
    move-object/from16 v6, v23
    goto +8h
    new-instance v5, Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion$getRemoteShareLink$1;
    move-object/from16 v6, v23
    invoke-direct v5, v6, v2, Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion$getRemoteShareLink$1;-><init>(Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion; Lkotlin/coroutines/Continuation;)V
    iget-object v2, v5, Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion$getRemoteShareLink$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v7
    iget v8, v5, Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion$getRemoteShareLink$1;->label I
    const-string v9, ""
    const/4 v10, 1
    const/4 v11, 0
    const-string v12, "ShareLinkApi"
    if-eqz v8, +018h
    if-ne v8, v10, +00eh
    invoke-static v2, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +08bh
    move-exception v0
    move-object v10, v0
    goto/16 +129h
    move-exception v0
    goto/16 +167h
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v1, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v1, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    invoke-static v2, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v8, Ljava/lang/StringBuilder;
    const-string v13, "getRemoteShareLink request: chatSessionId="
    invoke-direct v8, v13, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v8, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    const-string v13, ", artifactPath="
    invoke-virtual v8, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v2, v12, v8, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v2
    const-class v8, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v2, v8, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/login/api/ILoginService;
    if-eqz v2, +007h
    invoke-interface v2, Lcom/bytedance/trae/login/api/ILoginService;->getXTToken()Ljava/lang/String;
    move-result-object v2
    goto +2h
    move-object v2, v11
    if-nez v2, +003h
    move-object v2, v9
    new-array v8, v10, [Lkotlin/Pair;
    const-string v13, "authorization"
    new-instance v14, Ljava/lang/StringBuilder;
    invoke-direct v14, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v14, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-static v13, v2, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v2
    const/4 v3, 0
    aput-object v2, v8, v3
    invoke-static v8, Lkotlin/collections/MapsKt;->mutableMapOf([Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v18
    sget-object v13, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string/jumbo v14, share_link_remote_get
    const-class v15, Lcom/bytedance/trae/conversation/products/IShareLinkApi;
    const/16 v16, 0
    sget-object v2, Lcom/bytedance/trae/network/HostResolver;->INSTANCE Lcom/bytedance/trae/network/HostResolver;
    sget-object v3, Lcom/bytedance/trae/network/HostType;->REMOTE Lcom/bytedance/trae/network/HostType;
    invoke-virtual v2, v3, Lcom/bytedance/trae/network/HostResolver;->getBaseUrl(Lcom/bytedance/trae/network/HostType;)Ljava/lang/String;
    move-result-object v17
    const/16 v19, 0
    const/16 v20, 36
    const/16 v21, 0
    invoke-static/range v13 ... v21, Lcom/bytedance/trae/network/TraeHttpConnection;->createService$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Lcom/bytedance/retrofit2/Converter$Factory; Ljava/lang/String; Ljava/util/Map; Z I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/products/IShareLinkApi;
    iput v10, v5, Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion$getRemoteShareLink$1;->label I
    invoke-interface v2, v0, v1, v5, Lcom/bytedance/trae/conversation/products/IShareLinkApi;->getRemoteShareLink(Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v7, +003h
    return-object v7
    check-cast v2, Lcom/bytedance/trae/network/response/BizResponse;
    if-nez v2, +028h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "getRemoteShareLink response is null"
    invoke-virtual v0, v12, v1, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    const/16 v14, -1005
    const-string v15, "BizResponse is null"
    new-instance v1, Ljava/lang/Exception;
    const-string v2, "BizResponse is null"
    invoke-direct v1, v2, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V
    move-object/from16 v16, v1
    check-cast v16, Ljava/lang/Throwable;
    const/16 v17, 0
    const/16 v18, 8
    const/16 v19, 0
    move-object v13, v0
    invoke-direct/range v13 ... v19, Lcom/bytedance/trae/network/response/HttpDataResult$Error;-><init>(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult;
    goto/16 +0bah
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v3
    invoke-virtual v1, v3, v4, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v3, ", msg="
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v2, Lcom/bytedance/trae/network/response/BizResponse;->getMsg()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v3, ", shareSessionId="
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v2, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/products/ShareArtifactData;
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/products/ShareArtifactData;->getShareSessionId()Ljava/lang/String;
    move-result-object v3
    goto +2h
    move-object v3, v11
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v3, ", status="
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v2, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/products/ShareArtifactData;
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/products/ShareArtifactData;->getStatus()Ljava/lang/String;
    move-result-object v3
    goto +2h
    move-object v3, v11
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v12, v1, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    new-instance v1, Lcom/bytedance/trae/network/response/BizResponse;
    invoke-virtual v2, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v14
    invoke-virtual v2, Lcom/bytedance/trae/network/response/BizResponse;->getMsg()Ljava/lang/String;
    move-result-object v16
    const/16 v17, 0
    const/16 v18, 0
    invoke-virtual v2, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v19
    const/16 v20, 0
    const/16 v21, 44
    const/16 v22, 0
    move-object v13, v1
    invoke-direct/range v13 ... v22, Lcom/bytedance/trae/network/response/BizResponse;-><init>(J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Object; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-direct v0, v1, v11, Lcom/bytedance/trae/network/response/HttpDataResult$Success;-><init>(Lcom/bytedance/trae/network/response/BizResponse; Ljava/lang/Throwable;)V
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult;
    goto +41h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "getRemoteShareLink error: "
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v10, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/Class;->getName()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ": "
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v10, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v12, v1, v10, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    new-instance v0, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    const/16 v8, -1000
    invoke-virtual v10, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +003h
    goto +2h
    move-object v9, v1
    const/4 v11, 0
    const/16 v12, 8
    const/4 v13, 0
    move-object v7, v0
    invoke-direct/range v7 ... v13, Lcom/bytedance/trae/network/response/HttpDataResult$Error;-><init>(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult;
    return-object v0
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v2, "getRemoteShareLink cancelled"
    invoke-virtual v1, v12, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    throw v0
    :try_start_0x39
    :try_start_0x6e
.end method

.method public final updateLocalShareLinkStatus(com.bytedance.trae.conversation.products.UpdateLocalShareLinkStatusRequest  kotlin.coroutines.Continuation)java.lang.Object
    .registers 23
    # ins_size=3
    move-object/from16 v0, v22
    const-string/jumbo v1, updateLocalShareLinkStatus success: code=
    instance-of v2, v0, Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion$updateLocalShareLinkStatus$1;
    if-eqz v2, +014h
    move-object v2, v0
    check-cast v2, Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion$updateLocalShareLinkStatus$1;
    iget v3, v2, Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion$updateLocalShareLinkStatus$1;->label I
    const/high16 v4, -2147483648
    and-int/2addr v3, v4
    if-eqz v3, +00ah
    iget v0, v2, Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion$updateLocalShareLinkStatus$1;->label I
    sub-int/2addr v0, v4
    iput v0, v2, Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion$updateLocalShareLinkStatus$1;->label I
    move-object/from16 v3, v20
    goto +8h
    new-instance v2, Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion$updateLocalShareLinkStatus$1;
    move-object/from16 v3, v20
    invoke-direct v2, v3, v0, Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion$updateLocalShareLinkStatus$1;-><init>(Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion; Lkotlin/coroutines/Continuation;)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion$updateLocalShareLinkStatus$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v4
    iget v5, v2, Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion$updateLocalShareLinkStatus$1;->label I
    const-string v6, ", status="
    const-string v7, ", shareId="
    const/4 v8, 1
    const-string v9, "ShareLinkApi"
    if-eqz v5, +017h
    if-ne v5, v8, +00dh
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +65h
    move-exception v0
    move-object v7, v0
    goto/16 +0ffh
    move-exception v0
    goto/16 +13fh
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v1, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v1, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v5, Ljava/lang/StringBuilder;
    const-string/jumbo v10, updateLocalShareLinkStatus request: conversationId=
    invoke-direct v5, v10, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v21, Lcom/bytedance/trae/conversation/products/UpdateLocalShareLinkStatusRequest;->getConversationId()Ljava/lang/String;
    move-result-object v10
    invoke-virtual v5, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual/range v21, Lcom/bytedance/trae/conversation/products/UpdateLocalShareLinkStatusRequest;->getShareId()Ljava/lang/String;
    move-result-object v10
    invoke-virtual v5, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual/range v21, Lcom/bytedance/trae/conversation/products/UpdateLocalShareLinkStatusRequest;->getStatus()Ljava/lang/String;
    move-result-object v10
    invoke-virtual v5, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v0, v9, v5, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v10, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string/jumbo v11, share_link_local_status
    const-class v12, Lcom/bytedance/trae/conversation/products/IShareLinkApi;
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 60
    const/16 v18, 0
    invoke-static/range v10 ... v18, Lcom/bytedance/trae/network/TraeHttpConnection;->createService$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Lcom/bytedance/retrofit2/Converter$Factory; Ljava/lang/String; Ljava/util/Map; Z I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/products/IShareLinkApi;
    iput v8, v2, Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion$updateLocalShareLinkStatus$1;->label I
    move-object/from16 v5, v21
    invoke-interface v0, v5, v2, Lcom/bytedance/trae/conversation/products/IShareLinkApi;->updateLocalShareLinkStatus(Lcom/bytedance/trae/conversation/products/UpdateLocalShareLinkStatusRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v4, +003h
    return-object v4
    check-cast v0, Lcom/bytedance/trae/network/response/BizResponse;
    if-nez v0, +027h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string/jumbo v1, updateLocalShareLinkStatus response is null
    invoke-virtual v0, v9, v1, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    const/16 v11, -1005
    const-string v12, "BizResponse is null"
    new-instance v1, Ljava/lang/Exception;
    const-string v2, "BizResponse is null"
    invoke-direct v1, v2, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V
    move-object v13, v1
    check-cast v13, Ljava/lang/Throwable;
    const/4 v14, 0
    const/16 v15, 8
    const/16 v16, 0
    move-object v10, v0
    invoke-direct/range v10 ... v16, Lcom/bytedance/trae/network/response/HttpDataResult$Error;-><init>(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult;
    goto/16 +0b8h
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v4, Ljava/lang/StringBuilder;
    invoke-direct v4, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v10
    invoke-virtual v4, v10, v11, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v4, ", msg="
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->getMsg()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/conversation/products/UpdateLocalShareLinkStatusData;
    const/4 v5, 0
    if-eqz v4, +007h
    invoke-virtual v4, Lcom/bytedance/trae/conversation/products/UpdateLocalShareLinkStatusData;->getShareId()Ljava/lang/String;
    move-result-object v4
    goto +2h
    move-object v4, v5
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/conversation/products/UpdateLocalShareLinkStatusData;
    if-eqz v4, +007h
    invoke-virtual v4, Lcom/bytedance/trae/conversation/products/UpdateLocalShareLinkStatusData;->getStatus()Ljava/lang/String;
    move-result-object v4
    goto +2h
    move-object v4, v5
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v2, v9, v1, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v1, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    new-instance v2, Lcom/bytedance/trae/network/response/BizResponse;
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v11
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->getMsg()Ljava/lang/String;
    move-result-object v13
    const/4 v14, 0
    const/4 v15, 0
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v16
    const/16 v17, 0
    const/16 v18, 44
    const/16 v19, 0
    move-object v10, v2
    invoke-direct/range v10 ... v19, Lcom/bytedance/trae/network/response/BizResponse;-><init>(J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Object; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-direct v1, v2, v5, Lcom/bytedance/trae/network/response/HttpDataResult$Success;-><init>(Lcom/bytedance/trae/network/response/BizResponse; Ljava/lang/Throwable;)V
    move-object v0, v1
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult;
    goto +43h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string/jumbo v2, updateLocalShareLinkStatus error: 
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v7, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/Class;->getName()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ": "
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v7, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v9, v1, v7, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    new-instance v0, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    const/16 v5, -1000
    invoke-virtual v7, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +004h
    const-string v1, ""
    move-object v6, v1
    const/4 v8, 0
    const/16 v9, 8
    const/4 v10, 0
    move-object v4, v0
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/network/response/HttpDataResult$Error;-><init>(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult;
    return-object v0
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string/jumbo v2, updateLocalShareLinkStatus cancelled
    invoke-virtual v1, v9, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    throw v0
    :try_start_0x35
    :try_start_0x7c
.end method

.method public final updateShareLinkStatus(java.lang.String  com.bytedance.trae.conversation.products.UpdateShareLinkStatusRequest  kotlin.coroutines.Continuation)java.lang.Object
    .registers 27
    # ins_size=4
    move-object/from16 v0, v24
    move-object/from16 v1, v26
    const-string v2, "Cloud-IDE-JWT "
    const-string/jumbo v3, updateShareLinkStatus success: code=
    instance-of v4, v1, Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion$updateShareLinkStatus$1;
    if-eqz v4, +014h
    move-object v4, v1
    check-cast v4, Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion$updateShareLinkStatus$1;
    iget v5, v4, Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion$updateShareLinkStatus$1;->label I
    const/high16 v6, -2147483648
    and-int/2addr v5, v6
    if-eqz v5, +00ah
    iget v1, v4, Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion$updateShareLinkStatus$1;->label I
    sub-int/2addr v1, v6
    iput v1, v4, Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion$updateShareLinkStatus$1;->label I
    move-object/from16 v5, v23
    goto +8h
    new-instance v4, Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion$updateShareLinkStatus$1;
    move-object/from16 v5, v23
    invoke-direct v4, v5, v1, Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion$updateShareLinkStatus$1;-><init>(Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion; Lkotlin/coroutines/Continuation;)V
    iget-object v1, v4, Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion$updateShareLinkStatus$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v6
    iget v7, v4, Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion$updateShareLinkStatus$1;->label I
    const-string v8, ""
    const-string v9, ", status="
    const/4 v10, 1
    const/4 v11, 0
    const-string v12, "ShareLinkApi"
    if-eqz v7, +018h
    if-ne v7, v10, +00eh
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +090h
    move-exception v0
    move-object v9, v0
    goto/16 +12dh
    move-exception v0
    goto/16 +16ch
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v1, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v1, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v7, Ljava/lang/StringBuilder;
    const-string/jumbo v13, updateShareLinkStatus request: shareSessionId=
    invoke-direct v7, v13, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v7, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual/range v25, Lcom/bytedance/trae/conversation/products/UpdateShareLinkStatusRequest;->getStatus()Ljava/lang/String;
    move-result-object v13
    invoke-virtual v7, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v1, v12, v7, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v1
    const-class v7, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v1, v7, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/login/api/ILoginService;
    if-eqz v1, +007h
    invoke-interface v1, Lcom/bytedance/trae/login/api/ILoginService;->getXTToken()Ljava/lang/String;
    move-result-object v1
    goto +2h
    move-object v1, v11
    if-nez v1, +003h
    move-object v1, v8
    new-array v7, v10, [Lkotlin/Pair;
    const-string v13, "authorization"
    new-instance v14, Ljava/lang/StringBuilder;
    invoke-direct v14, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v14, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-static v13, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/4 v2, 0
    aput-object v1, v7, v2
    invoke-static v7, Lkotlin/collections/MapsKt;->mutableMapOf([Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v18
    sget-object v13, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string/jumbo v14, share_link_status
    const-class v15, Lcom/bytedance/trae/conversation/products/IShareLinkApi;
    const/16 v16, 0
    sget-object v1, Lcom/bytedance/trae/network/HostResolver;->INSTANCE Lcom/bytedance/trae/network/HostResolver;
    sget-object v2, Lcom/bytedance/trae/network/HostType;->REMOTE Lcom/bytedance/trae/network/HostType;
    invoke-virtual v1, v2, Lcom/bytedance/trae/network/HostResolver;->getBaseUrl(Lcom/bytedance/trae/network/HostType;)Ljava/lang/String;
    move-result-object v17
    const/16 v19, 0
    const/16 v20, 36
    const/16 v21, 0
    invoke-static/range v13 ... v21, Lcom/bytedance/trae/network/TraeHttpConnection;->createService$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Lcom/bytedance/retrofit2/Converter$Factory; Ljava/lang/String; Ljava/util/Map; Z I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/products/IShareLinkApi;
    iput v10, v4, Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion$updateShareLinkStatus$1;->label I
    move-object/from16 v2, v25
    invoke-interface v1, v0, v2, v4, Lcom/bytedance/trae/conversation/products/IShareLinkApi;->updateShareLinkStatus(Ljava/lang/String; Lcom/bytedance/trae/conversation/products/UpdateShareLinkStatusRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    if-ne v1, v6, +003h
    return-object v6
    check-cast v1, Lcom/bytedance/trae/network/response/BizResponse;
    if-nez v1, +029h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string/jumbo v1, updateShareLinkStatus response is null
    invoke-virtual v0, v12, v1, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    const/16 v14, -1005
    const-string v15, "BizResponse is null"
    new-instance v1, Ljava/lang/Exception;
    const-string v2, "BizResponse is null"
    invoke-direct v1, v2, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V
    move-object/from16 v16, v1
    check-cast v16, Ljava/lang/Throwable;
    const/16 v17, 0
    const/16 v18, 8
    const/16 v19, 0
    move-object v13, v0
    invoke-direct/range v13 ... v19, Lcom/bytedance/trae/network/response/HttpDataResult$Error;-><init>(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult;
    goto/16 +0b9h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v3
    invoke-virtual v2, v3, v4, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", msg="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v1, Lcom/bytedance/trae/network/response/BizResponse;->getMsg()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", shareSessionId="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v1, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/products/UpdateShareLinkStatusData;
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/products/UpdateShareLinkStatusData;->getShareSessionId()Ljava/lang/String;
    move-result-object v3
    goto +2h
    move-object v3, v11
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v1, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/products/UpdateShareLinkStatusData;
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/products/UpdateShareLinkStatusData;->getStatus()Ljava/lang/String;
    move-result-object v3
    goto +2h
    move-object v3, v11
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v12, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    new-instance v2, Lcom/bytedance/trae/network/response/BizResponse;
    invoke-virtual v1, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v14
    invoke-virtual v1, Lcom/bytedance/trae/network/response/BizResponse;->getMsg()Ljava/lang/String;
    move-result-object v16
    const/16 v17, 0
    const/16 v18, 0
    invoke-virtual v1, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v19
    const/16 v20, 0
    const/16 v21, 44
    const/16 v22, 0
    move-object v13, v2
    invoke-direct/range v13 ... v22, Lcom/bytedance/trae/network/response/BizResponse;-><init>(J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Object; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-direct v0, v2, v11, Lcom/bytedance/trae/network/response/HttpDataResult$Success;-><init>(Lcom/bytedance/trae/network/response/BizResponse; Ljava/lang/Throwable;)V
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult;
    goto +42h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string/jumbo v2, updateShareLinkStatus error: 
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v9, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/Class;->getName()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ": "
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v9, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v12, v1, v9, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    new-instance v0, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    const/16 v7, -1000
    invoke-virtual v9, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +003h
    goto +2h
    move-object v8, v1
    const/4 v10, 0
    const/16 v11, 8
    const/4 v12, 0
    move-object v6, v0
    invoke-direct/range v6 ... v12, Lcom/bytedance/trae/network/response/HttpDataResult$Error;-><init>(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult;
    return-object v0
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string/jumbo v2, updateShareLinkStatus cancelled
    invoke-virtual v1, v12, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    throw v0
    :try_start_0x3a
    :try_start_0x72
.end method
