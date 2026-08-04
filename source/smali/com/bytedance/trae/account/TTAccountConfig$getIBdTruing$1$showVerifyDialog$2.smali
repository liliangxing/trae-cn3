# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/account/TTAccountConfig$getIBdTruing$1$showVerifyDialog$2;
.super Ljava/lang/Object;
.source "TTAccountConfig.kt"

.implements Lcom/bytedance/bdturing/BdTuringCallback;

.field final synthetic $callback:Lcom/ss/android/account/dbtring/IBdTruing$IAccountBdTuringCallback;


.method constructor <init>(com.ss.android.account.dbtring.IBdTruing$IAccountBdTuringCallback)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/account/TTAccountConfig$getIBdTruing$1$showVerifyDialog$2;->$callback Lcom/ss/android/account/dbtring/IBdTruing$IAccountBdTuringCallback;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public onFail(int  org.json.JSONObject)void
    .registers 6
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "BdTuring onFail: result="
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v1, ", extras="
    invoke-virtual v4, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    const-string v5, "TTAccountConfig"
    invoke-virtual v0, v5, v4, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v4, v3, Lcom/bytedance/trae/account/TTAccountConfig$getIBdTruing$1$showVerifyDialog$2;->$callback Lcom/ss/android/account/dbtring/IBdTruing$IAccountBdTuringCallback;
    if-eqz v4, +005h
    invoke-interface v4, Lcom/ss/android/account/dbtring/IBdTruing$IAccountBdTuringCallback;->onFail()V
    return-void 
.end method

.method public onSuccess(int  org.json.JSONObject)void
    .registers 6
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "BdTuring onSuccess: result="
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v1, ", extras="
    invoke-virtual v4, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    const-string v5, "TTAccountConfig"
    invoke-virtual v0, v5, v4, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v4, v3, Lcom/bytedance/trae/account/TTAccountConfig$getIBdTruing$1$showVerifyDialog$2;->$callback Lcom/ss/android/account/dbtring/IBdTruing$IAccountBdTuringCallback;
    if-eqz v4, +005h
    invoke-interface v4, Lcom/ss/android/account/dbtring/IBdTruing$IAccountBdTuringCallback;->onSuccess()V
    return-void 
.end method
