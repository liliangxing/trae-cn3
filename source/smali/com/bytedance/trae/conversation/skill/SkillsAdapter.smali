# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/skill/SkillsAdapter;
.super Landroidx/recyclerview/widget/RecyclerView$Adapter;
.source "SkillsAdapter.kt"

.field private items:Ljava/util/List;
.field private onItemClick:Lkotlin/jvm/functions/Function1;


.method public static synthetic $r8$lambda$XAP204xPymlw-GKzU-URD8FeVJI(com.bytedance.trae.conversation.skill.SkillsAdapter  com.bytedance.trae.conversation.network.SkillItem  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/skill/SkillsAdapter;->onBindViewHolder$lambda$1(Lcom/bytedance/trae/conversation/skill/SkillsAdapter; Lcom/bytedance/trae/conversation/network/SkillItem; Landroid/view/View;)V
    return-void 
.end method

.method public constructor <init>()void
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 3
    invoke-direct v2, v0, v0, v1, v0, Lcom/bytedance/trae/conversation/skill/SkillsAdapter;-><init>(Ljava/util/List; Lkotlin/jvm/functions/Function1; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(java.util.List  kotlin.jvm.functions.Function1)void
    .registers 4
    # ins_size=3
    const-string v0, "items"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Landroidx/recyclerview/widget/RecyclerView$Adapter;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/skill/SkillsAdapter;->items Ljava/util/List;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/skill/SkillsAdapter;->onItemClick Lkotlin/jvm/functions/Function1;
    return-void 
.end method

.method public synthetic constructor <init>(java.util.List  kotlin.jvm.functions.Function1  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 5
    # ins_size=5
    and-int/lit8 v4, v3, 1
    if-eqz v4, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v1
    and-int/lit8 v3, v3, 2
    if-eqz v3, +003h
    const/4 v2, 0
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/skill/SkillsAdapter;-><init>(Ljava/util/List; Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method

.method private static final onBindViewHolder$lambda$1(com.bytedance.trae.conversation.skill.SkillsAdapter  com.bytedance.trae.conversation.network.SkillItem  android.view.View)void
    .registers 3
    # ins_size=3
    iget-object v0, v0, Lcom/bytedance/trae/conversation/skill/SkillsAdapter;->onItemClick Lkotlin/jvm/functions/Function1;
    if-eqz v0, +005h
    invoke-interface v0, v1, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method public getItemCount()int
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/skill/SkillsAdapter;->items Ljava/util/List;
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v0
    return v0
.end method

.method public bridge synthetic onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder  int)void
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/trae/conversation/skill/SkillsAdapter$SkillViewHolder;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/skill/SkillsAdapter;->onBindViewHolder(Lcom/bytedance/trae/conversation/skill/SkillsAdapter$SkillViewHolder; I)V
    return-void 
.end method

.method public onBindViewHolder(com.bytedance.trae.conversation.skill.SkillsAdapter$SkillViewHolder  int)void
    .registers 5
    # ins_size=3
    const-string v0, "holder"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "onBindViewHolder: position="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", name="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/skill/SkillsAdapter;->items Ljava/util/List;
    invoke-interface v1, v4, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/network/SkillItem;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/network/SkillItem;->getName()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    const-string v1, "SkillsAdapter"
    invoke-static v1, v0, Landroid/util/Log;->d(Ljava/lang/String; Ljava/lang/String;)I
    iget-object v0, v2, Lcom/bytedance/trae/conversation/skill/SkillsAdapter;->items Ljava/util/List;
    invoke-interface v0, v4, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/conversation/network/SkillItem;
    invoke-virtual v3, v4, Lcom/bytedance/trae/conversation/skill/SkillsAdapter$SkillViewHolder;->bind(Lcom/bytedance/trae/conversation/network/SkillItem;)V
    iget-object v3, v3, Lcom/bytedance/trae/conversation/skill/SkillsAdapter$SkillViewHolder;->itemView Landroid/view/View;
    new-instance v0, Lcom/bytedance/trae/conversation/skill/SkillsAdapter$$ExternalSyntheticLambda0;
    invoke-direct v0, v2, v4, Lcom/bytedance/trae/conversation/skill/SkillsAdapter$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/skill/SkillsAdapter; Lcom/bytedance/trae/conversation/network/SkillItem;)V
    invoke-virtual v3, v0, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method

.method public bridge synthetic onCreateViewHolder(android.view.ViewGroup  int)androidx.recyclerview.widget.RecyclerView$ViewHolder
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/skill/SkillsAdapter;->onCreateViewHolder(Landroid/view/ViewGroup; I)Lcom/bytedance/trae/conversation/skill/SkillsAdapter$SkillViewHolder;
    move-result-object v1
    check-cast v1, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
    return-object v1
.end method

.method public onCreateViewHolder(android.view.ViewGroup  int)com.bytedance.trae.conversation.skill.SkillsAdapter$SkillViewHolder
    .registers 5
    # ins_size=3
    const-string v4, "parent"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v4, "SkillsAdapter"
    const-string v0, "onCreateViewHolder"
    invoke-static v4, v0, Landroid/util/Log;->d(Ljava/lang/String; Ljava/lang/String;)I
    invoke-virtual v3, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;
    move-result-object v4
    invoke-static v4, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;
    move-result-object v4
    sget v0, Lcom/bytedance/trae/conversation/R$layout;->item_conversation_skill I
    const/4 v1, 0
    invoke-virtual v4, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v3
    new-instance v4, Lcom/bytedance/trae/conversation/skill/SkillsAdapter$SkillViewHolder;
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v4, v3, Lcom/bytedance/trae/conversation/skill/SkillsAdapter$SkillViewHolder;-><init>(Landroid/view/View;)V
    return-object v4
.end method

.method public final setOnItemClickListener(kotlin.jvm.functions.Function1)void
    .registers 3
    # ins_size=2
    const-string v0, "listener"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/skill/SkillsAdapter;->onItemClick Lkotlin/jvm/functions/Function1;
    return-void 
.end method

.method public final updateData(java.util.List)void
    .registers 5
    # ins_size=2
    const-string v0, "newItems"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Ljava/lang/StringBuilder;
    const-string/jumbo v1, updateData: size=
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-interface v4, Ljava/util/List;->size()I
    move-result v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    const-string v1, "SkillsAdapter"
    invoke-static v1, v0, Landroid/util/Log;->d(Ljava/lang/String; Ljava/lang/String;)I
    check-cast v4, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v4, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v4
    invoke-interface v4, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +013h
    invoke-interface v4, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Lcom/bytedance/trae/conversation/network/SkillItem;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/network/SkillItem;->getEnabled()Z
    move-result v2
    if-eqz v2, -011h
    invoke-interface v0, v1, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -16h
    check-cast v0, Ljava/util/List;
    iput-object v0, v3, Lcom/bytedance/trae/conversation/skill/SkillsAdapter;->items Ljava/util/List;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/skill/SkillsAdapter;->notifyDataSetChanged()V
    return-void 
.end method
