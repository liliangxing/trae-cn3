# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/devices/DirectoryAdapter;
.super Landroidx/recyclerview/widget/ListAdapter;
.source "DirectoryAdapter.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$Companion;
.field private static final VIEW_TYPE_EDITING:I
.field private static final VIEW_TYPE_NORMAL:I
.field private final onFolderNameCancelled:Lkotlin/jvm/functions/Function1;
.field private final onFolderNameConfirmed:Lkotlin/jvm/functions/Function2;
.field private final onNodeClick:Lkotlin/jvm/functions/Function1;
.field private final onNodeSelect:Lkotlin/jvm/functions/Function1;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter;->Companion Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$Companion;
    return-void 
.end method

.method public constructor <init>(kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function2  kotlin.jvm.functions.Function1)void
    .registers 6
    # ins_size=5
    const-string v0, "onNodeClick"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onNodeSelect"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onFolderNameConfirmed"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onFolderNameCancelled"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/devices/DirectoryDiffCallback;
    invoke-direct v0, Lcom/bytedance/trae/conversation/devices/DirectoryDiffCallback;-><init>()V
    check-cast v0, Landroidx/recyclerview/widget/DiffUtil$ItemCallback;
    invoke-direct v1, v0, Landroidx/recyclerview/widget/ListAdapter;-><init>(Landroidx/recyclerview/widget/DiffUtil$ItemCallback;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter;->onNodeClick Lkotlin/jvm/functions/Function1;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter;->onNodeSelect Lkotlin/jvm/functions/Function1;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter;->onFolderNameConfirmed Lkotlin/jvm/functions/Function2;
    iput-object v5, v1, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter;->onFolderNameCancelled Lkotlin/jvm/functions/Function1;
    return-void 
.end method

.method public static final synthetic access$getOnFolderNameCancelled$p(com.bytedance.trae.conversation.devices.DirectoryAdapter)kotlin.jvm.functions.Function1
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter;->onFolderNameCancelled Lkotlin/jvm/functions/Function1;
    return-object v0
.end method

.method public static final synthetic access$getOnFolderNameConfirmed$p(com.bytedance.trae.conversation.devices.DirectoryAdapter)kotlin.jvm.functions.Function2
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter;->onFolderNameConfirmed Lkotlin/jvm/functions/Function2;
    return-object v0
.end method

.method public static final synthetic access$getOnNodeClick$p(com.bytedance.trae.conversation.devices.DirectoryAdapter)kotlin.jvm.functions.Function1
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter;->onNodeClick Lkotlin/jvm/functions/Function1;
    return-object v0
.end method

.method public static final synthetic access$getOnNodeSelect$p(com.bytedance.trae.conversation.devices.DirectoryAdapter)kotlin.jvm.functions.Function1
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter;->onNodeSelect Lkotlin/jvm/functions/Function1;
    return-object v0
.end method

.method public getItemViewType(int)int
    .registers 2
    # ins_size=2
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter;->getItem(I)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/devices/DirectoryNode;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->isEditing()Z
    move-result v1
    return v1
.end method

.method public onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder  int)void
    .registers 4
    # ins_size=3
    const-string v0, "holder"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v1, v3, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter;->getItem(I)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/devices/DirectoryNode;
    instance-of v0, v2, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$NormalViewHolder;
    if-eqz v0, +00bh
    check-cast v2, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$NormalViewHolder;
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$NormalViewHolder;->bind(Lcom/bytedance/trae/conversation/devices/DirectoryNode;)V
    goto +dh
    instance-of v0, v2, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder;
    if-eqz v0, +00ah
    check-cast v2, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder;
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder;->bind(Lcom/bytedance/trae/conversation/devices/DirectoryNode;)V
    return-void 
.end method

.method public onCreateViewHolder(android.view.ViewGroup  int)androidx.recyclerview.widget.RecyclerView$ViewHolder
    .registers 6
    # ins_size=3
    const-string v0, "parent"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v4, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;
    move-result-object v0
    invoke-static v0, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;
    move-result-object v0
    const/4 v1, 1
    const/4 v2, 0
    if-ne v5, v1, +013h
    sget v5, Lcom/bytedance/trae/conversation/R$layout;->item_directory_node_editing I
    invoke-virtual v0, v5, v4, v2, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v4
    new-instance v5, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder;
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v5, v3, v4, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder;-><init>(Lcom/bytedance/trae/conversation/devices/DirectoryAdapter; Landroid/view/View;)V
    check-cast v5, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
    goto +11h
    sget v5, Lcom/bytedance/trae/conversation/R$layout;->item_directory_node I
    invoke-virtual v0, v5, v4, v2, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v4
    new-instance v5, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$NormalViewHolder;
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v5, v3, v4, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$NormalViewHolder;-><init>(Lcom/bytedance/trae/conversation/devices/DirectoryAdapter; Landroid/view/View;)V
    check-cast v5, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
    return-object v5
.end method
