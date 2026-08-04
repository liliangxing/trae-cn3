# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2$jobs$1$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ImageUploadService.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $f:Ljava/io/File;
.field final synthetic $idx:I
.field final synthetic $onItemProgress:Lkotlin/jvm/functions/Function2;
.field final synthetic $sem:Lkotlinx/coroutines/sync/Semaphore;
.field  I$0:I
.field  L$0:Ljava/lang/Object;
.field  L$1:Ljava/lang/Object;
.field  L$2:Ljava/lang/Object;
.field  L$3:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;


.method public static synthetic $r8$lambda$OBrCqpbe1biJamS127c7JIY2fN8(kotlin.jvm.functions.Function2  int  int)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2$jobs$1$1;->invokeSuspend$lambda$1$lambda$0(Lkotlin/jvm/functions/Function2; I I)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method constructor <init>(kotlinx.coroutines.sync.Semaphore  com.bytedance.trae.conversation.imageupload.ImageUploadService  java.io.File  kotlin.jvm.functions.Function2  int  kotlin.coroutines.Continuation)void
    .registers 7
    # ins_size=7
    iput-object v1, v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2$jobs$1$1;->$sem Lkotlinx/coroutines/sync/Semaphore;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2$jobs$1$1;->this$0 Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2$jobs$1$1;->$f Ljava/io/File;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2$jobs$1$1;->$onItemProgress Lkotlin/jvm/functions/Function2;
    iput v5, v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2$jobs$1$1;->$idx I
    const/4 v1, 2
    invoke-direct v0, v1, v6, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method private static final invokeSuspend$lambda$1$lambda$0(kotlin.jvm.functions.Function2  int  int)kotlin.Unit
    .registers 3
    # ins_size=3
    if-eqz v0, +00dh
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v2
    invoke-interface v0, v1, v2, Lkotlin/jvm/functions/Function2;->invoke(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 10
    # ins_size=3
    new-instance v8, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2$jobs$1$1;
    iget-object v1, v7, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2$jobs$1$1;->$sem Lkotlinx/coroutines/sync/Semaphore;
    iget-object v2, v7, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2$jobs$1$1;->this$0 Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;
    iget-object v3, v7, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2$jobs$1$1;->$f Ljava/io/File;
    iget-object v4, v7, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2$jobs$1$1;->$onItemProgress Lkotlin/jvm/functions/Function2;
    iget v5, v7, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2$jobs$1$1;->$idx I
    move-object v0, v8
    move-object v6, v9
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2$jobs$1$1;-><init>(Lkotlinx/coroutines/sync/Semaphore; Lcom/bytedance/trae/conversation/imageupload/ImageUploadService; Ljava/io/File; Lkotlin/jvm/functions/Function2; I Lkotlin/coroutines/Continuation;)V
    check-cast v8, Lkotlin/coroutines/Continuation;
    return-object v8
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2$jobs$1$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2$jobs$1$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2$jobs$1$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2$jobs$1$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 15
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v13, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2$jobs$1$1;->label I
    const/4 v2, 2
    const/4 v3, 1
    if-eqz v1, +031h
    if-eq v1, v3, +018h
    if-ne v1, v2, +00eh
    iget-object v0, v13, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2$jobs$1$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lkotlinx/coroutines/sync/Semaphore;
    invoke-static v14, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +06ah
    move-exception v14
    goto/16 +074h
    new-instance v14, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v14, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v14
    iget v1, v13, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2$jobs$1$1;->I$0 I
    iget-object v3, v13, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2$jobs$1$1;->L$3 Ljava/lang/Object;
    check-cast v3, Lkotlin/jvm/functions/Function2;
    iget-object v4, v13, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2$jobs$1$1;->L$2 Ljava/lang/Object;
    check-cast v4, Ljava/io/File;
    iget-object v5, v13, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2$jobs$1$1;->L$1 Ljava/lang/Object;
    check-cast v5, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;
    iget-object v6, v13, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2$jobs$1$1;->L$0 Ljava/lang/Object;
    check-cast v6, Lkotlinx/coroutines/sync/Semaphore;
    invoke-static v14, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v14, v6
    goto +26h
    invoke-static v14, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v14, v13, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2$jobs$1$1;->$sem Lkotlinx/coroutines/sync/Semaphore;
    iget-object v5, v13, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2$jobs$1$1;->this$0 Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;
    iget-object v4, v13, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2$jobs$1$1;->$f Ljava/io/File;
    iget-object v1, v13, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2$jobs$1$1;->$onItemProgress Lkotlin/jvm/functions/Function2;
    iget v6, v13, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2$jobs$1$1;->$idx I
    move-object v7, v13
    check-cast v7, Lkotlin/coroutines/Continuation;
    iput-object v14, v13, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2$jobs$1$1;->L$0 Ljava/lang/Object;
    iput-object v5, v13, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2$jobs$1$1;->L$1 Ljava/lang/Object;
    iput-object v4, v13, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2$jobs$1$1;->L$2 Ljava/lang/Object;
    iput-object v1, v13, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2$jobs$1$1;->L$3 Ljava/lang/Object;
    iput v6, v13, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2$jobs$1$1;->I$0 I
    iput v3, v13, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2$jobs$1$1;->label I
    invoke-interface v14, v7, Lkotlinx/coroutines/sync/Semaphore;->acquire(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v3
    if-ne v3, v0, +003h
    return-object v0
    move-object v3, v1
    move v1, v6
    move-object v12, v5
    move-object v5, v4
    move-object v4, v12
    new-instance v6, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2$jobs$1$1$$ExternalSyntheticLambda0;
    invoke-direct v6, v3, v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2$jobs$1$1$$ExternalSyntheticLambda0;-><init>(Lkotlin/jvm/functions/Function2; I)V
    const-wide/16 v7, 0
    const/4 v10, 4
    const/4 v11, 0
    iput-object v14, v13, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2$jobs$1$1;->L$0 Ljava/lang/Object;
    const/4 v1, 0
    iput-object v1, v13, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2$jobs$1$1;->L$1 Ljava/lang/Object;
    iput-object v1, v13, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2$jobs$1$1;->L$2 Ljava/lang/Object;
    iput-object v1, v13, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2$jobs$1$1;->L$3 Ljava/lang/Object;
    iput v2, v13, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2$jobs$1$1;->label I
    move-object v9, v13
    invoke-static/range v4 ... v11, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;->uploadImage$default(Lcom/bytedance/trae/conversation/imageupload/ImageUploadService; Ljava/io/File; Lkotlin/jvm/functions/Function1; J Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    if-ne v1, v0, +003h
    return-object v0
    move-object v0, v14
    move-object v14, v1
    check-cast v14, Lcom/bytedance/trae/conversation/imageupload/ImageUploadResult;
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v14, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v14
    goto +fh
    move-exception v0
    move-object v12, v0
    move-object v0, v14
    move-object v14, v12
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v14, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v14
    invoke-static v14, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v14
    invoke-static v14, Lkotlin/Result;->box-impl(Ljava/lang/Object;)Lkotlin/Result;
    move-result-object v14
    invoke-interface v0, Lkotlinx/coroutines/sync/Semaphore;->release()V
    return-object v14
    move-exception v14
    invoke-interface v0, Lkotlinx/coroutines/sync/Semaphore;->release()V
    throw v14
    :try_start_0x12
    :try_start_0x61
    :try_start_0x7f
    :try_start_0x8c
.end method
