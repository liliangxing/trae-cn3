# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter$loop$2;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "Typewriter.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $display:Ljava/lang/String;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;


.method constructor <init>(com.bytedance.trae.conversation.chat.block.renderer.Typewriter  java.lang.String  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter$loop$2;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter$loop$2;->$display Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v3, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter$loop$2;
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter$loop$2;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter$loop$2;->$display Ljava/lang/String;
    invoke-direct v3, v0, v1, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter$loop$2;-><init>(Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/coroutines/Continuation;
    return-object v3
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter$loop$2;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter$loop$2;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter$loop$2;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter$loop$2;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter$loop$2;->label I
    if-nez v0, +02bh
    invoke-static v3, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v3, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter$loop$2;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;
    invoke-static v3, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;->access$getCancelled$p(Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;)Z
    move-result v3
    if-nez v3, +01dh
    iget-object v3, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter$loop$2;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;
    invoke-static v3, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;->access$getOnTick$p(Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;)Lkotlin/jvm/functions/Function2;
    move-result-object v3
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter$loop$2;->$display Ljava/lang/String;
    const/4 v1, 0
    invoke-static v1, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v1
    invoke-interface v3, v0, v1, Lkotlin/jvm/functions/Function2;->invoke(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    iget-object v3, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter$loop$2;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;
    invoke-static v3, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;->access$getOnContentChanged$p(Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;)Lkotlin/jvm/functions/Function0;
    move-result-object v3
    if-eqz v3, +005h
    invoke-interface v3, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v3
    new-instance v3, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v3, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v3
.end method
