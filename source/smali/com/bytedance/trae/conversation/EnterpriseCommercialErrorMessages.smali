# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/EnterpriseCommercialErrorMessages;
.super Ljava/lang/Object;
.source "EnterpriseCommercialErrorMessages.kt"

.field private static final FLAGSHIP_DEFAULT_PARALLEL_LIMIT:I
.field public static final INSTANCE:Lcom/bytedance/trae/conversation/EnterpriseCommercialErrorMessages;
.field private static final TEAM_DEFAULT_PARALLEL_LIMIT:I
.field private static final TEAM_FLAGSHIP:I
.field private static final TEAM_FLAGSHIP_V2:I
.field private static final TEAM_GROUP:I
.field private static final TEAM_GROUP_V2:I


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/EnterpriseCommercialErrorMessages;
    invoke-direct v0, Lcom/bytedance/trae/conversation/EnterpriseCommercialErrorMessages;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/EnterpriseCommercialErrorMessages;->INSTANCE Lcom/bytedance/trae/conversation/EnterpriseCommercialErrorMessages;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static synthetic parallelLimitMessage$default(com.bytedance.trae.conversation.EnterpriseCommercialErrorMessages  android.content.res.Resources  java.lang.Integer  int  java.lang.Object)java.lang.String
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +003h
    const/4 v2, 0
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/EnterpriseCommercialErrorMessages;->parallelLimitMessage(Landroid/content/res/Resources; Ljava/lang/Integer;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public final parallelLimitMessage(android.content.res.Resources  java.lang.Integer)java.lang.String
    .registers 8
    # ins_size=3
    const-string/jumbo v0, resources
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/LoginUtils;->INSTANCE Lcom/bytedance/trae/conversation/LoginUtils;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/LoginUtils;->isEnterpriseLogin()Z
    move-result v0
    const/4 v1, 0
    if-nez v0, +003h
    return-object v1
    const-class v0, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v2, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v0, v2, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/api/ILoginService;
    const/4 v2, 0
    if-eqz v0, +00dh
    invoke-interface v0, Lcom/bytedance/trae/login/api/ILoginService;->getAccountInfo()Lcom/bytedance/trae/login/api/AccountInfo;
    move-result-object v0
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/login/api/AccountInfo;->getProductType()I
    move-result v0
    goto +2h
    move v0, v2
    const/16 v3, 220
    const/4 v4, 1
    if-eq v0, v3, +00eh
    const/16 v3, 221
    if-eq v0, v3, +00ah
    const/16 v3, 230
    if-eq v0, v3, +004h
    const/16 v3, 231
    move v0, v2
    goto +2h
    move v0, v4
    if-eqz v7, +019h
    move-object v3, v7
    check-cast v3, Ljava/lang/Number;
    invoke-virtual v3, Ljava/lang/Number;->intValue()I
    move-result v3
    if-lez v3, +004h
    move v3, v4
    goto +2h
    move v3, v2
    if-eqz v3, +003h
    goto +2h
    move-object v7, v1
    if-eqz v7, +007h
    invoke-virtual v7, Ljava/lang/Integer;->intValue()I
    move-result v7
    goto +8h
    if-eqz v0, +005h
    const/16 v7, 10
    goto +3h
    const/16 v7, 20
    if-eqz v0, +005h
    sget v0, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_enterprise_parallel_limit_team I
    goto +3h
    sget v0, Lcom/bytedance/trae/multilanguage/R$string;->imkit_error_enterprise_parallel_limit_flagship I
    sget-object v1, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->INSTANCE Lcom/bytedance/trae/multilanguage/I18nTextProvider;
    new-array v3, v4, [Ljava/lang/Object;
    invoke-static v7, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v7
    aput-object v7, v3, v2
    invoke-virtual v1, v6, v0, v3, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->getString(Landroid/content/res/Resources; I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v6
    return-object v6
.end method
