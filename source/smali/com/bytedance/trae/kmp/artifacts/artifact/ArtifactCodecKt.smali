# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodecKt;
.super Ljava/lang/Object;
.source "ArtifactCodec.kt"


.method public static final synthetic access$startsWith(byte[]  byte[])boolean
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodecKt;->startsWith([B [B)Z
    move-result v0
    return v0
.end method

.method private static final startsWith(byte[]  byte[])boolean
    .registers 7
    # ins_size=2
    array-length v0, v5
    array-length v1, v6
    const/4 v2, 0
    if-ge v0, v1, +003h
    return v2
    invoke-static v6, Lkotlin/collections/ArraysKt;->getIndices([B)Lkotlin/ranges/IntRange;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    instance-of v1, v0, Ljava/util/Collection;
    const/4 v3, 1
    if-eqz v1, +00dh
    move-object v1, v0
    check-cast v1, Ljava/util/Collection;
    invoke-interface v1, Ljava/util/Collection;->isEmpty()Z
    move-result v1
    if-eqz v1, +004h
    move v2, v3
    goto +1dh
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, -00ah
    move-object v1, v0
    check-cast v1, Lkotlin/collections/IntIterator;
    invoke-virtual v1, Lkotlin/collections/IntIterator;->nextInt()I
    move-result v1
    aget-byte v4, v5, v1
    aget-byte v1, v6, v1
    if-ne v4, v1, +004h
    move v1, v3
    goto +2h
    move v1, v2
    if-nez v1, -016h
    return v2
.end method
