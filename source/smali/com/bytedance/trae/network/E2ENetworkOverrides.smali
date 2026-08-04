# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/network/E2ENetworkOverrides;
.super Ljava/lang/Object;
.source "E2ENetworkOverrides.kt"

.field private static final ALLOWED_HOST:Ljava/lang/String;
.field private static final BACKEND_MODE_ARGUMENT:Ljava/lang/String;
.field private static final CMP_DEVICE_MANAGEMENT_ENABLED_KEY:Ljava/lang/String;
.field private static final CMP_SETTINGS_ENTRY_ENABLED_KEY:Ljava/lang/String;
.field private static final E2E_PREFS_NAME:Ljava/lang/String;
.field public static final INSTANCE:Lcom/bytedance/trae/network/E2ENetworkOverrides;
.field private static final INSTRUMENTATION_REGISTRY_CLASS:Ljava/lang/String;
.field private static final MOCK_BASE_URL_ARGUMENT:Ljava/lang/String;
.field private static bridge baseUrl:Ljava/lang/String;
.field private static bridge cmpDeviceManagementEnabledOverride:Ljava/lang/Boolean;
.field private static bridge cmpSettingsEntryEnabledOverride:Ljava/lang/Boolean;
.field private static bridge forceHubHttpFallback:Z
.field private static bridge networkAvailableOverride:Ljava/lang/Boolean;
.field private static bridge overrideEnabled:Z
.field private static bridge taskPinMinIdeVersionOverride:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/network/E2ENetworkOverrides;
    invoke-direct v0, Lcom/bytedance/trae/network/E2ENetworkOverrides;-><init>()V
    sput-object v0, Lcom/bytedance/trae/network/E2ENetworkOverrides;->INSTANCE Lcom/bytedance/trae/network/E2ENetworkOverrides;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final canUseOverride()boolean
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isDebug()Z
    move-result v0
    if-eqz v0, +00eh
    sget-boolean v0, Lcom/bytedance/trae/network/E2ENetworkOverrides;->overrideEnabled Z
    if-nez v0, +008h
    invoke-direct v1, Lcom/bytedance/trae/network/E2ENetworkOverrides;->isE2EInstrumentationRun()Z
    move-result v0
    if-eqz v0, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    return v0
.end method

