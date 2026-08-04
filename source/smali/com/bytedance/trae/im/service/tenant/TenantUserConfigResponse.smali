# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;
.super Ljava/lang/Object;
.source "TenantUserConfigModels.kt"

.field public static final Companion:Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse$Companion;
.field private static final EMPTY:Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;
.field private final mcpWhitelistConfig:Lcom/bytedance/trae/im/service/tenant/McpWhitelistConfigInfo;
.field private final rawConfigInfo:Lcom/bytedance/trae/im/service/tenant/TenantUserConfig;
.field private final rawSecurityRules:Ljava/util/List;


.method static constructor <clinit>()void
    .registers 4
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;->Companion Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse$Companion;
    new-instance v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;
    sget-object v2, Lcom/bytedance/trae/im/service/tenant/TenantUserConfig;->Companion Lcom/bytedance/trae/im/service/tenant/TenantUserConfig$Companion;
    invoke-virtual v2, Lcom/bytedance/trae/im/service/tenant/TenantUserConfig$Companion;->getEMPTY()Lcom/bytedance/trae/im/service/tenant/TenantUserConfig;
    move-result-object v2
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v3
    invoke-direct v0, v2, v3, v1, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;-><init>(Lcom/bytedance/trae/im/service/tenant/TenantUserConfig; Ljava/util/List; Lcom/bytedance/trae/im/service/tenant/McpWhitelistConfigInfo;)V
    sput-object v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;->EMPTY Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;
    return-void 
.end method

