# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/activity/PhoneBindActivity$startCountdownNew$1;
.super Landroid/os/CountDownTimer;
.source "PhoneBindActivity.kt"

.field final synthetic this$0:Lcom/bytedance/trae/login/activity/PhoneBindActivity;


.method constructor <init>(com.bytedance.trae.login.activity.PhoneBindActivity)void
    .registers 6
    # ins_size=2
    iput-object v5, v4, Lcom/bytedance/trae/login/activity/PhoneBindActivity$startCountdownNew$1;->this$0 Lcom/bytedance/trae/login/activity/PhoneBindActivity;
    const-wide/32 v0, 60000
    const-wide/16 v2, 1000
    invoke-direct v4, v0, v1, v2, v3, Landroid/os/CountDownTimer;-><init>(J J)V
    return-void 
.end method

.method public onFinish()void
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/login/activity/PhoneBindActivity$startCountdownNew$1;->this$0 Lcom/bytedance/trae/login/activity/PhoneBindActivity;
    invoke-virtual v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->isFinishing()Z
    move-result v0
    if-nez v0, +048h
    iget-object v0, v4, Lcom/bytedance/trae/login/activity/PhoneBindActivity$startCountdownNew$1;->this$0 Lcom/bytedance/trae/login/activity/PhoneBindActivity;
    invoke-virtual v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->isDestroyed()Z
    move-result v0
    if-eqz v0, +003h
    goto +3eh
    iget-object v0, v4, Lcom/bytedance/trae/login/activity/PhoneBindActivity$startCountdownNew$1;->this$0 Lcom/bytedance/trae/login/activity/PhoneBindActivity;
    invoke-static v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->access$getTvResendNew$p(Lcom/bytedance/trae/login/activity/PhoneBindActivity;)Landroid/widget/TextView;
    move-result-object v0
    const/4 v1, 0
    const-string/jumbo v2, tvResendNew
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    sget v3, Lcom/bytedance/trae/login/R$string;->trae_phone_resend_ready I
    invoke-virtual v0, v3, Landroid/widget/TextView;->setText(I)V
    iget-object v0, v4, Lcom/bytedance/trae/login/activity/PhoneBindActivity$startCountdownNew$1;->this$0 Lcom/bytedance/trae/login/activity/PhoneBindActivity;
    invoke-static v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->access$getTvResendNew$p(Lcom/bytedance/trae/login/activity/PhoneBindActivity;)Landroid/widget/TextView;
    move-result-object v0
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    const/4 v3, 1
    invoke-virtual v0, v3, Landroid/widget/TextView;->setClickable(Z)V
    iget-object v0, v4, Lcom/bytedance/trae/login/activity/PhoneBindActivity$startCountdownNew$1;->this$0 Lcom/bytedance/trae/login/activity/PhoneBindActivity;
    invoke-static v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->access$getTvResendNew$p(Lcom/bytedance/trae/login/activity/PhoneBindActivity;)Landroid/widget/TextView;
    move-result-object v0
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    iget-object v0, v4, Lcom/bytedance/trae/login/activity/PhoneBindActivity$startCountdownNew$1;->this$0 Lcom/bytedance/trae/login/activity/PhoneBindActivity;
    sget v2, Lcom/bytedance/trae/login/R$color;->trae_login_enable I
    invoke-virtual v0, v2, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->getColor(I)I
    move-result v0
    invoke-virtual v1, v0, Landroid/widget/TextView;->setTextColor(I)V
    return-void 
.end method

.method public onTick(long)void
    .registers 9
    # ins_size=3
    iget-object v0, v6, Lcom/bytedance/trae/login/activity/PhoneBindActivity$startCountdownNew$1;->this$0 Lcom/bytedance/trae/login/activity/PhoneBindActivity;
    invoke-virtual v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->isFinishing()Z
    move-result v0
    if-nez v0, +036h
    iget-object v0, v6, Lcom/bytedance/trae/login/activity/PhoneBindActivity$startCountdownNew$1;->this$0 Lcom/bytedance/trae/login/activity/PhoneBindActivity;
    invoke-virtual v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->isDestroyed()Z
    move-result v0
    if-eqz v0, +003h
    goto +2ch
    iget-object v0, v6, Lcom/bytedance/trae/login/activity/PhoneBindActivity$startCountdownNew$1;->this$0 Lcom/bytedance/trae/login/activity/PhoneBindActivity;
    invoke-static v0, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->access$getTvResendNew$p(Lcom/bytedance/trae/login/activity/PhoneBindActivity;)Landroid/widget/TextView;
    move-result-object v0
    if-nez v0, +009h
    const-string/jumbo v0, tvResendNew
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    iget-object v1, v6, Lcom/bytedance/trae/login/activity/PhoneBindActivity$startCountdownNew$1;->this$0 Lcom/bytedance/trae/login/activity/PhoneBindActivity;
    sget v2, Lcom/bytedance/trae/login/R$string;->trae_phone_resend I
    const/4 v3, 1
    new-array v3, v3, [Ljava/lang/Object;
    const/16 v4, 1000
    int-to-long v4, v4
    div-long/2addr v7, v4
    long-to-int v7, v7
    invoke-static v7, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v7
    const/4 v8, 0
    aput-object v7, v3, v8
    invoke-virtual v1, v2, v3, Lcom/bytedance/trae/login/activity/PhoneBindActivity;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v7
    check-cast v7, Ljava/lang/CharSequence;
    invoke-virtual v0, v7, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    return-void 
.end method
