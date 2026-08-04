# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/imageupload/ImageUploadConstants;
.super Ljava/lang/Object;
.source "ImageUploadConstants.kt"

.field private static final ACCEPTED_EXTENSIONS:Ljava/util/Set;
.field private static final ASPECT_RATIO_LIMIT:I
.field public static final COMPRESSION_DIMENSION_THRESHOLD:I
.field public static final COMPRESSION_SIZE_THRESHOLD_BYTES:J
.field public static final COMPRESSION_TARGET_SIZE_BYTES:J
.field public static final INSTANCE:Lcom/bytedance/trae/conversation/imageupload/ImageUploadConstants;
.field public static final MAX_ASPECT_RATIO:D
.field public static final MAX_FILE_SIZE_BYTES:J
.field public static final MAX_FILE_SIZE_MB:I
.field public static final MAX_IMAGE_COUNT:I
.field public static final MAX_PIXEL_COUNT:J
.field public static final MIN_ASPECT_RATIO:D
.field public static final MIN_IMAGE_DIMENSION:I
.field public static final MIN_PIXEL_COUNT:J
.field public static final TOKEN_EXPIRY_THRESHOLD_MS:J
.field public static final TOKEN_SAFETY_THRESHOLD_MS:J
.field public static final UPLOAD_CONCURRENCY:I
.field public static final UPLOAD_MAX_RETRIES:I
.field public static final UPLOAD_RETRY_DELAY_BASE_MS:J
.field public static final UPLOAD_TIMEOUT_MS:J


.method static constructor <clinit>()void
    .registers 5
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadConstants;
    invoke-direct v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadConstants;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadConstants;->INSTANCE Lcom/bytedance/trae/conversation/imageupload/ImageUploadConstants;
    const-string v0, ".gif"
    const-string v1, ".webp"
    const-string v2, ".jpg"
    const-string v3, ".jpeg"
    const-string v4, ".png"
    filled-new-array v2, v3, v4, v0, v1, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadConstants;->ACCEPTED_EXTENSIONS Ljava/util/Set;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final getACCEPTED_EXTENSIONS()java.util.Set
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadConstants;->ACCEPTED_EXTENSIONS Ljava/util/Set;
    return-object v0
.end method
