# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder$SvgDecoder;
.super Ljava/lang/Object;
.source "SvgFrescoDecoder.kt"

.implements Lcom/facebook/imagepipeline/decoder/ImageDecoder;


.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public decode(com.facebook.imagepipeline.image.EncodedImage  int  com.facebook.imagepipeline.image.QualityInfo  com.facebook.imagepipeline.common.ImageDecodeOptions)com.facebook.imagepipeline.image.CloseableImage
    .registers 7
    # ins_size=5
    const-string v4, "encodedImage"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v4, "qualityInfo"
    invoke-static v5, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v4, "options"
    invoke-static v6, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v4, 0
    sget-object v5, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v5, v2
    check-cast v5, Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder$SvgDecoder;
    invoke-virtual v3, Lcom/facebook/imagepipeline/image/EncodedImage;->getInputStream()Ljava/io/InputStream;
    move-result-object v3
    check-cast v3, Ljava/io/Closeable;
    move-object v5, v3
    check-cast v5, Ljava/io/InputStream;
    new-instance v6, Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder$CloseableSvgImage;
    invoke-static v5, Lcom/caverock/androidsvg/SVG;->getFromInputStream(Ljava/io/InputStream;)Lcom/caverock/androidsvg/SVG;
    move-result-object v5
    const-string v0, "getFromInputStream(...)"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v6, v5, Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder$CloseableSvgImage;-><init>(Lcom/caverock/androidsvg/SVG;)V
    invoke-static v3, v4, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    invoke-static v6, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    goto +13h
    move-exception v5
    throw v5
    move-exception v6
    invoke-static v3, v5, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    throw v6
    move-exception v3
    sget-object v5, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v3, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v3
    invoke-static v3, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    invoke-static v3, Lkotlin/Result;->exceptionOrNull-impl(Ljava/lang/Object;)Ljava/lang/Throwable;
    move-result-object v5
    if-eqz v5, +00bh
    sget-object v6, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    const-string v0, "SvgFrescoDecoder"
    const-string v1, "decode svg failed"
    invoke-virtual v6, v0, v1, v5, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    invoke-static v3, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, +003h
    goto +2h
    move-object v4, v3
    check-cast v4, Lcom/facebook/imagepipeline/image/CloseableImage;
    return-object v4
    :try_start_0x10
    :try_start_0x1b
    :try_start_0x2c
    :try_start_0x35
    :try_start_0x37
.end method
