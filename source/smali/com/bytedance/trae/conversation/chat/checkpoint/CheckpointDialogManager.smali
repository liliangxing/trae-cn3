# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;
.super Ljava/lang/Object;
.source "CheckpointDialogManager.kt"

.field private static final CHECK_POINT_TAG:Ljava/lang/String;
.field public static final INSTANCE:Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;
.field private static final SERVICE_SEPARATOR:Ljava/lang/String;
.field private static appContextProvider:Lkotlin/jvm/functions/Function0;
.field private static containerId:I
.field private static interactionCallback:Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointInteractionCallback;
.field private static onDismissAction:Lkotlin/jvm/functions/Function0;
.field private static onFileClick:Lkotlin/jvm/functions/Function2;
.field private static scope:Lkotlinx/coroutines/CoroutineScope;


.method public static synthetic $r8$lambda$4ORSHP29KShZ64EpWHvLJXhXLIM(java.lang.String  java.lang.String  com.bytedance.trae.im.model.ParsedToolCallInfo  com.bytedance.trae.conversation.chat.checkpoint.CheckpointInteractionCallback  com.bytedance.trae.im.model.ParsedPlanItem  java.lang.String  java.lang.String  java.lang.String)kotlin.Unit
    .registers 8
    # ins_size=8
    invoke-static/range v0 ... v7, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;->tryBypassWithBottomSheet$lambda$9(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedToolCallInfo; Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointInteractionCallback; Lcom/bytedance/trae/im/model/ParsedPlanItem; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$EJMe1Ie_6JO8xg8bzpJkR_eiVtk(java.lang.String  java.lang.String)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;->presentCheckpointDialog$lambda$2(Ljava/lang/String; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$x9PBwVvg1uZjvnxjrEOYDyKRzTo()kotlin.Unit
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;->presentCheckpointDialog$lambda$1()Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;->INSTANCE Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;
    const/4 v0, 0
    const/4 v1, 1
    invoke-static v0, v1, v0, Lkotlinx/coroutines/SupervisorKt;->SupervisorJob$default(Lkotlinx/coroutines/Job; I Ljava/lang/Object;)Lkotlinx/coroutines/CompletableJob;
    move-result-object v0
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v1
    invoke-virtual v1, Lkotlinx/coroutines/MainCoroutineDispatcher;->getImmediate()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v1
    check-cast v1, Lkotlin/coroutines/CoroutineContext;
    invoke-interface v0, v1, Lkotlinx/coroutines/CompletableJob;->plus(Lkotlin/coroutines/CoroutineContext;)Lkotlin/coroutines/CoroutineContext;
    move-result-object v0
    invoke-static v0, Lkotlinx/coroutines/CoroutineScopeKt;->CoroutineScope(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;->scope Lkotlinx/coroutines/CoroutineScope;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static final synthetic access$getOnDismissAction$p()kotlin.jvm.functions.Function0
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;->onDismissAction Lkotlin/jvm/functions/Function0;
    return-object v0
.end method

.method public static final synthetic access$presentCheckpointDialog(com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialogManager  androidx.fragment.app.FragmentManager  com.bytedance.trae.im.model.ParsedPlanItem  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.conversation.chat.checkpoint.CheckpointInteractionCallback  java.lang.String)void
    .registers 8
    # ins_size=8
    invoke-direct/range v0 ... v7, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;->presentCheckpointDialog(Landroidx/fragment/app/FragmentManager; Lcom/bytedance/trae/im/model/ParsedPlanItem; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointInteractionCallback; Ljava/lang/String;)V
    return-void 
.end method

.method private final buildAskUserQuestionPages(com.bytedance.trae.im.model.ParsedToolCallInfo)java.util.List
    .registers 32
    # ins_size=2
    move-object/from16 v0, v30
    invoke-virtual/range v31, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v1
    if-nez v1, +00bh
    invoke-direct/range v30 ... v31, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;->buildSimplePage(Lcom/bytedance/trae/im/model/ParsedToolCallInfo;)Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;
    move-result-object v1
    invoke-static v1, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v1
    return-object v1
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;->getQuestionsArray(Lcom/google/gson/JsonObject;)Lcom/google/gson/JsonArray;
    move-result-object v2
    const-string v3, "description"
    const-string v4, ""
    const-string v5, "label"
    const-string v6, "opt_"
    const-string v7, "multiSelect"
    const-string v8, "options"
    const-string v9, "question"
    if-eqz v2, +115h
    invoke-virtual v2, Lcom/google/gson/JsonArray;->size()I
    move-result v12
    if-lez v12, +10fh
    check-cast v2, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v2, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v12
    if-eqz v12, +0e2h
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v12
    check-cast v12, Lcom/google/gson/JsonElement;
    instance-of v13, v12, Lcom/google/gson/JsonObject;
    if-eqz v13, +005h
    check-cast v12, Lcom/google/gson/JsonObject;
    goto +2h
    const/4 v12, 0
    if-nez v12, +005h
    const/4 v10, 0
    goto/16 +0c8h
    sget-object v13, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;->INSTANCE Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;
    sget v14, Lcom/bytedance/trae/conversation/R$string;->trae_checkpoint_default_question I
    const-string v15, "Question"
    invoke-direct v13, v14, v15, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;->getStringRes(I Ljava/lang/String;)Ljava/lang/String;
    move-result-object v13
    invoke-virtual v12, v9, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v14
    if-eqz v14, +00ch
    invoke-virtual v14, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v14
    if-nez v14, +003h
    goto +4h
    move-object/from16 v16, v14
    goto +3h
    move-object/from16 v16, v13
    const-string v13, "allowCustomInput"
    invoke-virtual v12, v13, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v13
    if-eqz v13, +007h
    invoke-virtual v13, Lcom/google/gson/JsonElement;->getAsBoolean()Z
    move-result v13
    goto +2h
    const/4 v13, 1
    move/from16 v18, v13
    invoke-virtual v12, v7, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v13
    if-eqz v13, +009h
    invoke-virtual v13, Lcom/google/gson/JsonElement;->getAsBoolean()Z
    move-result v13
    move/from16 v19, v13
    goto +3h
    const/16 v19, 0
    invoke-virtual v12, v8, Lcom/google/gson/JsonObject;->getAsJsonArray(Ljava/lang/String;)Lcom/google/gson/JsonArray;
    move-result-object v12
    if-nez v12, +007h
    new-instance v12, Lcom/google/gson/JsonArray;
    invoke-direct v12, Lcom/google/gson/JsonArray;-><init>()V
    check-cast v12, Ljava/lang/Iterable;
    new-instance v13, Ljava/util/ArrayList;
    invoke-direct v13, Ljava/util/ArrayList;-><init>()V
    check-cast v13, Ljava/util/Collection;
    invoke-interface v12, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v12
    const/4 v14, 0
    invoke-interface v12, Ljava/util/Iterator;->hasNext()Z
    move-result v15
    if-eqz v15, +05eh
    invoke-interface v12, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v15
    add-int/lit8 v17, v14, 1
    if-gez v14, +005h
    invoke-static Lkotlin/collections/CollectionsKt;->throwIndexOverflow()V
    check-cast v15, Lcom/google/gson/JsonElement;
    instance-of v10, v15, Lcom/google/gson/JsonObject;
    if-eqz v10, +005h
    check-cast v15, Lcom/google/gson/JsonObject;
    goto +2h
    const/4 v15, 0
    if-nez v15, +004h
    const/4 v10, 0
    goto +3ch
    new-instance v10, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOption;
    new-instance v11, Ljava/lang/StringBuilder;
    invoke-direct v11, v6, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v11, v14, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-virtual v11, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v24
    invoke-virtual v15, v5, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v11
    if-eqz v11, +00ch
    invoke-virtual v11, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v11
    if-nez v11, +003h
    goto +4h
    move-object/from16 v25, v11
    goto +3h
    move-object/from16 v25, v4
    invoke-virtual v15, v3, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v11
    if-eqz v11, +009h
    invoke-virtual v11, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v11
    move-object/from16 v26, v11
    goto +3h
    const/16 v26, 0
    const/16 v27, 0
    const/16 v28, 8
    const/16 v29, 0
    move-object/from16 v23, v10
    invoke-direct/range v23 ... v29, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOption;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    if-eqz v10, +005h
    invoke-interface v13, v10, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    move/from16 v14, v17
    goto -61h
    move-object/from16 v17, v13
    check-cast v17, Ljava/util/List;
    new-instance v10, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;
    const/16 v20, 0
    const/16 v21, 16
    const/16 v22, 0
    move-object v15, v10
    invoke-direct/range v15 ... v22, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;-><init>(Ljava/lang/String; Ljava/util/List; Z Z Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    if-eqz v10, -0dfh
    invoke-interface v1, v10, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto/16 -0e4h
    check-cast v1, Ljava/util/List;
    check-cast v1, Ljava/util/Collection;
    invoke-interface v1, Ljava/util/Collection;->isEmpty()Z
    move-result v2
    if-eqz v2, +00fh
    sget-object v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;->INSTANCE Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;
    move-object/from16 v2, v31
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;->buildSimplePage(Lcom/bytedance/trae/im/model/ParsedToolCallInfo;)Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;
    move-result-object v1
    invoke-static v1, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v1
    return-object v1
    check-cast v1, Ljava/util/List;
    return-object v1
    sget v2, Lcom/bytedance/trae/conversation/R$string;->trae_checkpoint_ask_user_default_title I
    const-string v10, "Agent has a question"
    invoke-direct v0, v2, v10, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;->getStringRes(I Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v9, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v9
    if-eqz v9, +00bh
    invoke-virtual v9, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v9
    if-nez v9, +003h
    goto +3h
    move-object v11, v9
    goto +2h
    move-object v11, v2
    invoke-virtual v1, v8, Lcom/google/gson/JsonObject;->getAsJsonArray(Ljava/lang/String;)Lcom/google/gson/JsonArray;
    move-result-object v2
    if-nez v2, +007h
    new-instance v2, Lcom/google/gson/JsonArray;
    invoke-direct v2, Lcom/google/gson/JsonArray;-><init>()V
    invoke-virtual v1, v7, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v1
    if-eqz v1, +008h
    invoke-virtual v1, Lcom/google/gson/JsonElement;->getAsBoolean()Z
    move-result v1
    move v14, v1
    goto +2h
    const/4 v14, 0
    check-cast v2, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v2, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    const/4 v10, 0
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v7
    if-eqz v7, +05ch
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v7
    add-int/lit8 v8, v10, 1
    if-gez v10, +005h
    invoke-static Lkotlin/collections/CollectionsKt;->throwIndexOverflow()V
    check-cast v7, Lcom/google/gson/JsonElement;
    instance-of v9, v7, Lcom/google/gson/JsonObject;
    if-eqz v9, +005h
    check-cast v7, Lcom/google/gson/JsonObject;
    goto +2h
    const/4 v7, 0
    if-nez v7, +004h
    const/4 v9, 0
    goto +3bh
    new-instance v9, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOption;
    new-instance v12, Ljava/lang/StringBuilder;
    invoke-direct v12, v6, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v12, v10, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v16
    invoke-virtual v7, v5, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v10
    if-eqz v10, +00ch
    invoke-virtual v10, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v10
    if-nez v10, +003h
    goto +4h
    move-object/from16 v17, v10
    goto +3h
    move-object/from16 v17, v4
    invoke-virtual v7, v3, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v7
    if-eqz v7, +009h
    invoke-virtual v7, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v7
    move-object/from16 v18, v7
    goto +3h
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 8
    const/16 v21, 0
    move-object v15, v9
    invoke-direct/range v15 ... v21, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOption;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    if-eqz v9, +005h
    invoke-interface v1, v9, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    move v10, v8
    goto -5fh
    move-object v12, v1
    check-cast v12, Ljava/util/List;
    new-instance v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;
    const/4 v13, 1
    const/4 v15, 0
    const/16 v16, 16
    const/16 v17, 0
    move-object v10, v1
    invoke-direct/range v10 ... v17, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;-><init>(Ljava/lang/String; Ljava/util/List; Z Z Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-static v1, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v1
    return-object v1
.end method

.method private final buildAuthorizationParams(com.google.gson.JsonObject  java.lang.String)java.lang.String
    .registers 5
    # ins_size=3
    if-eqz v3, +008h
    invoke-virtual v3, Lcom/google/gson/JsonObject;->deepCopy()Lcom/google/gson/JsonObject;
    move-result-object v3
    if-nez v3, +007h
    new-instance v3, Lcom/google/gson/JsonObject;
    invoke-direct v3, Lcom/google/gson/JsonObject;-><init>()V
    new-instance v0, Lcom/google/gson/JsonObject;
    invoke-direct v0, Lcom/google/gson/JsonObject;-><init>()V
    const-string/jumbo v1, status
    invoke-virtual v0, v1, v4, Lcom/google/gson/JsonObject;->addProperty(Ljava/lang/String; Ljava/lang/String;)V
    const-string v4, "auth_scope_mode"
    const-string v1, "all"
    invoke-virtual v0, v4, v1, Lcom/google/gson/JsonObject;->addProperty(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v4, Lcom/google/gson/JsonArray;
    invoke-direct v4, Lcom/google/gson/JsonArray;-><init>()V
    check-cast v4, Lcom/google/gson/JsonElement;
    const-string/jumbo v1, scope_results
    invoke-virtual v0, v1, v4, Lcom/google/gson/JsonObject;->add(Ljava/lang/String; Lcom/google/gson/JsonElement;)V
    const-string v4, "authorization_result"
    check-cast v0, Lcom/google/gson/JsonElement;
    invoke-virtual v3, v4, v0, Lcom/google/gson/JsonObject;->add(Ljava/lang/String; Lcom/google/gson/JsonElement;)V
    new-instance v4, Lcom/google/gson/Gson;
    invoke-direct v4, Lcom/google/gson/Gson;-><init>()V
    check-cast v3, Lcom/google/gson/JsonElement;
    invoke-virtual v4, v3, Lcom/google/gson/Gson;->toJson(Lcom/google/gson/JsonElement;)Ljava/lang/String;
    move-result-object v3
    const-string/jumbo v4, toJson(...)
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v3
.end method

.method private final buildPages(com.bytedance.trae.im.model.ParsedToolCallInfo)java.util.List
    .registers 7
    # ins_size=2
    invoke-virtual v6, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v0
    const-string v1, "CheckPointDialog"
    if-nez v0, +015h
    move-object v0, v5
    check-cast v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v2, "[DialogManager] buildPages: toolName is null, using simplePage"
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    invoke-direct v5, v6, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;->buildSimplePage(Lcom/bytedance/trae/im/model/ParsedToolCallInfo;)Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;
    move-result-object v6
    invoke-static v6, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v6
    return-object v6
    const-string v2, "AskUserQuestion"
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +00eh
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v2, "[DialogManager] buildPages: AskUserQuestion flow"
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-direct v5, v6, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;->buildAskUserQuestionPages(Lcom/bytedance/trae/im/model/ParsedToolCallInfo;)Ljava/util/List;
    move-result-object v6
    goto +1dh
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "[DialogManager] buildPages: simplePage for tool="
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v2, v1, v0, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-direct v5, v6, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;->buildSimplePage(Lcom/bytedance/trae/im/model/ParsedToolCallInfo;)Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;
    move-result-object v6
    invoke-static v6, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v6
    return-object v6
.end method

.method private final buildSimplePage(com.bytedance.trae.im.model.ParsedToolCallInfo)com.bytedance.trae.conversation.chat.checkpoint.CheckpointPage
    .registers 10
    # ins_size=2
    new-instance v9, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;
    const-string v1, ""
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v2
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/16 v6, 24
    const/4 v7, 0
    move-object v0, v9
    invoke-direct/range v0 ... v7, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;-><init>(Ljava/lang/String; Ljava/util/List; Z Z Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v9
.end method

.method private final extractPluginName(com.bytedance.trae.im.model.ParsedToolCallInfo)java.lang.String
    .registers 10
    # ins_size=2
    const-string v0, ""
    const/4 v1, 0
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v2, v8
    check-cast v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;
    invoke-virtual v9, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v9
    if-eqz v9, +010h
    const-string/jumbo v2, service
    invoke-virtual v9, v2, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v9
    if-eqz v9, +007h
    invoke-virtual v9, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v9
    goto +2h
    move-object v9, v1
    if-nez v9, +003h
    move-object v9, v0
    invoke-static v9, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v9
    goto +ch
    move-exception v9
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v9, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v9
    invoke-static v9, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v9
    invoke-static v9, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +003h
    goto +2h
    move-object v0, v9
    check-cast v0, Ljava/lang/String;
    move-object v2, v0
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v9
    if-eqz v9, +003h
    return-object v1
    const-string v3, "::"
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 6
    const/4 v7, 0
    invoke-static/range v2 ... v7, Lkotlin/text/StringsKt;->indexOf$default(Ljava/lang/CharSequence; Ljava/lang/String; I Z I Ljava/lang/Object;)I
    move-result v9
    if-lez v9, +00dh
    const/4 v1, 0
    invoke-virtual v0, v1, v9, Ljava/lang/String;->substring(I I)Ljava/lang/String;
    move-result-object v0
    const-string/jumbo v9, substring(...)
    invoke-static v0, v9, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v0
    :try_start_0x3
.end method

.method private final extractQuestionsJson(com.bytedance.trae.im.model.ParsedToolCallInfo)java.lang.String
    .registers 3
    # ins_size=2
    const-string v0, "[]"
    if-eqz v2, +017h
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v2
    if-nez v2, +003h
    goto +fh
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;->getQuestionsArray(Lcom/google/gson/JsonObject;)Lcom/google/gson/JsonArray;
    move-result-object v2
    if-eqz v2, +00ah
    invoke-virtual v2, Lcom/google/gson/JsonArray;->toString()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    goto +2h
    move-object v0, v2
    return-object v0
.end method

.method private final getLocalizedProviderName(android.content.Context  java.lang.String  java.lang.String)java.lang.String
    .registers 6
    # ins_size=4
    sget-object v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->INSTANCE Lcom/bytedance/trae/conversation/plugin/PluginListCache;
    invoke-virtual v0, v5, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->getCachedLocalizedDisplayName(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v5
    move-object v0, v5
    check-cast v0, Ljava/lang/CharSequence;
    if-eqz v0, +00bh
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    if-eqz v0, +003h
    goto +3h
    const/4 v0, 0
    goto +2h
    const/4 v0, 1
    if-nez v0, +003h
    return-object v5
    sget-object v5, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    const-string v0, "ROOT"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v4, v5, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v5
    const-string/jumbo v0, toLowerCase(...)
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v5, Ljava/lang/String;->hashCode()I
    move-result v0
    const v1, 113006579
    if-eq v0, v1, +026h
    const v1, 133862058
    if-eq v0, v1, +015h
    const v1, 136221635
    if-eq v0, v1, +003h
    goto +2fh
    const-string/jumbo v0, tencent-docs
    invoke-virtual v5, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    goto +25h
    sget v4, Lcom/bytedance/trae/conversation/R$string;->trae_plugin_provider_name_tencent_docs I
    goto +18h
    const-string v0, "dingtalk"
    invoke-virtual v5, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    goto +19h
    sget v4, Lcom/bytedance/trae/conversation/R$string;->trae_plugin_provider_name_dingtalk I
    goto +ch
    const-string/jumbo v0, wecom
    invoke-virtual v5, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, +00eh
    sget v4, Lcom/bytedance/trae/conversation/R$string;->trae_plugin_provider_name_wecom I
    invoke-virtual v3, v4, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v3
    const-string v4, "getString(...)"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v3
    invoke-direct v2, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;->getProviderDisplayName(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    return-object v3
.end method

.method private final getProviderDisplayName(java.lang.String)java.lang.String
    .registers 5
    # ins_size=2
    move-object v0, v4
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v0
    sget-object v1, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    const-string v2, "ROOT"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v0, v1, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v0
    const-string/jumbo v1, toLowerCase(...)
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v1
    const v2, 113006579
    if-eq v1, v2, +026h
    const v2, 133862058
    if-eq v1, v2, +015h
    const v2, 136221635
    if-eq v1, v2, +003h
    goto +25h
    const-string/jumbo v1, tencent-docs
    invoke-virtual v0, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    goto +1bh
    const-string v4, "Tencent Docs"
    goto +18h
    const-string v1, "dingtalk"
    invoke-virtual v0, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    goto +fh
    const-string v4, "DingTalk"
    goto +ch
    const-string/jumbo v1, wecom
    invoke-virtual v0, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +004h
    const-string v4, "WeCom"
    return-object v4
.end method

.method private final getQuestionsArray(com.google.gson.JsonObject)com.google.gson.JsonArray
    .registers 6
    # ins_size=2
    const-string v0, "questions"
    invoke-virtual v5, v0, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v5
    const/4 v0, 0
    if-nez v5, +003h
    return-object v0
    invoke-virtual v5, Lcom/google/gson/JsonElement;->isJsonArray()Z
    move-result v1
    if-eqz v1, +007h
    invoke-virtual v5, Lcom/google/gson/JsonElement;->getAsJsonArray()Lcom/google/gson/JsonArray;
    move-result-object v5
    return-object v5
    invoke-virtual v5, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v1
    if-eqz v1, +031h
    invoke-virtual v5, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v5
    invoke-static v5, Lcom/google/gson/JsonParser;->parseString(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v5
    invoke-virtual v5, Lcom/google/gson/JsonElement;->isJsonArray()Z
    move-result v1
    if-eqz v1, +023h
    invoke-virtual v5, Lcom/google/gson/JsonElement;->getAsJsonArray()Lcom/google/gson/JsonArray;
    move-result-object v5
    move-object v0, v5
    goto +1ch
    move-exception v5
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "[DialogManager] getQuestionsArray: failed to parse string as JsonArray: "
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v5, Ljava/lang/Exception;->getMessage()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    const-string v2, "CheckPointDialog"
    invoke-virtual v1, v2, v5, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-object v0
    :try_start_0x1b
.end method

.method private final getStringRes(int  java.lang.String)java.lang.String
    .registers 4
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;->appContextProvider Lkotlin/jvm/functions/Function0;
    if-eqz v0, +012h
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Landroid/content/Context;
    if-eqz v0, +00ah
    invoke-virtual v0, v2, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    goto +2h
    move-object v3, v2
    return-object v3
    :try_start_0x0
.end method

.method private final presentCheckpointDialog(androidx.fragment.app.FragmentManager  com.bytedance.trae.im.model.ParsedPlanItem  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.conversation.chat.checkpoint.CheckpointInteractionCallback  java.lang.String)void
    .registers 24
    # ins_size=8
    move-object/from16 v0, v16
    invoke-virtual/range v18, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v1
    if-eqz v1, +007h
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;->buildPages(Lcom/bytedance/trae/im/model/ParsedToolCallInfo;)Ljava/util/List;
    move-result-object v2
    goto +1dh
    sget v2, Lcom/bytedance/trae/conversation/R$string;->trae_checkpoint_fallback_title I
    const-string v3, "Action Required"
    invoke-direct v0, v2, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;->getStringRes(I Ljava/lang/String;)Ljava/lang/String;
    move-result-object v5
    new-instance v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v6
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/16 v10, 24
    const/4 v11, 0
    move-object v4, v2
    invoke-direct/range v4 ... v11, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;-><init>(Ljava/lang/String; Ljava/util/List; Z Z Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-static v2, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v2
    move-object v10, v2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;->extractQuestionsJson(Lcom/bytedance/trae/im/model/ParsedToolCallInfo;)Ljava/lang/String;
    move-result-object v9
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "[DialogManager] built "
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-interface v10, Ljava/util/List;->size()I
    move-result v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, " pages, questionsJson.length="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v9, Ljava/lang/String;->length()I
    move-result v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    const-string v3, "CheckPointDialog"
    invoke-virtual v1, v3, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;->Companion Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$Companion;
    sget v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;->containerId I
    invoke-virtual/range v18, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getConfirmInfo()Lcom/bytedance/trae/im/model/ConfirmInfo;
    move-result-object v11
    new-instance v13, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager$$ExternalSyntheticLambda0;
    invoke-direct v13, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager$$ExternalSyntheticLambda0;-><init>()V
    new-instance v14, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager$$ExternalSyntheticLambda1;
    move-object/from16 v1, v21
    invoke-direct v14, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager$$ExternalSyntheticLambda1;-><init>(Ljava/lang/String;)V
    move-object/from16 v4, v17
    move-object/from16 v6, v18
    move-object/from16 v7, v19
    move-object/from16 v8, v20
    move-object/from16 v12, v22
    move-object/from16 v15, v23
    invoke-virtual/range v3 ... v15, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog$Companion;->show(Landroidx/fragment/app/FragmentManager; I Lcom/bytedance/trae/im/model/ParsedPlanItem; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/util/List; Lcom/bytedance/trae/im/model/ConfirmInfo; Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointInteractionCallback; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1; Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialog;
    return-void 
.end method

.method private static final presentCheckpointDialog$lambda$1()kotlin.Unit
    .registers 3
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "CheckPointDialog"
    const-string v2, "[DialogManager] onDismiss invoked"
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;->onDismissAction Lkotlin/jvm/functions/Function0;
    if-eqz v0, +005h
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final presentCheckpointDialog$lambda$2(java.lang.String  java.lang.String)kotlin.Unit
    .registers 3
    # ins_size=2
    const-string v0, "filePath"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;->onFileClick Lkotlin/jvm/functions/Function2;
    if-eqz v0, +005h
    invoke-interface v0, v2, v1, Lkotlin/jvm/functions/Function2;->invoke(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private final reportBypassAuthOutcome(java.lang.String  java.lang.String  java.lang.String)void
    .registers 14
    # ins_size=4
    sget-object v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->INSTANCE Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->authDurationMs()J
    move-result-wide v0
    sget-object v2, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/PluginTracker;
    const-string/jumbo v9, success
    invoke-static v13, v9, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +004h
    move-object v5, v9
    goto +4h
    const-string v3, "cancel"
    move-object v5, v3
    const/4 v6, 0
    const/16 v7, 8
    const/4 v8, 0
    move-object v3, v12
    move-object v4, v11
    invoke-static/range v2 ... v8, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->trackAuthResult$default(Lcom/bytedance/trae/conversation/tracker/PluginTracker; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    invoke-static v13, v9, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v12
    if-eqz v12, +00ah
    sget-object v12, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/PluginTracker;
    const-string v13, "desktop_redirect"
    invoke-virtual v12, v11, v0, v1, v13, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->trackAuthSuccess(Ljava/lang/String; J Ljava/lang/String;)V
    goto +6h
    sget-object v12, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/PluginTracker;
    invoke-virtual v12, v11, v13, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->trackAuthFail(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method private final tryBypassWithBottomSheet(androidx.fragment.app.FragmentManager  com.bytedance.trae.im.model.ParsedToolCallInfo  com.bytedance.trae.im.model.ParsedPlanItem  java.lang.String  java.lang.String  com.bytedance.trae.conversation.chat.checkpoint.CheckpointInteractionCallback  java.lang.String)boolean
    .registers 21
    # ins_size=8
    move-object v1, v13
    const-string v2, ""
    const/4 v0, 0
    if-eqz v15, +007h
    invoke-virtual v15, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v3
    goto +2h
    move-object v3, v0
    const-string v4, "RequestAuthorization"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    const/4 v4, 0
    if-nez v3, +003h
    return v4
    sget-object v3, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v3, v1
    check-cast v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;
    invoke-virtual v15, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v3
    if-eqz v3, +00fh
    const-string/jumbo v5, service
    invoke-virtual v3, v5, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v3
    if-eqz v3, +006h
    invoke-virtual v3, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +003h
    move-object v0, v2
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    goto +ch
    move-exception v0
    sget-object v3, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +003h
    goto +2h
    move-object v2, v0
    check-cast v2, Ljava/lang/String;
    move-object v5, v2
    check-cast v5, Ljava/lang/CharSequence;
    const-string v6, "::"
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 6
    const/4 v10, 0
    invoke-static/range v5 ... v10, Lkotlin/text/StringsKt;->indexOf$default(Ljava/lang/CharSequence; Ljava/lang/String; I Z I Ljava/lang/Object;)I
    move-result v0
    const-string/jumbo v3, substring(...)
    if-ltz v0, +00ch
    add-int/lit8 v5, v0, 2
    invoke-virtual v2, v5, Ljava/lang/String;->substring(I)Ljava/lang/String;
    move-result-object v5
    invoke-static v5, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +2h
    move-object v5, v2
    sget-object v6, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->INSTANCE Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;
    invoke-virtual v6, v5, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->isDesktopRedirectProvider(Ljava/lang/String;)Z
    move-result v6
    if-nez v6, +003h
    return v4
    sget-object v6, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v7, Ljava/lang/StringBuilder;
    const-string v8, "[DialogManager] bypass confirm card for desktop redirect provider: "
    invoke-direct v7, v8, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v7, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    const-string v8, "CheckPointDialog"
    invoke-virtual v6, v8, v7, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    if-lez v0, +00ah
    invoke-virtual v2, v4, v0, Ljava/lang/String;->substring(I I)Ljava/lang/String;
    move-result-object v0
    invoke-static v0, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +2h
    move-object v0, v2
    sget-object v2, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/PluginTracker;
    const-string v3, "plugin"
    const-string v6, "auto"
    move-object/from16 v7, v20
    invoke-virtual v2, v0, v3, v6, v7, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->trackPluginInvoked(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    sget-object v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;->appContextProvider Lkotlin/jvm/functions/Function0;
    if-eqz v2, +03ch
    invoke-interface v2, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Landroid/content/Context;
    if-nez v2, +003h
    goto +32h
    invoke-direct v13, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;->getProviderDisplayName(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    invoke-direct v13, v2, v5, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;->getLocalizedProviderName(Landroid/content/Context; Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    sget-object v4, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/PluginTracker;
    const-string v6, "chat_hint"
    invoke-virtual v4, v5, v6, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->trackAuthStart(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v4, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->Companion Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet$Companion;
    const/4 v11, 1
    invoke-virtual v4, v5, v3, v2, v11, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet$Companion;->newInstance(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I)Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;
    move-result-object v2
    new-instance v12, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager$$ExternalSyntheticLambda2;
    move-object v3, v12
    move-object v4, v5
    move-object v5, v0
    move-object v6, v15
    move-object/from16 v7, v19
    move-object/from16 v8, v16
    move-object/from16 v9, v17
    move-object/from16 v10, v18
    invoke-direct/range v3 ... v10, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager$$ExternalSyntheticLambda2;-><init>(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedToolCallInfo; Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointInteractionCallback; Lcom/bytedance/trae/im/model/ParsedPlanItem; Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v2, v12, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->setOnAuthResult(Lkotlin/jvm/functions/Function1;)V
    const-string v0, "PluginAuthorizationBottomSheet"
    move-object v3, v14
    invoke-virtual v2, v14, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->show(Landroidx/fragment/app/FragmentManager; Ljava/lang/String;)V
    return v11
    return v4
    :try_start_0x16
.end method

.method private static final tryBypassWithBottomSheet$lambda$9(java.lang.String  java.lang.String  com.bytedance.trae.im.model.ParsedToolCallInfo  com.bytedance.trae.conversation.chat.checkpoint.CheckpointInteractionCallback  com.bytedance.trae.im.model.ParsedPlanItem  java.lang.String  java.lang.String  java.lang.String)kotlin.Unit
    .registers 15
    # ins_size=8
    const-string/jumbo v0, status
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;->INSTANCE Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;
    invoke-direct v0, v7, v8, v14, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;->reportBypassAuthOutcome(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v9, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v7
    invoke-direct v0, v7, v14, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;->buildAuthorizationParams(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v6
    new-instance v7, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$Confirm;
    invoke-virtual v11, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getId()Ljava/lang/String;
    move-result-object v8
    if-nez v8, +004h
    const-string v8, ""
    move-object v2, v8
    invoke-virtual v9, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v3
    move-object v1, v7
    move-object v4, v12
    move-object v5, v13
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision$Confirm;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    check-cast v7, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision;
    invoke-interface v10, v7, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointInteractionCallback;->onDecision(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision;)V
    sget-object v7, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;->onDismissAction Lkotlin/jvm/functions/Function0;
    if-eqz v7, +005h
    invoke-interface v7, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    sget-object v7, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v7
.end method

.method public final init(kotlin.jvm.functions.Function0)void
    .registers 4
    # ins_size=2
    const-string v0, "contextProvider"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sput-object v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;->appContextProvider Lkotlin/jvm/functions/Function0;
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v0, "CheckPointDialog"
    const-string v1, "[DialogManager] init"
    invoke-virtual v3, v0, v1, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public final release()void
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;->scope Lkotlinx/coroutines/CoroutineScope;
    const/4 v1, 0
    const/4 v2, 1
    invoke-static v0, v1, v2, v1, Lkotlinx/coroutines/CoroutineScopeKt;->cancel$default(Lkotlinx/coroutines/CoroutineScope; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    invoke-static v1, v2, v1, Lkotlinx/coroutines/SupervisorKt;->SupervisorJob$default(Lkotlinx/coroutines/Job; I Ljava/lang/Object;)Lkotlinx/coroutines/CompletableJob;
    move-result-object v0
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v2
    invoke-virtual v2, Lkotlinx/coroutines/MainCoroutineDispatcher;->getImmediate()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v2
    check-cast v2, Lkotlin/coroutines/CoroutineContext;
    invoke-interface v0, v2, Lkotlinx/coroutines/CompletableJob;->plus(Lkotlin/coroutines/CoroutineContext;)Lkotlin/coroutines/CoroutineContext;
    move-result-object v0
    invoke-static v0, Lkotlinx/coroutines/CoroutineScopeKt;->CoroutineScope(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;->scope Lkotlinx/coroutines/CoroutineScope;
    sput-object v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;->interactionCallback Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointInteractionCallback;
    sput-object v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;->appContextProvider Lkotlin/jvm/functions/Function0;
    sput-object v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;->onDismissAction Lkotlin/jvm/functions/Function0;
    sput-object v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;->onFileClick Lkotlin/jvm/functions/Function2;
    const/4 v0, 0
    sput v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;->containerId I
    return-void 
.end method

.method public final setContainerId(int)void
    .registers 5
    # ins_size=2
    sput v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;->containerId I
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "[DialogManager] setContainerId: "
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    const-string v1, "CheckPointDialog"
    invoke-virtual v0, v1, v4, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public final setInteractionCallback(com.bytedance.trae.conversation.chat.checkpoint.CheckpointInteractionCallback)void
    .registers 5
    # ins_size=2
    sput-object v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;->interactionCallback Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointInteractionCallback;
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "[DialogManager] setInteractionCallback: "
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    if-eqz v4, +004h
    const/4 v4, 1
    goto +2h
    const/4 v4, 0
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    const-string v1, "CheckPointDialog"
    invoke-virtual v0, v1, v4, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public final setOnDismissAction(kotlin.jvm.functions.Function0)void
    .registers 2
    # ins_size=2
    sput-object v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;->onDismissAction Lkotlin/jvm/functions/Function0;
    return-void 
.end method

.method public final setOnFileClick(kotlin.jvm.functions.Function2)void
    .registers 2
    # ins_size=2
    sput-object v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;->onFileClick Lkotlin/jvm/functions/Function2;
    return-void 
.end method

.method public final showCheckpointDialog(androidx.fragment.app.FragmentManager  com.bytedance.trae.im.model.ParsedPlanItem  java.lang.String  java.lang.String  java.lang.String  java.lang.String)void
    .registers 26
    # ins_size=7
    move-object/from16 v8, v22
    move-object/from16 v9, v25
    const-string v0, "fragmentManager"
    move-object/from16 v10, v20
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "planItem"
    move-object/from16 v11, v21
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, taskId
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "mode"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "[DialogManager] showCheckpointDialog: taskId="
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", conversationId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    move-object/from16 v12, v23
    invoke-virtual v1, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", planItemId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual/range v21, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", toolName="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual/range v21, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v2
    const/4 v13, 0
    if-eqz v2, +007h
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v2
    goto +2h
    move-object v2, v13
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const-string v2, "CheckPointDialog"
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v14, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;->interactionCallback Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointInteractionCallback;
    const-string v0, "checkpoint"
    if-nez v14, +018h
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v3, "[DialogManager] ABORT: interactionCallback is null"
    invoke-virtual v1, v2, v3, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/PluginTracker;
    const-string v2, "interaction_callback_null"
    invoke-virtual v1, v0, v2, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->trackAuthFail(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;->onDismissAction Lkotlin/jvm/functions/Function0;
    if-eqz v0, +005h
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
    sget v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;->containerId I
    if-nez v1, +018h
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v3, "[DialogManager] ABORT: containerId is not set"
    invoke-virtual v1, v2, v3, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/PluginTracker;
    const-string v2, "container_id_not_set"
    invoke-virtual v1, v0, v2, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->trackAuthFail(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;->onDismissAction Lkotlin/jvm/functions/Function0;
    if-eqz v0, +005h
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
    invoke-virtual/range v21, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v15
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v3, "[DialogManager] toolCallInfo: name="
    invoke-direct v1, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    if-eqz v15, +007h
    invoke-virtual v15, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v3
    goto +2h
    move-object v3, v13
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v3, ", hasParams="
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    if-eqz v15, +007h
    invoke-virtual v15, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v3
    goto +2h
    move-object v3, v13
    const/4 v4, 1
    const/4 v5, 0
    if-eqz v3, +004h
    move v3, v4
    goto +2h
    move v3, v5
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v3, ", hasResult="
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    if-eqz v15, +007h
    invoke-virtual v15, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v3
    goto +2h
    move-object v3, v13
    if-eqz v3, +003h
    goto +2h
    move v4, v5
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    move-object/from16 v0, v19
    move-object/from16 v1, v20
    move-object v2, v15
    move-object/from16 v3, v21
    move-object/from16 v4, v22
    move-object/from16 v5, v23
    move-object v6, v14
    move-object/from16 v7, v25
    invoke-direct/range v0 ... v7, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;->tryBypassWithBottomSheet(Landroidx/fragment/app/FragmentManager; Lcom/bytedance/trae/im/model/ParsedToolCallInfo; Lcom/bytedance/trae/im/model/ParsedPlanItem; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointInteractionCallback; Ljava/lang/String;)Z
    move-result v0
    if-eqz v0, +003h
    return-void 
    if-eqz v15, +006h
    invoke-virtual v15, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v13
    const-string v0, "RequestAuthorization"
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    move-object/from16 v13, v19
    if-eqz v0, +061h
    invoke-direct v13, v15, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;->extractPluginName(Lcom/bytedance/trae/im/model/ParsedToolCallInfo;)Ljava/lang/String;
    move-result-object v1
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/PluginTracker;
    if-nez v1, +005h
    const-string v2, ""
    goto +2h
    move-object v2, v1
    const-string v3, "plugin"
    const-string v4, "auto"
    invoke-virtual v0, v2, v3, v4, v9, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->trackPluginInvoked(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    if-eqz v1, +04ch
    sget-object v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->INSTANCE Lcom/bytedance/trae/conversation/plugin/PluginListCache;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->getCachedLocalizedDisplayName(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v7
    if-eqz v7, +013h
    move-object/from16 v0, v19
    move-object/from16 v1, v20
    move-object/from16 v2, v21
    move-object/from16 v3, v22
    move-object/from16 v4, v23
    move-object/from16 v5, v24
    move-object v6, v14
    invoke-direct/range v0 ... v7, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;->presentCheckpointDialog(Landroidx/fragment/app/FragmentManager; Lcom/bytedance/trae/im/model/ParsedPlanItem; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointInteractionCallback; Ljava/lang/String;)V
    goto +31h
    sget-object v9, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;->scope Lkotlinx/coroutines/CoroutineScope;
    const/4 v15, 0
    const/16 v16, 0
    new-instance v17, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager$showCheckpointDialog$1;
    const/16 v18, 0
    move-object/from16 v0, v17
    move-object/from16 v2, v20
    move-object/from16 v3, v21
    move-object/from16 v4, v22
    move-object/from16 v5, v23
    move-object/from16 v6, v24
    move-object v7, v14
    move-object/from16 v8, v18
    invoke-direct/range v0 ... v8, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager$showCheckpointDialog$1;-><init>(Ljava/lang/String; Landroidx/fragment/app/FragmentManager; Lcom/bytedance/trae/im/model/ParsedPlanItem; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointInteractionCallback; Lkotlin/coroutines/Continuation;)V
    move-object/from16 v0, v17
    check-cast v0, Lkotlin/jvm/functions/Function2;
    const/4 v1, 3
    const/4 v2, 0
    move-object/from16 v20, v9
    move-object/from16 v21, v15
    move-object/from16 v22, v16
    move-object/from16 v23, v0
    move/from16 v24, v1
    move-object/from16 v25, v2
    invoke-static/range v20 ... v25, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
    const/4 v7, 0
    move-object/from16 v0, v19
    move-object/from16 v1, v20
    move-object/from16 v2, v21
    move-object/from16 v3, v22
    move-object/from16 v4, v23
    move-object/from16 v5, v24
    move-object v6, v14
    invoke-direct/range v0 ... v7, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;->presentCheckpointDialog(Landroidx/fragment/app/FragmentManager; Lcom/bytedance/trae/im/model/ParsedPlanItem; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointInteractionCallback; Ljava/lang/String;)V
    return-void 
.end method
