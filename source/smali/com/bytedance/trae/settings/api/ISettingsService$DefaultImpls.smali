# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/settings/api/ISettingsService$DefaultImpls;
.super Ljava/lang/Object;
.source "ISettingsService.kt"


.method public static synthetic registerListener$default(com.bytedance.trae.settings.api.ISettingsService  com.bytedance.news.common.settings.SettingsUpdateListener  boolean  int  java.lang.Object)void
    .registers 5
    # ins_size=5
    if-nez v4, +00bh
    and-int/lit8 v3, v3, 2
    if-eqz v3, +003h
    const/4 v2, 1
    invoke-interface v0, v1, v2, Lcom/bytedance/trae/settings/api/ISettingsService;->registerListener(Lcom/bytedance/news/common/settings/SettingsUpdateListener; Z)V
    return-void 
    new-instance v0, Ljava/lang/UnsupportedOperationException;
    const-string v1, "Super calls with default arguments not supported in this target, function: registerListener"
    invoke-direct v0, v1, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V
    throw v0
.end method

.method public static synthetic updateSettings$default(com.bytedance.trae.settings.api.ISettingsService  boolean  int  java.lang.Object)void
    .registers 4
    # ins_size=4
    if-nez v3, +00bh
    and-int/lit8 v2, v2, 1
    if-eqz v2, +003h
    const/4 v1, 0
    invoke-interface v0, v1, Lcom/bytedance/trae/settings/api/ISettingsService;->updateSettings(Z)V
    return-void 
    new-instance v0, Ljava/lang/UnsupportedOperationException;
    const-string v1, "Super calls with default arguments not supported in this target, function: updateSettings"
    invoke-direct v0, v1, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V
    throw v0
.end method
