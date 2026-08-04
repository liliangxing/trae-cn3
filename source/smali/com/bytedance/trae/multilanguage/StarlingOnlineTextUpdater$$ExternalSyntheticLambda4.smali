# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater$$ExternalSyntheticLambda4;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Lorg/json/JSONObject;


.method public synthetic constructor <init>(org.json.JSONObject)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater$$ExternalSyntheticLambda4;->f$0 Lorg/json/JSONObject;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater$$ExternalSyntheticLambda4;->f$0 Lorg/json/JSONObject;
    check-cast v2, Ljava/lang/String;
    invoke-static v0, v2, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;->$r8$lambda$84_OJ_suZvK47y9_PsezHXVQkBI(Lorg/json/JSONObject; Ljava/lang/String;)Lorg/json/JSONObject;
    move-result-object v2
    return-object v2
.end method
