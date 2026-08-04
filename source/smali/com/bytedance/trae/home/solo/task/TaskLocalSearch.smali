# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/task/TaskLocalSearch;
.super Ljava/lang/Object;
.source "TaskLocalSearch.kt"

.field public static final $stable:I
.field public static final INSTANCE:Lcom/bytedance/trae/home/solo/task/TaskLocalSearch;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskLocalSearch;
    invoke-direct v0, Lcom/bytedance/trae/home/solo/task/TaskLocalSearch;-><init>()V
    sput-object v0, Lcom/bytedance/trae/home/solo/task/TaskLocalSearch;->INSTANCE Lcom/bytedance/trae/home/solo/task/TaskLocalSearch;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final containsNormalized(java.lang.String  java.lang.String)boolean
    .registers 6
    # ins_size=3
    sget-object v0, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    const-string v1, "ROOT"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v4, v0, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v4
    const-string/jumbo v0, toLowerCase(...)
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v4, Ljava/lang/CharSequence;
    check-cast v5, Ljava/lang/CharSequence;
    const/4 v0, 2
    const/4 v1, 0
    const/4 v2, 0
    invoke-static v4, v5, v2, v0, v1, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z I Ljava/lang/Object;)Z
    move-result v4
    return v4
.end method

.method public final search(java.util.List  java.lang.String  kotlin.jvm.functions.Function1)java.util.List
    .registers 34
    # ins_size=4
    move-object/from16 v0, v31
    move-object/from16 v1, v32
    move-object/from16 v2, v33
    const-string/jumbo v3, tasks
    invoke-static v0, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v3, "query"
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v3, userQueriesForTask
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v1
    move-object v3, v1
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v3, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v3
    if-eqz v3, +007h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    return-object v0
    sget-object v3, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    const-string v4, "ROOT"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v1, v3, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v3
    const-string/jumbo v4, toLowerCase(...)
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Ljava/lang/Iterable;
    new-instance v4, Ljava/util/ArrayList;
    invoke-direct v4, Ljava/util/ArrayList;-><init>()V
    move-object v15, v4
    check-cast v15, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +0bbh
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    move-object v14, v4
    check-cast v14, Lcom/bytedance/trae/home/solo/task/TaskModel;
    sget-object v4, Lcom/bytedance/trae/home/solo/task/TaskLocalSearch;->INSTANCE Lcom/bytedance/trae/home/solo/task/TaskLocalSearch;
    invoke-virtual v14, Lcom/bytedance/trae/home/solo/task/TaskModel;->getTitle()Ljava/lang/String;
    move-result-object v5
    invoke-direct v4, v5, v3, Lcom/bytedance/trae/home/solo/task/TaskLocalSearch;->containsNormalized(Ljava/lang/String; Ljava/lang/String;)Z
    move-result v4
    if-eqz v4, +038h
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/16 v16, 0
    move-object/from16 v31, v14
    move/from16 v14, v16
    move-object/from16 v28, v15
    move/from16 v15, v16
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const-string v22, ""
    const/16 v24, 0
    const/16 v25, 0
    const v26, 3407871
    const/16 v27, 0
    move-object/from16 v29, v3
    move-object/from16 v3, v31
    move-object/from16 v23, v1
    invoke-static/range v3 ... v27, Lcom/bytedance/trae/home/solo/task/TaskModel;->copy$default(Lcom/bytedance/trae/home/solo/task/TaskModel; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/home/solo/task/TaskStatus; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Z Ljava/lang/String; Z Z Z Ljava/lang/String; Lcom/bytedance/trae/home/solo/task/TaskIconType; Ljava/lang/String; Ljava/lang/String; Ljava/util/List; Ljava/lang/String; I Ljava/lang/Object;)Lcom/bytedance/trae/home/solo/task/TaskModel;
    move-result-object v3
    goto +65h
    move-object/from16 v29, v3
    move-object v3, v14
    move-object/from16 v28, v15
    invoke-interface v2, v3, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Ljava/lang/Iterable;
    invoke-interface v4, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v4
    invoke-interface v4, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    const/4 v6, 0
    if-eqz v5, +017h
    invoke-interface v4, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    move-object v7, v5
    check-cast v7, Ljava/lang/String;
    sget-object v8, Lcom/bytedance/trae/home/solo/task/TaskLocalSearch;->INSTANCE Lcom/bytedance/trae/home/solo/task/TaskLocalSearch;
    move-object/from16 v15, v29
    invoke-direct v8, v7, v15, Lcom/bytedance/trae/home/solo/task/TaskLocalSearch;->containsNormalized(Ljava/lang/String; Ljava/lang/String;)Z
    move-result v7
    if-eqz v7, +003h
    goto +7h
    move-object/from16 v29, v15
    goto -1bh
    move-object/from16 v15, v29
    move-object v5, v6
    move-object/from16 v22, v5
    check-cast v22, Ljava/lang/String;
    if-eqz v22, +02fh
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/16 v16, 0
    move-object/from16 v29, v15
    move/from16 v15, v16
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const/16 v24, 0
    const/16 v25, 0
    const v26, 3407871
    const/16 v27, 0
    move-object/from16 v23, v1
    invoke-static/range v3 ... v27, Lcom/bytedance/trae/home/solo/task/TaskModel;->copy$default(Lcom/bytedance/trae/home/solo/task/TaskModel; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/home/solo/task/TaskStatus; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Z Ljava/lang/String; Z Z Z Ljava/lang/String; Lcom/bytedance/trae/home/solo/task/TaskIconType; Ljava/lang/String; Ljava/lang/String; Ljava/util/List; Ljava/lang/String; I Ljava/lang/Object;)Lcom/bytedance/trae/home/solo/task/TaskModel;
    move-result-object v3
    goto +4h
    move-object/from16 v29, v15
    move-object v3, v6
    move-object/from16 v4, v28
    if-eqz v3, +005h
    invoke-interface v4, v3, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    move-object v15, v4
    move-object/from16 v3, v29
    goto/16 -0bdh
    move-object v4, v15
    move-object v15, v4
    check-cast v15, Ljava/util/List;
    return-object v15
