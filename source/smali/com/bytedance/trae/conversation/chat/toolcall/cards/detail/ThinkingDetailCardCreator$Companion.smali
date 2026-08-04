# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ThinkingDetailCardCreator$Companion;
.super Ljava/lang/Object;
.source "ThinkingDetailCardCreator.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ThinkingDetailCardCreator$Companion;-><init>()V
    return-void 
.end method

.method public static synthetic buildContentView$conversation_mainlandRelease$default(com.bytedance.trae.conversation.chat.toolcall.cards.detail.ThinkingDetailCardCreator$Companion  android.content.Context  java.lang.String  boolean  int  java.lang.Object)android.view.View
    .registers 6
    # ins_size=6
    and-int/lit8 v4, v4, 4
    if-eqz v4, +003h
    const/4 v3, 1
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ThinkingDetailCardCreator$Companion;->buildContentView$conversation_mainlandRelease(Landroid/content/Context; Ljava/lang/String; Z)Landroid/view/View;
    move-result-object v0
    return-object v0
.end method

.method public final buildContentView$conversation_mainlandRelease(android.content.Context  java.lang.String  boolean)android.view.View
    .registers 13
    # ins_size=4
    const-string v0, "context"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "rawContent"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v10, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    invoke-virtual v0, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v0
    iget v0, v0, Landroid/util/DisplayMetrics;->density F
    invoke-virtual v11, Ljava/lang/String;->length()I
    move-result v0
    const/16 v1, 5000
    if-le v0, v1, +019h
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    invoke-static v11, v1, Lkotlin/text/StringsKt;->take(Ljava/lang/String; I)Ljava/lang/String;
    move-result-object v11
    invoke-virtual v0, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    const/16 v0, 8230
    invoke-virtual v11, v0, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-virtual v11, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v11
    move-object v2, v11
    new-instance v11, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 6
    const/4 v8, 0
    move-object v3, v11
    move-object v4, v10
    invoke-direct/range v3 ... v8, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sget v0, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_secondary I
    invoke-static v10, v0, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v10
    invoke-virtual v11, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->setTextColor(I)V
    const/4 v10, 2
    const/high16 v0, 1095761920
    invoke-virtual v11, v10, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->setTextSize(I F)V
    const/4 v10, 0
    const v0, 1068708659
    invoke-virtual v11, v10, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->setLineSpacing(F F)V
    invoke-static Landroid/text/method/LinkMovementMethod;->getInstance()Landroid/text/method/MovementMethod;
    move-result-object v10
    invoke-virtual v11, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V
    new-instance v10, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v0, -1
    const/4 v1, -2
    invoke-direct v10, v0, v1, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v10, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v11, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper;
    const/4 v4, 0
    const/16 v5, 8
    const/4 v6, 0
    move-object v1, v11
    move v3, v12
    invoke-static/range v0 ... v6, Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper;->setMarkdownContent$default(Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper; Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView; Ljava/lang/String; Z Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper$ListBulletStyle; I Ljava/lang/Object;)V
    check-cast v11, Landroid/view/View;
    return-object v11
.end method
