# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/BusinessLicenseFragment;
.super Landroidx/fragment/app/Fragment;
.source "BusinessLicenseFragment.kt"

.field public static final $stable:I
.field public static final Companion:Lcom/bytedance/trae/home/solo/setting/BusinessLicenseFragment$Companion;


.method public static synthetic $r8$lambda$78DSH0IIfA_5LJuGXaakWMSHpIo(com.bytedance.trae.home.solo.setting.BusinessLicenseFragment)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/home/solo/setting/BusinessLicenseFragment;->onViewCreated$lambda$1$lambda$0(Lcom/bytedance/trae/home/solo/setting/BusinessLicenseFragment;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$HckNo_oam96Rja76EyaAWtdfgXE(com.bytedance.trae.home.solo.setting.BusinessLicenseFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/BusinessLicenseFragment;->onViewCreated$lambda$1(Lcom/bytedance/trae/home/solo/setting/BusinessLicenseFragment; Landroid/view/View;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/BusinessLicenseFragment$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/BusinessLicenseFragment$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/BusinessLicenseFragment;->Companion Lcom/bytedance/trae/home/solo/setting/BusinessLicenseFragment$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Landroidx/fragment/app/Fragment;-><init>()V
    return-void 
.end method

.method private static final onViewCreated$lambda$1(com.bytedance.trae.home.solo.setting.BusinessLicenseFragment  android.view.View)void
    .registers 5
    # ins_size=2
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/BusinessLicenseFragment$$ExternalSyntheticLambda0;
    invoke-direct v0, v3, Lcom/bytedance/trae/home/solo/setting/BusinessLicenseFragment$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/home/solo/setting/BusinessLicenseFragment;)V
    const-wide/16 v1, 150
    invoke-virtual v4, v0, v1, v2, Landroid/view/View;->postDelayed(Ljava/lang/Runnable; J)Z
    return-void 
.end method

.method private static final onViewCreated$lambda$1$lambda$0(com.bytedance.trae.home.solo.setting.BusinessLicenseFragment)void
    .registers 1
    # ins_size=1
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/BusinessLicenseFragment;->getParentFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v0
    invoke-virtual v0, Landroidx/fragment/app/FragmentManager;->popBackStack()V
    return-void 
.end method

.method public onCreateView(android.view.LayoutInflater  android.view.ViewGroup  android.os.Bundle)android.view.View
    .registers 5
    # ins_size=4
    const-string v4, "inflater"
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget v4, Lcom/bytedance/trae/home/R$layout;->fragment_business_license I
    const/4 v0, 0
    invoke-virtual v2, v4, v3, v0, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    return-object v2
.end method

.method public onViewCreated(android.view.View  android.os.Bundle)void
    .registers 6
    # ins_size=3
    const-string/jumbo v0, view
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v3, v4, v5, Landroidx/fragment/app/Fragment;->onViewCreated(Landroid/view/View; Landroid/os/Bundle;)V
    sget v5, Lcom/bytedance/trae/home/R$id;->title_bar I
    invoke-virtual v4, v5, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/common/widget/TraeTitleBar;
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/BusinessLicenseFragment$$ExternalSyntheticLambda1;
    invoke-direct v0, v3, Lcom/bytedance/trae/home/solo/setting/BusinessLicenseFragment$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/home/solo/setting/BusinessLicenseFragment;)V
    invoke-virtual v5, v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setOnLeftActionClickListener(Landroid/view/View$OnClickListener;)V
    sget v5, Lcom/bytedance/trae/home/R$id;->iv_license I
    invoke-virtual v4, v5, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v4
    check-cast v4, Landroid/widget/ImageView;
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/BusinessLicenseFragment;->getResources()Landroid/content/res/Resources;
    move-result-object v5
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/BusinessLicenseFragment;->requireContext()Landroid/content/Context;
    move-result-object v0
    invoke-virtual v0, Landroid/content/Context;->getPackageName()Ljava/lang/String;
    move-result-object v0
    const-string v1, "ic_business_license"
    const-string v2, "drawable"
    invoke-virtual v5, v1, v2, v0, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)I
    move-result v5
    if-eqz v5, +005h
    invoke-virtual v4, v5, Landroid/widget/ImageView;->setImageResource(I)V
    return-void 
.end method
