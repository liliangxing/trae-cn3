# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public Lcom/bytedance/trae/conversation/products/IHtmlShareSettings$$Impl;
.super Ljava/lang/Object;
.source "IHtmlShareSettings$$Impl.java"

.implements Lcom/bytedance/trae/conversation/products/IHtmlShareSettings;

.field private static final GSON:Lcom/google/gson/Gson;
.field private static final VERSION:I
.field private iEnsure:Lcom/bytedance/services/apm/api/IEnsure;
.field private final mCachedSettings:Ljava/util/concurrent/ConcurrentHashMap;
.field private mExposedManager:Lcom/bytedance/news/common/settings/api/exposed/ExposedManager;
.field private final mInstanceCreator:Lcom/bytedance/news/common/settings/internal/InstanceCreator;
.field private final mStickySettings:Ljava/util/concurrent/ConcurrentHashMap;
.field private mStorage:Lcom/bytedance/news/common/settings/api/Storage;
.field private final mTransientSettings:Ljava/util/concurrent/ConcurrentHashMap;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/google/gson/Gson;
    invoke-direct v0, Lcom/google/gson/Gson;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/products/IHtmlShareSettings$$Impl;->GSON Lcom/google/gson/Gson;
    return-void 
.end method

.method public constructor <init>(com.bytedance.news.common.settings.api.Storage)void
    .registers 3
    # ins_size=2
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;
    invoke-direct v0, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V
    iput-object v0, v1, Lcom/bytedance/trae/conversation/products/IHtmlShareSettings$$Impl;->mStickySettings Ljava/util/concurrent/ConcurrentHashMap;
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;
    invoke-direct v0, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V
    iput-object v0, v1, Lcom/bytedance/trae/conversation/products/IHtmlShareSettings$$Impl;->mTransientSettings Ljava/util/concurrent/ConcurrentHashMap;
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;
    invoke-direct v0, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V
    iput-object v0, v1, Lcom/bytedance/trae/conversation/products/IHtmlShareSettings$$Impl;->mCachedSettings Ljava/util/concurrent/ConcurrentHashMap;
    new-instance v0, Lcom/bytedance/trae/conversation/products/IHtmlShareSettings$$Impl$1;
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/products/IHtmlShareSettings$$Impl$1;-><init>(Lcom/bytedance/trae/conversation/products/IHtmlShareSettings$$Impl;)V
    iput-object v0, v1, Lcom/bytedance/trae/conversation/products/IHtmlShareSettings$$Impl;->mInstanceCreator Lcom/bytedance/news/common/settings/internal/InstanceCreator;
    iput-object v2, v1, Lcom/bytedance/trae/conversation/products/IHtmlShareSettings$$Impl;->mStorage Lcom/bytedance/news/common/settings/api/Storage;
    invoke-static Lcom/bytedance/news/common/settings/internal/GlobalConfig;->getContext()Landroid/content/Context;
    move-result-object v2
    invoke-static v2, Lcom/bytedance/news/common/settings/api/exposed/ExposedManager;->getInstance(Landroid/content/Context;)Lcom/bytedance/news/common/settings/api/exposed/ExposedManager;
    move-result-object v2
    iput-object v2, v1, Lcom/bytedance/trae/conversation/products/IHtmlShareSettings$$Impl;->mExposedManager Lcom/bytedance/news/common/settings/api/exposed/ExposedManager;
    invoke-static Lcom/bytedance/news/common/settings/internal/IEnsureWrapper;->getInstance()Lcom/bytedance/news/common/settings/internal/IEnsureWrapper;
    move-result-object v2
    iput-object v2, v1, Lcom/bytedance/trae/conversation/products/IHtmlShareSettings$$Impl;->iEnsure Lcom/bytedance/services/apm/api/IEnsure;
    return-void 
.end method

