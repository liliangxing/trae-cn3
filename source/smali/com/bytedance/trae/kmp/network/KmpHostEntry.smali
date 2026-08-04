# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/network/KmpHostEntry;
.super Ljava/lang/Object;
.source "KmpHostResolver.kt"

.field public static final $stable:I
.field private final bytecloudUser:Lcom/bytedance/trae/kmp/network/KmpDomainList;
.field private final enterpriseBoeUser:Lcom/bytedance/trae/kmp/network/KmpDomainList;
.field private final enterpriseUser:Lcom/bytedance/trae/kmp/network/KmpDomainList;
.field private final publicUser:Lcom/bytedance/trae/kmp/network/KmpDomainList;


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>(com.bytedance.trae.kmp.network.KmpDomainList  com.bytedance.trae.kmp.network.KmpDomainList  com.bytedance.trae.kmp.network.KmpDomainList  com.bytedance.trae.kmp.network.KmpDomainList)void
    .registers 6
    # ins_size=5
    const-string/jumbo v0, publicUser
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/kmp/network/KmpHostEntry;->publicUser Lcom/bytedance/trae/kmp/network/KmpDomainList;
    iput-object v3, v1, Lcom/bytedance/trae/kmp/network/KmpHostEntry;->bytecloudUser Lcom/bytedance/trae/kmp/network/KmpDomainList;
    iput-object v4, v1, Lcom/bytedance/trae/kmp/network/KmpHostEntry;->enterpriseUser Lcom/bytedance/trae/kmp/network/KmpDomainList;
    iput-object v5, v1, Lcom/bytedance/trae/kmp/network/KmpHostEntry;->enterpriseBoeUser Lcom/bytedance/trae/kmp/network/KmpDomainList;
    return-void 
.end method

.method public synthetic constructor <init>(com.bytedance.trae.kmp.network.KmpDomainList  com.bytedance.trae.kmp.network.KmpDomainList  com.bytedance.trae.kmp.network.KmpDomainList  com.bytedance.trae.kmp.network.KmpDomainList  int  kotlin.jvm.internal.DefaultConstructorMarker)void
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
    invoke-direct v1, v2, v3, v4, v5, Lcom/bytedance/trae/kmp/network/KmpHostEntry;-><init>(Lcom/bytedance/trae/kmp/network/KmpDomainList; Lcom/bytedance/trae/kmp/network/KmpDomainList; Lcom/bytedance/trae/kmp/network/KmpDomainList; Lcom/bytedance/trae/kmp/network/KmpDomainList;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.kmp.network.KmpHostEntry  com.bytedance.trae.kmp.network.KmpDomainList  com.bytedance.trae.kmp.network.KmpDomainList  com.bytedance.trae.kmp.network.KmpDomainList  com.bytedance.trae.kmp.network.KmpDomainList  int  java.lang.Object)com.bytedance.trae.kmp.network.KmpHostEntry
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 1
    if-eqz v6, +004h
    iget-object v1, v0, Lcom/bytedance/trae/kmp/network/KmpHostEntry;->publicUser Lcom/bytedance/trae/kmp/network/KmpDomainList;
    and-int/lit8 v6, v5, 2
    if-eqz v6, +004h
    iget-object v2, v0, Lcom/bytedance/trae/kmp/network/KmpHostEntry;->bytecloudUser Lcom/bytedance/trae/kmp/network/KmpDomainList;
    and-int/lit8 v6, v5, 4
    if-eqz v6, +004h
    iget-object v3, v0, Lcom/bytedance/trae/kmp/network/KmpHostEntry;->enterpriseUser Lcom/bytedance/trae/kmp/network/KmpDomainList;
    and-int/lit8 v5, v5, 8
    if-eqz v5, +004h
    iget-object v4, v0, Lcom/bytedance/trae/kmp/network/KmpHostEntry;->enterpriseBoeUser Lcom/bytedance/trae/kmp/network/KmpDomainList;
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/kmp/network/KmpHostEntry;->copy(Lcom/bytedance/trae/kmp/network/KmpDomainList; Lcom/bytedance/trae/kmp/network/KmpDomainList; Lcom/bytedance/trae/kmp/network/KmpDomainList; Lcom/bytedance/trae/kmp/network/KmpDomainList;)Lcom/bytedance/trae/kmp/network/KmpHostEntry;
    move-result-object v0
    return-object v0
.end method

.method public final component1()com.bytedance.trae.kmp.network.KmpDomainList
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/network/KmpHostEntry;->publicUser Lcom/bytedance/trae/kmp/network/KmpDomainList;
    return-object v0
.end method

.method public final component2()com.bytedance.trae.kmp.network.KmpDomainList
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/network/KmpHostEntry;->bytecloudUser Lcom/bytedance/trae/kmp/network/KmpDomainList;
    return-object v0
.end method

.method public final component3()com.bytedance.trae.kmp.network.KmpDomainList
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/network/KmpHostEntry;->enterpriseUser Lcom/bytedance/trae/kmp/network/KmpDomainList;
    return-object v0
.end method

