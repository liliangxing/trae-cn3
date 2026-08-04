# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;
.super Landroid/app/Dialog;
.source "UpdateProcessDialog.kt"

.field public static final Companion:Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog$Companion;
.field public static final MESSAGE_DOWNLOAD_RESULT:I
.field public static final MESSAGE_REFRESH_PROGRESS:I
.field public static final TAG:Ljava/lang/String;
.field private final autoUpdate:Z
.field private final ctx:Landroid/content/Context;
.field private downloadInfo:Lcom/ss/android/update/DownloadInfo;
.field private handler:Landroid/os/Handler;
.field private helper:Lcom/ss/android/update/UpdateHelper;
.field private iUpdateConfig:Lcom/ss/android/update/IUpdateConfig;
.field private listener:Lcom/ss/android/update/OnUpdateStatusChangedListener;
.field private progressBar:Landroid/widget/ProgressBar;
.field private tvHintButton:Landroid/widget/TextView;
.field private tvProgressPercent:Landroid/widget/TextView;
.field private tvTitle:Landroid/widget/TextView;


.method public static synthetic $r8$lambda$DARb79MbzwrU6tXXYPE-qdMNGEg(com.bytedance.trae.update.dialogs.UpdateProcessDialog  android.os.Message)boolean
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->handler$lambda$0(Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog; Landroid/os/Message;)Z
    move-result v0
    return v0
.end method

