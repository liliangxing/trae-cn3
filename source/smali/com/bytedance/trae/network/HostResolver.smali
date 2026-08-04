# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/network/HostResolver;
.super Ljava/lang/Object;
.source "HostResolver.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/network/HostResolver;
.field private static final hostMap:Ljava/util/concurrent/ConcurrentHashMap;
.field private static bridge loginContextProvider:Lcom/bytedance/trae/network/LoginContextProvider;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/network/HostResolver;
    invoke-direct v0, Lcom/bytedance/trae/network/HostResolver;-><init>()V
    sput-object v0, Lcom/bytedance/trae/network/HostResolver;->INSTANCE Lcom/bytedance/trae/network/HostResolver;
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;
    invoke-direct v0, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V
    sput-object v0, Lcom/bytedance/trae/network/HostResolver;->hostMap Ljava/util/concurrent/ConcurrentHashMap;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final getAllHosts(com.bytedance.trae.network.HostType)java.util.Set
    .registers 5
    # ins_size=2
    const-string/jumbo v0, type
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/network/HostResolver;->hostMap Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v0, v4, Ljava/util/concurrent/ConcurrentHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/network/HostEntry;
    if-nez v4, +007h
    invoke-static Lkotlin/collections/SetsKt;->emptySet()Ljava/util/Set;
    move-result-object v4
    return-object v4
    new-instance v0, Ljava/util/LinkedHashSet;
    invoke-direct v0, Ljava/util/LinkedHashSet;-><init>()V
    check-cast v0, Ljava/util/Set;
    invoke-virtual v4, Lcom/bytedance/trae/network/HostEntry;->getPublicUser()Lcom/bytedance/trae/network/DomainList;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/network/DomainList;->getNormal()Ljava/lang/String;
    move-result-object v1
    invoke-interface v0, v1, Ljava/util/Set;->add(Ljava/lang/Object;)Z
    invoke-virtual v4, Lcom/bytedance/trae/network/HostEntry;->getPublicUser()Lcom/bytedance/trae/network/DomainList;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/network/DomainList;->getRegions()Ljava/util/Map;
    move-result-object v1
    invoke-interface v1, Ljava/util/Map;->values()Ljava/util/Collection;
    move-result-object v1
    invoke-interface v0, v1, Ljava/util/Set;->addAll(Ljava/util/Collection;)Z
    invoke-virtual v4, Lcom/bytedance/trae/network/HostEntry;->getBytecloudUser()Lcom/bytedance/trae/network/DomainList;
    move-result-object v1
    if-eqz v1, +014h
    invoke-virtual v1, Lcom/bytedance/trae/network/DomainList;->getNormal()Ljava/lang/String;
    move-result-object v2
    invoke-interface v0, v2, Ljava/util/Set;->add(Ljava/lang/Object;)Z
    invoke-virtual v1, Lcom/bytedance/trae/network/DomainList;->getRegions()Ljava/util/Map;
    move-result-object v1
    invoke-interface v1, Ljava/util/Map;->values()Ljava/util/Collection;
    move-result-object v1
    invoke-interface v0, v1, Ljava/util/Set;->addAll(Ljava/util/Collection;)Z
    invoke-virtual v4, Lcom/bytedance/trae/network/HostEntry;->getEnterpriseUser()Lcom/bytedance/trae/network/DomainList;
    move-result-object v1
    if-eqz v1, +014h
    invoke-virtual v1, Lcom/bytedance/trae/network/DomainList;->getNormal()Ljava/lang/String;
    move-result-object v2
    invoke-interface v0, v2, Ljava/util/Set;->add(Ljava/lang/Object;)Z
    invoke-virtual v1, Lcom/bytedance/trae/network/DomainList;->getRegions()Ljava/util/Map;
    move-result-object v1
    invoke-interface v1, Ljava/util/Map;->values()Ljava/util/Collection;
    move-result-object v1
    invoke-interface v0, v1, Ljava/util/Set;->addAll(Ljava/util/Collection;)Z
    invoke-virtual v4, Lcom/bytedance/trae/network/HostEntry;->getEnterpriseBoeUser()Lcom/bytedance/trae/network/DomainList;
    move-result-object v4
    if-eqz v4, +014h
    invoke-virtual v4, Lcom/bytedance/trae/network/DomainList;->getNormal()Ljava/lang/String;
    move-result-object v1
    invoke-interface v0, v1, Ljava/util/Set;->add(Ljava/lang/Object;)Z
    invoke-virtual v4, Lcom/bytedance/trae/network/DomainList;->getRegions()Ljava/util/Map;
    move-result-object v4
    invoke-interface v4, Ljava/util/Map;->values()Ljava/util/Collection;
    move-result-object v4
    invoke-interface v0, v4, Ljava/util/Set;->addAll(Ljava/util/Collection;)Z
    return-object v0
.end method

.method public final getBaseUrl(com.bytedance.trae.network.HostType)java.lang.String
    .registers 4
    # ins_size=2
    const-string/jumbo v0, type
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/network/E2ENetworkOverrides;->INSTANCE Lcom/bytedance/trae/network/E2ENetworkOverrides;
    invoke-virtual v0, Lcom/bytedance/trae/network/E2ENetworkOverrides;->overrideBaseUrlOrNull()Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +003h
    return-object v0
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "https://"
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v3, Lcom/bytedance/trae/network/HostResolver;->getHost(Lcom/bytedance/trae/network/HostType;)Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const/16 v0, 47
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    return-object v3
.end method

