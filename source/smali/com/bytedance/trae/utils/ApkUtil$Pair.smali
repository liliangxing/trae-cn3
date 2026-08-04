# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/utils/ApkUtil$Pair;
.super Ljava/lang/Object;
.source "ApkUtil.java"

.field private final mFirst:Ljava/lang/Object;
.field private final mSecond:Ljava/lang/Object;


.method private constructor <init>(java.lang.Object  java.lang.Object)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/utils/ApkUtil$Pair;->mFirst Ljava/lang/Object;
    iput-object v2, v0, Lcom/bytedance/trae/utils/ApkUtil$Pair;->mSecond Ljava/lang/Object;
    return-void 
.end method

.method public static of(java.lang.Object  java.lang.Object)com.bytedance.trae.utils.ApkUtil$Pair
    .registers 3
    # ins_size=2
    new-instance v0, Lcom/bytedance/trae/utils/ApkUtil$Pair;
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/utils/ApkUtil$Pair;-><init>(Ljava/lang/Object; Ljava/lang/Object;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    const/4 v1, 0
    if-nez v5, +003h
    return v1
    invoke-virtual v4, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v2
    invoke-virtual v5, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v3
    if-eq v2, v3, +003h
    return v1
    check-cast v5, Lcom/bytedance/trae/utils/ApkUtil$Pair;
    iget-object v2, v4, Lcom/bytedance/trae/utils/ApkUtil$Pair;->mFirst Ljava/lang/Object;
    if-nez v2, +007h
    iget-object v2, v5, Lcom/bytedance/trae/utils/ApkUtil$Pair;->mFirst Ljava/lang/Object;
    if-eqz v2, +00ch
    return v1
    iget-object v3, v5, Lcom/bytedance/trae/utils/ApkUtil$Pair;->mFirst Ljava/lang/Object;
    invoke-virtual v2, v3, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +003h
    return v1
    iget-object v2, v4, Lcom/bytedance/trae/utils/ApkUtil$Pair;->mSecond Ljava/lang/Object;
    if-nez v2, +007h
    iget-object v5, v5, Lcom/bytedance/trae/utils/ApkUtil$Pair;->mSecond Ljava/lang/Object;
    if-eqz v5, +00ch
    return v1
    iget-object v5, v5, Lcom/bytedance/trae/utils/ApkUtil$Pair;->mSecond Ljava/lang/Object;
    invoke-virtual v2, v5, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v1
    return v0
.end method

.method public getFirst()java.lang.Object
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/utils/ApkUtil$Pair;->mFirst Ljava/lang/Object;
    return-object v0
.end method

.method public getSecond()java.lang.Object
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/utils/ApkUtil$Pair;->mSecond Ljava/lang/Object;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/utils/ApkUtil$Pair;->mFirst Ljava/lang/Object;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Ljava/lang/Object;->hashCode()I
    move-result v0
    const/16 v2, 31
    add-int/2addr v0, v2
    mul-int/2addr v0, v2
    iget-object v2, v3, Lcom/bytedance/trae/utils/ApkUtil$Pair;->mSecond Ljava/lang/Object;
    if-nez v2, +003h
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method
