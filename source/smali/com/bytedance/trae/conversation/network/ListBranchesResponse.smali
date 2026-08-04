# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/network/ListBranchesResponse;
.super Ljava/lang/Object;
.source "Models.kt"

.field private final code:I
.field private final data:Lcom/bytedance/trae/conversation/network/ListBranchesData;
.field private final message:Ljava/lang/String;


.method public constructor <init>(int  java.lang.String  com.bytedance.trae.conversation.network.ListBranchesData)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput v1, v0, Lcom/bytedance/trae/conversation/network/ListBranchesResponse;->code I
    iput-object v2, v0, Lcom/bytedance/trae/conversation/network/ListBranchesResponse;->message Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/network/ListBranchesResponse;->data Lcom/bytedance/trae/conversation/network/ListBranchesData;
    return-void 
.end method

.method public synthetic constructor <init>(int  java.lang.String  com.bytedance.trae.conversation.network.ListBranchesData  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 7
    # ins_size=6
    and-int/lit8 v6, v5, 2
    const/4 v0, 0
    if-eqz v6, +003h
    move-object v3, v0
    and-int/lit8 v5, v5, 4
    if-eqz v5, +003h
    move-object v4, v0
    invoke-direct v1, v2, v3, v4, Lcom/bytedance/trae/conversation/network/ListBranchesResponse;-><init>(I Ljava/lang/String; Lcom/bytedance/trae/conversation/network/ListBranchesData;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.network.ListBranchesResponse  int  java.lang.String  com.bytedance.trae.conversation.network.ListBranchesData  int  java.lang.Object)com.bytedance.trae.conversation.network.ListBranchesResponse
    .registers 6
    # ins_size=6
    and-int/lit8 v5, v4, 1
    if-eqz v5, +004h
    iget v1, v0, Lcom/bytedance/trae/conversation/network/ListBranchesResponse;->code I
    and-int/lit8 v5, v4, 2
    if-eqz v5, +004h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/network/ListBranchesResponse;->message Ljava/lang/String;
    and-int/lit8 v4, v4, 4
    if-eqz v4, +004h
    iget-object v3, v0, Lcom/bytedance/trae/conversation/network/ListBranchesResponse;->data Lcom/bytedance/trae/conversation/network/ListBranchesData;
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/conversation/network/ListBranchesResponse;->copy(I Ljava/lang/String; Lcom/bytedance/trae/conversation/network/ListBranchesData;)Lcom/bytedance/trae/conversation/network/ListBranchesResponse;
    move-result-object v0
    return-object v0
.end method

.method public final component1()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/network/ListBranchesResponse;->code I
    return v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/ListBranchesResponse;->message Ljava/lang/String;
    return-object v0
.end method

.method public final component3()com.bytedance.trae.conversation.network.ListBranchesData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/ListBranchesResponse;->data Lcom/bytedance/trae/conversation/network/ListBranchesData;
    return-object v0
.end method

.method public final copy(int  java.lang.String  com.bytedance.trae.conversation.network.ListBranchesData)com.bytedance.trae.conversation.network.ListBranchesResponse
    .registers 5
    # ins_size=4
    new-instance v0, Lcom/bytedance/trae/conversation/network/ListBranchesResponse;
    invoke-direct v0, v2, v3, v4, Lcom/bytedance/trae/conversation/network/ListBranchesResponse;-><init>(I Ljava/lang/String; Lcom/bytedance/trae/conversation/network/ListBranchesData;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/network/ListBranchesResponse;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/network/ListBranchesResponse;
    iget v1, v4, Lcom/bytedance/trae/conversation/network/ListBranchesResponse;->code I
    iget v3, v5, Lcom/bytedance/trae/conversation/network/ListBranchesResponse;->code I
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/network/ListBranchesResponse;->message Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/network/ListBranchesResponse;->message Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/network/ListBranchesResponse;->data Lcom/bytedance/trae/conversation/network/ListBranchesData;
    iget-object v5, v5, Lcom/bytedance/trae/conversation/network/ListBranchesResponse;->data Lcom/bytedance/trae/conversation/network/ListBranchesData;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getCode()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/network/ListBranchesResponse;->code I
    return v0
.end method

.method public final getData()com.bytedance.trae.conversation.network.ListBranchesData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/ListBranchesResponse;->data Lcom/bytedance/trae/conversation/network/ListBranchesData;
    return-object v0
.end method

.method public final getMessage()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/ListBranchesResponse;->message Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget v0, v3, Lcom/bytedance/trae/conversation/network/ListBranchesResponse;->code I
    invoke-static v0, Ljava/lang/Integer;->hashCode(I)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/network/ListBranchesResponse;->message Ljava/lang/String;
    const/4 v2, 0
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/network/ListBranchesResponse;->data Lcom/bytedance/trae/conversation/network/ListBranchesData;
    if-nez v1, +003h
    goto +5h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/network/ListBranchesData;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "ListBranchesResponse(code="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget v1, v2, Lcom/bytedance/trae/conversation/network/ListBranchesResponse;->code I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", message="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/network/ListBranchesResponse;->message Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", data="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/network/ListBranchesResponse;->data Lcom/bytedance/trae/conversation/network/ListBranchesData;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
