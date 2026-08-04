# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/ConversationViewModel$handleModelUnavailableMessageErrorIfNeeded$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ConversationViewModel.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $code:J
.field final synthetic $device:Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
.field final synthetic $message:Lcom/bytedance/trae/im/model/ParsedChatMessage;
.field final synthetic $mode:Lcom/bytedance/trae/im/service/Mode;
.field final synthetic $source:Ljava/lang/String;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/ConversationViewModel;


.method constructor <init>(com.bytedance.trae.conversation.ConversationViewModel  com.bytedance.trae.conversation.devices.SelectedDeviceItem  com.bytedance.trae.im.service.Mode  long  java.lang.String  com.bytedance.trae.im.model.ParsedChatMessage  kotlin.coroutines.Continuation)void
    .registers 9
    # ins_size=9
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$handleModelUnavailableMessageErrorIfNeeded$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$handleModelUnavailableMessageErrorIfNeeded$1;->$device Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$handleModelUnavailableMessageErrorIfNeeded$1;->$mode Lcom/bytedance/trae/im/service/Mode;
    iput-wide v4, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$handleModelUnavailableMessageErrorIfNeeded$1;->$code J
    iput-object v6, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$handleModelUnavailableMessageErrorIfNeeded$1;->$source Ljava/lang/String;
    iput-object v7, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$handleModelUnavailableMessageErrorIfNeeded$1;->$message Lcom/bytedance/trae/im/model/ParsedChatMessage;
    const/4 v1, 2
    invoke-direct v0, v1, v8, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 12
    # ins_size=3
    new-instance v10, Lcom/bytedance/trae/conversation/ConversationViewModel$handleModelUnavailableMessageErrorIfNeeded$1;
    iget-object v1, v9, Lcom/bytedance/trae/conversation/ConversationViewModel$handleModelUnavailableMessageErrorIfNeeded$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    iget-object v2, v9, Lcom/bytedance/trae/conversation/ConversationViewModel$handleModelUnavailableMessageErrorIfNeeded$1;->$device Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    iget-object v3, v9, Lcom/bytedance/trae/conversation/ConversationViewModel$handleModelUnavailableMessageErrorIfNeeded$1;->$mode Lcom/bytedance/trae/im/service/Mode;
    iget-wide v4, v9, Lcom/bytedance/trae/conversation/ConversationViewModel$handleModelUnavailableMessageErrorIfNeeded$1;->$code J
    iget-object v6, v9, Lcom/bytedance/trae/conversation/ConversationViewModel$handleModelUnavailableMessageErrorIfNeeded$1;->$source Ljava/lang/String;
    iget-object v7, v9, Lcom/bytedance/trae/conversation/ConversationViewModel$handleModelUnavailableMessageErrorIfNeeded$1;->$message Lcom/bytedance/trae/im/model/ParsedChatMessage;
    move-object v0, v10
    move-object v8, v11
    invoke-direct/range v0 ... v8, Lcom/bytedance/trae/conversation/ConversationViewModel$handleModelUnavailableMessageErrorIfNeeded$1;-><init>(Lcom/bytedance/trae/conversation/ConversationViewModel; Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem; Lcom/bytedance/trae/im/service/Mode; J Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedChatMessage; Lkotlin/coroutines/Continuation;)V
    check-cast v10, Lkotlin/coroutines/Continuation;
    return-object v10
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$handleModelUnavailableMessageErrorIfNeeded$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$handleModelUnavailableMessageErrorIfNeeded$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/ConversationViewModel$handleModelUnavailableMessageErrorIfNeeded$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$handleModelUnavailableMessageErrorIfNeeded$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 9
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v7, Lcom/bytedance/trae/conversation/ConversationViewModel$handleModelUnavailableMessageErrorIfNeeded$1;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +4bh
    new-instance v8, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v8, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v8
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v8, v7, Lcom/bytedance/trae/conversation/ConversationViewModel$handleModelUnavailableMessageErrorIfNeeded$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    iget-object v1, v7, Lcom/bytedance/trae/conversation/ConversationViewModel$handleModelUnavailableMessageErrorIfNeeded$1;->$device Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    iget-object v3, v7, Lcom/bytedance/trae/conversation/ConversationViewModel$handleModelUnavailableMessageErrorIfNeeded$1;->$mode Lcom/bytedance/trae/im/service/Mode;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v5, "message_error_code_"
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-wide v5, v7, Lcom/bytedance/trae/conversation/ConversationViewModel$handleModelUnavailableMessageErrorIfNeeded$1;->$code J
    invoke-virtual v4, v5, v6, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v5, "_source_"
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    iget-object v5, v7, Lcom/bytedance/trae/conversation/ConversationViewModel$handleModelUnavailableMessageErrorIfNeeded$1;->$source Ljava/lang/String;
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v5, "_history_"
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    iget-object v5, v7, Lcom/bytedance/trae/conversation/ConversationViewModel$handleModelUnavailableMessageErrorIfNeeded$1;->$message Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isHistory()Z
    move-result v5
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    move-object v5, v7
    check-cast v5, Lkotlin/coroutines/Continuation;
    iput v2, v7, Lcom/bytedance/trae/conversation/ConversationViewModel$handleModelUnavailableMessageErrorIfNeeded$1;->label I
    invoke-static v8, v1, v3, v4, v5, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$switchSelectedModelToAuto(Lcom/bytedance/trae/conversation/ConversationViewModel; Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem; Lcom/bytedance/trae/im/service/Mode; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v8
    if-ne v8, v0, +003h
    return-object v0
    sget-object v8, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v8
.end method
