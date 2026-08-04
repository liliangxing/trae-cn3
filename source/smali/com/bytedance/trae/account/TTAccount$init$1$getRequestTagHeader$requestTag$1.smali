# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/account/TTAccount$init$1$getRequestTagHeader$requestTag$1;
.super Lcom/ss/android/ugc/quota/BDNetworkTagContextProviderAdapter;
.source "TTAccount.kt"

.field final synthetic $isAuto:Z


.method constructor <init>(boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/account/TTAccount$init$1$getRequestTagHeader$requestTag$1;->$isAuto Z
    invoke-direct v0, Lcom/ss/android/ugc/quota/BDNetworkTagContextProviderAdapter;-><init>()V
    return-void 
.end method

.method public triggerType()int
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/account/TTAccount$init$1$getRequestTagHeader$requestTag$1;->$isAuto Z
    xor-int/lit8 v0, v0, 1
    return v0
.end method
