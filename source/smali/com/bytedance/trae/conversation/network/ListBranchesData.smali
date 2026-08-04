# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/network/ListBranchesData;
.super Ljava/lang/Object;
.source "Models.kt"

.field private final items:Ljava/util/List;
.field private final nextPageToken:Ljava/lang/String;
.field private final total:Ljava/lang/Long;


.method public constructor <init>()void
    .registers 7
    # ins_size=1
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 7
    const/4 v5, 0
    move-object v0, v6
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/network/ListBranchesData;-><init>(Ljava/util/List; Ljava/lang/Long; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(java.util.List  java.lang.Long  java.lang.String)void
    .registers 5
    # ins_size=4
    const-string v0, "items"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/network/ListBranchesData;->items Ljava/util/List;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/network/ListBranchesData;->total Ljava/lang/Long;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/network/ListBranchesData;->nextPageToken Ljava/lang/String;
    return-void 
.end method

.method public synthetic constructor <init>(java.util.List  java.lang.Long  java.lang.String  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 7
    # ins_size=6
    and-int/lit8 v6, v5, 1
    if-eqz v6, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v2
    and-int/lit8 v6, v5, 2
    const/4 v0, 0
    if-eqz v6, +003h
    move-object v3, v0
    and-int/lit8 v5, v5, 4
    if-eqz v5, +003h
    move-object v4, v0
    invoke-direct v1, v2, v3, v4, Lcom/bytedance/trae/conversation/network/ListBranchesData;-><init>(Ljava/util/List; Ljava/lang/Long; Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.network.ListBranchesData  java.util.List  java.lang.Long  java.lang.String  int  java.lang.Object)com.bytedance.trae.conversation.network.ListBranchesData
    .registers 6
    # ins_size=6
    and-int/lit8 v5, v4, 1
    if-eqz v5, +004h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/network/ListBranchesData;->items Ljava/util/List;
    and-int/lit8 v5, v4, 2
    if-eqz v5, +004h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/network/ListBranchesData;->total Ljava/lang/Long;
    and-int/lit8 v4, v4, 4
    if-eqz v4, +004h
    iget-object v3, v0, Lcom/bytedance/trae/conversation/network/ListBranchesData;->nextPageToken Ljava/lang/String;
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/conversation/network/ListBranchesData;->copy(Ljava/util/List; Ljava/lang/Long; Ljava/lang/String;)Lcom/bytedance/trae/conversation/network/ListBranchesData;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/ListBranchesData;->items Ljava/util/List;
    return-object v0
.end method

.method public final component2()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/ListBranchesData;->total Ljava/lang/Long;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/ListBranchesData;->nextPageToken Ljava/lang/String;
    return-object v0
.end method

.method public final copy(java.util.List  java.lang.Long  java.lang.String)com.bytedance.trae.conversation.network.ListBranchesData
    .registers 5
    # ins_size=4
    const-string v0, "items"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/network/ListBranchesData;
    invoke-direct v0, v2, v3, v4, Lcom/bytedance/trae/conversation/network/ListBranchesData;-><init>(Ljava/util/List; Ljava/lang/Long; Ljava/lang/String;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/network/ListBranchesData;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/network/ListBranchesData;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/network/ListBranchesData;->items Ljava/util/List;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/network/ListBranchesData;->items Ljava/util/List;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/network/ListBranchesData;->total Ljava/lang/Long;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/network/ListBranchesData;->total Ljava/lang/Long;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/network/ListBranchesData;->nextPageToken Ljava/lang/String;
    iget-object v5, v5, Lcom/bytedance/trae/conversation/network/ListBranchesData;->nextPageToken Ljava/lang/String;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getItems()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/ListBranchesData;->items Ljava/util/List;
    return-object v0
.end method

.method public final getNextPageToken()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/ListBranchesData;->nextPageToken Ljava/lang/String;
    return-object v0
.end method

.method public final getTotal()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/ListBranchesData;->total Ljava/lang/Long;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/network/ListBranchesData;->items Ljava/util/List;
    invoke-virtual v0, Ljava/lang/Object;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/network/ListBranchesData;->total Ljava/lang/Long;
    const/4 v2, 0
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/network/ListBranchesData;->nextPageToken Ljava/lang/String;
    if-nez v1, +003h
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "ListBranchesData(items="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/network/ListBranchesData;->items Ljava/util/List;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", total="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/network/ListBranchesData;->total Ljava/lang/Long;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", nextPageToken="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/network/ListBranchesData;->nextPageToken Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
