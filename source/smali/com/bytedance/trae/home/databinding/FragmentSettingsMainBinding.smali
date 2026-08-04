# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/databinding/FragmentSettingsMainBinding;
.super Ljava/lang/Object;
.source "FragmentSettingsMainBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final btnAbout:Landroid/widget/LinearLayout;
.field public final btnAccount:Landroid/widget/LinearLayout;
.field public final btnClose:Landroid/widget/FrameLayout;
.field public final btnConnectors:Landroid/widget/LinearLayout;
.field public final btnDebug:Landroid/widget/LinearLayout;
.field public final btnDeviceManagement:Landroid/widget/LinearLayout;
.field public final btnEditProfile:Landroid/widget/TextView;
.field public final btnLanguage:Landroid/widget/LinearLayout;
.field public final btnLogout:Landroid/widget/LinearLayout;
.field public final btnMessages:Landroid/widget/LinearLayout;
.field public final btnNotification:Landroid/widget/LinearLayout;
.field public final btnPrivacyPermission:Landroid/widget/LinearLayout;
.field public final btnSubscribe:Landroid/widget/LinearLayout;
.field public final btnTheme:Landroid/widget/LinearLayout;
.field public final btnUpdate:Landroid/widget/LinearLayout;
.field public final btnUsage:Landroid/widget/LinearLayout;
.field public final dividerConnectors:Landroid/view/View;
.field public final dividerTheme:Landroid/view/View;
.field public final dividerUpdateAbout:Landroid/view/View;
.field public final groupAccountMessages:Landroid/widget/LinearLayout;
.field public final imgCnIdentity:Landroid/widget/ImageView;
.field public final ivAvatar:Lcom/facebook/drawee/view/SimpleDraweeView;
.field public final ivBytecloudBadge:Landroid/widget/ImageView;
.field private final rootView:Landroid/widget/LinearLayout;
.field public final rowPoints:Landroid/widget/LinearLayout;
.field public final toolbar:Landroidx/appcompat/widget/Toolbar;
.field public final tvCnFreeBadge:Landroid/widget/TextView;
.field public final tvCnTierBadge:Landroid/widget/TextView;
.field public final tvDebugPpeValue:Landroid/widget/TextView;
.field public final tvEmail:Landroid/widget/TextView;
.field public final tvIcpFiling:Landroid/widget/TextView;
.field public final tvLanguageValue:Landroid/widget/TextView;
.field public final tvMessageBadge:Landroid/widget/TextView;
.field public final tvModelFiling:Landroid/widget/TextView;
.field public final tvModelName:Landroid/widget/TextView;
.field public final tvName:Landroid/widget/TextView;
.field public final tvPointsBalance:Landroid/widget/TextView;
.field public final tvProBadge:Landroid/widget/TextView;
.field public final tvThemeValue:Landroid/widget/TextView;


