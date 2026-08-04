# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;
.super Ljava/lang/Object;
.source "NewFeaturePromptPolicy.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig$Companion;
.field public static final DEFAULT_MIN_INTERVAL_MILLIS:J
.field private static final DEFAULT_PRIORITY:Ljava/util/List;
.field public static final DEFAULT_VERSION:I
.field private static final DISABLED:Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;
.field private final enable:Z
.field private final minIntervalMillis:J
.field private final priority:Ljava/util/List;
.field private final version:I


.method static constructor <clinit>()void
    .registers 9
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;->Companion Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig$Companion;
    const/4 v0, 2
    new-array v0, v0, [Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    const/4 v1, 0
    sget-object v2, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->WORK Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    aput-object v2, v0, v1
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->IDE Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    aput-object v2, v0, v1
    invoke-static v0, Lkotlin/collections/CollectionsKt;->listOf([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;->DEFAULT_PRIORITY Ljava/util/List;
    new-instance v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const-wide/16 v5, 0
    const/16 v7, 14
    const/4 v8, 0
    move-object v1, v0
    invoke-direct/range v1 ... v8, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;-><init>(Z I Ljava/util/List; J I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;->DISABLED Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;
    return-void 
.end method

.method public constructor <init>()void
    .registers 9
    # ins_size=1
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const-wide/16 v4, 0
    const/16 v6, 15
    const/4 v7, 0
    move-object v0, v8
    invoke-direct/range v0 ... v7, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;-><init>(Z I Ljava/util/List; J I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(boolean  int  java.util.List  long)void
    .registers 7
    # ins_size=6
    const-string v0, "priority"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-boolean v2, v1, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;->enable Z
    iput v3, v1, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;->version I
    iput-object v4, v1, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;->priority Ljava/util/List;
    iput-wide v5, v1, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;->minIntervalMillis J
    return-void 
.end method

.method public synthetic constructor <init>(boolean  int  java.util.List  long  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 10
    # ins_size=8
    and-int/lit8 v9, v8, 1
    const/4 v0, 1
    if-eqz v9, +004h
    move v9, v0
    goto +2h
    move v9, v3
    and-int/lit8 v3, v8, 2
    if-eqz v3, +003h
    goto +2h
    move v0, v4
    and-int/lit8 v3, v8, 4
    if-eqz v3, +004h
    sget-object v5, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;->DEFAULT_PRIORITY Ljava/util/List;
    move-object v1, v5
    and-int/lit8 v3, v8, 8
    if-eqz v3, +005h
    const-wide/32 v6, 86400000
    move-wide v7, v6
    move-object v3, v2
    move v4, v9
    move v5, v0
    move-object v6, v1
    invoke-direct/range v3 ... v8, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;-><init>(Z I Ljava/util/List; J)V
    return-void 
.end method

.method public static final synthetic access$getDEFAULT_PRIORITY$cp()java.util.List
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;->DEFAULT_PRIORITY Ljava/util/List;
    return-object v0
.end method

.method public static final synthetic access$getDISABLED$cp()com.bytedance.trae.conversation.devices.newfeature.NewFeaturePromptConfig
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;->DISABLED Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;
    return-object v0
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.devices.newfeature.NewFeaturePromptConfig  boolean  int  java.util.List  long  int  java.lang.Object)com.bytedance.trae.conversation.devices.newfeature.NewFeaturePromptConfig
    .registers 11
    # ins_size=8
    and-int/lit8 v10, v9, 1
    if-eqz v10, +004h
    iget-boolean v4, v3, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;->enable Z
    and-int/lit8 v10, v9, 2
    if-eqz v10, +004h
    iget v5, v3, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;->version I
    move v10, v5
    and-int/lit8 v5, v9, 4
    if-eqz v5, +004h
    iget-object v6, v3, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;->priority Ljava/util/List;
    move-object v0, v6
    and-int/lit8 v5, v9, 8
    if-eqz v5, +004h
    iget-wide v7, v3, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;->minIntervalMillis J
    move-wide v1, v7
    move-object v5, v3
    move v6, v4
    move v7, v10
    move-object v8, v0
    move-wide v9, v1
    invoke-virtual/range v5 ... v10, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;->copy(Z I Ljava/util/List; J)Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;
    move-result-object v3
    return-object v3
.end method

.method public final component1()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;->enable Z
    return v0
.end method

.method public final component2()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;->version I
    return v0
.end method

.method public final component3()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;->priority Ljava/util/List;
    return-object v0
.end method

.method public final component4()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;->minIntervalMillis J
    return-wide v0
.end method

.method public final copy(boolean  int  java.util.List  long)com.bytedance.trae.conversation.devices.newfeature.NewFeaturePromptConfig
    .registers 13
    # ins_size=6
    const-string v0, "priority"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;
    move-object v1, v0
    move v2, v8
    move v3, v9
    move-object v4, v10
    move-wide v5, v11
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;-><init>(Z I Ljava/util/List; J)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 1
    if-ne v7, v8, +003h
    return v0
    instance-of v1, v8, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v8, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;
    iget-boolean v1, v7, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;->enable Z
    iget-boolean v3, v8, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;->enable Z
    if-eq v1, v3, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;->version I
    iget v3, v8, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;->version I
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;->priority Ljava/util/List;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;->priority Ljava/util/List;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;->minIntervalMillis J
    iget-wide v5, v8, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;->minIntervalMillis J
    cmp-long v8, v3, v5
    if-eqz v8, +003h
    return v2
    return v0
.end method

.method public final getEnable()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;->enable Z
    return v0
.end method

.method public final getMinIntervalMillis()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;->minIntervalMillis J
    return-wide v0
.end method

.method public final getPriority()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;->priority Ljava/util/List;
    return-object v0
.end method

.method public final getVersion()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;->version I
    return v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-boolean v0, v3, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;->enable Z
    invoke-static v0, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;->version I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;->priority Ljava/util/List;
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;->minIntervalMillis J
    invoke-static v1, v2, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "NewFeaturePromptConfig(enable="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-boolean v1, v3, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;->enable Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", version="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v3, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;->version I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", priority="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;->priority Ljava/util/List;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", minIntervalMillis="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConfig;->minIntervalMillis J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
