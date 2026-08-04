# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/kmp/artifacts/generated/resources/CommonMainString0;
.super Ljava/lang/Object;
.source "String0.commonMain.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/kmp/artifacts/generated/resources/CommonMainString0;
.field private static final trae_video_artifact_preview_error$delegate:Lkotlin/Lazy;
.field private static final trae_video_artifact_preview_loading$delegate:Lkotlin/Lazy;
.field private static final trae_video_artifact_preview_playing$delegate:Lkotlin/Lazy;
.field private static final trae_video_artifact_preview_reload$delegate:Lkotlin/Lazy;
.field private static final trae_video_artifact_preview_speed$delegate:Lkotlin/Lazy;


.method public static synthetic $r8$lambda$5GAEqJtRFINjh6np32W2xQXpOhQ()org.jetbrains.compose.resources.StringResource
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/kmp/artifacts/generated/resources/CommonMainString0;->trae_video_artifact_preview_speed_delegate$lambda$4()Lorg/jetbrains/compose/resources/StringResource;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$HbMiz1MtTqcFathUz3bqoXbtfrw()org.jetbrains.compose.resources.StringResource
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/kmp/artifacts/generated/resources/CommonMainString0;->trae_video_artifact_preview_playing_delegate$lambda$2()Lorg/jetbrains/compose/resources/StringResource;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$Vo8o2b_OZkn77R-7SKDFgIX8qLE()org.jetbrains.compose.resources.StringResource
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/kmp/artifacts/generated/resources/CommonMainString0;->trae_video_artifact_preview_error_delegate$lambda$0()Lorg/jetbrains/compose/resources/StringResource;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$Ywp43TrIO4tkpwun18UPahUSGbA()org.jetbrains.compose.resources.StringResource
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/kmp/artifacts/generated/resources/CommonMainString0;->trae_video_artifact_preview_loading_delegate$lambda$1()Lorg/jetbrains/compose/resources/StringResource;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$vFb5_DCWnHr8_zDjLo4dBC_bq7Q()org.jetbrains.compose.resources.StringResource
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/kmp/artifacts/generated/resources/CommonMainString0;->trae_video_artifact_preview_reload_delegate$lambda$3()Lorg/jetbrains/compose/resources/StringResource;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/generated/resources/CommonMainString0;
    invoke-direct v0, Lcom/bytedance/trae/kmp/artifacts/generated/resources/CommonMainString0;-><init>()V
    sput-object v0, Lcom/bytedance/trae/kmp/artifacts/generated/resources/CommonMainString0;->INSTANCE Lcom/bytedance/trae/kmp/artifacts/generated/resources/CommonMainString0;
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/generated/resources/CommonMainString0$$ExternalSyntheticLambda0;
    invoke-direct v0, Lcom/bytedance/trae/kmp/artifacts/generated/resources/CommonMainString0$$ExternalSyntheticLambda0;-><init>()V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/kmp/artifacts/generated/resources/CommonMainString0;->trae_video_artifact_preview_error$delegate Lkotlin/Lazy;
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/generated/resources/CommonMainString0$$ExternalSyntheticLambda1;
    invoke-direct v0, Lcom/bytedance/trae/kmp/artifacts/generated/resources/CommonMainString0$$ExternalSyntheticLambda1;-><init>()V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/kmp/artifacts/generated/resources/CommonMainString0;->trae_video_artifact_preview_loading$delegate Lkotlin/Lazy;
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/generated/resources/CommonMainString0$$ExternalSyntheticLambda2;
    invoke-direct v0, Lcom/bytedance/trae/kmp/artifacts/generated/resources/CommonMainString0$$ExternalSyntheticLambda2;-><init>()V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/kmp/artifacts/generated/resources/CommonMainString0;->trae_video_artifact_preview_playing$delegate Lkotlin/Lazy;
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/generated/resources/CommonMainString0$$ExternalSyntheticLambda3;
    invoke-direct v0, Lcom/bytedance/trae/kmp/artifacts/generated/resources/CommonMainString0$$ExternalSyntheticLambda3;-><init>()V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/kmp/artifacts/generated/resources/CommonMainString0;->trae_video_artifact_preview_reload$delegate Lkotlin/Lazy;
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/generated/resources/CommonMainString0$$ExternalSyntheticLambda4;
    invoke-direct v0, Lcom/bytedance/trae/kmp/artifacts/generated/resources/CommonMainString0$$ExternalSyntheticLambda4;-><init>()V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/kmp/artifacts/generated/resources/CommonMainString0;->trae_video_artifact_preview_speed$delegate Lkotlin/Lazy;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private static final trae_video_artifact_preview_error_delegate$lambda$0()org.jetbrains.compose.resources.StringResource
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/kmp/artifacts/generated/resources/StringInCommonMain0_androidMainKt;->__res_init_trae_video_artifact_preview_error()Lorg/jetbrains/compose/resources/StringResource;
    move-result-object v0
    return-object v0
