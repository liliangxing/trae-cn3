# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/service/tenant/TenantUserConfigBlacklistRepo;
.super Ljava/lang/Object;
.source "TenantUserConfigModels.kt"

.field private final rawRepoUrls:Ljava/util/List;
.field private final repoId:Ljava/lang/String;


.method public constructor <init>()void
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 3
    invoke-direct v2, v0, v0, v1, v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigBlacklistRepo;-><init>(Ljava/lang/String; Ljava/util/List; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(java.lang.String  java.util.List)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigBlacklistRepo;->repoId Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigBlacklistRepo;->rawRepoUrls Ljava/util/List;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  java.util.List  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 6
    # ins_size=5
    and-int/lit8 v5, v4, 1
    const/4 v0, 0
    if-eqz v5, +003h
    move-object v2, v0
    and-int/lit8 v4, v4, 2
    if-eqz v4, +003h
    move-object v3, v0
    invoke-direct v1, v2, v3, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigBlacklistRepo;-><init>(Ljava/lang/String; Ljava/util/List;)V
    return-void 
.end method

.method private final component2()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigBlacklistRepo;->rawRepoUrls Ljava/util/List;
    return-object v0
.end method

.method public static synthetic copy$default(com.bytedance.trae.im.service.tenant.TenantUserConfigBlacklistRepo  java.lang.String  java.util.List  int  java.lang.Object)com.bytedance.trae.im.service.tenant.TenantUserConfigBlacklistRepo
    .registers 5
    # ins_size=5
    and-int/lit8 v4, v3, 1
    if-eqz v4, +004h
    iget-object v1, v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigBlacklistRepo;->repoId Ljava/lang/String;
    and-int/lit8 v3, v3, 2
    if-eqz v3, +004h
    iget-object v2, v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigBlacklistRepo;->rawRepoUrls Ljava/util/List;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigBlacklistRepo;->copy(Ljava/lang/String; Ljava/util/List;)Lcom/bytedance/trae/im/service/tenant/TenantUserConfigBlacklistRepo;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigBlacklistRepo;->repoId Ljava/lang/String;
    return-object v0
.end method

.method public final copy(java.lang.String  java.util.List)com.bytedance.trae.im.service.tenant.TenantUserConfigBlacklistRepo
    .registers 4
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigBlacklistRepo;
    invoke-direct v0, v2, v3, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigBlacklistRepo;-><init>(Ljava/lang/String; Ljava/util/List;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigBlacklistRepo;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigBlacklistRepo;
    iget-object v1, v4, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigBlacklistRepo;->repoId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigBlacklistRepo;->repoId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigBlacklistRepo;->rawRepoUrls Ljava/util/List;
    iget-object v5, v5, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigBlacklistRepo;->rawRepoUrls Ljava/util/List;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getRepoId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigBlacklistRepo;->repoId Ljava/lang/String;
    return-object v0
.end method

.method public final getRepoUrls()java.util.List
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigBlacklistRepo;->rawRepoUrls Ljava/util/List;
    if-nez v0, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +017h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    move-object v3, v2
    check-cast v3, Ljava/lang/String;
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v3, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v3
    xor-int/lit8 v3, v3, 1
    if-eqz v3, -015h
    invoke-interface v1, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1ah
    check-cast v1, Ljava/util/List;
    return-object v1
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigBlacklistRepo;->repoId Ljava/lang/String;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigBlacklistRepo;->rawRepoUrls Ljava/util/List;
    if-nez v2, +003h
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "TenantUserConfigBlacklistRepo(repoId="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigBlacklistRepo;->repoId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", rawRepoUrls="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigBlacklistRepo;->rawRepoUrls Ljava/util/List;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
