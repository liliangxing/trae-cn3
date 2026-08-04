# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi;
.super Ljava/lang/Object;
.source "ImageUploadApi.kt"

.implements Lcom/bytedance/trae/conversation/imageupload/ImageUploadApi;

.field private final baseUrlProvider:Lkotlin/jvm/functions/Function0;
.field private final headersProvider:Lkotlin/jvm/functions/Function1;
.field private final tag:Ljava/lang/String;


.method public constructor <init>(kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function1  java.lang.String)void
    .registers 5
    # ins_size=4
    const-string v0, "baseUrlProvider"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "headersProvider"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, tag
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi;->baseUrlProvider Lkotlin/jvm/functions/Function0;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi;->headersProvider Lkotlin/jvm/functions/Function1;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi;->tag Ljava/lang/String;
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function1  java.lang.String  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 6
    # ins_size=6
    and-int/lit8 v5, v4, 2
    if-eqz v5, +00ah
    new-instance v2, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi$1;
    const/4 v5, 0
    invoke-direct v2, v5, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi$1;-><init>(Lkotlin/coroutines/Continuation;)V
    check-cast v2, Lkotlin/jvm/functions/Function1;
    and-int/lit8 v4, v4, 4
    if-eqz v4, +004h
    const-string v3, "conversation_image_upload"
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi;-><init>(Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1; Ljava/lang/String;)V
    return-void 
.end method

