# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/widget/AiDataNoticeHelper;
.super Ljava/lang/Object;
.source "AiDataNoticeHelper.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/widget/AiDataNoticeHelper;
.field private static final KEY_ACCEPTED:Ljava/lang/String;
.field private static final PREFS_NAME:Ljava/lang/String;


.method public static synthetic $r8$lambda$koH2gPBuAgByM_-bSJDnZz4CnRA(androidx.activity.ComponentActivity  android.app.Dialog  kotlin.jvm.functions.Function0  android.view.View)void
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/conversation/widget/AiDataNoticeHelper;->showIfNeeded$lambda$1(Landroidx/activity/ComponentActivity; Landroid/app/Dialog; Lkotlin/jvm/functions/Function0; Landroid/view/View;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/widget/AiDataNoticeHelper;
    invoke-direct v0, Lcom/bytedance/trae/conversation/widget/AiDataNoticeHelper;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/widget/AiDataNoticeHelper;->INSTANCE Lcom/bytedance/trae/conversation/widget/AiDataNoticeHelper;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private static final showIfNeeded$lambda$1(androidx.activity.ComponentActivity  android.app.Dialog  kotlin.jvm.functions.Function0  android.view.View)void
    .registers 5
    # ins_size=4
    const-string v4, "ai_data_notice"
    const/4 v0, 0
    invoke-virtual v1, v4, v0, Landroidx/activity/ComponentActivity;->getSharedPreferences(Ljava/lang/String; I)Landroid/content/SharedPreferences;
    move-result-object v1
    invoke-interface v1, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;
    move-result-object v1
    const-string v4, "accepted"
    const/4 v0, 1
    invoke-interface v1, v4, v0, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String; Z)Landroid/content/SharedPreferences$Editor;
    move-result-object v1
    invoke-interface v1, Landroid/content/SharedPreferences$Editor;->apply()V
    invoke-virtual v2, Landroid/app/Dialog;->dismiss()V
    invoke-interface v3, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
.end method

.method public final isAccepted(android.content.Context)boolean
    .registers 4
    # ins_size=2
    const-string v0, "context"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "ai_data_notice"
    const/4 v1, 0
    invoke-virtual v3, v0, v1, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String; I)Landroid/content/SharedPreferences;
    move-result-object v3
    const-string v0, "accepted"
    invoke-interface v3, v0, v1, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String; Z)Z
    move-result v3
    return v3
.end method

