# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/service/IMMessageKt;
.super Ljava/lang/Object;
.source "IMMessage.kt"

.field private static final AGENT_FLOW_TAG:Ljava/lang/String;
.field private static final aggregatorMap:Ljava/util/IdentityHashMap;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Ljava/util/IdentityHashMap;
    invoke-direct v0, Ljava/util/IdentityHashMap;-><init>()V
    sput-object v0, Lcom/bytedance/trae/im/service/IMMessageKt;->aggregatorMap Ljava/util/IdentityHashMap;
    return-void 
.end method

.method public static final synthetic access$normalizeDoneStatus(java.lang.String)java.lang.String
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/im/service/IMMessageKt;->normalizeDoneStatus(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static final applyEvent(com.bytedance.trae.im.model.ParsedChatMessage  com.bytedance.trae.im.service.ChatEvent  java.lang.String)void
    .registers 4
    # ins_size=3
    const-string v0, "<this>"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "event"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, source
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v1, Lcom/bytedance/trae/im/service/IMMessageKt;->getOrCreateAggregator(Lcom/bytedance/trae/im/model/ParsedChatMessage;)Lcom/bytedance/trae/im/service/PlanItemAggregator;
    move-result-object v0
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/im/service/PlanItemAggregator;->apply(Lcom/bytedance/trae/im/model/ParsedChatMessage; Lcom/bytedance/trae/im/service/ChatEvent; Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic applyEvent$default(com.bytedance.trae.im.model.ParsedChatMessage  com.bytedance.trae.im.service.ChatEvent  java.lang.String  int  java.lang.Object)void
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +005h
    const-string/jumbo v2, unknown
    invoke-static v0, v1, v2, Lcom/bytedance/trae/im/service/IMMessageKt;->applyEvent(Lcom/bytedance/trae/im/model/ParsedChatMessage; Lcom/bytedance/trae/im/service/ChatEvent; Ljava/lang/String;)V
    return-void 
.end method

.method public static final getItems(com.bytedance.trae.im.model.ParsedChatMessage)java.util.List
    .registers 3
    # ins_size=1
    const-string v0, "<this>"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/im/service/IMMessageKt;->aggregatorMap Ljava/util/IdentityHashMap;
    invoke-virtual v0, v2, Ljava/util/IdentityHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/service/PlanItemAggregator;
    if-nez v0, +039h
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getTaskContent()Lcom/bytedance/trae/im/model/ParsedTaskContent;
    move-result-object v2
    if-eqz v2, +02eh
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedTaskContent;->getMessages()Ljava/util/List;
    move-result-object v2
    if-eqz v2, +028h
    check-cast v2, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v2, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +012h
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/im/model/ParsedPlanItemMessage;
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedPlanItemMessage;->getPlanItem()Lcom/bytedance/trae/im/model/ParsedPlanItem;
    move-result-object v1
    if-eqz v1, -010h
    invoke-interface v0, v1, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -15h
    check-cast v0, Ljava/util/List;
    goto +5h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    return-object v0
    invoke-virtual v0, Lcom/bytedance/trae/im/service/PlanItemAggregator;->getAllItems()Ljava/util/List;
    move-result-object v2
    return-object v2
.end method

.method private static final getOrCreateAggregator(com.bytedance.trae.im.model.ParsedChatMessage)com.bytedance.trae.im.service.PlanItemAggregator
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/im/service/IMMessageKt;->aggregatorMap Ljava/util/IdentityHashMap;
    check-cast v0, Ljava/util/Map;
    invoke-interface v0, v2, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    if-nez v1, +00ah
    new-instance v1, Lcom/bytedance/trae/im/service/PlanItemAggregator;
    invoke-direct v1, Lcom/bytedance/trae/im/service/PlanItemAggregator;-><init>()V
    invoke-interface v0, v2, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    check-cast v1, Lcom/bytedance/trae/im/service/PlanItemAggregator;
    return-object v1
.end method

.method public static final getTaskId(com.bytedance.trae.im.model.ParsedChatMessage)java.lang.String
    .registers 2
    # ins_size=1
    const-string v0, "<this>"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getTaskContent()Lcom/bytedance/trae/im/model/ParsedTaskContent;
    move-result-object v1
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedTaskContent;->getTaskId()Ljava/lang/String;
    move-result-object v1
    goto +2h
    const/4 v1, 0
    return-object v1
.end method

.method private static final normalizeDoneStatus(java.lang.String)java.lang.String
    .registers 6
    # ins_size=1
    if-eqz v5, +071h
    invoke-virtual v5, Ljava/lang/String;->hashCode()I
    move-result v0
    const-string v1, "canceled"
    const-string v2, "in_progress"
    const-string v3, "failed"
    const-string v4, "completed"
    sparse-switch v0, +0000064h
    goto/16 +060h
    const-string/jumbo v0, running
    invoke-virtual v5, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +039h
    goto/16 +055h
    const-string v0, "cancelled"
    invoke-virtual v5, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +013h
    goto +4bh
    const-string v0, "error"
    invoke-virtual v5, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +03ah
    goto +42h
    invoke-virtual v5, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    goto +3bh
    move-object v5, v1
    goto +39h
    const-string/jumbo v0, streaming
    invoke-virtual v5, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +013h
    goto +2fh
    const-string v0, "finished"
    invoke-virtual v5, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +027h
    goto +26h
    invoke-virtual v5, v2, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    goto +1fh
    move-object v5, v2
    goto +1dh
    const-string v0, "paused"
    invoke-virtual v5, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    goto +14h
    move-object v5, v0
    goto +12h
    invoke-virtual v5, v3, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    goto +bh
    move-object v5, v3
    goto +9h
    invoke-virtual v5, v4, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    goto +2h
    move-object v5, v4
    return-object v5
    sparse-switch-payload -539f09b5 -4c696bc3 -3b5366d2 -2cea1ff9 -28273f8e -12cfe79e -7577b67 5c4d208 1c682951 5c6f15bf
.end method

.method public static final releaseAggregator(com.bytedance.trae.im.model.ParsedChatMessage)void
    .registers 2
    # ins_size=1
    const-string v0, "<this>"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/im/service/IMMessageKt;->aggregatorMap Ljava/util/IdentityHashMap;
    invoke-virtual v0, v1, Ljava/util/IdentityHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method
