# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;
.super Ljava/lang/Object;
.source "ChatFirstTokenTracker.kt"

.field private static final AGENT_FLOW_TAG:Ljava/lang/String;
.field private static final EMPTY_TOOLS:Ljava/util/Set;
.field private static final EVENT_NAME:Ljava/lang/String;
.field private static final FE_API_RESPONSE:Ljava/lang/String;
.field private static final FE_FRONT_END_RECEIVE:Ljava/lang/String;
.field private static final FE_SEND:Ljava/lang/String;
.field private static final GET_CUSTOM_MODEL:Ljava/lang/String;
.field public static final INSTANCE:Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;
.field private static final LLM_RESPONSE_FIRST_TOKEN:Ljava/lang/String;
.field private static final NET_PROCESS:Ljava/lang/String;
.field private static final REGISTERED_TOOLS:Ljava/util/Set;
.field private static final SVR_PLATFORM_FIRST_TOKEN_TIMING:Ljava/lang/String;
.field private static final SVR_PROCESSING_TIME:Ljava/lang/String;
.field private static final TAG:Ljava/lang/String;
.field private static final firstTokenFiredTaskIds:Ljava/util/Set;
.field private static final metadataReadyTaskIds:Ljava/util/Set;
.field private static final reportedContexts:Ljava/util/concurrent/ConcurrentHashMap;
.field private static final timingEventsStore:Ljava/util/concurrent/ConcurrentHashMap;
.field private static final trackingContexts:Ljava/util/concurrent/ConcurrentHashMap;


