# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/utils/ApkUtil;
.super Ljava/lang/Object;
.source "ApkUtil.java"

.field public static final APK_CHANNEL_BLOCK_ID:I
.field public static final APK_SIGNATURE_SCHEME_V2_BLOCK_ID:I
.field public static final APK_SIG_BLOCK_MAGIC_HI:J
.field public static final APK_SIG_BLOCK_MAGIC_LO:J
.field private static final APK_SIG_BLOCK_MIN_SIZE:I
.field public static final APK_TRACE_INFO:I
.field public static final DEFAULT_CHARSET:Ljava/lang/String;
.field private static final UINT16_MAX_VALUE:I
.field private static final ZIP_EOCD_COMMENT_LENGTH_FIELD_OFFSET:I
.field private static final ZIP_EOCD_REC_MIN_SIZE:I
.field private static final ZIP_EOCD_REC_SIG:I


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private static checkByteOrderLittleEndian(java.nio.ByteBuffer)void
    .registers 2
    # ins_size=1
    invoke-virtual v1, Ljava/nio/ByteBuffer;->order()Ljava/nio/ByteOrder;
    move-result-object v1
    sget-object v0, Ljava/nio/ByteOrder;->LITTLE_ENDIAN Ljava/nio/ByteOrder;
    if-ne v1, v0, +003h
    return-void 
    new-instance v1, Ljava/lang/IllegalArgumentException;
    const-string v0, "ByteBuffer byte order must be little endian"
    invoke-direct v1, v0, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V
    throw v1
.end method

.method public static findApkSigningBlock(java.nio.channels.FileChannel)com.bytedance.trae.utils.ApkUtil$Pair
    .registers 3
    # ins_size=1
    invoke-static v2, Lcom/bytedance/trae/utils/ApkUtil;->findCentralDirStartOffset(Ljava/nio/channels/FileChannel;)J
    move-result-wide v0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/utils/ApkUtil;->findApkSigningBlock(Ljava/nio/channels/FileChannel; J)Lcom/bytedance/trae/utils/ApkUtil$Pair;
    move-result-object v2
    return-object v2
.end method

