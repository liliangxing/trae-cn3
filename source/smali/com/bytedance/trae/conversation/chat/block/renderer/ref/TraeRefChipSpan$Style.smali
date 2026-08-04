# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;
.super Ljava/lang/Object;
.source "TraeRefChipSpan.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style$Companion;
.field private final bgColor:I
.field private final bgColorPressed:I
.field private final cornerRadiusDp:F
.field private final density:F
.field private final horizontalPaddingDp:F
.field private final marginDp:F
.field private final textColor:I
.field private final textSizePx:F
.field private final verticalPaddingDp:F


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->Companion Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 13
    # ins_size=1
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/16 v10, 511
    const/4 v11, 0
    move-object v0, v12
    invoke-direct/range v0 ... v11, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;-><init>(I I I F F F F F F I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(int  int  int  float  float  float  float  float  float)void
    .registers 10
    # ins_size=10
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->bgColor I
    iput v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->bgColorPressed I
    iput v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->textColor I
    iput v4, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->textSizePx F
    iput v5, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->horizontalPaddingDp F
    iput v6, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->verticalPaddingDp F
    iput v7, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->cornerRadiusDp F
    iput v8, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->marginDp F
    iput v9, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->density F
    return-void 
.end method

.method public synthetic constructor <init>(int  int  int  float  float  float  float  float  float  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 22
    # ins_size=12
    move/from16 v0, v20
    and-int/lit8 v1, v0, 1
    if-eqz v1, +006h
    const v1, 343110515
    goto +2h
    move v1, v11
    and-int/lit8 v2, v0, 2
    if-eqz v2, +006h
    const v2, 510882675
    goto +2h
    move v2, v12
    and-int/lit8 v3, v0, 4
    if-eqz v3, +006h
    const v3, -9211021
    goto +2h
    move v3, v13
    and-int/lit8 v4, v0, 8
    if-eqz v4, +005h
    const/high16 v4, 1095761920
    goto +2h
    move v4, v14
    and-int/lit8 v5, v0, 16
    if-eqz v5, +005h
    const/high16 v5, 1090519040
    goto +2h
    move v5, v15
    and-int/lit8 v6, v0, 32
    const/high16 v7, 1073741824
    if-eqz v6, +004h
    move v6, v7
    goto +3h
    move/from16 v6, v16
    and-int/lit8 v8, v0, 64
    if-eqz v8, +005h
    const/high16 v8, 1106247680
    goto +3h
    move/from16 v8, v17
    and-int/lit16 v9, v0, 128
    if-eqz v9, +003h
    goto +3h
    move/from16 v7, v18
    and-int/lit16 v0, v0, 256
    if-eqz v0, +005h
    const/high16 v0, 1065353216
    goto +3h
    move/from16 v0, v19
    move-object v11, v10
    move v12, v1
    move v13, v2
    move v14, v3
    move v15, v4
    move/from16 v16, v5
    move/from16 v17, v6
    move/from16 v18, v8
    move/from16 v19, v7
    move/from16 v20, v0
    invoke-direct/range v11 ... v20, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;-><init>(I I I F F F F F F)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.chat.block.renderer.ref.TraeRefChipSpan$Style  int  int  int  float  float  float  float  float  float  int  java.lang.Object)com.bytedance.trae.conversation.chat.block.renderer.ref.TraeRefChipSpan$Style
    .registers 22
    # ins_size=12
    move-object v0, v10
    move/from16 v1, v20
    and-int/lit8 v2, v1, 1
    if-eqz v2, +005h
    iget v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->bgColor I
    goto +2h
    move v2, v11
    and-int/lit8 v3, v1, 2
    if-eqz v3, +005h
    iget v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->bgColorPressed I
    goto +2h
    move v3, v12
    and-int/lit8 v4, v1, 4
    if-eqz v4, +005h
    iget v4, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->textColor I
    goto +2h
    move v4, v13
    and-int/lit8 v5, v1, 8
    if-eqz v5, +005h
    iget v5, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->textSizePx F
    goto +2h
    move v5, v14
    and-int/lit8 v6, v1, 16
    if-eqz v6, +005h
    iget v6, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->horizontalPaddingDp F
    goto +2h
    move v6, v15
    and-int/lit8 v7, v1, 32
    if-eqz v7, +005h
    iget v7, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->verticalPaddingDp F
    goto +3h
    move/from16 v7, v16
    and-int/lit8 v8, v1, 64
    if-eqz v8, +005h
    iget v8, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->cornerRadiusDp F
    goto +3h
    move/from16 v8, v17
    and-int/lit16 v9, v1, 128
    if-eqz v9, +005h
    iget v9, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->marginDp F
    goto +3h
    move/from16 v9, v18
    and-int/lit16 v1, v1, 256
    if-eqz v1, +005h
    iget v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->density F
    goto +3h
    move/from16 v1, v19
    move v11, v2
    move v12, v3
    move v13, v4
    move v14, v5
    move v15, v6
    move/from16 v16, v7
    move/from16 v17, v8
    move/from16 v18, v9
    move/from16 v19, v1
    invoke-virtual/range v10 ... v19, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->copy(I I I F F F F F F)Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;
    move-result-object v0
    return-object v0
.end method

.method public final component1()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->bgColor I
    return v0
.end method

.method public final component2()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->bgColorPressed I
    return v0
.end method

.method public final component3()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->textColor I
    return v0
.end method

.method public final component4()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->textSizePx F
    return v0
.end method

.method public final component5()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->horizontalPaddingDp F
    return v0
.end method

.method public final component6()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->verticalPaddingDp F
    return v0
.end method

.method public final component7()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->cornerRadiusDp F
    return v0
.end method

.method public final component8()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->marginDp F
    return v0
.end method

.method public final component9()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->density F
    return v0
.end method

.method public final copy(int  int  int  float  float  float  float  float  float)com.bytedance.trae.conversation.chat.block.renderer.ref.TraeRefChipSpan$Style
    .registers 21
    # ins_size=10
    new-instance v10, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;
    move-object v0, v10
    move v1, v12
    move v2, v13
    move v3, v14
    move v4, v15
    move/from16 v5, v16
    move/from16 v6, v17
    move/from16 v7, v18
    move/from16 v8, v19
    move/from16 v9, v20
    invoke-direct/range v0 ... v9, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;-><init>(I I I F F F F F F)V
    return-object v10
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;
    iget v1, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->bgColor I
    iget v3, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->bgColor I
    if-eq v1, v3, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->bgColorPressed I
    iget v3, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->bgColorPressed I
    if-eq v1, v3, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->textColor I
    iget v3, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->textColor I
    if-eq v1, v3, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->textSizePx F
    iget v3, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->textSizePx F
    invoke-static v1, v3, Ljava/lang/Float;->compare(F F)I
    move-result v1
    if-eqz v1, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->horizontalPaddingDp F
    iget v3, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->horizontalPaddingDp F
    invoke-static v1, v3, Ljava/lang/Float;->compare(F F)I
    move-result v1
    if-eqz v1, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->verticalPaddingDp F
    iget v3, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->verticalPaddingDp F
    invoke-static v1, v3, Ljava/lang/Float;->compare(F F)I
    move-result v1
    if-eqz v1, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->cornerRadiusDp F
    iget v3, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->cornerRadiusDp F
    invoke-static v1, v3, Ljava/lang/Float;->compare(F F)I
    move-result v1
    if-eqz v1, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->marginDp F
    iget v3, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->marginDp F
    invoke-static v1, v3, Ljava/lang/Float;->compare(F F)I
    move-result v1
    if-eqz v1, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->density F
    iget v5, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->density F
    invoke-static v1, v5, Ljava/lang/Float;->compare(F F)I
    move-result v5
    if-eqz v5, +003h
    return v2
    return v0
.end method

.method public final getBgColor()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->bgColor I
    return v0
.end method

.method public final getBgColorPressed()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->bgColorPressed I
    return v0
.end method

.method public final getCornerRadiusDp()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->cornerRadiusDp F
    return v0
.end method

.method public final getCornerRadiusPx()float
    .registers 3
    # ins_size=1
    iget v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->cornerRadiusDp F
    iget v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->density F
    mul-float/2addr v0, v1
    return v0
.end method

.method public final getDensity()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->density F
    return v0
.end method

.method public final getHorizontalPaddingDp()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->horizontalPaddingDp F
    return v0
.end method

.method public final getHorizontalPaddingPx()float
    .registers 3
    # ins_size=1
    iget v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->horizontalPaddingDp F
    iget v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->density F
    mul-float/2addr v0, v1
    return v0
.end method

.method public final getMarginDp()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->marginDp F
    return v0
.end method

.method public final getMarginPx()float
    .registers 3
    # ins_size=1
    iget v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->marginDp F
    iget v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->density F
    mul-float/2addr v0, v1
    return v0
.end method

.method public final getTextColor()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->textColor I
    return v0
.end method

.method public final getTextSizePx()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->textSizePx F
    return v0
.end method

.method public final getVerticalPaddingDp()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->verticalPaddingDp F
    return v0
.end method

.method public final getVerticalPaddingPx()float
    .registers 3
    # ins_size=1
    iget v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->verticalPaddingDp F
    iget v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->density F
    mul-float/2addr v0, v1
    return v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->bgColor I
    invoke-static v0, Ljava/lang/Integer;->hashCode(I)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->bgColorPressed I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->textColor I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->textSizePx F
    invoke-static v1, Ljava/lang/Float;->hashCode(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->horizontalPaddingDp F
    invoke-static v1, Ljava/lang/Float;->hashCode(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->verticalPaddingDp F
    invoke-static v1, Ljava/lang/Float;->hashCode(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->cornerRadiusDp F
    invoke-static v1, Ljava/lang/Float;->hashCode(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->marginDp F
    invoke-static v1, Ljava/lang/Float;->hashCode(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->density F
    invoke-static v1, Ljava/lang/Float;->hashCode(F)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "Style(bgColor="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->bgColor I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", bgColorPressed="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->bgColorPressed I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", textColor="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->textColor I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", textSizePx="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->textSizePx F
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", horizontalPaddingDp="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->horizontalPaddingDp F
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", verticalPaddingDp="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->verticalPaddingDp F
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", cornerRadiusDp="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->cornerRadiusDp F
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", marginDp="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->marginDp F
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", density="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->density F
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
