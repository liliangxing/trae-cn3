# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/databinding/TraeSelectProjectPermissionBinding;
.super Ljava/lang/Object;
.source "TraeSelectProjectPermissionBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final btnAllow:Landroid/widget/TextView;
.field public final btnCancel:Landroid/widget/TextView;
.field private final rootView:Landroidx/cardview/widget/CardView;
.field public final tvSubtitle:Landroid/widget/TextView;
.field public final tvTitle:Landroid/widget/TextView;


.method private constructor <init>(androidx.cardview.widget.CardView  android.widget.TextView  android.widget.TextView  android.widget.TextView  android.widget.TextView)void
    .registers 6
    # ins_size=6
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeSelectProjectPermissionBinding;->rootView Landroidx/cardview/widget/CardView;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/databinding/TraeSelectProjectPermissionBinding;->btnAllow Landroid/widget/TextView;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/databinding/TraeSelectProjectPermissionBinding;->btnCancel Landroid/widget/TextView;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/databinding/TraeSelectProjectPermissionBinding;->tvSubtitle Landroid/widget/TextView;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/databinding/TraeSelectProjectPermissionBinding;->tvTitle Landroid/widget/TextView;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.conversation.databinding.TraeSelectProjectPermissionBinding
    .registers 9
    # ins_size=1
    sget v0, Lcom/bytedance/trae/conversation/R$id;->btn_allow I
    invoke-static v8, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v4, v1
    check-cast v4, Landroid/widget/TextView;
    if-eqz v4, +02dh
    sget v0, Lcom/bytedance/trae/conversation/R$id;->btn_cancel I
    invoke-static v8, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v5, v1
    check-cast v5, Landroid/widget/TextView;
    if-eqz v5, +022h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_subtitle I
    invoke-static v8, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v6, v1
    check-cast v6, Landroid/widget/TextView;
    if-eqz v6, +017h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_title I
    invoke-static v8, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v7, v1
    check-cast v7, Landroid/widget/TextView;
    if-eqz v7, +00ch
    new-instance v0, Lcom/bytedance/trae/conversation/databinding/TraeSelectProjectPermissionBinding;
    move-object v3, v8
    check-cast v3, Landroidx/cardview/widget/CardView;
    move-object v2, v0
    invoke-direct/range v2 ... v7, Lcom/bytedance/trae/conversation/databinding/TraeSelectProjectPermissionBinding;-><init>(Landroidx/cardview/widget/CardView; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView;)V
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

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.conversation.databinding.TraeSelectProjectPermissionBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeSelectProjectPermissionBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/conversation/databinding/TraeSelectProjectPermissionBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.conversation.databinding.TraeSelectProjectPermissionBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/conversation/R$layout;->trae_select_project_permission I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/conversation/databinding/TraeSelectProjectPermissionBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/conversation/databinding/TraeSelectProjectPermissionBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/databinding/TraeSelectProjectPermissionBinding;->getRoot()Landroidx/cardview/widget/CardView;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()androidx.cardview.widget.CardView
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeSelectProjectPermissionBinding;->rootView Landroidx/cardview/widget/CardView;
    return-object v0
.end method
