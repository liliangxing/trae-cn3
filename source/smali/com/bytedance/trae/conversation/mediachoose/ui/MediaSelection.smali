# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;
.super Ljava/lang/Object;
.source "MediaSelection.kt"

.field private final config:Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;
.field private isSelectedVideo:Z
.field private keepOrigin:Z
.field private final selected:Ljava/util/ArrayList;


.method public constructor <init>(com.bytedance.trae.conversation.mediachoose.model.MediaChooseConfig)void
    .registers 3
    # ins_size=2
    const-string v0, "config"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;->config Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    iput-object v0, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;->selected Ljava/util/ArrayList;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->getKeepOriginDefault()Z
    move-result v2
    iput-boolean v2, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;->keepOrigin Z
    return-void 
.end method

.method public final getKeepOrigin()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;->keepOrigin Z
    return v0
.end method

.method public final getOrderText(long)java.lang.String
    .registers 10
    # ins_size=3
    iget-object v0, v7, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;->selected Ljava/util/ArrayList;
    check-cast v0, Ljava/util/List;
    invoke-interface v0, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v0
    const/4 v1, 0
    move v2, v1
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    const/4 v4, 1
    if-eqz v3, +019h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->getId()J
    move-result-wide v5
    cmp-long v3, v5, v8
    if-nez v3, +004h
    move v3, v4
    goto +2h
    move v3, v1
    if-eqz v3, +003h
    goto +5h
    add-int/lit8 v2, v2, 1
    goto -1dh
    const/4 v2, -1
    if-ltz v2, +008h
    add-int/2addr v2, v4
    invoke-static v2, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v8
    goto +3h
    const-string v8, ""
    return-object v8
.end method

.method public final isDisabled(com.bytedance.trae.conversation.mediachoose.model.MediaItem)boolean
    .registers 5
    # ins_size=2
    const-string v0, "item"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v4, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->getId()J
    move-result-wide v0
    invoke-virtual v3, v0, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;->isSelected(J)Z
    move-result v0
    const/4 v1, 0
    if-eqz v0, +003h
    return v1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;->selected Ljava/util/ArrayList;
    invoke-virtual v0, Ljava/util/ArrayList;->isEmpty()Z
    move-result v0
    if-eqz v0, +003h
    return v1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;->config Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->getMediaType()Lcom/bytedance/trae/conversation/mediachoose/model/MediaType;
    move-result-object v0
    sget-object v2, Lcom/bytedance/trae/conversation/mediachoose/model/MediaType;->ALL_EXCLUSIVE Lcom/bytedance/trae/conversation/mediachoose/model/MediaType;
    if-eq v0, v2, +003h
    return v1
    iget-boolean v0, v3, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;->isSelectedVideo Z
    if-nez v0, +007h
    invoke-virtual v4, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->isVideo()Z
    move-result v1
    goto +10h
    iget-object v0, v3, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;->config Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->getSingleVideo()Z
    move-result v0
    if-nez v0, +008h
    invoke-virtual v4, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->isVideo()Z
    move-result v4
    if-nez v4, +003h
    const/4 v1, 1
    return v1
.end method

.method public final isSelected(long)boolean
    .registers 8
    # ins_size=3
    iget-object v0, v5, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;->selected Ljava/util/ArrayList;
    check-cast v0, Ljava/lang/Iterable;
    instance-of v1, v0, Ljava/util/Collection;
    const/4 v2, 0
    if-eqz v1, +00ch
    move-object v1, v0
    check-cast v1, Ljava/util/Collection;
    invoke-interface v1, Ljava/util/Collection;->isEmpty()Z
    move-result v1
    if-eqz v1, +003h
    goto +20h
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +017h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->getId()J
    move-result-wide v3
    cmp-long v1, v3, v6
    const/4 v3, 1
    if-nez v1, +004h
    move v1, v3
    goto +2h
    move v1, v2
    if-eqz v1, -018h
    move v2, v3
    return v2
.end method

.method public final isSelectedVideo()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;->isSelectedVideo Z
    return v0
.end method

.method public final selectedCount()int
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;->selected Ljava/util/ArrayList;
    invoke-virtual v0, Ljava/util/ArrayList;->size()I
    move-result v0
    return v0
.end method

