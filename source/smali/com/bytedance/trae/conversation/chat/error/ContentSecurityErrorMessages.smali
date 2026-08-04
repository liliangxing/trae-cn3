# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/error/ContentSecurityErrorMessages;
.super Ljava/lang/Object;
.source "ContentSecurityErrorMessages.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/chat/error/ContentSecurityErrorMessages;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/error/ContentSecurityErrorMessages;
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/error/ContentSecurityErrorMessages;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/error/ContentSecurityErrorMessages;->INSTANCE Lcom/bytedance/trae/conversation/chat/error/ContentSecurityErrorMessages;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final blockedMessage(android.content.res.Resources  java.lang.String)java.lang.String
    .registers 6
    # ins_size=3
    const-string/jumbo v0, resources
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    if-eqz v5, +00dh
    check-cast v5, Ljava/lang/CharSequence;
    invoke-static v5, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v5
    goto +2h
    const/4 v5, 0
    if-nez v5, +004h
    const-string v5, ""
    move-object v0, v5
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    const/4 v1, 0
    if-lez v0, +004h
    const/4 v0, 1
    goto +2h
    move v0, v1
    if-eqz v0, +016h
    sget-object v0, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->INSTANCE Lcom/bytedance/trae/multilanguage/I18nTextProvider;
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_enterprise_content_security_blocked_with_rule_name I
    const-string/jumbo v2, rule_name
    invoke-static v2, v5, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v5
    invoke-static v5, Lkotlin/collections/MapsKt;->mapOf(Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v5
    invoke-virtual v0, v4, v1, v5, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->getStringWithNamedArgs(Landroid/content/res/Resources; I Ljava/util/Map;)Ljava/lang/String;
    move-result-object v4
    return-object v4
    sget-object v5, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->INSTANCE Lcom/bytedance/trae/multilanguage/I18nTextProvider;
    sget v0, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_enterprise_content_security_blocked I
    new-array v1, v1, [Ljava/lang/Object;
    invoke-virtual v5, v4, v0, v1, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->getString(Landroid/content/res/Resources; I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v4
    return-object v4
.end method
