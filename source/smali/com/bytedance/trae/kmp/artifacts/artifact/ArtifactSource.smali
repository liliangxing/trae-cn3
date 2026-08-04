# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final enum Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource;
.super Ljava/lang/Enum;
.source "ArtifactModels.kt"

.field private static final synthetic $ENTRIES:Lkotlin/enums/EnumEntries;
.field private static final synthetic $VALUES:[Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource;
.field private static final $cachedSerializer$delegate:Lkotlin/Lazy;
.field public static final Companion:Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource$Companion;
.field public static final enum Local:Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource;
.field public static final enum Remote:Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource;


.method public static synthetic $r8$lambda$02NOMfkvaiVcat-yuLf3FpBDiJM()kotlinx.serialization.KSerializer
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource;->_init_$_anonymous_()Lkotlinx/serialization/KSerializer;
    move-result-object v0
    return-object v0
.end method

.method private static final synthetic $values()com.bytedance.trae.kmp.artifacts.artifact.ArtifactSource[]
    .registers 3
    # ins_size=0
    const/4 v0, 2
    new-array v0, v0, [Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource;
    const/4 v1, 0
    sget-object v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource;->Remote Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource;
    aput-object v2, v0, v1
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource;->Local Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource;
    aput-object v2, v0, v1
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource;
    const-string v1, "Remote"
    const/4 v2, 0
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource;->Remote Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource;
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource;
    const-string v1, "Local"
    const/4 v2, 1
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource;->Local Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource;
    invoke-static Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource;->$values()[Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource;->$VALUES [Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource;
    check-cast v0, [Ljava/lang/Enum;
    invoke-static v0, Lkotlin/enums/EnumEntriesKt;->enumEntries([Ljava/lang/Enum;)Lkotlin/enums/EnumEntries;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource;->$ENTRIES Lkotlin/enums/EnumEntries;
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource;->Companion Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource$Companion;
    sget-object v0, Lkotlin/LazyThreadSafetyMode;->PUBLICATION Lkotlin/LazyThreadSafetyMode;
    new-instance v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource$$ExternalSyntheticLambda0;
    invoke-direct v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource$$ExternalSyntheticLambda0;-><init>()V
    invoke-static v0, v1, Lkotlin/LazyKt;->lazy(Lkotlin/LazyThreadSafetyMode; Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource;->$cachedSerializer$delegate Lkotlin/Lazy;
    return-void 
.end method

.method private constructor <init>(java.lang.String  int)void
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Ljava/lang/Enum;-><init>(Ljava/lang/String; I)V
    return-void 
.end method

.method private static final synthetic _init_$_anonymous_()kotlinx.serialization.KSerializer
    .registers 2
    # ins_size=0
    invoke-static Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource;->values()[Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource;
    move-result-object v0
    check-cast v0, [Ljava/lang/Enum;
    const-string v1, "com.bytedance.trae.kmp.artifacts.artifact.ArtifactSource"
    invoke-static v1, v0, Lkotlinx/serialization/internal/EnumsKt;->createSimpleEnumSerializer(Ljava/lang/String; [Ljava/lang/Enum;)Lkotlinx/serialization/KSerializer;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$get$cachedSerializer$delegate$cp()kotlin.Lazy
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource;->$cachedSerializer$delegate Lkotlin/Lazy;
    return-object v0
.end method

.method public static getEntries()kotlin.enums.EnumEntries
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-object v0
.end method

.method public static valueOf(java.lang.String)com.bytedance.trae.kmp.artifacts.artifact.ArtifactSource
    .registers 2
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource;
    invoke-static v0, v1, Ljava/lang/Enum;->valueOf(Ljava/lang/Class; Ljava/lang/String;)Ljava/lang/Enum;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource;
    return-object v1
.end method

.method public static values()com.bytedance.trae.kmp.artifacts.artifact.ArtifactSource[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource;->$VALUES [Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource;
    invoke-virtual v0, Ljava/lang/Object;->clone()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, [Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactSource;
    return-object v0
.end method
