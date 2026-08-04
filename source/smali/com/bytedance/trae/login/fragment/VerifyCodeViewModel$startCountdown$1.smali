# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$startCountdown$1;
.super Landroid/os/CountDownTimer;
.source "VerifyCodeViewModel.kt"

.field final synthetic this$0:Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;


.method constructor <init>(com.bytedance.trae.login.fragment.VerifyCodeViewModel)void
    .registers 6
    # ins_size=2
    iput-object v5, v4, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$startCountdown$1;->this$0 Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;
    const-wide/32 v0, 60000
    const-wide/16 v2, 1000
    invoke-direct v4, v0, v1, v2, v3, Landroid/os/CountDownTimer;-><init>(J J)V
    return-void 
.end method

.method public onFinish()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$startCountdown$1;->this$0 Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;
    invoke-static v0, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->access$get_countdownSeconds$p(Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v0
    const/4 v1, 0
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    invoke-virtual v0, v1, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V
    iget-object v0, v2, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$startCountdown$1;->this$0 Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;
    invoke-static v0, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->access$get_isResendEnabled$p(Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v0
    const/4 v1, 1
    invoke-static v1, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v1
    invoke-virtual v0, v1, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V
    return-void 
.end method

.method public onTick(long)void
    .registers 6
    # ins_size=3
    iget-object v0, v3, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$startCountdown$1;->this$0 Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;
    invoke-static v0, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;->access$get_countdownSeconds$p(Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v0
    const/16 v1, 1000
    int-to-long v1, v1
    div-long/2addr v4, v1
    long-to-int v4, v4
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    invoke-virtual v0, v4, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V
    return-void 
.end method
