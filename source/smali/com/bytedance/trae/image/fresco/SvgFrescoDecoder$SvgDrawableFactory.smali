# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder$SvgDrawableFactory;
.super Ljava/lang/Object;
.source "SvgFrescoDecoder.kt"

.implements Lcom/facebook/imagepipeline/drawable/DrawableFactory;


.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public createDrawable(com.facebook.imagepipeline.image.CloseableImage)android.graphics.drawable.Drawable
    .registers 4
    # ins_size=2
    const-string v0, "image"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    instance-of v0, v3, Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder$CloseableSvgImage;
    const/4 v1, 0
    if-eqz v0, +005h
    check-cast v3, Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder$CloseableSvgImage;
    goto +2h
    move-object v3, v1
    if-eqz v3, +00bh
    new-instance v1, Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder$SvgDrawable;
    invoke-virtual v3, Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder$CloseableSvgImage;->getSvg()Lcom/caverock/androidsvg/SVG;
    move-result-object v3
    invoke-direct v1, v3, Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder$SvgDrawable;-><init>(Lcom/caverock/androidsvg/SVG;)V
    check-cast v1, Landroid/graphics/drawable/Drawable;
    return-object v1
.end method

.method public createDrawable(com.facebook.imagepipeline.image.CloseableImage  android.graphics.drawable.Drawable)android.graphics.drawable.Drawable
    .registers 3
    # ins_size=3
    const-string v2, "image"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v0, v1, Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder$SvgDrawableFactory;->createDrawable(Lcom/facebook/imagepipeline/image/CloseableImage;)Landroid/graphics/drawable/Drawable;
    move-result-object v1
    return-object v1
.end method

.method public supportsImageType(com.facebook.imagepipeline.image.CloseableImage)boolean
    .registers 3
    # ins_size=2
    const-string v0, "image"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    instance-of v2, v2, Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder$CloseableSvgImage;
    return v2
.end method
