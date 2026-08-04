# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/voice/network/VoiceChatHistoryEntry;
.super Ljava/lang/Object;
.source "VoiceChatModels.kt"

.field private final agentType:Ljava/lang/String;
.field private final chatSessionId:Ljava/lang/String;
.field private final content:Ljava/lang/String;
.field private final createdAt:J
.field private final role:Ljava/lang/String;
.field private final taskStatus:Ljava/lang/String;


.method public constructor <init>()void
    .registers 11
    # ins_size=1
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const-wide/16 v4, 0
    const/4 v6, 0
    const/4 v7, 0
    const/16 v8, 63
    const/4 v9, 0
    move-object v0, v10
    invoke-direct/range v0 ... v9, Lcom/bytedance/trae/conversation/voice/network/VoiceChatHistoryEntry;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Ljava/lang/String; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(java.lang.String  java.lang.String  java.lang.String  long  java.lang.String  java.lang.String)void
    .registers 8
    # ins_size=8
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/voice/network/VoiceChatHistoryEntry;->role Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/voice/network/VoiceChatHistoryEntry;->content Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/voice/network/VoiceChatHistoryEntry;->agentType Ljava/lang/String;
    iput-wide v4, v0, Lcom/bytedance/trae/conversation/voice/network/VoiceChatHistoryEntry;->createdAt J
    iput-object v6, v0, Lcom/bytedance/trae/conversation/voice/network/VoiceChatHistoryEntry;->chatSessionId Ljava/lang/String;
    iput-object v7, v0, Lcom/bytedance/trae/conversation/voice/network/VoiceChatHistoryEntry;->taskStatus Ljava/lang/String;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  java.lang.String  java.lang.String  long  java.lang.String  java.lang.String  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 16
    # ins_size=10
    and-int/lit8 v15, v14, 1
    const/4 v0, 0
    if-eqz v15, +004h
    move-object v15, v0
    goto +2h
    move-object v15, v7
    and-int/lit8 v7, v14, 2
    if-eqz v7, +004h
    move-object v1, v0
    goto +2h
    move-object v1, v8
    and-int/lit8 v7, v14, 4
    if-eqz v7, +004h
    move-object v2, v0
    goto +2h
    move-object v2, v9
    and-int/lit8 v7, v14, 8
    if-eqz v7, +004h
    const-wide/16 v10, 0
    move-wide v3, v10
    and-int/lit8 v7, v14, 16
    if-eqz v7, +004h
    move-object v5, v0
    goto +2h
    move-object v5, v12
    and-int/lit8 v7, v14, 32
    if-eqz v7, +004h
    move-object v14, v0
    goto +2h
    move-object v14, v13
    move-object v7, v6
    move-object v8, v15
    move-object v9, v1
    move-object v10, v2
    move-wide v11, v3
    move-object v13, v5
    invoke-direct/range v7 ... v14, Lcom/bytedance/trae/conversation/voice/network/VoiceChatHistoryEntry;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.voice.network.VoiceChatHistoryEntry  java.lang.String  java.lang.String  java.lang.String  long  java.lang.String  java.lang.String  int  java.lang.Object)com.bytedance.trae.conversation.voice.network.VoiceChatHistoryEntry
    .registers 15
    # ins_size=10
    and-int/lit8 v14, v13, 1
    if-eqz v14, +004h
    iget-object v6, v5, Lcom/bytedance/trae/conversation/voice/network/VoiceChatHistoryEntry;->role Ljava/lang/String;
    and-int/lit8 v14, v13, 2
    if-eqz v14, +004h
    iget-object v7, v5, Lcom/bytedance/trae/conversation/voice/network/VoiceChatHistoryEntry;->content Ljava/lang/String;
    move-object v14, v7
    and-int/lit8 v7, v13, 4
    if-eqz v7, +004h
    iget-object v8, v5, Lcom/bytedance/trae/conversation/voice/network/VoiceChatHistoryEntry;->agentType Ljava/lang/String;
    move-object v0, v8
    and-int/lit8 v7, v13, 8
    if-eqz v7, +004h
    iget-wide v9, v5, Lcom/bytedance/trae/conversation/voice/network/VoiceChatHistoryEntry;->createdAt J
    move-wide v1, v9
    and-int/lit8 v7, v13, 16
    if-eqz v7, +004h
    iget-object v11, v5, Lcom/bytedance/trae/conversation/voice/network/VoiceChatHistoryEntry;->chatSessionId Ljava/lang/String;
    move-object v3, v11
    and-int/lit8 v7, v13, 32
    if-eqz v7, +004h
    iget-object v12, v5, Lcom/bytedance/trae/conversation/voice/network/VoiceChatHistoryEntry;->taskStatus Ljava/lang/String;
    move-object v4, v12
    move-object v7, v5
    move-object v8, v6
    move-object v9, v14
    move-object v10, v0
    move-wide v11, v1
    move-object v13, v3
    move-object v14, v4
    invoke-virtual/range v7 ... v14, Lcom/bytedance/trae/conversation/voice/network/VoiceChatHistoryEntry;->copy(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/trae/conversation/voice/network/VoiceChatHistoryEntry;
    move-result-object v5
    return-object v5
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/network/VoiceChatHistoryEntry;->role Ljava/lang/String;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/network/VoiceChatHistoryEntry;->content Ljava/lang/String;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/network/VoiceChatHistoryEntry;->agentType Ljava/lang/String;
    return-object v0
.end method

.method public final component4()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/voice/network/VoiceChatHistoryEntry;->createdAt J
    return-wide v0
.end method

.method public final component5()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/network/VoiceChatHistoryEntry;->chatSessionId Ljava/lang/String;
    return-object v0
.end method

.method public final component6()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/network/VoiceChatHistoryEntry;->taskStatus Ljava/lang/String;
    return-object v0
.end method

.method public final copy(java.lang.String  java.lang.String  java.lang.String  long  java.lang.String  java.lang.String)com.bytedance.trae.conversation.voice.network.VoiceChatHistoryEntry
    .registers 17
    # ins_size=8
    new-instance v8, Lcom/bytedance/trae/conversation/voice/network/VoiceChatHistoryEntry;
    move-object v0, v8
    move-object v1, v10
    move-object v2, v11
    move-object v3, v12
    move-wide v4, v13
    move-object v6, v15
    move-object/from16 v7, v16
    invoke-direct/range v0 ... v7, Lcom/bytedance/trae/conversation/voice/network/VoiceChatHistoryEntry;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Ljava/lang/String; Ljava/lang/String;)V
    return-object v8
