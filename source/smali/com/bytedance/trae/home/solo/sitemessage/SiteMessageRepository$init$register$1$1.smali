# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$init$register$1$1;
.super Ljava/lang/Object;
.source "SiteMessageRepository.kt"

.implements Landroidx/lifecycle/DefaultLifecycleObserver;


.method constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public onStart(androidx.lifecycle.LifecycleOwner)void
    .registers 3
    # ins_size=2
    const-string v0, "owner"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;->INSTANCE Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;->refreshUnreadCount()V
    sget-object v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;->INSTANCE Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;->getReadTracker()Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->retryPendingEvents()V
    return-void 
.end method
