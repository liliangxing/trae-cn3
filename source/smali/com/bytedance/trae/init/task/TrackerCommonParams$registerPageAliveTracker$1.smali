# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/init/task/TrackerCommonParams$registerPageAliveTracker$1;
.super Ljava/lang/Object;
.source "TrackerCommonParams.kt"

.implements Lcom/bytedance/trae/applog/api/OnNavigateCallback;


.method constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public onPause(java.lang.String  org.json.JSONObject)void
    .registers 7
    # ins_size=3
    const-string v0, "activityName"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "flatParams"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static Lcom/bytedance/trae/init/task/TrackerCommonParams;->access$getPageResumeTimeMap$p()Ljava/util/HashMap;
    move-result-object v6
    invoke-virtual v6, v5, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Ljava/lang/Long;
    if-eqz v6, +027h
    invoke-virtual v6, Ljava/lang/Long;->longValue()J
    move-result-wide v0
    invoke-static Landroid/os/SystemClock;->elapsedRealtime()J
    move-result-wide v2
    sub-long/2addr v2, v0
    const-wide/16 v0, 0
    cmp-long v6, v2, v0
    if-lez v6, +018h
    new-instance v6, Lorg/json/JSONObject;
    invoke-direct v6, Lorg/json/JSONObject;-><init>()V
    const-string v0, "page_key"
    invoke-virtual v6, v0, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v5, "duration"
    invoke-virtual v6, v5, v2, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    sget-object v5, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    const-string v0, "predefine_page_alive"
    invoke-virtual v5, v0, v6, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method

.method public onResume(java.lang.String  org.json.JSONObject)void
    .registers 5
    # ins_size=3
    const-string v0, "activityName"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "flatParams"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static Lcom/bytedance/trae/init/task/TrackerCommonParams;->access$getPageResumeTimeMap$p()Ljava/util/HashMap;
    move-result-object v4
    check-cast v4, Ljava/util/Map;
    invoke-static Landroid/os/SystemClock;->elapsedRealtime()J
    move-result-wide v0
    invoke-static v0, v1, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v0
    invoke-interface v4, v3, v0, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method
