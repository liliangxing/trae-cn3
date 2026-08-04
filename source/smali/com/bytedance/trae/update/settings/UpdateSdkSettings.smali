# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/update/settings/UpdateSdkSettings;
.super Ljava/lang/Object;
.source "UpdateSdkSettings.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/update/settings/UpdateSdkSettings;
.field private static final updateSettings$delegate:Lkotlin/Lazy;


.method public static synthetic $r8$lambda$6npO3UD11T9kycqhkWQxuu2inlM()com.bytedance.trae.update.settings.IUpdateSdkSettings
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/update/settings/UpdateSdkSettings;->updateSettings_delegate$lambda$0()Lcom/bytedance/trae/update/settings/IUpdateSdkSettings;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/update/settings/UpdateSdkSettings;
    invoke-direct v0, Lcom/bytedance/trae/update/settings/UpdateSdkSettings;-><init>()V
    sput-object v0, Lcom/bytedance/trae/update/settings/UpdateSdkSettings;->INSTANCE Lcom/bytedance/trae/update/settings/UpdateSdkSettings;
    new-instance v0, Lcom/bytedance/trae/update/settings/UpdateSdkSettings$$ExternalSyntheticLambda0;
    invoke-direct v0, Lcom/bytedance/trae/update/settings/UpdateSdkSettings$$ExternalSyntheticLambda0;-><init>()V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/update/settings/UpdateSdkSettings;->updateSettings$delegate Lkotlin/Lazy;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final getUpdateSettings()com.bytedance.trae.update.settings.IUpdateSdkSettings
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/update/settings/UpdateSdkSettings;->updateSettings$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/update/settings/IUpdateSdkSettings;
    return-object v0
.end method

.method private static final updateSettings_delegate$lambda$0()com.bytedance.trae.update.settings.IUpdateSdkSettings
    .registers 1
    # ins_size=0
    const-class v0, Lcom/bytedance/trae/update/settings/IUpdateSdkSettings;
    invoke-static v0, Lcom/bytedance/news/common/settings/SettingsManager;->obtain(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/update/settings/IUpdateSdkSettings;
    goto +2h
    const/4 v0, 0
    return-object v0
    :try_start_0x0
.end method

.method public final getDialogShowInterval(long)long
    .registers 5
    # ins_size=3
    invoke-direct v2, Lcom/bytedance/trae/update/settings/UpdateSdkSettings;->getUpdateSettings()Lcom/bytedance/trae/update/settings/IUpdateSdkSettings;
    move-result-object v0
    if-eqz v0, +007h
    invoke-interface v0, Lcom/bytedance/trae/update/settings/IUpdateSdkSettings;->getUpdateSdkConfig()Lcom/google/gson/JsonObject;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    if-eqz v0, +014h
    const-string v1, "dialog_show_interval"
    invoke-virtual v0, v1, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v0
    if-eqz v0, +00ch
    invoke-virtual v0, Lcom/google/gson/JsonElement;->getAsJsonPrimitive()Lcom/google/gson/JsonPrimitive;
    move-result-object v0
    if-eqz v0, +006h
    invoke-virtual v0, Lcom/google/gson/JsonPrimitive;->getAsLong()J
    move-result-wide v3
    return-wide v3
.end method

.method public final getManualUpdateEnable(boolean)boolean
    .registers 4
    # ins_size=2
    invoke-direct v2, Lcom/bytedance/trae/update/settings/UpdateSdkSettings;->getUpdateSettings()Lcom/bytedance/trae/update/settings/IUpdateSdkSettings;
    move-result-object v0
    if-eqz v0, +007h
    invoke-interface v0, Lcom/bytedance/trae/update/settings/IUpdateSdkSettings;->getUpdateSdkConfig()Lcom/google/gson/JsonObject;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    if-eqz v0, +014h
    const-string v1, "manual_update_enable"
    invoke-virtual v0, v1, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v0
    if-eqz v0, +00ch
    invoke-virtual v0, Lcom/google/gson/JsonElement;->getAsJsonPrimitive()Lcom/google/gson/JsonPrimitive;
    move-result-object v0
    if-eqz v0, +006h
    invoke-virtual v0, Lcom/google/gson/JsonPrimitive;->getAsBoolean()Z
    move-result v3
    return v3
.end method

.method public final getSdkUpdateEnable(boolean)boolean
    .registers 4
    # ins_size=2
    invoke-direct v2, Lcom/bytedance/trae/update/settings/UpdateSdkSettings;->getUpdateSettings()Lcom/bytedance/trae/update/settings/IUpdateSdkSettings;
    move-result-object v0
    if-eqz v0, +007h
    invoke-interface v0, Lcom/bytedance/trae/update/settings/IUpdateSdkSettings;->getUpdateSdkConfig()Lcom/google/gson/JsonObject;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    if-eqz v0, +015h
    const-string/jumbo v1, sdk_update_enable
    invoke-virtual v0, v1, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v0
    if-eqz v0, +00ch
    invoke-virtual v0, Lcom/google/gson/JsonElement;->getAsJsonPrimitive()Lcom/google/gson/JsonPrimitive;
    move-result-object v0
    if-eqz v0, +006h
    invoke-virtual v0, Lcom/google/gson/JsonPrimitive;->getAsBoolean()Z
    move-result v3
    return v3
.end method

.method public final getUpdateFormalConfig()com.google.gson.JsonObject
    .registers 3
    # ins_size=1
    invoke-direct v2, Lcom/bytedance/trae/update/settings/UpdateSdkSettings;->getUpdateSettings()Lcom/bytedance/trae/update/settings/IUpdateSdkSettings;
    move-result-object v0
    const/4 v1, 0
    if-eqz v0, +007h
    invoke-interface v0, Lcom/bytedance/trae/update/settings/IUpdateSdkSettings;->getUpdateSdkConfig()Lcom/google/gson/JsonObject;
    move-result-object v0
    goto +2h
    move-object v0, v1
    if-eqz v0, +008h
    const-string v1, "formal_update_config"
    invoke-virtual v0, v1, Lcom/google/gson/JsonObject;->getAsJsonObject(Ljava/lang/String;)Lcom/google/gson/JsonObject;
    move-result-object v1
    return-object v1
.end method
