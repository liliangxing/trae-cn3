# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/update/dialogs/UpdateDialog;
.super Landroid/app/Dialog;
.source "UpdateDialog.kt"

.field public static final Companion:Lcom/bytedance/trae/update/dialogs/UpdateDialog$Companion;
.field private static final TAG:Ljava/lang/String;
.field private final autoUpdate:Z
.field private btCancel:Landroid/widget/TextView;
.field private btConfirm:Landroid/widget/TextView;
.field private final ctx:Landroid/content/Context;
.field private helper:Lcom/ss/android/update/UpdateHelper;
.field private iUpdateConfig:Lcom/ss/android/update/IUpdateConfig;
.field private sp:Landroid/content/SharedPreferences;
.field private tvContent:Landroid/widget/TextView;


.method public static synthetic $r8$lambda$SgvvdClqopWZLqNZLz6tS249-bs(com.bytedance.trae.update.dialogs.UpdateDialog  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/update/dialogs/UpdateDialog;->initAction$lambda$1(Lcom/bytedance/trae/update/dialogs/UpdateDialog; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$pnIE2uqrnvQirWxKPTp0iOlxoRg(com.bytedance.trae.update.dialogs.UpdateDialog  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/update/dialogs/UpdateDialog;->initAction$lambda$0(Lcom/bytedance/trae/update/dialogs/UpdateDialog; Landroid/view/View;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/update/dialogs/UpdateDialog$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/update/dialogs/UpdateDialog$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/update/dialogs/UpdateDialog;->Companion Lcom/bytedance/trae/update/dialogs/UpdateDialog$Companion;
    const-string v0, "UpdateDialog"
    sput-object v0, Lcom/bytedance/trae/update/dialogs/UpdateDialog;->TAG Ljava/lang/String;
    return-void 
.end method

.method public constructor <init>(android.content.Context  boolean)void
    .registers 4
    # ins_size=3
    const-string v0, "ctx"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, Landroid/app/Dialog;-><init>(Landroid/content/Context;)V
    iput-object v2, v1, Lcom/bytedance/trae/update/dialogs/UpdateDialog;->ctx Landroid/content/Context;
    iput-boolean v3, v1, Lcom/bytedance/trae/update/dialogs/UpdateDialog;->autoUpdate Z
    invoke-static Lcom/ss/android/update/UpdateHelper;->getInstance()Lcom/ss/android/update/UpdateHelper;
    move-result-object v2
    const-string v3, "getInstance(...)"
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v1, Lcom/bytedance/trae/update/dialogs/UpdateDialog;->helper Lcom/ss/android/update/UpdateHelper;
    return-void 
.end method

.method public static final synthetic access$getTAG$cp()java.lang.String
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/update/dialogs/UpdateDialog;->TAG Ljava/lang/String;
    return-object v0
.end method

.method private final bindData()void
    .registers 5
    # ins_size=1
    invoke-static Lcom/ss/android/update/UpdateHelper;->getInstance()Lcom/ss/android/update/UpdateHelper;
    move-result-object v0
    const-string v1, "getInstance(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v0, v4, Lcom/bytedance/trae/update/dialogs/UpdateDialog;->helper Lcom/ss/android/update/UpdateHelper;
    invoke-static Lcom/ss/android/update/UpdateSDK;->getConfig()Lcom/ss/android/update/IUpdateConfig;
    move-result-object v0
    iput-object v0, v4, Lcom/bytedance/trae/update/dialogs/UpdateDialog;->iUpdateConfig Lcom/ss/android/update/IUpdateConfig;
    invoke-virtual v4, Lcom/bytedance/trae/update/dialogs/UpdateDialog;->getContext()Landroid/content/Context;
    move-result-object v0
    const-string/jumbo v1, upgrade_dialog.prefs
    const/4 v2, 0
    invoke-virtual v0, v1, v2, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String; I)Landroid/content/SharedPreferences;
    move-result-object v0
    iput-object v0, v4, Lcom/bytedance/trae/update/dialogs/UpdateDialog;->sp Landroid/content/SharedPreferences;
    iget-object v0, v4, Lcom/bytedance/trae/update/dialogs/UpdateDialog;->btConfirm Landroid/widget/TextView;
    if-eqz v0, +015h
    invoke-virtual v4, Lcom/bytedance/trae/update/dialogs/UpdateDialog;->getContext()Landroid/content/Context;
    move-result-object v1
    invoke-virtual v1, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v1
    sget v3, Lcom/bytedance/trae/update/bits/impl/R$string;->trae_update_now I
    invoke-virtual v1, v3, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v0, v1, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v0, v4, Lcom/bytedance/trae/update/dialogs/UpdateDialog;->helper Lcom/ss/android/update/UpdateHelper;
    invoke-virtual v0, Lcom/ss/android/update/UpdateHelper;->getWhatsNew()Ljava/lang/String;
    move-result-object v0
    iget-object v1, v4, Lcom/bytedance/trae/update/dialogs/UpdateDialog;->helper Lcom/ss/android/update/UpdateHelper;
    invoke-virtual v1, Lcom/ss/android/update/UpdateHelper;->getUpdateReadyApk()Ljava/io/File;
    move-result-object v1
    if-eqz v1, +008h
    iget-object v0, v4, Lcom/bytedance/trae/update/dialogs/UpdateDialog;->helper Lcom/ss/android/update/UpdateHelper;
    invoke-virtual v0, Lcom/ss/android/update/UpdateHelper;->getAlreadyDownloadTips()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    if-eqz v0, +008h
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-nez v1, +003h
    const/4 v2, 1
    if-eqz v2, +003h
    return-void 
    iget-object v1, v4, Lcom/bytedance/trae/update/dialogs/UpdateDialog;->tvContent Landroid/widget/TextView;
    if-eqz v1, +005h
    invoke-virtual v1, v0, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    return-void 
.end method

.method private final cancelClick()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/update/dialogs/UpdateDialog;->helper Lcom/ss/android/update/UpdateHelper;
    iget-boolean v1, v2, Lcom/bytedance/trae/update/dialogs/UpdateDialog;->autoUpdate Z
    invoke-virtual v0, v1, Lcom/ss/android/update/UpdateHelper;->clickCloseButton(Z)V
    invoke-virtual v2, Lcom/bytedance/trae/update/dialogs/UpdateDialog;->cancel()V
    iget-object v0, v2, Lcom/bytedance/trae/update/dialogs/UpdateDialog;->helper Lcom/ss/android/update/UpdateHelper;
    invoke-virtual v0, Lcom/ss/android/update/UpdateHelper;->isForceUpdate()Z
    move-result v0
    if-eqz v0, +01ah
    iget-object v0, v2, Lcom/bytedance/trae/update/dialogs/UpdateDialog;->iUpdateConfig Lcom/ss/android/update/IUpdateConfig;
    if-eqz v0, +015h
    invoke-interface v0, Lcom/ss/android/update/IUpdateConfig;->getUpdateConfig()Lcom/ss/android/update/UpdateConfig;
    move-result-object v0
    if-eqz v0, +00fh
    invoke-virtual v0, Lcom/ss/android/update/UpdateConfig;->getiUpdateForceExit()Lcom/ss/android/update/IUpdateForceExit;
    move-result-object v0
    if-eqz v0, +009h
    invoke-virtual v2, Lcom/bytedance/trae/update/dialogs/UpdateDialog;->getContext()Landroid/content/Context;
    move-result-object v1
    invoke-interface v0, v1, Lcom/ss/android/update/IUpdateForceExit;->forceExitApp(Landroid/content/Context;)V
    return-void 
    invoke-static Lcom/ss/android/update/UpdateStrategyManager;->getInstance()Lcom/ss/android/update/UpdateStrategyManager;
    move-result-object v0
    invoke-virtual v0, Lcom/ss/android/update/UpdateStrategyManager;->applyUpdateCancel()V
    return-void 
.end method

.method private final confirmClick()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/update/dialogs/UpdateDialog;->helper Lcom/ss/android/update/UpdateHelper;
    invoke-virtual v0, Lcom/ss/android/update/UpdateHelper;->isRealCurrentVersionOut()Z
    move-result v0
    if-nez v0, +003h
    return-void 
    iget-object v0, v2, Lcom/bytedance/trae/update/dialogs/UpdateDialog;->helper Lcom/ss/android/update/UpdateHelper;
    invoke-virtual v0, Lcom/ss/android/update/UpdateHelper;->cancelNotifyAvai()V
    iget-object v0, v2, Lcom/bytedance/trae/update/dialogs/UpdateDialog;->helper Lcom/ss/android/update/UpdateHelper;
    invoke-virtual v0, Lcom/ss/android/update/UpdateHelper;->getUpdateReadyApk()Ljava/io/File;
    move-result-object v0
    if-eqz v0, +00ch
    iget-object v1, v2, Lcom/bytedance/trae/update/dialogs/UpdateDialog;->helper Lcom/ss/android/update/UpdateHelper;
    invoke-virtual v1, Lcom/ss/android/update/UpdateHelper;->isForceUpdate()Z
    move-result v1
    invoke-direct v2, v0, v1, Lcom/bytedance/trae/update/dialogs/UpdateDialog;->installReadyApk(Ljava/io/File; Z)V
    return-void 
    iget-object v0, v2, Lcom/bytedance/trae/update/dialogs/UpdateDialog;->helper Lcom/ss/android/update/UpdateHelper;
    invoke-virtual v0, Lcom/ss/android/update/UpdateHelper;->isForceUpdate()Z
    move-result v0
    invoke-direct v2, v0, Lcom/bytedance/trae/update/dialogs/UpdateDialog;->downloadApkFile(Z)V
    return-void 
.end method

.method private final downloadApkFile(boolean)void
    .registers 5
    # ins_size=2
    invoke-direct v3, Lcom/bytedance/trae/update/dialogs/UpdateDialog;->isNetworkAvailable()Z
    move-result v0
    if-nez v0, +011h
    invoke-virtual v3, Lcom/bytedance/trae/update/dialogs/UpdateDialog;->getContext()Landroid/content/Context;
    move-result-object v4
    sget v0, Lcom/bytedance/trae/update/bits/impl/R$string;->trae_update_network_error I
    const/4 v1, 1
    invoke-static v4, v0, v1, Landroid/widget/Toast;->makeText(Landroid/content/Context; I I)Landroid/widget/Toast;
    move-result-object v4
    invoke-virtual v4, Landroid/widget/Toast;->show()V
    return-void 
    invoke-virtual v3, Lcom/bytedance/trae/update/dialogs/UpdateDialog;->cancel()V
    if-nez v4, +016h
    iget-object v0, v3, Lcom/bytedance/trae/update/dialogs/UpdateDialog;->helper Lcom/ss/android/update/UpdateHelper;
    invoke-virtual v0, Lcom/ss/android/update/UpdateHelper;->startDownload()V
    invoke-virtual v3, Lcom/bytedance/trae/update/dialogs/UpdateDialog;->getContext()Landroid/content/Context;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/update/bits/impl/R$string;->trae_update_downloading_bg I
    const/4 v2, 0
    invoke-static v0, v1, v2, Landroid/widget/Toast;->makeText(Landroid/content/Context; I I)Landroid/widget/Toast;
    move-result-object v0
    invoke-virtual v0, Landroid/widget/Toast;->show()V
    goto +8h
    sget-object v0, Lcom/bytedance/trae/update/dialogs/UpdateMainDialog;->INSTANCE Lcom/bytedance/trae/update/dialogs/UpdateMainDialog;
    iget-boolean v1, v3, Lcom/bytedance/trae/update/dialogs/UpdateDialog;->autoUpdate Z
    invoke-virtual v0, v1, Lcom/bytedance/trae/update/dialogs/UpdateMainDialog;->showProcessDialog(Z)V
    iget-object v0, v3, Lcom/bytedance/trae/update/dialogs/UpdateDialog;->helper Lcom/ss/android/update/UpdateHelper;
    iget-boolean v1, v3, Lcom/bytedance/trae/update/dialogs/UpdateDialog;->autoUpdate Z
    invoke-virtual v0, v1, Lcom/ss/android/update/UpdateHelper;->clickUpdateButton(Z)V
    if-nez v4, +009h
    invoke-static Lcom/ss/android/update/UpdateStrategyManager;->getInstance()Lcom/ss/android/update/UpdateStrategyManager;
    move-result-object v4
    invoke-virtual v4, Lcom/ss/android/update/UpdateStrategyManager;->applyUpdateBySelf()V
    return-void 
.end method

.method private final initAction()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/update/dialogs/UpdateDialog;->btCancel Landroid/widget/TextView;
    if-eqz v0, +00ah
    new-instance v1, Lcom/bytedance/trae/update/dialogs/UpdateDialog$$ExternalSyntheticLambda0;
    invoke-direct v1, v2, Lcom/bytedance/trae/update/dialogs/UpdateDialog$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/update/dialogs/UpdateDialog;)V
    invoke-virtual v0, v1, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v0, v2, Lcom/bytedance/trae/update/dialogs/UpdateDialog;->btConfirm Landroid/widget/TextView;
    if-eqz v0, +00ah
    new-instance v1, Lcom/bytedance/trae/update/dialogs/UpdateDialog$$ExternalSyntheticLambda1;
    invoke-direct v1, v2, Lcom/bytedance/trae/update/dialogs/UpdateDialog$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/update/dialogs/UpdateDialog;)V
    invoke-virtual v0, v1, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method

.method private static final initAction$lambda$0(com.bytedance.trae.update.dialogs.UpdateDialog  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/update/dialogs/UpdateDialog;->cancelClick()V
    return-void 
.end method

.method private static final initAction$lambda$1(com.bytedance.trae.update.dialogs.UpdateDialog  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/update/dialogs/UpdateDialog;->confirmClick()V
    return-void 
.end method

.method private final initUI()void
    .registers 4
    # ins_size=1
    const/4 v0, 1
    invoke-virtual v3, v0, Lcom/bytedance/trae/update/dialogs/UpdateDialog;->requestWindowFeature(I)Z
    sget v0, Lcom/bytedance/trae/update/bits/impl/R$layout;->trae_update_dialog I
    invoke-virtual v3, v0, Lcom/bytedance/trae/update/dialogs/UpdateDialog;->setContentView(I)V
    invoke-virtual v3, Lcom/bytedance/trae/update/dialogs/UpdateDialog;->getWindow()Landroid/view/Window;
    move-result-object v0
    if-eqz v0, +012h
    const v1, 17170445
    invoke-virtual v0, v1, Landroid/view/Window;->setBackgroundDrawableResource(I)V
    const/4 v1, -1
    const/4 v2, -2
    invoke-virtual v0, v1, v2, Landroid/view/Window;->setLayout(I I)V
    const/16 v1, 17
    invoke-virtual v0, v1, Landroid/view/Window;->setGravity(I)V
    const/4 v0, 0
    invoke-virtual v3, v0, Lcom/bytedance/trae/update/dialogs/UpdateDialog;->setCanceledOnTouchOutside(Z)V
    sget v0, Lcom/bytedance/trae/update/bits/impl/R$id;->tvDialogCancel I
    invoke-virtual v3, v0, Lcom/bytedance/trae/update/dialogs/UpdateDialog;->findViewById(I)Landroid/view/View;
    move-result-object v0
    check-cast v0, Landroid/widget/TextView;
    iput-object v0, v3, Lcom/bytedance/trae/update/dialogs/UpdateDialog;->btCancel Landroid/widget/TextView;
    sget v0, Lcom/bytedance/trae/update/bits/impl/R$id;->btnDialogConfirm I
    invoke-virtual v3, v0, Lcom/bytedance/trae/update/dialogs/UpdateDialog;->findViewById(I)Landroid/view/View;
    move-result-object v0
    check-cast v0, Landroid/widget/TextView;
    iput-object v0, v3, Lcom/bytedance/trae/update/dialogs/UpdateDialog;->btConfirm Landroid/widget/TextView;
    sget v0, Lcom/bytedance/trae/update/bits/impl/R$id;->tvDialogContent I
    invoke-virtual v3, v0, Lcom/bytedance/trae/update/dialogs/UpdateDialog;->findViewById(I)Landroid/view/View;
    move-result-object v0
    check-cast v0, Landroid/widget/TextView;
    iput-object v0, v3, Lcom/bytedance/trae/update/dialogs/UpdateDialog;->tvContent Landroid/widget/TextView;
    return-void 
.end method

.method private final installReadyApk(java.io.File  boolean)void
    .registers 5
    # ins_size=3
    iget-object v0, v2, Lcom/bytedance/trae/update/dialogs/UpdateDialog;->helper Lcom/ss/android/update/UpdateHelper;
    invoke-virtual v0, Lcom/ss/android/update/UpdateHelper;->cancelNotifyReady()V
    iget-object v0, v2, Lcom/bytedance/trae/update/dialogs/UpdateDialog;->helper Lcom/ss/android/update/UpdateHelper;
    invoke-virtual v2, Lcom/bytedance/trae/update/dialogs/UpdateDialog;->getContext()Landroid/content/Context;
    move-result-object v1
    invoke-virtual v0, v1, v3, Lcom/ss/android/update/UpdateHelper;->installApk(Landroid/content/Context; Ljava/io/File;)V
    iget-object v3, v2, Lcom/bytedance/trae/update/dialogs/UpdateDialog;->helper Lcom/ss/android/update/UpdateHelper;
    iget-boolean v0, v2, Lcom/bytedance/trae/update/dialogs/UpdateDialog;->autoUpdate Z
    invoke-virtual v3, v0, Lcom/ss/android/update/UpdateHelper;->clickUpdateButton(Z)V
    if-nez v4, +009h
    invoke-static Lcom/ss/android/update/UpdateStrategyManager;->getInstance()Lcom/ss/android/update/UpdateStrategyManager;
    move-result-object v3
    invoke-virtual v3, Lcom/ss/android/update/UpdateStrategyManager;->applyUpdateBySelf()V
    return-void 
.end method

.method private final isNetworkAvailable()boolean
    .registers 4
    # ins_size=1
    invoke-virtual v3, Lcom/bytedance/trae/update/dialogs/UpdateDialog;->getContext()Landroid/content/Context;
    move-result-object v0
    const-string v1, "connectivity"
    invoke-virtual v0, v1, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;
    move-result-object v0
    instance-of v1, v0, Landroid/net/ConnectivityManager;
    if-eqz v1, +005h
    check-cast v0, Landroid/net/ConnectivityManager;
    goto +2h
    const/4 v0, 0
    const/4 v1, 0
    if-nez v0, +003h
    return v1
    invoke-virtual v0, Landroid/net/ConnectivityManager;->getActiveNetwork()Landroid/net/Network;
    move-result-object v2
    if-nez v2, +003h
    return v1
    invoke-virtual v0, v2, Landroid/net/ConnectivityManager;->getNetworkCapabilities(Landroid/net/Network;)Landroid/net/NetworkCapabilities;
    move-result-object v0
    if-nez v0, +003h
    return v1
    const/16 v1, 12
    invoke-virtual v0, v1, Landroid/net/NetworkCapabilities;->hasCapability(I)Z
    move-result v0
    return v0
.end method

.method public final getAutoUpdate()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/update/dialogs/UpdateDialog;->autoUpdate Z
    return v0
.end method

.method public final getCtx()android.content.Context
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/update/dialogs/UpdateDialog;->ctx Landroid/content/Context;
    return-object v0
.end method

.method public onBackPressed()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/update/dialogs/UpdateDialog;->cancelClick()V
    return-void 
.end method

.method protected onCreate(android.os.Bundle)void
    .registers 2
    # ins_size=2
    invoke-super v0, v1, Landroid/app/Dialog;->onCreate(Landroid/os/Bundle;)V
    invoke-direct v0, Lcom/bytedance/trae/update/dialogs/UpdateDialog;->initUI()V
    invoke-direct v0, Lcom/bytedance/trae/update/dialogs/UpdateDialog;->bindData()V
    invoke-direct v0, Lcom/bytedance/trae/update/dialogs/UpdateDialog;->initAction()V
    return-void 
.end method

.method public show()void
    .registers 5
    # ins_size=1
    invoke-super v4, Landroid/app/Dialog;->show()V
    iget-object v0, v4, Lcom/bytedance/trae/update/dialogs/UpdateDialog;->sp Landroid/content/SharedPreferences;
    if-eqz v0, +017h
    invoke-interface v0, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;
    move-result-object v0
    const-string v1, "edit(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "last_show_timestamp"
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v2
    invoke-interface v0, v1, v2, v3, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String; J)Landroid/content/SharedPreferences$Editor;
    invoke-interface v0, Landroid/content/SharedPreferences$Editor;->apply()V
    iget-object v0, v4, Lcom/bytedance/trae/update/dialogs/UpdateDialog;->helper Lcom/ss/android/update/UpdateHelper;
    const/4 v1, 1
    invoke-virtual v0, v1, Lcom/ss/android/update/UpdateHelper;->showUpdateDialogScene(Z)V
    return-void 
.end method
