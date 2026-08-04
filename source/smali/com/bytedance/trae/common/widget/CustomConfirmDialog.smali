# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/common/widget/CustomConfirmDialog;
.super Landroid/app/Dialog;
.source "CustomConfirmDialog.kt"

.field public static final Companion:Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Companion;
.field private final config:Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;


.method public static synthetic $r8$lambda$LmHYD2iT4SAqEFJK49Yg2GDK7B0(com.bytedance.trae.common.widget.CustomConfirmDialog  android.widget.EditText  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->onCreate$lambda$11(Lcom/bytedance/trae/common/widget/CustomConfirmDialog; Landroid/widget/EditText; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$k7ruykEWOnB_mXMOPedFpABc6tk(com.bytedance.trae.common.widget.CustomConfirmDialog  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->onCreate$lambda$10(Lcom/bytedance/trae/common/widget/CustomConfirmDialog; Landroid/view/View;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->Companion Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Companion;
    return-void 
.end method

.method public constructor <init>(android.content.Context  com.bytedance.trae.common.widget.CustomConfirmDialog$Config)void
    .registers 4
    # ins_size=3
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "config"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, Landroid/app/Dialog;-><init>(Landroid/content/Context;)V
    iput-object v3, v1, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->config Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;
    return-void 
.end method

.method public static final synthetic access$onCreate$updateConfirmState(android.widget.TextView  java.lang.String)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->onCreate$updateConfirmState(Landroid/widget/TextView; Ljava/lang/String;)V
    return-void 
.end method

.method private static final onCreate$lambda$10(com.bytedance.trae.common.widget.CustomConfirmDialog  android.view.View)void
    .registers 2
    # ins_size=2
    iget-object v1, v0, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->config Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;
    invoke-virtual v1, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->getOnCancel()Lkotlin/jvm/functions/Function0;
    move-result-object v1
    invoke-interface v1, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    invoke-virtual v0, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->dismiss()V
    return-void 
.end method

.method private static final onCreate$lambda$11(com.bytedance.trae.common.widget.CustomConfirmDialog  android.widget.EditText  android.view.View)void
    .registers 3
    # ins_size=3
    iget-object v2, v0, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->config Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;
    invoke-virtual v2, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->getInputText()Ljava/lang/String;
    move-result-object v2
    if-eqz v2, +014h
    iget-object v2, v0, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->config Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;
    invoke-virtual v2, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->getOnConfirm()Lkotlin/jvm/functions/Function1;
    move-result-object v2
    invoke-virtual v1, Landroid/widget/EditText;->getText()Landroid/text/Editable;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-interface v2, v1, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    goto +bh
    iget-object v1, v0, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->config Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;
    invoke-virtual v1, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->getOnConfirm()Lkotlin/jvm/functions/Function1;
    move-result-object v1
    const/4 v2, 0
    invoke-interface v1, v2, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    invoke-virtual v0, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->dismiss()V
    return-void 
.end method

.method private static final onCreate$updateConfirmState(android.widget.TextView  java.lang.String)void
    .registers 2
    # ins_size=2
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-lez v1, +004h
    const/4 v1, 1
    goto +2h
    const/4 v1, 0
    invoke-virtual v0, v1, Landroid/widget/TextView;->setEnabled(Z)V
    if-eqz v1, +005h
    const/high16 v1, 1065353216
    goto +4h
    const v1, 1053609165
    invoke-virtual v0, v1, Landroid/widget/TextView;->setAlpha(F)V
    return-void 
.end method

.method protected onCreate(android.os.Bundle)void
    .registers 14
    # ins_size=2
    invoke-super v12, v13, Landroid/app/Dialog;->onCreate(Landroid/os/Bundle;)V
    sget v13, Lcom/bytedance/trae/common_ui/R$layout;->trae_dialog_custom_confirm I
    invoke-virtual v12, v13, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->setContentView(I)V
    invoke-virtual v12, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->getWindow()Landroid/view/Window;
    move-result-object v13
    const/4 v0, 0
    if-eqz v13, +041h
    new-instance v1, Landroid/graphics/drawable/ColorDrawable;
    invoke-direct v1, v0, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V
    check-cast v1, Landroid/graphics/drawable/Drawable;
    invoke-virtual v13, v1, Landroid/view/Window;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V
    iget-object v1, v12, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->config Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;
    invoke-virtual v1, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->getDialogWidthPx()Ljava/lang/Integer;
    move-result-object v1
    if-eqz v1, +007h
    invoke-virtual v1, Ljava/lang/Integer;->intValue()I
    move-result v1
    goto +17h
    invoke-virtual v13, Landroid/view/Window;->getContext()Landroid/content/Context;
    move-result-object v1
    invoke-virtual v1, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v1
    invoke-virtual v1, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v1
    iget v1, v1, Landroid/util/DisplayMetrics;->widthPixels I
    int-to-double v1, v1
    const-wide v3, 4605380978949069210
    mul-double/2addr v1, v3
    double-to-int v1, v1
    const/4 v2, -2
    invoke-virtual v13, v1, v2, Landroid/view/Window;->setLayout(I I)V
    const/16 v1, 17
    invoke-virtual v13, v1, Landroid/view/Window;->setGravity(I)V
    iget-object v1, v12, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->config Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;
    invoke-virtual v1, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->getDimAmount()F
    move-result v1
    invoke-virtual v13, v1, Landroid/view/Window;->setDimAmount(F)V
    const/4 v13, 1
    invoke-virtual v12, v13, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->setCancelable(Z)V
    invoke-virtual v12, v13, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->setCanceledOnTouchOutside(Z)V
    sget v13, Lcom/bytedance/trae/common_ui/R$id;->tv_dialog_title I
    invoke-virtual v12, v13, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->findViewById(I)Landroid/view/View;
    move-result-object v13
    check-cast v13, Landroid/widget/TextView;
    sget v1, Lcom/bytedance/trae/common_ui/R$id;->et_input I
    invoke-virtual v12, v1, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->findViewById(I)Landroid/view/View;
    move-result-object v1
    check-cast v1, Landroid/widget/EditText;
    sget v2, Lcom/bytedance/trae/common_ui/R$id;->tv_message I
    invoke-virtual v12, v2, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->findViewById(I)Landroid/view/View;
    move-result-object v2
    check-cast v2, Landroid/widget/TextView;
    sget v3, Lcom/bytedance/trae/common_ui/R$id;->btn_cancel I
    invoke-virtual v12, v3, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->findViewById(I)Landroid/view/View;
    move-result-object v3
    check-cast v3, Landroid/widget/TextView;
    sget v4, Lcom/bytedance/trae/common_ui/R$id;->btn_confirm I
    invoke-virtual v12, v4, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->findViewById(I)Landroid/view/View;
    move-result-object v4
    check-cast v4, Landroid/widget/TextView;
    sget v5, Lcom/bytedance/trae/common_ui/R$id;->v_button_spacer I
    invoke-virtual v12, v5, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->findViewById(I)Landroid/view/View;
    sget v5, Lcom/bytedance/trae/common_ui/R$id;->custom_confirm_dialog_root I
    invoke-virtual v12, v5, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->findViewById(I)Landroid/view/View;
    move-result-object v5
    sget v6, Lcom/bytedance/trae/common_ui/R$id;->ll_buttons I
    invoke-virtual v12, v6, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->findViewById(I)Landroid/view/View;
    move-result-object v6
    invoke-virtual v5, Landroid/view/View;->getPaddingLeft()I
    move-result v7
    invoke-virtual v5, Landroid/view/View;->getPaddingTop()I
    move-result v8
    invoke-virtual v5, Landroid/view/View;->getPaddingRight()I
    move-result v9
    invoke-virtual v5, Landroid/view/View;->getPaddingBottom()I
    move-result v10
    iget-object v11, v12, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->config Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;
    invoke-virtual v11, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->getDialogBgRes()I
    move-result v11
    invoke-virtual v5, v11, Landroid/view/View;->setBackgroundResource(I)V
    invoke-virtual v5, v7, v8, v9, v10, Landroid/view/View;->setPadding(I I I I)V
    iget-object v5, v12, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->config Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;
    invoke-virtual v5, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->getTitle()Ljava/lang/String;
    move-result-object v5
    check-cast v5, Ljava/lang/CharSequence;
    invoke-virtual v13, v5, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v5, v12, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->config Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;
    invoke-virtual v5, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->getTitleGravity()Ljava/lang/Integer;
    move-result-object v5
    if-eqz v5, +00bh
    check-cast v5, Ljava/lang/Number;
    invoke-virtual v5, Ljava/lang/Number;->intValue()I
    move-result v5
    invoke-virtual v13, v5, Landroid/widget/TextView;->setGravity(I)V
    iget-object v5, v12, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->config Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;
    invoke-virtual v5, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->getTitleHorizontalPaddingPx()Ljava/lang/Integer;
    move-result-object v5
    if-eqz v5, +013h
    check-cast v5, Ljava/lang/Number;
    invoke-virtual v5, Ljava/lang/Number;->intValue()I
    move-result v5
    invoke-virtual v13, Landroid/widget/TextView;->getPaddingTop()I
    move-result v7
    invoke-virtual v13, Landroid/widget/TextView;->getPaddingBottom()I
    move-result v8
    invoke-virtual v13, v5, v7, v5, v8, Landroid/widget/TextView;->setPadding(I I I I)V
    iget-object v13, v12, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->config Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;
    invoke-virtual v13, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->getButtonTopMarginPx()Ljava/lang/Integer;
    move-result-object v13
    if-eqz v13, +01dh
    check-cast v13, Ljava/lang/Number;
    invoke-virtual v13, Ljava/lang/Number;->intValue()I
    move-result v13
    invoke-virtual v6, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v5
    instance-of v7, v5, Landroid/view/ViewGroup$MarginLayoutParams;
    if-eqz v7, +005h
    check-cast v5, Landroid/view/ViewGroup$MarginLayoutParams;
    goto +2h
    const/4 v5, 0
    if-eqz v5, +009h
    iput v13, v5, Landroid/view/ViewGroup$MarginLayoutParams;->topMargin I
    check-cast v5, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v6, v5, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    iget-object v13, v12, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->config Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;
    invoke-virtual v13, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->getInputText()Ljava/lang/String;
    move-result-object v13
    const/16 v5, 8
    if-eqz v13, +04ch
    invoke-virtual v1, v0, Landroid/widget/EditText;->setVisibility(I)V
    invoke-virtual v2, v5, Landroid/widget/TextView;->setVisibility(I)V
    iget-object v13, v12, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->config Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;
    invoke-virtual v13, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->getInputText()Ljava/lang/String;
    move-result-object v13
    check-cast v13, Ljava/lang/CharSequence;
    invoke-virtual v1, v13, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V
    iget-object v13, v12, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->config Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;
    invoke-virtual v13, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->getInputHint()Ljava/lang/String;
    move-result-object v13
    if-eqz v13, +007h
    check-cast v13, Ljava/lang/CharSequence;
    invoke-virtual v1, v13, Landroid/widget/EditText;->setHint(Ljava/lang/CharSequence;)V
    invoke-virtual v1, Landroid/widget/EditText;->getText()Landroid/text/Editable;
    move-result-object v13
    invoke-interface v13, Landroid/text/Editable;->length()I
    move-result v13
    invoke-virtual v1, v13, Landroid/widget/EditText;->setSelection(I)V
    invoke-virtual v1, Landroid/widget/EditText;->requestFocus()Z
    invoke-virtual v12, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->getWindow()Landroid/view/Window;
    move-result-object v13
    if-eqz v13, +006h
    const/4 v2, 5
    invoke-virtual v13, v2, Landroid/view/Window;->setSoftInputMode(I)V
    iget-object v13, v12, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->config Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;
    invoke-virtual v13, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->getInputText()Ljava/lang/String;
    move-result-object v13
    invoke-static v4, v13, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->onCreate$updateConfirmState(Landroid/widget/TextView; Ljava/lang/String;)V
    new-instance v13, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$onCreate$6;
    invoke-direct v13, v4, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$onCreate$6;-><init>(Landroid/widget/TextView;)V
    check-cast v13, Landroid/text/TextWatcher;
    invoke-virtual v1, v13, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V
    goto +4bh
    iget-object v13, v12, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->config Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;
    invoke-virtual v13, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->getMessage()Ljava/lang/String;
    move-result-object v13
    if-eqz v13, +03eh
    invoke-virtual v1, v5, Landroid/widget/EditText;->setVisibility(I)V
    invoke-virtual v2, v0, Landroid/widget/TextView;->setVisibility(I)V
    iget-object v13, v12, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->config Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;
    invoke-virtual v13, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->getMessage()Ljava/lang/String;
    move-result-object v13
    check-cast v13, Ljava/lang/CharSequence;
    invoke-virtual v2, v13, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v13, v12, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->config Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;
    invoke-virtual v13, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->getMessageGravity()Ljava/lang/Integer;
    move-result-object v13
    if-eqz v13, +00bh
    check-cast v13, Ljava/lang/Number;
    invoke-virtual v13, Ljava/lang/Number;->intValue()I
    move-result v13
    invoke-virtual v2, v13, Landroid/widget/TextView;->setGravity(I)V
    iget-object v13, v12, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->config Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;
    invoke-virtual v13, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->getMessageHorizontalPaddingPx()Ljava/lang/Integer;
    move-result-object v13
    if-eqz v13, +01ah
    check-cast v13, Ljava/lang/Number;
    invoke-virtual v13, Ljava/lang/Number;->intValue()I
    move-result v13
    invoke-virtual v2, Landroid/widget/TextView;->getPaddingTop()I
    move-result v6
    invoke-virtual v2, Landroid/widget/TextView;->getPaddingBottom()I
    move-result v7
    invoke-virtual v2, v13, v6, v13, v7, Landroid/widget/TextView;->setPadding(I I I I)V
    goto +7h
    invoke-virtual v1, v5, Landroid/widget/EditText;->setVisibility(I)V
    invoke-virtual v2, v5, Landroid/widget/TextView;->setVisibility(I)V
    iget-object v13, v12, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->config Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;
    invoke-virtual v13, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->getSingleButton()Z
    move-result v13
    if-eqz v13, +006h
    invoke-virtual v3, v5, Landroid/widget/TextView;->setVisibility(I)V
    goto +31h
    invoke-virtual v3, v0, Landroid/widget/TextView;->setVisibility(I)V
    iget-object v13, v12, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->config Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;
    invoke-virtual v13, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->getCancelText()Ljava/lang/String;
    move-result-object v13
    check-cast v13, Ljava/lang/CharSequence;
    invoke-virtual v3, v13, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v13, v12, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->config Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;
    invoke-virtual v13, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->getCancelTextColor()Ljava/lang/Integer;
    move-result-object v13
    if-eqz v13, +00bh
    check-cast v13, Ljava/lang/Number;
    invoke-virtual v13, Ljava/lang/Number;->intValue()I
    move-result v13
    invoke-virtual v3, v13, Landroid/widget/TextView;->setTextColor(I)V
    iget-object v13, v12, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->config Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;
    invoke-virtual v13, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->getCancelBgRes()I
    move-result v13
    if-eqz v13, +00bh
    iget-object v13, v12, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->config Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;
    invoke-virtual v13, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->getCancelBgRes()I
    move-result v13
    invoke-virtual v3, v13, Landroid/widget/TextView;->setBackgroundResource(I)V
    iget-object v13, v12, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->config Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;
    invoke-virtual v13, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->getConfirmText()Ljava/lang/String;
    move-result-object v13
    check-cast v13, Ljava/lang/CharSequence;
    invoke-virtual v4, v13, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v13, v12, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->config Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;
    invoke-virtual v13, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->getConfirmTextColor()Ljava/lang/Integer;
    move-result-object v13
    if-eqz v13, +00bh
    check-cast v13, Ljava/lang/Number;
    invoke-virtual v13, Ljava/lang/Number;->intValue()I
    move-result v13
    invoke-virtual v4, v13, Landroid/widget/TextView;->setTextColor(I)V
    iget-object v13, v12, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->config Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;
    invoke-virtual v13, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->getConfirmBgRes()I
    move-result v13
    if-eqz v13, +00bh
    iget-object v13, v12, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->config Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;
    invoke-virtual v13, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;->getConfirmBgRes()I
    move-result v13
    invoke-virtual v4, v13, Landroid/widget/TextView;->setBackgroundResource(I)V
    new-instance v13, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$$ExternalSyntheticLambda0;
    invoke-direct v13, v12, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/common/widget/CustomConfirmDialog;)V
    invoke-virtual v3, v13, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    new-instance v13, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$$ExternalSyntheticLambda1;
    invoke-direct v13, v12, v1, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/common/widget/CustomConfirmDialog; Landroid/widget/EditText;)V
    invoke-virtual v4, v13, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method
