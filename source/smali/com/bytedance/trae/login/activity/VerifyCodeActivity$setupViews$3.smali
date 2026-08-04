# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/activity/VerifyCodeActivity$setupViews$3;
.super Ljava/lang/Object;
.source "VerifyCodeActivity.kt"

.implements Landroid/text/TextWatcher;

.field final synthetic this$0:Lcom/bytedance/trae/login/activity/VerifyCodeActivity;


.method constructor <init>(com.bytedance.trae.login.activity.VerifyCodeActivity)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/login/activity/VerifyCodeActivity$setupViews$3;->this$0 Lcom/bytedance/trae/login/activity/VerifyCodeActivity;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public afterTextChanged(android.text.Editable)void
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/login/activity/VerifyCodeActivity$setupViews$3;->this$0 Lcom/bytedance/trae/login/activity/VerifyCodeActivity;
    invoke-static v0, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->access$getViewModel(Lcom/bytedance/trae/login/activity/VerifyCodeActivity;)Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;
    move-result-object v0
    if-eqz v2, +007h
    invoke-virtual v2, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v2
    goto +2h
    const/4 v2, 0
    if-nez v2, +004h
    const-string v2, ""
    invoke-virtual v0, v2, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->onCodeChanged(Ljava/lang/String;)V
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
    iget-object v1, v0, Lcom/bytedance/trae/login/activity/VerifyCodeActivity$setupViews$3;->this$0 Lcom/bytedance/trae/login/activity/VerifyCodeActivity;
    invoke-static v1, Lcom/bytedance/trae/login/activity/VerifyCodeActivity;->access$getBinding$p(Lcom/bytedance/trae/login/activity/VerifyCodeActivity;)Lcom/bytedance/trae/login/databinding/TraeActivityVerifyCodeBinding;
    move-result-object v1
    if-nez v1, +008h
    const-string v1, "binding"
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v1, 0
    iget-object v1, v1, Lcom/bytedance/trae/login/databinding/TraeActivityVerifyCodeBinding;->verifyCodeInput Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
    const/4 v2, 0
    invoke-virtual v1, v2, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->setError(Z)V
    return-void 
.end method
