# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$$ExternalSyntheticLambda5;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Ljava/lang/Runnable;

.field public final synthetic f$0:Lcom/google/android/material/bottomsheet/BottomSheetBehavior;
.field public final synthetic f$1:Landroid/view/View;


.method public synthetic constructor <init>(com.google.android.material.bottomsheet.BottomSheetBehavior  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$$ExternalSyntheticLambda5;->f$0 Lcom/google/android/material/bottomsheet/BottomSheetBehavior;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$$ExternalSyntheticLambda5;->f$1 Landroid/view/View;
    return-void 
.end method

.method public final run()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$$ExternalSyntheticLambda5;->f$0 Lcom/google/android/material/bottomsheet/BottomSheetBehavior;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$$ExternalSyntheticLambda5;->f$1 Landroid/view/View;
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;->$r8$lambda$Yh6eHnK6A43M9ktD0lRc91bz9Ss(Lcom/google/android/material/bottomsheet/BottomSheetBehavior; Landroid/view/View;)V
    return-void 
.end method
