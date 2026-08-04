# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$startCountdown$1;
.super Landroid/os/CountDownTimer;
.source "DouyinBindVerifyCodeFragment.kt"

.field final synthetic this$0:Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;


.method constructor <init>(com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment)void
    .registers 6
    # ins_size=2
    iput-object v5, v4, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$startCountdown$1;->this$0 Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;
    const-wide/32 v0, 60000
    const-wide/16 v2, 1000
    invoke-direct v4, v0, v1, v2, v3, Landroid/os/CountDownTimer;-><init>(J J)V
    return-void 
.end method

.method public onFinish()void
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$startCountdown$1;->this$0 Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;
    invoke-static v0, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->access$setResendReady(Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;)V
    return-void 
.end method

.method public onTick(long)void
    .registers 7
    # ins_size=3
    const/16 v0, 1000
    int-to-long v0, v0
    div-long/2addr v5, v0
    long-to-int v5, v5
    iget-object v6, v4, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$startCountdown$1;->this$0 Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;
    invoke-static v6, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->access$getBinding(Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;)Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;
    move-result-object v6
    if-eqz v6, +01dh
    iget-object v6, v6, Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;->tvResend Landroid/widget/TextView;
    if-eqz v6, +019h
    iget-object v0, v4, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$startCountdown$1;->this$0 Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;
    sget v1, Lcom/bytedance/trae/login/R$string;->trae_douyin_bind_resend_countdown I
    const/4 v2, 1
    new-array v2, v2, [Ljava/lang/Object;
    const/4 v3, 0
    invoke-static v5, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    aput-object v5, v2, v3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v5
    check-cast v5, Ljava/lang/CharSequence;
    invoke-virtual v6, v5, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    return-void 
.end method
