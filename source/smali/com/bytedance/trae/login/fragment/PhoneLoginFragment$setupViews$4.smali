# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/fragment/PhoneLoginFragment$setupViews$4;
.super Ljava/lang/Object;
.source "PhoneLoginFragment.kt"

.implements Landroid/text/TextWatcher;

.field final synthetic this$0:Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;


.method constructor <init>(com.bytedance.trae.login.fragment.PhoneLoginFragment)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment$setupViews$4;->this$0 Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public afterTextChanged(android.text.Editable)void
    .registers 3
    # ins_size=2
    if-eqz v2, +007h
    invoke-virtual v2, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v2
    goto +2h
    const/4 v2, 0
    if-nez v2, +004h
    const-string v2, ""
    iget-object v0, v1, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment$setupViews$4;->this$0 Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;
    invoke-static v0, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->access$getViewModel(Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;)Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel;
    move-result-object v0
    invoke-virtual v0, v2, Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel;->onPhoneNumberChanged(Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment$setupViews$4;->this$0 Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;
    invoke-static v0, v2, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->access$updateClearButtonVisibility(Lcom/bytedance/trae/login/fragment/PhoneLoginFragment; Ljava/lang/String;)V
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
