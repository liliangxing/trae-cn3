# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/service/tenant/TenantUserConfig;
.super Ljava/lang/Object;
.source "TenantUserConfigModels.kt"

.field public static final Companion:Lcom/bytedance/trae/im/service/tenant/TenantUserConfig$Companion;
.field private static final EMPTY:Lcom/bytedance/trae/im/service/tenant/TenantUserConfig;
.field private final rawBlacklistCommands:Lcom/google/gson/JsonElement;
.field private final rawBlacklistRepos:Ljava/util/List;


.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfig$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/im/service/tenant/TenantUserConfig$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfig;->Companion Lcom/bytedance/trae/im/service/tenant/TenantUserConfig$Companion;
    new-instance v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfig;
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v2
    invoke-direct v0, v2, v1, Lcom/bytedance/trae/im/service/tenant/TenantUserConfig;-><init>(Ljava/util/List; Lcom/google/gson/JsonElement;)V
    sput-object v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfig;->EMPTY Lcom/bytedance/trae/im/service/tenant/TenantUserConfig;
    return-void 
.end method

.method public constructor <init>()void
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 3
    invoke-direct v2, v0, v0, v1, v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfig;-><init>(Ljava/util/List; Lcom/google/gson/JsonElement; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(java.util.List  com.google.gson.JsonElement)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfig;->rawBlacklistRepos Ljava/util/List;
    iput-object v2, v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfig;->rawBlacklistCommands Lcom/google/gson/JsonElement;
    return-void 
.end method

.method public synthetic constructor <init>(java.util.List  com.google.gson.JsonElement  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 6
    # ins_size=5
    and-int/lit8 v5, v4, 1
    const/4 v0, 0
    if-eqz v5, +003h
    move-object v2, v0
    and-int/lit8 v4, v4, 2
    if-eqz v4, +003h
    move-object v3, v0
    invoke-direct v1, v2, v3, Lcom/bytedance/trae/im/service/tenant/TenantUserConfig;-><init>(Ljava/util/List; Lcom/google/gson/JsonElement;)V
    return-void 
.end method

.method public static final synthetic access$getEMPTY$cp()com.bytedance.trae.im.service.tenant.TenantUserConfig
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfig;->EMPTY Lcom/bytedance/trae/im/service/tenant/TenantUserConfig;
    return-object v0
.end method

.method private final component1()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/tenant/TenantUserConfig;->rawBlacklistRepos Ljava/util/List;
    return-object v0
.end method

.method private final component2()com.google.gson.JsonElement
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/tenant/TenantUserConfig;->rawBlacklistCommands Lcom/google/gson/JsonElement;
    return-object v0
.end method

.method public static synthetic copy$default(com.bytedance.trae.im.service.tenant.TenantUserConfig  java.util.List  com.google.gson.JsonElement  int  java.lang.Object)com.bytedance.trae.im.service.tenant.TenantUserConfig
    .registers 5
    # ins_size=5
    and-int/lit8 v4, v3, 1
    if-eqz v4, +004h
    iget-object v1, v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfig;->rawBlacklistRepos Ljava/util/List;
    and-int/lit8 v3, v3, 2
    if-eqz v3, +004h
    iget-object v2, v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfig;->rawBlacklistCommands Lcom/google/gson/JsonElement;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/im/service/tenant/TenantUserConfig;->copy(Ljava/util/List; Lcom/google/gson/JsonElement;)Lcom/bytedance/trae/im/service/tenant/TenantUserConfig;
    move-result-object v0
    return-object v0
.end method

.method public final copy(java.util.List  com.google.gson.JsonElement)com.bytedance.trae.im.service.tenant.TenantUserConfig
    .registers 4
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfig;
    invoke-direct v0, v2, v3, Lcom/bytedance/trae/im/service/tenant/TenantUserConfig;-><init>(Ljava/util/List; Lcom/google/gson/JsonElement;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/im/service/tenant/TenantUserConfig;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/im/service/tenant/TenantUserConfig;
    iget-object v1, v4, Lcom/bytedance/trae/im/service/tenant/TenantUserConfig;->rawBlacklistRepos Ljava/util/List;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/tenant/TenantUserConfig;->rawBlacklistRepos Ljava/util/List;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/tenant/TenantUserConfig;->rawBlacklistCommands Lcom/google/gson/JsonElement;
    iget-object v5, v5, Lcom/bytedance/trae/im/service/tenant/TenantUserConfig;->rawBlacklistCommands Lcom/google/gson/JsonElement;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getBlacklistCommands()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/tenant/TenantUserConfig;->rawBlacklistCommands Lcom/google/gson/JsonElement;
    invoke-static v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigModelsKt;->access$stringListFromArrayOrJsonString(Lcom/google/gson/JsonElement;)Ljava/util/List;
    move-result-object v0
    return-object v0
.end method

.method public final getBlacklistRepos()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/tenant/TenantUserConfig;->rawBlacklistRepos Ljava/util/List;
    if-nez v0, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/im/service/tenant/TenantUserConfig;->rawBlacklistRepos Ljava/util/List;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Ljava/lang/Object;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/tenant/TenantUserConfig;->rawBlacklistCommands Lcom/google/gson/JsonElement;
    if-nez v2, +003h
    goto +5h
    invoke-virtual v2, Lcom/google/gson/JsonElement;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "TenantUserConfig(rawBlacklistRepos="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/im/service/tenant/TenantUserConfig;->rawBlacklistRepos Ljava/util/List;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", rawBlacklistCommands="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/tenant/TenantUserConfig;->rawBlacklistCommands Lcom/google/gson/JsonElement;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
