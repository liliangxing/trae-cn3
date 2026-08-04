# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryAdapter;
.super Landroidx/recyclerview/widget/RecyclerView$Adapter;
.source "BrainstormVoiceHistorySheet.kt"

.field private final imageUploadApi:Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi;
.field private final lifecycleScope:Landroidx/lifecycle/LifecycleCoroutineScope;
.field private final resourceUploadApi:Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;
.field private final rows:Ljava/util/List;
.field final synthetic this$0:Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;


.method public constructor <init>(com.bytedance.trae.conversation.brainstorm.widget.BrainstormVoiceHistorySheet  androidx.lifecycle.LifecycleCoroutineScope  com.bytedance.trae.conversation.imageupload.ConversationCopilotImageUploadApi  com.bytedance.trae.conversation.fileupload.ConversationCopilotResourceUploadApi)void
    .registers 6
    # ins_size=5
    const-string v0, "lifecycleScope"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "imageUploadApi"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, resourceUploadApi
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryAdapter;->this$0 Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;
    invoke-direct v1, Landroidx/recyclerview/widget/RecyclerView$Adapter;-><init>()V
    iput-object v3, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryAdapter;->lifecycleScope Landroidx/lifecycle/LifecycleCoroutineScope;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryAdapter;->imageUploadApi Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi;
    iput-object v5, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryAdapter;->resourceUploadApi Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;
    new-instance v2, Ljava/util/ArrayList;
    invoke-direct v2, Ljava/util/ArrayList;-><init>()V
    check-cast v2, Ljava/util/List;
    iput-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryAdapter;->rows Ljava/util/List;
    return-void 
.end method

.method private final allPreviewImageRows()java.util.List
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryAdapter;->rows Ljava/util/List;
    check-cast v0, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +026h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow;
    instance-of v3, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;
    if-eqz v3, +007h
    invoke-static v2, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v2
    goto +10h
    instance-of v3, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserImageGroup;
    if-eqz v3, +009h
    check-cast v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserImageGroup;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserImageGroup;->getImages()Ljava/util/List;
    move-result-object v2
    goto +5h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v2
    check-cast v2, Ljava/lang/Iterable;
    invoke-static v1, v2, Lkotlin/collections/CollectionsKt;->addAll(Ljava/util/Collection; Ljava/lang/Iterable;)Z
    goto -29h
    check-cast v1, Ljava/util/List;
    check-cast v1, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +013h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    move-object v3, v2
    check-cast v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;->isImage()Z
    move-result v3
    if-eqz v3, -011h
    invoke-interface v0, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -16h
    check-cast v0, Ljava/util/List;
    return-object v0
.end method

