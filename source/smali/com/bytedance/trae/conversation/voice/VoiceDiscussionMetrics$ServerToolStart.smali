# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics$ServerToolStart;
.super Ljava/lang/Object;
.source "VoiceDiscussionMetrics.kt"

.field private final startMs:J
.field private final toolName:Ljava/lang/String;


.method public constructor <init>(long  java.lang.String)void
    .registers 5
    # ins_size=4
    const-string/jumbo v0, toolName
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-wide v2, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics$ServerToolStart;->startMs J
    iput-object v4, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics$ServerToolStart;->toolName Ljava/lang/String;
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.voice.VoiceDiscussionMetrics$ServerToolStart  long  java.lang.String  int  java.lang.Object)com.bytedance.trae.conversation.voice.VoiceDiscussionMetrics$ServerToolStart
    .registers 6
    # ins_size=6
    and-int/lit8 v5, v4, 1
    if-eqz v5, +004h
    iget-wide v1, v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics$ServerToolStart;->startMs J
    and-int/lit8 v4, v4, 2
    if-eqz v4, +004h
    iget-object v3, v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics$ServerToolStart;->toolName Ljava/lang/String;
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics$ServerToolStart;->copy(J Ljava/lang/String;)Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics$ServerToolStart;
    move-result-object v0
    return-object v0
.end method

.method public final component1()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics$ServerToolStart;->startMs J
    return-wide v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics$ServerToolStart;->toolName Ljava/lang/String;
    return-object v0
.end method

.method public final copy(long  java.lang.String)com.bytedance.trae.conversation.voice.VoiceDiscussionMetrics$ServerToolStart
    .registers 5
    # ins_size=4
    const-string/jumbo v0, toolName
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics$ServerToolStart;
    invoke-direct v0, v2, v3, v4, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics$ServerToolStart;-><init>(J Ljava/lang/String;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 1
    if-ne v7, v8, +003h
    return v0
    instance-of v1, v8, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics$ServerToolStart;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v8, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics$ServerToolStart;
    iget-wide v3, v7, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics$ServerToolStart;->startMs J
    iget-wide v5, v8, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics$ServerToolStart;->startMs J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics$ServerToolStart;->toolName Ljava/lang/String;
    iget-object v8, v8, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics$ServerToolStart;->toolName Ljava/lang/String;
    invoke-static v1, v8, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v8
    if-nez v8, +003h
    return v2
    return v0
.end method

.method public final getStartMs()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics$ServerToolStart;->startMs J
    return-wide v0
.end method

.method public final getToolName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics$ServerToolStart;->toolName Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics$ServerToolStart;->startMs J
    invoke-static v0, v1, Ljava/lang/Long;->hashCode(J)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics$ServerToolStart;->toolName Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "ServerToolStart(startMs="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics$ServerToolStart;->startMs J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", toolName="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/voice/VoiceDiscussionMetrics$ServerToolStart;->toolName Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
