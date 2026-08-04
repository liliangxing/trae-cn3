# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/databinding/DialogDeleteAccountConfirmBinding;
.super Ljava/lang/Object;
.source "DialogDeleteAccountConfirmBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final btnCancel:Landroid/widget/TextView;
.field public final btnConfirm:Landroid/widget/TextView;
.field private final rootView:Landroid/widget/LinearLayout;
.field public final tvDialogMessage:Landroid/widget/TextView;


.method private constructor <init>(android.widget.LinearLayout  android.widget.TextView  android.widget.TextView  android.widget.TextView)void
    .registers 5
    # ins_size=5
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/DialogDeleteAccountConfirmBinding;->rootView Landroid/widget/LinearLayout;
    iput-object v2, v0, Lcom/bytedance/trae/home/databinding/DialogDeleteAccountConfirmBinding;->btnCancel Landroid/widget/TextView;
    iput-object v3, v0, Lcom/bytedance/trae/home/databinding/DialogDeleteAccountConfirmBinding;->btnConfirm Landroid/widget/TextView;
    iput-object v4, v0, Lcom/bytedance/trae/home/databinding/DialogDeleteAccountConfirmBinding;->tvDialogMessage Landroid/widget/TextView;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.home.databinding.DialogDeleteAccountConfirmBinding
    .registers 5
    # ins_size=1
    sget v0, Lcom/bytedance/trae/home/R$id;->btn_cancel I
    invoke-static v4, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    check-cast v1, Landroid/widget/TextView;
    if-eqz v1, +01eh
    sget v0, Lcom/bytedance/trae/home/R$id;->btn_confirm I
    invoke-static v4, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    check-cast v2, Landroid/widget/TextView;
    if-eqz v2, +014h
    sget v0, Lcom/bytedance/trae/home/R$id;->tv_dialog_message I
    invoke-static v4, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v3
    check-cast v3, Landroid/widget/TextView;
    if-eqz v3, +00ah
    new-instance v0, Lcom/bytedance/trae/home/databinding/DialogDeleteAccountConfirmBinding;
    check-cast v4, Landroid/widget/LinearLayout;
    invoke-direct v0, v4, v1, v2, v3, Lcom/bytedance/trae/home/databinding/DialogDeleteAccountConfirmBinding;-><init>(Landroid/widget/LinearLayout; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView;)V
    return-object v0
    invoke-virtual v4, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v4
    invoke-virtual v4, v0, Landroid/content/res/Resources;->getResourceName(I)Ljava/lang/String;
    move-result-object v4
    new-instance v0, Ljava/lang/NullPointerException;
    const-string v1, "Missing required view with ID: "
    invoke-virtual v1, v4, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    invoke-direct v0, v4, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V
    throw v0
.end method

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.home.databinding.DialogDeleteAccountConfirmBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/home/databinding/DialogDeleteAccountConfirmBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/home/databinding/DialogDeleteAccountConfirmBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.home.databinding.DialogDeleteAccountConfirmBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/home/R$layout;->dialog_delete_account_confirm I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/home/databinding/DialogDeleteAccountConfirmBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/home/databinding/DialogDeleteAccountConfirmBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/home/databinding/DialogDeleteAccountConfirmBinding;->getRoot()Landroid/widget/LinearLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()android.widget.LinearLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/databinding/DialogDeleteAccountConfirmBinding;->rootView Landroid/widget/LinearLayout;
    return-object v0
.end method
