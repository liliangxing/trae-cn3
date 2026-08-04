# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/plugin/PluginsAdapter$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/view/View$OnClickListener;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/plugin/PluginsAdapter;
.field public final synthetic f$1:Lcom/bytedance/trae/conversation/network/PluginItem;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.plugin.PluginsAdapter  com.bytedance.trae.conversation.network.PluginItem)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/plugin/PluginsAdapter$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/conversation/plugin/PluginsAdapter;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/plugin/PluginsAdapter$$ExternalSyntheticLambda0;->f$1 Lcom/bytedance/trae/conversation/network/PluginItem;
    return-void 
.end method

.method public final onClick(android.view.View)void
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/conversation/plugin/PluginsAdapter$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/conversation/plugin/PluginsAdapter;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/plugin/PluginsAdapter$$ExternalSyntheticLambda0;->f$1 Lcom/bytedance/trae/conversation/network/PluginItem;
    invoke-static v0, v1, v3, Lcom/bytedance/trae/conversation/plugin/PluginsAdapter;->$r8$lambda$94wJ4n_85t7Jdi593NkHIQMeBT8(Lcom/bytedance/trae/conversation/plugin/PluginsAdapter; Lcom/bytedance/trae/conversation/network/PluginItem; Landroid/view/View;)V
    return-void 
.end method
