# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec;
.super Ljava/lang/Object;
.source "ArtifactCodec.kt"

.field public static final $stable:I
.field public static final INSTANCE:Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec;
.field private static final magicV1:[B
.field private static final magicV2:[B
.field private static final magicV2WithZeroPrefix:[B
.field private static final xorKeyV2:[B


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec;
    invoke-direct v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec;-><init>()V
    sput-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec;->INSTANCE Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec;
    const/4 v0, 4
    new-array v1, v0, [B
    fill-array-data v1, +0000022h
    sput-object v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec;->magicV1 [B
    new-array v0, v0, [B
    fill-array-data v0, +0000021h
    sput-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec;->magicV2 [B
    const/16 v0, 8
    new-array v1, v0, [B
    fill-array-data v1, +000001eh
    sput-object v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec;->magicV2WithZeroPrefix [B
    const/16 v1, 37
    new-array v1, v1, [B
    fill-array-data v1, +000001dh
    sput-object v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec;->xorKeyV2 [B
    sput v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec;->$stable I
    return-void 
    nop 
    fill-array-data-payload b'\x86\xae\xc6\x1b' | \x86\xae\xc6\x1b
    fill-array-data-payload b'\x1b\xc6\xae\x86' | \x1b\xc6\xae\x86
    fill-array-data-payload b'\x00\x00\x00\x00\x1b\xc6\xae\x86' | \x00\x00\x00\x00\x1b\xc6\xae\x86
    fill-array-data-payload b'\xea\x9f\xba\xc6\x95\xc9\x85\xea\x9d\x89 \xe1\xb5\xbb\xc2\xa7 \xea\x9d\x89\xc6\x95\xe2\x82\xac \xc3\x9f\xe2\x82\xac\xc2\xa7\xea\x9d\x89!\x00' | \xea\x9f\xba\xc6\x95\xc9\x85\xea\x9d\x89\x20\xe1\xb5\xbb\xc2\xa7\x20\xea\x9d\x89\xc6\x95\xe2\x82\xac\x20\xc3\x9f\xe2\x82\xac\xc2\xa7\xea\x9d\x89\x21\x00
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static final synthetic access$getMagicV1$p()byte[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec;->magicV1 [B
    return-object v0
.end method

.method public static final synthetic access$getMagicV2$p()byte[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec;->magicV2 [B
    return-object v0
.end method

.method public static final synthetic access$getMagicV2WithZeroPrefix$p()byte[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec;->magicV2WithZeroPrefix [B
    return-object v0
.end method

.method public static final synthetic access$getXorKeyV2$p()byte[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec;->xorKeyV2 [B
    return-object v0
.end method

.method public final decode(byte[])byte[]
    .registers 3
    # ins_size=2
    const-string v0, "bytes"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Decoder;
    invoke-direct v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Decoder;-><init>()V
    invoke-virtual v0, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Decoder;->decode([B)[B
    move-result-object v2
    invoke-virtual v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Decoder;->finish()[B
    move-result-object v0
    invoke-static v2, v0, Lkotlin/collections/ArraysKt;->plus([B [B)[B
    move-result-object v2
    return-object v2
.end method

.method public final encodeV1ForTest(byte[])byte[]
    .registers 3
    # ins_size=2
    const-string v0, "bytes"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec;->magicV1 [B
    invoke-static v0, v2, Lkotlin/collections/ArraysKt;->plus([B [B)[B
    move-result-object v2
    return-object v2
.end method

.method public final encodeV2ForTest(byte[])byte[]
    .registers 11
    # ins_size=2
    const-string v0, "bytes"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec;->magicV2 [B
    new-instance v1, Ljava/util/ArrayList;
    array-length v2, v10
    invoke-direct v1, v2, Ljava/util/ArrayList;-><init>(I)V
    check-cast v1, Ljava/util/Collection;
    array-length v2, v10
    const/4 v3, 0
    move v4, v3
    if-ge v3, v2, +019h
    aget-byte v5, v10, v3
    add-int/lit8 v6, v4, 1
    sget-object v7, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec;->xorKeyV2 [B
    array-length v8, v7
    rem-int/2addr v4, v8
    aget-byte v4, v7, v4
    xor-int/2addr v4, v5
    int-to-byte v4, v4
    invoke-static v4, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;
    move-result-object v4
    invoke-interface v1, v4, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    add-int/lit8 v3, v3, 1
    move v4, v6
    goto -18h
    check-cast v1, Ljava/util/List;
    check-cast v1, Ljava/util/Collection;
    invoke-static v1, Lkotlin/collections/CollectionsKt;->toByteArray(Ljava/util/Collection;)[B
    move-result-object v10
    invoke-static v0, v10, Lkotlin/collections/ArraysKt;->plus([B [B)[B
    move-result-object v10
    return-object v10
.end method
