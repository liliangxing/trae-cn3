# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderUpdateActionSpy;
.super Ljava/lang/Object;
.source "UpgradeReminderUpdateActionSpy.kt"

.field private static final BACKEND_MODE_ARGUMENT:Ljava/lang/String;
.field private static final E2E_PREF:Ljava/lang/String;
.field public static final INSTANCE:Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderUpdateActionSpy;
.field private static final INSTRUMENTATION_CLASS:Ljava/lang/String;
.field private static final KEY_UPDATE_AUTO_CHECK:Ljava/lang/String;
.field private static final KEY_UPDATE_CALLED:Ljava/lang/String;
.field private static final RUN_ID_ARGUMENT:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderUpdateActionSpy;
    invoke-direct v0, Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderUpdateActionSpy;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderUpdateActionSpy;->INSTANCE Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderUpdateActionSpy;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final instrumentationArgumentsOrNull()android.os.Bundle
    .registers 6
    # ins_size=1
    const/4 v0, 0
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v1, v5
    check-cast v1, Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderUpdateActionSpy;
    const-string v1, "androidx.test.platform.app.InstrumentationRegistry"
    invoke-static v1, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;
    move-result-object v1
    const-string v2, "getArguments"
    const/4 v3, 0
    new-array v4, v3, [Ljava/lang/Class;
    invoke-virtual v1, v2, v4, Ljava/lang/Class;->getMethod(Ljava/lang/String; [Ljava/lang/Class;)Ljava/lang/reflect/Method;
    move-result-object v1
    new-array v2, v3, [Ljava/lang/Object;
    invoke-virtual v1, v0, v2, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object; [Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    instance-of v2, v1, Landroid/os/Bundle;
    if-eqz v2, +005h
    check-cast v1, Landroid/os/Bundle;
    goto +2h
    move-object v1, v0
    invoke-static v1, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    goto +ch
    move-exception v1
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v1, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v1
    invoke-static v1, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    invoke-static v1, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +003h
    goto +2h
    move-object v0, v1
    check-cast v0, Landroid/os/Bundle;
    return-object v0
    :try_start_0x1
.end method

.method private final isE2ERunnerInstrumentationRun()boolean
    .registers 5
    # ins_size=1
    invoke-direct v4, Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderUpdateActionSpy;->instrumentationArgumentsOrNull()Landroid/os/Bundle;
    move-result-object v0
    const/4 v1, 0
    if-nez v0, +003h
    return v1
    const-string v2, "backendMode"
    invoke-virtual v0, v2, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    check-cast v2, Ljava/lang/CharSequence;
    const/4 v3, 1
    if-eqz v2, +00bh
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    if-eqz v2, +003h
    goto +3h
    move v2, v1
    goto +2h
    move v2, v3
    if-nez v2, +01ah
    const-string/jumbo v2, runId
    invoke-virtual v0, v2, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    if-eqz v0, +00bh
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    if-eqz v0, +003h
    goto +3h
    move v0, v1
    goto +2h
    move v0, v3
    if-nez v0, +003h
    move v1, v3
    return v1
.end method

.method public final record(boolean)boolean
    .registers 5
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isDebug()Z
    move-result v0
    const/4 v1, 0
    if-eqz v0, +02dh
    invoke-direct v3, Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderUpdateActionSpy;->isE2ERunnerInstrumentationRun()Z
    move-result v0
    if-nez v0, +003h
    goto +25h
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v0
    const-string/jumbo v2, upgrade_reminder_e2e
    invoke-virtual v0, v2, v1, Landroid/app/Application;->getSharedPreferences(Ljava/lang/String; I)Landroid/content/SharedPreferences;
    move-result-object v0
    invoke-interface v0, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;
    move-result-object v0
    const-string/jumbo v1, update_called
    const/4 v2, 1
    invoke-interface v0, v1, v2, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String; Z)Landroid/content/SharedPreferences$Editor;
    move-result-object v0
    const-string/jumbo v1, update_auto_check
    invoke-interface v0, v1, v4, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String; Z)Landroid/content/SharedPreferences$Editor;
    move-result-object v4
    invoke-interface v4, Landroid/content/SharedPreferences$Editor;->apply()V
    return v2
    return v1
.end method
