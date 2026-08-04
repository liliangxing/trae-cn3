# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/apm/impl/ApmImpl$startApm$configBuilder$1$getRequestTagHeader$tag$1;
.super Lcom/ss/android/ugc/quota/BDNetworkTagContextProviderAdapter;
.source "ApmImpl.kt"


.method constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/ss/android/ugc/quota/BDNetworkTagContextProviderAdapter;-><init>()V
    return-void 
.end method

.method public triggerType()int
    .registers 2
    # ins_size=1
    const/4 v0, 0
    return v0
.end method