.method public static findApkSigningBlock(java.nio.channels.FileChannel  long)com.bytedance.trae.utils.ApkUtil$Pair
    .registers 9
    # ins_size=3
    const-wide/16 v0, 32
    cmp-long v0, v7, v0
    if-ltz v0, +0c7h
    const-wide/16 v0, 24
    sub-long v0, v7, v0
    invoke-virtual v6, v0, v1, Ljava/nio/channels/FileChannel;->position(J)Ljava/nio/channels/FileChannel;
    const/16 v0, 24
    invoke-static v0, Ljava/nio/ByteBuffer;->allocate(I)Ljava/nio/ByteBuffer;
    move-result-object v0
    invoke-virtual v6, v0, Ljava/nio/channels/FileChannel;->read(Ljava/nio/ByteBuffer;)I
    sget-object v1, Ljava/nio/ByteOrder;->LITTLE_ENDIAN Ljava/nio/ByteOrder;
    invoke-virtual v0, v1, Ljava/nio/ByteBuffer;->order(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    const/16 v1, 8
    invoke-virtual v0, v1, Ljava/nio/ByteBuffer;->getLong(I)J
    move-result-wide v1
    const-wide v3, 2334950737559900225
    cmp-long v1, v1, v3
    if-nez v1, +09bh
    const/16 v1, 16
    invoke-virtual v0, v1, Ljava/nio/ByteBuffer;->getLong(I)J
    move-result-wide v1
    const-wide v3, 3617552046287187010
    cmp-long v1, v1, v3
    if-nez v1, +08ch
    const/4 v1, 0
    invoke-virtual v0, v1, Ljava/nio/ByteBuffer;->getLong(I)J
    move-result-wide v2
    invoke-virtual v0, Ljava/nio/ByteBuffer;->capacity()I
    move-result v0
    int-to-long v4, v0
    cmp-long v0, v2, v4
    if-ltz v0, +069h
    const-wide/32 v4, 2147483639
    cmp-long v0, v2, v4
    if-gtz v0, +062h
    const-wide/16 v4, 8
    add-long/2addr v4, v2
    long-to-int v0, v4
    int-to-long v4, v0
    sub-long/2addr v7, v4
    const-wide/16 v4, 0
    cmp-long v4, v7, v4
    if-ltz v4, +041h
    invoke-virtual v6, v7, v8, Ljava/nio/channels/FileChannel;->position(J)Ljava/nio/channels/FileChannel;
    invoke-static v0, Ljava/nio/ByteBuffer;->allocate(I)Ljava/nio/ByteBuffer;
    move-result-object v0
    invoke-virtual v6, v0, Ljava/nio/channels/FileChannel;->read(Ljava/nio/ByteBuffer;)I
    sget-object v6, Ljava/nio/ByteOrder;->LITTLE_ENDIAN Ljava/nio/ByteOrder;
    invoke-virtual v0, v6, Ljava/nio/ByteBuffer;->order(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    invoke-virtual v0, v1, Ljava/nio/ByteBuffer;->getLong(I)J
    move-result-wide v4
    cmp-long v6, v4, v2
    if-nez v6, +00bh
    invoke-static v7, v8, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v6
    invoke-static v0, v6, Lcom/bytedance/trae/utils/ApkUtil$Pair;->of(Ljava/lang/Object; Ljava/lang/Object;)Lcom/bytedance/trae/utils/ApkUtil$Pair;
    move-result-object v6
    return-object v6
    new-instance v6, Lcom/bytedance/trae/utils/ApkUtil$SignatureNotFoundException;
    new-instance v7, Ljava/lang/StringBuilder;
    const-string v8, "APK Signing Block sizes in header and footer do not match: "
    invoke-direct v7, v8, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v7, v4, v5, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v8, " vs "
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v2, v3, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    invoke-direct v6, v7, Lcom/bytedance/trae/utils/ApkUtil$SignatureNotFoundException;-><init>(Ljava/lang/String;)V
    throw v6
    new-instance v6, Lcom/bytedance/trae/utils/ApkUtil$SignatureNotFoundException;
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "APK Signing Block offset out of range: "
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v7, v8, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    invoke-direct v6, v7, Lcom/bytedance/trae/utils/ApkUtil$SignatureNotFoundException;-><init>(Ljava/lang/String;)V
    throw v6
    new-instance v6, Lcom/bytedance/trae/utils/ApkUtil$SignatureNotFoundException;
    new-instance v7, Ljava/lang/StringBuilder;
    const-string v8, "APK Signing Block size out of range: "
    invoke-direct v7, v8, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v7, v2, v3, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    invoke-direct v6, v7, Lcom/bytedance/trae/utils/ApkUtil$SignatureNotFoundException;-><init>(Ljava/lang/String;)V
    throw v6
    new-instance v6, Lcom/bytedance/trae/utils/ApkUtil$SignatureNotFoundException;
    const-string v7, "No APK Signing Block before ZIP Central Directory"
    invoke-direct v6, v7, Lcom/bytedance/trae/utils/ApkUtil$SignatureNotFoundException;-><init>(Ljava/lang/String;)V
    throw v6
    new-instance v6, Lcom/bytedance/trae/utils/ApkUtil$SignatureNotFoundException;
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "APK too small for APK Signing Block. ZIP Central Directory offset: "
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v7, v8, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    invoke-direct v6, v7, Lcom/bytedance/trae/utils/ApkUtil$SignatureNotFoundException;-><init>(Ljava/lang/String;)V
    throw v6
.end method

.method public static findCentralDirStartOffset(java.nio.channels.FileChannel)long
    .registers 3
    # ins_size=1
    invoke-static v2, Lcom/bytedance/trae/utils/ApkUtil;->getCommentLength(Ljava/nio/channels/FileChannel;)J
    move-result-wide v0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/utils/ApkUtil;->findCentralDirStartOffset(Ljava/nio/channels/FileChannel; J)J
    move-result-wide v0
    return-wide v0
.end method

.method public static findCentralDirStartOffset(java.nio.channels.FileChannel  long)long
    .registers 6
    # ins_size=3
    const/4 v0, 4
    invoke-static v0, Ljava/nio/ByteBuffer;->allocate(I)Ljava/nio/ByteBuffer;
    move-result-object v0
    sget-object v1, Ljava/nio/ByteOrder;->LITTLE_ENDIAN Ljava/nio/ByteOrder;
    invoke-virtual v0, v1, Ljava/nio/ByteBuffer;->order(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    invoke-virtual v3, Ljava/nio/channels/FileChannel;->size()J
    move-result-wide v1
    sub-long/2addr v1, v4
    const-wide/16 v4, 6
    sub-long/2addr v1, v4
    invoke-virtual v3, v1, v2, Ljava/nio/channels/FileChannel;->position(J)Ljava/nio/channels/FileChannel;
    invoke-virtual v3, v0, Ljava/nio/channels/FileChannel;->read(Ljava/nio/ByteBuffer;)I
    const/4 v3, 0
    invoke-virtual v0, v3, Ljava/nio/ByteBuffer;->getInt(I)I
    move-result v3
    int-to-long v3, v3
    return-wide v3
.end method

.method public static findIdStringValue(java.lang.String  int)java.lang.String
    .registers 5
    # ins_size=2
    invoke-static v3, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z
    move-result v0
    const/4 v1, 0
    if-eqz v0, +003h
    return-object v1
    new-instance v0, Ljava/io/RandomAccessFile;
    const-string/jumbo v2, r
    invoke-direct v0, v3, v2, Ljava/io/RandomAccessFile;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v0, Ljava/io/RandomAccessFile;->getChannel()Ljava/nio/channels/FileChannel;
    move-result-object v3
    invoke-static v3, Lcom/bytedance/trae/utils/ApkUtil;->findApkSigningBlock(Ljava/nio/channels/FileChannel;)Lcom/bytedance/trae/utils/ApkUtil$Pair;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/trae/utils/ApkUtil$Pair;->getFirst()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/nio/ByteBuffer;
    invoke-static v3, Lcom/bytedance/trae/utils/ApkUtil;->findIdValues(Ljava/nio/ByteBuffer;)Ljava/util/Map;
    move-result-object v3
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v2
    invoke-interface v3, v2, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +019h
    new-instance v2, Ljava/lang/String;
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    invoke-interface v3, v4, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/nio/ByteBuffer;
    invoke-static v3, Lcom/bytedance/trae/utils/ApkUtil;->getBytes(Ljava/nio/ByteBuffer;)[B
    move-result-object v3
    invoke-direct v2, v3, Ljava/lang/String;-><init>([B)V
    invoke-virtual v0, Ljava/io/RandomAccessFile;->close()V
    return-object v2
    invoke-virtual v0, Ljava/io/RandomAccessFile;->close()V
    goto +bh
    move-exception v3
    goto +3h
    move-exception v3
    move-object v0, v1
    invoke-virtual v3, Ljava/lang/Throwable;->printStackTrace()V
    if-eqz v0, +003h
    goto -dh
    return-object v1
    move-exception v3
    if-eqz v0, +005h
    invoke-virtual v0, Ljava/io/RandomAccessFile;->close()V
    throw v3
    :try_start_0x8
    :try_start_0x10
    :try_start_0x3f
    :try_start_0x43
    :try_start_0x4b
    :try_start_0x55
.end method

.method public static findIdValues(java.nio.ByteBuffer)java.util.Map
    .registers 11
    # ins_size=1
    invoke-static v10, Lcom/bytedance/trae/utils/ApkUtil;->checkByteOrderLittleEndian(Ljava/nio/ByteBuffer;)V
    invoke-virtual v10, Ljava/nio/ByteBuffer;->capacity()I
    move-result v0
    add-int/lit8 v0, v0, -24
    const/16 v1, 8
    invoke-static v10, v1, v0, Lcom/bytedance/trae/utils/ApkUtil;->sliceFromTo(Ljava/nio/ByteBuffer; I I)Ljava/nio/ByteBuffer;
    move-result-object v10
    new-instance v0, Ljava/util/LinkedHashMap;
    invoke-direct v0, Ljava/util/LinkedHashMap;-><init>()V
    const/4 v2, 0
    invoke-virtual v10, Ljava/nio/ByteBuffer;->hasRemaining()Z
    move-result v3
    if-eqz v3, +099h
    add-int/lit8 v2, v2, 1
    invoke-virtual v10, Ljava/nio/ByteBuffer;->remaining()I
    move-result v3
    if-lt v3, v1, +07ch
    invoke-virtual v10, Ljava/nio/ByteBuffer;->getLong()J
    move-result-wide v3
    const-wide/16 v5, 4
    cmp-long v5, v3, v5
    const-string v6, " size out of range: "
    const-string v7, "APK Signing Block entry #"
    if-ltz v5, +053h
    const-wide/32 v8, 2147483647
    cmp-long v5, v3, v8
    if-gtz v5, +04ch
    long-to-int v3, v3
    invoke-virtual v10, Ljava/nio/ByteBuffer;->position()I
    move-result v4
    add-int/2addr v4, v3
    invoke-virtual v10, Ljava/nio/ByteBuffer;->remaining()I
    move-result v5
    if-gt v3, v5, +017h
    invoke-virtual v10, Ljava/nio/ByteBuffer;->getInt()I
    move-result v5
    invoke-static v5, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    add-int/lit8 v3, v3, -4
    invoke-static v10, v3, Lcom/bytedance/trae/utils/ApkUtil;->getByteBuffer(Ljava/nio/ByteBuffer; I)Ljava/nio/ByteBuffer;
    move-result-object v3
    invoke-interface v0, v5, v3, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    invoke-virtual v10, v4, Ljava/nio/ByteBuffer;->position(I)Ljava/nio/Buffer;
    goto -43h
    new-instance v0, Lcom/bytedance/trae/utils/ApkUtil$SignatureNotFoundException;
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, v7, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", available: "
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v10, Ljava/nio/ByteBuffer;->remaining()I
    move-result v10
    invoke-virtual v1, v10, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v10
    invoke-direct v0, v10, Lcom/bytedance/trae/utils/ApkUtil$SignatureNotFoundException;-><init>(Ljava/lang/String;)V
    throw v0
    new-instance v10, Lcom/bytedance/trae/utils/ApkUtil$SignatureNotFoundException;
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, v7, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v3, v4, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-direct v10, v0, Lcom/bytedance/trae/utils/ApkUtil$SignatureNotFoundException;-><init>(Ljava/lang/String;)V
    throw v10
    new-instance v10, Lcom/bytedance/trae/utils/ApkUtil$SignatureNotFoundException;
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "Insufficient data to read size of APK Signing Block entry #"
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-direct v10, v0, Lcom/bytedance/trae/utils/ApkUtil$SignatureNotFoundException;-><init>(Ljava/lang/String;)V
    throw v10
    return-object v0
.end method

.method private static getByteBuffer(java.nio.ByteBuffer  int)java.nio.ByteBuffer
    .registers 5
    # ins_size=2
    if-ltz v4, +02fh
    invoke-virtual v3, Ljava/nio/ByteBuffer;->limit()I
    move-result v0
    invoke-virtual v3, Ljava/nio/ByteBuffer;->position()I
    move-result v1
    add-int/2addr v4, v1
    if-lt v4, v1, +01eh
    if-gt v4, v0, +01ch
    invoke-virtual v3, v4, Ljava/nio/ByteBuffer;->limit(I)Ljava/nio/Buffer;
    invoke-virtual v3, Ljava/nio/ByteBuffer;->slice()Ljava/nio/ByteBuffer;
    move-result-object v1
    invoke-virtual v3, Ljava/nio/ByteBuffer;->order()Ljava/nio/ByteOrder;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/nio/ByteBuffer;->order(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    invoke-virtual v3, v4, Ljava/nio/ByteBuffer;->position(I)Ljava/nio/Buffer;
    invoke-virtual v3, v0, Ljava/nio/ByteBuffer;->limit(I)Ljava/nio/Buffer;
    return-object v1
    move-exception v4
    invoke-virtual v3, v0, Ljava/nio/ByteBuffer;->limit(I)Ljava/nio/Buffer;
    throw v4
    new-instance v3, Ljava/nio/BufferUnderflowException;
    invoke-direct v3, Ljava/nio/BufferUnderflowException;-><init>()V
    throw v3
    new-instance v3, Ljava/lang/IllegalArgumentException;
    new-instance v0, Ljava/lang/StringBuilder;
    const-string/jumbo v1, size: 
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-direct v3, v4, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V
    throw v3
    :try_start_0x12
.end method

.method private static getBytes(java.nio.ByteBuffer)byte[]
    .registers 4
    # ins_size=1
    invoke-virtual v3, Ljava/nio/ByteBuffer;->array()[B
    move-result-object v0
    invoke-virtual v3, Ljava/nio/ByteBuffer;->arrayOffset()I
    move-result v1
    invoke-virtual v3, Ljava/nio/ByteBuffer;->position()I
    move-result v2
    add-int/2addr v2, v1
    invoke-virtual v3, Ljava/nio/ByteBuffer;->limit()I
    move-result v3
    add-int/2addr v1, v3
    invoke-static v0, v2, v1, Ljava/util/Arrays;->copyOfRange([B I I)[B
    move-result-object v3
    return-object v3
.end method

.method public static getCommentLength(java.nio.channels.FileChannel)long
    .registers 12
    # ins_size=1
    invoke-virtual v11, Ljava/nio/channels/FileChannel;->size()J
    move-result-wide v0
    const-wide/16 v2, 22
    cmp-long v4, v0, v2
    if-ltz v4, +052h
    sub-long/2addr v0, v2
    const-wide/32 v2, 65535
    invoke-static v0, v1, v2, v3, Ljava/lang/Math;->min(J J)J
    move-result-wide v2
    const/4 v4, 0
    move v5, v4
    int-to-long v6, v5
    cmp-long v8, v6, v2
    if-gtz v8, +03bh
    sub-long v6, v0, v6
    const/4 v8, 4
    invoke-static v8, Ljava/nio/ByteBuffer;->allocate(I)Ljava/nio/ByteBuffer;
    move-result-object v8
    invoke-virtual v11, v6, v7, Ljava/nio/channels/FileChannel;->position(J)Ljava/nio/channels/FileChannel;
    invoke-virtual v11, v8, Ljava/nio/channels/FileChannel;->read(Ljava/nio/ByteBuffer;)I
    sget-object v9, Ljava/nio/ByteOrder;->LITTLE_ENDIAN Ljava/nio/ByteOrder;
    invoke-virtual v8, v9, Ljava/nio/ByteBuffer;->order(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    invoke-virtual v8, v4, Ljava/nio/ByteBuffer;->getInt(I)I
    move-result v8
    const v9, 101010256
    if-ne v8, v9, +01dh
    const/4 v8, 2
    invoke-static v8, Ljava/nio/ByteBuffer;->allocate(I)Ljava/nio/ByteBuffer;
    move-result-object v8
    const-wide/16 v9, 20
    add-long/2addr v6, v9
    invoke-virtual v11, v6, v7, Ljava/nio/channels/FileChannel;->position(J)Ljava/nio/channels/FileChannel;
    invoke-virtual v11, v8, Ljava/nio/channels/FileChannel;->read(Ljava/nio/ByteBuffer;)I
    sget-object v6, Ljava/nio/ByteOrder;->LITTLE_ENDIAN Ljava/nio/ByteOrder;
    invoke-virtual v8, v6, Ljava/nio/ByteBuffer;->order(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    invoke-virtual v8, v4, Ljava/nio/ByteBuffer;->getShort(I)S
    move-result v6
    if-ne v6, v5, +004h
    int-to-long v0, v6
    return-wide v0
    add-int/lit8 v5, v5, 1
    goto -3dh
    new-instance v11, Ljava/io/IOException;
    const-string v0, "ZIP End of Central Directory (EOCD) record not found"
    invoke-direct v11, v0, Ljava/io/IOException;-><init>(Ljava/lang/String;)V
    throw v11
    new-instance v11, Ljava/io/IOException;
    const-string v0, "APK too small for ZIP End of Central Directory (EOCD) record"
    invoke-direct v11, v0, Ljava/io/IOException;-><init>(Ljava/lang/String;)V
    throw v11
.end method

.method private static sliceFromTo(java.nio.ByteBuffer  int  int)java.nio.ByteBuffer
    .registers 6
    # ins_size=3
    if-ltz v4, +07eh
    if-lt v5, v4, +05dh
    invoke-virtual v3, Ljava/nio/ByteBuffer;->capacity()I
    move-result v0
    invoke-virtual v3, Ljava/nio/ByteBuffer;->capacity()I
    move-result v1
    if-gt v5, v1, +034h
    invoke-virtual v3, Ljava/nio/ByteBuffer;->limit()I
    move-result v0
    invoke-virtual v3, Ljava/nio/ByteBuffer;->position()I
    move-result v1
    const/4 v2, 0
    invoke-virtual v3, v2, Ljava/nio/ByteBuffer;->position(I)Ljava/nio/Buffer;
    invoke-virtual v3, v5, Ljava/nio/ByteBuffer;->limit(I)Ljava/nio/Buffer;
    invoke-virtual v3, v4, Ljava/nio/ByteBuffer;->position(I)Ljava/nio/Buffer;
    invoke-virtual v3, Ljava/nio/ByteBuffer;->slice()Ljava/nio/ByteBuffer;
    move-result-object v4
    invoke-virtual v3, Ljava/nio/ByteBuffer;->order()Ljava/nio/ByteOrder;
    move-result-object v5
    invoke-virtual v4, v5, Ljava/nio/ByteBuffer;->order(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    invoke-virtual v3, v2, Ljava/nio/ByteBuffer;->position(I)Ljava/nio/Buffer;
    invoke-virtual v3, v0, Ljava/nio/ByteBuffer;->limit(I)Ljava/nio/Buffer;
    invoke-virtual v3, v1, Ljava/nio/ByteBuffer;->position(I)Ljava/nio/Buffer;
    return-object v4
    move-exception v4
    invoke-virtual v3, v2, Ljava/nio/ByteBuffer;->position(I)Ljava/nio/Buffer;
    invoke-virtual v3, v0, Ljava/nio/ByteBuffer;->limit(I)Ljava/nio/Buffer;
    invoke-virtual v3, v1, Ljava/nio/ByteBuffer;->position(I)Ljava/nio/Buffer;
    throw v4
    new-instance v3, Ljava/lang/IllegalArgumentException;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v1, "end > capacity: "
    invoke-direct v4, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v5, " > "
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v0, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-direct v3, v4, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V
    throw v3
    new-instance v3, Ljava/lang/IllegalArgumentException;
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "end < start: "
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v5, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v0, " < "
    invoke-virtual v5, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-direct v3, v4, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V
    throw v3
    new-instance v3, Ljava/lang/IllegalArgumentException;
    new-instance v5, Ljava/lang/StringBuilder;
    const-string/jumbo v0, start: 
    invoke-direct v5, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v5, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-direct v3, v4, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V
    throw v3
    :try_start_0x17
.end method
