# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter;
.super Landroidx/recyclerview/widget/RecyclerView$Adapter;
.source "CheckpointOptionAdapter.kt"

.field private static final Companion:Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$Companion;
.field public static final SUBTITLE_COLLAPSED_FULL_LINES:I
.field public static final SUBTITLE_LINE_HEIGHT_DP:I
.field public static final SUBTITLE_PARTIAL_VISIBLE_LINE_RATIO:F
.field private final items:Ljava/util/List;
.field private final multiSelect:Z
.field private final onSelectionChanged:Lkotlin/jvm/functions/Function0;
.field private final onSingleSelectConfirmed:Lkotlin/jvm/functions/Function1;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter;->Companion Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$Companion;
    return-void 
.end method

.method public constructor <init>(boolean  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function1)void
    .registers 5
    # ins_size=4
    const-string v0, "onSelectionChanged"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Landroidx/recyclerview/widget/RecyclerView$Adapter;-><init>()V
    iput-boolean v2, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter;->multiSelect Z
    iput-object v3, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter;->onSelectionChanged Lkotlin/jvm/functions/Function0;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter;->onSingleSelectConfirmed Lkotlin/jvm/functions/Function1;
    new-instance v2, Ljava/util/ArrayList;
    invoke-direct v2, Ljava/util/ArrayList;-><init>()V
    check-cast v2, Ljava/util/List;
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter;->items Ljava/util/List;
    return-void 
.end method

.method public synthetic constructor <init>(boolean  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function1  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 6
    # ins_size=6
    and-int/lit8 v5, v4, 1
    if-eqz v5, +003h
    const/4 v1, 0
    and-int/lit8 v4, v4, 4
    if-eqz v4, +003h
    const/4 v3, 0
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter;-><init>(Z Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method

.method public static final synthetic access$getItems$p(com.bytedance.trae.conversation.chat.checkpoint.CheckpointOptionAdapter)java.util.List
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter;->items Ljava/util/List;
    return-object v0
.end method

.method public static final synthetic access$getMultiSelect$p(com.bytedance.trae.conversation.chat.checkpoint.CheckpointOptionAdapter)boolean
    .registers 1
    # ins_size=1
    iget-boolean v0, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter;->multiSelect Z
    return v0
.end method

.method public static final synthetic access$getOnSelectionChanged$p(com.bytedance.trae.conversation.chat.checkpoint.CheckpointOptionAdapter)kotlin.jvm.functions.Function0
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter;->onSelectionChanged Lkotlin/jvm/functions/Function0;
    return-object v0
.end method

.method public static final synthetic access$getOnSingleSelectConfirmed$p(com.bytedance.trae.conversation.chat.checkpoint.CheckpointOptionAdapter)kotlin.jvm.functions.Function1
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter;->onSingleSelectConfirmed Lkotlin/jvm/functions/Function1;
    return-object v0
.end method

.method public final clearSelection()boolean
    .registers 8
    # ins_size=1
    iget-object v0, v7, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter;->items Ljava/util/List;
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    const/4 v1, 0
    move v2, v1
    move v3, v2
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +01eh
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    add-int/lit8 v5, v3, 1
    if-gez v3, +005h
    invoke-static Lkotlin/collections/CollectionsKt;->throwIndexOverflow()V
    check-cast v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOption;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOption;->isSelected()Z
    move-result v6
    if-eqz v6, +009h
    invoke-virtual v4, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOption;->setSelected(Z)V
    invoke-virtual v7, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter;->notifyItemChanged(I)V
    const/4 v2, 1
    move v3, v5
    goto -21h
    return v2
.end method

.method public getItemCount()int
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter;->items Ljava/util/List;
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v0
    return v0
.end method

.method public final getSelectedOptions()java.util.List
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter;->items Ljava/util/List;
    check-cast v0, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +013h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    move-object v3, v2
    check-cast v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOption;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOption;->isSelected()Z
    move-result v3
    if-eqz v3, -011h
    invoke-interface v1, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -16h
    check-cast v1, Ljava/util/List;
    return-object v1
.end method

.method public bridge synthetic onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder  int)void
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter;->onBindViewHolder(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder; I)V
    return-void 
.end method

.method public onBindViewHolder(com.bytedance.trae.conversation.chat.checkpoint.CheckpointOptionAdapter$OptionViewHolder  int)void
    .registers 4
    # ins_size=3
    const-string v0, "holder"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter;->items Ljava/util/List;
    invoke-interface v0, v3, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOption;
    invoke-virtual v2, v0, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->bind(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOption; I)V
    return-void 
.end method

.method public bridge synthetic onCreateViewHolder(android.view.ViewGroup  int)androidx.recyclerview.widget.RecyclerView$ViewHolder
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter;->onCreateViewHolder(Landroid/view/ViewGroup; I)Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;
    move-result-object v1
    check-cast v1, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
    return-object v1
.end method

.method public onCreateViewHolder(android.view.ViewGroup  int)com.bytedance.trae.conversation.chat.checkpoint.CheckpointOptionAdapter$OptionViewHolder
    .registers 5
    # ins_size=3
    const-string v4, "parent"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v3, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;
    move-result-object v4
    invoke-static v4, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;
    move-result-object v4
    sget v0, Lcom/bytedance/trae/conversation/R$layout;->trae_item_checkpoint_option I
    const/4 v1, 0
    invoke-virtual v4, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v3
    new-instance v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v4, v2, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;-><init>(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter; Landroid/view/View;)V
    return-object v4
.end method

.method public final submitList(java.util.List)void
    .registers 3
    # ins_size=2
    const-string v0, "newItems"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter;->items Ljava/util/List;
    invoke-interface v0, Ljava/util/List;->clear()V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter;->items Ljava/util/List;
    check-cast v2, Ljava/util/Collection;
    invoke-interface v0, v2, Ljava/util/List;->addAll(Ljava/util/Collection;)Z
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter;->notifyDataSetChanged()V
    return-void 
.end method
