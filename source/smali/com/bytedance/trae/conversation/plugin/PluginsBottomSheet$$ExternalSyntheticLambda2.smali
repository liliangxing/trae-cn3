# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet$$ExternalSyntheticLambda2;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet;
.field public final synthetic f$1:Landroid/view/View;
.field public final synthetic f$2:Landroidx/recyclerview/widget/RecyclerView;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.plugin.PluginsBottomSheet  android.view.View  androidx.recyclerview.widget.RecyclerView)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet$$ExternalSyntheticLambda2;->f$0 Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet$$ExternalSyntheticLambda2;->f$1 Landroid/view/View;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet$$ExternalSyntheticLambda2;->f$2 Landroidx/recyclerview/widget/RecyclerView;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 5
    # ins_size=2
    iget-object v0, v3, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet$$ExternalSyntheticLambda2;->f$0 Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet$$ExternalSyntheticLambda2;->f$1 Landroid/view/View;
    iget-object v2, v3, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet$$ExternalSyntheticLambda2;->f$2 Landroidx/recyclerview/widget/RecyclerView;
    check-cast v4, Ljava/util/List;
    invoke-static v0, v1, v2, v4, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet;->$r8$lambda$fFEWDOqLEPiJdIt31kvLZ3rPPe8(Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet; Landroid/view/View; Landroidx/recyclerview/widget/RecyclerView; Ljava/util/List;)Lkotlin/Unit;
    move-result-object v4
    return-object v4
.end method
