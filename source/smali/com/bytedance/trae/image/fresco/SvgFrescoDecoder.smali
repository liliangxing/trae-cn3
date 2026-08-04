# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder;
.super Ljava/lang/Object;
.source "SvgFrescoDecoder.kt"

.field private static final BYTES_PER_ARGB_8888_PIXEL:J
.field private static final FALLBACK_SVG_SIZE_BYTES:I
.field private static final HEADER_SIZE:I
.field private static final HEADER_TAG:[B
.field public static final INSTANCE:Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder;
.field private static final SVG_FORMAT:Lcom/facebook/imageformat/ImageFormat;
.field private static final TAG:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder;
    invoke-direct v0, Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder;-><init>()V
    sput-object v0, Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder;->INSTANCE Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder;
    const-string v0, "<svg"
    invoke-static v0, Lcom/facebook/imageformat/ImageFormatCheckerUtils;->asciiBytes(Ljava/lang/String;)[B
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder;->HEADER_TAG [B
    new-instance v0, Lcom/facebook/imageformat/ImageFormat;
    const-string v1, "SVG_FORMAT"
    const-string/jumbo v2, svg
    invoke-direct v0, v1, v2, Lcom/facebook/imageformat/ImageFormat;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder;->SVG_FORMAT Lcom/facebook/imageformat/ImageFormat;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static final synthetic access$getHEADER_TAG$p()byte[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder;->HEADER_TAG [B
    return-object v0
.end method

.method public final getSVG_FORMAT()com.facebook.imageformat.ImageFormat
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder;->SVG_FORMAT Lcom/facebook/imageformat/ImageFormat;
    return-object v0
.end method
