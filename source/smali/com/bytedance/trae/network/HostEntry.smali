# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/network/HostEntry;
.super Ljava/lang/Object;
.source "HostResolver.kt"

.field public static final Companion:Lcom/bytedance/trae/network/HostEntry$Companion;
.field private final bytecloudUser:Lcom/bytedance/trae/network/DomainList;
.field private final enterpriseBoeUser:Lcom/bytedance/trae/network/DomainList;
.field private final enterpriseUser:Lcom/bytedance/trae/network/DomainList;
.field private final publicUser:Lcom/bytedance/trae/network/DomainList;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/network/HostEntry$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/network/HostEntry$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/network/HostEntry;->Companion Lcom/bytedance/trae/network/HostEntry$Companion;
    return-void 
.end method

.method public constructor <init>(com.bytedance.trae.network.DomainList  com.bytedance.trae.network.DomainList  com.bytedance.trae.network.DomainList  com.bytedance.trae.network.DomainList)void
    .registers 6
    # ins_size=5
    const-string/jumbo v0, publicUser
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/network/HostEntry;->publicUser Lcom/bytedance/trae/network/DomainList;
    iput-object v3, v1, Lcom/bytedance/trae/network/HostEntry;->bytecloudUser Lcom/bytedance/trae/network/DomainList;
    iput-object v4, v1, Lcom/bytedance/trae/network/HostEntry;->enterpriseUser Lcom/bytedance/trae/network/DomainList;
    iput-object v5, v1, Lcom/bytedance/trae/network/HostEntry;->enterpriseBoeUser Lcom/bytedance/trae/network/DomainList;
    return-void 
.end method

