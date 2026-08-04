# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder$$ExternalSyntheticLambda6;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;
.field public final synthetic f$1:Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;


.method public synthetic constructor <init>(com.bytedance.trae.home.solo.sitemessage.SiteMessageAdapter$ViewHolder  com.bytedance.trae.home.solo.sitemessage.SiteMessageAdapter)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder$$ExternalSyntheticLambda6;->f$0 Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder$$ExternalSyntheticLambda6;->f$1 Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder$$ExternalSyntheticLambda6;->f$0 Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder$$ExternalSyntheticLambda6;->f$1 Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;
    check-cast v3, Lcom/bytedance/trae/common/widget/SwipeRevealController$LongPressTouch;
    invoke-static v0, v1, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder;->$r8$lambda$ytiO1cwvF_xAD6VdgdX0zOdBY7Q(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter$ViewHolder; Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter; Lcom/bytedance/trae/common/widget/SwipeRevealController$LongPressTouch;)Lkotlin/Unit;
    move-result-object v3
    return-object v3
.end method
