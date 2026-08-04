# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "IMService.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $allEvents:Ljava/util/List;
.field final synthetic $conversationId:Ljava/lang/String;
.field final synthetic $taskId:Ljava/lang/String;
.field  label:I


.method constructor <init>(java.util.List  java.lang.String  java.lang.String  kotlin.coroutines.Continuation)void
    .registers 5
    # ins_size=5
    iput-object v1, v0, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1$1;->$allEvents Ljava/util/List;
    iput-object v2, v0, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1$1;->$taskId Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1$1;->$conversationId Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v4, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 6
    # ins_size=3
    new-instance v4, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1$1;
    iget-object v0, v3, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1$1;->$allEvents Ljava/util/List;
    iget-object v1, v3, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1$1;->$taskId Ljava/lang/String;
    iget-object v2, v3, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1$1;->$conversationId Ljava/lang/String;
    invoke-direct v4, v0, v1, v2, v5, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1$1;-><init>(Ljava/util/List; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v4, Lkotlin/coroutines/Continuation;
    return-object v4
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 75
    # ins_size=2
    move-object/from16 v1, v73
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v1, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1$1;->label I
    if-nez v0, +32ch
    invoke-static/range v74, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    new-instance v2, Lkotlin/jvm/internal/Ref$IntRef;
    invoke-direct v2, Lkotlin/jvm/internal/Ref$IntRef;-><init>()V
    iget-object v0, v1, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1$1;->$allEvents Ljava/util/List;
    check-cast v0, Ljava/util/Collection;
    invoke-interface v0, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    const/4 v3, 1
    xor-int/2addr v0, v3
    const/4 v4, 0
    if-eqz v0, +16dh
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    const-string v5, "AgentDataFlow"
    new-instance v6, Ljava/lang/StringBuilder;
    const-string v7, "[Node1] triggerFetchEvents: before clear, taskId="
    invoke-direct v6, v7, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v7, v1, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1$1;->$taskId Ljava/lang/String;
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    const-string v7, ", thoughtMap="
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-static Lcom/bytedance/trae/im/service/IMService;->access$getThoughtMap$p()Ljava/util/concurrent/ConcurrentHashMap;
    move-result-object v7
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v0, v5, v6, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    invoke-static Lcom/bytedance/trae/im/service/IMService;->access$getThoughtMap$p()Ljava/util/concurrent/ConcurrentHashMap;
    move-result-object v0
    iget-object v5, v1, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1$1;->$taskId Ljava/lang/String;
    invoke-virtual v0, v5, Ljava/util/concurrent/ConcurrentHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    if-eqz v0, +005h
    invoke-static v0, Lcom/bytedance/trae/im/service/IMMessageKt;->releaseAggregator(Lcom/bytedance/trae/im/model/ParsedChatMessage;)V
    invoke-static Lcom/bytedance/trae/im/service/IMService;->access$getSeqNumbers$p()Ljava/util/concurrent/ConcurrentHashMap;
    move-result-object v5
    iget-object v6, v1, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1$1;->$taskId Ljava/lang/String;
    invoke-virtual v5, v6, Ljava/util/concurrent/ConcurrentHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v5, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    const-string v6, "AgentDataFlow"
    new-instance v7, Ljava/lang/StringBuilder;
    const-string v8, "[Node1] triggerFetchEvents: after clear, taskId="
    invoke-direct v7, v8, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v8, v1, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1$1;->$taskId Ljava/lang/String;
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v8, ", thoughtMap="
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-static Lcom/bytedance/trae/im/service/IMService;->access$getThoughtMap$p()Ljava/util/concurrent/ConcurrentHashMap;
    move-result-object v8
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v8, ", oldMessage="
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v5, v6, v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    invoke-static Lcom/bytedance/trae/im/service/IMService;->access$getSeqNumbers$p()Ljava/util/concurrent/ConcurrentHashMap;
    move-result-object v0
    check-cast v0, Ljava/util/concurrent/ConcurrentMap;
    iget-object v5, v1, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1$1;->$taskId Ljava/lang/String;
    invoke-interface v0, v5, Ljava/util/concurrent/ConcurrentMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v6
    if-nez v6, +010h
    invoke-static Ljava/util/concurrent/ConcurrentHashMap;->newKeySet()Ljava/util/concurrent/ConcurrentHashMap$KeySetView;
    move-result-object v6
    check-cast v6, Ljava/util/Set;
    invoke-interface v0, v5, v6, Ljava/util/concurrent/ConcurrentMap;->putIfAbsent(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    if-nez v0, +003h
    goto +2h
    move-object v6, v0
    check-cast v6, Ljava/util/Set;
    iget-object v0, v1, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1$1;->$allEvents Ljava/util/List;
    invoke-interface v0, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v5
    invoke-interface v5, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +0a8h
    invoke-interface v5, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    move-object v7, v0
    check-cast v7, Lcom/bytedance/trae/im/service/EventItem;
    invoke-virtual v7, Lcom/bytedance/trae/im/service/EventItem;->getSeq()Ljava/lang/Integer;
    move-result-object v8
    if-eqz v8, +048h
    invoke-virtual v8, Ljava/lang/Integer;->intValue()I
    move-result v0
    if-lez v0, +042h
    invoke-interface v6, v8, Ljava/util/Set;->add(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    goto +3ah
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    const-string v9, "AgentDataFlow"
    new-instance v10, Ljava/lang/StringBuilder;
    const-string v11, "[Node1] triggerFetchEvents: stream not continuous, taskId="
    invoke-direct v10, v11, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v11, v1, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1$1;->$taskId Ljava/lang/String;
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    const-string v11, ", convId="
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    iget-object v11, v1, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1$1;->$conversationId Ljava/lang/String;
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    const-string v11, ", seq="
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v8
    const-string v10, ", item="
    invoke-virtual v8, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v0, v9, v7, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    goto -58h
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->INSTANCE Lcom/bytedance/trae/im/service/IMService;
    iget-object v9, v1, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1$1;->$conversationId Ljava/lang/String;
    invoke-static v0, v7, v9, Lcom/bytedance/trae/im/service/IMService;->access$parseEvent(Lcom/bytedance/trae/im/service/IMService; Lcom/bytedance/trae/im/service/EventItem; Ljava/lang/String;)Z
    move-result v0
    invoke-static v0, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    goto -64h
    move-exception v0
    sget-object v9, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    const-string v10, "AgentDataFlow"
    new-instance v11, Ljava/lang/StringBuilder;
    const-string v12, "[Node1] triggerFetchEvents: parseEvent error, taskId="
    invoke-direct v11, v12, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v12, v1, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1$1;->$taskId Ljava/lang/String;
    invoke-virtual v11, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    const-string v12, ", convId="
    invoke-virtual v11, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    iget-object v12, v1, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1$1;->$conversationId Ljava/lang/String;
    invoke-virtual v11, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    const-string v12, ", seq="
    invoke-virtual v11, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-virtual v11, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v8
    const-string v11, ", item="
    invoke-virtual v8, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v8, ", e="
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v9, v10, v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->e(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    goto/16 -0aah
    iget-object v0, v1, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1$1;->$allEvents Ljava/util/List;
    invoke-static v0, Lkotlin/collections/CollectionsKt;->last(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/service/EventItem;
    invoke-virtual v0, Lcom/bytedance/trae/im/service/EventItem;->getSeq()Ljava/lang/Integer;
    move-result-object v0
    if-eqz v0, +007h
    invoke-virtual v0, Ljava/lang/Integer;->intValue()I
    move-result v0
    goto +2h
    move v0, v4
    iput v0, v2, Lkotlin/jvm/internal/Ref$IntRef;->element I
    iget v0, v2, Lkotlin/jvm/internal/Ref$IntRef;->element I
    if-lez v0, +013h
    invoke-static Lcom/bytedance/trae/im/service/IMService;->access$getHttpTaskSeqNum$p()Ljava/util/concurrent/ConcurrentHashMap;
    move-result-object v0
    check-cast v0, Ljava/util/Map;
    iget-object v5, v1, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1$1;->$taskId Ljava/lang/String;
    iget v6, v2, Lkotlin/jvm/internal/Ref$IntRef;->element I
    invoke-static v6, Lkotlin/coroutines/jvm/internal/Boxing;->boxInt(I)Ljava/lang/Integer;
    move-result-object v6
    invoke-interface v0, v5, v6, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    invoke-static Lcom/bytedance/trae/im/service/IMService;->access$getPendingEventsMap$p()Ljava/util/concurrent/ConcurrentHashMap;
    move-result-object v0
    iget-object v5, v1, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1$1;->$taskId Ljava/lang/String;
    invoke-virtual v0, v5, Ljava/util/concurrent/ConcurrentHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/util/List;
    invoke-static Lcom/bytedance/trae/im/service/IMService;->access$getPendingTaskIdOrder$p()Ljava/util/LinkedHashSet;
    move-result-object v5
    iget-object v6, v1, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1$1;->$taskId Ljava/lang/String;
    monitor-enter v5
    invoke-static Lcom/bytedance/trae/im/service/IMService;->access$getPendingTaskIdOrder$p()Ljava/util/LinkedHashSet;
    move-result-object v7
    invoke-virtual v7, v6, Ljava/util/LinkedHashSet;->remove(Ljava/lang/Object;)Z
    monitor-exit v5
    move-object v5, v0
    check-cast v5, Ljava/util/Collection;
    if-eqz v5, +00bh
    invoke-interface v5, Ljava/util/Collection;->isEmpty()Z
    move-result v5
    if-eqz v5, +003h
    goto +3h
    move v5, v4
    goto +2h
    move v5, v3
    if-nez v5, +126h
    invoke-static Lcom/bytedance/trae/im/service/IMService;->access$getThoughtMap$p()Ljava/util/concurrent/ConcurrentHashMap;
    move-result-object v5
    check-cast v5, Ljava/util/concurrent/ConcurrentMap;
    iget-object v12, v1, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1$1;->$taskId Ljava/lang/String;
    iget-object v14, v1, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1$1;->$conversationId Ljava/lang/String;
    invoke-interface v5, v12, Ljava/util/concurrent/ConcurrentMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v6
    if-nez v6, +08eh
    new-instance v6, Lcom/bytedance/trae/im/model/ParsedTaskContent;
    move-object/from16 v52, v6
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 6
    const/4 v11, 0
    move-object v7, v12
    invoke-direct/range v6 ... v11, Lcom/bytedance/trae/im/model/ParsedTaskContent;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/util/List; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    new-instance v6, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    move-object v13, v6
    const-string v15, ""
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const-string/jumbo v19, task
    const-string v20, "assistant"
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 0
    const/16 v24, 0
    const/16 v25, 0
    const/16 v26, 0
    const/16 v27, 0
    const/16 v28, 0
    const/16 v29, 0
    const/16 v30, 0
    const/16 v31, 0
    const/16 v32, 0
    const/16 v33, 0
    const/16 v34, 0
    const/16 v35, 0
    const-wide/16 v36, 0
    const/16 v38, 0
    const/16 v39, 0
    const/16 v40, 0
    const/16 v41, 0
    const/16 v42, 0
    const/16 v43, 0
    const/16 v44, 0
    const/16 v45, 0
    const/16 v46, 0
    const/16 v47, 0
    const/16 v48, 0
    const/16 v49, 0
    const/16 v50, 0
    const/16 v51, 0
    const/16 v53, 0
    const/16 v54, 0
    const/16 v55, 0
    const/16 v56, 0
    const/16 v57, 0
    const/16 v58, 0
    const/16 v59, 0
    const/16 v60, 0
    const/16 v61, 0
    const/16 v62, 0
    const/16 v63, 0
    const/16 v64, 0
    const/16 v65, 0
    const/16 v66, 0
    const/16 v67, 0
    const/16 v68, 0
    const/16 v69, 0
    const/16 v70, -100
    const v71, 8388319
    const/16 v72, 0
    invoke-direct/range v13 ... v72, Lcom/bytedance/trae/im/model/ParsedChatMessage;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; Lcom/google/gson/JsonObject; Lcom/bytedance/trae/im/model/ParsedError; Ljava/lang/Boolean; Ljava/lang/Long; Ljava/util/List; Lcom/google/gson/JsonObject; Lcom/bytedance/trae/im/model/SearchReferenceData; Lcom/bytedance/trae/im/model/DocReferencesData; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Lcom/google/gson/JsonObject; Lcom/google/gson/JsonObject; Ljava/util/List; Lcom/bytedance/trae/im/model/ModelSmartSelectionMeta; Ljava/lang/Boolean; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedTokenUsage; Lcom/bytedance/trae/im/model/ParsedContextUsage; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Object; Ljava/util/List; Lcom/bytedance/trae/im/model/FastRequestSavings; Z Z Z Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/FastRequestEvent; Ljava/lang/Boolean; Lcom/bytedance/trae/im/model/MessageSourcePhase; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v5, v12, v6, Ljava/util/concurrent/ConcurrentMap;->putIfAbsent(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v5
    if-nez v5, +003h
    goto +2h
    move-object v6, v5
    check-cast v6, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    iget v5, v2, Lkotlin/jvm/internal/Ref$IntRef;->element I
    if-lez v5, +030h
    check-cast v0, Ljava/lang/Iterable;
    new-instance v5, Ljava/util/ArrayList;
    invoke-direct v5, Ljava/util/ArrayList;-><init>()V
    check-cast v5, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v7
    if-eqz v7, +01ah
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v7
    move-object v8, v7
    check-cast v8, Lcom/bytedance/trae/im/service/ChatEvent;
    invoke-virtual v8, Lcom/bytedance/trae/im/service/ChatEvent;->getSeq()I
    move-result v8
    iget v9, v2, Lkotlin/jvm/internal/Ref$IntRef;->element I
    if-le v8, v9, +004h
    move v8, v3
    goto +2h
    move v8, v4
    if-eqz v8, -018h
    invoke-interface v5, v7, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1dh
    move-object v0, v5
    check-cast v0, Ljava/util/List;
    invoke-interface v0, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +01ah
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    move-object v8, v4
    check-cast v8, Lcom/bytedance/trae/im/service/ChatEvent;
    sget-object v7, Lcom/bytedance/trae/im/service/IMService;->INSTANCE Lcom/bytedance/trae/im/service/IMService;
    iget-object v9, v1, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1$1;->$taskId Ljava/lang/String;
    iget-object v10, v1, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1$1;->$conversationId Ljava/lang/String;
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    const-string/jumbo v12, socket
    move-object v11, v6
    invoke-virtual/range v7 ... v12, Lcom/bytedance/trae/im/service/IMService;->realChatEvent(Lcom/bytedance/trae/im/service/ChatEvent; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/model/ParsedChatMessage; Ljava/lang/String;)V
    goto -1dh
    sget-object v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    const-string v4, "AgentDataFlow"
    new-instance v5, Ljava/lang/StringBuilder;
    const-string v6, "[Node1] triggerFetchEvents done: taskId="
    invoke-direct v5, v6, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v6, v1, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1$1;->$taskId Ljava/lang/String;
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v6, ", convId="
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    iget-object v6, v1, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1$1;->$conversationId Ljava/lang/String;
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v6, ", filtered pendingList.size="
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v0
    invoke-virtual v5, v0, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v2, v4, v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    invoke-static Lcom/bytedance/trae/im/service/IMService;->access$getFirstSeqNum$p()Ljava/util/concurrent/ConcurrentHashMap;
    move-result-object v0
    iget-object v2, v1, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1$1;->$taskId Ljava/lang/String;
    invoke-static v3, Lkotlin/coroutines/jvm/internal/Boxing;->boxInt(I)Ljava/lang/Integer;
    move-result-object v3
    invoke-virtual v0, v2, v3, Ljava/util/concurrent/ConcurrentHashMap;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    invoke-static Lcom/bytedance/trae/im/service/IMService;->access$getFetchedConversationDone$p()Ljava/util/Set;
    move-result-object v0
    iget-object v2, v1, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1$1;->$conversationId Ljava/lang/String;
    invoke-interface v0, v2, Ljava/util/Set;->add(Ljava/lang/Object;)Z
    invoke-static Lcom/bytedance/trae/im/service/IMService;->access$getFetchingTaskIds$p()Ljava/util/Set;
    move-result-object v0
    iget-object v2, v1, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1$1;->$taskId Ljava/lang/String;
    invoke-interface v0, v2, Ljava/util/Set;->remove(Ljava/lang/Object;)Z
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    const-string v2, "AgentDataFlow"
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "[Node1] triggerFetchEvents done: taskId="
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v4, v1, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1$1;->$taskId Ljava/lang/String;
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, ", convId="
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    iget-object v4, v1, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1$1;->$conversationId Ljava/lang/String;
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string/jumbo v4, ，allEvents.size=
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    iget-object v4, v1, Lcom/bytedance/trae/im/service/IMService$triggerFetchEvents$1$1;->$allEvents Ljava/util/List;
    invoke-interface v4, Ljava/util/List;->size()I
    move-result v4
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, v2, v3, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    move-exception v0
    monitor-exit v5
    throw v0
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    :try_start_0x10b
    :try_start_0x19c
.end method
