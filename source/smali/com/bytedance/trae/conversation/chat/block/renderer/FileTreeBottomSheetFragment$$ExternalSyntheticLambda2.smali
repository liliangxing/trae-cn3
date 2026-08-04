# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeBottomSheetFragment$$ExternalSyntheticLambda2;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/content/DialogInterface$OnShowListener;

.field public final synthetic f$0:Lcom/google/android/material/bottomsheet/BottomSheetDialog;


.method public synthetic constructor <init>(com.google.android.material.bottomsheet.BottomSheetDialog)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeBottomSheetFragment$$ExternalSyntheticLambda2;->f$0 Lcom/google/android/material/bottomsheet/BottomSheetDialog;
    return-void 
.end method

.method public final onShow(android.content.DialogInterface)void
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeBottomSheetFragment$$ExternalSyntheticLambda2;->f$0 Lcom/google/android/material/bottomsheet/BottomSheetDialog;
    invoke-static v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeBottomSheetFragment;->$r8$lambda$McXysJ9t41LkY93ujmlE6iRYeAY(Lcom/google/android/material/bottomsheet/BottomSheetDialog; Landroid/content/DialogInterface;)V
    return-void 
.end method
