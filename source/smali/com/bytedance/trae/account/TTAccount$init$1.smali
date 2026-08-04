# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/account/TTAccount$init$1;
.super Ljava/lang/Object;
.source "TTAccount.kt"

.implements Lcom/ss/android/IRequestTagHeaderProvider;


.method constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public getRequestTagHeader(boolean)com.ss.android.TTHeader
    .registers 4
    # ins_size=2
    invoke-static Lcom/ss/android/ugc/quota/BDNetworkTagManager;->getInstance()Lcom/ss/android/ugc/quota/BDNetworkTagManager;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/account/TTAccount$init$1$getRequestTagHeader$requestTag$1;
    invoke-direct v1, v3, Lcom/bytedance/trae/account/TTAccount$init$1$getRequestTagHeader$requestTag$1;-><init>(Z)V
    check-cast v1, Lcom/ss/android/ugc/quota/IBDNetworkTagContextProvider;
    invoke-virtual v0, v1, Lcom/ss/android/ugc/quota/BDNetworkTagManager;->buildBDNetworkTag(Lcom/ss/android/ugc/quota/IBDNetworkTagContextProvider;)Landroid/util/Pair;
    move-result-object v3
    new-instance v0, Lcom/ss/android/TTHeader;
    iget-object v1, v3, Landroid/util/Pair;->first Ljava/lang/Object;
    check-cast v1, Ljava/lang/String;
    iget-object v3, v3, Landroid/util/Pair;->second Ljava/lang/Object;
    check-cast v3, Ljava/lang/String;
    invoke-direct v0, v1, v3, Lcom/ss/android/TTHeader;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    return-object v0
.end method

.method public getRequestTagHeader(boolean  boolean)com.ss.android.TTHeader
    .registers 4
    # ins_size=3
    invoke-static Lcom/ss/android/ugc/quota/BDNetworkTagManager;->getInstance()Lcom/ss/android/ugc/quota/BDNetworkTagManager;
    move-result-object v3
    new-instance v0, Lcom/bytedance/trae/account/TTAccount$init$1$getRequestTagHeader$requestTag$2;
    invoke-direct v0, v2, Lcom/bytedance/trae/account/TTAccount$init$1$getRequestTagHeader$requestTag$2;-><init>(Z)V
    check-cast v0, Lcom/ss/android/ugc/quota/IBDNetworkTagContextProvider;
    invoke-virtual v3, v0, Lcom/ss/android/ugc/quota/BDNetworkTagManager;->buildBDNetworkTag(Lcom/ss/android/ugc/quota/IBDNetworkTagContextProvider;)Landroid/util/Pair;
    move-result-object v2
    new-instance v3, Lcom/ss/android/TTHeader;
    iget-object v0, v2, Landroid/util/Pair;->first Ljava/lang/Object;
    check-cast v0, Ljava/lang/String;
    iget-object v2, v2, Landroid/util/Pair;->second Ljava/lang/Object;
    check-cast v2, Ljava/lang/String;
    invoke-direct v3, v0, v2, Lcom/ss/android/TTHeader;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    return-object v3
.end method
