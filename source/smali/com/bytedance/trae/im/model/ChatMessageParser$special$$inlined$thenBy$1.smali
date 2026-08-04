# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/model/ChatMessageParser$special$$inlined$thenBy$1;
.super Ljava/lang/Object;
.source "Comparisons.kt"

.implements Ljava/util/Comparator;

.field final synthetic $this_thenBy:Ljava/util/Comparator;


.method public constructor <init>(java.util.Comparator)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ChatMessageParser$special$$inlined$thenBy$1;->$this_thenBy Ljava/util/Comparator;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final compare(java.lang.Object  java.lang.Object)int
    .registers 4
    # ins_size=3
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ChatMessageParser$special$$inlined$thenBy$1;->$this_thenBy Ljava/util/Comparator;
    invoke-interface v0, v2, v3, Ljava/util/Comparator;->compare(Ljava/lang/Object; Ljava/lang/Object;)I
    move-result v0
    if-eqz v0, +003h
    goto +1dh
    check-cast v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageIndex()I
    move-result v2
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v2
    check-cast v2, Ljava/lang/Comparable;
    check-cast v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageIndex()I
    move-result v3
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v3
    check-cast v3, Ljava/lang/Comparable;
    invoke-static v2, v3, Lkotlin/comparisons/ComparisonsKt;->compareValues(Ljava/lang/Comparable; Ljava/lang/Comparable;)I
    move-result v0
    return v0
.end method
