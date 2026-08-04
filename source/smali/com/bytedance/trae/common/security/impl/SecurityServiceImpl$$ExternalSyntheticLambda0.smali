# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/common/security/impl/SecurityServiceImpl$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function2;

.field public final synthetic f$0:Lcom/bytedance/trae/common/security/impl/SecurityServiceImpl;
.field public final synthetic f$1:Landroid/content/Context;


.method public synthetic constructor <init>(com.bytedance.trae.common.security.impl.SecurityServiceImpl  android.content.Context)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/common/security/impl/SecurityServiceImpl$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/common/security/impl/SecurityServiceImpl;
    iput-object v2, v0, Lcom/bytedance/trae/common/security/impl/SecurityServiceImpl$$ExternalSyntheticLambda0;->f$1 Landroid/content/Context;
    return-void 
.end method

.method public final invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 5
    # ins_size=3
    iget-object v0, v2, Lcom/bytedance/trae/common/security/impl/SecurityServiceImpl$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/common/security/impl/SecurityServiceImpl;
    iget-object v1, v2, Lcom/bytedance/trae/common/security/impl/SecurityServiceImpl$$ExternalSyntheticLambda0;->f$1 Landroid/content/Context;
    check-cast v3, Ljava/lang/String;
    check-cast v4, Ljava/lang/String;
    invoke-static v0, v1, v3, v4, Lcom/bytedance/trae/common/security/impl/SecurityServiceImpl;->$r8$lambda$f8_ctQ8lXXRdnjdGdfLcFGM_110(Lcom/bytedance/trae/common/security/impl/SecurityServiceImpl; Landroid/content/Context; Ljava/lang/String; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v3
    return-object v3
.end method
