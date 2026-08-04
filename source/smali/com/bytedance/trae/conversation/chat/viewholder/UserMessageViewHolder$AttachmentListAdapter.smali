# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;
.super Landroidx/recyclerview/widget/RecyclerView$Adapter;
.source "UserMessageViewHolder.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$Companion;
.field private static final VIEW_TYPE_FILE:I
.field private static final VIEW_TYPE_IMAGE:I
.field private chatSessionId:Ljava/lang/String;
.field private cliType:Ljava/lang/String;
.field private conversationId:Ljava/lang/String;
.field private items:Ljava/util/List;
.field private messageId:Ljava/lang/String;
.field private messageListener:Lcom/bytedance/trae/conversation/chat/IMessageListener;
.field private mode:Ljava/lang/String;
.field private resolvedUrls:Ljava/util/Map;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;->Companion Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Landroidx/recyclerview/widget/RecyclerView$Adapter;-><init>()V
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    iput-object v0, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;->items Ljava/util/List;
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v0
    iput-object v0, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;->resolvedUrls Ljava/util/Map;
    const-string v0, ""
    iput-object v0, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;->conversationId Ljava/lang/String;
    iput-object v0, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;->chatSessionId Ljava/lang/String;
    iput-object v0, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;->cliType Ljava/lang/String;
    iput-object v0, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;->mode Ljava/lang/String;
    iput-object v0, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;->messageId Ljava/lang/String;
    return-void 
.end method

.method private final allPreviewImages()java.util.List
    .registers 6
    # ins_size=1
    iget-object v0, v5, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;->messageListener Lcom/bytedance/trae/conversation/chat/IMessageListener;
    if-eqz v0, +065h
    invoke-interface v0, Lcom/bytedance/trae/conversation/chat/IMessageListener;->getAllMessages()Ljava/util/List;
    move-result-object v0
    if-eqz v0, +05fh
    check-cast v0, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +049h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isUserMessage()Z
    move-result v3
    if-nez v3, +007h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v2
    goto +31h
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getQuery()Ljava/util/List;
    move-result-object v2
    if-nez v2, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v2
    check-cast v2, Ljava/lang/Iterable;
    new-instance v3, Ljava/util/ArrayList;
    invoke-direct v3, Ljava/util/ArrayList;-><init>()V
    check-cast v3, Ljava/util/Collection;
    invoke-interface v2, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +012h
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/im/model/MessagePart;
    invoke-static v4, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolderKt;->previewImageItemFromData(Lcom/bytedance/trae/im/model/MessagePart;)Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem;
    move-result-object v4
    if-eqz v4, -010h
    invoke-interface v3, v4, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -15h
    move-object v2, v3
    check-cast v2, Ljava/util/List;
    check-cast v2, Ljava/lang/Iterable;
    invoke-static v1, v2, Lkotlin/collections/CollectionsKt;->addAll(Ljava/util/Collection; Ljava/lang/Iterable;)Z
    goto -4ch
    check-cast v1, Ljava/util/List;
    goto +2h
    const/4 v1, 0
    if-nez v1, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v1
    check-cast v1, Ljava/util/Collection;
    invoke-interface v1, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    if-eqz v0, +029h
    iget-object v0, v5, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;->items Ljava/util/List;
    check-cast v0, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +012h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/im/model/MessagePart;
    invoke-static v2, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolderKt;->previewImageItemFromData(Lcom/bytedance/trae/im/model/MessagePart;)Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem;
    move-result-object v2
    if-eqz v2, -010h
    invoke-interface v1, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -15h
    check-cast v1, Ljava/util/List;
    check-cast v1, Ljava/util/List;
    return-object v1
.end method

.method public final getChatSessionId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;->chatSessionId Ljava/lang/String;
    return-object v0
.end method

.method public final getCliType()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;->cliType Ljava/lang/String;
    return-object v0
.end method

.method public final getConversationId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;->conversationId Ljava/lang/String;
    return-object v0
.end method

.method public getItemCount()int
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;->items Ljava/util/List;
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v0
    return v0
.end method

.method public getItemViewType(int)int
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;->items Ljava/util/List;
    invoke-interface v0, v2, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/im/model/MessagePart;
    invoke-static v2, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolderKt;->access$isImageAttachmentPart(Lcom/bytedance/trae/im/model/MessagePart;)Z
    move-result v2
    xor-int/lit8 v2, v2, 1
    return v2
.end method

.method public final getMessageId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;->messageId Ljava/lang/String;
    return-object v0
.end method

.method public final getMessageListener()com.bytedance.trae.conversation.chat.IMessageListener
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;->messageListener Lcom/bytedance/trae/conversation/chat/IMessageListener;
    return-object v0
.end method

.method public final getMode()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;->mode Ljava/lang/String;
    return-object v0
