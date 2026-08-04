# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/update/UpdateListener;
.super Ljava/lang/Object;
.source "IBitsUpdateImpl.kt"

.implements Lcom/ss/android/update/OnUpdateStatusChangedListener;

.field private final TAG:Ljava/lang/String;


.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    const-string/jumbo v0, update_sdk
    iput-object v0, v1, Lcom/bytedance/trae/update/UpdateListener;->TAG Ljava/lang/String;
    return-void 
.end method

.method public downloadResult(boolean  boolean)void
    .registers 7
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v1, v4, Lcom/bytedance/trae/update/UpdateListener;->TAG Ljava/lang/String;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "downloadResult isSuccess:"
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v2, ",pre:"
    invoke-virtual v5, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v0, v1, v5, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public onPrepare(boolean)void
    .registers 6
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v1, v4, Lcom/bytedance/trae/update/UpdateListener;->TAG Ljava/lang/String;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string/jumbo v3, onPrepare pre:
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v0, v1, v5, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public onUpdateStatusChanged(int)void
    .registers 6
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v1, v4, Lcom/bytedance/trae/update/UpdateListener;->TAG Ljava/lang/String;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string/jumbo v3, onUpdateStatusChanged status:
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v0, v1, v5, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public saveDownloadInfo(int  java.lang.String  boolean)void
    .registers 7
    # ins_size=4
    sget-object v4, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v0, v3, Lcom/bytedance/trae/update/UpdateListener;->TAG Ljava/lang/String;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string/jumbo v2, saveDownloadInfo etag:
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v1, ",pre:"
    invoke-virtual v5, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v4, v0, v5, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public updateProgress(int  int  boolean)void
    .registers 8
    # ins_size=4
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v1, v4, Lcom/bytedance/trae/update/UpdateListener;->TAG Ljava/lang/String;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string/jumbo v3, updateProgress byteSoFar:
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v2, ",contentLength:"
    invoke-virtual v5, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v6, ",pre:"
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v7, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v0, v1, v5, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method
