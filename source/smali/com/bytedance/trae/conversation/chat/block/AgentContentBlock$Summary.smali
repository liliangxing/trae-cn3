# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Summary;
.super Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
.source "AgentContentBlock.kt"

.field private final content:Ljava/lang/String;
.field private final finished:Z
.field private final trackingId:Ljava/lang/String;
.field private final webReferences:Ljava/util/List;


.method public constructor <init>(java.lang.String  boolean  java.lang.String  java.util.List)void
    .registers 6
    # ins_size=5
    const-string v0, "content"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 0
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Summary;->content Ljava/lang/String;
    iput-boolean v3, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Summary;->finished Z
    iput-object v4, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Summary;->trackingId Ljava/lang/String;
    iput-object v5, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Summary;->webReferences Ljava/util/List;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  boolean  java.lang.String  java.util.List  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 8
    # ins_size=7
    and-int/lit8 v7, v6, 2
    if-eqz v7, +003h
    const/4 v3, 1
    and-int/lit8 v7, v6, 4
    const/4 v0, 0
    if-eqz v7, +003h
    move-object v4, v0
    and-int/lit8 v6, v6, 8
    if-eqz v6, +003h
    move-object v5, v0
    invoke-direct v1, v2, v3, v4, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Summary;-><init>(Ljava/lang/String; Z Ljava/lang/String; Ljava/util/List;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.chat.block.AgentContentBlock$Summary  java.lang.String  boolean  java.lang.String  java.util.List  int  java.lang.Object)com.bytedance.trae.conversation.chat.block.AgentContentBlock$Summary
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 1
    if-eqz v6, +004h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Summary;->content Ljava/lang/String;
    and-int/lit8 v6, v5, 2
    if-eqz v6, +004h
    iget-boolean v2, v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Summary;->finished Z
    and-int/lit8 v6, v5, 4
    if-eqz v6, +004h
    iget-object v3, v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Summary;->trackingId Ljava/lang/String;
    and-int/lit8 v5, v5, 8
    if-eqz v5, +004h
    iget-object v4, v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Summary;->webReferences Ljava/util/List;
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Summary;->copy(Ljava/lang/String; Z Ljava/lang/String; Ljava/util/List;)Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Summary;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Summary;->content Ljava/lang/String;
    return-object v0
.end method

.method public final component2()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Summary;->finished Z
    return v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Summary;->trackingId Ljava/lang/String;
    return-object v0
.end method

.method public final component4()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Summary;->webReferences Ljava/util/List;
    return-object v0
.end method

.method public final copy(java.lang.String  boolean  java.lang.String  java.util.List)com.bytedance.trae.conversation.chat.block.AgentContentBlock$Summary
    .registers 6
    # ins_size=5
    const-string v0, "content"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Summary;
    invoke-direct v0, v2, v3, v4, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Summary;-><init>(Ljava/lang/String; Z Ljava/lang/String; Ljava/util/List;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Summary;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Summary;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Summary;->content Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Summary;->content Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Summary;->finished Z
    iget-boolean v3, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Summary;->finished Z
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Summary;->trackingId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Summary;->trackingId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Summary;->webReferences Ljava/util/List;
    iget-object v5, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Summary;->webReferences Ljava/util/List;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getContent()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Summary;->content Ljava/lang/String;
    return-object v0
.end method

.method public final getFinished()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Summary;->finished Z
    return v0
.end method

.method public final getTrackingId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Summary;->trackingId Ljava/lang/String;
    return-object v0
.end method

.method public final getWebReferences()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Summary;->webReferences Ljava/util/List;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Summary;->content Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Summary;->finished Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Summary;->trackingId Ljava/lang/String;
    const/4 v2, 0
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Summary;->webReferences Ljava/util/List;
    if-nez v1, +003h
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "Summary(content="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Summary;->content Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", finished="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Summary;->finished Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", trackingId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Summary;->trackingId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", webReferences="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Summary;->webReferences Ljava/util/List;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
