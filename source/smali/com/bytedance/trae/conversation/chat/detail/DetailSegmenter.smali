# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/detail/DetailSegmenter;
.super Ljava/lang/Object;
.source "DetailSegmenter.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/chat/detail/DetailSegmenter;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/detail/DetailSegmenter;
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/detail/DetailSegmenter;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/detail/DetailSegmenter;->INSTANCE Lcom/bytedance/trae/conversation/chat/detail/DetailSegmenter;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final buildSegmentTitle(java.util.List)java.lang.String
    .registers 11
    # ins_size=2
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/List;
    new-instance v1, Ljava/util/LinkedHashMap;
    invoke-direct v1, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v1, Ljava/util/Map;
    invoke-interface v10, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v10
    const/4 v2, 0
    move v3, v2
    invoke-interface v10, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    const/4 v5, 1
    if-eqz v4, +059h
    invoke-interface v10, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    instance-of v6, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thinking;
    if-eqz v6, +005h
    add-int/lit8 v3, v3, 1
    goto -13h
    instance-of v6, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;
    if-eqz v6, +028h
    check-cast v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v4
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v4
    if-nez v4, +005h
    const-string/jumbo v4, tool
    invoke-interface v1, v4, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Ljava/lang/Integer;
    if-eqz v6, +007h
    invoke-virtual v6, Ljava/lang/Integer;->intValue()I
    move-result v6
    goto +2h
    move v6, v2
    add-int/2addr v6, v5
    invoke-static v6, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    invoke-interface v1, v4, v5, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    goto -3dh
    instance-of v5, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;
    if-eqz v5, +00ch
    check-cast v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;->getTitle()Ljava/lang/String;
    move-result-object v4
    invoke-interface v0, v4, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto -4bh
    instance-of v5, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;
    if-eqz v5, -04eh
    check-cast v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;->getTitle()Ljava/lang/String;
    move-result-object v4
    if-nez v4, +004h
    const-string v4, "Todo"
    invoke-interface v0, v4, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto -5dh
    if-lez v3, +007h
    const-string v10, "Thought"
    invoke-interface v0, v2, v10, Ljava/util/List;->add(I Ljava/lang/Object;)V
    invoke-interface v1, Ljava/util/Map;->entrySet()Ljava/util/Set;
    move-result-object v10
    invoke-interface v10, Ljava/util/Set;->iterator()Ljava/util/Iterator;
    move-result-object v10
    invoke-interface v10, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +03fh
    invoke-interface v10, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/util/Map$Entry;
    invoke-interface v1, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/String;
    invoke-interface v1, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/Number;
    invoke-virtual v1, Ljava/lang/Number;->intValue()I
    move-result v1
    invoke-direct v9, v2, Lcom/bytedance/trae/conversation/chat/detail/DetailSegmenter;->mapToolNameToLabel(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    if-le v1, v5, +01fh
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v3, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const/16 v3, 32
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, " files"
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-interface v0, v2, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto -42h
    invoke-interface v0, Ljava/util/List;->isEmpty()Z
    move-result v10
    if-eqz v10, +005h
    const-string v10, "Tools"
    goto +14h
    check-cast v0, Ljava/lang/Iterable;
    const-string v10, ", "
    move-object v1, v10
    check-cast v1, Ljava/lang/CharSequence;
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/16 v7, 62
    const/4 v8, 0
    invoke-static/range v0 ... v8, Lkotlin/collections/CollectionsKt;->joinToString$default(Ljava/lang/Iterable; Ljava/lang/CharSequence; Ljava/lang/CharSequence; Ljava/lang/CharSequence; I Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v10
    return-object v10
.end method

.method private final isToolBlock(com.bytedance.trae.conversation.chat.block.AgentContentBlock)boolean
    .registers 3
    # ins_size=2
    instance-of v0, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;
    if-nez v0, +011h
    instance-of v0, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thinking;
    if-nez v0, +00dh
    instance-of v0, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;
    if-nez v0, +009h
    instance-of v2, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;
    if-eqz v2, +003h
    goto +3h
    const/4 v2, 0
    goto +2h
    const/4 v2, 1
    return v2
.end method

.method private final mapToolNameToLabel(java.lang.String)java.lang.String
    .registers 6
    # ins_size=2
    move-object v0, v5
    check-cast v0, Ljava/lang/CharSequence;
    const-string/jumbo v1, search
    check-cast v1, Ljava/lang/CharSequence;
    const/4 v2, 1
    invoke-static v0, v1, v2, Lkotlin/text/StringsKt;->contains(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z)Z
    move-result v1
    if-nez v1, +0b3h
    const-string v1, "Grep"
    invoke-static v5, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +0abh
    const-string v1, "Glob"
    invoke-static v5, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +004h
    goto/16 +0a1h
    const-string v1, "read"
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v0, v1, v2, Lkotlin/text/StringsKt;->contains(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z)Z
    move-result v1
    const-string v3, "Read"
    if-nez v1, +093h
    const-string/jumbo v1, view_file
    invoke-static v5, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +08ah
    const-string/jumbo v1, view_files
    invoke-static v5, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +081h
    invoke-static v5, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +004h
    goto/16 +079h
    const-string v1, "edit"
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v0, v1, v2, Lkotlin/text/StringsKt;->contains(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z)Z
    move-result v1
    if-nez v1, +06ch
    const-string v1, "Write"
    invoke-static v5, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +064h
    const-string v1, "Edit"
    invoke-static v5, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +05ch
    const-string v1, "MultiEdit"
    invoke-static v5, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +054h
    const-string v1, "SearchReplace"
    invoke-static v5, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +003h
    goto +4ah
    const-string v1, "delete"
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v0, v1, v2, Lkotlin/text/StringsKt;->contains(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z)Z
    move-result v0
    if-nez v0, +03eh
    const-string v0, "DeleteFile"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    goto +34h
    const-string/jumbo v0, run_command
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +029h
    const-string v0, "RunCommand"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +021h
    const-string v0, "Shell"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +019h
    const-string v0, "exec_command"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    goto +fh
    const/4 v0, 2
    const/4 v1, 0
    const-string v2, "browser_"
    const/4 v3, 0
    invoke-static v5, v2, v3, v0, v1, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +012h
    const-string v5, "Browser"
    goto +eh
    const-string v5, "Executed"
    goto +bh
    const-string v5, "Deleted"
    goto +8h
    const-string v5, "Edited"
    goto +5h
    move-object v5, v3
    goto +3h
    const-string v5, "Searched"
    return-object v5
.end method

.method private static final segment$flushToolBuffer(kotlin.jvm.internal.Ref$ObjectRef  java.util.List)void
    .registers 5
    # ins_size=2
    iget-object v0, v3, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    check-cast v0, Ljava/util/Collection;
    invoke-interface v0, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    xor-int/lit8 v0, v0, 1
    if-eqz v0, +025h
    sget-object v0, Lcom/bytedance/trae/conversation/chat/detail/DetailSegmenter;->INSTANCE Lcom/bytedance/trae/conversation/chat/detail/DetailSegmenter;
    iget-object v1, v3, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    check-cast v1, Ljava/util/List;
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/detail/DetailSegmenter;->buildSegmentTitle(Ljava/util/List;)Ljava/lang/String;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/conversation/chat/detail/DetailSegment$ToolSegment;
    iget-object v2, v3, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    check-cast v2, Ljava/lang/Iterable;
    invoke-static v2, Lkotlin/collections/CollectionsKt;->toList(Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v2
    invoke-direct v1, v0, v2, Lcom/bytedance/trae/conversation/chat/detail/DetailSegment$ToolSegment;-><init>(Ljava/lang/String; Ljava/util/List;)V
    invoke-interface v4, v1, Ljava/util/List;->add(Ljava/lang/Object;)Z
    new-instance v4, Ljava/util/ArrayList;
    invoke-direct v4, Ljava/util/ArrayList;-><init>()V
    check-cast v4, Ljava/util/List;
    iput-object v4, v3, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    return-void 
.end method

.method public final segment(java.util.List)java.util.List
    .registers 6
    # ins_size=2
    const-string v0, "children"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/List;
    new-instance v1, Lkotlin/jvm/internal/Ref$ObjectRef;
    invoke-direct v1, Lkotlin/jvm/internal/Ref$ObjectRef;-><init>()V
    new-instance v2, Ljava/util/ArrayList;
    invoke-direct v2, Ljava/util/ArrayList;-><init>()V
    check-cast v2, Ljava/util/List;
    iput-object v2, v1, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    invoke-interface v5, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v5
    invoke-interface v5, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +03eh
    invoke-interface v5, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    invoke-direct v4, v2, Lcom/bytedance/trae/conversation/chat/detail/DetailSegmenter;->isToolBlock(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;)Z
    move-result v3
    if-eqz v3, +00ah
    iget-object v3, v1, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    check-cast v3, Ljava/util/List;
    invoke-interface v3, v2, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto -19h
    instance-of v3, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thought;
    if-eqz v3, +010h
    invoke-static v1, v0, Lcom/bytedance/trae/conversation/chat/detail/DetailSegmenter;->segment$flushToolBuffer(Lkotlin/jvm/internal/Ref$ObjectRef; Ljava/util/List;)V
    new-instance v3, Lcom/bytedance/trae/conversation/chat/detail/DetailSegment$ThoughtSegment;
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thought;
    invoke-direct v3, v2, Lcom/bytedance/trae/conversation/chat/detail/DetailSegment$ThoughtSegment;-><init>(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thought;)V
    invoke-interface v0, v3, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto -2bh
    instance-of v3, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;
    if-eqz v3, +010h
    invoke-static v1, v0, Lcom/bytedance/trae/conversation/chat/detail/DetailSegmenter;->segment$flushToolBuffer(Lkotlin/jvm/internal/Ref$ObjectRef; Ljava/util/List;)V
    new-instance v3, Lcom/bytedance/trae/conversation/chat/detail/DetailSegment$SubAgentSegment;
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;
    invoke-direct v3, v2, Lcom/bytedance/trae/conversation/chat/detail/DetailSegment$SubAgentSegment;-><init>(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;)V
    invoke-interface v0, v3, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto -3dh
    invoke-static v1, v0, Lcom/bytedance/trae/conversation/chat/detail/DetailSegmenter;->segment$flushToolBuffer(Lkotlin/jvm/internal/Ref$ObjectRef; Ljava/util/List;)V
    goto -41h
    invoke-static v1, v0, Lcom/bytedance/trae/conversation/chat/detail/DetailSegmenter;->segment$flushToolBuffer(Lkotlin/jvm/internal/Ref$ObjectRef; Ljava/util/List;)V
    return-object v0
.end method
