# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/AccountFragment$buildEnterprisePrivacyDesc$1$1;
.super Landroid/text/style/ClickableSpan;
.source "AccountFragment.kt"

.field final synthetic $linkColor:I
.field final synthetic this$0:Lcom/bytedance/trae/home/solo/setting/AccountFragment;


.method constructor <init>(com.bytedance.trae.home.solo.setting.AccountFragment  int)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/AccountFragment$buildEnterprisePrivacyDesc$1$1;->this$0 Lcom/bytedance/trae/home/solo/setting/AccountFragment;
    iput v2, v0, Lcom/bytedance/trae/home/solo/setting/AccountFragment$buildEnterprisePrivacyDesc$1$1;->$linkColor I
    invoke-direct v0, Landroid/text/style/ClickableSpan;-><init>()V
    return-void 
.end method

.method public onClick(android.view.View)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, widget
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v2, v1, Lcom/bytedance/trae/home/solo/setting/AccountFragment$buildEnterprisePrivacyDesc$1$1;->this$0 Lcom/bytedance/trae/home/solo/setting/AccountFragment;
    invoke-static v2, Lcom/bytedance/trae/home/solo/setting/AccountFragment;->access$openPrivacyModeDetails(Lcom/bytedance/trae/home/solo/setting/AccountFragment;)V
    return-void 
.end method

.method public updateDrawState(android.text.TextPaint)void
    .registers 3
    # ins_size=2
    const-string v0, "ds"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget v0, v1, Lcom/bytedance/trae/home/solo/setting/AccountFragment$buildEnterprisePrivacyDesc$1$1;->$linkColor I
    invoke-virtual v2, v0, Landroid/text/TextPaint;->setColor(I)V
    const/4 v0, 0
    invoke-virtual v2, v0, Landroid/text/TextPaint;->setUnderlineText(Z)V
    return-void 
.end method
