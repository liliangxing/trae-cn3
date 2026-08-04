# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/utils/TrustedDomainUtils;
.super Ljava/lang/Object;
.source "TrustedDomainUtils.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/utils/TrustedDomainUtils;
.field private static final TRUSTED_DOMAINS:Ljava/util/List;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/utils/TrustedDomainUtils;
    invoke-direct v0, Lcom/bytedance/trae/utils/TrustedDomainUtils;-><init>()V
    sput-object v0, Lcom/bytedance/trae/utils/TrustedDomainUtils;->INSTANCE Lcom/bytedance/trae/utils/TrustedDomainUtils;
    const-string/jumbo v0, trae.ai
    const-string/jumbo v1, trae.cn
    filled-new-array v0, v1, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/CollectionsKt;->listOf([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/utils/TrustedDomainUtils;->TRUSTED_DOMAINS Ljava/util/List;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final isTrustedHost(java.lang.String)boolean
    .registers 8
    # ins_size=2
    const-string v0, "host"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v7, v0, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v7
    const-string/jumbo v0, toLowerCase(...)
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/utils/TrustedDomainUtils;->TRUSTED_DOMAINS Ljava/util/List;
    check-cast v0, Ljava/lang/Iterable;
    instance-of v1, v0, Ljava/util/Collection;
    const/4 v2, 0
    if-eqz v1, +00ch
    move-object v1, v0
    check-cast v1, Ljava/util/Collection;
    invoke-interface v1, Ljava/util/Collection;->isEmpty()Z
    move-result v1
    if-eqz v1, +003h
    goto +36h
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +02dh
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/String;
    invoke-static v7, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    const/4 v4, 1
    if-nez v3, +01ch
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v5, "."
    invoke-direct v3, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const/4 v3, 2
    const/4 v5, 0
    invoke-static v7, v1, v2, v3, v5, Lkotlin/text/StringsKt;->endsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +003h
    goto +3h
    move v1, v2
    goto +2h
    move v1, v4
    if-eqz v1, -02eh
    move v2, v4
    return v2
.end method

.method public final isTrustedUrl(java.lang.String)boolean
    .registers 6
    # ins_size=2
    move-object v0, v5
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v1, 0
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    move v0, v1
    goto +2h
    const/4 v0, 1
    if-eqz v0, +003h
    return v1
    invoke-static v5, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v5
    invoke-virtual v5, Landroid/net/Uri;->getScheme()Ljava/lang/String;
    move-result-object v0
    const-string/jumbo v2, toLowerCase(...)
    if-eqz v0, +00ch
    sget-object v3, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v0, v3, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v0
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +2h
    const/4 v0, 0
    const-string v3, "https"
    invoke-static v0, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    return v1
    invoke-virtual v5, Landroid/net/Uri;->getHost()Ljava/lang/String;
    move-result-object v5
    if-eqz v5, +013h
    sget-object v0, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v5, v0, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v5
    invoke-static v5, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    if-nez v5, +003h
    goto +6h
    invoke-virtual v4, v5, Lcom/bytedance/trae/utils/TrustedDomainUtils;->isTrustedHost(Ljava/lang/String;)Z
    move-result v1
    nop 
    return v1
    :try_start_0x13
    :try_start_0x20
.end method
