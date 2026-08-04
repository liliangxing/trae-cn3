# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;
.super Ljava/lang/Object;
.source "NewFeaturePromptPolicy.kt"

.field private final eligibleProductTypes:Ljava/util/Set;
.field private final firstLoginObservedAtMillis:J
.field private final hasConversation:Z
.field private final highestShownVersions:Ljava/util/Map;
.field private final lastShownAtMillis:J
.field private final registeredProductTypes:Ljava/util/Set;
.field private final shownProductTypes:Ljava/util/Set;
.field private final shownRecords:Ljava/util/Set;


.method public constructor <init>(java.util.Set  java.util.Set  java.util.Set  java.util.Set  java.util.Map  long  boolean  long)void
    .registers 12
    # ins_size=11
    const-string/jumbo v0, shownProductTypes
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "eligibleProductTypes"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "registeredProductTypes"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, shownRecords
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "highestShownVersions"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;->shownProductTypes Ljava/util/Set;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;->eligibleProductTypes Ljava/util/Set;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;->registeredProductTypes Ljava/util/Set;
    iput-object v5, v1, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;->shownRecords Ljava/util/Set;
    iput-object v6, v1, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;->highestShownVersions Ljava/util/Map;
    iput-wide v7, v1, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;->firstLoginObservedAtMillis J
    iput-boolean v9, v1, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;->hasConversation Z
    iput-wide v10, v1, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;->lastShownAtMillis J
    return-void 
.end method

