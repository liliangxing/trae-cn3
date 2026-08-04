# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$setupListeners$6;
.super Ljava/lang/Object;
.source "ForgotPasswordActivity.kt"

.implements Landroid/text/TextWatcher;

.field final synthetic this$0:Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;


.method constructor <init>(com.bytedance.trae.login.enterprise.ForgotPasswordActivity)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$setupListeners$6;->this$0 Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public afterTextChanged(android.text.Editable)void
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$setupListeners$6;->this$0 Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;
    invoke-static v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->access$getLayoutErrorStep2$p(Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;)Landroid/view/View;
    move-result-object v0
    if-nez v0, +008h
    const-string v0, "layoutErrorStep2"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    invoke-virtual v0, Landroid/view/View;->getVisibility()I
    move-result v0
    if-nez v0, +007h
    iget-object v0, v2, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$setupListeners$6;->this$0 Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;
    invoke-static v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->access$clearStep2Error(Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;)V
    const/4 v0, 0
    if-eqz v3, +00ah
    invoke-interface v3, Landroid/text/Editable;->length()I
    move-result v3
    const/4 v1, 6
    if-ne v3, v1, +003h
    const/4 v0, 1
    if-eqz v0, +00fh
    iget-object v3, v2, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$setupListeners$6;->this$0 Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;
    invoke-static v3, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->access$isLoading$p(Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;)Z
    move-result v3
    if-nez v3, +007h
    iget-object v3, v2, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$setupListeners$6;->this$0 Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;
    invoke-static v3, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->access$performVerifyCode(Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;)V
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
