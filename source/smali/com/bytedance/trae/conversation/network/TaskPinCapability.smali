# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/network/TaskPinCapability;
.super Ljava/lang/Object;
.source "TaskPinCapability.kt"

.field public static final FEATURE_KEY:Ljava/lang/String;
.field public static final INSTANCE:Lcom/bytedance/trae/conversation/network/TaskPinCapability;
.field private static final SOLO_MIN_VERSION_KEY:Ljava/lang/String;
.field private static final TAG:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/network/TaskPinCapability;
    invoke-direct v0, Lcom/bytedance/trae/conversation/network/TaskPinCapability;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/network/TaskPinCapability;->INSTANCE Lcom/bytedance/trae/conversation/network/TaskPinCapability;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final isSupported(boolean  java.lang.String)boolean
    .registers 6
    # ins_size=3
    const/4 v0, 1
    if-nez v4, +003h
    return v0
    invoke-virtual v3, Lcom/bytedance/trae/conversation/network/TaskPinCapability;->minSupportedIdeVersion()Ljava/lang/String;
    move-result-object v4
    move-object v1, v4
    check-cast v1, Ljava/lang/CharSequence;
    const/4 v2, 0
    if-eqz v1, +00ah
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    if-eqz v1, +003h
    goto +2h
    move v0, v2
    if-eqz v0, +003h
    return v2
    sget-object v0, Lcom/bytedance/trae/conversation/network/IdeVersionComparator;->INSTANCE Lcom/bytedance/trae/conversation/network/IdeVersionComparator;
    invoke-virtual v0, v5, v4, Lcom/bytedance/trae/conversation/network/IdeVersionComparator;->isGreaterOrEqual(Ljava/lang/String; Ljava/lang/String;)Z
    move-result v4
    return v4
.end method

.method public final minSupportedIdeVersion()java.lang.String
    .registers 9
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/E2ENetworkOverrides;->INSTANCE Lcom/bytedance/trae/network/E2ENetworkOverrides;
    invoke-virtual v0, Lcom/bytedance/trae/network/E2ENetworkOverrides;->taskPinMinIdeVersionOverrideOrNull()Ljava/lang/String;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    const/4 v2, 0
    const/4 v3, 1
    if-eqz v1, +00bh
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    if-eqz v1, +003h
    goto +3h
    move v1, v2
    goto +2h
    move v1, v3
    if-nez v1, +003h
    return-object v0
    const/4 v0, 0
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v1, v8
    check-cast v1, Lcom/bytedance/trae/conversation/network/TaskPinCapability;
    const-class v1, Lcom/bytedance/trae/conversation/network/ITaskPinSettings;
    invoke-static v1, Lcom/bytedance/news/common/settings/SettingsManager;->obtain(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/network/ITaskPinSettings;
    if-eqz v1, +007h
    invoke-interface v1, Lcom/bytedance/trae/conversation/network/ITaskPinSettings;->getCliTaskPinMinIdeVersion()Ljava/lang/String;
    move-result-object v1
    goto +2h
    move-object v1, v0
    invoke-static v1, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    goto +ch
    move-exception v1
    sget-object v4, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v1, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v1
    invoke-static v1, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    invoke-static v1, Lkotlin/Result;->exceptionOrNull-impl(Ljava/lang/Object;)Ljava/lang/Throwable;
    move-result-object v4
    const-string v5, "TaskPinCapability"
    if-eqz v4, +009h
    sget-object v6, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    const-string v7, "obtain task pin settings failed"
    invoke-virtual v6, v5, v7, v4, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    invoke-static v1, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +003h
    move-object v1, v0
    check-cast v1, Ljava/lang/String;
    move-object v4, v1
    check-cast v4, Ljava/lang/CharSequence;
    if-eqz v4, +00bh
    invoke-static v4, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v4
    if-eqz v4, +003h
    goto +3h
    move v4, v2
    goto +2h
    move v4, v3
    if-nez v4, +003h
    goto +2h
    move-object v1, v0
    move-object v4, v1
    check-cast v4, Ljava/lang/CharSequence;
    if-eqz v4, +00bh
    invoke-static v4, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v4
    if-eqz v4, +003h
    goto +3h
    move v4, v2
    goto +2h
    move v4, v3
    if-eqz v4, +00ah
    sget-object v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    const-string v2, "minSupportedIdeVersion: settings config is null"
    invoke-virtual v1, v5, v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-object v0
    invoke-virtual v8, v1, Lcom/bytedance/trae/conversation/network/TaskPinCapability;->parseSettingsMinSupportedIdeVersion$conversation_mainlandRelease(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    move-object v6, v4
    check-cast v6, Ljava/lang/CharSequence;
    if-eqz v6, +008h
    invoke-static v6, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v6
    if-eqz v6, +003h
    move v2, v3
    if-eqz v2, +017h
    sget-object v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "minSupportedIdeVersion: version missing, rawConfig="
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v2, v5, v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-object v0
    return-object v4
    :try_start_0x1b
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
    check-cast v0, Lcom/bytedance/trae/conversation/network/TaskPinCapability;
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
    const-string v5, "TaskPinCapability"
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
