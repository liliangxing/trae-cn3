# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;
.super Ljava/lang/Object;
.source "SiteMessagePreferencesCache.kt"

.field public static final $stable:I
.field public static final INSTANCE:Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;
.field private static final KEY_ITEMS:Ljava/lang/String;
.field private static final KEY_PREFERENCES:Ljava/lang/String;
.field private static final PREFS_NAME:Ljava/lang/String;
.field private static final gson:Lcom/google/gson/Gson;
.field private static bridge memoryItems:Ljava/util/List;
.field private static bridge memoryPreferences:Ljava/util/Map;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;
    invoke-direct v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;-><init>()V
    sput-object v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;->INSTANCE Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;
    new-instance v0, Lcom/google/gson/Gson;
    invoke-direct v0, Lcom/google/gson/Gson;-><init>()V
    sput-object v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;->gson Lcom/google/gson/Gson;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;->$stable I
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final getCacheKeySuffix()java.lang.String
    .registers 3
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v0, v1, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/api/ILoginService;
    if-eqz v0, +00dh
    invoke-interface v0, Lcom/bytedance/trae/login/api/ILoginService;->getAccountInfo()Lcom/bytedance/trae/login/api/AccountInfo;
    move-result-object v0
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/login/api/AccountInfo;->getUserId()Ljava/lang/String;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    if-nez v0, +004h
    const-string v0, ""
    return-object v0
.end method

.method private final getPrefs()android.content.SharedPreferences
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v0
    const-string/jumbo v1, site_message_preferences
    const/4 v2, 0
    invoke-virtual v0, v1, v2, Landroid/app/Application;->getSharedPreferences(Ljava/lang/String; I)Landroid/content/SharedPreferences;
    move-result-object v0
    const-string v1, "getSharedPreferences(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v0
.end method

