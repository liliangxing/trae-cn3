# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter;
.super Landroidx/recyclerview/widget/RecyclerView$Adapter;
.source "MultiImagePreviewActivity.kt"

.field private final count:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;


.method public constructor <init>(com.bytedance.trae.conversation.products.MultiImagePreviewActivity  int)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    invoke-direct v0, Landroidx/recyclerview/widget/RecyclerView$Adapter;-><init>()V
    iput v2, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter;->count I
    return-void 
.end method

.method public static final synthetic access$loadUri(com.bytedance.trae.conversation.products.MultiImagePreviewActivity$ImagePagerAdapter  com.bytedance.trae.conversation.products.MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder  android.net.Uri)void
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter;->loadUri(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder; Landroid/net/Uri;)V
    return-void 
.end method

.method private final loadImageIntoView(com.bytedance.trae.conversation.products.MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder  java.lang.String  java.lang.String)void
    .registers 15
    # ins_size=4
    iget-object v0, v11, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    invoke-static v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->access$getResolveMode$p(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;)Ljava/lang/String;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v1
    const-string v2, "file://"
    const-string v3, "content://"
    const/4 v4, 2
    const/4 v5, 0
    const-string v6, "parse(...)"
    const/4 v7, 0
    sparse-switch v1, +0000101h
    goto/16 +09ah
    const-string v1, "local_artifact"
    invoke-virtual v0, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +004h
    goto/16 +090h
    invoke-static v13, v3, v5, v4, v7, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +031h
    invoke-static v13, v2, v5, v4, v7, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    goto +29h
    iget-object v0, v11, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    check-cast v0, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$loadImageIntoView$2;
    iget-object v8, v11, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    const/4 v10, 0
    move-object v4, v0
    move-object v5, v14
    move-object v6, v12
    move-object v7, v11
    move-object v9, v13
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$loadImageIntoView$2;-><init>(Ljava/lang/String; Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder; Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter; Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    move-result-object v13
    invoke-virtual v12, v13, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->setDownloadJob(Lkotlinx/coroutines/Job;)V
    goto/16 +0beh
    invoke-static v13, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v13
    invoke-static v13, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v11, v12, v13, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter;->loadUri(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder; Landroid/net/Uri;)V
    return-void 
    const-string v1, "remote_resource"
    invoke-virtual v0, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    goto +46h
    iget-object v0, v11, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    check-cast v0, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$loadImageIntoView$1;
    iget-object v8, v11, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    const/4 v10, 0
    move-object v4, v0
    move-object v5, v12
    move-object v6, v14
    move-object v7, v11
    move-object v9, v13
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$loadImageIntoView$1;-><init>(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder; Ljava/lang/String; Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter; Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    move-result-object v13
    invoke-virtual v12, v13, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->setDownloadJob(Lkotlinx/coroutines/Job;)V
    goto/16 +082h
    const-string v1, "image_id"
    invoke-virtual v0, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +017h
    goto +ah
    const-string v1, "local_uri"
    invoke-virtual v0, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    goto +ch
    invoke-static v13, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v13
    invoke-static v13, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v11, v12, v13, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter;->loadUri(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder; Landroid/net/Uri;)V
    goto +64h
    iget-object v0, v11, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    invoke-static v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->access$getCliType$p(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;)Ljava/lang/String;
    move-result-object v0
    if-nez v0, +008h
    const-string v0, "cliType"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v7
    sget-object v1, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v1, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v1
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +041h
    invoke-static v13, v3, v5, v4, v7, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +030h
    invoke-static v13, v2, v5, v4, v7, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    goto +28h
    iget-object v0, v11, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    check-cast v0, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$loadImageIntoView$3;
    iget-object v8, v11, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    const/4 v10, 0
    move-object v4, v0
    move-object v5, v12
    move-object v6, v14
    move-object v7, v11
    move-object v9, v13
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$loadImageIntoView$3;-><init>(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder; Ljava/lang/String; Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter; Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    move-result-object v13
    invoke-virtual v12, v13, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->setDownloadJob(Lkotlinx/coroutines/Job;)V
    goto +16h
    invoke-static v13, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v13
    invoke-static v13, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v11, v12, v13, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter;->loadUri(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder; Landroid/net/Uri;)V
    return-void 
    invoke-static v13, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v13
    invoke-static v13, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v11, v12, v13, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter;->loadUri(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder; Landroid/net/Uri;)V
    return-void 
    sparse-switch-payload -47d0d968 -333c7981 -324e1419 -1c217fda
.end method

.method private final loadUri(com.bytedance.trae.conversation.products.MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder  android.net.Uri)void
    .registers 4
    # ins_size=3
    invoke-static Lcom/facebook/drawee/backends/pipeline/Fresco;->newDraweeControllerBuilder()Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;
    move-result-object v0
    invoke-virtual v0, v3, Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;->setUri(Landroid/net/Uri;)Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;
    move-result-object v3
    const/4 v0, 1
    invoke-virtual v3, v0, Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;->setAutoPlayAnimations(Z)Lcom/facebook/drawee/controller/AbstractDraweeControllerBuilder;
    move-result-object v3
    check-cast v3, Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->getDraweeView()Lcom/facebook/drawee/view/SimpleDraweeView;
    move-result-object v0
    invoke-virtual v0, Lcom/facebook/drawee/view/SimpleDraweeView;->getController()Lcom/facebook/drawee/interfaces/DraweeController;
    move-result-object v0
    invoke-virtual v3, v0, Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;->setOldController(Lcom/facebook/drawee/interfaces/DraweeController;)Lcom/facebook/drawee/controller/AbstractDraweeControllerBuilder;
    move-result-object v3
    check-cast v3, Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;
    invoke-virtual v3, Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;->build()Lcom/facebook/drawee/controller/AbstractDraweeController;
    move-result-object v3
    invoke-virtual v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->getDraweeView()Lcom/facebook/drawee/view/SimpleDraweeView;
    move-result-object v2
    check-cast v3, Lcom/facebook/drawee/interfaces/DraweeController;
    invoke-virtual v2, v3, Lcom/facebook/drawee/view/SimpleDraweeView;->setController(Lcom/facebook/drawee/interfaces/DraweeController;)V
    return-void 
.end method

.method public getItemCount()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter;->count I
    return v0
.end method

.method public bridge synthetic onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder  int)void
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter;->onBindViewHolder(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder; I)V
    return-void 
.end method

.method public onBindViewHolder(com.bytedance.trae.conversation.products.MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder  int)void
    .registers 7
    # ins_size=3
    const-string v0, "holder"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v5, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->getDownloadJob()Lkotlinx/coroutines/Job;
    move-result-object v0
    const/4 v1, 1
    const/4 v2, 0
    if-eqz v0, +005h
    invoke-static v0, v2, v1, v2, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    invoke-virtual v5, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->setDownloadJob(Lkotlinx/coroutines/Job;)V
    invoke-virtual v5, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->resetScale()V
    invoke-virtual v5, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->setupTouchHandling()V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    invoke-static v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->access$getPaths$p(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;)Ljava/util/List;
    move-result-object v0
    invoke-interface v0, v6, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Ljava/lang/String;
    invoke-virtual v5, v6, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->setBoundPath(Ljava/lang/String;)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    invoke-static v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->access$getImageUrls$p(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;)Ljava/util/Map;
    move-result-object v0
    invoke-interface v0, v6, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/String;
    move-object v3, v0
    check-cast v3, Ljava/lang/CharSequence;
    if-eqz v3, +00ah
    invoke-interface v3, Ljava/lang/CharSequence;->length()I
    move-result v3
    if-nez v3, +003h
    goto +2h
    const/4 v1, 0
    if-eqz v1, +00ah
    invoke-virtual v5, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->getDraweeView()Lcom/facebook/drawee/view/SimpleDraweeView;
    move-result-object v5
    invoke-virtual v5, v2, Lcom/facebook/drawee/view/SimpleDraweeView;->setController(Lcom/facebook/drawee/interfaces/DraweeController;)V
    goto +4h
    invoke-direct v4, v5, v0, v6, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter;->loadImageIntoView(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public bridge synthetic onCreateViewHolder(android.view.ViewGroup  int)androidx.recyclerview.widget.RecyclerView$ViewHolder
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter;->onCreateViewHolder(Landroid/view/ViewGroup; I)Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;
    move-result-object v1
    check-cast v1, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
    return-object v1
.end method

.method public onCreateViewHolder(android.view.ViewGroup  int)com.bytedance.trae.conversation.products.MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder
    .registers 5
    # ins_size=3
    const-string v4, "parent"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v3, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;
    move-result-object v4
    invoke-static v4, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;
    move-result-object v4
    sget v0, Lcom/bytedance/trae/conversation/R$layout;->trae_item_multi_image_preview I
    const/4 v1, 0
    invoke-virtual v4, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v3
    new-instance v4, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v4, v2, v3, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;-><init>(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter; Landroid/view/View;)V
    return-object v4
.end method