.end method

.method public equals(java.lang.Object)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 1
    if-ne v7, v8, +003h
    return v0
    instance-of v1, v8, Lcom/bytedance/trae/conversation/voice/network/VoiceChatHistoryEntry;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v8, Lcom/bytedance/trae/conversation/voice/network/VoiceChatHistoryEntry;
    iget-object v1, v7, Lcom/bytedance/trae/conversation/voice/network/VoiceChatHistoryEntry;->role Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/voice/network/VoiceChatHistoryEntry;->role Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/voice/network/VoiceChatHistoryEntry;->content Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/voice/network/VoiceChatHistoryEntry;->content Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/voice/network/VoiceChatHistoryEntry;->agentType Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/voice/network/VoiceChatHistoryEntry;->agentType Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/conversation/voice/network/VoiceChatHistoryEntry;->createdAt J
    iget-wide v5, v8, Lcom/bytedance/trae/conversation/voice/network/VoiceChatHistoryEntry;->createdAt J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/voice/network/VoiceChatHistoryEntry;->chatSessionId Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/voice/network/VoiceChatHistoryEntry;->chatSessionId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/voice/network/VoiceChatHistoryEntry;->taskStatus Ljava/lang/String;
    iget-object v8, v8, Lcom/bytedance/trae/conversation/voice/network/VoiceChatHistoryEntry;->taskStatus Ljava/lang/String;
    invoke-static v1, v8, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v8
    if-nez v8, +003h
    return v2
    return v0
.end method

.method public final getAgentType()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/network/VoiceChatHistoryEntry;->agentType Ljava/lang/String;
    return-object v0
.end method

.method public final getChatSessionId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/network/VoiceChatHistoryEntry;->chatSessionId Ljava/lang/String;
    return-object v0
.end method

.method public final getContent()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/network/VoiceChatHistoryEntry;->content Ljava/lang/String;
    return-object v0
.end method

.method public final getCreatedAt()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/voice/network/VoiceChatHistoryEntry;->createdAt J
    return-wide v0
.end method

.method public final getRole()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/network/VoiceChatHistoryEntry;->role Ljava/lang/String;
    return-object v0
.end method

.method public final getTaskStatus()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/network/VoiceChatHistoryEntry;->taskStatus Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/conversation/voice/network/VoiceChatHistoryEntry;->role Ljava/lang/String;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v2, v4, Lcom/bytedance/trae/conversation/voice/network/VoiceChatHistoryEntry;->content Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v4, Lcom/bytedance/trae/conversation/voice/network/VoiceChatHistoryEntry;->agentType Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-wide v2, v4, Lcom/bytedance/trae/conversation/voice/network/VoiceChatHistoryEntry;->createdAt J
    invoke-static v2, v3, Ljava/lang/Long;->hashCode(J)I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v4, Lcom/bytedance/trae/conversation/voice/network/VoiceChatHistoryEntry;->chatSessionId Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v4, Lcom/bytedance/trae/conversation/voice/network/VoiceChatHistoryEntry;->taskStatus Ljava/lang/String;
    if-nez v2, +003h
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "VoiceChatHistoryEntry(role="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v3, Lcom/bytedance/trae/conversation/voice/network/VoiceChatHistoryEntry;->role Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", content="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/voice/network/VoiceChatHistoryEntry;->content Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", agentType="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/voice/network/VoiceChatHistoryEntry;->agentType Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", createdAt="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/voice/network/VoiceChatHistoryEntry;->createdAt J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", chatSessionId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/voice/network/VoiceChatHistoryEntry;->chatSessionId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", taskStatus="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/voice/network/VoiceChatHistoryEntry;->taskStatus Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
