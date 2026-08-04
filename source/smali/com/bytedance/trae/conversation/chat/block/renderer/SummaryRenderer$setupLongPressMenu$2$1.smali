# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer$setupLongPressMenu$2$1;
.super Ljava/lang/Object;
.source "SummaryRenderer.kt"

.implements Lcom/bytedance/trae/conversation/chat/menu/AgentMessageMenu$OnMenuClickListener;

.field final synthetic $contentView:Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;
.field final synthetic $lastTouchLocalX:Lkotlin/jvm/internal/Ref$FloatRef;
.field final synthetic $lastTouchLocalY:Lkotlin/jvm/internal/Ref$FloatRef;
.field final synthetic $summaryContent:Ljava/lang/String;


.method constructor <init>(com.bytedance.trae.conversation.chat.block.renderer.SimpleMarkdownTextView  java.lang.String  kotlin.jvm.internal.Ref$FloatRef  kotlin.jvm.internal.Ref$FloatRef)void
    .registers 5
    # ins_size=5
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer$setupLongPressMenu$2$1;->$contentView Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer$setupLongPressMenu$2$1;->$summaryContent Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer$setupLongPressMenu$2$1;->$lastTouchLocalX Lkotlin/jvm/internal/Ref$FloatRef;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer$setupLongPressMenu$2$1;->$lastTouchLocalY Lkotlin/jvm/internal/Ref$FloatRef;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public onCopyClick()void
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer$setupLongPressMenu$2$1;->$contentView Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->getContext()Landroid/content/Context;
    move-result-object v0
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer$setupLongPressMenu$2$1;->$summaryContent Ljava/lang/String;
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    if-eqz v1, +008h
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_no_copyable_content I
    invoke-static v0, v1, Lcom/bytedance/trae/common/widget/CustomToast;->showLong(Landroid/content/Context; I)V
    return-void 
    const-string v1, "clipboard"
    invoke-virtual v0, v1, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;
    move-result-object v1
    const-string v2, "null cannot be cast to non-null type android.content.ClipboardManager"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v1, Landroid/content/ClipboardManager;
    const-string/jumbo v2, summary
    check-cast v2, Ljava/lang/CharSequence;
    iget-object v3, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer$setupLongPressMenu$2$1;->$summaryContent Ljava/lang/String;
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v2, v3, Landroid/content/ClipData;->newPlainText(Ljava/lang/CharSequence; Ljava/lang/CharSequence;)Landroid/content/ClipData;
    move-result-object v2
    invoke-virtual v1, v2, Landroid/content/ClipboardManager;->setPrimaryClip(Landroid/content/ClipData;)V
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_copied I
    invoke-static v0, v1, Lcom/bytedance/trae/common/widget/CustomToast;->showLong(Landroid/content/Context; I)V
    return-void 
.end method

.method public onSelectTextClick()void
    .registers 5
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer$setupLongPressMenu$2$1;->$contentView Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;
    check-cast v1, Landroid/widget/TextView;
    iget-object v2, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer$setupLongPressMenu$2$1;->$lastTouchLocalX Lkotlin/jvm/internal/Ref$FloatRef;
    iget v2, v2, Lkotlin/jvm/internal/Ref$FloatRef;->element F
    iget-object v3, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer$setupLongPressMenu$2$1;->$lastTouchLocalY Lkotlin/jvm/internal/Ref$FloatRef;
    iget v3, v3, Lkotlin/jvm/internal/Ref$FloatRef;->element F
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->enterSelectionMode(Landroid/widget/TextView; F F)V
    return-void 
.end method
