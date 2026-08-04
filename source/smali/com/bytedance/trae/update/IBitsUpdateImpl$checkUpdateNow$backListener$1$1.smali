# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/update/IBitsUpdateImpl$checkUpdateNow$backListener$1$1;
.super Ljava/lang/Object;
.source "IBitsUpdateImpl.kt"

.implements Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager$OnAppBackGroundListener;

.field final synthetic $updateService:Lcom/ss/android/update/UpdateHelper;
.field final synthetic this$0:Lcom/bytedance/trae/update/IBitsUpdateImpl;


.method constructor <init>(com.ss.android.update.UpdateHelper  com.bytedance.trae.update.IBitsUpdateImpl)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/update/IBitsUpdateImpl$checkUpdateNow$backListener$1$1;->$updateService Lcom/ss/android/update/UpdateHelper;
    iput-object v2, v0, Lcom/bytedance/trae/update/IBitsUpdateImpl$checkUpdateNow$backListener$1$1;->this$0 Lcom/bytedance/trae/update/IBitsUpdateImpl;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public onAllActivityDestroyed()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/update/IBitsUpdateImpl$checkUpdateNow$backListener$1$1;->$updateService Lcom/ss/android/update/UpdateHelper;
    invoke-virtual v0, Lcom/ss/android/update/UpdateHelper;->onExit()V
    iget-object v0, v2, Lcom/bytedance/trae/update/IBitsUpdateImpl$checkUpdateNow$backListener$1$1;->this$0 Lcom/bytedance/trae/update/IBitsUpdateImpl;
    const/4 v1, 1
    invoke-static v0, v1, Lcom/bytedance/trae/update/IBitsUpdateImpl;->access$setShouldCheckUpdate$p(Lcom/bytedance/trae/update/IBitsUpdateImpl; Z)V
    iget-object v0, v2, Lcom/bytedance/trae/update/IBitsUpdateImpl$checkUpdateNow$backListener$1$1;->$updateService Lcom/ss/android/update/UpdateHelper;
    invoke-virtual v0, Lcom/ss/android/update/UpdateHelper;->onAllDialogDismiss()V
    return-void 
.end method

.method public onAppBackground()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/update/IBitsUpdateImpl$checkUpdateNow$backListener$1$1;->$updateService Lcom/ss/android/update/UpdateHelper;
    invoke-virtual v0, Lcom/ss/android/update/UpdateHelper;->isForceUpdate()Z
    move-result v0
    if-eqz v0, +008h
    iget-object v0, v2, Lcom/bytedance/trae/update/IBitsUpdateImpl$checkUpdateNow$backListener$1$1;->this$0 Lcom/bytedance/trae/update/IBitsUpdateImpl;
    const/4 v1, 1
    invoke-static v0, v1, Lcom/bytedance/trae/update/IBitsUpdateImpl;->access$setShouldCheckUpdate$p(Lcom/bytedance/trae/update/IBitsUpdateImpl; Z)V
    return-void 
.end method

.method public onAppForeground()void
    .registers 1
    # ins_size=1
    return-void 
.end method
