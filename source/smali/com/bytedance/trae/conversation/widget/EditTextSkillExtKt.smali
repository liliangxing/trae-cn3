# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/widget/EditTextSkillExtKt;
.super Ljava/lang/Object;
.source "EditTextSkillExt.kt"


.method public static final getSelectedSkill(android.widget.EditText)com.bytedance.trae.conversation.widget.SkillItem
    .registers 2
    # ins_size=1
    const-string v0, "<this>"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v1, Landroid/widget/EditText;->getTag()Ljava/lang/Object;
    move-result-object v1
    instance-of v0, v1, Lcom/bytedance/trae/conversation/widget/SkillItem;
    if-eqz v0, +005h
    check-cast v1, Lcom/bytedance/trae/conversation/widget/SkillItem;
    goto +2h
    const/4 v1, 0
    return-object v1
.end method

.method public static final getUserInputText(android.widget.EditText)java.lang.String
    .registers 4
    # ins_size=1
    const-string v0, "<this>"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v3, Landroid/widget/EditText;->getText()Landroid/text/Editable;
    move-result-object v3
    if-nez v3, +005h
    const-string v3, ""
    return-object v3
    invoke-interface v3, Landroid/text/Editable;->length()I
    move-result v0
    const-class v1, Lcom/bytedance/trae/conversation/widget/SkillTagSpan;
    const/4 v2, 0
    invoke-interface v3, v2, v0, v1, Landroid/text/Editable;->getSpans(I I Ljava/lang/Class;)[Ljava/lang/Object;
    move-result-object v0
    check-cast v0, [Lcom/bytedance/trae/conversation/widget/SkillTagSpan;
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    array-length v1, v0
    if-nez v1, +004h
    const/4 v1, 1
    goto +2h
    move v1, v2
    if-eqz v1, +011h
    invoke-virtual v3, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v3
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v3, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v3
    return-object v3
    aget-object v0, v0, v2
    invoke-interface v3, v0, Landroid/text/Editable;->getSpanEnd(Ljava/lang/Object;)I
    move-result v0
    invoke-interface v3, Landroid/text/Editable;->length()I
    move-result v1
    invoke-interface v3, v0, v1, Landroid/text/Editable;->subSequence(I I)Ljava/lang/CharSequence;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v3
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v3, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v3
    return-object v3
.end method

.method public static final hasSkillTag(android.widget.EditText)boolean
    .registers 4
    # ins_size=1
    const-string v0, "<this>"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v3, Landroid/widget/EditText;->getText()Landroid/text/Editable;
    move-result-object v3
    const/4 v0, 0
    if-nez v3, +003h
    return v0
    invoke-interface v3, Landroid/text/Editable;->length()I
    move-result v1
    const-class v2, Lcom/bytedance/trae/conversation/widget/SkillTagSpan;
    invoke-interface v3, v0, v1, v2, Landroid/text/Editable;->getSpans(I I Ljava/lang/Class;)[Ljava/lang/Object;
    move-result-object v3
    const-string v1, "getSpans(...)"
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    array-length v3, v3
    const/4 v1, 1
    if-nez v3, +003h
    move v0, v1
    xor-int/lit8 v3, v0, 1
    return v3
.end method

.method public static final insertSkillTag(android.widget.EditText  com.bytedance.trae.conversation.widget.SkillItem)void
    .registers 22
    # ins_size=2
    move-object/from16 v0, v20
    const-string v1, "<this>"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v1, skill
    move-object/from16 v2, v21
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static/range v20, Lcom/bytedance/trae/conversation/widget/EditTextSkillExtKt;->removeSkillTag(Landroid/widget/EditText;)V
    new-instance v1, Ljava/lang/StringBuilder;
    const-string/jumbo v3,  
    invoke-direct v1, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v21, Lcom/bytedance/trae/conversation/widget/SkillItem;->getName()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const/16 v3, 160
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    new-instance v3, Landroid/text/SpannableStringBuilder;
    move-object v4, v1
    check-cast v4, Ljava/lang/CharSequence;
    invoke-direct v3, v4, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;)V
    new-instance v4, Lcom/bytedance/trae/conversation/widget/SkillTagSpan;
    invoke-virtual/range v20, Landroid/widget/EditText;->getContext()Landroid/content/Context;
    move-result-object v6
    const-string v5, "getContext(...)"
    invoke-static v6, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual/range v21, Lcom/bytedance/trae/conversation/widget/SkillItem;->getName()Ljava/lang/String;
    move-result-object v7
    invoke-virtual/range v21, Lcom/bytedance/trae/conversation/widget/SkillItem;->getIconRes()I
    move-result v8
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 4088
    const/16 v19, 0
    move-object v5, v4
    invoke-direct/range v5 ... v19, Lcom/bytedance/trae/conversation/widget/SkillTagSpan;-><init>(Landroid/content/Context; Ljava/lang/String; I Lcom/bytedance/trae/conversation/widget/SkillItem; F F F F F I I F I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-virtual v1, Ljava/lang/String;->length()I
    move-result v5
    const/16 v6, 33
    const/4 v7, 0
    invoke-virtual v3, v4, v7, v5, v6, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object; I I I)V
    new-instance v4, Landroid/text/SpannableStringBuilder;
    invoke-direct v4, Landroid/text/SpannableStringBuilder;-><init>()V
    check-cast v3, Ljava/lang/CharSequence;
    invoke-virtual v4, v3, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
    const-string v3, " "
    check-cast v3, Ljava/lang/CharSequence;
    invoke-virtual v4, v3, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
    invoke-static/range v20, Lcom/bytedance/trae/conversation/widget/EditTextSkillExtKt;->getUserInputText(Landroid/widget/EditText;)Ljava/lang/String;
    move-result-object v3
    check-cast v3, Ljava/lang/CharSequence;
    invoke-virtual v4, v3, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
    check-cast v4, Ljava/lang/CharSequence;
    invoke-virtual v0, v4, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V
    invoke-virtual v1, Ljava/lang/String;->length()I
    move-result v1
    add-int/lit8 v1, v1, 1
    invoke-virtual v0, v1, Landroid/widget/EditText;->setSelection(I)V
    invoke-virtual/range v20 ... v21, Landroid/widget/EditText;->setTag(Ljava/lang/Object;)V
    return-void 
.end method

.method public static final removeSkillTag(android.widget.EditText)void
    .registers 6
    # ins_size=1
    const-string v0, "<this>"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v5, Landroid/widget/EditText;->getText()Landroid/text/Editable;
    move-result-object v0
    if-nez v0, +003h
    return-void 
    invoke-interface v0, Landroid/text/Editable;->length()I
    move-result v1
    const-class v2, Lcom/bytedance/trae/conversation/widget/SkillTagSpan;
    const/4 v3, 0
    invoke-interface v0, v3, v1, v2, Landroid/text/Editable;->getSpans(I I Ljava/lang/Class;)[Ljava/lang/Object;
    move-result-object v1
    check-cast v1, [Lcom/bytedance/trae/conversation/widget/SkillTagSpan;
    invoke-static v1, Lkotlin/jvm/internal/ArrayIteratorKt;->iterator([Ljava/lang/Object;)Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +017h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/widget/SkillTagSpan;
    invoke-interface v0, v2, Landroid/text/Editable;->getSpanStart(Ljava/lang/Object;)I
    move-result v3
    invoke-interface v0, v2, Landroid/text/Editable;->getSpanEnd(Ljava/lang/Object;)I
    move-result v4
    invoke-interface v0, v2, Landroid/text/Editable;->removeSpan(Ljava/lang/Object;)V
    invoke-interface v0, v3, v4, Landroid/text/Editable;->delete(I I)Landroid/text/Editable;
    goto -1ah
    const/4 v0, 0
    invoke-virtual v5, v0, Landroid/widget/EditText;->setTag(Ljava/lang/Object;)V
    return-void 
.end method
