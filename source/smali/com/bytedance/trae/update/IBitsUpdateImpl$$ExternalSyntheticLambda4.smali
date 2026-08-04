# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/update/IBitsUpdateImpl$$ExternalSyntheticLambda4;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lcom/ss/android/update/IUpdateConfig;

.field public final synthetic f$0:Lcom/ss/android/update/UpdateConfig;


.method public synthetic constructor <init>(com.ss.android.update.UpdateConfig)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/update/IBitsUpdateImpl$$ExternalSyntheticLambda4;->f$0 Lcom/ss/android/update/UpdateConfig;
    return-void 
.end method

.method public final getUpdateConfig()com.ss.android.update.UpdateConfig
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/update/IBitsUpdateImpl$$ExternalSyntheticLambda4;->f$0 Lcom/ss/android/update/UpdateConfig;
    invoke-static v0, Lcom/bytedance/trae/update/IBitsUpdateImpl;->$r8$lambda$6x2Gok5Z4c84PSobT_9mVluTCLU(Lcom/ss/android/update/UpdateConfig;)Lcom/ss/android/update/UpdateConfig;
    move-result-object v0
    return-object v0
.end method
