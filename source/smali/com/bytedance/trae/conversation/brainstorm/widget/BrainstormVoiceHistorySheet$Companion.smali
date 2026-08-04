# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$Companion;
.super Ljava/lang/Object;
.source "BrainstormVoiceHistorySheet.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$Companion;-><init>()V
    return-void 
.end method

.method public static final synthetic access$openImagePreview(com.bytedance.trae.conversation.brainstorm.widget.BrainstormVoiceHistorySheet$Companion  android.content.Context  com.bytedance.trae.conversation.brainstorm.widget.BrainstormVoiceHistorySheet$HistoryRow$UserAttachment  java.util.List)void
    .registers 4
    # ins_size=4
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$Companion;->openImagePreview(Landroid/content/Context; Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment; Ljava/util/List;)V
    return-void 
.end method

.method public static final synthetic access$putCache(com.bytedance.trae.conversation.brainstorm.widget.BrainstormVoiceHistorySheet$Companion  java.lang.String  com.bytedance.trae.conversation.brainstorm.widget.BrainstormVoiceHistorySheet$VoiceHistorySnapshot)void
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$Companion;->putCache(Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistorySnapshot;)V
    return-void 
.end method

.method private final openImagePreview(android.content.Context  com.bytedance.trae.conversation.brainstorm.widget.BrainstormVoiceHistorySheet$HistoryRow$UserAttachment  java.util.List)void
    .registers 13
    # ins_size=4
    invoke-virtual v11, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;->getPreviewImageId()Ljava/lang/String;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    const/4 v2, 0
    const/4 v3, 1
    if-eqz v1, +00bh
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    if-eqz v1, +003h
    goto +3h
    move v1, v2
    goto +2h
    move v1, v3
    const/16 v4, 10
    if-nez v1, +0eeh
    check-cast v12, Ljava/lang/Iterable;
    new-instance v11, Ljava/util/ArrayList;
    invoke-direct v11, Ljava/util/ArrayList;-><init>()V
    check-cast v11, Ljava/util/Collection;
    invoke-interface v12, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    if-eqz v5, +02ch
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    move-object v6, v5
    check-cast v6, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;->isImage()Z
    move-result v7
    if-eqz v7, +018h
    invoke-virtual v6, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;->getPreviewImageId()Ljava/lang/String;
    move-result-object v6
    check-cast v6, Ljava/lang/CharSequence;
    if-eqz v6, +00bh
    invoke-static v6, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v6
    if-eqz v6, +003h
    goto +3h
    move v6, v2
    goto +2h
    move v6, v3
    if-nez v6, +004h
    move v6, v3
    goto +2h
    move v6, v2
    if-eqz v6, -02ah
    invoke-interface v11, v5, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -2fh
    check-cast v11, Ljava/util/List;
    check-cast v11, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v11, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v11
    invoke-interface v11, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    if-eqz v5, +012h
    invoke-interface v11, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;->getPreviewImageId()Ljava/lang/String;
    move-result-object v5
    if-eqz v5, -010h
    invoke-interface v1, v5, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -15h
    check-cast v1, Ljava/util/List;
    move-object v11, v1
    check-cast v11, Ljava/util/Collection;
    invoke-interface v11, Ljava/util/Collection;->isEmpty()Z
    move-result v5
    xor-int/2addr v5, v3
    if-eqz v5, +07fh
    new-instance v5, Ljava/util/ArrayList;
    invoke-direct v5, Ljava/util/ArrayList;-><init>()V
    check-cast v5, Ljava/util/Collection;
    invoke-interface v12, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v12
    invoke-interface v12, Ljava/util/Iterator;->hasNext()Z
    move-result v6
    if-eqz v6, +02ch
    invoke-interface v12, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v6
    move-object v7, v6
    check-cast v7, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;->isImage()Z
    move-result v8
    if-eqz v8, +018h
    invoke-virtual v7, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;->getPreviewImageId()Ljava/lang/String;
    move-result-object v7
    check-cast v7, Ljava/lang/CharSequence;
    if-eqz v7, +00bh
    invoke-static v7, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v7
    if-eqz v7, +003h
    goto +3h
    move v7, v2
    goto +2h
    move v7, v3
    if-nez v7, +004h
    move v7, v3
    goto +2h
    move v7, v2
    if-eqz v7, -02ah
    invoke-interface v5, v6, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -2fh
    check-cast v5, Ljava/util/List;
    check-cast v5, Ljava/lang/Iterable;
    new-instance v12, Ljava/util/ArrayList;
    invoke-static v5, v4, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v3
    invoke-direct v12, v3, Ljava/util/ArrayList;-><init>(I)V
    check-cast v12, Ljava/util/Collection;
    invoke-interface v5, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +010h
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;->getFilename()Ljava/lang/String;
    move-result-object v4
    invoke-interface v12, v4, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -13h
    check-cast v12, Ljava/util/List;
    sget-object v3, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->Companion Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$Companion;
    new-instance v4, Ljava/util/ArrayList;
    invoke-direct v4, v11, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V
    invoke-interface v1, v0, Ljava/util/List;->indexOf(Ljava/lang/Object;)I
    move-result v11
    invoke-static v11, v2, Lkotlin/ranges/RangesKt;->coerceAtLeast(I I)I
    move-result v11
    new-instance v0, Ljava/util/ArrayList;
    check-cast v12, Ljava/util/Collection;
    invoke-direct v0, v12, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V
    invoke-virtual v3, v10, v4, v11, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$Companion;->startWithImageIds(Landroid/content/Context; Ljava/util/ArrayList; I Ljava/util/ArrayList;)V
    return-void 
    invoke-virtual v11, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;->getPreviewResourceUri()Ljava/lang/String;
    move-result-object v11
    invoke-static v11, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheetKt;->access$normalizeRemoteResourceId(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v11
    if-nez v11, +003h
    return-void 
    check-cast v12, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v12, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    if-eqz v5, +040h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    move-object v6, v5
    check-cast v6, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;->isImage()Z
    move-result v7
    if-eqz v7, +02ch
    invoke-virtual v6, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;->getPreviewImageId()Ljava/lang/String;
    move-result-object v7
    check-cast v7, Ljava/lang/CharSequence;
    if-eqz v7, +00bh
    invoke-static v7, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v7
    if-eqz v7, +003h
    goto +3h
    move v7, v2
    goto +2h
    move v7, v3
    if-eqz v7, +018h
    invoke-virtual v6, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;->getPreviewResourceUri()Ljava/lang/String;
    move-result-object v6
    check-cast v6, Ljava/lang/CharSequence;
    if-eqz v6, +00bh
    invoke-static v6, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v6
    if-eqz v6, +003h
    goto +3h
    move v6, v2
    goto +2h
    move v6, v3
    if-nez v6, +004h
    move v6, v3
    goto +2h
    move v6, v2
    if-eqz v6, -03eh
    invoke-interface v0, v5, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -43h
    check-cast v0, Ljava/util/List;
    check-cast v0, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    if-eqz v5, +01ah
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;->getPreviewResourceUri()Ljava/lang/String;
    move-result-object v5
    if-eqz v5, +007h
    invoke-static v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheetKt;->access$normalizeRemoteResourceId(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v5
    goto +2h
    const/4 v5, 0
    if-eqz v5, -018h
    invoke-interface v1, v5, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1dh
    check-cast v1, Ljava/util/List;
    move-object v0, v1
    check-cast v0, Ljava/util/Collection;
    invoke-interface v0, Ljava/util/Collection;->isEmpty()Z
    move-result v5
    xor-int/2addr v5, v3
    if-eqz v5, +093h
    new-instance v5, Ljava/util/ArrayList;
    invoke-direct v5, Ljava/util/ArrayList;-><init>()V
    check-cast v5, Ljava/util/Collection;
    invoke-interface v12, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v12
    invoke-interface v12, Ljava/util/Iterator;->hasNext()Z
    move-result v6
    if-eqz v6, +040h
    invoke-interface v12, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v6
    move-object v7, v6
    check-cast v7, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;->isImage()Z
    move-result v8
    if-eqz v8, +02ch
    invoke-virtual v7, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;->getPreviewImageId()Ljava/lang/String;
    move-result-object v8
    check-cast v8, Ljava/lang/CharSequence;
    if-eqz v8, +00bh
    invoke-static v8, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v8
    if-eqz v8, +003h
    goto +3h
    move v8, v2
    goto +2h
    move v8, v3
    if-eqz v8, +018h
    invoke-virtual v7, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;->getPreviewResourceUri()Ljava/lang/String;
    move-result-object v7
    check-cast v7, Ljava/lang/CharSequence;
    if-eqz v7, +00bh
    invoke-static v7, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v7
    if-eqz v7, +003h
    goto +3h
    move v7, v2
    goto +2h
    move v7, v3
    if-nez v7, +004h
    move v7, v3
    goto +2h
    move v7, v2
    if-eqz v7, -03eh
    invoke-interface v5, v6, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -43h
    check-cast v5, Ljava/util/List;
    check-cast v5, Ljava/lang/Iterable;
    new-instance v12, Ljava/util/ArrayList;
    invoke-static v5, v4, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v3
    invoke-direct v12, v3, Ljava/util/ArrayList;-><init>(I)V
    check-cast v12, Ljava/util/Collection;
    invoke-interface v5, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +010h
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$UserAttachment;->getFilename()Ljava/lang/String;
    move-result-object v4
    invoke-interface v12, v4, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -13h
    check-cast v12, Ljava/util/List;
    sget-object v3, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->Companion Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$Companion;
    new-instance v4, Ljava/util/ArrayList;
    invoke-direct v4, v0, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V
    invoke-interface v1, v11, Ljava/util/List;->indexOf(Ljava/lang/Object;)I
    move-result v11
    invoke-static v11, v2, Lkotlin/ranges/RangesKt;->coerceAtLeast(I I)I
    move-result v11
    new-instance v0, Ljava/util/ArrayList;
    check-cast v12, Ljava/util/Collection;
    invoke-direct v0, v12, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V
    invoke-virtual v3, v10, v4, v11, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$Companion;->startWithRemoteResources(Landroid/content/Context; Ljava/util/ArrayList; I Ljava/util/ArrayList;)V
    return-void 
.end method

.method private final synchronized putCache(java.lang.String  com.bytedance.trae.conversation.brainstorm.widget.BrainstormVoiceHistorySheet$VoiceHistorySnapshot)void
    .registers 4
    # ins_size=3
    monitor-enter v1
    invoke-static Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->access$getHistoryCache$cp()Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$Companion$historyCache$1;
    move-result-object v0
    check-cast v0, Ljava/util/Map;
    invoke-interface v0, v2, v3, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    monitor-exit v1
    return-void 
    move-exception v2
    monitor-exit v1
    throw v2
    :try_start_0x1
.end method

.method public final show(androidx.fragment.app.FragmentManager  java.lang.String  java.lang.String)void
    .registers 8
    # ins_size=4
    const-string v0, "fragmentManager"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, sessionId
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "conversationId"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "BrainstormVoiceHistorySheet"
    invoke-virtual v5, v0, Landroidx/fragment/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroidx/fragment/app/Fragment;
    move-result-object v1
    if-eqz v1, +003h
    return-void 
    new-instance v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;
    invoke-direct v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;-><init>()V
    new-instance v2, Landroid/os/Bundle;
    invoke-direct v2, Landroid/os/Bundle;-><init>()V
    const-string v3, "arg_session_id"
    invoke-virtual v2, v3, v6, Landroid/os/Bundle;->putString(Ljava/lang/String; Ljava/lang/String;)V
    const-string v6, "arg_conversation_id"
    invoke-virtual v2, v6, v7, Landroid/os/Bundle;->putString(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->setArguments(Landroid/os/Bundle;)V
    invoke-virtual v1, v5, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->show(Landroidx/fragment/app/FragmentManager; Ljava/lang/String;)V
    return-void 
.end method
