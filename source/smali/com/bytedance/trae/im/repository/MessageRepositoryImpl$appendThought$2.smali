# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$appendThought$2;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "MessageRepository.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $fragment:Ljava/lang/String;
.field final synthetic $messageId:Ljava/lang/String;
.field final synthetic $taskId:Ljava/lang/String;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/im/repository/MessageRepositoryImpl;


.method constructor <init>(com.bytedance.trae.im.repository.MessageRepositoryImpl  java.lang.String  java.lang.String  java.lang.String  kotlin.coroutines.Continuation)void
    .registers 6
    # ins_size=6
    iput-object v1, v0, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$appendThought$2;->this$0 Lcom/bytedance/trae/im/repository/MessageRepositoryImpl;
    iput-object v2, v0, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$appendThought$2;->$taskId Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$appendThought$2;->$fragment Ljava/lang/String;
    iput-object v4, v0, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$appendThought$2;->$messageId Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v5, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 9
    # ins_size=3
    new-instance v7, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$appendThought$2;
    iget-object v1, v6, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$appendThought$2;->this$0 Lcom/bytedance/trae/im/repository/MessageRepositoryImpl;
    iget-object v2, v6, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$appendThought$2;->$taskId Ljava/lang/String;
    iget-object v3, v6, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$appendThought$2;->$fragment Ljava/lang/String;
    iget-object v4, v6, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$appendThought$2;->$messageId Ljava/lang/String;
    move-object v0, v7
    move-object v5, v8
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$appendThought$2;-><init>(Lcom/bytedance/trae/im/repository/MessageRepositoryImpl; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v7, Lkotlin/coroutines/Continuation;
    return-object v7
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$appendThought$2;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$appendThought$2;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$appendThought$2;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$appendThought$2;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 5
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v3, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$appendThought$2;->label I
    if-nez v0, +049h
    invoke-static v4, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v4, v3, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$appendThought$2;->this$0 Lcom/bytedance/trae/im/repository/MessageRepositoryImpl;
    invoke-static v4, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl;->access$getPendingMap$p(Lcom/bytedance/trae/im/repository/MessageRepositoryImpl;)Ljava/util/HashMap;
    move-result-object v4
    check-cast v4, Ljava/util/Map;
    iget-object v0, v3, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$appendThought$2;->$taskId Ljava/lang/String;
    iget-object v1, v3, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$appendThought$2;->$messageId Ljava/lang/String;
    invoke-interface v4, v0, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    if-nez v2, +00ah
    new-instance v2, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$PendingThought;
    invoke-direct v2, v1, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$PendingThought;-><init>(Ljava/lang/String;)V
    invoke-interface v4, v0, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    check-cast v2, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$PendingThought;
    invoke-virtual v2, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$PendingThought;->getBuffer()Ljava/lang/StringBuilder;
    move-result-object v4
    iget-object v0, v3, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$appendThought$2;->$fragment Ljava/lang/String;
    invoke-virtual v4, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invoke-virtual v2, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$PendingThought;->getFragmentCount()I
    move-result v4
    add-int/lit8 v4, v4, 1
    invoke-virtual v2, v4, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$PendingThought;->setFragmentCount(I)V
    invoke-virtual v2, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$PendingThought;->getFragmentCount()I
    move-result v4
    iget-object v0, v3, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$appendThought$2;->this$0 Lcom/bytedance/trae/im/repository/MessageRepositoryImpl;
    invoke-static v0, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl;->access$getBatchSize$p(Lcom/bytedance/trae/im/repository/MessageRepositoryImpl;)I
    move-result v0
    if-lt v4, v0, +009h
    iget-object v4, v3, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$appendThought$2;->this$0 Lcom/bytedance/trae/im/repository/MessageRepositoryImpl;
    iget-object v0, v3, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$appendThought$2;->$taskId Ljava/lang/String;
    invoke-static v4, v0, v2, Lcom/bytedance/trae/im/repository/MessageRepositoryImpl;->access$writePending(Lcom/bytedance/trae/im/repository/MessageRepositoryImpl; Ljava/lang/String; Lcom/bytedance/trae/im/repository/MessageRepositoryImpl$PendingThought;)V
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v4
    new-instance v4, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v4, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v4
.end method
