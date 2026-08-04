# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$observeState$3$1;
.super Ljava/lang/Object;
.source "DiscussingFragment.kt"

.implements Lkotlinx/coroutines/flow/FlowCollector;

.field final synthetic this$0:Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;


.method constructor <init>(com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$observeState$3$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final emit(float  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    iget-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$observeState$3$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;
    invoke-static v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->access$getCurIsMicMuted$p(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;)Z
    move-result v2
    if-nez v2, +013h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$observeState$3$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;
    invoke-static v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;->access$getMainWaveform$p(Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;)Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;
    move-result-object v2
    if-nez v2, +008h
    const-string v2, "mainWaveform"
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v2, 0
    invoke-virtual v2, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->updateVolume(F)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method public bridge synthetic emit(java.lang.Object  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Ljava/lang/Number;
    invoke-virtual v1, Ljava/lang/Number;->floatValue()F
    move-result v1
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$observeState$3$1;->emit(F Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method