.method static constructor <clinit>()void
    .registers 123
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;
    invoke-direct v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;-><init>()V
    sput-object v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->INSTANCE Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;
    const-string v1, "create_file"
    const-string v2, "CreateFile"
    const-string/jumbo v3, write_to_file
    const-string v4, "Write"
    const-string v5, "WriteToFile"
    const-string v6, "edit_file_search_replace"
    const-string v7, "edit_file_update"
    const-string v8, "Edit"
    const-string v9, "MultiEdit"
    const-string v10, "SearchReplace"
    const-string v11, "EditFile"
    const-string v12, "WriteToProductDocument"
    const-string v13, "EditProductDocumentFastApply"
    const-string v14, "EditProductDocumentUpdate"
    const-string/jumbo v15, write_to_product_document
    const-string v16, "edit_product_document_fast_apply"
    const-string v17, "edit_product_document_update"
    const-string v18, "edit_product_document_update_fc"
    const-string/jumbo v19, show_diff
    const-string/jumbo v20, show_diff_fc
    const-string v21, "delete_file"
    const-string v22, "DeleteFile"
    const-string/jumbo v23, view_file
    const-string v24, "ViewFile"
    const-string v25, "Read"
    const-string/jumbo v26, view_files
    const-string v27, "ViewFiles"
    const-string/jumbo v28, view_folder
    const-string v29, "ViewFolder"
    const-string v30, "LS"
    const-string v31, "open_folder"
    const-string v32, "file_search"
    const-string v33, "FileSearch"
    const-string/jumbo v34, search_by_regex
    const-string v35, "Grep"
    const-string v36, "Glob"
    const-string/jumbo v37, search_codebase
    const-string v38, "SearchCodebase"
    const-string/jumbo v39, web_search
    const-string v40, "WebSearch"
    const-string v41, "WebFetch"
    const-string/jumbo v42, run_command
    const-string v43, "RunCommand"
    const-string v44, "exec_command"
    const-string v45, "Shell"
    const-string v46, "check_command_status"
    const-string v47, "CheckCommandStatus"
    const-string v48, "browser_action"
    const-string v49, "BrowserAction"
    const-string v50, "browser_use"
    const-string v51, "BrowserUse"
    const-string v52, "browser_navigate"
    const-string v53, "browser_navigate_back"
    const-string v54, "browser_navigate_forward"
    const-string v55, "browser_click"
    const-string v56, "browser_type"
    const-string v57, "browser_press_key"
    const-string v58, "browser_scroll"
    const-string v59, "browser_select_option"
    const-string v60, "browser_snapshot"
    const-string v61, "browser_take_screenshot"
    const-string v62, "browser_fill"
    const-string v63, "browser_wait_for"
    const-string v64, "browser_hover"
    const-string v65, "browser_get_attribute"
    const-string v66, "browser_lock"
    const-string v67, "browser_unlock"
    const-string v68, "browser_console_messages"
    const-string v69, "browser_drag"
    const-string v70, "browser_evaluate"
    const-string v71, "browser_fill_form"
    const-string v72, "browser_get_bounding_box"
    const-string v73, "browser_get_input_value"
    const-string v74, "browser_handle_dialog"
    const-string v75, "browser_highlight"
    const-string v76, "browser_is_checked"
    const-string v77, "browser_is_enabled"
    const-string v78, "browser_is_visible"
    const-string v79, "browser_network_requests"
    const-string v80, "browser_reload"
    const-string v81, "browser_resize"
    const-string v82, "browser_search"
    const-string v83, "browser_tabs"
    const-string v84, "browser_waiting_for_user_interaction"
    const-string v85, "browser_hand_over"
    const-string/jumbo v86, todo_write
    const-string v87, "TodoWrite"
    const-string v88, "AskUserQuestion"
    const-string v89, "NotifyUser"
    const-string v90, "ExitPlanMode"
    const-string v91, "Schedule"
    const-string v92, "finish"
    const-string v93, "Finish"
    const-string/jumbo v94, response_to_user
    const-string v95, "ResponseToUser"
    const-string v96, "agent_finish"
    const-string v97, "Task"
    const-string/jumbo v98, run_mcp
    const-string v99, "mcp_call"
    const-string v100, "MCPCall"
    const-string v101, "Skill"
    const-string v102, "open_preview"
    const-string v103, "OpenPreview"
    const-string v104, "open_preview_and_wait_for_error"
    const-string v105, "environment_setup"
    const-string v106, "EnvironmentSetup"
    const-string v107, "init_env"
    const-string v108, "image_ocr"
    const-string v109, "CompactFake"
    const-string v110, "GenerateImage"
    const-string v111, "manage_core_memory"
    const-string v112, "ManageCoreMemory"
    const-string v113, "get_preview_console_logs"
    const-string v114, "deploy_to_remote"
    const-string/jumbo v115, update_shallow_memento
    const-string/jumbo v116, update_shallow_memento_fc
    const-string v117, "condense_shallow_memento"
    const-string v118, "get_llm_config"
    const-string/jumbo v119, supabase_get_project
    const-string/jumbo v120, supabase_apply_migration
    const-string/jumbo v121, stripe_get_config
    const-string v122, "create_requirement"
    filled-new-array/range v1 ... v122, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->REGISTERED_TOOLS Ljava/util/Set;
    const-string v0, "check_command_status"
    const-string v1, "CheckCommandStatus"
    filled-new-array v0, v1, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->EMPTY_TOOLS Ljava/util/Set;
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;
    invoke-direct v0, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V
    sput-object v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->trackingContexts Ljava/util/concurrent/ConcurrentHashMap;
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;
    invoke-direct v0, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V
    check-cast v0, Ljava/util/Map;
    invoke-static v0, Ljava/util/Collections;->newSetFromMap(Ljava/util/Map;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->metadataReadyTaskIds Ljava/util/Set;
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;
    invoke-direct v0, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V
    check-cast v0, Ljava/util/Map;
    invoke-static v0, Ljava/util/Collections;->newSetFromMap(Ljava/util/Map;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->firstTokenFiredTaskIds Ljava/util/Set;
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;
    invoke-direct v0, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V
    sput-object v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->timingEventsStore Ljava/util/concurrent/ConcurrentHashMap;
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;
    invoke-direct v0, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V
    sput-object v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->reportedContexts Ljava/util/concurrent/ConcurrentHashMap;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final calculateAndPutStepDurations(org.json.JSONObject  java.util.Map  long  long  long)void
    .registers 37
    # ins_size=9
    move-object/from16 v0, v29
    move-wide/from16 v1, v31
    move-wide/from16 v3, v33
    move-wide/from16 v5, v35
    new-instance v7, Ljava/util/LinkedHashMap;
    invoke-direct v7, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v7, Ljava/util/Map;
    move-object/from16 v8, v30
    invoke-interface v7, v8, Ljava/util/Map;->putAll(Ljava/util/Map;)V
    long-to-double v8, v1
    invoke-static v8, v9, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;
    move-result-object v8
    const-string v9, "fe_00_send"
    invoke-interface v7, v9, v8, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const-wide/16 v8, 0
    cmp-long v10, v3, v8
    if-lez v10, +00ch
    long-to-double v3, v3
    invoke-static v3, v4, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;
    move-result-object v3
    const-string v4, "fe_01_send_response"
    invoke-interface v7, v4, v3, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    long-to-double v3, v5
    invoke-static v3, v4, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;
    move-result-object v3
    const-string v4, "fe_02_receive"
    invoke-interface v7, v4, v3, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sub-long v1, v5, v1
    invoke-interface v7, Ljava/util/Map;->keySet()Ljava/util/Set;
    move-result-object v3
    check-cast v3, Ljava/lang/Iterable;
    new-instance v4, Ljava/util/ArrayList;
    invoke-direct v4, Ljava/util/ArrayList;-><init>()V
    check-cast v4, Ljava/util/Collection;
    invoke-interface v3, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    const/4 v6, 0
    const/4 v10, 2
    const/4 v11, 0
    if-eqz v5, +016h
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    move-object v12, v5
    check-cast v12, Ljava/lang/String;
    const-string/jumbo v13, rs_06_resolver_
    invoke-static v12, v13, v11, v10, v6, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v6
    if-eqz v6, -017h
    invoke-interface v4, v5, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1ch
    check-cast v4, Ljava/util/List;
    invoke-interface v4, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v3
    const-string v12, ""
    const-wide/16 v13, 0
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v15
    if-eqz v15, +01fh
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v15
    check-cast v15, Ljava/lang/String;
    invoke-interface v7, v15, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v16
    check-cast v16, Ljava/lang/Double;
    if-eqz v16, -012h
    invoke-virtual/range v16, Ljava/lang/Double;->doubleValue()D
    move-result-wide v16
    cmpl-double v18, v16, v13
    if-lez v18, +005h
    move-object v12, v15
    move-wide/from16 v13, v16
    invoke-interface v7, v15, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    goto -22h
    const-string/jumbo v3, svr_11_server_processing_time
    invoke-interface v7, v3, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/lang/Double;
    if-eqz v3, +007h
    invoke-virtual v3, Ljava/lang/Double;->doubleValue()D
    move-result-wide v15
    goto +3h
    const-wide/16 v15, 0
    const-string/jumbo v3, svr_06_platform_first_token_timing
    invoke-interface v7, v3, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/lang/Double;
    if-eqz v3, +009h
    invoke-virtual v3, Ljava/lang/Double;->doubleValue()D
    move-result-wide v17
    move-wide/from16 v4, v17
    goto +3h
    const-wide/16 v4, 0
    sub-double v8, v15, v4
    new-instance v3, Ljava/util/LinkedHashMap;
    invoke-direct v3, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v3, Ljava/util/Map;
    invoke-interface v7, Ljava/util/Map;->entrySet()Ljava/util/Set;
    move-result-object v19
    invoke-interface/range v19, Ljava/util/Set;->iterator()Ljava/util/Iterator;
    move-result-object v19
    invoke-interface/range v19, Ljava/util/Iterator;->hasNext()Z
    move-result v20
    const-string/jumbo v6, svr_
    if-eqz v20, +028h
    invoke-interface/range v19, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v20
    check-cast v20, Ljava/util/Map$Entry;
    invoke-interface/range v20, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v21
    move-wide/from16 v33, v4
    move-object/from16 v4, v21
    check-cast v4, Ljava/lang/String;
    const/4 v5, 0
    invoke-static v4, v6, v11, v10, v5, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +00dh
    invoke-interface/range v20, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v4
    invoke-interface/range v20, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v5
    invoke-interface v3, v4, v5, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    move-wide/from16 v4, v33
    const/4 v6, 0
    goto -2eh
    move-wide/from16 v33, v4
    invoke-interface v3, Ljava/util/Map;->entrySet()Ljava/util/Set;
    move-result-object v3
    invoke-interface v3, Ljava/util/Set;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +01fh
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Ljava/util/Map$Entry;
    invoke-interface v4, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Ljava/lang/String;
    invoke-interface v4, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Ljava/lang/Number;
    invoke-virtual v4, Ljava/lang/Number;->doubleValue()D
    move-result-wide v10
    double-to-long v10, v10
    invoke-virtual v0, v5, v10, v11, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const/4 v10, 2
    const/4 v11, 0
    goto -22h
    new-instance v3, Ljava/util/LinkedHashMap;
    invoke-direct v3, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v3, Ljava/util/Map;
    invoke-interface v7, Ljava/util/Map;->entrySet()Ljava/util/Set;
    move-result-object v4
    invoke-interface v4, Ljava/util/Set;->iterator()Ljava/util/Iterator;
    move-result-object v4
    invoke-interface v4, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    if-eqz v5, +067h
    invoke-interface v4, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Ljava/util/Map$Entry;
    invoke-interface v5, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v10
    check-cast v10, Ljava/lang/String;
    invoke-interface v5, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Ljava/lang/Number;
    invoke-virtual v5, Ljava/lang/Number;->doubleValue()D
    move-result-wide v19
    move-object/from16 v32, v4
    const/4 v4, 0
    const/4 v5, 0
    const/4 v11, 2
    invoke-static v10, v6, v4, v11, v5, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v21
    if-nez v21, +043h
    move-object/from16 v22, v10
    check-cast v22, Ljava/lang/CharSequence;
    const-string v4, "_"
    filled-new-array v4, [Ljava/lang/String;
    move-result-object v23
    const/16 v24, 0
    const/16 v25, 0
    const/16 v26, 6
    const/16 v27, 0
    invoke-static/range v22 ... v27, Lkotlin/text/StringsKt;->split$default(Ljava/lang/CharSequence; [Ljava/lang/String; Z I I Ljava/lang/Object;)Ljava/util/List;
    move-result-object v4
    const/4 v11, 0
    invoke-interface v4, v11, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Ljava/lang/String;
    invoke-interface v3, v4, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v21
    if-nez v21, +010h
    new-instance v21, Ljava/util/ArrayList;
    invoke-direct/range v21, Ljava/util/ArrayList;-><init>()V
    move-object/from16 v5, v21
    check-cast v5, Ljava/util/List;
    invoke-interface v3, v4, v5, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    move-object/from16 v21, v5
    move-object/from16 v4, v21
    check-cast v4, Ljava/util/List;
    new-instance v5, Lkotlin/Pair;
    invoke-static/range v19 ... v20, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;
    move-result-object v11
    invoke-direct v5, v10, v11, Lkotlin/Pair;-><init>(Ljava/lang/Object; Ljava/lang/Object;)V
    invoke-interface v4, v5, Ljava/util/List;->add(Ljava/lang/Object;)Z
    move-object/from16 v4, v32
    goto -6ah
    const-string/jumbo v4, rs_18_llm_response_first_token
    invoke-interface v7, v4, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Ljava/lang/Double;
    invoke-interface v3, Ljava/util/Map;->entrySet()Ljava/util/Set;
    move-result-object v6
    invoke-interface v6, Ljava/util/Set;->iterator()Ljava/util/Iterator;
    move-result-object v6
    const/16 v22, 0
    invoke-interface v6, Ljava/util/Iterator;->hasNext()Z
    move-result v10
    if-eqz v10, +096h
    invoke-interface v6, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v10
    check-cast v10, Ljava/util/Map$Entry;
    invoke-interface v10, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v10
    check-cast v10, Ljava/util/List;
    invoke-interface v10, Ljava/util/List;->size()I
    move-result v11
    move-object/from16 v19, v6
    const/4 v6, 2
    if-lt v11, v6, +07dh
    invoke-interface v10, Ljava/util/List;->size()I
    move-result v6
    const/4 v11, 1
    if-le v6, v11, +00ch
    new-instance v6, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$calculateAndPutStepDurations$$inlined$sortBy$1;
    invoke-direct v6, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$calculateAndPutStepDurations$$inlined$sortBy$1;-><init>()V
    check-cast v6, Ljava/util/Comparator;
    invoke-static v10, v6, Lkotlin/collections/CollectionsKt;->sortWith(Ljava/util/List; Ljava/util/Comparator;)V
    invoke-interface v10, Ljava/util/List;->size()I
    move-result v6
    const/4 v11, 1
    if-ge v11, v6, +065h
    invoke-interface v10, v11, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v20
    check-cast v20, Lkotlin/Pair;
    invoke-virtual/range v20, Lkotlin/Pair;->getSecond()Ljava/lang/Object;
    move-result-object v20
    check-cast v20, Ljava/lang/Number;
    invoke-virtual/range v20, Ljava/lang/Number;->doubleValue()D
    move-result-wide v20
    move/from16 v23, v6
    add-int/lit8 v6, v11, -1
    invoke-interface v10, v6, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v24
    check-cast v24, Lkotlin/Pair;
    invoke-virtual/range v24, Lkotlin/Pair;->getSecond()Ljava/lang/Object;
    move-result-object v24
    check-cast v24, Ljava/lang/Number;
    invoke-virtual/range v24, Ljava/lang/Number;->doubleValue()D
    move-result-wide v24
    move-wide/from16 v26, v1
    sub-double v1, v20, v24
    invoke-interface v10, v11, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v20
    check-cast v20, Lkotlin/Pair;
    invoke-virtual/range v20, Lkotlin/Pair;->getFirst()Ljava/lang/Object;
    move-result-object v20
    move-object/from16 v21, v3
    move-object/from16 v3, v20
    check-cast v3, Ljava/lang/String;
    double-to-long v1, v1
    invoke-virtual v0, v3, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    invoke-interface v10, v11, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lkotlin/Pair;
    invoke-virtual v1, Lkotlin/Pair;->getFirst()Ljava/lang/Object;
    move-result-object v1
    invoke-static v1, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +010h
    invoke-interface v10, v6, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lkotlin/Pair;
    invoke-virtual v1, Lkotlin/Pair;->getSecond()Ljava/lang/Object;
    move-result-object v1
    move-object/from16 v22, v1
    check-cast v22, Ljava/lang/Double;
    add-int/lit8 v11, v11, 1
    move-object/from16 v3, v21
    move/from16 v6, v23
    move-wide/from16 v1, v26
    goto -64h
    move-object/from16 v6, v19
    goto/16 -098h
    move-wide/from16 v26, v1
    move-object/from16 v21, v3
    const-string v1, "net_01_process"
    if-eqz v22, +012h
    if-eqz v5, +010h
    invoke-virtual v5, Ljava/lang/Double;->doubleValue()D
    move-result-wide v2
    invoke-virtual/range v22, Ljava/lang/Double;->doubleValue()D
    move-result-wide v4
    sub-double/2addr v2, v4
    sub-double/2addr v2, v15
    double-to-long v2, v2
    invoke-virtual v0, v1, v2, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    move-object v2, v12
    check-cast v2, Ljava/lang/CharSequence;
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v2
    if-lez v2, +004h
    const/4 v11, 1
    goto +2h
    const/4 v11, 0
    if-eqz v11, +019h
    const-string/jumbo v2, rs_06_get_custom_model
    invoke-interface v7, v2, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/Double;
    if-eqz v2, +007h
    invoke-virtual v2, Ljava/lang/Double;->doubleValue()D
    move-result-wide v4
    goto +3h
    const-wide/16 v4, 0
    sub-double/2addr v13, v4
    double-to-long v2, v13
    invoke-virtual v0, v12, v2, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    invoke-virtual v0, v1, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z
    move-result v2
    if-eqz v2, +007h
    invoke-virtual v0, v1, Lorg/json/JSONObject;->getLong(Ljava/lang/String;)J
    move-result-wide v1
    goto +3h
    const-wide/16 v1, 0
    double-to-long v3, v8
    sub-long v5, v26, v3
    move-wide/from16 v7, v33
    double-to-long v7, v7
    sub-long/2addr v5, v7
    sub-long/2addr v5, v1
    const-string/jumbo v1, svr_cost
    invoke-virtual v0, v1, v3, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string v1, "llm_cost"
    invoke-virtual v0, v1, v7, v8, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string v1, "client_cost"
    invoke-virtual v0, v1, v5, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    new-instance v1, Ljava/util/LinkedHashMap;
    invoke-direct v1, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v1, Ljava/util/Map;
    invoke-interface/range v21, Ljava/util/Map;->entrySet()Ljava/util/Set;
    move-result-object v2
    invoke-interface v2, Ljava/util/Set;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +022h
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/util/Map$Entry;
    invoke-interface v3, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v4
    const-string v5, "fe"
    invoke-static v4, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    const/4 v5, 1
    xor-int/2addr v4, v5
    if-eqz v4, -018h
    invoke-interface v3, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v4
    invoke-interface v3, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v3
    invoke-interface v1, v4, v3, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    goto -25h
    invoke-interface v1, Ljava/util/Map;->values()Ljava/util/Collection;
    move-result-object v1
    check-cast v1, Ljava/lang/Iterable;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    const-wide/16 v2, 0
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +036h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Ljava/util/List;
    invoke-interface v4, Ljava/util/List;->size()I
    move-result v5
    const/4 v6, 2
    if-lt v5, v6, +025h
    invoke-static v4, Lkotlin/collections/CollectionsKt;->last(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lkotlin/Pair;
    invoke-virtual v5, Lkotlin/Pair;->getSecond()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Ljava/lang/Number;
    invoke-virtual v5, Ljava/lang/Number;->doubleValue()D
    move-result-wide v7
    invoke-static v4, Lkotlin/collections/CollectionsKt;->first(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lkotlin/Pair;
    invoke-virtual v4, Lkotlin/Pair;->getSecond()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Ljava/lang/Number;
    invoke-virtual v4, Ljava/lang/Number;->doubleValue()D
    move-result-wide v4
    sub-double/2addr v7, v4
    double-to-long v4, v7
    goto +3h
    const-wide/16 v4, 0
    add-long/2addr v2, v4
    goto -39h
    sub-long v1, v26, v2
    const-string v3, "hop"
    invoke-virtual v0, v3, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    return-void 
.end method

.method public static synthetic onMetadata$default(com.bytedance.trae.im.track.ChatFirstTokenTracker  java.lang.String  com.bytedance.trae.im.service.ChatEventPayload$Metadata  java.lang.String  int  java.lang.Object)void
    .registers 6
    # ins_size=6
    and-int/lit8 v4, v4, 4
    if-eqz v4, +003h
    const/4 v3, 0
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->onMetadata(Ljava/lang/String; Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata; Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic onSendMessage$default(com.bytedance.trae.im.track.ChatFirstTokenTracker  java.lang.String  java.lang.String  java.lang.String  boolean  int  int  java.lang.Object)void
    .registers 14
    # ins_size=8
    and-int/lit8 v12, v12, 4
    if-eqz v12, +004h
    const-string v9, ""
    move-object v3, v9
    move-object v0, v6
    move-object v1, v7
    move-object v2, v8
    move v4, v10
    move v5, v11
    invoke-virtual/range v0 ... v5, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->onSendMessage(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z I)V
    return-void 
.end method

.method public static synthetic updateMetadata$default(com.bytedance.trae.im.track.ChatFirstTokenTracker  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Boolean  java.lang.String  java.lang.String  java.lang.String  java.lang.Integer  java.lang.String  java.lang.String  java.lang.String  int  java.lang.Object)void
    .registers 31
    # ins_size=17
    move/from16 v0, v29
    and-int/lit8 v1, v0, 2
    const/4 v2, 0
    if-eqz v1, +004h
    move-object v1, v2
    goto +3h
    move-object/from16 v1, v16
    and-int/lit8 v3, v0, 4
    if-eqz v3, +004h
    move-object v3, v2
    goto +3h
    move-object/from16 v3, v17
    and-int/lit8 v4, v0, 8
    if-eqz v4, +004h
    move-object v4, v2
    goto +3h
    move-object/from16 v4, v18
    and-int/lit8 v5, v0, 16
    if-eqz v5, +004h
    move-object v5, v2
    goto +3h
    move-object/from16 v5, v19
    and-int/lit8 v6, v0, 32
    if-eqz v6, +004h
    move-object v6, v2
    goto +3h
    move-object/from16 v6, v20
    and-int/lit8 v7, v0, 64
    if-eqz v7, +004h
    move-object v7, v2
    goto +3h
    move-object/from16 v7, v21
    and-int/lit16 v8, v0, 128
    if-eqz v8, +004h
    move-object v8, v2
    goto +3h
    move-object/from16 v8, v22
    and-int/lit16 v9, v0, 256
    if-eqz v9, +004h
    move-object v9, v2
    goto +3h
    move-object/from16 v9, v23
    and-int/lit16 v10, v0, 512
    if-eqz v10, +004h
    move-object v10, v2
    goto +3h
    move-object/from16 v10, v24
    and-int/lit16 v11, v0, 1024
    if-eqz v11, +004h
    move-object v11, v2
    goto +3h
    move-object/from16 v11, v25
    and-int/lit16 v12, v0, 2048
    if-eqz v12, +004h
    move-object v12, v2
    goto +3h
    move-object/from16 v12, v26
    and-int/lit16 v13, v0, 4096
    if-eqz v13, +004h
    move-object v13, v2
    goto +3h
    move-object/from16 v13, v27
    and-int/lit16 v0, v0, 8192
    if-eqz v0, +003h
    goto +3h
    move-object/from16 v2, v28
    move-object/from16 v16, v14
    move-object/from16 v17, v15
    move-object/from16 v18, v1
    move-object/from16 v19, v3
    move-object/from16 v20, v4
    move-object/from16 v21, v5
    move-object/from16 v22, v6
    move-object/from16 v23, v7
    move-object/from16 v24, v8
    move-object/from16 v25, v9
    move-object/from16 v26, v10
    move-object/from16 v27, v11
    move-object/from16 v28, v12
    move-object/from16 v29, v13
    move-object/from16 v30, v2
    invoke-virtual/range v16 ... v30, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->updateMetadata(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public final checkAndFireFirstToken(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String)boolean
    .registers 18
    # ins_size=6
    move-object v1, v13
    move-object/from16 v7, v17
    const-string/jumbo v0, taskId
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "conversationId"
    move-object v2, v14
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->metadataReadyTaskIds Ljava/util/Set;
    invoke-interface v0, v13, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v0
    const/4 v3, 0
    if-nez v0, +003h
    return v3
    sget-object v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->trackingContexts Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v0, v13, Ljava/util/concurrent/ConcurrentHashMap;->containsKey(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    return v3
    sget-object v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->firstTokenFiredTaskIds Ljava/util/Set;
    invoke-interface v0, v13, Ljava/util/Set;->add(Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +003h
    return v3
    move-object v4, v15
    check-cast v4, Ljava/lang/CharSequence;
    const/4 v10, 1
    if-eqz v4, +00bh
    invoke-static v4, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v4
    if-eqz v4, +003h
    goto +3h
    move v4, v3
    goto +2h
    move v4, v10
    xor-int/lit8 v5, v4, 1
    move-object/from16 v4, v16
    check-cast v4, Ljava/lang/CharSequence;
    if-eqz v4, +00bh
    invoke-static v4, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v4
    if-eqz v4, +003h
    goto +3h
    move v4, v3
    goto +2h
    move v4, v10
    xor-int/lit8 v6, v4, 1
    if-eqz v7, +014h
    sget-object v4, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->REGISTERED_TOOLS Ljava/util/Set;
    invoke-interface v4, v7, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +00ch
    sget-object v4, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->EMPTY_TOOLS Ljava/util/Set;
    invoke-interface v4, v7, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +004h
    move v4, v10
    goto +2h
    move v4, v3
    if-nez v5, +00ah
    if-nez v6, +008h
    if-nez v4, +006h
    invoke-interface v0, v13, Ljava/util/Set;->remove(Ljava/lang/Object;)Z
    return v3
    sget-object v4, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->timingEventsStore Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v4, v13, Ljava/util/concurrent/ConcurrentHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v8
    check-cast v8, Lkotlin/Pair;
    if-nez v8, +006h
    invoke-interface v0, v13, Ljava/util/Set;->remove(Ljava/lang/Object;)Z
    return v3
    invoke-virtual v4, v13, Ljava/util/concurrent/ConcurrentHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v3
    invoke-virtual v8, Lkotlin/Pair;->getFirst()Ljava/lang/Object;
    move-result-object v0
    move-object v9, v0
    check-cast v9, Ljava/util/Map;
    invoke-virtual v8, Lkotlin/Pair;->getSecond()Ljava/lang/Object;
    move-result-object v0
    move-object v11, v0
    check-cast v11, Lcom/bytedance/trae/im/service/IMService$TimingMeta;
    move-object v0, v12
    move-object v1, v13
    move-object v2, v14
    move-object/from16 v7, v17
    move-object v8, v9
    move-object v9, v11
    invoke-virtual/range v0 ... v9, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->onFirstToken(Ljava/lang/String; Ljava/lang/String; J Z Z Ljava/lang/String; Ljava/util/Map; Lcom/bytedance/trae/im/service/IMService$TimingMeta;)V
    return v10
.end method

.method public final clear(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, taskId
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->trackingContexts Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v0, v2, Ljava/util/concurrent/ConcurrentHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->reportedContexts Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v0, v2, Ljava/util/concurrent/ConcurrentHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->metadataReadyTaskIds Ljava/util/Set;
    invoke-interface v0, v2, Ljava/util/Set;->remove(Ljava/lang/Object;)Z
    sget-object v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->firstTokenFiredTaskIds Ljava/util/Set;
    invoke-interface v0, v2, Ljava/util/Set;->remove(Ljava/lang/Object;)Z
    sget-object v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->timingEventsStore Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v0, v2, Ljava/util/concurrent/ConcurrentHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method public final clearReported(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, taskId
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->reportedContexts Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v0, v2, Ljava/util/concurrent/ConcurrentHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method public final getReportedContext(java.lang.String)com.bytedance.trae.im.track.ChatFirstTokenTracker$FirstTokenReportedContext
    .registers 3
    # ins_size=2
    const-string/jumbo v0, taskId
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->reportedContexts Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v0, v2, Ljava/util/concurrent/ConcurrentHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$FirstTokenReportedContext;
    return-object v2
.end method

.method public final getTrackingContext(java.lang.String)com.bytedance.trae.im.track.ChatFirstTokenTracker$TrackingContext
    .registers 3
    # ins_size=2
    const-string/jumbo v0, taskId
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->trackingContexts Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v0, v2, Ljava/util/concurrent/ConcurrentHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;
    return-object v2
.end method

.method public final hasFirstTokenFired(java.lang.String)boolean
    .registers 3
    # ins_size=2
    const-string/jumbo v0, taskId
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->firstTokenFiredTaskIds Ljava/util/Set;
    invoke-interface v0, v2, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v2
    return v2
.end method

.method public final migrateTo(java.lang.String  java.lang.String)void
    .registers 4
    # ins_size=3
    const-string v0, "oldKey"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "newTaskId"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->trackingContexts Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v0, v2, Ljava/util/concurrent/ConcurrentHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;
    if-nez v2, +003h
    return-void 
    check-cast v0, Ljava/util/Map;
    invoke-interface v0, v3, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method public final onFirstToken(java.lang.String  java.lang.String  long  boolean  boolean  java.lang.String  java.util.Map  com.bytedance.trae.im.service.IMService$TimingMeta)void
    .registers 23
    # ins_size=10
    move-object v0, v14
    const-string/jumbo v1, taskId
    invoke-static v14, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "conversationId"
    move-object v2, v15
    invoke-static v15, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->trackingContexts Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v1, v14, Ljava/util/concurrent/ConcurrentHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;
    if-nez v1, +01fh
    sget-object v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "onFirstToken: no tracking context for taskId="
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v14, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v2, ", skip report"
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    const-string v2, "ChatFirstTokenTracker"
    invoke-virtual v1, v2, v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    invoke-virtual v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->getStartTime()J
    move-result-wide v2
    sub-long v2, v16, v2
    if-eqz v22, +008h
    invoke-virtual/range v22, Lcom/bytedance/trae/im/service/IMService$TimingMeta;->getModelName()Ljava/lang/String;
    move-result-object v4
    if-nez v4, +006h
    invoke-virtual v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->getModel()Ljava/lang/String;
    move-result-object v4
    new-instance v10, Lorg/json/JSONObject;
    invoke-direct v10, Lorg/json/JSONObject;-><init>()V
    invoke-virtual v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->getStartTime()J
    move-result-wide v5
    const-string/jumbo v7, startTime
    invoke-virtual v10, v7, v5, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string/jumbo v5, status
    const-string v6, "Success"
    invoke-virtual v10, v5, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v5, sessionId
    invoke-virtual v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->getSessionId()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v10, v5, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v5, "model"
    invoke-virtual v10, v5, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v4, "agentType"
    invoke-virtual v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->getAgentType()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v10, v4, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v4, true
    const-string v5, "false"
    if-eqz v18, +004h
    move-object v6, v4
    goto +2h
    move-object v6, v5
    const-string v8, "hasThought"
    invoke-virtual v10, v8, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    if-eqz v19, +004h
    move-object v6, v4
    goto +2h
    move-object v6, v5
    const-string v8, "hasReasoning"
    invoke-virtual v10, v8, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->getHasText()Z
    move-result v6
    if-eqz v6, +003h
    goto +2h
    move-object v4, v5
    const-string v5, "hasText"
    invoke-virtual v10, v5, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v4, "imageCount"
    invoke-virtual v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->getImageCount()I
    move-result v5
    invoke-virtual v10, v4, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    const-string v4, ""
    if-nez v20, +004h
    move-object v5, v4
    goto +3h
    move-object/from16 v5, v20
    const-string v6, "planItemName"
    invoke-virtual v10, v6, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->getQueued()Z
    move-result v5
    const-string v6, "queued"
    invoke-virtual v10, v6, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    invoke-virtual v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->getQueued()Z
    move-result v5
    const-wide/16 v8, 0
    if-eqz v5, +01eh
    invoke-virtual v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->getQueueStartTime()J
    move-result-wide v5
    cmp-long v5, v5, v8
    if-lez v5, +016h
    const-string v5, "queueStartTime"
    invoke-virtual v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->getQueueStartTime()J
    move-result-wide v11
    invoke-virtual v10, v5, v11, v12, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    invoke-virtual v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->getQueueStartTime()J
    move-result-wide v5
    sub-long v5, v16, v5
    const-string v11, "queueCostTime"
    invoke-virtual v10, v11, v5, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    invoke-virtual v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->getTraceId()Ljava/lang/String;
    move-result-object v5
    if-nez v5, +003h
    move-object v5, v4
    const-string/jumbo v6, traceId
    invoke-virtual v10, v6, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->getModelStrategy()Ljava/lang/String;
    move-result-object v5
    if-nez v5, +004h
    const-string v5, "auto"
    const-string v6, "modelStrategy"
    invoke-virtual v10, v6, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->getConfigSource()Ljava/lang/String;
    move-result-object v5
    if-nez v5, +003h
    move-object v5, v4
    const-string v6, "configSource"
    invoke-virtual v10, v6, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->getProvider()Ljava/lang/String;
    move-result-object v5
    if-nez v5, +003h
    move-object v5, v4
    const-string v6, "provider"
    invoke-virtual v10, v6, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->getChatProcessVersion()Ljava/lang/String;
    move-result-object v5
    if-nez v5, +003h
    move-object v5, v4
    const-string v6, "chatProcessVersion"
    invoke-virtual v10, v6, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->getAgentTaskServiceStrategy()Ljava/lang/String;
    move-result-object v5
    if-nez v5, +003h
    move-object v5, v4
    const-string v6, "agentTaskServiceStrategy"
    invoke-virtual v10, v6, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->getTtnetABTest()Ljava/lang/String;
    move-result-object v5
    if-nez v5, +003h
    move-object v5, v4
    const-string/jumbo v6, ttnetABTest
    invoke-virtual v10, v6, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->getRequestClient()Ljava/lang/String;
    move-result-object v5
    if-nez v5, +003h
    move-object v5, v4
    const-string/jumbo v6, requestClient
    invoke-virtual v10, v6, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->getAgentProcessSupport()Ljava/lang/String;
    move-result-object v5
    if-nez v5, +003h
    move-object v5, v4
    const-string v6, "agentProcessSupport"
    invoke-virtual v10, v6, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->getSource()Ljava/lang/String;
    move-result-object v5
    if-eqz v5, +008h
    const-string/jumbo v6, source
    invoke-virtual v10, v6, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    if-eqz v22, +008h
    invoke-virtual/range v22, Lcom/bytedance/trae/im/service/IMService$TimingMeta;->getLogid()Ljava/lang/String;
    move-result-object v5
    if-nez v5, +003h
    move-object v5, v4
    const-string v6, "logid"
    invoke-virtual v10, v6, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    if-eqz v22, +008h
    invoke-virtual/range v22, Lcom/bytedance/trae/im/service/IMService$TimingMeta;->getModelAccountName()Ljava/lang/String;
    move-result-object v5
    if-nez v5, +003h
    move-object v5, v4
    const-string v6, "modelAccountName"
    invoke-virtual v10, v6, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    if-eqz v22, +008h
    invoke-virtual/range v22, Lcom/bytedance/trae/im/service/IMService$TimingMeta;->getModelAccountType()Ljava/lang/String;
    move-result-object v5
    if-nez v5, +003h
    move-object v5, v4
    const-string v6, "modelAccountType"
    invoke-virtual v10, v6, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    if-eqz v22, +00ah
    invoke-virtual/range v22, Lcom/bytedance/trae/im/service/IMService$TimingMeta;->getModelProviderName()Ljava/lang/String;
    move-result-object v5
    if-nez v5, +003h
    goto +2h
    move-object v4, v5
    const-string v5, "modelProviderName"
    invoke-virtual v10, v5, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const/4 v11, 0
    if-eqz v22, +00dh
    invoke-virtual/range v22, Lcom/bytedance/trae/im/service/IMService$TimingMeta;->isServerRetried()Ljava/lang/Boolean;
    move-result-object v4
    if-eqz v4, +007h
    invoke-virtual v4, Ljava/lang/Boolean;->booleanValue()Z
    move-result v4
    goto +2h
    move v4, v11
    invoke-static v4, Ljava/lang/String;->valueOf(Z)Ljava/lang/String;
    move-result-object v4
    const-string v5, "isServerRetried"
    invoke-virtual v10, v5, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    if-eqz v22, +00dh
    invoke-virtual/range v22, Lcom/bytedance/trae/im/service/IMService$TimingMeta;->getEnableDbOpt()Ljava/lang/Boolean;
    move-result-object v4
    if-eqz v4, +007h
    invoke-virtual v4, Ljava/lang/Boolean;->booleanValue()Z
    move-result v4
    goto +2h
    move v4, v11
    invoke-static v4, Ljava/lang/String;->valueOf(Z)Ljava/lang/String;
    move-result-object v4
    const-string v5, "enableDbOpt"
    invoke-virtual v10, v5, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    new-instance v12, Lorg/json/JSONObject;
    invoke-direct v12, Lorg/json/JSONObject;-><init>()V
    const-string v4, "costTime"
    invoke-virtual v12, v4, v2, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    invoke-virtual v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->getStartTime()J
    move-result-wide v2
    invoke-virtual v12, v7, v2, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    invoke-virtual v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->getSessionMessageCount()Ljava/lang/Integer;
    move-result-object v2
    if-eqz v2, +00eh
    check-cast v2, Ljava/lang/Number;
    invoke-virtual v2, Ljava/lang/Number;->intValue()I
    move-result v2
    const-string/jumbo v3, sessionMessageCount
    invoke-virtual v12, v3, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    invoke-virtual v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->getSendResponseTime()J
    move-result-wide v2
    cmp-long v2, v2, v8
    if-lez v2, +015h
    const-string v2, "fe_00_send"
    invoke-virtual v12, v2, v11, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    invoke-virtual v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->getSendResponseTime()J
    move-result-wide v2
    invoke-virtual v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->getStartTime()J
    move-result-wide v4
    sub-long/2addr v2, v4
    const-string v4, "fe_01_send_response"
    invoke-virtual v12, v4, v2, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    if-eqz v21, +015h
    sget-object v2, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->INSTANCE Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;
    invoke-virtual v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->getStartTime()J
    move-result-wide v4
    invoke-virtual v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->getSendResponseTime()J
    move-result-wide v6
    move-object v1, v2
    move-object v2, v12
    move-object/from16 v3, v21
    move-wide/from16 v8, v16
    invoke-direct/range v1 ... v9, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->calculateAndPutStepDurations(Lorg/json/JSONObject; Ljava/util/Map; J J J)V
    new-instance v1, Lorg/json/JSONObject;
    invoke-direct v1, Lorg/json/JSONObject;-><init>()V
    invoke-virtual v12, Lorg/json/JSONObject;->keys()Ljava/util/Iterator;
    move-result-object v2
    const-string v3, "keys(...)"
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    const/4 v4, 0
    if-eqz v3, +01dh
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/lang/String;
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    const-string/jumbo v5, svr__
    const/4 v6, 2
    invoke-static v3, v5, v11, v6, v4, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, -018h
    invoke-virtual v12, v3, Lorg/json/JSONObject;->get(Ljava/lang/String;)Ljava/lang/Object;
    move-result-object v4
    invoke-virtual v1, v3, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    goto -21h
    sget-object v2, Lcom/bytedance/trae/platform/service/ApmService;->INSTANCE Lcom/bytedance/trae/platform/service/ApmService;
    const-string v3, "icube_ai_chat_first_token"
    invoke-virtual v2, v3, v10, v1, v4, Lcom/bytedance/trae/platform/service/ApmService;->monitorEventForSlardar(Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; Lorg/json/JSONObject;)V
    sget-object v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->reportedContexts Ljava/util/concurrent/ConcurrentHashMap;
    move-object v7, v1
    check-cast v7, Ljava/util/Map;
    new-instance v8, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$FirstTokenReportedContext;
    if-eqz v22, +008h
    invoke-virtual/range v22, Lcom/bytedance/trae/im/service/IMService$TimingMeta;->getServerTimingInfo()Ljava/lang/String;
    move-result-object v1
    move-object v6, v1
    goto +2h
    move-object v6, v4
    move-object v1, v8
    move-object v2, v10
    move-object v3, v12
    move-wide/from16 v4, v16
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$FirstTokenReportedContext;-><init>(Lorg/json/JSONObject; Lorg/json/JSONObject; J Ljava/lang/String;)V
    invoke-interface v7, v14, v8, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method public final onMetadata(java.lang.String  com.bytedance.trae.im.service.ChatEventPayload$Metadata  java.lang.String)void
    .registers 20
    # ins_size=4
    move-object/from16 v15, v17
    const-string/jumbo v0, taskId
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "metadataPayload"
    move-object/from16 v1, v18
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->trackingContexts Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v0, v15, Ljava/util/concurrent/ConcurrentHashMap;->containsKey(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    return-void 
    invoke-virtual/range v18, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->getModelSmartSelectionMeta()Lcom/google/gson/JsonObject;
    move-result-object v0
    const/4 v2, 0
    if-eqz v0, +025h
    const-string v3, "mode"
    invoke-virtual v0, v3, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v0
    if-eqz v0, +01dh
    invoke-virtual v0, Lcom/google/gson/JsonElement;->isJsonNull()Z
    move-result v3
    if-nez v3, +00ah
    invoke-virtual v0, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v3
    if-eqz v3, +004h
    const/4 v3, 1
    goto +2h
    const/4 v3, 0
    if-eqz v3, +003h
    goto +2h
    move-object v0, v2
    if-eqz v0, +008h
    invoke-virtual v0, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v0
    move-object v5, v0
    goto +2h
    move-object v5, v2
    invoke-virtual/range v18, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->getMetadataStatus()Ljava/lang/String;
    move-result-object v0
    const-string v3, "done"
    invoke-static v0, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +007h
    sget-object v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->metadataReadyTaskIds Ljava/util/Set;
    invoke-interface v0, v15, Ljava/util/Set;->add(Ljava/lang/Object;)Z
    invoke-virtual/range v18, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->getAgentType()Ljava/lang/String;
    move-result-object v3
    invoke-virtual/range v18, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->getTraceId()Ljava/lang/String;
    move-result-object v4
    invoke-virtual/range v18, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->getChatProcessVersion()Ljava/lang/String;
    move-result-object v9
    invoke-virtual/range v18, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->getAgentTaskServiceStrategy()Ljava/lang/String;
    move-result-object v10
    invoke-virtual/range v18, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->getTtnetAbtest()Ljava/lang/Object;
    move-result-object v0
    if-eqz v0, +008h
    invoke-virtual v0, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v0
    move-object v11, v0
    goto +2h
    move-object v11, v2
    invoke-virtual/range v18, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->getMessageIndex()Ljava/lang/Integer;
    move-result-object v12
    invoke-virtual/range v18, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->getUserMessageContext()Lcom/bytedance/trae/im/service/UserMessageContext;
    move-result-object v0
    if-eqz v0, +014h
    invoke-virtual v0, Lcom/bytedance/trae/im/service/UserMessageContext;->getModelInfo()Lcom/bytedance/trae/im/service/ModelInfo;
    move-result-object v0
    if-eqz v0, +00eh
    invoke-virtual v0, Lcom/bytedance/trae/im/service/ModelInfo;->getConfigSource()Ljava/lang/Integer;
    move-result-object v0
    if-eqz v0, +008h
    invoke-virtual v0, Ljava/lang/Integer;->toString()Ljava/lang/String;
    move-result-object v0
    move-object v6, v0
    goto +2h
    move-object v6, v2
    invoke-virtual/range v18, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->getUserMessageContext()Lcom/bytedance/trae/im/service/UserMessageContext;
    move-result-object v0
    if-eqz v0, +00eh
    invoke-virtual v0, Lcom/bytedance/trae/im/service/UserMessageContext;->getModelInfo()Lcom/bytedance/trae/im/service/ModelInfo;
    move-result-object v0
    if-eqz v0, +008h
    invoke-virtual v0, Lcom/bytedance/trae/im/service/ModelInfo;->getProvider()Ljava/lang/String;
    move-result-object v0
    move-object v7, v0
    goto +2h
    move-object v7, v2
    invoke-virtual/range v18, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->getUserMessageContext()Lcom/bytedance/trae/im/service/UserMessageContext;
    move-result-object v0
    if-eqz v0, +00eh
    invoke-virtual v0, Lcom/bytedance/trae/im/service/UserMessageContext;->getModelInfo()Lcom/bytedance/trae/im/service/ModelInfo;
    move-result-object v0
    if-eqz v0, +008h
    invoke-virtual v0, Lcom/bytedance/trae/im/service/ModelInfo;->isPreset()Ljava/lang/Boolean;
    move-result-object v0
    move-object v8, v0
    goto +2h
    move-object v8, v2
    invoke-virtual/range v18, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->getRequestClient()Ljava/lang/String;
    move-result-object v13
    invoke-virtual/range v18, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;->getAgentProcessSupport()Ljava/lang/String;
    move-result-object v14
    move-object/from16 v1, v16
    move-object/from16 v2, v17
    move-object/from16 v15, v19
    invoke-virtual/range v1 ... v15, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->updateMetadata(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    goto +1ah
    move-exception v0
    sget-object v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "onMetadata: taskId="
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    move-object/from16 v3, v17
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    const-string v3, "ChatFirstTokenTracker"
    invoke-virtual v1, v3, v2, v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-void 
    :try_start_0xf
.end method

.method public final onQueuing(java.lang.String)void
    .registers 4
    # ins_size=2
    const-string/jumbo v0, taskId
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->trackingContexts Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v0, v3, Ljava/util/concurrent/ConcurrentHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;
    if-nez v3, +003h
    return-void 
    invoke-virtual v3, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->getQueued()Z
    move-result v0
    if-nez v0, +00dh
    const/4 v0, 1
    invoke-virtual v3, v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->setQueued(Z)V
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v0
    invoke-virtual v3, v0, v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->setQueueStartTime(J)V
    return-void 
    :try_start_0x6
.end method

.method public final onSendMessage(java.lang.String  java.lang.String  java.lang.String  boolean  int)void
    .registers 35
    # ins_size=6
    move-object/from16 v0, v30
    move-object/from16 v6, v31
    move-object/from16 v7, v32
    move/from16 v21, v33
    move/from16 v22, v34
    const-string/jumbo v1, taskId
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v1, sessionId
    move-object/from16 v2, v31
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "model"
    move-object/from16 v2, v32
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v15, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;
    move-object v1, v15
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v2
    const-wide/16 v4, 0
    const/4 v8, 0
    const/4 v9, 0
    const-wide/16 v10, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/16 v16, 0
    move-object/from16 v28, v15
    move-object/from16 v15, v16
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v23, 0
    const/16 v24, 0
    const/16 v25, 0
    const v26, 1900530
    const/16 v27, 0
    invoke-direct/range v1 ... v27, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;-><init>(J J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Z I Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sget-object v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->trackingContexts Ljava/util/concurrent/ConcurrentHashMap;
    check-cast v1, Ljava/util/Map;
    move-object/from16 v2, v28
    invoke-interface v1, v0, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method public final onSendResponse(java.lang.String)void
    .registers 4
    # ins_size=2
    const-string/jumbo v0, taskId
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->trackingContexts Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v0, v3, Ljava/util/concurrent/ConcurrentHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;
    if-nez v3, +003h
    return-void 
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v0
    invoke-virtual v3, v0, v1, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->setSendResponseTime(J)V
    return-void 
.end method

.method public final onTimingEvents(java.lang.String  java.util.Map  com.bytedance.trae.im.service.IMService$TimingMeta)void
    .registers 6
    # ins_size=4
    const-string/jumbo v0, taskId
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "data"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "meta"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->trackingContexts Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v0, v3, Ljava/util/concurrent/ConcurrentHashMap;->containsKey(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    return-void 
    sget-object v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->timingEventsStore Ljava/util/concurrent/ConcurrentHashMap;
    check-cast v0, Ljava/util/Map;
    new-instance v1, Lkotlin/Pair;
    invoke-direct v1, v4, v5, Lkotlin/Pair;-><init>(Ljava/lang/Object; Ljava/lang/Object;)V
    invoke-interface v0, v3, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method public final removeTaskId(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, taskId
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->trackingContexts Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v0, v2, Ljava/util/concurrent/ConcurrentHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method public final updateMetadata(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Boolean  java.lang.String  java.lang.String  java.lang.String  java.lang.Integer  java.lang.String  java.lang.String  java.lang.String)void
    .registers 16
    # ins_size=15
    const-string/jumbo v0, taskId
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker;->trackingContexts Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v0, v2, Ljava/util/concurrent/ConcurrentHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;
    if-nez v2, +003h
    return-void 
    if-eqz v3, +005h
    invoke-virtual v2, v3, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->setAgentType(Ljava/lang/String;)V
    if-eqz v4, +005h
    invoke-virtual v2, v4, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->setTraceId(Ljava/lang/String;)V
    if-eqz v5, +005h
    invoke-virtual v2, v5, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->setModelStrategy(Ljava/lang/String;)V
    if-eqz v6, +005h
    invoke-virtual v2, v6, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->setConfigSource(Ljava/lang/String;)V
    if-eqz v7, +005h
    invoke-virtual v2, v7, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->setProvider(Ljava/lang/String;)V
    if-eqz v8, +00dh
    invoke-virtual v8, Ljava/lang/Boolean;->booleanValue()Z
    move-result v3
    invoke-static v3, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v3
    invoke-virtual v2, v3, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->setPreset(Ljava/lang/Boolean;)V
    if-eqz v9, +005h
    invoke-virtual v2, v9, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->setChatProcessVersion(Ljava/lang/String;)V
    if-eqz v10, +005h
    invoke-virtual v2, v10, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->setAgentTaskServiceStrategy(Ljava/lang/String;)V
    if-eqz v11, +005h
    invoke-virtual v2, v11, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->setTtnetABTest(Ljava/lang/String;)V
    if-eqz v12, +00fh
    check-cast v12, Ljava/lang/Number;
    invoke-virtual v12, Ljava/lang/Number;->intValue()I
    move-result v3
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v3
    invoke-virtual v2, v3, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->setSessionMessageCount(Ljava/lang/Integer;)V
    if-eqz v13, +005h
    invoke-virtual v2, v13, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->setRequestClient(Ljava/lang/String;)V
    if-eqz v14, +005h
    invoke-virtual v2, v14, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->setAgentProcessSupport(Ljava/lang/String;)V
    if-eqz v15, +005h
    invoke-virtual v2, v15, Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$TrackingContext;->setSource(Ljava/lang/String;)V
    return-void 
.end method