.method public getHtmlShareMinIdeVersion()java.lang.String
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/conversation/products/IHtmlShareSettings$$Impl;->mExposedManager Lcom/bytedance/news/common/settings/api/exposed/ExposedManager;
    const-string v1, "cli_share_html_control"
    invoke-virtual v0, v1, Lcom/bytedance/news/common/settings/api/exposed/ExposedManager;->markExposed(Ljava/lang/String;)V
    invoke-static v1, Lcom/bytedance/news/common/settings/api/exposed/ExposedManager;->needsReporting(Ljava/lang/String;)Z
    move-result v0
    if-eqz v0, +034h
    iget-object v0, v4, Lcom/bytedance/trae/conversation/products/IHtmlShareSettings$$Impl;->iEnsure Lcom/bytedance/services/apm/api/IEnsure;
    if-eqz v0, +030h
    new-instance v0, Ljava/util/HashMap;
    invoke-direct v0, Ljava/util/HashMap;-><init>()V
    const-string/jumbo v2, settings_key
    invoke-interface v0, v2, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    invoke-static Lcom/bytedance/news/common/settings/api/exposed/ExposedManager;->getSettingsUsingTime()J
    move-result-wide v2
    invoke-static v2, v3, Ljava/lang/String;->valueOf(J)Ljava/lang/String;
    move-result-object v2
    const-string/jumbo v3, settings_time
    invoke-interface v0, v3, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    invoke-static Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/Thread;->getName()Ljava/lang/String;
    move-result-object v2
    const-string/jumbo v3, settings_thread_name
    invoke-interface v0, v3, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    iget-object v2, v4, Lcom/bytedance/trae/conversation/products/IHtmlShareSettings$$Impl;->iEnsure Lcom/bytedance/services/apm/api/IEnsure;
    const-string v3, "get settings key = cli_share_html_control"
    invoke-interface v2, v3, v0, Lcom/bytedance/services/apm/api/IEnsure;->ensureNotReachHere(Ljava/lang/String; Ljava/util/Map;)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/products/IHtmlShareSettings$$Impl;->mStorage Lcom/bytedance/news/common/settings/api/Storage;
    if-eqz v0, +00fh
    invoke-interface v0, v1, Lcom/bytedance/news/common/settings/api/Storage;->contains(Ljava/lang/String;)Z
    move-result v0
    if-eqz v0, +009h
    iget-object v0, v4, Lcom/bytedance/trae/conversation/products/IHtmlShareSettings$$Impl;->mStorage Lcom/bytedance/news/common/settings/api/Storage;
    invoke-interface v0, v1, Lcom/bytedance/news/common/settings/api/Storage;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    goto +3h
    const-string v0, ""
    return-object v0
.end method

.method public updateSettings()void
    .registers 1
    # ins_size=1
    return-void 
.end method

