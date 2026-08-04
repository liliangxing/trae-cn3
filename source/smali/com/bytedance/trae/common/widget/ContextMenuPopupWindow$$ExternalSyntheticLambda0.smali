# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/view/View$OnClickListener;

.field public final synthetic f$0:Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;
.field public final synthetic f$1:Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;


.method public synthetic constructor <init>(com.bytedance.trae.common.widget.ContextMenuPopupWindow  com.bytedance.trae.common.widget.ContextMenuPopupWindow$Item)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;
    iput-object v2, v0, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$$ExternalSyntheticLambda0;->f$1 Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;
    return-void 
.end method

.method public final onClick(android.view.View)void
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;
    iget-object v1, v2, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$$ExternalSyntheticLambda0;->f$1 Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;
    invoke-static v0, v1, v3, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;->$r8$lambda$HEz_gTUMF_D6hgyB-6ORZ6vemAg(Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow; Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item; Landroid/view/View;)V
    return-void 
.end method
