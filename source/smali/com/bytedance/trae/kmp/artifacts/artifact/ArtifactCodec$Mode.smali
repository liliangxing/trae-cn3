# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final enum Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Mode;
.super Ljava/lang/Enum;
.source "ArtifactCodec.kt"

.field private static final synthetic $ENTRIES:Lkotlin/enums/EnumEntries;
.field private static final synthetic $VALUES:[Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Mode;
.field public static final enum Plain:Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Mode;
.field public static final enum V1:Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Mode;
.field public static final enum V2:Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Mode;
.field public static final enum Waiting:Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Mode;


.method private static final synthetic $values()com.bytedance.trae.kmp.artifacts.artifact.ArtifactCodec$Mode[]
    .registers 3
    # ins_size=0
    const/4 v0, 4
    new-array v0, v0, [Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Mode;
    const/4 v1, 0
    sget-object v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Mode;->Waiting Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Mode;
    aput-object v2, v0, v1
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Mode;->V1 Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Mode;
    aput-object v2, v0, v1
    const/4 v1, 2
    sget-object v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Mode;->V2 Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Mode;
    aput-object v2, v0, v1
    const/4 v1, 3
    sget-object v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Mode;->Plain Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Mode;
    aput-object v2, v0, v1
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Mode;
    const-string v1, "Waiting"
    const/4 v2, 0
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Mode;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Mode;->Waiting Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Mode;
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Mode;
    const-string v1, "V1"
    const/4 v2, 1
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Mode;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Mode;->V1 Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Mode;
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Mode;
    const-string v1, "V2"
    const/4 v2, 2
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Mode;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Mode;->V2 Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Mode;
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Mode;
    const-string v1, "Plain"
    const/4 v2, 3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Mode;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Mode;->Plain Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Mode;
    invoke-static Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Mode;->$values()[Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Mode;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Mode;->$VALUES [Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Mode;
    check-cast v0, [Ljava/lang/Enum;
    invoke-static v0, Lkotlin/enums/EnumEntriesKt;->enumEntries([Ljava/lang/Enum;)Lkotlin/enums/EnumEntries;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Mode;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-void 
.end method

.method private constructor <init>(java.lang.String  int)void
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Ljava/lang/Enum;-><init>(Ljava/lang/String; I)V
    return-void 
.end method

.method public static getEntries()kotlin.enums.EnumEntries
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Mode;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-object v0
.end method

.method public static valueOf(java.lang.String)com.bytedance.trae.kmp.artifacts.artifact.ArtifactCodec$Mode
    .registers 2
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Mode;
    invoke-static v0, v1, Ljava/lang/Enum;->valueOf(Ljava/lang/Class; Ljava/lang/String;)Ljava/lang/Enum;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Mode;
    return-object v1
.end method

.method public static values()com.bytedance.trae.kmp.artifacts.artifact.ArtifactCodec$Mode[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Mode;->$VALUES [Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Mode;
    invoke-virtual v0, Ljava/lang/Object;->clone()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, [Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Mode;
    return-object v0
.end method
