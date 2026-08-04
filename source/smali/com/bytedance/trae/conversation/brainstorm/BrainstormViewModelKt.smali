# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModelKt;
.super Ljava/lang/Object;
.source "BrainstormViewModel.kt"


.method public static final resolveVoiceDiscussionDebugSubTaskSessionId(com.bytedance.trae.conversation.voice.subtask.SubTaskUiState  java.lang.String)java.lang.String
    .registers 3
    # ins_size=2
    if-eqz v1, +019h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;->getProxyChatSessionId()Ljava/lang/String;
    move-result-object v1
    if-eqz v1, +013h
    move-object v0, v1
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    xor-int/lit8 v0, v0, 1
    if-eqz v0, +003h
    goto +2h
    const/4 v1, 0
    if-eqz v1, +004h
    move-object v2, v1
    goto +5h
    if-nez v2, +004h
    const-string v2, ""
    return-object v2
.end method

.method public static final shouldUseVoiceDiscussionImageUpload(com.bytedance.trae.conversation.widget.ChatMode  boolean)boolean
    .registers 3
    # ins_size=2
    const-string v0, "chatMode"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/widget/ChatMode;->CODE Lcom/bytedance/trae/conversation/widget/ChatMode;
    if-ne v1, v0, +006h
    if-eqz v2, +004h
    const/4 v1, 1
    goto +2h
    const/4 v1, 0
    return v1
.end method
