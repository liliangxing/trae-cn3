# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/PrivacyPermissionFragment;
.super Landroidx/fragment/app/Fragment;
.source "PrivacyPermissionFragment.kt"

.field public static final $stable:I
.field public static final Companion:Lcom/bytedance/trae/home/solo/setting/PrivacyPermissionFragment$Companion;


.method public static synthetic $r8$lambda$-eQzSPkg4vuiaYuNA7FLiJVIubY(com.bytedance.trae.home.solo.setting.PrivacyPermissionFragment  java.lang.String)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/PrivacyPermissionFragment;->showGoSettingsDialog$lambda$3(Lcom/bytedance/trae/home/solo/setting/PrivacyPermissionFragment; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$afiUepJzVO10idZPq0ypaoWcCnc(com.bytedance.trae.home.solo.setting.PrivacyPermissionFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/PrivacyPermissionFragment;->onViewCreated$lambda$0(Lcom/bytedance/trae/home/solo/setting/PrivacyPermissionFragment; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$nR6gRhaJYrrV5-sC3g_4DuOGV-s(com.bytedance.trae.home.solo.setting.PrivacyPermissionFragment  kotlin.Pair  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/PrivacyPermissionFragment;->initSystemPermissionSection$lambda$2$lambda$1(Lcom/bytedance/trae/home/solo/setting/PrivacyPermissionFragment; Lkotlin/Pair; Landroid/view/View;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/PrivacyPermissionFragment$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/PrivacyPermissionFragment$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/PrivacyPermissionFragment;->Companion Lcom/bytedance/trae/home/solo/setting/PrivacyPermissionFragment$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Landroidx/fragment/app/Fragment;-><init>()V
    return-void 
.end method

.method private final goToSystemSettings()void
    .registers 5
    # ins_size=1
    new-instance v0, Landroid/content/Intent;
    const-string v1, "android.settings.APPLICATION_DETAILS_SETTINGS"
    invoke-direct v0, v1, Landroid/content/Intent;-><init>(Ljava/lang/String;)V
    const-string v1, "package"
    sget-object v2, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v2, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v2
    invoke-virtual v2, Landroid/app/Application;->getPackageName()Ljava/lang/String;
    move-result-object v2
    const/4 v3, 0
    invoke-static v1, v2, v3, Landroid/net/Uri;->fromParts(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v1
    invoke-virtual v0, v1, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;
    invoke-virtual v4, v0, Lcom/bytedance/trae/home/solo/setting/PrivacyPermissionFragment;->startActivity(Landroid/content/Intent;)V
    return-void 
    :try_start_0x0
.end method

.method private final initSystemPermissionSection(android.view.View)void
    .registers 7
    # ins_size=2
    const/4 v0, 5
    new-array v0, v0, [Lkotlin/Pair;
    sget v1, Lcom/bytedance/trae/home/R$id;->btn_push I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v2, Lkotlin/Pair;
    sget v3, Lcom/bytedance/trae/home/R$string;->trae_setting_privacy_dialog_title_push I
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v3
    sget v4, Lcom/bytedance/trae/home/R$string;->trae_setting_privacy_dialog_desc_push I
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    invoke-direct v2, v3, v4, Lkotlin/Pair;-><init>(Ljava/lang/Object; Ljava/lang/Object;)V
    invoke-static v1, v2, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/4 v2, 0
    aput-object v1, v0, v2
    sget v1, Lcom/bytedance/trae/home/R$id;->btn_camera_photo I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v2, Lkotlin/Pair;
    sget v3, Lcom/bytedance/trae/home/R$string;->trae_setting_privacy_dialog_title_camera_photo I
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v3
    sget v4, Lcom/bytedance/trae/home/R$string;->trae_setting_privacy_dialog_desc_camera_photo I
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    invoke-direct v2, v3, v4, Lkotlin/Pair;-><init>(Ljava/lang/Object; Ljava/lang/Object;)V
    invoke-static v1, v2, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/4 v2, 1
    aput-object v1, v0, v2
    sget v1, Lcom/bytedance/trae/home/R$id;->btn_photo I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v2, Lkotlin/Pair;
    sget v3, Lcom/bytedance/trae/home/R$string;->trae_setting_privacy_dialog_title_photo I
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v3
    sget v4, Lcom/bytedance/trae/home/R$string;->trae_setting_privacy_dialog_desc_photo I
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    invoke-direct v2, v3, v4, Lkotlin/Pair;-><init>(Ljava/lang/Object; Ljava/lang/Object;)V
    invoke-static v1, v2, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/4 v2, 2
    aput-object v1, v0, v2
    sget v1, Lcom/bytedance/trae/home/R$id;->btn_recording I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v2, Lkotlin/Pair;
    sget v3, Lcom/bytedance/trae/home/R$string;->trae_setting_privacy_dialog_title_recording I
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v3
    sget v4, Lcom/bytedance/trae/home/R$string;->trae_setting_privacy_dialog_desc_recording I
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    invoke-direct v2, v3, v4, Lkotlin/Pair;-><init>(Ljava/lang/Object; Ljava/lang/Object;)V
    invoke-static v1, v2, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/4 v2, 3
    aput-object v1, v0, v2
    sget v1, Lcom/bytedance/trae/home/R$id;->btn_file_access I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    new-instance v2, Lkotlin/Pair;
    sget v3, Lcom/bytedance/trae/home/R$string;->trae_setting_privacy_dialog_title_file_access I
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v3
    sget v4, Lcom/bytedance/trae/home/R$string;->trae_setting_privacy_dialog_desc_file_access I
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    invoke-direct v2, v3, v4, Lkotlin/Pair;-><init>(Ljava/lang/Object; Ljava/lang/Object;)V
    invoke-static v1, v2, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/4 v2, 4
    aput-object v1, v0, v2
    invoke-static v0, Lkotlin/collections/MapsKt;->mapOf([Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v0
    invoke-interface v0, Ljava/util/Map;->entrySet()Ljava/util/Set;
    move-result-object v0
    invoke-interface v0, Ljava/util/Set;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +027h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/util/Map$Entry;
    invoke-interface v1, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/Number;
    invoke-virtual v2, Ljava/lang/Number;->intValue()I
    move-result v2
    invoke-interface v1, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lkotlin/Pair;
    invoke-virtual v6, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    check-cast v2, Landroid/widget/LinearLayout;
    new-instance v3, Lcom/bytedance/trae/home/solo/setting/PrivacyPermissionFragment$$ExternalSyntheticLambda2;
    invoke-direct v3, v5, v1, Lcom/bytedance/trae/home/solo/setting/PrivacyPermissionFragment$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/home/solo/setting/PrivacyPermissionFragment; Lkotlin/Pair;)V
    invoke-virtual v2, v3, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    goto -2ah
    return-void 
.end method

.method private static final initSystemPermissionSection$lambda$2$lambda$1(com.bytedance.trae.home.solo.setting.PrivacyPermissionFragment  kotlin.Pair  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-virtual v1, Lkotlin/Pair;->getFirst()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/Number;
    invoke-virtual v2, Ljava/lang/Number;->intValue()I
    move-result v2
    invoke-virtual v1, Lkotlin/Pair;->getSecond()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/Number;
    invoke-virtual v1, Ljava/lang/Number;->intValue()I
    move-result v1
    invoke-direct v0, v2, v1, Lcom/bytedance/trae/home/solo/setting/PrivacyPermissionFragment;->showGoSettingsDialog(I I)V
    return-void 
.end method

.method private static final onViewCreated$lambda$0(com.bytedance.trae.home.solo.setting.PrivacyPermissionFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/PrivacyPermissionFragment;->getParentFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    invoke-virtual v0, Landroidx/fragment/app/FragmentManager;->popBackStack()V
    return-void 
.end method

.method private final showGoSettingsDialog(int  int)void
    .registers 31
    # ins_size=3
    move-object/from16 v0, v28
    invoke-virtual/range v28, Lcom/bytedance/trae/home/solo/setting/PrivacyPermissionFragment;->getContext()Landroid/content/Context;
    move-result-object v1
    if-nez v1, +003h
    return-void 
    new-instance v2, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;
    new-instance v15, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;
    move-object v3, v15
    invoke-virtual/range v28 ... v29, Lcom/bytedance/trae/home/solo/setting/PrivacyPermissionFragment;->getString(I)Ljava/lang/String;
    move-result-object v5
    move-object v4, v5
    const-string v10, "getString(...)"
    invoke-static v5, v10, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move/from16 v5, v30
    invoke-virtual v0, v5, Lcom/bytedance/trae/home/solo/setting/PrivacyPermissionFragment;->getString(I)Ljava/lang/String;
    move-result-object v5
    const/4 v6, 0
    const/4 v7, 0
    sget v8, Lcom/bytedance/trae/home/R$string;->trae_setting_privacy_dialog_btn_cancel I
    invoke-virtual v0, v8, Lcom/bytedance/trae/home/solo/setting/PrivacyPermissionFragment;->getString(I)Ljava/lang/String;
    move-result-object v9
    move-object v8, v9
    invoke-static v9, v10, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v9, Lcom/bytedance/trae/home/R$string;->trae_setting_privacy_dialog_btn_confirm I
    invoke-virtual v0, v9, Lcom/bytedance/trae/home/solo/setting/PrivacyPermissionFragment;->getString(I)Ljava/lang/String;
    move-result-object v11
    move-object v9, v11
    invoke-static v11, v10, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/16 v16, 0
    move-object/from16 v27, v15
    move-object/from16 v15, v16
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const/16 v22, 0
    new-instance v6, Lcom/bytedance/trae/home/solo/setting/PrivacyPermissionFragment$$ExternalSyntheticLambda1;
    move-object/from16 v23, v6
    invoke-direct v6, v0, Lcom/bytedance/trae/home/solo/setting/PrivacyPermissionFragment$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/home/solo/setting/PrivacyPermissionFragment;)V
    const/16 v24, 0
    const v25, 1572812
    const/16 v26, 0
    const/4 v6, 0
    invoke-direct/range v3 ... v26, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; F Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; I I I Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Z Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object/from16 v3, v27
    invoke-direct v2, v1, v3, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;-><init>(Landroid/content/Context; Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Config;)V
    invoke-virtual v2, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->show()V
    return-void 
.end method

.method private static final showGoSettingsDialog$lambda$3(com.bytedance.trae.home.solo.setting.PrivacyPermissionFragment  java.lang.String)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/PrivacyPermissionFragment;->goToSystemSettings()V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method public onCreateView(android.view.LayoutInflater  android.view.ViewGroup  android.os.Bundle)android.view.View
    .registers 5
    # ins_size=4
    const-string v4, "inflater"
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget v4, Lcom/bytedance/trae/home/R$layout;->fragment_privacy_permission I
    const/4 v0, 0
    invoke-virtual v2, v4, v3, v0, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    return-object v2
.end method

.method public onViewCreated(android.view.View  android.os.Bundle)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, view
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v1, v2, v3, Landroidx/fragment/app/Fragment;->onViewCreated(Landroid/view/View; Landroid/os/Bundle;)V
    sget v3, Lcom/bytedance/trae/home/R$id;->title_bar I
    invoke-virtual v2, v3, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/PrivacyPermissionFragment$$ExternalSyntheticLambda0;
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/PrivacyPermissionFragment$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/home/solo/setting/PrivacyPermissionFragment;)V
    invoke-virtual v3, v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setOnLeftActionClickListener(Landroid/view/View$OnClickListener;)V
    invoke-direct v1, v2, Lcom/bytedance/trae/home/solo/setting/PrivacyPermissionFragment;->initSystemPermissionSection(Landroid/view/View;)V
    return-void 
.end method
