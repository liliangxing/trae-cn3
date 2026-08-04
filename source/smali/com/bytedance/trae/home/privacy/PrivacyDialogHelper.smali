# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/privacy/PrivacyDialogHelper;
.super Ljava/lang/Object;
.source "PrivacyDialogHelper.kt"

.field public static final $stable:I
.field public static final INSTANCE:Lcom/bytedance/trae/home/privacy/PrivacyDialogHelper;
.field private static final TAG:Ljava/lang/String;


.method public static synthetic $r8$lambda$le2dSqzEI5HNISeImSla-Xs4S48(android.app.Dialog  kotlin.jvm.functions.Function0  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/privacy/PrivacyDialogHelper;->showDialog$lambda$2(Landroid/app/Dialog; Lkotlin/jvm/functions/Function0; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$rp-ITxe_1Nx3GfOeufB0hq5aY-w(android.app.Dialog  kotlin.jvm.functions.Function0  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/privacy/PrivacyDialogHelper;->showDialog$lambda$3(Landroid/app/Dialog; Lkotlin/jvm/functions/Function0; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$suGfvvZ0PRGYwqbR9AeTdqPlWAk(android.view.Window  int  androidx.activity.ComponentActivity)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/privacy/PrivacyDialogHelper;->showDialog$lambda$1$lambda$0(Landroid/view/Window; I Landroidx/activity/ComponentActivity;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/privacy/PrivacyDialogHelper;
    invoke-direct v0, Lcom/bytedance/trae/home/privacy/PrivacyDialogHelper;-><init>()V
    sput-object v0, Lcom/bytedance/trae/home/privacy/PrivacyDialogHelper;->INSTANCE Lcom/bytedance/trae/home/privacy/PrivacyDialogHelper;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static final synthetic access$openUrl(com.bytedance.trae.home.privacy.PrivacyDialogHelper  androidx.activity.ComponentActivity  java.lang.String)void
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/home/privacy/PrivacyDialogHelper;->openUrl(Landroidx/activity/ComponentActivity; Ljava/lang/String;)V
    return-void 
.end method

.method private final getBaseDomain()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v0
    if-eqz v0, +006h
    const-string/jumbo v0, trae.ai
    goto +4h
    const-string/jumbo v0, trae.cn
    return-object v0
.end method

.method private final openUrl(androidx.activity.ComponentActivity  java.lang.String)void
    .registers 4
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/utils/AgreementUrlOpener;->INSTANCE Lcom/bytedance/trae/utils/AgreementUrlOpener;
    check-cast v2, Landroid/content/Context;
    invoke-virtual v0, v2, v3, Lcom/bytedance/trae/utils/AgreementUrlOpener;->open(Landroid/content/Context; Ljava/lang/String;)V
    goto +5h
    move-exception v2
    invoke-virtual v2, Ljava/lang/Exception;->printStackTrace()V
    return-void 
    :try_start_0x0
.end method

.method private final setupLegalNotice(androidx.activity.ComponentActivity  android.view.View)void
    .registers 4
    # ins_size=3
    sget v0, Lcom/bytedance/trae/home/R$id;->tv_legal_notice I
    invoke-virtual v3, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v3
    check-cast v3, Landroid/widget/TextView;
    if-nez v3, +003h
    return-void 
    sget v0, Lcom/bytedance/trae/home/R$string;->trae_privacy_dialog_legal_notice I
    invoke-virtual v2, v0, Landroidx/activity/ComponentActivity;->getString(I)Ljava/lang/String;
    move-result-object v2
    check-cast v2, Ljava/lang/CharSequence;
    invoke-virtual v3, v2, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    return-void 
.end method

.method private static final showDialog$lambda$1$lambda$0(android.view.Window  int  androidx.activity.ComponentActivity)void
    .registers 7
    # ins_size=3
    invoke-virtual v4, Landroid/view/Window;->getDecorView()Landroid/view/View;
    move-result-object v0
    invoke-virtual v0, Landroid/view/View;->getHeight()I
    move-result v0
    if-le v0, v5, +017h
    invoke-virtual v6, Landroidx/activity/ComponentActivity;->getResources()Landroid/content/res/Resources;
    move-result-object v6
    invoke-virtual v6, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v6
    iget v6, v6, Landroid/util/DisplayMetrics;->widthPixels I
    int-to-double v0, v6
    const-wide v2, 4605831338911806259
    mul-double/2addr v0, v2
    double-to-int v6, v0
    invoke-virtual v4, v6, v5, Landroid/view/Window;->setLayout(I I)V
    return-void 
.end method

.method private static final showDialog$lambda$2(android.app.Dialog  kotlin.jvm.functions.Function0  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-virtual v0, Landroid/app/Dialog;->dismiss()V
    invoke-interface v1, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
.end method

.method private static final showDialog$lambda$3(android.app.Dialog  kotlin.jvm.functions.Function0  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-virtual v0, Landroid/app/Dialog;->dismiss()V
    invoke-interface v1, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
.end method

.method public final setupMessageWithLinks(androidx.activity.ComponentActivity  android.view.View)void
    .registers 19
    # ins_size=3
    move-object/from16 v0, v17
    move-object/from16 v1, v18
    const-string v2, "activity"
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v2, view
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget v2, Lcom/bytedance/trae/home/R$id;->tv_message I
    invoke-virtual v1, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    check-cast v2, Landroid/widget/TextView;
    sget v3, Lcom/bytedance/trae/home/R$string;->trae_privacy_dialog_message I
    invoke-virtual v0, v3, Landroidx/activity/ComponentActivity;->getString(I)Ljava/lang/String;
    move-result-object v3
    const-string v4, "getString(...)"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v5, Lcom/bytedance/trae/home/R$string;->trae_privacy_dialog_terms I
    invoke-virtual v0, v5, Landroidx/activity/ComponentActivity;->getString(I)Ljava/lang/String;
    move-result-object v5
    invoke-static v5, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v6, Lcom/bytedance/trae/home/R$string;->trae_privacy_dialog_privacy I
    invoke-virtual v0, v6, Landroidx/activity/ComponentActivity;->getString(I)Ljava/lang/String;
    move-result-object v13
    invoke-static v13, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v4, Landroid/text/SpannableString;
    check-cast v3, Ljava/lang/CharSequence;
    invoke-direct v4, v3, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 6
    const/4 v11, 0
    move-object v6, v3
    move-object v7, v5
    invoke-static/range v6 ... v11, Lkotlin/text/StringsKt;->indexOf$default(Ljava/lang/CharSequence; Ljava/lang/String; I Z I Ljava/lang/Object;)I
    move-result v6
    const/16 v14, 33
    const-string v15, "https://www."
    if-ltz v6, +026h
    new-instance v7, Ljava/lang/StringBuilder;
    invoke-direct v7, v15, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-direct/range v16, Lcom/bytedance/trae/home/privacy/PrivacyDialogHelper;->getBaseDomain()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v8, "/terms-of-service"
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    new-instance v8, Lcom/bytedance/trae/home/privacy/PrivacyDialogHelper$setupMessageWithLinks$1;
    invoke-direct v8, v0, v7, Lcom/bytedance/trae/home/privacy/PrivacyDialogHelper$setupMessageWithLinks$1;-><init>(Landroidx/activity/ComponentActivity; Ljava/lang/String;)V
    invoke-virtual v5, Ljava/lang/String;->length()I
    move-result v5
    add-int/2addr v5, v6
    invoke-virtual v4, v8, v6, v5, v14, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object; I I I)V
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 6
    const/4 v12, 0
    move-object v7, v3
    move-object v8, v13
    invoke-static/range v7 ... v12, Lkotlin/text/StringsKt;->indexOf$default(Ljava/lang/CharSequence; Ljava/lang/String; I Z I Ljava/lang/Object;)I
    move-result v3
    if-ltz v3, +026h
    new-instance v5, Ljava/lang/StringBuilder;
    invoke-direct v5, v15, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-direct/range v16, Lcom/bytedance/trae/home/privacy/PrivacyDialogHelper;->getBaseDomain()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v6, "/privacy-policy"
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    new-instance v6, Lcom/bytedance/trae/home/privacy/PrivacyDialogHelper$setupMessageWithLinks$2;
    invoke-direct v6, v0, v5, Lcom/bytedance/trae/home/privacy/PrivacyDialogHelper$setupMessageWithLinks$2;-><init>(Landroidx/activity/ComponentActivity; Ljava/lang/String;)V
    invoke-virtual v13, Ljava/lang/String;->length()I
    move-result v5
    add-int/2addr v5, v3
    invoke-virtual v4, v6, v3, v5, v14, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object; I I I)V
    check-cast v4, Ljava/lang/CharSequence;
    invoke-virtual v2, v4, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-static Landroid/text/method/LinkMovementMethod;->getInstance()Landroid/text/method/MovementMethod;
    move-result-object v3
    invoke-virtual v2, v3, Landroid/widget/TextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V
    const/4 v3, 0
    invoke-virtual v2, v3, Landroid/widget/TextView;->setHighlightColor(I)V
    invoke-direct/range v16 ... v18, Lcom/bytedance/trae/home/privacy/PrivacyDialogHelper;->setupLegalNotice(Landroidx/activity/ComponentActivity; Landroid/view/View;)V
    return-void 
.end method

.method public final showDialog(androidx.activity.ComponentActivity  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0)void
    .registers 13
    # ins_size=4
    const-string v0, "activity"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onAgree"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onDisagree"
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Ljava/lang/StringBuilder;
    const-string/jumbo v1, showDialog curMills = 
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v1
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    const-string v1, "PrivacyDialogHelper"
    invoke-static v1, v0, Landroid/util/Log;->d(Ljava/lang/String; Ljava/lang/String;)I
    new-instance v0, Landroid/app/Dialog;
    move-object v1, v10
    check-cast v1, Landroid/content/Context;
    invoke-direct v0, v1, Landroid/app/Dialog;-><init>(Landroid/content/Context;)V
    invoke-static v1, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;
    move-result-object v1
    sget v2, Lcom/bytedance/trae/home/R$layout;->dialog_privacy I
    const/4 v3, 0
    invoke-virtual v1, v2, v3, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup;)Landroid/view/View;
    move-result-object v1
    invoke-virtual v0, v1, Landroid/app/Dialog;->setContentView(Landroid/view/View;)V
    invoke-virtual v0, Landroid/app/Dialog;->getWindow()Landroid/view/Window;
    move-result-object v2
    const/4 v3, 0
    if-eqz v2, +04ah
    new-instance v4, Landroid/graphics/drawable/ColorDrawable;
    invoke-direct v4, v3, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V
    check-cast v4, Landroid/graphics/drawable/Drawable;
    invoke-virtual v2, v4, Landroid/view/Window;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V
    invoke-virtual v10, Landroidx/activity/ComponentActivity;->getResources()Landroid/content/res/Resources;
    move-result-object v4
    invoke-virtual v4, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v4
    iget v4, v4, Landroid/util/DisplayMetrics;->heightPixels I
    int-to-double v4, v4
    const-wide v6, 4605380978949069210
    mul-double/2addr v4, v6
    double-to-int v4, v4
    invoke-virtual v10, Landroidx/activity/ComponentActivity;->getResources()Landroid/content/res/Resources;
    move-result-object v5
    invoke-virtual v5, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v5
    iget v5, v5, Landroid/util/DisplayMetrics;->widthPixels I
    int-to-double v5, v5
    const-wide v7, 4605831338911806259
    mul-double/2addr v5, v7
    double-to-int v5, v5
    const/4 v6, -2
    invoke-virtual v2, v5, v6, Landroid/view/Window;->setLayout(I I)V
    invoke-virtual v2, Landroid/view/Window;->getDecorView()Landroid/view/View;
    move-result-object v5
    new-instance v6, Lcom/bytedance/trae/home/privacy/PrivacyDialogHelper$$ExternalSyntheticLambda0;
    invoke-direct v6, v2, v4, v10, Lcom/bytedance/trae/home/privacy/PrivacyDialogHelper$$ExternalSyntheticLambda0;-><init>(Landroid/view/Window; I Landroidx/activity/ComponentActivity;)V
    invoke-virtual v5, v6, Landroid/view/View;->post(Ljava/lang/Runnable;)Z
    const/16 v4, 17
    invoke-virtual v2, v4, Landroid/view/Window;->setGravity(I)V
    const/high16 v4, 1056964608
    invoke-virtual v2, v4, Landroid/view/Window;->setDimAmount(F)V
    invoke-virtual v0, v3, Landroid/app/Dialog;->setCancelable(Z)V
    invoke-virtual v0, v3, Landroid/app/Dialog;->setCanceledOnTouchOutside(Z)V
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual v9, v10, v1, Lcom/bytedance/trae/home/privacy/PrivacyDialogHelper;->setupMessageWithLinks(Landroidx/activity/ComponentActivity; Landroid/view/View;)V
    sget v10, Lcom/bytedance/trae/home/R$id;->btn_agree I
    invoke-virtual v1, v10, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v10
    check-cast v10, Landroid/widget/TextView;
    new-instance v2, Lcom/bytedance/trae/home/privacy/PrivacyDialogHelper$$ExternalSyntheticLambda1;
    invoke-direct v2, v0, v11, Lcom/bytedance/trae/home/privacy/PrivacyDialogHelper$$ExternalSyntheticLambda1;-><init>(Landroid/app/Dialog; Lkotlin/jvm/functions/Function0;)V
    invoke-virtual v10, v2, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    sget v10, Lcom/bytedance/trae/home/R$id;->btn_disagree I
    invoke-virtual v1, v10, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v10
    check-cast v10, Landroid/widget/TextView;
    new-instance v11, Lcom/bytedance/trae/home/privacy/PrivacyDialogHelper$$ExternalSyntheticLambda2;
    invoke-direct v11, v0, v12, Lcom/bytedance/trae/home/privacy/PrivacyDialogHelper$$ExternalSyntheticLambda2;-><init>(Landroid/app/Dialog; Lkotlin/jvm/functions/Function0;)V
    invoke-virtual v10, v11, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    invoke-virtual v0, Landroid/app/Dialog;->show()V
    return-void 
.end method
