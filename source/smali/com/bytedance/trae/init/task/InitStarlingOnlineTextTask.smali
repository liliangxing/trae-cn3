# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/init/task/InitStarlingOnlineTextTask;
.super Ljava/lang/Object;
.source "InitStarlingOnlineTextTask.kt"

.implements Lcom/bytedance/lego/init/model/IInitTask;
.implements Lcom/bytedance/trae/init/task/base/IInitReportTask;

.field public static final $stable:I
.field private static final Companion:Lcom/bytedance/trae/init/task/InitStarlingOnlineTextTask$Companion;
.field public static final STARLING_APP_KEY:Ljava/lang/String;
.field public static final STARLING_MAINLAND_NAMESPACE:Ljava/lang/String;
.field public static final STARLING_MAINLAND_ZONE_HOST:Ljava/lang/String;
.field public static final STARLING_NORMAL_MODE:Ljava/lang/String;
.field public static final STARLING_OFFLINE_MODE:Ljava/lang/String;
.field public static final STARLING_OVERSEA_NAMESPACE:Ljava/lang/String;
.field public static final STARLING_OVERSEA_ZONE_HOST:Ljava/lang/String;
.field public static final TAG:Ljava/lang/String;
.field public static final USE_STARLING_OFFLINE_MODE:Z
.field private final scene:Ljava/lang/String;


.method public static synthetic $r8$lambda$MRPlf1tEhfU1j58QZOR1btZ_VYg(java.lang.String  com.bytedance.trae.multilanguage.I18nLanguage  boolean  java.lang.String)kotlin.Unit
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/init/task/InitStarlingOnlineTextTask;->runInternal$lambda$0(Ljava/lang/String; Lcom/bytedance/trae/multilanguage/I18nLanguage; Z Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/init/task/InitStarlingOnlineTextTask$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/init/task/InitStarlingOnlineTextTask$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/init/task/InitStarlingOnlineTextTask;->Companion Lcom/bytedance/trae/init/task/InitStarlingOnlineTextTask$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    const-string v0, "Infra"
    iput-object v0, v1, Lcom/bytedance/trae/init/task/InitStarlingOnlineTextTask;->scene Ljava/lang/String;
    return-void 
.end method

.method private static final runInternal$lambda$0(java.lang.String  com.bytedance.trae.multilanguage.I18nLanguage  boolean  java.lang.String)kotlin.Unit
    .registers 15
    # ins_size=4
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "refresh start trigger: reason=ttnet_ready, namespace="
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", language="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v12, Lcom/bytedance/trae/multilanguage/I18nLanguage;->getCode()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const-string v2, "StarlingOnlineText"
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v3, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;->INSTANCE Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v0
    move-object v4, v0
    check-cast v4, Landroid/content/Context;
    new-instance v0, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextConfig;
    const-string v6, "371d23c04dd711f1a159f17d708204a2"
    if-eqz v13, +005h
    const-string v13, "https://starling-oversea.byteoversea.com"
    goto +3h
    const-string v13, "https://starling.zijieapi.com"
    move-object v8, v13
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v10
    move-object v5, v0
    move-object v7, v11
    move-object v9, v14
    invoke-direct/range v5 ... v10, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextConfig;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/util/List;)V
    invoke-static v12, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v6
    const/4 v7, 0
    const/4 v8, 0
    const/16 v9, 24
    const/4 v10, 0
    invoke-static/range v3 ... v10, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;->refreshAll$default(Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater; Landroid/content/Context; Lcom/bytedance/trae/multilanguage/StarlingOnlineTextConfig; Ljava/util/List; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)V
    sget-object v11, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v11
.end method

.method public checkFirstStartAsyncTaskInit(java.lang.String)boolean
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/init/task/base/IInitReportTask$DefaultImpls;->checkFirstStartAsyncTaskInit(Lcom/bytedance/trae/init/task/base/IInitReportTask; Ljava/lang/String;)Z
    move-result v1
    return v1
.end method

.method public getFirstStyle()java.lang.String
    .registers 2
    # ins_size=1
    invoke-static v1, Lcom/bytedance/trae/init/task/base/IInitReportTask$DefaultImpls;->getFirstStyle(Lcom/bytedance/trae/init/task/base/IInitReportTask;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public getScene()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/init/task/InitStarlingOnlineTextTask;->scene Ljava/lang/String;
    return-object v0
.end method

.method public run()void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/init/task/base/IInitReportTask$DefaultImpls;->run(Lcom/bytedance/trae/init/task/base/IInitReportTask;)V
    return-void 
.end method

.method public runInternal()void
    .registers 7
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v0
    if-eqz v0, +005h
    const-string v1, "errorCodes_i18n"
    goto +3h
    const-string v1, "errorCodes_cn"
    sget-object v2, Lcom/bytedance/trae/multilanguage/I18nLanguage;->Companion Lcom/bytedance/trae/multilanguage/I18nLanguage$Companion;
    sget-object v3, Lcom/bytedance/trae/utils/AppLocaleUtils;->INSTANCE Lcom/bytedance/trae/utils/AppLocaleUtils;
    invoke-virtual v3, Lcom/bytedance/trae/utils/AppLocaleUtils;->getAppLocale()Ljava/util/Locale;
    move-result-object v3
    invoke-virtual v2, v3, Lcom/bytedance/trae/multilanguage/I18nLanguage$Companion;->fromLocale(Ljava/util/Locale;)Lcom/bytedance/trae/multilanguage/I18nLanguage;
    move-result-object v2
    sget-object v3, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v5, "init task scheduled: waitTtnetReady=true, isOversea="
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v0, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v5, ", mode=normal, namespace="
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v5, ", language="
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v2, Lcom/bytedance/trae/multilanguage/I18nLanguage;->getCode()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v5, ", cronetReady="
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    sget-object v5, Lcom/bytedance/trae/network/TraeTTNet;->INSTANCE Lcom/bytedance/trae/network/TraeTTNet;
    invoke-virtual v5, Lcom/bytedance/trae/network/TraeTTNet;->isCronetInitSuccess()Z
    move-result v5
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    const-string v5, "StarlingOnlineText"
    invoke-virtual v3, v5, v4, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v3, Lcom/bytedance/trae/network/TraeTTNet;->INSTANCE Lcom/bytedance/trae/network/TraeTTNet;
    new-instance v4, Lcom/bytedance/trae/init/task/InitStarlingOnlineTextTask$$ExternalSyntheticLambda0;
    const-string v5, "normal"
    invoke-direct v4, v1, v2, v0, v5, Lcom/bytedance/trae/init/task/InitStarlingOnlineTextTask$$ExternalSyntheticLambda0;-><init>(Ljava/lang/String; Lcom/bytedance/trae/multilanguage/I18nLanguage; Z Ljava/lang/String;)V
    invoke-virtual v3, v4, Lcom/bytedance/trae/network/TraeTTNet;->runAfterCronetInit(Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method
