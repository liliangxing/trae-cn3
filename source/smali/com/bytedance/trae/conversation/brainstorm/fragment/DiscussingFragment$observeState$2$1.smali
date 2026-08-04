# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$observeState$2$1;
.super Ljava/lang/Object;
.source "DiscussingFragment.kt"

.implements Lkotlinx/coroutines/flow/FlowCollector;

.field final synthetic this$0:Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;


.method constructor <init>(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$observeState$2$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final emit(com.bytedance.trae.conversation.brainstorm.health.VoicePrompt  kotlin.coroutines.Continuation)java.lang.Object
    .registers 4
    # ins_size=3
    iget-object v3, v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$observeState$2$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->getView()Landroid/view/View;
    move-result-object v3
    instance-of v0, v3, Landroid/view/ViewGroup;
    if-eqz v0, +005h
    check-cast v3, Landroid/view/ViewGroup;
    goto +2h
    const/4 v3, 0
    if-nez v3, +005h
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePromptCenter;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/health/VoicePromptCenter;
    invoke-virtual v0, v3, v2, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePromptCenter;->enqueue(Landroid/view/ViewGroup; Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt;)V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
.end method

.method public bridge synthetic emit(java.lang.Object  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$observeState$2$1;->emit(Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method
