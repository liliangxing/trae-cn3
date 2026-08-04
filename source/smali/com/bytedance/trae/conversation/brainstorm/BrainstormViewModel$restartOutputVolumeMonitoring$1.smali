# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$restartOutputVolumeMonitoring$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "BrainstormViewModel.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $reason:Ljava/lang/String;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;


.method constructor <init>(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel  java.lang.String  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$restartOutputVolumeMonitoring$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$restartOutputVolumeMonitoring$1;->$reason Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$restartOutputVolumeMonitoring$1;
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$restartOutputVolumeMonitoring$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$restartOutputVolumeMonitoring$1;->$reason Ljava/lang/String;
    invoke-direct v3, v0, v1, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$restartOutputVolumeMonitoring$1;-><init>(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/coroutines/Continuation;
    return-object v3
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$restartOutputVolumeMonitoring$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$restartOutputVolumeMonitoring$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$restartOutputVolumeMonitoring$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$restartOutputVolumeMonitoring$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 7
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$restartOutputVolumeMonitoring$1;->label I
    const/4 v2, 2
    const/4 v3, 1
    if-eqz v1, +012h
    if-eq v1, v3, +004h
    if-ne v1, v2, +006h
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +1ah
    new-instance v6, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v6, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v6
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v6, v5
    check-cast v6, Lkotlin/coroutines/Continuation;
    iput v3, v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$restartOutputVolumeMonitoring$1;->label I
    const-wide/16 v3, 800
    invoke-static v3, v4, v6, Lkotlinx/coroutines/DelayKt;->delay(J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v6
    if-ne v6, v0, +003h
    return-object v0
    move-object v6, v5
    iget-object v1, v6, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$restartOutputVolumeMonitoring$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    iget-object v3, v6, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$restartOutputVolumeMonitoring$1;->$reason Ljava/lang/String;
    invoke-static v1, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$emitOutputVolumePromptIfNeeded(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Ljava/lang/String;)V
    move-object v1, v6
    check-cast v1, Lkotlin/coroutines/Continuation;
    iput v2, v6, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$restartOutputVolumeMonitoring$1;->label I
    const-wide/16 v3, 2000
    invoke-static v3, v4, v1, Lkotlinx/coroutines/DelayKt;->delay(J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    if-ne v1, v0, -012h
    return-object v0
.end method
