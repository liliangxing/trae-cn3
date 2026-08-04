# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2$4;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ConversationViewModel.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $cacheConvId:Ljava/lang/String;
.field final synthetic $message:Lcom/bytedance/trae/im/model/ParsedChatMessage;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/ConversationViewModel;


.method constructor <init>(com.bytedance.trae.conversation.ConversationViewModel  java.lang.String  com.bytedance.trae.im.model.ParsedChatMessage  kotlin.coroutines.Continuation)void
    .registers 5
    # ins_size=5
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2$4;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2$4;->$cacheConvId Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2$4;->$message Lcom/bytedance/trae/im/model/ParsedChatMessage;
    const/4 v1, 2
    invoke-direct v0, v1, v4, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 6
    # ins_size=3
    new-instance v4, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2$4;
    iget-object v0, v3, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2$4;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2$4;->$cacheConvId Ljava/lang/String;
    iget-object v2, v3, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2$4;->$message Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-direct v4, v0, v1, v2, v5, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2$4;-><init>(Lcom/bytedance/trae/conversation/ConversationViewModel; Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedChatMessage; Lkotlin/coroutines/Continuation;)V
    check-cast v4, Lkotlin/coroutines/Continuation;
    return-object v4
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2$4;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2$4;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2$4;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2$4;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2$4;->label I
    if-nez v0, +015h
    invoke-static v3, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v3, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2$4;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-static v3, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$getCacheRepository(Lcom/bytedance/trae/conversation/ConversationViewModel;)Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository;
    move-result-object v3
    iget-object v0, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2$4;->$cacheConvId Ljava/lang/String;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/ConversationViewModel$sendMessageIternal$2$4;->$message Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v3, v0, v1, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository;->cacheParsedMessage(Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedChatMessage;)V
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v3
    new-instance v3, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v3, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v3
.end method
