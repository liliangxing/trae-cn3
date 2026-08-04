# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/apm/impl/ApmImpl$registerDolaCloudControlConsumer$1;
.super Ljava/lang/Object;
.source "ApmImpl.kt"

.implements Lcom/monitor/cloudmessage/callback/IAlogConsumer;

.field final synthetic $isMinorMode:Z
.field private alogList:Ljava/util/List;


.method constructor <init>(boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/apm/impl/ApmImpl$registerDolaCloudControlConsumer$1;->$isMinorMode Z
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v1
    iput-object v1, v0, Lcom/bytedance/trae/apm/impl/ApmImpl$registerDolaCloudControlConsumer$1;->alogList Ljava/util/List;
    return-void 
.end method

.method public getConsumerResult()com.monitor.cloudmessage.entity.ConsumerResult
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/apm/impl/ApmImpl$registerDolaCloudControlConsumer$1;->alogList Ljava/util/List;
    check-cast v0, Ljava/util/Collection;
    invoke-interface v0, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    xor-int/lit8 v0, v0, 1
    iget-boolean v1, v3, Lcom/bytedance/trae/apm/impl/ApmImpl$registerDolaCloudControlConsumer$1;->$isMinorMode Z
    if-eqz v0, +005h
    const-string v1, ""
    goto +8h
    if-eqz v1, +005h
    const-string v1, "Cloud Command blocked: Forbidden in Minor Mode"
    goto +3h
    const-string v1, "alog file not get"
    if-eqz v0, +004h
    const/4 v2, 0
    goto +5h
    invoke-static Lcom/ss/android/agilelogger/ALog;->getLastFetchErrorInfo()Ljava/util/HashMap;
    move-result-object v2
    invoke-static v0, v1, v2, Lcom/monitor/cloudmessage/entity/ConsumerResult;->build(Z Ljava/lang/String; Ljava/util/HashMap;)Lcom/monitor/cloudmessage/entity/ConsumerResult;
    move-result-object v0
    const-string v1, "build(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v0
.end method

.method public handleAlogData(long  long  org.json.JSONObject)java.util.List
    .registers 8
    # ins_size=6
    const-string v0, "params"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-boolean v7, v2, Lcom/bytedance/trae/apm/impl/ApmImpl$registerDolaCloudControlConsumer$1;->$isMinorMode Z
    if-eqz v7, +005h
    iget-object v3, v2, Lcom/bytedance/trae/apm/impl/ApmImpl$registerDolaCloudControlConsumer$1;->alogList Ljava/util/List;
    return-object v3
    cmp-long v7, v3, v5
    if-gez v7, +01ah
    invoke-static Lcom/ss/android/agilelogger/ALog;->asyncFlush()V
    const-wide/16 v0, 1000
    invoke-static v0, v1, Ljava/lang/Thread;->sleep(J)V
    goto +5h
    move-exception v7
    invoke-virtual v7, Ljava/lang/InterruptedException;->printStackTrace()V
    invoke-static v3, v4, v5, v6, Lcom/ss/android/agilelogger/ALog;->getALogFiles(J J)Ljava/util/List;
    move-result-object v3
    const-string v4, "getALogFiles(...)"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v3, v2, Lcom/bytedance/trae/apm/impl/ApmImpl$registerDolaCloudControlConsumer$1;->alogList Ljava/util/List;
    iget-object v3, v2, Lcom/bytedance/trae/apm/impl/ApmImpl$registerDolaCloudControlConsumer$1;->alogList Ljava/util/List;
    return-object v3
    :try_start_0x15
.end method
