# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/voice/network/GetVoiceChatHistoryData;
.super Ljava/lang/Object;
.source "VoiceChatModels.kt"

.field private final agentType:Ljava/lang/String;
.field private final chatSessionId:Ljava/lang/String;
.field private final conversationId:Ljava/lang/String;
.field private final createdAt:J
.field private final historyContext:Ljava/util/List;
.field private final historyId:Ljava/lang/String;
.field private final sessionId:Ljava/lang/String;


.method public constructor <init>()void
    .registers 12
    # ins_size=1
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const-wide/16 v6, 0
    const/4 v8, 0
    const/16 v9, 127
    const/4 v10, 0
    move-object v0, v11
    invoke-direct/range v0 ... v10, Lcom/bytedance/trae/conversation/voice/network/GetVoiceChatHistoryData;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Ljava/util/List; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  long  java.util.List)void
    .registers 9
    # ins_size=9
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/voice/network/GetVoiceChatHistoryData;->historyId Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/voice/network/GetVoiceChatHistoryData;->conversationId Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/voice/network/GetVoiceChatHistoryData;->sessionId Ljava/lang/String;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/voice/network/GetVoiceChatHistoryData;->chatSessionId Ljava/lang/String;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/voice/network/GetVoiceChatHistoryData;->agentType Ljava/lang/String;
    iput-wide v6, v0, Lcom/bytedance/trae/conversation/voice/network/GetVoiceChatHistoryData;->createdAt J
    iput-object v8, v0, Lcom/bytedance/trae/conversation/voice/network/GetVoiceChatHistoryData;->historyContext Ljava/util/List;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  long  java.util.List  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 20
    # ins_size=11
    and-int/lit8 v0, v18, 1
    const/4 v1, 0
    if-eqz v0, +004h
    move-object v0, v1
    goto +2h
    move-object v0, v10
    and-int/lit8 v2, v18, 2
    if-eqz v2, +004h
    move-object v2, v1
    goto +2h
    move-object v2, v11
    and-int/lit8 v3, v18, 4
    if-eqz v3, +004h
    move-object v3, v1
    goto +2h
    move-object v3, v12
    and-int/lit8 v4, v18, 8
    if-eqz v4, +004h
    move-object v4, v1
    goto +2h
    move-object v4, v13
    and-int/lit8 v5, v18, 16
    if-eqz v5, +004h
    move-object v5, v1
    goto +2h
    move-object v5, v14
    and-int/lit8 v6, v18, 32
    if-eqz v6, +005h
    const-wide/16 v6, 0
    goto +2h
    move-wide v6, v15
    and-int/lit8 v8, v18, 64
    if-eqz v8, +003h
    goto +3h
    move-object/from16 v1, v17
    move-object v10, v9
    move-object v11, v0
    move-object v12, v2
    move-object v13, v3
    move-object v14, v4
    move-object v15, v5
    move-wide/from16 v16, v6
    move-object/from16 v18, v1
    invoke-direct/range v10 ... v18, Lcom/bytedance/trae/conversation/voice/network/GetVoiceChatHistoryData;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Ljava/util/List;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.voice.network.GetVoiceChatHistoryData  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  long  java.util.List  int  java.lang.Object)com.bytedance.trae.conversation.voice.network.GetVoiceChatHistoryData
    .registers 20
    # ins_size=11
    move-object v0, v9
    and-int/lit8 v1, v18, 1
    if-eqz v1, +005h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/voice/network/GetVoiceChatHistoryData;->historyId Ljava/lang/String;
    goto +2h
    move-object v1, v10
    and-int/lit8 v2, v18, 2
    if-eqz v2, +005h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/voice/network/GetVoiceChatHistoryData;->conversationId Ljava/lang/String;
    goto +2h
    move-object v2, v11
    and-int/lit8 v3, v18, 4
    if-eqz v3, +005h
    iget-object v3, v0, Lcom/bytedance/trae/conversation/voice/network/GetVoiceChatHistoryData;->sessionId Ljava/lang/String;
    goto +2h
    move-object v3, v12
    and-int/lit8 v4, v18, 8
    if-eqz v4, +005h
    iget-object v4, v0, Lcom/bytedance/trae/conversation/voice/network/GetVoiceChatHistoryData;->chatSessionId Ljava/lang/String;
    goto +2h
    move-object v4, v13
    and-int/lit8 v5, v18, 16
    if-eqz v5, +005h
    iget-object v5, v0, Lcom/bytedance/trae/conversation/voice/network/GetVoiceChatHistoryData;->agentType Ljava/lang/String;
    goto +2h
    move-object v5, v14
    and-int/lit8 v6, v18, 32
    if-eqz v6, +005h
    iget-wide v6, v0, Lcom/bytedance/trae/conversation/voice/network/GetVoiceChatHistoryData;->createdAt J
    goto +2h
    move-wide v6, v15
    and-int/lit8 v8, v18, 64
    if-eqz v8, +005h
    iget-object v8, v0, Lcom/bytedance/trae/conversation/voice/network/GetVoiceChatHistoryData;->historyContext Ljava/util/List;
    goto +3h
    move-object/from16 v8, v17
    move-object v10, v1
    move-object v11, v2
    move-object v12, v3
    move-object v13, v4
    move-object v14, v5
    move-wide v15, v6
    move-object/from16 v17, v8
    invoke-virtual/range v9 ... v17, Lcom/bytedance/trae/conversation/voice/network/GetVoiceChatHistoryData;->copy(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Ljava/util/List;)Lcom/bytedance/trae/conversation/voice/network/GetVoiceChatHistoryData;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/network/GetVoiceChatHistoryData;->historyId Ljava/lang/String;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/network/GetVoiceChatHistoryData;->conversationId Ljava/lang/String;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/network/GetVoiceChatHistoryData;->sessionId Ljava/lang/String;
    return-object v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/network/GetVoiceChatHistoryData;->chatSessionId Ljava/lang/String;
    return-object v0
