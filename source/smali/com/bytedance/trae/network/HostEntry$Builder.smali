# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/network/HostEntry$Builder;
.super Ljava/lang/Object;
.source "HostResolver.kt"

.field private bytecloudUser:Lcom/bytedance/trae/network/DomainList;
.field private enterpriseBoeUser:Lcom/bytedance/trae/network/DomainList;
.field private enterpriseUser:Lcom/bytedance/trae/network/DomainList;
.field private publicUser:Lcom/bytedance/trae/network/DomainList;


.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final build()com.bytedance.trae.network.HostEntry
    .registers 6
    # ins_size=1
    iget-object v0, v5, Lcom/bytedance/trae/network/HostEntry$Builder;->publicUser Lcom/bytedance/trae/network/DomainList;
    if-eqz v0, +00eh
    iget-object v1, v5, Lcom/bytedance/trae/network/HostEntry$Builder;->bytecloudUser Lcom/bytedance/trae/network/DomainList;
    iget-object v2, v5, Lcom/bytedance/trae/network/HostEntry$Builder;->enterpriseUser Lcom/bytedance/trae/network/DomainList;
    iget-object v3, v5, Lcom/bytedance/trae/network/HostEntry$Builder;->enterpriseBoeUser Lcom/bytedance/trae/network/DomainList;
    new-instance v4, Lcom/bytedance/trae/network/HostEntry;
    invoke-direct v4, v0, v1, v2, v3, Lcom/bytedance/trae/network/HostEntry;-><init>(Lcom/bytedance/trae/network/DomainList; Lcom/bytedance/trae/network/DomainList; Lcom/bytedance/trae/network/DomainList; Lcom/bytedance/trae/network/DomainList;)V
    return-object v4
    new-instance v0, Ljava/lang/IllegalArgumentException;
    const-string/jumbo v1, publicUser domain is required
    invoke-virtual v1, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-direct v0, v1, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V
    throw v0
.end method

.method public final bytecloudUser(com.bytedance.trae.network.DomainList)com.bytedance.trae.network.HostEntry$Builder
    .registers 3
    # ins_size=2
    const-string v0, "domain"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v0, v1
    check-cast v0, Lcom/bytedance/trae/network/HostEntry$Builder;
    iput-object v2, v1, Lcom/bytedance/trae/network/HostEntry$Builder;->bytecloudUser Lcom/bytedance/trae/network/DomainList;
    return-object v1
.end method

.method public final enterpriseBoeUser(com.bytedance.trae.network.DomainList)com.bytedance.trae.network.HostEntry$Builder
    .registers 3
    # ins_size=2
    const-string v0, "domain"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v0, v1
    check-cast v0, Lcom/bytedance/trae/network/HostEntry$Builder;
    iput-object v2, v1, Lcom/bytedance/trae/network/HostEntry$Builder;->enterpriseBoeUser Lcom/bytedance/trae/network/DomainList;
    return-object v1
.end method

.method public final enterpriseUser(com.bytedance.trae.network.DomainList)com.bytedance.trae.network.HostEntry$Builder
    .registers 3
    # ins_size=2
    const-string v0, "domain"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v0, v1
    check-cast v0, Lcom/bytedance/trae/network/HostEntry$Builder;
    iput-object v2, v1, Lcom/bytedance/trae/network/HostEntry$Builder;->enterpriseUser Lcom/bytedance/trae/network/DomainList;
    return-object v1
.end method

.method public final publicUser(com.bytedance.trae.network.DomainList)com.bytedance.trae.network.HostEntry$Builder
    .registers 3
    # ins_size=2
    const-string v0, "domain"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v0, v1
    check-cast v0, Lcom/bytedance/trae/network/HostEntry$Builder;
    iput-object v2, v1, Lcom/bytedance/trae/network/HostEntry$Builder;->publicUser Lcom/bytedance/trae/network/DomainList;
    return-object v1
.end method
