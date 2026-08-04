# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityDefaults;
.super Ljava/lang/Object;
.source "FeatureCapabilityDefaults.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityDefaults;
.field private static final ssoDefaults:Ljava/util/Map;
.field private static final tobDefaults:Ljava/util/Map;
.field private static final tocDefaults:Ljava/util/Map;


.method static constructor <clinit>()void
    .registers 12
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityDefaults;
    invoke-direct v0, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityDefaults;-><init>()V
    sput-object v0, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityDefaults;->INSTANCE Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityDefaults;
    const/4 v0, 7
    new-array v1, v0, [Lkotlin/Pair;
    sget-object v2, Lcom/bytedance/trae/settings/api/feature/Feature;->CONNECTORS Lcom/bytedance/trae/settings/api/feature/Feature;
    const/4 v3, 1
    invoke-static v3, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v4
    invoke-static v2, v4, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v2
    const/4 v5, 0
    invoke-static v5, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v6
    aput-object v2, v1, v5
    sget-object v2, Lcom/bytedance/trae/settings/api/feature/Feature;->MOBILE_IDE_GUIDE Lcom/bytedance/trae/settings/api/feature/Feature;
    invoke-static v2, v6, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v2
    aput-object v2, v1, v3
    sget-object v2, Lcom/bytedance/trae/settings/api/feature/Feature;->BRAINSTORM_V2 Lcom/bytedance/trae/settings/api/feature/Feature;
    invoke-static v2, v4, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v2
    const/4 v7, 2
    aput-object v2, v1, v7
    sget-object v2, Lcom/bytedance/trae/settings/api/feature/Feature;->TASK_LIST_SEARCH Lcom/bytedance/trae/settings/api/feature/Feature;
    invoke-static v2, v4, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v2
    const/4 v8, 3
    aput-object v2, v1, v8
    sget-object v2, Lcom/bytedance/trae/settings/api/feature/Feature;->TASK_LIST_PIN Lcom/bytedance/trae/settings/api/feature/Feature;
    invoke-static v2, v4, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v2
    const/4 v9, 4
    aput-object v2, v1, v9
    sget-object v2, Lcom/bytedance/trae/settings/api/feature/Feature;->HTML_SHARE Lcom/bytedance/trae/settings/api/feature/Feature;
    invoke-static v2, v4, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v2
    const/4 v10, 5
    aput-object v2, v1, v10
    sget-object v2, Lcom/bytedance/trae/settings/api/feature/Feature;->PLUGIN Lcom/bytedance/trae/settings/api/feature/Feature;
    invoke-static v2, v4, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v2
    const/4 v11, 6
    aput-object v2, v1, v11
    invoke-static v1, Lkotlin/collections/MapsKt;->mapOf([Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v1
    sput-object v1, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityDefaults;->tocDefaults Ljava/util/Map;
    new-array v1, v0, [Lkotlin/Pair;
    sget-object v2, Lcom/bytedance/trae/settings/api/feature/Feature;->CONNECTORS Lcom/bytedance/trae/settings/api/feature/Feature;
    invoke-static v2, v6, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v2
    aput-object v2, v1, v5
    sget-object v2, Lcom/bytedance/trae/settings/api/feature/Feature;->MOBILE_IDE_GUIDE Lcom/bytedance/trae/settings/api/feature/Feature;
    invoke-static v2, v6, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v2
    aput-object v2, v1, v3
    sget-object v2, Lcom/bytedance/trae/settings/api/feature/Feature;->BRAINSTORM_V2 Lcom/bytedance/trae/settings/api/feature/Feature;
    invoke-static v2, v6, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v2
    aput-object v2, v1, v7
    sget-object v2, Lcom/bytedance/trae/settings/api/feature/Feature;->TASK_LIST_SEARCH Lcom/bytedance/trae/settings/api/feature/Feature;
    invoke-static v2, v6, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v2
    aput-object v2, v1, v8
    sget-object v2, Lcom/bytedance/trae/settings/api/feature/Feature;->TASK_LIST_PIN Lcom/bytedance/trae/settings/api/feature/Feature;
    invoke-static v2, v6, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v2
    aput-object v2, v1, v9
    sget-object v2, Lcom/bytedance/trae/settings/api/feature/Feature;->HTML_SHARE Lcom/bytedance/trae/settings/api/feature/Feature;
    invoke-static v2, v6, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v2
    aput-object v2, v1, v10
    sget-object v2, Lcom/bytedance/trae/settings/api/feature/Feature;->PLUGIN Lcom/bytedance/trae/settings/api/feature/Feature;
    invoke-static v2, v6, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v2
    aput-object v2, v1, v11
    invoke-static v1, Lkotlin/collections/MapsKt;->mapOf([Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v1
    sput-object v1, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityDefaults;->tobDefaults Ljava/util/Map;
    new-array v0, v0, [Lkotlin/Pair;
    sget-object v1, Lcom/bytedance/trae/settings/api/feature/Feature;->CONNECTORS Lcom/bytedance/trae/settings/api/feature/Feature;
    invoke-static v1, v4, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    aput-object v1, v0, v5
    sget-object v1, Lcom/bytedance/trae/settings/api/feature/Feature;->MOBILE_IDE_GUIDE Lcom/bytedance/trae/settings/api/feature/Feature;
    invoke-static v1, v6, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    aput-object v1, v0, v3
    sget-object v1, Lcom/bytedance/trae/settings/api/feature/Feature;->BRAINSTORM_V2 Lcom/bytedance/trae/settings/api/feature/Feature;
    invoke-static v1, v4, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    aput-object v1, v0, v7
    sget-object v1, Lcom/bytedance/trae/settings/api/feature/Feature;->TASK_LIST_SEARCH Lcom/bytedance/trae/settings/api/feature/Feature;
    invoke-static v1, v4, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    aput-object v1, v0, v8
    sget-object v1, Lcom/bytedance/trae/settings/api/feature/Feature;->TASK_LIST_PIN Lcom/bytedance/trae/settings/api/feature/Feature;
    invoke-static v1, v4, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    aput-object v1, v0, v9
    sget-object v1, Lcom/bytedance/trae/settings/api/feature/Feature;->HTML_SHARE Lcom/bytedance/trae/settings/api/feature/Feature;
    invoke-static v1, v4, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    aput-object v1, v0, v10
    sget-object v1, Lcom/bytedance/trae/settings/api/feature/Feature;->PLUGIN Lcom/bytedance/trae/settings/api/feature/Feature;
    invoke-static v1, v4, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    aput-object v1, v0, v11
    invoke-static v0, Lkotlin/collections/MapsKt;->mapOf([Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityDefaults;->ssoDefaults Ljava/util/Map;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final getDefault(com.bytedance.trae.settings.api.feature.Feature  com.bytedance.trae.settings.impl.feature.FeatureCapabilityScope)boolean
    .registers 4
    # ins_size=3
    const-string v0, "feature"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, scope
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityDefaults$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v3, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScope;->ordinal()I
    move-result v3
    aget v3, v0, v3
    const/4 v0, 1
    if-eq v3, v0, +014h
    const/4 v0, 2
    if-eq v3, v0, +00eh
    const/4 v0, 3
    if-ne v3, v0, +005h
    sget-object v3, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityDefaults;->tobDefaults Ljava/util/Map;
    goto +ch
    new-instance v2, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v2, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v2
    sget-object v3, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityDefaults;->ssoDefaults Ljava/util/Map;
    goto +3h
    sget-object v3, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityDefaults;->tocDefaults Ljava/util/Map;
    invoke-interface v3, v2, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/Boolean;
    if-eqz v2, +007h
    invoke-virtual v2, Ljava/lang/Boolean;->booleanValue()Z
    move-result v2
    goto +2h
    const/4 v2, 0
    return v2
.end method
