# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$$ExternalSyntheticLambda6;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Landroid/widget/ProgressBar;
.field public final synthetic f$1:Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;


.method public synthetic constructor <init>(android.widget.ProgressBar  com.bytedance.trae.conversation.git.BranchSelectBottomSheet)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$$ExternalSyntheticLambda6;->f$0 Landroid/widget/ProgressBar;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$$ExternalSyntheticLambda6;->f$1 Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$$ExternalSyntheticLambda6;->f$0 Landroid/widget/ProgressBar;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$$ExternalSyntheticLambda6;->f$1 Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;
    check-cast v3, Ljava/lang/String;
    invoke-static v0, v1, v3, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->$r8$lambda$zDp5JSLNyNqFhTUnXWqAFg6eofs(Landroid/widget/ProgressBar; Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v3
    return-object v3
.end method