.method public final getEntry(com.bytedance.trae.network.HostType)com.bytedance.trae.network.HostEntry
    .registers 3
    # ins_size=2
    const-string/jumbo v0, type
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/network/HostResolver;->hostMap Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v0, v2, Ljava/util/concurrent/ConcurrentHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/network/HostEntry;
    return-object v2
.end method

.method public final getHost(com.bytedance.trae.network.HostType)java.lang.String
    .registers 4
    # ins_size=2
    const-string/jumbo v0, type
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/network/HostResolver;->hostMap Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v0, v3, Ljava/util/concurrent/ConcurrentHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/network/HostEntry;
    if-nez v3, +005h
    const-string v3, ""
    return-object v3
    sget-object v0, Lcom/bytedance/trae/network/HostResolver;->loginContextProvider Lcom/bytedance/trae/network/LoginContextProvider;
    if-eqz v0, +02ah
    invoke-interface v0, Lcom/bytedance/trae/network/LoginContextProvider;->isEnterpriseLogin()Z
    move-result v1
    if-eqz v1, +024h
    invoke-interface v0, Lcom/bytedance/trae/network/LoginContextProvider;->isEnterpriseBoeEnv()Z
    move-result v1
    if-eqz v1, +013h
    invoke-virtual v3, Lcom/bytedance/trae/network/HostEntry;->getEnterpriseBoeUser()Lcom/bytedance/trae/network/DomainList;
    move-result-object v1
    if-nez v1, +02fh
    invoke-virtual v3, Lcom/bytedance/trae/network/HostEntry;->getEnterpriseUser()Lcom/bytedance/trae/network/DomainList;
    move-result-object v1
    if-nez v1, +029h
    invoke-virtual v3, Lcom/bytedance/trae/network/HostEntry;->getPublicUser()Lcom/bytedance/trae/network/DomainList;
    move-result-object v1
    goto +23h
    invoke-virtual v3, Lcom/bytedance/trae/network/HostEntry;->getEnterpriseUser()Lcom/bytedance/trae/network/DomainList;
    move-result-object v1
    if-nez v1, +01eh
    invoke-virtual v3, Lcom/bytedance/trae/network/HostEntry;->getPublicUser()Lcom/bytedance/trae/network/DomainList;
    move-result-object v1
    goto +18h
    if-eqz v0, +013h
    invoke-interface v0, Lcom/bytedance/trae/network/LoginContextProvider;->isBytecloudLogin()Z
    move-result v1
    if-eqz v1, +00dh
    invoke-virtual v3, Lcom/bytedance/trae/network/HostEntry;->getBytecloudUser()Lcom/bytedance/trae/network/DomainList;
    move-result-object v1
    if-nez v1, +00bh
    invoke-virtual v3, Lcom/bytedance/trae/network/HostEntry;->getPublicUser()Lcom/bytedance/trae/network/DomainList;
    move-result-object v1
    goto +5h
    invoke-virtual v3, Lcom/bytedance/trae/network/HostEntry;->getPublicUser()Lcom/bytedance/trae/network/DomainList;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/network/DomainList;->getRegions()Ljava/util/Map;
    move-result-object v3
    invoke-interface v3, Ljava/util/Map;->isEmpty()Z
    move-result v3
    if-eqz v3, +007h
    invoke-virtual v1, Lcom/bytedance/trae/network/DomainList;->getNormal()Ljava/lang/String;
    move-result-object v3
    return-object v3
    if-eqz v0, +007h
    invoke-interface v0, Lcom/bytedance/trae/network/LoginContextProvider;->getAiRegion()Lcom/bytedance/trae/network/AiRegion;
    move-result-object v3
    goto +3h
    sget-object v3, Lcom/bytedance/trae/network/AiRegion;->CN Lcom/bytedance/trae/network/AiRegion;
    invoke-virtual v1, Lcom/bytedance/trae/network/DomainList;->getRegions()Ljava/util/Map;
    move-result-object v0
    invoke-interface v0, v3, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/lang/String;
    if-nez v3, +006h
    invoke-virtual v1, Lcom/bytedance/trae/network/DomainList;->getNormal()Ljava/lang/String;
    move-result-object v3
    return-object v3
.end method

.method public final init(java.util.Map)void
    .registers 3
    # ins_size=2
    const-string v0, "map"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/network/HostResolver;->hostMap Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v0, Ljava/util/concurrent/ConcurrentHashMap;->clear()V
    invoke-virtual v0, v2, Ljava/util/concurrent/ConcurrentHashMap;->putAll(Ljava/util/Map;)V
    return-void 
.end method

.method public final isBytecloudLogin()boolean
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/HostResolver;->loginContextProvider Lcom/bytedance/trae/network/LoginContextProvider;
    const/4 v1, 0
    if-eqz v0, +00ah
    invoke-interface v0, Lcom/bytedance/trae/network/LoginContextProvider;->isBytecloudLogin()Z
    move-result v0
    const/4 v2, 1
    if-ne v0, v2, +003h
    move v1, v2
    return v1
.end method

.method public final isEnterpriseLogin()boolean
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/HostResolver;->loginContextProvider Lcom/bytedance/trae/network/LoginContextProvider;
    const/4 v1, 0
    if-eqz v0, +00ah
    invoke-interface v0, Lcom/bytedance/trae/network/LoginContextProvider;->isEnterpriseLogin()Z
    move-result v0
    const/4 v2, 1
    if-ne v0, v2, +003h
    move v1, v2
    return v1
.end method

.method public final setLoginContextProvider(com.bytedance.trae.network.LoginContextProvider)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, provider
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sput-object v2, Lcom/bytedance/trae/network/HostResolver;->loginContextProvider Lcom/bytedance/trae/network/LoginContextProvider;
    return-void 
.end method
