# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/git/GitRepoItemAdapter;
.super Landroidx/recyclerview/widget/ListAdapter;
.source "GitRepoItemAdapter.kt"

.field public static final DiffCallback:Lcom/bytedance/trae/conversation/git/GitRepoItemAdapter$DiffCallback;
.field private final onRepoClick:Lkotlin/jvm/functions/Function1;


.method public static synthetic $r8$lambda$U6DH_VxjfEfqDUGvi6ptg3XKAzQ(com.bytedance.trae.conversation.git.GitRepoItem  com.bytedance.trae.conversation.git.GitRepoItemAdapter  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/git/GitRepoItemAdapter;->onBindViewHolder$lambda$0(Lcom/bytedance/trae/conversation/git/GitRepoItem; Lcom/bytedance/trae/conversation/git/GitRepoItemAdapter; Landroid/view/View;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/git/GitRepoItemAdapter$DiffCallback;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/git/GitRepoItemAdapter$DiffCallback;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/git/GitRepoItemAdapter;->DiffCallback Lcom/bytedance/trae/conversation/git/GitRepoItemAdapter$DiffCallback;
    return-void 
.end method

.method public constructor <init>(kotlin.jvm.functions.Function1)void
    .registers 3
    # ins_size=2
    const-string v0, "onRepoClick"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/git/GitRepoItemAdapter;->DiffCallback Lcom/bytedance/trae/conversation/git/GitRepoItemAdapter$DiffCallback;
    check-cast v0, Landroidx/recyclerview/widget/DiffUtil$ItemCallback;
    invoke-direct v1, v0, Landroidx/recyclerview/widget/ListAdapter;-><init>(Landroidx/recyclerview/widget/DiffUtil$ItemCallback;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/git/GitRepoItemAdapter;->onRepoClick Lkotlin/jvm/functions/Function1;
    return-void 
.end method

.method private static final onBindViewHolder$lambda$0(com.bytedance.trae.conversation.git.GitRepoItem  com.bytedance.trae.conversation.git.GitRepoItemAdapter  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-virtual v0, Lcom/bytedance/trae/conversation/git/GitRepoItem;->isEnabled()Z
    move-result v2
    if-eqz v2, +00ah
    iget-object v1, v1, Lcom/bytedance/trae/conversation/git/GitRepoItemAdapter;->onRepoClick Lkotlin/jvm/functions/Function1;
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-interface v1, v0, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method public bridge synthetic onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder  int)void
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/trae/conversation/git/GitRepoItemAdapter$ViewHolder;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/git/GitRepoItemAdapter;->onBindViewHolder(Lcom/bytedance/trae/conversation/git/GitRepoItemAdapter$ViewHolder; I)V
    return-void 
.end method

.method public onBindViewHolder(com.bytedance.trae.conversation.git.GitRepoItemAdapter$ViewHolder  int)void
    .registers 5
    # ins_size=3
    const-string v0, "holder"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v2, v4, Lcom/bytedance/trae/conversation/git/GitRepoItemAdapter;->getItem(I)Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/conversation/git/GitRepoItem;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/git/GitRepoItemAdapter$ViewHolder;->getTvTitle()Landroid/widget/TextView;
    move-result-object v0
    invoke-virtual v4, Lcom/bytedance/trae/conversation/git/GitRepoItem;->getTitle()Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v0, v1, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-virtual v4, Lcom/bytedance/trae/conversation/git/GitRepoItem;->isSelected()Z
    move-result v0
    if-eqz v0, +00ch
    invoke-virtual v3, Lcom/bytedance/trae/conversation/git/GitRepoItemAdapter$ViewHolder;->getIvRadio()Landroid/widget/ImageView;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->ic_radio_selected I
    invoke-virtual v0, v1, Landroid/widget/ImageView;->setImageResource(I)V
    goto +ah
    invoke-virtual v3, Lcom/bytedance/trae/conversation/git/GitRepoItemAdapter$ViewHolder;->getIvRadio()Landroid/widget/ImageView;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->ic_radio_unselected I
    invoke-virtual v0, v1, Landroid/widget/ImageView;->setImageResource(I)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/git/GitRepoItemAdapter$ViewHolder;->itemView Landroid/view/View;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/git/GitRepoItem;->isEnabled()Z
    move-result v1
    invoke-virtual v0, v1, Landroid/view/View;->setEnabled(Z)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/git/GitRepoItemAdapter$ViewHolder;->itemView Landroid/view/View;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/git/GitRepoItem;->isEnabled()Z
    move-result v1
    if-eqz v1, +005h
    const/high16 v1, 1065353216
    goto +4h
    const v1, 1045220557
    invoke-virtual v0, v1, Landroid/view/View;->setAlpha(F)V
    iget-object v3, v3, Lcom/bytedance/trae/conversation/git/GitRepoItemAdapter$ViewHolder;->itemView Landroid/view/View;
    new-instance v0, Lcom/bytedance/trae/conversation/git/GitRepoItemAdapter$$ExternalSyntheticLambda0;
    invoke-direct v0, v4, v2, Lcom/bytedance/trae/conversation/git/GitRepoItemAdapter$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/git/GitRepoItem; Lcom/bytedance/trae/conversation/git/GitRepoItemAdapter;)V
    invoke-virtual v3, v0, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method

.method public bridge synthetic onCreateViewHolder(android.view.ViewGroup  int)androidx.recyclerview.widget.RecyclerView$ViewHolder
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/git/GitRepoItemAdapter;->onCreateViewHolder(Landroid/view/ViewGroup; I)Lcom/bytedance/trae/conversation/git/GitRepoItemAdapter$ViewHolder;
    move-result-object v1
    check-cast v1, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
    return-object v1
.end method

.method public onCreateViewHolder(android.view.ViewGroup  int)com.bytedance.trae.conversation.git.GitRepoItemAdapter$ViewHolder
    .registers 5
    # ins_size=3
    const-string v4, "parent"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v3, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;
    move-result-object v4
    invoke-static v4, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;
    move-result-object v4
    sget v0, Lcom/bytedance/trae/conversation/R$layout;->trae_item_git_repo I
    const/4 v1, 0
    invoke-virtual v4, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v3
    new-instance v4, Lcom/bytedance/trae/conversation/git/GitRepoItemAdapter$ViewHolder;
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v4, v3, Lcom/bytedance/trae/conversation/git/GitRepoItemAdapter$ViewHolder;-><init>(Landroid/view/View;)V
    return-object v4
.end method