.method public constructor <init>()void
    .registers 7
    # ins_size=1
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 7
    const/4 v5, 0
    move-object v0, v6
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;-><init>(Lcom/bytedance/trae/im/service/tenant/TenantUserConfig; Ljava/util/List; Lcom/bytedance/trae/im/service/tenant/McpWhitelistConfigInfo; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(com.bytedance.trae.im.service.tenant.TenantUserConfig  java.util.List  com.bytedance.trae.im.service.tenant.McpWhitelistConfigInfo)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;->rawConfigInfo Lcom/bytedance/trae/im/service/tenant/TenantUserConfig;
    iput-object v2, v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;->rawSecurityRules Ljava/util/List;
    iput-object v3, v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;->mcpWhitelistConfig Lcom/bytedance/trae/im/service/tenant/McpWhitelistConfigInfo;
    return-void 
.end method

.method public synthetic constructor <init>(com.bytedance.trae.im.service.tenant.TenantUserConfig  java.util.List  com.bytedance.trae.im.service.tenant.McpWhitelistConfigInfo  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 7
    # ins_size=6
    and-int/lit8 v6, v5, 1
    const/4 v0, 0
    if-eqz v6, +003h
    move-object v2, v0
    and-int/lit8 v6, v5, 2
    if-eqz v6, +003h
    move-object v3, v0
    and-int/lit8 v5, v5, 4
    if-eqz v5, +003h
    move-object v4, v0
    invoke-direct v1, v2, v3, v4, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;-><init>(Lcom/bytedance/trae/im/service/tenant/TenantUserConfig; Ljava/util/List; Lcom/bytedance/trae/im/service/tenant/McpWhitelistConfigInfo;)V
    return-void 
.end method

.method public static final synthetic access$getEMPTY$cp()com.bytedance.trae.im.service.tenant.TenantUserConfigResponse
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;->EMPTY Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;
    return-object v0
.end method

.method private final component1()com.bytedance.trae.im.service.tenant.TenantUserConfig
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;->rawConfigInfo Lcom/bytedance/trae/im/service/tenant/TenantUserConfig;
    return-object v0
.end method

.method private final component2()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;->rawSecurityRules Ljava/util/List;
    return-object v0
.end method

.method public static synthetic copy$default(com.bytedance.trae.im.service.tenant.TenantUserConfigResponse  com.bytedance.trae.im.service.tenant.TenantUserConfig  java.util.List  com.bytedance.trae.im.service.tenant.McpWhitelistConfigInfo  int  java.lang.Object)com.bytedance.trae.im.service.tenant.TenantUserConfigResponse
    .registers 6
    # ins_size=6
    and-int/lit8 v5, v4, 1
    if-eqz v5, +004h
    iget-object v1, v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;->rawConfigInfo Lcom/bytedance/trae/im/service/tenant/TenantUserConfig;
    and-int/lit8 v5, v4, 2
    if-eqz v5, +004h
    iget-object v2, v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;->rawSecurityRules Ljava/util/List;
    and-int/lit8 v4, v4, 4
    if-eqz v4, +004h
    iget-object v3, v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;->mcpWhitelistConfig Lcom/bytedance/trae/im/service/tenant/McpWhitelistConfigInfo;
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;->copy(Lcom/bytedance/trae/im/service/tenant/TenantUserConfig; Ljava/util/List; Lcom/bytedance/trae/im/service/tenant/McpWhitelistConfigInfo;)Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;
    move-result-object v0
    return-object v0
.end method

.method public final component3()com.bytedance.trae.im.service.tenant.McpWhitelistConfigInfo
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;->mcpWhitelistConfig Lcom/bytedance/trae/im/service/tenant/McpWhitelistConfigInfo;
    return-object v0
.end method

.method public final copy(com.bytedance.trae.im.service.tenant.TenantUserConfig  java.util.List  com.bytedance.trae.im.service.tenant.McpWhitelistConfigInfo)com.bytedance.trae.im.service.tenant.TenantUserConfigResponse
    .registers 5
    # ins_size=4
    new-instance v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;
    invoke-direct v0, v2, v3, v4, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;-><init>(Lcom/bytedance/trae/im/service/tenant/TenantUserConfig; Ljava/util/List; Lcom/bytedance/trae/im/service/tenant/McpWhitelistConfigInfo;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;
    iget-object v1, v4, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;->rawConfigInfo Lcom/bytedance/trae/im/service/tenant/TenantUserConfig;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;->rawConfigInfo Lcom/bytedance/trae/im/service/tenant/TenantUserConfig;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;->rawSecurityRules Ljava/util/List;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;->rawSecurityRules Ljava/util/List;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;->mcpWhitelistConfig Lcom/bytedance/trae/im/service/tenant/McpWhitelistConfigInfo;
    iget-object v5, v5, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;->mcpWhitelistConfig Lcom/bytedance/trae/im/service/tenant/McpWhitelistConfigInfo;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getConfigInfo()com.bytedance.trae.im.service.tenant.TenantUserConfig
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;->rawConfigInfo Lcom/bytedance/trae/im/service/tenant/TenantUserConfig;
    if-nez v0, +008h
    sget-object v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfig;->Companion Lcom/bytedance/trae/im/service/tenant/TenantUserConfig$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfig$Companion;->getEMPTY()Lcom/bytedance/trae/im/service/tenant/TenantUserConfig;
    move-result-object v0
    return-object v0
.end method

.method public final getMcpWhitelistConfig()com.bytedance.trae.im.service.tenant.McpWhitelistConfigInfo
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;->mcpWhitelistConfig Lcom/bytedance/trae/im/service/tenant/McpWhitelistConfigInfo;
    return-object v0
.end method

.method public final getSecurityRules()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;->rawSecurityRules Ljava/util/List;
    if-nez v0, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;->rawConfigInfo Lcom/bytedance/trae/im/service/tenant/TenantUserConfig;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfig;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;->rawSecurityRules Ljava/util/List;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;->mcpWhitelistConfig Lcom/bytedance/trae/im/service/tenant/McpWhitelistConfigInfo;
    if-nez v2, +003h
    goto +5h
    invoke-virtual v2, Lcom/bytedance/trae/im/service/tenant/McpWhitelistConfigInfo;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "TenantUserConfigResponse(rawConfigInfo="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;->rawConfigInfo Lcom/bytedance/trae/im/service/tenant/TenantUserConfig;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", rawSecurityRules="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;->rawSecurityRules Ljava/util/List;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", mcpWhitelistConfig="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigResponse;->mcpWhitelistConfig Lcom/bytedance/trae/im/service/tenant/McpWhitelistConfigInfo;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
