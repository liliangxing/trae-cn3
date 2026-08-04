# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/imageupload/ImageCompressor;
.super Ljava/lang/Object;
.source "ImageCompressor.kt"

.field private final cacheDir:Ljava/io/File;


.method public constructor <init>(java.io.File)void
    .registers 3
    # ins_size=2
    const-string v0, "cacheDir"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/imageupload/ImageCompressor;->cacheDir Ljava/io/File;
    return-void 
.end method

.method private final calculateOptimalDimensions(int  int  int)kotlin.Pair
    .registers 10
    # ins_size=4
    if-gt v7, v9, +011h
    if-gt v8, v9, +00fh
    invoke-static v7, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v7
    invoke-static v8, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v8
    invoke-static v7, v8, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v7
    return-object v7
    int-to-double v0, v9
    int-to-double v2, v7
    div-double v4, v0, v2
    int-to-double v7, v8
    div-double/2addr v0, v7
    invoke-static v4, v5, v0, v1, Ljava/lang/Math;->min(D D)D
    move-result-wide v0
    mul-double/2addr v2, v0
    invoke-static v2, v3, Lkotlin/math/MathKt;->roundToInt(D)I
    move-result v9
    mul-double/2addr v7, v0
    invoke-static v7, v8, Lkotlin/math/MathKt;->roundToInt(D)I
    move-result v7
    rem-int/lit8 v8, v9, 2
    const/4 v0, 1
    if-ne v8, v0, +004h
    add-int/lit8 v9, v9, 1
    rem-int/lit8 v8, v7, 2
    if-ne v8, v0, +004h
    add-int/lit8 v7, v7, 1
    invoke-static v9, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v8
    invoke-static v7, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v7
    invoke-static v8, v7, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v7
    return-object v7
.end method

