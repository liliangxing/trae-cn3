# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/common/widget/PermissionRationaleDialog;
.super Landroid/app/Dialog;
.source "PermissionRationaleDialog.kt"

.field public static final Companion:Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Companion;
.field private final config:Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;


.method public static synthetic $r8$lambda$hDPUGFBeq1ql-fTrA-IBTClDNw4(com.bytedance.trae.common.widget.PermissionRationaleDialog  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog;->onCreate$lambda$2(Lcom/bytedance/trae/common/widget/PermissionRationaleDialog; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$tYXkjiqJViGWqLcpnwq8SxeDn_4(com.bytedance.trae.common.widget.PermissionRationaleDialog  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog;->onCreate$lambda$3(Lcom/bytedance/trae/common/widget/PermissionRationaleDialog; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$u1twAZkRNiHHpCw51b2K_jCJLv4(com.bytedance.trae.common.widget.PermissionRationaleDialog  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog;->onCreate$lambda$1(Lcom/bytedance/trae/common/widget/PermissionRationaleDialog; Landroid/view/View;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog;->Companion Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Companion;
    return-void 
.end method

.method public constructor <init>(android.content.Context  com.bytedance.trae.common.widget.PermissionRationaleDialog$Config)void
    .registers 4
    # ins_size=3
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "config"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, Landroid/app/Dialog;-><init>(Landroid/content/Context;)V
    iput-object v3, v1, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog;->config Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;
    return-void 
.end method

.method private static final onCreate$lambda$1(com.bytedance.trae.common.widget.PermissionRationaleDialog  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-virtual v0, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog;->dismiss()V
    iget-object v0, v0, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog;->config Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;
    invoke-virtual v0, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->getOnDenyPermanent()Lkotlin/jvm/functions/Function0;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
.end method

.method private static final onCreate$lambda$2(com.bytedance.trae.common.widget.PermissionRationaleDialog  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-virtual v0, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog;->dismiss()V
    iget-object v0, v0, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog;->config Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;
    invoke-virtual v0, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->getOnAllow()Lkotlin/jvm/functions/Function0;
    move-result-object v0
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
.end method

.method private static final onCreate$lambda$3(com.bytedance.trae.common.widget.PermissionRationaleDialog  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-virtual v0, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog;->dismiss()V
    iget-object v0, v0, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog;->config Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;
    invoke-virtual v0, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->getOnDeny()Lkotlin/jvm/functions/Function0;
    move-result-object v0
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
.end method

.method protected onCreate(android.os.Bundle)void
    .registers 10
    # ins_size=2
    invoke-super v8, v9, Landroid/app/Dialog;->onCreate(Landroid/os/Bundle;)V
    sget v9, Lcom/bytedance/trae/common_ui/R$layout;->trae_dialog_permission_rationale I
    invoke-virtual v8, v9, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog;->setContentView(I)V
    invoke-virtual v8, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog;->getWindow()Landroid/view/Window;
    move-result-object v9
    const/4 v0, 0
    if-eqz v9, +031h
    new-instance v1, Landroid/graphics/drawable/ColorDrawable;
    invoke-direct v1, v0, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V
    check-cast v1, Landroid/graphics/drawable/Drawable;
    invoke-virtual v9, v1, Landroid/view/Window;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V
    invoke-virtual v9, Landroid/view/Window;->getContext()Landroid/content/Context;
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
    invoke-virtual v9, v1, v2, Landroid/view/Window;->setLayout(I I)V
    const/16 v1, 17
    invoke-virtual v9, v1, Landroid/view/Window;->setGravity(I)V
    const v1, 1053609165
    invoke-virtual v9, v1, Landroid/view/Window;->setDimAmount(F)V
    invoke-virtual v8, v0, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog;->setCancelable(Z)V
    invoke-virtual v8, v0, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog;->setCanceledOnTouchOutside(Z)V
    sget v9, Lcom/bytedance/trae/common_ui/R$id;->iv_icon I
    invoke-virtual v8, v9, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog;->findViewById(I)Landroid/view/View;
    move-result-object v9
    check-cast v9, Landroid/widget/ImageView;
    sget v1, Lcom/bytedance/trae/common_ui/R$id;->tv_title I
    invoke-virtual v8, v1, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog;->findViewById(I)Landroid/view/View;
    move-result-object v1
    check-cast v1, Landroid/widget/TextView;
    sget v2, Lcom/bytedance/trae/common_ui/R$id;->tv_message I
    invoke-virtual v8, v2, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog;->findViewById(I)Landroid/view/View;
    move-result-object v2
    check-cast v2, Landroid/widget/TextView;
    sget v3, Lcom/bytedance/trae/common_ui/R$id;->btn_allow I
    invoke-virtual v8, v3, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog;->findViewById(I)Landroid/view/View;
    move-result-object v3
    check-cast v3, Landroid/widget/TextView;
    sget v4, Lcom/bytedance/trae/common_ui/R$id;->btn_deny I
    invoke-virtual v8, v4, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog;->findViewById(I)Landroid/view/View;
    move-result-object v4
    check-cast v4, Landroid/widget/TextView;
    sget v5, Lcom/bytedance/trae/common_ui/R$id;->btn_deny_permanent I
    invoke-virtual v8, v5, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog;->findViewById(I)Landroid/view/View;
    move-result-object v5
    check-cast v5, Landroid/widget/TextView;
    iget-object v6, v8, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog;->config Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;
    invoke-virtual v6, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->getIconResId()I
    move-result v6
    const/16 v7, 8
    if-eqz v6, +00fh
    iget-object v6, v8, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog;->config Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;
    invoke-virtual v6, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->getIconResId()I
    move-result v6
    invoke-virtual v9, v6, Landroid/widget/ImageView;->setImageResource(I)V
    invoke-virtual v9, v0, Landroid/widget/ImageView;->setVisibility(I)V
    goto +4h
    invoke-virtual v9, v7, Landroid/widget/ImageView;->setVisibility(I)V
    iget-object v9, v8, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog;->config Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;
    invoke-virtual v9, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->getTitle()Ljava/lang/String;
    move-result-object v9
    check-cast v9, Ljava/lang/CharSequence;
    invoke-virtual v1, v9, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v9, v8, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog;->config Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;
    invoke-virtual v9, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->getMessage()Ljava/lang/String;
    move-result-object v9
    check-cast v9, Ljava/lang/CharSequence;
    invoke-virtual v2, v9, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v9, v8, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog;->config Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;
    invoke-virtual v9, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->getAllowText()Ljava/lang/String;
    move-result-object v9
    check-cast v9, Ljava/lang/CharSequence;
    invoke-virtual v3, v9, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v9, v8, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog;->config Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;
    invoke-virtual v9, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->getDenyText()Ljava/lang/String;
    move-result-object v9
    check-cast v9, Ljava/lang/CharSequence;
    invoke-virtual v4, v9, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v9, v8, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog;->config Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;
    invoke-virtual v9, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->getDenyPermanentText()Ljava/lang/String;
    move-result-object v9
    if-eqz v9, +019h
    invoke-virtual v5, v0, Landroid/widget/TextView;->setVisibility(I)V
    iget-object v9, v8, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog;->config Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;
    invoke-virtual v9, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$Config;->getDenyPermanentText()Ljava/lang/String;
    move-result-object v9
    check-cast v9, Ljava/lang/CharSequence;
    invoke-virtual v5, v9, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    new-instance v9, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$$ExternalSyntheticLambda0;
    invoke-direct v9, v8, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/common/widget/PermissionRationaleDialog;)V
    invoke-virtual v5, v9, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    goto +4h
    invoke-virtual v5, v7, Landroid/widget/TextView;->setVisibility(I)V
    new-instance v9, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$$ExternalSyntheticLambda1;
    invoke-direct v9, v8, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/common/widget/PermissionRationaleDialog;)V
    invoke-virtual v3, v9, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    new-instance v9, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$$ExternalSyntheticLambda2;
    invoke-direct v9, v8, Lcom/bytedance/trae/common/widget/PermissionRationaleDialog$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/common/widget/PermissionRationaleDialog;)V
    invoke-virtual v4, v9, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method
