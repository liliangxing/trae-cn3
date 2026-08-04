# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;
.super Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
.source "AgentContentBlock.kt"

.field private final children:Ljava/util/List;
.field private final groupFinished:Z
.field private final groupType:Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupType;
.field private final isCollapsed:Z
.field private final title:Ljava/lang/String;
.field private final toolcalls:Ljava/util/List;


.method public constructor <init>(com.bytedance.trae.conversation.chat.block.AgentContentBlock$GroupType  java.lang.String  java.util.List  java.util.List  boolean  boolean)void
    .registers 8
    # ins_size=7
    const-string v0, "groupType"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, title
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, toolcalls
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "children"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 0
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;->groupType Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupType;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;->title Ljava/lang/String;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;->toolcalls Ljava/util/List;
    iput-object v5, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;->children Ljava/util/List;
    iput-boolean v6, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;->isCollapsed Z
    iput-boolean v7, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;->groupFinished Z
    return-void 
.end method

.method public synthetic constructor <init>(com.bytedance.trae.conversation.chat.block.AgentContentBlock$GroupType  java.lang.String  java.util.List  java.util.List  boolean  boolean  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 16
    # ins_size=9
    and-int/lit8 v15, v14, 8
    if-eqz v15, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v11
    move-object v4, v11
    and-int/lit8 v11, v14, 16
    if-eqz v11, +003h
    const/4 v12, 1
    move v5, v12
    and-int/lit8 v11, v14, 32
    if-eqz v11, +003h
    const/4 v13, 0
    move v6, v13
    move-object v0, v7
    move-object v1, v8
    move-object v2, v9
    move-object v3, v10
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;-><init>(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupType; Ljava/lang/String; Ljava/util/List; Ljava/util/List; Z Z)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.chat.block.AgentContentBlock$ToolcallGroup  com.bytedance.trae.conversation.chat.block.AgentContentBlock$GroupType  java.lang.String  java.util.List  java.util.List  boolean  boolean  int  java.lang.Object)com.bytedance.trae.conversation.chat.block.AgentContentBlock$ToolcallGroup
    .registers 13
    # ins_size=9
    and-int/lit8 v12, v11, 1
    if-eqz v12, +004h
    iget-object v5, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;->groupType Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupType;
    and-int/lit8 v12, v11, 2
    if-eqz v12, +004h
    iget-object v6, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;->title Ljava/lang/String;
    move-object v12, v6
    and-int/lit8 v6, v11, 4
    if-eqz v6, +004h
    iget-object v7, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;->toolcalls Ljava/util/List;
    move-object v0, v7
    and-int/lit8 v6, v11, 8
    if-eqz v6, +004h
    iget-object v8, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;->children Ljava/util/List;
    move-object v1, v8
    and-int/lit8 v6, v11, 16
    if-eqz v6, +004h
    iget-boolean v9, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;->isCollapsed Z
    move v2, v9
    and-int/lit8 v6, v11, 32
    if-eqz v6, +004h
    iget-boolean v10, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;->groupFinished Z
    move v3, v10
    move-object v6, v4
    move-object v7, v5
    move-object v8, v12
    move-object v9, v0
    move-object v10, v1
    move v11, v2
    move v12, v3
    invoke-virtual/range v6 ... v12, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;->copy(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupType; Ljava/lang/String; Ljava/util/List; Ljava/util/List; Z Z)Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;
    move-result-object v4
    return-object v4
.end method

.method public final component1()com.bytedance.trae.conversation.chat.block.AgentContentBlock$GroupType
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;->groupType Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupType;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;->title Ljava/lang/String;
    return-object v0
.end method

.method public final component3()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;->toolcalls Ljava/util/List;
    return-object v0
.end method

.method public final component4()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;->children Ljava/util/List;
    return-object v0
.end method

.method public final component5()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;->isCollapsed Z
    return v0
.end method

.method public final component6()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;->groupFinished Z
    return v0
.end method

.method public final copy(com.bytedance.trae.conversation.chat.block.AgentContentBlock$GroupType  java.lang.String  java.util.List  java.util.List  boolean  boolean)com.bytedance.trae.conversation.chat.block.AgentContentBlock$ToolcallGroup
    .registers 15
    # ins_size=7
    const-string v0, "groupType"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, title
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, toolcalls
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "children"
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;
    move-object v1, v0
    move-object v2, v9
    move-object v3, v10
    move-object v4, v11
    move-object v5, v12
    move v6, v13
    move v7, v14
    invoke-direct/range v1 ... v7, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;-><init>(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupType; Ljava/lang/String; Ljava/util/List; Ljava/util/List; Z Z)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;->groupType Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupType;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;->groupType Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupType;
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;->title Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;->title Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;->toolcalls Ljava/util/List;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;->toolcalls Ljava/util/List;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;->children Ljava/util/List;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;->children Ljava/util/List;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;->isCollapsed Z
    iget-boolean v3, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;->isCollapsed Z
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;->groupFinished Z
    iget-boolean v5, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;->groupFinished Z
    if-eq v1, v5, +003h
    return v2
    return v0
.end method

.method public final getChildren()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;->children Ljava/util/List;
    return-object v0
.end method

.method public final getGroupFinished()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;->groupFinished Z
    return v0
.end method

.method public final getGroupType()com.bytedance.trae.conversation.chat.block.AgentContentBlock$GroupType
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;->groupType Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupType;
    return-object v0
.end method

.method public final getTitle()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;->title Ljava/lang/String;
    return-object v0
.end method

.method public final getToolcalls()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;->toolcalls Ljava/util/List;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;->groupType Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupType;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupType;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;->title Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;->toolcalls Ljava/util/List;
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;->children Ljava/util/List;
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;->isCollapsed Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;->groupFinished Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public final isCollapsed()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;->isCollapsed Z
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "ToolcallGroup(groupType="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;->groupType Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupType;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", title="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;->title Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", toolcalls="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;->toolcalls Ljava/util/List;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", children="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;->children Ljava/util/List;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", isCollapsed="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;->isCollapsed Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", groupFinished="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;->groupFinished Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
