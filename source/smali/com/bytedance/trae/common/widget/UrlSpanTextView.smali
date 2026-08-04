# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/common/widget/UrlSpanTextView;
.super Landroidx/appcompat/widget/AppCompatTextView;
.source "UrlSpanTextView.kt"

.field private final attrs:Landroid/util/AttributeSet;
.field private linkColor:Landroid/content/res/ColorStateList;
.field private linkText:Ljava/lang/CharSequence;
.field private linkUnderLine:Z
.field private mOnClickListener:Lcom/bytedance/trae/common/widget/UrlSpanTextView$OnClickListener;


.method public constructor <init>(android.content.Context)void
    .registers 9
    # ins_size=2
    const-string v0, "context"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 6
    const/4 v6, 0
    move-object v1, v7
    move-object v2, v8
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/common/widget/UrlSpanTextView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(android.content.Context  android.util.AttributeSet)void
    .registers 10
    # ins_size=3
    const-string v0, "context"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v4, 0
    const/4 v5, 4
    const/4 v6, 0
    move-object v1, v7
    move-object v2, v8
    move-object v3, v9
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/common/widget/UrlSpanTextView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(android.content.Context  android.util.AttributeSet  int)void
    .registers 6
    # ins_size=4
    const-string v0, "context"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v2, v3, v4, v5, Landroidx/appcompat/widget/AppCompatTextView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I)V
    iput-object v4, v2, Lcom/bytedance/trae/common/widget/UrlSpanTextView;->attrs Landroid/util/AttributeSet;
    const/4 v5, 1
    iput-boolean v5, v2, Lcom/bytedance/trae/common/widget/UrlSpanTextView;->linkUnderLine Z
    const-string v0, ""
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    iput-object v1, v2, Lcom/bytedance/trae/common/widget/UrlSpanTextView;->linkText Ljava/lang/CharSequence;
    sget-object v1, Lcom/bytedance/trae/common_ui/R$styleable;->trae_UrlSpanTextView [I
    invoke-virtual v3, v4, v1, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet; [I)Landroid/content/res/TypedArray;
    move-result-object v3
    const-string v4, "obtainStyledAttributes(...)"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v4, Lcom/bytedance/trae/common_ui/R$styleable;->trae_UrlSpanTextView_trae_linkColor I
    invoke-virtual v3, v4, Landroid/content/res/TypedArray;->getColorStateList(I)Landroid/content/res/ColorStateList;
    move-result-object v4
    iput-object v4, v2, Lcom/bytedance/trae/common/widget/UrlSpanTextView;->linkColor Landroid/content/res/ColorStateList;
    sget v4, Lcom/bytedance/trae/common_ui/R$styleable;->trae_UrlSpanTextView_trae_linkUnderLine I
    invoke-virtual v3, v4, v5, Landroid/content/res/TypedArray;->getBoolean(I Z)Z
    move-result v4
    iput-boolean v4, v2, Lcom/bytedance/trae/common/widget/UrlSpanTextView;->linkUnderLine Z
    sget v4, Lcom/bytedance/trae/common_ui/R$styleable;->trae_UrlSpanTextView_trae_linkText I
    invoke-virtual v3, v4, Landroid/content/res/TypedArray;->getText(I)Ljava/lang/CharSequence;
    move-result-object v4
    if-nez v4, +005h
    move-object v4, v0
    check-cast v4, Ljava/lang/CharSequence;
    iput-object v4, v2, Lcom/bytedance/trae/common/widget/UrlSpanTextView;->linkText Ljava/lang/CharSequence;
    iget-object v4, v2, Lcom/bytedance/trae/common/widget/UrlSpanTextView;->linkColor Landroid/content/res/ColorStateList;
    if-eqz v4, +005h
    invoke-super v2, v4, Landroidx/appcompat/widget/AppCompatTextView;->setLinkTextColor(Landroid/content/res/ColorStateList;)V
    iget-object v4, v2, Lcom/bytedance/trae/common/widget/UrlSpanTextView;->linkText Ljava/lang/CharSequence;
    invoke-virtual v2, v4, Lcom/bytedance/trae/common/widget/UrlSpanTextView;->setUrlText(Ljava/lang/CharSequence;)V
    invoke-virtual v3, Landroid/content/res/TypedArray;->recycle()V
    return-void 
    move-exception v4
    invoke-virtual v3, Landroid/content/res/TypedArray;->recycle()V
    throw v4
    :try_start_0x1f
.end method

.method public synthetic constructor <init>(android.content.Context  android.util.AttributeSet  int  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 6
    # ins_size=6
    and-int/lit8 v5, v4, 2
    if-eqz v5, +003h
    const/4 v2, 0
    and-int/lit8 v4, v4, 4
    if-eqz v4, +003h
    const/4 v3, 0
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/common/widget/UrlSpanTextView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I)V
    return-void 
.end method

.method public static final synthetic access$getMOnClickListener$p(com.bytedance.trae.common.widget.UrlSpanTextView)com.bytedance.trae.common.widget.UrlSpanTextView$OnClickListener
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/common/widget/UrlSpanTextView;->mOnClickListener Lcom/bytedance/trae/common/widget/UrlSpanTextView$OnClickListener;
    return-object v0
.end method

.method private final wrapText(java.lang.CharSequence)java.lang.CharSequence
    .registers 11
    # ins_size=2
    instance-of v0, v10, Landroid/text/SpannedString;
    if-eqz v0, +063h
    invoke-static v10, Landroid/text/SpannableString;->valueOf(Ljava/lang/CharSequence;)Landroid/text/SpannableString;
    move-result-object v0
    check-cast v10, Landroid/text/SpannedString;
    invoke-virtual v0, Landroid/text/SpannableString;->length()I
    move-result v1
    const/4 v2, 1
    sub-int/2addr v1, v2
    const-class v3, Landroid/text/style/URLSpan;
    const/4 v4, 0
    invoke-virtual v10, v4, v1, v3, Landroid/text/SpannedString;->getSpans(I I Ljava/lang/Class;)[Ljava/lang/Object;
    move-result-object v1
    check-cast v1, [Landroid/text/style/URLSpan;
    invoke-static v1, Lkotlin/jvm/internal/ArrayIteratorKt;->iterator([Ljava/lang/Object;)Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +031h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Landroid/text/style/URLSpan;
    invoke-virtual v10, v3, Landroid/text/SpannedString;->getSpanStart(Ljava/lang/Object;)I
    move-result v5
    invoke-virtual v10, v3, Landroid/text/SpannedString;->getSpanEnd(Ljava/lang/Object;)I
    move-result v6
    invoke-virtual v0, v3, Landroid/text/SpannableString;->removeSpan(Ljava/lang/Object;)V
    new-instance v7, Lcom/bytedance/trae/common/widget/UrlSpanTextView$UrlClickSpan;
    invoke-virtual v3, Landroid/text/style/URLSpan;->getURL()Ljava/lang/String;
    move-result-object v3
    const-string v8, "getURL(...)"
    invoke-static v3, v8, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iget-boolean v8, v9, Lcom/bytedance/trae/common/widget/UrlSpanTextView;->linkUnderLine Z
    invoke-direct v7, v9, v3, v8, Lcom/bytedance/trae/common/widget/UrlSpanTextView$UrlClickSpan;-><init>(Lcom/bytedance/trae/common/widget/UrlSpanTextView; Ljava/lang/String; Z)V
    new-instance v3, Landroid/text/style/StyleSpan;
    invoke-direct v3, v2, Landroid/text/style/StyleSpan;-><init>(I)V
    const/16 v8, 33
    invoke-virtual v0, v7, v5, v6, v8, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object; I I I)V
    invoke-virtual v0, v3, v5, v6, v8, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object; I I I)V
    goto -34h
    invoke-static Landroid/text/method/LinkMovementMethod;->getInstance()Landroid/text/method/MovementMethod;
    move-result-object v10
    invoke-super v9, v10, Landroidx/appcompat/widget/AppCompatTextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V
    invoke-super v9, v4, Landroidx/appcompat/widget/AppCompatTextView;->setHighlightColor(I)V
    invoke-super v9, v2, Landroidx/appcompat/widget/AppCompatTextView;->setAutoLinkMask(I)V
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    check-cast v0, Ljava/lang/CharSequence;
    return-object v0
    return-object v10
.end method

.method public final getAttrs()android.util.AttributeSet
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/UrlSpanTextView;->attrs Landroid/util/AttributeSet;
    return-object v0
.end method

.method public final setOnClickListener(com.bytedance.trae.common.widget.UrlSpanTextView$OnClickListener)void
    .registers 3
    # ins_size=2
    const-string v0, "listener"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v1, Lcom/bytedance/trae/common/widget/UrlSpanTextView;->mOnClickListener Lcom/bytedance/trae/common/widget/UrlSpanTextView$OnClickListener;
    return-void 
.end method

.method public final setUrlSpannedText(java.lang.String)void
    .registers 9
    # ins_size=2
    const-string/jumbo v0, spannedText
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v2, "
"
    const-string v3, "<br/>"
    const/4 v4, 0
    const/4 v5, 4
    const/4 v6, 0
    move-object v1, v8
    invoke-static/range v1 ... v6, Lkotlin/text/StringsKt;->replace$default(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v8
    const/4 v0, 0
    invoke-static v8, v0, Landroidx/core/text/HtmlCompat;->fromHtml(Ljava/lang/String; I)Landroid/text/Spanned;
    move-result-object v8
    instance-of v0, v8, Landroid/text/SpannableStringBuilder;
    if-eqz v0, +005h
    check-cast v8, Landroid/text/SpannableStringBuilder;
    goto +2h
    const/4 v8, 0
    check-cast v8, Ljava/lang/CharSequence;
    invoke-static v8, Landroid/text/SpannedString;->valueOf(Ljava/lang/CharSequence;)Landroid/text/SpannedString;
    move-result-object v8
    invoke-static v8, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    check-cast v8, Ljava/lang/CharSequence;
    iput-object v8, v7, Lcom/bytedance/trae/common/widget/UrlSpanTextView;->linkText Ljava/lang/CharSequence;
    invoke-direct v7, v8, Lcom/bytedance/trae/common/widget/UrlSpanTextView;->wrapText(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v8
    invoke-super v7, v8, Landroidx/appcompat/widget/AppCompatTextView;->setText(Ljava/lang/CharSequence;)V
    return-void 
.end method

.method public final setUrlText(java.lang.CharSequence)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, text
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v1, Lcom/bytedance/trae/common/widget/UrlSpanTextView;->linkText Ljava/lang/CharSequence;
    invoke-direct v1, v2, Lcom/bytedance/trae/common/widget/UrlSpanTextView;->wrapText(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v2
    invoke-super v1, v2, Landroidx/appcompat/widget/AppCompatTextView;->setText(Ljava/lang/CharSequence;)V
    return-void 
.end method

.method public final setUrlTextColor(android.content.res.ColorStateList)void
    .registers 3
    # ins_size=2
    const-string v0, "linkColor"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v1, Lcom/bytedance/trae/common/widget/UrlSpanTextView;->linkColor Landroid/content/res/ColorStateList;
    invoke-super v1, v2, Landroidx/appcompat/widget/AppCompatTextView;->setLinkTextColor(Landroid/content/res/ColorStateList;)V
    return-void 
.end method