.method public static final synthetic access$createService(com.bytedance.trae.conversation.imageupload.ConversationCopilotImageUploadApi  kotlin.coroutines.Continuation)java.lang.Object
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi;->createService(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method private final createService(kotlin.coroutines.Continuation)java.lang.Object
    .registers 12
    # ins_size=2
    instance-of v0, v11, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi$createService$1;
    if-eqz v0, +012h
    move-object v0, v11
    check-cast v0, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi$createService$1;
    iget v1, v0, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi$createService$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v11, v0, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi$createService$1;->label I
    sub-int/2addr v11, v2
    iput v11, v0, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi$createService$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi$createService$1;
    invoke-direct v0, v10, v11, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi$createService$1;-><init>(Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi; Lkotlin/coroutines/Continuation;)V
    iget-object v11, v0, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi$createService$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi$createService$1;->label I
    const/4 v3, 1
    if-eqz v2, +014h
    if-ne v2, v3, +00ah
    iget-object v0, v0, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi$createService$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi;
    invoke-static v11, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +1ah
    new-instance v11, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v11, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v11
    invoke-static v11, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v11, v10, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi;->headersProvider Lkotlin/jvm/functions/Function1;
    iput-object v10, v0, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi$createService$1;->L$0 Ljava/lang/Object;
    iput v3, v0, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi$createService$1;->label I
    invoke-interface v11, v0, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v11
    if-ne v11, v1, +003h
    return-object v1
    move-object v0, v10
    move-object v6, v11
    check-cast v6, Ljava/util/Map;
    sget-object v1, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    iget-object v2, v0, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi;->tag Ljava/lang/String;
    const-class v3, Lcom/bytedance/trae/conversation/imageupload/ICopilotImageUploadRetrofitApi;
    const/4 v4, 0
    iget-object v11, v0, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi;->baseUrlProvider Lkotlin/jvm/functions/Function0;
    invoke-interface v11, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    move-result-object v11
    move-object v5, v11
    check-cast v5, Ljava/lang/String;
    const/4 v7, 0
    const/16 v8, 36
    const/4 v9, 0
    invoke-static/range v1 ... v9, Lcom/bytedance/trae/network/TraeHttpConnection;->createService$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Lcom/bytedance/retrofit2/Converter$Factory; Ljava/lang/String; Ljava/util/Map; Z I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v11
    return-object v11
.end method

.method private final isEnterpriseLogin()boolean
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/LoginUtils;->INSTANCE Lcom/bytedance/trae/conversation/LoginUtils;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/LoginUtils;->isEnterpriseLogin()Z
    move-result v0
    return v0
.end method

.method public checkImageContent(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 9
    # ins_size=3
    instance-of v0, v8, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi$checkImageContent$1;
    if-eqz v0, +012h
    move-object v0, v8
    check-cast v0, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi$checkImageContent$1;
    iget v1, v0, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi$checkImageContent$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v8, v0, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi$checkImageContent$1;->label I
    sub-int/2addr v8, v2
    iput v8, v0, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi$checkImageContent$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi$checkImageContent$1;
    invoke-direct v0, v6, v8, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi$checkImageContent$1;-><init>(Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi; Lkotlin/coroutines/Continuation;)V
    iget-object v8, v0, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi$checkImageContent$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi$checkImageContent$1;->label I
    const/4 v3, 0
    const/4 v4, 2
    const/4 v5, 1
    if-eqz v2, +01ah
    if-eq v2, v5, +010h
    if-ne v2, v4, +006h
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +31h
    new-instance v7, Ljava/lang/IllegalStateException;
    const-string v8, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v7, v8, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v7
    iget-object v7, v0, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi$checkImageContent$1;->L$0 Ljava/lang/Object;
    check-cast v7, Ljava/lang/String;
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +fh
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iput-object v7, v0, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi$checkImageContent$1;->L$0 Ljava/lang/Object;
    iput v5, v0, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi$checkImageContent$1;->label I
    invoke-direct v6, v0, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi;->createService(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v8
    if-ne v8, v1, +003h
    return-object v1
    check-cast v8, Lcom/bytedance/trae/conversation/imageupload/ICopilotImageUploadRetrofitApi;
    new-instance v2, Lcom/bytedance/trae/conversation/imageupload/CheckContentRequest;
    invoke-direct v2, v7, Lcom/bytedance/trae/conversation/imageupload/CheckContentRequest;-><init>(Ljava/lang/String;)V
    iput-object v3, v0, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi$checkImageContent$1;->L$0 Ljava/lang/Object;
    iput v4, v0, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi$checkImageContent$1;->label I
    invoke-interface v8, v2, v0, Lcom/bytedance/trae/conversation/imageupload/ICopilotImageUploadRetrofitApi;->checkContent(Lcom/bytedance/trae/conversation/imageupload/CheckContentRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v8
    if-ne v8, v1, +003h
    return-object v1
    check-cast v8, Lcom/bytedance/trae/conversation/imageupload/CheckContentResponse;
    new-instance v7, Lcom/bytedance/trae/conversation/imageupload/ContentCheckResult;
    invoke-virtual v8, Lcom/bytedance/trae/conversation/imageupload/CheckContentResponse;->getPass()Z
    move-result v8
    invoke-static v8, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v8
    const/4 v0, 0
    invoke-direct v7, v0, v8, Lcom/bytedance/trae/conversation/imageupload/ContentCheckResult;-><init>(I Ljava/lang/Boolean;)V
    move-object v3, v7
    return-object v3
    :try_start_0x2a
    :try_start_0x3a
    :try_start_0x41
.end method

.method public getImageUrls(java.util.List  kotlin.coroutines.Continuation)java.lang.Object
    .registers 9
    # ins_size=3
    instance-of v0, v8, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi$getImageUrls$1;
    if-eqz v0, +012h
    move-object v0, v8
    check-cast v0, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi$getImageUrls$1;
    iget v1, v0, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi$getImageUrls$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v8, v0, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi$getImageUrls$1;->label I
    sub-int/2addr v8, v2
    iput v8, v0, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi$getImageUrls$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi$getImageUrls$1;
    invoke-direct v0, v6, v8, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi$getImageUrls$1;-><init>(Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi; Lkotlin/coroutines/Continuation;)V
    iget-object v8, v0, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi$getImageUrls$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi$getImageUrls$1;->label I
    const/4 v3, 2
    const/4 v4, 1
    if-eqz v2, +020h
    if-eq v2, v4, +012h
    if-ne v2, v3, +008h
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +52h
    move-exception v7
    goto +57h
    new-instance v7, Ljava/lang/IllegalStateException;
    const-string v8, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v7, v8, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v7
    iget-object v7, v0, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi$getImageUrls$1;->L$1 Ljava/lang/Object;
    check-cast v7, Ljava/util/List;
    iget-object v2, v0, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi$getImageUrls$1;->L$0 Ljava/lang/Object;
    check-cast v2, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi;
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +1dh
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    invoke-interface v7, Ljava/util/List;->isEmpty()Z
    move-result v8
    if-eqz v8, +007h
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v7
    return-object v7
    iput-object v6, v0, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi$getImageUrls$1;->L$0 Ljava/lang/Object;
    iput-object v7, v0, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi$getImageUrls$1;->L$1 Ljava/lang/Object;
    iput v4, v0, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi$getImageUrls$1;->label I
    invoke-direct v6, v0, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi;->createService(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v8
    if-ne v8, v1, +003h
    return-object v1
    move-object v2, v6
    check-cast v8, Lcom/bytedance/trae/conversation/imageupload/ICopilotImageUploadRetrofitApi;
    new-instance v4, Lcom/bytedance/trae/conversation/imageupload/GetResourceUrlRequest;
    invoke-direct v2, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi;->isEnterpriseLogin()Z
    move-result v2
    const/4 v5, 0
    if-eqz v2, +005h
    const-string v2, "image"
    goto +2h
    move-object v2, v5
    invoke-direct v4, v7, v2, Lcom/bytedance/trae/conversation/imageupload/GetResourceUrlRequest;-><init>(Ljava/util/List; Ljava/lang/String;)V
    iput-object v5, v0, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi$getImageUrls$1;->L$0 Ljava/lang/Object;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi$getImageUrls$1;->L$1 Ljava/lang/Object;
    iput v3, v0, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi$getImageUrls$1;->label I
    invoke-interface v8, v4, v0, Lcom/bytedance/trae/conversation/imageupload/ICopilotImageUploadRetrofitApi;->getResourceUrl(Lcom/bytedance/trae/conversation/imageupload/GetResourceUrlRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v8
    if-ne v8, v1, +003h
    return-object v1
    check-cast v8, Lcom/bytedance/trae/conversation/imageupload/GetResourceUrlResponse;
    invoke-virtual v8, Lcom/bytedance/trae/conversation/imageupload/GetResourceUrlResponse;->getUrlMap()Ljava/util/Map;
    move-result-object v7
    return-object v7
    new-instance v8, Lcom/bytedance/trae/conversation/imageupload/ImageUploadException;
    sget-object v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;->NETWORK_ERROR Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "getImageUrls failed: "
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v7, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-direct v8, v0, v1, v7, Lcom/bytedance/trae/conversation/imageupload/ImageUploadException;-><init>(Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode; Ljava/lang/String; Ljava/lang/Throwable;)V
    throw v8
    :try_start_0x29
    :try_start_0x3f
    :try_start_0x51
.end method

.method public getStsToken(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 7
    # ins_size=3
    instance-of v5, v6, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi$getStsToken$1;
    if-eqz v5, +012h
    move-object v5, v6
    check-cast v5, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi$getStsToken$1;
    iget v0, v5, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi$getStsToken$1;->label I
    const/high16 v1, -2147483648
    and-int/2addr v0, v1
    if-eqz v0, +008h
    iget v6, v5, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi$getStsToken$1;->label I
    sub-int/2addr v6, v1
    iput v6, v5, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi$getStsToken$1;->label I
    goto +6h
    new-instance v5, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi$getStsToken$1;
    invoke-direct v5, v4, v6, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi$getStsToken$1;-><init>(Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi; Lkotlin/coroutines/Continuation;)V
    iget-object v6, v5, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi$getStsToken$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v5, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi$getStsToken$1;->label I
    const/4 v2, 2
    const/4 v3, 1
    if-eqz v1, +018h
    if-eq v1, v3, +010h
    if-ne v1, v2, +006h
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +2ah
    new-instance v5, Ljava/lang/IllegalStateException;
    const-string v6, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v5, v6, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v5
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +fh
    move-exception v5
    goto +1dh
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iput v3, v5, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi$getStsToken$1;->label I
    invoke-direct v4, v5, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi;->createService(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v6
    if-ne v6, v0, +003h
    return-object v0
    check-cast v6, Lcom/bytedance/trae/conversation/imageupload/ICopilotImageUploadRetrofitApi;
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v1
    iput v2, v5, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi$getStsToken$1;->label I
    invoke-interface v6, v1, v5, Lcom/bytedance/trae/conversation/imageupload/ICopilotImageUploadRetrofitApi;->getResourceUploadToken(Ljava/util/Map; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v6
    if-ne v6, v0, +003h
    return-object v0
    return-object v6
    new-instance v6, Lcom/bytedance/trae/conversation/imageupload/ImageUploadException;
    sget-object v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;->TOKEN_FETCH_FAILED Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "getStsToken failed: "
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v5, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-direct v6, v0, v1, v5, Lcom/bytedance/trae/conversation/imageupload/ImageUploadException;-><init>(Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode; Ljava/lang/String; Ljava/lang/Throwable;)V
    throw v6
    :try_start_0x29
    :try_start_0x35
    :try_start_0x3e
.end method
