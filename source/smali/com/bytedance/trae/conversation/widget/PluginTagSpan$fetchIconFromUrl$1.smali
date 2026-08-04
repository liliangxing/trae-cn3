# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/widget/PluginTagSpan$fetchIconFromUrl$1;
.super Lcom/facebook/datasource/BaseDataSubscriber;
.source "PluginTagSpan.kt"

.field final synthetic this$0:Lcom/bytedance/trae/conversation/widget/PluginTagSpan;


.method constructor <init>(com.bytedance.trae.conversation.widget.PluginTagSpan)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/widget/PluginTagSpan$fetchIconFromUrl$1;->this$0 Lcom/bytedance/trae/conversation/widget/PluginTagSpan;
    invoke-direct v0, Lcom/facebook/datasource/BaseDataSubscriber;-><init>()V
    return-void 
.end method

.method protected onFailureImpl(com.facebook.datasource.DataSource)void
    .registers 3
    # ins_size=2
    const-string v0, "dataSource"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/widget/PluginTagSpan$fetchIconFromUrl$1;->this$0 Lcom/bytedance/trae/conversation/widget/PluginTagSpan;
    const/4 v0, 0
    invoke-static v2, v0, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;->access$setActiveDataSource$p(Lcom/bytedance/trae/conversation/widget/PluginTagSpan; Lcom/facebook/datasource/DataSource;)V
    return-void 
.end method

.method protected onNewResultImpl(com.facebook.datasource.DataSource)void
    .registers 5
    # ins_size=2
    const-string v0, "dataSource"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v4, Lcom/facebook/datasource/DataSource;->isFinished()Z
    move-result v0
    if-nez v0, +003h
    return-void 
    invoke-interface v4, Lcom/facebook/datasource/DataSource;->getResult()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/facebook/common/references/CloseableReference;
    if-nez v4, +003h
    return-void 
    iget-object v0, v3, Lcom/bytedance/trae/conversation/widget/PluginTagSpan$fetchIconFromUrl$1;->this$0 Lcom/bytedance/trae/conversation/widget/PluginTagSpan;
    invoke-virtual v4, Lcom/facebook/common/references/CloseableReference;->get()Ljava/lang/Object;
    move-result-object v1
    const-string v2, "get(...)"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v1, Lcom/facebook/imagepipeline/image/CloseableImage;
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;->access$toDrawable(Lcom/bytedance/trae/conversation/widget/PluginTagSpan; Lcom/facebook/imagepipeline/image/CloseableImage;)Landroid/graphics/drawable/Drawable;
    move-result-object v0
    if-eqz v0, +00ch
    iget-object v1, v3, Lcom/bytedance/trae/conversation/widget/PluginTagSpan$fetchIconFromUrl$1;->this$0 Lcom/bytedance/trae/conversation/widget/PluginTagSpan;
    invoke-static v1, v0, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;->access$setLoadedDrawable$p(Lcom/bytedance/trae/conversation/widget/PluginTagSpan; Landroid/graphics/drawable/Drawable;)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/widget/PluginTagSpan$fetchIconFromUrl$1;->this$0 Lcom/bytedance/trae/conversation/widget/PluginTagSpan;
    invoke-static v0, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;->access$notifySpanChanged(Lcom/bytedance/trae/conversation/widget/PluginTagSpan;)V
    invoke-static v4, Lcom/facebook/common/references/CloseableReference;->closeSafely(Lcom/facebook/common/references/CloseableReference;)V
    iget-object v4, v3, Lcom/bytedance/trae/conversation/widget/PluginTagSpan$fetchIconFromUrl$1;->this$0 Lcom/bytedance/trae/conversation/widget/PluginTagSpan;
    const/4 v0, 0
    invoke-static v4, v0, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;->access$setActiveDataSource$p(Lcom/bytedance/trae/conversation/widget/PluginTagSpan; Lcom/facebook/datasource/DataSource;)V
    return-void 
    move-exception v0
    invoke-static v4, Lcom/facebook/common/references/CloseableReference;->closeSafely(Lcom/facebook/common/references/CloseableReference;)V
    throw v0
    :try_start_0x15
.end method
