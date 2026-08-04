# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/fileupload/FileUploadService$downloadSingleFile$2;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "FileUploadService.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $bizType:Lcom/bytedance/trae/conversation/fileupload/BizType;
.field final synthetic $enableMagic:Z
.field final synthetic $oid:Ljava/lang/String;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/fileupload/FileUploadService;


.method constructor <init>(com.bytedance.trae.conversation.fileupload.FileUploadService  java.lang.String  com.bytedance.trae.conversation.fileupload.BizType  boolean  kotlin.coroutines.Continuation)void
    .registers 6
    # ins_size=6
    iput-object v1, v0, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$downloadSingleFile$2;->this$0 Lcom/bytedance/trae/conversation/fileupload/FileUploadService;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$downloadSingleFile$2;->$oid Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$downloadSingleFile$2;->$bizType Lcom/bytedance/trae/conversation/fileupload/BizType;
    iput-boolean v4, v0, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$downloadSingleFile$2;->$enableMagic Z
    const/4 v1, 2
    invoke-direct v0, v1, v5, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 9
    # ins_size=3
    new-instance v7, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$downloadSingleFile$2;
    iget-object v1, v6, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$downloadSingleFile$2;->this$0 Lcom/bytedance/trae/conversation/fileupload/FileUploadService;
    iget-object v2, v6, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$downloadSingleFile$2;->$oid Ljava/lang/String;
    iget-object v3, v6, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$downloadSingleFile$2;->$bizType Lcom/bytedance/trae/conversation/fileupload/BizType;
    iget-boolean v4, v6, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$downloadSingleFile$2;->$enableMagic Z
    move-object v0, v7
    move-object v5, v8
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$downloadSingleFile$2;-><init>(Lcom/bytedance/trae/conversation/fileupload/FileUploadService; Ljava/lang/String; Lcom/bytedance/trae/conversation/fileupload/BizType; Z Lkotlin/coroutines/Continuation;)V
    check-cast v7, Lkotlin/coroutines/Continuation;
    return-object v7
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$downloadSingleFile$2;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$downloadSingleFile$2;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$downloadSingleFile$2;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$downloadSingleFile$2;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 7
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v5, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$downloadSingleFile$2;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +2bh
    new-instance v6, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v6, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v6
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v6, v5, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$downloadSingleFile$2;->this$0 Lcom/bytedance/trae/conversation/fileupload/FileUploadService;
    invoke-static v6, Lcom/bytedance/trae/conversation/fileupload/FileUploadService;->access$getApi$p(Lcom/bytedance/trae/conversation/fileupload/FileUploadService;)Lcom/bytedance/trae/conversation/fileupload/ResourceUploadApi;
    move-result-object v6
    new-instance v1, Lcom/bytedance/trae/conversation/fileupload/GetResourceUrlRequest;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$downloadSingleFile$2;->$oid Ljava/lang/String;
    invoke-static v3, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v3
    iget-object v4, v5, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$downloadSingleFile$2;->$bizType Lcom/bytedance/trae/conversation/fileupload/BizType;
    invoke-direct v1, v3, v4, Lcom/bytedance/trae/conversation/fileupload/GetResourceUrlRequest;-><init>(Ljava/util/List; Lcom/bytedance/trae/conversation/fileupload/BizType;)V
    move-object v3, v5
    check-cast v3, Lkotlin/coroutines/Continuation;
    iput v2, v5, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$downloadSingleFile$2;->label I
    invoke-interface v6, v1, v3, Lcom/bytedance/trae/conversation/fileupload/ResourceUploadApi;->getResourceUrl(Lcom/bytedance/trae/conversation/fileupload/GetResourceUrlRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v6
    if-ne v6, v0, +003h
    return-object v0
    check-cast v6, Lcom/bytedance/trae/conversation/fileupload/GetResourceUrlResponse;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/fileupload/GetResourceUrlResponse;->getUrlMap()Ljava/util/Map;
    move-result-object v6
    iget-object v0, v5, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$downloadSingleFile$2;->$oid Ljava/lang/String;
    invoke-interface v6, v0, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Ljava/lang/String;
    if-eqz v6, +05ch
    iget-object v0, v5, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$downloadSingleFile$2;->this$0 Lcom/bytedance/trae/conversation/fileupload/FileUploadService;
    invoke-static v0, Lcom/bytedance/trae/conversation/fileupload/FileUploadService;->access$createObjectStoreApi(Lcom/bytedance/trae/conversation/fileupload/FileUploadService;)Lcom/bytedance/trae/conversation/fileupload/FileUploadService$IObjectStoreApi;
    move-result-object v0
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v1
    invoke-interface v0, v6, v1, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$IObjectStoreApi;->get(Ljava/lang/String; Ljava/util/Map;)Lcom/bytedance/retrofit2/Call;
    move-result-object v6
    invoke-interface v6, Lcom/bytedance/retrofit2/Call;->execute()Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v6
    const-string v0, "execute(...)"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v6, Lcom/bytedance/retrofit2/SsResponse;->isSuccessful()Z
    move-result v0
    if-eqz v0, +026h
    invoke-virtual v6, Lcom/bytedance/retrofit2/SsResponse;->body()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Lcom/bytedance/retrofit2/mime/TypedInput;
    if-nez v6, +006h
    const/4 v6, 0
    new-array v6, v6, [B
    return-object v6
    iget-object v0, v5, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$downloadSingleFile$2;->this$0 Lcom/bytedance/trae/conversation/fileupload/FileUploadService;
    invoke-interface v6, Lcom/bytedance/retrofit2/mime/TypedInput;->in()Ljava/io/InputStream;
    move-result-object v6
    const-string v1, "in(...)"
    invoke-static v6, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v0, v6, Lcom/bytedance/trae/conversation/fileupload/FileUploadService;->access$readAllBytes(Lcom/bytedance/trae/conversation/fileupload/FileUploadService; Ljava/io/InputStream;)[B
    move-result-object v6
    iget-boolean v0, v5, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$downloadSingleFile$2;->$enableMagic Z
    if-eqz v0, +006h
    invoke-static v6, Lcom/bytedance/trae/conversation/fileupload/ResourceUploadUtilKt;->decodeContent([B)[B
    move-result-object v6
    return-object v6
    new-instance v0, Ljava/lang/IllegalStateException;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "Download failed with status "
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v6, Lcom/bytedance/retrofit2/SsResponse;->code()I
    move-result v6
    invoke-virtual v1, v6, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    invoke-direct v0, v6, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    new-instance v6, Ljava/lang/IllegalStateException;
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "No URL found for oid: "
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v5, Lcom/bytedance/trae/conversation/fileupload/FileUploadService$downloadSingleFile$2;->$oid Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-direct v6, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v6
.end method
