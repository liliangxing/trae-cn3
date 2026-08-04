# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/view/View$OnClickListener;

.field public final synthetic f$0:Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;
.field public final synthetic f$1:Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;


.method public synthetic constructor <init>(com.bytedance.trae.home.solo.sitemessage.SiteMessageAdapter  com.bytedance.trae.home.solo.sitemessage.SiteMessageItem)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder$$ExternalSyntheticLambda0;->f$1 Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;
    return-void 
.end method

.method public final onClick(android.view.View)void
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder$$ExternalSyntheticLambda0;->f$1 Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;
    invoke-static v0, v1, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;->$r8$lambda$MLXttbv7IKduhBIZroYxVDfjym8(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter; Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem; Landroid/view/View;)V
    return-void 
.end method
