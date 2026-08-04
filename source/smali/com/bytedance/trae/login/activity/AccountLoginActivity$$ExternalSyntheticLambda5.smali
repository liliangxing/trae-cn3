# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/login/activity/AccountLoginActivity$$ExternalSyntheticLambda5;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lcom/bytedance/trae/login/DeviceOverLimitDialog$Callback;

.field public final synthetic f$0:Lcom/bytedance/trae/login/activity/AccountLoginActivity;
.field public final synthetic f$1:Ljava/util/Map;
.field public final synthetic f$2:Ljava/lang/String;


.method public synthetic constructor <init>(com.bytedance.trae.login.activity.AccountLoginActivity  java.util.Map  java.lang.String)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity$$ExternalSyntheticLambda5;->f$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    iput-object v2, v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity$$ExternalSyntheticLambda5;->f$1 Ljava/util/Map;
    iput-object v3, v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity$$ExternalSyntheticLambda5;->f$2 Ljava/lang/String;
    return-void 
.end method

.method public final onResult(boolean)void
    .registers 5
    # ins_size=2
    iget-object v0, v3, Lcom/bytedance/trae/login/activity/AccountLoginActivity$$ExternalSyntheticLambda5;->f$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    iget-object v1, v3, Lcom/bytedance/trae/login/activity/AccountLoginActivity$$ExternalSyntheticLambda5;->f$1 Ljava/util/Map;
    iget-object v2, v3, Lcom/bytedance/trae/login/activity/AccountLoginActivity$$ExternalSyntheticLambda5;->f$2 Ljava/lang/String;
    invoke-virtual v0, v1, v2, v4, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->lambda$showDeviceOverLimitDialog$7$com-bytedance-trae-login-activity-AccountLoginActivity(Ljava/util/Map; Ljava/lang/String; Z)V
    return-void 
.end method
