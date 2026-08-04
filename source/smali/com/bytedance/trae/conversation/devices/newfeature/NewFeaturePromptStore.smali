# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptStore;
.super Ljava/lang/Object;
.source "NewFeaturePromptStore.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptStore;
.field private static final KEY_FIRST_LOGIN_OBSERVED_AT:Ljava/lang/String;
.field private static final KEY_HIGHEST_SHOWN_VERSION_PREFIX:Ljava/lang/String;
.field private static final KEY_LAST_SHOWN_AT:Ljava/lang/String;
.field private static final KEY_SHOWN_COUNT_PREFIX:Ljava/lang/String;
.field private static final KEY_SHOWN_PREFIX:Ljava/lang/String;
.field private static final REPO_PREFIX:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptStore;
    invoke-direct v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptStore;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptStore;->INSTANCE Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptStore;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final highestShownVersionKey(com.bytedance.trae.conversation.devices.DeviceProductType)java.lang.String
    .registers 4
    # ins_size=2
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "highest_shown_version_"
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->name()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    return-object v3
.end method

.method private final legacyShownKey(com.bytedance.trae.conversation.devices.DeviceProductType)java.lang.String
    .registers 4
    # ins_size=2
    new-instance v0, Ljava/lang/StringBuilder;
    const-string/jumbo v1, shown_
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->name()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    return-object v3
.end method

.method private final legacyShownVersion(com.bytedance.keva.Keva  com.bytedance.trae.conversation.devices.DeviceProductType)int
    .registers 5
    # ins_size=3
    invoke-direct v2, v4, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptStore;->legacyShownKey(Lcom/bytedance/trae/conversation/devices/DeviceProductType;)Ljava/lang/String;
    move-result-object v0
    const/4 v1, 0
    invoke-virtual v3, v0, v1, Lcom/bytedance/keva/Keva;->getBoolean(Ljava/lang/String; Z)Z
    move-result v0
    if-nez v0, +00ch
    invoke-direct v2, v4, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptStore;->shownCountKey(Lcom/bytedance/trae/conversation/devices/DeviceProductType;)Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v4, v1, Lcom/bytedance/keva/Keva;->getInt(Ljava/lang/String; I)I
    move-result v3
    if-lez v3, +003h
    const/4 v1, 1
    return v1
.end method

