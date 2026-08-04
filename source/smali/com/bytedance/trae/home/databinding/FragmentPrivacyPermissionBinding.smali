# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/databinding/FragmentPrivacyPermissionBinding;
.super Ljava/lang/Object;
.source "FragmentPrivacyPermissionBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final btnCameraPhoto:Landroid/widget/LinearLayout;
.field public final btnFileAccess:Landroid/widget/LinearLayout;
.field public final btnPhoto:Landroid/widget/LinearLayout;
.field public final btnPush:Landroid/widget/LinearLayout;
.field public final btnRecording:Landroid/widget/LinearLayout;
.field private final rootView:Landroid/widget/LinearLayout;
.field public final titleBar:Lcom/bytedance/trae/common/widget/TraeTitleBar;


.method private constructor <init>(android.widget.LinearLayout  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.LinearLayout  com.bytedance.trae.common.widget.TraeTitleBar)void
    .registers 8
    # ins_size=8
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentPrivacyPermissionBinding;->rootView Landroid/widget/LinearLayout;
    iput-object v2, v0, Lcom/bytedance/trae/home/databinding/FragmentPrivacyPermissionBinding;->btnCameraPhoto Landroid/widget/LinearLayout;
    iput-object v3, v0, Lcom/bytedance/trae/home/databinding/FragmentPrivacyPermissionBinding;->btnFileAccess Landroid/widget/LinearLayout;
    iput-object v4, v0, Lcom/bytedance/trae/home/databinding/FragmentPrivacyPermissionBinding;->btnPhoto Landroid/widget/LinearLayout;
    iput-object v5, v0, Lcom/bytedance/trae/home/databinding/FragmentPrivacyPermissionBinding;->btnPush Landroid/widget/LinearLayout;
    iput-object v6, v0, Lcom/bytedance/trae/home/databinding/FragmentPrivacyPermissionBinding;->btnRecording Landroid/widget/LinearLayout;
    iput-object v7, v0, Lcom/bytedance/trae/home/databinding/FragmentPrivacyPermissionBinding;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.home.databinding.FragmentPrivacyPermissionBinding
    .registers 11
    # ins_size=1
    sget v0, Lcom/bytedance/trae/home/R$id;->btn_camera_photo I
    invoke-static v10, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v4, v1
    check-cast v4, Landroid/widget/LinearLayout;
    if-eqz v4, +043h
    sget v0, Lcom/bytedance/trae/home/R$id;->btn_file_access I
    invoke-static v10, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v5, v1
    check-cast v5, Landroid/widget/LinearLayout;
    if-eqz v5, +038h
    sget v0, Lcom/bytedance/trae/home/R$id;->btn_photo I
    invoke-static v10, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v6, v1
    check-cast v6, Landroid/widget/LinearLayout;
    if-eqz v6, +02dh
    sget v0, Lcom/bytedance/trae/home/R$id;->btn_push I
    invoke-static v10, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v7, v1
    check-cast v7, Landroid/widget/LinearLayout;
    if-eqz v7, +022h
    sget v0, Lcom/bytedance/trae/home/R$id;->btn_recording I
    invoke-static v10, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v8, v1
    check-cast v8, Landroid/widget/LinearLayout;
    if-eqz v8, +017h
    sget v0, Lcom/bytedance/trae/home/R$id;->title_bar I
    invoke-static v10, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v9, v1
    check-cast v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;
    if-eqz v9, +00ch
    new-instance v0, Lcom/bytedance/trae/home/databinding/FragmentPrivacyPermissionBinding;
    move-object v3, v10
    check-cast v3, Landroid/widget/LinearLayout;
    move-object v2, v0
    invoke-direct/range v2 ... v9, Lcom/bytedance/trae/home/databinding/FragmentPrivacyPermissionBinding;-><init>(Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Lcom/bytedance/trae/common/widget/TraeTitleBar;)V
    return-object v0
    invoke-virtual v10, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v10
    invoke-virtual v10, v0, Landroid/content/res/Resources;->getResourceName(I)Ljava/lang/String;
    move-result-object v10
    new-instance v0, Ljava/lang/NullPointerException;
    const-string v1, "Missing required view with ID: "
    invoke-virtual v1, v10, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v10
    invoke-direct v0, v10, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V
    throw v0
.end method

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.home.databinding.FragmentPrivacyPermissionBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/home/databinding/FragmentPrivacyPermissionBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/home/databinding/FragmentPrivacyPermissionBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.home.databinding.FragmentPrivacyPermissionBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/home/R$layout;->fragment_privacy_permission I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/home/databinding/FragmentPrivacyPermissionBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/home/databinding/FragmentPrivacyPermissionBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/home/databinding/FragmentPrivacyPermissionBinding;->getRoot()Landroid/widget/LinearLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()android.widget.LinearLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/databinding/FragmentPrivacyPermissionBinding;->rootView Landroid/widget/LinearLayout;
    return-object v0
.end method
