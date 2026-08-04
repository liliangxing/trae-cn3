# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet$onViewCreated$4;
.super Ljava/lang/Object;
.source "SkillsBottomSheet.kt"

.implements Landroid/text/TextWatcher;

.field final synthetic $ivSearchClear:Landroid/widget/ImageView;
.field final synthetic this$0:Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;


.method constructor <init>(android.widget.ImageView  com.bytedance.trae.conversation.skill.SkillsBottomSheet)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet$onViewCreated$4;->$ivSearchClear Landroid/widget/ImageView;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet$onViewCreated$4;->this$0 Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public afterTextChanged(android.text.Editable)void
    .registers 9
    # ins_size=2
    const/4 v0, 0
    if-eqz v8, +007h
    invoke-virtual v8, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v8
    goto +2h
    move-object v8, v0
    if-nez v8, +004h
    const-string v8, ""
    iget-object v1, v7, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet$onViewCreated$4;->$ivSearchClear Landroid/widget/ImageView;
    check-cast v8, Ljava/lang/CharSequence;
    invoke-interface v8, Ljava/lang/CharSequence;->length()I
    move-result v2
    const/4 v3, 1
    const/4 v4, 0
    if-lez v2, +004h
    move v2, v3
    goto +2h
    move v2, v4
    if-eqz v2, +004h
    move v2, v4
    goto +3h
    const/16 v2, 8
    invoke-virtual v1, v2, Landroid/widget/ImageView;->setVisibility(I)V
    invoke-interface v8, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-nez v1, +003h
    move v4, v3
    const-string v1, "adapter"
    if-eqz v4, +019h
    iget-object v8, v7, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet$onViewCreated$4;->this$0 Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;
    invoke-static v8, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;->access$getAdapter$p(Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;)Lcom/bytedance/trae/conversation/skill/SkillsAdapter;
    move-result-object v8
    if-nez v8, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v0, v8
    iget-object v8, v7, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet$onViewCreated$4;->this$0 Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;
    invoke-static v8, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;->access$getFullSkillsList$p(Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;)Ljava/util/List;
    move-result-object v8
    invoke-virtual v0, v8, Lcom/bytedance/trae/conversation/skill/SkillsAdapter;->updateData(Ljava/util/List;)V
    goto +43h
    iget-object v2, v7, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet$onViewCreated$4;->this$0 Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;
    invoke-static v2, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;->access$getFullSkillsList$p(Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;)Ljava/util/List;
    move-result-object v2
    check-cast v2, Ljava/lang/Iterable;
    new-instance v4, Ljava/util/ArrayList;
    invoke-direct v4, Ljava/util/ArrayList;-><init>()V
    check-cast v4, Ljava/util/Collection;
    invoke-interface v2, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    if-eqz v5, +019h
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    move-object v6, v5
    check-cast v6, Lcom/bytedance/trae/conversation/network/SkillItem;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/network/SkillItem;->getName()Ljava/lang/String;
    move-result-object v6
    check-cast v6, Ljava/lang/CharSequence;
    invoke-static v6, v8, v3, Lkotlin/text/StringsKt;->contains(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z)Z
    move-result v6
    if-eqz v6, -017h
    invoke-interface v4, v5, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1ch
    check-cast v4, Ljava/util/List;
    iget-object v8, v7, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet$onViewCreated$4;->this$0 Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;
    invoke-static v8, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;->access$getAdapter$p(Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;)Lcom/bytedance/trae/conversation/skill/SkillsAdapter;
    move-result-object v8
    if-nez v8, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v0, v8
    invoke-virtual v0, v4, Lcom/bytedance/trae/conversation/skill/SkillsAdapter;->updateData(Ljava/util/List;)V
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
