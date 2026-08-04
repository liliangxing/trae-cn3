# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/image/fresco/DefaultResizeStrategy;
.super Ljava/lang/Object;
.source "IResizeStrategy.kt"

.implements Lcom/bytedance/trae/image/fresco/IResizeStrategy;

.field public static final INSTANCE:Lcom/bytedance/trae/image/fresco/DefaultResizeStrategy;
.field private static final TAG:Ljava/lang/String;
.field private static final imageResizeOpt:Z


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/image/fresco/DefaultResizeStrategy;
    invoke-direct v0, Lcom/bytedance/trae/image/fresco/DefaultResizeStrategy;-><init>()V
    sput-object v0, Lcom/bytedance/trae/image/fresco/DefaultResizeStrategy;->INSTANCE Lcom/bytedance/trae/image/fresco/DefaultResizeStrategy;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public getResizeConfig(android.net.Uri  int  int  int  int  boolean  com.facebook.imageformat.ImageFormat)com.facebook.imagepipeline.common.ResizeOptions
    .registers 14
    # ins_size=8
    sget-boolean v12, Lcom/bytedance/trae/image/fresco/DefaultResizeStrategy;->imageResizeOpt Z
    const/4 v13, 0
    if-nez v12, +003h
    return-object v13
    if-eqz v7, +032h
    const/4 v12, 1
    if-le v8, v12, +02fh
    if-le v9, v12, +02dh
    if-lez v10, +02bh
    if-gtz v11, +003h
    goto +27h
    if-le v10, v8, +026h
    if-gt v11, v9, +003h
    goto +22h
    const-string v0, "DefaultResizeStrategy"
    move-object v1, v7
    move v2, v10
    move v3, v11
    move v4, v8
    move v5, v9
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/image/fresco/IResizeStrategyKt;->access$log(Ljava/lang/String; Landroid/net/Uri; I I I I)V
    int-to-float v7, v10
    int-to-float v10, v8
    div-float v10, v7, v10
    int-to-float v11, v11
    int-to-float v12, v9
    div-float v12, v11, v12
    cmpl-float v13, v10, v12
    if-lez v13, +005h
    div-float/2addr v7, v12
    float-to-int v8, v7
    goto +3h
    div-float/2addr v11, v10
    float-to-int v9, v11
    new-instance v7, Lcom/facebook/imagepipeline/common/ResizeOptions;
    invoke-direct v7, v8, v9, Lcom/facebook/imagepipeline/common/ResizeOptions;-><init>(I I)V
    return-object v7
    return-object v13
.end method
