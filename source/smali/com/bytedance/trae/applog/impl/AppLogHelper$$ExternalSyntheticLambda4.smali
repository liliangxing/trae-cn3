# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/applog/impl/AppLogHelper$$ExternalSyntheticLambda4;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lcom/bytedance/applog/ILaunchObserver;

.field public final synthetic f$0:Lcom/bytedance/trae/applog/api/OnLaunchCallback;


.method public synthetic constructor <init>(com.bytedance.trae.applog.api.OnLaunchCallback)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/applog/impl/AppLogHelper$$ExternalSyntheticLambda4;->f$0 Lcom/bytedance/trae/applog/api/OnLaunchCallback;
    return-void 
.end method

.method public final onLaunch(java.lang.String  long  boolean)void
    .registers 6
    # ins_size=5
    iget-object v0, v1, Lcom/bytedance/trae/applog/impl/AppLogHelper$$ExternalSyntheticLambda4;->f$0 Lcom/bytedance/trae/applog/api/OnLaunchCallback;
    invoke-interface v0, v2, v3, v4, v5, Lcom/bytedance/trae/applog/api/OnLaunchCallback;->onLaunch(Ljava/lang/String; J Z)V
    return-void 
.end method
