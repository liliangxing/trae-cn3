# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$setupListeners$4;
.super Ljava/lang/Object;
.source "ForgotPasswordActivity.kt"

.implements Landroid/text/TextWatcher;

.field final synthetic this$0:Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;


.method constructor <init>(com.bytedance.trae.login.enterprise.ForgotPasswordActivity)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$setupListeners$4;->this$0 Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public afterTextChanged(android.text.Editable)void
    .registers 2
    # ins_size=2
    iget-object v1, v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$setupListeners$4;->this$0 Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;
    invoke-static v1, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->access$getLayoutErrorStep1$p(Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;)Landroid/view/View;
    move-result-object v1
    if-nez v1, +008h
    const-string v1, "layoutErrorStep1"
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v1, 0
    invoke-virtual v1, Landroid/view/View;->getVisibility()I
    move-result v1
    if-nez v1, +007h
    iget-object v1, v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$setupListeners$4;->this$0 Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;
    invoke-static v1, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->access$clearStep1Error(Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;)V
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