.method public final selectedItems()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;->selected Ljava/util/ArrayList;
    check-cast v0, Ljava/lang/Iterable;
    invoke-static v0, Lkotlin/collections/CollectionsKt;->toList(Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v0
    return-object v0
.end method

.method public final setKeepOrigin(boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;->keepOrigin Z
    return-void 
.end method

.method public final setSelected(java.util.List)void
    .registers 4
    # ins_size=2
    const-string v0, "items"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;->selected Ljava/util/ArrayList;
    invoke-virtual v0, Ljava/util/ArrayList;->clear()V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;->selected Ljava/util/ArrayList;
    check-cast v3, Ljava/util/Collection;
    invoke-virtual v0, v3, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z
    iget-object v3, v2, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;->selected Ljava/util/ArrayList;
    check-cast v3, Ljava/util/List;
    invoke-static v3, Lkotlin/collections/CollectionsKt;->firstOrNull(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;
    const/4 v0, 0
    if-eqz v3, +00ah
    invoke-virtual v3, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->isVideo()Z
    move-result v3
    const/4 v1, 1
    if-ne v3, v1, +003h
    move v0, v1
    iput-boolean v0, v2, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;->isSelectedVideo Z
    return-void 
.end method

.method public final toggle(com.bytedance.trae.conversation.mediachoose.model.MediaItem)com.bytedance.trae.conversation.mediachoose.ui.MediaSelection$ToggleResult
    .registers 11
    # ins_size=2
    const-string v0, "item"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v9, v10, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;->isDisabled(Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;)Z
    move-result v0
    if-eqz v0, +005h
    sget-object v10, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection$ToggleResult;->BlockedByExclusive Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection$ToggleResult;
    return-object v10
    iget-object v0, v9, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;->selected Ljava/util/ArrayList;
    check-cast v0, Ljava/util/List;
    invoke-interface v0, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v0
    const/4 v1, 0
    move v2, v1
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    const/4 v4, 1
    if-eqz v3, +01dh
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->getId()J
    move-result-wide v5
    invoke-virtual v10, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->getId()J
    move-result-wide v7
    cmp-long v3, v5, v7
    if-nez v3, +004h
    move v3, v4
    goto +2h
    move v3, v1
    if-eqz v3, +003h
    goto +5h
    add-int/lit8 v2, v2, 1
    goto -21h
    const/4 v2, -1
    if-ltz v2, +02fh
    iget-object v10, v9, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;->selected Ljava/util/ArrayList;
    invoke-virtual v10, v2, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;
    iget-object v10, v9, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;->selected Ljava/util/ArrayList;
    invoke-virtual v10, Ljava/util/ArrayList;->isEmpty()Z
    move-result v10
    if-eqz v10, +005h
    iput-boolean v1, v9, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;->isSelectedVideo Z
    goto +1bh
    iget-object v10, v9, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;->config Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->getMediaType()Lcom/bytedance/trae/conversation/mediachoose/model/MediaType;
    move-result-object v10
    sget-object v0, Lcom/bytedance/trae/conversation/mediachoose/model/MediaType;->ALL_EXCLUSIVE Lcom/bytedance/trae/conversation/mediachoose/model/MediaType;
    if-ne v10, v0, +012h
    iget-object v10, v9, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;->selected Ljava/util/ArrayList;
    check-cast v10, Ljava/util/List;
    invoke-static v10, Lkotlin/collections/CollectionsKt;->first(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v10
    check-cast v10, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->isVideo()Z
    move-result v10
    iput-boolean v10, v9, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;->isSelectedVideo Z
    sget-object v10, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection$ToggleResult;->Removed Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection$ToggleResult;
    return-object v10
    iget-object v0, v9, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;->selected Ljava/util/ArrayList;
    invoke-virtual v0, Ljava/util/ArrayList;->size()I
    move-result v0
    iget-object v2, v9, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;->config Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->getMaxSelectCount()I
    move-result v2
    if-ne v0, v2, +004h
    move v0, v4
    goto +2h
    move v0, v1
    iget-object v2, v9, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;->config Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->getSingleVideo()Z
    move-result v2
    if-eqz v2, +00fh
    iget-object v2, v9, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;->selected Ljava/util/ArrayList;
    invoke-virtual v2, Ljava/util/ArrayList;->size()I
    move-result v2
    if-ne v2, v4, +007h
    iget-boolean v2, v9, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;->isSelectedVideo Z
    if-eqz v2, +003h
    move v1, v4
    if-nez v0, +01bh
    if-eqz v1, +003h
    goto +17h
    iget-object v0, v9, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;->selected Ljava/util/ArrayList;
    invoke-virtual v0, v10, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    iget-object v0, v9, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;->selected Ljava/util/ArrayList;
    invoke-virtual v0, Ljava/util/ArrayList;->size()I
    move-result v0
    if-ne v0, v4, +008h
    invoke-virtual v10, Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;->isVideo()Z
    move-result v10
    iput-boolean v10, v9, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;->isSelectedVideo Z
    sget-object v10, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection$ToggleResult;->Added Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection$ToggleResult;
    return-object v10
    sget-object v10, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection$ToggleResult;->ReachMax Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection$ToggleResult;
    return-object v10
.end method
