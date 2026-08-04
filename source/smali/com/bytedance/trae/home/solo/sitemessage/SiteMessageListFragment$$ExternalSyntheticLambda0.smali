# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/widget/PopupWindow$OnDismissListener;

.field public final synthetic f$0:Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;
.field public final synthetic f$1:Landroid/graphics/Bitmap;


.method public synthetic constructor <init>(com.bytedance.trae.home.solo.sitemessage.SiteMessageListFragment  android.graphics.Bitmap)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$$ExternalSyntheticLambda0;->f$1 Landroid/graphics/Bitmap;
    return-void 
.end method

.method public final onDismiss()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$$ExternalSyntheticLambda0;->f$1 Landroid/graphics/Bitmap;
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->$r8$lambda$qPdIVMIQBgpid1t7F-yDnvpAEoY(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment; Landroid/graphics/Bitmap;)V
    return-void 
.end method
