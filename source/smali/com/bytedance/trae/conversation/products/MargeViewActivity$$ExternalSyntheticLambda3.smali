# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/products/MargeViewActivity$$ExternalSyntheticLambda3;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/view/View$OnClickListener;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/products/MargeViewActivity;
.field public final synthetic f$1:Ljava/lang/String;
.field public final synthetic f$2:Lcom/bytedance/trae/im/model/MergeChangedFilesData;
.field public final synthetic f$3:Ljava/lang/String;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.products.MargeViewActivity  java.lang.String  com.bytedance.trae.im.model.MergeChangedFilesData  java.lang.String)void
    .registers 5
    # ins_size=5
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/MargeViewActivity$$ExternalSyntheticLambda3;->f$0 Lcom/bytedance/trae/conversation/products/MargeViewActivity;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/products/MargeViewActivity$$ExternalSyntheticLambda3;->f$1 Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/products/MargeViewActivity$$ExternalSyntheticLambda3;->f$2 Lcom/bytedance/trae/im/model/MergeChangedFilesData;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/products/MargeViewActivity$$ExternalSyntheticLambda3;->f$3 Ljava/lang/String;
    return-void 
.end method

.method public final onClick(android.view.View)void
    .registers 6
    # ins_size=2
    iget-object v0, v4, Lcom/bytedance/trae/conversation/products/MargeViewActivity$$ExternalSyntheticLambda3;->f$0 Lcom/bytedance/trae/conversation/products/MargeViewActivity;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/products/MargeViewActivity$$ExternalSyntheticLambda3;->f$1 Ljava/lang/String;
    iget-object v2, v4, Lcom/bytedance/trae/conversation/products/MargeViewActivity$$ExternalSyntheticLambda3;->f$2 Lcom/bytedance/trae/im/model/MergeChangedFilesData;
    iget-object v3, v4, Lcom/bytedance/trae/conversation/products/MargeViewActivity$$ExternalSyntheticLambda3;->f$3 Ljava/lang/String;
    invoke-static v0, v1, v2, v3, v5, Lcom/bytedance/trae/conversation/products/MargeViewActivity;->$r8$lambda$sH9AmYZUGOyH3GJXehLlN_Z9BsI(Lcom/bytedance/trae/conversation/products/MargeViewActivity; Ljava/lang/String; Lcom/bytedance/trae/im/model/MergeChangedFilesData; Ljava/lang/String; Landroid/view/View;)V
    return-void 
.end method
