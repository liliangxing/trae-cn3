# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/login/DeviceOverLimitDialog$launchClearRefreshToken$1$2$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "DeviceOverLimitDialog.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $activity:Landroid/app/Activity;
.field final synthetic $adapter:Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter;
.field final synthetic $binding:Lcom/bytedance/trae/login/databinding/TraeDialogDeviceOverLimitBinding;
.field final synthetic $deviceId:Ljava/lang/String;
.field final synthetic $maxDeviceCount:I
.field  label:I


.method constructor <init>(com.bytedance.trae.login.DeviceOverLimitDeviceAdapter  java.lang.String  int  com.bytedance.trae.login.databinding.TraeDialogDeviceOverLimitBinding  android.app.Activity  kotlin.coroutines.Continuation)void
    .registers 7
    # ins_size=7
    iput-object v1, v0, Lcom/bytedance/trae/login/DeviceOverLimitDialog$launchClearRefreshToken$1$2$1;->$adapter Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter;
    iput-object v2, v0, Lcom/bytedance/trae/login/DeviceOverLimitDialog$launchClearRefreshToken$1$2$1;->$deviceId Ljava/lang/String;
    iput v3, v0, Lcom/bytedance/trae/login/DeviceOverLimitDialog$launchClearRefreshToken$1$2$1;->$maxDeviceCount I
    iput-object v4, v0, Lcom/bytedance/trae/login/DeviceOverLimitDialog$launchClearRefreshToken$1$2$1;->$binding Lcom/bytedance/trae/login/databinding/TraeDialogDeviceOverLimitBinding;
    iput-object v5, v0, Lcom/bytedance/trae/login/DeviceOverLimitDialog$launchClearRefreshToken$1$2$1;->$activity Landroid/app/Activity;
    const/4 v1, 2
    invoke-direct v0, v1, v6, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 10
    # ins_size=3
    new-instance v8, Lcom/bytedance/trae/login/DeviceOverLimitDialog$launchClearRefreshToken$1$2$1;
    iget-object v1, v7, Lcom/bytedance/trae/login/DeviceOverLimitDialog$launchClearRefreshToken$1$2$1;->$adapter Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter;
    iget-object v2, v7, Lcom/bytedance/trae/login/DeviceOverLimitDialog$launchClearRefreshToken$1$2$1;->$deviceId Ljava/lang/String;
    iget v3, v7, Lcom/bytedance/trae/login/DeviceOverLimitDialog$launchClearRefreshToken$1$2$1;->$maxDeviceCount I
    iget-object v4, v7, Lcom/bytedance/trae/login/DeviceOverLimitDialog$launchClearRefreshToken$1$2$1;->$binding Lcom/bytedance/trae/login/databinding/TraeDialogDeviceOverLimitBinding;
    iget-object v5, v7, Lcom/bytedance/trae/login/DeviceOverLimitDialog$launchClearRefreshToken$1$2$1;->$activity Landroid/app/Activity;
    move-object v0, v8
    move-object v6, v9
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/login/DeviceOverLimitDialog$launchClearRefreshToken$1$2$1;-><init>(Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter; Ljava/lang/String; I Lcom/bytedance/trae/login/databinding/TraeDialogDeviceOverLimitBinding; Landroid/app/Activity; Lkotlin/coroutines/Continuation;)V
    check-cast v8, Lkotlin/coroutines/Continuation;
    return-object v8
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/DeviceOverLimitDialog$launchClearRefreshToken$1$2$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/DeviceOverLimitDialog$launchClearRefreshToken$1$2$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/login/DeviceOverLimitDialog$launchClearRefreshToken$1$2$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/login/DeviceOverLimitDialog$launchClearRefreshToken$1$2$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 5
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v3, Lcom/bytedance/trae/login/DeviceOverLimitDialog$launchClearRefreshToken$1$2$1;->label I
    if-nez v0, +04dh
    invoke-static v4, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v4, v3, Lcom/bytedance/trae/login/DeviceOverLimitDialog$launchClearRefreshToken$1$2$1;->$adapter Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter;
    iget-object v0, v3, Lcom/bytedance/trae/login/DeviceOverLimitDialog$launchClearRefreshToken$1$2$1;->$deviceId Ljava/lang/String;
    invoke-virtual v4, v0, Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter;->removeDevice(Ljava/lang/String;)V
    iget-object v4, v3, Lcom/bytedance/trae/login/DeviceOverLimitDialog$launchClearRefreshToken$1$2$1;->$adapter Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter;
    invoke-virtual v4, Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter;->getItemCount()I
    move-result v4
    iget v0, v3, Lcom/bytedance/trae/login/DeviceOverLimitDialog$launchClearRefreshToken$1$2$1;->$maxDeviceCount I
    if-ge v4, v0, +036h
    iget-object v4, v3, Lcom/bytedance/trae/login/DeviceOverLimitDialog$launchClearRefreshToken$1$2$1;->$binding Lcom/bytedance/trae/login/databinding/TraeDialogDeviceOverLimitBinding;
    iget-object v4, v4, Lcom/bytedance/trae/login/databinding/TraeDialogDeviceOverLimitBinding;->btnLoginCurrent Landroid/widget/FrameLayout;
    const/4 v0, 0
    invoke-virtual v4, v0, Landroid/widget/FrameLayout;->getChildAt(I)Landroid/view/View;
    move-result-object v4
    instance-of v0, v4, Landroid/widget/TextView;
    if-eqz v0, +005h
    check-cast v4, Landroid/widget/TextView;
    goto +2h
    const/4 v4, 0
    const/4 v0, 1
    if-eqz v4, +005h
    invoke-virtual v4, v0, Landroid/widget/TextView;->setEnabled(Z)V
    if-eqz v4, +007h
    sget v1, Lcom/bytedance/trae/login/R$drawable;->trae_login_bg_btn_new I
    invoke-virtual v4, v1, Landroid/widget/TextView;->setBackgroundResource(I)V
    if-eqz v4, +00fh
    iget-object v1, v3, Lcom/bytedance/trae/login/DeviceOverLimitDialog$launchClearRefreshToken$1$2$1;->$activity Landroid/app/Activity;
    check-cast v1, Landroid/content/Context;
    sget v2, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_onaccent I
    invoke-static v1, v2, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v1
    invoke-virtual v4, v1, Landroid/widget/TextView;->setTextColor(I)V
    iget-object v4, v3, Lcom/bytedance/trae/login/DeviceOverLimitDialog$launchClearRefreshToken$1$2$1;->$binding Lcom/bytedance/trae/login/databinding/TraeDialogDeviceOverLimitBinding;
    iget-object v4, v4, Lcom/bytedance/trae/login/databinding/TraeDialogDeviceOverLimitBinding;->btnLoginCurrent Landroid/widget/FrameLayout;
    invoke-virtual v4, v0, Landroid/widget/FrameLayout;->setEnabled(Z)V
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v4
    new-instance v4, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v4, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v4
.end method
