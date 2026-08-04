# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/common/widget/CustomConfirmDialog$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/view/View$OnClickListener;

.field public final synthetic f$0:Lcom/bytedance/trae/common/widget/CustomConfirmDialog;
.field public final synthetic f$1:Landroid/widget/EditText;


.method public synthetic constructor <init>(com.bytedance.trae.common.widget.CustomConfirmDialog  android.widget.EditText)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$$ExternalSyntheticLambda1;->f$0 Lcom/bytedance/trae/common/widget/CustomConfirmDialog;
    iput-object v2, v0, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$$ExternalSyntheticLambda1;->f$1 Landroid/widget/EditText;
    return-void 
.end method

.method public final onClick(android.view.View)void
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$$ExternalSyntheticLambda1;->f$0 Lcom/bytedance/trae/common/widget/CustomConfirmDialog;
    iget-object v1, v2, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$$ExternalSyntheticLambda1;->f$1 Landroid/widget/EditText;
    invoke-static v0, v1, v3, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->$r8$lambda$LmHYD2iT4SAqEFJK49Yg2GDK7B0(Lcom/bytedance/trae/common/widget/CustomConfirmDialog; Landroid/widget/EditText; Landroid/view/View;)V
    return-void 
.end method
