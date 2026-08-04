# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet$onViewCreated$1;
.super Landroid/view/ViewOutlineProvider;
.source "AccountSettingsBottomSheet.kt"

.field final synthetic $radiusPx:I


.method constructor <init>(int)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet$onViewCreated$1;->$radiusPx I
    invoke-direct v0, Landroid/view/ViewOutlineProvider;-><init>()V
    return-void 
.end method

.method public getOutline(android.view.View  android.graphics.Outline)void
    .registers 10
    # ins_size=3
    const-string/jumbo v0, v
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "outline"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v2, 0
    const/4 v3, 0
    invoke-virtual v8, Landroid/view/View;->getWidth()I
    move-result v4
    invoke-virtual v8, Landroid/view/View;->getHeight()I
    move-result v8
    iget v0, v7, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet$onViewCreated$1;->$radiusPx I
    add-int v5, v8, v0
    int-to-float v6, v0
    move-object v1, v9
    invoke-virtual/range v1 ... v6, Landroid/graphics/Outline;->setRoundRect(I I I I F)V
    return-void 
.end method
