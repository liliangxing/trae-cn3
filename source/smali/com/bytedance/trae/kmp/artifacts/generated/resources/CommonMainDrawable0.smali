# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/kmp/artifacts/generated/resources/CommonMainDrawable0;
.super Ljava/lang/Object;
.source "Drawable0.commonMain.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/kmp/artifacts/generated/resources/CommonMainDrawable0;
.field private static final trae_artifact_preview_error$delegate:Lkotlin/Lazy;
.field private static final trae_video_preview_checkmark$delegate:Lkotlin/Lazy;
.field private static final trae_video_preview_error$delegate:Lkotlin/Lazy;
.field private static final trae_video_preview_pause$delegate:Lkotlin/Lazy;
.field private static final trae_video_preview_play$delegate:Lkotlin/Lazy;


.method public static synthetic $r8$lambda$K2VL8f62otAIWQ1TCS4GCX2KT_0()org.jetbrains.compose.resources.DrawableResource
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/kmp/artifacts/generated/resources/CommonMainDrawable0;->trae_video_preview_pause_delegate$lambda$3()Lorg/jetbrains/compose/resources/DrawableResource;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$Puu5bogNxbZsE3qNw4SlLCSCWbU()org.jetbrains.compose.resources.DrawableResource
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/kmp/artifacts/generated/resources/CommonMainDrawable0;->trae_video_preview_checkmark_delegate$lambda$1()Lorg/jetbrains/compose/resources/DrawableResource;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$hKkpXvgOf-YPvJymHZZtIgSng3Y()org.jetbrains.compose.resources.DrawableResource
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/kmp/artifacts/generated/resources/CommonMainDrawable0;->trae_video_preview_error_delegate$lambda$2()Lorg/jetbrains/compose/resources/DrawableResource;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$kb30ViJSkCpzLsUw-Vhx4ynE5oM()org.jetbrains.compose.resources.DrawableResource
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/kmp/artifacts/generated/resources/CommonMainDrawable0;->trae_artifact_preview_error_delegate$lambda$0()Lorg/jetbrains/compose/resources/DrawableResource;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$kqGN2W9F8AQ1xYoZ6pJ6Ewc9WPE()org.jetbrains.compose.resources.DrawableResource
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/kmp/artifacts/generated/resources/CommonMainDrawable0;->trae_video_preview_play_delegate$lambda$4()Lorg/jetbrains/compose/resources/DrawableResource;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/generated/resources/CommonMainDrawable0;
    invoke-direct v0, Lcom/bytedance/trae/kmp/artifacts/generated/resources/CommonMainDrawable0;-><init>()V
    sput-object v0, Lcom/bytedance/trae/kmp/artifacts/generated/resources/CommonMainDrawable0;->INSTANCE Lcom/bytedance/trae/kmp/artifacts/generated/resources/CommonMainDrawable0;
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/generated/resources/CommonMainDrawable0$$ExternalSyntheticLambda0;
    invoke-direct v0, Lcom/bytedance/trae/kmp/artifacts/generated/resources/CommonMainDrawable0$$ExternalSyntheticLambda0;-><init>()V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/kmp/artifacts/generated/resources/CommonMainDrawable0;->trae_artifact_preview_error$delegate Lkotlin/Lazy;
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/generated/resources/CommonMainDrawable0$$ExternalSyntheticLambda1;
    invoke-direct v0, Lcom/bytedance/trae/kmp/artifacts/generated/resources/CommonMainDrawable0$$ExternalSyntheticLambda1;-><init>()V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/kmp/artifacts/generated/resources/CommonMainDrawable0;->trae_video_preview_checkmark$delegate Lkotlin/Lazy;
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/generated/resources/CommonMainDrawable0$$ExternalSyntheticLambda2;
    invoke-direct v0, Lcom/bytedance/trae/kmp/artifacts/generated/resources/CommonMainDrawable0$$ExternalSyntheticLambda2;-><init>()V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/kmp/artifacts/generated/resources/CommonMainDrawable0;->trae_video_preview_error$delegate Lkotlin/Lazy;
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/generated/resources/CommonMainDrawable0$$ExternalSyntheticLambda3;
    invoke-direct v0, Lcom/bytedance/trae/kmp/artifacts/generated/resources/CommonMainDrawable0$$ExternalSyntheticLambda3;-><init>()V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/kmp/artifacts/generated/resources/CommonMainDrawable0;->trae_video_preview_pause$delegate Lkotlin/Lazy;
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/generated/resources/CommonMainDrawable0$$ExternalSyntheticLambda4;
    invoke-direct v0, Lcom/bytedance/trae/kmp/artifacts/generated/resources/CommonMainDrawable0$$ExternalSyntheticLambda4;-><init>()V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/kmp/artifacts/generated/resources/CommonMainDrawable0;->trae_video_preview_play$delegate Lkotlin/Lazy;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private static final trae_artifact_preview_error_delegate$lambda$0()org.jetbrains.compose.resources.DrawableResource
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/kmp/artifacts/generated/resources/DrawableInCommonMain0_androidMainKt;->__res_init_trae_artifact_preview_error()Lorg/jetbrains/compose/resources/DrawableResource;
    move-result-object v0
    return-object v0
