# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;
.super Ljava/lang/Object;
.source "VoiceAttemptMetricsTracker.kt"

.field private final asrCallbackCount:I
.field private final conversationId:Ljava/lang/String;
.field private final hasReceiveVoice:Z
.field private final perfApiRequestEndTimestamp:J
.field private final perfJoinRoomSuccessTimestamp:J
.field private final perfJoinRoomTimestamp:J
.field private final perfPublishStreamTimestamp:J
.field private final perfStartVoiceChatTimestamp:J
.field private final subvMessageCount:I
.field private final voiceReleaseTimestamp:J
.field private final voiceStartTimestamp:J


.method public constructor <init>(java.lang.String  boolean  long  long  long  long  long  long  long  int  int)void
    .registers 22
    # ins_size=19
    move-object v0, v3
    move-object v1, v4
    const-string v2, "conversationId"
    invoke-static v4, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v3, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->conversationId Ljava/lang/String;
    move v1, v5
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->hasReceiveVoice Z
    move-wide v1, v6
    iput-wide v1, v0, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->voiceStartTimestamp J
    move-wide v1, v8
    iput-wide v1, v0, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->voiceReleaseTimestamp J
    move-wide v1, v10
    iput-wide v1, v0, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->perfStartVoiceChatTimestamp J
    move-wide v1, v12
    iput-wide v1, v0, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->perfApiRequestEndTimestamp J
    move-wide v1, v14
    iput-wide v1, v0, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->perfJoinRoomTimestamp J
    move-wide/from16 v1, v16
    iput-wide v1, v0, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->perfJoinRoomSuccessTimestamp J
    move-wide/from16 v1, v18
    iput-wide v1, v0, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->perfPublishStreamTimestamp J
    move/from16 v1, v20
    iput v1, v0, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->subvMessageCount I
    move/from16 v1, v21
    iput v1, v0, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->asrCallbackCount I
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.voice.VoiceAttemptMetricsTracker$SessionSnapshot  java.lang.String  boolean  long  long  long  long  long  long  long  int  int  int  java.lang.Object)com.bytedance.trae.conversation.voice.VoiceAttemptMetricsTracker$SessionSnapshot
    .registers 37
    # ins_size=21
    move-object/from16 v0, v16
    move/from16 v1, v35
    and-int/lit8 v2, v1, 1
    if-eqz v2, +005h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->conversationId Ljava/lang/String;
    goto +3h
    move-object/from16 v2, v17
    and-int/lit8 v3, v1, 2
    if-eqz v3, +005h
    iget-boolean v3, v0, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->hasReceiveVoice Z
    goto +3h
    move/from16 v3, v18
    and-int/lit8 v4, v1, 4
    if-eqz v4, +005h
    iget-wide v4, v0, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->voiceStartTimestamp J
    goto +3h
    move-wide/from16 v4, v19
    and-int/lit8 v6, v1, 8
    if-eqz v6, +005h
    iget-wide v6, v0, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->voiceReleaseTimestamp J
    goto +3h
    move-wide/from16 v6, v21
    and-int/lit8 v8, v1, 16
    if-eqz v8, +005h
    iget-wide v8, v0, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->perfStartVoiceChatTimestamp J
    goto +3h
    move-wide/from16 v8, v23
    and-int/lit8 v10, v1, 32
    if-eqz v10, +005h
    iget-wide v10, v0, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->perfApiRequestEndTimestamp J
    goto +3h
    move-wide/from16 v10, v25
    and-int/lit8 v12, v1, 64
    if-eqz v12, +005h
    iget-wide v12, v0, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->perfJoinRoomTimestamp J
    goto +3h
    move-wide/from16 v12, v27
    and-int/lit16 v14, v1, 128
    if-eqz v14, +005h
    iget-wide v14, v0, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->perfJoinRoomSuccessTimestamp J
    goto +3h
    move-wide/from16 v14, v29
    move-wide/from16 v29, v14
    and-int/lit16 v14, v1, 256
    if-eqz v14, +005h
    iget-wide v14, v0, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->perfPublishStreamTimestamp J
    goto +3h
    move-wide/from16 v14, v31
    move-wide/from16 v31, v14
    and-int/lit16 v14, v1, 512
    if-eqz v14, +005h
    iget v14, v0, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->subvMessageCount I
    goto +3h
    move/from16 v14, v33
    and-int/lit16 v1, v1, 1024
    if-eqz v1, +005h
    iget v1, v0, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->asrCallbackCount I
    goto +3h
    move/from16 v1, v34
    move-object/from16 v17, v2
    move/from16 v18, v3
    move-wide/from16 v19, v4
    move-wide/from16 v21, v6
    move-wide/from16 v23, v8
    move-wide/from16 v25, v10
    move-wide/from16 v27, v12
    move/from16 v33, v14
    move/from16 v34, v1
    invoke-virtual/range v16 ... v34, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->copy(Ljava/lang/String; Z J J J J J J J I I)Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->conversationId Ljava/lang/String;
    return-object v0
.end method

.method public final component10()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->subvMessageCount I
    return v0
.end method

.method public final component11()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->asrCallbackCount I
    return v0
.end method

.method public final component2()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->hasReceiveVoice Z
    return v0
.end method

.method public final component3()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->voiceStartTimestamp J
    return-wide v0
.end method

.method public final component4()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->voiceReleaseTimestamp J
    return-wide v0
.end method

.method public final component5()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->perfStartVoiceChatTimestamp J
    return-wide v0
.end method

.method public final component6()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->perfApiRequestEndTimestamp J
    return-wide v0
.end method

.method public final component7()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->perfJoinRoomTimestamp J
    return-wide v0
