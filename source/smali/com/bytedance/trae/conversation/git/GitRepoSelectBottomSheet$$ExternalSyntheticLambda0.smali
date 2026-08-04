# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/content/DialogInterface$OnShowListener;

.field public final synthetic f$0:Lcom/google/android/material/bottomsheet/BottomSheetDialog;
.field public final synthetic f$1:Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;


.method public synthetic constructor <init>(com.google.android.material.bottomsheet.BottomSheetDialog  com.bytedance.trae.conversation.git.GitRepoSelectBottomSheet)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$$ExternalSyntheticLambda0;->f$0 Lcom/google/android/material/bottomsheet/BottomSheetDialog;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$$ExternalSyntheticLambda0;->f$1 Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;
    return-void 
.end method

.method public final onShow(android.content.DialogInterface)void
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$$ExternalSyntheticLambda0;->f$0 Lcom/google/android/material/bottomsheet/BottomSheetDialog;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$$ExternalSyntheticLambda0;->f$1 Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;
    invoke-static v0, v1, v3, Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;->$r8$lambda$_FfXevE7ntgJrBvhyvxSNLmiIyk(Lcom/google/android/material/bottomsheet/BottomSheetDialog; Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet; Landroid/content/DialogInterface;)V
    return-void 
.end method