.method private final loadFromDisk()java.util.Map
    .registers 5
    # ins_size=1
    invoke-direct v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;->getPrefs()Landroid/content/SharedPreferences;
    move-result-object v0
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "preferences."
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-direct v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;->getCacheKeySuffix()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const/4 v2, 0
    invoke-interface v0, v1, v2, Landroid/content/SharedPreferences;->getString(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    if-nez v0, +003h
    return-object v2
    sget-object v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;->gson Lcom/google/gson/Gson;
    new-instance v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache$loadFromDisk$1;
    invoke-direct v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache$loadFromDisk$1;-><init>()V
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache$loadFromDisk$1;->getType()Ljava/lang/reflect/Type;
    move-result-object v3
    invoke-virtual v1, v0, v3, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/reflect/Type;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/util/Map;
    move-object v2, v0
    return-object v2
    :try_start_0x1f
.end method

.method private final loadItemsFromDisk()java.util.List
    .registers 5
    # ins_size=1
    invoke-direct v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;->getPrefs()Landroid/content/SharedPreferences;
    move-result-object v0
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "items."
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-direct v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;->getCacheKeySuffix()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const/4 v2, 0
    invoke-interface v0, v1, v2, Landroid/content/SharedPreferences;->getString(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    if-nez v0, +003h
    return-object v2
    sget-object v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;->gson Lcom/google/gson/Gson;
    new-instance v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache$loadItemsFromDisk$1;
    invoke-direct v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache$loadItemsFromDisk$1;-><init>()V
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache$loadItemsFromDisk$1;->getType()Ljava/lang/reflect/Type;
    move-result-object v3
    invoke-virtual v1, v0, v3, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/reflect/Type;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/util/List;
    move-object v2, v0
    return-object v2
    :try_start_0x1f
.end method

.method public final clear()void
    .registers 5
    # ins_size=1
    const/4 v0, 0
    sput-object v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;->memoryPreferences Ljava/util/Map;
    sput-object v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;->memoryItems Ljava/util/List;
    invoke-direct v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;->getCacheKeySuffix()Ljava/lang/String;
    move-result-object v0
    invoke-direct v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;->getPrefs()Landroid/content/SharedPreferences;
    move-result-object v1
    invoke-interface v1, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;
    move-result-object v1
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "preferences."
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-interface v1, v2, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    move-result-object v1
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "items."
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-interface v1, v0, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    move-result-object v0
    invoke-interface v0, Landroid/content/SharedPreferences$Editor;->apply()V
    return-void 
.end method

.method public final defaultPreferences()java.util.Map
    .registers 13
    # ins_size=1
    invoke-virtual v12, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;->getStoreCountryCode()Ljava/lang/String;
    move-result-object v0
    const-string v1, "DE"
    const/4 v2, 1
    invoke-static v2, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v3
    invoke-static v0, v1, v2, Lkotlin/text/StringsKt;->equals(Ljava/lang/String; Ljava/lang/String; Z)Z
    move-result v0
    const-string v1, "feedback"
    const/4 v4, 3
    const-string v5, "account"
    const/4 v6, 2
    const-string/jumbo v7, tips
    const-string v8, "offers"
    const/4 v9, 4
    const/4 v10, 0
    invoke-static v10, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v11
    if-eqz v0, +021h
    new-array v0, v9, [Lkotlin/Pair;
    invoke-static v8, v11, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v8
    aput-object v8, v0, v10
    invoke-static v7, v11, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v7
    aput-object v7, v0, v2
    invoke-static v5, v3, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v2
    aput-object v2, v0, v6
    invoke-static v1, v11, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    aput-object v1, v0, v4
    invoke-static v0, Lkotlin/collections/MapsKt;->mapOf([Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v0
    goto +1fh
    new-array v0, v9, [Lkotlin/Pair;
    invoke-static v8, v3, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v8
    aput-object v8, v0, v10
    invoke-static v7, v3, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v7
    aput-object v7, v0, v2
    invoke-static v5, v3, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v2
    aput-object v2, v0, v6
    invoke-static v1, v3, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    aput-object v1, v0, v4
    invoke-static v0, Lkotlin/collections/MapsKt;->mapOf([Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v0
    return-object v0
.end method

.method public final get(java.lang.String)boolean
    .registers 3
    # ins_size=2
    const-string v0, "key"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;->getCurrentPreferences()Ljava/util/Map;
    move-result-object v0
    invoke-interface v0, v2, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/Boolean;
    if-eqz v2, +007h
    invoke-virtual v2, Ljava/lang/Boolean;->booleanValue()Z
    move-result v2
    goto +2h
    const/4 v2, 1
    return v2
.end method

.method public final getCurrentItems()java.util.List
    .registers 2
    # ins_size=1
    monitor-enter v1
    sget-object v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;->memoryItems Ljava/util/List;
    if-eqz v0, +004h
    monitor-exit v1
    return-object v0
    sget-object v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;->INSTANCE Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;
    invoke-direct v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;->loadItemsFromDisk()Ljava/util/List;
    move-result-object v0
    if-eqz v0, +005h
    sput-object v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;->memoryItems Ljava/util/List;
    goto +2h
    const/4 v0, 0
    monitor-exit v1
    return-object v0
    move-exception v0
    monitor-exit v1
    throw v0
    :try_start_0x1
    :try_start_0x7
.end method

.method public final getCurrentPreferences()java.util.Map
    .registers 3
    # ins_size=1
    monitor-enter v2
    sget-object v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;->memoryPreferences Ljava/util/Map;
    if-eqz v0, +004h
    monitor-exit v2
    return-object v0
    sget-object v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;->INSTANCE Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;
    invoke-direct v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;->loadFromDisk()Ljava/util/Map;
    move-result-object v1
    if-eqz v1, +006h
    sput-object v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;->memoryPreferences Ljava/util/Map;
    monitor-exit v2
    return-object v1
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;->defaultPreferences()Ljava/util/Map;
    move-result-object v0
    monitor-exit v2
    return-object v0
    move-exception v0
    monitor-exit v2
    throw v0
    :try_start_0x1
    :try_start_0x7
    :try_start_0x13
.end method

.method public final getEnabledTypes()java.lang.String
    .registers 11
    # ins_size=1
    invoke-virtual v10, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;->getCurrentPreferences()Ljava/util/Map;
    move-result-object v0
    new-instance v1, Ljava/util/LinkedHashMap;
    invoke-direct v1, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v1, Ljava/util/Map;
    invoke-interface v0, Ljava/util/Map;->entrySet()Ljava/util/Set;
    move-result-object v0
    invoke-interface v0, Ljava/util/Set;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +020h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/util/Map$Entry;
    invoke-interface v2, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/lang/Boolean;
    invoke-virtual v3, Ljava/lang/Boolean;->booleanValue()Z
    move-result v3
    if-eqz v3, -016h
    invoke-interface v2, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v3
    invoke-interface v2, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v2
    invoke-interface v1, v3, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    goto -23h
    invoke-interface v1, Ljava/util/Map;->keySet()Ljava/util/Set;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    invoke-static v0, Lkotlin/collections/CollectionsKt;->sorted(Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v0
    invoke-interface v0, Ljava/util/List;->isEmpty()Z
    move-result v1
    if-eqz v1, +005h
    const-string v0, "offers,tips,account,feedback"
    goto +15h
    move-object v1, v0
    check-cast v1, Ljava/lang/Iterable;
    const-string v0, ","
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
    return-object v0
.end method

.method public final getStoreCountryCode()java.lang.String
    .registers 3
    # ins_size=1
    invoke-static Ljava/util/Locale;->getDefault()Ljava/util/Locale;
    move-result-object v0
    invoke-virtual v0, Ljava/util/Locale;->getCountry()Ljava/lang/String;
    move-result-object v0
    const-string v1, "getCountry(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v0
.end method

.method public final save(java.util.Map)void
    .registers 5
    # ins_size=2
    const-string v0, "preferences"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sput-object v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;->memoryPreferences Ljava/util/Map;
    invoke-direct v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;->getPrefs()Landroid/content/SharedPreferences;
    move-result-object v0
    invoke-interface v0, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;
    move-result-object v0
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "preferences."
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-direct v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;->getCacheKeySuffix()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    sget-object v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;->gson Lcom/google/gson/Gson;
    invoke-virtual v2, v4, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v4
    invoke-interface v0, v1, v4, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String; Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    move-result-object v4
    invoke-interface v4, Landroid/content/SharedPreferences$Editor;->apply()V
    return-void 
.end method

.method public final saveItems(java.util.List)void
    .registers 5
    # ins_size=2
    const-string v0, "items"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sput-object v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;->memoryItems Ljava/util/List;
    invoke-direct v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;->getPrefs()Landroid/content/SharedPreferences;
    move-result-object v0
    invoke-interface v0, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;
    move-result-object v0
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "items."
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-direct v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;->getCacheKeySuffix()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    sget-object v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;->gson Lcom/google/gson/Gson;
    invoke-virtual v2, v4, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v4
    invoke-interface v0, v1, v4, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String; Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    move-result-object v4
    invoke-interface v4, Landroid/content/SharedPreferences$Editor;->apply()V
    return-void 
.end method
