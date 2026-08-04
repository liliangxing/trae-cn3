# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/databinding/DialogEditNameBinding;
.super Ljava/lang/Object;
.source "DialogEditNameBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final btnCancel:Landroid/widget/TextView;
.field public final btnSave:Landroid/widget/TextView;
.field public final etName:Landroid/widget/EditText;
.field private final rootView:Landroid/widget/LinearLayout;
.field public final tvCharCount:Landroid/widget/TextView;


.method private constructor <init>(android.widget.LinearLayout  android.widget.TextView  android.widget.TextView  android.widget.EditText  android.widget.TextView)void
    .registers 6
    # ins_size=6
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/DialogEditNameBinding;->rootView Landroid/widget/LinearLayout;
    iput-object v2, v0, Lcom/bytedance/trae/home/databinding/DialogEditNameBinding;->btnCancel Landroid/widget/TextView;
    iput-object v3, v0, Lcom/bytedance/trae/home/databinding/DialogEditNameBinding;->btnSave Landroid/widget/TextView;
    iput-object v4, v0, Lcom/bytedance/trae/home/databinding/DialogEditNameBinding;->etName Landroid/widget/EditText;
    iput-object v5, v0, Lcom/bytedance/trae/home/databinding/DialogEditNameBinding;->tvCharCount Landroid/widget/TextView;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.home.databinding.DialogEditNameBinding
    .registers 9
    # ins_size=1
    sget v0, Lcom/bytedance/trae/home/R$id;->btn_cancel I
    invoke-static v8, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v4, v1
    check-cast v4, Landroid/widget/TextView;
    if-eqz v4, +02dh
    sget v0, Lcom/bytedance/trae/home/R$id;->btn_save I
    invoke-static v8, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v5, v1
    check-cast v5, Landroid/widget/TextView;
    if-eqz v5, +022h
    sget v0, Lcom/bytedance/trae/home/R$id;->et_name I
    invoke-static v8, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v6, v1
    check-cast v6, Landroid/widget/EditText;
    if-eqz v6, +017h
    sget v0, Lcom/bytedance/trae/home/R$id;->tv_char_count I
    invoke-static v8, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v7, v1
    check-cast v7, Landroid/widget/TextView;
    if-eqz v7, +00ch
    new-instance v0, Lcom/bytedance/trae/home/databinding/DialogEditNameBinding;
    move-object v3, v8
    check-cast v3, Landroid/widget/LinearLayout;
    move-object v2, v0
    invoke-direct/range v2 ... v7, Lcom/bytedance/trae/home/databinding/DialogEditNameBinding;-><init>(Landroid/widget/LinearLayout; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/EditText; Landroid/widget/TextView;)V
    return-object v0
    invoke-virtual v8, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v8
    invoke-virtual v8, v0, Landroid/content/res/Resources;->getResourceName(I)Ljava/lang/String;
    move-result-object v8
    new-instance v0, Ljava/lang/NullPointerException;
    const-string v1, "Missing required view with ID: "
    invoke-virtual v1, v8, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v8
    invoke-direct v0, v8, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V
    throw v0
.end method

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.home.databinding.DialogEditNameBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/home/databinding/DialogEditNameBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/home/databinding/DialogEditNameBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.home.databinding.DialogEditNameBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/home/R$layout;->dialog_edit_name I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/home/databinding/DialogEditNameBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/home/databinding/DialogEditNameBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/home/databinding/DialogEditNameBinding;->getRoot()Landroid/widget/LinearLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()android.widget.LinearLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/databinding/DialogEditNameBinding;->rootView Landroid/widget/LinearLayout;
    return-object v0
.end method