.method public final component4()com.bytedance.trae.kmp.network.KmpDomainList
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/network/KmpHostEntry;->enterpriseBoeUser Lcom/bytedance/trae/kmp/network/KmpDomainList;
    return-object v0
.end method

.method public final copy(com.bytedance.trae.kmp.network.KmpDomainList  com.bytedance.trae.kmp.network.KmpDomainList  com.bytedance.trae.kmp.network.KmpDomainList  com.bytedance.trae.kmp.network.KmpDomainList)com.bytedance.trae.kmp.network.KmpHostEntry
    .registers 6
    # ins_size=5
    const-string/jumbo v0, publicUser
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/kmp/network/KmpHostEntry;
    invoke-direct v0, v2, v3, v4, v5, Lcom/bytedance/trae/kmp/network/KmpHostEntry;-><init>(Lcom/bytedance/trae/kmp/network/KmpDomainList; Lcom/bytedance/trae/kmp/network/KmpDomainList; Lcom/bytedance/trae/kmp/network/KmpDomainList; Lcom/bytedance/trae/kmp/network/KmpDomainList;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/kmp/network/KmpHostEntry;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/kmp/network/KmpHostEntry;
    iget-object v1, v4, Lcom/bytedance/trae/kmp/network/KmpHostEntry;->publicUser Lcom/bytedance/trae/kmp/network/KmpDomainList;
    iget-object v3, v5, Lcom/bytedance/trae/kmp/network/KmpHostEntry;->publicUser Lcom/bytedance/trae/kmp/network/KmpDomainList;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/kmp/network/KmpHostEntry;->bytecloudUser Lcom/bytedance/trae/kmp/network/KmpDomainList;
    iget-object v3, v5, Lcom/bytedance/trae/kmp/network/KmpHostEntry;->bytecloudUser Lcom/bytedance/trae/kmp/network/KmpDomainList;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/kmp/network/KmpHostEntry;->enterpriseUser Lcom/bytedance/trae/kmp/network/KmpDomainList;
    iget-object v3, v5, Lcom/bytedance/trae/kmp/network/KmpHostEntry;->enterpriseUser Lcom/bytedance/trae/kmp/network/KmpDomainList;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/kmp/network/KmpHostEntry;->enterpriseBoeUser Lcom/bytedance/trae/kmp/network/KmpDomainList;
    iget-object v5, v5, Lcom/bytedance/trae/kmp/network/KmpHostEntry;->enterpriseBoeUser Lcom/bytedance/trae/kmp/network/KmpDomainList;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getBytecloudUser()com.bytedance.trae.kmp.network.KmpDomainList
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/network/KmpHostEntry;->bytecloudUser Lcom/bytedance/trae/kmp/network/KmpDomainList;
    return-object v0
.end method

.method public final getEnterpriseBoeUser()com.bytedance.trae.kmp.network.KmpDomainList
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/network/KmpHostEntry;->enterpriseBoeUser Lcom/bytedance/trae/kmp/network/KmpDomainList;
    return-object v0
.end method

.method public final getEnterpriseUser()com.bytedance.trae.kmp.network.KmpDomainList
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/network/KmpHostEntry;->enterpriseUser Lcom/bytedance/trae/kmp/network/KmpDomainList;
    return-object v0
.end method

.method public final getPublicUser()com.bytedance.trae.kmp.network.KmpDomainList
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/network/KmpHostEntry;->publicUser Lcom/bytedance/trae/kmp/network/KmpDomainList;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/kmp/network/KmpHostEntry;->publicUser Lcom/bytedance/trae/kmp/network/KmpDomainList;
    invoke-virtual v0, Lcom/bytedance/trae/kmp/network/KmpDomainList;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/kmp/network/KmpHostEntry;->bytecloudUser Lcom/bytedance/trae/kmp/network/KmpDomainList;
    const/4 v2, 0
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Lcom/bytedance/trae/kmp/network/KmpDomainList;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/kmp/network/KmpHostEntry;->enterpriseUser Lcom/bytedance/trae/kmp/network/KmpDomainList;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Lcom/bytedance/trae/kmp/network/KmpDomainList;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/kmp/network/KmpHostEntry;->enterpriseBoeUser Lcom/bytedance/trae/kmp/network/KmpDomainList;
    if-nez v1, +003h
    goto +5h
    invoke-virtual v1, Lcom/bytedance/trae/kmp/network/KmpDomainList;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "KmpHostEntry(publicUser="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/kmp/network/KmpHostEntry;->publicUser Lcom/bytedance/trae/kmp/network/KmpDomainList;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", bytecloudUser="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/kmp/network/KmpHostEntry;->bytecloudUser Lcom/bytedance/trae/kmp/network/KmpDomainList;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", enterpriseUser="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/kmp/network/KmpHostEntry;->enterpriseUser Lcom/bytedance/trae/kmp/network/KmpDomainList;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", enterpriseBoeUser="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/kmp/network/KmpHostEntry;->enterpriseBoeUser Lcom/bytedance/trae/kmp/network/KmpDomainList;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
