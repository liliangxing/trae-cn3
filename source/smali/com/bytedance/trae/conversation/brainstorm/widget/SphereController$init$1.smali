# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController$init$1;
.super Landroid/webkit/WebViewClient;
.source "SphereController.kt"

.field final synthetic this$0:Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;


.method constructor <init>(com.bytedance.trae.conversation.brainstorm.widget.SphereController)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController$init$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;
    invoke-direct v0, Landroid/webkit/WebViewClient;-><init>()V
    return-void 
.end method

.method public onPageFinished(android.webkit.WebView  java.lang.String)void
    .registers 3
    # ins_size=3
    invoke-super v0, v1, v2, Landroid/webkit/WebViewClient;->onPageFinished(Landroid/webkit/WebView; Ljava/lang/String;)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController$init$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;
    const/4 v2, 1
    invoke-static v1, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;->access$setPageLoaded$p(Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController; Z)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController$init$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;
    invoke-static v1, Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;->access$getPendingActions$p(Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;)Ljava/util/List;
    move-result-object v1
    check-cast v1, Ljava/lang/Iterable;
    invoke-static v1, Lkotlin/collections/CollectionsKt;->toList(Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v1
    iget-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController$init$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;
    invoke-static v2, Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;->access$getPendingActions$p(Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;)Ljava/util/List;
    move-result-object v2
    invoke-interface v2, Ljava/util/List;->clear()V
    check-cast v1, Ljava/lang/Iterable;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +00ch
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lkotlin/jvm/functions/Function0;
    invoke-interface v2, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    goto -fh
    return-void 
.end method

.method public onPageStarted(android.webkit.WebView  java.lang.String  android.graphics.Bitmap)void
    .registers 4
    # ins_size=4
    invoke-super v0, v1, v2, v3, Landroid/webkit/WebViewClient;->onPageStarted(Landroid/webkit/WebView; Ljava/lang/String; Landroid/graphics/Bitmap;)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController$init$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;
    const/4 v2, 0
    invoke-static v1, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController;->access$setPageLoaded$p(Lcom/bytedance/trae/conversation/brainstorm/widget/SphereController; Z)V
    return-void 
.end method
