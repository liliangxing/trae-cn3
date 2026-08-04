# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/InitialLoadingRenderer$render$1;
.super Ljava/lang/Object;
.source "InitialLoadingRenderer.kt"

.implements Landroid/view/View$OnAttachStateChangeListener;

.field final synthetic $animators:Ljava/util/List;


.method constructor <init>(java.util.List)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/InitialLoadingRenderer$render$1;->$animators Ljava/util/List;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public onViewAttachedToWindow(android.view.View)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, v
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method

.method public onViewDetachedFromWindow(android.view.View)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, v
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/InitialLoadingRenderer$render$1;->$animators Ljava/util/List;
    check-cast v2, Ljava/lang/Iterable;
    invoke-interface v2, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +00ch
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Landroid/animation/ObjectAnimator;
    invoke-virtual v0, Landroid/animation/ObjectAnimator;->cancel()V
    goto -fh
    iget-object v2, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/InitialLoadingRenderer$render$1;->$animators Ljava/util/List;
    invoke-interface v2, Ljava/util/List;->clear()V
    return-void 
.end method
