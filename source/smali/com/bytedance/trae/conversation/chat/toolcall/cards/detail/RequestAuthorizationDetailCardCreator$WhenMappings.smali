# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RequestAuthorizationDetailCardCreator$WhenMappings;
.super Ljava/lang/Object;
.source "RequestAuthorizationDetailCardCreator.kt"

.field public static final synthetic $EnumSwitchMapping$0:[I


.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    invoke-static Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->values()[Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    move-result-object v0
    array-length v0, v0
    new-array v0, v0, [I
    sget-object v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->PENDING Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->ordinal()I
    move-result v1
    const/4 v2, 1
    aput v2, v0, v1
    sget-object v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->RUNNING Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->ordinal()I
    move-result v1
    const/4 v2, 2
    aput v2, v0, v1
    sget-object v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->FAILED Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->ordinal()I
    move-result v1
    const/4 v2, 3
    aput v2, v0, v1
    sget-object v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->SKIPPED Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->ordinal()I
    move-result v1
    const/4 v2, 4
    aput v2, v0, v1
    sget-object v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->CANCELED Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->ordinal()I
    move-result v1
    const/4 v2, 5
    aput v2, v0, v1
    sget-object v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->SUCCESS Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->ordinal()I
    move-result v1
    const/4 v2, 6
    aput v2, v0, v1
    sput-object v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RequestAuthorizationDetailCardCreator$WhenMappings;->$EnumSwitchMapping$0 [I
    return-void 
    :try_start_0x7
    :try_start_0x10
    :try_start_0x19
    :try_start_0x22
    :try_start_0x2b
    :try_start_0x34
.end method
