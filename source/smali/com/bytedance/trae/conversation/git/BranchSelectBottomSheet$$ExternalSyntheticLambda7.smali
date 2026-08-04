# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$$ExternalSyntheticLambda7;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;
.field public final synthetic f$1:Landroid/widget/ProgressBar;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.git.BranchSelectBottomSheet  android.widget.ProgressBar)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$$ExternalSyntheticLambda7;->f$0 Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$$ExternalSyntheticLambda7;->f$1 Landroid/widget/ProgressBar;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$$ExternalSyntheticLambda7;->f$0 Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$$ExternalSyntheticLambda7;->f$1 Landroid/widget/ProgressBar;
    check-cast v3, Ljava/lang/Boolean;
    invoke-static v0, v1, v3, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->$r8$lambda$IB5kFvckaliquMHuzNpAoDXq2ys(Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet; Landroid/widget/ProgressBar; Ljava/lang/Boolean;)Lkotlin/Unit;
    move-result-object v3
    return-object v3
.end method
