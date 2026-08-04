# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;
.super Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
.source "AgentContentBlock.kt"

.field private final confirmInfo:Lcom/bytedance/trae/im/model/ConfirmInfo;
.field private final planItemId:Ljava/lang/String;
.field private final toolCallInfo:Lcom/bytedance/trae/im/model/ParsedToolCallInfo;


.method public constructor <init>(java.lang.String  com.bytedance.trae.im.model.ParsedToolCallInfo  com.bytedance.trae.im.model.ConfirmInfo)void
    .registers 5
    # ins_size=4
    const-string v0, "planItemId"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, toolCallInfo
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 0
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;->planItemId Ljava/lang/String;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;->toolCallInfo Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;->confirmInfo Lcom/bytedance/trae/im/model/ConfirmInfo;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  com.bytedance.trae.im.model.ParsedToolCallInfo  com.bytedance.trae.im.model.ConfirmInfo  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 6
    # ins_size=6
    and-int/lit8 v4, v4, 4
    if-eqz v4, +003h
    const/4 v3, 0
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;-><init>(Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedToolCallInfo; Lcom/bytedance/trae/im/model/ConfirmInfo;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.chat.block.AgentContentBlock$Toolcall  java.lang.String  com.bytedance.trae.im.model.ParsedToolCallInfo  com.bytedance.trae.im.model.ConfirmInfo  int  java.lang.Object)com.bytedance.trae.conversation.chat.block.AgentContentBlock$Toolcall
    .registers 6
    # ins_size=6
    and-int/lit8 v5, v4, 1
    if-eqz v5, +004h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;->planItemId Ljava/lang/String;
    and-int/lit8 v5, v4, 2
    if-eqz v5, +004h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;->toolCallInfo Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    and-int/lit8 v4, v4, 4
    if-eqz v4, +004h
    iget-object v3, v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;->confirmInfo Lcom/bytedance/trae/im/model/ConfirmInfo;
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;->copy(Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedToolCallInfo; Lcom/bytedance/trae/im/model/ConfirmInfo;)Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;->planItemId Ljava/lang/String;
    return-object v0
.end method

.method public final component2()com.bytedance.trae.im.model.ParsedToolCallInfo
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;->toolCallInfo Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    return-object v0
.end method

.method public final component3()com.bytedance.trae.im.model.ConfirmInfo
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;->confirmInfo Lcom/bytedance/trae/im/model/ConfirmInfo;
    return-object v0
.end method

.method public final copy(java.lang.String  com.bytedance.trae.im.model.ParsedToolCallInfo  com.bytedance.trae.im.model.ConfirmInfo)com.bytedance.trae.conversation.chat.block.AgentContentBlock$Toolcall
    .registers 5
    # ins_size=4
    const-string v0, "planItemId"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, toolCallInfo
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;
    invoke-direct v0, v2, v3, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;-><init>(Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedToolCallInfo; Lcom/bytedance/trae/im/model/ConfirmInfo;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;->planItemId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;->planItemId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;->toolCallInfo Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;->toolCallInfo Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;->confirmInfo Lcom/bytedance/trae/im/model/ConfirmInfo;
    iget-object v5, v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;->confirmInfo Lcom/bytedance/trae/im/model/ConfirmInfo;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getConfirmInfo()com.bytedance.trae.im.model.ConfirmInfo
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;->confirmInfo Lcom/bytedance/trae/im/model/ConfirmInfo;
    return-object v0
.end method

.method public final getPlanItemId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;->planItemId Ljava/lang/String;
    return-object v0
.end method

.method public final getToolCallInfo()com.bytedance.trae.im.model.ParsedToolCallInfo
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;->toolCallInfo Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;->planItemId Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;->toolCallInfo Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;->confirmInfo Lcom/bytedance/trae/im/model/ConfirmInfo;
    if-nez v1, +004h
    const/4 v1, 0
    goto +5h
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ConfirmInfo;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "Toolcall(planItemId="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;->planItemId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", toolCallInfo="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;->toolCallInfo Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", confirmInfo="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;->confirmInfo Lcom/bytedance/trae/im/model/ConfirmInfo;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
