# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/service/ListConversationsRequest;
.super Ljava/lang/Object;
.source "IListConversationsService.kt"

.field private final orderBy:Ljava/lang/String;
.field private final pageIndex:I
.field private final pageSize:I
.field private final sort:Ljava/lang/String;


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
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/im/service/ListConversationsRequest;-><init>(I I Ljava/lang/String; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(int  int  java.lang.String  java.lang.String)void
    .registers 6
    # ins_size=5
    const-string v0, "orderBy"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, sort
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput v2, v1, Lcom/bytedance/trae/im/service/ListConversationsRequest;->pageSize I
    iput v3, v1, Lcom/bytedance/trae/im/service/ListConversationsRequest;->pageIndex I
    iput-object v4, v1, Lcom/bytedance/trae/im/service/ListConversationsRequest;->orderBy Ljava/lang/String;
    iput-object v5, v1, Lcom/bytedance/trae/im/service/ListConversationsRequest;->sort Ljava/lang/String;
    return-void 
.end method

.method public synthetic constructor <init>(int  int  java.lang.String  java.lang.String  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 1
    if-eqz v6, +004h
    const/16 v1, 300
    and-int/lit8 v6, v5, 2
    if-eqz v6, +003h
    const/4 v2, 0
    and-int/lit8 v6, v5, 4
    if-eqz v6, +005h
    const-string/jumbo v3, updated_at
    and-int/lit8 v5, v5, 8
    if-eqz v5, +004h
    const-string v4, "desc"
    invoke-direct v0, v1, v2, v3, v4, Lcom/bytedance/trae/im/service/ListConversationsRequest;-><init>(I I Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.im.service.ListConversationsRequest  int  int  java.lang.String  java.lang.String  int  java.lang.Object)com.bytedance.trae.im.service.ListConversationsRequest
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 1
    if-eqz v6, +004h
    iget v1, v0, Lcom/bytedance/trae/im/service/ListConversationsRequest;->pageSize I
    and-int/lit8 v6, v5, 2
    if-eqz v6, +004h
    iget v2, v0, Lcom/bytedance/trae/im/service/ListConversationsRequest;->pageIndex I
    and-int/lit8 v6, v5, 4
    if-eqz v6, +004h
    iget-object v3, v0, Lcom/bytedance/trae/im/service/ListConversationsRequest;->orderBy Ljava/lang/String;
    and-int/lit8 v5, v5, 8
    if-eqz v5, +004h
    iget-object v4, v0, Lcom/bytedance/trae/im/service/ListConversationsRequest;->sort Ljava/lang/String;
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/im/service/ListConversationsRequest;->copy(I I Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/trae/im/service/ListConversationsRequest;
    move-result-object v0
    return-object v0
.end method

.method public final component1()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/im/service/ListConversationsRequest;->pageSize I
    return v0
.end method

.method public final component2()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/im/service/ListConversationsRequest;->pageIndex I
    return v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ListConversationsRequest;->orderBy Ljava/lang/String;
    return-object v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ListConversationsRequest;->sort Ljava/lang/String;
    return-object v0
.end method

.method public final copy(int  int  java.lang.String  java.lang.String)com.bytedance.trae.im.service.ListConversationsRequest
    .registers 6
    # ins_size=5
    const-string v0, "orderBy"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, sort
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/im/service/ListConversationsRequest;
    invoke-direct v0, v2, v3, v4, v5, Lcom/bytedance/trae/im/service/ListConversationsRequest;-><init>(I I Ljava/lang/String; Ljava/lang/String;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/im/service/ListConversationsRequest;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/im/service/ListConversationsRequest;
    iget v1, v4, Lcom/bytedance/trae/im/service/ListConversationsRequest;->pageSize I
    iget v3, v5, Lcom/bytedance/trae/im/service/ListConversationsRequest;->pageSize I
    if-eq v1, v3, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/im/service/ListConversationsRequest;->pageIndex I
    iget v3, v5, Lcom/bytedance/trae/im/service/ListConversationsRequest;->pageIndex I
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ListConversationsRequest;->orderBy Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ListConversationsRequest;->orderBy Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ListConversationsRequest;->sort Ljava/lang/String;
    iget-object v5, v5, Lcom/bytedance/trae/im/service/ListConversationsRequest;->sort Ljava/lang/String;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getOrderBy()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ListConversationsRequest;->orderBy Ljava/lang/String;
    return-object v0
.end method

.method public final getPageIndex()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/im/service/ListConversationsRequest;->pageIndex I
    return v0
.end method

.method public final getPageSize()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/im/service/ListConversationsRequest;->pageSize I
    return v0
.end method

.method public final getSort()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ListConversationsRequest;->sort Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget v0, v2, Lcom/bytedance/trae/im/service/ListConversationsRequest;->pageSize I
    invoke-static v0, Ljava/lang/Integer;->hashCode(I)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/im/service/ListConversationsRequest;->pageIndex I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/im/service/ListConversationsRequest;->orderBy Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/im/service/ListConversationsRequest;->sort Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "ListConversationsRequest(pageSize="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget v1, v2, Lcom/bytedance/trae/im/service/ListConversationsRequest;->pageSize I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", pageIndex="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/im/service/ListConversationsRequest;->pageIndex I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", orderBy="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/ListConversationsRequest;->orderBy Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", sort="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/ListConversationsRequest;->sort Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
