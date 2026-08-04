# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/network/AndroidKmpHostResolverBridge;
.super Ljava/lang/Object;
.source "AndroidKmpHttpClientFactory.kt"

.field public static final $stable:I
.field public static final INSTANCE:Lcom/bytedance/trae/kmp/network/AndroidKmpHostResolverBridge;
.field private static final NOTIFICATION_BOE_BASE_URL:Ljava/lang/String;


.method public static synthetic $r8$lambda$7x-AgWXxPnVWtoEg9RVrh687Tks(com.bytedance.trae.kmp.network.KmpHostType)java.lang.String
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/kmp/network/AndroidKmpHostResolverBridge;->configure$lambda$4(Lcom/bytedance/trae/kmp/network/KmpHostType;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/kmp/network/AndroidKmpHostResolverBridge;
    invoke-direct v0, Lcom/bytedance/trae/kmp/network/AndroidKmpHostResolverBridge;-><init>()V
    sput-object v0, Lcom/bytedance/trae/kmp/network/AndroidKmpHostResolverBridge;->INSTANCE Lcom/bytedance/trae/kmp/network/AndroidKmpHostResolverBridge;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private static final configure$lambda$4(com.bytedance.trae.kmp.network.KmpHostType)java.lang.String
    .registers 2
    # ins_size=1
    const-string v0, "hostType"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/network/E2ENetworkOverrides;->INSTANCE Lcom/bytedance/trae/network/E2ENetworkOverrides;
    invoke-virtual v0, Lcom/bytedance/trae/network/E2ENetworkOverrides;->overrideBaseUrlOrNull()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +012h
    sget-object v0, Lcom/bytedance/trae/kmp/network/KmpHostType;->Notification Lcom/bytedance/trae/kmp/network/KmpHostType;
    if-ne v1, v0, +00dh
    sget-object v1, Lcom/bytedance/trae/network/DebugSettings;->INSTANCE Lcom/bytedance/trae/network/DebugSettings;
    invoke-virtual v1, Lcom/bytedance/trae/network/DebugSettings;->getNotificationBoe()Z
    move-result v1
    if-eqz v1, +005h
    const-string v0, "https://icube-boe-api.bytedance.net/"
    goto +2h
    const/4 v0, 0
    return-object v0
.end method

.method private final toKmpDomainList(com.bytedance.trae.network.DomainList)com.bytedance.trae.kmp.network.KmpDomainList
    .registers 7
    # ins_size=2
    invoke-virtual v6, Lcom/bytedance/trae/network/DomainList;->getNormal()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v6, Lcom/bytedance/trae/network/DomainList;->getRegions()Ljava/util/Map;
    move-result-object v6
    new-instance v1, Ljava/util/LinkedHashMap;
    invoke-interface v6, Ljava/util/Map;->size()I
    move-result v2
    invoke-static v2, Lkotlin/collections/MapsKt;->mapCapacity(I)I
    move-result v2
    invoke-direct v1, v2, Ljava/util/LinkedHashMap;-><init>(I)V
    check-cast v1, Ljava/util/Map;
    invoke-interface v6, Ljava/util/Map;->entrySet()Ljava/util/Set;
    move-result-object v6
    check-cast v6, Ljava/lang/Iterable;
    invoke-interface v6, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v6
    invoke-interface v6, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +035h
    invoke-interface v6, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/util/Map$Entry;
    invoke-interface v2, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/network/AiRegion;
    sget-object v4, Lcom/bytedance/trae/kmp/network/AndroidKmpHostResolverBridge$WhenMappings;->$EnumSwitchMapping$1 [I
    invoke-virtual v3, Lcom/bytedance/trae/network/AiRegion;->ordinal()I
    move-result v3
    aget v3, v4, v3
    const/4 v4, 1
    if-eq v3, v4, +014h
    const/4 v4, 2
    if-eq v3, v4, +00eh
    const/4 v4, 3
    if-ne v3, v4, +005h
    sget-object v3, Lcom/bytedance/trae/kmp/network/KmpAiRegion;->US Lcom/bytedance/trae/kmp/network/KmpAiRegion;
    goto +ch
    new-instance v6, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v6, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v6
    sget-object v3, Lcom/bytedance/trae/kmp/network/KmpAiRegion;->SG Lcom/bytedance/trae/kmp/network/KmpAiRegion;
    goto +3h
    sget-object v3, Lcom/bytedance/trae/kmp/network/KmpAiRegion;->CN Lcom/bytedance/trae/kmp/network/KmpAiRegion;
    invoke-interface v2, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v2
    invoke-interface v1, v3, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    goto -38h
    new-instance v6, Lcom/bytedance/trae/kmp/network/KmpDomainList;
    invoke-direct v6, v0, v1, Lcom/bytedance/trae/kmp/network/KmpDomainList;-><init>(Ljava/lang/String; Ljava/util/Map;)V
    return-object v6
.end method

.method private final toKmpHostEntry(com.bytedance.trae.network.HostEntry)com.bytedance.trae.kmp.network.KmpHostEntry
    .registers 7
    # ins_size=2
    new-instance v0, Lcom/bytedance/trae/kmp/network/KmpHostEntry;
    invoke-virtual v6, Lcom/bytedance/trae/network/HostEntry;->getPublicUser()Lcom/bytedance/trae/network/DomainList;
    move-result-object v1
    invoke-direct v5, v1, Lcom/bytedance/trae/kmp/network/AndroidKmpHostResolverBridge;->toKmpDomainList(Lcom/bytedance/trae/network/DomainList;)Lcom/bytedance/trae/kmp/network/KmpDomainList;
    move-result-object v1
    invoke-virtual v6, Lcom/bytedance/trae/network/HostEntry;->getBytecloudUser()Lcom/bytedance/trae/network/DomainList;
    move-result-object v2
    const/4 v3, 0
    if-eqz v2, +007h
    invoke-direct v5, v2, Lcom/bytedance/trae/kmp/network/AndroidKmpHostResolverBridge;->toKmpDomainList(Lcom/bytedance/trae/network/DomainList;)Lcom/bytedance/trae/kmp/network/KmpDomainList;
    move-result-object v2
    goto +2h
    move-object v2, v3
    invoke-virtual v6, Lcom/bytedance/trae/network/HostEntry;->getEnterpriseUser()Lcom/bytedance/trae/network/DomainList;
    move-result-object v4
    if-eqz v4, +007h
    invoke-direct v5, v4, Lcom/bytedance/trae/kmp/network/AndroidKmpHostResolverBridge;->toKmpDomainList(Lcom/bytedance/trae/network/DomainList;)Lcom/bytedance/trae/kmp/network/KmpDomainList;
    move-result-object v4
    goto +2h
    move-object v4, v3
    invoke-virtual v6, Lcom/bytedance/trae/network/HostEntry;->getEnterpriseBoeUser()Lcom/bytedance/trae/network/DomainList;
    move-result-object v6
    if-eqz v6, +006h
    invoke-direct v5, v6, Lcom/bytedance/trae/kmp/network/AndroidKmpHostResolverBridge;->toKmpDomainList(Lcom/bytedance/trae/network/DomainList;)Lcom/bytedance/trae/kmp/network/KmpDomainList;
    move-result-object v3
    invoke-direct v0, v1, v2, v4, v3, Lcom/bytedance/trae/kmp/network/KmpHostEntry;-><init>(Lcom/bytedance/trae/kmp/network/KmpDomainList; Lcom/bytedance/trae/kmp/network/KmpDomainList; Lcom/bytedance/trae/kmp/network/KmpDomainList; Lcom/bytedance/trae/kmp/network/KmpDomainList;)V
    return-object v0
.end method

.method private final toKmpHostType(com.bytedance.trae.network.HostType)com.bytedance.trae.kmp.network.KmpHostType
    .registers 3
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/kmp/network/AndroidKmpHostResolverBridge$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v2, Lcom/bytedance/trae/network/HostType;->ordinal()I
    move-result v2
    aget v2, v0, v2
    packed-switch v2, +0000036h
    new-instance v2, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v2, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v2
    sget-object v2, Lcom/bytedance/trae/kmp/network/KmpHostType;->PluginWeb Lcom/bytedance/trae/kmp/network/KmpHostType;
    goto +2ah
    sget-object v2, Lcom/bytedance/trae/kmp/network/KmpHostType;->Community Lcom/bytedance/trae/kmp/network/KmpHostType;
    goto +27h
    sget-object v2, Lcom/bytedance/trae/kmp/network/KmpHostType;->Docs Lcom/bytedance/trae/kmp/network/KmpHostType;
    goto +24h
    sget-object v2, Lcom/bytedance/trae/kmp/network/KmpHostType;->Website Lcom/bytedance/trae/kmp/network/KmpHostType;
    goto +21h
    sget-object v2, Lcom/bytedance/trae/kmp/network/KmpHostType;->Marketplace Lcom/bytedance/trae/kmp/network/KmpHostType;
    goto +1eh
    sget-object v2, Lcom/bytedance/trae/kmp/network/KmpHostType;->Notification Lcom/bytedance/trae/kmp/network/KmpHostType;
    goto +1bh
    sget-object v2, Lcom/bytedance/trae/kmp/network/KmpHostType;->Praise Lcom/bytedance/trae/kmp/network/KmpHostType;
    goto +18h
    sget-object v2, Lcom/bytedance/trae/kmp/network/KmpHostType;->Settings Lcom/bytedance/trae/kmp/network/KmpHostType;
    goto +15h
    sget-object v2, Lcom/bytedance/trae/kmp/network/KmpHostType;->Passport Lcom/bytedance/trae/kmp/network/KmpHostType;
    goto +12h
    sget-object v2, Lcom/bytedance/trae/kmp/network/KmpHostType;->Mssdk Lcom/bytedance/trae/kmp/network/KmpHostType;
    goto +fh
    sget-object v2, Lcom/bytedance/trae/kmp/network/KmpHostType;->Imagex Lcom/bytedance/trae/kmp/network/KmpHostType;
    goto +ch
    sget-object v2, Lcom/bytedance/trae/kmp/network/KmpHostType;->Remote Lcom/bytedance/trae/kmp/network/KmpHostType;
    goto +9h
    sget-object v2, Lcom/bytedance/trae/kmp/network/KmpHostType;->Ai Lcom/bytedance/trae/kmp/network/KmpHostType;
    goto +6h
    sget-object v2, Lcom/bytedance/trae/kmp/network/KmpHostType;->Login Lcom/bytedance/trae/kmp/network/KmpHostType;
    goto +3h
    sget-object v2, Lcom/bytedance/trae/kmp/network/KmpHostType;->Online Lcom/bytedance/trae/kmp/network/KmpHostType;
    return-object v2
    packed-switch-payload 1 2 3 4 5 6 7 8 9 a b c d e f
.end method

.method public final configure(java.util.Map)void
    .registers 7
    # ins_size=2
    const-string v0, "map"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/kmp/network/KmpHostResolver;->INSTANCE Lcom/bytedance/trae/kmp/network/KmpHostResolver;
    new-instance v1, Ljava/util/LinkedHashMap;
    invoke-interface v6, Ljava/util/Map;->size()I
    move-result v2
    invoke-static v2, Lkotlin/collections/MapsKt;->mapCapacity(I)I
    move-result v2
    invoke-direct v1, v2, Ljava/util/LinkedHashMap;-><init>(I)V
    check-cast v1, Ljava/util/Map;
    invoke-interface v6, Ljava/util/Map;->entrySet()Ljava/util/Set;
    move-result-object v6
    check-cast v6, Ljava/lang/Iterable;
    invoke-interface v6, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v6
    invoke-interface v6, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +01ch
    invoke-interface v6, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/util/Map$Entry;
    invoke-interface v2, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/network/HostType;
    sget-object v4, Lcom/bytedance/trae/kmp/network/AndroidKmpHostResolverBridge;->INSTANCE Lcom/bytedance/trae/kmp/network/AndroidKmpHostResolverBridge;
    invoke-direct v4, v3, Lcom/bytedance/trae/kmp/network/AndroidKmpHostResolverBridge;->toKmpHostType(Lcom/bytedance/trae/network/HostType;)Lcom/bytedance/trae/kmp/network/KmpHostType;
    move-result-object v3
    invoke-interface v2, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v2
    invoke-interface v1, v3, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    goto -1fh
    new-instance v6, Ljava/util/LinkedHashMap;
    invoke-interface v1, Ljava/util/Map;->size()I
    move-result v2
    invoke-static v2, Lkotlin/collections/MapsKt;->mapCapacity(I)I
    move-result v2
    invoke-direct v6, v2, Ljava/util/LinkedHashMap;-><init>(I)V
    check-cast v6, Ljava/util/Map;
    invoke-interface v1, Ljava/util/Map;->entrySet()Ljava/util/Set;
    move-result-object v1
    check-cast v1, Ljava/lang/Iterable;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +01ch
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/util/Map$Entry;
    invoke-interface v2, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v3
    invoke-interface v2, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/network/HostEntry;
    sget-object v4, Lcom/bytedance/trae/kmp/network/AndroidKmpHostResolverBridge;->INSTANCE Lcom/bytedance/trae/kmp/network/AndroidKmpHostResolverBridge;
    invoke-direct v4, v2, Lcom/bytedance/trae/kmp/network/AndroidKmpHostResolverBridge;->toKmpHostEntry(Lcom/bytedance/trae/network/HostEntry;)Lcom/bytedance/trae/kmp/network/KmpHostEntry;
    move-result-object v2
    invoke-interface v6, v3, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    goto -1fh
    new-instance v1, Lcom/bytedance/trae/kmp/network/AndroidKmpHostResolverBridge$$ExternalSyntheticLambda0;
    invoke-direct v1, Lcom/bytedance/trae/kmp/network/AndroidKmpHostResolverBridge$$ExternalSyntheticLambda0;-><init>()V
    invoke-virtual v0, v6, v1, Lcom/bytedance/trae/kmp/network/KmpHostResolver;->configure(Ljava/util/Map; Lcom/bytedance/trae/kmp/network/KmpBaseUrlOverrideProvider;)V
    return-void 
.end method

.method public final configureFromNativeHostResolver()void
    .registers 5
    # ins_size=1
    invoke-static Lcom/bytedance/trae/network/HostType;->getEntries()Lkotlin/enums/EnumEntries;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +01ch
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/network/HostType;
    sget-object v3, Lcom/bytedance/trae/network/HostResolver;->INSTANCE Lcom/bytedance/trae/network/HostResolver;
    invoke-virtual v3, v2, Lcom/bytedance/trae/network/HostResolver;->getEntry(Lcom/bytedance/trae/network/HostType;)Lcom/bytedance/trae/network/HostEntry;
    move-result-object v3
    if-eqz v3, +007h
    invoke-static v2, v3, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v2
    goto +2h
    const/4 v2, 0
    if-eqz v2, -01ah
    invoke-interface v1, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1fh
    check-cast v1, Ljava/util/List;
    check-cast v1, Ljava/lang/Iterable;
    invoke-static v1, Lkotlin/collections/MapsKt;->toMap(Ljava/lang/Iterable;)Ljava/util/Map;
    move-result-object v0
    invoke-virtual v4, v0, Lcom/bytedance/trae/kmp/network/AndroidKmpHostResolverBridge;->configure(Ljava/util/Map;)V
    return-void 
.end method
