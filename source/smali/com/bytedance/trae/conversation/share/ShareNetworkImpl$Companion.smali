# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/share/ShareNetworkImpl$Companion;
.super Ljava/lang/Object;
.source "ShareNetworkImpl.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/share/ShareNetworkImpl$Companion;-><init>()V
    return-void 
.end method

.method private final readStream(java.io.InputStream)java.lang.String
    .registers 6
    # ins_size=2
    const/16 v0, 1024
    new-array v0, v0, [B
    new-instance v1, Ljava/io/ByteArrayOutputStream;
    invoke-direct v1, Ljava/io/ByteArrayOutputStream;-><init>()V
    invoke-virtual v5, v0, Ljava/io/InputStream;->read([B)I
    move-result v2
    if-lez v2, +007h
    const/4 v3, 0
    invoke-virtual v1, v0, v3, v2, Ljava/io/ByteArrayOutputStream;->write([B I I)V
    goto -ah
    invoke-virtual v5, Ljava/io/InputStream;->close()V
    invoke-virtual v1, Ljava/io/ByteArrayOutputStream;->toByteArray()[B
    move-result-object v5
    const-string/jumbo v0, toByteArray(...)
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Ljava/lang/String;
    sget-object v1, Lkotlin/text/Charsets;->UTF_8 Ljava/nio/charset/Charset;
    invoke-direct v0, v5, v1, Ljava/lang/String;-><init>([B Ljava/nio/charset/Charset;)V
    return-object v0
.end method
