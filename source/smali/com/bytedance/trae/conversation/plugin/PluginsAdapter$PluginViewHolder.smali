# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/plugin/PluginsAdapter$PluginViewHolder;
.super Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
.source "PluginsAdapter.kt"

.field private final ivIcon:Lcom/facebook/drawee/view/SimpleDraweeView;
.field private final tvName:Landroid/widget/TextView;


.method public constructor <init>(android.view.View)void
    .registers 4
    # ins_size=2
    const-string v0, "itemView"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v2, v3, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;-><init>(Landroid/view/View;)V
    sget v0, Lcom/bytedance/trae/conversation/R$id;->iv_plugin_icon I
    invoke-virtual v3, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    const-string v1, "findViewById(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Lcom/facebook/drawee/view/SimpleDraweeView;
    iput-object v0, v2, Lcom/bytedance/trae/conversation/plugin/PluginsAdapter$PluginViewHolder;->ivIcon Lcom/facebook/drawee/view/SimpleDraweeView;
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_plugin_name I
    invoke-virtual v3, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v3
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v3, Landroid/widget/TextView;
    iput-object v3, v2, Lcom/bytedance/trae/conversation/plugin/PluginsAdapter$PluginViewHolder;->tvName Landroid/widget/TextView;
    return-void 
.end method

.method public final bind(com.bytedance.trae.conversation.network.PluginItem)void
    .registers 4
    # ins_size=2
    const-string v0, "item"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/plugin/PluginsAdapter$PluginViewHolder;->tvName Landroid/widget/TextView;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/network/PluginItem;->getDisplayName()Ljava/lang/String;
    move-result-object v1
    if-eqz v1, +005h
    check-cast v1, Ljava/lang/CharSequence;
    goto +dh
    invoke-virtual v3, Lcom/bytedance/trae/conversation/network/PluginItem;->getOriginPluginName()Ljava/lang/String;
    move-result-object v1
    if-eqz v1, +003h
    goto -9h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/network/PluginItem;->getName()Ljava/lang/String;
    move-result-object v1
    goto -eh
    invoke-virtual v0, v1, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-virtual v3, Lcom/bytedance/trae/conversation/network/PluginItem;->getIconUrl()Ljava/lang/String;
    move-result-object v3
    move-object v0, v3
    check-cast v0, Ljava/lang/CharSequence;
    if-eqz v0, +00bh
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    if-eqz v0, +003h
    goto +3h
    const/4 v0, 0
    goto +2h
    const/4 v0, 1
    if-nez v0, +00ch
    iget-object v0, v2, Lcom/bytedance/trae/conversation/plugin/PluginsAdapter$PluginViewHolder;->ivIcon Lcom/facebook/drawee/view/SimpleDraweeView;
    invoke-static v3, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v3
    invoke-virtual v0, v3, Lcom/facebook/drawee/view/SimpleDraweeView;->setImageURI(Landroid/net/Uri;)V
    goto +8h
    iget-object v3, v2, Lcom/bytedance/trae/conversation/plugin/PluginsAdapter$PluginViewHolder;->ivIcon Lcom/facebook/drawee/view/SimpleDraweeView;
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->ic_plugin_default I
    invoke-virtual v3, v0, Lcom/facebook/drawee/view/SimpleDraweeView;->setActualImageResource(I)V
    return-void 
.end method
