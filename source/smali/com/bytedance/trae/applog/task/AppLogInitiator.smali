# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/applog/task/AppLogInitiator;
.super Ljava/lang/Object;
.source "AppLogInitiator.kt"

.implements Lcom/bytedance/trae/applog/init/IAppLogInitiator;


.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public initAppLog(com.bytedance.trae.applog.api.AppLogConfigInfo)void
    .registers 3
    # ins_size=2
    const-string v0, "configInfo"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;->INSTANCE Lcom/bytedance/trae/applog/impl/AppLogHelper;
    invoke-virtual v0, v2, Lcom/bytedance/trae/applog/impl/AppLogHelper;->init(Lcom/bytedance/trae/applog/api/AppLogConfigInfo;)V
    sget-object v2, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v2, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isDebug()Z
    move-result v2
    if-nez v2, +00ah
    sget-object v2, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v2, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isTestChannel()Z
    move-result v2
    if-eqz v2, +007h
    sget-object v2, Lcom/bytedance/trae/applog/impl/AppLogHelper;->INSTANCE Lcom/bytedance/trae/applog/impl/AppLogHelper;
    invoke-virtual v2, Lcom/bytedance/trae/applog/impl/AppLogHelper;->openETVerify()V
    const/4 v2, 1
    invoke-static v2, Lcom/ss/android/common/applog/AppLog;->setSwitchToBdtracker(Z)V
    sput-boolean v2, Lcom/ss/android/common/applog/ApplogServiceImpl;->isServicePrepared Z
    invoke-static Lcom/ss/android/common/applog/ApplogServiceImpl;->handleCachedData()V
    return-void 
.end method
