# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ProcessEnd;
.super Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
.source "AgentContentBlock.kt"

.field private final autoCollapse:Z
.field private final durationMs:J
.field private final isCompleted:Z


.method public constructor <init>(long  boolean  boolean)void
    .registers 6
    # ins_size=5
    const/4 v0, 0
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput-wide v2, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ProcessEnd;->durationMs J
    iput-boolean v4, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ProcessEnd;->isCompleted Z
    iput-boolean v5, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ProcessEnd;->autoCollapse Z
    return-void 
.end method

.method public synthetic constructor <init>(long  boolean  boolean  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 7
    # ins_size=7
    and-int/lit8 v5, v5, 4
    if-eqz v5, +003h
    const/4 v4, 1
    invoke-direct v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ProcessEnd;-><init>(J Z Z)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.chat.block.AgentContentBlock$ProcessEnd  long  boolean  boolean  int  java.lang.Object)com.bytedance.trae.conversation.chat.block.AgentContentBlock$ProcessEnd
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 1
    if-eqz v6, +004h
    iget-wide v1, v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ProcessEnd;->durationMs J
    and-int/lit8 v6, v5, 2
    if-eqz v6, +004h
    iget-boolean v3, v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ProcessEnd;->isCompleted Z
    and-int/lit8 v5, v5, 4
    if-eqz v5, +004h
    iget-boolean v4, v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ProcessEnd;->autoCollapse Z
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ProcessEnd;->copy(J Z Z)Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ProcessEnd;
    move-result-object v0
    return-object v0
.end method

.method public final component1()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ProcessEnd;->durationMs J
    return-wide v0
.end method

.method public final component2()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ProcessEnd;->isCompleted Z
    return v0
.end method

.method public final component3()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ProcessEnd;->autoCollapse Z
    return v0
.end method

.method public final copy(long  boolean  boolean)com.bytedance.trae.conversation.chat.block.AgentContentBlock$ProcessEnd
    .registers 6
    # ins_size=5
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ProcessEnd;
    invoke-direct v0, v2, v3, v4, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ProcessEnd;-><init>(J Z Z)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 1
    if-ne v7, v8, +003h
    return v0
    instance-of v1, v8, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ProcessEnd;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v8, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ProcessEnd;
    iget-wide v3, v7, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ProcessEnd;->durationMs J
    iget-wide v5, v8, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ProcessEnd;->durationMs J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-boolean v1, v7, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ProcessEnd;->isCompleted Z
    iget-boolean v3, v8, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ProcessEnd;->isCompleted Z
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v7, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ProcessEnd;->autoCollapse Z
    iget-boolean v8, v8, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ProcessEnd;->autoCollapse Z
    if-eq v1, v8, +003h
    return v2
    return v0
.end method

.method public final getAutoCollapse()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ProcessEnd;->autoCollapse Z
    return v0
.end method

.method public final getDurationMs()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ProcessEnd;->durationMs J
    return-wide v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ProcessEnd;->durationMs J
    invoke-static v0, v1, Ljava/lang/Long;->hashCode(J)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ProcessEnd;->isCompleted Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ProcessEnd;->autoCollapse Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public final isCompleted()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ProcessEnd;->isCompleted Z
    return v0
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "ProcessEnd(durationMs="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ProcessEnd;->durationMs J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", isCompleted="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ProcessEnd;->isCompleted Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", autoCollapse="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ProcessEnd;->autoCollapse Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
