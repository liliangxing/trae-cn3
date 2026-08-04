# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefStreamGuard;
.super Ljava/lang/Object;
.source "TraeRefStreamGuard.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefStreamGuard;
.field private static final TOKEN_HEAD:Ljava/lang/String;
.field private static final TOKEN_HEAD_WITH_PAREN:Ljava/lang/String;
.field private static final TRAE_REF_PATTERN:Ljava/util/regex/Pattern;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefStreamGuard;
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefStreamGuard;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefStreamGuard;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefStreamGuard;
    const-string v0, "\[\$TRAE_REF\]\((https?://[^)\s]+)\)"
    invoke-static v0, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;
    move-result-object v0
    const-string v1, "compile(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefStreamGuard;->TRAE_REF_PATTERN Ljava/util/regex/Pattern;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final findTrailingPartialHead(java.lang.String)java.lang.Integer
    .registers 14
    # ins_size=2
    const-string v0, "[$TRAE_REF]("
    const-string v1, "[$TRAE_REF]"
    filled-new-array v0, v1, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/CollectionsKt;->listOf([Ljava/lang/Object;)Ljava/util/List;
    const/16 v0, 11
    const-string/jumbo v2, substring(...)
    const/4 v3, 2
    const/4 v4, 0
    const/4 v5, 0
    if-lez v0, +022h
    invoke-virtual v1, v5, v0, Ljava/lang/String;->substring(I I)Ljava/lang/String;
    move-result-object v6
    invoke-static v6, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v13, v6, v5, v3, v4, Lkotlin/text/StringsKt;->endsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +012h
    invoke-static v13, v1, v5, v3, v4, Lkotlin/text/StringsKt;->endsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +00ch
    invoke-virtual v13, Ljava/lang/String;->length()I
    move-result v13
    sub-int/2addr v13, v0
    invoke-static v13, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v13
    return-object v13
    add-int/lit8 v0, v0, -1
    goto -27h
    move-object v6, v13
    check-cast v6, Ljava/lang/CharSequence;
    const-string v7, "[$TRAE_REF]("
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 6
    const/4 v11, 0
    invoke-static/range v6 ... v11, Lkotlin/text/StringsKt;->lastIndexOf$default(Ljava/lang/CharSequence; Ljava/lang/String; I Z I Ljava/lang/Object;)I
    move-result v0
    if-ltz v0, +01ah
    invoke-virtual v13, v0, Ljava/lang/String;->substring(I)Ljava/lang/String;
    move-result-object v13
    invoke-static v13, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v13, Ljava/lang/CharSequence;
    const-string v1, ")"
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v13, v1, v5, v3, v4, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z I Ljava/lang/Object;)Z
    move-result v13
    if-nez v13, +007h
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v13
    return-object v13
    return-object v4
.end method

.method public final canEmit(java.lang.String)boolean
    .registers 3
    # ins_size=2
    const-string v0, "raw"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefStreamGuard;->findIncompleteTRAERef(Ljava/lang/String;)Ljava/lang/Integer;
    move-result-object v2
    if-nez v2, +004h
    const/4 v2, 1
    goto +2h
    const/4 v2, 0
    return v2
.end method

.method public final findIncompleteTRAERef(java.lang.String)java.lang.Integer
    .registers 10
    # ins_size=2
    const-string v0, "raw"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v1, v9
    check-cast v1, Ljava/lang/CharSequence;
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    const/4 v7, 0
    if-eqz v0, +003h
    return-object v7
    const-string v2, "[$TRAE_REF]"
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 6
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlin/text/StringsKt;->lastIndexOf$default(Ljava/lang/CharSequence; Ljava/lang/String; I Z I Ljava/lang/Object;)I
    move-result v0
    if-ltz v0, +025h
    invoke-virtual v9, v0, Ljava/lang/String;->substring(I)Ljava/lang/String;
    move-result-object v1
    const-string/jumbo v2, substring(...)
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefStreamGuard;->TRAE_REF_PATTERN Ljava/util/regex/Pattern;
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v2, v1, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    move-result-object v1
    invoke-virtual v1, Ljava/util/regex/Matcher;->lookingAt()Z
    move-result v2
    if-eqz v2, +008h
    invoke-virtual v1, Ljava/util/regex/Matcher;->start()I
    move-result v1
    if-eqz v1, +007h
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v9
    return-object v9
    invoke-direct v8, v9, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefStreamGuard;->findTrailingPartialHead(Ljava/lang/String;)Ljava/lang/Integer;
    move-result-object v9
    if-eqz v9, +003h
    return-object v9
    return-object v7
.end method

.method public final getTRAE_REF_PATTERN()java.util.regex.Pattern
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefStreamGuard;->TRAE_REF_PATTERN Ljava/util/regex/Pattern;
    return-object v0
.end method

.method public final safeTruncate(java.lang.String)java.lang.String
    .registers 4
    # ins_size=2
    const-string v0, "raw"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefStreamGuard;->findIncompleteTRAERef(Ljava/lang/String;)Ljava/lang/Integer;
    move-result-object v0
    if-eqz v0, +011h
    invoke-virtual v0, Ljava/lang/Integer;->intValue()I
    move-result v0
    const/4 v1, 0
    invoke-virtual v3, v1, v0, Ljava/lang/String;->substring(I I)Ljava/lang/String;
    move-result-object v3
    const-string/jumbo v0, substring(...)
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v3
.end method
