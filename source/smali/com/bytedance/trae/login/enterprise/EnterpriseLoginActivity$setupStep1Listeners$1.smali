# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$setupStep1Listeners$1;
.super Ljava/lang/Object;
.source "EnterpriseLoginActivity.kt"

.implements Landroid/text/TextWatcher;

.field final synthetic this$0:Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;


.method constructor <init>(com.bytedance.trae.login.enterprise.EnterpriseLoginActivity)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$setupStep1Listeners$1;->this$0 Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public afterTextChanged(android.text.Editable)void
    .registers 7
    # ins_size=2
    const/4 v0, 1
    const/4 v1, 0
    if-eqz v6, +023h
    invoke-virtual v6, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v6
    if-eqz v6, +01dh
    check-cast v6, Ljava/lang/CharSequence;
    invoke-static v6, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v6
    if-eqz v6, +011h
    check-cast v6, Ljava/lang/CharSequence;
    invoke-interface v6, Ljava/lang/CharSequence;->length()I
    move-result v6
    if-lez v6, +004h
    move v6, v0
    goto +2h
    move v6, v1
    if-ne v6, v0, +004h
    move v6, v0
    goto +2h
    move v6, v1
    iget-object v2, v5, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$setupStep1Listeners$1;->this$0 Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;
    invoke-static v2, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->access$getBtnContinue$p(Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;)Landroid/widget/Button;
    move-result-object v2
    const/4 v3, 0
    if-nez v2, +008h
    const-string v2, "btnContinue"
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v2, v3
    if-eqz v6, +00bh
    iget-object v4, v5, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$setupStep1Listeners$1;->this$0 Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;
    invoke-static v4, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->access$isLoading$p(Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;)Z
    move-result v4
    if-nez v4, +003h
    goto +2h
    move v0, v1
    invoke-virtual v2, v0, Landroid/widget/Button;->setEnabled(Z)V
    iget-object v0, v5, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$setupStep1Listeners$1;->this$0 Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;
    invoke-static v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->access$getIvClearEmail$p(Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;)Landroid/widget/ImageView;
    move-result-object v0
    if-nez v0, +008h
    const-string v0, "ivClearEmail"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v3, v0
    if-eqz v6, +003h
    goto +3h
    const/16 v1, 8
    invoke-virtual v3, v1, Landroid/widget/ImageView;->setVisibility(I)V
    iget-object v6, v5, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$setupStep1Listeners$1;->this$0 Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;
    invoke-static v6, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->access$clearEmailError(Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;)V
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
