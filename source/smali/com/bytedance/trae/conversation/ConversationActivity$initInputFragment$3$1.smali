# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/ConversationActivity$initInputFragment$3$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ConversationActivity.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $text:Ljava/lang/String;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/ConversationActivity;


.method constructor <init>(com.bytedance.trae.conversation.ConversationActivity  java.lang.String  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity$initInputFragment$3$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/ConversationActivity$initInputFragment$3$1;->$text Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v3, Lcom/bytedance/trae/conversation/ConversationActivity$initInputFragment$3$1;
    iget-object v0, v2, Lcom/bytedance/trae/conversation/ConversationActivity$initInputFragment$3$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$initInputFragment$3$1;->$text Ljava/lang/String;
    invoke-direct v3, v0, v1, v4, Lcom/bytedance/trae/conversation/ConversationActivity$initInputFragment$3$1;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/coroutines/Continuation;
    return-object v3
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$initInputFragment$3$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$initInputFragment$3$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/ConversationActivity$initInputFragment$3$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$initInputFragment$3$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 5
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v3, Lcom/bytedance/trae/conversation/ConversationActivity$initInputFragment$3$1;->label I
    if-nez v0, +021h
    invoke-static v4, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v4, v3, Lcom/bytedance/trae/conversation/ConversationActivity$initInputFragment$3$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v4, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getInputFragment(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/conversation/widget/InputFragment;
    move-result-object v4
    invoke-virtual v4, Lcom/bytedance/trae/conversation/widget/InputFragment;->getInputPayload()Lcom/bytedance/trae/conversation/widget/InputFragment$InputPayload;
    move-result-object v4
    iget-object v0, v3, Lcom/bytedance/trae/conversation/ConversationActivity$initInputFragment$3$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/widget/InputFragment$InputPayload;->getQuery()Ljava/lang/String;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/conversation/ConversationActivity$initInputFragment$3$1;->$text Ljava/lang/String;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/widget/InputFragment$InputPayload;->getPlugins()Ljava/util/List;
    move-result-object v4
    invoke-static v0, v1, v2, v4, Lcom/bytedance/trae/conversation/ConversationActivity;->access$sendQuery(Lcom/bytedance/trae/conversation/ConversationActivity; Ljava/lang/String; Ljava/lang/String; Ljava/util/List;)V
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v4
    new-instance v4, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v4, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v4
.end method
