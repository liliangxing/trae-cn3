# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/init/task/base/IInitReportTask$DefaultImpls;
.super Ljava/lang/Object;
.source "IInitReportTask.kt"


.method public static synthetic $r8$lambda$3ztkOuRQZym3JwQRBs1gvsYtyoY(com.bytedance.trae.init.task.base.IInitReportTask)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/init/task/base/IInitReportTask$DefaultImpls;->run$lambda$1$lambda$0(Lcom/bytedance/trae/init/task/base/IInitReportTask;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$5GbHnJxS5w0AWxO3r2aKgQTQFRE(com.bytedance.trae.init.task.base.IInitReportTask)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/init/task/base/IInitReportTask$DefaultImpls;->run$lambda$1(Lcom/bytedance/trae/init/task/base/IInitReportTask;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static checkFirstStartAsyncTaskInit(com.bytedance.trae.init.task.base.IInitReportTask  java.lang.String)boolean
    .registers 2
    # ins_size=2
    const-string/jumbo v0, taskName
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/home/privacy/PrivacyManager;->INSTANCE Lcom/bytedance/trae/home/privacy/PrivacyManager;
    invoke-virtual v0, Lcom/bytedance/trae/home/privacy/PrivacyManager;->isFirstInstallStarting()Z
    move-result v0
    if-eqz v0, +010h
    sget-object v0, Lcom/bytedance/trae/init/task/base/IInitReportTask;->Companion Lcom/bytedance/trae/init/task/base/IInitReportTask$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/init/task/base/IInitReportTask$Companion;->getPrePrivacyWhiteList()Ljava/util/Set;
    move-result-object v0
    invoke-interface v0, v1, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    return v0
.end method

.method public static getFirstStyle(com.bytedance.trae.init.task.base.IInitReportTask)java.lang.String
    .registers 1
    # ins_size=1
    const-string v0, "normal"
    return-object v0
.end method

.method public static run(com.bytedance.trae.init.task.base.IInitReportTask)void
    .registers 5
    # ins_size=1
    invoke-interface v4, Lcom/bytedance/trae/init/task/base/IInitReportTask;->getScene()Ljava/lang/String;
    move-result-object v0
    invoke-interface v4, Lcom/bytedance/trae/init/task/base/IInitReportTask;->getFirstStyle()Ljava/lang/String;
    move-result-object v1
    move-object v2, v4
    check-cast v2, Ljava/lang/Runnable;
    new-instance v3, Lcom/bytedance/trae/init/task/base/IInitReportTask$DefaultImpls$$ExternalSyntheticLambda0;
    invoke-direct v3, v4, Lcom/bytedance/trae/init/task/base/IInitReportTask$DefaultImpls$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/init/task/base/IInitReportTask;)V
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/init/task/base/InitTaskHelperKt;->runWithMonitor(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Runnable; Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method private static run$lambda$1(com.bytedance.trae.init.task.base.IInitReportTask)kotlin.Unit
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v0
    if-nez v0, +02fh
    invoke-virtual v2, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v0
    invoke-static v0, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;
    move-result-object v0
    invoke-interface v0, Lkotlin/reflect/KClass;->getSimpleName()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    const-string v0, ""
    invoke-interface v2, v0, Lcom/bytedance/trae/init/task/base/IInitReportTask;->checkFirstStartAsyncTaskInit(Ljava/lang/String;)Z
    move-result v0
    if-eqz v0, +019h
    invoke-interface v2, Lcom/bytedance/trae/init/task/base/IInitReportTask;->getFirstStyle()Ljava/lang/String;
    move-result-object v0
    const-string v1, "asyncThreadWhenFirst"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +00dh
    sget-object v0, Lcom/bytedance/trae/init/task/FirstFrameSchedulerExecutors;->INSTANCE Lcom/bytedance/trae/init/task/FirstFrameSchedulerExecutors;
    new-instance v1, Lcom/bytedance/trae/init/task/base/IInitReportTask$DefaultImpls$$ExternalSyntheticLambda1;
    invoke-direct v1, v2, Lcom/bytedance/trae/init/task/base/IInitReportTask$DefaultImpls$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/init/task/base/IInitReportTask;)V
    invoke-virtual v0, v1, Lcom/bytedance/trae/init/task/FirstFrameSchedulerExecutors;->useLaunchBoostExecutor(Lkotlin/jvm/functions/Function0;)V
    goto +4h
    invoke-interface v2, Lcom/bytedance/trae/init/task/base/IInitReportTask;->runInternal()V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
.end method

.method private static run$lambda$1$lambda$0(com.bytedance.trae.init.task.base.IInitReportTask)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-interface v0, Lcom/bytedance/trae/init/task/base/IInitReportTask;->runInternal()V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method
