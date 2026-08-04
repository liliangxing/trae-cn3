# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$flushThought$2;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "MessageRepository.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $taskId:Ljava/lang/String;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/im/repository/MessageRepositoryImpl;


.method constructor <init>(com.bytedance.trae.im.repository.MessageRepositoryImpl  java.lang.String  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$flushThought$2;->this$0 Lcom/bytedance/trae/im/repository/MessageRepositoryImpl;
    iput-object v2, v0, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$flushThought$2;->$taskId Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v3, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$flushThought$2;
    iget-object v0, v2, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$flushThought$2;->this$0 Lcom/bytedance/trae/im/repository/MessageRepositoryImpl;
    iget-object v1, v2, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$flushThought$2;->$taskId Ljava/lang/String;
    invoke-direct v3, v0, v1, v4, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$flushThought$2;-><init>(Lcom/bytedance/trae/im/repository/MessageRepositoryImpl; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/coroutines/Continuation;
    return-object v3
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$flushThought$2;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$flushThought$2;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$flushThought$2;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$flushThought$2;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v2, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$flushThought$2;->label I
    if-nez v0, +033h
    invoke-static v3, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v3, v2, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$flushThought$2;->this$0 Lcom/bytedance/trae/im/repository/MessageRepositoryImpl;
    invoke-static v3, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl;->access$getPendingMap$p(Lcom/bytedance/trae/im/repository/MessageRepositoryImpl;)Ljava/util/HashMap;
    move-result-object v3
    iget-object v0, v2, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$flushThought$2;->$taskId Ljava/lang/String;
    invoke-virtual v3, v0, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$PendingThought;
    if-nez v3, +005h
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v3
    invoke-virtual v3, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$PendingThought;->getBuffer()Ljava/lang/StringBuilder;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-lez v0, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    if-eqz v0, +009h
    iget-object v0, v2, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$flushThought$2;->this$0 Lcom/bytedance/trae/im/repository/MessageRepositoryImpl;
    iget-object v1, v2, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$flushThought$2;->$taskId Ljava/lang/String;
    invoke-static v0, v1, v3, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl;->access$writePending(Lcom/bytedance/trae/im/repository/MessageRepositoryImpl; Ljava/lang/String; Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$PendingThought;)V
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v3
    new-instance v3, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v3, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v3
.end method
