# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository;
.super Ljava/lang/Object;
.source "BrainstormSummaryRepository.kt"

.field public static final AGENT_TYPE_SELECT_MODEL_NAME:Ljava/lang/String;
.field public static final AGENT_TYPE_VOICE_SUMMARY:Ljava/lang/String;
.field public static final Companion:Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository$Companion;
.field private static final TAG:Ljava/lang/String;
.field private final gson:Lcom/google/gson/Gson;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository;->Companion Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    new-instance v0, Lcom/google/gson/Gson;
    invoke-direct v0, Lcom/google/gson/Gson;-><init>()V
    iput-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository;->gson Lcom/google/gson/Gson;
    return-void 
.end method

.method public static final synthetic access$extractTextFromEvent(com.bytedance.trae.conversation.brainstorm.BrainstormSummaryRepository  java.lang.String  java.lang.String)java.lang.String
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository;->extractTextFromEvent(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$subscribeSseAndCollect(com.bytedance.trae.conversation.brainstorm.BrainstormSummaryRepository  java.lang.String  java.lang.String  kotlin.jvm.functions.Function1  kotlin.coroutines.Continuation)java.lang.Object
    .registers 5
    # ins_size=5
    invoke-direct v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository;->subscribeSseAndCollect(Ljava/lang/String; Ljava/lang/String; Lkotlin/jvm/functions/Function1; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method private final buildSummary(java.lang.String  java.util.List  long)com.bytedance.trae.conversation.brainstorm.model.BrainstormSummary
    .registers 21
    # ins_size=5
    move-object/from16 v0, v17
    const v1, 60000
    int-to-long v1, v1
    div-long v3, v19, v1
    long-to-int v3, v3
    rem-long v1, v19, v1
    const/16 v4, 1000
    int-to-long v4, v4
    div-long/2addr v1, v4
    long-to-int v1, v1
    const/16 v2, 115
    if-lez v3, +012h
    new-instance v4, Ljava/lang/StringBuilder;
    invoke-direct v4, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v4, v3, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, "m "
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    goto +6h
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v3, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    move-object v6, v1
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->lines(Ljava/lang/CharSequence;)Ljava/util/List;
    move-result-object v1
    check-cast v1, Ljava/lang/Iterable;
    new-instance v2, Ljava/util/ArrayList;
    const/16 v3, 10
    invoke-static v1, v3, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v3
    invoke-direct v2, v3, Ljava/util/ArrayList;-><init>(I)V
    check-cast v2, Ljava/util/Collection;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +016h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/lang/String;
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v3, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-interface v2, v3, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -19h
    check-cast v2, Ljava/util/List;
    check-cast v2, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v2, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    const/4 v5, 0
    if-eqz v3, +01ah
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    move-object v7, v3
    check-cast v7, Ljava/lang/String;
    check-cast v7, Ljava/lang/CharSequence;
    invoke-interface v7, Ljava/lang/CharSequence;->length()I
    move-result v7
    if-lez v7, +004h
    const/4 v4, 1
    goto +2h
    move v4, v5
    if-eqz v4, -019h
    invoke-interface v1, v3, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1eh
    check-cast v1, Ljava/util/List;
    new-instance v2, Ljava/util/ArrayList;
    invoke-direct v2, Ljava/util/ArrayList;-><init>()V
    move-object v7, v2
    check-cast v7, Ljava/util/List;
    new-instance v2, Ljava/util/ArrayList;
    invoke-direct v2, Ljava/util/ArrayList;-><init>()V
    move-object v8, v2
    check-cast v8, Ljava/util/List;
    invoke-interface v1, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v1
    const-string v2, "Brainstorm Summary"
    const-string v3, "key"
    move-object v9, v2
    move-object v10, v3
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v11
    if-eqz v11, +0efh
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v11
    check-cast v11, Ljava/lang/String;
    sget-object v12, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v11, v12, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v12
    const-string/jumbo v13, toLowerCase(...)
    invoke-static v12, v13, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v13, v12
    check-cast v13, Ljava/lang/CharSequence;
    const-string v14, "action"
    move-object v15, v14
    check-cast v15, Ljava/lang/CharSequence;
    const/4 v4, 2
    move-object/from16 v20, v1
    const/4 v1, 0
    invoke-static v13, v15, v5, v4, v1, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z I Ljava/lang/Object;)Z
    move-result v15
    if-eqz v15, +010h
    const-string v15, "item"
    check-cast v15, Ljava/lang/CharSequence;
    invoke-static v13, v15, v5, v4, v1, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z I Ljava/lang/Object;)Z
    move-result v15
    if-eqz v15, +006h
    move-object/from16 v1, v20
    move-object v10, v14
    goto -37h
    move-object v15, v3
    check-cast v15, Ljava/lang/CharSequence;
    invoke-static v13, v15, v5, v4, v1, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z I Ljava/lang/Object;)Z
    move-result v15
    if-eqz v15, +023h
    const-string v15, "point"
    check-cast v15, Ljava/lang/CharSequence;
    invoke-static v13, v15, v5, v4, v1, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z I Ljava/lang/Object;)Z
    move-result v15
    if-nez v15, +016h
    const-string v15, "insight"
    check-cast v15, Ljava/lang/CharSequence;
    invoke-static v13, v15, v5, v4, v1, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z I Ljava/lang/Object;)Z
    move-result v15
    if-nez v15, +00ch
    const-string v15, "finding"
    check-cast v15, Ljava/lang/CharSequence;
    invoke-static v13, v15, v5, v4, v1, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z I Ljava/lang/Object;)Z
    move-result v13
    if-eqz v13, +005h
    move-object/from16 v1, v20
    goto -62h
    const-string v13, "# "
    invoke-static v12, v13, v5, v4, v1, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v13
    if-nez v13, +05dh
    const-string v13, "## "
    invoke-static v12, v13, v5, v4, v1, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +003h
    goto +53h
    const-string v1, "-"
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v11, v1, Lkotlin/text/StringsKt;->removePrefix(Ljava/lang/String; Ljava/lang/CharSequence;)Ljava/lang/String;
    move-result-object v1
    const-string v4, "*"
    check-cast v4, Ljava/lang/CharSequence;
    invoke-static v1, v4, Lkotlin/text/StringsKt;->removePrefix(Ljava/lang/String; Ljava/lang/CharSequence;)Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    new-instance v4, Lkotlin/text/Regex;
    const-string v11, "^\d+[.):]\s*"
    invoke-direct v4, v11, Lkotlin/text/Regex;-><init>(Ljava/lang/String;)V
    const-string v11, ""
    invoke-virtual v4, v1, v11, Lkotlin/text/Regex;->replace(Ljava/lang/CharSequence; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    new-instance v4, Lkotlin/text/Regex;
    const-string v12, "^☐\s*"
    invoke-direct v4, v12, Lkotlin/text/Regex;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v1, v11, Lkotlin/text/Regex;->replace(Ljava/lang/CharSequence; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v1
    move-object v4, v1
    check-cast v4, Ljava/lang/CharSequence;
    invoke-interface v4, Ljava/lang/CharSequence;->length()I
    move-result v4
    if-nez v4, +004h
    const/4 v4, 1
    goto +2h
    move v4, v5
    if-nez v4, +03ah
    invoke-static v10, v14, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +006h
    invoke-interface v8, v1, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto +2fh
    invoke-interface v7, v1, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto +2bh
    const/4 v1, 1
    new-array v4, v1, [C
    const/16 v12, 35
    aput-char v12, v4, v5
    invoke-static v11, v4, Lkotlin/text/StringsKt;->trimStart(Ljava/lang/String; [C)Ljava/lang/String;
    move-result-object v4
    check-cast v4, Ljava/lang/CharSequence;
    invoke-static v4, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-static v9, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v11
    if-eqz v11, +011h
    move-object v11, v4
    check-cast v11, Ljava/lang/CharSequence;
    invoke-interface v11, Ljava/lang/CharSequence;->length()I
    move-result v11
    if-lez v11, +004h
    move v11, v1
    goto +2h
    move v11, v5
    if-eqz v11, +003h
    move-object v9, v4
    move-object/from16 v1, v20
    goto/16 -0f1h
    invoke-interface v7, Ljava/util/List;->isEmpty()Z
    move-result v1
    if-eqz v1, +00bh
    const/16 v1, 500
    invoke-static v0, v1, Lkotlin/text/StringsKt;->take(Ljava/lang/String; I)Ljava/lang/String;
    move-result-object v0
    invoke-interface v7, v0, Ljava/util/List;->add(Ljava/lang/Object;)Z
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary;
    invoke-interface/range v18, Ljava/util/List;->size()I
    move-result v1
    move-object v2, v0
    move-object v3, v9
    move-object v4, v7
    move-object v5, v8
    move v7, v1
    invoke-direct/range v2 ... v7, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary;-><init>(Ljava/lang/String; Ljava/util/List; Ljava/util/List; Ljava/lang/String; I)V
    return-object v0
.end method

.method private final extractTextFromEvent(java.lang.String  java.lang.String)java.lang.String
    .registers 7
    # ins_size=3
    const-string v0, "done"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    const/4 v1, 0
    if-nez v0, +07ah
    const-string v0, "error"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, +004h
    goto/16 +070h
    iget-object v5, v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository;->gson Lcom/google/gson/Gson;
    const-class v0, Lcom/google/gson/JsonObject;
    invoke-virtual v5, v6, v0, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/google/gson/JsonObject;
    const-string v0, "content"
    if-eqz v5, +011h
    invoke-virtual v5, v0, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v2
    if-eqz v2, +00bh
    invoke-virtual v2, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    goto +3h
    move-object v6, v2
    goto +51h
    const-string/jumbo v2, text
    if-eqz v5, +00dh
    invoke-virtual v5, v2, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v3
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v3
    goto +2h
    move-object v3, v1
    if-nez v3, +03eh
    if-eqz v5, +037h
    const-string v3, "delta"
    invoke-virtual v5, v3, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v5
    if-eqz v5, +02fh
    invoke-virtual v5, Lcom/google/gson/JsonElement;->isJsonObject()Z
    move-result v3
    if-eqz v3, +024h
    invoke-virtual v5, Lcom/google/gson/JsonElement;->getAsJsonObject()Lcom/google/gson/JsonObject;
    move-result-object v3
    invoke-virtual v3, v0, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v0
    if-eqz v0, +00bh
    invoke-virtual v0, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +003h
    goto +3h
    move-object v1, v0
    goto +15h
    invoke-virtual v5, Lcom/google/gson/JsonElement;->getAsJsonObject()Lcom/google/gson/JsonObject;
    move-result-object v5
    invoke-virtual v5, v2, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v5
    if-eqz v5, +00ch
    invoke-virtual v5, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v5
    goto +5h
    invoke-virtual v5, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v5
    move-object v1, v5
    if-nez v1, +003h
    goto +4h
    move-object v6, v1
    goto +2h
    move-object v6, v3
    return-object v6
    return-object v1
    :try_start_0x13
    :try_start_0x21
    :try_start_0x35
.end method

.method private final subscribeSseAndCollect(java.lang.String  java.lang.String  kotlin.jvm.functions.Function1  kotlin.coroutines.Continuation)java.lang.Object
    .registers 13
    # ins_size=5
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v0
    check-cast v0, Lkotlin/coroutines/CoroutineContext;
    new-instance v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository$subscribeSseAndCollect$2;
    const/4 v6, 0
    move-object v1, v7
    move-object v2, v9
    move-object v3, v10
    move-object v4, v8
    move-object v5, v11
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository$subscribeSseAndCollect$2;-><init>(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository; Lkotlin/jvm/functions/Function1; Lkotlin/coroutines/Continuation;)V
    check-cast v7, Lkotlin/jvm/functions/Function2;
    invoke-static v0, v7, v12, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v9
    return-object v9
.end method
