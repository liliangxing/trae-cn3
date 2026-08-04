# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/products/GetArtifactListData;
.super Ljava/lang/Object;
.source "IGetArtifactListApi.kt"

.field private final artifacts:Ljava/util/List;
.field private final total:I


.method public constructor <init>()void
    .registers 4
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 3
    const/4 v2, 0
    invoke-direct v3, v2, v0, v1, v2, Lcom/bytedance/trae/conversation/products/GetArtifactListData;-><init>(Ljava/util/List; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(java.util.List  int)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/GetArtifactListData;->artifacts Ljava/util/List;
    iput v2, v0, Lcom/bytedance/trae/conversation/products/GetArtifactListData;->total I
    return-void 
.end method

.method public synthetic constructor <init>(java.util.List  int  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 5
    # ins_size=5
    and-int/lit8 v4, v3, 1
    if-eqz v4, +003h
    const/4 v1, 0
    and-int/lit8 v3, v3, 2
    if-eqz v3, +003h
    const/4 v2, 0
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/products/GetArtifactListData;-><init>(Ljava/util/List; I)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.products.GetArtifactListData  java.util.List  int  int  java.lang.Object)com.bytedance.trae.conversation.products.GetArtifactListData
    .registers 5
    # ins_size=5
    and-int/lit8 v4, v3, 1
    if-eqz v4, +004h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/products/GetArtifactListData;->artifacts Ljava/util/List;
    and-int/lit8 v3, v3, 2
    if-eqz v3, +004h
    iget v2, v0, Lcom/bytedance/trae/conversation/products/GetArtifactListData;->total I
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/GetArtifactListData;->copy(Ljava/util/List; I)Lcom/bytedance/trae/conversation/products/GetArtifactListData;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/GetArtifactListData;->artifacts Ljava/util/List;
    return-object v0
.end method

.method public final component2()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/products/GetArtifactListData;->total I
    return v0
.end method

.method public final copy(java.util.List  int)com.bytedance.trae.conversation.products.GetArtifactListData
    .registers 4
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/conversation/products/GetArtifactListData;
    invoke-direct v0, v2, v3, Lcom/bytedance/trae/conversation/products/GetArtifactListData;-><init>(Ljava/util/List; I)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/products/GetArtifactListData;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/products/GetArtifactListData;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/products/GetArtifactListData;->artifacts Ljava/util/List;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/products/GetArtifactListData;->artifacts Ljava/util/List;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/conversation/products/GetArtifactListData;->total I
    iget v5, v5, Lcom/bytedance/trae/conversation/products/GetArtifactListData;->total I
    if-eq v1, v5, +003h
    return v2
    return v0
.end method

.method public final getArtifacts()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/GetArtifactListData;->artifacts Ljava/util/List;
    return-object v0
.end method

.method public final getTotal()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/products/GetArtifactListData;->total I
    return v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/products/GetArtifactListData;->artifacts Ljava/util/List;
    if-nez v0, +004h
    const/4 v0, 0
    goto +5h
    invoke-virtual v0, Ljava/lang/Object;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/conversation/products/GetArtifactListData;->total I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "GetArtifactListData(artifacts="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/products/GetArtifactListData;->artifacts Ljava/util/List;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", total="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/conversation/products/GetArtifactListData;->total I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
