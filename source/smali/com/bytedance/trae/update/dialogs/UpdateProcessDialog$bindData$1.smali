# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog$bindData$1;
.super Ljava/lang/Object;
.source "UpdateProcessDialog.kt"

.implements Lcom/ss/android/update/OnUpdateStatusChangedListener;

.field private lastProgress:I
.field final synthetic this$0:Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;


.method constructor <init>(com.bytedance.trae.update.dialogs.UpdateProcessDialog)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog$bindData$1;->this$0 Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public downloadResult(boolean  boolean)void
    .registers 4
    # ins_size=3
    if-eqz v3, +003h
    return-void 
    new-instance v3, Lcom/ss/android/update/DownloadInfo;
    invoke-direct v3, Lcom/ss/android/update/DownloadInfo;-><init>()V
    const/4 v0, 2
    if-eqz v2, +004h
    const/4 v2, 3
    goto +2h
    move v2, v0
    iput v2, v3, Lcom/ss/android/update/DownloadInfo;->status I
    invoke-static Landroid/os/Message;->obtain()Landroid/os/Message;
    move-result-object v2
    iput v0, v2, Landroid/os/Message;->what I
    iput-object v3, v2, Landroid/os/Message;->obj Ljava/lang/Object;
    iget-object v3, v1, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog$bindData$1;->this$0 Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;
    invoke-static v3, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->access$getHandler$p(Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;)Landroid/os/Handler;
    move-result-object v3
    invoke-virtual v3, v2, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z
    return-void 
.end method

.method public final getLastProgress()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog$bindData$1;->lastProgress I
    return v0
.end method

.method public onPrepare(boolean)void
    .registers 2
    # ins_size=2
    return-void 
.end method

.method public onUpdateStatusChanged(int)void
    .registers 2
    # ins_size=2
    return-void 
.end method

.method public saveDownloadInfo(int  java.lang.String  boolean)void
    .registers 4
    # ins_size=4
    return-void 
.end method

.method public final setLastProgress(int)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog$bindData$1;->lastProgress I
    return-void 
.end method

.method public updateProgress(int  int  boolean)void
    .registers 6
    # ins_size=4
    if-eqz v5, +003h
    return-void 
    iget-object v5, v2, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog$bindData$1;->this$0 Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;
    invoke-static v5, v3, v4, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->access$calculateProgress(Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog; I I)I
    move-result v5
    iget v0, v2, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog$bindData$1;->lastProgress I
    sub-int v0, v5, v0
    const/4 v1, 1
    if-gt v0, v1, +003h
    return-void 
    iput v5, v2, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog$bindData$1;->lastProgress I
    new-instance v5, Lcom/ss/android/update/DownloadInfo;
    invoke-direct v5, Lcom/ss/android/update/DownloadInfo;-><init>()V
    iput v1, v5, Lcom/ss/android/update/DownloadInfo;->status I
    iput v3, v5, Lcom/ss/android/update/DownloadInfo;->byteSoFar I
    iput v4, v5, Lcom/ss/android/update/DownloadInfo;->contentLength I
    invoke-static Landroid/os/Message;->obtain()Landroid/os/Message;
    move-result-object v3
    iput v1, v3, Landroid/os/Message;->what I
    iput-object v5, v3, Landroid/os/Message;->obj Ljava/lang/Object;
    iget-object v4, v2, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog$bindData$1;->this$0 Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;
    invoke-static v4, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->access$getHandler$p(Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;)Landroid/os/Handler;
    move-result-object v4
    invoke-virtual v4, v3, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z
    return-void 
.end method
