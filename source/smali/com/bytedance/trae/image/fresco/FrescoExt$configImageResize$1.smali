# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/image/fresco/FrescoExt$configImageResize$1;
.super Lcom/facebook/imagepipeline/producers/ImageResizeOptionStrategy;
.source "FrescoExt.kt"


.method constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/facebook/imagepipeline/producers/ImageResizeOptionStrategy;-><init>()V
    return-void 
.end method

.method public getResizeConfig(android.net.Uri  int  int  int  int  boolean  com.facebook.imageformat.ImageFormat)com.facebook.imagepipeline.common.ResizeOptions
    .registers 18
    # ins_size=8
    invoke-static Lcom/bytedance/trae/image/fresco/IResizeStrategyKt;->getStrategies()Ljava/util/List;
    move-result-object v0
    invoke-interface v0, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +019h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Lcom/bytedance/trae/image/fresco/IResizeStrategy;
    move-object v3, v11
    move v4, v12
    move v5, v13
    move v6, v14
    move v7, v15
    move/from16 v8, v16
    move-object/from16 v9, v17
    invoke-interface/range v2 ... v9, Lcom/bytedance/trae/image/fresco/IResizeStrategy;->getResizeConfig(Landroid/net/Uri; I I I I Z Lcom/facebook/imageformat/ImageFormat;)Lcom/facebook/imagepipeline/common/ResizeOptions;
    move-result-object v1
    if-eqz v1, -01ah
    return-object v1
    const/4 v0, 0
    return-object v0
.end method
