# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/track/ChatFirstTokenTracker$calculateAndPutStepDurations$$inlined$sortBy$1;
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
    check-cast v1, Lkotlin/Pair;
    invoke-virtual v1, Lkotlin/Pair;->getSecond()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/Double;
    check-cast v1, Ljava/lang/Comparable;
    check-cast v2, Lkotlin/Pair;
    invoke-virtual v2, Lkotlin/Pair;->getSecond()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/Double;
    check-cast v2, Ljava/lang/Comparable;
    invoke-static v1, v2, Lkotlin/comparisons/ComparisonsKt;->compareValues(Ljava/lang/Comparable; Ljava/lang/Comparable;)I
    move-result v1
    return v1
.end method
