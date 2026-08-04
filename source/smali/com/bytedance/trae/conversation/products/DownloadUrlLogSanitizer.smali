# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/products/DownloadUrlLogSanitizer;
.super Ljava/lang/Object;
.source "FileDownloadHelper.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/products/DownloadUrlLogSanitizer;
.field private static final sensitiveQueryParamRegex:Lkotlin/text/Regex;


.method public static synthetic $r8$lambda$TeDLEBoF9qj965UHy-EUFQCP8Rw(kotlin.text.MatchResult)java.lang.CharSequence
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/products/DownloadUrlLogSanitizer;->redactSensitiveQueryParams$lambda$0(Lkotlin/text/MatchResult;)Ljava/lang/CharSequence;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/products/DownloadUrlLogSanitizer;
    invoke-direct v0, Lcom/bytedance/trae/conversation/products/DownloadUrlLogSanitizer;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/products/DownloadUrlLogSanitizer;->INSTANCE Lcom/bytedance/trae/conversation/products/DownloadUrlLogSanitizer;
    new-instance v0, Lkotlin/text/Regex;
    const-string v1, "(?i)([?&]authorization=)[^&]*"
    invoke-direct v0, v1, Lkotlin/text/Regex;-><init>(Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/conversation/products/DownloadUrlLogSanitizer;->sensitiveQueryParamRegex Lkotlin/text/Regex;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private static final redactSensitiveQueryParams$lambda$0(kotlin.text.MatchResult)java.lang.CharSequence
    .registers 3
    # ins_size=1
    const-string v0, "match"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    invoke-interface v2, Lkotlin/text/MatchResult;->getGroupValues()Ljava/util/List;
    move-result-object v2
    const/4 v1, 1
    invoke-interface v2, v1, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/String;
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v0, "<redacted>"
    invoke-virtual v2, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    check-cast v2, Ljava/lang/CharSequence;
    return-object v2
.end method

.method public final redactSensitiveQueryParams(java.lang.String)java.lang.String
    .registers 4
    # ins_size=2
    const-string/jumbo v0, url
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/products/DownloadUrlLogSanitizer;->sensitiveQueryParamRegex Lkotlin/text/Regex;
    check-cast v3, Ljava/lang/CharSequence;
    new-instance v1, Lcom/bytedance/trae/conversation/products/DownloadUrlLogSanitizer$$ExternalSyntheticLambda0;
    invoke-direct v1, Lcom/bytedance/trae/conversation/products/DownloadUrlLogSanitizer$$ExternalSyntheticLambda0;-><init>()V
    invoke-virtual v0, v3, v1, Lkotlin/text/Regex;->replace(Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function1;)Ljava/lang/String;
    move-result-object v3
    return-object v3
.end method
