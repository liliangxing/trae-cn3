# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/databinding/FragmentDebugLoginDevicesBinding;
.super Ljava/lang/Object;
.source "FragmentDebugLoginDevicesBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final progressLoading:Landroid/widget/ProgressBar;
.field private final rootView:Landroid/widget/LinearLayout;
.field public final rvLoginDevices:Landroidx/recyclerview/widget/RecyclerView;
.field public final titleBar:Lcom/bytedance/trae/common/widget/TraeTitleBar;
.field public final tvEmpty:Landroid/widget/TextView;


.method private constructor <init>(android.widget.LinearLayout  android.widget.ProgressBar  androidx.recyclerview.widget.RecyclerView  com.bytedance.trae.common.widget.TraeTitleBar  android.widget.TextView)void
    .registers 6
    # ins_size=6
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentDebugLoginDevicesBinding;->rootView Landroid/widget/LinearLayout;
    iput-object v2, v0, Lcom/bytedance/trae/home/databinding/FragmentDebugLoginDevicesBinding;->progressLoading Landroid/widget/ProgressBar;
    iput-object v3, v0, Lcom/bytedance/trae/home/databinding/FragmentDebugLoginDevicesBinding;->rvLoginDevices Landroidx/recyclerview/widget/RecyclerView;
    iput-object v4, v0, Lcom/bytedance/trae/home/databinding/FragmentDebugLoginDevicesBinding;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    iput-object v5, v0, Lcom/bytedance/trae/home/databinding/FragmentDebugLoginDevicesBinding;->tvEmpty Landroid/widget/TextView;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.home.databinding.FragmentDebugLoginDevicesBinding
    .registers 9
    # ins_size=1
    sget v0, Lcom/bytedance/trae/home/R$id;->progress_loading I
    invoke-static v8, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v4, v1
    check-cast v4, Landroid/widget/ProgressBar;
    if-eqz v4, +02dh
    sget v0, Lcom/bytedance/trae/home/R$id;->rv_login_devices I
    invoke-static v8, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v5, v1
    check-cast v5, Landroidx/recyclerview/widget/RecyclerView;
    if-eqz v5, +022h
    sget v0, Lcom/bytedance/trae/home/R$id;->title_bar I
    invoke-static v8, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v6, v1
    check-cast v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;
    if-eqz v6, +017h
    sget v0, Lcom/bytedance/trae/home/R$id;->tv_empty I
    invoke-static v8, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v7, v1
    check-cast v7, Landroid/widget/TextView;
    if-eqz v7, +00ch
    new-instance v0, Lcom/bytedance/trae/home/databinding/FragmentDebugLoginDevicesBinding;
    move-object v3, v8
    check-cast v3, Landroid/widget/LinearLayout;
    move-object v2, v0
    invoke-direct/range v2 ... v7, Lcom/bytedance/trae/home/databinding/FragmentDebugLoginDevicesBinding;-><init>(Landroid/widget/LinearLayout; Landroid/widget/ProgressBar; Landroidx/recyclerview/widget/RecyclerView; Lcom/bytedance/trae/common/widget/TraeTitleBar; Landroid/widget/TextView;)V
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

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.home.databinding.FragmentDebugLoginDevicesBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/home/databinding/FragmentDebugLoginDevicesBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/home/databinding/FragmentDebugLoginDevicesBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.home.databinding.FragmentDebugLoginDevicesBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/home/R$layout;->fragment_debug_login_devices I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/home/databinding/FragmentDebugLoginDevicesBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/home/databinding/FragmentDebugLoginDevicesBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/home/databinding/FragmentDebugLoginDevicesBinding;->getRoot()Landroid/widget/LinearLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()android.widget.LinearLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/databinding/FragmentDebugLoginDevicesBinding;->rootView Landroid/widget/LinearLayout;
    return-object v0
.end method
