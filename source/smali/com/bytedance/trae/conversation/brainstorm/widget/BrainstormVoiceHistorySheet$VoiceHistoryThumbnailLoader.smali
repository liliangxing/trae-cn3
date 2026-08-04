# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader;
.super Ljava/lang/Object;
.source "BrainstormVoiceHistorySheet.kt"

.field private boundImageSource:Ljava/lang/String;
.field private final fileDownloadHelper:Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
.field private final imageUploadApi:Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi;
.field private final lifecycleScope:Landroidx/lifecycle/LifecycleCoroutineScope;
.field private final previewView:Lcom/facebook/drawee/view/SimpleDraweeView;
.field private final resourceUploadApi:Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;


.method public constructor <init>(com.facebook.drawee.view.SimpleDraweeView  androidx.lifecycle.LifecycleCoroutineScope  com.bytedance.trae.conversation.imageupload.ConversationCopilotImageUploadApi  com.bytedance.trae.conversation.fileupload.ConversationCopilotResourceUploadApi)void
    .registers 6
    # ins_size=5
    const-string v0, "previewView"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "lifecycleScope"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "imageUploadApi"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, resourceUploadApi
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader;->previewView Lcom/facebook/drawee/view/SimpleDraweeView;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader;->lifecycleScope Landroidx/lifecycle/LifecycleCoroutineScope;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader;->imageUploadApi Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi;
    iput-object v5, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader;->resourceUploadApi Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;
    new-instance v2, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    invoke-direct v2, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader;->fileDownloadHelper Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    return-void 
.end method

.method public static final synthetic access$getBoundImageSource$p(com.bytedance.trae.conversation.brainstorm.widget.BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader)java.lang.String
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader;->boundImageSource Ljava/lang/String;
    return-object v0
.end method

.method public static final synthetic access$getFileDownloadHelper$p(com.bytedance.trae.conversation.brainstorm.widget.BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader)com.bytedance.trae.conversation.products.FileDownloadHelper
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader;->fileDownloadHelper Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    return-object v0
.end method

.method public static final synthetic access$getImageUploadApi$p(com.bytedance.trae.conversation.brainstorm.widget.BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader)com.bytedance.trae.conversation.imageupload.ConversationCopilotImageUploadApi
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader;->imageUploadApi Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi;
    return-object v0
.end method

.method public static final synthetic access$getPreviewView$p(com.bytedance.trae.conversation.brainstorm.widget.BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader)com.facebook.drawee.view.SimpleDraweeView
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader;->previewView Lcom/facebook/drawee/view/SimpleDraweeView;
    return-object v0
.end method

.method public static final synthetic access$getResourceUploadApi$p(com.bytedance.trae.conversation.brainstorm.widget.BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader)com.bytedance.trae.conversation.fileupload.ConversationCopilotResourceUploadApi
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader;->resourceUploadApi Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;
    return-object v0
.end method

.method public static final synthetic access$loadPreviewUrl(com.bytedance.trae.conversation.brainstorm.widget.BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader  java.lang.String  java.lang.String  boolean)void
    .registers 4
    # ins_size=4
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader;->loadPreviewUrl(Ljava/lang/String; Ljava/lang/String; Z)V
    return-void 
.end method

