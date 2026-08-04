# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser;
.super Ljava/lang/Object;
.source "LenientJsonObjectParser.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser;
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final readJsonString(java.lang.String  int)com.bytedance.trae.conversation.chat.block.LenientJsonObjectParser$ReadResult
    .registers 11
    # ins_size=3
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v9, Ljava/lang/String;->length()I
    move-result v1
    const/4 v2, 1
    add-int/2addr v10, v2
    const/4 v3, 0
    const-string/jumbo v4, toString(...)
    if-ge v10, v1, +0bbh
    invoke-virtual v9, v10, Ljava/lang/String;->charAt(I)C
    move-result v5
    const/16 v6, 34
    if-eq v5, v6, +0a5h
    const/16 v7, 92
    if-eq v5, v7, +008h
    invoke-virtual v0, v5, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    add-int/lit8 v10, v10, 1
    goto -17h
    add-int/lit8 v5, v10, 1
    if-lt v5, v1, +00fh
    new-instance v9, Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser$ReadResult;
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v10
    invoke-static v10, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v9, v10, v3, v1, Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser$ReadResult;-><init>(Ljava/lang/String; Z I)V
    return-object v9
    invoke-virtual v9, v5, Ljava/lang/String;->charAt(I)C
    move-result v5
    if-eq v5, v6, +07dh
    const/16 v6, 47
    if-eq v5, v6, +075h
    if-eq v5, v7, +06fh
    const/16 v6, 98
    if-eq v5, v6, +065h
    const/16 v6, 102
    if-eq v5, v6, +05bh
    const/16 v6, 110
    if-eq v5, v6, +051h
    const/16 v6, 114
    if-eq v5, v6, +047h
    const/16 v6, 116
    if-eq v5, v6, +03dh
    const/16 v6, 117
    if-eq v5, v6, +006h
    invoke-virtual v0, v5, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    goto +5dh
    add-int/lit8 v6, v10, 6
    if-gt v6, v1, +024h
    add-int/lit8 v3, v10, 2
    invoke-virtual v9, v3, v6, Ljava/lang/String;->substring(I I)Ljava/lang/String;
    move-result-object v3
    const-string/jumbo v4, substring(...)
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/16 v4, 16
    invoke-static v3, v4, Lkotlin/text/StringsKt;->toIntOrNull(Ljava/lang/String; I)Ljava/lang/Integer;
    move-result-object v3
    if-eqz v3, +00ch
    invoke-virtual v3, Ljava/lang/Integer;->intValue()I
    move-result v10
    int-to-char v10, v10
    invoke-virtual v0, v10, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move v10, v6
    goto -72h
    invoke-virtual v0, v5, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    goto +37h
    new-instance v9, Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser$ReadResult;
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v10
    invoke-static v10, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v9, v10, v3, v1, Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser$ReadResult;-><init>(Ljava/lang/String; Z I)V
    return-object v9
    const/16 v3, 9
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    goto +24h
    const/16 v3, 13
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    goto +1eh
    const/16 v3, 10
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    goto +18h
    const/16 v3, 12
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    goto +12h
    const/16 v3, 8
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    goto +ch
    invoke-virtual v0, v7, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    goto +8h
    invoke-virtual v0, v6, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    goto +4h
    invoke-virtual v0, v6, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    add-int/lit8 v10, v10, 2
    goto/16 -0afh
    new-instance v9, Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser$ReadResult;
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-static v0, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    add-int/2addr v10, v2
    invoke-direct v9, v0, v2, v10, Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser$ReadResult;-><init>(Ljava/lang/String; Z I)V
    return-object v9
    new-instance v9, Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser$ReadResult;
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v10
    invoke-static v10, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v9, v10, v3, v1, Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser$ReadResult;-><init>(Ljava/lang/String; Z I)V
    return-object v9
.end method

