# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/common/widget/CustomConfirmDialog$onCreate$6;
.super Ljava/lang/Object;
.source "CustomConfirmDialog.kt"

.implements Landroid/text/TextWatcher;

.field final synthetic $btnConfirm:Landroid/widget/TextView;


.method constructor <init>(android.widget.TextView)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$onCreate$6;->$btnConfirm Landroid/widget/TextView;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public afterTextChanged(android.text.Editable)void
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$onCreate$6;->$btnConfirm Landroid/widget/TextView;
    if-eqz v2, +007h
    invoke-virtual v2, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v2
    goto +2h
    const/4 v2, 0
    if-nez v2, +004h
    const-string v2, ""
    invoke-static v0, v2, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->access$onCreate$updateConfirmState(Landroid/widget/TextView; Ljava/lang/String;)V
    return-void 
.end method

.method public beforeTextChanged(java.lang.CharSequence  int  int  int)void
    .registers 5
    # ins_size=5
    return-void 
.end method

.method public onTextChanged(java.lang.CharSequence  int  int  int)void
    .registers 5
    # ins_size=5
    return-void 
.end method