.end method

.method private static final trae_video_preview_checkmark_delegate$lambda$1()org.jetbrains.compose.resources.DrawableResource
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/kmp/artifacts/generated/resources/DrawableInCommonMain0_androidMainKt;->__res_init_trae_video_preview_checkmark()Lorg/jetbrains/compose/resources/DrawableResource;
    move-result-object v0
    return-object v0
.end method

.method private static final trae_video_preview_error_delegate$lambda$2()org.jetbrains.compose.resources.DrawableResource
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/kmp/artifacts/generated/resources/DrawableInCommonMain0_androidMainKt;->__res_init_trae_video_preview_error()Lorg/jetbrains/compose/resources/DrawableResource;
    move-result-object v0
    return-object v0
.end method

.method private static final trae_video_preview_pause_delegate$lambda$3()org.jetbrains.compose.resources.DrawableResource
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/kmp/artifacts/generated/resources/DrawableInCommonMain0_androidMainKt;->__res_init_trae_video_preview_pause()Lorg/jetbrains/compose/resources/DrawableResource;
    move-result-object v0
    return-object v0
.end method

.method private static final trae_video_preview_play_delegate$lambda$4()org.jetbrains.compose.resources.DrawableResource
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/kmp/artifacts/generated/resources/DrawableInCommonMain0_androidMainKt;->__res_init_trae_video_preview_play()Lorg/jetbrains/compose/resources/DrawableResource;
    move-result-object v0
    return-object v0
.end method

.method public final getTrae_artifact_preview_error()org.jetbrains.compose.resources.DrawableResource
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/kmp/artifacts/generated/resources/CommonMainDrawable0;->trae_artifact_preview_error$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lorg/jetbrains/compose/resources/DrawableResource;
    return-object v0
.end method

.method public final getTrae_video_preview_checkmark()org.jetbrains.compose.resources.DrawableResource
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/kmp/artifacts/generated/resources/CommonMainDrawable0;->trae_video_preview_checkmark$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lorg/jetbrains/compose/resources/DrawableResource;
    return-object v0
.end method

.method public final getTrae_video_preview_error()org.jetbrains.compose.resources.DrawableResource
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/kmp/artifacts/generated/resources/CommonMainDrawable0;->trae_video_preview_error$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lorg/jetbrains/compose/resources/DrawableResource;
    return-object v0
.end method

.method public final getTrae_video_preview_pause()org.jetbrains.compose.resources.DrawableResource
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/kmp/artifacts/generated/resources/CommonMainDrawable0;->trae_video_preview_pause$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lorg/jetbrains/compose/resources/DrawableResource;
    return-object v0
.end method

.method public final getTrae_video_preview_play()org.jetbrains.compose.resources.DrawableResource
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/kmp/artifacts/generated/resources/CommonMainDrawable0;->trae_video_preview_play$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lorg/jetbrains/compose/resources/DrawableResource;
    return-object v0
.end method
