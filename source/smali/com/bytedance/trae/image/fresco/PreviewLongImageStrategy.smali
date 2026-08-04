# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/image/fresco/PreviewLongImageStrategy;
.super Ljava/lang/Object;
.source "IResizeStrategy.kt"

.implements Lcom/bytedance/trae/image/fresco/IResizeStrategy;

.field public static final INSTANCE:Lcom/bytedance/trae/image/fresco/PreviewLongImageStrategy;
.field private static final TAG:Ljava/lang/String;
.field private static final enableLongImageAutoFit:Z


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/image/fresco/PreviewLongImageStrategy;
    invoke-direct v0, Lcom/bytedance/trae/image/fresco/PreviewLongImageStrategy;-><init>()V
    sput-object v0, Lcom/bytedance/trae/image/fresco/PreviewLongImageStrategy;->INSTANCE Lcom/bytedance/trae/image/fresco/PreviewLongImageStrategy;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public getResizeConfig(android.net.Uri  int  int  int  int  boolean  com.facebook.imageformat.ImageFormat)com.facebook.imagepipeline.common.ResizeOptions
    .registers 15
    # ins_size=8
    sget-boolean v13, Lcom/bytedance/trae/image/fresco/PreviewLongImageStrategy;->enableLongImageAutoFit Z
    const/4 v14, 0
    if-nez v13, +003h
    return-object v14
    if-eqz v8, +033h
    if-lez v11, +031h
    if-gtz v12, +003h
    goto +2dh
    const-string v13, "biz_tag"
    invoke-virtual v8, v13, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v13
    goto +2h
    move-object v13, v14
    const-string v0, "common.photo_dialog_preview"
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v13
    if-nez v13, +003h
    return-object v14
    int-to-float v13, v12
    int-to-float v0, v11
    div-float v0, v13, v0
    const/high16 v1, 1084227584
    cmpg-float v0, v0, v1
    if-gez v0, +003h
    return-object v14
    const-string v1, "PreviewLongImageStrategy"
    move-object v2, v8
    move v3, v11
    move v4, v12
    move v5, v9
    move v6, v10
    invoke-static/range v1 ... v6, Lcom/bytedance/trae/image/fresco/IResizeStrategyKt;->access$log(Ljava/lang/String; Landroid/net/Uri; I I I I)V
    new-instance v8, Lcom/facebook/imagepipeline/common/ResizeOptions;
    invoke-direct v8, v11, v12, v13, Lcom/facebook/imagepipeline/common/ResizeOptions;-><init>(I I F)V
    return-object v8
    return-object v14
    :try_start_0xd
.end method
