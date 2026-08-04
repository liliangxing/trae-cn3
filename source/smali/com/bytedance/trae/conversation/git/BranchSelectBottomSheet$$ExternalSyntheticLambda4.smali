# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$$ExternalSyntheticLambda4;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Landroid/widget/ProgressBar;
.field public final synthetic f$1:Landroidx/recyclerview/widget/RecyclerView;
.field public final synthetic f$2:Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;


.method public synthetic constructor <init>(android.widget.ProgressBar  androidx.recyclerview.widget.RecyclerView  com.bytedance.trae.conversation.git.BranchSelectBottomSheet)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$$ExternalSyntheticLambda4;->f$0 Landroid/widget/ProgressBar;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$$ExternalSyntheticLambda4;->f$1 Landroidx/recyclerview/widget/RecyclerView;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$$ExternalSyntheticLambda4;->f$2 Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 5
    # ins_size=2
    iget-object v0, v3, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$$ExternalSyntheticLambda4;->f$0 Landroid/widget/ProgressBar;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$$ExternalSyntheticLambda4;->f$1 Landroidx/recyclerview/widget/RecyclerView;
    iget-object v2, v3, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$$ExternalSyntheticLambda4;->f$2 Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;
    check-cast v4, Ljava/lang/Boolean;
    invoke-static v0, v1, v2, v4, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->$r8$lambda$fBANrBdpetf-6mE2rCduQ_UJ-CY(Landroid/widget/ProgressBar; Landroidx/recyclerview/widget/RecyclerView; Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet; Ljava/lang/Boolean;)Lkotlin/Unit;
    move-result-object v4
    return-object v4
.end method
