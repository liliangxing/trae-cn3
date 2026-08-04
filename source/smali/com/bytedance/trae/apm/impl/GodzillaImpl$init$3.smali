# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/apm/impl/GodzillaImpl$init$3;
.super Ljava/lang/Object;
.source "GodzillaImpl.kt"

.implements Lcom/bytedance/platform/godzilla/crash/uncaughtexecption/SuperUncaughtExceptionPlugin$ConfigFetcher;


.method constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public getAppVersion()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getVersionName()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public getCrashPortrait()java.util.List
    .registers 2
    # ins_size=1
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/List;
    return-object v0
.end method

.method public getUpdateVersion()int
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getUpdateVersionCode()I
    move-result v0
    return v0
.end method

.method public onCrashCatchSucceed(com.bytedance.platform.godzilla.common.CrashPortrait)void
    .registers 5
    # ins_size=2
    const-string v0, "crashPortrait"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    const-string v1, "process_name"
    iget-object v2, v4, Lcom/bytedance/platform/godzilla/common/CrashPortrait;->processName Ljava/lang/String;
    invoke-virtual v0, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v1, thread_name
    iget-object v2, v4, Lcom/bytedance/platform/godzilla/common/CrashPortrait;->threadName Ljava/lang/String;
    invoke-virtual v0, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v1, "clazz_name"
    iget-object v2, v4, Lcom/bytedance/platform/godzilla/common/CrashPortrait;->clazzName Ljava/lang/String;
    invoke-virtual v0, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v1, "method_name"
    iget-object v2, v4, Lcom/bytedance/platform/godzilla/common/CrashPortrait;->methodName Ljava/lang/String;
    invoke-virtual v0, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v1, throwable_class_name
    iget-object v2, v4, Lcom/bytedance/platform/godzilla/common/CrashPortrait;->throwableClassName Ljava/lang/String;
    invoke-virtual v0, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v1, "message"
    iget-object v2, v4, Lcom/bytedance/platform/godzilla/common/CrashPortrait;->detailMessage Ljava/lang/String;
    invoke-virtual v0, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v1, "app_version"
    iget-object v2, v4, Lcom/bytedance/platform/godzilla/common/CrashPortrait;->appVersion Ljava/lang/String;
    invoke-virtual v0, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v1, update_version
    iget v2, v4, Lcom/bytedance/platform/godzilla/common/CrashPortrait;->updateVersion I
    invoke-virtual v0, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    const-string v1, "os_version"
    iget v2, v4, Lcom/bytedance/platform/godzilla/common/CrashPortrait;->osVersion I
    invoke-virtual v0, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    const-string v1, "crash_portrait"
    const/4 v2, 0
    invoke-static v1, v0, v2, v2, Lcom/bytedance/apm/ApmAgent;->monitorEvent(Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; Lorg/json/JSONObject;)V
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/Throwable;
    invoke-virtual v4, Lcom/bytedance/platform/godzilla/common/CrashPortrait;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-direct v1, v4, Ljava/lang/Throwable;-><init>(Ljava/lang/String;)V
    const-string v4, "GodzillaExt"
    const-string v2, "onCrashCatchSucceed"
    invoke-virtual v0, v4, v2, v1, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-void 
.end method
