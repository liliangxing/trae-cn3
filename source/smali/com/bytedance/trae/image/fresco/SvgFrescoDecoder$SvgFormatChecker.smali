# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder$SvgFormatChecker;
.super Ljava/lang/Object;
.source "SvgFrescoDecoder.kt"

.implements Lcom/facebook/imageformat/ImageFormat$FormatChecker;


.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public determineFormat(byte[]  int)com.facebook.imageformat.ImageFormat
    .registers 5
    # ins_size=3
    const-string v0, "headerBytes"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder;->access$getHEADER_TAG$p()[B
    move-result-object v0
    invoke-static Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder;->access$getHEADER_TAG$p()[B
    move-result-object v1
    array-length v1, v1
    invoke-static v3, v4, v0, v1, Lcom/facebook/imageformat/ImageFormatCheckerUtils;->indexOfPattern([B I [B I)I
    move-result v3
    if-ltz v3, +009h
    sget-object v3, Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder;->INSTANCE Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder;
    invoke-virtual v3, Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder;->getSVG_FORMAT()Lcom/facebook/imageformat/ImageFormat;
    move-result-object v3
    goto +2h
    const/4 v3, 0
    return-object v3
.end method

.method public getHeaderSize()int
    .registers 2
    # ins_size=1
    const/16 v0, 4096
    return v0
.end method
