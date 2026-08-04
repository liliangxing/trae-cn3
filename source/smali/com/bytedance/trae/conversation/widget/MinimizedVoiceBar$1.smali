# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar$1;
.super Landroid/view/ViewOutlineProvider;
.source "MinimizedVoiceBar.kt"

.field final synthetic $cornerRadius:F


.method constructor <init>(float)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar$1;->$cornerRadius F
    invoke-direct v0, Landroid/view/ViewOutlineProvider;-><init>()V
    return-void 
.end method

.method public getOutline(android.view.View  android.graphics.Outline)void
    .registers 10
    # ins_size=3
    const-string/jumbo v0, view
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "outline"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v2, 0
    const/4 v3, 0
    invoke-virtual v8, Landroid/view/View;->getWidth()I
    move-result v4
    invoke-virtual v8, Landroid/view/View;->getHeight()I
    move-result v5
    iget v6, v7, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar$1;->$cornerRadius F
    move-object v1, v9
    invoke-virtual/range v1 ... v6, Landroid/graphics/Outline;->setRoundRect(I I I I F)V
    return-void 
.end method