.method private final instrumentationArgumentsOrNull()android.os.Bundle
    .registers 6
    # ins_size=1
    invoke-direct v5, Lcom/bytedance/trae/network/E2ENetworkOverrides;->loadInstrumentationRegistryClass()Ljava/lang/Class;
    move-result-object v0
    const/4 v1, 0
    if-nez v0, +003h
    return-object v1
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v2, v5
    check-cast v2, Lcom/bytedance/trae/network/E2ENetworkOverrides;
    const-string v2, "getArguments"
    const/4 v3, 0
    new-array v4, v3, [Ljava/lang/Class;
    invoke-virtual v0, v2, v4, Ljava/lang/Class;->getMethod(Ljava/lang/String; [Ljava/lang/Class;)Ljava/lang/reflect/Method;
    move-result-object v0
    new-array v2, v3, [Ljava/lang/Object;
    invoke-virtual v0, v1, v2, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object; [Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    instance-of v2, v0, Landroid/os/Bundle;
    if-eqz v2, +005h
    check-cast v0, Landroid/os/Bundle;
    goto +2h
    move-object v0, v1
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    goto +ch
    move-exception v0
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +003h
    goto +2h
    move-object v1, v0
    check-cast v1, Landroid/os/Bundle;
    return-object v1
    :try_start_0x8
.end method

.method private final isE2EInstrumentationRun()boolean
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isDebug()Z
    move-result v0
    const/4 v1, 0
    if-nez v0, +003h
    return v1
    invoke-direct v3, Lcom/bytedance/trae/network/E2ENetworkOverrides;->instrumentationArgumentsOrNull()Landroid/os/Bundle;
    move-result-object v0
    if-nez v0, +003h
    return v1
    const-string v2, "mockBaseUrl"
    invoke-virtual v0, v2, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z
    move-result v2
    if-nez v2, +011h
    const-string v2, "backendMode"
    invoke-virtual v0, v2, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    const-string/jumbo v2, real
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    const/4 v1, 1
    return v1
.end method

.method private final loadInstrumentationRegistryClass()java.lang.Class
    .registers 7
    # ins_size=1
    const/4 v0, 3
    new-array v0, v0, [Ljava/lang/ClassLoader;
    invoke-static Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/Thread;->getContextClassLoader()Ljava/lang/ClassLoader;
    move-result-object v1
    const/4 v2, 0
    aput-object v1, v0, v2
    const-class v1, Lcom/bytedance/trae/network/E2ENetworkOverrides;
    invoke-virtual v1, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;
    move-result-object v1
    const/4 v3, 1
    aput-object v1, v0, v3
    const/4 v1, 2
    invoke-static Ljava/lang/ClassLoader;->getSystemClassLoader()Ljava/lang/ClassLoader;
    move-result-object v3
    aput-object v3, v0, v1
    invoke-static v0, Lkotlin/collections/CollectionsKt;->listOfNotNull([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    const/4 v3, 0
    const-string v4, "androidx.test.platform.app.InstrumentationRegistry"
    if-eqz v1, +02bh
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/ClassLoader;
    sget-object v5, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v4, v2, v1, Ljava/lang/Class;->forName(Ljava/lang/String; Z Ljava/lang/ClassLoader;)Ljava/lang/Class;
    move-result-object v1
    invoke-static v1, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    goto +ch
    move-exception v1
    sget-object v4, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v1, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v1
    invoke-static v1, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    invoke-static v1, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +003h
    goto +2h
    move-object v3, v1
    check-cast v3, Ljava/lang/Class;
    if-eqz v3, -02fh
    return-object v3
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v6
    check-cast v0, Lcom/bytedance/trae/network/E2ENetworkOverrides;
    invoke-static v4, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    goto +ch
    move-exception v0
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +003h
    goto +2h
    move-object v3, v0
    check-cast v3, Ljava/lang/Class;
    return-object v3
    :try_start_0x37
    :try_start_0x5a
.end method

.method private final normalizeAndValidate(java.lang.String)java.lang.String
    .registers 8
    # ins_size=2
    const-string v0, "/"
    const/4 v1, 0
    const/4 v2, 2
    const/4 v3, 0
    invoke-static v7, v0, v1, v2, v3, Lkotlin/text/StringsKt;->endsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    goto +14h
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v0, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    const/16 v0, 47
    invoke-virtual v7, v0, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    new-instance v0, Ljava/net/URI;
    invoke-direct v0, v7, Ljava/net/URI;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, Ljava/net/URI;->getScheme()Ljava/lang/String;
    move-result-object v2
    const-string/jumbo v4, toLowerCase(...)
    if-eqz v2, +00ch
    sget-object v5, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v2, v5, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v2
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +2h
    move-object v2, v3
    invoke-virtual v0, Ljava/net/URI;->getHost()Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +00bh
    sget-object v3, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v0, v3, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "http"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +00ah
    const-string v0, "https"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    const/4 v1, 1
    if-eqz v1, +017h
    const-string v0, "127.0.0.1"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    return-object v7
    new-instance v7, Ljava/lang/IllegalStateException;
    const-string v0, "E2E mock base URL host must be 127.0.0.1"
    invoke-virtual v0, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-direct v7, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v7
    new-instance v7, Ljava/lang/IllegalStateException;
    const-string v0, "E2E mock base URL must use http or https"
    invoke-virtual v0, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-direct v7, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v7
.end method

.method private final overridePrefsOrNull()android.content.SharedPreferences
    .registers 4
    # ins_size=1
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v3
    check-cast v0, Lcom/bytedance/trae/network/E2ENetworkOverrides;
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v0
    const-string v1, "e2e_network_overrides"
    const/4 v2, 0
    invoke-virtual v0, v1, v2, Landroid/app/Application;->getSharedPreferences(Ljava/lang/String; I)Landroid/content/SharedPreferences;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    goto +ch
    move-exception v0
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +003h
    const/4 v0, 0
    check-cast v0, Landroid/content/SharedPreferences;
    return-object v0
    :try_start_0x0
.end method

.method public final clear()void
    .registers 5
    # ins_size=1
    const/4 v0, 0
    sput-object v0, Lcom/bytedance/trae/network/E2ENetworkOverrides;->baseUrl Ljava/lang/String;
    const/4 v1, 0
    sput-boolean v1, Lcom/bytedance/trae/network/E2ENetworkOverrides;->forceHubHttpFallback Z
    sput-object v0, Lcom/bytedance/trae/network/E2ENetworkOverrides;->networkAvailableOverride Ljava/lang/Boolean;
    sput-object v0, Lcom/bytedance/trae/network/E2ENetworkOverrides;->taskPinMinIdeVersionOverride Ljava/lang/String;
    sput-object v0, Lcom/bytedance/trae/network/E2ENetworkOverrides;->cmpSettingsEntryEnabledOverride Ljava/lang/Boolean;
    sput-object v0, Lcom/bytedance/trae/network/E2ENetworkOverrides;->cmpDeviceManagementEnabledOverride Ljava/lang/Boolean;
    invoke-direct v4, Lcom/bytedance/trae/network/E2ENetworkOverrides;->overridePrefsOrNull()Landroid/content/SharedPreferences;
    move-result-object v2
    if-eqz v2, +013h
    invoke-interface v2, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;
    move-result-object v2
    if-eqz v2, +00dh
    const-string v3, "cmp_settings_entry_enabled"
    invoke-interface v2, v3, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    move-result-object v2
    if-eqz v2, +005h
    invoke-interface v2, Landroid/content/SharedPreferences$Editor;->apply()V
    invoke-direct v4, Lcom/bytedance/trae/network/E2ENetworkOverrides;->overridePrefsOrNull()Landroid/content/SharedPreferences;
    move-result-object v2
    if-eqz v2, +013h
    invoke-interface v2, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;
    move-result-object v2
    if-eqz v2, +00dh
    const-string v3, "cmp_device_management_enabled"
    invoke-interface v2, v3, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    move-result-object v2
    if-eqz v2, +005h
    invoke-interface v2, Landroid/content/SharedPreferences$Editor;->apply()V
    sput-boolean v1, Lcom/bytedance/trae/network/E2ENetworkOverrides;->overrideEnabled Z
    sget-object v1, Lcom/bytedance/trae/network/NetworkMonitor;->INSTANCE Lcom/bytedance/trae/network/NetworkMonitor;
    invoke-virtual v1, v0, Lcom/bytedance/trae/network/NetworkMonitor;->applyE2EConnectivityOverride(Ljava/lang/Boolean;)V
    return-void 
.end method

.method public final cmpDeviceManagementEnabledOverrideOrNull()java.lang.Boolean
    .registers 5
    # ins_size=1
    invoke-direct v4, Lcom/bytedance/trae/network/E2ENetworkOverrides;->canUseOverride()Z
    move-result v0
    const/4 v1, 0
    if-nez v0, +003h
    return-object v1
    sget-object v0, Lcom/bytedance/trae/network/E2ENetworkOverrides;->cmpDeviceManagementEnabledOverride Ljava/lang/Boolean;
    if-eqz v0, +00bh
    invoke-virtual v0, Ljava/lang/Boolean;->booleanValue()Z
    move-result v0
    invoke-static v0, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v0
    return-object v0
    invoke-direct v4, Lcom/bytedance/trae/network/E2ENetworkOverrides;->overridePrefsOrNull()Landroid/content/SharedPreferences;
    move-result-object v0
    if-nez v0, +003h
    return-object v1
    const-string v2, "cmp_device_management_enabled"
    invoke-interface v0, v2, Landroid/content/SharedPreferences;->contains(Ljava/lang/String;)Z
    move-result v3
    if-eqz v3, +00bh
    const/4 v1, 0
    invoke-interface v0, v2, v1, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String; Z)Z
    move-result v0
    invoke-static v0, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v1
    return-object v1
.end method

.method public final cmpSettingsEntryEnabledOverrideOrNull()java.lang.Boolean
    .registers 5
    # ins_size=1
    invoke-direct v4, Lcom/bytedance/trae/network/E2ENetworkOverrides;->canUseOverride()Z
    move-result v0
    const/4 v1, 0
    if-nez v0, +003h
    return-object v1
    sget-object v0, Lcom/bytedance/trae/network/E2ENetworkOverrides;->cmpSettingsEntryEnabledOverride Ljava/lang/Boolean;
    if-eqz v0, +00bh
    invoke-virtual v0, Ljava/lang/Boolean;->booleanValue()Z
    move-result v0
    invoke-static v0, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v0
    return-object v0
    invoke-direct v4, Lcom/bytedance/trae/network/E2ENetworkOverrides;->overridePrefsOrNull()Landroid/content/SharedPreferences;
    move-result-object v0
    if-nez v0, +003h
    return-object v1
    const-string v2, "cmp_settings_entry_enabled"
    invoke-interface v0, v2, Landroid/content/SharedPreferences;->contains(Ljava/lang/String;)Z
    move-result v3
    if-eqz v3, +00bh
    const/4 v1, 0
    invoke-interface v0, v2, v1, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String; Z)Z
    move-result v0
    invoke-static v0, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v1
    return-object v1
.end method

.method public final forceHubHttpFallbackOnly(boolean)void
    .registers 3
    # ins_size=2
    invoke-direct v1, Lcom/bytedance/trae/network/E2ENetworkOverrides;->isE2EInstrumentationRun()Z
    move-result v0
    if-eqz v0, +00bh
    const/4 v0, 0
    sput-object v0, Lcom/bytedance/trae/network/E2ENetworkOverrides;->baseUrl Ljava/lang/String;
    sput-boolean v2, Lcom/bytedance/trae/network/E2ENetworkOverrides;->forceHubHttpFallback Z
    const/4 v2, 1
    sput-boolean v2, Lcom/bytedance/trae/network/E2ENetworkOverrides;->overrideEnabled Z
    return-void 
    new-instance v2, Ljava/lang/IllegalStateException;
    const-string v0, "E2E network overrides are only available in debug androidTest runs"
    invoke-virtual v0, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-direct v2, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v2
.end method

.method public final isHubHttpFallbackForced()boolean
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/network/E2ENetworkOverrides;->canUseOverride()Z
    move-result v0
    if-eqz v0, +008h
    sget-boolean v0, Lcom/bytedance/trae/network/E2ENetworkOverrides;->forceHubHttpFallback Z
    if-eqz v0, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    return v0
.end method

.method public final networkAvailableOverrideOrNull()java.lang.Boolean
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/network/E2ENetworkOverrides;->canUseOverride()Z
    move-result v0
    if-nez v0, +004h
    const/4 v0, 0
    return-object v0
    sget-object v0, Lcom/bytedance/trae/network/E2ENetworkOverrides;->networkAvailableOverride Ljava/lang/Boolean;
    return-object v0
.end method

.method public final overrideBaseUrlOrNull()java.lang.String
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/network/E2ENetworkOverrides;->canUseOverride()Z
    move-result v0
    if-nez v0, +004h
    const/4 v0, 0
    return-object v0
    sget-object v0, Lcom/bytedance/trae/network/E2ENetworkOverrides;->baseUrl Ljava/lang/String;
    return-object v0
.end method

.method public final set(java.lang.String  boolean)void
    .registers 4
    # ins_size=3
    const-string v0, "fullBaseUrl"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Lcom/bytedance/trae/network/E2ENetworkOverrides;->isE2EInstrumentationRun()Z
    move-result v0
    if-eqz v0, +00eh
    invoke-direct v1, v2, Lcom/bytedance/trae/network/E2ENetworkOverrides;->normalizeAndValidate(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    sput-object v2, Lcom/bytedance/trae/network/E2ENetworkOverrides;->baseUrl Ljava/lang/String;
    sput-boolean v3, Lcom/bytedance/trae/network/E2ENetworkOverrides;->forceHubHttpFallback Z
    const/4 v2, 1
    sput-boolean v2, Lcom/bytedance/trae/network/E2ENetworkOverrides;->overrideEnabled Z
    return-void 
    new-instance v2, Ljava/lang/IllegalStateException;
    const-string v3, "E2E network overrides are only available in debug androidTest runs with mockBaseUrl"
    invoke-virtual v3, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-direct v2, v3, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v2
.end method

.method public final setCmpDeviceManagementEnabledForE2E(java.lang.Boolean)void
    .registers 4
    # ins_size=2
    invoke-direct v2, Lcom/bytedance/trae/network/E2ENetworkOverrides;->isE2EInstrumentationRun()Z
    move-result v0
    if-eqz v0, +026h
    sput-object v3, Lcom/bytedance/trae/network/E2ENetworkOverrides;->cmpDeviceManagementEnabledOverride Ljava/lang/Boolean;
    invoke-direct v2, Lcom/bytedance/trae/network/E2ENetworkOverrides;->overridePrefsOrNull()Landroid/content/SharedPreferences;
    move-result-object v0
    if-eqz v0, +01ah
    invoke-interface v0, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;
    move-result-object v0
    if-eqz v0, +014h
    const-string v1, "cmp_device_management_enabled"
    if-nez v3, +006h
    invoke-interface v0, v1, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    goto +8h
    invoke-virtual v3, Ljava/lang/Boolean;->booleanValue()Z
    move-result v3
    invoke-interface v0, v1, v3, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String; Z)Landroid/content/SharedPreferences$Editor;
    invoke-interface v0, Landroid/content/SharedPreferences$Editor;->apply()V
    const/4 v3, 1
    sput-boolean v3, Lcom/bytedance/trae/network/E2ENetworkOverrides;->overrideEnabled Z
    return-void 
    new-instance v3, Ljava/lang/IllegalStateException;
    const-string v0, "E2E CMP device management override is only available in debug androidTest runs"
    invoke-virtual v0, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-direct v3, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v3
.end method

.method public final setCmpSettingsEntryEnabledForE2E(java.lang.Boolean)void
    .registers 4
    # ins_size=2
    invoke-direct v2, Lcom/bytedance/trae/network/E2ENetworkOverrides;->isE2EInstrumentationRun()Z
    move-result v0
    if-eqz v0, +026h
    sput-object v3, Lcom/bytedance/trae/network/E2ENetworkOverrides;->cmpSettingsEntryEnabledOverride Ljava/lang/Boolean;
    invoke-direct v2, Lcom/bytedance/trae/network/E2ENetworkOverrides;->overridePrefsOrNull()Landroid/content/SharedPreferences;
    move-result-object v0
    if-eqz v0, +01ah
    invoke-interface v0, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;
    move-result-object v0
    if-eqz v0, +014h
    const-string v1, "cmp_settings_entry_enabled"
    if-nez v3, +006h
    invoke-interface v0, v1, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    goto +8h
    invoke-virtual v3, Ljava/lang/Boolean;->booleanValue()Z
    move-result v3
    invoke-interface v0, v1, v3, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String; Z)Landroid/content/SharedPreferences$Editor;
    invoke-interface v0, Landroid/content/SharedPreferences$Editor;->apply()V
    const/4 v3, 1
    sput-boolean v3, Lcom/bytedance/trae/network/E2ENetworkOverrides;->overrideEnabled Z
    return-void 
    new-instance v3, Ljava/lang/IllegalStateException;
    const-string v0, "E2E CMP settings entry override is only available in debug androidTest runs"
    invoke-virtual v0, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-direct v3, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v3
.end method

.method public final setNetworkAvailableForE2E(boolean)void
    .registers 3
    # ins_size=2
    invoke-direct v1, Lcom/bytedance/trae/network/E2ENetworkOverrides;->isE2EInstrumentationRun()Z
    move-result v0
    if-eqz v0, +015h
    invoke-static v2, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/network/E2ENetworkOverrides;->networkAvailableOverride Ljava/lang/Boolean;
    const/4 v0, 1
    sput-boolean v0, Lcom/bytedance/trae/network/E2ENetworkOverrides;->overrideEnabled Z
    sget-object v0, Lcom/bytedance/trae/network/NetworkMonitor;->INSTANCE Lcom/bytedance/trae/network/NetworkMonitor;
    invoke-static v2, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v2
    invoke-virtual v0, v2, Lcom/bytedance/trae/network/NetworkMonitor;->applyE2EConnectivityOverride(Ljava/lang/Boolean;)V
    return-void 
    new-instance v2, Ljava/lang/IllegalStateException;
    const-string v0, "E2E network availability override is only available in debug androidTest runs"
    invoke-virtual v0, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-direct v2, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v2
.end method

.method public final setTaskPinMinIdeVersionForE2E(java.lang.String)void
    .registers 5
    # ins_size=2
    invoke-direct v3, Lcom/bytedance/trae/network/E2ENetworkOverrides;->isE2EInstrumentationRun()Z
    move-result v0
    if-eqz v0, +017h
    const/4 v0, 1
    const/4 v1, 0
    if-eqz v4, +00dh
    move-object v2, v4
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    xor-int/2addr v2, v0
    if-eqz v2, +003h
    goto +2h
    move-object v4, v1
    sput-object v4, Lcom/bytedance/trae/network/E2ENetworkOverrides;->taskPinMinIdeVersionOverride Ljava/lang/String;
    sput-boolean v0, Lcom/bytedance/trae/network/E2ENetworkOverrides;->overrideEnabled Z
    return-void 
    new-instance v4, Ljava/lang/IllegalStateException;
    const-string v0, "E2E task pin settings override is only available in debug androidTest runs"
    invoke-virtual v0, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-direct v4, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v4
.end method

.method public final shouldBypassAppLogDidWaitForMockE2E()boolean
    .registers 6
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isDebug()Z
    move-result v0
    const/4 v1, 0
    if-nez v0, +003h
    return v1
    invoke-direct v5, Lcom/bytedance/trae/network/E2ENetworkOverrides;->instrumentationArgumentsOrNull()Landroid/os/Bundle;
    move-result-object v0
    if-nez v0, +003h
    return v1
    const-string v2, "backendMode"
    invoke-virtual v0, v2, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    const/4 v3, 0
    if-eqz v2, +00fh
    sget-object v4, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v2, v4, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v2
    const-string/jumbo v4, toLowerCase(...)
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +2h
    move-object v2, v3
    const-string v4, "mock"
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +003h
    return v1
    const-string v2, "mockBaseUrl"
    invoke-virtual v0, v2, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +03eh
    move-object v2, v0
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    const/4 v4, 1
    xor-int/2addr v2, v4
    if-eqz v2, +003h
    move-object v3, v0
    if-eqz v3, +030h
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v5
    check-cast v0, Lcom/bytedance/trae/network/E2ENetworkOverrides;
    invoke-direct v5, v3, Lcom/bytedance/trae/network/E2ENetworkOverrides;->normalizeAndValidate(Ljava/lang/String;)Ljava/lang/String;
    invoke-static v4, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    goto +ch
    move-exception v0
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v1, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v1
    invoke-static v0, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +003h
    move-object v0, v1
    check-cast v0, Ljava/lang/Boolean;
    invoke-virtual v0, Ljava/lang/Boolean;->booleanValue()Z
    move-result v0
    return v0
    return v1
    :try_start_0x47
.end method

.method public final taskPinMinIdeVersionOverrideOrNull()java.lang.String
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/network/E2ENetworkOverrides;->canUseOverride()Z
    move-result v0
    if-nez v0, +004h
    const/4 v0, 0
    return-object v0
    sget-object v0, Lcom/bytedance/trae/network/E2ENetworkOverrides;->taskPinMinIdeVersionOverride Ljava/lang/String;
    return-object v0
.end method
