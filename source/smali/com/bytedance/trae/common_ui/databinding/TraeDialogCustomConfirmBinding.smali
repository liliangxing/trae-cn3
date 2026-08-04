# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/common_ui/databinding/TraeDialogCustomConfirmBinding;
.super Ljava/lang/Object;
.source "TraeDialogCustomConfirmBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final btnCancel:Landroid/widget/TextView;
.field public final btnConfirm:Landroid/widget/TextView;
.field public final customConfirmDialogRoot:Landroid/widget/LinearLayout;
.field public final etInput:Landroid/widget/EditText;
.field public final llButtons:Landroid/widget/LinearLayout;
.field private final rootView:Landroid/widget/LinearLayout;
.field public final tvDialogTitle:Landroid/widget/TextView;
.field public final tvMessage:Landroid/widget/TextView;
.field public final vButtonSpacer:Landroid/view/View;


.method private constructor <init>(android.widget.LinearLayout  android.widget.TextView  android.widget.TextView  android.widget.LinearLayout  android.widget.EditText  android.widget.LinearLayout  android.widget.TextView  android.widget.TextView  android.view.View)void
    .registers 10
    # ins_size=10
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/common_ui/databinding/TraeDialogCustomConfirmBinding;->rootView Landroid/widget/LinearLayout;
    iput-object v2, v0, Lcom/bytedance/trae/common_ui/databinding/TraeDialogCustomConfirmBinding;->btnCancel Landroid/widget/TextView;
    iput-object v3, v0, Lcom/bytedance/trae/common_ui/databinding/TraeDialogCustomConfirmBinding;->btnConfirm Landroid/widget/TextView;
    iput-object v4, v0, Lcom/bytedance/trae/common_ui/databinding/TraeDialogCustomConfirmBinding;->customConfirmDialogRoot Landroid/widget/LinearLayout;
    iput-object v5, v0, Lcom/bytedance/trae/common_ui/databinding/TraeDialogCustomConfirmBinding;->etInput Landroid/widget/EditText;
    iput-object v6, v0, Lcom/bytedance/trae/common_ui/databinding/TraeDialogCustomConfirmBinding;->llButtons Landroid/widget/LinearLayout;
    iput-object v7, v0, Lcom/bytedance/trae/common_ui/databinding/TraeDialogCustomConfirmBinding;->tvDialogTitle Landroid/widget/TextView;
    iput-object v8, v0, Lcom/bytedance/trae/common_ui/databinding/TraeDialogCustomConfirmBinding;->tvMessage Landroid/widget/TextView;
    iput-object v9, v0, Lcom/bytedance/trae/common_ui/databinding/TraeDialogCustomConfirmBinding;->vButtonSpacer Landroid/view/View;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.common_ui.databinding.TraeDialogCustomConfirmBinding
    .registers 13
    # ins_size=1
    sget v0, Lcom/bytedance/trae/common_ui/R$id;->btn_cancel I
    invoke-static v12, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v4, v1
    check-cast v4, Landroid/widget/TextView;
    if-eqz v4, +04ch
    sget v0, Lcom/bytedance/trae/common_ui/R$id;->btn_confirm I
    invoke-static v12, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v5, v1
    check-cast v5, Landroid/widget/TextView;
    if-eqz v5, +041h
    move-object v6, v12
    check-cast v6, Landroid/widget/LinearLayout;
    sget v0, Lcom/bytedance/trae/common_ui/R$id;->et_input I
    invoke-static v12, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v7, v1
    check-cast v7, Landroid/widget/EditText;
    if-eqz v7, +033h
    sget v0, Lcom/bytedance/trae/common_ui/R$id;->ll_buttons I
    invoke-static v12, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v8, v1
    check-cast v8, Landroid/widget/LinearLayout;
    if-eqz v8, +028h
    sget v0, Lcom/bytedance/trae/common_ui/R$id;->tv_dialog_title I
    invoke-static v12, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v9, v1
    check-cast v9, Landroid/widget/TextView;
    if-eqz v9, +01dh
    sget v0, Lcom/bytedance/trae/common_ui/R$id;->tv_message I
    invoke-static v12, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v10, v1
    check-cast v10, Landroid/widget/TextView;
    if-eqz v10, +012h
    sget v0, Lcom/bytedance/trae/common_ui/R$id;->v_button_spacer I
    invoke-static v12, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v11
    if-eqz v11, +00ah
    new-instance v12, Lcom/bytedance/trae/common_ui/databinding/TraeDialogCustomConfirmBinding;
    move-object v2, v12
    move-object v3, v6
    invoke-direct/range v2 ... v11, Lcom/bytedance/trae/common_ui/databinding/TraeDialogCustomConfirmBinding;-><init>(Landroid/widget/LinearLayout; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/LinearLayout; Landroid/widget/EditText; Landroid/widget/LinearLayout; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/view/View;)V
    return-object v12
    invoke-virtual v12, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v12
    invoke-virtual v12, v0, Landroid/content/res/Resources;->getResourceName(I)Ljava/lang/String;
    move-result-object v12
    new-instance v0, Ljava/lang/NullPointerException;
    const-string v1, "Missing required view with ID: "
    invoke-virtual v1, v12, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v12
    invoke-direct v0, v12, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V
    throw v0
.end method

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.common_ui.databinding.TraeDialogCustomConfirmBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/common_ui/databinding/TraeDialogCustomConfirmBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/common_ui/databinding/TraeDialogCustomConfirmBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.common_ui.databinding.TraeDialogCustomConfirmBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/common_ui/R$layout;->trae_dialog_custom_confirm I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/common_ui/databinding/TraeDialogCustomConfirmBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/common_ui/databinding/TraeDialogCustomConfirmBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/common_ui/databinding/TraeDialogCustomConfirmBinding;->getRoot()Landroid/widget/LinearLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()android.widget.LinearLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/common_ui/databinding/TraeDialogCustomConfirmBinding;->rootView Landroid/widget/LinearLayout;
    return-object v0
.end method
