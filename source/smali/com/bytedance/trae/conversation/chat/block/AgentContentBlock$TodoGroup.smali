# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;
.super Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
.source "AgentContentBlock.kt"

.field private final children:Ljava/util/List;
.field private final status:Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
.field private final summary:Ljava/lang/String;
.field private final title:Ljava/lang/String;
.field private final todoWriteId:Ljava/lang/String;


.method public constructor <init>(java.lang.String  java.lang.String  java.lang.String  java.util.List  com.bytedance.trae.conversation.chat.block.AgentContentBlock$GroupStatus)void
    .registers 7
    # ins_size=6
    const-string/jumbo v0, todoWriteId
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "children"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, status
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 0
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->todoWriteId Ljava/lang/String;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->title Ljava/lang/String;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->summary Ljava/lang/String;
    iput-object v5, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->children Ljava/util/List;
    iput-object v6, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->status Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  java.lang.String  java.lang.String  java.util.List  com.bytedance.trae.conversation.chat.block.AgentContentBlock$GroupStatus  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 14
    # ins_size=8
    and-int/lit8 v12, v12, 16
    if-eqz v12, +004h
    sget-object v11, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;->RUNNING Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    move-object v5, v11
    move-object v0, v6
    move-object v1, v7
    move-object v2, v8
    move-object v3, v9
    move-object v4, v10
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/util/List; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.chat.block.AgentContentBlock$TodoGroup  java.lang.String  java.lang.String  java.lang.String  java.util.List  com.bytedance.trae.conversation.chat.block.AgentContentBlock$GroupStatus  int  java.lang.Object)com.bytedance.trae.conversation.chat.block.AgentContentBlock$TodoGroup
    .registers 11
    # ins_size=8
    and-int/lit8 v10, v9, 1
    if-eqz v10, +004h
    iget-object v4, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->todoWriteId Ljava/lang/String;
    and-int/lit8 v10, v9, 2
    if-eqz v10, +004h
    iget-object v5, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->title Ljava/lang/String;
    move-object v10, v5
    and-int/lit8 v5, v9, 4
    if-eqz v5, +004h
    iget-object v6, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->summary Ljava/lang/String;
    move-object v0, v6
    and-int/lit8 v5, v9, 8
    if-eqz v5, +004h
    iget-object v7, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->children Ljava/util/List;
    move-object v1, v7
    and-int/lit8 v5, v9, 16
    if-eqz v5, +004h
    iget-object v8, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->status Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    move-object v2, v8
    move-object v5, v3
    move-object v6, v4
    move-object v7, v10
    move-object v8, v0
    move-object v9, v1
    move-object v10, v2
    invoke-virtual/range v5 ... v10, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->copy(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/util/List; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;)Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;
    move-result-object v3
    return-object v3
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->todoWriteId Ljava/lang/String;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->title Ljava/lang/String;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->summary Ljava/lang/String;
    return-object v0
.end method

.method public final component4()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->children Ljava/util/List;
    return-object v0
.end method

.method public final component5()com.bytedance.trae.conversation.chat.block.AgentContentBlock$GroupStatus
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->status Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    return-object v0
.end method

.method public final copy(java.lang.String  java.lang.String  java.lang.String  java.util.List  com.bytedance.trae.conversation.chat.block.AgentContentBlock$GroupStatus)com.bytedance.trae.conversation.chat.block.AgentContentBlock$TodoGroup
    .registers 13
    # ins_size=6
    const-string/jumbo v0, todoWriteId
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "children"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, status
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;
    move-object v1, v0
    move-object v2, v8
    move-object v3, v9
    move-object v4, v10
    move-object v5, v11
    move-object v6, v12
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/util/List; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->todoWriteId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->todoWriteId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->title Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->title Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->summary Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->summary Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->children Ljava/util/List;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->children Ljava/util/List;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->status Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    iget-object v5, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->status Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    if-eq v1, v5, +003h
    return v2
    return v0
.end method

.method public final getChildren()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->children Ljava/util/List;
    return-object v0
.end method

.method public final getStatus()com.bytedance.trae.conversation.chat.block.AgentContentBlock$GroupStatus
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->status Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    return-object v0
.end method

.method public final getSummary()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->summary Ljava/lang/String;
    return-object v0
.end method

.method public final getTitle()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->title Ljava/lang/String;
    return-object v0
.end method

.method public final getTodoWriteId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->todoWriteId Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->todoWriteId Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->title Ljava/lang/String;
    const/4 v2, 0
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->summary Ljava/lang/String;
    if-nez v1, +003h
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->children Ljava/util/List;
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->status Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "TodoGroup(todoWriteId="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->todoWriteId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", title="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->title Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", summary="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->summary Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", children="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->children Ljava/util/List;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", status="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->status Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
