# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/skill/SkillsAdapter$SkillViewHolder;
.super Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
.source "SkillsAdapter.kt"

.field private final tvName:Landroid/widget/TextView;


.method public constructor <init>(android.view.View)void
    .registers 3
    # ins_size=2
    const-string v0, "itemView"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;-><init>(Landroid/view/View;)V
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_skill_name I
    invoke-virtual v2, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    const-string v0, "findViewById(...)"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Landroid/widget/TextView;
    iput-object v2, v1, Lcom/bytedance/trae/conversation/skill/SkillsAdapter$SkillViewHolder;->tvName Landroid/widget/TextView;
    return-void 
.end method

.method public final bind(com.bytedance.trae.conversation.network.SkillItem)void
    .registers 3
    # ins_size=2
    const-string v0, "item"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/skill/SkillsAdapter$SkillViewHolder;->tvName Landroid/widget/TextView;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/network/SkillItem;->getName()Ljava/lang/String;
    move-result-object v2
    check-cast v2, Ljava/lang/CharSequence;
    invoke-virtual v0, v2, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    return-void 
.end method
