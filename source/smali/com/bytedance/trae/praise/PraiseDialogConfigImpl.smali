# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/praise/PraiseDialogConfigImpl;
.super Ljava/lang/Object;
.source "PraiseDialogConfigImpl.kt"

.implements Lcom/bytedance/praisedialoglib/depend/IPraiseDialogConfig;


.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public getAppConfig()com.bytedance.praisedialoglib.depend.IPraiseDialogAppConfig
    .registers 2
    # ins_size=1
    new-instance v0, Lcom/bytedance/trae/praise/PraiseDialogAppConfigImpl;
    invoke-direct v0, Lcom/bytedance/trae/praise/PraiseDialogAppConfigImpl;-><init>()V
    check-cast v0, Lcom/bytedance/praisedialoglib/depend/IPraiseDialogAppConfig;
    return-object v0
.end method

.method public getAsyncThreadConfig()com.bytedance.praisedialoglib.depend.IPraiseDialogAsyncThreadConfig
    .registers 2
    # ins_size=1
    new-instance v0, Lcom/bytedance/trae/praise/PraiseDialogAsyncThreadImpl;
    invoke-direct v0, Lcom/bytedance/trae/praise/PraiseDialogAsyncThreadImpl;-><init>()V
    check-cast v0, Lcom/bytedance/praisedialoglib/depend/IPraiseDialogAsyncThreadConfig;
    return-object v0
.end method

.method public getLocalConfig()com.bytedance.praisedialoglib.depend.IPraiseDialogLocalConditionConfig
    .registers 2
    # ins_size=1
    new-instance v0, Lcom/bytedance/trae/praise/PraiseDialogLocalConditionImpl;
    invoke-direct v0, Lcom/bytedance/trae/praise/PraiseDialogLocalConditionImpl;-><init>()V
    check-cast v0, Lcom/bytedance/praisedialoglib/depend/IPraiseDialogLocalConditionConfig;
    return-object v0
.end method

.method public getNetworkConfig()com.bytedance.praisedialoglib.depend.IPraiseDialogNetworkConfig
    .registers 2
    # ins_size=1
    new-instance v0, Lcom/bytedance/trae/praise/PraiseDialogNetworkImpl;
    invoke-direct v0, Lcom/bytedance/trae/praise/PraiseDialogNetworkImpl;-><init>()V
    check-cast v0, Lcom/bytedance/praisedialoglib/depend/IPraiseDialogNetworkConfig;
    return-object v0
.end method

.method public getStartActivityConfig()com.bytedance.praisedialoglib.depend.IPraiseDialogStartActivityConfig
    .registers 2
    # ins_size=1
    const/4 v0, 0
    return-object v0
.end method

.method public getUiConfig()com.bytedance.praisedialoglib.depend.IPraiseDialogUIConfig
    .registers 2
    # ins_size=1
    new-instance v0, Lcom/bytedance/trae/praise/PraiseDialogUIConfigImpl;
    invoke-direct v0, Lcom/bytedance/trae/praise/PraiseDialogUIConfigImpl;-><init>()V
    check-cast v0, Lcom/bytedance/praisedialoglib/depend/IPraiseDialogUIConfig;
    return-object v0
.end method
