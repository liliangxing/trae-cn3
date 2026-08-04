# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final enum Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
.super Ljava/lang/Enum;
.source "ToolDisplayCategory.kt"

.field private static final synthetic $ENTRIES:Lkotlin/enums/EnumEntries;
.field private static final synthetic $VALUES:[Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
.field public static final enum ASK_USER:Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
.field private static final ASK_USER_NAMES:Ljava/util/Set;
.field public static final enum BROWSER_USE:Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
.field private static final BROWSER_USE_NAMES:Ljava/util/Set;
.field public static final enum COMMAND_EXEC:Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
.field private static final COMMAND_EXEC_NAMES:Ljava/util/Set;
.field public static final Companion:Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$Companion;
.field public static final enum ENV_INIT:Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
.field private static final ENV_INIT_NAMES:Ljava/util/Set;
.field public static final enum FALLBACK:Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
.field public static final enum FILE_CREATE:Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
.field private static final FILE_CREATE_NAMES:Ljava/util/Set;
.field public static final enum FILE_DELETE:Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
.field private static final FILE_DELETE_NAMES:Ljava/util/Set;
.field public static final enum FILE_EDIT:Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
.field private static final FILE_EDIT_NAMES:Ljava/util/Set;
.field public static final enum FILE_SEARCH:Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
.field private static final FILE_SEARCH_NAMES:Ljava/util/Set;
.field public static final enum FILE_VIEW:Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
.field private static final FILE_VIEW_NAMES:Ljava/util/Set;
.field public static final enum FOLDER_VIEW:Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
.field private static final FOLDER_VIEW_NAMES:Ljava/util/Set;
.field public static final enum MCP_TOOL:Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
.field private static final MCP_TOOL_NAMES:Ljava/util/Set;
.field public static final enum PREVIEW:Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
.field private static final PREVIEW_NAMES:Ljava/util/Set;
.field public static final enum SKILL:Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
.field private static final SKILL_NAMES:Ljava/util/Set;
.field public static final enum SUB_AGENT:Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
.field private static final SUB_AGENT_NAMES:Ljava/util/Set;
.field public static final enum TASK_MANAGE:Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
.field private static final TASK_MANAGE_NAMES:Ljava/util/Set;
.field public static final enum THINKING:Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
.field private static final THINKING_NAMES:Ljava/util/Set;
.field public static final enum WEB_SEARCH:Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
.field private static final WEB_SEARCH_NAMES:Ljava/util/Set;
.field private final countType:Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$CountType;


.method private static final synthetic $values()com.bytedance.trae.conversation.chat.grouping.ToolDisplayCategory[]
    .registers 3
    # ins_size=0
    const/16 v0, 18
    new-array v0, v0, [Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    const/4 v1, 0
    sget-object v2, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->FILE_EDIT Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    aput-object v2, v0, v1
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->FILE_VIEW Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    aput-object v2, v0, v1
    const/4 v1, 2
    sget-object v2, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->FILE_CREATE Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    aput-object v2, v0, v1
    const/4 v1, 3
    sget-object v2, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->FOLDER_VIEW Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    aput-object v2, v0, v1
    const/4 v1, 4
    sget-object v2, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->FILE_DELETE Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    aput-object v2, v0, v1
    const/4 v1, 5
    sget-object v2, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->COMMAND_EXEC Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    aput-object v2, v0, v1
    const/4 v1, 6
    sget-object v2, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->MCP_TOOL Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    aput-object v2, v0, v1
    const/4 v1, 7
    sget-object v2, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->SKILL Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    aput-object v2, v0, v1
    const/16 v1, 8
    sget-object v2, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->FILE_SEARCH Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    aput-object v2, v0, v1
    const/16 v1, 9
    sget-object v2, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->WEB_SEARCH Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    aput-object v2, v0, v1
    const/16 v1, 10
    sget-object v2, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->THINKING Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    aput-object v2, v0, v1
    const/16 v1, 11
    sget-object v2, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->PREVIEW Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    aput-object v2, v0, v1
    const/16 v1, 12
    sget-object v2, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->TASK_MANAGE Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    aput-object v2, v0, v1
    const/16 v1, 13
    sget-object v2, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->ENV_INIT Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    aput-object v2, v0, v1
    const/16 v1, 14
    sget-object v2, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->ASK_USER Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    aput-object v2, v0, v1
    const/16 v1, 15
    sget-object v2, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->BROWSER_USE Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    aput-object v2, v0, v1
    const/16 v1, 16
    sget-object v2, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->SUB_AGENT Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    aput-object v2, v0, v1
    const/16 v1, 17
    sget-object v2, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->FALLBACK Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    aput-object v2, v0, v1
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 12
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    const/4 v1, 0
    sget-object v2, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$CountType;->OBJECT Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$CountType;
    const-string v3, "FILE_EDIT"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;-><init>(Ljava/lang/String; I Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$CountType;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->FILE_EDIT Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$CountType;->OBJECT Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$CountType;
    const-string v3, "FILE_VIEW"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;-><init>(Ljava/lang/String; I Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$CountType;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->FILE_VIEW Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    const/4 v1, 2
    sget-object v2, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$CountType;->OBJECT Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$CountType;
    const-string v3, "FILE_CREATE"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;-><init>(Ljava/lang/String; I Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$CountType;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->FILE_CREATE Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    const/4 v1, 3
    sget-object v2, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$CountType;->OBJECT Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$CountType;
    const-string v3, "FOLDER_VIEW"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;-><init>(Ljava/lang/String; I Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$CountType;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->FOLDER_VIEW Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    const/4 v1, 4
    sget-object v2, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$CountType;->OBJECT Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$CountType;
    const-string v3, "FILE_DELETE"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;-><init>(Ljava/lang/String; I Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$CountType;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->FILE_DELETE Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    const/4 v1, 5
    sget-object v2, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$CountType;->OBJECT Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$CountType;
    const-string v3, "COMMAND_EXEC"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;-><init>(Ljava/lang/String; I Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$CountType;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->COMMAND_EXEC Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    const/4 v1, 6
    sget-object v2, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$CountType;->OBJECT Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$CountType;
    const-string v3, "MCP_TOOL"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;-><init>(Ljava/lang/String; I Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$CountType;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->MCP_TOOL Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    const/4 v1, 7
    sget-object v2, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$CountType;->OBJECT Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$CountType;
    const-string v3, "SKILL"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;-><init>(Ljava/lang/String; I Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$CountType;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->SKILL Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    const/16 v1, 8
    sget-object v2, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$CountType;->ACTION Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$CountType;
    const-string v3, "FILE_SEARCH"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;-><init>(Ljava/lang/String; I Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$CountType;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->FILE_SEARCH Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    const/16 v1, 9
    sget-object v2, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$CountType;->ACTION Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$CountType;
    const-string v3, "WEB_SEARCH"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;-><init>(Ljava/lang/String; I Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$CountType;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->WEB_SEARCH Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    const/16 v1, 10
    sget-object v2, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$CountType;->NONE Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$CountType;
    const-string v3, "THINKING"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;-><init>(Ljava/lang/String; I Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$CountType;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->THINKING Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    const/16 v1, 11
    sget-object v2, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$CountType;->NONE Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$CountType;
    const-string v3, "PREVIEW"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;-><init>(Ljava/lang/String; I Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$CountType;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->PREVIEW Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    const/16 v1, 12
    sget-object v2, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$CountType;->NONE Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$CountType;
    const-string v3, "TASK_MANAGE"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;-><init>(Ljava/lang/String; I Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$CountType;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->TASK_MANAGE Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    const/16 v1, 13
    sget-object v2, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$CountType;->NONE Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$CountType;
    const-string v3, "ENV_INIT"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;-><init>(Ljava/lang/String; I Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$CountType;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->ENV_INIT Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    const/16 v1, 14
    sget-object v2, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$CountType;->NONE Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$CountType;
    const-string v3, "ASK_USER"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;-><init>(Ljava/lang/String; I Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$CountType;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->ASK_USER Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    const/16 v1, 15
    sget-object v2, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$CountType;->NONE Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$CountType;
    const-string v3, "BROWSER_USE"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;-><init>(Ljava/lang/String; I Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$CountType;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->BROWSER_USE Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    const/16 v1, 16
    sget-object v2, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$CountType;->NONE Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$CountType;
    const-string v3, "SUB_AGENT"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;-><init>(Ljava/lang/String; I Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$CountType;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->SUB_AGENT Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    const/16 v1, 17
    sget-object v2, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$CountType;->OBJECT Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$CountType;
    const-string v3, "FALLBACK"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;-><init>(Ljava/lang/String; I Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$CountType;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->FALLBACK Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    invoke-static Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->$values()[Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->$VALUES [Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    check-cast v0, [Ljava/lang/Enum;
    invoke-static v0, Lkotlin/enums/EnumEntriesKt;->enumEntries([Ljava/lang/Enum;)Lkotlin/enums/EnumEntries;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->$ENTRIES Lkotlin/enums/EnumEntries;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->Companion Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$Companion;
    const-string v2, "edit_file_search_replace"
    const-string v3, "Write"
    const-string v4, "Edit"
    const-string v5, "MultiEdit"
    const-string v6, "SearchReplace"
    const-string v7, "edit_file"
    const-string/jumbo v8, write_to_file
    const-string v9, "edit_file_update"
    const-string v10, "ShowDiff"
    const-string v11, "WriteToFile"
    filled-new-array/range v2 ... v11, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->FILE_EDIT_NAMES Ljava/util/Set;
    const-string v0, "ViewFile"
    const-string v1, "ViewFiles"
    const-string/jumbo v2, view_file
    const-string/jumbo v3, view_files
    const-string v4, "Read"
    filled-new-array v2, v3, v4, v0, v1, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->FILE_VIEW_NAMES Ljava/util/Set;
    const-string v0, "create_file"
    const-string v1, "CreateFile"
    filled-new-array v0, v1, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->FILE_CREATE_NAMES Ljava/util/Set;
    const-string v0, "LS"
    const-string v1, "ViewFolder"
    const-string/jumbo v2, view_folder
    filled-new-array v2, v0, v1, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->FOLDER_VIEW_NAMES Ljava/util/Set;
    const-string v0, "delete_file"
    const-string v1, "DeleteFile"
    filled-new-array v0, v1, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->FILE_DELETE_NAMES Ljava/util/Set;
    const-string/jumbo v1, run_command
    const-string v2, "RunCommand"
    const-string v3, "Shell"
    const-string v4, "exec_command"
    const-string v5, "CheckCommandStatus"
    const-string v6, "StopCommand"
    filled-new-array/range v1 ... v6, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->COMMAND_EXEC_NAMES Ljava/util/Set;
    const-string v0, "MCPCall"
    const-string v1, "RunMcp"
    const-string/jumbo v2, run_mcp
    const-string v3, "mcp_call"
    filled-new-array v2, v3, v0, v1, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->MCP_TOOL_NAMES Ljava/util/Set;
    const-string v0, "Skill"
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf(Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->SKILL_NAMES Ljava/util/Set;
    const-string v1, "file_search"
    const-string v2, "FileSearch"
    const-string v3, "Glob"
    const-string v4, "SearchByRegex"
    const-string v5, "Grep"
    const-string v6, "SearchCodebase"
    const-string/jumbo v7, search_codebase
    const-string/jumbo v8, search_by_regex
    filled-new-array/range v1 ... v8, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->FILE_SEARCH_NAMES Ljava/util/Set;
    const-string v0, "WebSearch"
    const-string v1, "WebFetch"
    const-string/jumbo v2, web_search
    filled-new-array v2, v0, v1, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->WEB_SEARCH_NAMES Ljava/util/Set;
    const-string v0, "Thinking"
    const-string v1, "Reasoning"
    filled-new-array v0, v1, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->THINKING_NAMES Ljava/util/Set;
    const-string v0, "OpenPreview"
    const-string v1, "open_preview_and_wait_for_error"
    const-string v2, "open_preview"
    filled-new-array v2, v0, v1, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->PREVIEW_NAMES Ljava/util/Set;
    const-string/jumbo v0, todo_write
    const-string v1, "TodoWrite"
    filled-new-array v0, v1, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->TASK_MANAGE_NAMES Ljava/util/Set;
    const-string v0, "InitEnv"
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf(Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->ENV_INIT_NAMES Ljava/util/Set;
    const-string v0, "AskUserQuestion"
    const-string v1, "RequestAuthorization"
    filled-new-array v0, v1, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->ASK_USER_NAMES Ljava/util/Set;
    const-string v0, "BrowserHandOver"
    const-string v1, "BrowserWaitingForUserInteraction"
    filled-new-array v0, v1, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->BROWSER_USE_NAMES Ljava/util/Set;
    const-string v0, "RunAgent"
    const-string v1, "Task"
    filled-new-array v0, v1, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->SUB_AGENT_NAMES Ljava/util/Set;
    return-void 
.end method

.method private constructor <init>(java.lang.String  int  com.bytedance.trae.conversation.chat.grouping.ToolDisplayCategory$CountType)void
    .registers 4
    # ins_size=4
    invoke-direct v0, v1, v2, Ljava/lang/Enum;-><init>(Ljava/lang/String; I)V
    iput-object v3, v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->countType Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$CountType;
    return-void 
.end method

.method public static final synthetic access$getASK_USER_NAMES$cp()java.util.Set
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->ASK_USER_NAMES Ljava/util/Set;
    return-object v0
.end method

.method public static final synthetic access$getBROWSER_USE_NAMES$cp()java.util.Set
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->BROWSER_USE_NAMES Ljava/util/Set;
    return-object v0
.end method

.method public static final synthetic access$getCOMMAND_EXEC_NAMES$cp()java.util.Set
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->COMMAND_EXEC_NAMES Ljava/util/Set;
    return-object v0
.end method

.method public static final synthetic access$getENV_INIT_NAMES$cp()java.util.Set
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->ENV_INIT_NAMES Ljava/util/Set;
    return-object v0
.end method

.method public static final synthetic access$getFILE_CREATE_NAMES$cp()java.util.Set
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->FILE_CREATE_NAMES Ljava/util/Set;
    return-object v0
.end method

.method public static final synthetic access$getFILE_DELETE_NAMES$cp()java.util.Set
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->FILE_DELETE_NAMES Ljava/util/Set;
    return-object v0
.end method

.method public static final synthetic access$getFILE_EDIT_NAMES$cp()java.util.Set
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->FILE_EDIT_NAMES Ljava/util/Set;
    return-object v0
.end method

.method public static final synthetic access$getFILE_SEARCH_NAMES$cp()java.util.Set
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->FILE_SEARCH_NAMES Ljava/util/Set;
    return-object v0
.end method

.method public static final synthetic access$getFILE_VIEW_NAMES$cp()java.util.Set
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->FILE_VIEW_NAMES Ljava/util/Set;
    return-object v0
.end method

.method public static final synthetic access$getFOLDER_VIEW_NAMES$cp()java.util.Set
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->FOLDER_VIEW_NAMES Ljava/util/Set;
    return-object v0
.end method

.method public static final synthetic access$getMCP_TOOL_NAMES$cp()java.util.Set
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->MCP_TOOL_NAMES Ljava/util/Set;
    return-object v0
.end method

.method public static final synthetic access$getPREVIEW_NAMES$cp()java.util.Set
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->PREVIEW_NAMES Ljava/util/Set;
    return-object v0
.end method

.method public static final synthetic access$getSKILL_NAMES$cp()java.util.Set
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->SKILL_NAMES Ljava/util/Set;
    return-object v0
.end method

.method public static final synthetic access$getSUB_AGENT_NAMES$cp()java.util.Set
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->SUB_AGENT_NAMES Ljava/util/Set;
    return-object v0
.end method

.method public static final synthetic access$getTASK_MANAGE_NAMES$cp()java.util.Set
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->TASK_MANAGE_NAMES Ljava/util/Set;
    return-object v0
.end method

.method public static final synthetic access$getTHINKING_NAMES$cp()java.util.Set
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->THINKING_NAMES Ljava/util/Set;
    return-object v0
.end method

.method public static final synthetic access$getWEB_SEARCH_NAMES$cp()java.util.Set
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->WEB_SEARCH_NAMES Ljava/util/Set;
    return-object v0
.end method

.method public static getEntries()kotlin.enums.EnumEntries
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-object v0
.end method

.method public static valueOf(java.lang.String)com.bytedance.trae.conversation.chat.grouping.ToolDisplayCategory
    .registers 2
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    invoke-static v0, v1, Ljava/lang/Enum;->valueOf(Ljava/lang/Class; Ljava/lang/String;)Ljava/lang/Enum;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    return-object v1
.end method

.method public static values()com.bytedance.trae.conversation.chat.grouping.ToolDisplayCategory[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->$VALUES [Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    invoke-virtual v0, Ljava/lang/Object;->clone()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, [Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;
    return-object v0
.end method

.method public final getCompletedTitle(android.content.res.Resources  int)java.lang.String
    .registers 7
    # ins_size=3
    const-string/jumbo v0, resources
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->ordinal()I
    move-result v1
    aget v0, v0, v1
    const/4 v1, 0
    const/4 v2, 1
    const-string v3, "getString(...)"
    packed-switch v0, +0000128h
    new-instance v5, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v5, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v5
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_group_done_mcp_tool I
    new-array v2, v2, [Ljava/lang/Object;
    invoke-static v6, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    aput-object v6, v2, v1
    invoke-virtual v5, v0, v2, Landroid/content/res/Resources;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v5
    invoke-static v5, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto/16 +10dh
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_group_done_file_edit I
    new-array v2, v2, [Ljava/lang/Object;
    invoke-static v6, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    aput-object v6, v2, v1
    invoke-virtual v5, v0, v2, Landroid/content/res/Resources;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v5
    invoke-static v5, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto/16 +0fah
    sget v6, Lcom/bytedance/trae/conversation/R$string;->trae_group_done_browser_use I
    invoke-virtual v5, v6, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;
    move-result-object v5
    invoke-static v5, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto/16 +0efh
    sget v6, Lcom/bytedance/trae/conversation/R$string;->trae_group_done_ask_user I
    invoke-virtual v5, v6, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;
    move-result-object v5
    invoke-static v5, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto/16 +0e4h
    sget v6, Lcom/bytedance/trae/conversation/R$string;->trae_group_done_env_init I
    invoke-virtual v5, v6, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;
    move-result-object v5
    invoke-static v5, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto/16 +0d9h
    sget v6, Lcom/bytedance/trae/conversation/R$string;->trae_group_done_task_manage I
    invoke-virtual v5, v6, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;
    move-result-object v5
    invoke-static v5, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto/16 +0ceh
    sget v6, Lcom/bytedance/trae/conversation/R$string;->trae_group_done_preview I
    invoke-virtual v5, v6, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;
    move-result-object v5
    invoke-static v5, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto/16 +0c3h
    sget v6, Lcom/bytedance/trae/conversation/R$string;->trae_group_done_thinking I
    invoke-virtual v5, v6, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;
    move-result-object v5
    invoke-static v5, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto/16 +0b8h
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_group_done_web_search I
    new-array v2, v2, [Ljava/lang/Object;
    invoke-static v6, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    aput-object v6, v2, v1
    invoke-virtual v5, v0, v2, Landroid/content/res/Resources;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v5
    invoke-static v5, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto/16 +0a5h
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_group_done_file_search I
    new-array v2, v2, [Ljava/lang/Object;
    invoke-static v6, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    aput-object v6, v2, v1
    invoke-virtual v5, v0, v2, Landroid/content/res/Resources;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v5
    invoke-static v5, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto/16 +092h
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_group_done_skill I
    new-array v2, v2, [Ljava/lang/Object;
    invoke-static v6, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    aput-object v6, v2, v1
    invoke-virtual v5, v0, v2, Landroid/content/res/Resources;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v5
    invoke-static v5, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto/16 +07fh
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_group_done_mcp_tool I
    new-array v2, v2, [Ljava/lang/Object;
    invoke-static v6, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    aput-object v6, v2, v1
    invoke-virtual v5, v0, v2, Landroid/content/res/Resources;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v5
    invoke-static v5, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +6ch
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_group_done_command_exec I
    new-array v2, v2, [Ljava/lang/Object;
    invoke-static v6, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    aput-object v6, v2, v1
    invoke-virtual v5, v0, v2, Landroid/content/res/Resources;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v5
    invoke-static v5, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +5ah
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_group_done_file_delete I
    new-array v2, v2, [Ljava/lang/Object;
    invoke-static v6, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    aput-object v6, v2, v1
    invoke-virtual v5, v0, v2, Landroid/content/res/Resources;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v5
    invoke-static v5, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +48h
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_group_done_folder_view I
    new-array v2, v2, [Ljava/lang/Object;
    invoke-static v6, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    aput-object v6, v2, v1
    invoke-virtual v5, v0, v2, Landroid/content/res/Resources;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v5
    invoke-static v5, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +36h
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_group_done_file_create I
    new-array v2, v2, [Ljava/lang/Object;
    invoke-static v6, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    aput-object v6, v2, v1
    invoke-virtual v5, v0, v2, Landroid/content/res/Resources;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v5
    invoke-static v5, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +24h
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_group_done_file_view I
    new-array v2, v2, [Ljava/lang/Object;
    invoke-static v6, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    aput-object v6, v2, v1
    invoke-virtual v5, v0, v2, Landroid/content/res/Resources;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v5
    invoke-static v5, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +12h
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_group_done_file_edit I
    new-array v2, v2, [Ljava/lang/Object;
    invoke-static v6, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    aput-object v6, v2, v1
    invoke-virtual v5, v0, v2, Landroid/content/res/Resources;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v5
    invoke-static v5, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v5
    packed-switch-payload 1 2 3 4 5 6 7 8 9 a b c d e f 10 11 12
.end method

.method public final getCountType()com.bytedance.trae.conversation.chat.grouping.ToolDisplayCategory$CountType
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->countType Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$CountType;
    return-object v0
.end method

.method public final getRunningTitle(android.content.res.Resources)java.lang.String
    .registers 4
    # ins_size=2
    const-string/jumbo v0, resources
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->ordinal()I
    move-result v1
    aget v0, v0, v1
    const-string v1, "getString(...)"
    packed-switch v0, +00000c4h
    new-instance v3, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v3, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v3
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_group_running_mcp_tool I
    invoke-virtual v3, v0, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto/16 +0b1h
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_group_running_file_edit I
    invoke-virtual v3, v0, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto/16 +0a6h
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_group_running_browser_use I
    invoke-virtual v3, v0, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto/16 +09bh
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_group_running_ask_user I
    invoke-virtual v3, v0, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto/16 +090h
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_group_running_env_init I
    invoke-virtual v3, v0, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto/16 +085h
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_group_running_task_manage I
    invoke-virtual v3, v0, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto/16 +07ah
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_group_running_preview I
    invoke-virtual v3, v0, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto/16 +06fh
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_group_running_thinking I
    invoke-virtual v3, v0, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +64h
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_group_running_web_search I
    invoke-virtual v3, v0, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +5ah
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_group_running_file_search I
    invoke-virtual v3, v0, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +50h
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_group_running_skill I
    invoke-virtual v3, v0, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +46h
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_group_running_mcp_tool I
    invoke-virtual v3, v0, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +3ch
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_group_running_command_exec I
    invoke-virtual v3, v0, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +32h
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_group_running_file_delete I
    invoke-virtual v3, v0, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +28h
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_group_running_folder_view I
    invoke-virtual v3, v0, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +1eh
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_group_running_file_create I
    invoke-virtual v3, v0, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +14h
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_group_running_file_view I
    invoke-virtual v3, v0, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +ah
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_group_running_file_edit I
    invoke-virtual v3, v0, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v3
    packed-switch-payload 1 2 3 4 5 6 7 8 9 a b c d e f 10 11 12
.end method

.method public final getSummaryTitle(android.content.res.Resources)java.lang.String
    .registers 4
    # ins_size=2
    const-string/jumbo v0, resources
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/grouping/ToolDisplayCategory;->ordinal()I
    move-result v1
    aget v0, v0, v1
    const-string v1, "getString(...)"
    packed-switch v0, +00000c4h
    new-instance v3, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v3, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v3
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_group_summary_mcp_tool I
    invoke-virtual v3, v0, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto/16 +0b1h
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_group_summary_file_edit I
    invoke-virtual v3, v0, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto/16 +0a6h
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_group_done_browser_use I
    invoke-virtual v3, v0, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto/16 +09bh
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_group_done_ask_user I
    invoke-virtual v3, v0, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto/16 +090h
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_group_done_env_init I
    invoke-virtual v3, v0, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto/16 +085h
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_group_done_task_manage I
    invoke-virtual v3, v0, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto/16 +07ah
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_group_done_preview I
    invoke-virtual v3, v0, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto/16 +06fh
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_group_done_thinking I
    invoke-virtual v3, v0, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +64h
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_group_summary_web_search I
    invoke-virtual v3, v0, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +5ah
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_group_summary_file_search I
    invoke-virtual v3, v0, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +50h
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_group_summary_skill I
    invoke-virtual v3, v0, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +46h
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_group_summary_mcp_tool I
    invoke-virtual v3, v0, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +3ch
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_group_summary_command_exec I
    invoke-virtual v3, v0, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +32h
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_group_summary_file_delete I
    invoke-virtual v3, v0, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +28h
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_group_summary_folder_view I
    invoke-virtual v3, v0, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +1eh
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_group_summary_file_create I
    invoke-virtual v3, v0, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +14h
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_group_summary_file_view I
    invoke-virtual v3, v0, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +ah
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_group_summary_file_edit I
    invoke-virtual v3, v0, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v3
    packed-switch-payload 1 2 3 4 5 6 7 8 9 a b c d e f 10 11 12
.end method
