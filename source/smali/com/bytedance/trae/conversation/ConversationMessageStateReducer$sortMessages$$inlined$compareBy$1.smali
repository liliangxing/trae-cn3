# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/ConversationMessageStateReducer$sortMessages$$inlined$compareBy$1;
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
    .registers 8
    # ins_size=3
    check-cast v6, Lkotlin/Pair;
    invoke-virtual v6, Lkotlin/Pair;->component1()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v6, Lkotlin/Pair;->component2()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    if-nez v0, +003h
    move-object v0, v6
    const-wide/16 v1, 0
    if-eqz v0, +00bh
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getCreatedAt()J
    move-result-wide v3
    invoke-static v3, v4, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v6
    goto +5h
    invoke-static v1, v2, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v6
    check-cast v6, Ljava/lang/Comparable;
    check-cast v7, Lkotlin/Pair;
    invoke-virtual v7, Lkotlin/Pair;->component1()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v7, Lkotlin/Pair;->component2()Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    if-nez v0, +003h
    move-object v0, v7
    if-eqz v0, +00bh
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getCreatedAt()J
    move-result-wide v0
    invoke-static v0, v1, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v7
    goto +5h
    invoke-static v1, v2, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v7
    check-cast v7, Ljava/lang/Comparable;
    invoke-static v6, v7, Lkotlin/comparisons/ComparisonsKt;->compareValues(Ljava/lang/Comparable; Ljava/lang/Comparable;)I
    move-result v6
    return v6
.end method
