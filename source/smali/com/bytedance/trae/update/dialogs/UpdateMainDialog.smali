# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/update/dialogs/UpdateMainDialog;
.super Ljava/lang/Object;
.source "UpdateMainDialog.kt"

.implements Lcom/ss/android/update/IUpdateMainDialog;

.field public static final INSTANCE:Lcom/bytedance/trae/update/dialogs/UpdateMainDialog;
.field private static final TAG:Ljava/lang/String;
.field private static dialogWeakRef:Ljava/lang/ref/WeakReference;
.field private static processDialogWeakRef:Ljava/lang/ref/WeakReference;


.method public static synthetic $r8$lambda$19DhGebD-aVQfggEVQZUrFJBOjI(android.content.DialogInterface)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/update/dialogs/UpdateMainDialog;->showMainDialog$lambda$0(Landroid/content/DialogInterface;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$xneOrHDG9Gf-yS9kyNdQasIyqcA(android.content.DialogInterface)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/update/dialogs/UpdateMainDialog;->showProcessDialog$lambda$1(Landroid/content/DialogInterface;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/update/dialogs/UpdateMainDialog;
    invoke-direct v0, Lcom/bytedance/trae/update/dialogs/UpdateMainDialog;-><init>()V
    sput-object v0, Lcom/bytedance/trae/update/dialogs/UpdateMainDialog;->INSTANCE Lcom/bytedance/trae/update/dialogs/UpdateMainDialog;
    const-string v0, "UpdateMainDialog"
    sput-object v0, Lcom/bytedance/trae/update/dialogs/UpdateMainDialog;->TAG Ljava/lang/String;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private static final showMainDialog$lambda$0(android.content.DialogInterface)void
    .registers 1
    # ins_size=1
    const/4 v0, 0
    sput-object v0, Lcom/bytedance/trae/update/dialogs/UpdateMainDialog;->dialogWeakRef Ljava/lang/ref/WeakReference;
    return-void 
.end method

.method private static final showProcessDialog$lambda$1(android.content.DialogInterface)void
    .registers 1
    # ins_size=1
    const/4 v0, 0
    sput-object v0, Lcom/bytedance/trae/update/dialogs/UpdateMainDialog;->processDialogWeakRef Ljava/lang/ref/WeakReference;
    return-void 
.end method

.method public final getDialogWeakRef()java.lang.ref.WeakReference
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/update/dialogs/UpdateMainDialog;->dialogWeakRef Ljava/lang/ref/WeakReference;
    return-object v0
.end method

.method public final getProcessDialogWeakRef()java.lang.ref.WeakReference
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/update/dialogs/UpdateMainDialog;->processDialogWeakRef Ljava/lang/ref/WeakReference;
    return-object v0
.end method

.method public isAutoUpdate(boolean)void
    .registers 2
    # ins_size=2
    return-void 
.end method

.method public isShowMainDialog()boolean
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/update/dialogs/UpdateMainDialog;->dialogWeakRef Ljava/lang/ref/WeakReference;
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
    sget-object v1, Lcom/bytedance/trae/update/dialogs/UpdateMainDialog;->processDialogWeakRef Ljava/lang/ref/WeakReference;
    if-eqz v1, +00eh
    invoke-virtual v1, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Landroid/app/Dialog;
    if-eqz v1, +006h
    invoke-virtual v1, Landroid/app/Dialog;->isShowing()Z
    move-result v0
    return v0
.end method

.method public final setDialogWeakRef(java.lang.ref.WeakReference)void
    .registers 2
    # ins_size=2
    sput-object v1, Lcom/bytedance/trae/update/dialogs/UpdateMainDialog;->dialogWeakRef Ljava/lang/ref/WeakReference;
    return-void 
.end method

.method public final setProcessDialogWeakRef(java.lang.ref.WeakReference)void
    .registers 2
    # ins_size=2
    sput-object v1, Lcom/bytedance/trae/update/dialogs/UpdateMainDialog;->processDialogWeakRef Ljava/lang/ref/WeakReference;
    return-void 
.end method

.method public showMainDialog(boolean)void
    .registers 8
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    sget-object v1, Lcom/bytedance/trae/update/dialogs/UpdateMainDialog;->TAG Ljava/lang/String;
    const-string v2, "TAG"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v2, Ljava/lang/StringBuilder;
    const-string/jumbo v3, showMainDialog, 
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v7, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", "
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    sget-object v4, Lcom/bytedance/trae/update/dialogs/UpdateMainDialog;->dialogWeakRef Ljava/lang/ref/WeakReference;
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    sget-object v4, Lcom/bytedance/trae/update/dialogs/UpdateMainDialog;->dialogWeakRef Ljava/lang/ref/WeakReference;
    const/4 v5, 0
    if-eqz v4, +013h
    invoke-virtual v4, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Landroid/app/Dialog;
    if-eqz v4, +00bh
    invoke-virtual v4, Landroid/app/Dialog;->isShowing()Z
    move-result v4
    invoke-static v4, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v4
    goto +2h
    move-object v4, v5
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    sget-object v4, Lcom/bytedance/trae/update/dialogs/UpdateMainDialog;->processDialogWeakRef Ljava/lang/ref/WeakReference;
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    sget-object v3, Lcom/bytedance/trae/update/dialogs/UpdateMainDialog;->processDialogWeakRef Ljava/lang/ref/WeakReference;
    if-eqz v3, +012h
    invoke-virtual v3, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Landroid/app/Dialog;
    if-eqz v3, +00ah
    invoke-virtual v3, Landroid/app/Dialog;->isShowing()Z
    move-result v3
    invoke-static v3, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v5
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
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
    sget-object v1, Lcom/bytedance/trae/update/dialogs/UpdateMainDialog;->dialogWeakRef Ljava/lang/ref/WeakReference;
    if-eqz v1, +00dh
    invoke-virtual v1, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Landroid/app/Dialog;
    if-eqz v1, +005h
    invoke-virtual v1, Landroid/app/Dialog;->dismiss()V
    sget-object v1, Lcom/bytedance/trae/update/dialogs/UpdateMainDialog;->processDialogWeakRef Ljava/lang/ref/WeakReference;
    if-eqz v1, +00dh
    invoke-virtual v1, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Landroid/app/Dialog;
    if-eqz v1, +005h
    invoke-virtual v1, Landroid/app/Dialog;->dismiss()V
    new-instance v1, Lcom/bytedance/trae/update/dialogs/UpdateDialog;
    check-cast v0, Landroid/content/Context;
    invoke-direct v1, v0, v7, Lcom/bytedance/trae/update/dialogs/UpdateDialog;-><init>(Landroid/content/Context; Z)V
    new-instance v7, Lcom/bytedance/trae/update/dialogs/UpdateMainDialog$$ExternalSyntheticLambda0;
    invoke-direct v7, Lcom/bytedance/trae/update/dialogs/UpdateMainDialog$$ExternalSyntheticLambda0;-><init>()V
    invoke-virtual v1, v7, Lcom/bytedance/trae/update/dialogs/UpdateDialog;->setOnDismissListener(Landroid/content/DialogInterface$OnDismissListener;)V
    new-instance v7, Ljava/lang/ref/WeakReference;
    invoke-direct v7, v1, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V
    sput-object v7, Lcom/bytedance/trae/update/dialogs/UpdateMainDialog;->dialogWeakRef Ljava/lang/ref/WeakReference;
    invoke-virtual v1, Lcom/bytedance/trae/update/dialogs/UpdateDialog;->show()V
    return-void 
.end method

.method public final showProcessDialog(boolean)void
    .registers 4
    # ins_size=2
    sget-object v3, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getActivityStackManager()Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;
    move-result-object v3
    invoke-interface v3, Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;->getCurrentActivity()Landroid/app/Activity;
    move-result-object v3
    if-eqz v3, +023h
    invoke-virtual v3, Landroid/app/Activity;->isFinishing()Z
    move-result v0
    if-eqz v0, +003h
    goto +1bh
    new-instance v0, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;
    check-cast v3, Landroid/content/Context;
    const/4 v1, 1
    invoke-direct v0, v3, v1, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;-><init>(Landroid/content/Context; Z)V
    new-instance v3, Lcom/bytedance/trae/update/dialogs/UpdateMainDialog$$ExternalSyntheticLambda1;
    invoke-direct v3, Lcom/bytedance/trae/update/dialogs/UpdateMainDialog$$ExternalSyntheticLambda1;-><init>()V
    invoke-virtual v0, v3, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->setOnDismissListener(Landroid/content/DialogInterface$OnDismissListener;)V
    new-instance v3, Ljava/lang/ref/WeakReference;
    invoke-direct v3, v0, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V
    sput-object v3, Lcom/bytedance/trae/update/dialogs/UpdateMainDialog;->processDialogWeakRef Ljava/lang/ref/WeakReference;
    invoke-virtual v0, Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;->show()V
    return-void 
.end method
