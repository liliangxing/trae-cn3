# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/products/HtmlShareSettings;
.super Ljava/lang/Object;
.source "IHtmlShareSettings.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/products/HtmlShareSettings;
.field private static final TAG:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/products/HtmlShareSettings;
    invoke-direct v0, Lcom/bytedance/trae/conversation/products/HtmlShareSettings;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/products/HtmlShareSettings;->INSTANCE Lcom/bytedance/trae/conversation/products/HtmlShareSettings;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final getHtmlShareSettingsItem()com.bytedance.trae.conversation.products.HtmlShareSettingsItem
    .registers 11
    # ins_size=1
    const/4 v0, 0
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v1, v10
    check-cast v1, Lcom/bytedance/trae/conversation/products/HtmlShareSettings;
    const-class v1, Lcom/bytedance/trae/conversation/products/IHtmlShareSettings;
    invoke-static v1, Lcom/bytedance/news/common/settings/SettingsManager;->obtain(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/products/IHtmlShareSettings;
    if-eqz v1, +007h
    invoke-interface v1, Lcom/bytedance/trae/conversation/products/IHtmlShareSettings;->getHtmlShareMinIdeVersion()Ljava/lang/String;
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
    const-string v3, "HtmlShareSettings"
    if-eqz v2, +009h
    sget-object v4, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    const-string v5, "obtain html share settings failed"
    invoke-virtual v4, v3, v5, v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    invoke-static v1, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +003h
    move-object v1, v0
    check-cast v1, Ljava/lang/String;
    move-object v2, v1
    check-cast v2, Ljava/lang/CharSequence;
    const/4 v4, 1
    const/4 v5, 0
    if-eqz v2, +00bh
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    if-eqz v2, +003h
    goto +3h
    move v2, v5
    goto +2h
    move v2, v4
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
    move v2, v5
    goto +2h
    move v2, v4
    if-eqz v2, +00fh
    sget-object v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    const-string v2, "getHtmlShareSettingsItem: settings config is null"
    invoke-virtual v1, v3, v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->w(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v1, Lcom/bytedance/trae/conversation/products/HtmlShareSettingsItem;
    invoke-direct v1, v0, v5, Lcom/bytedance/trae/conversation/products/HtmlShareSettingsItem;-><init>(Ljava/lang/String; Z)V
    return-object v1
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v2, v10
    check-cast v2, Lcom/bytedance/trae/conversation/products/HtmlShareSettings;
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
    const-string v9, "getHtmlShareSettingsItem: parse settings config failed, rawConfig="
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
    if-nez v2, +008h
    new-instance v1, Lcom/bytedance/trae/conversation/products/HtmlShareSettingsItem;
    invoke-direct v1, v0, v5, Lcom/bytedance/trae/conversation/products/HtmlShareSettingsItem;-><init>(Ljava/lang/String; Z)V
    return-object v1
    const-string v6, "cli_min_version"
    invoke-virtual v2, v6, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v6
    if-eqz v6, +011h
    invoke-virtual v6, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v7
    if-eqz v7, +003h
    goto +2h
    move-object v6, v0
    if-eqz v6, +007h
    invoke-virtual v6, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v6
    goto +2h
    move-object v6, v0
    const-string v7, "bytedance_enable"
    invoke-virtual v2, v7, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v2
    if-eqz v2, +010h
    invoke-virtual v2, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v7
    if-eqz v7, +003h
    move-object v0, v2
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/google/gson/JsonElement;->getAsBoolean()Z
    move-result v0
    goto +2h
    move v0, v5
    move-object v2, v6
    check-cast v2, Ljava/lang/CharSequence;
    if-eqz v2, +00ah
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    if-eqz v2, +003h
    goto +2h
    move v4, v5
    if-eqz v4, +026h
    sget-object v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v5, "getHtmlShareSettingsItem: version missing, isOversea="
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
    new-instance v1, Lcom/bytedance/trae/conversation/products/HtmlShareSettingsItem;
    invoke-direct v1, v6, v0, Lcom/bytedance/trae/conversation/products/HtmlShareSettingsItem;-><init>(Ljava/lang/String; Z)V
    return-object v1
    :try_start_0x1
    :try_start_0x71
.end method
