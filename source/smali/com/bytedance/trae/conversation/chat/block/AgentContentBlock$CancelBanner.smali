# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$CancelBanner;
.super Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
.source "AgentContentBlock.kt"

.field private final isUserCanceled:Z


.method public constructor <init>(boolean)void
    .registers 3
    # ins_size=2
    const/4 v0, 0
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput-boolean v2, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$CancelBanner;->isUserCanceled Z
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.chat.block.AgentContentBlock$CancelBanner  boolean  int  java.lang.Object)com.bytedance.trae.conversation.chat.block.AgentContentBlock$CancelBanner
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +004h
    iget-boolean v1, v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$CancelBanner;->isUserCanceled Z
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$CancelBanner;->copy(Z)Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$CancelBanner;
    move-result-object v0
    return-object v0
.end method

.method public final component1()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$CancelBanner;->isUserCanceled Z
    return v0
.end method

.method public final copy(boolean)com.bytedance.trae.conversation.chat.block.AgentContentBlock$CancelBanner
    .registers 3
    # ins_size=2
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$CancelBanner;
    invoke-direct v0, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$CancelBanner;-><init>(Z)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 5
    # ins_size=2
    const/4 v0, 1
    if-ne v3, v4, +003h
    return v0
    instance-of v1, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$CancelBanner;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$CancelBanner;
    iget-boolean v1, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$CancelBanner;->isUserCanceled Z
    iget-boolean v4, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$CancelBanner;->isUserCanceled Z
    if-eq v1, v4, +003h
    return v2
    return v0
.end method

.method public hashCode()int
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$CancelBanner;->isUserCanceled Z
    invoke-static v0, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v0
    return v0
.end method

.method public final isUserCanceled()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$CancelBanner;->isUserCanceled Z
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "CancelBanner(isUserCanceled="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$CancelBanner;->isUserCanceled Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
