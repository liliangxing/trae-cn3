# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$startResendCountdown$1;
.super Landroid/os/CountDownTimer;
.source "ForgotPasswordActivity.kt"

.field final synthetic this$0:Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;


.method constructor <init>(com.bytedance.trae.login.enterprise.ForgotPasswordActivity)void
    .registers 6
    # ins_size=2
    iput-object v5, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$startResendCountdown$1;->this$0 Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;
    const-wide/32 v0, 60000
    const-wide/16 v2, 1000
    invoke-direct v4, v0, v1, v2, v3, Landroid/os/CountDownTimer;-><init>(J J)V
    return-void 
.end method

.method public onFinish()void
    .registers 6
    # ins_size=1
    iget-object v0, v5, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$startResendCountdown$1;->this$0 Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;
    const/4 v1, 0
    invoke-static v0, v1, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->access$setCountdownActive$p(Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity; Z)V
    iget-object v0, v5, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$startResendCountdown$1;->this$0 Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;
    invoke-static v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->access$getTvResendCode$p(Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;)Landroid/widget/TextView;
    move-result-object v0
    const/4 v1, 0
    const-string/jumbo v2, tvResendCode
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    const/4 v3, 1
    invoke-virtual v0, v3, Landroid/widget/TextView;->setEnabled(Z)V
    iget-object v0, v5, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$startResendCountdown$1;->this$0 Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;
    invoke-static v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->access$getTvResendCode$p(Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;)Landroid/widget/TextView;
    move-result-object v0
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    iget-object v3, v5, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$startResendCountdown$1;->this$0 Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->trae_forgot_password_resend_code I
    invoke-virtual v3, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->getString(I)Ljava/lang/String;
    move-result-object v3
    check-cast v3, Ljava/lang/CharSequence;
    invoke-virtual v0, v3, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v0, v5, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$startResendCountdown$1;->this$0 Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;
    invoke-static v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->access$getTvResendCode$p(Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;)Landroid/widget/TextView;
    move-result-object v0
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    iget-object v3, v5, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$startResendCountdown$1;->this$0 Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;
    sget v4, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_default I
    invoke-virtual v3, v4, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->getColor(I)I
    move-result v3
    invoke-virtual v0, v3, Landroid/widget/TextView;->setTextColor(I)V
    iget-object v0, v5, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$startResendCountdown$1;->this$0 Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;
    invoke-static v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->access$getTvResendCode$p(Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;)Landroid/widget/TextView;
    move-result-object v0
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    iget-object v3, v5, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$startResendCountdown$1;->this$0 Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;
    invoke-static v3, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->access$getTvResendCode$p(Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;)Landroid/widget/TextView;
    move-result-object v3
    if-nez v3, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v3
    invoke-virtual v1, Landroid/widget/TextView;->getPaintFlags()I
    move-result v1
    or-int/lit8 v1, v1, 8
    invoke-virtual v0, v1, Landroid/widget/TextView;->setPaintFlags(I)V
    return-void 
.end method

.method public onTick(long)void
    .registers 10
    # ins_size=3
    const/16 v0, 1000
    int-to-long v0, v0
    div-long/2addr v8, v0
    iget-object v0, v7, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$startResendCountdown$1;->this$0 Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;
    invoke-static v0, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->access$getTvResendCode$p(Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;)Landroid/widget/TextView;
    move-result-object v0
    const/4 v1, 0
    const-string/jumbo v2, tvResendCode
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    iget-object v3, v7, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$startResendCountdown$1;->this$0 Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->trae_forgot_password_resend_countdown I
    const/4 v5, 1
    new-array v5, v5, [Ljava/lang/Object;
    const/4 v6, 0
    invoke-static v8, v9, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v8
    aput-object v8, v5, v6
    invoke-virtual v3, v4, v5, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v8
    check-cast v8, Ljava/lang/CharSequence;
    invoke-virtual v0, v8, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v8, v7, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$startResendCountdown$1;->this$0 Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;
    invoke-static v8, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->access$getTvResendCode$p(Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;)Landroid/widget/TextView;
    move-result-object v8
    if-nez v8, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v8
    iget-object v8, v7, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$startResendCountdown$1;->this$0 Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;
    sget v9, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_disabled I
    invoke-virtual v8, v9, Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;->getColor(I)I
    move-result v8
    invoke-virtual v1, v8, Landroid/widget/TextView;->setTextColor(I)V
    return-void 
.end method
