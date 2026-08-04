# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderSettings;
.super Ljava/lang/Object;
.source "UpgradeReminderSettings.kt"

.field private static final E2E_PREF:Ljava/lang/String;
.field public static final INSTANCE:Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderSettings;
.field private static final KEY_SETTINGS_OVERRIDE:Ljava/lang/String;
.field private static final SETTINGS_INSTRUMENTATION_CLASS:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderSettings;
    invoke-direct v0, Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderSettings;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderSettings;->INSTANCE Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderSettings;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final e2eOverride()com.google.gson.JsonObject
    .registers 5
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isDebug()Z
    move-result v0
    const/4 v1, 0
    if-eqz v0, +081h
    invoke-direct v4, Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderSettings;->isInstrumentationRun()Z
    move-result v0
    if-nez v0, +004h
    goto/16 +079h
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v4
    check-cast v0, Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderSettings;
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v0
    const-string/jumbo v2, upgrade_reminder_e2e
    const/4 v3, 0
    invoke-virtual v0, v2, v3, Landroid/app/Application;->getSharedPreferences(Ljava/lang/String; I)Landroid/content/SharedPreferences;
    move-result-object v0
    const-string/jumbo v2, settings_override
    invoke-interface v0, v2, v1, Landroid/content/SharedPreferences;->getString(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
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
    invoke-static v0, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +003h
    move-object v0, v1
    check-cast v0, Ljava/lang/String;
    if-eqz v0, +044h
    move-object v2, v0
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    xor-int/lit8 v2, v2, 1
    if-eqz v2, +003h
    goto +2h
    move-object v0, v1
    if-eqz v0, +035h
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v2, v4
    check-cast v2, Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderSettings;
    invoke-static v0, Lcom/google/gson/JsonParser;->parseString(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v0
    invoke-virtual v0, Lcom/google/gson/JsonElement;->isJsonObject()Z
    move-result v2
    if-eqz v2, +003h
    goto +2h
    move-object v0, v1
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/google/gson/JsonElement;->getAsJsonObject()Lcom/google/gson/JsonObject;
    move-result-object v0
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
    check-cast v1, Lcom/google/gson/JsonObject;
    return-object v1
    :try_start_0x11
    :try_start_0x55
.end method

.method private final isInstrumentationRun()boolean
    .registers 4
    # ins_size=1
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v3
    check-cast v0, Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderSettings;
    const-string v0, "androidx.test.platform.app.InstrumentationRegistry"
    invoke-static v0, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;
    const/4 v0, 1
    invoke-static v0, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
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
    const/4 v1, 0
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
    :try_start_0x0
.end method

.method private final parse(com.google.gson.JsonObject)com.bytedance.trae.conversation.upgrade.UpgradeReminderConfig
    .registers 7
    # ins_size=2
    const/4 v0, 0
    if-nez v6, +003h
    return-object v0
    const-string v1, "enabled"
    invoke-virtual v6, v1, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v1
    if-eqz v1, +09bh
    invoke-virtual v1, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v2
    if-eqz v2, +003h
    goto +2h
    move-object v1, v0
    if-eqz v1, +091h
    invoke-virtual v1, Lcom/google/gson/JsonElement;->getAsJsonPrimitive()Lcom/google/gson/JsonPrimitive;
    move-result-object v1
    if-eqz v1, +08bh
    invoke-virtual v1, Lcom/google/gson/JsonPrimitive;->isBoolean()Z
    move-result v2
    if-eqz v2, +003h
    goto +2h
    move-object v1, v0
    if-eqz v1, +081h
    invoke-virtual v1, Lcom/google/gson/JsonPrimitive;->getAsBoolean()Z
    move-result v1
    if-nez v1, +003h
    return-object v0
    const-string/jumbo v1, version_config
    invoke-virtual v6, v1, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v6
    if-eqz v6, +071h
    invoke-virtual v6, Lcom/google/gson/JsonElement;->isJsonObject()Z
    move-result v1
    if-eqz v1, +003h
    goto +2h
    move-object v6, v0
    if-eqz v6, +067h
    invoke-virtual v6, Lcom/google/gson/JsonElement;->getAsJsonObject()Lcom/google/gson/JsonObject;
    move-result-object v6
    if-eqz v6, +061h
    const-string v1, "recommended_highest"
    invoke-virtual v6, v1, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v6
    if-eqz v6, +059h
    invoke-virtual v6, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v1
    if-eqz v1, +003h
    goto +2h
    move-object v6, v0
    if-eqz v6, +04fh
    invoke-virtual v6, Lcom/google/gson/JsonElement;->getAsJsonPrimitive()Lcom/google/gson/JsonPrimitive;
    move-result-object v6
    if-eqz v6, +049h
    invoke-virtual v6, Lcom/google/gson/JsonPrimitive;->isNumber()Z
    move-result v1
    if-eqz v1, +00bh
    invoke-virtual v6, Lcom/google/gson/JsonPrimitive;->getAsLong()J
    move-result-wide v1
    invoke-static v1, v2, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v6
    goto +16h
    invoke-virtual v6, Lcom/google/gson/JsonPrimitive;->isString()Z
    move-result v1
    if-eqz v1, +010h
    invoke-virtual v6, Lcom/google/gson/JsonPrimitive;->getAsString()Ljava/lang/String;
    move-result-object v6
    const-string v1, "getAsString(...)"
    invoke-static v6, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v6, Lkotlin/text/StringsKt;->toLongOrNull(Ljava/lang/String;)Ljava/lang/Long;
    move-result-object v6
    goto +2h
    move-object v6, v0
    if-eqz v6, +023h
    move-object v1, v6
    check-cast v1, Ljava/lang/Number;
    invoke-virtual v1, Ljava/lang/Number;->longValue()J
    move-result-wide v1
    const-wide/16 v3, 0
    cmp-long v1, v1, v3
    const/4 v2, 1
    if-lez v1, +004h
    move v1, v2
    goto +2h
    const/4 v1, 0
    if-eqz v1, +003h
    goto +2h
    move-object v6, v0
    if-eqz v6, +00ch
    invoke-virtual v6, Ljava/lang/Long;->longValue()J
    move-result-wide v0
    new-instance v6, Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderConfig;
    invoke-direct v6, v2, v0, v1, Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderConfig;-><init>(Z J)V
    return-object v6
    return-object v0
.end method

.method public final getConfig()com.bytedance.trae.conversation.upgrade.UpgradeReminderConfig
    .registers 4
    # ins_size=1
    invoke-direct v3, Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderSettings;->e2eOverride()Lcom/google/gson/JsonObject;
    move-result-object v0
    if-nez v0, +032h
    const/4 v0, 0
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v1, v3
    check-cast v1, Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderSettings;
    const-class v1, Lcom/bytedance/trae/conversation/upgrade/IUpgradeReminderSettings;
    invoke-static v1, Lcom/bytedance/news/common/settings/SettingsManager;->obtain(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/upgrade/IUpgradeReminderSettings;
    if-eqz v1, +007h
    invoke-interface v1, Lcom/bytedance/trae/conversation/upgrade/IUpgradeReminderSettings;->getUpgradeReminderConfig()Lcom/google/gson/JsonObject;
    move-result-object v1
    goto +2h
    move-object v1, v0
    invoke-static v1, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    goto +ch
    move-exception v1
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v1, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v1
    invoke-static v1, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    invoke-static v1, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +003h
    goto +2h
    move-object v0, v1
    check-cast v0, Lcom/google/gson/JsonObject;
    invoke-direct v3, v0, Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderSettings;->parse(Lcom/google/gson/JsonObject;)Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderConfig;
    move-result-object v0
    return-object v0
    :try_start_0x7
.end method