.method public static synthetic markShown$default(com.bytedance.trae.conversation.devices.newfeature.NewFeaturePromptStore  java.lang.String  com.bytedance.trae.conversation.devices.DeviceProductType  com.bytedance.trae.conversation.devices.newfeature.NewFeaturePromptConfig  long  int  java.lang.Object)void
    .registers 23
    # ins_size=8
    and-int/lit8 v0, v21, 4
    if-eqz v0, +012h
    new-instance v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const-wide/16 v5, 0
    const/16 v7, 15
    const/4 v8, 0
    move-object v1, v0
    invoke-direct/range v1 ... v8, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;-><init>(Z I Ljava/util/List; J I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object v12, v0
    goto +3h
    move-object/from16 v12, v18
    and-int/lit8 v0, v21, 8
    if-eqz v0, +008h
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v0
    move-wide v13, v0
    goto +3h
    move-wide/from16 v13, v19
    move-object v9, v15
    move-object/from16 v10, v16
    move-object/from16 v11, v17
    invoke-virtual/range v9 ... v14, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptStore;->markShown(Ljava/lang/String; Lcom/bytedance/trae/conversation/devices/DeviceProductType; Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig; J)V
    return-void 
.end method

.method private final mergeLegacyExposureIntoUnifiedLedger(java.lang.String  com.bytedance.keva.Keva)void
    .registers 21
    # ins_size=3
    move-object/from16 v0, v20
    invoke-static Lcom/bytedance/trae/conversation/devices/DeviceProductType;->values()[Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-result-object v1
    new-instance v2, Ljava/util/ArrayList;
    invoke-direct v2, Ljava/util/ArrayList;-><init>()V
    check-cast v2, Ljava/util/Collection;
    array-length v3, v1
    const/4 v4, 0
    move v5, v4
    if-ge v5, v3, +049h
    aget-object v6, v1, v5
    sget-object v7, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptStore;->INSTANCE Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptStore;
    invoke-direct v7, v0, v6, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptStore;->legacyShownVersion(Lcom/bytedance/keva/Keva; Lcom/bytedance/trae/conversation/devices/DeviceProductType;)I
    move-result v8
    invoke-direct v7, v6, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptStore;->highestShownVersionKey(Lcom/bytedance/trae/conversation/devices/DeviceProductType;)Ljava/lang/String;
    move-result-object v7
    invoke-virtual v0, v7, v4, Lcom/bytedance/keva/Keva;->getInt(Ljava/lang/String; I)I
    move-result v7
    invoke-static v8, v7, Ljava/lang/Math;->max(I I)I
    move-result v7
    if-lez v7, +029h
    sget-object v8, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptPolicy;->INSTANCE Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptPolicy;
    new-instance v15, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;
    const/4 v10, 0
    const/4 v12, 0
    const-wide/16 v13, 0
    const/16 v16, 13
    const/16 v17, 0
    move-object v9, v15
    move v11, v7
    move-object v4, v15
    move/from16 v15, v16
    move-object/from16 v16, v17
    invoke-direct/range v9 ... v16, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;-><init>(Z I Ljava/util/List; J I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-virtual v8, v6, v4, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptPolicy;->managedCandidate$conversation_mainlandRelease(Lcom/bytedance/trae/conversation/devices/DeviceProductType; Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;)Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;
    move-result-object v4
    invoke-virtual v4, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;->getCampaignId()Ljava/lang/String;
    move-result-object v4
    invoke-static v7, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    invoke-static v4, v6, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v4
    goto +2h
    const/4 v4, 0
    if-eqz v4, +005h
    invoke-interface v2, v4, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    add-int/lit8 v5, v5, 1
    const/4 v4, 0
    goto -48h
    check-cast v2, Ljava/util/List;
    check-cast v2, Ljava/lang/Iterable;
    invoke-static v2, Lkotlin/collections/MapsKt;->toMap(Ljava/lang/Iterable;)Ljava/util/Map;
    move-result-object v1
    const-string v2, "last_shown_at"
    const-wide/16 v3, 0
    invoke-virtual v0, v2, v3, v4, Lcom/bytedance/keva/Keva;->getLong(Ljava/lang/String; J)J
    move-result-wide v5
    invoke-interface v1, Ljava/util/Map;->isEmpty()Z
    move-result v0
    xor-int/lit8 v0, v0, 1
    if-nez v0, +006h
    cmp-long v0, v5, v3
    if-lez v0, +009h
    sget-object v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStore;->INSTANCE Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStore;
    move-object/from16 v2, v19
    invoke-virtual v0, v2, v1, v5, v6, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStore;->mergeExposureHistory(Ljava/lang/String; Ljava/util/Map; J)V
    return-void 
.end method

.method public static synthetic recordLoginObserved$default(com.bytedance.trae.conversation.devices.newfeature.NewFeaturePromptStore  java.lang.String  long  int  java.lang.Object)long
    .registers 6
    # ins_size=6
    and-int/lit8 v4, v4, 2
    if-eqz v4, +006h
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v2
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptStore;->recordLoginObserved(Ljava/lang/String; J)J
    move-result-wide v0
    return-wide v0
.end method

.method private final repo(java.lang.String)com.bytedance.keva.Keva
    .registers 4
    # ins_size=2
    new-instance v0, Ljava/lang/StringBuilder;
    const-string/jumbo v1, trae_new_feature_prompt_
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    const/4 v0, 0
    invoke-static v3, v0, Lcom/bytedance/keva/Keva;->getRepo(Ljava/lang/String; I)Lcom/bytedance/keva/Keva;
    move-result-object v3
    const-string v0, "getRepo(...)"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v3
.end method

.method private final shownCountKey(com.bytedance.trae.conversation.devices.DeviceProductType)java.lang.String
    .registers 4
    # ins_size=2
    new-instance v0, Ljava/lang/StringBuilder;
    const-string/jumbo v1, shown_count_
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->name()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    return-object v3
.end method

.method public static synthetic snapshot$default(com.bytedance.trae.conversation.devices.newfeature.NewFeaturePromptStore  java.lang.String  com.bytedance.trae.conversation.devices.newfeature.NewFeaturePromptConfig  int  java.lang.Object)com.bytedance.trae.conversation.devices.newfeature.NewFeaturePromptState
    .registers 13
    # ins_size=5
    and-int/lit8 v11, v11, 2
    if-eqz v11, +010h
    new-instance v10, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const-wide/16 v4, 0
    const/16 v6, 15
    const/4 v7, 0
    move-object v0, v10
    invoke-direct/range v0 ... v7, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;-><init>(Z I Ljava/util/List; J I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-virtual v8, v9, v10, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptStore;->snapshot(Ljava/lang/String; Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;)Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;
    move-result-object v8
    return-object v8
.end method

.method private final versionedShownKey(com.bytedance.trae.conversation.devices.DeviceProductType  int)java.lang.String
    .registers 5
    # ins_size=3
    new-instance v0, Ljava/lang/StringBuilder;
    const-string/jumbo v1, shown_
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->name()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v0, "_v"
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    return-object v3
.end method

.method public final synchronized markShown(java.lang.String  com.bytedance.trae.conversation.devices.DeviceProductType  com.bytedance.trae.conversation.devices.newfeature.NewFeaturePromptConfig  long)void
    .registers 23
    # ins_size=6
    move-object/from16 v1, v17
    move-object/from16 v0, v18
    move-object/from16 v2, v19
    move-wide/from16 v3, v21
    monitor-enter v17
    const-string/jumbo v5, userId
    invoke-static v0, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v5, "productType"
    invoke-static v2, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v5, "config"
    move-object/from16 v6, v20
    invoke-static v6, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v5, v0
    check-cast v5, Ljava/lang/CharSequence;
    invoke-static v5, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v5
    if-eqz v5, +004h
    monitor-exit v17
    return-void 
    invoke-virtual/range v20, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;->getVersion()I
    move-result v5
    const/4 v14, 1
    invoke-static v5, v14, Lkotlin/ranges/RangesKt;->coerceAtLeast(I I)I
    move-result v5
    sget-object v15, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStore;->INSTANCE Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStore;
    sget-object v13, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptPolicy;->INSTANCE Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptPolicy;
    const/4 v7, 0
    const/4 v9, 0
    const-wide/16 v10, 0
    const/16 v12, 13
    const/16 v16, 0
    move-object/from16 v6, v20
    move v8, v5
    move-object v14, v13
    move-object/from16 v13, v16
    invoke-static/range v6 ... v13, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;->copy$default(Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig; Z I Ljava/util/List; J I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;
    move-result-object v6
    invoke-virtual v14, v2, v6, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptPolicy;->managedCandidate$conversation_mainlandRelease(Lcom/bytedance/trae/conversation/devices/DeviceProductType; Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;)Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;
    move-result-object v6
    invoke-virtual v15, v0, v6, v3, v4, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStore;->recordShown(Ljava/lang/String; Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate; J)V
    invoke-direct/range v17 ... v18, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptStore;->repo(Ljava/lang/String;)Lcom/bytedance/keva/Keva;
    move-result-object v0
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptStore;->legacyShownKey(Lcom/bytedance/trae/conversation/devices/DeviceProductType;)Ljava/lang/String;
    move-result-object v6
    const/4 v7, 1
    invoke-virtual v0, v6, v7, Lcom/bytedance/keva/Keva;->storeBoolean(Ljava/lang/String; Z)V
    invoke-direct v1, v2, v5, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptStore;->versionedShownKey(Lcom/bytedance/trae/conversation/devices/DeviceProductType; I)Ljava/lang/String;
    move-result-object v6
    invoke-virtual v0, v6, v7, Lcom/bytedance/keva/Keva;->storeBoolean(Ljava/lang/String; Z)V
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptStore;->highestShownVersionKey(Lcom/bytedance/trae/conversation/devices/DeviceProductType;)Ljava/lang/String;
    move-result-object v6
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptStore;->highestShownVersionKey(Lcom/bytedance/trae/conversation/devices/DeviceProductType;)Ljava/lang/String;
    move-result-object v2
    const/4 v7, 0
    invoke-virtual v0, v2, v7, Lcom/bytedance/keva/Keva;->getInt(Ljava/lang/String; I)I
    move-result v2
    invoke-static v2, v5, Ljava/lang/Math;->max(I I)I
    move-result v2
    invoke-virtual v0, v6, v2, Lcom/bytedance/keva/Keva;->storeInt(Ljava/lang/String; I)V
    const-string v2, "last_shown_at"
    invoke-virtual v0, v2, v3, v4, Lcom/bytedance/keva/Keva;->storeLong(Ljava/lang/String; J)V
    monitor-exit v17
    return-void 
    move-exception v0
    monitor-exit v17
    throw v0
    :try_start_0x9
    :try_start_0x26
.end method

.method public final synchronized recordLoginObserved(java.lang.String  long)long
    .registers 9
    # ins_size=4
    monitor-enter v5
    const-string/jumbo v0, userId
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v0, v6
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    const-wide/16 v1, 0
    if-eqz v0, +004h
    monitor-exit v5
    return-wide v1
    invoke-direct v5, v6, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptStore;->repo(Ljava/lang/String;)Lcom/bytedance/keva/Keva;
    move-result-object v0
    const-string v3, "first_login_observed_at"
    invoke-virtual v0, v3, v1, v2, Lcom/bytedance/keva/Keva;->getLong(Ljava/lang/String; J)J
    move-result-wide v3
    cmp-long v1, v3, v1
    if-lez v1, +004h
    move-wide v7, v3
    goto +6h
    const-string v1, "first_login_observed_at"
    invoke-virtual v0, v1, v7, v8, Lcom/bytedance/keva/Keva;->storeLong(Ljava/lang/String; J)V
    invoke-direct v5, v6, v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptStore;->mergeLegacyExposureIntoUnifiedLedger(Ljava/lang/String; Lcom/bytedance/keva/Keva;)V
    monitor-exit v5
    return-wide v7
    move-exception v6
    monitor-exit v5
    throw v6
    :try_start_0x1
    :try_start_0x14
.end method

.method public final synchronized snapshot(java.lang.String  com.bytedance.trae.conversation.devices.newfeature.NewFeaturePromptConfig)com.bytedance.trae.conversation.devices.newfeature.NewFeaturePromptState
    .registers 26
    # ins_size=3
    move-object/from16 v1, v23
    move-object/from16 v0, v24
    move-object/from16 v2, v25
    monitor-enter v23
    const-string/jumbo v3, userId
    invoke-static v0, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v3, "config"
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v3, v0
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v3, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v3
    if-eqz v3, +01bh
    new-instance v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;
    invoke-static Lkotlin/collections/SetsKt;->emptySet()Ljava/util/Set;
    move-result-object v5
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const-wide/16 v10, 0
    const/4 v12, 0
    const-wide/16 v13, 0
    const/16 v15, 254
    const/16 v16, 0
    move-object v4, v0
    invoke-direct/range v4 ... v16, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;-><init>(Ljava/util/Set; Ljava/util/Set; Ljava/util/Set; Ljava/util/Set; Ljava/util/Map; J Z J I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    monitor-exit v23
    return-object v0
    invoke-direct/range v23 ... v24, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptStore;->repo(Ljava/lang/String;)Lcom/bytedance/keva/Keva;
    move-result-object v3
    invoke-direct v1, v0, v3, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptStore;->mergeLegacyExposureIntoUnifiedLedger(Ljava/lang/String; Lcom/bytedance/keva/Keva;)V
    sget-object v4, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStore;->INSTANCE Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStore;
    invoke-virtual v4, v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStore;->snapshot(Ljava/lang/String;)Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;
    move-result-object v0
    invoke-static Lcom/bytedance/trae/conversation/devices/DeviceProductType;->values()[Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-result-object v4
    new-instance v5, Ljava/util/LinkedHashMap;
    array-length v6, v4
    invoke-static v6, Lkotlin/collections/MapsKt;->mapCapacity(I)I
    move-result v6
    const/16 v7, 16
    invoke-static v6, v7, Lkotlin/ranges/RangesKt;->coerceAtLeast(I I)I
    move-result v6
    invoke-direct v5, v6, Ljava/util/LinkedHashMap;-><init>(I)V
    array-length v6, v4
    const/4 v7, 0
    move v8, v7
    const/4 v9, 1
    if-ge v8, v6, +05dh
    aget-object v10, v4, v8
    move-object v11, v5
    check-cast v11, Ljava/util/Map;
    sget-object v12, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptStore;->INSTANCE Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptStore;
    invoke-direct v12, v10, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptStore;->highestShownVersionKey(Lcom/bytedance/trae/conversation/devices/DeviceProductType;)Ljava/lang/String;
    move-result-object v13
    invoke-virtual v3, v13, v7, Lcom/bytedance/keva/Keva;->getInt(Ljava/lang/String; I)I
    move-result v13
    const/4 v14, 3
    new-array v14, v14, [I
    invoke-direct v12, v3, v10, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptStore;->legacyShownVersion(Lcom/bytedance/keva/Keva; Lcom/bytedance/trae/conversation/devices/DeviceProductType;)I
    move-result v15
    aput v15, v14, v7
    invoke-virtual/range v25, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;->getVersion()I
    move-result v15
    invoke-direct v12, v10, v15, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptStore;->versionedShownKey(Lcom/bytedance/trae/conversation/devices/DeviceProductType; I)Ljava/lang/String;
    move-result-object v12
    invoke-virtual v3, v12, v7, Lcom/bytedance/keva/Keva;->getBoolean(Ljava/lang/String; Z)Z
    move-result v12
    if-eqz v12, +007h
    invoke-virtual/range v25, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;->getVersion()I
    move-result v12
    goto +2h
    move v12, v7
    aput v12, v14, v9
    invoke-virtual v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;->getShownVersions()Ljava/util/Map;
    move-result-object v9
    sget-object v12, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptPolicy;->INSTANCE Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptPolicy;
    invoke-virtual v12, v10, v2, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptPolicy;->managedCandidate$conversation_mainlandRelease(Lcom/bytedance/trae/conversation/devices/DeviceProductType; Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;)Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;
    move-result-object v12
    invoke-virtual v12, Lcom/bytedance/trae/conversation/prompt/ManagedPromptCandidate;->getCampaignId()Ljava/lang/String;
    move-result-object v12
    invoke-interface v9, v12, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v9
    check-cast v9, Ljava/lang/Integer;
    if-eqz v9, +007h
    invoke-virtual v9, Ljava/lang/Integer;->intValue()I
    move-result v9
    goto +2h
    move v9, v7
    const/4 v12, 2
    aput v9, v14, v12
    invoke-static v13, v14, Lkotlin/comparisons/ComparisonsKt;->maxOf(I [I)I
    move-result v9
    invoke-static v9, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v9
    invoke-interface v11, v10, v9, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    add-int/lit8 v8, v8, 1
    goto -5dh
    check-cast v5, Ljava/util/Map;
    new-instance v2, Ljava/util/LinkedHashMap;
    invoke-direct v2, Ljava/util/LinkedHashMap;-><init>()V
    invoke-interface v5, Ljava/util/Map;->entrySet()Ljava/util/Set;
    move-result-object v4
    invoke-interface v4, Ljava/util/Set;->iterator()Ljava/util/Iterator;
    move-result-object v4
    invoke-interface v4, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    if-eqz v5, +025h
    invoke-interface v4, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Ljava/util/Map$Entry;
    invoke-interface v5, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Ljava/lang/Number;
    invoke-virtual v6, Ljava/lang/Number;->intValue()I
    move-result v6
    if-lez v6, +004h
    move v6, v9
    goto +2h
    move v6, v7
    if-eqz v6, -01bh
    invoke-interface v5, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v6
    invoke-interface v5, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v5
    invoke-virtual v2, v6, v5, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    goto -28h
    move-object v15, v2
    check-cast v15, Ljava/util/Map;
    new-instance v2, Ljava/util/ArrayList;
    invoke-interface v15, Ljava/util/Map;->size()I
    move-result v4
    invoke-direct v2, v4, Ljava/util/ArrayList;-><init>(I)V
    check-cast v2, Ljava/util/Collection;
    invoke-interface v15, Ljava/util/Map;->entrySet()Ljava/util/Set;
    move-result-object v4
    invoke-interface v4, Ljava/util/Set;->iterator()Ljava/util/Iterator;
    move-result-object v4
    invoke-interface v4, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    if-eqz v5, +021h
    invoke-interface v4, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Ljava/util/Map$Entry;
    invoke-interface v5, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    invoke-interface v5, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Ljava/lang/Number;
    invoke-virtual v5, Ljava/lang/Number;->intValue()I
    move-result v5
    new-instance v7, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptRecord;
    invoke-direct v7, v6, v5, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptRecord;-><init>(Lcom/bytedance/trae/conversation/devices/DeviceProductType; I)V
    invoke-interface v2, v7, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -24h
    check-cast v2, Ljava/util/List;
    check-cast v2, Ljava/lang/Iterable;
    invoke-static v2, Lkotlin/collections/CollectionsKt;->toSet(Ljava/lang/Iterable;)Ljava/util/Set;
    move-result-object v14
    new-instance v2, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;
    invoke-interface v15, Ljava/util/Map;->keySet()Ljava/util/Set;
    move-result-object v11
    const/4 v12, 0
    const/4 v13, 0
    const-string v4, "first_login_observed_at"
    const-wide/16 v5, 0
    invoke-virtual v3, v4, v5, v6, Lcom/bytedance/keva/Keva;->getLong(Ljava/lang/String; J)J
    move-result-wide v16
    const/16 v18, 0
    const-string v4, "last_shown_at"
    invoke-virtual v3, v4, v5, v6, Lcom/bytedance/keva/Keva;->getLong(Ljava/lang/String; J)J
    move-result-wide v3
    invoke-virtual v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerState;->getLastShownAtMillis()J
    move-result-wide v5
    invoke-static v3, v4, v5, v6, Ljava/lang/Math;->max(J J)J
    move-result-wide v19
    const/16 v21, 70
    const/16 v22, 0
    move-object v10, v2
    invoke-direct/range v10 ... v22, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;-><init>(Ljava/util/Set; Ljava/util/Set; Ljava/util/Set; Ljava/util/Set; Ljava/util/Map; J Z J I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    monitor-exit v23
    return-object v2
    move-exception v0
    monitor-exit v23
    throw v0
    :try_start_0x7
    :try_start_0x34
.end method