.method private static final submit$appendImageRows(java.util.ArrayList  com.bytedance.trae.conversation.brainstorm.widget.BrainstormVoiceHistorySheet$VoiceHistoryAdapter)void
    .registers 4
    # ins_size=2
    invoke-virtual v2, Ljava/util/ArrayList;->size()I
    move-result v0
    if-eqz v0, +025h
    const/4 v1, 1
    if-eq v0, v1, +015h
    iget-object v3, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryAdapter;->rows Ljava/util/List;
    check-cast v3, Ljava/util/Collection;
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserImageGroup;
    check-cast v2, Ljava/lang/Iterable;
    invoke-static v2, Lkotlin/collections/CollectionsKt;->toList(Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v2
    invoke-direct v0, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserImageGroup;-><init>(Ljava/util/List;)V
    invoke-interface v3, v0, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto +eh
    iget-object v3, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryAdapter;->rows Ljava/util/List;
    check-cast v3, Ljava/util/Collection;
    check-cast v2, Ljava/util/List;
    invoke-static v2, Lkotlin/collections/CollectionsKt;->first(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v2
    invoke-interface v3, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    return-void 
.end method

.method public getItemCount()int
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryAdapter;->rows Ljava/util/List;
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v0
    return v0
.end method

.method public getItemViewType(int)int
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryAdapter;->rows Ljava/util/List;
    invoke-interface v0, v2, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow;
    instance-of v0, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserText;
    if-eqz v0, +004h
    const/4 v2, 1
    goto +12h
    instance-of v0, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;
    if-eqz v0, +004h
    const/4 v2, 2
    goto +ch
    instance-of v0, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserImageGroup;
    if-eqz v0, +004h
    const/4 v2, 3
    goto +6h
    instance-of v2, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$AssistantText;
    if-eqz v2, +004h
    const/4 v2, 0
    return v2
    new-instance v2, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v2, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v2
.end method

.method public onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder  int)void
    .registers 4
    # ins_size=3
    const-string v0, "holder"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryAdapter;->rows Ljava/util/List;
    invoke-interface v0, v3, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow;
    instance-of v0, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserText;
    if-eqz v0, +00eh
    check-cast v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$TextRowVH;
    check-cast v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserText;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserText;->getContent()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$TextRowVH;->bind(Ljava/lang/String;)V
    goto +30h
    instance-of v0, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$AssistantText;
    if-eqz v0, +00ah
    check-cast v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AssistantRowVH;
    check-cast v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$AssistantText;
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AssistantRowVH;->bind(Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$AssistantText;)V
    goto +24h
    instance-of v0, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;
    if-eqz v0, +00eh
    check-cast v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH;
    check-cast v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;
    invoke-direct v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryAdapter;->allPreviewImageRows()Ljava/util/List;
    move-result-object v0
    invoke-virtual v2, v3, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH;->bind(Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment; Ljava/util/List;)V
    goto +14h
    instance-of v0, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserImageGroup;
    if-eqz v0, +012h
    check-cast v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$ImageGroupRowVH;
    check-cast v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserImageGroup;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserImageGroup;->getImages()Ljava/util/List;
    move-result-object v3
    invoke-direct v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryAdapter;->allPreviewImageRows()Ljava/util/List;
    move-result-object v0
    invoke-virtual v2, v3, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$ImageGroupRowVH;->bind(Ljava/util/List; Ljava/util/List;)V
    return-void 
    new-instance v2, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v2, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v2
.end method

.method public onCreateViewHolder(android.view.ViewGroup  int)androidx.recyclerview.widget.RecyclerView$ViewHolder
    .registers 9
    # ins_size=3
    const-string v0, "parent"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v7, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;
    move-result-object v0
    invoke-static v0, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;
    move-result-object v0
    const-string v1, "inflate(...)"
    const/4 v2, 0
    if-eqz v8, +06eh
    const/4 v3, 1
    if-eq v8, v3, +05ah
    const/4 v1, 2
    const-string v3, "null cannot be cast to non-null type android.widget.FrameLayout"
    if-eq v8, v1, +034h
    const/4 v1, 3
    if-ne v8, v1, +01bh
    new-instance v8, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$ImageGroupRowVH;
    sget v1, Lcom/bytedance/trae/conversation/R$layout;->trae_item_brainstorm_attachment_group I
    invoke-virtual v0, v1, v7, v2, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v7
    invoke-static v7, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v7, Landroid/widget/FrameLayout;
    iget-object v0, v6, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryAdapter;->lifecycleScope Landroidx/lifecycle/LifecycleCoroutineScope;
    iget-object v1, v6, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryAdapter;->imageUploadApi Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi;
    iget-object v2, v6, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryAdapter;->resourceUploadApi Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;
    invoke-direct v8, v7, v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$ImageGroupRowVH;-><init>(Landroid/widget/FrameLayout; Landroidx/lifecycle/LifecycleCoroutineScope; Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi; Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;)V
    check-cast v8, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
    goto +59h
    new-instance v7, Ljava/lang/IllegalStateException;
    new-instance v0, Ljava/lang/StringBuilder;
    const-string/jumbo v1, unknown viewType=
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v8, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v8
    invoke-direct v7, v8, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v7
    new-instance v8, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH;
    sget v1, Lcom/bytedance/trae/conversation/R$layout;->trae_item_brainstorm_attachment I
    invoke-virtual v0, v1, v7, v2, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v7
    invoke-static v7, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v1, v7
    check-cast v1, Landroid/widget/FrameLayout;
    iget-object v7, v6, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryAdapter;->this$0 Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;
    invoke-static v7, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->access$getConversationId(Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;)Ljava/lang/String;
    move-result-object v2
    iget-object v3, v6, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryAdapter;->lifecycleScope Landroidx/lifecycle/LifecycleCoroutineScope;
    iget-object v4, v6, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryAdapter;->imageUploadApi Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi;
    iget-object v5, v6, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryAdapter;->resourceUploadApi Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;
    move-object v0, v8
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AttachmentRowVH;-><init>(Landroid/widget/FrameLayout; Ljava/lang/String; Landroidx/lifecycle/LifecycleCoroutineScope; Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi; Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;)V
    check-cast v8, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
    goto +22h
    new-instance v8, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$TextRowVH;
    sget v3, Lcom/bytedance/trae/conversation/R$layout;->trae_item_voice_history_user I
    invoke-virtual v0, v3, v7, v2, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v7
    invoke-static v7, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v8, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$TextRowVH;-><init>(Landroid/view/View;)V
    check-cast v8, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
    goto +11h
    new-instance v8, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AssistantRowVH;
    sget v3, Lcom/bytedance/trae/conversation/R$layout;->trae_item_voice_history_assistant I
    invoke-virtual v0, v3, v7, v2, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v7
    invoke-static v7, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v8, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AssistantRowVH;-><init>(Landroid/view/View;)V
    check-cast v8, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
    return-object v8
.end method

.method public final submit(java.util.List  java.lang.String)void
    .registers 20
    # ins_size=3
    move-object/from16 v0, v17
    const-string v1, "entries"
    move-object/from16 v2, v18
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryAdapter;->rows Ljava/util/List;
    invoke-interface v1, Ljava/util/List;->clear()V
    invoke-interface/range v18, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +125h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/voice/network/VoiceChatHistoryEntry;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/network/VoiceChatHistoryEntry;->getChatSessionId()Ljava/lang/String;
    move-result-object v3
    const/4 v4, 0
    if-eqz v3, +012h
    move-object v5, v3
    check-cast v5, Ljava/lang/CharSequence;
    invoke-static v5, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v5
    xor-int/lit8 v5, v5, 1
    if-eqz v5, +003h
    goto +2h
    move-object v3, v4
    if-eqz v3, +003h
    goto +3h
    move-object/from16 v3, v19
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/network/VoiceChatHistoryEntry;->getRole()Ljava/lang/String;
    move-result-object v5
    const-string/jumbo v6, user
    invoke-static v5, v6, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, +0b9h
    sget-object v5, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceHistoryContentParser;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceHistoryContentParser;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/network/VoiceChatHistoryEntry;->getContent()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v5, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceHistoryContentParser;->parseUserContent(Ljava/lang/String;)Ljava/util/List;
    move-result-object v2
    new-instance v5, Ljava/util/ArrayList;
    invoke-direct v5, Ljava/util/ArrayList;-><init>()V
    new-instance v6, Ljava/util/ArrayList;
    invoke-direct v6, Ljava/util/ArrayList;-><init>()V
    invoke-interface v2, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v7
    if-eqz v7, +08dh
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart;
    instance-of v8, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Text;
    if-eqz v8, +029h
    check-cast v7, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Text;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Text;->getFromMultimodalJson()Z
    move-result v8
    if-nez v8, -016h
    invoke-virtual v7, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Text;->getContent()Ljava/lang/String;
    move-result-object v8
    check-cast v8, Ljava/lang/CharSequence;
    invoke-static v8, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v8
    xor-int/lit8 v8, v8, 1
    if-eqz v8, -024h
    iget-object v8, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryAdapter;->rows Ljava/util/List;
    check-cast v8, Ljava/util/Collection;
    new-instance v9, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserText;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Text;->getContent()Ljava/lang/String;
    move-result-object v7
    invoke-direct v9, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserText;-><init>(Ljava/lang/String;)V
    invoke-interface v8, v9, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -36h
    instance-of v8, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;
    if-eqz v8, +052h
    check-cast v7, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;->getUri()Ljava/lang/String;
    move-result-object v9
    invoke-virtual v7, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;->getFilename()Ljava/lang/String;
    move-result-object v10
    invoke-virtual v7, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;->isImage()Z
    move-result v11
    invoke-virtual v7, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;->getFile_size()J
    move-result-wide v12
    invoke-virtual v7, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;->getPreviewImageId()Ljava/lang/String;
    move-result-object v14
    invoke-virtual v7, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;->getPreviewResourceUri()Ljava/lang/String;
    move-result-object v15
    invoke-virtual v7, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;->getPreviewChatSessionId()Ljava/lang/String;
    move-result-object v7
    if-eqz v7, +014h
    move-object v8, v7
    check-cast v8, Ljava/lang/CharSequence;
    invoke-static v8, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v8
    xor-int/lit8 v8, v8, 1
    if-eqz v8, +003h
    goto +2h
    move-object v7, v4
    if-eqz v7, +005h
    move-object/from16 v16, v7
    goto +3h
    move-object/from16 v16, v3
    new-instance v7, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;
    move-object v8, v7
    invoke-direct/range v8 ... v16, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;-><init>(Ljava/lang/String; Ljava/lang/String; Z J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v7, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;->isImage()Z
    move-result v8
    if-eqz v8, +00ah
    move-object v8, v5
    check-cast v8, Ljava/util/Collection;
    invoke-interface v8, v7, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto/16 -081h
    move-object v8, v6
    check-cast v8, Ljava/util/Collection;
    invoke-interface v8, v7, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto/16 -089h
    new-instance v1, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v1, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v1
    invoke-static v5, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryAdapter;->submit$appendImageRows(Ljava/util/ArrayList; Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryAdapter;)V
    iget-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryAdapter;->rows Ljava/util/List;
    check-cast v2, Ljava/util/Collection;
    check-cast v6, Ljava/lang/Iterable;
    invoke-static v2, v6, Lkotlin/collections/CollectionsKt;->addAll(Ljava/util/Collection; Ljava/lang/Iterable;)Z
    goto/16 -0e7h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/network/VoiceChatHistoryEntry;->getContent()Ljava/lang/String;
    move-result-object v3
    if-nez v3, +004h
    const-string v3, ""
    invoke-static v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessageKt;->parseAttachedSubTaskId(Ljava/lang/String;)Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;
    move-result-object v5
    invoke-virtual v5, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;->isIncompleteHead()Z
    move-result v6
    if-eqz v6, +003h
    goto +5h
    invoke-virtual v5, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;->getCleanedText()Ljava/lang/String;
    move-result-object v3
    move-object v5, v3
    check-cast v5, Ljava/lang/CharSequence;
    invoke-static v5, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v5
    if-nez v5, -107h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/network/VoiceChatHistoryEntry;->getTaskStatus()Ljava/lang/String;
    move-result-object v2
    if-eqz v2, +00eh
    move-object v5, v2
    check-cast v5, Ljava/lang/CharSequence;
    invoke-static v5, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v5
    xor-int/lit8 v5, v5, 1
    if-eqz v5, +003h
    move-object v4, v2
    iget-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryAdapter;->rows Ljava/util/List;
    check-cast v2, Ljava/util/Collection;
    new-instance v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$AssistantText;
    invoke-direct v5, v3, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$AssistantText;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    invoke-interface v2, v5, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto/16 -127h
    invoke-virtual/range v17, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistoryAdapter;->notifyDataSetChanged()V
    return-void 
.end method
