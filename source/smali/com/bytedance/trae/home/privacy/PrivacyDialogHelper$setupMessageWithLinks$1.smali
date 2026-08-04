# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/privacy/PrivacyDialogHelper$setupMessageWithLinks$1;
.super Landroid/text/style/ClickableSpan;
.source "PrivacyDialogHelper.kt"

.field final synthetic $activity:Landroidx/activity/ComponentActivity;
.field final synthetic $termsUrl:Ljava/lang/String;


.method constructor <init>(androidx.activity.ComponentActivity  java.lang.String)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/home/privacy/PrivacyDialogHelper$setupMessageWithLinks$1;->$activity Landroidx/activity/ComponentActivity;
    iput-object v2, v0, Lcom/bytedance/trae/home/privacy/PrivacyDialogHelper$setupMessageWithLinks$1;->$termsUrl Ljava/lang/String;
    invoke-direct v0, Landroid/text/style/ClickableSpan;-><init>()V
    return-void 
.end method

.method public onClick(android.view.View)void
    .registers 4
    # ins_size=2
    const-string/jumbo v0, widget
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v3, Lcom/bytedance/trae/home/privacy/PrivacyDialogHelper;->INSTANCE Lcom/bytedance/trae/home/privacy/PrivacyDialogHelper;
    iget-object v0, v2, Lcom/bytedance/trae/home/privacy/PrivacyDialogHelper$setupMessageWithLinks$1;->$activity Landroidx/activity/ComponentActivity;
    iget-object v1, v2, Lcom/bytedance/trae/home/privacy/PrivacyDialogHelper$setupMessageWithLinks$1;->$termsUrl Ljava/lang/String;
    invoke-static v3, v0, v1, Lcom/bytedance/trae/home/privacy/PrivacyDialogHelper;->access$openUrl(Lcom/bytedance/trae/home/privacy/PrivacyDialogHelper; Landroidx/activity/ComponentActivity; Ljava/lang/String;)V
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