.method public updateSettings(com.bytedance.news.common.settings.api.SettingsData)void
    .registers 8
    # ins_size=2
    invoke-static Lcom/bytedance/news/common/settings/internal/GlobalConfig;->getContext()Landroid/content/Context;
    move-result-object v0
    invoke-static v0, Lcom/bytedance/news/common/settings/internal/MetaInfo;->getInstance(Landroid/content/Context;)Lcom/bytedance/news/common/settings/internal/MetaInfo;
    move-result-object v0
    const-string v1, "nova_settings_com.bytedance.trae.conversation.products.IHtmlShareSettings"
    if-nez v7, +072h
    invoke-virtual v0, v1, Lcom/bytedance/news/common/settings/internal/MetaInfo;->getSettingsVersion(Ljava/lang/String;)I
    move-result v2
    const-string v3, "isUseOneSpForAppSettingsStatic error"
    const-string v4, ""
    const v5, -994687320
    if-eq v5, v2, +02ch
    invoke-static Lcom/bytedance/news/common/settings/internal/GlobalConfig;->getContext()Landroid/content/Context;
    move-result-object v7
    invoke-static v7, Lcom/bytedance/news/common/settings/internal/LocalCache;->getInstance(Landroid/content/Context;)Lcom/bytedance/news/common/settings/internal/LocalCache;
    move-result-object v7
    invoke-virtual v7, v4, Lcom/bytedance/news/common/settings/internal/LocalCache;->getLocalSettingsData(Ljava/lang/String;)Lcom/bytedance/news/common/settings/api/SettingsData;
    move-result-object v7
    invoke-static Lcom/bytedance/news/common/settings/api/exposed/ExposedManager;->isUseOneSpForAppSettingsStatic()Z
    move-result v2
    if-eqz v2, +008h
    if-eqz v7, +051h
    invoke-virtual v0, v1, v5, Lcom/bytedance/news/common/settings/internal/MetaInfo;->setSettingsVersion(Ljava/lang/String; I)V
    goto +4ch
    invoke-virtual v0, v1, v5, Lcom/bytedance/news/common/settings/internal/MetaInfo;->setSettingsVersion(Ljava/lang/String; I)V
    goto +48h
    move-exception v2
    if-eqz v7, +005h
    invoke-virtual v0, v1, v5, Lcom/bytedance/news/common/settings/internal/MetaInfo;->setSettingsVersion(Ljava/lang/String; I)V
    iget-object v4, v6, Lcom/bytedance/trae/conversation/products/IHtmlShareSettings$$Impl;->iEnsure Lcom/bytedance/services/apm/api/IEnsure;
    if-eqz v4, +03fh
    invoke-interface v4, v2, v3, Lcom/bytedance/services/apm/api/IEnsure;->ensureNotReachHere(Ljava/lang/Throwable; Ljava/lang/String;)V
    goto +3ah
    invoke-virtual v0, v1, v4, Lcom/bytedance/news/common/settings/internal/MetaInfo;->needUpdate(Ljava/lang/String; Ljava/lang/String;)Z
    move-result v2
    if-eqz v2, +00fh
    invoke-static Lcom/bytedance/news/common/settings/internal/GlobalConfig;->getContext()Landroid/content/Context;
    move-result-object v7
    invoke-static v7, Lcom/bytedance/news/common/settings/internal/LocalCache;->getInstance(Landroid/content/Context;)Lcom/bytedance/news/common/settings/internal/LocalCache;
    move-result-object v7
    invoke-virtual v7, v4, Lcom/bytedance/news/common/settings/internal/LocalCache;->getLocalSettingsData(Ljava/lang/String;)Lcom/bytedance/news/common/settings/api/SettingsData;
    move-result-object v7
    goto +27h
    if-nez v7, +026h
    invoke-static Lcom/bytedance/news/common/settings/api/exposed/ExposedManager;->isUseOneSpForAppSettingsStatic()Z
    move-result v2
    if-eqz v2, +020h
    invoke-virtual v0, v1, Lcom/bytedance/news/common/settings/internal/MetaInfo;->isOneSpMigrateDone(Ljava/lang/String;)Z
    move-result v2
    if-nez v2, +01ah
    invoke-static Lcom/bytedance/news/common/settings/internal/GlobalConfig;->getContext()Landroid/content/Context;
    move-result-object v2
    invoke-static v2, Lcom/bytedance/news/common/settings/internal/LocalCache;->getInstance(Landroid/content/Context;)Lcom/bytedance/news/common/settings/internal/LocalCache;
    move-result-object v2
    invoke-virtual v2, v4, Lcom/bytedance/news/common/settings/internal/LocalCache;->getLocalSettingsData(Ljava/lang/String;)Lcom/bytedance/news/common/settings/api/SettingsData;
    move-result-object v7
    invoke-virtual v0, v1, Lcom/bytedance/news/common/settings/internal/MetaInfo;->setOneSpMigrateDone(Ljava/lang/String;)V
    goto +9h
    move-exception v2
    iget-object v4, v6, Lcom/bytedance/trae/conversation/products/IHtmlShareSettings$$Impl;->iEnsure Lcom/bytedance/services/apm/api/IEnsure;
    if-eqz v4, +005h
    invoke-interface v4, v2, v3, Lcom/bytedance/services/apm/api/IEnsure;->ensureNotReachHere(Ljava/lang/Throwable; Ljava/lang/String;)V
    if-eqz v7, +029h
    iget-object v2, v6, Lcom/bytedance/trae/conversation/products/IHtmlShareSettings$$Impl;->mStorage Lcom/bytedance/news/common/settings/api/Storage;
    if-eqz v2, +025h
    invoke-virtual v7, Lcom/bytedance/news/common/settings/api/SettingsData;->getAppSettings()Lorg/json/JSONObject;
    move-result-object v2
    if-eqz v2, +013h
    const-string v3, "cli_share_html_control"
    invoke-virtual v2, v3, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z
    move-result v4
    if-eqz v4, +00bh
    iget-object v4, v6, Lcom/bytedance/trae/conversation/products/IHtmlShareSettings$$Impl;->mStorage Lcom/bytedance/news/common/settings/api/Storage;
    invoke-virtual v2, v3, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    invoke-interface v4, v3, v2, Lcom/bytedance/news/common/settings/api/Storage;->putString(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v2, v6, Lcom/bytedance/trae/conversation/products/IHtmlShareSettings$$Impl;->mStorage Lcom/bytedance/news/common/settings/api/Storage;
    invoke-interface v2, Lcom/bytedance/news/common/settings/api/Storage;->apply()V
    invoke-virtual v7, Lcom/bytedance/news/common/settings/api/SettingsData;->getToken()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v0, v1, v7, Lcom/bytedance/news/common/settings/internal/MetaInfo;->setStorageKeyUpdateToken(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    :try_start_0x25
    :try_start_0x58
.end method
