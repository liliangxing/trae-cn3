# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/CmpAccountSettingsBottomSheet;
.super Lcom/bytedance/trae/kmp/cmp/TraeCmpBottomSheetFragment;
.source "CmpAccountSettingsBottomSheet.kt"

.field public static final $stable:I
.field public static final Companion:Lcom/bytedance/trae/home/solo/setting/CmpAccountSettingsBottomSheet$Companion;
.field public static final TAG:Ljava/lang/String;
.field private final fragmentContainerId:I
.field private final navigator$delegate:Lkotlin/Lazy;


.method public static synthetic $r8$lambda$9iMkNj52rD4MvJBI0z_2yfwBpyg(com.bytedance.trae.home.solo.setting.CmpAccountSettingsBottomSheet)com.bytedance.trae.home.solo.setting.CmpSettingsNavigator
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/home/solo/setting/CmpAccountSettingsBottomSheet;->navigator_delegate$lambda$0(Lcom/bytedance/trae/home/solo/setting/CmpAccountSettingsBottomSheet;)Lcom/bytedance/trae/home/solo/setting/CmpSettingsNavigator;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/CmpAccountSettingsBottomSheet$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/CmpAccountSettingsBottomSheet$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/CmpAccountSettingsBottomSheet;->Companion Lcom/bytedance/trae/home/solo/setting/CmpAccountSettingsBottomSheet$Companion;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/home/solo/setting/CmpAccountSettingsBottomSheet;->$stable I
    return-void 
.end method

.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/kmp/cmp/TraeCmpBottomSheetFragment;-><init>()V
    sget v0, Lcom/bytedance/trae/home/R$id;->settings_fragment_container I
    iput v0, v1, Lcom/bytedance/trae/home/solo/setting/CmpAccountSettingsBottomSheet;->fragmentContainerId I
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/CmpAccountSettingsBottomSheet$$ExternalSyntheticLambda0;
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/CmpAccountSettingsBottomSheet$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/home/solo/setting/CmpAccountSettingsBottomSheet;)V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    iput-object v0, v1, Lcom/bytedance/trae/home/solo/setting/CmpAccountSettingsBottomSheet;->navigator$delegate Lkotlin/Lazy;
    return-void 
.end method

.method private static final navigator_delegate$lambda$0(com.bytedance.trae.home.solo.setting.CmpAccountSettingsBottomSheet)com.bytedance.trae.home.solo.setting.CmpSettingsNavigator
    .registers 3
    # ins_size=1
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/CmpSettingsNavigator;
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/CmpAccountSettingsBottomSheet;->getChildFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v2
    const-string v1, "getChildFragmentManager(...)"
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v0, v2, Lcom/bytedance/trae/home/solo/setting/CmpSettingsNavigator;-><init>(Landroidx/fragment/app/FragmentManager;)V
    return-object v0
.end method

.method protected createRootFragment()androidx.fragment.app.Fragment
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;->Companion Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment$Companion;->newInstance()Lcom/bytedance/trae/home/solo/setting/fragment/CmpSettingsEntryFragment;
    move-result-object v0
    check-cast v0, Landroidx/fragment/app/Fragment;
    return-object v0
.end method

.method protected getFragmentContainerId()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/home/solo/setting/CmpAccountSettingsBottomSheet;->fragmentContainerId I
    return v0
.end method

.method public final getNavigator()com.bytedance.trae.home.solo.setting.CmpSettingsNavigator
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/CmpAccountSettingsBottomSheet;->navigator$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/home/solo/setting/CmpSettingsNavigator;
    return-object v0
.end method

.method protected onBackPressed()boolean
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/CmpAccountSettingsBottomSheet;->getNavigator()Lcom/bytedance/trae/home/solo/setting/CmpSettingsNavigator;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/CmpSettingsNavigator;->pop()Z
    move-result v0
    return v0
.end method
