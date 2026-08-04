# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/share/SharePermissionConfigImpl$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function0;

.field public final synthetic f$0:Landroid/app/Activity;
.field public final synthetic f$1:[Ljava/lang/String;
.field public final synthetic f$2:Lcom/bytedance/ug/sdk/share/api/callback/RequestPermissionsCallback;


.method public synthetic constructor <init>(android.app.Activity  java.lang.String[]  com.bytedance.ug.sdk.share.api.callback.RequestPermissionsCallback)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/share/SharePermissionConfigImpl$$ExternalSyntheticLambda1;->f$0 Landroid/app/Activity;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/share/SharePermissionConfigImpl$$ExternalSyntheticLambda1;->f$1 [Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/share/SharePermissionConfigImpl$$ExternalSyntheticLambda1;->f$2 Lcom/bytedance/ug/sdk/share/api/callback/RequestPermissionsCallback;
    return-void 
.end method

.method public final invoke()java.lang.Object
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/share/SharePermissionConfigImpl$$ExternalSyntheticLambda1;->f$0 Landroid/app/Activity;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/share/SharePermissionConfigImpl$$ExternalSyntheticLambda1;->f$1 [Ljava/lang/String;
    iget-object v2, v3, Lcom/bytedance/trae/conversation/share/SharePermissionConfigImpl$$ExternalSyntheticLambda1;->f$2 Lcom/bytedance/ug/sdk/share/api/callback/RequestPermissionsCallback;
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/share/SharePermissionConfigImpl;->$r8$lambda$nECfV18HGaZbQEB16TAboKKenw4(Landroid/app/Activity; [Ljava/lang/String; Lcom/bytedance/ug/sdk/share/api/callback/RequestPermissionsCallback;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method
