# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffError$ApiError;
.super Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffError;
.source "MergeDiffManager.kt"

.field private final cause:Ljava/lang/Throwable;
.field private final message:Ljava/lang/String;


.method public constructor <init>(java.lang.String  java.lang.Throwable)void
    .registers 4
    # ins_size=3
    const-string v0, "message"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 0
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffError;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffError$ApiError;->message Ljava/lang/String;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffError$ApiError;->cause Ljava/lang/Throwable;
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.products.MergeDiffManager$MergeDiffError$ApiError  java.lang.String  java.lang.Throwable  int  java.lang.Object)com.bytedance.trae.conversation.products.MergeDiffManager$MergeDiffError$ApiError
    .registers 5
    # ins_size=5
    and-int/lit8 v4, v3, 1
    if-eqz v4, +004h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffError$ApiError;->message Ljava/lang/String;
    and-int/lit8 v3, v3, 2
    if-eqz v3, +004h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffError$ApiError;->cause Ljava/lang/Throwable;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffError$ApiError;->copy(Ljava/lang/String; Ljava/lang/Throwable;)Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffError$ApiError;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffError$ApiError;->message Ljava/lang/String;
    return-object v0
.end method

.method public final component2()java.lang.Throwable
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffError$ApiError;->cause Ljava/lang/Throwable;
    return-object v0
.end method

.method public final copy(java.lang.String  java.lang.Throwable)com.bytedance.trae.conversation.products.MergeDiffManager$MergeDiffError$ApiError
    .registers 4
    # ins_size=3
    const-string v0, "message"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffError$ApiError;
    invoke-direct v0, v2, v3, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffError$ApiError;-><init>(Ljava/lang/String; Ljava/lang/Throwable;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffError$ApiError;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffError$ApiError;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffError$ApiError;->message Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffError$ApiError;->message Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffError$ApiError;->cause Ljava/lang/Throwable;
    iget-object v5, v5, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffError$ApiError;->cause Ljava/lang/Throwable;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getCause()java.lang.Throwable
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffError$ApiError;->cause Ljava/lang/Throwable;
    return-object v0
.end method

.method public final getMessage()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffError$ApiError;->message Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffError$ApiError;->message Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffError$ApiError;->cause Ljava/lang/Throwable;
    if-nez v1, +004h
    const/4 v1, 0
    goto +5h
    invoke-virtual v1, Ljava/lang/Throwable;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "ApiError(message="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffError$ApiError;->message Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", cause="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffError$ApiError;->cause Ljava/lang/Throwable;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
