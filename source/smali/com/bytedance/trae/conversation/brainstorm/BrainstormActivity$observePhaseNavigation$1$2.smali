# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$observePhaseNavigation$1$2;
.super Ljava/lang/Object;
.source "BrainstormActivity.kt"

.implements Lkotlinx/coroutines/flow/FlowCollector;

.field final synthetic this$0:Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;


.method constructor <init>(com.bytedance.trae.conversation.brainstorm.BrainstormActivity)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$observePhaseNavigation$1$2;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final emit(com.bytedance.trae.conversation.brainstorm.model.BrainstormPhase  kotlin.coroutines.Continuation)java.lang.Object
    .registers 6
    # ins_size=3
    sget-object v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$observePhaseNavigation$1$2$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase;->ordinal()I
    move-result v4
    aget v4, v5, v4
    const/4 v5, 1
    if-eq v4, v5, +03bh
    const/4 v0, 2
    if-ne v4, v0, +032h
    new-instance v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;
    invoke-direct v4, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment;-><init>()V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$observePhaseNavigation$1$2;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    invoke-virtual v0, Landroidx/fragment/app/FragmentManager;->beginTransaction()Landroidx/fragment/app/FragmentTransaction;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/conversation/R$anim;->trae_fade_in I
    sget v2, Lcom/bytedance/trae/conversation/R$anim;->trae_fade_out I
    invoke-virtual v0, v1, v2, Landroidx/fragment/app/FragmentTransaction;->setCustomAnimations(I I)Landroidx/fragment/app/FragmentTransaction;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/conversation/R$id;->brainstorm_fragment_container I
    check-cast v4, Landroidx/fragment/app/Fragment;
    invoke-virtual v0, v1, v4, Landroidx/fragment/app/FragmentTransaction;->replace(I Landroidx/fragment/app/Fragment;)Landroidx/fragment/app/FragmentTransaction;
    move-result-object v4
    invoke-virtual v4, Landroidx/fragment/app/FragmentTransaction;->commitNow()V
    sget-object v4, Lcom/bytedance/trae/conversation/AccountSettingsKeva;->INSTANCE Lcom/bytedance/trae/conversation/AccountSettingsKeva;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/AccountSettingsKeva;->getKeva()Lcom/bytedance/keva/Keva;
    move-result-object v4
    const-string v0, "brainstorm_has_seen_intro"
    invoke-virtual v4, v0, v5, Lcom/bytedance/keva/Keva;->storeBoolean(Ljava/lang/String; Z)V
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v4
    new-instance v4, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v4, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v4
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v4
.end method

.method public bridge synthetic emit(java.lang.Object  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormActivity$observePhaseNavigation$1$2;->emit(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method
