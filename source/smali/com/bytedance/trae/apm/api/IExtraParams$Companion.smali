# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/apm/api/IExtraParams$Companion;
.super Ljava/lang/Object;
.source "IExtraParams.kt"

.implements Lcom/bytedance/trae/apm/api/IExtraParams;

.field static final synthetic $$INSTANCE:Lcom/bytedance/trae/apm/api/IExtraParams$Companion;
.field public static final KEY_APP_VARIANT:Ljava/lang/String;
.field public static final KEY_BUILD_JOB_ID:Ljava/lang/String;
.field public static final KEY_GIT_BRANCH:Ljava/lang/String;
.field public static final KEY_GIT_COMMIT_ID:Ljava/lang/String;
.field public static final KEY_PROCESS_ID:Ljava/lang/String;
.field public static final KEY_PROCESS_NAME:Ljava/lang/String;
.field private static bridge dynamicParamsProvider:Lkotlin/jvm/functions/Function0;
.field private static final impl$delegate:Lkotlin/Lazy;


.method public static synthetic $r8$lambda$RAleyWdoTVhrCoZhIJ0mMStdVuo()com.bytedance.trae.apm.api.IExtraParams
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/apm/api/IExtraParams$Companion;->impl_delegate$lambda$0()Lcom/bytedance/trae/apm/api/IExtraParams;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/apm/api/IExtraParams$Companion;
    invoke-direct v0, Lcom/bytedance/trae/apm/api/IExtraParams$Companion;-><init>()V
    sput-object v0, Lcom/bytedance/trae/apm/api/IExtraParams$Companion;->$$INSTANCE Lcom/bytedance/trae/apm/api/IExtraParams$Companion;
    new-instance v0, Lcom/bytedance/trae/apm/api/IExtraParams$Companion$$ExternalSyntheticLambda0;
    invoke-direct v0, Lcom/bytedance/trae/apm/api/IExtraParams$Companion$$ExternalSyntheticLambda0;-><init>()V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/apm/api/IExtraParams$Companion;->impl$delegate Lkotlin/Lazy;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final getImpl()com.bytedance.trae.apm.api.IExtraParams
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/apm/api/IExtraParams$Companion;->impl$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/apm/api/IExtraParams;
    return-object v0
.end method

.method private static final impl_delegate$lambda$0()com.bytedance.trae.apm.api.IExtraParams
    .registers 2
    # ins_size=0
    const-class v0, Lcom/bytedance/trae/apm/api/IExtraParams;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/apm/api/IExtraParams;
    invoke-virtual v0, v1, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/apm/api/IExtraParams;
    return-object v0
.end method

.method public getAppVariant()java.lang.String
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/apm/api/IExtraParams$Companion;->getImpl()Lcom/bytedance/trae/apm/api/IExtraParams;
    move-result-object v0
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/apm/api/IExtraParams;->getAppVariant()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    const-string v0, ""
    return-object v0
.end method

.method public final getDynamicParams()java.util.Map
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/apm/api/IExtraParams$Companion;->dynamicParamsProvider Lkotlin/jvm/functions/Function0;
    if-eqz v0, +00ah
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/util/Map;
    if-nez v0, +006h
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v0
    return-object v0
.end method

.method public getStaticParams()java.util.Map
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/apm/api/IExtraParams$Companion;->getImpl()Lcom/bytedance/trae/apm/api/IExtraParams;
    move-result-object v0
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/apm/api/IExtraParams;->getStaticParams()Ljava/util/Map;
    move-result-object v0
    if-nez v0, +006h
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v0
    return-object v0
.end method

.method public final registerDynamicParamsProvider(kotlin.jvm.functions.Function0)void
    .registers 3
    # ins_size=2
    const-string v0, "provider"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sput-object v2, Lcom/bytedance/trae/apm/api/IExtraParams$Companion;->dynamicParamsProvider Lkotlin/jvm/functions/Function0;
    return-void 
.end method
