# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/settings/impl/SettingsAbVersionServiceImpl;
.super Ljava/lang/Object;
.source "SettingsAbVersionServiceImpl.kt"

.implements Lcom/bytedance/news/common/settings/api/SettingsAbReportService;


.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public setAbSDKVersion(java.lang.String)void
    .registers 3
    # ins_size=2
    move-object v0, v2
    check-cast v0, Ljava/lang/CharSequence;
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    const/4 v0, 0
    goto +2h
    const/4 v0, 1
    if-eqz v0, +003h
    return-void 
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v0, v2, Lcom/bytedance/trae/applog/api/IApplog$Companion;->setExternalAbVersionFromSettings(Ljava/lang/String;)V
    return-void 
.end method
