# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/init/task/bdturing/BDTuringAccount$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lcom/bytedance/bdturing/uc_twiceverify/UCTwiceVerifyDepend;


.method public synthetic constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final startTwiceVerify(org.json.JSONObject  com.bytedance.bdturing.uc_twiceverify.UCTwiceVerifyResultCallback)boolean
    .registers 3
    # ins_size=3
    invoke-static v1, v2, Lcom/bytedance/trae/init/task/bdturing/BDTuringAccount;->$r8$lambda$Z1saeet7LvmeH7R9wJuKNCmShTg(Lorg/json/JSONObject; Lcom/bytedance/bdturing/uc_twiceverify/UCTwiceVerifyResultCallback;)Z
    move-result v1
    return v1
.end method