.method public synthetic constructor <init>(java.util.Set  java.util.Set  java.util.Set  java.util.Set  java.util.Map  long  boolean  long  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 23
    # ins_size=13
    move/from16 v0, v21
    and-int/lit8 v1, v0, 2
    if-eqz v1, +00bh
    invoke-static Lcom/bytedance/trae/conversation/devices/DeviceProductType;->values()[Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-result-object v1
    invoke-static v1, Lkotlin/collections/ArraysKt;->toSet([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v1
    goto +2h
    move-object v1, v12
    and-int/lit8 v2, v0, 4
    if-eqz v2, +007h
    invoke-static Lkotlin/collections/SetsKt;->emptySet()Ljava/util/Set;
    move-result-object v2
    goto +2h
    move-object v2, v13
    and-int/lit8 v3, v0, 8
    if-eqz v3, +035h
    move-object v3, v11
    check-cast v3, Ljava/lang/Iterable;
    new-instance v4, Ljava/util/ArrayList;
    const/16 v5, 10
    invoke-static v3, v5, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v5
    invoke-direct v4, v5, Ljava/util/ArrayList;-><init>(I)V
    check-cast v4, Ljava/util/Collection;
    invoke-interface v3, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    if-eqz v5, +012h
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    new-instance v6, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptRecord;
    const/4 v7, 1
    invoke-direct v6, v5, v7, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptRecord;-><init>(Lcom/bytedance/trae/conversation/devices/DeviceProductType; I)V
    invoke-interface v4, v6, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -15h
    check-cast v4, Ljava/util/List;
    check-cast v4, Ljava/lang/Iterable;
    invoke-static v4, Lkotlin/collections/CollectionsKt;->toSet(Ljava/lang/Iterable;)Ljava/util/Set;
    move-result-object v3
    goto +2h
    move-object v3, v14
    and-int/lit8 v4, v0, 16
    if-eqz v4, +09eh
    move-object v4, v3
    check-cast v4, Ljava/lang/Iterable;
    new-instance v5, Ljava/util/LinkedHashMap;
    invoke-direct v5, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v5, Ljava/util/Map;
    invoke-interface v4, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v4
    invoke-interface v4, Ljava/util/Iterator;->hasNext()Z
    move-result v6
    if-eqz v6, +023h
    invoke-interface v4, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v6
    move-object v7, v6
    check-cast v7, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptRecord;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptRecord;->getProductType()Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-result-object v7
    invoke-interface v5, v7, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v8
    if-nez v8, +00ch
    new-instance v8, Ljava/util/ArrayList;
    invoke-direct v8, Ljava/util/ArrayList;-><init>()V
    check-cast v8, Ljava/util/List;
    invoke-interface v5, v7, v8, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    check-cast v8, Ljava/util/List;
    invoke-interface v8, v6, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto -26h
    new-instance v4, Ljava/util/LinkedHashMap;
    invoke-interface v5, Ljava/util/Map;->size()I
    move-result v6
    invoke-static v6, Lkotlin/collections/MapsKt;->mapCapacity(I)I
    move-result v6
    invoke-direct v4, v6, Ljava/util/LinkedHashMap;-><init>(I)V
    check-cast v4, Ljava/util/Map;
    invoke-interface v5, Ljava/util/Map;->entrySet()Ljava/util/Set;
    move-result-object v5
    check-cast v5, Ljava/lang/Iterable;
    invoke-interface v5, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v5
    invoke-interface v5, Ljava/util/Iterator;->hasNext()Z
    move-result v6
    if-eqz v6, +04bh
    invoke-interface v5, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Ljava/util/Map$Entry;
    invoke-interface v6, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v7
    invoke-interface v6, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Ljava/util/List;
    check-cast v6, Ljava/lang/Iterable;
    invoke-interface v6, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v6
    invoke-interface v6, Ljava/util/Iterator;->hasNext()Z
    move-result v8
    if-eqz v8, +028h
    invoke-interface v6, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v8
    check-cast v8, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptRecord;
    invoke-virtual v8, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptRecord;->getVersion()I
    move-result v8
    invoke-interface v6, Ljava/util/Iterator;->hasNext()Z
    move-result v9
    if-eqz v9, +010h
    invoke-interface v6, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v9
    check-cast v9, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptRecord;
    invoke-virtual v9, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptRecord;->getVersion()I
    move-result v9
    if-ge v8, v9, -010h
    move v8, v9
    goto -13h
    invoke-static v8, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    invoke-interface v4, v7, v6, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    goto -47h
    new-instance v0, Ljava/util/NoSuchElementException;
    invoke-direct v0, Ljava/util/NoSuchElementException;-><init>()V
    throw v0
    move-object v4, v15
    and-int/lit8 v5, v0, 32
    const-wide/16 v6, 0
    if-eqz v5, +004h
    move-wide v8, v6
    goto +3h
    move-wide/from16 v8, v16
    and-int/lit8 v5, v0, 64
    if-eqz v5, +004h
    const/4 v5, 0
    goto +3h
    move/from16 v5, v18
    and-int/lit16 v0, v0, 128
    if-eqz v0, +003h
    goto +3h
    move-wide/from16 v6, v19
    move-object v12, v10
    move-object v13, v11
    move-object v14, v1
    move-object v15, v2
    move-object/from16 v16, v3
    move-object/from16 v17, v4
    move-wide/from16 v18, v8
    move/from16 v20, v5
    move-wide/from16 v21, v6
    invoke-direct/range v12 ... v22, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;-><init>(Ljava/util/Set; Ljava/util/Set; Ljava/util/Set; Ljava/util/Set; Ljava/util/Map; J Z J)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.devices.newfeature.NewFeaturePromptState  java.util.Set  java.util.Set  java.util.Set  java.util.Set  java.util.Map  long  boolean  long  int  java.lang.Object)com.bytedance.trae.conversation.devices.newfeature.NewFeaturePromptState
    .registers 25
    # ins_size=13
    move-object v0, v12
    move/from16 v1, v23
    and-int/lit8 v2, v1, 1
    if-eqz v2, +005h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;->shownProductTypes Ljava/util/Set;
    goto +2h
    move-object v2, v13
    and-int/lit8 v3, v1, 2
    if-eqz v3, +005h
    iget-object v3, v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;->eligibleProductTypes Ljava/util/Set;
    goto +2h
    move-object v3, v14
    and-int/lit8 v4, v1, 4
    if-eqz v4, +005h
    iget-object v4, v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;->registeredProductTypes Ljava/util/Set;
    goto +2h
    move-object v4, v15
    and-int/lit8 v5, v1, 8
    if-eqz v5, +005h
    iget-object v5, v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;->shownRecords Ljava/util/Set;
    goto +3h
    move-object/from16 v5, v16
    and-int/lit8 v6, v1, 16
    if-eqz v6, +005h
    iget-object v6, v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;->highestShownVersions Ljava/util/Map;
    goto +3h
    move-object/from16 v6, v17
    and-int/lit8 v7, v1, 32
    if-eqz v7, +005h
    iget-wide v7, v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;->firstLoginObservedAtMillis J
    goto +3h
    move-wide/from16 v7, v18
    and-int/lit8 v9, v1, 64
    if-eqz v9, +005h
    iget-boolean v9, v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;->hasConversation Z
    goto +3h
    move/from16 v9, v20
    and-int/lit16 v1, v1, 128
    if-eqz v1, +005h
    iget-wide v10, v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;->lastShownAtMillis J
    goto +3h
    move-wide/from16 v10, v21
    move-object v13, v2
    move-object v14, v3
    move-object v15, v4
    move-object/from16 v16, v5
    move-object/from16 v17, v6
    move-wide/from16 v18, v7
    move/from16 v20, v9
    move-wide/from16 v21, v10
    invoke-virtual/range v12 ... v22, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;->copy(Ljava/util/Set; Ljava/util/Set; Ljava/util/Set; Ljava/util/Set; Ljava/util/Map; J Z J)Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.util.Set
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;->shownProductTypes Ljava/util/Set;
    return-object v0
.end method

.method public final component2()java.util.Set
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;->eligibleProductTypes Ljava/util/Set;
    return-object v0
.end method

.method public final component3()java.util.Set
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;->registeredProductTypes Ljava/util/Set;
    return-object v0
.end method

.method public final component4()java.util.Set
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;->shownRecords Ljava/util/Set;
    return-object v0
.end method

.method public final component5()java.util.Map
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;->highestShownVersions Ljava/util/Map;
    return-object v0
.end method

.method public final component6()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;->firstLoginObservedAtMillis J
    return-wide v0
.end method

.method public final component7()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;->hasConversation Z
    return v0
.end method

.method public final component8()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;->lastShownAtMillis J
    return-wide v0
.end method

.method public final copy(java.util.Set  java.util.Set  java.util.Set  java.util.Set  java.util.Map  long  boolean  long)com.bytedance.trae.conversation.devices.newfeature.NewFeaturePromptState
    .registers 23
    # ins_size=11
    const-string/jumbo v0, shownProductTypes
    move-object v2, v13
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "eligibleProductTypes"
    move-object v3, v14
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "registeredProductTypes"
    move-object v4, v15
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, shownRecords
    move-object/from16 v5, v16
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "highestShownVersions"
    move-object/from16 v6, v17
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;
    move-object v1, v0
    move-wide/from16 v7, v18
    move/from16 v9, v20
    move-wide/from16 v10, v21
    invoke-direct/range v1 ... v11, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;-><init>(Ljava/util/Set; Ljava/util/Set; Ljava/util/Set; Ljava/util/Set; Ljava/util/Map; J Z J)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 1
    if-ne v7, v8, +003h
    return v0
    instance-of v1, v8, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v8, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;
    iget-object v1, v7, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;->shownProductTypes Ljava/util/Set;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;->shownProductTypes Ljava/util/Set;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;->eligibleProductTypes Ljava/util/Set;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;->eligibleProductTypes Ljava/util/Set;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;->registeredProductTypes Ljava/util/Set;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;->registeredProductTypes Ljava/util/Set;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;->shownRecords Ljava/util/Set;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;->shownRecords Ljava/util/Set;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;->highestShownVersions Ljava/util/Map;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;->highestShownVersions Ljava/util/Map;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;->firstLoginObservedAtMillis J
    iget-wide v5, v8, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;->firstLoginObservedAtMillis J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-boolean v1, v7, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;->hasConversation Z
    iget-boolean v3, v8, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;->hasConversation Z
    if-eq v1, v3, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;->lastShownAtMillis J
    iget-wide v5, v8, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;->lastShownAtMillis J
    cmp-long v8, v3, v5
    if-eqz v8, +003h
    return v2
    return v0
.end method

.method public final getEligibleProductTypes()java.util.Set
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;->eligibleProductTypes Ljava/util/Set;
    return-object v0
.end method

.method public final getFirstLoginObservedAtMillis()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;->firstLoginObservedAtMillis J
    return-wide v0
.end method

.method public final getHasConversation()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;->hasConversation Z
    return v0
.end method

.method public final getHighestShownVersions()java.util.Map
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;->highestShownVersions Ljava/util/Map;
    return-object v0
.end method

.method public final getLastShownAtMillis()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;->lastShownAtMillis J
    return-wide v0
.end method

.method public final getRegisteredProductTypes()java.util.Set
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;->registeredProductTypes Ljava/util/Set;
    return-object v0
.end method

.method public final getShownProductTypes()java.util.Set
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;->shownProductTypes Ljava/util/Set;
    return-object v0
.end method

.method public final getShownRecords()java.util.Set
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;->shownRecords Ljava/util/Set;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;->shownProductTypes Ljava/util/Set;
    invoke-virtual v0, Ljava/lang/Object;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;->eligibleProductTypes Ljava/util/Set;
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;->registeredProductTypes Ljava/util/Set;
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;->shownRecords Ljava/util/Set;
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;->highestShownVersions Ljava/util/Map;
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;->firstLoginObservedAtMillis J
    invoke-static v1, v2, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v3, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;->hasConversation Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;->lastShownAtMillis J
    invoke-static v1, v2, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "NewFeaturePromptState(shownProductTypes="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v3, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;->shownProductTypes Ljava/util/Set;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", eligibleProductTypes="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;->eligibleProductTypes Ljava/util/Set;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", registeredProductTypes="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;->registeredProductTypes Ljava/util/Set;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", shownRecords="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;->shownRecords Ljava/util/Set;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", highestShownVersions="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;->highestShownVersions Ljava/util/Map;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", firstLoginObservedAtMillis="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;->firstLoginObservedAtMillis J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", hasConversation="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v3, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;->hasConversation Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", lastShownAtMillis="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptState;->lastShownAtMillis J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
