# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/network/IdeVersionComparator$Version;
.super Ljava/lang/Object;
.source "IdeVersionComparator.kt"

.implements Ljava/lang/Comparable;

.field private final parts:Ljava/util/List;


.method public constructor <init>(java.util.List)void
    .registers 3
    # ins_size=2
    const-string v0, "parts"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/network/IdeVersionComparator$Version;->parts Ljava/util/List;
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.network.IdeVersionComparator$Version  java.util.List  int  java.lang.Object)com.bytedance.trae.conversation.network.IdeVersionComparator$Version
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +004h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/network/IdeVersionComparator$Version;->parts Ljava/util/List;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/network/IdeVersionComparator$Version;->copy(Ljava/util/List;)Lcom/bytedance/trae/conversation/network/IdeVersionComparator$Version;
    move-result-object v0
    return-object v0
.end method

.method public compareTo(com.bytedance.trae.conversation.network.IdeVersionComparator$Version)int
    .registers 10
    # ins_size=2
    const-string v0, "other"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v8, Lcom/bytedance/trae/conversation/network/IdeVersionComparator$Version;->parts Ljava/util/List;
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v0
    iget-object v1, v9, Lcom/bytedance/trae/conversation/network/IdeVersionComparator$Version;->parts Ljava/util/List;
    invoke-interface v1, Ljava/util/List;->size()I
    move-result v1
    invoke-static v0, v1, Ljava/lang/Math;->max(I I)I
    move-result v0
    const/4 v1, 0
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v2
    move v3, v1
    if-ge v3, v0, +054h
    iget-object v4, v8, Lcom/bytedance/trae/conversation/network/IdeVersionComparator$Version;->parts Ljava/util/List;
    const/4 v5, 1
    if-ltz v3, +00ah
    invoke-interface v4, Ljava/util/List;->size()I
    move-result v6
    if-ge v3, v6, +004h
    move v6, v5
    goto +2h
    move v6, v1
    if-eqz v6, +007h
    invoke-interface v4, v3, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v4
    goto +2h
    move-object v4, v2
    check-cast v4, Ljava/lang/Comparable;
    iget-object v6, v9, Lcom/bytedance/trae/conversation/network/IdeVersionComparator$Version;->parts Ljava/util/List;
    if-ltz v3, +00ah
    invoke-interface v6, Ljava/util/List;->size()I
    move-result v7
    if-ge v3, v7, +004h
    move v7, v5
    goto +2h
    move v7, v1
    if-eqz v7, +007h
    invoke-interface v6, v3, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v6
    goto +2h
    move-object v6, v2
    check-cast v6, Ljava/lang/Comparable;
    invoke-static v4, v6, Lkotlin/comparisons/ComparisonsKt;->compareValues(Ljava/lang/Comparable; Ljava/lang/Comparable;)I
    move-result v4
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    move-object v6, v4
    check-cast v6, Ljava/lang/Number;
    invoke-virtual v6, Ljava/lang/Number;->intValue()I
    move-result v6
    if-eqz v6, +003h
    goto +2h
    move v5, v1
    if-eqz v5, +003h
    goto +2h
    const/4 v4, 0
    if-eqz v4, +009h
    check-cast v4, Ljava/lang/Number;
    invoke-virtual v4, Ljava/lang/Number;->intValue()I
    move-result v9
    return v9
    add-int/lit8 v3, v3, 1
    goto -53h
    return v1
.end method

.method public bridge synthetic compareTo(java.lang.Object)int
    .registers 2
    # ins_size=2
    check-cast v1, Lcom/bytedance/trae/conversation/network/IdeVersionComparator$Version;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/network/IdeVersionComparator$Version;->compareTo(Lcom/bytedance/trae/conversation/network/IdeVersionComparator$Version;)I
    move-result v1
    return v1
.end method

.method public final component1()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/IdeVersionComparator$Version;->parts Ljava/util/List;
    return-object v0
.end method

.method public final copy(java.util.List)com.bytedance.trae.conversation.network.IdeVersionComparator$Version
    .registers 3
    # ins_size=2
    const-string v0, "parts"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/network/IdeVersionComparator$Version;
    invoke-direct v0, v2, Lcom/bytedance/trae/conversation/network/IdeVersionComparator$Version;-><init>(Ljava/util/List;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 5
    # ins_size=2
    const/4 v0, 1
    if-ne v3, v4, +003h
    return v0
    instance-of v1, v4, Lcom/bytedance/trae/conversation/network/IdeVersionComparator$Version;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v4, Lcom/bytedance/trae/conversation/network/IdeVersionComparator$Version;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/network/IdeVersionComparator$Version;->parts Ljava/util/List;
    iget-object v4, v4, Lcom/bytedance/trae/conversation/network/IdeVersionComparator$Version;->parts Ljava/util/List;
    invoke-static v1, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +003h
    return v2
    return v0
.end method

.method public final getParts()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/IdeVersionComparator$Version;->parts Ljava/util/List;
    return-object v0
.end method

.method public hashCode()int
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/IdeVersionComparator$Version;->parts Ljava/util/List;
    invoke-virtual v0, Ljava/lang/Object;->hashCode()I
    move-result v0
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "Version(parts="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/network/IdeVersionComparator$Version;->parts Ljava/util/List;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