.end method

.method public final userQueryText(java.util.List)java.lang.String
    .registers 14
    # ins_size=2
    move-object v0, v13
    check-cast v0, Ljava/util/Collection;
    const/4 v1, 1
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    if-eqz v0, +003h
    goto +3h
    const/4 v0, 0
    goto +2h
    move v0, v1
    const/4 v2, 0
    if-eqz v0, +003h
    return-object v2
    check-cast v13, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v13, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v13
    invoke-interface v13, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +01ah
    invoke-interface v13, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    move-object v4, v3
    check-cast v4, Lcom/bytedance/trae/im/model/MessagePart;
    invoke-virtual v4, Lcom/bytedance/trae/im/model/MessagePart;->getType()Ljava/lang/String;
    move-result-object v4
    const-string/jumbo v5, text
    invoke-static v4, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, -018h
    invoke-interface v0, v3, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1dh
    check-cast v0, Ljava/util/List;
    check-cast v0, Ljava/lang/Iterable;
    new-instance v13, Ljava/util/ArrayList;
    invoke-direct v13, Ljava/util/ArrayList;-><init>()V
    check-cast v13, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +04bh
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/im/model/MessagePart;
    invoke-virtual v3, Lcom/bytedance/trae/im/model/MessagePart;->getData()Lcom/google/gson/JsonObject;
    move-result-object v4
    if-eqz v4, +01ah
    const-string v5, "content"
    invoke-virtual v4, v5, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v4
    if-eqz v4, +012h
    invoke-virtual v4, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v5
    if-eqz v5, +003h
    goto +2h
    move-object v4, v2
    if-eqz v4, +008h
    invoke-virtual v4, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v4
    if-nez v4, +021h
    invoke-virtual v3, Lcom/bytedance/trae/im/model/MessagePart;->getData()Lcom/google/gson/JsonObject;
    move-result-object v3
    if-eqz v3, +01ah
    const-string/jumbo v4, text_content
    invoke-virtual v3, v4, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v3
    if-eqz v3, +011h
    invoke-virtual v3, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v4
    if-eqz v4, +003h
    goto +2h
    move-object v3, v2
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v4
    goto +2h
    move-object v4, v2
    if-eqz v4, -049h
    invoke-interface v13, v4, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -4eh
    check-cast v13, Ljava/util/List;
    move-object v3, v13
    check-cast v3, Ljava/lang/Iterable;
    const-string v13, ""
    move-object v4, v13
    check-cast v4, Ljava/lang/CharSequence;
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/16 v10, 62
    const/4 v11, 0
    invoke-static/range v3 ... v11, Lkotlin/collections/CollectionsKt;->joinToString$default(Ljava/lang/Iterable; Ljava/lang/CharSequence; Ljava/lang/CharSequence; Ljava/lang/CharSequence; I Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v13
    move-object v0, v13
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    xor-int/2addr v0, v1
    if-eqz v0, +003h
    move-object v2, v13
    return-object v2
.end method
