# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$$ExternalSyntheticLambda2;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function0;

.field public final synthetic f$0:Lcom/bytedance/trae/login/api/IAccountCallback;
.field public final synthetic f$1:Ljava/lang/String;


.method public synthetic constructor <init>(com.bytedance.trae.login.api.IAccountCallback  java.lang.String)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$$ExternalSyntheticLambda2;->f$0 Lcom/bytedance/trae/login/api/IAccountCallback;
    iput-object v2, v0, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$$ExternalSyntheticLambda2;->f$1 Ljava/lang/String;
    return-void 
.end method

.method public final invoke()java.lang.Object
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$$ExternalSyntheticLambda2;->f$0 Lcom/bytedance/trae/login/api/IAccountCallback;
    iget-object v1, v2, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl$$ExternalSyntheticLambda2;->f$1 Ljava/lang/String;
    invoke-static v0, v1, Lcom/bytedance/trae/login/service/DouyinLoginServiceImpl;->$r8$lambda$senkbGN2MSuz3PymLXTl5yXTO_M(Lcom/bytedance/trae/login/api/IAccountCallback; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method
