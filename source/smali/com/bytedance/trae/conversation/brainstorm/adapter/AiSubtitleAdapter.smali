# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter;
.super Landroidx/recyclerview/widget/RecyclerView$Adapter;
.source "AiSubtitleAdapter.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$Companion;
.field private static final PAYLOAD_FORCE_UPDATE:Ljava/lang/String;
.field private final lines:Ljava/util/List;
.field private translateSpeed:F


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter;->Companion Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Landroidx/recyclerview/widget/RecyclerView$Adapter;-><init>()V
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/List;
    iput-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter;->lines Ljava/util/List;
    const v0, 1058642330
    iput v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter;->translateSpeed F
    return-void 
.end method

.method public final appendLine(com.bytedance.trae.conversation.brainstorm.adapter.AiSubtitleAdapter$SubtitleLine)void
    .registers 3
    # ins_size=2
    const-string v0, "line"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter;->lines Ljava/util/List;
    invoke-interface v0, v2, Ljava/util/List;->add(Ljava/lang/Object;)Z
    iget-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter;->lines Ljava/util/List;
    invoke-static v2, Lkotlin/collections/CollectionsKt;->getLastIndex(Ljava/util/List;)I
    move-result v2
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter;->notifyItemInserted(I)V
    return-void 
.end method

.method public final clearAll()void
    .registers 3
    # ins_size=1
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter;->getItemCount()I
    move-result v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter;->lines Ljava/util/List;
    invoke-interface v1, Ljava/util/List;->clear()V
    const/4 v1, 0
    invoke-virtual v2, v1, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter;->notifyItemRangeRemoved(I I)V
    return-void 
.end method

.method public final forceUpdateLastLine(com.bytedance.trae.conversation.brainstorm.adapter.AiSubtitleAdapter$SubtitleLine)void
    .registers 4
    # ins_size=2
    const-string v0, "line"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter;->lines Ljava/util/List;
    check-cast v0, Ljava/util/Collection;
    invoke-interface v0, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    xor-int/lit8 v0, v0, 1
    if-eqz v0, +016h
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter;->lines Ljava/util/List;
    invoke-static v0, Lkotlin/collections/CollectionsKt;->getLastIndex(Ljava/util/List;)I
    move-result v1
    invoke-interface v0, v1, v3, Ljava/util/List;->set(I Ljava/lang/Object;)Ljava/lang/Object;
    iget-object v3, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter;->lines Ljava/util/List;
    invoke-static v3, Lkotlin/collections/CollectionsKt;->getLastIndex(Ljava/util/List;)I
    move-result v3
    const-string v0, "force_update"
    invoke-virtual v2, v3, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter;->notifyItemChanged(I Ljava/lang/Object;)V
    return-void 
.end method

.method public getItemCount()int
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter;->lines Ljava/util/List;
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v0
    return v0
.end method

.method public final getLastLine()com.bytedance.trae.conversation.brainstorm.adapter.AiSubtitleAdapter$SubtitleLine
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter;->lines Ljava/util/List;
    invoke-static v0, Lkotlin/collections/CollectionsKt;->lastOrNull(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$SubtitleLine;
    return-object v0
.end method

.method public final getTranslateSpeed()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter;->translateSpeed F
    return v0
.end method

.method public bridge synthetic onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder  int)void
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter;->onBindViewHolder(Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder; I)V
    return-void 
.end method

.method public bridge synthetic onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder  int  java.util.List)void
    .registers 4
    # ins_size=4
    check-cast v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder;
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter;->onBindViewHolder(Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder; I Ljava/util/List;)V
    return-void 
.end method

.method public onBindViewHolder(com.bytedance.trae.conversation.brainstorm.adapter.AiSubtitleAdapter$LineViewHolder  int)void
    .registers 4
    # ins_size=3
    const-string v0, "holder"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter;->lines Ljava/util/List;
    invoke-interface v0, v3, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$SubtitleLine;
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder;->bindImmediate(Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$SubtitleLine;)V
    return-void 
.end method

.method public onBindViewHolder(com.bytedance.trae.conversation.brainstorm.adapter.AiSubtitleAdapter$LineViewHolder  int  java.util.List)void
    .registers 5
    # ins_size=4
    const-string v0, "holder"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "payloads"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "force_update"
    invoke-interface v4, v0, Ljava/util/List;->contains(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +00eh
    iget-object v4, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter;->lines Ljava/util/List;
    invoke-interface v4, v3, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$SubtitleLine;
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder;->bindImmediate(Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$SubtitleLine;)V
    goto +6h
    check-cast v2, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
    invoke-super v1, v2, v3, v4, Landroidx/recyclerview/widget/RecyclerView$Adapter;->onBindViewHolder(Landroidx/recyclerview/widget/RecyclerView$ViewHolder; I Ljava/util/List;)V
    return-void 
.end method

.method public bridge synthetic onCreateViewHolder(android.view.ViewGroup  int)androidx.recyclerview.widget.RecyclerView$ViewHolder
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter;->onCreateViewHolder(Landroid/view/ViewGroup; I)Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder;
    move-result-object v1
    check-cast v1, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
    return-object v1
.end method

.method public onCreateViewHolder(android.view.ViewGroup  int)com.bytedance.trae.conversation.brainstorm.adapter.AiSubtitleAdapter$LineViewHolder
    .registers 5
    # ins_size=3
    const-string v4, "parent"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v3, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;
    move-result-object v4
    invoke-static v4, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;
    move-result-object v4
    sget v0, Lcom/bytedance/trae/conversation/R$layout;->trae_item_brainstorm_ai_subtitle I
    const/4 v1, 0
    invoke-virtual v4, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v3
    new-instance v4, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder;
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    iget v0, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter;->translateSpeed F
    invoke-direct v4, v3, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder;-><init>(Landroid/view/View; F)V
    return-object v4
.end method

.method public final setTranslateSpeed(float)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter;->translateSpeed F
    return-void 
.end method

.method public final updateLastLineData(com.bytedance.trae.conversation.brainstorm.adapter.AiSubtitleAdapter$SubtitleLine)void
    .registers 4
    # ins_size=2
    const-string v0, "line"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter;->lines Ljava/util/List;
    check-cast v0, Ljava/util/Collection;
    invoke-interface v0, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    xor-int/lit8 v0, v0, 1
    if-eqz v0, +00bh
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter;->lines Ljava/util/List;
    invoke-static v0, Lkotlin/collections/CollectionsKt;->getLastIndex(Ljava/util/List;)I
    move-result v1
    invoke-interface v0, v1, v3, Ljava/util/List;->set(I Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method
