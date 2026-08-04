# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/account/TTAccountConfig$getIBdTruing$1;
.super Lcom/ss/android/account/dbtring/AbsBdTuringImpl;
.source "TTAccountConfig.kt"


.method constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/ss/android/account/dbtring/AbsBdTuringImpl;-><init>()V
    return-void 
.end method

.method public forceDisable()boolean
    .registers 2
    # ins_size=1
    const/4 v0, 0
    return v0
.end method

.method public init(android.content.Context)boolean
    .registers 2
    # ins_size=2
    const/4 v1, 1
    return v1
.end method

.method public showVerifyDialog(int  java.lang.String  com.ss.android.account.dbtring.IBdTruing$IAccountBdTuringCallback)void
    .registers 6
    # ins_size=4
    invoke-static Lcom/bytedance/bdturing/BdTuring;->getInstance()Lcom/bytedance/bdturing/BdTuring;
    move-result-object v3
    invoke-static Lcom/bytedance/sdk/account/utils/ActivityStack;->getTopActivity()Landroid/app/Activity;
    move-result-object v0
    if-eqz v4, +008h
    new-instance v1, Lcom/bytedance/bdturing/verify/request/RiskInfoRequest;
    invoke-direct v1, v4, Lcom/bytedance/bdturing/verify/request/RiskInfoRequest;-><init>(Ljava/lang/String;)V
    goto +2h
    const/4 v1, 0
    check-cast v1, Lcom/bytedance/bdturing/verify/request/AbstractRequest;
    new-instance v4, Lcom/bytedance/trae/account/TTAccountConfig$getIBdTruing$1$showVerifyDialog$2;
    invoke-direct v4, v5, Lcom/bytedance/trae/account/TTAccountConfig$getIBdTruing$1$showVerifyDialog$2;-><init>(Lcom/ss/android/account/dbtring/IBdTruing$IAccountBdTuringCallback;)V
    check-cast v4, Lcom/bytedance/bdturing/BdTuringCallback;
    invoke-virtual v3, v0, v1, v4, Lcom/bytedance/bdturing/BdTuring;->showVerifyDialog(Landroid/app/Activity; Lcom/bytedance/bdturing/verify/request/AbstractRequest; Lcom/bytedance/bdturing/BdTuringCallback;)V
    return-void 
.end method
