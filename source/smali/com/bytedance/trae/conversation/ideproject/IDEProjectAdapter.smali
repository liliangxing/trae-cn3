# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/ideproject/IDEProjectAdapter;
.super Landroidx/recyclerview/widget/ListAdapter;
.source "IDEProjectAdapter.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/ideproject/IDEProjectAdapter$Companion;
.field private static final DiffCallback:Lcom/bytedance/trae/conversation/ideproject/IDEProjectAdapter$Companion$DiffCallback$1;
.field private final onItemClick:Lkotlin/jvm/functions/Function1;
.field private selectedProjectId:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/ideproject/IDEProjectAdapter$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/ideproject/IDEProjectAdapter$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/ideproject/IDEProjectAdapter;->Companion Lcom/bytedance/trae/conversation/ideproject/IDEProjectAdapter$Companion;
    new-instance v0, Lcom/bytedance/trae/conversation/ideproject/IDEProjectAdapter$Companion$DiffCallback$1;
    invoke-direct v0, Lcom/bytedance/trae/conversation/ideproject/IDEProjectAdapter$Companion$DiffCallback$1;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/ideproject/IDEProjectAdapter;->DiffCallback Lcom/bytedance/trae/conversation/ideproject/IDEProjectAdapter$Companion$DiffCallback$1;
    return-void 
.end method

.method public constructor <init>(kotlin.jvm.functions.Function1)void
    .registers 3
    # ins_size=2
    const-string v0, "onItemClick"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/ideproject/IDEProjectAdapter;->DiffCallback Lcom/bytedance/trae/conversation/ideproject/IDEProjectAdapter$Companion$DiffCallback$1;
    check-cast v0, Landroidx/recyclerview/widget/DiffUtil$ItemCallback;
    invoke-direct v1, v0, Landroidx/recyclerview/widget/ListAdapter;-><init>(Landroidx/recyclerview/widget/DiffUtil$ItemCallback;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/ideproject/IDEProjectAdapter;->onItemClick Lkotlin/jvm/functions/Function1;
    return-void 
.end method

.method public static final synthetic access$getItem(com.bytedance.trae.conversation.ideproject.IDEProjectAdapter  int)com.bytedance.trae.conversation.network.ProjectItem
    .registers 2
    # ins_size=2
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/ideproject/IDEProjectAdapter;->getItem(I)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/network/ProjectItem;
    return-object v0
.end method

.method public static final synthetic access$getOnItemClick$p(com.bytedance.trae.conversation.ideproject.IDEProjectAdapter)kotlin.jvm.functions.Function1
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/ideproject/IDEProjectAdapter;->onItemClick Lkotlin/jvm/functions/Function1;
    return-object v0
.end method

.method public static final synthetic access$getSelectedProjectId$p(com.bytedance.trae.conversation.ideproject.IDEProjectAdapter)java.lang.String
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/ideproject/IDEProjectAdapter;->selectedProjectId Ljava/lang/String;
    return-object v0
.end method

.method public bridge synthetic onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder  int)void
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/trae/conversation/ideproject/IDEProjectAdapter$ProjectViewHolder;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ideproject/IDEProjectAdapter;->onBindViewHolder(Lcom/bytedance/trae/conversation/ideproject/IDEProjectAdapter$ProjectViewHolder; I)V
    return-void 
.end method

.method public onBindViewHolder(com.bytedance.trae.conversation.ideproject.IDEProjectAdapter$ProjectViewHolder  int)void
    .registers 4
    # ins_size=3
    const-string v0, "holder"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v1, v3, Lcom/bytedance/trae/conversation/ideproject/IDEProjectAdapter;->getItem(I)Ljava/lang/Object;
    move-result-object v3
    const-string v0, "getItem(...)"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v3, Lcom/bytedance/trae/conversation/network/ProjectItem;
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/ideproject/IDEProjectAdapter$ProjectViewHolder;->bind(Lcom/bytedance/trae/conversation/network/ProjectItem;)V
    return-void 
.end method

.method public bridge synthetic onCreateViewHolder(android.view.ViewGroup  int)androidx.recyclerview.widget.RecyclerView$ViewHolder
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ideproject/IDEProjectAdapter;->onCreateViewHolder(Landroid/view/ViewGroup; I)Lcom/bytedance/trae/conversation/ideproject/IDEProjectAdapter$ProjectViewHolder;
    move-result-object v1
    check-cast v1, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
    return-object v1
.end method

.method public onCreateViewHolder(android.view.ViewGroup  int)com.bytedance.trae.conversation.ideproject.IDEProjectAdapter$ProjectViewHolder
    .registers 5
    # ins_size=3
    const-string v4, "parent"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v3, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;
    move-result-object v4
    invoke-static v4, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;
    move-result-object v4
    sget v0, Lcom/bytedance/trae/conversation/R$layout;->trae_item_ide_project I
    const/4 v1, 0
    invoke-virtual v4, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v3
    new-instance v4, Lcom/bytedance/trae/conversation/ideproject/IDEProjectAdapter$ProjectViewHolder;
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v4, v2, v3, Lcom/bytedance/trae/conversation/ideproject/IDEProjectAdapter$ProjectViewHolder;-><init>(Lcom/bytedance/trae/conversation/ideproject/IDEProjectAdapter; Landroid/view/View;)V
    return-object v4
.end method

.method public final setSelectedProjectId(java.lang.String)void
    .registers 8
    # ins_size=2
    iget-object v0, v6, Lcom/bytedance/trae/conversation/ideproject/IDEProjectAdapter;->selectedProjectId Ljava/lang/String;
    iput-object v7, v6, Lcom/bytedance/trae/conversation/ideproject/IDEProjectAdapter;->selectedProjectId Ljava/lang/String;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/ideproject/IDEProjectAdapter;->getCurrentList()Ljava/util/List;
    move-result-object v1
    const-string v2, "getCurrentList(...)"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v1, Ljava/lang/Iterable;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    const/4 v2, 0
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +028h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    add-int/lit8 v4, v2, 1
    if-gez v2, +005h
    invoke-static Lkotlin/collections/CollectionsKt;->throwIndexOverflow()V
    check-cast v3, Lcom/bytedance/trae/conversation/network/ProjectItem;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/network/ProjectItem;->getProjectId()Ljava/lang/String;
    move-result-object v5
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +00ch
    invoke-virtual v3, Lcom/bytedance/trae/conversation/network/ProjectItem;->getProjectId()Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v7, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +005h
    invoke-virtual v6, v2, Lcom/bytedance/trae/conversation/ideproject/IDEProjectAdapter;->notifyItemChanged(I)V
    move v2, v4
    goto -2bh
    return-void 
.end method
