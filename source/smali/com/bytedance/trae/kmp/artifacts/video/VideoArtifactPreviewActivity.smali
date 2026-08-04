# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;
.super Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;
.source "VideoArtifactPreviewActivity.kt"

.field public static final $stable:I
.field public static final Companion:Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$Companion;
.field private static final EXTRA_OPEN_REQUEST:Ljava/lang/String;
.field private static final json:Lkotlinx/serialization/json/Json;
.field private isSaving:Z
.field private previewViewModel:Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;
.field private titleBar:Lcom/bytedance/trae/common/widget/TraeTitleBar;


.method public static synthetic $r8$lambda$-JD1-tJStN_eetK_Mzffsi1WSIM(com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewActivity  com.bytedance.trae.kmp.host.KmpMediaLibrarySaveResult)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;->saveVideo$lambda$9(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity; Lcom/bytedance/trae/kmp/host/KmpMediaLibrarySaveResult;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$-tc9VwOHTEeEJ-dsM2TM-VXY8PY(com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;->onCreate$lambda$5$lambda$3(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$E4FyGMGEJY6Luh-R9QARiyHt5HU(com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewActivity  androidx.activity.OnBackPressedCallback)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;->onCreate$lambda$7(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity; Landroidx/activity/OnBackPressedCallback;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$YkEZnh--lkW2x2bXG4QarjTHu0g(kotlinx.serialization.json.JsonBuilder)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;->json$lambda$10(Lkotlinx/serialization/json/JsonBuilder;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$hHJ1J6oYlHReGDrWjrbaSXdnFJc(com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewActivity  com.bytedance.trae.kmp.host.KmpMediaLibrarySaveResult)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;->saveVideo$lambda$9$lambda$8(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity; Lcom/bytedance/trae/kmp/host/KmpMediaLibrarySaveResult;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$jBESLnaUfvmXYvlvyEjlLU3rk9Q(com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;->onCreate$lambda$5$lambda$4(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity; Landroid/view/View;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;->Companion Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$Companion;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;->$stable I
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$$ExternalSyntheticLambda4;
    invoke-direct v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$$ExternalSyntheticLambda4;-><init>()V
    const/4 v2, 1
    invoke-static v1, v0, v2, v1, Lkotlinx/serialization/json/JsonKt;->Json$default(Lkotlinx/serialization/json/Json; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Lkotlinx/serialization/json/Json;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;->json Lkotlinx/serialization/json/Json;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;-><init>()V
    return-void 
.end method

.method public static final synthetic access$closePreview(com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewActivity)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;->closePreview()V
    return-void 
.end method

.method public static final synthetic access$getJson$cp()kotlinx.serialization.json.Json
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;->json Lkotlinx/serialization/json/Json;
    return-object v0
.end method

.method public static final synthetic access$getPreviewViewModel$p(com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewActivity)com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewViewModel
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;->previewViewModel Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;
    return-object v0
.end method

.method private final closePreview()void
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;->previewViewModel Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;
    if-nez v0, +009h
    const-string/jumbo v0, previewViewModel
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    invoke-virtual v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->close()V
    invoke-virtual v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;->finish()V
    return-void 
.end method

.method public static com_bytedance_trae_kmp_artifacts_video_VideoArtifactPreviewActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewActivity)void
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;->com_bytedance_trae_kmp_artifacts_video_VideoArtifactPreviewActivity__onStop$___twin___()V
    invoke-static Lcom/bytedance/sysoptimizer/EnterTransitionCrashOptimizer;->getContext()Landroid/content/Context;
    move-result-object v0
    if-eqz v0, +013h
    check-cast v1, Landroid/app/Activity;
    invoke-virtual v1, Landroid/app/Activity;->getWindow()Landroid/view/Window;
    move-result-object v1
    invoke-virtual v1, Landroid/view/Window;->getDecorView()Landroid/view/View;
    move-result-object v1
    invoke-virtual v1, Landroid/view/View;->getViewTreeObserver()Landroid/view/ViewTreeObserver;
    move-result-object v1
    invoke-virtual v1, Landroid/view/ViewTreeObserver;->dispatchOnPreDraw()Z
    return-void 
    :try_start_0xb
.end method

.method private static final json$lambda$10(kotlinx.serialization.json.JsonBuilder)kotlin.Unit
    .registers 2
    # ins_size=1
    const-string v0, "$this$Json"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 1
    invoke-virtual v1, v0, Lkotlinx/serialization/json/JsonBuilder;->setIgnoreUnknownKeys(Z)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final onCreate$lambda$5$lambda$3(com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;->closePreview()V
    return-void 
.end method

.method private static final onCreate$lambda$5$lambda$4(com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;->saveVideo()V
    return-void 
.end method

.method private static final onCreate$lambda$7(com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewActivity  androidx.activity.OnBackPressedCallback)kotlin.Unit
    .registers 3
    # ins_size=2
    const-string v0, "$this$addCallback"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;->closePreview()V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private final saveVideo()void
    .registers 4
    # ins_size=1
    iget-boolean v0, v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;->isSaving Z
    if-eqz v0, +003h
    return-void 
    const/4 v0, 1
    iput-boolean v0, v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;->isSaving Z
    iget-object v0, v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    const/4 v1, 0
    if-nez v0, +009h
    const-string/jumbo v0, titleBar
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    const/4 v2, 0
    invoke-virtual v0, v2, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setRightActionEnabled(I Z)V
    iget-object v0, v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;->previewViewModel Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;
    if-nez v0, +009h
    const-string/jumbo v0, previewViewModel
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$$ExternalSyntheticLambda5;
    invoke-direct v0, v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$$ExternalSyntheticLambda5;-><init>(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;)V
    invoke-virtual v1, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->saveToMediaLibrary(Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method

.method private static final saveVideo$lambda$9(com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewActivity  com.bytedance.trae.kmp.host.KmpMediaLibrarySaveResult)kotlin.Unit
    .registers 3
    # ins_size=2
    const-string/jumbo v0, result
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$$ExternalSyntheticLambda0;
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity; Lcom/bytedance/trae/kmp/host/KmpMediaLibrarySaveResult;)V
    invoke-virtual v1, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;->runOnUiThread(Ljava/lang/Runnable;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final saveVideo$lambda$9$lambda$8(com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewActivity  com.bytedance.trae.kmp.host.KmpMediaLibrarySaveResult)void
    .registers 5
    # ins_size=2
    const/4 v0, 0
    iput-boolean v0, v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;->isSaving Z
    iget-object v1, v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    if-nez v1, +009h
    const-string/jumbo v1, titleBar
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v1, 0
    const/4 v2, 1
    invoke-virtual v1, v0, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setRightActionEnabled(I Z)V
    invoke-virtual v4, Lcom/bytedance/trae/kmp/host/KmpMediaLibrarySaveResult;->isSuccess()Z
    move-result v4
    if-eqz v4, +009h
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->trae_doc_preview_download_success I
    invoke-virtual v3, v4, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;->getString(I)Ljava/lang/String;
    move-result-object v4
    goto +7h
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->trae_doc_preview_download_failed I
    invoke-virtual v3, v4, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;->getString(I)Ljava/lang/String;
    move-result-object v4
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    check-cast v3, Landroid/content/Context;
    invoke-static v3, v4, Lcom/bytedance/trae/common/widget/CustomToast;->showShort(Landroid/content/Context; Ljava/lang/String;)V
    return-void 
.end method

.method public com_bytedance_trae_kmp_artifacts_video_VideoArtifactPreviewActivity__onStop$___twin___()void
    .registers 1
    # ins_size=1
    invoke-super v0, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onStop()V
    return-void 
.end method

.method public getDecorViewBackgroundColor()int
    .registers 2
    # ins_size=1
    sget v0, Lcom/bytedance/trae/common_ui/R$color;->trae_special_black I
    invoke-virtual v1, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;->getColor(I)I
    move-result v0
    return v0
.end method

.method public isLightStatusBar()boolean
    .registers 2
    # ins_size=1
    const/4 v0, 0
    return v0
.end method

.method protected onCreate(android.os.Bundle)void
    .registers 9
    # ins_size=2
    invoke-super v7, v8, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onCreate(Landroid/os/Bundle;)V
    invoke-virtual v7, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;->getIntent()Landroid/content/Intent;
    move-result-object v8
    const-string/jumbo v0, video_artifact_open_request
    invoke-virtual v8, v0, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v8
    if-eqz v8, +0b5h
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v7
    check-cast v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;
    sget-object v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;->json Lkotlinx/serialization/json/Json;
    invoke-virtual v0, Lkotlinx/serialization/json/Json;->getSerializersModule()Lkotlinx/serialization/modules/SerializersModule;
    sget-object v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->Companion Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest$Companion;->serializer()Lkotlinx/serialization/KSerializer;
    move-result-object v1
    check-cast v1, Lkotlinx/serialization/DeserializationStrategy;
    invoke-virtual v0, v1, v8, Lkotlinx/serialization/json/Json;->decodeFromString(Lkotlinx/serialization/DeserializationStrategy; Ljava/lang/String;)Ljava/lang/Object;
    move-result-object v8
    check-cast v8, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;
    invoke-static v8, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v8
    goto +ch
    move-exception v8
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v8, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v8
    invoke-static v8, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v8
    invoke-static v8, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    const/4 v8, 0
    check-cast v8, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;
    if-eqz v8, +082h
    new-instance v0, Landroidx/lifecycle/ViewModelProvider;
    move-object v1, v7
    check-cast v1, Landroidx/lifecycle/ViewModelStoreOwner;
    new-instance v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$VideoArtifactPreviewViewModelFactory;
    invoke-direct v2, v7, v8, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$VideoArtifactPreviewViewModelFactory;-><init>(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity; Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;)V
    check-cast v2, Landroidx/lifecycle/ViewModelProvider$Factory;
    invoke-direct v0, v1, v2, Landroidx/lifecycle/ViewModelProvider;-><init>(Landroidx/lifecycle/ViewModelStoreOwner; Landroidx/lifecycle/ViewModelProvider$Factory;)V
    const-class v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;
    invoke-virtual v0, v1, Landroidx/lifecycle/ViewModelProvider;->get(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;
    iput-object v0, v7, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;->previewViewModel Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;
    sget v0, Lcom/bytedance/trae/kmp/artifacts/R$layout;->activity_video_artifact_preview I
    invoke-virtual v7, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;->setContentView(I)V
    sget v0, Lcom/bytedance/trae/kmp/artifacts/R$id;->video_artifact_preview_title_bar I
    invoke-virtual v7, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;
    invoke-virtual v8, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->getTitle()Ljava/lang/String;
    move-result-object v8
    check-cast v8, Ljava/lang/CharSequence;
    invoke-virtual v1, v8, Lcom/bytedance/trae/common/widget/TraeTitleBar;->showMediaPreviewHeader(Ljava/lang/CharSequence;)V
    new-instance v8, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$$ExternalSyntheticLambda1;
    invoke-direct v8, v7, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;)V
    invoke-virtual v1, v8, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setOnLeftActionClickListener(Landroid/view/View$OnClickListener;)V
    new-instance v8, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$$ExternalSyntheticLambda2;
    invoke-direct v8, v7, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;)V
    invoke-virtual v1, v8, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setOnRightActionClickListener(Landroid/view/View$OnClickListener;)V
    const-string v8, "apply(...)"
    invoke-static v0, v8, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v1, v7, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    sget v8, Lcom/bytedance/trae/kmp/artifacts/R$id;->video_artifact_preview_content I
    invoke-virtual v7, v8, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v8
    check-cast v8, Landroidx/compose/ui/platform/ComposeView;
    sget-object v0, Landroidx/compose/ui/platform/ViewCompositionStrategy$DisposeOnViewTreeLifecycleDestroyed;->INSTANCE Landroidx/compose/ui/platform/ViewCompositionStrategy$DisposeOnViewTreeLifecycleDestroyed;
    check-cast v0, Landroidx/compose/ui/platform/ViewCompositionStrategy;
    invoke-virtual v8, v0, Landroidx/compose/ui/platform/ComposeView;->setViewCompositionStrategy(Landroidx/compose/ui/platform/ViewCompositionStrategy;)V
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$onCreate$2$1;
    invoke-direct v0, v7, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$onCreate$2$1;-><init>(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;)V
    const v1, -339933407
    const/4 v2, 1
    invoke-static v1, v2, v0, Landroidx/compose/runtime/internal/ComposableLambdaKt;->composableLambdaInstance(I Z Ljava/lang/Object;)Landroidx/compose/runtime/internal/ComposableLambda;
    move-result-object v0
    check-cast v0, Lkotlin/jvm/functions/Function2;
    invoke-virtual v8, v0, Landroidx/compose/ui/platform/ComposeView;->setContent(Lkotlin/jvm/functions/Function2;)V
    invoke-virtual v7, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;->getOnBackPressedDispatcher()Landroidx/activity/OnBackPressedDispatcher;
    move-result-object v1
    const-string v8, "<get-onBackPressedDispatcher>(...)"
    invoke-static v1, v8, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v2, v7
    check-cast v2, Landroidx/lifecycle/LifecycleOwner;
    const/4 v3, 0
    new-instance v4, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$$ExternalSyntheticLambda3;
    invoke-direct v4, v7, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;)V
    const/4 v5, 2
    const/4 v6, 0
    invoke-static/range v1 ... v6, Landroidx/activity/OnBackPressedDispatcherKt;->addCallback$default(Landroidx/activity/OnBackPressedDispatcher; Landroidx/lifecycle/LifecycleOwner; Z Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Landroidx/activity/OnBackPressedCallback;
    return-void 
    move-object v8, v7
    check-cast v8, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;
    invoke-virtual v7, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;->finish()V
    return-void 
    :try_start_0x10
.end method

.method protected onStop()void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;->com_bytedance_trae_kmp_artifacts_video_VideoArtifactPreviewActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;)V
    return-void 
.end method
