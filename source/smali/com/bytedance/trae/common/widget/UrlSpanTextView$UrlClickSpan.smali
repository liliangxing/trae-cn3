# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/common/widget/UrlSpanTextView$UrlClickSpan;
.super Landroid/text/style/ClickableSpan;
.source "UrlSpanTextView.kt"

.field final synthetic this$0:Lcom/bytedance/trae/common/widget/UrlSpanTextView;
.field private underlineText:Z
.field private url:Ljava/lang/String;


.method public constructor <init>(com.bytedance.trae.common.widget.UrlSpanTextView  java.lang.String  boolean)void
    .registers 5
    # ins_size=4
    const-string/jumbo v0, url
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v1, Lcom/bytedance/trae/common/widget/UrlSpanTextView$UrlClickSpan;->this$0 Lcom/bytedance/trae/common/widget/UrlSpanTextView;
    invoke-direct v1, Landroid/text/style/ClickableSpan;-><init>()V
    iput-object v3, v1, Lcom/bytedance/trae/common/widget/UrlSpanTextView$UrlClickSpan;->url Ljava/lang/String;
    iput-boolean v4, v1, Lcom/bytedance/trae/common/widget/UrlSpanTextView$UrlClickSpan;->underlineText Z
    return-void 
.end method

.method public final getUrl$common_ui_mainlandRelease()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/UrlSpanTextView$UrlClickSpan;->url Ljava/lang/String;
    return-object v0
.end method

.method public onClick(android.view.View)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, widget
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v2, v1, Lcom/bytedance/trae/common/widget/UrlSpanTextView$UrlClickSpan;->this$0 Lcom/bytedance/trae/common/widget/UrlSpanTextView;
    invoke-static v2, Lcom/bytedance/trae/common/widget/UrlSpanTextView;->access$getMOnClickListener$p(Lcom/bytedance/trae/common/widget/UrlSpanTextView;)Lcom/bytedance/trae/common/widget/UrlSpanTextView$OnClickListener;
    move-result-object v2
    if-eqz v2, +007h
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/UrlSpanTextView$UrlClickSpan;->url Ljava/lang/String;
    invoke-interface v2, v0, Lcom/bytedance/trae/common/widget/UrlSpanTextView$OnClickListener;->onUrlClick(Ljava/lang/String;)V
    return-void 
.end method

.method public final setUrl$common_ui_mainlandRelease(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string v0, "<set-?>"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v1, Lcom/bytedance/trae/common/widget/UrlSpanTextView$UrlClickSpan;->url Ljava/lang/String;
    return-void 
.end method

.method public updateDrawState(android.text.TextPaint)void
    .registers 3
    # ins_size=2
    const-string v0, "ds"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-boolean v0, v1, Lcom/bytedance/trae/common/widget/UrlSpanTextView$UrlClickSpan;->underlineText Z
    invoke-virtual v2, v0, Landroid/text/TextPaint;->setUnderlineText(Z)V
    iget v0, v2, Landroid/text/TextPaint;->linkColor I
    invoke-virtual v2, v0, Landroid/text/TextPaint;->setColor(I)V
    return-void 
.end method
