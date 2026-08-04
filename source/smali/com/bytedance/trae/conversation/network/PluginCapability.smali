# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/network/PluginCapability;
.super Ljava/lang/Object;
.source "PluginCapability.kt"

.field private static final DEFAULT_TASK_PLUGIN_MIN_IDE_VERSION:Ljava/lang/String;
.field public static final INSTANCE:Lcom/bytedance/trae/conversation/network/PluginCapability;
.field private static final SOLO_MIN_VERSION_KEY:Ljava/lang/String;
.field private static final TAG:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/network/PluginCapability;
    invoke-direct v0, Lcom/bytedance/trae/conversation/network/PluginCapability;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/network/PluginCapability;->INSTANCE Lcom/bytedance/trae/conversation/network/PluginCapability;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final isSupported(boolean  java.lang.String)boolean
    .registers 4
    # ins_size=3
    if-nez v2, +004h
    const/4 v2, 1
    return v2
    sget-object v2, Lcom/bytedance/trae/conversation/network/IdeVersionComparator;->INSTANCE Lcom/bytedance/trae/conversation/network/IdeVersionComparator;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/network/PluginCapability;->minSupportedIdeVersion()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v2, v3, v0, Lcom/bytedance/trae/conversation/network/IdeVersionComparator;->isGreaterOrEqual(Ljava/lang/String; Ljava/lang/String;)Z
    move-result v2
    return v2
.end method

.method public final minSupportedIdeVersion()java.lang.String
    .registers 8
    # ins_size=1
    const/4 v0, 0
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v1, v7
    check-cast v1, Lcom/bytedance/trae/conversation/network/PluginCapability;
    const-class v1, Lcom/bytedance/trae/conversation/network/IPluginSettings;
    invoke-static v1, Lcom/bytedance/news/common/settings/SettingsManager;->obtain(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/network/IPluginSettings;
    if-eqz v1, +007h
    invoke-interface v1, Lcom/bytedance/trae/conversation/network/IPluginSettings;->getCliTaskPluginMinIdeVersion()Ljava/lang/String;
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
    const-string v3, "PluginCapability"
    if-eqz v2, +009h
    sget-object v4, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    const-string v5, "obtain plugin settings failed"
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
    move-object v0, v1
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    if-eqz v1, +00bh
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    if-eqz v1, +003h
    goto +3h
    move v1, v4
    goto +2h
    move v1, v5
    const-string v2, "0.1.27"
    if-eqz v1, +003h
    return-object v2
    invoke-virtual v7, v0, Lcom/bytedance/trae/conversation/network/PluginCapability;->parseSettingsMinSupportedIdeVersion$conversation_mainlandRelease(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    move-object v6, v1
    check-cast v6, Ljava/lang/CharSequence;
    if-eqz v6, +008h
    invoke-static v6, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v6
    if-eqz v6, +003h
    move v4, v5
    if-eqz v4, +017h
    sget-object v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v5, "minSupportedIdeVersion: version missing, rawConfig="
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v1, v3, v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-object v2
    sget-object v0, Lcom/bytedance/trae/conversation/network/IdeVersionComparator;->INSTANCE Lcom/bytedance/trae/conversation/network/IdeVersionComparator;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/network/IdeVersionComparator;->isGreaterOrEqual(Ljava/lang/String; Ljava/lang/String;)Z
    move-result v0
    if-eqz v0, +003h
    move-object v2, v1
    return-object v2
    :try_start_0x1
.end method

.method public final parseSettingsMinSupportedIdeVersion$conversation_mainlandRelease(java.lang.String)java.lang.String
    .registers 9
    # ins_size=2
    move-object v0, v8
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v1, 1
    if-eqz v0, +00bh
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    if-eqz v0, +003h
    goto +3h
    const/4 v0, 0
    goto +2h
    move v0, v1
    const/4 v2, 0
    if-nez v0, +003h
    goto +2h
    move-object v8, v2
    if-nez v8, +003h
    return-object v2
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v7
    check-cast v0, Lcom/bytedance/trae/conversation/network/PluginCapability;
    invoke-static v8, Lcom/google/gson/JsonParser;->parseString(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v0
    invoke-virtual v0, Lcom/google/gson/JsonElement;->getAsJsonObject()Lcom/google/gson/JsonObject;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    goto +ch
    move-exception v0
    sget-object v3, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->exceptionOrNull-impl(Ljava/lang/Object;)Ljava/lang/Throwable;
    move-result-object v3
    if-eqz v3, +018h
    sget-object v4, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v5, Ljava/lang/StringBuilder;
    const-string v6, "minSupportedIdeVersion: parse settings config failed, rawConfig="
    invoke-direct v5, v6, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v5, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v8
    const-string v5, "PluginCapability"
    invoke-virtual v4, v5, v8, v3, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    invoke-static v0, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v8
    if-eqz v8, +003h
    move-object v0, v2
    check-cast v0, Lcom/google/gson/JsonObject;
    if-nez v0, +003h
    return-object v2
    const-string/jumbo v8, solo_min_version
    invoke-virtual v0, v8, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v8
    if-eqz v8, +01dh
    invoke-virtual v8, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v0
    if-eqz v0, +003h
    goto +2h
    move-object v8, v2
    if-eqz v8, +013h
    invoke-virtual v8, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v8
    if-eqz v8, +00dh
    move-object v0, v8
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    xor-int/2addr v0, v1
    if-eqz v0, +003h
    move-object v2, v8
    return-object v2
    :try_start_0x18
.end method
