# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/common/widget/SwipeRevealController$$ExternalSyntheticLambda3;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/view/View$OnLongClickListener;

.field public final synthetic f$0:Lcom/bytedance/trae/common/widget/SwipeRevealController;
.field public final synthetic f$1:Lkotlin/jvm/functions/Function1;


.method public synthetic constructor <init>(com.bytedance.trae.common.widget.SwipeRevealController  kotlin.jvm.functions.Function1)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/common/widget/SwipeRevealController$$ExternalSyntheticLambda3;->f$0 Lcom/bytedance/trae/common/widget/SwipeRevealController;
    iput-object v2, v0, Lcom/bytedance/trae/common/widget/SwipeRevealController$$ExternalSyntheticLambda3;->f$1 Lkotlin/jvm/functions/Function1;
    return-void 
.end method

.method public final onLongClick(android.view.View)boolean
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/common/widget/SwipeRevealController$$ExternalSyntheticLambda3;->f$0 Lcom/bytedance/trae/common/widget/SwipeRevealController;
    iget-object v1, v2, Lcom/bytedance/trae/common/widget/SwipeRevealController$$ExternalSyntheticLambda3;->f$1 Lkotlin/jvm/functions/Function1;
    invoke-static v0, v1, v3, Lcom/bytedance/trae/common/widget/SwipeRevealController;->$r8$lambda$By_amCgWFSirvHbDNsROOePwSKU(Lcom/bytedance/trae/common/widget/SwipeRevealController; Lkotlin/jvm/functions/Function1; Landroid/view/View;)Z
    move-result v3
    return v3
.end method