.method public static synthetic compressIfNeeded$default(com.bytedance.trae.conversation.imageupload.ImageCompressor  java.io.File  com.bytedance.trae.conversation.imageupload.ImageDimension  com.bytedance.trae.conversation.imageupload.ImageCompressor$Config  int  java.lang.Object)com.bytedance.trae.conversation.imageupload.CompressionResult
    .registers 14
    # ins_size=6
    and-int/lit8 v12, v12, 4
    if-eqz v12, +010h
    new-instance v11, Lcom/bytedance/trae/conversation/imageupload/ImageCompressor$Config;
    const-wide/16 v1, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/16 v6, 15
    const/4 v7, 0
    move-object v0, v11
    invoke-direct/range v0 ... v7, Lcom/bytedance/trae/conversation/imageupload/ImageCompressor$Config;-><init>(J I F Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-virtual v8, v9, v10, v11, Lcom/bytedance/trae/conversation/imageupload/ImageCompressor;->compressIfNeeded(Ljava/io/File; Lcom/bytedance/trae/conversation/imageupload/ImageDimension; Lcom/bytedance/trae/conversation/imageupload/ImageCompressor$Config;)Lcom/bytedance/trae/conversation/imageupload/CompressionResult;
    move-result-object v8
    return-object v8
.end method

.method private final compressWithBinarySearch(android.graphics.Bitmap  android.graphics.Bitmap$CompressFormat  long  float)byte[]
    .registers 15
    # ins_size=6
    sget-object v0, Landroid/graphics/Bitmap$CompressFormat;->PNG Landroid/graphics/Bitmap$CompressFormat;
    const/4 v1, 0
    const/16 v2, 100
    if-ne v11, v0, +027h
    new-instance v12, Ljava/io/ByteArrayOutputStream;
    invoke-direct v12, Ljava/io/ByteArrayOutputStream;-><init>()V
    check-cast v12, Ljava/io/Closeable;
    move-object v13, v12
    check-cast v13, Ljava/io/ByteArrayOutputStream;
    move-object v14, v13
    check-cast v14, Ljava/io/OutputStream;
    invoke-virtual v10, v11, v2, v14, Landroid/graphics/Bitmap;->compress(Landroid/graphics/Bitmap$CompressFormat; I Ljava/io/OutputStream;)Z
    invoke-virtual v13, Ljava/io/ByteArrayOutputStream;->toByteArray()[B
    move-result-object v10
    invoke-static v12, v1, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    const-string/jumbo v11, use(...)
    invoke-static v10, v11, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v10
    move-exception v10
    throw v10
    move-exception v11
    invoke-static v12, v10, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    throw v11
    int-to-float v0, v2
    mul-float/2addr v14, v0
    float-to-int v14, v14
    const/4 v0, 0
    invoke-static v14, v0, v2, Lkotlin/ranges/RangesKt;->coerceIn(I I I)I
    move-result v14
    move-object v3, v1
    const/16 v4, 8
    if-ge v0, v4, +031h
    add-int v4, v14, v2
    div-int/lit8 v4, v4, 2
    new-instance v5, Ljava/io/ByteArrayOutputStream;
    invoke-direct v5, Ljava/io/ByteArrayOutputStream;-><init>()V
    check-cast v5, Ljava/io/Closeable;
    move-object v6, v5
    check-cast v6, Ljava/io/ByteArrayOutputStream;
    move-object v7, v6
    check-cast v7, Ljava/io/OutputStream;
    invoke-virtual v10, v11, v4, v7, Landroid/graphics/Bitmap;->compress(Landroid/graphics/Bitmap$CompressFormat; I Ljava/io/OutputStream;)Z
    invoke-virtual v6, Ljava/io/ByteArrayOutputStream;->toByteArray()[B
    move-result-object v6
    invoke-static v5, v1, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    array-length v5, v6
    int-to-long v7, v5
    cmp-long v5, v7, v12
    if-gtz v5, +005h
    move v14, v4
    move-object v3, v6
    goto +2h
    move v2, v4
    add-int/lit8 v0, v0, 1
    goto -2bh
    move-exception v10
    throw v10
    move-exception v11
    invoke-static v5, v10, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    throw v11
    if-eqz v3, +008h
    array-length v0, v3
    int-to-long v4, v0
    cmp-long v12, v4, v12
    if-lez v12, +019h
    new-instance v12, Ljava/io/ByteArrayOutputStream;
    invoke-direct v12, Ljava/io/ByteArrayOutputStream;-><init>()V
    check-cast v12, Ljava/io/Closeable;
    move-object v13, v12
    check-cast v13, Ljava/io/ByteArrayOutputStream;
    move-object v0, v13
    check-cast v0, Ljava/io/OutputStream;
    invoke-virtual v10, v11, v14, v0, Landroid/graphics/Bitmap;->compress(Landroid/graphics/Bitmap$CompressFormat; I Ljava/io/OutputStream;)Z
    invoke-virtual v13, Ljava/io/ByteArrayOutputStream;->toByteArray()[B
    move-result-object v3
    invoke-static v12, v1, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    return-object v3
    move-exception v10
    throw v10
    move-exception v11
    invoke-static v12, v10, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    throw v11
    :try_start_0xe
    :try_start_0x26
    :try_start_0x44
    :try_start_0x62
    :try_start_0x77
    :try_start_0x8c
.end method

.method private final decodeAndScale(java.io.File  int  int)android.graphics.Bitmap
    .registers 5
    # ins_size=4
    invoke-virtual v2, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;
    move-result-object v2
    invoke-static v2, Landroid/graphics/BitmapFactory;->decodeFile(Ljava/lang/String;)Landroid/graphics/Bitmap;
    move-result-object v2
    if-nez v2, +004h
    const/4 v2, 0
    return-object v2
    invoke-virtual v2, Landroid/graphics/Bitmap;->getWidth()I
    move-result v0
    if-ne v0, v3, +009h
    invoke-virtual v2, Landroid/graphics/Bitmap;->getHeight()I
    move-result v0
    if-ne v0, v4, +003h
    return-object v2
    const/4 v0, 1
    invoke-static v2, v3, v4, v0, Landroid/graphics/Bitmap;->createScaledBitmap(Landroid/graphics/Bitmap; I I Z)Landroid/graphics/Bitmap;
    move-result-object v3
    const-string v4, "createScaledBitmap(...)"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    if-eq v3, v2, +005h
    invoke-virtual v2, Landroid/graphics/Bitmap;->recycle()V
    return-object v3
.end method

.method public final compressIfNeeded(java.io.File  com.bytedance.trae.conversation.imageupload.ImageDimension  com.bytedance.trae.conversation.imageupload.ImageCompressor$Config)com.bytedance.trae.conversation.imageupload.CompressionResult
    .registers 23
    # ins_size=4
    move-object/from16 v7, v19
    move-object/from16 v0, v20
    const-string v8, "conv_img_upload_"
    const-string v1, "input"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "config"
    move-object/from16 v2, v22
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual/range v20, Ljava/io/File;->length()J
    move-result-wide v14
    if-nez v21, +009h
    sget-object v1, Lcom/bytedance/trae/conversation/imageupload/ImageValidation;->INSTANCE Lcom/bytedance/trae/conversation/imageupload/ImageValidation;
    invoke-virtual v1, v0, Lcom/bytedance/trae/conversation/imageupload/ImageValidation;->readImageDimension(Ljava/io/File;)Lcom/bytedance/trae/conversation/imageupload/ImageDimension;
    move-result-object v1
    goto +3h
    move-object/from16 v1, v21
    const-wide/32 v3, 1048576
    cmp-long v3, v14, v3
    const/4 v4, 0
    if-gtz v3, +013h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/imageupload/ImageDimension;->getWidth()I
    move-result v3
    const/16 v5, 2048
    if-gt v3, v5, +00bh
    invoke-virtual v1, Lcom/bytedance/trae/conversation/imageupload/ImageDimension;->getHeight()I
    move-result v3
    if-le v3, v5, +003h
    goto +3h
    move v3, v4
    goto +2h
    const/4 v3, 1
    if-nez v3, +016h
    new-instance v2, Lcom/bytedance/trae/conversation/imageupload/CompressionResult;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/imageupload/ImageDimension;->getWidth()I
    move-result v10
    invoke-virtual v1, Lcom/bytedance/trae/conversation/imageupload/ImageDimension;->getHeight()I
    move-result v11
    const/16 v16, 0
    move-object v8, v2
    move-object/from16 v9, v20
    move-wide v12, v14
    invoke-direct/range v8 ... v16, Lcom/bytedance/trae/conversation/imageupload/CompressionResult;-><init>(Ljava/io/File; I I J J Z)V
    return-object v2
    invoke-virtual v1, Lcom/bytedance/trae/conversation/imageupload/ImageDimension;->getWidth()I
    move-result v3
    invoke-virtual v1, Lcom/bytedance/trae/conversation/imageupload/ImageDimension;->getHeight()I
    move-result v1
    invoke-virtual/range v22, Lcom/bytedance/trae/conversation/imageupload/ImageCompressor$Config;->getMaxDimension()I
    move-result v5
    invoke-direct v7, v3, v1, v5, Lcom/bytedance/trae/conversation/imageupload/ImageCompressor;->calculateOptimalDimensions(I I I)Lkotlin/Pair;
    move-result-object v1
    invoke-virtual v1, Lkotlin/Pair;->component1()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/lang/Number;
    invoke-virtual v3, Ljava/lang/Number;->intValue()I
    move-result v11
    invoke-virtual v1, Lkotlin/Pair;->component2()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/Number;
    invoke-virtual v1, Ljava/lang/Number;->intValue()I
    move-result v12
    invoke-direct v7, v0, v11, v12, Lcom/bytedance/trae/conversation/imageupload/ImageCompressor;->decodeAndScale(Ljava/io/File; I I)Landroid/graphics/Bitmap;
    move-result-object v18
    if-eqz v18, +093h
    invoke-virtual/range v22, Lcom/bytedance/trae/conversation/imageupload/ImageCompressor$Config;->getPreserveFormat()Z
    move-result v1
    const/4 v9, 0
    const-string v10, ".png"
    if-eqz v1, +021h
    invoke-virtual/range v20, Ljava/io/File;->getName()Ljava/lang/String;
    move-result-object v0
    const-string v1, "getName(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v1, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v0, v1, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v0
    const-string/jumbo v1, toLowerCase(...)
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v1, 2
    invoke-static v0, v10, v4, v1, v9, Lkotlin/text/StringsKt;->endsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +005h
    sget-object v0, Landroid/graphics/Bitmap$CompressFormat;->PNG Landroid/graphics/Bitmap$CompressFormat;
    goto +3h
    sget-object v0, Landroid/graphics/Bitmap$CompressFormat;->JPEG Landroid/graphics/Bitmap$CompressFormat;
    invoke-virtual/range v22, Lcom/bytedance/trae/conversation/imageupload/ImageCompressor$Config;->getMaxSizeBytes()J
    move-result-wide v4
    invoke-virtual/range v22, Lcom/bytedance/trae/conversation/imageupload/ImageCompressor$Config;->getMinQuality()F
    move-result v6
    move-object/from16 v1, v19
    move-object/from16 v2, v18
    move-object v3, v0
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/imageupload/ImageCompressor;->compressWithBinarySearch(Landroid/graphics/Bitmap; Landroid/graphics/Bitmap$CompressFormat; J F)[B
    move-result-object v1
    sget-object v2, Landroid/graphics/Bitmap$CompressFormat;->PNG Landroid/graphics/Bitmap$CompressFormat;
    if-ne v0, v2, +003h
    goto +3h
    const-string v10, ".jpg"
    new-instance v0, Ljava/io/File;
    iget-object v2, v7, Lcom/bytedance/trae/conversation/imageupload/ImageCompressor;->cacheDir Ljava/io/File;
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, v8, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v4
    invoke-virtual v3, v4, v5, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-direct v0, v2, v3, Ljava/io/File;-><init>(Ljava/io/File; Ljava/lang/String;)V
    new-instance v2, Ljava/io/FileOutputStream;
    invoke-direct v2, v0, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V
    check-cast v2, Ljava/io/Closeable;
    move-object v3, v2
    check-cast v3, Ljava/io/FileOutputStream;
    invoke-virtual v3, v1, Ljava/io/FileOutputStream;->write([B)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v2, v9, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    new-instance v1, Lcom/bytedance/trae/conversation/imageupload/CompressionResult;
    invoke-virtual v0, Ljava/io/File;->length()J
    move-result-wide v2
    const/16 v17, 1
    move-object v9, v1
    move-object v10, v0
    move-wide v13, v14
    move-wide v15, v2
    invoke-direct/range v9 ... v17, Lcom/bytedance/trae/conversation/imageupload/CompressionResult;-><init>(Ljava/io/File; I I J J Z)V
    invoke-virtual/range v18, Landroid/graphics/Bitmap;->recycle()V
    return-object v1
    move-exception v0
    move-object v1, v0
    throw v1
    move-exception v0
    move-object v3, v0
    invoke-static v2, v1, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    throw v3
    move-exception v0
    invoke-virtual/range v18, Landroid/graphics/Bitmap;->recycle()V
    throw v0
    new-instance v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadException;
    sget-object v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;->COMPRESSION_FAILED Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    const-string v3, "Decode bitmap failed"
    const/4 v4, 0
    const/4 v5, 4
    const/4 v6, 0
    move-object v1, v0
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/imageupload/ImageUploadException;-><init>(Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode; Ljava/lang/String; Ljava/lang/Throwable; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    throw v0
    :try_start_0x7b
    :try_start_0x84
    :try_start_0xe0
    :try_start_0xe8
    :try_start_0x100
    :try_start_0x103
.end method
