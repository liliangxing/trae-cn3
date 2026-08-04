# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$ImageGroupRowVH;
.super Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
.source "BrainstormVoiceHistorySheet.kt"

.field private final childAdapter:Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter;
.field private final rowView:Landroidx/recyclerview/widget/RecyclerView;


.method public constructor <init>(android.widget.FrameLayout  androidx.lifecycle.LifecycleCoroutineScope  com.bytedance.trae.conversation.imageupload.ConversationCopilotImageUploadApi  com.bytedance.trae.conversation.fileupload.ConversationCopilotResourceUploadApi)void
    .registers 7
    # ins_size=5
    const-string v0, "container"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "lifecycleScope"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "imageUploadApi"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, resourceUploadApi
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v0, v3
    check-cast v0, Landroid/view/View;
    invoke-direct v2, v0, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;-><init>(Landroid/view/View;)V
    sget v0, Lcom/bytedance/trae/conversation/R$id;->rv_image_row I
    invoke-virtual v3, v0, Landroid/widget/FrameLayout;->findViewById(I)Landroid/view/View;
    move-result-object v0
    const-string v1, "findViewById(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroidx/recyclerview/widget/RecyclerView;
    iput-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$ImageGroupRowVH;->rowView Landroidx/recyclerview/widget/RecyclerView;
    new-instance v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter;
    invoke-direct v1, v4, v5, v6, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter;-><init>(Landroidx/lifecycle/LifecycleCoroutineScope; Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi; Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;)V
    iput-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$ImageGroupRowVH;->childAdapter Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter;
    new-instance v4, Landroidx/recyclerview/widget/LinearLayoutManager;
    invoke-virtual v3, Landroid/widget/FrameLayout;->getContext()Landroid/content/Context;
    move-result-object v5
    const/4 v6, 0
    invoke-direct v4, v5, v6, v6, Landroidx/recyclerview/widget/LinearLayoutManager;-><init>(Landroid/content/Context; I Z)V
    check-cast v4, Landroidx/recyclerview/widget/RecyclerView$LayoutManager;
    invoke-virtual v0, v4, Landroidx/recyclerview/widget/RecyclerView;->setLayoutManager(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)V
    check-cast v1, Landroidx/recyclerview/widget/RecyclerView$Adapter;
    invoke-virtual v0, v1, Landroidx/recyclerview/widget/RecyclerView;->setAdapter(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V
    invoke-virtual v3, Landroid/widget/FrameLayout;->getResources()Landroid/content/res/Resources;
    move-result-object v3
    sget v4, Lcom/bytedance/trae/conversation/R$dimen;->trae_dp_8 I
    invoke-virtual v3, v4, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v3
    new-instance v4, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$ImageGroupRowVH$1;
    invoke-direct v4, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$ImageGroupRowVH$1;-><init>(I)V
    check-cast v4, Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;
    invoke-virtual v0, v4, Landroidx/recyclerview/widget/RecyclerView;->addItemDecoration(Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;)V
    return-void 
.end method

.method public final bind(java.util.List  java.util.List)void
    .registers 4
    # ins_size=3
    const-string v0, "images"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "previewRows"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$ImageGroupRowVH;->childAdapter Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter;
    invoke-virtual v0, v2, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryImageRowAdapter;->submit(Ljava/util/List; Ljava/util/List;)V
    return-void 
.end method
