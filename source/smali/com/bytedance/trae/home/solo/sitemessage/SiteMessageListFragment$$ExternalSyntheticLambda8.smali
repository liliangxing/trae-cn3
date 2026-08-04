# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$$ExternalSyntheticLambda8;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function2;


.method public synthetic constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;
    check-cast v2, Ljava/lang/Integer;
    invoke-virtual v2, Ljava/lang/Integer;->intValue()I
    move-result v2
    invoke-static v1, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->$r8$lambda$QOWOIJJbCh847e2MbWdaUTBeHBw(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem; I)Lkotlin/Unit;
    move-result-object v1
    return-object v1
.end method
