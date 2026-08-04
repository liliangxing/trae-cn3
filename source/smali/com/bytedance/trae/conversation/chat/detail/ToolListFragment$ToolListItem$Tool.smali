# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListItem$Tool;
.super Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListItem;
.source "ToolListFragment.kt"

.field private final planItemContext:Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;
.field private final toolCallInfo:Lcom/bytedance/trae/im/model/ParsedToolCallInfo;


.method public constructor <init>(com.bytedance.trae.im.model.ParsedToolCallInfo  com.bytedance.trae.conversation.chat.toolcall.PlanItemContext)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, toolCallInfo
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 0
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListItem;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListItem$Tool;->toolCallInfo Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListItem$Tool;->planItemContext Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.chat.detail.ToolListFragment$ToolListItem$Tool  com.bytedance.trae.im.model.ParsedToolCallInfo  com.bytedance.trae.conversation.chat.toolcall.PlanItemContext  int  java.lang.Object)com.bytedance.trae.conversation.chat.detail.ToolListFragment$ToolListItem$Tool
    .registers 5
    # ins_size=5
    and-int/lit8 v4, v3, 1
    if-eqz v4, +004h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListItem$Tool;->toolCallInfo Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    and-int/lit8 v3, v3, 2
    if-eqz v3, +004h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListItem$Tool;->planItemContext Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListItem$Tool;->copy(Lcom/bytedance/trae/im/model/ParsedToolCallInfo; Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;)Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListItem$Tool;
    move-result-object v0
    return-object v0
.end method

.method public final component1()com.bytedance.trae.im.model.ParsedToolCallInfo
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListItem$Tool;->toolCallInfo Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    return-object v0
.end method

.method public final component2()com.bytedance.trae.conversation.chat.toolcall.PlanItemContext
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListItem$Tool;->planItemContext Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;
    return-object v0
.end method

.method public final copy(com.bytedance.trae.im.model.ParsedToolCallInfo  com.bytedance.trae.conversation.chat.toolcall.PlanItemContext)com.bytedance.trae.conversation.chat.detail.ToolListFragment$ToolListItem$Tool
    .registers 4
    # ins_size=3
    const-string/jumbo v0, toolCallInfo
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListItem$Tool;
    invoke-direct v0, v2, v3, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListItem$Tool;-><init>(Lcom/bytedance/trae/im/model/ParsedToolCallInfo; Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListItem$Tool;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListItem$Tool;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListItem$Tool;->toolCallInfo Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListItem$Tool;->toolCallInfo Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListItem$Tool;->planItemContext Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;
    iget-object v5, v5, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListItem$Tool;->planItemContext Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public getCategory()com.bytedance.trae.conversation.chat.detail.ToolListFragment$ToolCategory
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->Companion Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory$Companion;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListItem$Tool;->toolCallInfo Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory$Companion;->fromToolName(Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
    move-result-object v0
    return-object v0
.end method

.method public final getPlanItemContext()com.bytedance.trae.conversation.chat.toolcall.PlanItemContext
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListItem$Tool;->planItemContext Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;
    return-object v0
.end method

.method public final getToolCallInfo()com.bytedance.trae.im.model.ParsedToolCallInfo
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListItem$Tool;->toolCallInfo Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListItem$Tool;->toolCallInfo Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListItem$Tool;->planItemContext Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;
    if-nez v1, +004h
    const/4 v1, 0
    goto +5h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "Tool(toolCallInfo="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListItem$Tool;->toolCallInfo Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", planItemContext="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListItem$Tool;->planItemContext Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
