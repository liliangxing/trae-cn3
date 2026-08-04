# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment$setupViews$1;
.super Ljava/lang/Object;
.source "DouyinBindPhoneInputFragment.kt"

.implements Landroid/text/TextWatcher;

.field final synthetic this$0:Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;


.method constructor <init>(com.bytedance.trae.login.fragment.DouyinBindPhoneInputFragment)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment$setupViews$1;->this$0 Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public afterTextChanged(android.text.Editable)void
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment$setupViews$1;->this$0 Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;
    if-eqz v2, +007h
    invoke-virtual v2, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v2
    goto +2h
    const/4 v2, 0
    if-nez v2, +004h
    const-string v2, ""
    invoke-static v0, v2, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;->access$setPhoneNumber$p(Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment; Ljava/lang/String;)V
    iget-object v2, v1, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment$setupViews$1;->this$0 Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;
    invoke-static v2, Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;->access$updateSendButton(Lcom/bytedance/trae/login/fragment/DouyinBindPhoneInputFragment;)V
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
