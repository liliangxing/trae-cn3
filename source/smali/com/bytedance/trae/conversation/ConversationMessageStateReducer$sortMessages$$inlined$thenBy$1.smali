# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/ConversationMessageStateReducer$sortMessages$$inlined$thenBy$1;
.super Ljava/lang/Object;
.source "Comparisons.kt"

.implements Ljava/util/Comparator;

.field final synthetic $this_thenBy:Ljava/util/Comparator;


.method public constructor <init>(java.util.Comparator)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ConversationMessageStateReducer$sortMessages$$inlined$thenBy$1;->$this_thenBy Ljava/util/Comparator;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final compare(java.lang.Object  java.lang.Object)int
    .registers 5
    # ins_size=3
    iget-object v0, v2, Lcom/bytedance/trae/conversation/ConversationMessageStateReducer$sortMessages$$inlined$thenBy$1;->$this_thenBy Ljava/util/Comparator;
    invoke-interface v0, v3, v4, Ljava/util/Comparator;->compare(Ljava/lang/Object; Ljava/lang/Object;)I
    move-result v0
    if-eqz v0, +003h
    goto +45h
    check-cast v3, Lkotlin/Pair;
    invoke-virtual v3, Lkotlin/Pair;->component1()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v3, Lkotlin/Pair;->component2()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    if-nez v0, +003h
    move-object v0, v3
    const/4 v3, 0
    if-eqz v0, +00bh
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageIndex()I
    move-result v0
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    goto +5h
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    check-cast v0, Ljava/lang/Comparable;
    check-cast v4, Lkotlin/Pair;
    invoke-virtual v4, Lkotlin/Pair;->component1()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v4, Lkotlin/Pair;->component2()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    if-nez v1, +003h
    move-object v1, v4
    if-eqz v1, +006h
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageIndex()I
    move-result v3
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v3
    check-cast v3, Ljava/lang/Comparable;
    invoke-static v0, v3, Lkotlin/comparisons/ComparisonsKt;->compareValues(Ljava/lang/Comparable; Ljava/lang/Comparable;)I
    move-result v0
    return v0
.end method
