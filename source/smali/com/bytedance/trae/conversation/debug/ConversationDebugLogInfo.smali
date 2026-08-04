# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;
.super Ljava/lang/Object;
.source "ConversationDebugInfoCopier.kt"

.field private final createdAt:J
.field private final deviceId:Ljava/lang/String;
.field private final location:Ljava/lang/String;
.field private final messageId:Ljava/lang/String;
.field private final replyToMessageId:Ljava/lang/String;
.field private final sessionId:Ljava/lang/String;
.field private final userId:Ljava/lang/String;
.field private final voiceDiscussion:Lcom/bytedance/trae/conversation/debug/VoiceDiscussionDebugLogInfo;


.method public constructor <init>(long  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.conversation.debug.VoiceDiscussionDebugLogInfo)void
    .registers 11
    # ins_size=10
    const-string v0, "messageId"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, replyToMessageId
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, sessionId
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "deviceId"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, userId
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "location"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-wide v2, v1, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;->createdAt J
    iput-object v4, v1, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;->messageId Ljava/lang/String;
    iput-object v5, v1, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;->replyToMessageId Ljava/lang/String;
    iput-object v6, v1, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;->sessionId Ljava/lang/String;
    iput-object v7, v1, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;->deviceId Ljava/lang/String;
    iput-object v8, v1, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;->userId Ljava/lang/String;
    iput-object v9, v1, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;->location Ljava/lang/String;
    iput-object v10, v1, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;->voiceDiscussion Lcom/bytedance/trae/conversation/debug/VoiceDiscussionDebugLogInfo;
    return-void 
.end method

