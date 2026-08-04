# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/apm/api/ITTProtector$Companion;
.super Ljava/lang/Object;
.source "ITTProtector.kt"

.implements Lcom/bytedance/trae/apm/api/ITTProtector;

.field static final synthetic $$INSTANCE:Lcom/bytedance/trae/apm/api/ITTProtector$Companion;
.field private static final impl$delegate:Lkotlin/Lazy;


.method public static synthetic $r8$lambda$L603WUEe7479RmINltBJ-pQxvFo()com.bytedance.trae.apm.api.ITTProtector
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/apm/api/ITTProtector$Companion;->impl_delegate$lambda$0()Lcom/bytedance/trae/apm/api/ITTProtector;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/apm/api/ITTProtector$Companion;
    invoke-direct v0, Lcom/bytedance/trae/apm/api/ITTProtector$Companion;-><init>()V
    sput-object v0, Lcom/bytedance/trae/apm/api/ITTProtector$Companion;->$$INSTANCE Lcom/bytedance/trae/apm/api/ITTProtector$Companion;
    new-instance v0, Lcom/bytedance/trae/apm/api/ITTProtector$Companion$$ExternalSyntheticLambda0;
    invoke-direct v0, Lcom/bytedance/trae/apm/api/ITTProtector$Companion$$ExternalSyntheticLambda0;-><init>()V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/apm/api/ITTProtector$Companion;->impl$delegate Lkotlin/Lazy;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final getImpl()com.bytedance.trae.apm.api.ITTProtector
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/apm/api/ITTProtector$Companion;->impl$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/apm/api/ITTProtector;
    return-object v0
.end method

.method private static final impl_delegate$lambda$0()com.bytedance.trae.apm.api.ITTProtector
    .registers 2
    # ins_size=0
    const-class v0, Lcom/bytedance/trae/apm/api/ITTProtector;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/apm/api/ITTProtector;
    invoke-virtual v0, v1, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/apm/api/ITTProtector;
    return-object v0
.end method

.method public init()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/apm/api/ITTProtector$Companion;->getImpl()Lcom/bytedance/trae/apm/api/ITTProtector;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, Lcom/bytedance/trae/apm/api/ITTProtector;->init()V
    return-void 
.end method
