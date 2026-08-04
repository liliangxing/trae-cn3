# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/activity/AgreementDialog;
.super Landroid/app/Dialog;
.source "AgreementDialog.kt"

.field private final onAgreeClick:Lkotlin/jvm/functions/Function0;
.field private final onDisagreeClick:Lkotlin/jvm/functions/Function0;


.method public static synthetic $r8$lambda$-Fm6AiyIeEGTRzsUZFIeSJanPO4()kotlin.Unit
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/login/activity/AgreementDialog;->_init_$lambda$0()Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$I-Nk0SThe1Pjr8yvqjxuetIvWus(android.view.Window  int)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/activity/AgreementDialog;->onCreate$lambda$3$lambda$2(Landroid/view/Window; I)V
    return-void 
.end method

.method public static synthetic $r8$lambda$W_UJpsqYkuIcRSnmG4nqmTC3-Pw(com.bytedance.trae.login.activity.AgreementDialog  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/activity/AgreementDialog;->onCreate$lambda$4(Lcom/bytedance/trae/login/activity/AgreementDialog; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$rdQoYlFuANB-fh4oMLPO8z-osBw()kotlin.Unit
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/login/activity/AgreementDialog;->_init_$lambda$1()Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$u3fwbVXgtQPLSmIiooMCYJ-Gfp4(com.bytedance.trae.login.activity.AgreementDialog  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/login/activity/AgreementDialog;->onCreate$lambda$5(Lcom/bytedance/trae/login/activity/AgreementDialog; Landroid/view/View;)V
    return-void 
.end method

.method public constructor <init>(android.content.Context  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0)void
    .registers 5
    # ins_size=4
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, onAgreeClick
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, onDisagreeClick
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, Landroid/app/Dialog;-><init>(Landroid/content/Context;)V
    iput-object v3, v1, Lcom/bytedance/trae/login/activity/AgreementDialog;->onAgreeClick Lkotlin/jvm/functions/Function0;
    iput-object v4, v1, Lcom/bytedance/trae/login/activity/AgreementDialog;->onDisagreeClick Lkotlin/jvm/functions/Function0;
    return-void 
.end method

.method public synthetic constructor <init>(android.content.Context  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 6
    # ins_size=6
    and-int/lit8 v5, v4, 2
    if-eqz v5, +007h
    new-instance v2, Lcom/bytedance/trae/login/activity/AgreementDialog$$ExternalSyntheticLambda3;
    invoke-direct v2, Lcom/bytedance/trae/login/activity/AgreementDialog$$ExternalSyntheticLambda3;-><init>()V
    and-int/lit8 v4, v4, 4
    if-eqz v4, +007h
    new-instance v3, Lcom/bytedance/trae/login/activity/AgreementDialog$$ExternalSyntheticLambda4;
    invoke-direct v3, Lcom/bytedance/trae/login/activity/AgreementDialog$$ExternalSyntheticLambda4;-><init>()V
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/login/activity/AgreementDialog;-><init>(Landroid/content/Context; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method private static final _init_$lambda$0()kotlin.Unit
    .registers 1
    # ins_size=0
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final _init_$lambda$1()kotlin.Unit
    .registers 1
    # ins_size=0
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method public static final synthetic access$openUrl(com.bytedance.trae.login.activity.AgreementDialog  java.lang.String)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/login/activity/AgreementDialog;->openUrl(Ljava/lang/String;)V
    return-void 
.end method

.method private static final onCreate$lambda$3$lambda$2(android.view.Window  int)void
    .registers 3
    # ins_size=2
    invoke-virtual v1, Landroid/view/Window;->getDecorView()Landroid/view/View;
    move-result-object v0
    invoke-virtual v0, Landroid/view/View;->getHeight()I
    move-result v0
    if-le v0, v2, +006h
    const/4 v0, -2
    invoke-virtual v1, v0, v2, Landroid/view/Window;->setLayout(I I)V
    return-void 
.end method

.method private static final onCreate$lambda$4(com.bytedance.trae.login.activity.AgreementDialog  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-virtual v0, Lcom/bytedance/trae/login/activity/AgreementDialog;->dismiss()V
    iget-object v0, v0, Lcom/bytedance/trae/login/activity/AgreementDialog;->onAgreeClick Lkotlin/jvm/functions/Function0;
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
.end method

.method private static final onCreate$lambda$5(com.bytedance.trae.login.activity.AgreementDialog  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-virtual v0, Lcom/bytedance/trae/login/activity/AgreementDialog;->dismiss()V
    iget-object v0, v0, Lcom/bytedance/trae/login/activity/AgreementDialog;->onDisagreeClick Lkotlin/jvm/functions/Function0;
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
.end method

.method private final openUrl(java.lang.String)void
    .registers 5
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/utils/AgreementUrlOpener;->INSTANCE Lcom/bytedance/trae/utils/AgreementUrlOpener;
    invoke-virtual v3, Lcom/bytedance/trae/login/activity/AgreementDialog;->getContext()Landroid/content/Context;
    move-result-object v1
    const-string v2, "getContext(...)"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v0, v1, v4, Lcom/bytedance/trae/utils/AgreementUrlOpener;->open(Landroid/content/Context; Ljava/lang/String;)V
    return-void 
    :try_start_0x0
.end method

.method private final setupLegalNotice()void
    .registers 4
    # ins_size=1
    sget v0, Lcom/bytedance/trae/login/R$id;->tv_legal_notice I
    invoke-virtual v3, v0, Lcom/bytedance/trae/login/activity/AgreementDialog;->findViewById(I)Landroid/view/View;
    move-result-object v0
    check-cast v0, Landroid/widget/TextView;
    if-nez v0, +003h
    return-void 
    invoke-virtual v3, Lcom/bytedance/trae/login/activity/AgreementDialog;->getContext()Landroid/content/Context;
    move-result-object v1
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->trae_agreement_dialog_legal_notice I
    invoke-virtual v1, v2, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v0, v1, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    return-void 
.end method

.method private final setupMessageWithLinks()void
    .registers 14
    # ins_size=1
    sget v0, Lcom/bytedance/trae/login/R$id;->tv_message I
    invoke-virtual v13, v0, Lcom/bytedance/trae/login/activity/AgreementDialog;->findViewById(I)Landroid/view/View;
    move-result-object v0
    check-cast v0, Landroid/widget/TextView;
    invoke-virtual v13, Lcom/bytedance/trae/login/activity/AgreementDialog;->getContext()Landroid/content/Context;
    move-result-object v1
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->trae_agreement_dialog_message I
    invoke-virtual v1, v2, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v1
    const-string v2, "getString(...)"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v13, Lcom/bytedance/trae/login/activity/AgreementDialog;->getContext()Landroid/content/Context;
    move-result-object v3
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->trae_agreement_dialog_terms I
    invoke-virtual v3, v4, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v13, Lcom/bytedance/trae/login/activity/AgreementDialog;->getContext()Landroid/content/Context;
    move-result-object v4
    sget v5, Lcom/bytedance/trae/multilanguage/R$string;->trae_agreement_dialog_privacy I
    invoke-virtual v4, v5, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v4
    invoke-static v4, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v2, Landroid/text/SpannableString;
    check-cast v1, Ljava/lang/CharSequence;
    invoke-direct v2, v1, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 6
    const/4 v10, 0
    move-object v5, v1
    move-object v6, v3
    invoke-static/range v5 ... v10, Lkotlin/text/StringsKt;->indexOf$default(Ljava/lang/CharSequence; Ljava/lang/String; I Z I Ljava/lang/Object;)I
    move-result v5
    const/16 v12, 33
    if-ltz v5, +00fh
    new-instance v6, Lcom/bytedance/trae/login/activity/AgreementDialog$setupMessageWithLinks$1;
    invoke-direct v6, v13, Lcom/bytedance/trae/login/activity/AgreementDialog$setupMessageWithLinks$1;-><init>(Lcom/bytedance/trae/login/activity/AgreementDialog;)V
    invoke-virtual v3, Ljava/lang/String;->length()I
    move-result v3
    add-int/2addr v3, v5
    invoke-virtual v2, v6, v5, v3, v12, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object; I I I)V
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 6
    const/4 v11, 0
    move-object v6, v1
    move-object v7, v4
    invoke-static/range v6 ... v11, Lkotlin/text/StringsKt;->indexOf$default(Ljava/lang/CharSequence; Ljava/lang/String; I Z I Ljava/lang/Object;)I
    move-result v1
    if-ltz v1, +00fh
    new-instance v3, Lcom/bytedance/trae/login/activity/AgreementDialog$setupMessageWithLinks$2;
    invoke-direct v3, v13, Lcom/bytedance/trae/login/activity/AgreementDialog$setupMessageWithLinks$2;-><init>(Lcom/bytedance/trae/login/activity/AgreementDialog;)V
    invoke-virtual v4, Ljava/lang/String;->length()I
    move-result v4
    add-int/2addr v4, v1
    invoke-virtual v2, v3, v1, v4, v12, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object; I I I)V
    check-cast v2, Ljava/lang/CharSequence;
    invoke-virtual v0, v2, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-static Landroid/text/method/LinkMovementMethod;->getInstance()Landroid/text/method/MovementMethod;
    move-result-object v1
    invoke-virtual v0, v1, Landroid/widget/TextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V
    const/4 v1, 0
    invoke-virtual v0, v1, Landroid/widget/TextView;->setHighlightColor(I)V
    return-void 
.end method

.method protected onCreate(android.os.Bundle)void
    .registers 7
    # ins_size=2
    invoke-super v5, v6, Landroid/app/Dialog;->onCreate(Landroid/os/Bundle;)V
    sget v6, Lcom/bytedance/trae/login/R$layout;->trae_dialog_agreement I
    invoke-virtual v5, v6, Lcom/bytedance/trae/login/activity/AgreementDialog;->setContentView(I)V
    invoke-virtual v5, Lcom/bytedance/trae/login/activity/AgreementDialog;->getWindow()Landroid/view/Window;
    move-result-object v6
    const/4 v0, 0
    if-eqz v6, +03dh
    new-instance v1, Landroid/graphics/drawable/ColorDrawable;
    invoke-direct v1, v0, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V
    check-cast v1, Landroid/graphics/drawable/Drawable;
    invoke-virtual v6, v1, Landroid/view/Window;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V
    const/4 v1, -2
    invoke-virtual v6, v1, v1, Landroid/view/Window;->setLayout(I I)V
    invoke-virtual v6, Landroid/view/Window;->getContext()Landroid/content/Context;
    move-result-object v1
    invoke-virtual v1, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v1
    invoke-virtual v1, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v1
    iget v1, v1, Landroid/util/DisplayMetrics;->heightPixels I
    int-to-double v1, v1
    const-wide v3, 4604480259023595110
    mul-double/2addr v1, v3
    double-to-int v1, v1
    invoke-virtual v6, Landroid/view/Window;->getDecorView()Landroid/view/View;
    move-result-object v2
    new-instance v3, Lcom/bytedance/trae/login/activity/AgreementDialog$$ExternalSyntheticLambda0;
    invoke-direct v3, v6, v1, Lcom/bytedance/trae/login/activity/AgreementDialog$$ExternalSyntheticLambda0;-><init>(Landroid/view/Window; I)V
    invoke-virtual v2, v3, Landroid/view/View;->post(Ljava/lang/Runnable;)Z
    const/16 v1, 17
    invoke-virtual v6, v1, Landroid/view/Window;->setGravity(I)V
    const v1, 1053609165
    invoke-virtual v6, v1, Landroid/view/Window;->setDimAmount(F)V
    invoke-virtual v5, v0, Lcom/bytedance/trae/login/activity/AgreementDialog;->setCancelable(Z)V
    invoke-virtual v5, v0, Lcom/bytedance/trae/login/activity/AgreementDialog;->setCanceledOnTouchOutside(Z)V
    invoke-direct v5, Lcom/bytedance/trae/login/activity/AgreementDialog;->setupMessageWithLinks()V
    invoke-direct v5, Lcom/bytedance/trae/login/activity/AgreementDialog;->setupLegalNotice()V
    sget v6, Lcom/bytedance/trae/login/R$id;->btn_agree I
    invoke-virtual v5, v6, Lcom/bytedance/trae/login/activity/AgreementDialog;->findViewById(I)Landroid/view/View;
    move-result-object v6
    new-instance v0, Lcom/bytedance/trae/login/activity/AgreementDialog$$ExternalSyntheticLambda1;
    invoke-direct v0, v5, Lcom/bytedance/trae/login/activity/AgreementDialog$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/login/activity/AgreementDialog;)V
    invoke-virtual v6, v0, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    sget v6, Lcom/bytedance/trae/login/R$id;->btn_disagree I
    invoke-virtual v5, v6, Lcom/bytedance/trae/login/activity/AgreementDialog;->findViewById(I)Landroid/view/View;
    move-result-object v6
    new-instance v0, Lcom/bytedance/trae/login/activity/AgreementDialog$$ExternalSyntheticLambda2;
    invoke-direct v0, v5, Lcom/bytedance/trae/login/activity/AgreementDialog$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/login/activity/AgreementDialog;)V
    invoke-virtual v6, v0, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method
