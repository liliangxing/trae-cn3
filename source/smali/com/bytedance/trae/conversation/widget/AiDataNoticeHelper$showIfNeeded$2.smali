# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/widget/AiDataNoticeHelper$showIfNeeded$2;
.super Landroid/text/style/ClickableSpan;
.source "AiDataNoticeHelper.kt"

.field final synthetic $activity:Landroidx/activity/ComponentActivity;
.field final synthetic $url:Ljava/lang/String;


.method constructor <init>(androidx.activity.ComponentActivity  java.lang.String)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/widget/AiDataNoticeHelper$showIfNeeded$2;->$activity Landroidx/activity/ComponentActivity;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/widget/AiDataNoticeHelper$showIfNeeded$2;->$url Ljava/lang/String;
    invoke-direct v0, Landroid/text/style/ClickableSpan;-><init>()V
    return-void 
.end method

.method public onClick(android.view.View)void
    .registers 9
    # ins_size=2
    const-string/jumbo v0, sslocal://webview?hide_nav_bar=1&url=
    const-string/jumbo v1, widget
    invoke-static v8, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v8, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v8, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v8
    if-eqz v8, +012h
    sget-object v1, Lcom/bytedance/trae/common/activity/SimpleWebViewActivity;->Companion Lcom/bytedance/trae/common/activity/SimpleWebViewActivity$Companion;
    iget-object v8, v7, Lcom/bytedance/trae/conversation/widget/AiDataNoticeHelper$showIfNeeded$2;->$activity Landroidx/activity/ComponentActivity;
    move-object v2, v8
    check-cast v2, Landroid/content/Context;
    iget-object v3, v7, Lcom/bytedance/trae/conversation/widget/AiDataNoticeHelper$showIfNeeded$2;->$url Ljava/lang/String;
    const/4 v4, 0
    const/4 v5, 4
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lcom/bytedance/trae/common/activity/SimpleWebViewActivity$Companion;->start$default(Lcom/bytedance/trae/common/activity/SimpleWebViewActivity$Companion; Landroid/content/Context; Ljava/lang/String; Z I Ljava/lang/Object;)V
    goto +2bh
    iget-object v8, v7, Lcom/bytedance/trae/conversation/widget/AiDataNoticeHelper$showIfNeeded$2;->$url Ljava/lang/String;
    const-string v1, ":/?=&#"
    invoke-static v8, v1, Landroid/net/Uri;->encode(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v8
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v8
    sget-object v0, Lcom/bytedance/android/anniex/assemble/AnnieX;->INSTANCE Lcom/bytedance/android/anniex/assemble/AnnieX;
    iget-object v1, v7, Lcom/bytedance/trae/conversation/widget/AiDataNoticeHelper$showIfNeeded$2;->$activity Landroidx/activity/ComponentActivity;
    check-cast v1, Landroid/content/Context;
    invoke-static v8, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v2
    const-string v8, "parse(...)"
    invoke-static v2, v8, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v3, 0
    const/4 v4, 4
    const/4 v5, 0
    invoke-static/range v0 ... v5, Lcom/bytedance/android/anniex/assemble/AnnieX;->open$default(Lcom/bytedance/android/anniex/assemble/AnnieX; Landroid/content/Context; Landroid/net/Uri; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Z
    return-void 
    :try_start_0x9
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
