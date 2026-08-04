# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/applog/impl/MultiInstanceAppLogServiceImpl;
.super Ljava/lang/Object;
.source "MultiInstanceAppLogServiceImpl.kt"

.implements Lcom/bytedance/trae/applog/api/IMultiInstanceAppLogService;


.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public createInstance()com.bytedance.trae.applog.api.IMultiInstanceAppLog
    .registers 4
    # ins_size=1
    new-instance v0, Lcom/bytedance/trae/applog/impl/MultiInstanceAppLog;
    invoke-static Lcom/bytedance/applog/AppLog;->newInstance()Lcom/bytedance/applog/IAppLogInstance;
    move-result-object v1
    const-string v2, "newInstance(...)"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v0, v1, Lcom/bytedance/trae/applog/impl/MultiInstanceAppLog;-><init>(Lcom/bytedance/applog/IAppLogInstance;)V
    check-cast v0, Lcom/bytedance/trae/applog/api/IMultiInstanceAppLog;
    return-object v0
.end method