.method private final loadPreviewUrl(java.lang.String  java.lang.String  boolean)void
    .registers 13
    # ins_size=4
    if-eqz v12, +02bh
    const-string v12, "content://"
    const/4 v0, 0
    const/4 v1, 2
    const/4 v2, 0
    invoke-static v11, v12, v0, v1, v2, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v12
    if-nez v12, +020h
    const-string v12, "file://"
    invoke-static v11, v12, v0, v1, v2, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v12
    if-eqz v12, +003h
    goto +16h
    iget-object v12, v9, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader;->lifecycleScope Landroidx/lifecycle/LifecycleCoroutineScope;
    move-object v3, v12
    check-cast v3, Lkotlinx/coroutines/CoroutineScope;
    const/4 v4, 0
    const/4 v5, 0
    new-instance v12, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader$loadPreviewUrl$1;
    invoke-direct v12, v9, v10, v11, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader$loadPreviewUrl$1;-><init>(Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    move-object v6, v12
    check-cast v6, Lkotlin/jvm/functions/Function2;
    const/4 v7, 3
    const/4 v8, 0
    invoke-static/range v3 ... v8, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
    iget-object v10, v9, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader;->previewView Lcom/facebook/drawee/view/SimpleDraweeView;
    invoke-static Lcom/facebook/drawee/backends/pipeline/Fresco;->newDraweeControllerBuilder()Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;
    move-result-object v12
    invoke-static v11, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v11
    invoke-virtual v12, v11, Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;->setUri(Landroid/net/Uri;)Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;
    move-result-object v11
    const/4 v12, 1
    invoke-virtual v11, v12, Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;->setAutoPlayAnimations(Z)Lcom/facebook/drawee/controller/AbstractDraweeControllerBuilder;
    move-result-object v11
    check-cast v11, Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;
    iget-object v12, v9, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader;->previewView Lcom/facebook/drawee/view/SimpleDraweeView;
    invoke-virtual v12, Lcom/facebook/drawee/view/SimpleDraweeView;->getController()Lcom/facebook/drawee/interfaces/DraweeController;
    move-result-object v12
    invoke-virtual v11, v12, Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;->setOldController(Lcom/facebook/drawee/interfaces/DraweeController;)Lcom/facebook/drawee/controller/AbstractDraweeControllerBuilder;
    move-result-object v11
    check-cast v11, Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;
    invoke-virtual v11, Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;->build()Lcom/facebook/drawee/controller/AbstractDraweeController;
    move-result-object v11
    check-cast v11, Lcom/facebook/drawee/interfaces/DraweeController;
    invoke-virtual v10, v11, Lcom/facebook/drawee/view/SimpleDraweeView;->setController(Lcom/facebook/drawee/interfaces/DraweeController;)V
    return-void 
.end method

.method public final clear()void
    .registers 3
    # ins_size=1
    const/4 v0, 0
    iput-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader;->boundImageSource Ljava/lang/String;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader;->previewView Lcom/facebook/drawee/view/SimpleDraweeView;
    invoke-virtual v1, v0, Lcom/facebook/drawee/view/SimpleDraweeView;->setController(Lcom/facebook/drawee/interfaces/DraweeController;)V
    return-void 
.end method

.method public final load(com.bytedance.trae.conversation.brainstorm.widget.BrainstormVoiceHistorySheet$HistoryRow$UserAttachment)void
    .registers 14
    # ins_size=2
    const-string/jumbo v0, row
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v13, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;->getPreviewImageId()Ljava/lang/String;
    move-result-object v5
    move-object v0, v5
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v1, 0
    const/4 v2, 1
    if-eqz v0, +00bh
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    if-eqz v0, +003h
    goto +3h
    move v0, v1
    goto +2h
    move v0, v2
    const/4 v3, 0
    if-eqz v0, +00ch
    invoke-virtual v13, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;->getPreviewResourceUri()Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheetKt;->access$normalizeRemoteResourceId(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    move-object v4, v0
    goto +2h
    move-object v4, v3
    if-nez v5, +004h
    move-object v0, v4
    goto +2h
    move-object v0, v5
    if-nez v0, +006h
    invoke-virtual v12, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader;->clear()V
    return-void 
    iput-object v0, v12, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader;->boundImageSource Ljava/lang/String;
    iget-object v6, v12, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader;->previewView Lcom/facebook/drawee/view/SimpleDraweeView;
    invoke-virtual v6, Lcom/facebook/drawee/view/SimpleDraweeView;->getHierarchy()Lcom/facebook/drawee/interfaces/DraweeHierarchy;
    move-result-object v6
    check-cast v6, Lcom/facebook/drawee/generic/GenericDraweeHierarchy;
    sget v7, Lcom/bytedance/trae/common_ui/R$drawable;->trae_bg_image_loading I
    sget-object v8, Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;->CENTER_CROP Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;
    invoke-virtual v6, v7, v8, Lcom/facebook/drawee/generic/GenericDraweeHierarchy;->setPlaceholderImage(I Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;)V
    iget-object v6, v12, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader;->previewView Lcom/facebook/drawee/view/SimpleDraweeView;
    invoke-virtual v6, v3, Lcom/facebook/drawee/view/SimpleDraweeView;->setController(Lcom/facebook/drawee/interfaces/DraweeController;)V
    sget-object v3, Lcom/bytedance/trae/conversation/imageupload/ResourceRepoManager;->INSTANCE Lcom/bytedance/trae/conversation/imageupload/ResourceRepoManager;
    invoke-virtual v3, v0, Lcom/bytedance/trae/conversation/imageupload/ResourceRepoManager;->get(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    if-eqz v3, +009h
    if-eqz v4, +003h
    move v1, v2
    invoke-direct v12, v0, v3, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader;->loadPreviewUrl(Ljava/lang/String; Ljava/lang/String; Z)V
    return-void 
    iget-object v1, v12, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader;->lifecycleScope Landroidx/lifecycle/LifecycleCoroutineScope;
    move-object v8, v1
    check-cast v8, Lkotlinx/coroutines/CoroutineScope;
    const/4 v9, 0
    const/4 v10, 0
    new-instance v11, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader$load$2;
    const/4 v7, 0
    move-object v1, v11
    move-object v2, v12
    move-object v3, v0
    move-object v6, v13
    invoke-direct/range v1 ... v7, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader$load$2;-><init>(Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryThumbnailLoader; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment; Lkotlin/coroutines/Continuation;)V
    move-object v13, v11
    check-cast v13, Lkotlin/jvm/functions/Function2;
    const/4 v0, 3
    const/4 v11, 0
    move-object v6, v8
    move-object v7, v9
    move-object v8, v10
    move-object v9, v13
    move v10, v0
    invoke-static/range v6 ... v11, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method
