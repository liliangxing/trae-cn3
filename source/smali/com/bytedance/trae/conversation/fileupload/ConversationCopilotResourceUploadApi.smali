# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;
.super Ljava/lang/Object;
.source "ResourceUploadApi.kt"

.implements Lcom/bytedance/trae/conversation/fileupload/ResourceUploadApi;

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
    iput-object v2, v1, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;->baseUrlProvider Lkotlin/jvm/functions/Function0;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;->headersProvider Lkotlin/jvm/functions/Function1;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;->tag Ljava/lang/String;
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function1  java.lang.String  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 6
    # ins_size=6
    and-int/lit8 v5, v4, 2
    if-eqz v5, +00ah
    new-instance v2, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi$1;
    const/4 v5, 0
    invoke-direct v2, v5, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi$1;-><init>(Lkotlin/coroutines/Continuation;)V
    check-cast v2, Lkotlin/jvm/functions/Function1;
    and-int/lit8 v4, v4, 4
    if-eqz v4, +004h
    const-string v3, "conversation_file_upload"
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;-><init>(Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1; Ljava/lang/String;)V
    return-void 
.end method

.method public static final synthetic access$createService(com.bytedance.trae.conversation.fileupload.ConversationCopilotResourceUploadApi  kotlin.coroutines.Continuation)java.lang.Object
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;->createService(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method private final createService(kotlin.coroutines.Continuation)java.lang.Object
    .registers 12
    # ins_size=2
    instance-of v0, v11, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi$createService$1;
    if-eqz v0, +012h
    move-object v0, v11
    check-cast v0, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi$createService$1;
    iget v1, v0, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi$createService$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v11, v0, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi$createService$1;->label I
    sub-int/2addr v11, v2
    iput v11, v0, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi$createService$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi$createService$1;
    invoke-direct v0, v10, v11, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi$createService$1;-><init>(Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi; Lkotlin/coroutines/Continuation;)V
    iget-object v11, v0, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi$createService$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi$createService$1;->label I
    const/4 v3, 1
    if-eqz v2, +022h
    if-ne v2, v3, +018h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi$createService$1;->L$3 Ljava/lang/Object;
    check-cast v1, Ljava/lang/String;
    iget-object v2, v0, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi$createService$1;->L$2 Ljava/lang/Object;
    check-cast v2, Ljava/lang/Class;
    iget-object v3, v0, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi$createService$1;->L$1 Ljava/lang/Object;
    check-cast v3, Ljava/lang/String;
    iget-object v0, v0, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi$createService$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/network/TraeHttpConnection;
    invoke-static v11, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v4, v1
    move-object v1, v3
    goto +33h
    new-instance v11, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v11, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v11
    invoke-static v11, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v11, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    iget-object v2, v10, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;->tag Ljava/lang/String;
    const-class v4, Lcom/bytedance/trae/conversation/fileupload/ICopilotResourceUploadRetrofitApi;
    iget-object v5, v10, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;->baseUrlProvider Lkotlin/jvm/functions/Function0;
    invoke-interface v5, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Ljava/lang/String;
    iget-object v6, v10, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;->headersProvider Lkotlin/jvm/functions/Function1;
    iput-object v11, v0, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi$createService$1;->L$0 Ljava/lang/Object;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi$createService$1;->L$1 Ljava/lang/Object;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi$createService$1;->L$2 Ljava/lang/Object;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi$createService$1;->L$3 Ljava/lang/Object;
    iput v3, v0, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi$createService$1;->label I
    invoke-interface v6, v0, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v1, +003h
    return-object v1
    move-object v1, v2
    move-object v2, v4
    move-object v4, v5
    move-object v9, v0
    move-object v0, v11
    move-object v11, v9
    const/4 v3, 0
    move-object v5, v11
    check-cast v5, Ljava/util/Map;
    const/4 v6, 0
    const/16 v7, 36
    const/4 v8, 0
    invoke-static/range v0 ... v8, Lcom/bytedance/trae/network/TraeHttpConnection;->createService$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Lcom/bytedance/retrofit2/Converter$Factory; Ljava/lang/String; Ljava/util/Map; Z I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v11
    return-object v11
.end method

.method public commitResourceUploadResult(com.bytedance.trae.conversation.fileupload.CommitResourceUploadResultRequest  kotlin.coroutines.Continuation)java.lang.Object
    .registers 8
    # ins_size=3
    instance-of v0, v7, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi$commitResourceUploadResult$1;
    if-eqz v0, +012h
    move-object v0, v7
    check-cast v0, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi$commitResourceUploadResult$1;
    iget v1, v0, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi$commitResourceUploadResult$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v7, v0, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi$commitResourceUploadResult$1;->label I
    sub-int/2addr v7, v2
    iput v7, v0, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi$commitResourceUploadResult$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi$commitResourceUploadResult$1;
    invoke-direct v0, v5, v7, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi$commitResourceUploadResult$1;-><init>(Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi; Lkotlin/coroutines/Continuation;)V
    iget-object v7, v0, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi$commitResourceUploadResult$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi$commitResourceUploadResult$1;->label I
    const/4 v3, 2
    const/4 v4, 1
    if-eqz v2, +01ah
    if-eq v2, v4, +010h
    if-ne v2, v3, +006h
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +2dh
    new-instance v6, Ljava/lang/IllegalStateException;
    const-string v7, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v6, v7, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v6
    iget-object v6, v0, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi$commitResourceUploadResult$1;->L$0 Ljava/lang/Object;
    check-cast v6, Lcom/bytedance/trae/conversation/fileupload/CommitResourceUploadResultRequest;
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +fh
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iput-object v6, v0, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi$commitResourceUploadResult$1;->L$0 Ljava/lang/Object;
    iput v4, v0, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi$commitResourceUploadResult$1;->label I
    invoke-direct v5, v0, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;->createService(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v1, +003h
    return-object v1
    check-cast v7, Lcom/bytedance/trae/conversation/fileupload/ICopilotResourceUploadRetrofitApi;
    const/4 v2, 0
    iput-object v2, v0, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi$commitResourceUploadResult$1;->L$0 Ljava/lang/Object;
    iput v3, v0, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi$commitResourceUploadResult$1;->label I
    invoke-interface v7, v6, v0, Lcom/bytedance/trae/conversation/fileupload/ICopilotResourceUploadRetrofitApi;->commitResourceUploadResult(Lcom/bytedance/trae/conversation/fileupload/CommitResourceUploadResultRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v6
    if-ne v6, v1, +003h
    return-object v1
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v6
.end method

.method public getResourceUploadUrl(com.bytedance.trae.conversation.fileupload.GetResourceUploadUrlRequest  kotlin.coroutines.Continuation)java.lang.Object
    .registers 8
    # ins_size=3
    instance-of v0, v7, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi$getResourceUploadUrl$1;
    if-eqz v0, +012h
    move-object v0, v7
    check-cast v0, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi$getResourceUploadUrl$1;
    iget v1, v0, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi$getResourceUploadUrl$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v7, v0, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi$getResourceUploadUrl$1;->label I
    sub-int/2addr v7, v2
    iput v7, v0, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi$getResourceUploadUrl$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi$getResourceUploadUrl$1;
    invoke-direct v0, v5, v7, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi$getResourceUploadUrl$1;-><init>(Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi; Lkotlin/coroutines/Continuation;)V
    iget-object v7, v0, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi$getResourceUploadUrl$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi$getResourceUploadUrl$1;->label I
    const/4 v3, 2
    const/4 v4, 1
    if-eqz v2, +01ah
    if-eq v2, v4, +010h
    if-ne v2, v3, +006h
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +2dh
    new-instance v6, Ljava/lang/IllegalStateException;
    const-string v7, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v6, v7, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v6
    iget-object v6, v0, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi$getResourceUploadUrl$1;->L$0 Ljava/lang/Object;
    check-cast v6, Lcom/bytedance/trae/conversation/fileupload/GetResourceUploadUrlRequest;
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +fh
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iput-object v6, v0, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi$getResourceUploadUrl$1;->L$0 Ljava/lang/Object;
    iput v4, v0, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi$getResourceUploadUrl$1;->label I
    invoke-direct v5, v0, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;->createService(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v1, +003h
    return-object v1
    check-cast v7, Lcom/bytedance/trae/conversation/fileupload/ICopilotResourceUploadRetrofitApi;
    const/4 v2, 0
    iput-object v2, v0, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi$getResourceUploadUrl$1;->L$0 Ljava/lang/Object;
    iput v3, v0, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi$getResourceUploadUrl$1;->label I
    invoke-interface v7, v6, v0, Lcom/bytedance/trae/conversation/fileupload/ICopilotResourceUploadRetrofitApi;->getResourceUploadUrl(Lcom/bytedance/trae/conversation/fileupload/GetResourceUploadUrlRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v1, +003h
    return-object v1
    return-object v7
.end method

.method public getResourceUrl(com.bytedance.trae.conversation.fileupload.GetResourceUrlRequest  kotlin.coroutines.Continuation)java.lang.Object
    .registers 8
    # ins_size=3
    instance-of v0, v7, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi$getResourceUrl$1;
    if-eqz v0, +012h
    move-object v0, v7
    check-cast v0, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi$getResourceUrl$1;
    iget v1, v0, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi$getResourceUrl$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v7, v0, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi$getResourceUrl$1;->label I
    sub-int/2addr v7, v2
    iput v7, v0, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi$getResourceUrl$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi$getResourceUrl$1;
    invoke-direct v0, v5, v7, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi$getResourceUrl$1;-><init>(Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi; Lkotlin/coroutines/Continuation;)V
    iget-object v7, v0, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi$getResourceUrl$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi$getResourceUrl$1;->label I
    const/4 v3, 2
    const/4 v4, 1
    if-eqz v2, +01ah
    if-eq v2, v4, +010h
    if-ne v2, v3, +006h
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +2dh
    new-instance v6, Ljava/lang/IllegalStateException;
    const-string v7, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v6, v7, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v6
    iget-object v6, v0, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi$getResourceUrl$1;->L$0 Ljava/lang/Object;
    check-cast v6, Lcom/bytedance/trae/conversation/fileupload/GetResourceUrlRequest;
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +fh
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iput-object v6, v0, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi$getResourceUrl$1;->L$0 Ljava/lang/Object;
    iput v4, v0, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi$getResourceUrl$1;->label I
    invoke-direct v5, v0, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;->createService(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v1, +003h
    return-object v1
    check-cast v7, Lcom/bytedance/trae/conversation/fileupload/ICopilotResourceUploadRetrofitApi;
    const/4 v2, 0
    iput-object v2, v0, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi$getResourceUrl$1;->L$0 Ljava/lang/Object;
    iput v3, v0, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi$getResourceUrl$1;->label I
    invoke-interface v7, v6, v0, Lcom/bytedance/trae/conversation/fileupload/ICopilotResourceUploadRetrofitApi;->getResourceUrl(Lcom/bytedance/trae/conversation/fileupload/GetResourceUrlRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v1, +003h
    return-object v1
    return-object v7
.end method
