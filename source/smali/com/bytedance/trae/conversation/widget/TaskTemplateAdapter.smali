# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/widget/TaskTemplateAdapter;
.super Landroidx/recyclerview/widget/ListAdapter;
.source "TaskTemplateAdapter.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/widget/TaskTemplateAdapter$Companion;
.field private static final DIFF_CALLBACK:Lcom/bytedance/trae/conversation/widget/TaskTemplateAdapter$Companion$DIFF_CALLBACK$1;
.field private final onItemClick:Lkotlin/jvm/functions/Function1;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/widget/TaskTemplateAdapter$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/widget/TaskTemplateAdapter$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/widget/TaskTemplateAdapter;->Companion Lcom/bytedance/trae/conversation/widget/TaskTemplateAdapter$Companion;
    new-instance v0, Lcom/bytedance/trae/conversation/widget/TaskTemplateAdapter$Companion$DIFF_CALLBACK$1;
    invoke-direct v0, Lcom/bytedance/trae/conversation/widget/TaskTemplateAdapter$Companion$DIFF_CALLBACK$1;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/widget/TaskTemplateAdapter;->DIFF_CALLBACK Lcom/bytedance/trae/conversation/widget/TaskTemplateAdapter$Companion$DIFF_CALLBACK$1;
    return-void 
.end method

.method public constructor <init>(kotlin.jvm.functions.Function1)void
    .registers 3
    # ins_size=2
    const-string v0, "onItemClick"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/widget/TaskTemplateAdapter;->DIFF_CALLBACK Lcom/bytedance/trae/conversation/widget/TaskTemplateAdapter$Companion$DIFF_CALLBACK$1;
    check-cast v0, Landroidx/recyclerview/widget/DiffUtil$ItemCallback;
    invoke-direct v1, v0, Landroidx/recyclerview/widget/ListAdapter;-><init>(Landroidx/recyclerview/widget/DiffUtil$ItemCallback;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/widget/TaskTemplateAdapter;->onItemClick Lkotlin/jvm/functions/Function1;
    return-void 
.end method

.method public bridge synthetic onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder  int)void
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/trae/conversation/widget/TaskTemplateAdapter$ViewHolder;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/widget/TaskTemplateAdapter;->onBindViewHolder(Lcom/bytedance/trae/conversation/widget/TaskTemplateAdapter$ViewHolder; I)V
    return-void 
.end method

.method public onBindViewHolder(com.bytedance.trae.conversation.widget.TaskTemplateAdapter$ViewHolder  int)void
    .registers 5
    # ins_size=3
    const-string v0, "holder"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v2, v4, Lcom/bytedance/trae/conversation/widget/TaskTemplateAdapter;->getItem(I)Ljava/lang/Object;
    move-result-object v0
    const-string v1, "getItem(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;
    invoke-virtual v3, v0, v4, Lcom/bytedance/trae/conversation/widget/TaskTemplateAdapter$ViewHolder;->bind(Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel; I)V
    return-void 
.end method

.method public bridge synthetic onCreateViewHolder(android.view.ViewGroup  int)androidx.recyclerview.widget.RecyclerView$ViewHolder
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/widget/TaskTemplateAdapter;->onCreateViewHolder(Landroid/view/ViewGroup; I)Lcom/bytedance/trae/conversation/widget/TaskTemplateAdapter$ViewHolder;
    move-result-object v1
    check-cast v1, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
    return-object v1
.end method

.method public onCreateViewHolder(android.view.ViewGroup  int)com.bytedance.trae.conversation.widget.TaskTemplateAdapter$ViewHolder
    .registers 4
    # ins_size=3
    const-string v3, "parent"
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v2, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;
    move-result-object v3
    invoke-static v3, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;
    move-result-object v3
    const/4 v0, 0
    invoke-static v3, v2, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemTaskTemplateBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/conversation/databinding/TraeItemTaskTemplateBinding;
    move-result-object v2
    const-string v3, "inflate(...)"
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v3, Lcom/bytedance/trae/conversation/widget/TaskTemplateAdapter$ViewHolder;
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/TaskTemplateAdapter;->onItemClick Lkotlin/jvm/functions/Function1;
    invoke-direct v3, v2, v0, Lcom/bytedance/trae/conversation/widget/TaskTemplateAdapter$ViewHolder;-><init>(Lcom/bytedance/trae/conversation/databinding/TraeItemTaskTemplateBinding; Lkotlin/jvm/functions/Function1;)V
    return-object v3
.end method
