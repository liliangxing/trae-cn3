# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedger;
.super Ljava/lang/Object;
.source "ManagedPromptLedger.kt"

.field private static final Companion:Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedger$Companion;
.field public static final LEGACY_IMPORTED_CAMPAIGN_KEY:Ljava/lang/String;
.field private final gson:Lcom/google/gson/Gson;
.field private final storage:Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStorage;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedger$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedger$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedger;->Companion Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedger$Companion;
    return-void 
.end method

.method public constructor <init>(com.bytedance.trae.conversation.prompt.ManagedPromptLedgerStorage  com.google.gson.Gson)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, storage
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "gson"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedger;->storage Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStorage;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedger;->gson Lcom/google/gson/Gson;
    return-void 
.end method

.method public synthetic constructor <init>(com.bytedance.trae.conversation.prompt.ManagedPromptLedgerStorage  com.google.gson.Gson  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +007h
    new-instance v2, Lcom/google/gson/Gson;
    invoke-direct v2, Lcom/google/gson/Gson;-><init>()V
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedger;-><init>(Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStorage; Lcom/google/gson/Gson;)V
    return-void 
.end method

.method private final write(java.lang.String  com.bytedance.trae.conversation.prompt.ManagedPromptLedgerState)void
    .registers 12
    # ins_size=3
    iget-object v0, v9, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedger;->storage Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStorage;
    iget-object v1, v9, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedger;->gson Lcom/google/gson/Gson;
    new-instance v8, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedger$PersistedState;
    invoke-virtual v11, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;->getLastShownAtMillis()J
    move-result-wide v3
    invoke-virtual v11, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;->getLastShownCampaignKey()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v11, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;->getShownVersions()Ljava/util/Map;
    move-result-object v6
    invoke-virtual v11, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;->getPendingBilling()Lcom/bytedance/trae/conversation/prompt/PendingBillingPromptRecord;
    move-result-object v7
    move-object v2, v8
    invoke-direct/range v2 ... v7, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedger$PersistedState;-><init>(J Ljava/lang/String; Ljava/util/Map; Lcom/bytedance/trae/conversation/prompt/PendingBillingPromptRecord;)V
    invoke-virtual v1, v8, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v11
    const-string/jumbo v1, toJson(...)
    invoke-static v11, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v0, v10, v11, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStorage;->write(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public final synchronized clearPendingBilling(java.lang.String  int)void
    .registers 12
    # ins_size=3
    monitor-enter v9
    const-string/jumbo v0, userId
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v0, v10
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    if-eqz v0, +004h
    monitor-exit v9
    return-void 
    invoke-virtual v9, v10, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedger;->snapshot(Ljava/lang/String;)Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;->getPendingBilling()Lcom/bytedance/trae/conversation/prompt/PendingBillingPromptRecord;
    move-result-object v0
    const/4 v2, 0
    if-eqz v0, +009h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/prompt/PendingBillingPromptRecord;->getCampaignVersion()I
    move-result v0
    if-ne v0, v11, +003h
    const/4 v2, 1
    if-nez v2, +004h
    monitor-exit v9
    return-void 
    const-wide/16 v2, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 7
    const/4 v8, 0
    invoke-static/range v1 ... v8, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;->copy$default(Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState; J Ljava/lang/String; Ljava/util/Map; Lcom/bytedance/trae/conversation/prompt/PendingBillingPromptRecord; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;
    move-result-object v11
    invoke-direct v9, v10, v11, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedger;->write(Ljava/lang/String; Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;)V
    monitor-exit v9
    return-void 
    move-exception v10
    monitor-exit v9
    throw v10
    :try_start_0x1
    :try_start_0x12
    :try_start_0x2f
.end method

.method public final synchronized mergeExposureHistory(java.lang.String  java.util.Map  long)void
    .registers 14
    # ins_size=5
    monitor-enter v9
    const-string/jumbo v0, userId
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, shownVersions
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v0, v10
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    if-eqz v0, +004h
    monitor-exit v9
    return-void 
    invoke-virtual v9, v10, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedger;->snapshot(Ljava/lang/String;)Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;->getShownVersions()Ljava/util/Map;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/MapsKt;->toMutableMap(Ljava/util/Map;)Ljava/util/Map;
    move-result-object v5
    invoke-interface v11, Ljava/util/Map;->entrySet()Ljava/util/Set;
    move-result-object v11
    invoke-interface v11, Ljava/util/Set;->iterator()Ljava/util/Iterator;
    move-result-object v11
    invoke-interface v11, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    const/4 v2, 1
    const/4 v3, 0
    if-eqz v0, +03ch
    invoke-interface v11, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/util/Map$Entry;
    invoke-interface v0, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Ljava/lang/String;
    invoke-interface v0, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/Number;
    invoke-virtual v0, Ljava/lang/Number;->intValue()I
    move-result v0
    move-object v6, v4
    check-cast v6, Ljava/lang/CharSequence;
    invoke-static v6, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v6
    xor-int/2addr v2, v6
    if-eqz v2, -026h
    if-lez v0, -028h
    invoke-interface v5, v4, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/Integer;
    if-eqz v2, +006h
    invoke-virtual v2, Ljava/lang/Integer;->intValue()I
    move-result v3
    invoke-static v3, v0, Ljava/lang/Math;->max(I I)I
    move-result v0
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    invoke-interface v5, v4, v0, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    goto -41h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;->getLastShownAtMillis()J
    move-result-wide v6
    cmp-long v11, v12, v6
    if-lez v11, +003h
    goto +2h
    move v2, v3
    invoke-virtual v1, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;->getShownVersions()Ljava/util/Map;
    move-result-object v11
    invoke-static v5, v11, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v11
    if-eqz v11, +006h
    if-nez v2, +004h
    monitor-exit v9
    return-void 
    if-eqz v2, +003h
    goto +5h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;->getLastShownAtMillis()J
    move-result-wide v12
    if-eqz v2, +005h
    const-string v11, "legacy_import"
    goto +5h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;->getLastShownCampaignKey()Ljava/lang/String;
    move-result-object v11
    move-object v4, v11
    const/4 v6, 0
    const/16 v7, 8
    const/4 v8, 0
    move-wide v2, v12
    invoke-static/range v1 ... v8, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;->copy$default(Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState; J Ljava/lang/String; Ljava/util/Map; Lcom/bytedance/trae/conversation/prompt/PendingBillingPromptRecord; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;
    move-result-object v11
    invoke-direct v9, v10, v11, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedger;->write(Ljava/lang/String; Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;)V
    monitor-exit v9
    return-void 
    move-exception v10
    monitor-exit v9
    throw v10
    :try_start_0x1
    :try_start_0x18
    :try_start_0x89
.end method

.method public final synchronized recordShown(java.lang.String  com.bytedance.trae.conversation.prompt.ManagedPromptCandidate  long)void
    .registers 13
    # ins_size=5
    monitor-enter v8
    const-string/jumbo v0, userId
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "candidate"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v0, v9
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    if-eqz v0, +004h
    monitor-exit v8
    return-void 
    invoke-virtual v8, v9, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedger;->snapshot(Ljava/lang/String;)Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;->getShownVersions()Ljava/util/Map;
    move-result-object v0
    invoke-virtual v10, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;->getCampaignId()Ljava/lang/String;
    move-result-object v2
    invoke-interface v0, v2, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/Integer;
    const/4 v2, 0
    if-eqz v0, +007h
    invoke-virtual v0, Ljava/lang/Integer;->intValue()I
    move-result v0
    goto +2h
    move v0, v2
    invoke-virtual v1, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;->getLastShownAtMillis()J
    move-result-wide v3
    invoke-static v3, v4, v11, v12, Ljava/lang/Math;->max(J J)J
    move-result-wide v3
    invoke-virtual v1, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;->getLastShownAtMillis()J
    move-result-wide v5
    cmp-long v11, v11, v5
    if-ltz v11, +007h
    invoke-virtual v10, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;->getStableKey()Ljava/lang/String;
    move-result-object v11
    goto +5h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;->getLastShownCampaignKey()Ljava/lang/String;
    move-result-object v11
    invoke-virtual v1, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;->getShownVersions()Ljava/util/Map;
    move-result-object v12
    invoke-virtual v10, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;->getCampaignId()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v10, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;->getCampaignVersion()I
    move-result v6
    invoke-static v0, v6, Ljava/lang/Math;->max(I I)I
    move-result v0
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    invoke-static v5, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    invoke-static v12, v0, Lkotlin/collections/MapsKt;->plus(Ljava/util/Map; Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v5
    invoke-virtual v1, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;->getPendingBilling()Lcom/bytedance/trae/conversation/prompt/PendingBillingPromptRecord;
    move-result-object v12
    const/4 v0, 0
    if-eqz v12, +019h
    invoke-virtual v10, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;->getType()Lcom/bytedance/trae/conversation/prompt/ManagedPromptType;
    move-result-object v6
    sget-object v7, Lcom/bytedance/trae/conversation/prompt/ManagedPromptType;->BillingUpgrade Lcom/bytedance/trae/conversation/prompt/ManagedPromptType;
    if-ne v6, v7, +00dh
    invoke-virtual v12, Lcom/bytedance/trae/conversation/prompt/PendingBillingPromptRecord;->getCampaignVersion()I
    move-result v6
    invoke-virtual v10, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;->getCampaignVersion()I
    move-result v10
    if-gt v6, v10, +003h
    const/4 v2, 1
    if-nez v2, +004h
    move-object v6, v12
    goto +2h
    move-object v6, v0
    move-wide v2, v3
    move-object v4, v11
    invoke-virtual/range v1 ... v6, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;->copy(J Ljava/lang/String; Ljava/util/Map; Lcom/bytedance/trae/conversation/prompt/PendingBillingPromptRecord;)Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;
    move-result-object v10
    invoke-direct v8, v9, v10, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedger;->write(Ljava/lang/String; Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;)V
    monitor-exit v8
    return-void 
    move-exception v9
    monitor-exit v8
    throw v9
    :try_start_0x1
    :try_start_0x17
.end method

.method public final synchronized savePendingBilling(java.lang.String  com.bytedance.trae.conversation.prompt.PendingBillingPromptRecord)void
    .registers 12
    # ins_size=3
    monitor-enter v9
    const-string/jumbo v0, userId
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "pending"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v0, v10
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    if-eqz v0, +004h
    monitor-exit v9
    return-void 
    invoke-virtual v9, v10, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedger;->snapshot(Ljava/lang/String;)Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;->getPendingBilling()Lcom/bytedance/trae/conversation/prompt/PendingBillingPromptRecord;
    move-result-object v0
    if-eqz v0, +00eh
    invoke-virtual v0, Lcom/bytedance/trae/conversation/prompt/PendingBillingPromptRecord;->getCampaignVersion()I
    move-result v0
    invoke-virtual v11, Lcom/bytedance/trae/conversation/prompt/PendingBillingPromptRecord;->getCampaignVersion()I
    move-result v2
    if-le v0, v2, +004h
    monitor-exit v9
    return-void 
    const-wide/16 v2, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v7, 7
    const/4 v8, 0
    move-object v6, v11
    invoke-static/range v1 ... v8, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;->copy$default(Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState; J Ljava/lang/String; Ljava/util/Map; Lcom/bytedance/trae/conversation/prompt/PendingBillingPromptRecord; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;
    move-result-object v11
    invoke-direct v9, v10, v11, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedger;->write(Ljava/lang/String; Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;)V
    monitor-exit v9
    return-void 
    move-exception v10
    monitor-exit v9
    throw v10
    :try_start_0x1
    :try_start_0x17
    :try_start_0x34
.end method

.method public final synchronized snapshot(java.lang.String)com.bytedance.trae.conversation.prompt.ManagedPromptLedgerState
    .registers 11
    # ins_size=2
    monitor-enter v9
    const-string/jumbo v0, userId
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v0, v10
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    if-eqz v0, +012h
    new-instance v10, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;
    const-wide/16 v2, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/16 v7, 15
    const/4 v8, 0
    move-object v1, v10
    invoke-direct/range v1 ... v8, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;-><init>(J Ljava/lang/String; Ljava/util/Map; Lcom/bytedance/trae/conversation/prompt/PendingBillingPromptRecord; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    monitor-exit v9
    return-object v10
    iget-object v0, v9, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedger;->storage Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStorage;
    invoke-interface v0, v10, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStorage;->read(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v10
    if-eqz v10, +067h
    move-object v0, v10
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    xor-int/lit8 v0, v0, 1
    if-eqz v0, +003h
    goto +2h
    const/4 v10, 0
    if-nez v10, +003h
    goto +56h
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v9
    check-cast v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedger;
    iget-object v0, v9, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedger;->gson Lcom/google/gson/Gson;
    const-class v1, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedger$PersistedState;
    invoke-virtual v0, v10, v1, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v10
    check-cast v10, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedger$PersistedState;
    new-instance v6, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedger$PersistedState;->getLastShownAtMillis()J
    move-result-wide v1
    invoke-virtual v10, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedger$PersistedState;->getLastShownCampaignKey()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v10, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedger$PersistedState;->getShownVersions()Ljava/util/Map;
    move-result-object v0
    if-nez v0, +006h
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v0
    move-object v4, v0
    invoke-virtual v10, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedger$PersistedState;->getPendingBilling()Lcom/bytedance/trae/conversation/prompt/PendingBillingPromptRecord;
    move-result-object v5
    move-object v0, v6
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;-><init>(J Ljava/lang/String; Ljava/util/Map; Lcom/bytedance/trae/conversation/prompt/PendingBillingPromptRecord;)V
    invoke-static v6, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v10
    goto +ch
    move-exception v10
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v10, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v10
    invoke-static v10, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v10
    new-instance v8, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;
    const-wide/16 v1, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/16 v6, 15
    const/4 v7, 0
    move-object v0, v8
    invoke-direct/range v0 ... v7, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;-><init>(J Ljava/lang/String; Ljava/util/Map; Lcom/bytedance/trae/conversation/prompt/PendingBillingPromptRecord; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-static v10, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    move-object v10, v8
    check-cast v10, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;
    monitor-exit v9
    return-object v10
    new-instance v10, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;
    const-wide/16 v1, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/16 v6, 15
    const/4 v7, 0
    move-object v0, v10
    invoke-direct/range v0 ... v7, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;-><init>(J Ljava/lang/String; Ljava/util/Map; Lcom/bytedance/trae/conversation/prompt/PendingBillingPromptRecord; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    monitor-exit v9
    return-object v10
    move-exception v10
    monitor-exit v9
    throw v10
    :try_start_0x1
    :try_start_0x20
    :try_start_0x38
    :try_start_0x6a
    :try_start_0x8d
.end method
