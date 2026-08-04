# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$ImageGroupRowVH$1;
.super Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;
.source "BrainstormVoiceHistorySheet.kt"

.field final synthetic $spacingPx:I


.method constructor <init>(int)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$ImageGroupRowVH$1;->$spacingPx I
    invoke-direct v0, Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;-><init>()V
    return-void 
.end method

.method public getItemOffsets(android.graphics.Rect  android.view.View  androidx.recyclerview.widget.RecyclerView  androidx.recyclerview.widget.RecyclerView$State)void
    .registers 6
    # ins_size=5
    const-string v0, "outRect"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, view
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "parent"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, state
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v4, v3, Landroidx/recyclerview/widget/RecyclerView;->getChildAdapterPosition(Landroid/view/View;)I
    move-result v3
    invoke-virtual v4, Landroidx/recyclerview/widget/RecyclerView;->getAdapter()Landroidx/recyclerview/widget/RecyclerView$Adapter;
    move-result-object v4
    if-eqz v4, +007h
    invoke-virtual v4, Landroidx/recyclerview/widget/RecyclerView$Adapter;->getItemCount()I
    move-result v4
    goto +2h
    const/4 v4, 0
    add-int/lit8 v4, v4, -1
    if-ge v3, v4, +006h
    iget v3, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$ImageGroupRowVH$1;->$spacingPx I
    iput v3, v2, Landroid/graphics/Rect;->right I
    return-void 
.end method
