# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/update/dialogs/UpdateCheckDialog;
.super Ljava/lang/Object;
.source "UpdateCheckDialog.kt"

.implements Lcom/ss/android/update/IUpdateCheckDialog;

.field public static final INSTANCE:Lcom/bytedance/trae/update/dialogs/UpdateCheckDialog;
.field private static final TAG:Ljava/lang/String;
.field private static processDialogWeakRef:Ljava/lang/ref/WeakReference;
.field private static updateDialogWeakRef:Ljava/lang/ref/WeakReference;


.method public static synthetic $r8$lambda$LcDkEIy6DTSvdgrEqGeXzyM48eg(android.content.DialogInterface)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/update/dialogs/UpdateCheckDialog;->showProgressDialog$lambda$3(Landroid/content/DialogInterface;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$t4YK-PzyhB4kK1sbTUrReb82r64(android.content.DialogInterface)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/update/dialogs/UpdateCheckDialog;->showUpdateDialog$lambda$2(Landroid/content/DialogInterface;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/update/dialogs/UpdateCheckDialog;
    invoke-direct v0, Lcom/bytedance/trae/update/dialogs/UpdateCheckDialog;-><init>()V
    sput-object v0, Lcom/bytedance/trae/update/dialogs/UpdateCheckDialog;->INSTANCE Lcom/bytedance/trae/update/dialogs/UpdateCheckDialog;
    const-string v0, "UpdateCheckDialog"
    sput-object v0, Lcom/bytedance/trae/update/dialogs/UpdateCheckDialog;->TAG Ljava/lang/String;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final showCheckFailureDialog()void
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getActivityStackManager()Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;->getCurrentActivity()Landroid/app/Activity;
    move-result-object v0
    if-eqz v0, +015h
    invoke-virtual v0, Landroid/app/Activity;->isFinishing()Z
    move-result v1
    if-eqz v1, +003h
    goto +dh
    check-cast v0, Landroid/content/Context;
    sget v1, Lcom/bytedance/trae/update/bits/impl/R$string;->trae_update_network_error I
    const/4 v2, 0
    invoke-static v0, v1, v2, Landroid/widget/Toast;->makeText(Landroid/content/Context; I I)Landroid/widget/Toast;
    move-result-object v0
    invoke-virtual v0, Landroid/widget/Toast;->show()V
    return-void 
.end method

.method private final showNoUpdateDialog()void
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getActivityStackManager()Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;->getCurrentActivity()Landroid/app/Activity;
    move-result-object v0
    if-eqz v0, +015h
    invoke-virtual v0, Landroid/app/Activity;->isFinishing()Z
    move-result v1
    if-eqz v1, +003h
    goto +dh
    check-cast v0, Landroid/content/Context;
    sget v1, Lcom/bytedance/trae/update/bits/impl/R$string;->trae_update_already_latest I
    const/4 v2, 0
    invoke-static v0, v1, v2, Landroid/widget/Toast;->makeText(Landroid/content/Context; I I)Landroid/widget/Toast;
    move-result-object v0
    invoke-virtual v0, Landroid/widget/Toast;->show()V
    return-void 
.end method

.method private static final showProgressDialog$lambda$3(android.content.DialogInterface)void
    .registers 1
    # ins_size=1
    const/4 v0, 0
    sput-object v0, Lcom/bytedance/trae/update/dialogs/UpdateCheckDialog;->processDialogWeakRef Ljava/lang/ref/WeakReference;
    return-void 
.end method

.method private final showUpdateDialog()void
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getActivityStackManager()Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;->getCurrentActivity()Landroid/app/Activity;
    move-result-object v0
    if-eqz v0, +040h
    invoke-virtual v0, Landroid/app/Activity;->isFinishing()Z
    move-result v1
    if-eqz v1, +003h
    goto +38h
    sget-object v1, Lcom/bytedance/trae/update/dialogs/UpdateCheckDialog;->updateDialogWeakRef Ljava/lang/ref/WeakReference;
    if-eqz v1, +00dh
    invoke-virtual v1, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Landroid/app/Dialog;
    if-eqz v1, +005h
    invoke-virtual v1, Landroid/app/Dialog;->dismiss()V
    sget-object v1, Lcom/bytedance/trae/update/dialogs/UpdateCheckDialog;->processDialogWeakRef Ljava/lang/ref/WeakReference;
    if-eqz v1, +00dh
    invoke-virtual v1, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Landroid/app/Dialog;
    if-eqz v1, +005h
    invoke-virtual v1, Landroid/app/Dialog;->dismiss()V
    new-instance v1, Lcom/bytedance/trae/update/dialogs/ManualCheckUpdateDialog;
    check-cast v0, Landroid/content/Context;
    invoke-direct v1, v0, Lcom/bytedance/trae/update/dialogs/ManualCheckUpdateDialog;-><init>(Landroid/content/Context;)V
    new-instance v0, Lcom/bytedance/trae/update/dialogs/UpdateCheckDialog$$ExternalSyntheticLambda0;
    invoke-direct v0, Lcom/bytedance/trae/update/dialogs/UpdateCheckDialog$$ExternalSyntheticLambda0;-><init>()V
    invoke-virtual v1, v0, Lcom/bytedance/trae/update/dialogs/ManualCheckUpdateDialog;->setOnDismissListener(Landroid/content/DialogInterface$OnDismissListener;)V
    new-instance v0, Ljava/lang/ref/WeakReference;
    invoke-direct v0, v1, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V
    sput-object v0, Lcom/bytedance/trae/update/dialogs/UpdateCheckDialog;->updateDialogWeakRef Ljava/lang/ref/WeakReference;
    invoke-virtual v1, Lcom/bytedance/trae/update/dialogs/ManualCheckUpdateDialog;->show()V
    return-void 
.end method

.method private static final showUpdateDialog$lambda$2(android.content.DialogInterface)void
    .registers 1
    # ins_size=1
    const/4 v0, 0
    sput-object v0, Lcom/bytedance/trae/update/dialogs/UpdateCheckDialog;->updateDialogWeakRef Ljava/lang/ref/WeakReference;
    return-void 
.end method

.method public final getProcessDialogWeakRef()java.lang.ref.WeakReference
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/update/dialogs/UpdateCheckDialog;->processDialogWeakRef Ljava/lang/ref/WeakReference;
    return-object v0
.end method

.method public final getUpdateDialogWeakRef()java.lang.ref.WeakReference
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/update/dialogs/UpdateCheckDialog;->updateDialogWeakRef Ljava/lang/ref/WeakReference;
    return-object v0
.end method

.method public isShowCheckDialog()boolean
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/update/dialogs/UpdateCheckDialog;->updateDialogWeakRef Ljava/lang/ref/WeakReference;
    if-eqz v0, +00fh
    invoke-virtual v0, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Landroid/app/Dialog;
    if-eqz v0, +007h
    invoke-virtual v0, Landroid/app/Dialog;->isShowing()Z
    move-result v0
    goto +2h
    const/4 v0, 0
    if-nez v0, +012h
    sget-object v1, Lcom/bytedance/trae/update/dialogs/UpdateCheckDialog;->processDialogWeakRef Ljava/lang/ref/WeakReference;
    if-eqz v1, +00eh
    invoke-virtual v1, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Landroid/app/Dialog;
    if-eqz v1, +006h
    invoke-virtual v1, Landroid/app/Dialog;->isShowing()Z
    move-result v0
    return v0
.end method

.method public final setProcessDialogWeakRef(java.lang.ref.WeakReference)void
    .registers 2
    # ins_size=2
    sput-object v1, Lcom/bytedance/trae/update/dialogs/UpdateCheckDialog;->processDialogWeakRef Ljava/lang/ref/WeakReference;
    return-void 
.end method

.method public final setUpdateDialogWeakRef(java.lang.ref.WeakReference)void
    .registers 2
    # ins_size=2
    sput-object v1, Lcom/bytedance/trae/update/dialogs/UpdateCheckDialog;->updateDialogWeakRef Ljava/lang/ref/WeakReference;
    return-void 
.end method

.method public showCheckDialog(int)void
    .registers 3
    # ins_size=2
    const/4 v0, -2
    if-eq v2, v0, +011h
    const/4 v0, -1
    if-eq v2, v0, +00ah
    const/4 v0, 1
    if-eq v2, v0, +003h
    goto +ch
    invoke-direct v1, Lcom/bytedance/trae/update/dialogs/UpdateCheckDialog;->showUpdateDialog()V
    goto +8h
    invoke-direct v1, Lcom/bytedance/trae/update/dialogs/UpdateCheckDialog;->showCheckFailureDialog()V
    goto +4h
    invoke-direct v1, Lcom/bytedance/trae/update/dialogs/UpdateCheckDialog;->showNoUpdateDialog()V
    return-void 
.end method

.method public final showProgressDialog()void
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getActivityStackManager()Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;->getCurrentActivity()Landroid/app/Activity;
    move-result-object v0
    if-eqz v0, +023h
    invoke-virtual v0, Landroid/app/Activity;->isFinishing()Z
    move-result v1
    if-eqz v1, +003h
    goto +1bh
    new-instance v1, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;
    check-cast v0, Landroid/content/Context;
    const/4 v2, 1
    invoke-direct v1, v0, v2, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;-><init>(Landroid/content/Context; Z)V
    new-instance v0, Lcom/bytedance/trae/update/dialogs/UpdateCheckDialog$$ExternalSyntheticLambda1;
    invoke-direct v0, Lcom/bytedance/trae/update/dialogs/UpdateCheckDialog$$ExternalSyntheticLambda1;-><init>()V
    invoke-virtual v1, v0, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->setOnDismissListener(Landroid/content/DialogInterface$OnDismissListener;)V
    new-instance v0, Ljava/lang/ref/WeakReference;
    invoke-direct v0, v1, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V
    sput-object v0, Lcom/bytedance/trae/update/dialogs/UpdateCheckDialog;->processDialogWeakRef Ljava/lang/ref/WeakReference;
    invoke-virtual v1, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->show()V
    return-void 
.end method
