# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory$Companion;
.super Ljava/lang/Object;
.source "ToolListFragment.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory$Companion;-><init>()V
    return-void 
.end method

.method public final fromToolName(java.lang.String)com.bytedance.trae.conversation.chat.detail.ToolListFragment$ToolCategory
    .registers 6
    # ins_size=2
    if-nez v5, +005h
    sget-object v5, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->FALLBACK Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
    return-object v5
    invoke-static Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->access$getEDIT_FILE_NAMES$cp()Ljava/util/Set;
    move-result-object v0
    invoke-interface v0, v5, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +006h
    sget-object v5, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->EDIT_FILE Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
    goto/16 +0c5h
    invoke-static Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->access$getCREATE_FILE_NAMES$cp()Ljava/util/Set;
    move-result-object v0
    invoke-interface v0, v5, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +006h
    sget-object v5, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->CREATE_FILE Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
    goto/16 +0b7h
    invoke-static Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->access$getVIEW_FILE_NAMES$cp()Ljava/util/Set;
    move-result-object v0
    invoke-interface v0, v5, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +006h
    sget-object v5, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->VIEW_FILE Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
    goto/16 +0a9h
    invoke-static Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->access$getCODE_SEARCH_NAMES$cp()Ljava/util/Set;
    move-result-object v0
    invoke-interface v0, v5, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +006h
    sget-object v5, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->CODE_SEARCH Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
    goto/16 +09bh
    invoke-static Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->access$getWEB_SEARCH_NAMES$cp()Ljava/util/Set;
    move-result-object v0
    invoke-interface v0, v5, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +006h
    sget-object v5, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->WEB_SEARCH Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
    goto/16 +08dh
    invoke-static Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->access$getRUN_COMMAND_NAMES$cp()Ljava/util/Set;
    move-result-object v0
    invoke-interface v0, v5, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +006h
    sget-object v5, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->RUN_COMMAND Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
    goto/16 +07fh
    invoke-static Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->access$getTODO_NAMES$cp()Ljava/util/Set;
    move-result-object v0
    invoke-interface v0, v5, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +006h
    sget-object v5, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->TODO_LIST Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
    goto/16 +071h
    const/4 v0, 2
    const/4 v1, 0
    const-string v2, "browser_"
    const/4 v3, 0
    invoke-static v5, v2, v3, v0, v1, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +064h
    const-string v0, "BrowserHandOver"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +05ch
    const-string v0, "BrowserWaitingForUserInteraction"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    goto +52h
    invoke-static Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->access$getOPEN_PREVIEW_NAMES$cp()Ljava/util/Set;
    move-result-object v0
    invoke-interface v0, v5, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +005h
    sget-object v5, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->OPEN_PREVIEW Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
    goto +47h
    invoke-static Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->access$getMCP_NAMES$cp()Ljava/util/Set;
    move-result-object v0
    invoke-interface v0, v5, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +005h
    sget-object v5, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->MCP Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
    goto +3ah
    invoke-static Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->access$getSKILL_NAMES$cp()Ljava/util/Set;
    move-result-object v0
    invoke-interface v0, v5, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +005h
    sget-object v5, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->SKILL Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
    goto +2dh
    invoke-static Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->access$getASK_USER_NAMES$cp()Ljava/util/Set;
    move-result-object v0
    invoke-interface v0, v5, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +005h
    sget-object v5, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->ASK_USER Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
    goto +20h
    invoke-static Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->access$getENVIRONMENT_SETUP_NAMES$cp()Ljava/util/Set;
    move-result-object v0
    invoke-interface v0, v5, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +005h
    sget-object v5, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->ENVIRONMENT_SETUP Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
    goto +13h
    invoke-static Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->access$getIMAGE_GENERATE_NAMES$cp()Ljava/util/Set;
    move-result-object v0
    invoke-interface v0, v5, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, +005h
    sget-object v5, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->IMAGE_GENERATE Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
    goto +6h
    sget-object v5, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->FALLBACK Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
    goto +3h
    sget-object v5, Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;->BROWSER Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;
    return-object v5
.end method
