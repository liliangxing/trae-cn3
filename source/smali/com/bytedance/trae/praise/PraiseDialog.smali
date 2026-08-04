# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/praise/PraiseDialog;
.super Landroid/app/Dialog;
.source "PraiseDialog.kt"

.field public static final Companion:Lcom/bytedance/trae/praise/PraiseDialog$Companion;
.field private static final TAG:Ljava/lang/String;
.field private dismissed:Z
.field private final onLaterClick:Lkotlin/jvm/functions/Function0;
.field private final onRateClick:Lkotlin/jvm/functions/Function0;


.method public static synthetic $r8$lambda$MR4_OWhmWBb0BcfMpM9nHZH883k(com.bytedance.trae.praise.PraiseDialog  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/praise/PraiseDialog;->onCreate$lambda$2(Lcom/bytedance/trae/praise/PraiseDialog; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$WaDqzq2SqHLvGZWNJF2gsubxKNE(com.bytedance.trae.praise.PraiseDialog  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/praise/PraiseDialog;->onCreate$lambda$1(Lcom/bytedance/trae/praise/PraiseDialog; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$xF3DPQUfg5b8ixruCzwckXe7uUw(com.bytedance.trae.praise.PraiseDialog  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/praise/PraiseDialog;->onCreate$lambda$3(Lcom/bytedance/trae/praise/PraiseDialog; Landroid/view/View;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/praise/PraiseDialog$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/praise/PraiseDialog$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/praise/PraiseDialog;->Companion Lcom/bytedance/trae/praise/PraiseDialog$Companion;
    return-void 
.end method

.method public constructor <init>(android.content.Context  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0)void
    .registers 5
    # ins_size=4
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, onRateClick
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, onLaterClick
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, Landroid/app/Dialog;-><init>(Landroid/content/Context;)V
    iput-object v3, v1, Lcom/bytedance/trae/praise/PraiseDialog;->onRateClick Lkotlin/jvm/functions/Function0;
    iput-object v4, v1, Lcom/bytedance/trae/praise/PraiseDialog;->onLaterClick Lkotlin/jvm/functions/Function0;
    return-void 
.end method

.method private final handleLater()void
    .registers 4
    # ins_size=1
    iget-boolean v0, v3, Lcom/bytedance/trae/praise/PraiseDialog;->dismissed Z
    if-eqz v0, +003h
    return-void 
    const/4 v0, 1
    iput-boolean v0, v3, Lcom/bytedance/trae/praise/PraiseDialog;->dismissed Z
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "Praise"
    const-string v2, "PraiseDialog: Later/Cancel"
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v0, v3, Lcom/bytedance/trae/praise/PraiseDialog;->onLaterClick Lkotlin/jvm/functions/Function0;
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
.end method

.method private static final onCreate$lambda$1(com.bytedance.trae.praise.PraiseDialog  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/praise/PraiseDialog;->handleLater()V
    invoke-virtual v0, Lcom/bytedance/trae/praise/PraiseDialog;->dismiss()V
    return-void 
.end method

.method private static final onCreate$lambda$2(com.bytedance.trae.praise.PraiseDialog  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/praise/PraiseDialog;->handleLater()V
    invoke-virtual v0, Lcom/bytedance/trae/praise/PraiseDialog;->dismiss()V
    return-void 
.end method

.method private static final onCreate$lambda$3(com.bytedance.trae.praise.PraiseDialog  android.view.View)void
    .registers 4
    # ins_size=2
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v0, "Praise"
    const-string v1, "PraiseDialog: Rate Now clicked"
    invoke-virtual v3, v0, v1, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    const/4 v3, 1
    iput-boolean v3, v2, Lcom/bytedance/trae/praise/PraiseDialog;->dismissed Z
    iget-object v3, v2, Lcom/bytedance/trae/praise/PraiseDialog;->onRateClick Lkotlin/jvm/functions/Function0;
    invoke-interface v3, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    invoke-virtual v2, Lcom/bytedance/trae/praise/PraiseDialog;->dismiss()V
    return-void 
.end method

.method protected onCreate(android.os.Bundle)void
    .registers 7
    # ins_size=2
    invoke-super v5, v6, Landroid/app/Dialog;->onCreate(Landroid/os/Bundle;)V
    sget v6, Lcom/bytedance/trae/praise/R$layout;->trae_dialog_praise I
    invoke-virtual v5, v6, Lcom/bytedance/trae/praise/PraiseDialog;->setContentView(I)V
    invoke-virtual v5, Lcom/bytedance/trae/praise/PraiseDialog;->getWindow()Landroid/view/Window;
    move-result-object v6
    const/4 v0, 0
    if-eqz v6, +030h
    new-instance v1, Landroid/graphics/drawable/ColorDrawable;
    invoke-direct v1, v0, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V
    check-cast v1, Landroid/graphics/drawable/Drawable;
    invoke-virtual v6, v1, Landroid/view/Window;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V
    invoke-virtual v6, Landroid/view/Window;->getContext()Landroid/content/Context;
    move-result-object v1
    invoke-virtual v1, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v1
    invoke-virtual v1, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v1
    iget v1, v1, Landroid/util/DisplayMetrics;->widthPixels I
    int-to-double v1, v1
    const-wide v3, 4605200834963974390
    mul-double/2addr v1, v3
    double-to-int v1, v1
    const/4 v2, -2
    invoke-virtual v6, v1, v2, Landroid/view/Window;->setLayout(I I)V
    const/16 v1, 17
    invoke-virtual v6, v1, Landroid/view/Window;->setGravity(I)V
    const/high16 v1, 1056964608
    invoke-virtual v6, v1, Landroid/view/Window;->setDimAmount(F)V
    invoke-virtual v5, v0, Lcom/bytedance/trae/praise/PraiseDialog;->setCancelable(Z)V
    invoke-virtual v5, v0, Lcom/bytedance/trae/praise/PraiseDialog;->setCanceledOnTouchOutside(Z)V
    sget v6, Lcom/bytedance/trae/praise/R$id;->iv_praise_icon I
    invoke-virtual v5, v6, Lcom/bytedance/trae/praise/PraiseDialog;->findViewById(I)Landroid/view/View;
    move-result-object v6
    check-cast v6, Landroid/widget/ImageView;
    invoke-virtual v6, v0, v0, v0, v0, Landroid/widget/ImageView;->setPadding(I I I I)V
    invoke-virtual v6, v0, Landroid/widget/ImageView;->setCropToPadding(Z)V
    sget v6, Lcom/bytedance/trae/praise/R$id;->btn_later I
    invoke-virtual v5, v6, Lcom/bytedance/trae/praise/PraiseDialog;->findViewById(I)Landroid/view/View;
    move-result-object v6
    check-cast v6, Landroid/widget/TextView;
    sget v0, Lcom/bytedance/trae/praise/R$id;->btn_rate I
    invoke-virtual v5, v0, Lcom/bytedance/trae/praise/PraiseDialog;->findViewById(I)Landroid/view/View;
    move-result-object v0
    check-cast v0, Landroid/widget/TextView;
    sget v1, Lcom/bytedance/trae/praise/R$id;->btn_close I
    invoke-virtual v5, v1, Lcom/bytedance/trae/praise/PraiseDialog;->findViewById(I)Landroid/view/View;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/praise/PraiseDialog$$ExternalSyntheticLambda0;
    invoke-direct v2, v5, Lcom/bytedance/trae/praise/PraiseDialog$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/praise/PraiseDialog;)V
    invoke-virtual v1, v2, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    new-instance v1, Lcom/bytedance/trae/praise/PraiseDialog$$ExternalSyntheticLambda1;
    invoke-direct v1, v5, Lcom/bytedance/trae/praise/PraiseDialog$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/praise/PraiseDialog;)V
    invoke-virtual v6, v1, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    new-instance v6, Lcom/bytedance/trae/praise/PraiseDialog$$ExternalSyntheticLambda2;
    invoke-direct v6, v5, Lcom/bytedance/trae/praise/PraiseDialog$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/praise/PraiseDialog;)V
    invoke-virtual v0, v6, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method
