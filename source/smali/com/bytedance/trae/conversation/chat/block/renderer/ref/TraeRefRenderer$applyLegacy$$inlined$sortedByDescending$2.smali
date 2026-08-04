# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer$applyLegacy$$inlined$sortedByDescending$2;
.super Ljava/lang/Object;
.source "Comparisons.kt"

.implements Ljava/util/Comparator;

.field final synthetic $builder$inlined:Landroid/text/SpannableStringBuilder;


.method public constructor <init>(android.text.SpannableStringBuilder)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer$applyLegacy$$inlined$sortedByDescending$2;->$builder$inlined Landroid/text/SpannableStringBuilder;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final compare(java.lang.Object  java.lang.Object)int
    .registers 4
    # ins_size=3
    check-cast v3, Ljava/util/List;
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer$applyLegacy$$inlined$sortedByDescending$2;->$builder$inlined Landroid/text/SpannableStringBuilder;
    invoke-static v3, Lkotlin/collections/CollectionsKt;->first(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v3
    invoke-virtual v0, v3, Landroid/text/SpannableStringBuilder;->getSpanStart(Ljava/lang/Object;)I
    move-result v3
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v3
    check-cast v3, Ljava/lang/Comparable;
    check-cast v2, Ljava/util/List;
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer$applyLegacy$$inlined$sortedByDescending$2;->$builder$inlined Landroid/text/SpannableStringBuilder;
    invoke-static v2, Lkotlin/collections/CollectionsKt;->first(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v2
    invoke-virtual v0, v2, Landroid/text/SpannableStringBuilder;->getSpanStart(Ljava/lang/Object;)I
    move-result v2
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v2
    check-cast v2, Ljava/lang/Comparable;
    invoke-static v3, v2, Lkotlin/comparisons/ComparisonsKt;->compareValues(Ljava/lang/Comparable; Ljava/lang/Comparable;)I
    move-result v2
    return v2
.end method
