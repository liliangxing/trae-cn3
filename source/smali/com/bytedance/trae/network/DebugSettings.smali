# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/network/DebugSettings;
.super Ljava/lang/Object;
.source "DebugSettings.kt"

.field public static final ENTERPRISE_ENV_ONLINE:Ljava/lang/String;
.field public static final ENTERPRISE_ENV_TEST:Ljava/lang/String;
.field public static final INSTANCE:Lcom/bytedance/trae/network/DebugSettings;
.field private static final KEY_CUSTOM_HEADERS:Ljava/lang/String;
.field private static final KEY_DEBUG_FLOATING_BUTTON:Ljava/lang/String;
.field private static final KEY_ENTERPRISE_ENV:Ljava/lang/String;
.field private static final KEY_ENV_LANE:Ljava/lang/String;
.field private static final KEY_FEATURE_OVERRIDE_PREFIX:Ljava/lang/String;
.field private static final KEY_FORCE_TOKEN_REFRESH:Ljava/lang/String;
.field private static final KEY_MOCK_DID:Ljava/lang/String;
.field private static final KEY_NOTIFICATION_BOE:Ljava/lang/String;
.field private static final KEY_PPE_ENV:Ljava/lang/String;
.field private static final KEY_PPE_HISTORY:Ljava/lang/String;
.field private static final MAX_HISTORY_SIZE:I
.field private static final REPO_NAME:Ljava/lang/String;
.field private static bridge cachedCustomHeaders:Ljava/util/Map;
.field private static final repo$delegate:Lkotlin/Lazy;


.method public static synthetic $r8$lambda$hmSbAXLMSjbPTT-mhATywqom4zE()com.bytedance.keva.Keva
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/network/DebugSettings;->repo_delegate$lambda$0()Lcom/bytedance/keva/Keva;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/network/DebugSettings;
    invoke-direct v0, Lcom/bytedance/trae/network/DebugSettings;-><init>()V
    sput-object v0, Lcom/bytedance/trae/network/DebugSettings;->INSTANCE Lcom/bytedance/trae/network/DebugSettings;
    new-instance v0, Lcom/bytedance/trae/network/DebugSettings$$ExternalSyntheticLambda0;
    invoke-direct v0, Lcom/bytedance/trae/network/DebugSettings$$ExternalSyntheticLambda0;-><init>()V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/network/DebugSettings;->repo$delegate Lkotlin/Lazy;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final addPpeHistory(java.lang.String)void
    .registers 12
    # ins_size=2
    invoke-virtual v10, Lcom/bytedance/trae/network/DebugSettings;->getPpeHistory()Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/util/Collection;
    invoke-static v0, Lkotlin/collections/CollectionsKt;->toMutableList(Ljava/util/Collection;)Ljava/util/List;
    move-result-object v0
    invoke-interface v0, v11, Ljava/util/List;->remove(Ljava/lang/Object;)Z
    const/4 v1, 0
    invoke-interface v0, v1, v11, Ljava/util/List;->add(I Ljava/lang/Object;)V
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v11
    const/16 v1, 10
    if-le v11, v1, +00dh
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v11
    invoke-interface v0, v1, v11, Ljava/util/List;->subList(I I)Ljava/util/List;
    move-result-object v11
    invoke-interface v11, Ljava/util/List;->clear()V
    invoke-direct v10, Lcom/bytedance/trae/network/DebugSettings;->getRepo()Lcom/bytedance/keva/Keva;
    move-result-object v11
    move-object v1, v0
    check-cast v1, Ljava/lang/Iterable;
    const-string v0, "
