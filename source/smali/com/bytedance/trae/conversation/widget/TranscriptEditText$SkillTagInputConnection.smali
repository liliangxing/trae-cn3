# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/widget/TranscriptEditText$SkillTagInputConnection;
.super Landroid/view/inputmethod/InputConnectionWrapper;
.source "TranscriptEditText.kt"

.field final synthetic this$0:Lcom/bytedance/trae/conversation/widget/TranscriptEditText;


.method public constructor <init>(com.bytedance.trae.conversation.widget.TranscriptEditText  android.view.inputmethod.InputConnection  boolean)void
    .registers 5
    # ins_size=4
    const-string/jumbo v0, target
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/widget/TranscriptEditText$SkillTagInputConnection;->this$0 Lcom/bytedance/trae/conversation/widget/TranscriptEditText;
    invoke-direct v1, v3, v4, Landroid/view/inputmethod/InputConnectionWrapper;-><init>(Landroid/view/inputmethod/InputConnection; Z)V
    return-void 
.end method

.method private final tryDeleteInputTag()boolean
    .registers 8
    # ins_size=1
    iget-object v0, v7, Lcom/bytedance/trae/conversation/widget/TranscriptEditText$SkillTagInputConnection;->this$0 Lcom/bytedance/trae/conversation/widget/TranscriptEditText;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->getText()Landroid/text/Editable;
    move-result-object v0
    const/4 v1, 0
    if-nez v0, +003h
    return v1
    iget-object v2, v7, Lcom/bytedance/trae/conversation/widget/TranscriptEditText$SkillTagInputConnection;->this$0 Lcom/bytedance/trae/conversation/widget/TranscriptEditText;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->getSelectionStart()I
    move-result v2
    iget-object v3, v7, Lcom/bytedance/trae/conversation/widget/TranscriptEditText$SkillTagInputConnection;->this$0 Lcom/bytedance/trae/conversation/widget/TranscriptEditText;
    move-object v4, v0
    check-cast v4, Landroid/text/Spanned;
    invoke-static v3, v4, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->access$getTagSpans(Lcom/bytedance/trae/conversation/widget/TranscriptEditText; Landroid/text/Spanned;)Ljava/util/List;
    move-result-object v3
    invoke-interface v3, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +048h
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/conversation/widget/InputTagSpan;
    invoke-interface v0, v4, Landroid/text/Editable;->getSpanEnd(Ljava/lang/Object;)I
    move-result v5
    if-eq v2, v5, +006h
    add-int/lit8 v6, v5, 1
    if-ne v2, v6, -014h
    invoke-interface v0, v4, Landroid/text/Editable;->getSpanStart(Ljava/lang/Object;)I
    move-result v2
    iget-object v3, v7, Lcom/bytedance/trae/conversation/widget/TranscriptEditText$SkillTagInputConnection;->this$0 Lcom/bytedance/trae/conversation/widget/TranscriptEditText;
    const/4 v6, 1
    invoke-static v3, v6, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->access$setInternalUpdate$p(Lcom/bytedance/trae/conversation/widget/TranscriptEditText; Z)V
    instance-of v3, v4, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;
    if-eqz v3, +008h
    move-object v3, v4
    check-cast v3, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;->release()V
    invoke-interface v0, v4, Landroid/text/Editable;->removeSpan(Ljava/lang/Object;)V
    add-int/2addr v5, v6
    invoke-interface v0, Landroid/text/Editable;->length()I
    move-result v3
    invoke-static v5, v3, Lkotlin/ranges/RangesKt;->coerceAtMost(I I)I
    move-result v3
    invoke-interface v0, v2, v3, Landroid/text/Editable;->delete(I I)Landroid/text/Editable;
    iget-object v3, v7, Lcom/bytedance/trae/conversation/widget/TranscriptEditText$SkillTagInputConnection;->this$0 Lcom/bytedance/trae/conversation/widget/TranscriptEditText;
    invoke-interface v0, Landroid/text/Editable;->length()I
    move-result v0
    invoke-static v2, v0, Lkotlin/ranges/RangesKt;->coerceAtMost(I I)I
    move-result v0
    invoke-virtual v3, v0, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->setSelection(I)V
    iget-object v0, v7, Lcom/bytedance/trae/conversation/widget/TranscriptEditText$SkillTagInputConnection;->this$0 Lcom/bytedance/trae/conversation/widget/TranscriptEditText;
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->access$setInternalUpdate$p(Lcom/bytedance/trae/conversation/widget/TranscriptEditText; Z)V
    return v6
    return v1
.end method

.method public deleteSurroundingText(int  int)boolean
    .registers 4
    # ins_size=3
    if-lez v2, +00ah
    invoke-direct v1, Lcom/bytedance/trae/conversation/widget/TranscriptEditText$SkillTagInputConnection;->tryDeleteInputTag()Z
    move-result v0
    if-eqz v0, +004h
    const/4 v2, 1
    return v2
    invoke-super v1, v2, v3, Landroid/view/inputmethod/InputConnectionWrapper;->deleteSurroundingText(I I)Z
    move-result v2
    return v2
.end method

.method public sendKeyEvent(android.view.KeyEvent)boolean
    .registers 4
    # ins_size=2
    const-string v0, "event"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v3, Landroid/view/KeyEvent;->getAction()I
    move-result v0
    if-nez v0, +012h
    invoke-virtual v3, Landroid/view/KeyEvent;->getKeyCode()I
    move-result v0
    const/16 v1, 67
    if-ne v0, v1, +00ah
    invoke-direct v2, Lcom/bytedance/trae/conversation/widget/TranscriptEditText$SkillTagInputConnection;->tryDeleteInputTag()Z
    move-result v0
    if-eqz v0, +004h
    const/4 v3, 1
    return v3
    invoke-super v2, v3, Landroid/view/inputmethod/InputConnectionWrapper;->sendKeyEvent(Landroid/view/KeyEvent;)Z
    move-result v3
    return v3
.end method
