# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter$feed$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "Typewriter.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $text:Ljava/lang/String;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;


.method constructor <init>(com.bytedance.trae.conversation.chat.block.renderer.Typewriter  java.lang.String  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter$feed$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter$feed$1;->$text Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v3, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter$feed$1;
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter$feed$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter$feed$1;->$text Ljava/lang/String;
    invoke-direct v3, v0, v1, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter$feed$1;-><init>(Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/coroutines/Continuation;
    return-object v3
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter$feed$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter$feed$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter$feed$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter$feed$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 8
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter$feed$1;->label I
    if-nez v0, +07bh
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v7, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter$feed$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;
    invoke-static v7, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;->access$getCancelled$p(Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;)Z
    move-result v7
    if-eqz v7, +005h
    sget-object v7, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v7
    iget-object v7, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter$feed$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;
    invoke-static v7, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;->access$getEnd$p(Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;)I
    move-result v7
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter$feed$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;
    iget-object v1, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter$feed$1;->$text Ljava/lang/String;
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;->access$setFullText$p(Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter; Ljava/lang/String;)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter$feed$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;
    iget-object v1, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter$feed$1;->$text Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->length()I
    move-result v1
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;->access$setEnd$p(Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter; I)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter$feed$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;->access$getEnd$p(Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;)I
    move-result v0
    if-le v0, v7, +01dh
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter$feed$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;->access$getRemainingBytes$p(Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;)I
    move-result v1
    iget-object v2, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter$feed$1;->$text Ljava/lang/String;
    invoke-virtual v2, v7, Ljava/lang/String;->substring(I)Ljava/lang/String;
    move-result-object v7
    const-string/jumbo v2, substring(...)
    invoke-static v7, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v7, Lkotlin/text/StringsKt;->encodeToByteArray(Ljava/lang/String;)[B
    move-result-object v7
    array-length v7, v7
    add-int/2addr v1, v7
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;->access$setRemainingBytes$p(Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter; I)V
    iget-object v7, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter$feed$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;
    invoke-static v7, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;->access$getJob$p(Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;)Lkotlinx/coroutines/Job;
    move-result-object v7
    const/4 v0, 0
    if-eqz v7, +00ah
    invoke-interface v7, Lkotlinx/coroutines/Job;->isActive()Z
    move-result v7
    const/4 v1, 1
    if-ne v7, v1, +003h
    move v0, v1
    if-nez v0, +01ch
    iget-object v7, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter$feed$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;
    invoke-static Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;->access$getScope$cp()Lkotlinx/coroutines/CoroutineScope;
    move-result-object v0
    const/4 v1, 0
    const/4 v2, 0
    new-instance v3, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter$feed$1$1;
    iget-object v4, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter$feed$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;
    const/4 v5, 0
    invoke-direct v3, v4, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter$feed$1$1;-><init>(Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/jvm/functions/Function2;
    const/4 v4, 3
    invoke-static/range v0 ... v5, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    move-result-object v0
    invoke-static v7, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;->access$setJob$p(Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter; Lkotlinx/coroutines/Job;)V
    sget-object v7, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v7
    new-instance v7, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v7, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v7
.end method
