# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/share/SharePermissionConfigImpl$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Lcom/bytedance/ug/sdk/share/api/callback/RequestPermissionsCallback;


.method public synthetic constructor <init>(com.bytedance.ug.sdk.share.api.callback.RequestPermissionsCallback)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/share/SharePermissionConfigImpl$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/ug/sdk/share/api/callback/RequestPermissionsCallback;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/conversation/share/SharePermissionConfigImpl$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/ug/sdk/share/api/callback/RequestPermissionsCallback;
    check-cast v2, Ljava/lang/Boolean;
    invoke-virtual v2, Ljava/lang/Boolean;->booleanValue()Z
    move-result v2
    invoke-static v0, v2, Lcom/bytedance/trae/conversation/share/SharePermissionConfigImpl;->$r8$lambda$2FTUulgr824zgbZY8nK0CSn4qdI(Lcom/bytedance/ug/sdk/share/api/callback/RequestPermissionsCallback; Z)Lkotlin/Unit;
    move-result-object v2
    return-object v2
.end method
