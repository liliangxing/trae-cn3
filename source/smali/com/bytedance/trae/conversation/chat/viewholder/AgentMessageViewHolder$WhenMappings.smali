# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder$WhenMappings;
.super Ljava/lang/Object;
.source "AgentMessageViewHolder.kt"

.field public static final synthetic $EnumSwitchMapping$0:[I


.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    invoke-static Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionType;->values()[Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionType;
    move-result-object v0
    array-length v0, v0
    new-array v0, v0, [I
    sget-object v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionType;->THUMBS_UP Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionType;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionType;->ordinal()I
    move-result v1
    const/4 v2, 1
    aput v2, v0, v1
    sget-object v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionType;->THUMBS_DOWN Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionType;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionType;->ordinal()I
    move-result v1
    const/4 v2, 2
    aput v2, v0, v1
    sget-object v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionType;->COPY Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionType;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionType;->ordinal()I
    move-result v1
    const/4 v2, 3
    aput v2, v0, v1
    sget-object v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionType;->RETRY Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionType;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionType;->ordinal()I
    move-result v1
    const/4 v2, 4
    aput v2, v0, v1
    sget-object v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionType;->MORE Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionType;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionType;->ordinal()I
    move-result v1
    const/4 v2, 5
    aput v2, v0, v1
    sget-object v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionType;->USER_ERPRESS_PASS_WHEN_ERROR Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionType;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionType;->ordinal()I
    move-result v1
    const/4 v2, 6
    aput v2, v0, v1
    sput-object v0, Lcom/bytedance/trae/conversation/chat/viewholder/AgentMessageViewHolder$WhenMappings;->$EnumSwitchMapping$0 [I
    return-void 
    :try_start_0x7
    :try_start_0x10
    :try_start_0x19
    :try_start_0x22
    :try_start_0x2b
    :try_start_0x34
.end method