.method public static synthetic $r8$lambda$DSoGh2cUs3SrlYqP7asuwwPiT4M(com.bytedance.trae.update.dialogs.UpdateProcessDialog  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->initAction$lambda$8(Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$OcvjaOlG35pM_1lLTCycIkYeD4w(com.bytedance.trae.update.dialogs.UpdateProcessDialog  android.content.DialogInterface)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->initAction$lambda$6(Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog; Landroid/content/DialogInterface;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->Companion Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog$Companion;
    return-void 
.end method

.method public constructor <init>(android.content.Context  boolean)void
    .registers 4
    # ins_size=3
    const-string v0, "ctx"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, Landroid/app/Dialog;-><init>(Landroid/content/Context;)V
    iput-object v2, v1, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->ctx Landroid/content/Context;
    iput-boolean v3, v1, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->autoUpdate Z
    new-instance v2, Landroid/os/Handler;
    invoke-static Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;
    move-result-object v3
    new-instance v0, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog$$ExternalSyntheticLambda2;
    invoke-direct v0, v1, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;)V
    invoke-direct v2, v3, v0, Landroid/os/Handler;-><init>(Landroid/os/Looper; Landroid/os/Handler$Callback;)V
    iput-object v2, v1, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->handler Landroid/os/Handler;
    invoke-static Lcom/ss/android/update/UpdateHelper;->getInstance()Lcom/ss/android/update/UpdateHelper;
    move-result-object v2
    const-string v3, "getInstance(...)"
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v1, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->helper Lcom/ss/android/update/UpdateHelper;
    new-instance v2, Lcom/ss/android/update/DownloadInfo;
    invoke-direct v2, Lcom/ss/android/update/DownloadInfo;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->downloadInfo Lcom/ss/android/update/DownloadInfo;
    return-void 
.end method

.method public static final synthetic access$calculateProgress(com.bytedance.trae.update.dialogs.UpdateProcessDialog  int  int)int
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->calculateProgress(I I)I
    move-result v0
    return v0
.end method

.method public static final synthetic access$getHandler$p(com.bytedance.trae.update.dialogs.UpdateProcessDialog)android.os.Handler
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->handler Landroid/os/Handler;
    return-object v0
.end method

.method private final bindData()void
    .registers 3
    # ins_size=1
    invoke-static Lcom/ss/android/update/UpdateHelper;->getInstance()Lcom/ss/android/update/UpdateHelper;
    move-result-object v0
    const-string v1, "getInstance(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v0, v2, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->helper Lcom/ss/android/update/UpdateHelper;
    invoke-static Lcom/ss/android/update/UpdateSDK;->getConfig()Lcom/ss/android/update/IUpdateConfig;
    move-result-object v0
    iput-object v0, v2, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->iUpdateConfig Lcom/ss/android/update/IUpdateConfig;
    new-instance v0, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog$bindData$1;
    invoke-direct v0, v2, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog$bindData$1;-><init>(Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;)V
    check-cast v0, Lcom/ss/android/update/OnUpdateStatusChangedListener;
    iput-object v0, v2, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->listener Lcom/ss/android/update/OnUpdateStatusChangedListener;
    iget-object v1, v2, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->helper Lcom/ss/android/update/UpdateHelper;
    invoke-virtual v1, v0, Lcom/ss/android/update/UpdateHelper;->addUpdateStatusListener(Lcom/ss/android/update/OnUpdateStatusChangedListener;)V
    return-void 
.end method

.method private final calculateProgress(int  int)int
    .registers 4
    # ins_size=3
    if-ltz v2, +011h
    if-gtz v3, +003h
    goto +dh
    int-to-float v2, v2
    int-to-float v3, v3
    div-float/2addr v2, v3
    const/16 v3, 100
    int-to-float v0, v3
    mul-float/2addr v2, v0
    float-to-int v2, v2
    if-le v2, v3, +003h
    return v3
    return v2
    const/4 v2, 0
    return v2
.end method

.method private final formatSize(int)java.lang.String
    .registers 6
    # ins_size=2
    int-to-double v0, v5
    const-wide/high16 v2, 4697254411347427328
    div-double/2addr v0, v2
    sget-object v5, Lkotlin/jvm/internal/StringCompanionObject;->INSTANCE Lkotlin/jvm/internal/StringCompanionObject;
    const/4 v5, 1
    new-array v2, v5, [Ljava/lang/Object;
    const/4 v3, 0
    invoke-static v0, v1, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;
    move-result-object v0
    aput-object v0, v2, v3
    invoke-static v2, v5, Ljava/util/Arrays;->copyOf([Ljava/lang/Object; I)[Ljava/lang/Object;
    move-result-object v5
    const-string v0, "%.1f MB"
    invoke-static v0, v5, Ljava/lang/String;->format(Ljava/lang/String; [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v5
    const-string v0, "format(...)"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v5
.end method

.method private final handleMsg(android.os.Message)void
    .registers 5
    # ins_size=2
    iget v0, v4, Landroid/os/Message;->what I
    const/4 v1, 1
    const-string/jumbo v2, null cannot be cast to non-null type com.ss.android.update.DownloadInfo
    if-eq v0, v1, +013h
    const/4 v1, 2
    if-eq v0, v1, +003h
    goto +1ah
    iget-object v4, v4, Landroid/os/Message;->obj Ljava/lang/Object;
    invoke-static v4, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v4, Lcom/ss/android/update/DownloadInfo;
    iput-object v4, v3, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->downloadInfo Lcom/ss/android/update/DownloadInfo;
    invoke-direct v3, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->updateUI()V
    goto +dh
    iget-object v4, v4, Landroid/os/Message;->obj Ljava/lang/Object;
    invoke-static v4, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v4, Lcom/ss/android/update/DownloadInfo;
    iput-object v4, v3, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->downloadInfo Lcom/ss/android/update/DownloadInfo;
    invoke-direct v3, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->updateUI()V
    return-void 
.end method

.method private static final handler$lambda$0(com.bytedance.trae.update.dialogs.UpdateProcessDialog  android.os.Message)boolean
    .registers 3
    # ins_size=2
    const-string v0, "msg"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->handleMsg(Landroid/os/Message;)V
    const/4 v1, 1
    return v1
.end method

.method private final initAction()void
    .registers 3
    # ins_size=1
    new-instance v0, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog$$ExternalSyntheticLambda0;
    invoke-direct v0, v2, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;)V
    invoke-virtual v2, v0, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->setOnDismissListener(Landroid/content/DialogInterface$OnDismissListener;)V
    iget-object v0, v2, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->tvHintButton Landroid/widget/TextView;
    if-eqz v0, +00ah
    new-instance v1, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog$$ExternalSyntheticLambda1;
    invoke-direct v1, v2, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;)V
    invoke-virtual v0, v1, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    invoke-direct v2, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->startDownload()V
    return-void 
.end method

.method private static final initAction$lambda$6(com.bytedance.trae.update.dialogs.UpdateProcessDialog  android.content.DialogInterface)void
    .registers 2
    # ins_size=2
    iget-object v1, v0, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->listener Lcom/ss/android/update/OnUpdateStatusChangedListener;
    if-eqz v1, +007h
    iget-object v0, v0, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->helper Lcom/ss/android/update/UpdateHelper;
    invoke-virtual v0, v1, Lcom/ss/android/update/UpdateHelper;->removeUpdateStatusListener(Lcom/ss/android/update/OnUpdateStatusChangedListener;)V
    return-void 
.end method

.method private static final initAction$lambda$8(com.bytedance.trae.update.dialogs.UpdateProcessDialog  android.view.View)void
    .registers 4
    # ins_size=2
    iget-object v3, v2, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->downloadInfo Lcom/ss/android/update/DownloadInfo;
    iget v3, v3, Lcom/ss/android/update/DownloadInfo;->status I
    if-eqz v3, +04fh
    const/4 v0, 1
    if-eq v3, v0, +04ch
    const/4 v1, 2
    if-eq v3, v1, +025h
    const/4 v0, 3
    if-eq v3, v0, +003h
    goto +68h
    iget-object v3, v2, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->helper Lcom/ss/android/update/UpdateHelper;
    invoke-virtual v3, Lcom/ss/android/update/UpdateHelper;->getUpdateReadyApk()Ljava/io/File;
    move-result-object v3
    if-eqz v3, +00bh
    iget-object v0, v2, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->helper Lcom/ss/android/update/UpdateHelper;
    invoke-virtual v2, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->getContext()Landroid/content/Context;
    move-result-object v1
    invoke-virtual v0, v1, v3, Lcom/ss/android/update/UpdateHelper;->installApk(Landroid/content/Context; Ljava/io/File;)V
    invoke-static Lcom/ss/android/update/UpdateHelper;->getInstance()Lcom/ss/android/update/UpdateHelper;
    move-result-object v3
    invoke-virtual v3, Lcom/ss/android/update/UpdateHelper;->isForceUpdate()Z
    move-result v3
    if-nez v3, +04eh
    invoke-virtual v2, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->cancel()V
    goto +49h
    invoke-direct v2, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->isNetworkAvailable()Z
    move-result v3
    if-nez v3, +010h
    invoke-virtual v2, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->getContext()Landroid/content/Context;
    move-result-object v2
    sget v3, Lcom/bytedance/trae/update/bits/impl/R$string;->trae_update_network_error I
    invoke-static v2, v3, v0, Landroid/widget/Toast;->makeText(Landroid/content/Context; I I)Landroid/widget/Toast;
    move-result-object v2
    invoke-virtual v2, Landroid/widget/Toast;->show()V
    return-void 
    new-instance v3, Lcom/ss/android/update/DownloadInfo;
    invoke-direct v3, Lcom/ss/android/update/DownloadInfo;-><init>()V
    iput-object v3, v2, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->downloadInfo Lcom/ss/android/update/DownloadInfo;
    iput v0, v3, Lcom/ss/android/update/DownloadInfo;->status I
    invoke-direct v2, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->startDownload()V
    invoke-direct v2, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->updateUI()V
    goto +25h
    invoke-virtual v2, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->cancel()V
    invoke-static Lcom/ss/android/update/UpdateHelper;->getInstance()Lcom/ss/android/update/UpdateHelper;
    move-result-object v3
    invoke-virtual v3, Lcom/ss/android/update/UpdateHelper;->isForceUpdate()Z
    move-result v3
    if-eqz v3, +019h
    iget-object v3, v2, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->iUpdateConfig Lcom/ss/android/update/IUpdateConfig;
    if-eqz v3, +015h
    invoke-interface v3, Lcom/ss/android/update/IUpdateConfig;->getUpdateConfig()Lcom/ss/android/update/UpdateConfig;
    move-result-object v3
    if-eqz v3, +00fh
    invoke-virtual v3, Lcom/ss/android/update/UpdateConfig;->getiUpdateForceExit()Lcom/ss/android/update/IUpdateForceExit;
    move-result-object v3
    if-eqz v3, +009h
    invoke-virtual v2, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->getContext()Landroid/content/Context;
    move-result-object v2
    invoke-interface v3, v2, Lcom/ss/android/update/IUpdateForceExit;->forceExitApp(Landroid/content/Context;)V
    return-void 
.end method

.method private final initUI()void
    .registers 4
    # ins_size=1
    const/4 v0, 1
    invoke-virtual v3, v0, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->requestWindowFeature(I)Z
    sget v0, Lcom/bytedance/trae/update/bits/impl/R$layout;->trae_update_progress_dialog I
    invoke-virtual v3, v0, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->setContentView(I)V
    invoke-virtual v3, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->getWindow()Landroid/view/Window;
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
    invoke-virtual v3, v0, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->setCanceledOnTouchOutside(Z)V
    sget v0, Lcom/bytedance/trae/update/bits/impl/R$id;->tvDialogTitle I
    invoke-virtual v3, v0, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->findViewById(I)Landroid/view/View;
    move-result-object v0
    check-cast v0, Landroid/widget/TextView;
    iput-object v0, v3, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->tvTitle Landroid/widget/TextView;
    sget v0, Lcom/bytedance/trae/update/bits/impl/R$id;->tv_update_hint I
    invoke-virtual v3, v0, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->findViewById(I)Landroid/view/View;
    move-result-object v0
    check-cast v0, Landroid/widget/TextView;
    iput-object v0, v3, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->tvHintButton Landroid/widget/TextView;
    sget v0, Lcom/bytedance/trae/update/bits/impl/R$id;->tvProgressPercent I
    invoke-virtual v3, v0, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->findViewById(I)Landroid/view/View;
    move-result-object v0
    check-cast v0, Landroid/widget/TextView;
    iput-object v0, v3, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->tvProgressPercent Landroid/widget/TextView;
    sget v0, Lcom/bytedance/trae/update/bits/impl/R$id;->updateProgressBar I
    invoke-virtual v3, v0, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->findViewById(I)Landroid/view/View;
    move-result-object v0
    check-cast v0, Landroid/widget/ProgressBar;
    iput-object v0, v3, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->progressBar Landroid/widget/ProgressBar;
    return-void 
.end method

.method private final isNetworkAvailable()boolean
    .registers 4
    # ins_size=1
    invoke-virtual v3, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->getContext()Landroid/content/Context;
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

.method private final startDownload()void
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->helper Lcom/ss/android/update/UpdateHelper;
    invoke-virtual v0, Lcom/ss/android/update/UpdateHelper;->startDownload()V
    return-void 
.end method

.method private final updateUI()void
    .registers 6
    # ins_size=1
    iget-object v0, v5, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->downloadInfo Lcom/ss/android/update/DownloadInfo;
    iget v0, v0, Lcom/ss/android/update/DownloadInfo;->status I
    const/4 v1, 1
    if-eqz v0, +0b2h
    if-eq v0, v1, +0b0h
    const/4 v1, 2
    const-string v2, ""
    const/4 v3, -1
    if-eq v0, v1, +059h
    const/4 v1, 3
    if-eq v0, v1, +004h
    goto/16 +169h
    iget-object v0, v5, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->tvTitle Landroid/widget/TextView;
    if-eqz v0, +015h
    invoke-virtual v5, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->getContext()Landroid/content/Context;
    move-result-object v1
    invoke-virtual v1, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v1
    sget v4, Lcom/bytedance/trae/update/bits/impl/R$string;->trae_update_download_completed I
    invoke-virtual v1, v4, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v0, v1, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v0, v5, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->tvHintButton Landroid/widget/TextView;
    if-eqz v0, +015h
    invoke-virtual v5, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->getContext()Landroid/content/Context;
    move-result-object v1
    invoke-virtual v1, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v1
    sget v4, Lcom/bytedance/trae/update/bits/impl/R$string;->trae_update_install I
    invoke-virtual v1, v4, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v0, v1, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v0, v5, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->tvHintButton Landroid/widget/TextView;
    if-eqz v0, +007h
    sget v1, Lcom/bytedance/trae/update/bits/impl/R$drawable;->trae_update_btn_bg I
    invoke-virtual v0, v1, Landroid/widget/TextView;->setBackgroundResource(I)V
    iget-object v0, v5, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->tvHintButton Landroid/widget/TextView;
    if-eqz v0, +005h
    invoke-virtual v0, v3, Landroid/widget/TextView;->setTextColor(I)V
    iget-object v0, v5, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->tvProgressPercent Landroid/widget/TextView;
    if-eqz v0, +007h
    check-cast v2, Ljava/lang/CharSequence;
    invoke-virtual v0, v2, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v0, v5, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->progressBar Landroid/widget/ProgressBar;
    if-eqz v0, +11eh
    const/16 v1, 100
    invoke-virtual v0, v1, Landroid/widget/ProgressBar;->setProgress(I)V
    goto/16 +117h
    iget-object v0, v5, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->tvTitle Landroid/widget/TextView;
    if-eqz v0, +015h
    invoke-virtual v5, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->getContext()Landroid/content/Context;
    move-result-object v1
    invoke-virtual v1, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v1
    sget v4, Lcom/bytedance/trae/update/bits/impl/R$string;->trae_update_download_failed I
    invoke-virtual v1, v4, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v0, v1, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v0, v5, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->tvHintButton Landroid/widget/TextView;
    if-eqz v0, +015h
    invoke-virtual v5, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->getContext()Landroid/content/Context;
    move-result-object v1
    invoke-virtual v1, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v1
    sget v4, Lcom/bytedance/trae/update/bits/impl/R$string;->trae_update_retry I
    invoke-virtual v1, v4, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v0, v1, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v0, v5, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->tvHintButton Landroid/widget/TextView;
    if-eqz v0, +007h
    sget v1, Lcom/bytedance/trae/update/bits/impl/R$drawable;->trae_update_btn_bg I
    invoke-virtual v0, v1, Landroid/widget/TextView;->setBackgroundResource(I)V
    iget-object v0, v5, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->tvHintButton Landroid/widget/TextView;
    if-eqz v0, +005h
    invoke-virtual v0, v3, Landroid/widget/TextView;->setTextColor(I)V
    iget-object v0, v5, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->tvProgressPercent Landroid/widget/TextView;
    if-eqz v0, +007h
    check-cast v2, Ljava/lang/CharSequence;
    invoke-virtual v0, v2, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v0, v5, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->progressBar Landroid/widget/ProgressBar;
    if-eqz v0, +0cch
    const/4 v1, 0
    invoke-virtual v0, v1, Landroid/widget/ProgressBar;->setProgress(I)V
    goto/16 +0c6h
    iget-object v0, v5, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->downloadInfo Lcom/ss/android/update/DownloadInfo;
    iget v0, v0, Lcom/ss/android/update/DownloadInfo;->byteSoFar I
    iget-object v2, v5, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->downloadInfo Lcom/ss/android/update/DownloadInfo;
    iget v2, v2, Lcom/ss/android/update/DownloadInfo;->contentLength I
    invoke-direct v5, v0, v2, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->calculateProgress(I I)I
    move-result v0
    iget-object v2, v5, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->tvTitle Landroid/widget/TextView;
    if-eqz v2, +015h
    invoke-virtual v5, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->getContext()Landroid/content/Context;
    move-result-object v3
    invoke-virtual v3, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v3
    sget v4, Lcom/bytedance/trae/update/bits/impl/R$string;->trae_update_downloading I
    invoke-virtual v3, v4, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;
    move-result-object v3
    check-cast v3, Ljava/lang/CharSequence;
    invoke-virtual v2, v3, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-static Lcom/ss/android/update/UpdateHelper;->getInstance()Lcom/ss/android/update/UpdateHelper;
    move-result-object v2
    invoke-virtual v2, Lcom/ss/android/update/UpdateHelper;->isForceUpdate()Z
    move-result v2
    if-eqz v2, +005h
    sget v2, Lcom/bytedance/trae/update/bits/impl/R$string;->trae_update_quit I
    goto +3h
    sget v2, Lcom/bytedance/trae/update/bits/impl/R$string;->trae_update_ok I
    iget-object v3, v5, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->tvHintButton Landroid/widget/TextView;
    if-eqz v3, +013h
    invoke-virtual v5, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->getContext()Landroid/content/Context;
    move-result-object v4
    invoke-virtual v4, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v4
    invoke-virtual v4, v2, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;
    move-result-object v2
    check-cast v2, Ljava/lang/CharSequence;
    invoke-virtual v3, v2, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v2, v5, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->tvHintButton Landroid/widget/TextView;
    if-eqz v2, +007h
    sget v3, Lcom/bytedance/trae/update/bits/impl/R$drawable;->trae_update_btn_bg_secondary I
    invoke-virtual v2, v3, Landroid/widget/TextView;->setBackgroundResource(I)V
    iget-object v2, v5, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->tvHintButton Landroid/widget/TextView;
    if-eqz v2, +008h
    const v3, -10066330
    invoke-virtual v2, v3, Landroid/widget/TextView;->setTextColor(I)V
    iget-object v2, v5, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->progressBar Landroid/widget/ProgressBar;
    if-eqz v2, +005h
    invoke-virtual v2, v0, v1, Landroid/widget/ProgressBar;->setProgress(I Z)V
    iget-object v1, v5, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->downloadInfo Lcom/ss/android/update/DownloadInfo;
    iget v1, v1, Lcom/ss/android/update/DownloadInfo;->contentLength I
    if-lez v1, +043h
    iget-object v1, v5, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->tvProgressPercent Landroid/widget/TextView;
    if-eqz v1, +05bh
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, Ljava/lang/StringBuilder;-><init>()V
    iget-object v3, v5, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->downloadInfo Lcom/ss/android/update/DownloadInfo;
    iget v3, v3, Lcom/ss/android/update/DownloadInfo;->byteSoFar I
    invoke-direct v5, v3, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->formatSize(I)Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, " / "
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    iget-object v3, v5, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->downloadInfo Lcom/ss/android/update/DownloadInfo;
    iget v3, v3, Lcom/ss/android/update/DownloadInfo;->contentLength I
    invoke-direct v5, v3, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->formatSize(I)Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, "  ("
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v0, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v2, "%)"
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v1, v0, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    goto +1dh
    iget-object v1, v5, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->tvProgressPercent Landroid/widget/TextView;
    if-eqz v1, +01ah
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v2, v0, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v2, 37
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v1, v0, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    return-void 
.end method

.method public final getAutoUpdate()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->autoUpdate Z
    return v0
.end method

.method public final getCtx()android.content.Context
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->ctx Landroid/content/Context;
    return-object v0
.end method

.method public onBackPressed()void
    .registers 3
    # ins_size=1
    invoke-super v2, Landroid/app/Dialog;->onBackPressed()V
    invoke-static Lcom/ss/android/update/UpdateHelper;->getInstance()Lcom/ss/android/update/UpdateHelper;
    move-result-object v0
    invoke-virtual v0, Lcom/ss/android/update/UpdateHelper;->isForceUpdate()Z
    move-result v0
    if-eqz v0, +019h
    iget-object v0, v2, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->iUpdateConfig Lcom/ss/android/update/IUpdateConfig;
    if-eqz v0, +015h
    invoke-interface v0, Lcom/ss/android/update/IUpdateConfig;->getUpdateConfig()Lcom/ss/android/update/UpdateConfig;
    move-result-object v0
    if-eqz v0, +00fh
    invoke-virtual v0, Lcom/ss/android/update/UpdateConfig;->getiUpdateForceExit()Lcom/ss/android/update/IUpdateForceExit;
    move-result-object v0
    if-eqz v0, +009h
    invoke-virtual v2, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->getContext()Landroid/content/Context;
    move-result-object v1
    invoke-interface v0, v1, Lcom/ss/android/update/IUpdateForceExit;->forceExitApp(Landroid/content/Context;)V
    return-void 
.end method

.method protected onCreate(android.os.Bundle)void
    .registers 3
    # ins_size=2
    invoke-super v1, v2, Landroid/app/Dialog;->onCreate(Landroid/os/Bundle;)V
    invoke-direct v1, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->initUI()V
    invoke-direct v1, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->bindData()V
    invoke-direct v1, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->initAction()V
    invoke-static Lcom/ss/android/update/UpdateHelper;->getInstance()Lcom/ss/android/update/UpdateHelper;
    move-result-object v2
    iget-object v0, v1, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->downloadInfo Lcom/ss/android/update/DownloadInfo;
    invoke-virtual v2, v0, Lcom/ss/android/update/UpdateHelper;->getProgress(Lcom/ss/android/update/DownloadInfo;)V
    invoke-direct v1, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->updateUI()V
    return-void 
.end method
