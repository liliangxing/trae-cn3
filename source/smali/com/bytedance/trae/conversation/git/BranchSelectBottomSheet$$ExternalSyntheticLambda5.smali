# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$$ExternalSyntheticLambda5;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;
.field public final synthetic f$1:Landroid/widget/ProgressBar;
.field public final synthetic f$2:Landroidx/recyclerview/widget/RecyclerView;
.field public final synthetic f$3:Lkotlin/jvm/internal/Ref$ObjectRef;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.git.BranchSelectBottomSheet  android.widget.ProgressBar  androidx.recyclerview.widget.RecyclerView  kotlin.jvm.internal.Ref$ObjectRef)void
    .registers 5
    # ins_size=5
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$$ExternalSyntheticLambda5;->f$0 Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$$ExternalSyntheticLambda5;->f$1 Landroid/widget/ProgressBar;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$$ExternalSyntheticLambda5;->f$2 Landroidx/recyclerview/widget/RecyclerView;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$$ExternalSyntheticLambda5;->f$3 Lkotlin/jvm/internal/Ref$ObjectRef;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 6
    # ins_size=2
    iget-object v0, v4, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$$ExternalSyntheticLambda5;->f$0 Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$$ExternalSyntheticLambda5;->f$1 Landroid/widget/ProgressBar;
    iget-object v2, v4, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$$ExternalSyntheticLambda5;->f$2 Landroidx/recyclerview/widget/RecyclerView;
    iget-object v3, v4, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$$ExternalSyntheticLambda5;->f$3 Lkotlin/jvm/internal/Ref$ObjectRef;
    check-cast v5, Ljava/util/List;
    invoke-static v0, v1, v2, v3, v5, Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;->$r8$lambda$ruymjyXp4D9Z_e2Ojc3r8gOyg0E(Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet; Landroid/widget/ProgressBar; Landroidx/recyclerview/widget/RecyclerView; Lkotlin/jvm/internal/Ref$ObjectRef; Ljava/util/List;)Lkotlin/Unit;
    move-result-object v5
    return-object v5
.end method
