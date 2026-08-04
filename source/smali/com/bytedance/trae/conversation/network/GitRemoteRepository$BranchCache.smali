# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;
.super Ljava/lang/Object;
.source "GitRemoteRepository.kt"

.field private final branches:Ljava/util/List;
.field private final isFull:Z
.field private final nextPageToken:Ljava/lang/String;
.field private final total:Ljava/lang/Long;


.method public constructor <init>()void
    .registers 8
    # ins_size=1
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/16 v5, 15
    const/4 v6, 0
    move-object v0, v7
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;-><init>(Ljava/util/List; Ljava/lang/Long; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(java.util.List  java.lang.Long  java.lang.String  boolean)void
    .registers 6
    # ins_size=5
    const-string v0, "branches"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;->branches Ljava/util/List;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;->total Ljava/lang/Long;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;->nextPageToken Ljava/lang/String;
    iput-boolean v5, v1, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;->isFull Z
    return-void 
.end method

.method public synthetic constructor <init>(java.util.List  java.lang.Long  java.lang.String  boolean  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 8
    # ins_size=7
    and-int/lit8 v7, v6, 1
    if-eqz v7, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v2
    and-int/lit8 v7, v6, 2
    const/4 v0, 0
    if-eqz v7, +003h
    move-object v3, v0
    and-int/lit8 v7, v6, 4
    if-eqz v7, +003h
    move-object v4, v0
    and-int/lit8 v6, v6, 8
    if-eqz v6, +003h
    const/4 v5, 0
    invoke-direct v1, v2, v3, v4, v5, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;-><init>(Ljava/util/List; Ljava/lang/Long; Ljava/lang/String; Z)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.network.GitRemoteRepository$BranchCache  java.util.List  java.lang.Long  java.lang.String  boolean  int  java.lang.Object)com.bytedance.trae.conversation.network.GitRemoteRepository$BranchCache
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 1
    if-eqz v6, +004h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;->branches Ljava/util/List;
    and-int/lit8 v6, v5, 2
    if-eqz v6, +004h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;->total Ljava/lang/Long;
    and-int/lit8 v6, v5, 4
    if-eqz v6, +004h
    iget-object v3, v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;->nextPageToken Ljava/lang/String;
    and-int/lit8 v5, v5, 8
    if-eqz v5, +004h
    iget-boolean v4, v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;->isFull Z
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;->copy(Ljava/util/List; Ljava/lang/Long; Ljava/lang/String; Z)Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;->branches Ljava/util/List;
    return-object v0
.end method

.method public final component2()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;->total Ljava/lang/Long;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;->nextPageToken Ljava/lang/String;
    return-object v0
.end method

.method public final component4()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;->isFull Z
    return v0
.end method

.method public final copy(java.util.List  java.lang.Long  java.lang.String  boolean)com.bytedance.trae.conversation.network.GitRemoteRepository$BranchCache
    .registers 6
    # ins_size=5
    const-string v0, "branches"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;
    invoke-direct v0, v2, v3, v4, v5, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;-><init>(Ljava/util/List; Ljava/lang/Long; Ljava/lang/String; Z)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;->branches Ljava/util/List;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;->branches Ljava/util/List;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;->total Ljava/lang/Long;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;->total Ljava/lang/Long;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;->nextPageToken Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;->nextPageToken Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;->isFull Z
    iget-boolean v5, v5, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;->isFull Z
    if-eq v1, v5, +003h
    return v2
    return v0
.end method

.method public final getBranches()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;->branches Ljava/util/List;
    return-object v0
.end method

.method public final getNextPageToken()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;->nextPageToken Ljava/lang/String;
    return-object v0
.end method

.method public final getTotal()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;->total Ljava/lang/Long;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;->branches Ljava/util/List;
    invoke-virtual v0, Ljava/lang/Object;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;->total Ljava/lang/Long;
    const/4 v2, 0
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;->nextPageToken Ljava/lang/String;
    if-nez v1, +003h
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v3, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;->isFull Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public final isFull()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;->isFull Z
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "BranchCache(branches="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;->branches Ljava/util/List;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", total="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;->total Ljava/lang/Long;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", nextPageToken="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;->nextPageToken Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", isFull="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;->isFull Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
