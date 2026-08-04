# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/service/ApplogServiceImpl;
.super Ljava/lang/Object;
.source "ApplogServiceImpl.kt"

.implements Lcom/bytedance/trae/platform/api/ISdkApplog;

.field public static final $stable:I
.field public static final INSTANCE:Lcom/bytedance/trae/service/ApplogServiceImpl;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/service/ApplogServiceImpl;
    invoke-direct v0, Lcom/bytedance/trae/service/ApplogServiceImpl;-><init>()V
    sput-object v0, Lcom/bytedance/trae/service/ApplogServiceImpl;->INSTANCE Lcom/bytedance/trae/service/ApplogServiceImpl;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public addApplogIdCallback(com.bytedance.trae.platform.api.IApplogIdCallback)void
    .registers 4
    # ins_size=2
    const-string v0, "callback"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    new-instance v1, Lcom/bytedance/trae/service/ApplogServiceImpl$addApplogIdCallback$1;
    invoke-direct v1, v3, Lcom/bytedance/trae/service/ApplogServiceImpl$addApplogIdCallback$1;-><init>(Lcom/bytedance/trae/platform/api/IApplogIdCallback;)V
    check-cast v1, Lcom/bytedance/trae/applog/api/OnGetAppLogIdListener;
    invoke-virtual v0, v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->addGetAppLogIdListener(Lcom/bytedance/trae/applog/api/OnGetAppLogIdListener;)V
    return-void 
.end method

.method public changeBgSessionTask(boolean)void
    .registers 2
    # ins_size=2
    if-eqz v1, +008h
    sget-object v1, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->onBgSessionTaskResume()V
    goto +6h
    sget-object v1, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->onBgSessionTaskPause()V
    return-void 
.end method

.method public getDeviceId()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getDeviceId()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public getInstallId()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getInstallId()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public getUserID()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getUserID()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public getUserUniqueID()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getUserUniqueID()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public putCommonParams(java.util.Map)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, params
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v0, v2, Lcom/bytedance/trae/applog/api/IApplog$Companion;->putCommonParams(Ljava/util/Map;)V
    return-void 
.end method

.method public reportEvent(java.lang.String  android.os.Bundle)void
    .registers 4
    # ins_size=3
    const-string v0, "event"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v0, v2, v3, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Landroid/os/Bundle;)V
    return-void 
.end method

.method public reportEvent(java.lang.String  org.json.JSONObject)void
    .registers 4
    # ins_size=3
    const-string v0, "event"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v0, v2, v3, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method

.method public setHeaderInfo(java.lang.String  java.lang.Object)void
    .registers 4
    # ins_size=3
    const-string v0, "key"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, value
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v0, v2, v3, Lcom/bytedance/trae/applog/api/IApplog$Companion;->setHeaderInfo(Ljava/lang/String; Ljava/lang/Object;)V
    return-void 
.end method
