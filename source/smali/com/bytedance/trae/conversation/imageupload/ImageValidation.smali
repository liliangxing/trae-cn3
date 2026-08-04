# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/imageupload/ImageValidation;
.super Ljava/lang/Object;
.source "ImageValidation.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/imageupload/ImageValidation;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/imageupload/ImageValidation;
    invoke-direct v0, Lcom/bytedance/trae/conversation/imageupload/ImageValidation;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/imageupload/ImageValidation;->INSTANCE Lcom/bytedance/trae/conversation/imageupload/ImageValidation;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final readImageDimension(java.io.File)com.bytedance.trae.conversation.imageupload.ImageDimension
    .registers 10
    # ins_size=2
    const-string v0, "file"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Landroid/graphics/BitmapFactory$Options;
    invoke-direct v0, Landroid/graphics/BitmapFactory$Options;-><init>()V
    const/4 v1, 1
    iput-boolean v1, v0, Landroid/graphics/BitmapFactory$Options;->inJustDecodeBounds Z
    invoke-virtual v9, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;
    move-result-object v9
    invoke-static v9, v0, Landroid/graphics/BitmapFactory;->decodeFile(Ljava/lang/String; Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    iget v9, v0, Landroid/graphics/BitmapFactory$Options;->outWidth I
    iget v0, v0, Landroid/graphics/BitmapFactory$Options;->outHeight I
    if-lez v9, +00ah
    if-lez v0, +008h
    new-instance v1, Lcom/bytedance/trae/conversation/imageupload/ImageDimension;
    invoke-direct v1, v9, v0, Lcom/bytedance/trae/conversation/imageupload/ImageDimension;-><init>(I I)V
    return-object v1
    new-instance v9, Lcom/bytedance/trae/conversation/imageupload/ImageUploadException;
    sget-object v3, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;->INVALID_FORMAT Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    const-string v4, "Cannot decode image bounds"
    const/4 v5, 0
    const/4 v6, 4
    const/4 v7, 0
    move-object v2, v9
    invoke-direct/range v2 ... v7, Lcom/bytedance/trae/conversation/imageupload/ImageUploadException;-><init>(Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode; Ljava/lang/String; Ljava/lang/Throwable; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    throw v9
.end method

.method public final validateDimension(int  int)com.bytedance.trae.conversation.imageupload.FileValidationResult
    .registers 10
    # ins_size=3
    const/4 v0, 0
    const/16 v1, 14
    if-le v8, v1, +04ch
    if-gt v9, v1, +003h
    goto +48h
    int-to-long v1, v8
    int-to-long v3, v9
    mul-long/2addr v1, v3
    const-wide/16 v3, 196
    cmp-long v3, v1, v3
    if-ltz v3, +036h
    const-wide/32 v3, 36000000
    cmp-long v1, v1, v3
    if-lez v1, +003h
    goto +2dh
    int-to-double v1, v8
    int-to-double v8, v9
    div-double/2addr v1, v8
    const-wide v8, 4574336165517728591
    cmpg-double v8, v1, v8
    if-ltz v8, +018h
    const-wide v8, 4639481672377565184
    cmpl-double v8, v1, v8
    if-lez v8, +003h
    goto +dh
    new-instance v8, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;
    const/4 v2, 1
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 6
    const/4 v6, 0
    move-object v1, v8
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;-><init>(Z Ljava/lang/String; Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v8
    new-instance v8, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;
    const-string v9, "Image aspect ratio out of range"
    sget-object v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;->ASPECT_RATIO_INVALID Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    invoke-direct v8, v0, v9, v1, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;-><init>(Z Ljava/lang/String; Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;)V
    return-object v8
    new-instance v8, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;
    const-string v9, "Image pixel count out of range"
    sget-object v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;->PIXEL_COUNT_INVALID Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    invoke-direct v8, v0, v9, v1, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;-><init>(Z Ljava/lang/String; Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;)V
    return-object v8
    new-instance v8, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;
    const-string v9, "Image dimensions too small"
    sget-object v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;->DIMENSION_TOO_SMALL Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    invoke-direct v8, v0, v9, v1, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;-><init>(Z Ljava/lang/String; Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;)V
    return-object v8
.end method

.method public final validateFile(java.io.File)kotlin.Pair
    .registers 9
    # ins_size=2
    const-string v0, "file"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v7, v8, Lcom/bytedance/trae/conversation/imageupload/ImageValidation;->validateFileFormat(Ljava/io/File;)Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;->getValid()Z
    move-result v1
    const/4 v2, 0
    if-nez v1, +007h
    invoke-static v0, v2, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v8
    return-object v8
    invoke-virtual v7, v8, Lcom/bytedance/trae/conversation/imageupload/ImageValidation;->validateFileSize(Ljava/io/File;)Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;->getValid()Z
    move-result v1
    if-nez v1, +007h
    invoke-static v0, v2, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v8
    return-object v8
    invoke-virtual v7, v8, Lcom/bytedance/trae/conversation/imageupload/ImageValidation;->readImageDimension(Ljava/io/File;)Lcom/bytedance/trae/conversation/imageupload/ImageDimension;
    move-result-object v8
    invoke-virtual v8, Lcom/bytedance/trae/conversation/imageupload/ImageDimension;->getWidth()I
    move-result v0
    invoke-virtual v8, Lcom/bytedance/trae/conversation/imageupload/ImageDimension;->getHeight()I
    move-result v1
    invoke-virtual v7, v0, v1, Lcom/bytedance/trae/conversation/imageupload/ImageValidation;->validateDimension(I I)Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;->getValid()Z
    move-result v1
    if-nez v1, +007h
    invoke-static v0, v8, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v8
    return-object v8
    new-instance v6, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;
    const/4 v1, 1
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 6
    const/4 v5, 0
    move-object v0, v6
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;-><init>(Z Ljava/lang/String; Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-static v6, v8, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v8
    return-object v8
    new-instance v8, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;
    const-string v0, "Cannot read image dimension"
    sget-object v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;->INVALID_FORMAT Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    const/4 v3, 0
    invoke-direct v8, v3, v0, v1, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;-><init>(Z Ljava/lang/String; Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;)V
    invoke-static v8, v2, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v8
    return-object v8
    :try_start_0x24
.end method

.method public final validateFileFormat(java.io.File)com.bytedance.trae.conversation.imageupload.FileValidationResult
    .registers 11
    # ins_size=2
    const-string v0, "file"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v10, Ljava/io/File;->getName()Ljava/lang/String;
    move-result-object v10
    const-string v0, "getName(...)"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v10, v0, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v10
    const-string/jumbo v0, toLowerCase(...)
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v1, v10
    check-cast v1, Ljava/lang/CharSequence;
    const/16 v2, 46
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 6
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlin/text/StringsKt;->lastIndexOf$default(Ljava/lang/CharSequence; C I Z I Ljava/lang/Object;)I
    move-result v0
    if-ltz v0, +00dh
    invoke-virtual v10, v0, Ljava/lang/String;->substring(I)Ljava/lang/String;
    move-result-object v10
    const-string/jumbo v0, substring(...)
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +3h
    const-string v10, ""
    sget-object v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadConstants;->INSTANCE Lcom/bytedance/trae/conversation/imageupload/ImageUploadConstants;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadConstants;->getACCEPTED_EXTENSIONS()Ljava/util/Set;
    move-result-object v0
    invoke-interface v0, v10, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v10
    if-nez v10, +00dh
    new-instance v10, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;
    const-string v0, "Unsupported image format"
    sget-object v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;->INVALID_FORMAT Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    const/4 v2, 0
    invoke-direct v10, v2, v0, v1, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;-><init>(Z Ljava/lang/String; Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;)V
    return-object v10
    new-instance v10, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;
    const/4 v4, 1
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 6
    const/4 v8, 0
    move-object v3, v10
    invoke-direct/range v3 ... v8, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;-><init>(Z Ljava/lang/String; Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v10
.end method

.method public final validateFileSize(java.io.File)com.bytedance.trae.conversation.imageupload.FileValidationResult
    .registers 11
    # ins_size=2
    const-string v0, "file"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v10, Ljava/io/File;->length()J
    move-result-wide v0
    const-wide/32 v2, 20971520
    cmp-long v10, v0, v2
    if-lez v10, +00dh
    new-instance v10, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;
    const-string v0, "Image size exceeds limit (max 20MB)"
    sget-object v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;->FILE_TOO_LARGE Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    const/4 v2, 0
    invoke-direct v10, v2, v0, v1, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;-><init>(Z Ljava/lang/String; Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;)V
    return-object v10
    new-instance v10, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;
    const/4 v4, 1
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 6
    const/4 v8, 0
    move-object v3, v10
    invoke-direct/range v3 ... v8, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;-><init>(Z Ljava/lang/String; Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v10
.end method

.method public final validateImageCount(int  int)kotlin.Pair
    .registers 9
    # ins_size=3
    rsub-int/lit8 v7, v7, 5
    if-gtz v7, +015h
    new-instance v7, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;
    const-string v8, "Maximum 5 images allowed"
    sget-object v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;->TOO_MANY_IMAGES Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    const/4 v1, 0
    invoke-direct v7, v1, v8, v0, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;-><init>(Z Ljava/lang/String; Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;)V
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v8
    invoke-static v7, v8, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v7
    return-object v7
    if-le v8, v7, +02ah
    new-instance v8, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;
    const/4 v1, 1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v2, "Only "
    invoke-direct v0, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v7, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v2, " more images allowed"
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    const/4 v3, 0
    const/4 v4, 4
    const/4 v5, 0
    move-object v0, v8
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;-><init>(Z Ljava/lang/String; Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-static v7, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v7
    invoke-static v8, v7, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v7
    return-object v7
    new-instance v7, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;
    const/4 v1, 1
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 6
    const/4 v5, 0
    move-object v0, v7
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;-><init>(Z Ljava/lang/String; Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-static v8, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v8
    invoke-static v7, v8, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v7
    return-object v7
.end method
