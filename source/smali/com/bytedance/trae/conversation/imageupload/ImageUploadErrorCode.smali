# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final enum Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
.super Ljava/lang/Enum;
.source "ImageUploadModels.kt"

.field private static final synthetic $ENTRIES:Lkotlin/enums/EnumEntries;
.field private static final synthetic $VALUES:[Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
.field public static final enum ASPECT_RATIO_INVALID:Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
.field public static final enum COMPRESSION_FAILED:Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
.field public static final enum CONTENT_CHECK_FAILED:Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
.field public static final enum DIMENSION_TOO_SMALL:Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
.field public static final enum FILE_TOO_LARGE:Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
.field public static final enum INVALID_FORMAT:Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
.field public static final enum NETWORK_ERROR:Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
.field public static final enum PIXEL_COUNT_INVALID:Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
.field public static final enum TIMEOUT:Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
.field public static final enum TOKEN_FETCH_FAILED:Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
.field public static final enum TOO_MANY_IMAGES:Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
.field public static final enum UNKNOWN:Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
.field public static final enum UPLOAD_FAILED:Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;


.method private static final synthetic $values()com.bytedance.trae.conversation.imageupload.ImageUploadErrorCode[]
    .registers 3
    # ins_size=0
    const/16 v0, 13
    new-array v0, v0, [Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    const/4 v1, 0
    sget-object v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;->INVALID_FORMAT Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    aput-object v2, v0, v1
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;->FILE_TOO_LARGE Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    aput-object v2, v0, v1
    const/4 v1, 2
    sget-object v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;->DIMENSION_TOO_SMALL Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    aput-object v2, v0, v1
    const/4 v1, 3
    sget-object v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;->PIXEL_COUNT_INVALID Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    aput-object v2, v0, v1
    const/4 v1, 4
    sget-object v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;->ASPECT_RATIO_INVALID Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    aput-object v2, v0, v1
    const/4 v1, 5
    sget-object v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;->TOO_MANY_IMAGES Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    aput-object v2, v0, v1
    const/4 v1, 6
    sget-object v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;->TOKEN_FETCH_FAILED Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    aput-object v2, v0, v1
    const/4 v1, 7
    sget-object v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;->UPLOAD_FAILED Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    aput-object v2, v0, v1
    const/16 v1, 8
    sget-object v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;->COMPRESSION_FAILED Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    aput-object v2, v0, v1
    const/16 v1, 9
    sget-object v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;->CONTENT_CHECK_FAILED Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    aput-object v2, v0, v1
    const/16 v1, 10
    sget-object v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;->NETWORK_ERROR Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    aput-object v2, v0, v1
    const/16 v1, 11
    sget-object v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;->TIMEOUT Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    aput-object v2, v0, v1
    const/16 v1, 12
    sget-object v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;->UNKNOWN Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    aput-object v2, v0, v1
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    const-string v1, "INVALID_FORMAT"
    const/4 v2, 0
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;->INVALID_FORMAT Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    new-instance v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    const-string v1, "FILE_TOO_LARGE"
    const/4 v2, 1
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;->FILE_TOO_LARGE Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    new-instance v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    const-string v1, "DIMENSION_TOO_SMALL"
    const/4 v2, 2
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;->DIMENSION_TOO_SMALL Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    new-instance v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    const-string v1, "PIXEL_COUNT_INVALID"
    const/4 v2, 3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;->PIXEL_COUNT_INVALID Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    new-instance v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    const-string v1, "ASPECT_RATIO_INVALID"
    const/4 v2, 4
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;->ASPECT_RATIO_INVALID Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    new-instance v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    const-string v1, "TOO_MANY_IMAGES"
    const/4 v2, 5
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;->TOO_MANY_IMAGES Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    new-instance v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    const-string v1, "TOKEN_FETCH_FAILED"
    const/4 v2, 6
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;->TOKEN_FETCH_FAILED Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    new-instance v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    const-string v1, "UPLOAD_FAILED"
    const/4 v2, 7
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;->UPLOAD_FAILED Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    new-instance v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    const-string v1, "COMPRESSION_FAILED"
    const/16 v2, 8
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;->COMPRESSION_FAILED Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    new-instance v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    const-string v1, "CONTENT_CHECK_FAILED"
    const/16 v2, 9
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;->CONTENT_CHECK_FAILED Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    new-instance v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    const-string v1, "NETWORK_ERROR"
    const/16 v2, 10
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;->NETWORK_ERROR Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    new-instance v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    const-string v1, "TIMEOUT"
    const/16 v2, 11
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;->TIMEOUT Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    new-instance v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    const-string v1, "UNKNOWN"
    const/16 v2, 12
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;->UNKNOWN Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    invoke-static Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;->$values()[Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;->$VALUES [Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    check-cast v0, [Ljava/lang/Enum;
    invoke-static v0, Lkotlin/enums/EnumEntriesKt;->enumEntries([Ljava/lang/Enum;)Lkotlin/enums/EnumEntries;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-void 
.end method

.method private constructor <init>(java.lang.String  int)void
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Ljava/lang/Enum;-><init>(Ljava/lang/String; I)V
    return-void 
.end method

.method public static getEntries()kotlin.enums.EnumEntries
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-object v0
.end method

.method public static valueOf(java.lang.String)com.bytedance.trae.conversation.imageupload.ImageUploadErrorCode
    .registers 2
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    invoke-static v0, v1, Ljava/lang/Enum;->valueOf(Ljava/lang/Class; Ljava/lang/String;)Ljava/lang/Enum;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    return-object v1
.end method

.method public static values()com.bytedance.trae.conversation.imageupload.ImageUploadErrorCode[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;->$VALUES [Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    invoke-virtual v0, Ljava/lang/Object;->clone()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, [Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    return-object v0
.end method