.method private final skipValue(java.lang.String  int)com.bytedance.trae.conversation.chat.block.LenientJsonObjectParser$ReadResult
    .registers 10
    # ins_size=3
    invoke-virtual v8, Ljava/lang/String;->length()I
    move-result v0
    const/4 v1, 0
    move v2, v1
    const-string v3, ""
    if-ge v9, v0, +04dh
    invoke-virtual v8, v9, Ljava/lang/String;->charAt(I)C
    move-result v4
    const/16 v5, 34
    if-eq v4, v5, +030h
    const/16 v5, 44
    const/4 v6, 1
    if-eq v4, v5, +023h
    const/16 v5, 91
    if-eq v4, v5, +01ah
    const/16 v5, 93
    if-eq v4, v5, +00bh
    const/16 v5, 123
    if-eq v4, v5, +012h
    const/16 v5, 125
    if-eq v4, v5, +003h
    goto +eh
    if-nez v2, +008h
    new-instance v8, Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser$ReadResult;
    invoke-direct v8, v3, v6, v9, Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser$ReadResult;-><init>(Ljava/lang/String; Z I)V
    return-object v8
    add-int/lit8 v2, v2, -1
    goto +3h
    add-int/lit8 v2, v2, 1
    add-int/lit8 v9, v9, 1
    goto -31h
    if-nez v2, -003h
    new-instance v8, Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser$ReadResult;
    invoke-direct v8, v3, v6, v9, Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser$ReadResult;-><init>(Ljava/lang/String; Z I)V
    return-object v8
    invoke-direct v7, v8, v9, Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser;->readJsonString(Ljava/lang/String; I)Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser$ReadResult;
    move-result-object v9
    invoke-virtual v9, Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser$ReadResult;->getComplete()Z
    move-result v4
    if-nez v4, +008h
    new-instance v8, Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser$ReadResult;
    invoke-direct v8, v3, v1, v0, Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser$ReadResult;-><init>(Ljava/lang/String; Z I)V
    return-object v8
    invoke-virtual v9, Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser$ReadResult;->getNextIndex()I
    move-result v9
    goto -4eh
    new-instance v8, Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser$ReadResult;
    invoke-direct v8, v3, v1, v0, Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser$ReadResult;-><init>(Ljava/lang/String; Z I)V
    return-object v8
.end method

.method private final skipWhitespace(java.lang.String  int)int
    .registers 4
    # ins_size=3
    invoke-virtual v2, Ljava/lang/String;->length()I
    move-result v0
    if-ge v3, v0, +00fh
    invoke-virtual v2, v3, Ljava/lang/String;->charAt(I)C
    move-result v0
    invoke-static v0, Lkotlin/text/CharsKt;->isWhitespace(C)Z
    move-result v0
    if-eqz v0, +005h
    add-int/lit8 v3, v3, 1
    goto -12h
    return v3
.end method

.method public final parseTopLevelStrings(java.lang.String)java.util.Map
    .registers 9
    # ins_size=2
    const-string v0, "raw"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Ljava/util/LinkedHashMap;
    invoke-direct v0, Ljava/util/LinkedHashMap;-><init>()V
    invoke-virtual v8, Ljava/lang/String;->length()I
    move-result v1
    const/4 v2, 0
    invoke-direct v7, v8, v2, Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser;->skipWhitespace(Ljava/lang/String; I)I
    move-result v2
    if-ge v2, v1, +07dh
    invoke-virtual v8, v2, Ljava/lang/String;->charAt(I)C
    move-result v3
    const/16 v4, 123
    if-eq v3, v4, +004h
    goto/16 +073h
    add-int/lit8 v2, v2, 1
    if-ge v2, v1, +06ch
    invoke-direct v7, v8, v2, Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser;->skipWhitespace(Ljava/lang/String; I)I
    move-result v2
    if-ge v2, v1, +066h
    invoke-virtual v8, v2, Ljava/lang/String;->charAt(I)C
    move-result v3
    const/16 v4, 34
    if-eq v3, v4, +007h
    const/16 v4, 44
    if-eq v3, v4, -014h
    goto +58h
    invoke-direct v7, v8, v2, Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser;->readJsonString(Ljava/lang/String; I)Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser$ReadResult;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser$ReadResult;->getComplete()Z
    move-result v3
    if-eqz v3, +04fh
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser$ReadResult;->getValue()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser$ReadResult;->getNextIndex()I
    move-result v2
    invoke-direct v7, v8, v2, Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser;->skipWhitespace(Ljava/lang/String; I)I
    move-result v2
    if-ge v2, v1, +041h
    invoke-virtual v8, v2, Ljava/lang/String;->charAt(I)C
    move-result v5
    const/16 v6, 58
    if-eq v5, v6, +003h
    goto +37h
    add-int/lit8 v2, v2, 1
    invoke-direct v7, v8, v2, Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser;->skipWhitespace(Ljava/lang/String; I)I
    move-result v2
    if-ge v2, v1, +030h
    invoke-virtual v8, v2, Ljava/lang/String;->charAt(I)C
    move-result v5
    if-ne v5, v4, +01bh
    invoke-direct v7, v8, v2, Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser;->readJsonString(Ljava/lang/String; I)Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser$ReadResult;
    move-result-object v2
    move-object v4, v0
    check-cast v4, Ljava/util/Map;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser$ReadResult;->getValue()Ljava/lang/String;
    move-result-object v5
    invoke-interface v4, v3, v5, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser$ReadResult;->getComplete()Z
    move-result v3
    if-eqz v3, +016h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser$ReadResult;->getNextIndex()I
    move-result v2
    goto -5ch
    invoke-direct v7, v8, v2, Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser;->skipValue(Ljava/lang/String; I)Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser$ReadResult;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser$ReadResult;->getComplete()Z
    move-result v3
    if-eqz v3, +007h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser$ReadResult;->getNextIndex()I
    move-result v2
    goto -6bh
    check-cast v0, Ljava/util/Map;
    return-object v0
    check-cast v0, Ljava/util/Map;
    return-object v0
.end method
