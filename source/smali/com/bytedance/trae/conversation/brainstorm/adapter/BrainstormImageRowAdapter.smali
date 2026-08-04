# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormImageRowAdapter;
.super Landroidx/recyclerview/widget/ListAdapter;
.source "BrainstormImageRowAdapter.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormImageRowAdapter$Companion;
.field private static final DIFF:Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormImageRowAdapter$Companion$DIFF$1;
.field private final callback:Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentCallback;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormImageRowAdapter$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormImageRowAdapter$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormImageRowAdapter;->Companion Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormImageRowAdapter$Companion;
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormImageRowAdapter$Companion$DIFF$1;
    invoke-direct v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormImageRowAdapter$Companion$DIFF$1;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormImageRowAdapter;->DIFF Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormImageRowAdapter$Companion$DIFF$1;
    return-void 
.end method

.method public constructor <init>(com.bytedance.trae.conversation.brainstorm.adapter.HistorySubtitleAdapter$AttachmentCallback)void
    .registers 3
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormImageRowAdapter;->DIFF Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormImageRowAdapter$Companion$DIFF$1;
    check-cast v0, Landroidx/recyclerview/widget/DiffUtil$ItemCallback;
    invoke-direct v1, v0, Landroidx/recyclerview/widget/ListAdapter;-><init>(Landroidx/recyclerview/widget/DiffUtil$ItemCallback;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormImageRowAdapter;->callback Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentCallback;
    return-void 
.end method

.method public bridge synthetic onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder  int)void
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormImageRowAdapter$ImageCellViewHolder;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormImageRowAdapter;->onBindViewHolder(Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormImageRowAdapter$ImageCellViewHolder; I)V
    return-void 
.end method

.method public onBindViewHolder(com.bytedance.trae.conversation.brainstorm.adapter.BrainstormImageRowAdapter$ImageCellViewHolder  int)void
    .registers 4
    # ins_size=3
    const-string v0, "holder"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v1, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormImageRowAdapter;->getItem(I)Ljava/lang/Object;
    move-result-object v3
    const-string v0, "getItem(...)"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormImageRowAdapter$ImageCellViewHolder;->bind(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;)V
    return-void 
.end method

.method public bridge synthetic onCreateViewHolder(android.view.ViewGroup  int)androidx.recyclerview.widget.RecyclerView$ViewHolder
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormImageRowAdapter;->onCreateViewHolder(Landroid/view/ViewGroup; I)Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormImageRowAdapter$ImageCellViewHolder;
    move-result-object v1
    check-cast v1, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
    return-object v1
.end method

.method public onCreateViewHolder(android.view.ViewGroup  int)com.bytedance.trae.conversation.brainstorm.adapter.BrainstormImageRowAdapter$ImageCellViewHolder
    .registers 5
    # ins_size=3
    const-string v4, "parent"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v3, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;
    move-result-object v4
    invoke-static v4, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;
    move-result-object v4
    sget v0, Lcom/bytedance/trae/conversation/R$layout;->trae_item_brainstorm_image_cell I
    const/4 v1, 0
    invoke-virtual v4, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v3
    const-string v4, "null cannot be cast to non-null type android.widget.FrameLayout"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v3, Landroid/widget/FrameLayout;
    new-instance v4, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormImageRowAdapter$ImageCellViewHolder;
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormImageRowAdapter;->callback Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentCallback;
    invoke-direct v4, v3, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormImageRowAdapter$ImageCellViewHolder;-><init>(Landroid/widget/FrameLayout; Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$AttachmentCallback;)V
    return-object v4
.end method
