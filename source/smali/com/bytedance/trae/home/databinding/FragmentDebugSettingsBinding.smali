# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/databinding/FragmentDebugSettingsBinding;
.super Ljava/lang/Object;
.source "FragmentDebugSettingsBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final btnClear:Landroid/widget/TextView;
.field public final btnClearBillingUpgradePromptCache:Landroid/widget/TextView;
.field public final btnCopyDeviceInfo:Landroid/widget/TextView;
.field public final btnCustomHeaderAdd:Landroid/widget/TextView;
.field public final btnCustomHeaderClearAll:Landroid/widget/TextView;
.field public final btnEnvLaneReset:Landroid/widget/TextView;
.field public final btnEnvLaneSave:Landroid/widget/TextView;
.field public final btnSave:Landroid/widget/TextView;
.field public final btnUploadAlog:Landroid/widget/TextView;
.field public final btnViewLoginDevices:Landroid/widget/TextView;
.field public final cbMockDid:Landroid/widget/CheckBox;
.field public final etCustomHeaderKey:Landroid/widget/EditText;
.field public final etCustomHeaderValue:Landroid/widget/EditText;
.field public final etEnvLane:Landroid/widget/EditText;
.field public final etPpeEnv:Landroid/widget/EditText;
.field public final llCustomHeaders:Landroid/widget/LinearLayout;
.field public final llPpeHistory:Landroid/widget/LinearLayout;
.field private final rootView:Landroid/widget/LinearLayout;
.field public final titleBar:Lcom/bytedance/trae/common/widget/TraeTitleBar;
.field public final tvDeviceId:Landroid/widget/TextView;
.field public final tvEnvLaneCurrent:Landroid/widget/TextView;
.field public final tvPassportUserId:Landroid/widget/TextView;
.field public final tvPpeCurrent:Landroid/widget/TextView;
.field public final tvPpeHistoryLabel:Landroid/widget/TextView;
.field public final tvUserId:Landroid/widget/TextView;


