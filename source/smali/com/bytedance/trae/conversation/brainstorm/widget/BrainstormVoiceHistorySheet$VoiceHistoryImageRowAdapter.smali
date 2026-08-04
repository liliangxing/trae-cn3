# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter;
.super Landroidx/recyclerview/widget/RecyclerView$Adapter;
.source "BrainstormVoiceHistorySheet.kt"

.field private final imageUploadApi:Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi;
.field private final images:Ljava/util/List;
.field private final lifecycleScope:Landroidx/lifecycle/LifecycleCoroutineScope;
.field private final previewRows:Ljava/util/List;
.field private final resourceUploadApi:Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;


.method public constructor <init>(androidx.lifecycle.LifecycleCoroutineScope  com.bytedance.trae.conversation.imageupload.ConversationCopilotImageUploadApi  com.bytedance.trae.conversation.fileupload.ConversationCopilotResourceUploadApi)void
    .registers 5
    # ins_size=4
    const-string v0, "lifecycleScope"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "imageUploadApi"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, resourceUploadApi
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Landroidx/recyclerview/widget/RecyclerView$Adapter;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter;->lifecycleScope Landroidx/lifecycle/LifecycleCoroutineScope;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter;->imageUploadApi Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter;->resourceUploadApi Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;
    new-instance v2, Ljava/util/ArrayList;
    invoke-direct v2, Ljava/util/ArrayList;-><init>()V
    check-cast v2, Ljava/util/List;
    iput-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter;->images Ljava/util/List;
    new-instance v2, Ljava/util/ArrayList;
    invoke-direct v2, Ljava/util/ArrayList;-><init>()V
    check-cast v2, Ljava/util/List;
    iput-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter;->previewRows Ljava/util/List;
    return-void 
.end method

.method public getItemCount()int
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter;->images Ljava/util/List;
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v0
    return v0
.end method

.method public bridge synthetic onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder  int)void
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter$ImageCellVH;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter;->onBindViewHolder(Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter$ImageCellVH; I)V
    return-void 
.end method

.method public onBindViewHolder(com.bytedance.trae.conversation.brainstorm.widget.BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter$ImageCellVH  int)void
    .registers 4
    # ins_size=3
    const-string v0, "holder"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter;->images Ljava/util/List;
    invoke-interface v0, v3, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter;->previewRows Ljava/util/List;
    invoke-virtual v2, v3, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter$ImageCellVH;->bind(Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment; Ljava/util/List;)V
    return-void 
.end method

.method public bridge synthetic onCreateViewHolder(android.view.ViewGroup  int)androidx.recyclerview.widget.RecyclerView$ViewHolder
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter;->onCreateViewHolder(Landroid/view/ViewGroup; I)Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter$ImageCellVH;
    move-result-object v1
    check-cast v1, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
    return-object v1
.end method

.method public onCreateViewHolder(android.view.ViewGroup  int)com.bytedance.trae.conversation.brainstorm.widget.BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter$ImageCellVH
    .registers 6
    # ins_size=3
    const-string v5, "parent"
    invoke-static v4, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v4, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;
    move-result-object v5
    invoke-static v5, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;
    move-result-object v5
    sget v0, Lcom/bytedance/trae/conversation/R$layout;->trae_item_brainstorm_image_cell I
    const/4 v1, 0
    invoke-virtual v5, v0, v4, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v4
    const-string v5, "null cannot be cast to non-null type android.widget.FrameLayout"
    invoke-static v4, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v4, Landroid/widget/FrameLayout;
    new-instance v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter$ImageCellVH;
    iget-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter;->lifecycleScope Landroidx/lifecycle/LifecycleCoroutineScope;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter;->imageUploadApi Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi;
    iget-object v2, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter;->resourceUploadApi Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;
    invoke-direct v5, v4, v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter$ImageCellVH;-><init>(Landroid/widget/FrameLayout; Landroidx/lifecycle/LifecycleCoroutineScope; Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi; Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;)V
    return-object v5
.end method

.method public bridge synthetic onViewRecycled(androidx.recyclerview.widget.RecyclerView$ViewHolder)void
    .registers 2
    # ins_size=2
    check-cast v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter$ImageCellVH;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter;->onViewRecycled(Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter$ImageCellVH;)V
    return-void 
.end method

.method public onViewRecycled(com.bytedance.trae.conversation.brainstorm.widget.BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter$ImageCellVH)void
    .registers 3
    # ins_size=2
    const-string v0, "holder"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter$ImageCellVH;->clear()V
    return-void 
.end method

.method public final submit(java.util.List  java.util.List)void
    .registers 4
    # ins_size=3
    const-string v0, "newImages"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "newPreviewRows"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter;->images Ljava/util/List;
    invoke-interface v0, Ljava/util/List;->clear()V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter;->images Ljava/util/List;
    check-cast v2, Ljava/util/Collection;
    invoke-interface v0, v2, Ljava/util/List;->addAll(Ljava/util/Collection;)Z
    iget-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter;->previewRows Ljava/util/List;
    invoke-interface v2, Ljava/util/List;->clear()V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter;->previewRows Ljava/util/List;
    check-cast v3, Ljava/util/Collection;
    invoke-interface v2, v3, Ljava/util/List;->addAll(Ljava/util/Collection;)Z
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter;->notifyDataSetChanged()V
    return-void 
.end method
