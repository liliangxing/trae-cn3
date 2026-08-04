# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/login/traeauth/TraeAuthManager$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lcom/bytedance/trae/login/DeviceOverLimitDialog$Callback;

.field public final synthetic f$0:Ljava/lang/String;
.field public final synthetic f$1:Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;


.method public synthetic constructor <init>(java.lang.String  com.bytedance.trae.login.traeauth.TraeAuthManager$TraeAuthCallback)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$$ExternalSyntheticLambda1;->f$0 Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$$ExternalSyntheticLambda1;->f$1 Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;
    return-void 
.end method

.method public final onResult(boolean)void
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$$ExternalSyntheticLambda1;->f$0 Ljava/lang/String;
    iget-object v1, v2, Lcom/bytedance/trae/login/traeauth/TraeAuthManager$$ExternalSyntheticLambda1;->f$1 Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback;
    invoke-static v0, v1, v3, Lcom/bytedance/trae/login/traeauth/TraeAuthManager;->$r8$lambda$NYBQBgpEju8dhOGg1zHTic-rqOI(Ljava/lang/String; Lcom/bytedance/trae/login/traeauth/TraeAuthManager$TraeAuthCallback; Z)V
    return-void 
.end method
