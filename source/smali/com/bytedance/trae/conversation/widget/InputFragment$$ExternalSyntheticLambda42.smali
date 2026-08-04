# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda42;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Ljava/lang/Runnable;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/widget/InputFragment;
.field public final synthetic f$1:Landroid/widget/ImageView;
.field public final synthetic f$2:Landroid/view/View;
.field public final synthetic f$3:F


.method public synthetic constructor <init>(com.bytedance.trae.conversation.widget.InputFragment  android.widget.ImageView  android.view.View  float)void
    .registers 5
    # ins_size=5
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda42;->f$0 Lcom/bytedance/trae/conversation/widget/InputFragment;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda42;->f$1 Landroid/widget/ImageView;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda42;->f$2 Landroid/view/View;
    iput v4, v0, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda42;->f$3 F
    return-void 
.end method

.method public final run()void
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda42;->f$0 Lcom/bytedance/trae/conversation/widget/InputFragment;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda42;->f$1 Landroid/widget/ImageView;
    iget-object v2, v4, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda42;->f$2 Landroid/view/View;
    iget v3, v4, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda42;->f$3 F
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->$r8$lambda$VH-ls3tmCx9e6h2Kms1qyMjajNM(Lcom/bytedance/trae/conversation/widget/InputFragment; Landroid/widget/ImageView; Landroid/view/View; F)V
    return-void 
.end method
