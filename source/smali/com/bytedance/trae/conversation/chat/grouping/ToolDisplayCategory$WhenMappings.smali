# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$WhenMappings;
.super Ljava/lang/Object;
.source "ToolDisplayCategory.kt"

.field public static final synthetic $EnumSwitchMapping$0:[I


.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    invoke-static Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->values()[Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    move-result-object v0
    array-length v0, v0
    new-array v0, v0, [I
    sget-object v1, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->FILE_EDIT Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->ordinal()I
    move-result v1
    const/4 v2, 1
    aput v2, v0, v1
    sget-object v1, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->FILE_VIEW Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->ordinal()I
    move-result v1
    const/4 v2, 2
    aput v2, v0, v1
    sget-object v1, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->FILE_CREATE Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->ordinal()I
    move-result v1
    const/4 v2, 3
    aput v2, v0, v1
    sget-object v1, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->FOLDER_VIEW Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->ordinal()I
    move-result v1
    const/4 v2, 4
    aput v2, v0, v1
    sget-object v1, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->FILE_DELETE Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->ordinal()I
    move-result v1
    const/4 v2, 5
    aput v2, v0, v1
    sget-object v1, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->COMMAND_EXEC Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->ordinal()I
    move-result v1
    const/4 v2, 6
    aput v2, v0, v1
    sget-object v1, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->MCP_TOOL Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->ordinal()I
    move-result v1
    const/4 v2, 7
    aput v2, v0, v1
    sget-object v1, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->SKILL Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->ordinal()I
    move-result v1
    const/16 v2, 8
    aput v2, v0, v1
    sget-object v1, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->FILE_SEARCH Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->ordinal()I
    move-result v1
    const/16 v2, 9
    aput v2, v0, v1
    sget-object v1, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->WEB_SEARCH Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->ordinal()I
    move-result v1
    const/16 v2, 10
    aput v2, v0, v1
    sget-object v1, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->THINKING Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->ordinal()I
    move-result v1
    const/16 v2, 11
    aput v2, v0, v1
    sget-object v1, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->PREVIEW Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->ordinal()I
    move-result v1
    const/16 v2, 12
    aput v2, v0, v1
    sget-object v1, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->TASK_MANAGE Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->ordinal()I
    move-result v1
    const/16 v2, 13
    aput v2, v0, v1
    sget-object v1, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->ENV_INIT Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->ordinal()I
    move-result v1
    const/16 v2, 14
    aput v2, v0, v1
    sget-object v1, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->ASK_USER Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->ordinal()I
    move-result v1
    const/16 v2, 15
    aput v2, v0, v1
    sget-object v1, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->BROWSER_USE Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->ordinal()I
    move-result v1
    const/16 v2, 16
    aput v2, v0, v1
    sget-object v1, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->SUB_AGENT Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->ordinal()I
    move-result v1
    const/16 v2, 17
    aput v2, v0, v1
    sget-object v1, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->FALLBACK Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->ordinal()I
    move-result v1
    const/16 v2, 18
    aput v2, v0, v1
    sput-object v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$WhenMappings;->$EnumSwitchMapping$0 [I
    return-void 
    :try_start_0x7
    :try_start_0x10
    :try_start_0x19
    :try_start_0x22
    :try_start_0x2b
    :try_start_0x34
    :try_start_0x3d
    :try_start_0x46
    :try_start_0x50
    :try_start_0x5a
    :try_start_0x64
    :try_start_0x6e
    :try_start_0x78
    :try_start_0x82
    :try_start_0x8c
    :try_start_0x96
    :try_start_0xa0
    :try_start_0xaa
.end method
