# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$seedHistoryWithAttachments$Tagged;
.super Ljava/lang/Object;
.source "HistorySubtitleAdapter.kt"

.field private final item:Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;
.field private final kindRank:I
.field private final ts:J


.method public constructor <init>(long  int  com.bytedance.trae.conversation.brainstorm.adapter.HistorySubtitleAdapter$SubtitleItem)void
    .registers 6
    # ins_size=5
    const-string v0, "item"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-wide v2, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$seedHistoryWithAttachments$Tagged;->ts J
    iput v4, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$seedHistoryWithAttachments$Tagged;->kindRank I
    iput-object v5, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$seedHistoryWithAttachments$Tagged;->item Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.brainstorm.adapter.HistorySubtitleAdapter$seedHistoryWithAttachments$Tagged  long  int  com.bytedance.trae.conversation.brainstorm.adapter.HistorySubtitleAdapter$SubtitleItem  int  java.lang.Object)com.bytedance.trae.conversation.brainstorm.adapter.HistorySubtitleAdapter$seedHistoryWithAttachments$Tagged
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 1
    if-eqz v6, +004h
    iget-wide v1, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$seedHistoryWithAttachments$Tagged;->ts J
    and-int/lit8 v6, v5, 2
    if-eqz v6, +004h
    iget v3, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$seedHistoryWithAttachments$Tagged;->kindRank I
    and-int/lit8 v5, v5, 4
    if-eqz v5, +004h
    iget-object v4, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$seedHistoryWithAttachments$Tagged;->item Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$seedHistoryWithAttachments$Tagged;->copy(J I Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;)Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$seedHistoryWithAttachments$Tagged;
    move-result-object v0
    return-object v0
.end method

.method public final component1()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$seedHistoryWithAttachments$Tagged;->ts J
    return-wide v0
.end method

.method public final component2()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$seedHistoryWithAttachments$Tagged;->kindRank I
    return v0
.end method

.method public final component3()com.bytedance.trae.conversation.brainstorm.adapter.HistorySubtitleAdapter$SubtitleItem
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$seedHistoryWithAttachments$Tagged;->item Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;
    return-object v0
.end method

.method public final copy(long  int  com.bytedance.trae.conversation.brainstorm.adapter.HistorySubtitleAdapter$SubtitleItem)com.bytedance.trae.conversation.brainstorm.adapter.HistorySubtitleAdapter$seedHistoryWithAttachments$Tagged
    .registers 6
    # ins_size=5
    const-string v0, "item"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$seedHistoryWithAttachments$Tagged;
    invoke-direct v0, v2, v3, v4, v5, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$seedHistoryWithAttachments$Tagged;-><init>(J I Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 1
    if-ne v7, v8, +003h
    return v0
    instance-of v1, v8, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$seedHistoryWithAttachments$Tagged;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v8, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$seedHistoryWithAttachments$Tagged;
    iget-wide v3, v7, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$seedHistoryWithAttachments$Tagged;->ts J
    iget-wide v5, v8, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$seedHistoryWithAttachments$Tagged;->ts J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$seedHistoryWithAttachments$Tagged;->kindRank I
    iget v3, v8, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$seedHistoryWithAttachments$Tagged;->kindRank I
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$seedHistoryWithAttachments$Tagged;->item Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;
    iget-object v8, v8, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$seedHistoryWithAttachments$Tagged;->item Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;
    invoke-static v1, v8, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v8
    if-nez v8, +003h
    return v2
    return v0
.end method

.method public final getItem()com.bytedance.trae.conversation.brainstorm.adapter.HistorySubtitleAdapter$SubtitleItem
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$seedHistoryWithAttachments$Tagged;->item Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;
    return-object v0
.end method

.method public final getKindRank()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$seedHistoryWithAttachments$Tagged;->kindRank I
    return v0
.end method

.method public final getTs()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$seedHistoryWithAttachments$Tagged;->ts J
    return-wide v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$seedHistoryWithAttachments$Tagged;->ts J
    invoke-static v0, v1, Ljava/lang/Long;->hashCode(J)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$seedHistoryWithAttachments$Tagged;->kindRank I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$seedHistoryWithAttachments$Tagged;->item Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "Tagged(ts="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$seedHistoryWithAttachments$Tagged;->ts J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", kindRank="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$seedHistoryWithAttachments$Tagged;->kindRank I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", item="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$seedHistoryWithAttachments$Tagged;->item Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
