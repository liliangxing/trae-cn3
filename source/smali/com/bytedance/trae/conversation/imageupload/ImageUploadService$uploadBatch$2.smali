# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ImageUploadService.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $concurrency:I
.field final synthetic $currentCount:I
.field final synthetic $files:Ljava/util/List;
.field final synthetic $onItemProgress:Lkotlin/jvm/functions/Function2;
.field private synthetic L$0:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;


.method constructor <init>(int  java.util.List  int  com.bytedance.trae.conversation.imageupload.ImageUploadService  kotlin.jvm.functions.Function2  kotlin.coroutines.Continuation)void
    .registers 7
    # ins_size=7
    iput v1, v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2;->$currentCount I
    iput-object v2, v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2;->$files Ljava/util/List;
    iput v3, v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2;->$concurrency I
    iput-object v4, v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2;->this$0 Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2;->$onItemProgress Lkotlin/jvm/functions/Function2;
    const/4 v1, 2
    invoke-direct v0, v1, v6, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 11
    # ins_size=3
    new-instance v7, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2;
    iget v1, v8, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2;->$currentCount I
    iget-object v2, v8, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2;->$files Ljava/util/List;
    iget v3, v8, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2;->$concurrency I
    iget-object v4, v8, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2;->this$0 Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;
    iget-object v5, v8, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2;->$onItemProgress Lkotlin/jvm/functions/Function2;
    move-object v0, v7
    move-object v6, v10
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2;-><init>(I Ljava/util/List; I Lcom/bytedance/trae/conversation/imageupload/ImageUploadService; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)V
    iput-object v9, v7, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2;->L$0 Ljava/lang/Object;
    check-cast v7, Lkotlin/coroutines/Continuation;
    return-object v7
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 24
    # ins_size=2
    move-object/from16 v0, v22
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2;->label I
    const/4 v3, 0
    const/4 v4, 1
    if-eqz v2, +017h
    if-ne v2, v4, +00dh
    iget-object v1, v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2;->L$0 Ljava/lang/Object;
    check-cast v1, Ljava/util/List;
    invoke-static/range v23, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v2, v23
    goto/16 +0fah
    new-instance v1, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v1, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v1
    invoke-static/range v23, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v2, v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2;->L$0 Ljava/lang/Object;
    check-cast v2, Lkotlinx/coroutines/CoroutineScope;
    sget-object v5, Lcom/bytedance/trae/conversation/imageupload/ImageValidation;->INSTANCE Lcom/bytedance/trae/conversation/imageupload/ImageValidation;
    iget v6, v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2;->$currentCount I
    iget-object v7, v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2;->$files Ljava/util/List;
    invoke-interface v7, Ljava/util/List;->size()I
    move-result v7
    invoke-virtual v5, v6, v7, Lcom/bytedance/trae/conversation/imageupload/ImageValidation;->validateImageCount(I I)Lkotlin/Pair;
    move-result-object v5
    invoke-virtual v5, Lkotlin/Pair;->component1()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;
    invoke-virtual v5, Lkotlin/Pair;->component2()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Ljava/lang/Number;
    invoke-virtual v5, Ljava/lang/Number;->intValue()I
    move-result v5
    iget-object v7, v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2;->$files Ljava/util/List;
    check-cast v7, Ljava/lang/Iterable;
    invoke-static v7, v5, Lkotlin/collections/CollectionsKt;->take(Ljava/lang/Iterable; I)Ljava/util/List;
    move-result-object v11
    invoke-virtual v6, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;->getValid()Z
    move-result v5
    const/16 v7, 10
    if-nez v5, +04bh
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v1
    iget-object v2, v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2;->$files Ljava/util/List;
    check-cast v2, Ljava/lang/Iterable;
    new-instance v3, Ljava/util/ArrayList;
    invoke-static v2, v7, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v4
    invoke-direct v3, v4, Ljava/util/ArrayList;-><init>(I)V
    check-cast v3, Ljava/util/Collection;
    invoke-interface v2, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +027h
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Ljava/io/File;
    new-instance v5, Lcom/bytedance/trae/conversation/imageupload/ImageUploadException;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;->getErrorCode()Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    move-result-object v8
    invoke-static v8, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual v6, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;->getErrorMessage()Ljava/lang/String;
    move-result-object v9
    invoke-static v9, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    const/4 v10, 0
    const/4 v11, 4
    const/4 v12, 0
    move-object v7, v5
    invoke-direct/range v7 ... v12, Lcom/bytedance/trae/conversation/imageupload/ImageUploadException;-><init>(Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode; Ljava/lang/String; Ljava/lang/Throwable; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-static v4, v5, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v4
    invoke-interface v3, v4, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -2ah
    check-cast v3, Ljava/util/List;
    invoke-static v1, v3, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    return-object v1
    iget v5, v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2;->$concurrency I
    const/4 v6, 2
    const/4 v8, 0
    invoke-static v5, v3, v6, v8, Lkotlinx/coroutines/sync/SemaphoreKt;->Semaphore$default(I I I Ljava/lang/Object;)Lkotlinx/coroutines/sync/Semaphore;
    move-result-object v19
    move-object v5, v11
    check-cast v5, Ljava/lang/Iterable;
    iget-object v10, v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2;->this$0 Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;
    iget-object v9, v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2;->$onItemProgress Lkotlin/jvm/functions/Function2;
    new-instance v6, Ljava/util/ArrayList;
    invoke-static v5, v7, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v7
    invoke-direct v6, v7, Ljava/util/ArrayList;-><init>(I)V
    move-object v8, v6
    check-cast v8, Ljava/util/Collection;
    invoke-interface v5, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v20
    move/from16 v17, v3
    invoke-interface/range v20, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    if-eqz v5, +038h
    invoke-interface/range v20, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    add-int/lit8 v21, v17, 1
    if-gez v17, +005h
    invoke-static Lkotlin/collections/CollectionsKt;->throwIndexOverflow()V
    move-object v15, v5
    check-cast v15, Ljava/io/File;
    const/4 v6, 0
    const/4 v7, 0
    new-instance v5, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2$jobs$1$1;
    const/16 v18, 0
    move-object v12, v5
    move-object/from16 v13, v19
    move-object v14, v10
    move-object/from16 v16, v9
    invoke-direct/range v12 ... v18, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2$jobs$1$1;-><init>(Lkotlinx/coroutines/sync/Semaphore; Lcom/bytedance/trae/conversation/imageupload/ImageUploadService; Ljava/io/File; Lkotlin/jvm/functions/Function2; I Lkotlin/coroutines/Continuation;)V
    move-object v12, v5
    check-cast v12, Lkotlin/jvm/functions/Function2;
    const/4 v13, 3
    const/4 v14, 0
    move-object v5, v2
    move-object v15, v8
    move-object v8, v12
    move-object v12, v9
    move v9, v13
    move-object v13, v10
    move-object v10, v14
    invoke-static/range v5 ... v10, Lkotlinx/coroutines/BuildersKt;->async$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Deferred;
    move-result-object v5
    invoke-interface v15, v5, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    move-object v9, v12
    move-object v10, v13
    move-object v8, v15
    move/from16 v17, v21
    goto -3bh
    move-object v15, v8
    move-object v8, v15
    check-cast v8, Ljava/util/List;
    check-cast v8, Ljava/util/Collection;
    move-object v2, v0
    check-cast v2, Lkotlin/coroutines/Continuation;
    iput-object v11, v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2;->L$0 Ljava/lang/Object;
    iput v4, v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2;->label I
    invoke-static v8, v2, Lkotlinx/coroutines/AwaitKt;->awaitAll(Ljava/util/Collection; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v1, +003h
    return-object v1
    move-object v1, v11
    check-cast v2, Ljava/util/List;
    new-instance v4, Ljava/util/ArrayList;
    invoke-direct v4, Ljava/util/ArrayList;-><init>()V
    new-instance v5, Ljava/util/ArrayList;
    invoke-direct v5, Ljava/util/ArrayList;-><init>()V
    check-cast v2, Ljava/lang/Iterable;
    invoke-interface v2, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v6
    if-eqz v6, +02ch
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v6
    add-int/lit8 v7, v3, 1
    if-gez v3, +005h
    invoke-static Lkotlin/collections/CollectionsKt;->throwIndexOverflow()V
    check-cast v6, Lkotlin/Result;
    invoke-virtual v6, Lkotlin/Result;->unbox-impl()Ljava/lang/Object;
    move-result-object v6
    invoke-static v6, Lkotlin/Result;->exceptionOrNull-impl(Ljava/lang/Object;)Ljava/lang/Throwable;
    move-result-object v8
    if-nez v8, +008h
    check-cast v6, Lcom/bytedance/trae/conversation/imageupload/ImageUploadResult;
    invoke-virtual v4, v6, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    goto +ch
    invoke-interface v1, v3, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v3
    invoke-static v3, v8, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v3
    invoke-virtual v5, v3, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    move v3, v7
    goto -2fh
    invoke-static v4, v5, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    return-object v1
.end method
