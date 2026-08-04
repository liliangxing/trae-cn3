# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;
.super Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;
.source "PluginAuthorizationBottomSheet.kt"

.field private static final ARG_LOCALIZED_NAME:Ljava/lang/String;
.field private static final ARG_MODE:Ljava/lang/String;
.field private static final ARG_PROVIDER:Ljava/lang/String;
.field private static final ARG_PROVIDER_DISPLAY_NAME:Ljava/lang/String;
.field public static final Companion:Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet$Companion;
.field public static final MODE_DESKTOP_REDIRECT:I
.field public static final MODE_QRCODE:I
.field private static final QR_CODE_SIZE:I
.field private static final SCREEN_RATIO:D
.field public static final TAG:Ljava/lang/String;
.field private bridge authStarted:Z
.field private bridge completed:Z
.field private onAuthResult:Lkotlin/jvm/functions/Function1;
.field private shimmerTextView:Lcom/bytedance/trae/conversation/widget/ShimmerTextView;


.method public static synthetic $r8$lambda$-KY7SxzYgMZMXDTEikdyf_JEBls(android.widget.ProgressBar  com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationBottomSheet  java.lang.String  android.widget.ImageView)void
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->startQrCodeAuth$lambda$5$lambda$4(Landroid/widget/ProgressBar; Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet; Ljava/lang/String; Landroid/widget/ImageView;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$0udP-cOL4BqJX1P7IWXUSPZavKk(com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationBottomSheet  int  android.content.DialogInterface)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->onCreateDialog$lambda$1(Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet; I Landroid/content/DialogInterface;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$1Gi_ZNkuT0RVCDRJtU0-Dya_aps(com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationBottomSheet  java.lang.String)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->startQrCodeAuth$lambda$7(Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$7unc3-KLMxSWy_MNa75vLEASHF4(com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationBottomSheet)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->startQrCodeAuth$lambda$9$lambda$8(Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$DrnSE2MtdnSkBM9l0G7IDEIKDzk(com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationBottomSheet  java.lang.String)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->startDesktopRedirectAuth$lambda$11$lambda$10(Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet; Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$EJPxDkBrAecv22LZnO1RiJ1HqQ4(com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationBottomSheet  java.lang.String)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->startDesktopRedirectAuth$lambda$11(Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$KT3MIZuKrtUFnRsrkkEw2c7O4EY(com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationBottomSheet  android.widget.ProgressBar  android.widget.ImageView  java.lang.String)kotlin.Unit
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->startQrCodeAuth$lambda$5(Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet; Landroid/widget/ProgressBar; Landroid/widget/ImageView; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$Sl3hzjZFoWoKp-yGfz4qi_gDfD0(com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationBottomSheet  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->setupDesktopRedirectMode$lambda$3(Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$icM26znDWCPuhXQef7FpScwBSFY(com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationBottomSheet  java.lang.String)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->startQrCodeAuth$lambda$7$lambda$6(Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet; Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$mHMNPdGsKd_ZhpCbNchOXudkmig(com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationBottomSheet)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->startQrCodeAuth$lambda$9(Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$sqaSe2Bpg1X4fJXwwqL2R53e9T0(com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationBottomSheet  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->onViewCreated$lambda$2(Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet; Landroid/view/View;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->Companion Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;-><init>()V
    return-void 
.end method

.method private final cancelAndDismiss()void
    .registers 2
    # ins_size=1
    const-string/jumbo v0, user_cancel
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->finishAuth(Ljava/lang/String;)V
    return-void 
.end method

.method private final finishAuth(java.lang.String)void
    .registers 5
    # ins_size=2
    iget-boolean v0, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->completed Z
    if-eqz v0, +003h
    return-void 
    const/4 v0, 1
    iput-boolean v0, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->completed Z
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->shimmerTextView Lcom/bytedance/trae/conversation/widget/ShimmerTextView;
    const/4 v2, 0
    if-eqz v1, +005h
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->setShimmerEnabled(Z)V
    invoke-direct v3, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->getMode()I
    move-result v1
    if-eqz v1, +00bh
    if-eq v1, v0, +003h
    goto +ch
    sget-object v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->INSTANCE Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->cancelDesktopRedirectAuth()V
    goto +6h
    sget-object v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->INSTANCE Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->cancelQrCodeAuth()V
    iput-boolean v2, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->authStarted Z
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->onAuthResult Lkotlin/jvm/functions/Function1;
    if-eqz v0, +005h
    invoke-interface v0, v4, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->dismissAllowingStateLoss()V
    return-void 
.end method

.method private final generateQrBitmap(java.lang.String  int)android.graphics.Bitmap
    .registers 22
    # ins_size=3
    new-instance v0, Lcom/github/alexzhirkevich/customqrgenerator/vector/QrVectorOptions$Builder;
    invoke-direct v0, Lcom/github/alexzhirkevich/customqrgenerator/vector/QrVectorOptions$Builder;-><init>()V
    const/4 v1, 0
    invoke-virtual v0, v1, Lcom/github/alexzhirkevich/customqrgenerator/vector/QrVectorOptions$Builder;->setFourthEyeEnabled(Z)Lcom/github/alexzhirkevich/customqrgenerator/vector/QrVectorOptions$Builder;
    move-result-object v0
    sget-object v1, Lcom/github/alexzhirkevich/customqrgenerator/QrErrorCorrectionLevel;->Low Lcom/github/alexzhirkevich/customqrgenerator/QrErrorCorrectionLevel;
    invoke-virtual v0, v1, Lcom/github/alexzhirkevich/customqrgenerator/vector/QrVectorOptions$Builder;->setErrorCorrectionLevel(Lcom/github/alexzhirkevich/customqrgenerator/QrErrorCorrectionLevel;)Lcom/github/alexzhirkevich/customqrgenerator/vector/QrVectorOptions$Builder;
    move-result-object v0
    new-instance v1, Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColors;
    new-instance v2, Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor$Solid;
    const/high16 v3, -16777216
    invoke-direct v2, v3, Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor$Solid;-><init>(I)V
    check-cast v2, Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor;
    new-instance v4, Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor$Solid;
    const/4 v5, -1
    invoke-direct v4, v5, Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor$Solid;-><init>(I)V
    check-cast v4, Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor;
    new-instance v5, Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor$Solid;
    invoke-direct v5, v3, Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor$Solid;-><init>(I)V
    check-cast v5, Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor;
    new-instance v6, Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor$Solid;
    invoke-direct v6, v3, Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor$Solid;-><init>(I)V
    check-cast v6, Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor;
    invoke-direct v1, v2, v4, v5, v6, Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColors;-><init>(Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor; Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor; Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor; Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColor;)V
    invoke-virtual v0, v1, Lcom/github/alexzhirkevich/customqrgenerator/vector/QrVectorOptions$Builder;->setColors(Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorColors;)Lcom/github/alexzhirkevich/customqrgenerator/vector/QrVectorOptions$Builder;
    move-result-object v0
    new-instance v9, Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorShapes;
    const/4 v2, 0
    const/4 v3, 0
    new-instance v1, Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorBallShape$Circle;
    const v4, 1061997773
    invoke-direct v1, v4, Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorBallShape$Circle;-><init>(F)V
    move-object v4, v1
    check-cast v4, Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorBallShape;
    new-instance v1, Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorFrameShape$RoundCorners;
    const/high16 v11, 1048576000
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 62
    const/16 v18, 0
    move-object v10, v1
    invoke-direct/range v10 ... v18, Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorFrameShape$RoundCorners;-><init>(F F Z Z Z Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object v5, v1
    check-cast v5, Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorFrameShape;
    const/4 v6, 0
    const/16 v7, 19
    const/4 v8, 0
    move-object v1, v9
    invoke-direct/range v1 ... v8, Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorShapes;-><init>(Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorPixelShape; Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorPixelShape; Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorBallShape; Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorFrameShape; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-virtual v0, v9, Lcom/github/alexzhirkevich/customqrgenerator/vector/QrVectorOptions$Builder;->setShapes(Lcom/github/alexzhirkevich/customqrgenerator/vector/style/QrVectorShapes;)Lcom/github/alexzhirkevich/customqrgenerator/vector/QrVectorOptions$Builder;
    move-result-object v0
    invoke-virtual v0, Lcom/github/alexzhirkevich/customqrgenerator/vector/QrVectorOptions$Builder;->build()Lcom/github/alexzhirkevich/customqrgenerator/vector/QrVectorOptions;
    move-result-object v0
    new-instance v1, Lcom/github/alexzhirkevich/customqrgenerator/QrData$Url;
    move-object/from16 v2, v20
    invoke-direct v1, v2, Lcom/github/alexzhirkevich/customqrgenerator/QrData$Url;-><init>(Ljava/lang/String;)V
    check-cast v1, Lcom/github/alexzhirkevich/customqrgenerator/QrData;
    const/4 v2, 0
    const/4 v3, 4
    invoke-static v1, v0, v2, v3, v2, Lcom/github/alexzhirkevich/customqrgenerator/vector/QrCodeDrawableKt;->QrCodeDrawable$default(Lcom/github/alexzhirkevich/customqrgenerator/QrData; Lcom/github/alexzhirkevich/customqrgenerator/vector/QrVectorOptions; Ljava/nio/charset/Charset; I Ljava/lang/Object;)Landroid/graphics/drawable/Drawable;
    move-result-object v4
    const/4 v7, 0
    const/4 v8, 4
    const/4 v9, 0
    move/from16 v5, v21
    move/from16 v6, v21
    invoke-static/range v4 ... v9, Landroidx/core/graphics/drawable/DrawableKt;->toBitmap$default(Landroid/graphics/drawable/Drawable; I I Landroid/graphics/Bitmap$Config; I Ljava/lang/Object;)Landroid/graphics/Bitmap;
    move-result-object v0
    return-object v0
.end method

.method private final getMode()int
    .registers 4
    # ins_size=1
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->getArguments()Landroid/os/Bundle;
    move-result-object v0
    const/4 v1, 0
    if-eqz v0, +008h
    const-string v2, "arg_mode"
    invoke-virtual v0, v2, v1, Landroid/os/Bundle;->getInt(Ljava/lang/String; I)I
    move-result v1
    return v1
.end method

.method private final getProviderIconRes(java.lang.String)int
    .registers 4
    # ins_size=2
    sget-object v0, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    const-string v1, "ROOT"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v3, v0, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v3
    const-string/jumbo v0, toLowerCase(...)
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v3, Ljava/lang/String;->hashCode()I
    move-result v0
    const v1, 113006579
    if-eq v0, v1, +026h
    const v1, 133862058
    if-eq v0, v1, +015h
    const v1, 136221635
    if-eq v0, v1, +003h
    goto +26h
    const-string/jumbo v0, tencent-docs
    invoke-virtual v3, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +003h
    goto +1ch
    sget v3, Lcom/bytedance/trae/conversation/R$drawable;->ic_plugin_auth_tencent_docs_logo I
    goto +1bh
    const-string v0, "dingtalk"
    invoke-virtual v3, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +003h
    goto +10h
    sget v3, Lcom/bytedance/trae/conversation/R$drawable;->ic_plugin_auth_dingtalk_logo I
    goto +fh
    const-string/jumbo v0, wecom
    invoke-virtual v3, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +005h
    sget v3, Lcom/bytedance/trae/conversation/R$drawable;->ic_plugin_auth_wecom_logo I
    goto +3h
    sget v3, Lcom/bytedance/trae/conversation/R$drawable;->ic_plugin_auth_link_connector I
    return v3
.end method

.method private static final onCreateDialog$lambda$1(com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationBottomSheet  int  android.content.DialogInterface)void
    .registers 4
    # ins_size=3
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->isAdded()Z
    move-result v1
    if-nez v1, +003h
    return-void 
    instance-of v1, v3, Lcom/google/android/material/bottomsheet/BottomSheetDialog;
    if-eqz v1, +005h
    check-cast v3, Lcom/google/android/material/bottomsheet/BottomSheetDialog;
    goto +2h
    const/4 v3, 0
    if-nez v3, +003h
    return-void 
    sget v1, Lcom/google/android/material/R$id;->design_bottom_sheet I
    invoke-virtual v3, v1, Lcom/google/android/material/bottomsheet/BottomSheetDialog;->findViewById(I)Landroid/view/View;
    move-result-object v1
    if-nez v1, +003h
    return-void 
    const v3, 17170445
    invoke-virtual v1, v3, Landroid/view/View;->setBackgroundResource(I)V
    invoke-static v1, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->from(Landroid/view/View;)Lcom/google/android/material/bottomsheet/BottomSheetBehavior;
    move-result-object v3
    invoke-virtual v3, v2, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setPeekHeight(I)V
    const/4 v0, 3
    invoke-virtual v3, v0, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setState(I)V
    const/4 v0, 1
    invoke-virtual v3, v0, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setSkipCollapsed(Z)V
    invoke-virtual v3, v0, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setHideable(Z)V
    invoke-virtual v1, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v3
    iput v2, v3, Landroid/view/ViewGroup$LayoutParams;->height I
    invoke-virtual v1, v3, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    return-void 
.end method

.method private static final onViewCreated$lambda$2(com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationBottomSheet  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->cancelAndDismiss()V
    return-void 
.end method

.method private final setupDesktopRedirectMode(android.view.View  java.lang.String)void
    .registers 7
    # ins_size=3
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->getArguments()Landroid/os/Bundle;
    move-result-object v0
    if-eqz v0, +007h
    const-string v1, "arg_localized_name"
    invoke-virtual v0, v1, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    sget v0, Lcom/bytedance/trae/conversation/R$id;->layout_desktop_content I
    invoke-virtual v5, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    const/4 v1, 0
    invoke-virtual v0, v1, Landroid/view/View;->setVisibility(I)V
    sget v0, Lcom/bytedance/trae/conversation/R$id;->iv_desktop_provider_icon I
    invoke-virtual v5, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    check-cast v0, Landroid/widget/ImageView;
    sget v1, Lcom/bytedance/trae/conversation/R$id;->tv_desktop_message I
    invoke-virtual v5, v1, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v1
    check-cast v1, Landroid/widget/TextView;
    sget v2, Lcom/bytedance/trae/conversation/R$id;->tv_desktop_shimmer I
    invoke-virtual v5, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;
    iput-object v2, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->shimmerTextView Lcom/bytedance/trae/conversation/widget/ShimmerTextView;
    sget v3, Lcom/bytedance/trae/conversation/R$id;->btn_desktop_cancel I
    invoke-virtual v5, v3, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v5
    invoke-direct v4, v6, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->getProviderIconRes(Ljava/lang/String;)I
    move-result v3
    invoke-virtual v0, v3, Landroid/widget/ImageView;->setImageResource(I)V
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_plugin_authorization_desktop_message I
    invoke-virtual v4, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->getString(I)Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v1, v0, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    const/4 v0, 1
    invoke-virtual v2, v0, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->setShimmerEnabled(Z)V
    new-instance v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet$$ExternalSyntheticLambda10;
    invoke-direct v0, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet$$ExternalSyntheticLambda10;-><init>(Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;)V
    invoke-virtual v5, v0, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    invoke-direct v4, v6, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->startDesktopRedirectAuth(Ljava/lang/String;)V
    return-void 
.end method

.method private static final setupDesktopRedirectMode$lambda$3(com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationBottomSheet  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->cancelAndDismiss()V
    return-void 
.end method

.method private final setupQrCodeMode(android.view.View  java.lang.String)void
    .registers 12
    # ins_size=3
    invoke-virtual v9, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->getArguments()Landroid/os/Bundle;
    move-result-object v0
    if-eqz v0, +009h
    const-string v1, "arg_localized_name"
    invoke-virtual v0, v1, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    if-nez v0, +004h
    const-string v0, ""
    sget v1, Lcom/bytedance/trae/conversation/R$id;->layout_qrcode_content I
    invoke-virtual v10, v1, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v1
    const/4 v2, 0
    invoke-virtual v1, v2, Landroid/view/View;->setVisibility(I)V
    sget v1, Lcom/bytedance/trae/conversation/R$id;->iv_provider_icon I
    invoke-virtual v10, v1, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v1
    check-cast v1, Landroid/widget/ImageView;
    sget v3, Lcom/bytedance/trae/conversation/R$id;->tv_status I
    invoke-virtual v10, v3, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v3
    check-cast v3, Landroid/widget/TextView;
    sget v4, Lcom/bytedance/trae/conversation/R$id;->tv_desc I
    invoke-virtual v10, v4, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v4
    check-cast v4, Landroid/widget/TextView;
    sget v5, Lcom/bytedance/trae/conversation/R$id;->iv_qrcode I
    invoke-virtual v10, v5, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v5
    check-cast v5, Landroid/widget/ImageView;
    sget v6, Lcom/bytedance/trae/conversation/R$id;->pb_qrcode_loading I
    invoke-virtual v10, v6, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v6
    check-cast v6, Landroid/widget/ProgressBar;
    sget v7, Lcom/bytedance/trae/conversation/R$id;->tv_qr_shimmer I
    invoke-virtual v10, v7, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v10
    check-cast v10, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;
    iput-object v10, v9, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->shimmerTextView Lcom/bytedance/trae/conversation/widget/ShimmerTextView;
    invoke-direct v9, v11, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->getProviderIconRes(Ljava/lang/String;)I
    move-result v7
    invoke-virtual v1, v7, Landroid/widget/ImageView;->setImageResource(I)V
    sget v1, Lcom/bytedance/trae/conversation/R$string;->trae_plugin_authorization_qrcode_status I
    const/4 v7, 1
    new-array v8, v7, [Ljava/lang/Object;
    aput-object v0, v8, v2
    invoke-virtual v9, v1, v8, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v3, v1, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget v1, Lcom/bytedance/trae/conversation/R$string;->trae_plugin_authorization_qrcode_desc I
    new-array v3, v7, [Ljava/lang/Object;
    aput-object v0, v3, v2
    invoke-virtual v9, v1, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v4, v0, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-virtual v10, v7, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->setShimmerEnabled(Z)V
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v9, v11, v5, v6, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->startQrCodeAuth(Ljava/lang/String; Landroid/widget/ImageView; Landroid/widget/ProgressBar;)V
    return-void 
.end method

.method private final startDesktopRedirectAuth(java.lang.String)void
    .registers 4
    # ins_size=2
    const/4 v0, 1
    iput-boolean v0, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->authStarted Z
    sget-object v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->INSTANCE Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;
    new-instance v1, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet$$ExternalSyntheticLambda5;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet$$ExternalSyntheticLambda5;-><init>(Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;)V
    invoke-virtual v0, v3, v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->startDesktopRedirectAuth(Ljava/lang/String; Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method

.method private static final startDesktopRedirectAuth$lambda$11(com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationBottomSheet  java.lang.String)kotlin.Unit
    .registers 4
    # ins_size=2
    const-string/jumbo v0, status
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 0
    iput-boolean v0, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->authStarted Z
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->isAdded()Z
    move-result v0
    if-nez v0, +005h
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->getView()Landroid/view/View;
    move-result-object v0
    if-eqz v0, +00ah
    new-instance v1, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet$$ExternalSyntheticLambda2;
    invoke-direct v1, v2, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet; Ljava/lang/String;)V
    invoke-virtual v0, v1, Landroid/view/View;->post(Ljava/lang/Runnable;)Z
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
.end method

.method private static final startDesktopRedirectAuth$lambda$11$lambda$10(com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationBottomSheet  java.lang.String)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->finishAuth(Ljava/lang/String;)V
    return-void 
.end method

.method private final startQrCodeAuth(java.lang.String  android.widget.ImageView  android.widget.ProgressBar)void
    .registers 6
    # ins_size=4
    const/4 v0, 1
    iput-boolean v0, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->authStarted Z
    sget-object v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->INSTANCE Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;
    new-instance v1, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet$$ExternalSyntheticLambda7;
    invoke-direct v1, v2, v5, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet$$ExternalSyntheticLambda7;-><init>(Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet; Landroid/widget/ProgressBar; Landroid/widget/ImageView;)V
    new-instance v4, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet$$ExternalSyntheticLambda8;
    invoke-direct v4, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet$$ExternalSyntheticLambda8;-><init>(Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;)V
    new-instance v5, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet$$ExternalSyntheticLambda9;
    invoke-direct v5, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet$$ExternalSyntheticLambda9;-><init>(Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;)V
    invoke-virtual v0, v3, v1, v4, v5, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->startQrCodeAuth(Ljava/lang/String; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method private static final startQrCodeAuth$lambda$5(com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationBottomSheet  android.widget.ProgressBar  android.widget.ImageView  java.lang.String)kotlin.Unit
    .registers 6
    # ins_size=4
    const-string v0, "qrcodeUrl"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->isAdded()Z
    move-result v0
    if-nez v0, +005h
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->getView()Landroid/view/View;
    move-result-object v0
    if-eqz v0, +00ah
    new-instance v1, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet$$ExternalSyntheticLambda6;
    invoke-direct v1, v3, v2, v5, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet$$ExternalSyntheticLambda6;-><init>(Landroid/widget/ProgressBar; Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet; Ljava/lang/String; Landroid/widget/ImageView;)V
    invoke-virtual v0, v1, Landroid/view/View;->post(Ljava/lang/Runnable;)Z
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
.end method

.method private static final startQrCodeAuth$lambda$5$lambda$4(android.widget.ProgressBar  com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationBottomSheet  java.lang.String  android.widget.ImageView)void
    .registers 5
    # ins_size=4
    const/16 v0, 8
    invoke-virtual v1, v0, Landroid/widget/ProgressBar;->setVisibility(I)V
    const/16 v1, 480
    invoke-direct v2, v3, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->generateQrBitmap(Ljava/lang/String; I)Landroid/graphics/Bitmap;
    move-result-object v1
    invoke-virtual v4, v1, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V
    return-void 
.end method

.method private static final startQrCodeAuth$lambda$7(com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationBottomSheet  java.lang.String)kotlin.Unit
    .registers 4
    # ins_size=2
    const-string/jumbo v0, status
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 0
    iput-boolean v0, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->authStarted Z
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->isAdded()Z
    move-result v0
    if-nez v0, +005h
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->getView()Landroid/view/View;
    move-result-object v0
    if-eqz v0, +00ah
    new-instance v1, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet$$ExternalSyntheticLambda4;
    invoke-direct v1, v2, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet$$ExternalSyntheticLambda4;-><init>(Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet; Ljava/lang/String;)V
    invoke-virtual v0, v1, Landroid/view/View;->post(Ljava/lang/Runnable;)Z
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
.end method

.method private static final startQrCodeAuth$lambda$7$lambda$6(com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationBottomSheet  java.lang.String)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->finishAuth(Ljava/lang/String;)V
    return-void 
.end method

.method private static final startQrCodeAuth$lambda$9(com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationBottomSheet)kotlin.Unit
    .registers 3
    # ins_size=1
    const/4 v0, 0
    iput-boolean v0, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->authStarted Z
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->isAdded()Z
    move-result v0
    if-nez v0, +005h
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->getView()Landroid/view/View;
    move-result-object v0
    if-eqz v0, +00ah
    new-instance v1, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet$$ExternalSyntheticLambda3;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;)V
    invoke-virtual v0, v1, Landroid/view/View;->post(Ljava/lang/Runnable;)Z
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
.end method

.method private static final startQrCodeAuth$lambda$9$lambda$8(com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationBottomSheet)void
    .registers 2
    # ins_size=1
    const-string/jumbo v0, user_cancel
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->finishAuth(Ljava/lang/String;)V
    return-void 
.end method

.method public final getOnAuthResult()kotlin.jvm.functions.Function1
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->onAuthResult Lkotlin/jvm/functions/Function1;
    return-object v0
.end method

.method public onCreateDialog(android.os.Bundle)android.app.Dialog
    .registers 6
    # ins_size=2
    invoke-super v4, v5, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;->onCreateDialog(Landroid/os/Bundle;)Landroid/app/Dialog;
    move-result-object v5
    const-string v0, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v5, Lcom/google/android/material/bottomsheet/BottomSheetDialog;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    invoke-virtual v0, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v0
    iget v0, v0, Landroid/util/DisplayMetrics;->heightPixels I
    int-to-double v0, v0
    const-wide v2, 4606281698874543309
    mul-double/2addr v0, v2
    double-to-int v0, v0
    new-instance v1, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet$$ExternalSyntheticLambda1;
    invoke-direct v1, v4, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet; I)V
    invoke-virtual v5, v1, Lcom/google/android/material/bottomsheet/BottomSheetDialog;->setOnShowListener(Landroid/content/DialogInterface$OnShowListener;)V
    check-cast v5, Landroid/app/Dialog;
    return-object v5
.end method

.method public onCreateView(android.view.LayoutInflater  android.view.ViewGroup  android.os.Bundle)android.view.View
    .registers 5
    # ins_size=4
    const-string v4, "inflater"
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget v4, Lcom/bytedance/trae/conversation/R$layout;->trae_bottom_sheet_plugin_auth_qrcode I
    const/4 v0, 0
    invoke-virtual v2, v4, v3, v0, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    return-object v2
.end method

.method public onDestroyView()void
    .registers 3
    # ins_size=1
    iget-boolean v0, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->authStarted Z
    const/4 v1, 1
    if-eqz v0, +016h
    invoke-direct v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->getMode()I
    move-result v0
    if-eqz v0, +00bh
    if-eq v0, v1, +003h
    goto +ch
    sget-object v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->INSTANCE Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->cancelDesktopRedirectAuth()V
    goto +6h
    sget-object v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->INSTANCE Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->cancelQrCodeAuth()V
    iget-boolean v0, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->completed Z
    if-nez v0, +00eh
    iput-boolean v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->completed Z
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->onAuthResult Lkotlin/jvm/functions/Function1;
    if-eqz v0, +008h
    const-string/jumbo v1, user_cancel
    invoke-interface v0, v1, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    invoke-super v2, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;->onDestroyView()V
    return-void 
.end method

.method public onViewCreated(android.view.View  android.os.Bundle)void
    .registers 9
    # ins_size=3
    const-string/jumbo v0, view
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v6, v7, v8, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;->onViewCreated(Landroid/view/View; Landroid/os/Bundle;)V
    invoke-virtual v6, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->getArguments()Landroid/os/Bundle;
    move-result-object v8
    const/4 v0, 0
    if-eqz v8, +009h
    const-string v1, "arg_provider"
    invoke-virtual v8, v1, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v8
    goto +2h
    move-object v8, v0
    const-string v1, ""
    if-nez v8, +003h
    move-object v8, v1
    invoke-virtual v6, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->getArguments()Landroid/os/Bundle;
    move-result-object v2
    if-eqz v2, +008h
    const-string v0, "arg_provider_display_name"
    invoke-virtual v2, v0, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    if-nez v0, +003h
    goto +2h
    move-object v1, v0
    sget v0, Lcom/bytedance/trae/conversation/R$id;->title_bar I
    invoke-virtual v7, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;
    new-instance v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet$$ExternalSyntheticLambda0;
    invoke-direct v2, v6, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;)V
    invoke-virtual v0, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setOnRightActionClickListener(Landroid/view/View$OnClickListener;)V
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_footer I
    invoke-virtual v7, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    check-cast v0, Landroid/widget/TextView;
    sget v2, Lcom/bytedance/trae/conversation/R$string;->trae_plugin_authorization_desktop_footer I
    const/4 v3, 1
    new-array v4, v3, [Ljava/lang/Object;
    const/4 v5, 0
    aput-object v1, v4, v5
    invoke-virtual v6, v2, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v0, v1, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-direct v6, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->getMode()I
    move-result v0
    if-eqz v0, +009h
    if-eq v0, v3, +003h
    goto +8h
    invoke-direct v6, v7, v8, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->setupDesktopRedirectMode(Landroid/view/View; Ljava/lang/String;)V
    goto +4h
    invoke-direct v6, v7, v8, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->setupQrCodeMode(Landroid/view/View; Ljava/lang/String;)V
    return-void 
.end method

.method public final setOnAuthResult(kotlin.jvm.functions.Function1)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->onAuthResult Lkotlin/jvm/functions/Function1;
    return-void 
.end method
