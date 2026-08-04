# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/fileupload/ResourceUploadUtilKt;
.super Ljava/lang/Object;
.source "ResourceUploadUtil.kt"

.field private static final TRAE_MAGIC_NUMBER_V1:[B
.field private static final TRAE_MAGIC_NUMBER_V2:[B
.field private static final TRAE_MAGIC_NUMBER_V2_WITH_ZERO_PREFIX:[B
.field private static final TRAE_XOR_KEY_V2:[B


.method public static synthetic $r8$lambda$Nyvo22CI3abtTxWYDCJQLFb8D00(byte)java.lang.CharSequence
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/fileupload/ResourceUploadUtilKt;->calculateChecksums$lambda$1(B)Ljava/lang/CharSequence;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    const/4 v0, 4
    new-array v1, v0, [B
    fill-array-data v1, +000001fh
    sput-object v1, Lcom/bytedance/trae/conversation/fileupload/ResourceUploadUtilKt;->TRAE_MAGIC_NUMBER_V1 [B
    new-array v0, v0, [B
    fill-array-data v0, +000001eh
    sput-object v0, Lcom/bytedance/trae/conversation/fileupload/ResourceUploadUtilKt;->TRAE_MAGIC_NUMBER_V2 [B
    const/16 v0, 8
    new-array v0, v0, [B
    fill-array-data v0, +000001bh
    sput-object v0, Lcom/bytedance/trae/conversation/fileupload/ResourceUploadUtilKt;->TRAE_MAGIC_NUMBER_V2_WITH_ZERO_PREFIX [B
    const/16 v0, 37
    new-array v0, v0, [B
    fill-array-data v0, +000001ah
    sput-object v0, Lcom/bytedance/trae/conversation/fileupload/ResourceUploadUtilKt;->TRAE_XOR_KEY_V2 [B
    return-void 
    fill-array-data-payload b'\x86\xae\xc6\x1b' | \x86\xae\xc6\x1b
    fill-array-data-payload b'\x1b\xc6\xae\x86' | \x1b\xc6\xae\x86
    fill-array-data-payload b'\x00\x00\x00\x00\x1b\xc6\xae\x86' | \x00\x00\x00\x00\x1b\xc6\xae\x86
    fill-array-data-payload b'\xea\x9f\xba\xc6\x95\xc9\x85\xea\x9d\x89 \xe1\xb5\xbb\xc2\xa7 \xea\x9d\x89\xc6\x95\xe2\x82\xac \xc3\x9f\xe2\x82\xac\xc2\xa7\xea\x9d\x89!\x00' | \xea\x9f\xba\xc6\x95\xc9\x85\xea\x9d\x89\x20\xe1\xb5\xbb\xc2\xa7\x20\xea\x9d\x89\xc6\x95\xe2\x82\xac\x20\xc3\x9f\xe2\x82\xac\xc2\xa7\xea\x9d\x89\x21\x00
.end method

.method public static final calculateChecksums(java.io.File  boolean  boolean)com.bytedance.trae.conversation.fileupload.ContentChecksums
    .registers 19
    # ins_size=3
    move-object/from16 v0, v16
    const-string v1, "file"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v1, Ljava/util/zip/CRC32;
    invoke-direct v1, Ljava/util/zip/CRC32;-><init>()V
    const-string v2, "SHA-256"
    invoke-static v2, Ljava/security/MessageDigest;->getInstance(Ljava/lang/String;)Ljava/security/MessageDigest;
    move-result-object v2
    invoke-static/range v17 ... v18, Lcom/bytedance/trae/conversation/fileupload/ResourceUploadUtilKt;->getUploadMagicNumber(Z Z)[B
    move-result-object v3
    array-length v4, v3
    const/4 v5, 1
    const/4 v6, 0
    if-nez v4, +004h
    move v4, v5
    goto +2h
    move v4, v6
    xor-int/2addr v4, v5
    if-eqz v4, +008h
    invoke-virtual v1, v3, Ljava/util/zip/CRC32;->update([B)V
    invoke-virtual v2, v3, Ljava/security/MessageDigest;->update([B)V
    new-instance v4, Ljava/io/FileInputStream;
    invoke-direct v4, v0, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V
    check-cast v4, Ljava/io/Closeable;
    move-object v5, v4
    check-cast v5, Ljava/io/FileInputStream;
    const/16 v7, 8192
    new-array v7, v7, [B
    const-wide/16 v8, 0
    invoke-virtual v5, v7, Ljava/io/FileInputStream;->read([B)I
    move-result v10
    if-lez v10, +02bh
    if-eqz v18, +01ch
    if-eqz v17, +01ah
    move v11, v6
    if-ge v11, v10, +017h
    aget-byte v12, v7, v11
    sget-object v13, Lcom/bytedance/trae/conversation/fileupload/ResourceUploadUtilKt;->TRAE_XOR_KEY_V2 [B
    array-length v14, v13
    int-to-long v14, v14
    rem-long v14, v8, v14
    long-to-int v14, v14
    aget-byte v13, v13, v14
    xor-int/2addr v12, v13
    int-to-byte v12, v12
    aput-byte v12, v7, v11
    const-wide/16 v12, 1
    add-long/2addr v8, v12
    add-int/lit8 v11, v11, 1
    goto -16h
    invoke-virtual v1, v7, v6, v10, Ljava/util/zip/CRC32;->update([B I I)V
    invoke-virtual v2, v7, v6, v10, Ljava/security/MessageDigest;->update([B I I)V
    if-eqz v18, +004h
    if-nez v17, -02ah
    int-to-long v10, v10
    add-long/2addr v8, v10
    goto -2eh
    sget-object v5, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    const/4 v5, 0
    invoke-static v4, v5, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    invoke-virtual v1, Ljava/util/zip/CRC32;->getValue()J
    move-result-wide v4
    invoke-static v4, v5, Ljava/lang/Long;->toHexString(J)Ljava/lang/String;
    move-result-object v1
    invoke-virtual v2, Ljava/security/MessageDigest;->digest()[B
    move-result-object v4
    const-string v2, "digest(...)"
    invoke-static v4, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v2, ""
    move-object v5, v2
    check-cast v5, Ljava/lang/CharSequence;
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    new-instance v10, Lcom/bytedance/trae/conversation/fileupload/ResourceUploadUtilKt$$ExternalSyntheticLambda0;
    invoke-direct v10, Lcom/bytedance/trae/conversation/fileupload/ResourceUploadUtilKt$$ExternalSyntheticLambda0;-><init>()V
    const/16 v11, 30
    const/4 v12, 0
    invoke-static/range v4 ... v12, Lkotlin/collections/ArraysKt;->joinToString$default([B Ljava/lang/CharSequence; Ljava/lang/CharSequence; Ljava/lang/CharSequence; I Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v2
    invoke-virtual/range v16, Ljava/io/File;->length()J
    move-result-wide v4
    array-length v0, v3
    int-to-long v6, v0
    add-long/2addr v4, v6
    new-instance v0, Lcom/bytedance/trae/conversation/fileupload/ContentChecksums;
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v0, v1, v2, v4, v5, Lcom/bytedance/trae/conversation/fileupload/ContentChecksums;-><init>(Ljava/lang/String; Ljava/lang/String; J)V
    return-object v0
    move-exception v0
    move-object v1, v0
    throw v1
    move-exception v0
    move-object v2, v0
    invoke-static v4, v1, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    throw v2
    :try_start_0x2e
    :try_start_0xa4
.end method

.method public static synthetic calculateChecksums$default(java.io.File  boolean  boolean  int  java.lang.Object)com.bytedance.trae.conversation.fileupload.ContentChecksums
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 4
    if-eqz v3, +003h
    const/4 v2, 0
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/fileupload/ResourceUploadUtilKt;->calculateChecksums(Ljava/io/File; Z Z)Lcom/bytedance/trae/conversation/fileupload/ContentChecksums;
    move-result-object v0
    return-object v0
.end method

.method private static final calculateChecksums$lambda$1(byte)java.lang.CharSequence
    .registers 5
    # ins_size=1
    sget-object v0, Lkotlin/jvm/internal/StringCompanionObject;->INSTANCE Lkotlin/jvm/internal/StringCompanionObject;
    sget-object v0, Ljava/util/Locale;->US Ljava/util/Locale;
    const/4 v1, 1
    new-array v2, v1, [Ljava/lang/Object;
    const/4 v3, 0
    invoke-static v4, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;
    move-result-object v4
    aput-object v4, v2, v3
    invoke-static v2, v1, Ljava/util/Arrays;->copyOf([Ljava/lang/Object; I)[Ljava/lang/Object;
    move-result-object v4
    const-string v1, "%02x"
    invoke-static v0, v1, v4, Ljava/lang/String;->format(Ljava/util/Locale; Ljava/lang/String; [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v4
    const-string v0, "format(...)"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v4, Ljava/lang/CharSequence;
    return-object v4
.end method

.method public static final decodeContent(byte[])byte[]
    .registers 9
    # ins_size=1
    const-string v0, "encoded"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v8, Lcom/bytedance/trae/conversation/fileupload/ResourceUploadUtilKt;->findV2Magic([B)Lcom/bytedance/trae/conversation/fileupload/V2MagicMatch;
    move-result-object v0
    if-eqz v0, +022h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/fileupload/V2MagicMatch;->getPayloadOffset()I
    move-result v0
    array-length v1, v8
    invoke-static v8, v0, v1, Lkotlin/collections/ArraysKt;->copyOfRange([B I I)[B
    move-result-object v8
    array-length v0, v8
    const/4 v1, 0
    if-ge v1, v0, +014h
    aget-byte v2, v8, v1
    sget-object v3, Lcom/bytedance/trae/conversation/fileupload/ResourceUploadUtilKt;->TRAE_XOR_KEY_V2 [B
    int-to-long v4, v1
    array-length v6, v3
    int-to-long v6, v6
    rem-long/2addr v4, v6
    long-to-int v4, v4
    aget-byte v3, v3, v4
    xor-int/2addr v2, v3
    int-to-byte v2, v2
    aput-byte v2, v8, v1
    add-int/lit8 v1, v1, 1
    goto -13h
    return-object v8
    invoke-static v8, Lcom/bytedance/trae/conversation/fileupload/ResourceUploadUtilKt;->hasMagicNumberV1([B)Z
    move-result v0
    if-eqz v0, +006h
    invoke-static v8, Lcom/bytedance/trae/conversation/fileupload/ResourceUploadUtilKt;->stripMagicNumberV1([B)[B
    move-result-object v8
    return-object v8
.end method

.method private static final findV2Magic(byte[])com.bytedance.trae.conversation.fileupload.V2MagicMatch
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/fileupload/ResourceUploadUtilKt;->TRAE_MAGIC_NUMBER_V2_WITH_ZERO_PREFIX [B
    const/4 v1, 0
    invoke-static v3, v1, v0, Lcom/bytedance/trae/conversation/fileupload/ResourceUploadUtilKt;->hasMagicAt([B I [B)Z
    move-result v2
    if-eqz v2, +009h
    new-instance v3, Lcom/bytedance/trae/conversation/fileupload/V2MagicMatch;
    array-length v0, v0
    invoke-direct v3, v0, Lcom/bytedance/trae/conversation/fileupload/V2MagicMatch;-><init>(I)V
    return-object v3
    sget-object v0, Lcom/bytedance/trae/conversation/fileupload/ResourceUploadUtilKt;->TRAE_MAGIC_NUMBER_V2 [B
    invoke-static v3, v1, v0, Lcom/bytedance/trae/conversation/fileupload/ResourceUploadUtilKt;->hasMagicAt([B I [B)Z
    move-result v3
    if-eqz v3, +009h
    new-instance v3, Lcom/bytedance/trae/conversation/fileupload/V2MagicMatch;
    array-length v0, v0
    invoke-direct v3, v0, Lcom/bytedance/trae/conversation/fileupload/V2MagicMatch;-><init>(I)V
    return-object v3
    const/4 v3, 0
    return-object v3
.end method

.method public static final getTRAE_MAGIC_NUMBER_V1()byte[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/fileupload/ResourceUploadUtilKt;->TRAE_MAGIC_NUMBER_V1 [B
    return-object v0
.end method

.method public static final getTRAE_MAGIC_NUMBER_V2()byte[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/fileupload/ResourceUploadUtilKt;->TRAE_MAGIC_NUMBER_V2 [B
    return-object v0
.end method

.method public static final getTRAE_MAGIC_NUMBER_V2_WITH_ZERO_PREFIX()byte[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/fileupload/ResourceUploadUtilKt;->TRAE_MAGIC_NUMBER_V2_WITH_ZERO_PREFIX [B
    return-object v0
.end method

.method public static final getTRAE_XOR_KEY_V2()byte[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/fileupload/ResourceUploadUtilKt;->TRAE_XOR_KEY_V2 [B
    return-object v0
.end method

.method public static final getUploadMagicNumber(boolean  boolean)byte[]
    .registers 2
    # ins_size=2
    if-nez v0, +006h
    const/4 v0, 0
    new-array v0, v0, [B
    return-object v0
    if-eqz v1, +005h
    sget-object v0, Lcom/bytedance/trae/conversation/fileupload/ResourceUploadUtilKt;->TRAE_MAGIC_NUMBER_V2 [B
    goto +3h
    sget-object v0, Lcom/bytedance/trae/conversation/fileupload/ResourceUploadUtilKt;->TRAE_MAGIC_NUMBER_V1 [B
    return-object v0
.end method

.method private static final hasMagicAt(byte[]  int  byte[])boolean
    .registers 5
    # ins_size=3
    array-length v0, v2
    array-length v1, v4
    add-int/2addr v1, v3
    if-ge v0, v1, +004h
    const/4 v2, 0
    return v2
    array-length v0, v4
    add-int/2addr v0, v3
    invoke-static v2, v3, v0, Lkotlin/collections/ArraysKt;->copyOfRange([B I I)[B
    move-result-object v2
    invoke-static v2, v4, Ljava/util/Arrays;->equals([B [B)Z
    move-result v2
    return v2
.end method

.method public static final hasMagicNumberV1(byte[])boolean
    .registers 6
    # ins_size=1
    const-string v0, "content"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    array-length v0, v5
    sget-object v1, Lcom/bytedance/trae/conversation/fileupload/ResourceUploadUtilKt;->TRAE_MAGIC_NUMBER_V1 [B
    array-length v2, v1
    const/4 v3, 0
    if-ge v0, v2, +003h
    return v3
    array-length v0, v1
    move v1, v3
    if-ge v1, v0, +00eh
    aget-byte v2, v5, v1
    sget-object v4, Lcom/bytedance/trae/conversation/fileupload/ResourceUploadUtilKt;->TRAE_MAGIC_NUMBER_V1 [B
    aget-byte v4, v4, v1
    if-eq v2, v4, +003h
    return v3
    add-int/lit8 v1, v1, 1
    goto -dh
    const/4 v5, 1
    return v5
.end method

.method public static final stripMagicNumberV1(byte[])byte[]
    .registers 3
    # ins_size=1
    const-string v0, "content"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v2, Lcom/bytedance/trae/conversation/fileupload/ResourceUploadUtilKt;->hasMagicNumberV1([B)Z
    move-result v0
    if-nez v0, +003h
    return-object v2
    sget-object v0, Lcom/bytedance/trae/conversation/fileupload/ResourceUploadUtilKt;->TRAE_MAGIC_NUMBER_V1 [B
    array-length v0, v0
    array-length v1, v2
    invoke-static v2, v0, v1, Lkotlin/collections/ArraysKt;->copyOfRange([B I I)[B
    move-result-object v2
    return-object v2
.end method

.method public static final urlEncode(java.lang.String)java.lang.String
    .registers 2
    # ins_size=1
    const-string/jumbo v0, value
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "UTF-8"
    invoke-static v1, v0, Ljava/net/URLEncoder;->encode(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    const-string v0, "encode(...)"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v1
.end method
