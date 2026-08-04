# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/update/bits/impl/databinding/TraeUpdateProgressDialogBinding;
.super Ljava/lang/Object;
.source "TraeUpdateProgressDialogBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field private final rootView:Landroidx/cardview/widget/CardView;
.field public final tvDialogTitle:Landroid/widget/TextView;
.field public final tvProgressPercent:Landroid/widget/TextView;
.field public final tvUpdateHint:Landroid/widget/TextView;
.field public final updateProgressBar:Landroid/widget/ProgressBar;


.method private constructor <init>(androidx.cardview.widget.CardView  android.widget.TextView  android.widget.TextView  android.widget.TextView  android.widget.ProgressBar)void
    .registers 6
    # ins_size=6
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/update/bits/impl/databinding/TraeUpdateProgressDialogBinding;->rootView Landroidx/cardview/widget/CardView;
    iput-object v2, v0, Lcom/bytedance/trae/update/bits/impl/databinding/TraeUpdateProgressDialogBinding;->tvDialogTitle Landroid/widget/TextView;
    iput-object v3, v0, Lcom/bytedance/trae/update/bits/impl/databinding/TraeUpdateProgressDialogBinding;->tvProgressPercent Landroid/widget/TextView;
    iput-object v4, v0, Lcom/bytedance/trae/update/bits/impl/databinding/TraeUpdateProgressDialogBinding;->tvUpdateHint Landroid/widget/TextView;
    iput-object v5, v0, Lcom/bytedance/trae/update/bits/impl/databinding/TraeUpdateProgressDialogBinding;->updateProgressBar Landroid/widget/ProgressBar;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.update.bits.impl.databinding.TraeUpdateProgressDialogBinding
    .registers 9
    # ins_size=1
    sget v0, Lcom/bytedance/trae/update/bits/impl/R$id;->tvDialogTitle I
    invoke-static v8, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v4, v1
    check-cast v4, Landroid/widget/TextView;
    if-eqz v4, +02dh
    sget v0, Lcom/bytedance/trae/update/bits/impl/R$id;->tvProgressPercent I
    invoke-static v8, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v5, v1
    check-cast v5, Landroid/widget/TextView;
    if-eqz v5, +022h
    sget v0, Lcom/bytedance/trae/update/bits/impl/R$id;->tv_update_hint I
    invoke-static v8, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v6, v1
    check-cast v6, Landroid/widget/TextView;
    if-eqz v6, +017h
    sget v0, Lcom/bytedance/trae/update/bits/impl/R$id;->updateProgressBar I
    invoke-static v8, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v7, v1
    check-cast v7, Landroid/widget/ProgressBar;
    if-eqz v7, +00ch
    new-instance v0, Lcom/bytedance/trae/update/bits/impl/databinding/TraeUpdateProgressDialogBinding;
    move-object v3, v8
    check-cast v3, Landroidx/cardview/widget/CardView;
    move-object v2, v0
    invoke-direct/range v2 ... v7, Lcom/bytedance/trae/update/bits/impl/databinding/TraeUpdateProgressDialogBinding;-><init>(Landroidx/cardview/widget/CardView; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/ProgressBar;)V
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

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.update.bits.impl.databinding.TraeUpdateProgressDialogBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/update/bits/impl/databinding/TraeUpdateProgressDialogBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/update/bits/impl/databinding/TraeUpdateProgressDialogBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.update.bits.impl.databinding.TraeUpdateProgressDialogBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/update/bits/impl/R$layout;->trae_update_progress_dialog I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/update/bits/impl/databinding/TraeUpdateProgressDialogBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/update/bits/impl/databinding/TraeUpdateProgressDialogBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/update/bits/impl/databinding/TraeUpdateProgressDialogBinding;->getRoot()Landroidx/cardview/widget/CardView;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()androidx.cardview.widget.CardView
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/update/bits/impl/databinding/TraeUpdateProgressDialogBinding;->rootView Landroidx/cardview/widget/CardView;
    return-object v0
.end method
