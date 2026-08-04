# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/praise/PraiseDialogHelper$registerCustomDialogCallback$1;
.super Ljava/lang/Object;
.source "PraiseDialogHelper.kt"

.implements Lcom/bytedance/praisedialoglib/callback/IPraiseDialogActionCallback;


.method public static synthetic $r8$lambda$5AsoHzkG8gqMzGRSGtf9Gbgh2wQ(com.bytedance.praisedialoglib.callback.IPraiseDialogCallback)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/praise/PraiseDialogHelper$registerCustomDialogCallback$1;->onPraiseDialogShow$lambda$0(Lcom/bytedance/praisedialoglib/callback/IPraiseDialogCallback;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$bMrSNiwLsb6JHMo0OW5pXAK1NHQ(com.bytedance.praisedialoglib.callback.IPraiseDialogCallback  android.content.DialogInterface)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/praise/PraiseDialogHelper$registerCustomDialogCallback$1;->onPraiseDialogShow$lambda$2(Lcom/bytedance/praisedialoglib/callback/IPraiseDialogCallback; Landroid/content/DialogInterface;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$msReLjYk9ZPI-jL4DfEdUO4p2-k(com.bytedance.praisedialoglib.callback.IPraiseDialogCallback)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/praise/PraiseDialogHelper$registerCustomDialogCallback$1;->onPraiseDialogShow$lambda$1(Lcom/bytedance/praisedialoglib/callback/IPraiseDialogCallback;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$qsrDSuPU_YzA-vU9QmDBxwcoC00(com.bytedance.praisedialoglib.callback.IPraiseDialogCallback  android.content.DialogInterface)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/praise/PraiseDialogHelper$registerCustomDialogCallback$1;->onPraiseDialogShow$lambda$3(Lcom/bytedance/praisedialoglib/callback/IPraiseDialogCallback; Landroid/content/DialogInterface;)V
    return-void 
.end method

.method constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private static final onPraiseDialogShow$lambda$0(com.bytedance.praisedialoglib.callback.IPraiseDialogCallback)kotlin.Unit
    .registers 1
    # ins_size=1
    if-eqz v0, +005h
    invoke-interface v0, Lcom/bytedance/praisedialoglib/callback/IPraiseDialogCallback;->onPraiseBtnClick()V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final onPraiseDialogShow$lambda$1(com.bytedance.praisedialoglib.callback.IPraiseDialogCallback)kotlin.Unit
    .registers 1
    # ins_size=1
    if-eqz v0, +005h
    invoke-interface v0, Lcom/bytedance/praisedialoglib/callback/IPraiseDialogCallback;->onFeedbackBtnClick()V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final onPraiseDialogShow$lambda$2(com.bytedance.praisedialoglib.callback.IPraiseDialogCallback  android.content.DialogInterface)void
    .registers 2
    # ins_size=2
    if-eqz v0, +005h
    invoke-interface v0, Lcom/bytedance/praisedialoglib/callback/IPraiseDialogCallback;->onDialogShow()V
    return-void 
.end method

.method private static final onPraiseDialogShow$lambda$3(com.bytedance.praisedialoglib.callback.IPraiseDialogCallback  android.content.DialogInterface)void
    .registers 2
    # ins_size=2
    if-eqz v0, +005h
    invoke-interface v0, Lcom/bytedance/praisedialoglib/callback/IPraiseDialogCallback;->onDialogDismiss()V
    return-void 
.end method

.method public onPraiseDialogShow(com.bytedance.praisedialoglib.callback.IPraiseDialogCallback)void
    .registers 7
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getActivityStackManager()Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;->getCurrentActivity()Landroid/app/Activity;
    move-result-object v0
    const-string v1, "Praise"
    if-eqz v0, +03ch
    invoke-virtual v0, Landroid/app/Activity;->isFinishing()Z
    move-result v2
    if-nez v2, +036h
    invoke-virtual v0, Landroid/app/Activity;->isDestroyed()Z
    move-result v2
    if-eqz v2, +003h
    goto +2eh
    new-instance v2, Lcom/bytedance/trae/praise/PraiseDialog;
    check-cast v0, Landroid/content/Context;
    new-instance v3, Lcom/bytedance/trae/praise/PraiseDialogHelper$registerCustomDialogCallback$1$$ExternalSyntheticLambda0;
    invoke-direct v3, v6, Lcom/bytedance/trae/praise/PraiseDialogHelper$registerCustomDialogCallback$1$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/praisedialoglib/callback/IPraiseDialogCallback;)V
    new-instance v4, Lcom/bytedance/trae/praise/PraiseDialogHelper$registerCustomDialogCallback$1$$ExternalSyntheticLambda1;
    invoke-direct v4, v6, Lcom/bytedance/trae/praise/PraiseDialogHelper$registerCustomDialogCallback$1$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/praisedialoglib/callback/IPraiseDialogCallback;)V
    invoke-direct v2, v0, v3, v4, Lcom/bytedance/trae/praise/PraiseDialog;-><init>(Landroid/content/Context; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0;)V
    new-instance v0, Lcom/bytedance/trae/praise/PraiseDialogHelper$registerCustomDialogCallback$1$$ExternalSyntheticLambda2;
    invoke-direct v0, v6, Lcom/bytedance/trae/praise/PraiseDialogHelper$registerCustomDialogCallback$1$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/praisedialoglib/callback/IPraiseDialogCallback;)V
    invoke-virtual v2, v0, Lcom/bytedance/trae/praise/PraiseDialog;->setOnShowListener(Landroid/content/DialogInterface$OnShowListener;)V
    new-instance v0, Lcom/bytedance/trae/praise/PraiseDialogHelper$registerCustomDialogCallback$1$$ExternalSyntheticLambda3;
    invoke-direct v0, v6, Lcom/bytedance/trae/praise/PraiseDialogHelper$registerCustomDialogCallback$1$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/praisedialoglib/callback/IPraiseDialogCallback;)V
    invoke-virtual v2, v0, Lcom/bytedance/trae/praise/PraiseDialog;->setOnDismissListener(Landroid/content/DialogInterface$OnDismissListener;)V
    invoke-virtual v2, Lcom/bytedance/trae/praise/PraiseDialog;->show()V
    sget-object v6, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string/jumbo v0, registerCustomDialogCallback: PraiseDialog shown
    invoke-virtual v6, v1, v0, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    sget-object v6, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string/jumbo v0, registerCustomDialogCallback: activity is null, skip showing dialog
    invoke-virtual v6, v1, v0, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method
