# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/account/AccountInitExt$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lcom/bytedance/sdk/account/settings/AuthExpirationConfigManager$GetLocalConfig;


.method public synthetic constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final getConfig()com.bytedance.sdk.account.settings.AuthExpirationConfigManager$Config
    .registers 2
    # ins_size=1
    invoke-static Lcom/bytedance/trae/account/AccountInitExt;->$r8$lambda$wOYDhf0WoCipCy3hEZ0AVJtA2pM()Lcom/bytedance/sdk/account/settings/AuthExpirationConfigManager$Config;
    move-result-object v0
    return-object v0
.end method
