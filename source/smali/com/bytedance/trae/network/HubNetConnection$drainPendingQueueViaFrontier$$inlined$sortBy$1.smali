# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/network/HubNetConnection$drainPendingQueueViaFrontier$$inlined$sortBy$1;
.super Ljava/lang/Object;
.source "Comparisons.kt"

.implements Ljava/util/Comparator;


.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final compare(java.lang.Object  java.lang.Object)int
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/trae/network/HubNetConnection$PendingSend;
    invoke-virtual v1, Lcom/bytedance/trae/network/HubNetConnection$PendingSend;->getMessage()Lcom/bytedance/trae/network/WsMessage;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/network/WsMessage;->getUpSeqId()Ljava/lang/Long;
    move-result-object v1
    check-cast v1, Ljava/lang/Comparable;
    check-cast v2, Lcom/bytedance/trae/network/HubNetConnection$PendingSend;
    invoke-virtual v2, Lcom/bytedance/trae/network/HubNetConnection$PendingSend;->getMessage()Lcom/bytedance/trae/network/WsMessage;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/network/WsMessage;->getUpSeqId()Ljava/lang/Long;
    move-result-object v2
    check-cast v2, Ljava/lang/Comparable;
    invoke-static v1, v2, Lkotlin/comparisons/ComparisonsKt;->compareValues(Ljava/lang/Comparable; Ljava/lang/Comparable;)I
    move-result v1
    return v1
.end method
