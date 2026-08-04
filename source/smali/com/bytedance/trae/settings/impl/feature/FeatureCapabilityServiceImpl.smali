# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityServiceImpl;
.super Ljava/lang/Object;
.source "FeatureCapabilityServiceImpl.kt"

.implements Lcom/bytedance/trae/settings/api/feature/IFeatureCapabilityService;

.field public static final Companion:Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityServiceImpl$Companion;
.field private static final TAG:Ljava/lang/String;
.field private final debugOverrides:Ljava/util/Map;
.field private bridge remoteConfigs:Ljava/util/Map;
.field private settingsListenerRegistered:Z


.method public static synthetic $r8$lambda$rlyPTLkBa8eb71iIT8gx3WHYSYo(com.bytedance.trae.settings.impl.feature.FeatureCapabilityServiceImpl  com.bytedance.news.common.settings.api.SettingsData)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityServiceImpl;->ensureSettingsListener$lambda$10(Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityServiceImpl; Lcom/bytedance/news/common/settings/api/SettingsData;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityServiceImpl$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityServiceImpl$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityServiceImpl;->Companion Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityServiceImpl$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    invoke-direct v1, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityServiceImpl;->restoreDebugOverrides()Ljava/util/Map;
    move-result-object v0
    iput-object v0, v1, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityServiceImpl;->debugOverrides Ljava/util/Map;
    return-void 
.end method

.method private final ensureSettingsListener()void
    .registers 4
    # ins_size=1
    iget-boolean v0, v3, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityServiceImpl;->settingsListenerRegistered Z
    if-eqz v0, +003h
    return-void 
    const/4 v0, 1
    iput-boolean v0, v3, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityServiceImpl;->settingsListenerRegistered Z
    const-class v1, Lcom/bytedance/trae/settings/api/ISettingsService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v1
    const-class v2, Lcom/bytedance/trae/settings/api/ISettingsService;
    invoke-virtual v1, v2, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/settings/api/ISettingsService;
    if-eqz v1, +00ah
    new-instance v2, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityServiceImpl$$ExternalSyntheticLambda0;
    invoke-direct v2, v3, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityServiceImpl$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityServiceImpl;)V
    invoke-interface v1, v2, v0, Lcom/bytedance/trae/settings/api/ISettingsService;->registerListener(Lcom/bytedance/news/common/settings/SettingsUpdateListener; Z)V
    return-void 
.end method

.method private static final ensureSettingsListener$lambda$10(com.bytedance.trae.settings.impl.feature.FeatureCapabilityServiceImpl  com.bytedance.news.common.settings.api.SettingsData)void
    .registers 2
    # ins_size=2
    invoke-virtual v0, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityServiceImpl;->refresh()V
    return-void 
.end method

