# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/products/ArtifactListAdapter$ViewHolder;
.super Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
.source "ArtifactListAdapter.kt"

.field private final ivIcon:Landroid/widget/ImageView;
.field private final tvName:Landroid/widget/TextView;


.method public constructor <init>(android.view.View)void
    .registers 4
    # ins_size=2
    const-string v0, "itemView"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v2, v3, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;-><init>(Landroid/view/View;)V
    sget v0, Lcom/bytedance/trae/conversation/R$id;->iv_icon I
    invoke-virtual v3, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    const-string v1, "findViewById(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/ImageView;
    iput-object v0, v2, Lcom/bytedance/trae/conversation/products/ArtifactListAdapter$ViewHolder;->ivIcon Landroid/widget/ImageView;
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_name I
    invoke-virtual v3, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v3
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v3, Landroid/widget/TextView;
    iput-object v3, v2, Lcom/bytedance/trae/conversation/products/ArtifactListAdapter$ViewHolder;->tvName Landroid/widget/TextView;
    return-void 
.end method

.method public final getIvIcon()android.widget.ImageView
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/ArtifactListAdapter$ViewHolder;->ivIcon Landroid/widget/ImageView;
    return-object v0
.end method

.method public final getTvName()android.widget.TextView
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/ArtifactListAdapter$ViewHolder;->tvName Landroid/widget/TextView;
    return-object v0
.end method
