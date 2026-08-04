# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/DeviceCountEventTracker;
.super Ljava/lang/Object;
.source "DeviceCountEventTracker.kt"

.field private lastSnapshot:Lcom/bytedance/trae/conversation/DeviceCountSnapshot;
.field private final onReport:Lkotlin/jvm/functions/Function1;


.method public constructor <init>(kotlin.jvm.functions.Function1)void
    .registers 3
    # ins_size=2
    const-string v0, "onReport"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/DeviceCountEventTracker;->onReport Lkotlin/jvm/functions/Function1;
    return-void 
.end method

.method public final onFetchFailed()void
    .registers 1
    # ins_size=1
    return-void 
.end method

.method public final synchronized onFetchSucceeded(java.util.List)void
    .registers 8
    # ins_size=2
    monitor-enter v6
    const-string v0, "clis"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v7, Ljava/util/List;->size()I
    move-result v0
    move-object v1, v7
    check-cast v1, Ljava/lang/Iterable;
    instance-of v2, v1, Ljava/util/Collection;
    const/4 v3, 0
    if-eqz v2, +00dh
    move-object v2, v1
    check-cast v2, Ljava/util/Collection;
    invoke-interface v2, Ljava/util/Collection;->isEmpty()Z
    move-result v2
    if-eqz v2, +004h
    move v2, v3
    goto +2ah
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    move v2, v3
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +020h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/im/service/Cli;
    invoke-virtual v4, Lcom/bytedance/trae/im/service/Cli;->getType()Ljava/lang/String;
    move-result-object v4
    sget-object v5, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v5, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v5
    invoke-static v4, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, -01ah
    add-int/lit8 v2, v2, 1
    if-gez v2, -01eh
    invoke-static Lkotlin/collections/CollectionsKt;->throwCountOverflow()V
    goto -23h
    check-cast v7, Ljava/lang/Iterable;
    instance-of v1, v7, Ljava/util/Collection;
    if-eqz v1, +00ch
    move-object v1, v7
    check-cast v1, Ljava/util/Collection;
    invoke-interface v1, Ljava/util/Collection;->isEmpty()Z
    move-result v1
    if-eqz v1, +003h
    goto +29h
    invoke-interface v7, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v7
    invoke-interface v7, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +020h
    invoke-interface v7, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/im/service/Cli;
    invoke-virtual v1, Lcom/bytedance/trae/im/service/Cli;->getType()Ljava/lang/String;
    move-result-object v1
    sget-object v4, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v4, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v4
    invoke-static v1, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, -01ah
    add-int/lit8 v3, v3, 1
    if-gez v3, -01eh
    invoke-static Lkotlin/collections/CollectionsKt;->throwCountOverflow()V
    goto -23h
    new-instance v7, Lcom/bytedance/trae/conversation/DeviceCountSnapshot;
    invoke-direct v7, v0, v2, v3, Lcom/bytedance/trae/conversation/DeviceCountSnapshot;-><init>(I I I)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/DeviceCountEventTracker;->lastSnapshot Lcom/bytedance/trae/conversation/DeviceCountSnapshot;
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +004h
    monitor-exit v6
    return-void 
    iput-object v7, v6, Lcom/bytedance/trae/conversation/DeviceCountEventTracker;->lastSnapshot Lcom/bytedance/trae/conversation/DeviceCountSnapshot;
    iget-object v0, v6, Lcom/bytedance/trae/conversation/DeviceCountEventTracker;->onReport Lkotlin/jvm/functions/Function1;
    invoke-interface v0, v7, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    monitor-exit v6
    return-void 
    move-exception v7
    monitor-exit v6
    throw v7
    :try_start_0x1
    :try_start_0x8d
.end method
