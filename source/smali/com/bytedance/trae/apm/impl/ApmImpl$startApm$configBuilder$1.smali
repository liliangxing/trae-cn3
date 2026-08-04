# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/apm/impl/ApmImpl$startApm$configBuilder$1;
.super Ljava/lang/Object;
.source "ApmImpl.kt"

.implements Lcom/bytedance/services/apm/api/IRequestTagHeaderProvider;


.method constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public getRequestTagHeader()java.util.Map
    .registers 4
    # ins_size=1
    invoke-static Lcom/ss/android/ugc/quota/BDNetworkTagManager;->getInstance()Lcom/ss/android/ugc/quota/BDNetworkTagManager;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/apm/impl/ApmImpl$startApm$configBuilder$1$getRequestTagHeader$tag$1;
    invoke-direct v1, Lcom/bytedance/trae/apm/impl/ApmImpl$startApm$configBuilder$1$getRequestTagHeader$tag$1;-><init>()V
    check-cast v1, Lcom/ss/android/ugc/quota/IBDNetworkTagContextProvider;
    invoke-virtual v0, v1, Lcom/ss/android/ugc/quota/BDNetworkTagManager;->buildBDNetworkTag(Lcom/ss/android/ugc/quota/IBDNetworkTagContextProvider;)Landroid/util/Pair;
    move-result-object v0
    const/4 v1, 1
    new-array v1, v1, [Lkotlin/Pair;
    iget-object v2, v0, Landroid/util/Pair;->first Ljava/lang/Object;
    iget-object v0, v0, Landroid/util/Pair;->second Ljava/lang/Object;
    invoke-static v2, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/4 v2, 0
    aput-object v0, v1, v2
    invoke-static v1, Lkotlin/collections/MapsKt;->mutableMapOf([Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v0
    return-object v0
.end method