.method public final showIfNeeded(androidx.activity.ComponentActivity  kotlin.jvm.functions.Function0)void
    .registers 14
    # ins_size=3
    const-string v0, "activity"
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onAccepted"
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v0, v12
    check-cast v0, Landroid/content/Context;
    invoke-virtual v11, v0, Lcom/bytedance/trae/conversation/widget/AiDataNoticeHelper;->isAccepted(Landroid/content/Context;)Z
    move-result v1
    if-eqz v1, +006h
    invoke-interface v13, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
    new-instance v1, Landroid/app/Dialog;
    invoke-direct v1, v0, Landroid/app/Dialog;-><init>(Landroid/content/Context;)V
    invoke-static v0, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;
    move-result-object v0
    sget v2, Lcom/bytedance/trae/conversation/R$layout;->dialog_ai_data_notice I
    const/4 v3, 0
    invoke-virtual v0, v2, v3, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup;)Landroid/view/View;
    move-result-object v0
    invoke-virtual v1, v0, Landroid/app/Dialog;->setContentView(Landroid/view/View;)V
    invoke-virtual v1, Landroid/app/Dialog;->getWindow()Landroid/view/Window;
    move-result-object v2
    const/4 v3, 0
    if-eqz v2, +02ch
    new-instance v4, Landroid/graphics/drawable/ColorDrawable;
    invoke-direct v4, v3, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V
    check-cast v4, Landroid/graphics/drawable/Drawable;
    invoke-virtual v2, v4, Landroid/view/Window;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V
    invoke-virtual v12, Landroidx/activity/ComponentActivity;->getResources()Landroid/content/res/Resources;
    move-result-object v4
    invoke-virtual v4, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v4
    iget v4, v4, Landroid/util/DisplayMetrics;->widthPixels I
    int-to-double v4, v4
    const-wide v6, 4605831338911806259
    mul-double/2addr v4, v6
    double-to-int v4, v4
    const/4 v5, -2
    invoke-virtual v2, v4, v5, Landroid/view/Window;->setLayout(I I)V
    const/16 v4, 17
    invoke-virtual v2, v4, Landroid/view/Window;->setGravity(I)V
    const/high16 v4, 1056964608
    invoke-virtual v2, v4, Landroid/view/Window;->setDimAmount(F)V
    invoke-virtual v1, v3, Landroid/app/Dialog;->setCancelable(Z)V
    invoke-virtual v1, v3, Landroid/app/Dialog;->setCanceledOnTouchOutside(Z)V
    sget v2, Lcom/bytedance/trae/conversation/R$id;->tv_message I
    invoke-virtual v0, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    check-cast v2, Landroid/widget/TextView;
    sget-object v3, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v3
    if-eqz v3, +005h
    sget v3, Lcom/bytedance/trae/conversation/R$string;->trae_ai_data_notice_message I
    goto +3h
    sget v3, Lcom/bytedance/trae/conversation/R$string;->trae_ai_data_notice_message_cn I
    invoke-virtual v12, v3, Landroidx/activity/ComponentActivity;->getString(I)Ljava/lang/String;
    move-result-object v3
    check-cast v3, Ljava/lang/CharSequence;
    invoke-virtual v2, v3, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-virtual v2, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v3
    sget-object v4, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v4, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v4
    if-eqz v4, +005h
    sget v4, Lcom/bytedance/trae/conversation/R$string;->trae_ai_data_notice_privacy_policy I
    goto +3h
    sget v4, Lcom/bytedance/trae/conversation/R$string;->trae_ai_data_notice_privacy_policy_cn I
    invoke-virtual v12, v4, Landroidx/activity/ComponentActivity;->getString(I)Ljava/lang/String;
    move-result-object v4
    const-string v5, "getString(...)"
    invoke-static v4, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v3, Ljava/lang/CharSequence;
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 6
    const/4 v10, 0
    move-object v5, v3
    move-object v6, v4
    invoke-static/range v5 ... v10, Lkotlin/text/StringsKt;->indexOf$default(Ljava/lang/CharSequence; Ljava/lang/String; I Z I Ljava/lang/Object;)I
    move-result v5
    if-ltz v5, +02fh
    new-instance v6, Landroid/text/SpannableString;
    invoke-direct v6, v3, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V
    sget-object v3, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v3
    if-eqz v3, +005h
    const-string v3, "https://www.trae.ai/privacy-policy?platform=h5"
    goto +3h
    const-string v3, "https://www.trae.cn/privacy-policy?platform=h5"
    new-instance v7, Lcom/bytedance/trae/conversation/widget/AiDataNoticeHelper$showIfNeeded$2;
    invoke-direct v7, v12, v3, Lcom/bytedance/trae/conversation/widget/AiDataNoticeHelper$showIfNeeded$2;-><init>(Landroidx/activity/ComponentActivity; Ljava/lang/String;)V
    invoke-virtual v4, Ljava/lang/String;->length()I
    move-result v3
    add-int/2addr v3, v5
    const/16 v4, 33
    invoke-virtual v6, v7, v5, v3, v4, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object; I I I)V
    check-cast v6, Ljava/lang/CharSequence;
    invoke-virtual v2, v6, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-static Landroid/text/method/LinkMovementMethod;->getInstance()Landroid/text/method/MovementMethod;
    move-result-object v3
    invoke-virtual v2, v3, Landroid/widget/TextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V
    sget v2, Lcom/bytedance/trae/conversation/R$id;->btn_ok I
    invoke-virtual v0, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    check-cast v0, Landroid/widget/TextView;
    new-instance v2, Lcom/bytedance/trae/conversation/widget/AiDataNoticeHelper$$ExternalSyntheticLambda0;
    invoke-direct v2, v12, v1, v13, Lcom/bytedance/trae/conversation/widget/AiDataNoticeHelper$$ExternalSyntheticLambda0;-><init>(Landroidx/activity/ComponentActivity; Landroid/app/Dialog; Lkotlin/jvm/functions/Function0;)V
    invoke-virtual v0, v2, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    invoke-virtual v1, Landroid/app/Dialog;->show()V
    return-void 
.end method
