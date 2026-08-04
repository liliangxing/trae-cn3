# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/activity/AgreementDialog$setupMessageWithLinks$2;
.super Landroid/text/style/ClickableSpan;
.source "AgreementDialog.kt"

.field final synthetic this$0:Lcom/bytedance/trae/login/activity/AgreementDialog;


.method constructor <init>(com.bytedance.trae.login.activity.AgreementDialog)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/login/activity/AgreementDialog$setupMessageWithLinks$2;->this$0 Lcom/bytedance/trae/login/activity/AgreementDialog;
    invoke-direct v0, Landroid/text/style/ClickableSpan;-><init>()V
    return-void 
.end method

.method public onClick(android.view.View)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, widget
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v2, v1, Lcom/bytedance/trae/login/activity/AgreementDialog$setupMessageWithLinks$2;->this$0 Lcom/bytedance/trae/login/activity/AgreementDialog;
    const-string v0, "https://www.trae.cn/privacy-policy"
    invoke-static v2, v0, Lcom/bytedance/trae/login/activity/AgreementDialog;->access$openUrl(Lcom/bytedance/trae/login/activity/AgreementDialog; Ljava/lang/String;)V
    return-void 
.end method

.method public updateDrawState(android.text.TextPaint)void
    .registers 3
    # ins_size=2
    const-string v0, "ds"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const v0, -13667073
    invoke-virtual v2, v0, Landroid/text/TextPaint;->setColor(I)V
    const/4 v0, 0
    invoke-virtual v2, v0, Landroid/text/TextPaint;->setUnderlineText(Z)V
    return-void 
.end method
