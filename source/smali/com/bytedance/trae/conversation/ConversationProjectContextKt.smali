# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/ConversationProjectContextKt;
.super Ljava/lang/Object;
.source "ConversationProjectContext.kt"


.method public static final ideProjectId(com.bytedance.trae.im.service.Conversation)java.lang.String
    .registers 2
    # ins_size=1
    const-string v0, "<this>"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v1, Lcom/bytedance/trae/im/service/Conversation;->getOwnerProjectId()Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationProjectContextKt;->takeNotBlank(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    if-nez v0, +00ah
    invoke-virtual v1, Lcom/bytedance/trae/im/service/Conversation;->getLatestProjectId()Ljava/lang/String;
    move-result-object v1
    invoke-static v1, Lcom/bytedance/trae/conversation/ConversationProjectContextKt;->takeNotBlank(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static final ideProjectPath(com.bytedance.trae.im.service.Conversation)java.lang.String
    .registers 2
    # ins_size=1
    const-string v0, "<this>"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v1, Lcom/bytedance/trae/im/service/Conversation;->getOwnerProjectAbsolutePath()Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationProjectContextKt;->takeNotBlank(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    if-nez v0, +00ah
    invoke-virtual v1, Lcom/bytedance/trae/im/service/Conversation;->getWorkspace()Ljava/lang/String;
    move-result-object v1
    invoke-static v1, Lcom/bytedance/trae/conversation/ConversationProjectContextKt;->takeNotBlank(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static final ownerIdeProjectId(com.bytedance.trae.im.service.Conversation)java.lang.String
    .registers 2
    # ins_size=1
    const-string v0, "<this>"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v1, Lcom/bytedance/trae/im/service/Conversation;->getOwnerProjectId()Ljava/lang/String;
    move-result-object v1
    invoke-static v1, Lcom/bytedance/trae/conversation/ConversationProjectContextKt;->takeNotBlank(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    return-object v1
.end method

.method public static final takeNotBlank(java.lang.String)java.lang.String
    .registers 3
    # ins_size=1
    const/4 v0, 0
    if-eqz v2, +00eh
    move-object v1, v2
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    xor-int/lit8 v1, v1, 1
    if-eqz v1, +003h
    goto +2h
    move-object v2, v0
    return-object v2
.end method
