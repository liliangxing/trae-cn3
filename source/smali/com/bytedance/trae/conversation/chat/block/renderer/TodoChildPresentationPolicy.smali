# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildPresentationPolicy;
.super Ljava/lang/Object;
.source "TodoChildPresentationPolicy.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildPresentationPolicy;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildPresentationPolicy;
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildPresentationPolicy;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildPresentationPolicy;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildPresentationPolicy;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final containsPureShowWidget(com.bytedance.trae.conversation.chat.block.AgentContentBlock)boolean
    .registers 5
    # ins_size=2
    instance-of v0, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PureShowWidgetToolcallGroup;
    const/4 v1, 1
    if-eqz v0, +004h
    goto/16 +098h
    instance-of v0, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;
    const/4 v2, 0
    if-eqz v0, +030h
    check-cast v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->getChildren()Ljava/util/List;
    move-result-object v4
    check-cast v4, Ljava/lang/Iterable;
    instance-of v0, v4, Ljava/util/Collection;
    if-eqz v0, +00dh
    move-object v0, v4
    check-cast v0, Ljava/util/Collection;
    invoke-interface v0, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    if-eqz v0, +004h
    goto/16 +07bh
    invoke-interface v4, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v4
    invoke-interface v4, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +071h
    invoke-interface v4, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    invoke-direct v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildPresentationPolicy;->containsPureShowWidget(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;)Z
    move-result v0
    if-eqz v0, -010h
    goto +64h
    instance-of v0, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;
    if-eqz v0, +02fh
    check-cast v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;->getChildren()Ljava/util/List;
    move-result-object v4
    check-cast v4, Ljava/lang/Iterable;
    instance-of v0, v4, Ljava/util/Collection;
    if-eqz v0, +00ch
    move-object v0, v4
    check-cast v0, Ljava/util/Collection;
    invoke-interface v0, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    if-eqz v0, +003h
    goto +49h
    invoke-interface v4, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v4
    invoke-interface v4, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +040h
    invoke-interface v4, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    invoke-direct v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildPresentationPolicy;->containsPureShowWidget(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;)Z
    move-result v0
    if-eqz v0, -010h
    goto +33h
    instance-of v0, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;
    if-eqz v0, +02fh
    check-cast v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;->getChildren()Ljava/util/List;
    move-result-object v4
    check-cast v4, Ljava/lang/Iterable;
    instance-of v0, v4, Ljava/util/Collection;
    if-eqz v0, +00ch
    move-object v0, v4
    check-cast v0, Ljava/util/Collection;
    invoke-interface v0, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    if-eqz v0, +003h
    goto +18h
    invoke-interface v4, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v4
    invoke-interface v4, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +00fh
    invoke-interface v4, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    invoke-direct v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildPresentationPolicy;->containsPureShowWidget(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;)Z
    move-result v0
    if-eqz v0, -010h
    goto +2h
    move v1, v2
    return v1
.end method

.method public final containsPureShowWidget(java.util.List)boolean
    .registers 4
    # ins_size=2
    const-string v0, "children"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v3, Ljava/lang/Iterable;
    instance-of v0, v3, Ljava/util/Collection;
    const/4 v1, 0
    if-eqz v0, +00ch
    move-object v0, v3
    check-cast v0, Ljava/util/Collection;
    invoke-interface v0, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    if-eqz v0, +003h
    goto +18h
    invoke-interface v3, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +00fh
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    invoke-direct v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildPresentationPolicy;->containsPureShowWidget(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;)Z
    move-result v0
    if-eqz v0, -010h
    const/4 v1, 1
    return v1
.end method

.method public final shouldAutoExpand(java.util.List)boolean
    .registers 3
    # ins_size=2
    const-string v0, "children"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildPresentationPolicy;->containsPureShowWidget(Ljava/util/List;)Z
    move-result v2
    return v2
.end method

.method public final visibleChildren(java.util.List)java.util.List
    .registers 6
    # ins_size=2
    const-string v0, "children"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v5, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v5, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v5
    invoke-interface v5, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +027h
    invoke-interface v5, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    instance-of v3, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thought;
    if-nez v3, +015h
    instance-of v3, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;
    if-nez v3, +011h
    instance-of v3, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;
    if-nez v3, +00dh
    instance-of v3, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PureShowWidgetToolcallGroup;
    if-nez v3, +009h
    instance-of v2, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;
    if-eqz v2, +003h
    goto +3h
    const/4 v2, 0
    goto +2h
    const/4 v2, 1
    if-eqz v2, -025h
    invoke-interface v0, v1, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -2ah
    check-cast v0, Ljava/util/List;
    return-object v0
.end method
