# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/menu/RevertConfirmDialog;
.super Landroid/app/Dialog;
.source "RevertConfirmDialog.kt"

.field private final cancelText:Ljava/lang/String;
.field private final confirmText:Ljava/lang/String;
.field private final customMessage:Ljava/lang/String;
.field private final diffFileInfos:Ljava/util/List;
.field private final onConfirm:Lkotlin/jvm/functions/Function0;
.field private final title:Ljava/lang/String;


.method public static synthetic $r8$lambda$8I0eHOjd-oR_xKYCFI4UMh_aA0o(com.bytedance.trae.conversation.chat.menu.RevertConfirmDialog  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/menu/RevertConfirmDialog;->onCreate$lambda$5(Lcom/bytedance/trae/conversation/chat/menu/RevertConfirmDialog; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$qZm83P77iM6vRd6GwbGf6Ua-pSw(com.bytedance.trae.conversation.chat.menu.RevertConfirmDialog  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/menu/RevertConfirmDialog;->onCreate$lambda$4(Lcom/bytedance/trae/conversation/chat/menu/RevertConfirmDialog; Landroid/view/View;)V
    return-void 
.end method

.method public constructor <init>(android.content.Context  java.lang.String  java.util.List  java.lang.String  java.lang.String  java.lang.String  kotlin.jvm.functions.Function0)void
    .registers 9
    # ins_size=8
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, title
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "cancelText"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "confirmText"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onConfirm"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, Landroid/app/Dialog;-><init>(Landroid/content/Context;)V
    iput-object v3, v1, Lcom/bytedance/trae/conversation/chat/menu/RevertConfirmDialog;->title Ljava/lang/String;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/chat/menu/RevertConfirmDialog;->diffFileInfos Ljava/util/List;
    iput-object v5, v1, Lcom/bytedance/trae/conversation/chat/menu/RevertConfirmDialog;->cancelText Ljava/lang/String;
    iput-object v6, v1, Lcom/bytedance/trae/conversation/chat/menu/RevertConfirmDialog;->confirmText Ljava/lang/String;
    iput-object v7, v1, Lcom/bytedance/trae/conversation/chat/menu/RevertConfirmDialog;->customMessage Ljava/lang/String;
    iput-object v8, v1, Lcom/bytedance/trae/conversation/chat/menu/RevertConfirmDialog;->onConfirm Lkotlin/jvm/functions/Function0;
    return-void 
.end method

.method public synthetic constructor <init>(android.content.Context  java.lang.String  java.util.List  java.lang.String  java.lang.String  java.lang.String  kotlin.jvm.functions.Function0  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 19
    # ins_size=10
    and-int/lit8 v0, v17, 32
    if-eqz v0, +005h
    const/4 v0, 0
    move-object v7, v0
    goto +2h
    move-object v7, v15
    move-object v1, v9
    move-object v2, v10
    move-object v3, v11
    move-object v4, v12
    move-object v5, v13
    move-object v6, v14
    move-object/from16 v8, v16
    invoke-direct/range v1 ... v8, Lcom/bytedance/trae/conversation/chat/menu/RevertConfirmDialog;-><init>(Landroid/content/Context; Ljava/lang/String; Ljava/util/List; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method private static final onCreate$lambda$4(com.bytedance.trae.conversation.chat.menu.RevertConfirmDialog  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/menu/RevertConfirmDialog;->dismiss()V
    return-void 
.end method

.method private static final onCreate$lambda$5(com.bytedance.trae.conversation.chat.menu.RevertConfirmDialog  android.view.View)void
    .registers 2
    # ins_size=2
    iget-object v1, v0, Lcom/bytedance/trae/conversation/chat/menu/RevertConfirmDialog;->onConfirm Lkotlin/jvm/functions/Function0;
    invoke-interface v1, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/menu/RevertConfirmDialog;->dismiss()V
    return-void 
.end method

.method protected onCreate(android.os.Bundle)void
    .registers 12
    # ins_size=2
    invoke-super v10, v11, Landroid/app/Dialog;->onCreate(Landroid/os/Bundle;)V
    sget v11, Lcom/bytedance/trae/conversation/R$layout;->trae_revert_dialog I
    invoke-virtual v10, v11, Lcom/bytedance/trae/conversation/chat/menu/RevertConfirmDialog;->setContentView(I)V
    invoke-virtual v10, Lcom/bytedance/trae/conversation/chat/menu/RevertConfirmDialog;->getWindow()Landroid/view/Window;
    move-result-object v11
    const/4 v0, 0
    if-eqz v11, +01ah
    new-instance v1, Landroid/graphics/drawable/ColorDrawable;
    invoke-direct v1, v0, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V
    check-cast v1, Landroid/graphics/drawable/Drawable;
    invoke-virtual v11, v1, Landroid/view/Window;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V
    const/4 v1, -2
    invoke-virtual v11, v1, v1, Landroid/view/Window;->setLayout(I I)V
    const/16 v1, 17
    invoke-virtual v11, v1, Landroid/view/Window;->setGravity(I)V
    const/high16 v1, 1056964608
    invoke-virtual v11, v1, Landroid/view/Window;->setDimAmount(F)V
    const/4 v11, 1
    invoke-virtual v10, v11, Lcom/bytedance/trae/conversation/chat/menu/RevertConfirmDialog;->setCancelable(Z)V
    invoke-virtual v10, v11, Lcom/bytedance/trae/conversation/chat/menu/RevertConfirmDialog;->setCanceledOnTouchOutside(Z)V
    sget v1, Lcom/bytedance/trae/conversation/R$id;->tv_dialog_title I
    invoke-virtual v10, v1, Lcom/bytedance/trae/conversation/chat/menu/RevertConfirmDialog;->findViewById(I)Landroid/view/View;
    move-result-object v1
    check-cast v1, Landroid/widget/TextView;
    sget v2, Lcom/bytedance/trae/conversation/R$id;->tv_message I
    invoke-virtual v10, v2, Lcom/bytedance/trae/conversation/chat/menu/RevertConfirmDialog;->findViewById(I)Landroid/view/View;
    move-result-object v2
    check-cast v2, Landroid/widget/TextView;
    sget v3, Lcom/bytedance/trae/conversation/R$id;->rv_file_list I
    invoke-virtual v10, v3, Lcom/bytedance/trae/conversation/chat/menu/RevertConfirmDialog;->findViewById(I)Landroid/view/View;
    move-result-object v3
    check-cast v3, Landroidx/recyclerview/widget/RecyclerView;
    sget v4, Lcom/bytedance/trae/conversation/R$id;->btn_cancel I
    invoke-virtual v10, v4, Lcom/bytedance/trae/conversation/chat/menu/RevertConfirmDialog;->findViewById(I)Landroid/view/View;
    move-result-object v4
    check-cast v4, Landroid/widget/TextView;
    sget v5, Lcom/bytedance/trae/conversation/R$id;->btn_confirm I
    invoke-virtual v10, v5, Lcom/bytedance/trae/conversation/chat/menu/RevertConfirmDialog;->findViewById(I)Landroid/view/View;
    move-result-object v5
    check-cast v5, Landroid/widget/TextView;
    new-instance v6, Landroid/graphics/drawable/GradientDrawable;
    invoke-direct v6, Landroid/graphics/drawable/GradientDrawable;-><init>()V
    const-string v7, "#F5F5F5"
    invoke-static v7, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I
    move-result v7
    invoke-virtual v6, v7, Landroid/graphics/drawable/GradientDrawable;->setColor(I)V
    invoke-virtual v10, Lcom/bytedance/trae/conversation/chat/menu/RevertConfirmDialog;->getContext()Landroid/content/Context;
    move-result-object v7
    invoke-virtual v7, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v7
    invoke-virtual v7, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v7
    iget v7, v7, Landroid/util/DisplayMetrics;->density F
    const/high16 v8, 1107820544
    mul-float/2addr v7, v8
    invoke-virtual v6, v7, Landroid/graphics/drawable/GradientDrawable;->setCornerRadius(F)V
    sget v7, Lcom/bytedance/trae/conversation/R$id;->tv_dialog_title I
    invoke-virtual v10, v7, Lcom/bytedance/trae/conversation/chat/menu/RevertConfirmDialog;->findViewById(I)Landroid/view/View;
    move-result-object v7
    invoke-virtual v7, Landroid/view/View;->getParent()Landroid/view/ViewParent;
    move-result-object v7
    const-string v8, "null cannot be cast to non-null type android.view.View"
    invoke-static v7, v8, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v7, Landroid/view/View;
    check-cast v6, Landroid/graphics/drawable/Drawable;
    invoke-virtual v7, v6, Landroid/view/View;->setBackground(Landroid/graphics/drawable/Drawable;)V
    iget-object v6, v10, Lcom/bytedance/trae/conversation/chat/menu/RevertConfirmDialog;->title Ljava/lang/String;
    check-cast v6, Ljava/lang/CharSequence;
    invoke-virtual v1, v6, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v1, v10, Lcom/bytedance/trae/conversation/chat/menu/RevertConfirmDialog;->diffFileInfos Ljava/util/List;
    if-nez v1, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v1
    iget-object v6, v10, Lcom/bytedance/trae/conversation/chat/menu/RevertConfirmDialog;->customMessage Ljava/lang/String;
    if-eqz v6, +008h
    check-cast v6, Ljava/lang/CharSequence;
    invoke-virtual v2, v6, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    goto +32h
    invoke-interface v1, Ljava/util/List;->isEmpty()Z
    move-result v6
    if-eqz v6, +012h
    invoke-virtual v10, Lcom/bytedance/trae/conversation/chat/menu/RevertConfirmDialog;->getContext()Landroid/content/Context;
    move-result-object v0
    sget v6, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_revert_dialog_message_empty I
    invoke-virtual v0, v6, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v2, v0, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    goto +1ch
    invoke-virtual v10, Lcom/bytedance/trae/conversation/chat/menu/RevertConfirmDialog;->getContext()Landroid/content/Context;
    move-result-object v6
    sget v7, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_revert_dialog_message I
    new-array v8, v11, [Ljava/lang/Object;
    invoke-interface v1, Ljava/util/List;->size()I
    move-result v9
    invoke-static v9, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v9
    aput-object v9, v8, v0
    invoke-virtual v6, v7, v8, Landroid/content/Context;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v2, v0, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    move-object v0, v1
    check-cast v0, Ljava/util/Collection;
    invoke-interface v0, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    xor-int/2addr v11, v0
    if-eqz v11, +01bh
    new-instance v11, Landroidx/recyclerview/widget/LinearLayoutManager;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/chat/menu/RevertConfirmDialog;->getContext()Landroid/content/Context;
    move-result-object v0
    invoke-direct v11, v0, Landroidx/recyclerview/widget/LinearLayoutManager;-><init>(Landroid/content/Context;)V
    check-cast v11, Landroidx/recyclerview/widget/RecyclerView$LayoutManager;
    invoke-virtual v3, v11, Landroidx/recyclerview/widget/RecyclerView;->setLayoutManager(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)V
    new-instance v11, Lcom/bytedance/trae/conversation/chat/menu/RevertConfirmDialog$DiffFileAdapter;
    invoke-direct v11, v1, Lcom/bytedance/trae/conversation/chat/menu/RevertConfirmDialog$DiffFileAdapter;-><init>(Ljava/util/List;)V
    check-cast v11, Landroidx/recyclerview/widget/RecyclerView$Adapter;
    invoke-virtual v3, v11, Landroidx/recyclerview/widget/RecyclerView;->setAdapter(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V
    goto +6h
    const/16 v11, 8
    invoke-virtual v3, v11, Landroidx/recyclerview/widget/RecyclerView;->setVisibility(I)V
    new-instance v11, Landroid/graphics/drawable/GradientDrawable;
    invoke-direct v11, Landroid/graphics/drawable/GradientDrawable;-><init>()V
    const-string v0, "#29787880"
    invoke-static v0, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I
    move-result v0
    invoke-virtual v11, v0, Landroid/graphics/drawable/GradientDrawable;->setColor(I)V
    invoke-virtual v10, Lcom/bytedance/trae/conversation/chat/menu/RevertConfirmDialog;->getContext()Landroid/content/Context;
    move-result-object v0
    invoke-virtual v0, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    invoke-virtual v0, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v0
    iget v0, v0, Landroid/util/DisplayMetrics;->density F
    const/high16 v1, 1120403456
    mul-float/2addr v0, v1
    invoke-virtual v11, v0, Landroid/graphics/drawable/GradientDrawable;->setCornerRadius(F)V
    iget-object v0, v10, Lcom/bytedance/trae/conversation/chat/menu/RevertConfirmDialog;->cancelText Ljava/lang/String;
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v4, v0, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    check-cast v11, Landroid/graphics/drawable/Drawable;
    invoke-virtual v4, v11, Landroid/widget/TextView;->setBackground(Landroid/graphics/drawable/Drawable;)V
    iget-object v0, v10, Lcom/bytedance/trae/conversation/chat/menu/RevertConfirmDialog;->confirmText Ljava/lang/String;
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v5, v0, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-virtual v5, v11, Landroid/widget/TextView;->setBackground(Landroid/graphics/drawable/Drawable;)V
    new-instance v11, Lcom/bytedance/trae/conversation/chat/menu/RevertConfirmDialog$$ExternalSyntheticLambda0;
    invoke-direct v11, v10, Lcom/bytedance/trae/conversation/chat/menu/RevertConfirmDialog$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/chat/menu/RevertConfirmDialog;)V
    invoke-virtual v4, v11, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    new-instance v11, Lcom/bytedance/trae/conversation/chat/menu/RevertConfirmDialog$$ExternalSyntheticLambda1;
    invoke-direct v11, v10, Lcom/bytedance/trae/conversation/chat/menu/RevertConfirmDialog$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/chat/menu/RevertConfirmDialog;)V
    invoke-virtual v5, v11, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method
