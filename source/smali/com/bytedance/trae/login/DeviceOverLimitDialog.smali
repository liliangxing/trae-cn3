# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/DeviceOverLimitDialog;
.super Ljava/lang/Object;
.source "DeviceOverLimitDialog.kt"

.field private static final DEFAULT_BOTTOM_SHEET_HEIGHT_RATIO:F
.field public static final INSTANCE:Lcom/bytedance/trae/login/DeviceOverLimitDialog;
.field private static final TAG:Ljava/lang/String;
.field private static isContinueClicked:Z
.field private static savedActivity:Landroid/app/Activity;
.field private static savedAdapter:Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter;
.field private static savedCallback:Lcom/bytedance/trae/login/DeviceOverLimitDialog$Callback;
.field private static savedMaxDeviceCount:I
.field private static savedScene:Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene;


.method public static synthetic $r8$lambda$AaOOeadGrbjolz-6jfCYI_YY-kM(android.app.Activity  kotlin.jvm.internal.Ref$ObjectRef  com.bytedance.trae.login.databinding.TraeDialogDeviceOverLimitBinding  com.bytedance.trae.login.traeauth.ListDevicesResult  com.bytedance.trae.login.traeauth.DeviceSummary)kotlin.Unit
    .registers 5
    # ins_size=5
    invoke-static v0, v1, v2, v3, v4, Lcom/bytedance/trae/login/DeviceOverLimitDialog;->show$lambda$1(Landroid/app/Activity; Lkotlin/jvm/internal/Ref$ObjectRef; Lcom/bytedance/trae/login/databinding/TraeDialogDeviceOverLimitBinding; Lcom/bytedance/trae/login/traeauth/ListDevicesResult; Lcom/bytedance/trae/login/traeauth/DeviceSummary;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$DuZRLegbtfcM2iCue2FRUsBv2SY(com.google.android.material.bottomsheet.BottomSheetDialog  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/DeviceOverLimitDialog;->show$lambda$4(Lcom/google/android/material/bottomsheet/BottomSheetDialog; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$KMzV6xXtPNuDk7v6VwVHeJr6LIo(kotlin.jvm.functions.Function0  java.lang.String)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/DeviceOverLimitDialog;->showLogoutConfirmDialog$lambda$10(Lkotlin/jvm/functions/Function0; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$O0BKi5rDWdzIwOmXWMSFGmUFN8U(android.content.DialogInterface)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/login/DeviceOverLimitDialog;->show$lambda$2(Landroid/content/DialogInterface;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$RgA9NV4K4a3BwY4jDJf7_N8s7p4(com.google.android.material.bottomsheet.BottomSheetDialog  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/DeviceOverLimitDialog;->show$lambda$3(Lcom/google/android/material/bottomsheet/BottomSheetDialog; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$WEiaYKIN42AgWfqGwdPRGEdCsOA(com.google.android.material.bottomsheet.BottomSheetDialog  android.app.Activity  com.bytedance.trae.login.DeviceOverLimitDialog$Scene  android.content.DialogInterface)void
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/login/DeviceOverLimitDialog;->show$lambda$7(Lcom/google/android/material/bottomsheet/BottomSheetDialog; Landroid/app/Activity; Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene; Landroid/content/DialogInterface;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$qoN6Ufc7kwjsNQnrPwlR2blVnKQ(android.app.Activity  java.lang.String  kotlin.jvm.internal.Ref$ObjectRef  com.bytedance.trae.login.databinding.TraeDialogDeviceOverLimitBinding  com.bytedance.trae.login.traeauth.ListDevicesResult)kotlin.Unit
    .registers 5
    # ins_size=5
    invoke-static v0, v1, v2, v3, v4, Lcom/bytedance/trae/login/DeviceOverLimitDialog;->show$lambda$1$lambda$0(Landroid/app/Activity; Ljava/lang/String; Lkotlin/jvm/internal/Ref$ObjectRef; Lcom/bytedance/trae/login/databinding/TraeDialogDeviceOverLimitBinding; Lcom/bytedance/trae/login/traeauth/ListDevicesResult;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$rwENBZLSv6QU8S0cIVRJ_Hl5-FY(android.content.DialogInterface)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/login/DeviceOverLimitDialog;->show$lambda$5(Landroid/content/DialogInterface;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$xzHRCdvQQuwxDtg0qFABbRCPHdw()kotlin.Unit
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/login/DeviceOverLimitDialog;->showLogoutConfirmDialog$lambda$11()Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/login/DeviceOverLimitDialog;
    invoke-direct v0, Lcom/bytedance/trae/login/DeviceOverLimitDialog;-><init>()V
    sput-object v0, Lcom/bytedance/trae/login/DeviceOverLimitDialog;->INSTANCE Lcom/bytedance/trae/login/DeviceOverLimitDialog;
    const v0, 2147483647
    sput v0, Lcom/bytedance/trae/login/DeviceOverLimitDialog;->savedMaxDeviceCount I
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final launchClearRefreshToken(android.app.Activity  java.lang.String  com.bytedance.trae.login.DeviceOverLimitDeviceAdapter  com.bytedance.trae.login.databinding.TraeDialogDeviceOverLimitBinding  int)void
    .registers 17
    # ins_size=6
    move-object v5, v12
    instance-of v0, v5, Landroidx/lifecycle/LifecycleOwner;
    if-eqz v0, +006h
    move-object v0, v5
    check-cast v0, Landroidx/lifecycle/LifecycleOwner;
    goto +2h
    const/4 v0, 0
    if-eqz v0, +00bh
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v0
    if-eqz v0, +005h
    check-cast v0, Lkotlinx/coroutines/CoroutineScope;
    goto +bh
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v0
    check-cast v0, Lkotlin/coroutines/CoroutineContext;
    invoke-static v0, Lkotlinx/coroutines/CoroutineScopeKt;->CoroutineScope(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v0
    move-object v7, v0
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v0
    move-object v8, v0
    check-cast v8, Lkotlin/coroutines/CoroutineContext;
    const/4 v9, 0
    new-instance v10, Lcom/bytedance/trae/login/DeviceOverLimitDialog$launchClearRefreshToken$1;
    const/4 v6, 0
    move-object v0, v10
    move-object v1, v13
    move-object v2, v14
    move/from16 v3, v16
    move-object v4, v15
    move-object v5, v12
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/login/DeviceOverLimitDialog$launchClearRefreshToken$1;-><init>(Ljava/lang/String; Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter; I Lcom/bytedance/trae/login/databinding/TraeDialogDeviceOverLimitBinding; Landroid/app/Activity; Lkotlin/coroutines/Continuation;)V
    move-object v4, v10
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 2
    move-object v1, v7
    move-object v2, v8
    move-object v3, v9
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final onCallback()void
    .registers 6
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/login/DeviceOverLimitDialog;->savedAdapter Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter;
    if-nez v0, +003h
    return-void 
    invoke-virtual v0, Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter;->getItemCount()I
    move-result v0
    sget v1, Lcom/bytedance/trae/login/DeviceOverLimitDialog;->savedMaxDeviceCount I
    if-ge v0, v1, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    new-instance v1, Lorg/json/JSONObject;
    invoke-direct v1, Lorg/json/JSONObject;-><init>()V
    sget-boolean v2, Lcom/bytedance/trae/login/DeviceOverLimitDialog;->isContinueClicked Z
    const-string v3, "login"
    const-string v4, "buttonType"
    if-eqz v2, +006h
    invoke-virtual v1, v4, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    goto +6h
    const-string v2, "close"
    invoke-virtual v1, v4, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v2, "loginStatus"
    if-eqz v0, +006h
    invoke-virtual v1, v2, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    goto +6h
    const-string v3, "logout"
    invoke-virtual v1, v2, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v2, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    const-string v3, "device_page_dismiss"
    invoke-virtual v2, v3, v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    sget-object v1, Lcom/bytedance/trae/login/DeviceOverLimitDialog;->savedCallback Lcom/bytedance/trae/login/DeviceOverLimitDialog$Callback;
    if-eqz v1, +005h
    invoke-interface v1, v0, Lcom/bytedance/trae/login/DeviceOverLimitDialog$Callback;->onResult(Z)V
    const/4 v0, 0
    sput-object v0, Lcom/bytedance/trae/login/DeviceOverLimitDialog;->savedScene Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene;
    sput-object v0, Lcom/bytedance/trae/login/DeviceOverLimitDialog;->savedCallback Lcom/bytedance/trae/login/DeviceOverLimitDialog$Callback;
    sput-object v0, Lcom/bytedance/trae/login/DeviceOverLimitDialog;->savedActivity Landroid/app/Activity;
    sput-object v0, Lcom/bytedance/trae/login/DeviceOverLimitDialog;->savedAdapter Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter;
    return-void 
    :try_start_0x10
    :try_start_0x1d
    :try_start_0x2a
.end method

.method private final resolveBottomSheetHeight(android.app.Activity  android.view.View)int
    .registers 7
    # ins_size=3
    invoke-virtual v6, Landroid/view/View;->getRootView()Landroid/view/View;
    move-result-object v6
    invoke-virtual v6, Landroid/view/View;->getHeight()I
    move-result v6
    invoke-static v6, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    move-object v0, v6
    check-cast v0, Ljava/lang/Number;
    invoke-virtual v0, Ljava/lang/Number;->intValue()I
    move-result v0
    const/4 v1, 1
    const/4 v2, 0
    if-lez v0, +004h
    move v0, v1
    goto +2h
    move v0, v2
    const/4 v3, 0
    if-eqz v0, +003h
    goto +2h
    move-object v6, v3
    if-eqz v6, +007h
    invoke-virtual v6, Ljava/lang/Integer;->intValue()I
    move-result v5
    goto +34h
    invoke-virtual v5, Landroid/app/Activity;->getWindow()Landroid/view/Window;
    move-result-object v6
    if-eqz v6, +01eh
    invoke-virtual v6, Landroid/view/Window;->getDecorView()Landroid/view/View;
    move-result-object v6
    if-eqz v6, +018h
    invoke-virtual v6, Landroid/view/View;->getHeight()I
    move-result v6
    invoke-static v6, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    move-object v0, v6
    check-cast v0, Ljava/lang/Number;
    invoke-virtual v0, Ljava/lang/Number;->intValue()I
    move-result v0
    if-lez v0, +003h
    goto +2h
    move v1, v2
    if-eqz v1, +003h
    move-object v3, v6
    if-eqz v3, +007h
    invoke-virtual v3, Ljava/lang/Integer;->intValue()I
    move-result v5
    goto +bh
    invoke-virtual v5, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;
    move-result-object v5
    invoke-virtual v5, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v5
    iget v5, v5, Landroid/util/DisplayMetrics;->heightPixels I
    int-to-float v5, v5
    const v6, 1063675494
    mul-float/2addr v5, v6
    invoke-static v5, Lkotlin/math/MathKt;->roundToInt(F)I
    move-result v5
    return v5
.end method

.method public static synthetic show$default(com.bytedance.trae.login.DeviceOverLimitDialog  android.app.Activity  com.bytedance.trae.login.traeauth.ListDevicesResult  com.bytedance.trae.login.DeviceOverLimitDialog$Scene  com.bytedance.trae.login.DeviceOverLimitDialog$Callback  int  java.lang.Object)void
    .registers 7
    # ins_size=7
    and-int/lit8 v5, v5, 8
    if-eqz v5, +003h
    const/4 v4, 0
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/login/DeviceOverLimitDialog;->show(Landroid/app/Activity; Lcom/bytedance/trae/login/traeauth/ListDevicesResult; Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene; Lcom/bytedance/trae/login/DeviceOverLimitDialog$Callback;)V
    return-void 
.end method

.method private static final show$lambda$1(android.app.Activity  kotlin.jvm.internal.Ref$ObjectRef  com.bytedance.trae.login.databinding.TraeDialogDeviceOverLimitBinding  com.bytedance.trae.login.traeauth.ListDevicesResult  com.bytedance.trae.login.traeauth.DeviceSummary)kotlin.Unit
    .registers 13
    # ins_size=5
    const-string v0, "device"
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v12, Lcom/bytedance/trae/login/traeauth/DeviceSummary;->getDeviceId()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    const-string v0, ""
    move-object v3, v0
    move-object v0, v3
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    const-string v1, "DeviceOverLimitDialog"
    if-eqz v0, +00ah
    sget-object v8, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v9, "logout device clicked with empty deviceId"
    invoke-virtual v8, v1, v9, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    goto +24h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v4, "logout device clicked, deviceId="
    invoke-direct v2, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/login/DeviceOverLimitDialog;->INSTANCE Lcom/bytedance/trae/login/DeviceOverLimitDialog;
    new-instance v7, Lcom/bytedance/trae/login/DeviceOverLimitDialog$$ExternalSyntheticLambda8;
    move-object v1, v7
    move-object v2, v8
    move-object v4, v9
    move-object v5, v10
    move-object v6, v11
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/login/DeviceOverLimitDialog$$ExternalSyntheticLambda8;-><init>(Landroid/app/Activity; Ljava/lang/String; Lkotlin/jvm/internal/Ref$ObjectRef; Lcom/bytedance/trae/login/databinding/TraeDialogDeviceOverLimitBinding; Lcom/bytedance/trae/login/traeauth/ListDevicesResult;)V
    invoke-direct v0, v8, v12, v7, Lcom/bytedance/trae/login/DeviceOverLimitDialog;->showLogoutConfirmDialog(Landroid/app/Activity; Lcom/bytedance/trae/login/traeauth/DeviceSummary; Lkotlin/jvm/functions/Function0;)V
    sget-object v8, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v8
.end method

.method private static final show$lambda$1$lambda$0(android.app.Activity  java.lang.String  kotlin.jvm.internal.Ref$ObjectRef  com.bytedance.trae.login.databinding.TraeDialogDeviceOverLimitBinding  com.bytedance.trae.login.traeauth.ListDevicesResult)kotlin.Unit
    .registers 11
    # ins_size=5
    sget-object v0, Lcom/bytedance/trae/login/DeviceOverLimitDialog;->INSTANCE Lcom/bytedance/trae/login/DeviceOverLimitDialog;
    iget-object v8, v8, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    invoke-static v8, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    move-object v3, v8
    check-cast v3, Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter;
    invoke-virtual v10, Lcom/bytedance/trae/login/traeauth/ListDevicesResult;->getMaxDeviceCount()Ljava/lang/Integer;
    move-result-object v8
    if-eqz v8, +007h
    invoke-virtual v8, Ljava/lang/Integer;->intValue()I
    move-result v8
    goto +4h
    const v8, 2147483647
    move v5, v8
    move-object v1, v6
    move-object v2, v7
    move-object v4, v9
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/login/DeviceOverLimitDialog;->launchClearRefreshToken(Landroid/app/Activity; Ljava/lang/String; Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter; Lcom/bytedance/trae/login/databinding/TraeDialogDeviceOverLimitBinding; I)V
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v6
.end method

.method private static final show$lambda$2(android.content.DialogInterface)void
    .registers 1
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/login/DeviceOverLimitDialog;->INSTANCE Lcom/bytedance/trae/login/DeviceOverLimitDialog;
    invoke-direct v0, Lcom/bytedance/trae/login/DeviceOverLimitDialog;->onCallback()V
    return-void 
.end method

.method private static final show$lambda$3(com.google.android.material.bottomsheet.BottomSheetDialog  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-virtual v0, Lcom/google/android/material/bottomsheet/BottomSheetDialog;->dismiss()V
    return-void 
.end method

.method private static final show$lambda$4(com.google.android.material.bottomsheet.BottomSheetDialog  android.view.View)void
    .registers 2
    # ins_size=2
    const/4 v1, 1
    sput-boolean v1, Lcom/bytedance/trae/login/DeviceOverLimitDialog;->isContinueClicked Z
    invoke-virtual v0, Lcom/google/android/material/bottomsheet/BottomSheetDialog;->dismiss()V
    return-void 
.end method

.method private static final show$lambda$5(android.content.DialogInterface)void
    .registers 1
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/login/DeviceOverLimitDialog;->INSTANCE Lcom/bytedance/trae/login/DeviceOverLimitDialog;
    invoke-direct v0, Lcom/bytedance/trae/login/DeviceOverLimitDialog;->onCallback()V
    return-void 
.end method

.method private static final show$lambda$7(com.google.android.material.bottomsheet.BottomSheetDialog  android.app.Activity  com.bytedance.trae.login.DeviceOverLimitDialog$Scene  android.content.DialogInterface)void
    .registers 5
    # ins_size=4
    sget v4, Lcom/google/android/material/R$id;->design_bottom_sheet I
    invoke-virtual v1, v4, Lcom/google/android/material/bottomsheet/BottomSheetDialog;->findViewById(I)Landroid/view/View;
    move-result-object v1
    if-eqz v1, +029h
    const v4, 17170445
    invoke-virtual v1, v4, Landroid/view/View;->setBackgroundResource(I)V
    invoke-static v1, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->from(Landroid/view/View;)Lcom/google/android/material/bottomsheet/BottomSheetBehavior;
    move-result-object v4
    sget-object v0, Lcom/bytedance/trae/login/DeviceOverLimitDialog;->INSTANCE Lcom/bytedance/trae/login/DeviceOverLimitDialog;
    invoke-direct v0, v2, v1, Lcom/bytedance/trae/login/DeviceOverLimitDialog;->resolveBottomSheetHeight(Landroid/app/Activity; Landroid/view/View;)I
    move-result v2
    invoke-virtual v4, v2, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setPeekHeight(I)V
    const/4 v0, 3
    invoke-virtual v4, v0, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setState(I)V
    const/4 v0, 1
    invoke-virtual v4, v0, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setSkipCollapsed(Z)V
    invoke-virtual v4, v0, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setHideable(Z)V
    invoke-virtual v1, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v4
    iput v2, v4, Landroid/view/ViewGroup$LayoutParams;->height I
    invoke-virtual v1, v4, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v1, Lorg/json/JSONObject;
    invoke-direct v1, Lorg/json/JSONObject;-><init>()V
    sget-object v2, Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene;->EXCHANGE Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene;
    const-string/jumbo v4, source
    if-ne v3, v2, +008h
    const-string v2, "exchangetoken"
    invoke-virtual v1, v4, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    goto +10h
    sget-object v2, Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene;->REBIND Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene;
    if-ne v3, v2, +008h
    const-string v2, "binddevice"
    invoke-virtual v1, v4, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    goto +6h
    const-string v2, "getrefreshtoken"
    invoke-virtual v1, v4, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v2, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    const-string v3, "device_page_show"
    invoke-virtual v2, v3, v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
    :try_start_0x2f
    :try_start_0x3b
.end method

.method private final showLogoutConfirmDialog(android.app.Activity  com.bytedance.trae.login.traeauth.DeviceSummary  kotlin.jvm.functions.Function0)void
    .registers 32
    # ins_size=4
    move-object/from16 v0, v29
    sget-object v1, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    const-string v2, "device_delete_click"
    invoke-virtual v1, v2, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String;)V
    invoke-virtual/range v29, Landroid/app/Activity;->isFinishing()Z
    move-result v1
    if-nez v1, +09dh
    invoke-virtual/range v29, Landroid/app/Activity;->isDestroyed()Z
    move-result v1
    if-eqz v1, +004h
    goto/16 +095h
    invoke-virtual/range v30, Lcom/bytedance/trae/login/traeauth/DeviceSummary;->getDeviceName()Ljava/lang/String;
    move-result-object v1
    const-string v2, ""
    if-nez v1, +003h
    move-object v1, v2
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v3
    if-eqz v3, +00bh
    invoke-virtual/range v30, Lcom/bytedance/trae/login/traeauth/DeviceSummary;->getDeviceModel()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +003h
    goto +2h
    move-object v2, v1
    move-object v1, v2
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    const-string v3, "getString(...)"
    if-eqz v2, +00bh
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->trae_device_over_limit_unknown_device I
    invoke-virtual v0, v1, Landroid/app/Activity;->getString(I)Ljava/lang/String;
    move-result-object v1
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v1, Ljava/lang/String;
    new-instance v1, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;
    move-object v2, v0
    check-cast v2, Landroid/content/Context;
    new-instance v15, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;
    move-object v4, v15
    sget v5, Lcom/bytedance/trae/multilanguage/R$string;->trae_device_over_limit_logout_confirm_title I
    invoke-virtual v0, v5, Landroid/app/Activity;->getString(I)Ljava/lang/String;
    move-result-object v6
    move-object v5, v6
    invoke-static v6, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v6, Lcom/bytedance/trae/multilanguage/R$string;->trae_device_over_limit_logout_confirm_message I
    invoke-virtual v0, v6, Landroid/app/Activity;->getString(I)Ljava/lang/String;
    move-result-object v6
    const/4 v7, 0
    const/4 v8, 0
    sget v9, Lcom/bytedance/trae/multilanguage/R$string;->trae_device_over_limit_logout_confirm_cancel I
    invoke-virtual v0, v9, Landroid/app/Activity;->getString(I)Ljava/lang/String;
    move-result-object v10
    move-object v9, v10
    invoke-static v10, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v10, Lcom/bytedance/trae/multilanguage/R$string;->trae_device_over_limit_logout_confirm_logout I
    invoke-virtual v0, v10, Landroid/app/Activity;->getString(I)Ljava/lang/String;
    move-result-object v0
    move-object v10, v0
    invoke-static v0, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v0, 0
    move-object v3, v15
    move-object v15, v0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 0
    new-instance v0, Lcom/bytedance/trae/login/DeviceOverLimitDialog$$ExternalSyntheticLambda6;
    move-object/from16 v24, v0
    move-object/from16 v7, v31
    invoke-direct v0, v7, Lcom/bytedance/trae/login/DeviceOverLimitDialog$$ExternalSyntheticLambda6;-><init>(Lkotlin/jvm/functions/Function0;)V
    new-instance v0, Lcom/bytedance/trae/login/DeviceOverLimitDialog$$ExternalSyntheticLambda7;
    move-object/from16 v25, v0
    invoke-direct v0, Lcom/bytedance/trae/login/DeviceOverLimitDialog$$ExternalSyntheticLambda7;-><init>()V
    const v26, 524236
    const/16 v27, 0
    const/4 v7, 0
    invoke-direct/range v4 ... v27, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; F Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; I I I Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Z Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-direct v1, v2, v3, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;-><init>(Landroid/content/Context; Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;)V
    invoke-virtual v1, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->show()V
    return-void 
.end method

.method private static final showLogoutConfirmDialog$lambda$10(kotlin.jvm.functions.Function0  java.lang.String)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final showLogoutConfirmDialog$lambda$11()kotlin.Unit
    .registers 1
    # ins_size=0
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method public final isContinueClicked()boolean
    .registers 2
    # ins_size=1
    sget-boolean v0, Lcom/bytedance/trae/login/DeviceOverLimitDialog;->isContinueClicked Z
    return v0
.end method

.method public final setContinueClicked(boolean)void
    .registers 2
    # ins_size=2
    sput-boolean v1, Lcom/bytedance/trae/login/DeviceOverLimitDialog;->isContinueClicked Z
    return-void 
.end method

.method public final show(android.app.Activity  com.bytedance.trae.login.traeauth.ListDevicesResult  com.bytedance.trae.login.DeviceOverLimitDialog$Scene  com.bytedance.trae.login.DeviceOverLimitDialog$Callback)void
    .registers 12
    # ins_size=5
    const-string v0, "activity"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, result
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, scene
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sput-object v10, Lcom/bytedance/trae/login/DeviceOverLimitDialog;->savedScene Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene;
    sput-object v11, Lcom/bytedance/trae/login/DeviceOverLimitDialog;->savedCallback Lcom/bytedance/trae/login/DeviceOverLimitDialog$Callback;
    sput-object v8, Lcom/bytedance/trae/login/DeviceOverLimitDialog;->savedActivity Landroid/app/Activity;
    invoke-virtual v9, Lcom/bytedance/trae/login/traeauth/ListDevicesResult;->getMaxDeviceCount()Ljava/lang/Integer;
    move-result-object v11
    if-eqz v11, +007h
    invoke-virtual v11, Ljava/lang/Integer;->intValue()I
    move-result v11
    goto +4h
    const v11, 2147483647
    sput v11, Lcom/bytedance/trae/login/DeviceOverLimitDialog;->savedMaxDeviceCount I
    invoke-virtual v8, Landroid/app/Activity;->isFinishing()Z
    move-result v11
    if-nez v11, +0fbh
    invoke-virtual v8, Landroid/app/Activity;->isDestroyed()Z
    move-result v11
    if-eqz v11, +004h
    goto/16 +0f3h
    new-instance v11, Lcom/google/android/material/bottomsheet/BottomSheetDialog;
    move-object v0, v8
    check-cast v0, Landroid/content/Context;
    sget v1, Lcom/google/android/material/R$style;->Theme_MaterialComponents_Light_BottomSheetDialog I
    invoke-direct v11, v0, v1, Lcom/google/android/material/bottomsheet/BottomSheetDialog;-><init>(Landroid/content/Context; I)V
    invoke-virtual v11, Lcom/google/android/material/bottomsheet/BottomSheetDialog;->getContext()Landroid/content/Context;
    move-result-object v1
    invoke-static v1, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;
    move-result-object v1
    invoke-static v1, Lcom/bytedance/trae/login/databinding/TraeDialogDeviceOverLimitBinding;->inflate(Landroid/view/LayoutInflater;)Lcom/bytedance/trae/login/databinding/TraeDialogDeviceOverLimitBinding;
    move-result-object v1
    const-string v2, "inflate(...)"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v2, v1, Lcom/bytedance/trae/login/databinding/TraeDialogDeviceOverLimitBinding;->loginCurrentText Landroid/widget/TextView;
    sget-object v3, Lcom/bytedance/trae/login/DeviceOverLimitDialog$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v10, Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene;->ordinal()I
    move-result v4
    aget v3, v3, v4
    const/4 v4, 1
    if-eq v3, v4, +01ch
    const/4 v5, 2
    if-eq v3, v5, +012h
    const/4 v5, 3
    if-ne v3, v5, +009h
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->trae_device_over_limit_stay_current I
    invoke-virtual v8, v3, Landroid/app/Activity;->getString(I)Ljava/lang/String;
    move-result-object v3
    goto +14h
    new-instance v8, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v8, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v8
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->trae_device_over_limit_stay_current I
    invoke-virtual v8, v3, Landroid/app/Activity;->getString(I)Ljava/lang/String;
    move-result-object v3
    goto +7h
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->trae_device_over_limit_login_current I
    invoke-virtual v8, v3, Landroid/app/Activity;->getString(I)Ljava/lang/String;
    move-result-object v3
    check-cast v3, Ljava/lang/CharSequence;
    invoke-virtual v2, v3, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v2, v1, Lcom/bytedance/trae/login/databinding/TraeDialogDeviceOverLimitBinding;->tvDescription Landroid/widget/TextView;
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->trae_device_over_limit_description I
    new-array v4, v4, [Ljava/lang/Object;
    sget v5, Lcom/bytedance/trae/login/DeviceOverLimitDialog;->savedMaxDeviceCount I
    invoke-static v5, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    const/4 v6, 0
    aput-object v5, v4, v6
    invoke-virtual v8, v3, v4, Landroid/app/Activity;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v3
    check-cast v3, Ljava/lang/CharSequence;
    invoke-virtual v2, v3, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    new-instance v2, Lkotlin/jvm/internal/Ref$ObjectRef;
    invoke-direct v2, Lkotlin/jvm/internal/Ref$ObjectRef;-><init>()V
    new-instance v3, Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter;
    invoke-virtual v9, Lcom/bytedance/trae/login/traeauth/ListDevicesResult;->getDevices()Ljava/util/List;
    move-result-object v4
    if-nez v4, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v4
    new-instance v5, Lcom/bytedance/trae/login/DeviceOverLimitDialog$$ExternalSyntheticLambda0;
    invoke-direct v5, v8, v2, v1, v9, Lcom/bytedance/trae/login/DeviceOverLimitDialog$$ExternalSyntheticLambda0;-><init>(Landroid/app/Activity; Lkotlin/jvm/internal/Ref$ObjectRef; Lcom/bytedance/trae/login/databinding/TraeDialogDeviceOverLimitBinding; Lcom/bytedance/trae/login/traeauth/ListDevicesResult;)V
    invoke-direct v3, v4, v5, Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter;-><init>(Ljava/util/List; Lkotlin/jvm/functions/Function1;)V
    iput-object v3, v2, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    iget-object v9, v2, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    check-cast v9, Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter;
    sput-object v9, Lcom/bytedance/trae/login/DeviceOverLimitDialog;->savedAdapter Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter;
    iget-object v9, v1, Lcom/bytedance/trae/login/databinding/TraeDialogDeviceOverLimitBinding;->rvDevices Landroidx/recyclerview/widget/RecyclerView;
    new-instance v3, Landroidx/recyclerview/widget/LinearLayoutManager;
    invoke-direct v3, v0, Landroidx/recyclerview/widget/LinearLayoutManager;-><init>(Landroid/content/Context;)V
    check-cast v3, Landroidx/recyclerview/widget/RecyclerView$LayoutManager;
    invoke-virtual v9, v3, Landroidx/recyclerview/widget/RecyclerView;->setLayoutManager(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)V
    iget-object v9, v1, Lcom/bytedance/trae/login/databinding/TraeDialogDeviceOverLimitBinding;->rvDevices Landroidx/recyclerview/widget/RecyclerView;
    new-instance v0, Lcom/bytedance/trae/login/DeviceOverLimitDialog$DeviceSpacingDecoration;
    invoke-virtual v8, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;
    move-result-object v3
    invoke-virtual v3, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v3
    iget v3, v3, Landroid/util/DisplayMetrics;->density F
    const/16 v4, 12
    int-to-float v4, v4
    mul-float/2addr v3, v4
    float-to-int v3, v3
    invoke-direct v0, v3, Lcom/bytedance/trae/login/DeviceOverLimitDialog$DeviceSpacingDecoration;-><init>(I)V
    check-cast v0, Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;
    invoke-virtual v9, v0, Landroidx/recyclerview/widget/RecyclerView;->addItemDecoration(Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;)V
    new-instance v9, Lcom/bytedance/trae/login/DeviceOverLimitDialog$$ExternalSyntheticLambda1;
    invoke-direct v9, Lcom/bytedance/trae/login/DeviceOverLimitDialog$$ExternalSyntheticLambda1;-><init>()V
    invoke-virtual v11, v9, Lcom/google/android/material/bottomsheet/BottomSheetDialog;->setOnDismissListener(Landroid/content/DialogInterface$OnDismissListener;)V
    iget-object v9, v1, Lcom/bytedance/trae/login/databinding/TraeDialogDeviceOverLimitBinding;->rvDevices Landroidx/recyclerview/widget/RecyclerView;
    iget-object v0, v2, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    check-cast v0, Landroidx/recyclerview/widget/RecyclerView$Adapter;
    invoke-virtual v9, v0, Landroidx/recyclerview/widget/RecyclerView;->setAdapter(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V
    iget-object v9, v1, Lcom/bytedance/trae/login/databinding/TraeDialogDeviceOverLimitBinding;->ivClose Landroid/widget/ImageView;
    new-instance v0, Lcom/bytedance/trae/login/DeviceOverLimitDialog$$ExternalSyntheticLambda2;
    invoke-direct v0, v11, Lcom/bytedance/trae/login/DeviceOverLimitDialog$$ExternalSyntheticLambda2;-><init>(Lcom/google/android/material/bottomsheet/BottomSheetDialog;)V
    invoke-virtual v9, v0, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v9, v1, Lcom/bytedance/trae/login/databinding/TraeDialogDeviceOverLimitBinding;->btnLoginCurrent Landroid/widget/FrameLayout;
    new-instance v0, Lcom/bytedance/trae/login/DeviceOverLimitDialog$$ExternalSyntheticLambda3;
    invoke-direct v0, v11, Lcom/bytedance/trae/login/DeviceOverLimitDialog$$ExternalSyntheticLambda3;-><init>(Lcom/google/android/material/bottomsheet/BottomSheetDialog;)V
    invoke-virtual v9, v0, Landroid/widget/FrameLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    invoke-virtual v1, Lcom/bytedance/trae/login/databinding/TraeDialogDeviceOverLimitBinding;->getRoot()Landroid/widget/LinearLayout;
    move-result-object v9
    check-cast v9, Landroid/view/View;
    invoke-virtual v11, v9, Lcom/google/android/material/bottomsheet/BottomSheetDialog;->setContentView(Landroid/view/View;)V
    invoke-virtual v11, v6, Lcom/google/android/material/bottomsheet/BottomSheetDialog;->setCancelable(Z)V
    new-instance v9, Lcom/bytedance/trae/login/DeviceOverLimitDialog$$ExternalSyntheticLambda4;
    invoke-direct v9, Lcom/bytedance/trae/login/DeviceOverLimitDialog$$ExternalSyntheticLambda4;-><init>()V
    invoke-virtual v11, v9, Lcom/google/android/material/bottomsheet/BottomSheetDialog;->setOnDismissListener(Landroid/content/DialogInterface$OnDismissListener;)V
    new-instance v9, Lcom/bytedance/trae/login/DeviceOverLimitDialog$$ExternalSyntheticLambda5;
    invoke-direct v9, v11, v8, v10, Lcom/bytedance/trae/login/DeviceOverLimitDialog$$ExternalSyntheticLambda5;-><init>(Lcom/google/android/material/bottomsheet/BottomSheetDialog; Landroid/app/Activity; Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene;)V
    invoke-virtual v11, v9, Lcom/google/android/material/bottomsheet/BottomSheetDialog;->setOnShowListener(Landroid/content/DialogInterface$OnShowListener;)V
    invoke-virtual v11, Lcom/google/android/material/bottomsheet/BottomSheetDialog;->show()V
    return-void 
.end method
