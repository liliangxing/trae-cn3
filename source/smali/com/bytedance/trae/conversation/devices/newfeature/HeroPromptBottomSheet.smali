# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public abstract Lcom/bytedance/trae/conversation/devices/newfeature/HeroPromptBottomSheet;
.super Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;
.source "HeroPromptBottomSheet.kt"


.method public static synthetic $r8$lambda$3S_BxLovnbG_USci7uNCKsBvWYs(kotlin.jvm.functions.Function0  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/devices/newfeature/HeroPromptBottomSheet;->bindHeroPrompt$lambda$3(Lkotlin/jvm/functions/Function0; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$BAy5Ced8CVbx14Ovmd3k17HqCAA(int  android.content.DialogInterface)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/devices/newfeature/HeroPromptBottomSheet;->onCreateDialog$lambda$2(I Landroid/content/DialogInterface;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$ijcXPZN0WTaWqwYewD2npyRRnqE(kotlin.jvm.functions.Function0  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/devices/newfeature/HeroPromptBottomSheet;->bindHeroPrompt$lambda$5$lambda$4(Lkotlin/jvm/functions/Function0; Landroid/view/View;)V
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;-><init>()V
    return-void 
.end method

.method private static final bindHeroPrompt$lambda$3(kotlin.jvm.functions.Function0  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
.end method

.method private static final bindHeroPrompt$lambda$5$lambda$4(kotlin.jvm.functions.Function0  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
.end method

.method private static final onCreateDialog$lambda$2(int  android.content.DialogInterface)void
    .registers 4
    # ins_size=2
    instance-of v0, v3, Lcom/google/android/material/bottomsheet/BottomSheetDialog;
    if-eqz v0, +005h
    check-cast v3, Lcom/google/android/material/bottomsheet/BottomSheetDialog;
    goto +2h
    const/4 v3, 0
    if-eqz v3, +02ch
    sget v0, Lcom/google/android/material/R$id;->design_bottom_sheet I
    invoke-virtual v3, v0, Lcom/google/android/material/bottomsheet/BottomSheetDialog;->findViewById(I)Landroid/view/View;
    move-result-object v3
    if-nez v3, +003h
    goto +22h
    const v0, 17170445
    invoke-virtual v3, v0, Landroid/view/View;->setBackgroundResource(I)V
    invoke-static v3, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->from(Landroid/view/View;)Lcom/google/android/material/bottomsheet/BottomSheetBehavior;
    move-result-object v0
    invoke-virtual v0, v2, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setPeekHeight(I)V
    const/4 v1, 3
    invoke-virtual v0, v1, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setState(I)V
    const/4 v1, 1
    invoke-virtual v0, v1, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setSkipCollapsed(Z)V
    invoke-virtual v0, v1, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setHideable(Z)V
    invoke-virtual v3, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v0
    iput v2, v0, Landroid/view/ViewGroup$LayoutParams;->height I
    invoke-virtual v3, v0, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    return-void 
.end method

.method protected final bindHeroPrompt(android.view.View  int  java.lang.CharSequence  java.lang.CharSequence  java.lang.CharSequence  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0)void
    .registers 10
    # ins_size=8
    const-string/jumbo v0, view
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, title
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "message"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "actionText"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onClose"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onAction"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget v0, Lcom/bytedance/trae/conversation/R$id;->title_bar I
    invoke-virtual v3, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;
    new-instance v1, Lcom/bytedance/trae/conversation/devices/newfeature/HeroPromptBottomSheet$$ExternalSyntheticLambda1;
    invoke-direct v1, v8, Lcom/bytedance/trae/conversation/devices/newfeature/HeroPromptBottomSheet$$ExternalSyntheticLambda1;-><init>(Lkotlin/jvm/functions/Function0;)V
    invoke-virtual v0, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setOnRightActionClickListener(Landroid/view/View$OnClickListener;)V
    sget v8, Lcom/bytedance/trae/conversation/R$id;->iv_prompt_image I
    invoke-virtual v3, v8, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v8
    check-cast v8, Landroid/widget/ImageView;
    invoke-virtual v8, v4, Landroid/widget/ImageView;->setImageResource(I)V
    sget v4, Lcom/bytedance/trae/conversation/R$id;->tv_prompt_title I
    invoke-virtual v3, v4, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v4
    check-cast v4, Landroid/widget/TextView;
    invoke-virtual v4, v5, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget v4, Lcom/bytedance/trae/conversation/R$id;->tv_prompt_message I
    invoke-virtual v3, v4, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v4
    check-cast v4, Landroid/widget/TextView;
    invoke-virtual v4, v6, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget v4, Lcom/bytedance/trae/conversation/R$id;->btn_connect I
    invoke-virtual v3, v4, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v3
    check-cast v3, Landroid/widget/TextView;
    invoke-virtual v3, v7, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    new-instance v4, Lcom/bytedance/trae/conversation/devices/newfeature/HeroPromptBottomSheet$$ExternalSyntheticLambda2;
    invoke-direct v4, v9, Lcom/bytedance/trae/conversation/devices/newfeature/HeroPromptBottomSheet$$ExternalSyntheticLambda2;-><init>(Lkotlin/jvm/functions/Function0;)V
    invoke-virtual v3, v4, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method

.method public onCreateDialog(android.os.Bundle)android.app.Dialog
    .registers 4
    # ins_size=2
    invoke-super v2, v3, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;->onCreateDialog(Landroid/os/Bundle;)Landroid/app/Dialog;
    move-result-object v3
    const-string v0, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v3, Lcom/google/android/material/bottomsheet/BottomSheetDialog;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/newfeature/HeroPromptBottomSheet;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/conversation/R$dimen;->trae_new_feature_prompt_sheet_height I
    invoke-virtual v0, v1, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v0
    new-instance v1, Lcom/bytedance/trae/conversation/devices/newfeature/HeroPromptBottomSheet$$ExternalSyntheticLambda0;
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/devices/newfeature/HeroPromptBottomSheet$$ExternalSyntheticLambda0;-><init>(I)V
    invoke-virtual v3, v1, Lcom/google/android/material/bottomsheet/BottomSheetDialog;->setOnShowListener(Landroid/content/DialogInterface$OnShowListener;)V
    check-cast v3, Landroid/app/Dialog;
    return-object v3
.end method

.method public onCreateView(android.view.LayoutInflater  android.view.ViewGroup  android.os.Bundle)android.view.View
    .registers 5
    # ins_size=4
    const-string v4, "inflater"
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget v4, Lcom/bytedance/trae/conversation/R$layout;->bottom_sheet_new_feature_prompt I
    const/4 v0, 0
    invoke-virtual v2, v4, v3, v0, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    const-string v3, "inflate(...)"
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v2
.end method
