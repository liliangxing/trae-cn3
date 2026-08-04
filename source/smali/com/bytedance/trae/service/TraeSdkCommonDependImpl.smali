# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/service/TraeSdkCommonDependImpl;
.super Ljava/lang/Object;
.source "TraeSdkCommonDependImpl.kt"

.implements Lcom/bytedance/trae/platform/ITraeSdkCommonDepend;

.field public static final $stable:I


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public bridge synthetic getApmService()com.bytedance.trae.platform.api.ISdkApm
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/service/TraeSdkCommonDependImpl;->getApmService()Lcom/bytedance/trae/service/ApmServiceImpl;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/platform/api/ISdkApm;
    return-object v0
.end method

.method public getApmService()com.bytedance.trae.service.ApmServiceImpl
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/service/ApmServiceImpl;->INSTANCE Lcom/bytedance/trae/service/ApmServiceImpl;
    return-object v0
.end method

.method public bridge synthetic getApplogService()com.bytedance.trae.platform.api.ISdkApplog
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/service/TraeSdkCommonDependImpl;->getApplogService()Lcom/bytedance/trae/service/ApplogServiceImpl;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/platform/api/ISdkApplog;
    return-object v0
.end method

.method public getApplogService()com.bytedance.trae.service.ApplogServiceImpl
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/service/ApplogServiceImpl;->INSTANCE Lcom/bytedance/trae/service/ApplogServiceImpl;
    return-object v0
.end method

.method public bridge synthetic getCommonHttpService()com.bytedance.trae.platform.api.ISdkCommonHttp
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/service/TraeSdkCommonDependImpl;->getCommonHttpService()Lcom/bytedance/trae/service/SdkCommonHttpImpl;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/platform/api/ISdkCommonHttp;
    return-object v0
.end method

.method public getCommonHttpService()com.bytedance.trae.service.SdkCommonHttpImpl
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/service/SdkCommonHttpImpl;->INSTANCE Lcom/bytedance/trae/service/SdkCommonHttpImpl;
    return-object v0
.end method
