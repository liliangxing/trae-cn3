# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stop$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "TranscriptionVoiceManager.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $ignoreFinalText:Z
.field private synthetic L$0:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;


.method constructor <init>(com.bytedance.trae.conversation.voice.TranscriptionVoiceManager  boolean  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stop$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    iput-boolean v2, v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stop$1;->$ignoreFinalText Z
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 6
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stop$1;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stop$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    iget-boolean v2, v3, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stop$1;->$ignoreFinalText Z
    invoke-direct v0, v1, v2, v5, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stop$1;-><init>(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Z Lkotlin/coroutines/Continuation;)V
    iput-object v4, v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stop$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lkotlin/coroutines/Continuation;
    return-object v0
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stop$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stop$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stop$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stop$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 9
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v7, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stop$1;->label I
    if-nez v0, +042h
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v8, v7, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stop$1;->L$0 Ljava/lang/Object;
    move-object v0, v8
    check-cast v0, Lkotlinx/coroutines/CoroutineScope;
    iget-object v8, v7, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stop$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    const/4 v1, 1
    invoke-static v8, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$setWaitingBotResponse$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Z)V
    iget-object v8, v7, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stop$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    sget-object v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$Status;->WaitingBotResponse Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$Status;
    invoke-static v8, v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$emitStatus(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$Status;)V
    iget-object v8, v7, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stop$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v8, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$getWaitBotJob$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;)Lkotlinx/coroutines/Job;
    move-result-object v8
    const/4 v2, 0
    if-eqz v8, +005h
    invoke-static v8, v2, v1, v2, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    iget-object v8, v7, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stop$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    const/4 v1, 0
    const/4 v3, 0
    new-instance v4, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stop$1$1;
    iget-boolean v5, v7, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stop$1;->$ignoreFinalText Z
    iget-object v6, v7, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stop$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-direct v4, v5, v6, v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$stop$1$1;-><init>(Z Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Lkotlin/coroutines/Continuation;)V
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    move-object v2, v3
    move-object v3, v4
    move v4, v5
    move-object v5, v6
    invoke-static/range v0 ... v5, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    move-result-object v0
    invoke-static v8, v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$setWaitBotJob$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Lkotlinx/coroutines/Job;)V
    sget-object v8, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v8
    new-instance v8, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v8, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v8
.end method
