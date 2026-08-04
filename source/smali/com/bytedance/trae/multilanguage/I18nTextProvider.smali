# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/multilanguage/I18nTextProvider;
.super Ljava/lang/Object;
.source "I18nTextProvider.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/multilanguage/I18nTextProvider;
.field private static final hotStrings:Ljava/util/concurrent/ConcurrentHashMap;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/multilanguage/I18nTextProvider;
    invoke-direct v0, Lcom/bytedance/trae/multilanguage/I18nTextProvider;-><init>()V
    sput-object v0, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->INSTANCE Lcom/bytedance/trae/multilanguage/I18nTextProvider;
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;
    invoke-direct v0, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V
    sput-object v0, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->hotStrings Ljava/util/concurrent/ConcurrentHashMap;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final currentLocale(android.content.res.Resources)java.util.Locale
    .registers 3
    # ins_size=2
    invoke-virtual v2, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;
    move-result-object v2
    invoke-virtual v2, Landroid/content/res/Configuration;->getLocales()Landroid/os/LocaleList;
    move-result-object v2
    const/4 v0, 0
    invoke-virtual v2, v0, Landroid/os/LocaleList;->get(I)Ljava/util/Locale;
    move-result-object v2
    if-nez v2, +006h
    invoke-static Ljava/util/Locale;->getDefault()Ljava/util/Locale;
    move-result-object v2
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    return-object v2
.end method

