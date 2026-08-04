# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager$buildContentArea$5$1;
.super Landroid/graphics/drawable/ShapeDrawable$ShaderFactory;
.source "TodoGroupRenderer.kt"

.field final synthetic $bgColor:I
.field final synthetic $bgColorTransparent:I


.method constructor <init>(int  int)void
    .registers 3
    # ins_size=3
    iput v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager$buildContentArea$5$1;->$bgColor I
    iput v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager$buildContentArea$5$1;->$bgColorTransparent I
    invoke-direct v0, Landroid/graphics/drawable/ShapeDrawable$ShaderFactory;-><init>()V
    return-void 
.end method

.method public resize(int  int)android.graphics.Shader
    .registers 11
    # ins_size=3
    new-instance v9, Landroid/graphics/LinearGradient;
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    int-to-float v4, v10
    iget v5, v8, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager$buildContentArea$5$1;->$bgColor I
    iget v6, v8, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager$buildContentArea$5$1;->$bgColorTransparent I
    sget-object v7, Landroid/graphics/Shader$TileMode;->CLAMP Landroid/graphics/Shader$TileMode;
    move-object v0, v9
    invoke-direct/range v0 ... v7, Landroid/graphics/LinearGradient;-><init>(F F F F I I Landroid/graphics/Shader$TileMode;)V
    check-cast v9, Landroid/graphics/Shader;
    return-object v9
.end method
