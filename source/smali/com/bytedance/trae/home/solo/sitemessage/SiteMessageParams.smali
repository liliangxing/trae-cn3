# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageParams;
.super Ljava/lang/Object;
.source "SiteMessageApi.kt"

.field public static final $stable:I
.field public static final INSTANCE:Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageParams;
.field public static final platform:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageParams;
    invoke-direct v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageParams;-><init>()V
    sput-object v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageParams;->INSTANCE Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageParams;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static synthetic buildQueryParams$default(com.bytedance.trae.home.solo.sitemessage.SiteMessageParams  java.util.Map  int  java.lang.Object)java.util.Map
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +006h
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageParams;->buildQueryParams(Ljava/util/Map;)Ljava/util/Map;
    move-result-object v0
    return-object v0
.end method

.method public final buildCountParams()java.util.Map
    .registers 4
    # ins_size=1
    const/4 v0, 4
    new-array v0, v0, [Lkotlin/Pair;
    const-string/jumbo v1, version
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageParams;->getVersion()Ljava/lang/String;
    move-result-object v2
    invoke-static v1, v2, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/4 v2, 0
    aput-object v1, v0, v2
    const-string v1, "platform"
    const-string v2, "Android"
    invoke-static v1, v2, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/4 v2, 1
    aput-object v1, v0, v2
    const-string v1, "language"
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageParams;->getLanguage()Ljava/lang/String;
    move-result-object v2
    invoke-static v1, v2, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/4 v2, 2
    aput-object v1, v0, v2
    sget-object v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;->INSTANCE Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;->getStoreCountryCode()Ljava/lang/String;
    move-result-object v1
    const-string/jumbo v2, storeCountryCode
    invoke-static v2, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/4 v2, 3
    aput-object v1, v0, v2
    invoke-static v0, Lkotlin/collections/MapsKt;->mapOf([Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v0
    return-object v0
.end method

.method public final buildQueryParams(java.util.Map)java.util.Map
    .registers 5
    # ins_size=2
    const-string v0, "extra"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 5
    new-array v0, v0, [Lkotlin/Pair;
    const-string/jumbo v1, version
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageParams;->getVersion()Ljava/lang/String;
    move-result-object v2
    invoke-static v1, v2, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/4 v2, 0
    aput-object v1, v0, v2
    const-string v1, "platform"
    const-string v2, "Android"
    invoke-static v1, v2, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/4 v2, 1
    aput-object v1, v0, v2
    const-string/jumbo v1, types
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageParams;->getTypes()Ljava/lang/String;
    move-result-object v2
    invoke-static v1, v2, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/4 v2, 2
    aput-object v1, v0, v2
    const-string v1, "language"
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageParams;->getLanguage()Ljava/lang/String;
    move-result-object v2
    invoke-static v1, v2, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/4 v2, 3
    aput-object v1, v0, v2
    sget-object v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;->INSTANCE Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;->getStoreCountryCode()Ljava/lang/String;
    move-result-object v1
    const-string/jumbo v2, storeCountryCode
    invoke-static v2, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/4 v2, 4
    aput-object v1, v0, v2
    invoke-static v0, Lkotlin/collections/MapsKt;->mutableMapOf([Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v0
    invoke-interface v0, v4, Ljava/util/Map;->putAll(Ljava/util/Map;)V
    return-object v0
.end method

.method public final getLanguage()java.lang.String
    .registers 6
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/utils/LocaleManager;->INSTANCE Lcom/bytedance/trae/utils/LocaleManager;
    invoke-virtual v0, Lcom/bytedance/trae/utils/LocaleManager;->getEffectiveLanguage()Ljava/lang/String;
    move-result-object v0
    const-string/jumbo v1, zh
    const/4 v2, 0
    const/4 v3, 2
    const/4 v4, 0
    invoke-static v0, v1, v2, v3, v4, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +006h
    const-string/jumbo v0, zh-cn
    goto +dh
    const-string v1, "ja"
    invoke-static v0, v1, v2, v3, v4, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +004h
    move-object v0, v1
    goto +3h
    const-string v0, "en"
    return-object v0
.end method

.method public final getTypes()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;->INSTANCE Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;->getEnabledTypes()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public final getVersion()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getVersionName()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
