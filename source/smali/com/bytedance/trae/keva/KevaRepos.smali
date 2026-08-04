# Decompiled TRAE business class
# Source DEX: classes.dex
.class public final Lcom/bytedance/trae/keva/KevaRepos;
.super Ljava/lang/Object;
.source "KevaRepos.kt"

.field public static final AUTO_INIT_ANY_WHERE_DOOR:Ljava/lang/String;
.field public static final HAS_DORA_DEVICE:Ljava/lang/String;
.field public static final INSTANCE:Lcom/bytedance/trae/keva/KevaRepos;
.field public static final REPO_DEFAULT:Ljava/lang/String;
.field public static final REPO_MESSAGE_IMPRESSION:Ljava/lang/String;
.field private static final defaultRepo$delegate:Lkotlin/Lazy;


.method public static synthetic $r8$lambda$jEFL8Y3Gd7aVvENR9vC42L7LnZ8()com.bytedance.keva.Keva
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/keva/KevaRepos;->defaultRepo_delegate$lambda$0()Lcom/bytedance/keva/Keva;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/keva/KevaRepos;
    invoke-direct v0, Lcom/bytedance/trae/keva/KevaRepos;-><init>()V
    sput-object v0, Lcom/bytedance/trae/keva/KevaRepos;->INSTANCE Lcom/bytedance/trae/keva/KevaRepos;
    new-instance v0, Lcom/bytedance/trae/keva/KevaRepos$$ExternalSyntheticLambda0;
    invoke-direct v0, Lcom/bytedance/trae/keva/KevaRepos$$ExternalSyntheticLambda0;-><init>()V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/keva/KevaRepos;->defaultRepo$delegate Lkotlin/Lazy;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private static final defaultRepo_delegate$lambda$0()com.bytedance.keva.Keva
    .registers 2
    # ins_size=0
    const-string v0, "default"
    const/4 v1, 0
    invoke-static v0, v1, Lcom/bytedance/keva/Keva;->getRepo(Ljava/lang/String; I)Lcom/bytedance/keva/Keva;
    move-result-object v0
    return-object v0
.end method

.method public final getDefaultRepo()com.bytedance.keva.Keva
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/keva/KevaRepos;->defaultRepo$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    const-string v1, "getValue(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Lcom/bytedance/keva/Keva;
    return-object v0
.end method
