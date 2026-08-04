# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$WhenMappings;
.super Ljava/lang/Object;
.source "ImageUploadService.kt"

.field public static final synthetic $EnumSwitchMapping$0:[I


.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    invoke-static Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;->values()[Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    move-result-object v0
    array-length v0, v0
    new-array v0, v0, [I
    sget-object v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;->INVALID_FORMAT Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;->ordinal()I
    move-result v1
    const/4 v2, 1
    aput v2, v0, v1
    sget-object v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;->FILE_TOO_LARGE Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;->ordinal()I
    move-result v1
    const/4 v2, 2
    aput v2, v0, v1
    sget-object v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;->DIMENSION_TOO_SMALL Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;->ordinal()I
    move-result v1
    const/4 v2, 3
    aput v2, v0, v1
    sget-object v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;->PIXEL_COUNT_INVALID Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;->ordinal()I
    move-result v1
    const/4 v2, 4
    aput v2, v0, v1
    sget-object v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;->ASPECT_RATIO_INVALID Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;->ordinal()I
    move-result v1
    const/4 v2, 5
    aput v2, v0, v1
    sget-object v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;->CONTENT_CHECK_FAILED Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;->ordinal()I
    move-result v1
    const/4 v2, 6
    aput v2, v0, v1
    sget-object v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;->TOO_MANY_IMAGES Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;->ordinal()I
    move-result v1
    const/4 v2, 7
    aput v2, v0, v1
    sput-object v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$WhenMappings;->$EnumSwitchMapping$0 [I
    return-void 
    :try_start_0x7
    :try_start_0x10
    :try_start_0x19
    :try_start_0x22
    :try_start_0x2b
    :try_start_0x34
    :try_start_0x3d
.end method
