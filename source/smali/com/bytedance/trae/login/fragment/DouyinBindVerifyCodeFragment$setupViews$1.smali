# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$setupViews$1;
.super Ljava/lang/Object;
.source "DouyinBindVerifyCodeFragment.kt"

.implements Landroid/text/TextWatcher;

.field final synthetic this$0:Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;


.method constructor <init>(com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$setupViews$1;->this$0 Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public afterTextChanged(android.text.Editable)void
    .registers 4
    # ins_size=2
    if-eqz v3, +007h
    invoke-virtual v3, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v3
    goto +2h
    const/4 v3, 0
    if-nez v3, +004h
    const-string v3, ""
    invoke-virtual v3, Ljava/lang/String;->length()I
    move-result v0
    const/4 v1, 6
    if-ne v0, v1, +00fh
    iget-object v0, v2, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$setupViews$1;->this$0 Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;
    invoke-static v0, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->access$isSubmitting$p(Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;)Z
    move-result v0
    if-nez v0, +007h
    iget-object v0, v2, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$setupViews$1;->this$0 Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;
    invoke-static v0, v3, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->access$submitBind(Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment; Ljava/lang/String;)V
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
