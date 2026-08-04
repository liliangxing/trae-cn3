# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showCodePreview$1$content$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "InputPreviewActivity.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $fileUrl:Ljava/lang/String;
.field private synthetic L$0:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/products/InputPreviewActivity;


.method constructor <init>(com.bytedance.trae.conversation.products.InputPreviewActivity  java.lang.String  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showCodePreview$1$content$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showCodePreview$1$content$1;->$fileUrl Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 6
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showCodePreview$1$content$1;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showCodePreview$1$content$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    iget-object v2, v3, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showCodePreview$1$content$1;->$fileUrl Ljava/lang/String;
    invoke-direct v0, v1, v2, v5, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showCodePreview$1$content$1;-><init>(Lcom/bytedance/trae/conversation/products/InputPreviewActivity; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    iput-object v4, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showCodePreview$1$content$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lkotlin/coroutines/Continuation;
    return-object v0
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showCodePreview$1$content$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showCodePreview$1$content$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showCodePreview$1$content$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showCodePreview$1$content$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showCodePreview$1$content$1;->label I
    if-nez v0, +02bh
    invoke-static v3, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v3, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showCodePreview$1$content$1;->L$0 Ljava/lang/Object;
    check-cast v3, Lkotlinx/coroutines/CoroutineScope;
    iget-object v3, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showCodePreview$1$content$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    iget-object v0, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showCodePreview$1$content$1;->$fileUrl Ljava/lang/String;
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v3, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->access$fetchTextViaTTNet(Lcom/bytedance/trae/conversation/products/InputPreviewActivity; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    goto +ch
    move-exception v3
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v3, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v3
    invoke-static v3, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    invoke-static v3, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    const/4 v3, 0
    return-object v3
    new-instance v3, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v3, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v3
    :try_start_0x12
.end method
