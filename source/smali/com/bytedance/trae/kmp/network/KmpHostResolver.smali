# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/network/KmpHostResolver;
.super Ljava/lang/Object;
.source "KmpHostResolver.kt"

.field public static final $stable:I
.field public static final INSTANCE:Lcom/bytedance/trae/kmp/network/KmpHostResolver;
.field private static hostMap:Ljava/util/Map;
.field private static overrideProvider:Lcom/bytedance/trae/kmp/network/KmpBaseUrlOverrideProvider;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/kmp/network/KmpHostResolver;
    invoke-direct v0, Lcom/bytedance/trae/kmp/network/KmpHostResolver;-><init>()V
    sput-object v0, Lcom/bytedance/trae/kmp/network/KmpHostResolver;->INSTANCE Lcom/bytedance/trae/kmp/network/KmpHostResolver;
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/kmp/network/KmpHostResolver;->hostMap Ljava/util/Map;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/kmp/network/KmpHostResolver;->$stable I
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static synthetic configure$default(com.bytedance.trae.kmp.network.KmpHostResolver  java.util.Map  com.bytedance.trae.kmp.network.KmpBaseUrlOverrideProvider  int  java.lang.Object)void
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +003h
    const/4 v2, 0
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/kmp/network/KmpHostResolver;->configure(Ljava/util/Map; Lcom/bytedance/trae/kmp/network/KmpBaseUrlOverrideProvider;)V
    return-void 
.end method

.method public final baseUrl(com.bytedance.trae.kmp.network.KmpHostType  com.bytedance.trae.kmp.host.KmpHostInfo)java.lang.String
    .registers 4
    # ins_size=3
    const-string/jumbo v0, type
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "hostInfo"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/kmp/network/KmpHostResolver;->overrideProvider Lcom/bytedance/trae/kmp/network/KmpBaseUrlOverrideProvider;
    if-eqz v0, +009h
    invoke-interface v0, v2, Lcom/bytedance/trae/kmp/network/KmpBaseUrlOverrideProvider;->overrideBaseUrlOrNull(Lcom/bytedance/trae/kmp/network/KmpHostType;)Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +003h
    return-object v0
    invoke-virtual v1, v2, v3, Lcom/bytedance/trae/kmp/network/KmpHostResolver;->host(Lcom/bytedance/trae/kmp/network/KmpHostType; Lcom/bytedance/trae/kmp/host/KmpHostInfo;)Ljava/lang/String;
    move-result-object v2
    move-object v3, v2
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v3, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v3
    if-eqz v3, +005h
    const-string v2, ""
    return-object v2
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v0, "https://"
    invoke-direct v3, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const/16 v3, 47
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    return-object v2
.end method

.method public final configure(java.util.Map  com.bytedance.trae.kmp.network.KmpBaseUrlOverrideProvider)void
    .registers 4
    # ins_size=3
    const-string v0, "map"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v2, Lkotlin/collections/MapsKt;->toMap(Ljava/util/Map;)Ljava/util/Map;
    move-result-object v2
    sput-object v2, Lcom/bytedance/trae/kmp/network/KmpHostResolver;->hostMap Ljava/util/Map;
    sput-object v3, Lcom/bytedance/trae/kmp/network/KmpHostResolver;->overrideProvider Lcom/bytedance/trae/kmp/network/KmpBaseUrlOverrideProvider;
    return-void 
.end method

.method public final host(com.bytedance.trae.kmp.network.KmpHostType  com.bytedance.trae.kmp.host.KmpHostInfo)java.lang.String
    .registers 5
    # ins_size=3
    const-string/jumbo v0, type
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "hostInfo"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/kmp/network/KmpHostResolver;->hostMap Ljava/util/Map;
    invoke-interface v0, v3, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/kmp/network/KmpHostEntry;
    if-nez v3, +005h
    const-string v3, ""
    return-object v3
    invoke-interface v4, Lcom/bytedance/trae/kmp/host/KmpHostInfo;->isEnterprise()Z
    move-result v0
    if-eqz v0, +024h
    invoke-interface v4, Lcom/bytedance/trae/kmp/host/KmpHostInfo;->isEnterpriseBoe()Z
    move-result v0
    if-eqz v0, +013h
    invoke-virtual v3, Lcom/bytedance/trae/kmp/network/KmpHostEntry;->getEnterpriseBoeUser()Lcom/bytedance/trae/kmp/network/KmpDomainList;
    move-result-object v0
    if-nez v0, +02dh
    invoke-virtual v3, Lcom/bytedance/trae/kmp/network/KmpHostEntry;->getEnterpriseUser()Lcom/bytedance/trae/kmp/network/KmpDomainList;
    move-result-object v0
    if-nez v0, +027h
    invoke-virtual v3, Lcom/bytedance/trae/kmp/network/KmpHostEntry;->getPublicUser()Lcom/bytedance/trae/kmp/network/KmpDomainList;
    move-result-object v0
    goto +21h
    invoke-virtual v3, Lcom/bytedance/trae/kmp/network/KmpHostEntry;->getEnterpriseUser()Lcom/bytedance/trae/kmp/network/KmpDomainList;
    move-result-object v0
    if-nez v0, +01ch
    invoke-virtual v3, Lcom/bytedance/trae/kmp/network/KmpHostEntry;->getPublicUser()Lcom/bytedance/trae/kmp/network/KmpDomainList;
    move-result-object v0
    goto +16h
    invoke-interface v4, Lcom/bytedance/trae/kmp/host/KmpHostInfo;->isByteCloud()Z
    move-result v0
    if-eqz v0, +00dh
    invoke-virtual v3, Lcom/bytedance/trae/kmp/network/KmpHostEntry;->getBytecloudUser()Lcom/bytedance/trae/kmp/network/KmpDomainList;
    move-result-object v0
    if-nez v0, +00bh
    invoke-virtual v3, Lcom/bytedance/trae/kmp/network/KmpHostEntry;->getPublicUser()Lcom/bytedance/trae/kmp/network/KmpDomainList;
    move-result-object v0
    goto +5h
    invoke-virtual v3, Lcom/bytedance/trae/kmp/network/KmpHostEntry;->getPublicUser()Lcom/bytedance/trae/kmp/network/KmpDomainList;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/kmp/network/KmpDomainList;->getRegions()Ljava/util/Map;
    move-result-object v3
    invoke-interface v3, Ljava/util/Map;->isEmpty()Z
    move-result v3
    if-eqz v3, +007h
    invoke-virtual v0, Lcom/bytedance/trae/kmp/network/KmpDomainList;->getNormal()Ljava/lang/String;
    move-result-object v3
    return-object v3
    invoke-virtual v0, Lcom/bytedance/trae/kmp/network/KmpDomainList;->getRegions()Ljava/util/Map;
    move-result-object v3
    sget-object v1, Lcom/bytedance/trae/kmp/network/KmpAiRegion;->Companion Lcom/bytedance/trae/kmp/network/KmpAiRegion$Companion;
    invoke-interface v4, Lcom/bytedance/trae/kmp/host/KmpHostInfo;->getAiRegion()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v1, v4, Lcom/bytedance/trae/kmp/network/KmpAiRegion$Companion;->from(Ljava/lang/String;)Lcom/bytedance/trae/kmp/network/KmpAiRegion;
    move-result-object v4
    invoke-interface v3, v4, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/lang/String;
    if-nez v3, +006h
    invoke-virtual v0, Lcom/bytedance/trae/kmp/network/KmpDomainList;->getNormal()Ljava/lang/String;
    move-result-object v3
    return-object v3
.end method
