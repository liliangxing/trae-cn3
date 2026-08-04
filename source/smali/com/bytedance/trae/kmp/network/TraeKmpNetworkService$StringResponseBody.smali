# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/kmp/network/TraeKmpNetworkService$StringResponseBody;
.super Lcom/bytedance/kmp/network/response/ResponseBody;
.source "TraeKmpNetworkService.kt"

.field private final bytes:[B
.field private final content:Ljava/lang/String;


.method public constructor <init>(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string v0, "content"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Lcom/bytedance/kmp/network/response/ResponseBody;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/kmp/network/TraeKmpNetworkService$StringResponseBody;->content Ljava/lang/String;
    invoke-static v2, Lkotlin/text/StringsKt;->encodeToByteArray(Ljava/lang/String;)[B
    move-result-object v2
    iput-object v2, v1, Lcom/bytedance/trae/kmp/network/TraeKmpNetworkService$StringResponseBody;->bytes [B
    return-void 
.end method

.method public byteStream()okio.Source
    .registers 3
    # ins_size=1
    new-instance v0, Lokio/Buffer;
    invoke-direct v0, Lokio/Buffer;-><init>()V
    iget-object v1, v2, Lcom/bytedance/trae/kmp/network/TraeKmpNetworkService$StringResponseBody;->bytes [B
    invoke-virtual v0, v1, Lokio/Buffer;->write([B)Lokio/Buffer;
    move-result-object v0
    check-cast v0, Lokio/Source;
    return-object v0
.end method

.method public contentLength()long
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/kmp/network/TraeKmpNetworkService$StringResponseBody;->bytes [B
    array-length v0, v0
    int-to-long v0, v0
    return-wide v0
.end method

.method public contentType()java.lang.String
    .registers 2
    # ins_size=1
    const-string v0, "application/json; charset=UTF-8"
    return-object v0
.end method
