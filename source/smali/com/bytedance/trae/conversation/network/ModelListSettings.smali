# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/network/ModelListSettings;
.super Ljava/lang/Object;
.source "IModelListSettings.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/network/ModelListSettings;
.field private static final TAG:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/network/ModelListSettings;
    invoke-direct v0, Lcom/bytedance/trae/conversation/network/ModelListSettings;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/network/ModelListSettings;->INSTANCE Lcom/bytedance/trae/conversation/network/ModelListSettings;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final isBelowConfiguredMinIdeVersion(java.lang.String)boolean
    .registers 4
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/conversation/network/IdeVersionGate;->INSTANCE Lcom/bytedance/trae/conversation/network/IdeVersionGate;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/network/ModelListSettings;->minSupportedIdeVersion()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v3, v1, Lcom/bytedance/trae/conversation/network/IdeVersionGate;->shouldBlockByMinimum(Ljava/lang/String; Ljava/lang/String;)Z
    move-result v3
    return v3
.end method

.method public final minSupportedIdeVersion()java.lang.String
    .registers 11
    # ins_size=1
    const/4 v0, 0
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v1, v10
    check-cast v1, Lcom/bytedance/trae/conversation/network/ModelListSettings;
    const-class v1, Lcom/bytedance/trae/conversation/network/IModelListSettings;
    invoke-static v1, Lcom/bytedance/news/common/settings/SettingsManager;->obtain(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/network/IModelListSettings;
    if-eqz v1, +007h
    invoke-interface v1, Lcom/bytedance/trae/conversation/network/IModelListSettings;->getCliModelListMinIdeVersion()Ljava/lang/String;
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
    const-string v3, "ModelListSettings"
    if-eqz v2, +009h
    sget-object v4, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    const-string v5, "obtain model list settings failed"
    invoke-virtual v4, v3, v5, v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    invoke-static v1, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +003h
    move-object v1, v0
    check-cast v1, Ljava/lang/String;
    move-object v2, v1
    check-cast v2, Ljava/lang/CharSequence;
    const/4 v4, 0
    const/4 v5, 1
    if-eqz v2, +00bh
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    if-eqz v2, +003h
    goto +3h
    move v2, v4
    goto +2h
    move v2, v5
    if-nez v2, +003h
    goto +2h
    move-object v1, v0
    move-object v2, v1
    check-cast v2, Ljava/lang/CharSequence;
    if-eqz v2, +00bh
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    if-eqz v2, +003h
    goto +3h
    move v2, v4
    goto +2h
    move v2, v5
    if-eqz v2, +00ah
    sget-object v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    const-string v2, "minSupportedIdeVersion: settings config is null"
    invoke-virtual v1, v3, v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-object v0
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v2, v10
    check-cast v2, Lcom/bytedance/trae/conversation/network/ModelListSettings;
    invoke-static v1, Lcom/google/gson/JsonParser;->parseString(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v2
    invoke-virtual v2, Lcom/google/gson/JsonElement;->getAsJsonObject()Lcom/google/gson/JsonObject;
    move-result-object v2
    invoke-static v2, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    goto +ch
    move-exception v2
    sget-object v6, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v2, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v2
    invoke-static v2, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    invoke-static v2, Lkotlin/Result;->exceptionOrNull-impl(Ljava/lang/Object;)Ljava/lang/Throwable;
    move-result-object v6
    if-eqz v6, +016h
    sget-object v7, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v8, Ljava/lang/StringBuilder;
    const-string v9, "minSupportedIdeVersion: parse settings config failed, rawConfig="
    invoke-direct v8, v9, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v8, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v7, v3, v8, v6, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    invoke-static v2, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v6
    if-eqz v6, +003h
    move-object v2, v0
    check-cast v2, Lcom/google/gson/JsonObject;
    if-nez v2, +003h
    return-object v0
    const-string v6, "enable"
    invoke-virtual v2, v6, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v6
    if-eqz v6, +014h
    invoke-virtual v6, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v7
    if-eqz v7, +003h
    goto +2h
    move-object v6, v0
    if-eqz v6, +00ah
    invoke-virtual v6, Lcom/google/gson/JsonElement;->getAsBoolean()Z
    move-result v6
    if-ne v6, v5, +004h
    move v6, v5
    goto +2h
    move v6, v4
    if-nez v6, +017h
    sget-object v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v5, "minSupportedIdeVersion: disabled by settings, rawConfig="
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v2, v3, v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-object v0
    sget-object v6, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v6, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v6
    if-eqz v6, +005h
    const-string v6, "i18n_solo_min_version"
    goto +3h
    const-string v6, "cn_solo_min_version"
    invoke-virtual v2, v6, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v2
    if-eqz v2, +011h
    invoke-virtual v2, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v6
    if-eqz v6, +003h
    goto +2h
    move-object v2, v0
    if-eqz v2, +007h
    invoke-virtual v2, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v2
    goto +2h
    move-object v2, v0
    move-object v6, v2
    check-cast v6, Ljava/lang/CharSequence;
    if-eqz v6, +008h
    invoke-static v6, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v6
    if-eqz v6, +003h
    move v4, v5
    if-eqz v4, +027h
    sget-object v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v5, "minSupportedIdeVersion: version missing, isOversea="
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    sget-object v5, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v5, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v5
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v5, ", rawConfig="
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v2, v3, v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-object v0
    return-object v2
    :try_start_0x1
    :try_start_0x6c
.end method