.end method

.method public final component5()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/network/GetVoiceChatHistoryData;->agentType Ljava/lang/String;
    return-object v0
.end method

.method public final component6()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/voice/network/GetVoiceChatHistoryData;->createdAt J
    return-wide v0
.end method

.method public final component7()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/network/GetVoiceChatHistoryData;->historyContext Ljava/util/List;
    return-object v0
.end method

.method public final copy(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  long  java.util.List)com.bytedance.trae.conversation.voice.network.GetVoiceChatHistoryData
    .registers 19
    # ins_size=9
    new-instance v9, Lcom/bytedance/trae/conversation/voice/network/GetVoiceChatHistoryData;
    move-object v0, v9
    move-object v1, v11
    move-object v2, v12
    move-object v3, v13
    move-object v4, v14
    move-object v5, v15
    move-wide/from16 v6, v16
    move-object/from16 v8, v18
    invoke-direct/range v0 ... v8, Lcom/bytedance/trae/conversation/voice/network/GetVoiceChatHistoryData;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Ljava/util/List;)V
    return-object v9
.end method

.method public equals(java.lang.Object)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 1
    if-ne v7, v8, +003h
    return v0
    instance-of v1, v8, Lcom/bytedance/trae/conversation/voice/network/GetVoiceChatHistoryData;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v8, Lcom/bytedance/trae/conversation/voice/network/GetVoiceChatHistoryData;
    iget-object v1, v7, Lcom/bytedance/trae/conversation/voice/network/GetVoiceChatHistoryData;->historyId Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/voice/network/GetVoiceChatHistoryData;->historyId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/voice/network/GetVoiceChatHistoryData;->conversationId Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/voice/network/GetVoiceChatHistoryData;->conversationId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/voice/network/GetVoiceChatHistoryData;->sessionId Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/voice/network/GetVoiceChatHistoryData;->sessionId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/voice/network/GetVoiceChatHistoryData;->chatSessionId Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/voice/network/GetVoiceChatHistoryData;->chatSessionId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/voice/network/GetVoiceChatHistoryData;->agentType Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/voice/network/GetVoiceChatHistoryData;->agentType Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/conversation/voice/network/GetVoiceChatHistoryData;->createdAt J
    iget-wide v5, v8, Lcom/bytedance/trae/conversation/voice/network/GetVoiceChatHistoryData;->createdAt J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/voice/network/GetVoiceChatHistoryData;->historyContext Ljava/util/List;
    iget-object v8, v8, Lcom/bytedance/trae/conversation/voice/network/GetVoiceChatHistoryData;->historyContext Ljava/util/List;
    invoke-static v1, v8, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v8
    if-nez v8, +003h
    return v2
    return v0
.end method

.method public final getAgentType()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/network/GetVoiceChatHistoryData;->agentType Ljava/lang/String;
    return-object v0
.end method

.method public final getChatSessionId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/network/GetVoiceChatHistoryData;->chatSessionId Ljava/lang/String;
    return-object v0
.end method

.method public final getConversationId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/network/GetVoiceChatHistoryData;->conversationId Ljava/lang/String;
    return-object v0
.end method

.method public final getCreatedAt()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/voice/network/GetVoiceChatHistoryData;->createdAt J
    return-wide v0
.end method

.method public final getHistoryContext()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/network/GetVoiceChatHistoryData;->historyContext Ljava/util/List;
    return-object v0
.end method

.method public final getHistoryId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/network/GetVoiceChatHistoryData;->historyId Ljava/lang/String;
    return-object v0
.end method

.method public final getSessionId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/network/GetVoiceChatHistoryData;->sessionId Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/conversation/voice/network/GetVoiceChatHistoryData;->historyId Ljava/lang/String;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v2, v4, Lcom/bytedance/trae/conversation/voice/network/GetVoiceChatHistoryData;->conversationId Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v4, Lcom/bytedance/trae/conversation/voice/network/GetVoiceChatHistoryData;->sessionId Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v4, Lcom/bytedance/trae/conversation/voice/network/GetVoiceChatHistoryData;->chatSessionId Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v4, Lcom/bytedance/trae/conversation/voice/network/GetVoiceChatHistoryData;->agentType Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-wide v2, v4, Lcom/bytedance/trae/conversation/voice/network/GetVoiceChatHistoryData;->createdAt J
    invoke-static v2, v3, Ljava/lang/Long;->hashCode(J)I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v4, Lcom/bytedance/trae/conversation/voice/network/GetVoiceChatHistoryData;->historyContext Ljava/util/List;
    if-nez v2, +003h
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "GetVoiceChatHistoryData(historyId="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v3, Lcom/bytedance/trae/conversation/voice/network/GetVoiceChatHistoryData;->historyId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", conversationId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/voice/network/GetVoiceChatHistoryData;->conversationId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", sessionId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/voice/network/GetVoiceChatHistoryData;->sessionId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", chatSessionId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/voice/network/GetVoiceChatHistoryData;->chatSessionId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", agentType="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/voice/network/GetVoiceChatHistoryData;->agentType Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", createdAt="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/voice/network/GetVoiceChatHistoryData;->createdAt J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", historyContext="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/voice/network/GetVoiceChatHistoryData;->historyContext Ljava/util/List;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
