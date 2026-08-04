# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/devices/SelectProjectPermissionDialog;
.super Landroid/app/Dialog;
.source "SelectProjectPermissionDialog.kt"

.field private final folderName:Ljava/lang/String;
.field private final onAllow:Lkotlin/jvm/functions/Function0;
.field private final onCancel:Lkotlin/jvm/functions/Function0;


.method public static synthetic $r8$lambda$Jq0ekHfbAR4wyAuxEkaOTuZA4f8()kotlin.Unit
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/conversation/devices/SelectProjectPermissionDialog;->_init_$lambda$0()Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$RiXpz5VMTF40aN9Y6mXH-DI5k1Y(com.bytedance.trae.conversation.devices.SelectProjectPermissionDialog  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/devices/SelectProjectPermissionDialog;->onCreate$lambda$2(Lcom/bytedance/trae/conversation/devices/SelectProjectPermissionDialog; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$gsbjxdXEfpSvrFBN-zxy0PmgYF0(com.bytedance.trae.conversation.devices.SelectProjectPermissionDialog  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/devices/SelectProjectPermissionDialog;->onCreate$lambda$3(Lcom/bytedance/trae/conversation/devices/SelectProjectPermissionDialog; Landroid/view/View;)V
    return-void 
.end method

.method public constructor <init>(android.content.Context  java.lang.String  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0)void
    .registers 6
    # ins_size=5
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "folderName"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onAllow"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onCancel"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, Landroid/app/Dialog;-><init>(Landroid/content/Context;)V
    iput-object v3, v1, Lcom/bytedance/trae/conversation/devices/SelectProjectPermissionDialog;->folderName Ljava/lang/String;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/devices/SelectProjectPermissionDialog;->onAllow Lkotlin/jvm/functions/Function0;
    iput-object v5, v1, Lcom/bytedance/trae/conversation/devices/SelectProjectPermissionDialog;->onCancel Lkotlin/jvm/functions/Function0;
    return-void 
.end method

.method public synthetic constructor <init>(android.content.Context  java.lang.String  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 7
    # ins_size=7
    and-int/lit8 v5, v5, 8
    if-eqz v5, +007h
    new-instance v4, Lcom/bytedance/trae/conversation/devices/SelectProjectPermissionDialog$$ExternalSyntheticLambda0;
    invoke-direct v4, Lcom/bytedance/trae/conversation/devices/SelectProjectPermissionDialog$$ExternalSyntheticLambda0;-><init>()V
    invoke-direct v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/devices/SelectProjectPermissionDialog;-><init>(Landroid/content/Context; Ljava/lang/String; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method private static final _init_$lambda$0()kotlin.Unit
    .registers 1
    # ins_size=0
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final onCreate$lambda$2(com.bytedance.trae.conversation.devices.SelectProjectPermissionDialog  android.view.View)void
    .registers 2
    # ins_size=2
    iget-object v1, v0, Lcom/bytedance/trae/conversation/devices/SelectProjectPermissionDialog;->onAllow Lkotlin/jvm/functions/Function0;
    invoke-interface v1, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/SelectProjectPermissionDialog;->dismiss()V
    return-void 
.end method

.method private static final onCreate$lambda$3(com.bytedance.trae.conversation.devices.SelectProjectPermissionDialog  android.view.View)void
    .registers 2
    # ins_size=2
    iget-object v1, v0, Lcom/bytedance/trae/conversation/devices/SelectProjectPermissionDialog;->onCancel Lkotlin/jvm/functions/Function0;
    invoke-interface v1, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/SelectProjectPermissionDialog;->dismiss()V
    return-void 
.end method

.method protected onCreate(android.os.Bundle)void
    .registers 10
    # ins_size=2
    invoke-super v8, v9, Landroid/app/Dialog;->onCreate(Landroid/os/Bundle;)V
    sget v9, Lcom/bytedance/trae/conversation/R$layout;->trae_select_project_permission I
    invoke-virtual v8, v9, Lcom/bytedance/trae/conversation/devices/SelectProjectPermissionDialog;->setContentView(I)V
    invoke-virtual v8, Lcom/bytedance/trae/conversation/devices/SelectProjectPermissionDialog;->getWindow()Landroid/view/Window;
    move-result-object v9
    const/4 v0, 0
    if-eqz v9, +02dh
    new-instance v1, Landroid/graphics/drawable/ColorDrawable;
    invoke-direct v1, v0, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V
    check-cast v1, Landroid/graphics/drawable/Drawable;
    invoke-virtual v9, v1, Landroid/view/Window;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V
    const/16 v1, 300
    int-to-float v1, v1
    invoke-virtual v9, Landroid/view/Window;->getContext()Landroid/content/Context;
    move-result-object v2
    invoke-virtual v2, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v2
    invoke-virtual v2, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v2
    iget v2, v2, Landroid/util/DisplayMetrics;->density F
    mul-float/2addr v1, v2
    float-to-int v1, v1
    const/4 v2, -2
    invoke-virtual v9, v1, v2, Landroid/view/Window;->setLayout(I I)V
    const/16 v1, 17
    invoke-virtual v9, v1, Landroid/view/Window;->setGravity(I)V
    const/high16 v1, 1056964608
    invoke-virtual v9, v1, Landroid/view/Window;->setDimAmount(F)V
    const/4 v9, 1
    invoke-virtual v8, v9, Lcom/bytedance/trae/conversation/devices/SelectProjectPermissionDialog;->setCancelable(Z)V
    invoke-virtual v8, v9, Lcom/bytedance/trae/conversation/devices/SelectProjectPermissionDialog;->setCanceledOnTouchOutside(Z)V
    sget v1, Lcom/bytedance/trae/conversation/R$id;->tv_title I
    invoke-virtual v8, v1, Lcom/bytedance/trae/conversation/devices/SelectProjectPermissionDialog;->findViewById(I)Landroid/view/View;
    move-result-object v1
    check-cast v1, Landroid/widget/TextView;
    sget v2, Lcom/bytedance/trae/conversation/R$id;->tv_subtitle I
    invoke-virtual v8, v2, Lcom/bytedance/trae/conversation/devices/SelectProjectPermissionDialog;->findViewById(I)Landroid/view/View;
    move-result-object v2
    check-cast v2, Landroid/widget/TextView;
    sget v3, Lcom/bytedance/trae/conversation/R$id;->btn_allow I
    invoke-virtual v8, v3, Lcom/bytedance/trae/conversation/devices/SelectProjectPermissionDialog;->findViewById(I)Landroid/view/View;
    move-result-object v3
    check-cast v3, Landroid/widget/TextView;
    sget v4, Lcom/bytedance/trae/conversation/R$id;->btn_cancel I
    invoke-virtual v8, v4, Lcom/bytedance/trae/conversation/devices/SelectProjectPermissionDialog;->findViewById(I)Landroid/view/View;
    move-result-object v4
    check-cast v4, Landroid/widget/TextView;
    invoke-virtual v8, Lcom/bytedance/trae/conversation/devices/SelectProjectPermissionDialog;->getContext()Landroid/content/Context;
    move-result-object v5
    sget v6, Lcom/bytedance/trae/conversation/R$string;->trae_select_project_permission_title I
    new-array v9, v9, [Ljava/lang/Object;
    iget-object v7, v8, Lcom/bytedance/trae/conversation/devices/SelectProjectPermissionDialog;->folderName Ljava/lang/String;
    aput-object v7, v9, v0
    invoke-virtual v5, v6, v9, Landroid/content/Context;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v9
    check-cast v9, Ljava/lang/CharSequence;
    invoke-virtual v1, v9, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-virtual v8, Lcom/bytedance/trae/conversation/devices/SelectProjectPermissionDialog;->getContext()Landroid/content/Context;
    move-result-object v9
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_select_project_permission_subtitle I
    invoke-virtual v9, v0, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v9
    check-cast v9, Ljava/lang/CharSequence;
    invoke-virtual v2, v9, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-virtual v8, Lcom/bytedance/trae/conversation/devices/SelectProjectPermissionDialog;->getContext()Landroid/content/Context;
    move-result-object v9
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_select_project_permission_allow I
    invoke-virtual v9, v0, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v9
    check-cast v9, Ljava/lang/CharSequence;
    invoke-virtual v3, v9, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-virtual v8, Lcom/bytedance/trae/conversation/devices/SelectProjectPermissionDialog;->getContext()Landroid/content/Context;
    move-result-object v9
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_select_project_permission_cancel I
    invoke-virtual v9, v0, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v9
    check-cast v9, Ljava/lang/CharSequence;
    invoke-virtual v4, v9, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    new-instance v9, Lcom/bytedance/trae/conversation/devices/SelectProjectPermissionDialog$$ExternalSyntheticLambda1;
    invoke-direct v9, v8, Lcom/bytedance/trae/conversation/devices/SelectProjectPermissionDialog$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/devices/SelectProjectPermissionDialog;)V
    invoke-virtual v3, v9, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    new-instance v9, Lcom/bytedance/trae/conversation/devices/SelectProjectPermissionDialog$$ExternalSyntheticLambda2;
    invoke-direct v9, v8, Lcom/bytedance/trae/conversation/devices/SelectProjectPermissionDialog$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/conversation/devices/SelectProjectPermissionDialog;)V
    invoke-virtual v4, v9, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method