.end method

.method private static final trae_video_artifact_preview_loading_delegate$lambda$1()org.jetbrains.compose.resources.StringResource
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/kmp/artifacts/generated/resources/StringInCommonMain0_androidMainKt;->__res_init_trae_video_artifact_preview_loading()Lorg/jetbrains/compose/resources/StringResource;
    move-result-object v0
    return-object v0
.end method

.method private static final trae_video_artifact_preview_playing_delegate$lambda$2()org.jetbrains.compose.resources.StringResource
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/kmp/artifacts/generated/resources/StringInCommonMain0_androidMainKt;->__res_init_trae_video_artifact_preview_playing()Lorg/jetbrains/compose/resources/StringResource;
    move-result-object v0
    return-object v0
.end method

.method private static final trae_video_artifact_preview_reload_delegate$lambda$3()org.jetbrains.compose.resources.StringResource
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/kmp/artifacts/generated/resources/StringInCommonMain0_androidMainKt;->__res_init_trae_video_artifact_preview_reload()Lorg/jetbrains/compose/resources/StringResource;
    move-result-object v0
    return-object v0
.end method

.method private static final trae_video_artifact_preview_speed_delegate$lambda$4()org.jetbrains.compose.resources.StringResource
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/kmp/artifacts/generated/resources/StringInCommonMain0_androidMainKt;->__res_init_trae_video_artifact_preview_speed()Lorg/jetbrains/compose/resources/StringResource;
    move-result-object v0
    return-object v0
.end method

.method public final getTrae_video_artifact_preview_error()org.jetbrains.compose.resources.StringResource
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/kmp/artifacts/generated/resources/CommonMainString0;->trae_video_artifact_preview_error$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lorg/jetbrains/compose/resources/StringResource;
    return-object v0
.end method

.method public final getTrae_video_artifact_preview_loading()org.jetbrains.compose.resources.StringResource
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/kmp/artifacts/generated/resources/CommonMainString0;->trae_video_artifact_preview_loading$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lorg/jetbrains/compose/resources/StringResource;
    return-object v0
.end method

.method public final getTrae_video_artifact_preview_playing()org.jetbrains.compose.resources.StringResource
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/kmp/artifacts/generated/resources/CommonMainString0;->trae_video_artifact_preview_playing$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lorg/jetbrains/compose/resources/StringResource;
    return-object v0
.end method

.method public final getTrae_video_artifact_preview_reload()org.jetbrains.compose.resources.StringResource
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/kmp/artifacts/generated/resources/CommonMainString0;->trae_video_artifact_preview_reload$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lorg/jetbrains/compose/resources/StringResource;
    return-object v0
.end method

.method public final getTrae_video_artifact_preview_speed()org.jetbrains.compose.resources.StringResource
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/kmp/artifacts/generated/resources/CommonMainString0;->trae_video_artifact_preview_speed$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lorg/jetbrains/compose/resources/StringResource;
    return-object v0
.end method