.method public synthetic constructor <init>(long  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.conversation.debug.VoiceDiscussionDebugLogInfo  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 23
    # ins_size=12
    move/from16 v0, v21
    and-int/lit16 v0, v0, 128
    if-eqz v0, +005h
    const/4 v0, 0
    move-object v10, v0
    goto +3h
    move-object/from16 v10, v20
    move-object v1, v11
    move-wide v2, v12
    move-object v4, v14
    move-object v5, v15
    move-object/from16 v6, v16
    move-object/from16 v7, v17
    move-object/from16 v8, v18
    move-object/from16 v9, v19
    invoke-direct/range v1 ... v10, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;-><init>(J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/debug/VoiceDiscussionDebugLogInfo;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.debug.ConversationDebugLogInfo  long  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.conversation.debug.VoiceDiscussionDebugLogInfo  int  java.lang.Object)com.bytedance.trae.conversation.debug.ConversationDebugLogInfo
    .registers 22
    # ins_size=12
    move-object v0, v10
    move/from16 v1, v20
    and-int/lit8 v2, v1, 1
    if-eqz v2, +005h
    iget-wide v2, v0, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;->createdAt J
    goto +2h
    move-wide v2, v11
    and-int/lit8 v4, v1, 2
    if-eqz v4, +005h
    iget-object v4, v0, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;->messageId Ljava/lang/String;
    goto +2h
    move-object v4, v13
    and-int/lit8 v5, v1, 4
    if-eqz v5, +005h
    iget-object v5, v0, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;->replyToMessageId Ljava/lang/String;
    goto +2h
    move-object v5, v14
    and-int/lit8 v6, v1, 8
    if-eqz v6, +005h
    iget-object v6, v0, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;->sessionId Ljava/lang/String;
    goto +2h
    move-object v6, v15
    and-int/lit8 v7, v1, 16
    if-eqz v7, +005h
    iget-object v7, v0, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;->deviceId Ljava/lang/String;
    goto +3h
    move-object/from16 v7, v16
    and-int/lit8 v8, v1, 32
    if-eqz v8, +005h
    iget-object v8, v0, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;->userId Ljava/lang/String;
    goto +3h
    move-object/from16 v8, v17
    and-int/lit8 v9, v1, 64
    if-eqz v9, +005h
    iget-object v9, v0, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;->location Ljava/lang/String;
    goto +3h
    move-object/from16 v9, v18
    and-int/lit16 v1, v1, 128
    if-eqz v1, +005h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;->voiceDiscussion Lcom/bytedance/trae/conversation/debug/VoiceDiscussionDebugLogInfo;
    goto +3h
    move-object/from16 v1, v19
    move-wide v11, v2
    move-object v13, v4
    move-object v14, v5
    move-object v15, v6
    move-object/from16 v16, v7
    move-object/from16 v17, v8
    move-object/from16 v18, v9
    move-object/from16 v19, v1
    invoke-virtual/range v10 ... v19, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;->copy(J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/debug/VoiceDiscussionDebugLogInfo;)Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;
    move-result-object v0
    return-object v0
.end method

.method public final component1()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;->createdAt J
    return-wide v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;->messageId Ljava/lang/String;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;->replyToMessageId Ljava/lang/String;
    return-object v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;->sessionId Ljava/lang/String;
    return-object v0
.end method

.method public final component5()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;->deviceId Ljava/lang/String;
    return-object v0
.end method

.method public final component6()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;->userId Ljava/lang/String;
    return-object v0
.end method

.method public final component7()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;->location Ljava/lang/String;
    return-object v0
.end method

.method public final component8()com.bytedance.trae.conversation.debug.VoiceDiscussionDebugLogInfo
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;->voiceDiscussion Lcom/bytedance/trae/conversation/debug/VoiceDiscussionDebugLogInfo;
    return-object v0
.end method

.method public final copy(long  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.conversation.debug.VoiceDiscussionDebugLogInfo)com.bytedance.trae.conversation.debug.ConversationDebugLogInfo
    .registers 21
    # ins_size=10
    const-string v0, "messageId"
    move-object v4, v14
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, replyToMessageId
    move-object v5, v15
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, sessionId
    move-object/from16 v6, v16
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "deviceId"
    move-object/from16 v7, v17
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, userId
    move-object/from16 v8, v18
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "location"
    move-object/from16 v9, v19
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;
    move-object v1, v0
    move-wide v2, v12
    move-object/from16 v10, v20
    invoke-direct/range v1 ... v10, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;-><init>(J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/debug/VoiceDiscussionDebugLogInfo;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 1
    if-ne v7, v8, +003h
    return v0
    instance-of v1, v8, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v8, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;
    iget-wide v3, v7, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;->createdAt J
    iget-wide v5, v8, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;->createdAt J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;->messageId Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;->messageId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;->replyToMessageId Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;->replyToMessageId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;->sessionId Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;->sessionId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;->deviceId Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;->deviceId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;->userId Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;->userId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;->location Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;->location Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;->voiceDiscussion Lcom/bytedance/trae/conversation/debug/VoiceDiscussionDebugLogInfo;
    iget-object v8, v8, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;->voiceDiscussion Lcom/bytedance/trae/conversation/debug/VoiceDiscussionDebugLogInfo;
    invoke-static v1, v8, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v8
    if-nez v8, +003h
    return v2
    return v0
.end method

.method public final getCreatedAt()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;->createdAt J
    return-wide v0
.end method

.method public final getDeviceId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;->deviceId Ljava/lang/String;
    return-object v0
.end method

.method public final getLocation()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;->location Ljava/lang/String;
    return-object v0
.end method

.method public final getMessageId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;->messageId Ljava/lang/String;
    return-object v0
.end method

.method public final getReplyToMessageId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;->replyToMessageId Ljava/lang/String;
    return-object v0
.end method

.method public final getSessionId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;->sessionId Ljava/lang/String;
    return-object v0
.end method

.method public final getUserId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;->userId Ljava/lang/String;
    return-object v0
.end method

.method public final getVoiceDiscussion()com.bytedance.trae.conversation.debug.VoiceDiscussionDebugLogInfo
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;->voiceDiscussion Lcom/bytedance/trae/conversation/debug/VoiceDiscussionDebugLogInfo;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;->createdAt J
    invoke-static v0, v1, Ljava/lang/Long;->hashCode(J)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;->messageId Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;->replyToMessageId Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;->sessionId Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;->deviceId Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;->userId Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;->location Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;->voiceDiscussion Lcom/bytedance/trae/conversation/debug/VoiceDiscussionDebugLogInfo;
    if-nez v1, +004h
    const/4 v1, 0
    goto +5h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/debug/VoiceDiscussionDebugLogInfo;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "ConversationDebugLogInfo(createdAt="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;->createdAt J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", messageId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;->messageId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", replyToMessageId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;->replyToMessageId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", sessionId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;->sessionId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", deviceId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;->deviceId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", userId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;->userId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", location="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;->location Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", voiceDiscussion="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;->voiceDiscussion Lcom/bytedance/trae/conversation/debug/VoiceDiscussionDebugLogInfo;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