.method private constructor <init>(android.widget.LinearLayout  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.FrameLayout  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.TextView  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.LinearLayout  android.view.View  android.view.View  android.view.View  android.widget.LinearLayout  android.widget.ImageView  com.facebook.drawee.view.SimpleDraweeView  android.widget.ImageView  android.widget.LinearLayout  androidx.appcompat.widget.Toolbar  android.widget.TextView  android.widget.TextView  android.widget.TextView  android.widget.TextView  android.widget.TextView  android.widget.TextView  android.widget.TextView  android.widget.TextView  android.widget.TextView  android.widget.TextView  android.widget.TextView  android.widget.TextView  android.widget.TextView)void
    .registers 42
    # ins_size=40
    move-object v0, v2
    invoke-direct v2, Ljava/lang/Object;-><init>()V
    move-object v1, v3
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentSettingsMainBinding;->rootView Landroid/widget/LinearLayout;
    move-object v1, v4
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentSettingsMainBinding;->btnAbout Landroid/widget/LinearLayout;
    move-object v1, v5
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentSettingsMainBinding;->btnAccount Landroid/widget/LinearLayout;
    move-object v1, v6
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentSettingsMainBinding;->btnClose Landroid/widget/FrameLayout;
    move-object v1, v7
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentSettingsMainBinding;->btnConnectors Landroid/widget/LinearLayout;
    move-object v1, v8
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentSettingsMainBinding;->btnDebug Landroid/widget/LinearLayout;
    move-object v1, v9
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentSettingsMainBinding;->btnDeviceManagement Landroid/widget/LinearLayout;
    move-object v1, v10
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentSettingsMainBinding;->btnEditProfile Landroid/widget/TextView;
    move-object v1, v11
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentSettingsMainBinding;->btnLanguage Landroid/widget/LinearLayout;
    move-object v1, v12
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentSettingsMainBinding;->btnLogout Landroid/widget/LinearLayout;
    move-object v1, v13
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentSettingsMainBinding;->btnMessages Landroid/widget/LinearLayout;
    move-object v1, v14
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentSettingsMainBinding;->btnNotification Landroid/widget/LinearLayout;
    move-object v1, v15
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentSettingsMainBinding;->btnPrivacyPermission Landroid/widget/LinearLayout;
    move-object/from16 v1, v16
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentSettingsMainBinding;->btnSubscribe Landroid/widget/LinearLayout;
    move-object/from16 v1, v17
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentSettingsMainBinding;->btnTheme Landroid/widget/LinearLayout;
    move-object/from16 v1, v18
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentSettingsMainBinding;->btnUpdate Landroid/widget/LinearLayout;
    move-object/from16 v1, v19
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentSettingsMainBinding;->btnUsage Landroid/widget/LinearLayout;
    move-object/from16 v1, v20
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentSettingsMainBinding;->dividerConnectors Landroid/view/View;
    move-object/from16 v1, v21
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentSettingsMainBinding;->dividerTheme Landroid/view/View;
    move-object/from16 v1, v22
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentSettingsMainBinding;->dividerUpdateAbout Landroid/view/View;
    move-object/from16 v1, v23
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentSettingsMainBinding;->groupAccountMessages Landroid/widget/LinearLayout;
    move-object/from16 v1, v24
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentSettingsMainBinding;->imgCnIdentity Landroid/widget/ImageView;
    move-object/from16 v1, v25
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentSettingsMainBinding;->ivAvatar Lcom/facebook/drawee/view/SimpleDraweeView;
    move-object/from16 v1, v26
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentSettingsMainBinding;->ivBytecloudBadge Landroid/widget/ImageView;
    move-object/from16 v1, v27
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentSettingsMainBinding;->rowPoints Landroid/widget/LinearLayout;
    move-object/from16 v1, v28
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentSettingsMainBinding;->toolbar Landroidx/appcompat/widget/Toolbar;
    move-object/from16 v1, v29
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentSettingsMainBinding;->tvCnFreeBadge Landroid/widget/TextView;
    move-object/from16 v1, v30
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentSettingsMainBinding;->tvCnTierBadge Landroid/widget/TextView;
    move-object/from16 v1, v31
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentSettingsMainBinding;->tvDebugPpeValue Landroid/widget/TextView;
    move-object/from16 v1, v32
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentSettingsMainBinding;->tvEmail Landroid/widget/TextView;
    move-object/from16 v1, v33
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentSettingsMainBinding;->tvIcpFiling Landroid/widget/TextView;
    move-object/from16 v1, v34
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentSettingsMainBinding;->tvLanguageValue Landroid/widget/TextView;
    move-object/from16 v1, v35
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentSettingsMainBinding;->tvMessageBadge Landroid/widget/TextView;
    move-object/from16 v1, v36
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentSettingsMainBinding;->tvModelFiling Landroid/widget/TextView;
    move-object/from16 v1, v37
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentSettingsMainBinding;->tvModelName Landroid/widget/TextView;
    move-object/from16 v1, v38
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentSettingsMainBinding;->tvName Landroid/widget/TextView;
    move-object/from16 v1, v39
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentSettingsMainBinding;->tvPointsBalance Landroid/widget/TextView;
    move-object/from16 v1, v40
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentSettingsMainBinding;->tvProBadge Landroid/widget/TextView;
    move-object/from16 v1, v41
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentSettingsMainBinding;->tvThemeValue Landroid/widget/TextView;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.home.databinding.FragmentSettingsMainBinding
    .registers 44
    # ins_size=1
    move-object/from16 v0, v43
    sget v1, Lcom/bytedance/trae/home/R$id;->btn_about I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v5, v2
    check-cast v5, Landroid/widget/LinearLayout;
    if-eqz v5, +1b2h
    sget v1, Lcom/bytedance/trae/home/R$id;->btn_account I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v6, v2
    check-cast v6, Landroid/widget/LinearLayout;
    if-eqz v6, +1a7h
    sget v1, Lcom/bytedance/trae/home/R$id;->btn_close I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v7, v2
    check-cast v7, Landroid/widget/FrameLayout;
    if-eqz v7, +19ch
    sget v1, Lcom/bytedance/trae/home/R$id;->btn_connectors I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v8, v2
    check-cast v8, Landroid/widget/LinearLayout;
    if-eqz v8, +191h
    sget v1, Lcom/bytedance/trae/home/R$id;->btn_debug I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v9, v2
    check-cast v9, Landroid/widget/LinearLayout;
    if-eqz v9, +186h
    sget v1, Lcom/bytedance/trae/home/R$id;->btn_device_management I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v10, v2
    check-cast v10, Landroid/widget/LinearLayout;
    if-eqz v10, +17bh
    sget v1, Lcom/bytedance/trae/home/R$id;->btn_edit_profile I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v11, v2
    check-cast v11, Landroid/widget/TextView;
    if-eqz v11, +170h
    sget v1, Lcom/bytedance/trae/home/R$id;->btn_language I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v12, v2
    check-cast v12, Landroid/widget/LinearLayout;
    if-eqz v12, +165h
    sget v1, Lcom/bytedance/trae/home/R$id;->btn_logout I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v13, v2
    check-cast v13, Landroid/widget/LinearLayout;
    if-eqz v13, +15ah
    sget v1, Lcom/bytedance/trae/home/R$id;->btn_messages I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v14, v2
    check-cast v14, Landroid/widget/LinearLayout;
    if-eqz v14, +14fh
    sget v1, Lcom/bytedance/trae/home/R$id;->btn_notification I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v15, v2
    check-cast v15, Landroid/widget/LinearLayout;
    if-eqz v15, +144h
    sget v1, Lcom/bytedance/trae/home/R$id;->btn_privacy_permission I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v16, v2
    check-cast v16, Landroid/widget/LinearLayout;
    if-eqz v16, +138h
    sget v1, Lcom/bytedance/trae/home/R$id;->btn_subscribe I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v17, v2
    check-cast v17, Landroid/widget/LinearLayout;
    if-eqz v17, +12ch
    sget v1, Lcom/bytedance/trae/home/R$id;->btn_theme I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v18, v2
    check-cast v18, Landroid/widget/LinearLayout;
    if-eqz v18, +120h
    sget v1, Lcom/bytedance/trae/home/R$id;->btn_update I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v19, v2
    check-cast v19, Landroid/widget/LinearLayout;
    if-eqz v19, +114h
    sget v1, Lcom/bytedance/trae/home/R$id;->btn_usage I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v20, v2
    check-cast v20, Landroid/widget/LinearLayout;
    if-eqz v20, +108h
    sget v1, Lcom/bytedance/trae/home/R$id;->divider_connectors I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v21
    if-eqz v21, +100h
    sget v1, Lcom/bytedance/trae/home/R$id;->divider_theme I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v22
    if-eqz v22, +0f8h
    sget v1, Lcom/bytedance/trae/home/R$id;->divider_update_about I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v23
    if-eqz v23, +0f0h
    sget v1, Lcom/bytedance/trae/home/R$id;->group_account_messages I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v24, v2
    check-cast v24, Landroid/widget/LinearLayout;
    if-eqz v24, +0e4h
    sget v1, Lcom/bytedance/trae/home/R$id;->img_cn_identity I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v25, v2
    check-cast v25, Landroid/widget/ImageView;
    if-eqz v25, +0d8h
    sget v1, Lcom/bytedance/trae/home/R$id;->iv_avatar I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v26, v2
    check-cast v26, Lcom/facebook/drawee/view/SimpleDraweeView;
    if-eqz v26, +0cch
    sget v1, Lcom/bytedance/trae/home/R$id;->iv_bytecloud_badge I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v27, v2
    check-cast v27, Landroid/widget/ImageView;
    if-eqz v27, +0c0h
    sget v1, Lcom/bytedance/trae/home/R$id;->row_points I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v28, v2
    check-cast v28, Landroid/widget/LinearLayout;
    if-eqz v28, +0b4h
    sget v1, Lcom/bytedance/trae/home/R$id;->toolbar I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v29, v2
    check-cast v29, Landroidx/appcompat/widget/Toolbar;
    if-eqz v29, +0a8h
    sget v1, Lcom/bytedance/trae/home/R$id;->tv_cn_free_badge I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v30, v2
    check-cast v30, Landroid/widget/TextView;
    if-eqz v30, +09ch
    sget v1, Lcom/bytedance/trae/home/R$id;->tv_cn_tier_badge I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v31, v2
    check-cast v31, Landroid/widget/TextView;
    if-eqz v31, +090h
    sget v1, Lcom/bytedance/trae/home/R$id;->tv_debug_ppe_value I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v32, v2
    check-cast v32, Landroid/widget/TextView;
    if-eqz v32, +084h
    sget v1, Lcom/bytedance/trae/home/R$id;->tv_email I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v33, v2
    check-cast v33, Landroid/widget/TextView;
    if-eqz v33, +078h
    sget v1, Lcom/bytedance/trae/home/R$id;->tv_icp_filing I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v34, v2
    check-cast v34, Landroid/widget/TextView;
    if-eqz v34, +06ch
    sget v1, Lcom/bytedance/trae/home/R$id;->tv_language_value I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v35, v2
    check-cast v35, Landroid/widget/TextView;
    if-eqz v35, +060h
    sget v1, Lcom/bytedance/trae/home/R$id;->tv_message_badge I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v36, v2
    check-cast v36, Landroid/widget/TextView;
    if-eqz v36, +054h
    sget v1, Lcom/bytedance/trae/home/R$id;->tv_model_filing I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v37, v2
    check-cast v37, Landroid/widget/TextView;
    if-eqz v37, +048h
    sget v1, Lcom/bytedance/trae/home/R$id;->tv_model_name I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v38, v2
    check-cast v38, Landroid/widget/TextView;
    if-eqz v38, +03ch
    sget v1, Lcom/bytedance/trae/home/R$id;->tv_name I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v39, v2
    check-cast v39, Landroid/widget/TextView;
    if-eqz v39, +030h
    sget v1, Lcom/bytedance/trae/home/R$id;->tv_points_balance I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v40, v2
    check-cast v40, Landroid/widget/TextView;
    if-eqz v40, +024h
    sget v1, Lcom/bytedance/trae/home/R$id;->tv_pro_badge I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v41, v2
    check-cast v41, Landroid/widget/TextView;
    if-eqz v41, +018h
    sget v1, Lcom/bytedance/trae/home/R$id;->tv_theme_value I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v42, v2
    check-cast v42, Landroid/widget/TextView;
    if-eqz v42, +00ch
    new-instance v1, Lcom/bytedance/trae/home/databinding/FragmentSettingsMainBinding;
    move-object v3, v1
    move-object v4, v0
    check-cast v4, Landroid/widget/LinearLayout;
    invoke-direct/range v3 ... v42, Lcom/bytedance/trae/home/databinding/FragmentSettingsMainBinding;-><init>(Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/FrameLayout; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/TextView; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/view/View; Landroid/view/View; Landroid/view/View; Landroid/widget/LinearLayout; Landroid/widget/ImageView; Lcom/facebook/drawee/view/SimpleDraweeView; Landroid/widget/ImageView; Landroid/widget/LinearLayout; Landroidx/appcompat/widget/Toolbar; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView;)V
    return-object v1
    invoke-virtual/range v43, Landroid/view/View;->getResources()Landroid/content/res/Resources;
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

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.home.databinding.FragmentSettingsMainBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/home/databinding/FragmentSettingsMainBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/home/databinding/FragmentSettingsMainBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.home.databinding.FragmentSettingsMainBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/home/R$layout;->fragment_settings_main I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/home/databinding/FragmentSettingsMainBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/home/databinding/FragmentSettingsMainBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/home/databinding/FragmentSettingsMainBinding;->getRoot()Landroid/widget/LinearLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()android.widget.LinearLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/databinding/FragmentSettingsMainBinding;->rootView Landroid/widget/LinearLayout;
    return-object v0
.end method
