# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/activity/PhoneBindActivity$initViews$2;
.super Ljava/lang/Object;
.source "PhoneBindActivity.kt"

.implements Landroid/text/TextWatcher;

.field final synthetic this$0:Lcom/bytedance/trae/login/activity/PhoneBindActivity;


.method constructor <init>(com.bytedance.trae.login.activity.PhoneBindActivity)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity$initViews$2;->this$0 Lcom/bytedance/trae/login/activity/PhoneBindActivity;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public afterTextChanged(android.text.Editable)void
    .registers 5
    # ins_size=2
    const/4 v0, 0
    if-eqz v4, +007h
    invoke-interface v4, Landroid/text/Editable;->length()I
    move-result v4
    goto +2h
    move v4, v0
    const/16 v1, 11
    if-lt v4, v1, +003h
    const/4 v0, 1
    iget-object v4, v3, Lcom/bytedance/trae/login/activity/PhoneBindActivity$initViews$2;->this$0 Lcom/bytedance/trae/login/activity/PhoneBindActivity;
    invoke-static v4, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->access$getBtnSendCodeOld$p(Lcom/bytedance/trae/login/activity/PhoneBindActivity;)Landroid/widget/TextView;
    move-result-object v4
    const/4 v1, 0
    const-string v2, "btnSendCodeOld"
    if-nez v4, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v4, v1
    invoke-virtual v4, v0, Landroid/widget/TextView;->setEnabled(Z)V
    iget-object v4, v3, Lcom/bytedance/trae/login/activity/PhoneBindActivity$initViews$2;->this$0 Lcom/bytedance/trae/login/activity/PhoneBindActivity;
    invoke-static v4, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->access$getBtnSendCodeOld$p(Lcom/bytedance/trae/login/activity/PhoneBindActivity;)Landroid/widget/TextView;
    move-result-object v4
    if-nez v4, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v4
    iget-object v4, v3, Lcom/bytedance/trae/login/activity/PhoneBindActivity$initViews$2;->this$0 Lcom/bytedance/trae/login/activity/PhoneBindActivity;
    if-eqz v0, +005h
    sget v0, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_onaccent I
    goto +3h
    sget v0, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_disabled I
    invoke-virtual v4, v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->getColor(I)I
    move-result v4
    invoke-virtual v1, v4, Landroid/widget/TextView;->setTextColor(I)V
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
