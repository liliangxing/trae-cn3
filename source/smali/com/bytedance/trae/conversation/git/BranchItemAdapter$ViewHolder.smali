# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/git/BranchItemAdapter$ViewHolder;
.super Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
.source "BranchItemAdapter.kt"

.field private final ivCheck:Landroid/widget/ImageView;
.field private final tvTitle:Landroid/widget/TextView;


.method public constructor <init>(android.view.View)void
    .registers 4
    # ins_size=2
    const-string/jumbo v0, view
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v2, v3, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;-><init>(Landroid/view/View;)V
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_title I
    invoke-virtual v3, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    const-string v1, "findViewById(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/TextView;
    iput-object v0, v2, Lcom/bytedance/trae/conversation/git/BranchItemAdapter$ViewHolder;->tvTitle Landroid/widget/TextView;
    sget v0, Lcom/bytedance/trae/conversation/R$id;->iv_check I
    invoke-virtual v3, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v3
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v3, Landroid/widget/ImageView;
    iput-object v3, v2, Lcom/bytedance/trae/conversation/git/BranchItemAdapter$ViewHolder;->ivCheck Landroid/widget/ImageView;
    return-void 
.end method

.method public final getIvCheck()android.widget.ImageView
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/git/BranchItemAdapter$ViewHolder;->ivCheck Landroid/widget/ImageView;
    return-object v0
.end method

.method public final getTvTitle()android.widget.TextView
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/git/BranchItemAdapter$ViewHolder;->tvTitle Landroid/widget/TextView;
    return-object v0
.end method
