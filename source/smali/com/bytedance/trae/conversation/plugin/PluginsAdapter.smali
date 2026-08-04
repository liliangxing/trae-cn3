# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/plugin/PluginsAdapter;
.super Landroidx/recyclerview/widget/RecyclerView$Adapter;
.source "PluginsAdapter.kt"

.field private final items:Ljava/util/List;
.field private onItemClickListener:Lkotlin/jvm/functions/Function1;


.method public static synthetic $r8$lambda$94wJ4n_85t7Jdi593NkHIQMeBT8(com.bytedance.trae.conversation.plugin.PluginsAdapter  com.bytedance.trae.conversation.network.PluginItem  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/plugin/PluginsAdapter;->onBindViewHolder$lambda$0(Lcom/bytedance/trae/conversation/plugin/PluginsAdapter; Lcom/bytedance/trae/conversation/network/PluginItem; Landroid/view/View;)V
    return-void 
.end method

.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Landroidx/recyclerview/widget/RecyclerView$Adapter;-><init>()V
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/List;
    iput-object v0, v1, Lcom/bytedance/trae/conversation/plugin/PluginsAdapter;->items Ljava/util/List;
    return-void 
.end method

.method private static final onBindViewHolder$lambda$0(com.bytedance.trae.conversation.plugin.PluginsAdapter  com.bytedance.trae.conversation.network.PluginItem  android.view.View)void
    .registers 3
    # ins_size=3
    iget-object v0, v0, Lcom/bytedance/trae/conversation/plugin/PluginsAdapter;->onItemClickListener Lkotlin/jvm/functions/Function1;
    if-eqz v0, +005h
    invoke-interface v0, v1, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method public final appendData(java.util.List)void
    .registers 5
    # ins_size=2
    const-string v0, "newItems"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/plugin/PluginsAdapter;->items Ljava/util/List;
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/plugin/PluginsAdapter;->items Ljava/util/List;
    move-object v2, v4
    check-cast v2, Ljava/util/Collection;
    invoke-interface v1, v2, Ljava/util/List;->addAll(Ljava/util/Collection;)Z
    invoke-interface v4, Ljava/util/List;->size()I
    move-result v4
    invoke-virtual v3, v0, v4, Lcom/bytedance/trae/conversation/plugin/PluginsAdapter;->notifyItemRangeInserted(I I)V
    return-void 
.end method

.method public getItemCount()int
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/plugin/PluginsAdapter;->items Ljava/util/List;
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v0
    return v0
.end method

.method public bridge synthetic onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder  int)void
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/trae/conversation/plugin/PluginsAdapter$PluginViewHolder;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/plugin/PluginsAdapter;->onBindViewHolder(Lcom/bytedance/trae/conversation/plugin/PluginsAdapter$PluginViewHolder; I)V
    return-void 
.end method

.method public onBindViewHolder(com.bytedance.trae.conversation.plugin.PluginsAdapter$PluginViewHolder  int)void
    .registers 4
    # ins_size=3
    const-string v0, "holder"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/plugin/PluginsAdapter;->items Ljava/util/List;
    invoke-interface v0, v3, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/network/PluginItem;
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/plugin/PluginsAdapter$PluginViewHolder;->bind(Lcom/bytedance/trae/conversation/network/PluginItem;)V
    iget-object v2, v2, Lcom/bytedance/trae/conversation/plugin/PluginsAdapter$PluginViewHolder;->itemView Landroid/view/View;
    new-instance v0, Lcom/bytedance/trae/conversation/plugin/PluginsAdapter$$ExternalSyntheticLambda0;
    invoke-direct v0, v1, v3, Lcom/bytedance/trae/conversation/plugin/PluginsAdapter$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/plugin/PluginsAdapter; Lcom/bytedance/trae/conversation/network/PluginItem;)V
    invoke-virtual v2, v0, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method

.method public bridge synthetic onCreateViewHolder(android.view.ViewGroup  int)androidx.recyclerview.widget.RecyclerView$ViewHolder
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/plugin/PluginsAdapter;->onCreateViewHolder(Landroid/view/ViewGroup; I)Lcom/bytedance/trae/conversation/plugin/PluginsAdapter$PluginViewHolder;
    move-result-object v1
    check-cast v1, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
    return-object v1
.end method

.method public onCreateViewHolder(android.view.ViewGroup  int)com.bytedance.trae.conversation.plugin.PluginsAdapter$PluginViewHolder
    .registers 5
    # ins_size=3
    const-string v4, "parent"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v3, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;
    move-result-object v4
    invoke-static v4, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;
    move-result-object v4
    sget v0, Lcom/bytedance/trae/conversation/R$layout;->item_conversation_plugin I
    const/4 v1, 0
    invoke-virtual v4, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v3
    new-instance v4, Lcom/bytedance/trae/conversation/plugin/PluginsAdapter$PluginViewHolder;
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v4, v3, Lcom/bytedance/trae/conversation/plugin/PluginsAdapter$PluginViewHolder;-><init>(Landroid/view/View;)V
    return-object v4
.end method

.method public final setOnItemClickListener(kotlin.jvm.functions.Function1)void
    .registers 3
    # ins_size=2
    const-string v0, "listener"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/plugin/PluginsAdapter;->onItemClickListener Lkotlin/jvm/functions/Function1;
    return-void 
.end method

.method public final updateData(java.util.List)void
    .registers 3
    # ins_size=2
    const-string v0, "newItems"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/plugin/PluginsAdapter;->items Ljava/util/List;
    invoke-interface v0, Ljava/util/List;->clear()V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/plugin/PluginsAdapter;->items Ljava/util/List;
    check-cast v2, Ljava/util/Collection;
    invoke-interface v0, v2, Ljava/util/List;->addAll(Ljava/util/Collection;)Z
    invoke-virtual v1, Lcom/bytedance/trae/conversation/plugin/PluginsAdapter;->notifyDataSetChanged()V
    return-void 
.end method
