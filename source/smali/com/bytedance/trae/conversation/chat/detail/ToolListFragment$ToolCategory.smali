# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final enum Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
.super Ljava/lang/Enum;
.source "ToolListFragment.kt"

.field private static final synthetic $ENTRIES:Lkotlin/enums/EnumEntries;
.field private static final synthetic $VALUES:[Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
.field public static final enum ASK_USER:Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
.field private static final ASK_USER_NAMES:Ljava/util/Set;
.field public static final enum BROWSER:Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
.field public static final enum CODE_SEARCH:Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
.field private static final CODE_SEARCH_NAMES:Ljava/util/Set;
.field public static final enum CREATE_FILE:Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
.field private static final CREATE_FILE_NAMES:Ljava/util/Set;
.field public static final Companion:Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory$Companion;
.field public static final enum EDIT_FILE:Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
.field private static final EDIT_FILE_NAMES:Ljava/util/Set;
.field public static final enum ENVIRONMENT_SETUP:Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
.field private static final ENVIRONMENT_SETUP_NAMES:Ljava/util/Set;
.field public static final enum FALLBACK:Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
.field public static final enum IMAGE_GENERATE:Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
.field private static final IMAGE_GENERATE_NAMES:Ljava/util/Set;
.field public static final enum MCP:Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
.field private static final MCP_NAMES:Ljava/util/Set;
.field public static final enum OPEN_PREVIEW:Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
.field private static final OPEN_PREVIEW_NAMES:Ljava/util/Set;
.field public static final enum RUN_COMMAND:Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
.field private static final RUN_COMMAND_NAMES:Ljava/util/Set;
.field public static final enum SKILL:Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
.field private static final SKILL_NAMES:Ljava/util/Set;
.field public static final enum THINKING:Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
.field public static final enum TODO_LIST:Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
.field private static final TODO_NAMES:Ljava/util/Set;
.field public static final enum VIEW_FILE:Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
.field private static final VIEW_FILE_NAMES:Ljava/util/Set;
.field public static final enum WEB_SEARCH:Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
.field private static final WEB_SEARCH_NAMES:Ljava/util/Set;


.method private static final synthetic $values()com.bytedance.trae.conversation.chat.detail.ToolListFragment$ToolCategory[]
    .registers 3
    # ins_size=0
    const/16 v0, 16
    new-array v0, v0, [Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
    const/4 v1, 0
    sget-object v2, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->EDIT_FILE Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
    aput-object v2, v0, v1
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->CREATE_FILE Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
    aput-object v2, v0, v1
    const/4 v1, 2
    sget-object v2, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->VIEW_FILE Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
    aput-object v2, v0, v1
    const/4 v1, 3
    sget-object v2, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->CODE_SEARCH Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
    aput-object v2, v0, v1
    const/4 v1, 4
    sget-object v2, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->WEB_SEARCH Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
    aput-object v2, v0, v1
    const/4 v1, 5
    sget-object v2, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->RUN_COMMAND Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
    aput-object v2, v0, v1
    const/4 v1, 6
    sget-object v2, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->TODO_LIST Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
    aput-object v2, v0, v1
    const/4 v1, 7
    sget-object v2, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->BROWSER Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
    aput-object v2, v0, v1
    const/16 v1, 8
    sget-object v2, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->OPEN_PREVIEW Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
    aput-object v2, v0, v1
    const/16 v1, 9
    sget-object v2, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->MCP Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
    aput-object v2, v0, v1
    const/16 v1, 10
    sget-object v2, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->SKILL Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
    aput-object v2, v0, v1
    const/16 v1, 11
    sget-object v2, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->ASK_USER Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
    aput-object v2, v0, v1
    const/16 v1, 12
    sget-object v2, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->THINKING Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
    aput-object v2, v0, v1
    const/16 v1, 13
    sget-object v2, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->ENVIRONMENT_SETUP Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
    aput-object v2, v0, v1
    const/16 v1, 14
    sget-object v2, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->IMAGE_GENERATE Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
    aput-object v2, v0, v1
    const/16 v1, 15
    sget-object v2, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->FALLBACK Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
    aput-object v2, v0, v1
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 12
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
    const-string v1, "EDIT_FILE"
    const/4 v2, 0
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->EDIT_FILE Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
    const-string v1, "CREATE_FILE"
    const/4 v2, 1
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->CREATE_FILE Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
    const-string v1, "VIEW_FILE"
    const/4 v2, 2
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->VIEW_FILE Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
    const-string v1, "CODE_SEARCH"
    const/4 v2, 3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->CODE_SEARCH Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
    const-string v1, "WEB_SEARCH"
    const/4 v2, 4
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->WEB_SEARCH Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
    const-string v1, "RUN_COMMAND"
    const/4 v2, 5
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->RUN_COMMAND Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
    const-string v1, "TODO_LIST"
    const/4 v2, 6
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->TODO_LIST Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
    const-string v1, "BROWSER"
    const/4 v2, 7
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->BROWSER Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
    const-string v1, "OPEN_PREVIEW"
    const/16 v2, 8
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->OPEN_PREVIEW Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
    const-string v1, "MCP"
    const/16 v2, 9
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->MCP Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
    const-string v1, "SKILL"
    const/16 v2, 10
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->SKILL Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
    const-string v1, "ASK_USER"
    const/16 v2, 11
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->ASK_USER Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
    const-string v1, "THINKING"
    const/16 v2, 12
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->THINKING Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
    const-string v1, "ENVIRONMENT_SETUP"
    const/16 v2, 13
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->ENVIRONMENT_SETUP Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
    const-string v1, "IMAGE_GENERATE"
    const/16 v2, 14
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->IMAGE_GENERATE Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
    const-string v1, "FALLBACK"
    const/16 v2, 15
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->FALLBACK Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
    invoke-static Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->$values()[Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->$VALUES [Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
    check-cast v0, [Ljava/lang/Enum;
    invoke-static v0, Lkotlin/enums/EnumEntriesKt;->enumEntries([Ljava/lang/Enum;)Lkotlin/enums/EnumEntries;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->$ENTRIES Lkotlin/enums/EnumEntries;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->Companion Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory$Companion;
    const-string v2, "edit_file_search_replace"
    const-string v3, "Write"
    const-string v4, "Edit"
    const-string v5, "MultiEdit"
    const-string v6, "SearchReplace"
    const-string v7, "edit_file"
    const-string/jumbo v8, write_to_file
    const-string v9, "edit_file_update"
    const-string v10, "delete_file"
    const-string v11, "DeleteFile"
    filled-new-array/range v2 ... v11, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->EDIT_FILE_NAMES Ljava/util/Set;
    const-string v0, "create_file"
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf(Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->CREATE_FILE_NAMES Ljava/util/Set;
    const-string/jumbo v0, view_files
    const-string/jumbo v1, view_folder
    const-string/jumbo v2, view_file
    const-string v3, "Read"
    const-string v4, "LS"
    filled-new-array v2, v3, v4, v0, v1, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->VIEW_FILE_NAMES Ljava/util/Set;
    const-string v1, "file_search"
    const-string v2, "Glob"
    const-string/jumbo v3, search_codebase
    const-string v4, "SearchCodebase"
    const-string/jumbo v5, search_by_regex
    const-string v6, "Grep"
    filled-new-array/range v1 ... v6, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->CODE_SEARCH_NAMES Ljava/util/Set;
    const-string/jumbo v0, web_search
    const-string v1, "WebSearch"
    filled-new-array v0, v1, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->WEB_SEARCH_NAMES Ljava/util/Set;
    const-string v0, "Shell"
    const-string v1, "exec_command"
    const-string/jumbo v2, run_command
    const-string v3, "RunCommand"
    filled-new-array v2, v3, v0, v1, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->RUN_COMMAND_NAMES Ljava/util/Set;
    const-string/jumbo v0, todo_write
    const-string v1, "TodoWrite"
    filled-new-array v0, v1, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->TODO_NAMES Ljava/util/Set;
    const-string v0, "open_preview_and_wait_for_error"
    const-string v1, "open_folder"
    const-string v2, "open_preview"
    const-string v3, "OpenPreview"
    filled-new-array v2, v3, v0, v1, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->OPEN_PREVIEW_NAMES Ljava/util/Set;
    const-string v0, "mcp_call"
    const-string v1, "MCPCall"
    const-string/jumbo v2, run_mcp
    filled-new-array v2, v0, v1, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->MCP_NAMES Ljava/util/Set;
    const-string v0, "Skill"
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf(Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->SKILL_NAMES Ljava/util/Set;
    const-string v0, "AskUserQuestion"
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf(Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->ASK_USER_NAMES Ljava/util/Set;
    const-string v0, "environment_setup"
    const-string v1, "EnvironmentSetup"
    filled-new-array v0, v1, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->ENVIRONMENT_SETUP_NAMES Ljava/util/Set;
    const-string v0, "image_ocr"
    const-string v1, "GenerateImage"
    filled-new-array v0, v1, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->IMAGE_GENERATE_NAMES Ljava/util/Set;
    return-void 
.end method

.method private constructor <init>(java.lang.String  int)void
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Ljava/lang/Enum;-><init>(Ljava/lang/String; I)V
    return-void 
.end method

.method public static final synthetic access$getASK_USER_NAMES$cp()java.util.Set
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->ASK_USER_NAMES Ljava/util/Set;
    return-object v0
.end method

.method public static final synthetic access$getCODE_SEARCH_NAMES$cp()java.util.Set
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->CODE_SEARCH_NAMES Ljava/util/Set;
    return-object v0
.end method

.method public static final synthetic access$getCREATE_FILE_NAMES$cp()java.util.Set
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->CREATE_FILE_NAMES Ljava/util/Set;
    return-object v0
.end method

.method public static final synthetic access$getEDIT_FILE_NAMES$cp()java.util.Set
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->EDIT_FILE_NAMES Ljava/util/Set;
    return-object v0
.end method

.method public static final synthetic access$getENVIRONMENT_SETUP_NAMES$cp()java.util.Set
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->ENVIRONMENT_SETUP_NAMES Ljava/util/Set;
    return-object v0
.end method

.method public static final synthetic access$getIMAGE_GENERATE_NAMES$cp()java.util.Set
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->IMAGE_GENERATE_NAMES Ljava/util/Set;
    return-object v0
.end method

.method public static final synthetic access$getMCP_NAMES$cp()java.util.Set
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->MCP_NAMES Ljava/util/Set;
    return-object v0
.end method

.method public static final synthetic access$getOPEN_PREVIEW_NAMES$cp()java.util.Set
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->OPEN_PREVIEW_NAMES Ljava/util/Set;
    return-object v0
.end method

.method public static final synthetic access$getRUN_COMMAND_NAMES$cp()java.util.Set
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->RUN_COMMAND_NAMES Ljava/util/Set;
    return-object v0
.end method

.method public static final synthetic access$getSKILL_NAMES$cp()java.util.Set
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->SKILL_NAMES Ljava/util/Set;
    return-object v0
.end method

.method public static final synthetic access$getTODO_NAMES$cp()java.util.Set
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->TODO_NAMES Ljava/util/Set;
    return-object v0
.end method

.method public static final synthetic access$getVIEW_FILE_NAMES$cp()java.util.Set
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->VIEW_FILE_NAMES Ljava/util/Set;
    return-object v0
.end method

.method public static final synthetic access$getWEB_SEARCH_NAMES$cp()java.util.Set
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->WEB_SEARCH_NAMES Ljava/util/Set;
    return-object v0
.end method

.method public static getEntries()kotlin.enums.EnumEntries
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-object v0
.end method

.method public static valueOf(java.lang.String)com.bytedance.trae.conversation.chat.detail.ToolListFragment$ToolCategory
    .registers 2
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
    invoke-static v0, v1, Ljava/lang/Enum;->valueOf(Ljava/lang/Class; Ljava/lang/String;)Ljava/lang/Enum;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
    return-object v1
.end method

.method public static values()com.bytedance.trae.conversation.chat.detail.ToolListFragment$ToolCategory[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->$VALUES [Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
    invoke-virtual v0, Ljava/lang/Object;->clone()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, [Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
    return-object v0
.end method
