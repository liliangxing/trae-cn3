# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/EditNameDialogFragment$onViewCreated$1;
.super Ljava/lang/Object;
.source "EditNameDialogFragment.kt"

.implements Landroid/text/TextWatcher;

.field final synthetic $tvCharCount:Landroid/widget/TextView;
.field final synthetic this$0:Lcom/bytedance/trae/home/solo/setting/EditNameDialogFragment;


.method constructor <init>(com.bytedance.trae.home.solo.setting.EditNameDialogFragment  android.widget.TextView)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/EditNameDialogFragment$onViewCreated$1;->this$0 Lcom/bytedance/trae/home/solo/setting/EditNameDialogFragment;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/EditNameDialogFragment$onViewCreated$1;->$tvCharCount Landroid/widget/TextView;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public afterTextChanged(android.text.Editable)void
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/setting/EditNameDialogFragment$onViewCreated$1;->this$0 Lcom/bytedance/trae/home/solo/setting/EditNameDialogFragment;
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/EditNameDialogFragment$onViewCreated$1;->$tvCharCount Landroid/widget/TextView;
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    if-eqz v3, +007h
    invoke-interface v3, Landroid/text/Editable;->length()I
    move-result v3
    goto +2h
    const/4 v3, 0
    invoke-static v0, v1, v3, Lcom/bytedance/trae/home/solo/setting/EditNameDialogFragment;->access$updateCharCount(Lcom/bytedance/trae/home/solo/setting/EditNameDialogFragment; Landroid/widget/TextView; I)V
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
