# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository$loadBuckets$2$invokeSuspend$$inlined$sortedByDescending$1;
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
    check-cast v2, Lcom/bytedance/trae/conversation/mediachoose/model/AlbumBucket;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/mediachoose/model/AlbumBucket;->getCount()I
    move-result v2
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v2
    check-cast v2, Ljava/lang/Comparable;
    check-cast v1, Lcom/bytedance/trae/conversation/mediachoose/model/AlbumBucket;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/mediachoose/model/AlbumBucket;->getCount()I
    move-result v1
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    check-cast v1, Ljava/lang/Comparable;
    invoke-static v2, v1, Lkotlin/comparisons/ComparisonsKt;->compareValues(Ljava/lang/Comparable; Ljava/lang/Comparable;)I
    move-result v1
    return v1
.end method
