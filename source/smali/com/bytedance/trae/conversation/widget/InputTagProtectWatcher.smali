# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/widget/InputTagProtectWatcher;
.super Ljava/lang/Object;
.source "InputTagProtectWatcher.kt"

.implements Landroid/text/TextWatcher;

.field private final editText:Landroid/widget/EditText;
.field private isProcessing:Z


.method public constructor <init>(android.widget.EditText)void
    .registers 3
    # ins_size=2
    const-string v0, "editText"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/widget/InputTagProtectWatcher;->editText Landroid/widget/EditText;
    return-void 
.end method

.method private final getTagSpans(android.text.Editable)java.util.List
    .registers 8
    # ins_size=2
    invoke-static Lkotlin/collections/CollectionsKt;->createListBuilder()Ljava/util/List;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Ljava/util/Collection;
    invoke-interface v7, Landroid/text/Editable;->length()I
    move-result v2
    const-class v3, Lcom/bytedance/trae/conversation/widget/SkillTagSpan;
    const/4 v4, 0
    invoke-interface v7, v4, v2, v3, Landroid/text/Editable;->getSpans(I I Ljava/lang/Class;)[Ljava/lang/Object;
    move-result-object v2
    const-string v3, "getSpans(...)"
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v1, v2, Lkotlin/collections/CollectionsKt;->addAll(Ljava/util/Collection; [Ljava/lang/Object;)Z
    invoke-interface v7, Landroid/text/Editable;->length()I
    move-result v2
    const-class v5, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;
    invoke-interface v7, v4, v2, v5, Landroid/text/Editable;->getSpans(I I Ljava/lang/Class;)[Ljava/lang/Object;
    move-result-object v2
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v1, v2, Lkotlin/collections/CollectionsKt;->addAll(Ljava/util/Collection; [Ljava/lang/Object;)Z
    invoke-static v0, Lkotlin/collections/CollectionsKt;->build(Ljava/util/List;)Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    new-instance v1, Lcom/bytedance/trae/conversation/widget/InputTagProtectWatcher$getTagSpans$$inlined$sortedBy$1;
    invoke-direct v1, v7, Lcom/bytedance/trae/conversation/widget/InputTagProtectWatcher$getTagSpans$$inlined$sortedBy$1;-><init>(Landroid/text/Editable;)V
    check-cast v1, Ljava/util/Comparator;
    invoke-static v0, v1, Lkotlin/collections/CollectionsKt;->sortedWith(Ljava/lang/Iterable; Ljava/util/Comparator;)Ljava/util/List;
    move-result-object v7
    return-object v7
.end method

.method public afterTextChanged(android.text.Editable)void
    .registers 8
    # ins_size=2
    iget-boolean v0, v6, Lcom/bytedance/trae/conversation/widget/InputTagProtectWatcher;->isProcessing Z
    if-nez v0, +08ch
    if-nez v7, +004h
    goto/16 +088h
    iget-object v0, v6, Lcom/bytedance/trae/conversation/widget/InputTagProtectWatcher;->editText Landroid/widget/EditText;
    instance-of v1, v0, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;
    if-eqz v1, +00bh
    check-cast v0, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->isInternalUpdateFlag()Z
    move-result v0
    if-eqz v0, +003h
    return-void 
    invoke-direct v6, v7, Lcom/bytedance/trae/conversation/widget/InputTagProtectWatcher;->getTagSpans(Landroid/text/Editable;)Ljava/util/List;
    move-result-object v0
    invoke-interface v0, Ljava/util/List;->isEmpty()Z
    move-result v1
    if-eqz v1, +003h
    return-void 
    invoke-interface v0, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    const/4 v2, 0
    const/4 v3, 1
    if-eqz v1, +033h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    invoke-interface v7, v1, Landroid/text/Editable;->getSpanStart(Ljava/lang/Object;)I
    move-result v4
    invoke-interface v7, v1, Landroid/text/Editable;->getSpanEnd(Ljava/lang/Object;)I
    move-result v5
    if-ltz v4, +006h
    if-ltz v5, +004h
    if-gt v5, v4, -018h
    iput-boolean v3, v6, Lcom/bytedance/trae/conversation/widget/InputTagProtectWatcher;->isProcessing Z
    invoke-interface v7, v1, Landroid/text/Editable;->removeSpan(Ljava/lang/Object;)V
    if-ltz v4, +017h
    if-ltz v5, +015h
    invoke-interface v7, Landroid/text/Editable;->length()I
    move-result v1
    invoke-static v4, v1, Lkotlin/ranges/RangesKt;->coerceAtMost(I I)I
    move-result v1
    invoke-interface v7, Landroid/text/Editable;->length()I
    move-result v3
    invoke-static v5, v3, Lkotlin/ranges/RangesKt;->coerceAtMost(I I)I
    move-result v3
    invoke-interface v7, v1, v3, Landroid/text/Editable;->delete(I I)Landroid/text/Editable;
    iput-boolean v2, v6, Lcom/bytedance/trae/conversation/widget/InputTagProtectWatcher;->isProcessing Z
    goto -38h
    iget-object v0, v6, Lcom/bytedance/trae/conversation/widget/InputTagProtectWatcher;->editText Landroid/widget/EditText;
    invoke-virtual v0, Landroid/widget/EditText;->getSelectionStart()I
    move-result v0
    invoke-direct v6, v7, Lcom/bytedance/trae/conversation/widget/InputTagProtectWatcher;->getTagSpans(Landroid/text/Editable;)Ljava/util/List;
    move-result-object v1
    invoke-interface v1, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +01dh
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    invoke-interface v7, v4, Landroid/text/Editable;->getSpanStart(Ljava/lang/Object;)I
    move-result v5
    invoke-interface v7, v4, Landroid/text/Editable;->getSpanEnd(Ljava/lang/Object;)I
    move-result v4
    add-int/2addr v5, v3
    if-gt v5, v0, +006h
    if-ge v0, v4, +004h
    move v5, v3
    goto +2h
    move v5, v2
    if-eqz v5, -01ah
    iget-object v7, v6, Lcom/bytedance/trae/conversation/widget/InputTagProtectWatcher;->editText Landroid/widget/EditText;
    invoke-virtual v7, v4, Landroid/widget/EditText;->setSelection(I)V
    return-void 
.end method

.method public beforeTextChanged(java.lang.CharSequence  int  int  int)void
    .registers 5
    # ins_size=5
    return-void 
.end method

.method public onTextChanged(java.lang.CharSequence  int  int  int)void
    .registers 5
    # ins_size=5
    return-void 
.end method