.method private final formatHotString(android.content.res.Resources  com.bytedance.trae.multilanguage.I18nLanguage  java.lang.String  int  java.lang.Object[])java.lang.String
    .registers 8
    # ins_size=6
    array-length v0, v7
    if-nez v0, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    if-eqz v0, +003h
    return-object v5
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v2
    check-cast v0, Lcom/bytedance/trae/multilanguage/I18nTextProvider;
    sget-object v0, Lkotlin/jvm/internal/StringCompanionObject;->INSTANCE Lkotlin/jvm/internal/StringCompanionObject;
    invoke-virtual v4, Lcom/bytedance/trae/multilanguage/I18nLanguage;->getLocale()Ljava/util/Locale;
    move-result-object v4
    array-length v0, v7
    invoke-static v7, v0, Ljava/util/Arrays;->copyOf([Ljava/lang/Object; I)[Ljava/lang/Object;
    move-result-object v0
    array-length v1, v0
    invoke-static v0, v1, Ljava/util/Arrays;->copyOf([Ljava/lang/Object; I)[Ljava/lang/Object;
    move-result-object v0
    invoke-static v4, v5, v0, Ljava/lang/String;->format(Ljava/util/Locale; Ljava/lang/String; [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v4
    const-string v5, "format(...)"
    invoke-static v4, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v4, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v4
    goto +ch
    move-exception v4
    sget-object v5, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v4, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v4
    invoke-static v4, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v4
    invoke-static v4, Lkotlin/Result;->exceptionOrNull-impl(Ljava/lang/Object;)Ljava/lang/Throwable;
    move-result-object v5
    if-nez v5, +003h
    goto +fh
    array-length v4, v7
    invoke-static v7, v4, Ljava/util/Arrays;->copyOf([Ljava/lang/Object; I)[Ljava/lang/Object;
    move-result-object v4
    invoke-virtual v3, v6, v4, Landroid/content/res/Resources;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v4
    const-string v3, "getString(...)"
    invoke-static v4, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v4, Ljava/lang/String;
    return-object v4
    :try_start_0x9
.end method

.method private final resourceEntryNameOrNull(android.content.res.Resources  int)java.lang.String
    .registers 4
    # ins_size=3
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-virtual v2, v3, Landroid/content/res/Resources;->getResourceEntryName(I)Ljava/lang/String;
    move-result-object v2
    invoke-static v2, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    goto +ch
    move-exception v2
    sget-object v3, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v2, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v2
    invoke-static v2, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    invoke-static v2, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +003h
    const/4 v2, 0
    check-cast v2, Ljava/lang/String;
    return-object v2
    :try_start_0x0
.end method

.method public final varargs getString(android.content.res.Resources  int  java.lang.Object[])java.lang.String
    .registers 13
    # ins_size=4
    const-string/jumbo v0, resources
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "args"
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v9, v10, v11, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->resourceEntryNameOrNull(Landroid/content/res/Resources; I)Ljava/lang/String;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/multilanguage/I18nLanguage;->Companion Lcom/bytedance/trae/multilanguage/I18nLanguage$Companion;
    invoke-direct v9, v10, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->currentLocale(Landroid/content/res/Resources;)Ljava/util/Locale;
    move-result-object v2
    invoke-virtual v1, v2, Lcom/bytedance/trae/multilanguage/I18nLanguage$Companion;->fromLocale(Ljava/util/Locale;)Lcom/bytedance/trae/multilanguage/I18nLanguage;
    move-result-object v5
    const/4 v1, 0
    if-eqz v0, +013h
    sget-object v2, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->hotStrings Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v2, v5, Ljava/util/concurrent/ConcurrentHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/util/concurrent/ConcurrentHashMap;
    if-eqz v2, +009h
    invoke-virtual v2, v0, Ljava/util/concurrent/ConcurrentHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Ljava/lang/String;
    move-object v6, v1
    move-object v0, v6
    check-cast v0, Ljava/lang/CharSequence;
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    const/4 v0, 0
    goto +2h
    const/4 v0, 1
    if-nez v0, +00bh
    move-object v3, v9
    move-object v4, v10
    move v7, v11
    move-object v8, v12
    invoke-direct/range v3 ... v8, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->formatHotString(Landroid/content/res/Resources; Lcom/bytedance/trae/multilanguage/I18nLanguage; Ljava/lang/String; I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v10
    return-object v10
    array-length v0, v12
    invoke-static v12, v0, Ljava/util/Arrays;->copyOf([Ljava/lang/Object; I)[Ljava/lang/Object;
    move-result-object v12
    invoke-virtual v10, v11, v12, Landroid/content/res/Resources;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v10
    const-string v11, "getString(...)"
    invoke-static v10, v11, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v10
.end method

.method public final getStringByName(android.content.res.Resources  java.lang.String)java.lang.String
    .registers 8
    # ins_size=3
    const-string/jumbo v0, resources
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "keyName"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 0
    sget-object v1, Lcom/bytedance/trae/multilanguage/I18nLanguage;->Companion Lcom/bytedance/trae/multilanguage/I18nLanguage$Companion;
    invoke-direct v5, v6, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->currentLocale(Landroid/content/res/Resources;)Ljava/util/Locale;
    move-result-object v2
    invoke-virtual v1, v2, Lcom/bytedance/trae/multilanguage/I18nLanguage$Companion;->fromLocale(Ljava/util/Locale;)Lcom/bytedance/trae/multilanguage/I18nLanguage;
    move-result-object v1
    sget-object v2, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->hotStrings Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v2, v1, Ljava/util/concurrent/ConcurrentHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/util/concurrent/ConcurrentHashMap;
    if-eqz v1, +009h
    invoke-virtual v1, v7, Ljava/util/concurrent/ConcurrentHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/String;
    goto +2h
    move-object v1, v0
    move-object v2, v1
    check-cast v2, Ljava/lang/CharSequence;
    const/4 v3, 0
    const/4 v4, 1
    if-eqz v2, +00bh
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v2
    if-nez v2, +003h
    goto +3h
    move v2, v3
    goto +2h
    move v2, v4
    if-nez v2, +003h
    return-object v1
    const-string/jumbo v1, string
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_default I
    invoke-virtual v6, v2, Landroid/content/res/Resources;->getResourcePackageName(I)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v6, v7, v1, v2, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)I
    move-result v1
    if-nez v1, +003h
    return-object v0
    invoke-virtual v6, v1, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;
    move-result-object v6
    const-string v1, "getString(...)"
    invoke-static v6, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v1, v6
    check-cast v1, Ljava/lang/CharSequence;
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-lez v1, +004h
    move v1, v4
    goto +2h
    move v1, v3
    if-eqz v1, +009h
    invoke-static v6, v7, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v7
    if-nez v7, +003h
    move v3, v4
    if-eqz v3, +003h
    move-object v0, v6
    return-object v0
    :try_start_0xc
.end method

.method public final getStringWithNamedArgs(android.content.res.Resources  int  java.util.Map)java.lang.String
    .registers 10
    # ins_size=4
    const-string/jumbo v0, resources
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "namedArgs"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 0
    new-array v0, v0, [Ljava/lang/Object;
    invoke-virtual v6, v7, v8, v0, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->getString(Landroid/content/res/Resources; I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v7
    invoke-interface v9, Ljava/util/Map;->isEmpty()Z
    move-result v8
    if-eqz v8, +003h
    return-object v7
    invoke-interface v9, Ljava/util/Map;->entrySet()Ljava/util/Set;
    move-result-object v8
    check-cast v8, Ljava/lang/Iterable;
    invoke-interface v8, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v8
    move-object v0, v7
    invoke-interface v8, Ljava/util/Iterator;->hasNext()Z
    move-result v7
    if-eqz v7, +03dh
    invoke-interface v8, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Ljava/util/Map$Entry;
    invoke-interface v7, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v9
    check-cast v9, Ljava/lang/String;
    invoke-interface v7, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v7
    new-instance v1, Ljava/lang/StringBuilder;
    const-string/jumbo v2, {
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    const/16 v1, 125
    invoke-virtual v9, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    if-eqz v7, +007h
    invoke-virtual v7, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v7
    goto +2h
    const/4 v7, 0
    if-nez v7, +004h
    const-string v7, ""
    move-object v2, v7
    const/4 v3, 0
    const/4 v4, 4
    const/4 v5, 0
    invoke-static/range v0 ... v5, Lkotlin/text/StringsKt;->replace$default(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v0
    goto -40h
    return-object v0
.end method

.method public final updateStrings(com.bytedance.trae.multilanguage.I18nLanguage  java.util.Map)void
    .registers 5
    # ins_size=3
    const-string v0, "language"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, strings
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v4, Ljava/util/Map;->isEmpty()Z
    move-result v0
    if-eqz v0, +003h
    return-void 
    sget-object v0, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->hotStrings Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v0, v3, Ljava/util/concurrent/ConcurrentHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/util/concurrent/ConcurrentHashMap;
    if-nez v1, +011h
    new-instance v1, Ljava/util/concurrent/ConcurrentHashMap;
    invoke-direct v1, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V
    invoke-virtual v0, v3, v1, Ljava/util/concurrent/ConcurrentHashMap;->putIfAbsent(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/util/concurrent/ConcurrentHashMap;
    if-nez v3, +003h
    goto +2h
    move-object v1, v3
    invoke-virtual v1, v4, Ljava/util/concurrent/ConcurrentHashMap;->putAll(Ljava/util/Map;)V
    return-void 
.end method