.method private constructor <init>(android.widget.LinearLayout  android.widget.TextView  android.widget.TextView  android.widget.TextView  android.widget.TextView  android.widget.TextView  android.widget.TextView  android.widget.TextView  android.widget.TextView  android.widget.TextView  android.widget.TextView  android.widget.CheckBox  android.widget.EditText  android.widget.EditText  android.widget.EditText  android.widget.EditText  android.widget.LinearLayout  android.widget.LinearLayout  com.bytedance.trae.common.widget.TraeTitleBar  android.widget.TextView  android.widget.TextView  android.widget.TextView  android.widget.TextView  android.widget.TextView  android.widget.TextView)void
    .registers 28
    # ins_size=26
    move-object v0, v2
    invoke-direct v2, Ljava/lang/Object;-><init>()V
    move-object v1, v3
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentDebugSettingsBinding;->rootView Landroid/widget/LinearLayout;
    move-object v1, v4
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentDebugSettingsBinding;->btnClear Landroid/widget/TextView;
    move-object v1, v5
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentDebugSettingsBinding;->btnClearBillingUpgradePromptCache Landroid/widget/TextView;
    move-object v1, v6
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentDebugSettingsBinding;->btnCopyDeviceInfo Landroid/widget/TextView;
    move-object v1, v7
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentDebugSettingsBinding;->btnCustomHeaderAdd Landroid/widget/TextView;
    move-object v1, v8
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentDebugSettingsBinding;->btnCustomHeaderClearAll Landroid/widget/TextView;
    move-object v1, v9
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentDebugSettingsBinding;->btnEnvLaneReset Landroid/widget/TextView;
    move-object v1, v10
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentDebugSettingsBinding;->btnEnvLaneSave Landroid/widget/TextView;
    move-object v1, v11
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentDebugSettingsBinding;->btnSave Landroid/widget/TextView;
    move-object v1, v12
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentDebugSettingsBinding;->btnUploadAlog Landroid/widget/TextView;
    move-object v1, v13
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentDebugSettingsBinding;->btnViewLoginDevices Landroid/widget/TextView;
    move-object v1, v14
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentDebugSettingsBinding;->cbMockDid Landroid/widget/CheckBox;
    move-object v1, v15
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentDebugSettingsBinding;->etCustomHeaderKey Landroid/widget/EditText;
    move-object/from16 v1, v16
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentDebugSettingsBinding;->etCustomHeaderValue Landroid/widget/EditText;
    move-object/from16 v1, v17
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentDebugSettingsBinding;->etEnvLane Landroid/widget/EditText;
    move-object/from16 v1, v18
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentDebugSettingsBinding;->etPpeEnv Landroid/widget/EditText;
    move-object/from16 v1, v19
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentDebugSettingsBinding;->llCustomHeaders Landroid/widget/LinearLayout;
    move-object/from16 v1, v20
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentDebugSettingsBinding;->llPpeHistory Landroid/widget/LinearLayout;
    move-object/from16 v1, v21
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentDebugSettingsBinding;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    move-object/from16 v1, v22
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentDebugSettingsBinding;->tvDeviceId Landroid/widget/TextView;
    move-object/from16 v1, v23
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentDebugSettingsBinding;->tvEnvLaneCurrent Landroid/widget/TextView;
    move-object/from16 v1, v24
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentDebugSettingsBinding;->tvPassportUserId Landroid/widget/TextView;
    move-object/from16 v1, v25
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentDebugSettingsBinding;->tvPpeCurrent Landroid/widget/TextView;
    move-object/from16 v1, v26
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentDebugSettingsBinding;->tvPpeHistoryLabel Landroid/widget/TextView;
    move-object/from16 v1, v27
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentDebugSettingsBinding;->tvUserId Landroid/widget/TextView;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.home.databinding.FragmentDebugSettingsBinding
    .registers 30
    # ins_size=1
    move-object/from16 v0, v29
    sget v1, Lcom/bytedance/trae/home/R$id;->btn_clear I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v5, v2
    check-cast v5, Landroid/widget/TextView;
    if-eqz v5, +116h
    sget v1, Lcom/bytedance/trae/home/R$id;->btn_clear_billing_upgrade_prompt_cache I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v6, v2
    check-cast v6, Landroid/widget/TextView;
    if-eqz v6, +10bh
    sget v1, Lcom/bytedance/trae/home/R$id;->btn_copy_device_info I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v7, v2
    check-cast v7, Landroid/widget/TextView;
    if-eqz v7, +100h
    sget v1, Lcom/bytedance/trae/home/R$id;->btn_custom_header_add I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v8, v2
    check-cast v8, Landroid/widget/TextView;
    if-eqz v8, +0f5h
    sget v1, Lcom/bytedance/trae/home/R$id;->btn_custom_header_clear_all I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v9, v2
    check-cast v9, Landroid/widget/TextView;
    if-eqz v9, +0eah
    sget v1, Lcom/bytedance/trae/home/R$id;->btn_env_lane_reset I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v10, v2
    check-cast v10, Landroid/widget/TextView;
    if-eqz v10, +0dfh
    sget v1, Lcom/bytedance/trae/home/R$id;->btn_env_lane_save I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v11, v2
    check-cast v11, Landroid/widget/TextView;
    if-eqz v11, +0d4h
    sget v1, Lcom/bytedance/trae/home/R$id;->btn_save I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v12, v2
    check-cast v12, Landroid/widget/TextView;
    if-eqz v12, +0c9h
    sget v1, Lcom/bytedance/trae/home/R$id;->btn_upload_alog I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v13, v2
    check-cast v13, Landroid/widget/TextView;
    if-eqz v13, +0beh
    sget v1, Lcom/bytedance/trae/home/R$id;->btn_view_login_devices I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v14, v2
    check-cast v14, Landroid/widget/TextView;
    if-eqz v14, +0b3h
    sget v1, Lcom/bytedance/trae/home/R$id;->cb_mock_did I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v15, v2
    check-cast v15, Landroid/widget/CheckBox;
    if-eqz v15, +0a8h
    sget v1, Lcom/bytedance/trae/home/R$id;->et_custom_header_key I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v16, v2
    check-cast v16, Landroid/widget/EditText;
    if-eqz v16, +09ch
    sget v1, Lcom/bytedance/trae/home/R$id;->et_custom_header_value I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v17, v2
    check-cast v17, Landroid/widget/EditText;
    if-eqz v17, +090h
    sget v1, Lcom/bytedance/trae/home/R$id;->et_env_lane I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v18, v2
    check-cast v18, Landroid/widget/EditText;
    if-eqz v18, +084h
    sget v1, Lcom/bytedance/trae/home/R$id;->et_ppe_env I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v19, v2
    check-cast v19, Landroid/widget/EditText;
    if-eqz v19, +078h
    sget v1, Lcom/bytedance/trae/home/R$id;->ll_custom_headers I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v20, v2
    check-cast v20, Landroid/widget/LinearLayout;
    if-eqz v20, +06ch
    sget v1, Lcom/bytedance/trae/home/R$id;->ll_ppe_history I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v21, v2
    check-cast v21, Landroid/widget/LinearLayout;
    if-eqz v21, +060h
    sget v1, Lcom/bytedance/trae/home/R$id;->title_bar I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v22, v2
    check-cast v22, Lcom/bytedance/trae/common/widget/TraeTitleBar;
    if-eqz v22, +054h
    sget v1, Lcom/bytedance/trae/home/R$id;->tv_device_id I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v23, v2
    check-cast v23, Landroid/widget/TextView;
    if-eqz v23, +048h
    sget v1, Lcom/bytedance/trae/home/R$id;->tv_env_lane_current I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v24, v2
    check-cast v24, Landroid/widget/TextView;
    if-eqz v24, +03ch
    sget v1, Lcom/bytedance/trae/home/R$id;->tv_passport_user_id I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v25, v2
    check-cast v25, Landroid/widget/TextView;
    if-eqz v25, +030h
    sget v1, Lcom/bytedance/trae/home/R$id;->tv_ppe_current I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v26, v2
    check-cast v26, Landroid/widget/TextView;
    if-eqz v26, +024h
    sget v1, Lcom/bytedance/trae/home/R$id;->tv_ppe_history_label I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v27, v2
    check-cast v27, Landroid/widget/TextView;
    if-eqz v27, +018h
    sget v1, Lcom/bytedance/trae/home/R$id;->tv_user_id I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v28, v2
    check-cast v28, Landroid/widget/TextView;
    if-eqz v28, +00ch
    new-instance v1, Lcom/bytedance/trae/home/databinding/FragmentDebugSettingsBinding;
    move-object v3, v1
    move-object v4, v0
    check-cast v4, Landroid/widget/LinearLayout;
    invoke-direct/range v3 ... v28, Lcom/bytedance/trae/home/databinding/FragmentDebugSettingsBinding;-><init>(Landroid/widget/LinearLayout; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/CheckBox; Landroid/widget/EditText; Landroid/widget/EditText; Landroid/widget/EditText; Landroid/widget/EditText; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Lcom/bytedance/trae/common/widget/TraeTitleBar; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView;)V
    return-object v1
    invoke-virtual/range v29, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    invoke-virtual v0, v1, Landroid/content/res/Resources;->getResourceName(I)Ljava/lang/String;
    move-result-object v0
    new-instance v1, Ljava/lang/NullPointerException;
    const-string v2, "Missing required view with ID: "
    invoke-virtual v2, v0, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    invoke-direct v1, v0, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V
    throw v1
.end method

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.home.databinding.FragmentDebugSettingsBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/home/databinding/FragmentDebugSettingsBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/home/databinding/FragmentDebugSettingsBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.home.databinding.FragmentDebugSettingsBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/home/R$layout;->fragment_debug_settings I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/home/databinding/FragmentDebugSettingsBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/home/databinding/FragmentDebugSettingsBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/home/databinding/FragmentDebugSettingsBinding;->getRoot()Landroid/widget/LinearLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()android.widget.LinearLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/databinding/FragmentDebugSettingsBinding;->rootView Landroid/widget/LinearLayout;
    return-object v0
.end method
