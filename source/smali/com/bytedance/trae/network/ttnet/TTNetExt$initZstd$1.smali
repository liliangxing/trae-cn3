# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/network/ttnet/TTNetExt$initZstd$1;
.super Ljava/lang/Object;
.source "TTNetExt.kt"

.implements Lcom/bytedance/retrofit2/mime/TTRequestCompressManager$AddZstdCompressCallback;


.method constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public compress(byte[]  int)byte[]
    .registers 4
    # ins_size=3
    const-string/jumbo v0, src
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v2, v3, Lcom/bytedance/compression/zstd/ZstdCompress;->compress([B I)[B
    move-result-object v2
    return-object v2
    const/4 v2, 0
    return-object v2
    :try_start_0x6
.end method

.method public decompress(byte[]  int)byte[]
    .registers 4
    # ins_size=3
    const-string/jumbo v0, src
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v2, v3, Lcom/bytedance/compression/zstd/ZstdDecompress;->decompress([B I)[B
    move-result-object v2
    return-object v2
    const/4 v2, 0
    return-object v2
    :try_start_0x6
.end method
