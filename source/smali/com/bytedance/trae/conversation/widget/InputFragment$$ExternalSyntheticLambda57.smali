# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda57;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/widget/InputFragment;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.widget.InputFragment)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda57;->f$0 Lcom/bytedance/trae/conversation/widget/InputFragment;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda57;->f$0 Lcom/bytedance/trae/conversation/widget/InputFragment;
    check-cast v2, Lcom/bytedance/trae/conversation/network/PluginItem;
    invoke-static v0, v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->$r8$lambda$skyNPrvIHALCUrtXiZvhWBPfcU4(Lcom/bytedance/trae/conversation/widget/InputFragment; Lcom/bytedance/trae/conversation/network/PluginItem;)Lkotlin/Unit;
    move-result-object v2
    return-object v2
.end method
