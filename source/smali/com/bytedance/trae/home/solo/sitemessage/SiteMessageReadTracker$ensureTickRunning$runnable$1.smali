# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker$ensureTickRunning$runnable$1;
.super Ljava/lang/Object;
.source "SiteMessageReadTracker.kt"

.implements Ljava/lang/Runnable;

.field final synthetic this$0:Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;


.method constructor <init>(com.bytedance.trae.home.solo.sitemessage.SiteMessageReadTracker)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker$ensureTickRunning$runnable$1;->this$0 Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public run()void
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker$ensureTickRunning$runnable$1;->this$0 Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;
    invoke-static v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->access$tick(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;)V
    iget-object v0, v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker$ensureTickRunning$runnable$1;->this$0 Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;
    invoke-static v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->access$getTrackingStartTimes$p(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;)Ljava/util/Map;
    move-result-object v0
    invoke-interface v0, Ljava/util/Map;->isEmpty()Z
    move-result v0
    xor-int/lit8 v0, v0, 1
    if-eqz v0, +011h
    iget-object v0, v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker$ensureTickRunning$runnable$1;->this$0 Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;
    invoke-static v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->access$getHandler$p(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;)Landroid/os/Handler;
    move-result-object v0
    move-object v1, v4
    check-cast v1, Ljava/lang/Runnable;
    const-wide/16 v2, 1000
    invoke-virtual v0, v1, v2, v3, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable; J)Z
    goto +7h
    iget-object v0, v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker$ensureTickRunning$runnable$1;->this$0 Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;
    const/4 v1, 0
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->access$setTickRunnable$p(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker; Ljava/lang/Runnable;)V
    return-void 
.end method
