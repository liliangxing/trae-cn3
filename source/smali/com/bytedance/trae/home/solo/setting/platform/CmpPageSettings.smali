# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/platform/CmpPageSettings;
.super Ljava/lang/Object;
.source "CmpPageSettings.kt"

.field public static final $stable:I
.field private static final DEVICE_MANAGEMENT_KEY:Ljava/lang/String;
.field public static final INSTANCE:Lcom/bytedance/trae/home/solo/setting/platform/CmpPageSettings;
.field private static final SETTINGS_ENTRY_KEY:Ljava/lang/String;
.field private static final TAG:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/platform/CmpPageSettings;
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/platform/CmpPageSettings;-><init>()V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/platform/CmpPageSettings;->INSTANCE Lcom/bytedance/trae/home/solo/setting/platform/CmpPageSettings;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final readBoolean(java.lang.String)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 0
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v1, v7
    check-cast v1, Lcom/bytedance/trae/home/solo/setting/platform/CmpPageSettings;
    const-class v1, Lcom/bytedance/trae/home/solo/setting/platform/IHomeCmpPageSettings;
    invoke-static v1, Lcom/bytedance/news/common/settings/SettingsManager;->obtain(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/home/solo/setting/platform/IHomeCmpPageSettings;
    if-eqz v1, +007h
    invoke-interface v1, Lcom/bytedance/trae/home/solo/setting/platform/IHomeCmpPageSettings;->getEnableCmpPages()Lcom/google/gson/JsonObject;
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
    invoke-static v1, Lkotlin/Result;->exceptionOrNull-impl(Ljava/lang/Object;)Ljava/lang/Throwable;
    move-result-object v2
    const-string v3, "CmpPageSettings"
    if-eqz v2, +009h
    sget-object v4, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v5, "obtain cmp page settings failed"
    invoke-virtual v4, v3, v5, v2, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    invoke-static v1, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +003h
    move-object v1, v0
    check-cast v1, Lcom/google/gson/JsonObject;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    sget-object v4, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v4, v7
    check-cast v4, Lcom/bytedance/trae/home/solo/setting/platform/CmpPageSettings;
    invoke-virtual v1, v8, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v8
    if-eqz v8, +013h
    invoke-virtual v8, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v4
    if-eqz v4, +003h
    move-object v0, v8
    if-eqz v0, +00ah
    invoke-virtual v0, Lcom/google/gson/JsonElement;->getAsBoolean()Z
    move-result v8
    const/4 v0, 1
    if-ne v8, v0, +003h
    goto +2h
    move v0, v2
    invoke-static v0, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v8
    invoke-static v8, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v8
    goto +ch
    move-exception v8
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v8, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v8
    invoke-static v8, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v8
    invoke-static v8, Lkotlin/Result;->exceptionOrNull-impl(Ljava/lang/Object;)Ljava/lang/Throwable;
    move-result-object v0
    if-eqz v0, +016h
    sget-object v4, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v5, Ljava/lang/StringBuilder;
    const-string v6, "parse cmp page settings failed: "
    invoke-direct v5, v6, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v5, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v4, v3, v1, v0, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    invoke-static v2, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v0
    invoke-static v8, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +003h
    move-object v8, v0
    check-cast v8, Ljava/lang/Boolean;
    invoke-virtual v8, Ljava/lang/Boolean;->booleanValue()Z
    move-result v8
    return v8
    :try_start_0x1
    :try_start_0x42
.end method

.method public final isDeviceManagementEnabled()boolean
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/E2ENetworkOverrides;->INSTANCE Lcom/bytedance/trae/network/E2ENetworkOverrides;
    invoke-virtual v0, Lcom/bytedance/trae/network/E2ENetworkOverrides;->cmpDeviceManagementEnabledOverrideOrNull()Ljava/lang/Boolean;
    move-result-object v0
    if-eqz v0, +007h
    invoke-virtual v0, Ljava/lang/Boolean;->booleanValue()Z
    move-result v0
    return v0
    const-string v0, "device_management"
    invoke-direct v1, v0, Lcom/bytedance/trae/home/solo/setting/platform/CmpPageSettings;->readBoolean(Ljava/lang/String;)Z
    move-result v0
    return v0
.end method

.method public final isSettingsEntryEnabled()boolean
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/E2ENetworkOverrides;->INSTANCE Lcom/bytedance/trae/network/E2ENetworkOverrides;
    invoke-virtual v0, Lcom/bytedance/trae/network/E2ENetworkOverrides;->cmpSettingsEntryEnabledOverrideOrNull()Ljava/lang/Boolean;
    move-result-object v0
    if-eqz v0, +007h
    invoke-virtual v0, Ljava/lang/Boolean;->booleanValue()Z
    move-result v0
    return v0
    const-string/jumbo v0, settings_entry
    invoke-direct v1, v0, Lcom/bytedance/trae/home/solo/setting/platform/CmpPageSettings;->readBoolean(Ljava/lang/String;)Z
    move-result v0
    return v0
.end method
