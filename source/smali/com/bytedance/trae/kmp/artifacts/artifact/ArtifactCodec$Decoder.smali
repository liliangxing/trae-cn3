# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Decoder;
.super Ljava/lang/Object;
.source "ArtifactCodec.kt"

.field public static final $stable:I
.field private mode:Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Mode;
.field private payloadOffset:I
.field private pendingHeader:[B


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    const/4 v0, 0
    new-array v0, v0, [B
    iput-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Decoder;->pendingHeader [B
    return-void 
.end method

.method private final detectMode(byte[])com.bytedance.trae.kmp.artifacts.artifact.ArtifactCodec$Mode
    .registers 3
    # ins_size=2
    invoke-static Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec;->access$getMagicV2WithZeroPrefix$p()[B
    move-result-object v0
    invoke-static v2, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodecKt;->access$startsWith([B [B)Z
    move-result v0
    if-eqz v0, +005h
    sget-object v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Mode;->V2 Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Mode;
    goto +49h
    invoke-static Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec;->access$getMagicV2$p()[B
    move-result-object v0
    invoke-static v2, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodecKt;->access$startsWith([B [B)Z
    move-result v0
    if-eqz v0, +005h
    sget-object v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Mode;->V2 Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Mode;
    goto +3ch
    invoke-static Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec;->access$getMagicV1$p()[B
    move-result-object v0
    invoke-static v2, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodecKt;->access$startsWith([B [B)Z
    move-result v0
    if-eqz v0, +005h
    sget-object v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Mode;->V1 Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Mode;
    goto +2fh
    invoke-static Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec;->access$getMagicV2WithZeroPrefix$p()[B
    move-result-object v0
    invoke-static v0, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodecKt;->access$startsWith([B [B)Z
    move-result v0
    if-nez v0, +024h
    invoke-static Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec;->access$getMagicV2$p()[B
    move-result-object v0
    invoke-static v0, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodecKt;->access$startsWith([B [B)Z
    move-result v0
    if-nez v0, +01ah
    invoke-static Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec;->access$getMagicV1$p()[B
    move-result-object v0
    invoke-static v0, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodecKt;->access$startsWith([B [B)Z
    move-result v0
    if-eqz v0, +003h
    goto +eh
    array-length v2, v2
    invoke-static Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec;->access$getMagicV1$p()[B
    move-result-object v0
    array-length v0, v0
    if-lt v2, v0, +005h
    sget-object v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Mode;->Plain Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Mode;
    goto +5h
    const/4 v2, 0
    goto +3h
    sget-object v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Mode;->Waiting Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Mode;
    return-object v2
.end method

.method private final transform(byte[]  com.bytedance.trae.kmp.artifacts.artifact.ArtifactCodec$Mode)byte[]
    .registers 9
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Decoder$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v8, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Mode;->ordinal()I
    move-result v8
    aget v8, v0, v8
    const/4 v0, 1
    if-eq v8, v0, +050h
    const/4 v0, 2
    const/4 v1, 0
    if-eq v8, v0, +011h
    const/4 v0, 3
    if-eq v8, v0, +049h
    const/4 v7, 4
    if-ne v8, v7, +005h
    new-array v7, v1, [B
    goto +42h
    new-instance v7, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v7, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v7
    new-instance v8, Ljava/util/ArrayList;
    array-length v0, v7
    invoke-direct v8, v0, Ljava/util/ArrayList;-><init>(I)V
    check-cast v8, Ljava/util/Collection;
    array-length v0, v7
    move v2, v1
    if-ge v1, v0, +022h
    aget-byte v3, v7, v1
    add-int/lit8 v4, v2, 1
    iget v5, v6, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Decoder;->payloadOffset I
    add-int/2addr v5, v2
    invoke-static Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec;->access$getXorKeyV2$p()[B
    move-result-object v2
    array-length v2, v2
    rem-int/2addr v5, v2
    invoke-static Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec;->access$getXorKeyV2$p()[B
    move-result-object v2
    aget-byte v2, v2, v5
    xor-int/2addr v2, v3
    int-to-byte v2, v2
    invoke-static v2, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;
    move-result-object v2
    invoke-interface v8, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    add-int/lit8 v1, v1, 1
    move v2, v4
    goto -21h
    check-cast v8, Ljava/util/List;
    check-cast v8, Ljava/util/Collection;
    invoke-static v8, Lkotlin/collections/CollectionsKt;->toByteArray(Ljava/util/Collection;)[B
    move-result-object v8
    iget v0, v6, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Decoder;->payloadOffset I
    array-length v7, v7
    add-int/2addr v0, v7
    iput v0, v6, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Decoder;->payloadOffset I
    move-object v7, v8
    return-object v7
.end method

.method public final decode(byte[])byte[]
    .registers 6
    # ins_size=2
    const-string v0, "chunk"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    array-length v0, v5
    const/4 v1, 1
    const/4 v2, 0
    if-nez v0, +004h
    move v0, v1
    goto +2h
    move v0, v2
    if-eqz v0, +005h
    new-array v5, v2, [B
    return-object v5
    iget-object v0, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Decoder;->mode Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Mode;
    if-eqz v0, +007h
    invoke-direct v4, v5, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Decoder;->transform([B Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Mode;)[B
    move-result-object v5
    return-object v5
    iget-object v0, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Decoder;->pendingHeader [B
    invoke-static v0, v5, Lkotlin/collections/ArraysKt;->plus([B [B)[B
    move-result-object v5
    iput-object v5, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Decoder;->pendingHeader [B
    invoke-direct v4, v5, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Decoder;->detectMode([B)Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Mode;
    move-result-object v5
    if-nez v5, +01ah
    iget-object v5, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Decoder;->pendingHeader [B
    array-length v5, v5
    invoke-static Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec;->access$getMagicV2WithZeroPrefix$p()[B
    move-result-object v0
    array-length v0, v0
    if-ge v5, v0, +005h
    new-array v5, v2, [B
    goto +bh
    sget-object v5, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Mode;->Plain Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Mode;
    iput-object v5, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Decoder;->mode Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Mode;
    iget-object v5, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Decoder;->pendingHeader [B
    new-array v0, v2, [B
    iput-object v0, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Decoder;->pendingHeader [B
    return-object v5
    sget-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Mode;->Waiting Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Mode;
    if-ne v5, v0, +005h
    new-array v5, v2, [B
    return-object v5
    iput-object v5, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Decoder;->mode Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Mode;
    sget-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Decoder$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v5, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Mode;->ordinal()I
    move-result v3
    aget v0, v0, v3
    if-eq v0, v1, +02ch
    const/4 v1, 2
    if-eq v0, v1, +011h
    const/4 v1, 3
    if-eq v0, v1, +00ch
    const/4 v1, 4
    if-ne v0, v1, +003h
    goto +7h
    new-instance v5, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v5, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v5
    move v0, v2
    goto +1eh
    iget-object v0, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Decoder;->pendingHeader [B
    invoke-static Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec;->access$getMagicV2WithZeroPrefix$p()[B
    move-result-object v1
    invoke-static v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodecKt;->access$startsWith([B [B)Z
    move-result v0
    if-eqz v0, +008h
    invoke-static Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec;->access$getMagicV2WithZeroPrefix$p()[B
    move-result-object v0
    array-length v0, v0
    goto +ch
    invoke-static Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec;->access$getMagicV2$p()[B
    move-result-object v0
    array-length v0, v0
    goto +6h
    invoke-static Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec;->access$getMagicV1$p()[B
    move-result-object v0
    array-length v0, v0
    iget-object v1, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Decoder;->pendingHeader [B
    array-length v3, v1
    invoke-static v1, v0, v3, Lkotlin/collections/ArraysKt;->copyOfRange([B I I)[B
    move-result-object v0
    new-array v1, v2, [B
    iput-object v1, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Decoder;->pendingHeader [B
    invoke-direct v4, v0, v5, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Decoder;->transform([B Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Mode;)[B
    move-result-object v5
    return-object v5
.end method

.method public final finish()byte[]
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Decoder;->mode Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Mode;
    const/4 v1, 0
    if-nez v0, +00dh
    sget-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Mode;->Plain Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Mode;
    iput-object v0, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Decoder;->mode Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Mode;
    iget-object v0, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Decoder;->pendingHeader [B
    new-array v1, v1, [B
    iput-object v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Decoder;->pendingHeader [B
    return-object v0
    new-array v0, v1, [B
    return-object v0
.end method
