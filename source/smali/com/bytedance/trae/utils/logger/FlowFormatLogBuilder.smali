# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/utils/logger/FlowFormatLogBuilder;
.super Ljava/lang/Object;
.source "FormatLogBuilder.kt"

.field private final level:Lcom/bytedance/trae/utils/logger/LogLevel;
.field private final logger:Lcom/bytedance/trae/utils/logger/Logger;
.field private parameter:Lcom/bytedance/trae/utils/logger/LogParameter;


.method public static synthetic $r8$lambda$hLnIg_sywoe8puG9U8h4_urcfC0(com.bytedance.trae.utils.logger.FlowFormatLogBuilder  java.lang.String)java.lang.CharSequence
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/utils/logger/FlowFormatLogBuilder;->formatStructuredLog$lambda$8$lambda$7(Lcom/bytedance/trae/utils/logger/FlowFormatLogBuilder; Ljava/lang/String;)Ljava/lang/CharSequence;
    move-result-object v0
    return-object v0
.end method

.method public constructor <init>(com.bytedance.trae.utils.logger.Logger  com.bytedance.trae.utils.logger.LogLevel  java.lang.String)void
    .registers 15
    # ins_size=4
    const-string v0, "logger"
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "level"
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, what
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v11, Ljava/lang/Object;-><init>()V
    iput-object v12, v11, Lcom/bytedance/trae/utils/logger/FlowFormatLogBuilder;->logger Lcom/bytedance/trae/utils/logger/Logger;
    iput-object v13, v11, Lcom/bytedance/trae/utils/logger/FlowFormatLogBuilder;->level Lcom/bytedance/trae/utils/logger/LogLevel;
    new-instance v12, Lcom/bytedance/trae/utils/logger/LogParameter;
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/16 v9, 126
    const/4 v10, 0
    move-object v1, v12
    move-object v2, v14
    invoke-direct/range v1 ... v10, Lcom/bytedance/trae/utils/logger/LogParameter;-><init>(Ljava/lang/String; Ljava/util/List; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/util/Map; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput-object v12, v11, Lcom/bytedance/trae/utils/logger/FlowFormatLogBuilder;->parameter Lcom/bytedance/trae/utils/logger/LogParameter;
    return-void 
.end method

.method private final formatParams(java.util.Map)java.lang.String
    .registers 13
    # ins_size=2
    new-instance v0, Ljava/util/ArrayList;
    invoke-interface v12, Ljava/util/Map;->size()I
    move-result v1
    invoke-direct v0, v1, Ljava/util/ArrayList;-><init>(I)V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v12, Ljava/util/Map;->entrySet()Ljava/util/Set;
    move-result-object v12
    invoke-interface v12, Ljava/util/Set;->iterator()Ljava/util/Iterator;
    move-result-object v12
    invoke-interface v12, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +089h
    invoke-interface v12, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/util/Map$Entry;
    invoke-interface v1, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/utils/logger/LogKey;
    invoke-interface v1, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v1
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, """
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/utils/logger/LogKey;->getRawValue()Ljava/lang/String;
    move-result-object v2
    invoke-direct v11, v2, Lcom/bytedance/trae/utils/logger/FlowFormatLogBuilder;->sanitize(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v3, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const/16 v3, 34
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    instance-of v5, v1, Ljava/lang/String;
    if-eqz v5, +01ah
    new-instance v5, Ljava/lang/StringBuilder;
    invoke-direct v5, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    check-cast v1, Ljava/lang/String;
    invoke-direct v11, v1, Lcom/bytedance/trae/utils/logger/FlowFormatLogBuilder;->sanitize(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    invoke-virtual v5, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    goto +23h
    instance-of v5, v1, Ljava/lang/Number;
    if-eqz v5, +007h
    invoke-virtual v1, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v1
    goto +1ah
    new-instance v5, Ljava/lang/StringBuilder;
    invoke-direct v5, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-direct v11, v1, Lcom/bytedance/trae/utils/logger/FlowFormatLogBuilder;->sanitize(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    invoke-virtual v5, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v3, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const/16 v3, 58
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-interface v0, v1, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto/16 -08bh
    check-cast v0, Ljava/util/List;
    new-instance v12, Ljava/lang/StringBuilder;
    const-string/jumbo v1, {
    invoke-direct v12, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    move-object v2, v0
    check-cast v2, Ljava/lang/Iterable;
    const-string v0, ","
    move-object v3, v0
    check-cast v3, Ljava/lang/CharSequence;
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/16 v9, 62
    const/4 v10, 0
    invoke-static/range v2 ... v10, Lkotlin/collections/CollectionsKt;->joinToString$default(Ljava/lang/Iterable; Ljava/lang/CharSequence; Ljava/lang/CharSequence; Ljava/lang/CharSequence; I Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v0
    invoke-virtual v12, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v12
    const/16 v0, 125
    invoke-virtual v12, v0, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v12
    invoke-virtual v12, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v12
    return-object v12
.end method

.method private final formatStructuredLog(com.bytedance.trae.utils.logger.LogParameter)java.lang.String
    .registers 15
    # ins_size=2
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/List;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "<What="
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v14, Lcom/bytedance/trae/utils/logger/LogParameter;->getWhat()Ljava/lang/String;
    move-result-object v2
    invoke-direct v13, v2, Lcom/bytedance/trae/utils/logger/FlowFormatLogBuilder;->sanitize(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const/16 v2, 62
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-interface v0, v1, Ljava/util/List;->add(Ljava/lang/Object;)Z
    invoke-virtual v14, Lcom/bytedance/trae/utils/logger/LogParameter;->getParams()Ljava/util/Map;
    move-result-object v1
    const/4 v3, 0
    if-eqz v1, +028h
    invoke-interface v1, Ljava/util/Map;->isEmpty()Z
    move-result v4
    xor-int/lit8 v4, v4, 1
    if-eqz v4, +003h
    goto +2h
    move-object v1, v3
    if-eqz v1, +01ch
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v5, "<Params="
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-direct v13, v1, Lcom/bytedance/trae/utils/logger/FlowFormatLogBuilder;->formatParams(Ljava/util/Map;)Ljava/lang/String;
    move-result-object v1
    invoke-virtual v4, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-interface v0, v1, Ljava/util/List;->add(Ljava/lang/Object;)Z
    invoke-virtual v14, Lcom/bytedance/trae/utils/logger/LogParameter;->getWho()Ljava/lang/String;
    move-result-object v1
    if-eqz v1, +01ch
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v5, "<Who="
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-direct v13, v1, Lcom/bytedance/trae/utils/logger/FlowFormatLogBuilder;->sanitize(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    invoke-virtual v4, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-interface v0, v1, Ljava/util/List;->add(Ljava/lang/Object;)Z
    invoke-virtual v14, Lcom/bytedance/trae/utils/logger/LogParameter;->getWhereInfo()Ljava/lang/String;
    move-result-object v1
    if-eqz v1, +01ch
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v5, "<Where="
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-direct v13, v1, Lcom/bytedance/trae/utils/logger/FlowFormatLogBuilder;->sanitize(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    invoke-virtual v4, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-interface v0, v1, Ljava/util/List;->add(Ljava/lang/Object;)Z
    invoke-virtual v14, Lcom/bytedance/trae/utils/logger/LogParameter;->getEventType()Ljava/lang/String;
    move-result-object v1
    if-eqz v1, +01ch
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v5, "<EventType="
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-direct v13, v1, Lcom/bytedance/trae/utils/logger/FlowFormatLogBuilder;->sanitize(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    invoke-virtual v4, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-interface v0, v1, Ljava/util/List;->add(Ljava/lang/Object;)Z
    invoke-virtual v14, Lcom/bytedance/trae/utils/logger/LogParameter;->getLinkID()Ljava/util/List;
    move-result-object v1
    if-eqz v1, +03eh
    move-object v4, v1
    check-cast v4, Ljava/util/Collection;
    invoke-interface v4, Ljava/util/Collection;->isEmpty()Z
    move-result v4
    xor-int/lit8 v4, v4, 1
    if-eqz v4, +003h
    move-object v3, v1
    if-eqz v3, +030h
    move-object v4, v3
    check-cast v4, Ljava/lang/Iterable;
    const-string v1, ","
    move-object v5, v1
    check-cast v5, Ljava/lang/CharSequence;
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    new-instance v10, Lcom/bytedance/trae/utils/logger/FlowFormatLogBuilder$$ExternalSyntheticLambda0;
    invoke-direct v10, v13, Lcom/bytedance/trae/utils/logger/FlowFormatLogBuilder$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/utils/logger/FlowFormatLogBuilder;)V
    const/16 v11, 30
    const/4 v12, 0
    invoke-static/range v4 ... v12, Lkotlin/collections/CollectionsKt;->joinToString$default(Ljava/lang/Iterable; Ljava/lang/CharSequence; Ljava/lang/CharSequence; Ljava/lang/CharSequence; I Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v1
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "<LinkID="
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-interface v0, v1, Ljava/util/List;->add(Ljava/lang/Object;)Z
    invoke-virtual v14, Lcom/bytedance/trae/utils/logger/LogParameter;->getSource()Ljava/lang/String;
    move-result-object v14
    if-eqz v14, +01ch
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v3, "<Source="
    invoke-direct v1, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-direct v13, v14, Lcom/bytedance/trae/utils/logger/FlowFormatLogBuilder;->sanitize(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v14
    invoke-virtual v1, v14, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v14
    invoke-virtual v14, v2, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v14
    invoke-virtual v14, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v14
    invoke-interface v0, v14, Ljava/util/List;->add(Ljava/lang/Object;)Z
    move-object v1, v0
    check-cast v1, Ljava/lang/Iterable;
    const-string v14, ""
    move-object v2, v14
    check-cast v2, Ljava/lang/CharSequence;
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/16 v8, 62
    const/4 v9, 0
    invoke-static/range v1 ... v9, Lkotlin/collections/CollectionsKt;->joinToString$default(Ljava/lang/Iterable; Ljava/lang/CharSequence; Ljava/lang/CharSequence; Ljava/lang/CharSequence; I Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v14
    return-object v14
.end method

.method private static final formatStructuredLog$lambda$8$lambda$7(com.bytedance.trae.utils.logger.FlowFormatLogBuilder  java.lang.String)java.lang.CharSequence
    .registers 4
    # ins_size=2
    const-string v0, "id"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Ljava/lang/StringBuilder;
    const-string/jumbo v1, {
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-direct v2, v3, Lcom/bytedance/trae/utils/logger/FlowFormatLogBuilder;->sanitize(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const/16 v3, 125
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    check-cast v2, Ljava/lang/CharSequence;
    return-object v2
.end method

.method public static synthetic log$default(com.bytedance.trae.utils.logger.FlowFormatLogBuilder  java.lang.String  java.lang.String  int  int  int  java.lang.Object)void
    .registers 8
    # ins_size=7
    and-int/lit8 v7, v6, 1
    const-string v0, ""
    if-eqz v7, +003h
    move-object v2, v0
    and-int/lit8 v7, v6, 2
    if-eqz v7, +003h
    move-object v3, v0
    and-int/lit8 v7, v6, 4
    if-eqz v7, +003h
    const/4 v4, -1
    and-int/lit8 v6, v6, 8
    if-eqz v6, +003h
    const/4 v5, 4
    invoke-virtual v1, v2, v3, v4, v5, Lcom/bytedance/trae/utils/logger/FlowFormatLogBuilder;->log(Ljava/lang/String; Ljava/lang/String; I I)V
    return-void 
.end method

.method private final sanitize(java.lang.String)java.lang.String
    .registers 14
    # ins_size=2
    const-string v1, "<"
    const-string v2, ""
    const/4 v3, 0
    const/4 v4, 4
    const/4 v5, 0
    move-object v0, v13
    invoke-static/range v0 ... v5, Lkotlin/text/StringsKt;->replace$default(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v6
    const-string v7, ">"
    const-string v8, ""
    const/4 v9, 0
    const/4 v10, 4
    const/4 v11, 0
    invoke-static/range v6 ... v11, Lkotlin/text/StringsKt;->replace$default(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v0
    const-string v1, """
    const-string v2, "\""
    invoke-static/range v0 ... v5, Lkotlin/text/StringsKt;->replace$default(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v13
    return-object v13
.end method

.method public final eventType(java.lang.String)com.bytedance.trae.utils.logger.FlowFormatLogBuilder
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/utils/logger/FlowFormatLogBuilder;->parameter Lcom/bytedance/trae/utils/logger/LogParameter;
    invoke-virtual v0, v2, Lcom/bytedance/trae/utils/logger/LogParameter;->setEventType(Ljava/lang/String;)V
    return-object v1
.end method

.method public final linkID(java.util.List)com.bytedance.trae.utils.logger.FlowFormatLogBuilder
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/utils/logger/FlowFormatLogBuilder;->parameter Lcom/bytedance/trae/utils/logger/LogParameter;
    invoke-virtual v0, v2, Lcom/bytedance/trae/utils/logger/LogParameter;->setLinkID(Ljava/util/List;)V
    return-object v1
.end method

.method public final log(java.lang.String  java.lang.String  int  int)void
    .registers 12
    # ins_size=5
    const-string v0, "file"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "function"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/Thread;->getStackTrace()[Ljava/lang/StackTraceElement;
    move-result-object v0
    array-length v1, v0
    add-int/lit8 v2, v11, 1
    if-lt v1, v2, +005h
    aget-object v11, v0, v11
    goto +2h
    const/4 v11, 0
    if-eqz v11, +00bh
    invoke-virtual v11, Ljava/lang/StackTraceElement;->getFileName()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +003h
    goto +3h
    move-object v4, v0
    goto +2h
    move-object v4, v8
    if-eqz v11, +00bh
    invoke-virtual v11, Ljava/lang/StackTraceElement;->getMethodName()Ljava/lang/String;
    move-result-object v8
    if-nez v8, +003h
    goto +3h
    move-object v5, v8
    goto +2h
    move-object v5, v9
    if-eqz v11, +006h
    invoke-virtual v11, Ljava/lang/StackTraceElement;->getLineNumber()I
    move-result v10
    move v6, v10
    iget-object v8, v7, Lcom/bytedance/trae/utils/logger/FlowFormatLogBuilder;->parameter Lcom/bytedance/trae/utils/logger/LogParameter;
    invoke-direct v7, v8, Lcom/bytedance/trae/utils/logger/FlowFormatLogBuilder;->formatStructuredLog(Lcom/bytedance/trae/utils/logger/LogParameter;)Ljava/lang/String;
    move-result-object v3
    iget-object v1, v7, Lcom/bytedance/trae/utils/logger/FlowFormatLogBuilder;->logger Lcom/bytedance/trae/utils/logger/Logger;
    iget-object v2, v7, Lcom/bytedance/trae/utils/logger/FlowFormatLogBuilder;->level Lcom/bytedance/trae/utils/logger/LogLevel;
    invoke-virtual/range v1 ... v6, Lcom/bytedance/trae/utils/logger/Logger;->log(Lcom/bytedance/trae/utils/logger/LogLevel; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I)V
    return-void 
.end method

.method public final params(java.util.Map)com.bytedance.trae.utils.logger.FlowFormatLogBuilder
    .registers 4
    # ins_size=2
    if-nez v3, +003h
    return-object v2
    iget-object v0, v2, Lcom/bytedance/trae/utils/logger/FlowFormatLogBuilder;->parameter Lcom/bytedance/trae/utils/logger/LogParameter;
    invoke-virtual v0, Lcom/bytedance/trae/utils/logger/LogParameter;->getParams()Ljava/util/Map;
    move-result-object v0
    if-nez v0, +00fh
    iget-object v0, v2, Lcom/bytedance/trae/utils/logger/FlowFormatLogBuilder;->parameter Lcom/bytedance/trae/utils/logger/LogParameter;
    new-instance v1, Ljava/util/HashMap;
    invoke-direct v1, v3, Ljava/util/HashMap;-><init>(Ljava/util/Map;)V
    check-cast v1, Ljava/util/Map;
    invoke-virtual v0, v1, Lcom/bytedance/trae/utils/logger/LogParameter;->setParams(Ljava/util/Map;)V
    goto +dh
    iget-object v0, v2, Lcom/bytedance/trae/utils/logger/FlowFormatLogBuilder;->parameter Lcom/bytedance/trae/utils/logger/LogParameter;
    invoke-virtual v0, Lcom/bytedance/trae/utils/logger/LogParameter;->getParams()Ljava/util/Map;
    move-result-object v0
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-interface v0, v3, Ljava/util/Map;->putAll(Ljava/util/Map;)V
    return-object v2
.end method

.method public final params(kotlin.jvm.functions.Function1)com.bytedance.trae.utils.logger.FlowFormatLogBuilder
    .registers 3
    # ins_size=2
    const-string v0, "block"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Ljava/util/LinkedHashMap;
    invoke-direct v0, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v0, Ljava/util/Map;
    invoke-interface v2, v0, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    invoke-virtual v1, v0, Lcom/bytedance/trae/utils/logger/FlowFormatLogBuilder;->params(Ljava/util/Map;)Lcom/bytedance/trae/utils/logger/FlowFormatLogBuilder;
    move-result-object v2
    return-object v2
.end method

.method public final params2(kotlin.jvm.functions.Function1)com.bytedance.trae.utils.logger.FlowFormatLogBuilder
    .registers 6
    # ins_size=2
    const-string v0, "block"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Ljava/util/LinkedHashMap;
    invoke-direct v0, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v0, Ljava/util/Map;
    invoke-interface v5, v0, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    new-instance v5, Ljava/util/ArrayList;
    invoke-interface v0, Ljava/util/Map;->size()I
    move-result v1
    invoke-direct v5, v1, Ljava/util/ArrayList;-><init>(I)V
    check-cast v5, Ljava/util/Collection;
    invoke-interface v0, Ljava/util/Map;->entrySet()Ljava/util/Set;
    move-result-object v0
    invoke-interface v0, Ljava/util/Set;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +01fh
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/util/Map$Entry;
    new-instance v2, Lcom/bytedance/trae/utils/logger/LogKey;
    invoke-interface v1, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/lang/String;
    invoke-direct v2, v3, Lcom/bytedance/trae/utils/logger/LogKey;-><init>(Ljava/lang/String;)V
    invoke-interface v1, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v1
    invoke-static v2, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    invoke-interface v5, v1, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -22h
    check-cast v5, Ljava/util/List;
    check-cast v5, Ljava/lang/Iterable;
    invoke-static v5, Lkotlin/collections/MapsKt;->toMap(Ljava/lang/Iterable;)Ljava/util/Map;
    move-result-object v5
    invoke-virtual v4, v5, Lcom/bytedance/trae/utils/logger/FlowFormatLogBuilder;->params(Ljava/util/Map;)Lcom/bytedance/trae/utils/logger/FlowFormatLogBuilder;
    move-result-object v5
    return-object v5
.end method

.method public final source(java.lang.String)com.bytedance.trae.utils.logger.FlowFormatLogBuilder
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/utils/logger/FlowFormatLogBuilder;->parameter Lcom/bytedance/trae/utils/logger/LogParameter;
    invoke-virtual v0, v2, Lcom/bytedance/trae/utils/logger/LogParameter;->setSource(Ljava/lang/String;)V
    return-object v1
.end method

.method public final whereInfo(java.lang.String)com.bytedance.trae.utils.logger.FlowFormatLogBuilder
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/utils/logger/FlowFormatLogBuilder;->parameter Lcom/bytedance/trae/utils/logger/LogParameter;
    invoke-virtual v0, v2, Lcom/bytedance/trae/utils/logger/LogParameter;->setWhereInfo(Ljava/lang/String;)V
    return-object v1
.end method

.method public final who(java.lang.String)com.bytedance.trae.utils.logger.FlowFormatLogBuilder
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/utils/logger/FlowFormatLogBuilder;->parameter Lcom/bytedance/trae/utils/logger/LogParameter;
    invoke-virtual v0, v2, Lcom/bytedance/trae/utils/logger/LogParameter;->setWho(Ljava/lang/String;)V
    return-object v1
.end method
