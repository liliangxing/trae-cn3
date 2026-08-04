# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$$ExternalSyntheticLambda6;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function2;

.field public final synthetic f$0:Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;


.method public synthetic constructor <init>(com.bytedance.trae.home.solo.sitemessage.SiteMessageListFragment)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$$ExternalSyntheticLambda6;->f$0 Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;
    return-void 
.end method

.method public final invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=3
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$$ExternalSyntheticLambda6;->f$0 Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;
    check-cast v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;
    check-cast v3, Ljava/lang/Integer;
    invoke-virtual v3, Ljava/lang/Integer;->intValue()I
    move-result v3
    invoke-static v0, v2, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->$r8$lambda$AsVzhnI6qkuFCg0GGHJMvNeINq8(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment; Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem; I)Lkotlin/Unit;
    move-result-object v2
    return-object v2
.end method
