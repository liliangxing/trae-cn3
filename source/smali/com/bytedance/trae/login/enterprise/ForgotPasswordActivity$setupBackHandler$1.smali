# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$setupBackHandler$1;
.super Landroidx/activity/OnBackPressedCallback;
.source "ForgotPasswordActivity.kt"

.field final synthetic this$0:Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;


.method constructor <init>(com.bytedance.trae.login.enterprise.ForgotPasswordActivity)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$setupBackHandler$1;->this$0 Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;
    const/4 v1, 1
    invoke-direct v0, v1, Landroidx/activity/OnBackPressedCallback;-><init>(Z)V
    return-void 
.end method

.method public handleOnBackPressed()void
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$setupBackHandler$1;->this$0 Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;
    invoke-static v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->access$getLayoutStepSuccess$p(Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;)Landroid/view/View;
    move-result-object v0
    if-nez v0, +008h
    const-string v0, "layoutStepSuccess"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    invoke-virtual v0, Landroid/view/View;->getVisibility()I
    move-result v0
    if-nez v0, +008h
    iget-object v0, v1, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$setupBackHandler$1;->this$0 Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;
    invoke-static v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->access$finishWithEmail(Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;)V
    goto +6h
    iget-object v0, v1, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$setupBackHandler$1;->this$0 Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;
    invoke-virtual v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->finish()V
    return-void 
.end method
