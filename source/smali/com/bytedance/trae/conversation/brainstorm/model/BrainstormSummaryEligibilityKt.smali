# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummaryEligibilityKt;
.super Ljava/lang/Object;
.source "BrainstormSummaryEligibility.kt"


.method public static final hasSummaryWorthyInput(com.bytedance.trae.conversation.brainstorm.model.BrainstormUiState)boolean
    .registers 8
    # ins_size=1
    const-string v0, "<this>"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v7, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getSubtitleHistory()Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    instance-of v1, v0, Ljava/util/Collection;
    const/4 v2, 1
    const/4 v3, 0
    if-eqz v1, +00dh
    move-object v1, v0
    check-cast v1, Ljava/util/Collection;
    invoke-interface v1, Ljava/util/Collection;->isEmpty()Z
    move-result v1
    if-eqz v1, +004h
    move v0, v3
    goto +2ch
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, -00ah
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->getRole()Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole;
    move-result-object v4
    sget-object v5, Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole;->User Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole;
    if-ne v4, v5, +011h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->getContent()Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    xor-int/2addr v1, v2
    if-eqz v1, +004h
    move v1, v2
    goto +2h
    move v1, v3
    if-eqz v1, -024h
    move v0, v2
    invoke-virtual v7, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getCurrentTranscript()Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    xor-int/2addr v1, v2
    invoke-virtual v7, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;->getAttachments()Ljava/util/List;
    move-result-object v7
    check-cast v7, Ljava/lang/Iterable;
    instance-of v4, v7, Ljava/util/Collection;
    if-eqz v4, +00dh
    move-object v4, v7
    check-cast v4, Ljava/util/Collection;
    invoke-interface v4, Ljava/util/Collection;->isEmpty()Z
    move-result v4
    if-eqz v4, +004h
    move v7, v3
    goto +39h
    invoke-interface v7, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v7
    invoke-interface v7, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, -00ah
    invoke-interface v7, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getState()Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;
    move-result-object v5
    sget-object v6, Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;->Uploaded Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;
    if-ne v5, v6, +01eh
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getUploadedRef()Ljava/lang/String;
    move-result-object v5
    check-cast v5, Ljava/lang/CharSequence;
    if-eqz v5, +00bh
    invoke-static v5, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v5
    if-eqz v5, +003h
    goto +3h
    move v5, v3
    goto +2h
    move v5, v2
    if-nez v5, +00ah
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getNotifiedToBot()Z
    move-result v4
    if-eqz v4, +004h
    move v4, v2
    goto +2h
    move v4, v3
    if-eqz v4, -031h
    move v7, v2
    if-nez v0, +008h
    if-nez v1, +006h
    if-eqz v7, +003h
    goto +2h
    move v2, v3
    return v2
.end method