.end method

.method public onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder  int)void
    .registers 12
    # ins_size=3
    const-string v0, "holder"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v9, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;->items Ljava/util/List;
    invoke-interface v0, v11, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v11
    move-object v1, v11
    check-cast v1, Lcom/bytedance/trae/im/model/MessagePart;
    instance-of v11, v10, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder;
    if-eqz v11, +019h
    invoke-direct v9, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;->allPreviewImages()Ljava/util/List;
    move-result-object v3
    move-object v0, v10
    check-cast v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder;
    iget-object v2, v9, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;->resolvedUrls Ljava/util/Map;
    iget-object v4, v9, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;->conversationId Ljava/lang/String;
    iget-object v5, v9, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;->chatSessionId Ljava/lang/String;
    iget-object v6, v9, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;->cliType Ljava/lang/String;
    iget-object v7, v9, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;->mode Ljava/lang/String;
    iget-object v8, v9, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;->messageId Ljava/lang/String;
    invoke-virtual/range v0 ... v8, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder;->bind(Lcom/bytedance/trae/im/model/MessagePart; Ljava/util/Map; Ljava/util/List; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    goto +15h
    instance-of v11, v10, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$FileViewHolder;
    if-eqz v11, +012h
    move-object v0, v10
    check-cast v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$FileViewHolder;
    iget-object v2, v9, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;->conversationId Ljava/lang/String;
    iget-object v3, v9, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;->cliType Ljava/lang/String;
    iget-object v4, v9, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;->mode Ljava/lang/String;
    iget-object v5, v9, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;->messageId Ljava/lang/String;
    iget-object v6, v9, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;->messageListener Lcom/bytedance/trae/conversation/chat/IMessageListener;
    invoke-virtual/range v0 ... v6, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$FileViewHolder;->bind(Lcom/bytedance/trae/im/model/MessagePart; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/IMessageListener;)V
    return-void 
.end method

.method public onCreateViewHolder(android.view.ViewGroup  int)androidx.recyclerview.widget.RecyclerView$ViewHolder
    .registers 7
    # ins_size=3
    const-string v0, "parent"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v5, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;
    move-result-object v0
    invoke-static v0, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;
    move-result-object v0
    const-string v1, "inflate(...)"
    const/4 v2, 0
    if-nez v6, +013h
    new-instance v6, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder;
    sget v3, Lcom/bytedance/trae/conversation/R$layout;->trae_item_chat_image I
    invoke-virtual v0, v3, v5, v2, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v5
    invoke-static v5, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v6, v5, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder;-><init>(Landroid/view/View;)V
    check-cast v6, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
    goto +11h
    new-instance v6, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$FileViewHolder;
    sget v3, Lcom/bytedance/trae/conversation/R$layout;->trae_item_chat_attachment I
    invoke-virtual v0, v3, v5, v2, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v5
    invoke-static v5, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v6, v5, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$FileViewHolder;-><init>(Landroid/view/View;)V
    check-cast v6, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
    return-object v6
.end method

.method public onViewRecycled(androidx.recyclerview.widget.RecyclerView$ViewHolder)void
    .registers 3
    # ins_size=2
    const-string v0, "holder"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    instance-of v0, v2, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder;
    if-eqz v0, +008h
    move-object v0, v2
    check-cast v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter$ImageViewHolder;->cancelLoad()V
    invoke-super v1, v2, Landroidx/recyclerview/widget/RecyclerView$Adapter;->onViewRecycled(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V
    return-void 
.end method

.method public final setChatSessionId(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string v0, "<set-?>"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;->chatSessionId Ljava/lang/String;
    return-void 
.end method

.method public final setCliType(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string v0, "<set-?>"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;->cliType Ljava/lang/String;
    return-void 
.end method

.method public final setConversationId(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string v0, "<set-?>"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;->conversationId Ljava/lang/String;
    return-void 
.end method

.method public final setMessageId(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string v0, "<set-?>"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;->messageId Ljava/lang/String;
    return-void 
.end method

.method public final setMessageListener(com.bytedance.trae.conversation.chat.IMessageListener)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;->messageListener Lcom/bytedance/trae/conversation/chat/IMessageListener;
    return-void 
.end method

.method public final setMode(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string v0, "<set-?>"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;->mode Ljava/lang/String;
    return-void 
.end method

.method public final submitList(java.util.List  java.util.Map)void
    .registers 4
    # ins_size=3
    const-string v0, "newItems"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, urls
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;->items Ljava/util/List;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;->resolvedUrls Ljava/util/Map;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;->notifyDataSetChanged()V
    return-void 
.end method

.method public final updateResolvedUrls(java.util.Map)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, urls
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;->resolvedUrls Ljava/util/Map;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;->notifyDataSetChanged()V
    return-void 
.end method