"
    move-object v2, v0
    check-cast v2, Ljava/lang/CharSequence;
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/16 v8, 62
    const/4 v9, 0
    invoke-static/range v1 ... v9, Lkotlin/collections/CollectionsKt;->joinToString$default(Ljava/lang/Iterable; Ljava/lang/CharSequence; Ljava/lang/CharSequence; Ljava/lang/CharSequence; I Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v0
    const-string/jumbo v1, ppe_history
    invoke-virtual v11, v1, v0, Lcom/bytedance/keva/Keva;->storeString(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic buildDefaultHeaders$default(com.bytedance.trae.network.DebugSettings  java.util.Map  int  java.lang.Object)java.util.Map
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +006h
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/bytedance/trae/network/DebugSettings;->buildDefaultHeaders(Ljava/util/Map;)Ljava/util/Map;
    move-result-object v0
    return-object v0
.end method

.method private final getRepo()com.bytedance.keva.Keva
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/DebugSettings;->repo$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    const-string v1, "getValue(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Lcom/bytedance/keva/Keva;
    return-object v0
.end method

.method private static final repo_delegate$lambda$0()com.bytedance.keva.Keva
    .registers 2
    # ins_size=0
    const-string v0, "debug_settings"
    const/4 v1, 0
    invoke-static v0, v1, Lcom/bytedance/keva/Keva;->getRepo(Ljava/lang/String; I)Lcom/bytedance/keva/Keva;
    move-result-object v0
    return-object v0
.end method

.method public final addCustomHeader(java.lang.String  java.lang.String)void
    .registers 4
    # ins_size=3
    const-string v0, "key"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, value
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v1, Lcom/bytedance/trae/network/DebugSettings;->getCustomHeaders()Ljava/util/Map;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/MapsKt;->toMutableMap(Ljava/util/Map;)Ljava/util/Map;
    move-result-object v0
    invoke-interface v0, v2, v3, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    invoke-virtual v1, v0, Lcom/bytedance/trae/network/DebugSettings;->setCustomHeaders(Ljava/util/Map;)V
    return-void 
.end method

.method public final buildDefaultHeaders(java.util.Map)java.util.Map
    .registers 6
    # ins_size=2
    const-string v0, "extras"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/network/DefaultHeaderBuilder;->INSTANCE Lcom/bytedance/trae/network/DefaultHeaderBuilder;
    invoke-virtual v4, Lcom/bytedance/trae/network/DebugSettings;->getPpeHeaders()Ljava/util/Map;
    move-result-object v1
    invoke-virtual v4, Lcom/bytedance/trae/network/DebugSettings;->getEnvLane()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v4, Lcom/bytedance/trae/network/DebugSettings;->getCustomHeaders()Ljava/util/Map;
    move-result-object v3
    invoke-static v3, v5, Lkotlin/collections/MapsKt;->plus(Ljava/util/Map; Ljava/util/Map;)Ljava/util/Map;
    move-result-object v5
    invoke-virtual v0, v1, v2, v5, Lcom/bytedance/trae/network/DefaultHeaderBuilder;->build(Ljava/util/Map; Ljava/lang/String; Ljava/util/Map;)Ljava/util/Map;
    move-result-object v5
    return-object v5
.end method

.method public final getCustomHeaders()java.util.Map
    .registers 7
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/DebugSettings;->cachedCustomHeaders Ljava/util/Map;
    if-eqz v0, +003h
    return-object v0
    invoke-direct v6, Lcom/bytedance/trae/network/DebugSettings;->getRepo()Lcom/bytedance/keva/Keva;
    move-result-object v0
    const-string v1, "custom_headers"
    const-string v2, ""
    invoke-virtual v0, v1, v2, Lcom/bytedance/keva/Keva;->getString(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    if-nez v0, +003h
    move-object v0, v2
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-nez v1, +004h
    const/4 v1, 1
    goto +2h
    const/4 v1, 0
    if-eqz v1, +007h
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v0
    return-object v0
    new-instance v1, Lorg/json/JSONObject;
    invoke-direct v1, v0, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V
    new-instance v0, Ljava/util/LinkedHashMap;
    invoke-direct v0, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v0, Ljava/util/Map;
    invoke-virtual v1, Lorg/json/JSONObject;->keys()Ljava/util/Iterator;
    move-result-object v3
    const-string v4, "keys(...)"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +010h
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Ljava/lang/String;
    invoke-virtual v1, v4, v2, Lorg/json/JSONObject;->optString(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v5
    invoke-interface v0, v4, v5, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    goto -13h
    sput-object v0, Lcom/bytedance/trae/network/DebugSettings;->cachedCustomHeaders Ljava/util/Map;
    goto +5h
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v0
    return-object v0
    :try_start_0x27
.end method

.method public final getEnterpriseEnv()java.lang.String
    .registers 4
    # ins_size=1
    invoke-direct v3, Lcom/bytedance/trae/network/DebugSettings;->getRepo()Lcom/bytedance/keva/Keva;
    move-result-object v0
    const-string v1, "enterprise_env"
    const-string v2, "ONLINE"
    invoke-virtual v0, v1, v2, Lcom/bytedance/keva/Keva;->getString(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    if-nez v0, +003h
    goto +2h
    move-object v2, v0
    return-object v2
.end method

.method public final getEnvLane()java.lang.String
    .registers 4
    # ins_size=1
    invoke-direct v3, Lcom/bytedance/trae/network/DebugSettings;->getRepo()Lcom/bytedance/keva/Keva;
    move-result-object v0
    const-string v1, "env_lane"
    const-string v2, ""
    invoke-virtual v0, v1, v2, Lcom/bytedance/keva/Keva;->getString(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    if-nez v0, +003h
    goto +2h
    move-object v2, v0
    return-object v2
.end method

.method public final getFeatureOverride(java.lang.String)java.lang.Boolean
    .registers 5
    # ins_size=2
    const-string v0, "featureKey"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v3, Lcom/bytedance/trae/network/DebugSettings;->getRepo()Lcom/bytedance/keva/Keva;
    move-result-object v0
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "feature_override_"
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    const-string v1, ""
    invoke-virtual v0, v4, v1, Lcom/bytedance/keva/Keva;->getString(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    if-nez v4, +003h
    goto +2h
    move-object v1, v4
    invoke-static v1, Lkotlin/text/StringsKt;->toBooleanStrictOrNull(Ljava/lang/String;)Ljava/lang/Boolean;
    move-result-object v4
    return-object v4
.end method

.method public final getForceTokenRefresh()boolean
    .registers 4
    # ins_size=1
    invoke-direct v3, Lcom/bytedance/trae/network/DebugSettings;->getRepo()Lcom/bytedance/keva/Keva;
    move-result-object v0
    const-string v1, "force_token_refresh"
    const/4 v2, 0
    invoke-virtual v0, v1, v2, Lcom/bytedance/keva/Keva;->getBoolean(Ljava/lang/String; Z)Z
    move-result v0
    return v0
.end method

.method public final getNotificationBoe()boolean
    .registers 4
    # ins_size=1
    invoke-direct v3, Lcom/bytedance/trae/network/DebugSettings;->getRepo()Lcom/bytedance/keva/Keva;
    move-result-object v0
    const-string/jumbo v1, notification_boe
    const/4 v2, 0
    invoke-virtual v0, v1, v2, Lcom/bytedance/keva/Keva;->getBoolean(Ljava/lang/String; Z)Z
    move-result v0
    return v0
.end method

.method public final getPpeEnv()java.lang.String
    .registers 4
    # ins_size=1
    invoke-direct v3, Lcom/bytedance/trae/network/DebugSettings;->getRepo()Lcom/bytedance/keva/Keva;
    move-result-object v0
    const-string/jumbo v1, ppe_env
    const-string v2, ""
    invoke-virtual v0, v1, v2, Lcom/bytedance/keva/Keva;->getString(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    if-nez v0, +003h
    goto +2h
    move-object v2, v0
    return-object v2
.end method

.method public final getPpeHeaders()java.util.Map
    .registers 7
    # ins_size=1
    invoke-virtual v6, Lcom/bytedance/trae/network/DebugSettings;->getPpeEnv()Ljava/lang/String;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    const/4 v2, 1
    const/4 v3, 0
    if-nez v1, +004h
    move v1, v2
    goto +2h
    move v1, v3
    if-eqz v1, +007h
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v0
    return-object v0
    const/4 v1, 2
    new-array v1, v1, [Lkotlin/Pair;
    const-string v4, "X-Use-PPE"
    const-string v5, "1"
    invoke-static v4, v5, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v4
    aput-object v4, v1, v3
    const-string v3, "X-TT-ENV"
    invoke-static v3, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    aput-object v0, v1, v2
    invoke-static v1, Lkotlin/collections/MapsKt;->mapOf([Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v0
    return-object v0
.end method

.method public final getPpeHistory()java.util.List
    .registers 10
    # ins_size=1
    invoke-direct v9, Lcom/bytedance/trae/network/DebugSettings;->getRepo()Lcom/bytedance/keva/Keva;
    move-result-object v0
    const-string/jumbo v1, ppe_history
    const-string v2, ""
    invoke-virtual v0, v1, v2, Lcom/bytedance/keva/Keva;->getString(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    if-nez v0, +003h
    goto +2h
    move-object v2, v0
    move-object v3, v2
    check-cast v3, Ljava/lang/CharSequence;
    invoke-interface v3, Ljava/lang/CharSequence;->length()I
    move-result v0
    const/4 v1, 1
    const/4 v2, 0
    if-nez v0, +004h
    move v0, v1
    goto +2h
    move v0, v2
    if-eqz v0, +007h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    return-object v0
    const-string v0, "
"
    filled-new-array v0, [Ljava/lang/String;
    move-result-object v4
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 6
    const/4 v8, 0
    invoke-static/range v3 ... v8, Lkotlin/text/StringsKt;->split$default(Ljava/lang/CharSequence; [Ljava/lang/String; Z I I Ljava/lang/Object;)Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    new-instance v3, Ljava/util/ArrayList;
    invoke-direct v3, Ljava/util/ArrayList;-><init>()V
    check-cast v3, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +01ah
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    move-object v5, v4
    check-cast v5, Ljava/lang/String;
    check-cast v5, Ljava/lang/CharSequence;
    invoke-interface v5, Ljava/lang/CharSequence;->length()I
    move-result v5
    if-lez v5, +004h
    move v5, v1
    goto +2h
    move v5, v2
    if-eqz v5, -018h
    invoke-interface v3, v4, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1dh
    check-cast v3, Ljava/util/List;
    return-object v3
.end method

.method public final isDebugFloatingButtonEnabled()boolean
    .registers 4
    # ins_size=1
    invoke-direct v3, Lcom/bytedance/trae/network/DebugSettings;->getRepo()Lcom/bytedance/keva/Keva;
    move-result-object v0
    const-string v1, "debug_floating_button_enabled"
    const/4 v2, 1
    invoke-virtual v0, v1, v2, Lcom/bytedance/keva/Keva;->getBoolean(Ljava/lang/String; Z)Z
    move-result v0
    return v0
.end method

.method public final isDeviceManagerMockDid()boolean
    .registers 4
    # ins_size=1
    invoke-direct v3, Lcom/bytedance/trae/network/DebugSettings;->getRepo()Lcom/bytedance/keva/Keva;
    move-result-object v0
    const-string v1, "device_manager_mock_did"
    const/4 v2, 0
    invoke-virtual v0, v1, v2, Lcom/bytedance/keva/Keva;->getBoolean(Ljava/lang/String; Z)Z
    move-result v0
    return v0
.end method

.method public final isEnterpriseTestEnv()boolean
    .registers 3
    # ins_size=1
    invoke-virtual v2, Lcom/bytedance/trae/network/DebugSettings;->getEnterpriseEnv()Ljava/lang/String;
    move-result-object v0
    const-string v1, "TEST"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    return v0
.end method

.method public final isEnvLaneCustomized()boolean
    .registers 4
    # ins_size=1
    invoke-direct v3, Lcom/bytedance/trae/network/DebugSettings;->getRepo()Lcom/bytedance/keva/Keva;
    move-result-object v0
    const-string v1, "env_lane"
    const-string v2, ""
    invoke-virtual v0, v1, v2, Lcom/bytedance/keva/Keva;->getString(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    if-nez v0, +003h
    goto +2h
    move-object v2, v0
    check-cast v2, Ljava/lang/CharSequence;
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-lez v0, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    return v0
.end method

.method public final isPpeEnabled()boolean
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/network/DebugSettings;->getPpeEnv()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-lez v0, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    return v0
.end method

.method public final removeCustomHeader(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string v0, "key"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v1, Lcom/bytedance/trae/network/DebugSettings;->getCustomHeaders()Ljava/util/Map;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/MapsKt;->toMutableMap(Ljava/util/Map;)Ljava/util/Map;
    move-result-object v0
    invoke-interface v0, v2, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    invoke-virtual v1, v0, Lcom/bytedance/trae/network/DebugSettings;->setCustomHeaders(Ljava/util/Map;)V
    return-void 
.end method

.method public final removePpeHistory(java.lang.String)void
    .registers 12
    # ins_size=2
    const-string v0, "env"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v10, Lcom/bytedance/trae/network/DebugSettings;->getPpeHistory()Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/util/Collection;
    invoke-static v0, Lkotlin/collections/CollectionsKt;->toMutableList(Ljava/util/Collection;)Ljava/util/List;
    move-result-object v0
    invoke-interface v0, v11, Ljava/util/List;->remove(Ljava/lang/Object;)Z
    invoke-direct v10, Lcom/bytedance/trae/network/DebugSettings;->getRepo()Lcom/bytedance/keva/Keva;
    move-result-object v11
    move-object v1, v0
    check-cast v1, Ljava/lang/Iterable;
    const-string v0, "
"
    move-object v2, v0
    check-cast v2, Ljava/lang/CharSequence;
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/16 v8, 62
    const/4 v9, 0
    invoke-static/range v1 ... v9, Lkotlin/collections/CollectionsKt;->joinToString$default(Ljava/lang/Iterable; Ljava/lang/CharSequence; Ljava/lang/CharSequence; Ljava/lang/CharSequence; I Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v0
    const-string/jumbo v1, ppe_history
    invoke-virtual v11, v1, v0, Lcom/bytedance/keva/Keva;->storeString(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public final setCustomHeaders(java.util.Map)void
    .registers 6
    # ins_size=2
    const-string v0, "headers"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 0
    sput-object v0, Lcom/bytedance/trae/network/DebugSettings;->cachedCustomHeaders Ljava/util/Map;
    invoke-interface v5, Ljava/util/Map;->isEmpty()Z
    move-result v0
    const-string v1, "custom_headers"
    if-eqz v0, +00ch
    invoke-direct v4, Lcom/bytedance/trae/network/DebugSettings;->getRepo()Lcom/bytedance/keva/Keva;
    move-result-object v5
    const-string v0, ""
    invoke-virtual v5, v1, v0, Lcom/bytedance/keva/Keva;->storeString(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    invoke-interface v5, Ljava/util/Map;->entrySet()Ljava/util/Set;
    move-result-object v5
    invoke-interface v5, Ljava/util/Set;->iterator()Ljava/util/Iterator;
    move-result-object v5
    invoke-interface v5, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +018h
    invoke-interface v5, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/util/Map$Entry;
    invoke-interface v2, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/lang/String;
    invoke-interface v2, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/String;
    invoke-virtual v0, v3, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    goto -1bh
    invoke-direct v4, Lcom/bytedance/trae/network/DebugSettings;->getRepo()Lcom/bytedance/keva/Keva;
    move-result-object v5
    invoke-virtual v0, Lorg/json/JSONObject;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v5, v1, v0, Lcom/bytedance/keva/Keva;->storeString(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public final setDebugFloatingButtonEnabled(boolean)void
    .registers 4
    # ins_size=2
    invoke-direct v2, Lcom/bytedance/trae/network/DebugSettings;->getRepo()Lcom/bytedance/keva/Keva;
    move-result-object v0
    const-string v1, "debug_floating_button_enabled"
    invoke-virtual v0, v1, v3, Lcom/bytedance/keva/Keva;->storeBoolean(Ljava/lang/String; Z)V
    return-void 
.end method

.method public final setDeviceManagerMockDid(boolean)void
    .registers 4
    # ins_size=2
    invoke-direct v2, Lcom/bytedance/trae/network/DebugSettings;->getRepo()Lcom/bytedance/keva/Keva;
    move-result-object v0
    const-string v1, "device_manager_mock_did"
    invoke-virtual v0, v1, v3, Lcom/bytedance/keva/Keva;->storeBoolean(Ljava/lang/String; Z)V
    return-void 
.end method

.method public final setEnterpriseEnv(java.lang.String)void
    .registers 4
    # ins_size=2
    const-string/jumbo v0, value
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v2, Lcom/bytedance/trae/network/DebugSettings;->getRepo()Lcom/bytedance/keva/Keva;
    move-result-object v0
    const-string v1, "enterprise_env"
    invoke-virtual v0, v1, v3, Lcom/bytedance/keva/Keva;->storeString(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public final setEnvLane(java.lang.String)void
    .registers 4
    # ins_size=2
    const-string/jumbo v0, value
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v2, Lcom/bytedance/trae/network/DebugSettings;->getRepo()Lcom/bytedance/keva/Keva;
    move-result-object v0
    const-string v1, "env_lane"
    invoke-virtual v0, v1, v3, Lcom/bytedance/keva/Keva;->storeString(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public final setFeatureOverride(java.lang.String  java.lang.Boolean)void
    .registers 5
    # ins_size=3
    const-string v0, "featureKey"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "feature_override_"
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    if-nez v4, +00ch
    invoke-direct v2, Lcom/bytedance/trae/network/DebugSettings;->getRepo()Lcom/bytedance/keva/Keva;
    move-result-object v4
    const-string v0, ""
    invoke-virtual v4, v3, v0, Lcom/bytedance/keva/Keva;->storeString(Ljava/lang/String; Ljava/lang/String;)V
    goto +ch
    invoke-direct v2, Lcom/bytedance/trae/network/DebugSettings;->getRepo()Lcom/bytedance/keva/Keva;
    move-result-object v0
    invoke-virtual v4, Ljava/lang/Boolean;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v0, v3, v4, Lcom/bytedance/keva/Keva;->storeString(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public final setForceTokenRefresh(boolean)void
    .registers 4
    # ins_size=2
    invoke-direct v2, Lcom/bytedance/trae/network/DebugSettings;->getRepo()Lcom/bytedance/keva/Keva;
    move-result-object v0
    const-string v1, "force_token_refresh"
    invoke-virtual v0, v1, v3, Lcom/bytedance/keva/Keva;->storeBoolean(Ljava/lang/String; Z)V
    return-void 
.end method

.method public final setNotificationBoe(boolean)void
    .registers 4
    # ins_size=2
    invoke-direct v2, Lcom/bytedance/trae/network/DebugSettings;->getRepo()Lcom/bytedance/keva/Keva;
    move-result-object v0
    const-string/jumbo v1, notification_boe
    invoke-virtual v0, v1, v3, Lcom/bytedance/keva/Keva;->storeBoolean(Ljava/lang/String; Z)V
    return-void 
.end method

.method public final setPpeEnv(java.lang.String)void
    .registers 4
    # ins_size=2
    const-string/jumbo v0, value
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v2, Lcom/bytedance/trae/network/DebugSettings;->getRepo()Lcom/bytedance/keva/Keva;
    move-result-object v0
    const-string/jumbo v1, ppe_env
    invoke-virtual v0, v1, v3, Lcom/bytedance/keva/Keva;->storeString(Ljava/lang/String; Ljava/lang/String;)V
    move-object v0, v3
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-lez v0, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    if-eqz v0, +005h
    invoke-direct v2, v3, Lcom/bytedance/trae/network/DebugSettings;->addPpeHistory(Ljava/lang/String;)V
    return-void 
.end method
