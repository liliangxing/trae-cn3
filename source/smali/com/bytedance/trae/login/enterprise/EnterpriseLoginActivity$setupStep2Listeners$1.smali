# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$setupStep2Listeners$1;
.super Ljava/lang/Object;
.source "EnterpriseLoginActivity.kt"

.implements Landroid/text/TextWatcher;

.field final synthetic this$0:Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;


.method constructor <init>(com.bytedance.trae.login.enterprise.EnterpriseLoginActivity)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$setupStep2Listeners$1;->this$0 Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public afterTextChanged(android.text.Editable)void
    .registers 5
    # ins_size=2
    iget-object v0, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$setupStep2Listeners$1;->this$0 Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;
    invoke-static v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->access$updateLoginButtonState(Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;)V
    iget-object v0, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$setupStep2Listeners$1;->this$0 Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;
    invoke-static v0, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->access$getIvClearPassword$p(Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;)Landroid/widget/ImageView;
    move-result-object v0
    if-nez v0, +008h
    const-string v0, "ivClearPassword"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    const/4 v1, 0
    if-eqz v4, +011h
    check-cast v4, Ljava/lang/CharSequence;
    invoke-interface v4, Ljava/lang/CharSequence;->length()I
    move-result v4
    const/4 v2, 1
    if-lez v4, +004h
    move v4, v2
    goto +2h
    move v4, v1
    if-ne v4, v2, +003h
    goto +2h
    move v2, v1
    if-eqz v2, +003h
    goto +3h
    const/16 v1, 8
    invoke-virtual v0, v1, Landroid/widget/ImageView;->setVisibility(I)V
    iget-object v4, v3, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity$setupStep2Listeners$1;->this$0 Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;
    invoke-static v4, Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;->access$clearPasswordError(Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;)V
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