.method public synthetic constructor <init>(com.bytedance.trae.network.DomainList  com.bytedance.trae.network.DomainList  com.bytedance.trae.network.DomainList  com.bytedance.trae.network.DomainList  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 8
    # ins_size=7
    and-int/lit8 v7, v6, 2
    const/4 v0, 0
    if-eqz v7, +003h
    move-object v3, v0
    and-int/lit8 v7, v6, 4
    if-eqz v7, +003h
    move-object v4, v0
    and-int/lit8 v6, v6, 8
    if-eqz v6, +003h
    move-object v5, v0
    invoke-direct v1, v2, v3, v4, v5, Lcom/bytedance/trae/network/HostEntry;-><init>(Lcom/bytedance/trae/network/DomainList; Lcom/bytedance/trae/network/DomainList; Lcom/bytedance/trae/network/DomainList; Lcom/bytedance/trae/network/DomainList;)V
    return-void 
.end method

.method public static final builder()com.bytedance.trae.network.HostEntry$Builder
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/network/HostEntry;->Companion Lcom/bytedance/trae/network/HostEntry$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/network/HostEntry$Companion;->builder()Lcom/bytedance/trae/network/HostEntry$Builder;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic copy$default(com.bytedance.trae.network.HostEntry  com.bytedance.trae.network.DomainList  com.bytedance.trae.network.DomainList  com.bytedance.trae.network.DomainList  com.bytedance.trae.network.DomainList  int  java.lang.Object)com.bytedance.trae.network.HostEntry
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 1
    if-eqz v6, +004h
    iget-object v1, v0, Lcom/bytedance/trae/network/HostEntry;->publicUser Lcom/bytedance/trae/network/DomainList;
    and-int/lit8 v6, v5, 2
    if-eqz v6, +004h
    iget-object v2, v0, Lcom/bytedance/trae/network/HostEntry;->bytecloudUser Lcom/bytedance/trae/network/DomainList;
    and-int/lit8 v6, v5, 4
    if-eqz v6, +004h
    iget-object v3, v0, Lcom/bytedance/trae/network/HostEntry;->enterpriseUser Lcom/bytedance/trae/network/DomainList;
    and-int/lit8 v5, v5, 8
    if-eqz v5, +004h
    iget-object v4, v0, Lcom/bytedance/trae/network/HostEntry;->enterpriseBoeUser Lcom/bytedance/trae/network/DomainList;
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/network/HostEntry;->copy(Lcom/bytedance/trae/network/DomainList; Lcom/bytedance/trae/network/DomainList; Lcom/bytedance/trae/network/DomainList; Lcom/bytedance/trae/network/DomainList;)Lcom/bytedance/trae/network/HostEntry;
    move-result-object v0
    return-object v0
.end method

.method public final component1()com.bytedance.trae.network.DomainList
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/network/HostEntry;->publicUser Lcom/bytedance/trae/network/DomainList;
    return-object v0
.end method

.method public final component2()com.bytedance.trae.network.DomainList
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/network/HostEntry;->bytecloudUser Lcom/bytedance/trae/network/DomainList;
    return-object v0
.end method

.method public final component3()com.bytedance.trae.network.DomainList
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/network/HostEntry;->enterpriseUser Lcom/bytedance/trae/network/DomainList;
    return-object v0
.end method

.method public final component4()com.bytedance.trae.network.DomainList
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/network/HostEntry;->enterpriseBoeUser Lcom/bytedance/trae/network/DomainList;
    return-object v0
.end method

.method public final copy(com.bytedance.trae.network.DomainList  com.bytedance.trae.network.DomainList  com.bytedance.trae.network.DomainList  com.bytedance.trae.network.DomainList)com.bytedance.trae.network.HostEntry
    .registers 6
    # ins_size=5
    const-string/jumbo v0, publicUser
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/network/HostEntry;
    invoke-direct v0, v2, v3, v4, v5, Lcom/bytedance/trae/network/HostEntry;-><init>(Lcom/bytedance/trae/network/DomainList; Lcom/bytedance/trae/network/DomainList; Lcom/bytedance/trae/network/DomainList; Lcom/bytedance/trae/network/DomainList;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/network/HostEntry;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/network/HostEntry;
    iget-object v1, v4, Lcom/bytedance/trae/network/HostEntry;->publicUser Lcom/bytedance/trae/network/DomainList;
    iget-object v3, v5, Lcom/bytedance/trae/network/HostEntry;->publicUser Lcom/bytedance/trae/network/DomainList;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/network/HostEntry;->bytecloudUser Lcom/bytedance/trae/network/DomainList;
    iget-object v3, v5, Lcom/bytedance/trae/network/HostEntry;->bytecloudUser Lcom/bytedance/trae/network/DomainList;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/network/HostEntry;->enterpriseUser Lcom/bytedance/trae/network/DomainList;
    iget-object v3, v5, Lcom/bytedance/trae/network/HostEntry;->enterpriseUser Lcom/bytedance/trae/network/DomainList;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/network/HostEntry;->enterpriseBoeUser Lcom/bytedance/trae/network/DomainList;
    iget-object v5, v5, Lcom/bytedance/trae/network/HostEntry;->enterpriseBoeUser Lcom/bytedance/trae/network/DomainList;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getBytecloudUser()com.bytedance.trae.network.DomainList
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/network/HostEntry;->bytecloudUser Lcom/bytedance/trae/network/DomainList;
    return-object v0
.end method

.method public final getEnterpriseBoeUser()com.bytedance.trae.network.DomainList
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/network/HostEntry;->enterpriseBoeUser Lcom/bytedance/trae/network/DomainList;
    return-object v0
.end method

.method public final getEnterpriseUser()com.bytedance.trae.network.DomainList
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/network/HostEntry;->enterpriseUser Lcom/bytedance/trae/network/DomainList;
    return-object v0
.end method

.method public final getPublicUser()com.bytedance.trae.network.DomainList
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/network/HostEntry;->publicUser Lcom/bytedance/trae/network/DomainList;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/network/HostEntry;->publicUser Lcom/bytedance/trae/network/DomainList;
    invoke-virtual v0, Lcom/bytedance/trae/network/DomainList;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/network/HostEntry;->bytecloudUser Lcom/bytedance/trae/network/DomainList;
    const/4 v2, 0
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Lcom/bytedance/trae/network/DomainList;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/network/HostEntry;->enterpriseUser Lcom/bytedance/trae/network/DomainList;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Lcom/bytedance/trae/network/DomainList;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/network/HostEntry;->enterpriseBoeUser Lcom/bytedance/trae/network/DomainList;
    if-nez v1, +003h
    goto +5h
    invoke-virtual v1, Lcom/bytedance/trae/network/DomainList;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "HostEntry(publicUser="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/network/HostEntry;->publicUser Lcom/bytedance/trae/network/DomainList;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", bytecloudUser="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/network/HostEntry;->bytecloudUser Lcom/bytedance/trae/network/DomainList;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", enterpriseUser="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/network/HostEntry;->enterpriseUser Lcom/bytedance/trae/network/DomainList;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", enterpriseBoeUser="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/network/HostEntry;->enterpriseBoeUser Lcom/bytedance/trae/network/DomainList;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