.method private final loadRemoteConfig(com.bytedance.trae.settings.impl.feature.FeatureCapabilityScope)java.util.Map
    .registers 8
    # ins_size=2
    iget-object v0, v6, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityServiceImpl;->remoteConfigs Ljava/util/Map;
    if-eqz v0, +009h
    invoke-interface v0, v7, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Ljava/util/Map;
    return-object v7
    const/4 v0, 0
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v1, v6
    check-cast v1, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityServiceImpl;
    const-class v1, Lcom/bytedance/trae/settings/impl/feature/IFeatureCapabilitySettings;
    invoke-static v1, Lcom/bytedance/news/common/settings/SettingsManager;->obtain(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/settings/impl/feature/IFeatureCapabilitySettings;
    if-eqz v1, +007h
    invoke-interface v1, Lcom/bytedance/trae/settings/impl/feature/IFeatureCapabilitySettings;->getConfig()Ljava/lang/String;
    move-result-object v1
    goto +2h
    move-object v1, v0
    invoke-static v1, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    goto +ch
    move-exception v1
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v1, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v1
    invoke-static v1, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    invoke-static v1, Lkotlin/Result;->exceptionOrNull-impl(Ljava/lang/Object;)Ljava/lang/Throwable;
    move-result-object v2
    const-string v3, "FeatureCapability"
    if-eqz v2, +009h
    sget-object v4, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v5, "loadRemoteConfig: obtain settings failed"
    invoke-virtual v4, v3, v5, v2, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    invoke-static v1, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +003h
    move-object v1, v0
    check-cast v1, Ljava/lang/String;
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v5, "loadRemoteConfig: raw json = "
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v2, v3, v4, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    if-nez v1, +003h
    return-object v0
    invoke-direct v6, v1, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityServiceImpl;->parseAndCacheRemoteJson(Ljava/lang/String;)V
    iget-object v1, v6, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityServiceImpl;->remoteConfigs Ljava/util/Map;
    if-eqz v1, +009h
    invoke-interface v1, v7, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v7
    move-object v0, v7
    check-cast v0, Ljava/util/Map;
    return-object v0
    :try_start_0xc
.end method

.method private final parseAndCacheRemoteJson(java.lang.String)void
    .registers 9
    # ins_size=2
    const-string v0, "FeatureCapability"
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v1, v7
    check-cast v1, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityServiceImpl;
    invoke-static Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScope;->getEntries()Lkotlin/enums/EnumEntries;
    move-result-object v1
    check-cast v1, Ljava/lang/Iterable;
    new-instance v2, Ljava/util/LinkedHashMap;
    const/16 v3, 10
    invoke-static v1, v3, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v3
    invoke-static v3, Lkotlin/collections/MapsKt;->mapCapacity(I)I
    move-result v3
    const/16 v4, 16
    invoke-static v3, v4, Lkotlin/ranges/RangesKt;->coerceAtLeast(I I)I
    move-result v3
    invoke-direct v2, v3, Ljava/util/LinkedHashMap;-><init>(I)V
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +016h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    move-object v4, v2
    check-cast v4, Ljava/util/Map;
    move-object v5, v3
    check-cast v5, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScope;
    sget-object v6, Lcom/bytedance/trae/settings/impl/feature/FeatureRemoteConfigParser;->INSTANCE Lcom/bytedance/trae/settings/impl/feature/FeatureRemoteConfigParser;
    invoke-virtual v6, v8, v5, Lcom/bytedance/trae/settings/impl/feature/FeatureRemoteConfigParser;->parse(Ljava/lang/String; Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScope;)Ljava/util/Map;
    move-result-object v5
    invoke-interface v4, v3, v5, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    goto -19h
    check-cast v2, Ljava/util/Map;
    iput-object v2, v7, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityServiceImpl;->remoteConfigs Ljava/util/Map;
    sget-object v8, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, Ljava/lang/StringBuilder;-><init>()V
    const-string/jumbo v2, parseAndCacheRemoteJson: remoteConfigs=
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v7, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityServiceImpl;->remoteConfigs Ljava/util/Map;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v8, v0, v1, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v8, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v8, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v8
    goto +ch
    move-exception v8
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v8, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v8
    invoke-static v8, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v8
    invoke-static v8, Lkotlin/Result;->exceptionOrNull-impl(Ljava/lang/Object;)Ljava/lang/Throwable;
    move-result-object v8
    if-eqz v8, +00ah
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string/jumbo v2, parseAndCacheRemoteJson failed
    invoke-virtual v1, v0, v2, v8, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-void 
    :try_start_0x2
.end method

.method private final resolveScope()com.bytedance.trae.settings.impl.feature.FeatureCapabilityScope
    .registers 5
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v0, v1, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/api/ILoginService;
    const/4 v1, 0
    if-eqz v0, +00ah
    invoke-interface v0, Lcom/bytedance/trae/login/api/ILoginService;->isTraeLoggedIn()Z
    move-result v2
    const/4 v3, 1
    if-ne v2, v3, +003h
    move v1, v3
    const/4 v2, 0
    if-eqz v1, +00eh
    if-eqz v0, +00ch
    invoke-interface v0, Lcom/bytedance/trae/login/api/ILoginService;->getAccountInfo()Lcom/bytedance/trae/login/api/AccountInfo;
    move-result-object v0
    if-eqz v0, +006h
    invoke-virtual v0, Lcom/bytedance/trae/login/api/AccountInfo;->getLoginPlatform()Ljava/lang/String;
    move-result-object v2
    sget-object v0, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScopeResolver;->INSTANCE Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScopeResolver;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScopeResolver;->resolve(Z Ljava/lang/String;)Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScope;
    move-result-object v0
    return-object v0
.end method

.method private final restoreDebugOverrides()java.util.Map
    .registers 6
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isDebug()Z
    move-result v0
    if-nez v0, +00ah
    new-instance v0, Ljava/util/LinkedHashMap;
    invoke-direct v0, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v0, Ljava/util/Map;
    return-object v0
    new-instance v0, Ljava/util/LinkedHashMap;
    invoke-direct v0, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v0, Ljava/util/Map;
    invoke-static Lcom/bytedance/trae/settings/api/feature/Feature;->getEntries()Lkotlin/enums/EnumEntries;
    move-result-object v1
    invoke-interface v1, Lkotlin/enums/EnumEntries;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +020h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/settings/api/feature/Feature;
    sget-object v3, Lcom/bytedance/trae/network/DebugSettings;->INSTANCE Lcom/bytedance/trae/network/DebugSettings;
    invoke-virtual v2, Lcom/bytedance/trae/settings/api/feature/Feature;->getKey()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v4, Lcom/bytedance/trae/network/DebugSettings;->getFeatureOverride(Ljava/lang/String;)Ljava/lang/Boolean;
    move-result-object v3
    if-eqz v3, -016h
    invoke-virtual v3, Ljava/lang/Boolean;->booleanValue()Z
    move-result v3
    invoke-static v3, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v3
    invoke-interface v0, v2, v3, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    goto -23h
    return-object v0
.end method

.method public getEnabledFeatures()java.util.Set
    .registers 5
    # ins_size=1
    invoke-static Lcom/bytedance/trae/settings/api/feature/Feature;->getEntries()Lkotlin/enums/EnumEntries;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +013h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    move-object v3, v2
    check-cast v3, Lcom/bytedance/trae/settings/api/feature/Feature;
    invoke-virtual v4, v3, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityServiceImpl;->isEnabled(Lcom/bytedance/trae/settings/api/feature/Feature;)Z
    move-result v3
    if-eqz v3, -011h
    invoke-interface v1, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -16h
    check-cast v1, Ljava/util/List;
    check-cast v1, Ljava/lang/Iterable;
    invoke-static v1, Lkotlin/collections/CollectionsKt;->toSet(Ljava/lang/Iterable;)Ljava/util/Set;
    move-result-object v0
    return-object v0
.end method

.method public isEnabled(com.bytedance.trae.settings.api.feature.Feature)boolean
    .registers 10
    # ins_size=2
    const-string v0, "feature"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v8, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityServiceImpl;->ensureSettingsListener()V
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isDebug()Z
    move-result v0
    const-string v1, ") = "
    const-string v2, "isEnabled("
    const-string v3, "FeatureCapability"
    if-eqz v0, +035h
    iget-object v0, v8, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityServiceImpl;->debugOverrides Ljava/util/Map;
    invoke-interface v0, v9, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/Boolean;
    if-eqz v0, +02bh
    invoke-virtual v0, Ljava/lang/Boolean;->booleanValue()Z
    move-result v0
    sget-object v4, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v5, Ljava/lang/StringBuilder;
    invoke-direct v5, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v9, Lcom/bytedance/trae/settings/api/feature/Feature;->getKey()Ljava/lang/String;
    move-result-object v9
    invoke-virtual v5, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, v0, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v9
    const-string v1, " [source: debugOverride]"
    invoke-virtual v9, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v9
    invoke-virtual v4, v3, v9, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return v0
    invoke-direct v8, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityServiceImpl;->resolveScope()Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScope;
    move-result-object v0
    invoke-direct v8, v0, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityServiceImpl;->loadRemoteConfig(Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScope;)Ljava/util/Map;
    move-result-object v4
    const/16 v5, 93
    if-eqz v4, +043h
    invoke-virtual v9, Lcom/bytedance/trae/settings/api/feature/Feature;->getKey()Ljava/lang/String;
    move-result-object v6
    invoke-interface v4, v6, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Ljava/lang/Boolean;
    if-eqz v4, +037h
    invoke-virtual v4, Ljava/lang/Boolean;->booleanValue()Z
    move-result v4
    sget-object v6, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v7, Ljava/lang/StringBuilder;
    invoke-direct v7, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v9, Lcom/bytedance/trae/settings/api/feature/Feature;->getKey()Ljava/lang/String;
    move-result-object v9
    invoke-virtual v7, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, v4, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v9
    const-string v1, " [source: remoteConfig, scope="
    invoke-virtual v9, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v0, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScope;->getRemoteKey()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v9, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, v5, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v9
    invoke-virtual v6, v3, v9, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return v4
    sget-object v4, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityDefaults;->INSTANCE Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityDefaults;
    invoke-virtual v4, v9, v0, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityDefaults;->getDefault(Lcom/bytedance/trae/settings/api/feature/Feature; Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScope;)Z
    move-result v4
    sget-object v6, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v7, Ljava/lang/StringBuilder;
    invoke-direct v7, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v9, Lcom/bytedance/trae/settings/api/feature/Feature;->getKey()Ljava/lang/String;
    move-result-object v9
    invoke-virtual v7, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, v4, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v9
    const-string v1, " [source: default, scope="
    invoke-virtual v9, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v0, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScope;->getRemoteKey()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v9, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, v5, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v9
    invoke-virtual v6, v3, v9, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return v4
.end method

.method public isToBUser()boolean
    .registers 4
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v0, v1, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/api/ILoginService;
    const/4 v1, 0
    if-nez v0, +003h
    return v1
    invoke-interface v0, Lcom/bytedance/trae/login/api/ILoginService;->getAccountInfo()Lcom/bytedance/trae/login/api/AccountInfo;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/login/api/AccountInfo;->getAccountType()Lcom/bytedance/trae/login/api/AccountType;
    move-result-object v0
    sget-object v2, Lcom/bytedance/trae/login/api/AccountType;->TOB Lcom/bytedance/trae/login/api/AccountType;
    if-ne v0, v2, +003h
    const/4 v1, 1
    return v1
.end method

.method public refresh()void
    .registers 4
    # ins_size=1
    const/4 v0, 0
    iput-object v0, v3, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityServiceImpl;->remoteConfigs Ljava/util/Map;
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "FeatureCapability"
    const-string/jumbo v2, refresh: remote config cache cleared
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public setDebugOverride(com.bytedance.trae.settings.api.feature.Feature  java.lang.Boolean)void
    .registers 6
    # ins_size=3
    const-string v0, "feature"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    if-nez v5, +008h
    iget-object v0, v3, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityServiceImpl;->debugOverrides Ljava/util/Map;
    invoke-interface v0, v4, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    goto +6h
    iget-object v0, v3, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityServiceImpl;->debugOverrides Ljava/util/Map;
    invoke-interface v0, v4, v5, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v0, Lcom/bytedance/trae/network/DebugSettings;->INSTANCE Lcom/bytedance/trae/network/DebugSettings;
    invoke-virtual v4, Lcom/bytedance/trae/settings/api/feature/Feature;->getKey()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, v5, Lcom/bytedance/trae/network/DebugSettings;->setFeatureOverride(Ljava/lang/String; Ljava/lang/Boolean;)V
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string/jumbo v2, setDebugOverride: 
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, Lcom/bytedance/trae/settings/api/feature/Feature;->getKey()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v1, " = "
    invoke-virtual v4, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    const-string v5, "FeatureCapability"
    invoke-virtual v0, v5, v4, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method
