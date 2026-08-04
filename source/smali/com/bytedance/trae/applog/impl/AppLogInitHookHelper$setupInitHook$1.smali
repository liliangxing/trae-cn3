# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/applog/impl/AppLogInitHookHelper$setupInitHook$1;
.super Ljava/lang/Object;
.source "AppLogInitHookHelper.kt"

.implements Lcom/bytedance/applog/BDInstallInitHook;


.method constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public afterHook()void
    .registers 1
    # ins_size=1
    return-void 
.end method

.method public beforeInit(com.bytedance.bdinstall.Builder)void
    .registers 3
    # ins_size=2
    if-eqz v2, +00ch
    new-instance v0, Lcom/bytedance/trae/applog/impl/AppLogInitHookHelper$setupInitHook$1$beforeInit$1;
    invoke-direct v0, Lcom/bytedance/trae/applog/impl/AppLogInitHookHelper$setupInitHook$1$beforeInit$1;-><init>()V
    check-cast v0, Lcom/bytedance/bdinstall/ISstInfoProvider;
    invoke-virtual v2, v0, Lcom/bytedance/bdinstall/Builder;->setSSTInfoProvider(Lcom/bytedance/bdinstall/ISstInfoProvider;)Lcom/bytedance/bdinstall/Builder;
    return-void 
.end method
