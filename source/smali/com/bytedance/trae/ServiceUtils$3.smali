# Decompiled TRAE business class
# Source DEX: classes5.dex
.class 0x0 Lcom/bytedance/trae/ServiceUtils$3;
.super Ljava/lang/Object;
.source "ServiceUtils.java"

.implements Lcom/ss/android/ugc/aweme/framework/services/ServiceProvider;


.method constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public get()com.bytedance.trae.applog.init.IAppLogInitiator
    .registers 2
    # ins_size=1
    new-instance v0, Lcom/bytedance/trae/applog/task/AppLogInitiator;
    invoke-direct v0, Lcom/bytedance/trae/applog/task/AppLogInitiator;-><init>()V
    return-object v0
.end method

.method public bridge synthetic get()java.lang.Object
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/ServiceUtils$3;->get()Lcom/bytedance/trae/applog/init/IAppLogInitiator;
    move-result-object v0
    return-object v0
.end method
