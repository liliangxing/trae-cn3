# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/view/View$OnClickListener;

.field public final synthetic f$0:Landroid/widget/PopupWindow;
.field public final synthetic f$1:Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;
.field public final synthetic f$2:I
.field public final synthetic f$3:Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;


.method public synthetic constructor <init>(android.widget.PopupWindow  com.bytedance.trae.home.solo.sitemessage.SiteMessageListFragment  int  com.bytedance.trae.home.solo.sitemessage.SiteMessageItem)void
    .registers 5
    # ins_size=5
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$$ExternalSyntheticLambda1;->f$0 Landroid/widget/PopupWindow;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$$ExternalSyntheticLambda1;->f$1 Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;
    iput v3, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$$ExternalSyntheticLambda1;->f$2 I
    iput-object v4, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$$ExternalSyntheticLambda1;->f$3 Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;
    return-void 
.end method

.method public final onClick(android.view.View)void
    .registers 6
    # ins_size=2
    iget-object v0, v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$$ExternalSyntheticLambda1;->f$0 Landroid/widget/PopupWindow;
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$$ExternalSyntheticLambda1;->f$1 Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;
    iget v2, v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$$ExternalSyntheticLambda1;->f$2 I
    iget-object v3, v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$$ExternalSyntheticLambda1;->f$3 Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;
    invoke-static v0, v1, v2, v3, v5, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->$r8$lambda$-a8_kC1Mss4APWcN8JCmucZK2nc(Landroid/widget/PopupWindow; Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment; I Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem; Landroid/view/View;)V
    return-void 
.end method