.end method

.method public final component8()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->perfJoinRoomSuccessTimestamp J
    return-wide v0
.end method

.method public final component9()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->perfPublishStreamTimestamp J
    return-wide v0
.end method

.method public final copy(java.lang.String  boolean  long  long  long  long  long  long  long  int  int)com.bytedance.trae.conversation.voice.VoiceAttemptMetricsTracker$SessionSnapshot
    .registers 40
    # ins_size=19
    move-object/from16 v1, v22
    move/from16 v2, v23
    move-wide/from16 v3, v24
    move-wide/from16 v5, v26
    move-wide/from16 v7, v28
    move-wide/from16 v9, v30
    move-wide/from16 v11, v32
    move-wide/from16 v13, v34
    move-wide/from16 v15, v36
    move/from16 v17, v38
    move/from16 v18, v39
    const-string v0, "conversationId"
    move-object/from16 v19, v1
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v20, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;
    move-object/from16 v0, v20
    invoke-direct/range v0 ... v18, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;-><init>(Ljava/lang/String; Z J J J J J J J I I)V
    return-object v20
.end method

.method public equals(java.lang.Object)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 1
    if-ne v7, v8, +003h
    return v0
    instance-of v1, v8, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v8, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;
    iget-object v1, v7, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->conversationId Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->conversationId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-boolean v1, v7, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->hasReceiveVoice Z
    iget-boolean v3, v8, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->hasReceiveVoice Z
    if-eq v1, v3, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->voiceStartTimestamp J
    iget-wide v5, v8, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->voiceStartTimestamp J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->voiceReleaseTimestamp J
    iget-wide v5, v8, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->voiceReleaseTimestamp J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->perfStartVoiceChatTimestamp J
    iget-wide v5, v8, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->perfStartVoiceChatTimestamp J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->perfApiRequestEndTimestamp J
    iget-wide v5, v8, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->perfApiRequestEndTimestamp J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->perfJoinRoomTimestamp J
    iget-wide v5, v8, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->perfJoinRoomTimestamp J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->perfJoinRoomSuccessTimestamp J
    iget-wide v5, v8, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->perfJoinRoomSuccessTimestamp J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->perfPublishStreamTimestamp J
    iget-wide v5, v8, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->perfPublishStreamTimestamp J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->subvMessageCount I
    iget v3, v8, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->subvMessageCount I
    if-eq v1, v3, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->asrCallbackCount I
    iget v8, v8, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->asrCallbackCount I
    if-eq v1, v8, +003h
    return v2
    return v0
.end method

.method public final getAsrCallbackCount()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->asrCallbackCount I
    return v0
.end method

.method public final getConversationId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->conversationId Ljava/lang/String;
    return-object v0
.end method

.method public final getHasReceiveVoice()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->hasReceiveVoice Z
    return v0
.end method

.method public final getPerfApiRequestEndTimestamp()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->perfApiRequestEndTimestamp J
    return-wide v0
.end method

.method public final getPerfJoinRoomSuccessTimestamp()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->perfJoinRoomSuccessTimestamp J
    return-wide v0
.end method

.method public final getPerfJoinRoomTimestamp()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->perfJoinRoomTimestamp J
    return-wide v0
.end method

.method public final getPerfPublishStreamTimestamp()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->perfPublishStreamTimestamp J
    return-wide v0
.end method

.method public final getPerfStartVoiceChatTimestamp()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->perfStartVoiceChatTimestamp J
    return-wide v0
.end method

.method public final getSubvMessageCount()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->subvMessageCount I
    return v0
.end method

.method public final getVoiceReleaseTimestamp()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->voiceReleaseTimestamp J
    return-wide v0
.end method

.method public final getVoiceStartTimestamp()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->voiceStartTimestamp J
    return-wide v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->conversationId Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v3, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->hasReceiveVoice Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->voiceStartTimestamp J
    invoke-static v1, v2, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->voiceReleaseTimestamp J
    invoke-static v1, v2, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->perfStartVoiceChatTimestamp J
    invoke-static v1, v2, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->perfApiRequestEndTimestamp J
    invoke-static v1, v2, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->perfJoinRoomTimestamp J
    invoke-static v1, v2, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->perfJoinRoomSuccessTimestamp J
    invoke-static v1, v2, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->perfPublishStreamTimestamp J
    invoke-static v1, v2, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->subvMessageCount I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->asrCallbackCount I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 5
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "SessionSnapshot(conversationId="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v4, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->conversationId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", hasReceiveVoice="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-boolean v2, v4, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->hasReceiveVoice Z
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", voiceStartTimestamp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->voiceStartTimestamp J
    invoke-virtual v1, v2, v3, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", voiceReleaseTimestamp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->voiceReleaseTimestamp J
    invoke-virtual v1, v2, v3, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", perfStartVoiceChatTimestamp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->perfStartVoiceChatTimestamp J
    invoke-virtual v1, v2, v3, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", perfApiRequestEndTimestamp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->perfApiRequestEndTimestamp J
    invoke-virtual v1, v2, v3, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", perfJoinRoomTimestamp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->perfJoinRoomTimestamp J
    invoke-virtual v1, v2, v3, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", perfJoinRoomSuccessTimestamp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->perfJoinRoomSuccessTimestamp J
    invoke-virtual v1, v2, v3, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", perfPublishStreamTimestamp="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->perfPublishStreamTimestamp J
    invoke-virtual v1, v2, v3, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", subvMessageCount="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->subvMessageCount I
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", asrCallbackCount="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v4, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$SessionSnapshot;->asrCallbackCount I
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    const/16 v2, 41
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
