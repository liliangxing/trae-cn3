# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$$ExternalSyntheticLambda7;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function3;

.field public final synthetic f$0:Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;


.method public synthetic constructor <init>(com.bytedance.trae.home.solo.sitemessage.SiteMessageListFragment)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$$ExternalSyntheticLambda7;->f$0 Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;
    return-void 
.end method

.method public final invoke(java.lang.Object  java.lang.Object  java.lang.Object)java.lang.Object
    .registers 5
    # ins_size=4
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$$ExternalSyntheticLambda7;->f$0 Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;
    check-cast v2, Landroid/view/View;
    check-cast v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;
    check-cast v4, Ljava/lang/Integer;
    invoke-virtual v4, Ljava/lang/Integer;->intValue()I
    move-result v4
    invoke-static v0, v2, v3, v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->$r8$lambda$hdQ1sVPYVpoK6KMNBfAwbgo81r8(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment; Landroid/view/View; Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem; I)Lkotlin/Unit;
    move-result-object v2
    return-object v2
.end method
