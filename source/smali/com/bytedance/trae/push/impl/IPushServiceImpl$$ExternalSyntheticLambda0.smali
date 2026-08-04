# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/push/impl/IPushServiceImpl$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lcom/bytedance/trae/login/api/IAccountStatusListener;

.field public final synthetic f$0:Lcom/bytedance/trae/push/impl/IPushServiceImpl;


.method public synthetic constructor <init>(com.bytedance.trae.push.impl.IPushServiceImpl)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/push/impl/IPushServiceImpl$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/push/impl/IPushServiceImpl;
    return-void 
.end method

.method public final onAccountStatusChanged(com.bytedance.trae.login.api.AccountStatus  java.lang.String)void
    .registers 4
    # ins_size=3
    iget-object v0, v1, Lcom/bytedance/trae/push/impl/IPushServiceImpl$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/push/impl/IPushServiceImpl;
    invoke-static v0, v2, v3, Lcom/bytedance/trae/push/impl/IPushServiceImpl;->$r8$lambda$0XrP9ovrrZ5v7Caz52i4MubHNYs(Lcom/bytedance/trae/push/impl/IPushServiceImpl; Lcom/bytedance/trae/login/api/AccountStatus; Ljava/lang/String;)V
    return-void 
.end method
