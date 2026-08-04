# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptSettingsProvider;
.super Ljava/lang/Object;
.source "NewFeaturePromptSettings.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptSettingsProvider;
.field private static final TAG:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptSettingsProvider;
    invoke-direct v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptSettingsProvider;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptSettingsProvider;->INSTANCE Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptSettingsProvider;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static synthetic getConfig$default(com.bytedance.trae.conversation.devices.newfeature.NewFeaturePromptSettingsProvider  java.lang.String  int  java.lang.Object)com.bytedance.trae.conversation.devices.newfeature.NewFeaturePromptConfig
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +006h
    invoke-direct v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptSettingsProvider;->getRemotePromptConfig()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptSettingsProvider;->getConfig(Ljava/lang/String;)Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;
    move-result-object v0
    return-object v0
.end method

.method private final getRemotePromptConfig()java.lang.String
    .registers 7
    # ins_size=1
    const/4 v0, 0
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v1, v6
    check-cast v1, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptSettingsProvider;
    const-class v1, Lcom/bytedance/trae/conversation/devices/newfeature/IMobileIdeGuidePromptSettings;
    invoke-static v1, Lcom/bytedance/news/common/settings/SettingsManager;->obtain(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/devices/newfeature/IMobileIdeGuidePromptSettings;
    if-eqz v1, +014h
    invoke-interface v1, Lcom/bytedance/trae/conversation/devices/newfeature/IMobileIdeGuidePromptSettings;->getMobileIdeGuidePrompt()Ljava/lang/String;
    move-result-object v1
    if-eqz v1, +00eh
    move-object v2, v1
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    xor-int/lit8 v2, v2, 1
    if-eqz v2, +003h
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
    if-eqz v2, +01dh
    sget-object v3, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    sget-object v3, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    const-string v4, "NewFeaturePromptSettings"
    const-string v5, "obtain mobile ide guide prompt settings failed"
    invoke-virtual v3, v4, v5, v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v2, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    goto +bh
    move-exception v2
    sget-object v3, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v2, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v2
    invoke-static v2, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    invoke-static v1, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +003h
    goto +2h
    move-object v0, v1
    check-cast v0, Ljava/lang/String;
    return-object v0
    :try_start_0x1
    :try_start_0x39
.end method

.method private final optBoolean(com.google.gson.JsonObject  java.lang.String)java.lang.Boolean
    .registers 4
    # ins_size=3
    invoke-virtual v2, v3, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v2
    const/4 v3, 0
    if-eqz v2, +014h
    invoke-virtual v2, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v0
    if-eqz v0, +003h
    goto +2h
    move-object v2, v3
    if-eqz v2, +00ah
    invoke-virtual v2, Lcom/google/gson/JsonElement;->getAsBoolean()Z
    move-result v2
    invoke-static v2, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v3
    return-object v3
.end method

.method private final optInt(com.google.gson.JsonObject  java.lang.String)java.lang.Integer
    .registers 4
    # ins_size=3
    invoke-virtual v2, v3, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v2
    const/4 v3, 0
    if-eqz v2, +014h
    invoke-virtual v2, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v0
    if-eqz v0, +003h
    goto +2h
    move-object v2, v3
    if-eqz v2, +00ah
    invoke-virtual v2, Lcom/google/gson/JsonElement;->getAsInt()I
    move-result v2
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v3
    return-object v3
.end method

.method private final optLong(com.google.gson.JsonObject  java.lang.String)java.lang.Long
    .registers 4
    # ins_size=3
    invoke-virtual v2, v3, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v2
    const/4 v3, 0
    if-eqz v2, +014h
    invoke-virtual v2, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v0
    if-eqz v0, +003h
    goto +2h
    move-object v2, v3
    if-eqz v2, +00ah
    invoke-virtual v2, Lcom/google/gson/JsonElement;->getAsLong()J
    move-result-wide v2
    invoke-static v2, v3, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v3
    return-object v3
.end method

.method private final optPriority(com.google.gson.JsonObject  java.lang.String)java.util.List
    .registers 5
    # ins_size=3
    invoke-virtual v3, v4, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v3
    const/4 v4, 0
    if-eqz v3, +03ch
    invoke-virtual v3, Lcom/google/gson/JsonElement;->isJsonArray()Z
    move-result v0
    if-eqz v0, +003h
    goto +2h
    move-object v3, v4
    if-eqz v3, +032h
    invoke-virtual v3, Lcom/google/gson/JsonElement;->getAsJsonArray()Lcom/google/gson/JsonArray;
    move-result-object v3
    if-eqz v3, +02ch
    check-cast v3, Ljava/lang/Iterable;
    new-instance v4, Ljava/util/ArrayList;
    invoke-direct v4, Ljava/util/ArrayList;-><init>()V
    check-cast v4, Ljava/util/Collection;
    invoke-interface v3, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +017h
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/google/gson/JsonElement;
    sget-object v1, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptSettingsProvider;->INSTANCE Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptSettingsProvider;
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptSettingsProvider;->toProductTypeOrNull(Lcom/google/gson/JsonElement;)Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-result-object v0
    if-eqz v0, -015h
    invoke-interface v4, v0, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1ah
    check-cast v4, Ljava/util/List;
    if-nez v4, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v4
    check-cast v4, Ljava/util/Collection;
    invoke-interface v4, Ljava/util/Collection;->isEmpty()Z
    move-result v3
    if-eqz v3, +008h
    sget-object v3, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;->Companion Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig$Companion;->getDEFAULT_PRIORITY()Ljava/util/List;
    move-result-object v4
    check-cast v4, Ljava/util/List;
    return-object v4
.end method

.method private final toProductTypeOrNull(com.google.gson.JsonElement)com.bytedance.trae.conversation.devices.DeviceProductType
    .registers 10
    # ins_size=2
    invoke-virtual v9, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v0
    const/4 v1, 0
    if-eqz v0, +003h
    goto +2h
    move-object v9, v1
    if-eqz v9, +032h
    invoke-virtual v9, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v9
    if-nez v9, +003h
    goto +2ah
    invoke-static Lcom/bytedance/trae/conversation/devices/DeviceProductType;->values()[Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-result-object v0
    array-length v2, v0
    const/4 v3, 0
    move v4, v3
    if-ge v4, v2, +022h
    aget-object v5, v0, v4
    invoke-virtual v5, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->name()Ljava/lang/String;
    move-result-object v6
    const/4 v7, 1
    invoke-static v6, v9, v7, Lkotlin/text/StringsKt;->equals(Ljava/lang/String; Ljava/lang/String; Z)Z
    move-result v6
    if-nez v6, +00eh
    invoke-virtual v5, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->getCliTypeValue()Ljava/lang/String;
    move-result-object v6
    invoke-static v6, v9, v7, Lkotlin/text/StringsKt;->equals(Ljava/lang/String; Ljava/lang/String; Z)Z
    move-result v6
    if-eqz v6, +003h
    goto +2h
    move v7, v3
    if-eqz v7, +004h
    move-object v1, v5
    goto +4h
    add-int/lit8 v4, v4, 1
    goto -21h
    return-object v1
.end method

.method public final getConfig()com.bytedance.trae.conversation.devices.newfeature.NewFeaturePromptConfig
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 1
    invoke-static v2, v0, v1, v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptSettingsProvider;->getConfig$default(Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptSettingsProvider; Ljava/lang/String; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;
    move-result-object v0
    return-object v0
.end method

.method public final getConfig(java.lang.String)com.bytedance.trae.conversation.devices.newfeature.NewFeaturePromptConfig
    .registers 12
    # ins_size=2
    const-string v0, "parse mobile ide guide prompt config failed, rawConfig="
    move-object v1, v11
    check-cast v1, Ljava/lang/CharSequence;
    if-eqz v1, +00bh
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    if-eqz v1, +003h
    goto +3h
    const/4 v1, 0
    goto +2h
    const/4 v1, 1
    if-nez v1, +061h
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v1, v10
    check-cast v1, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptSettingsProvider;
    invoke-virtual v10, v11, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptSettingsProvider;->parseConfig$conversation_mainlandRelease(Ljava/lang/String;)Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;
    move-result-object v1
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
    if-eqz v2, +028h
    sget-object v3, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    sget-object v3, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    const-string v4, "NewFeaturePromptSettings"
    new-instance v5, Ljava/lang/StringBuilder;
    invoke-direct v5, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v5, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-virtual v11, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v11
    invoke-virtual v3, v4, v11, v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    sget-object v11, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v11, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    goto +bh
    move-exception v11
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v11, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v11
    invoke-static v11, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    invoke-static v1, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v11
    if-eqz v11, +003h
    const/4 v1, 0
    check-cast v1, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;
    if-nez v1, +010h
    new-instance v1, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const-wide/16 v6, 0
    const/16 v8, 15
    const/4 v9, 0
    move-object v2, v1
    invoke-direct/range v2 ... v9, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;-><init>(Z I Ljava/util/List; J I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v1
    new-instance v11, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const-wide/16 v6, 0
    const/16 v8, 15
    const/4 v9, 0
    move-object v2, v11
    invoke-direct/range v2 ... v9, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;-><init>(Z I Ljava/util/List; J I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v11
    :try_start_0x13
    :try_start_0x32
.end method

.method public final parseConfig$conversation_mainlandRelease(java.lang.String)com.bytedance.trae.conversation.devices.newfeature.NewFeaturePromptConfig
    .registers 9
    # ins_size=2
    const-string v0, "rawConfig"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v8, Lcom/google/gson/JsonParser;->parseString(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v8
    invoke-virtual v8, Lcom/google/gson/JsonElement;->getAsJsonObject()Lcom/google/gson/JsonObject;
    move-result-object v8
    new-instance v6, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;
    invoke-static v8, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    const-string v0, "enable"
    invoke-direct v7, v8, v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptSettingsProvider;->optBoolean(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/lang/Boolean;
    move-result-object v0
    if-eqz v0, +007h
    invoke-virtual v0, Ljava/lang/Boolean;->booleanValue()Z
    move-result v0
    goto +2h
    const/4 v0, 0
    move v1, v0
    const-string v0, "campaign_version"
    invoke-direct v7, v8, v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptSettingsProvider;->optInt(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/lang/Integer;
    move-result-object v0
    const/4 v2, 1
    if-eqz v0, +007h
    invoke-virtual v0, Ljava/lang/Integer;->intValue()I
    move-result v0
    goto +ch
    const-string/jumbo v0, version
    invoke-direct v7, v8, v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptSettingsProvider;->optInt(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/lang/Integer;
    move-result-object v0
    if-eqz v0, +003h
    goto -eh
    move v0, v2
    invoke-static v0, v2, Lkotlin/ranges/RangesKt;->coerceAtLeast(I I)I
    move-result v2
    const-string v0, "priority"
    invoke-direct v7, v8, v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptSettingsProvider;->optPriority(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/util/List;
    move-result-object v3
    const-string v0, "minIntervalMillis"
    invoke-direct v7, v8, v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptSettingsProvider;->optLong(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/lang/Long;
    move-result-object v0
    if-eqz v0, +007h
    invoke-virtual v0, Ljava/lang/Long;->longValue()J
    move-result-wide v4
    goto +11h
    const-string v0, "minInterval"
    invoke-direct v7, v8, v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptSettingsProvider;->optLong(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/lang/Long;
    move-result-object v8
    if-eqz v8, +007h
    invoke-virtual v8, Ljava/lang/Long;->longValue()J
    move-result-wide v4
    goto +4h
    const-wide/32 v4, 86400000
    move-object v0, v6
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;-><init>(Z I Ljava/util/List; J)V
    return-object v6
.end method
