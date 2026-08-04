# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/login/activity/AccountLoginActivity$$ExternalSyntheticLambda2;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Ljava/lang/Runnable;

.field public final synthetic f$0:Lcom/bytedance/trae/login/activity/AccountLoginActivity;
.field public final synthetic f$1:Lcom/bytedance/trae/login/traeauth/ListDevicesResult;
.field public final synthetic f$2:Ljava/util/Map;
.field public final synthetic f$3:Ljava/lang/String;


.method public synthetic constructor <init>(com.bytedance.trae.login.activity.AccountLoginActivity  com.bytedance.trae.login.traeauth.ListDevicesResult  java.util.Map  java.lang.String)void
    .registers 5
    # ins_size=5
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity$$ExternalSyntheticLambda2;->f$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    iput-object v2, v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity$$ExternalSyntheticLambda2;->f$1 Lcom/bytedance/trae/login/traeauth/ListDevicesResult;
    iput-object v3, v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity$$ExternalSyntheticLambda2;->f$2 Ljava/util/Map;
    iput-object v4, v0, Lcom/bytedance/trae/login/activity/AccountLoginActivity$$ExternalSyntheticLambda2;->f$3 Ljava/lang/String;
    return-void 
.end method

.method public final run()void
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/login/activity/AccountLoginActivity$$ExternalSyntheticLambda2;->f$0 Lcom/bytedance/trae/login/activity/AccountLoginActivity;
    iget-object v1, v4, Lcom/bytedance/trae/login/activity/AccountLoginActivity$$ExternalSyntheticLambda2;->f$1 Lcom/bytedance/trae/login/traeauth/ListDevicesResult;
    iget-object v2, v4, Lcom/bytedance/trae/login/activity/AccountLoginActivity$$ExternalSyntheticLambda2;->f$2 Ljava/util/Map;
    iget-object v3, v4, Lcom/bytedance/trae/login/activity/AccountLoginActivity$$ExternalSyntheticLambda2;->f$3 Ljava/lang/String;
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/login/activity/AccountLoginActivity;->lambda$listDevicesAndNotify$4$com-bytedance-trae-login-activity-AccountLoginActivity(Lcom/bytedance/trae/login/traeauth/ListDevicesResult; Ljava/util/Map; Ljava/lang/String;)V
    return-void 
.end method
