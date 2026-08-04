# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/design/compose/TraeContextMenuItem;
.super Ljava/lang/Object;
.source "TraeContextMenuPopup.kt"

.field public static final $stable:I
.field private final icon:Lorg/jetbrains/compose/resources/DrawableResource;
.field private final iconTint:Landroidx/compose/ui/graphics/Color;
.field private final key:Ljava/lang/String;
.field private final onClick:Lkotlin/jvm/functions/Function0;
.field private final text:Ljava/lang/String;
.field private final textColor:Landroidx/compose/ui/graphics/Color;
.field private final trailingIcon:Lorg/jetbrains/compose/resources/DrawableResource;
.field private final trailingIconTint:Landroidx/compose/ui/graphics/Color;


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method private constructor <init>(java.lang.String  java.lang.String  kotlin.jvm.functions.Function0  org.jetbrains.compose.resources.DrawableResource  androidx.compose.ui.graphics.Color  androidx.compose.ui.graphics.Color  org.jetbrains.compose.resources.DrawableResource  androidx.compose.ui.graphics.Color)void
    .registers 10
    # ins_size=9
    const-string v0, "key"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, text
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onClick"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;->key Ljava/lang/String;
    iput-object v3, v1, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;->text Ljava/lang/String;
    iput-object v4, v1, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;->onClick Lkotlin/jvm/functions/Function0;
    iput-object v5, v1, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;->icon Lorg/jetbrains/compose/resources/DrawableResource;
    iput-object v6, v1, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;->textColor Landroidx/compose/ui/graphics/Color;
    iput-object v7, v1, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;->iconTint Landroidx/compose/ui/graphics/Color;
    iput-object v8, v1, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;->trailingIcon Lorg/jetbrains/compose/resources/DrawableResource;
    iput-object v9, v1, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;->trailingIconTint Landroidx/compose/ui/graphics/Color;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  java.lang.String  kotlin.jvm.functions.Function0  org.jetbrains.compose.resources.DrawableResource  androidx.compose.ui.graphics.Color  androidx.compose.ui.graphics.Color  org.jetbrains.compose.resources.DrawableResource  androidx.compose.ui.graphics.Color  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 24
    # ins_size=11
    move/from16 v0, v22
    and-int/lit8 v1, v0, 8
    const/4 v2, 0
    if-eqz v1, +004h
    move-object v7, v2
    goto +3h
    move-object/from16 v7, v17
    and-int/lit8 v1, v0, 16
    if-eqz v1, +004h
    move-object v8, v2
    goto +3h
    move-object/from16 v8, v18
    and-int/lit8 v1, v0, 32
    if-eqz v1, +004h
    move-object v9, v8
    goto +3h
    move-object/from16 v9, v19
    and-int/lit8 v1, v0, 64
    if-eqz v1, +004h
    move-object v10, v2
    goto +3h
    move-object/from16 v10, v20
    and-int/lit16 v0, v0, 128
    if-eqz v0, +004h
    move-object v11, v2
    goto +3h
    move-object/from16 v11, v21
    const/4 v12, 0
    move-object v3, v13
    move-object v4, v14
    move-object v5, v15
    move-object/from16 v6, v16
    invoke-direct/range v3 ... v12, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;-><init>(Ljava/lang/String; Ljava/lang/String; Lkotlin/jvm/functions/Function0; Lorg/jetbrains/compose/resources/DrawableResource; Landroidx/compose/ui/graphics/Color; Landroidx/compose/ui/graphics/Color; Lorg/jetbrains/compose/resources/DrawableResource; Landroidx/compose/ui/graphics/Color; Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  java.lang.String  kotlin.jvm.functions.Function0  org.jetbrains.compose.resources.DrawableResource  androidx.compose.ui.graphics.Color  androidx.compose.ui.graphics.Color  org.jetbrains.compose.resources.DrawableResource  androidx.compose.ui.graphics.Color  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 10
    # ins_size=10
    invoke-direct/range v0 ... v8, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;-><init>(Ljava/lang/String; Ljava/lang/String; Lkotlin/jvm/functions/Function0; Lorg/jetbrains/compose/resources/DrawableResource; Landroidx/compose/ui/graphics/Color; Landroidx/compose/ui/graphics/Color; Lorg/jetbrains/compose/resources/DrawableResource; Landroidx/compose/ui/graphics/Color;)V
    return-void 
.end method

.method public static synthetic copy-D_Dgqy4$default(com.bytedance.trae.design.compose.TraeContextMenuItem  java.lang.String  java.lang.String  kotlin.jvm.functions.Function0  org.jetbrains.compose.resources.DrawableResource  androidx.compose.ui.graphics.Color  androidx.compose.ui.graphics.Color  org.jetbrains.compose.resources.DrawableResource  androidx.compose.ui.graphics.Color  int  java.lang.Object)com.bytedance.trae.design.compose.TraeContextMenuItem
    .registers 20
    # ins_size=11
    move-object v0, v9
    move/from16 v1, v18
    and-int/lit8 v2, v1, 1
    if-eqz v2, +005h
    iget-object v2, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;->key Ljava/lang/String;
    goto +2h
    move-object v2, v10
    and-int/lit8 v3, v1, 2
    if-eqz v3, +005h
    iget-object v3, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;->text Ljava/lang/String;
    goto +2h
    move-object v3, v11
    and-int/lit8 v4, v1, 4
    if-eqz v4, +005h
    iget-object v4, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;->onClick Lkotlin/jvm/functions/Function0;
    goto +2h
    move-object v4, v12
    and-int/lit8 v5, v1, 8
    if-eqz v5, +005h
    iget-object v5, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;->icon Lorg/jetbrains/compose/resources/DrawableResource;
    goto +2h
    move-object v5, v13
    and-int/lit8 v6, v1, 16
    if-eqz v6, +005h
    iget-object v6, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;->textColor Landroidx/compose/ui/graphics/Color;
    goto +2h
    move-object v6, v14
    and-int/lit8 v7, v1, 32
    if-eqz v7, +005h
    iget-object v7, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;->iconTint Landroidx/compose/ui/graphics/Color;
    goto +2h
    move-object v7, v15
    and-int/lit8 v8, v1, 64
    if-eqz v8, +005h
    iget-object v8, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;->trailingIcon Lorg/jetbrains/compose/resources/DrawableResource;
    goto +3h
    move-object/from16 v8, v16
    and-int/lit16 v1, v1, 128
    if-eqz v1, +005h
    iget-object v1, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;->trailingIconTint Landroidx/compose/ui/graphics/Color;
    goto +3h
    move-object/from16 v1, v17
    move-object v10, v2
    move-object v11, v3
    move-object v12, v4
    move-object v13, v5
    move-object v14, v6
    move-object v15, v7
    move-object/from16 v16, v8
    move-object/from16 v17, v1
    invoke-virtual/range v9 ... v17, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;->copy-D_Dgqy4(Ljava/lang/String; Ljava/lang/String; Lkotlin/jvm/functions/Function0; Lorg/jetbrains/compose/resources/DrawableResource; Landroidx/compose/ui/graphics/Color; Landroidx/compose/ui/graphics/Color; Lorg/jetbrains/compose/resources/DrawableResource; Landroidx/compose/ui/graphics/Color;)Lcom/bytedance/trae/design/compose/TraeContextMenuItem;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;->key Ljava/lang/String;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;->text Ljava/lang/String;
    return-object v0
.end method

.method public final component3()kotlin.jvm.functions.Function0
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;->onClick Lkotlin/jvm/functions/Function0;
    return-object v0
.end method

.method public final component4()org.jetbrains.compose.resources.DrawableResource
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;->icon Lorg/jetbrains/compose/resources/DrawableResource;
    return-object v0
.end method

.method public final component5-QN2ZGVo()androidx.compose.ui.graphics.Color
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;->textColor Landroidx/compose/ui/graphics/Color;
    return-object v0
.end method

.method public final component6-QN2ZGVo()androidx.compose.ui.graphics.Color
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;->iconTint Landroidx/compose/ui/graphics/Color;
    return-object v0
.end method

.method public final component7()org.jetbrains.compose.resources.DrawableResource
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;->trailingIcon Lorg/jetbrains/compose/resources/DrawableResource;
    return-object v0
.end method

.method public final component8-QN2ZGVo()androidx.compose.ui.graphics.Color
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;->trailingIconTint Landroidx/compose/ui/graphics/Color;
    return-object v0
.end method

.method public final copy-D_Dgqy4(java.lang.String  java.lang.String  kotlin.jvm.functions.Function0  org.jetbrains.compose.resources.DrawableResource  androidx.compose.ui.graphics.Color  androidx.compose.ui.graphics.Color  org.jetbrains.compose.resources.DrawableResource  androidx.compose.ui.graphics.Color)com.bytedance.trae.design.compose.TraeContextMenuItem
    .registers 20
    # ins_size=9
    const-string v0, "key"
    move-object v2, v12
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, text
    move-object v3, v13
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onClick"
    move-object v4, v14
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;
    const/4 v10, 0
    move-object v1, v0
    move-object v5, v15
    move-object/from16 v6, v16
    move-object/from16 v7, v17
    move-object/from16 v8, v18
    move-object/from16 v9, v19
    invoke-direct/range v1 ... v10, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;-><init>(Ljava/lang/String; Ljava/lang/String; Lkotlin/jvm/functions/Function0; Lorg/jetbrains/compose/resources/DrawableResource; Landroidx/compose/ui/graphics/Color; Landroidx/compose/ui/graphics/Color; Lorg/jetbrains/compose/resources/DrawableResource; Landroidx/compose/ui/graphics/Color; Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;
    iget-object v1, v4, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;->key Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;->key Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;->text Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;->text Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;->onClick Lkotlin/jvm/functions/Function0;
    iget-object v3, v5, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;->onClick Lkotlin/jvm/functions/Function0;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;->icon Lorg/jetbrains/compose/resources/DrawableResource;
    iget-object v3, v5, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;->icon Lorg/jetbrains/compose/resources/DrawableResource;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;->textColor Landroidx/compose/ui/graphics/Color;
    iget-object v3, v5, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;->textColor Landroidx/compose/ui/graphics/Color;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;->iconTint Landroidx/compose/ui/graphics/Color;
    iget-object v3, v5, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;->iconTint Landroidx/compose/ui/graphics/Color;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;->trailingIcon Lorg/jetbrains/compose/resources/DrawableResource;
    iget-object v3, v5, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;->trailingIcon Lorg/jetbrains/compose/resources/DrawableResource;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;->trailingIconTint Landroidx/compose/ui/graphics/Color;
    iget-object v5, v5, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;->trailingIconTint Landroidx/compose/ui/graphics/Color;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getIcon()org.jetbrains.compose.resources.DrawableResource
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;->icon Lorg/jetbrains/compose/resources/DrawableResource;
    return-object v0
.end method

.method public final getIconTint-QN2ZGVo()androidx.compose.ui.graphics.Color
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;->iconTint Landroidx/compose/ui/graphics/Color;
    return-object v0
.end method

.method public final getKey()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;->key Ljava/lang/String;
    return-object v0
.end method

.method public final getOnClick()kotlin.jvm.functions.Function0
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;->onClick Lkotlin/jvm/functions/Function0;
    return-object v0
.end method

.method public final getText()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;->text Ljava/lang/String;
    return-object v0
.end method

.method public final getTextColor-QN2ZGVo()androidx.compose.ui.graphics.Color
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;->textColor Landroidx/compose/ui/graphics/Color;
    return-object v0
.end method

.method public final getTrailingIcon()org.jetbrains.compose.resources.DrawableResource
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;->trailingIcon Lorg/jetbrains/compose/resources/DrawableResource;
    return-object v0
.end method

.method public final getTrailingIconTint-QN2ZGVo()androidx.compose.ui.graphics.Color
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;->trailingIconTint Landroidx/compose/ui/graphics/Color;
    return-object v0
.end method

.method public hashCode()int
    .registers 6
    # ins_size=1
    iget-object v0, v5, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;->key Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;->text Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;->onClick Lkotlin/jvm/functions/Function0;
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;->icon Lorg/jetbrains/compose/resources/DrawableResource;
    const/4 v2, 0
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Lorg/jetbrains/compose/resources/DrawableResource;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;->textColor Landroidx/compose/ui/graphics/Color;
    if-nez v1, +004h
    move v1, v2
    goto +9h
    invoke-virtual v1, Landroidx/compose/ui/graphics/Color;->unbox-impl()J
    move-result-wide v3
    invoke-static v3, v4, Landroidx/compose/ui/graphics/Color;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;->iconTint Landroidx/compose/ui/graphics/Color;
    if-nez v1, +004h
    move v1, v2
    goto +9h
    invoke-virtual v1, Landroidx/compose/ui/graphics/Color;->unbox-impl()J
    move-result-wide v3
    invoke-static v3, v4, Landroidx/compose/ui/graphics/Color;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;->trailingIcon Lorg/jetbrains/compose/resources/DrawableResource;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Lorg/jetbrains/compose/resources/DrawableResource;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v5, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;->trailingIconTint Landroidx/compose/ui/graphics/Color;
    if-nez v1, +003h
    goto +9h
    invoke-virtual v1, Landroidx/compose/ui/graphics/Color;->unbox-impl()J
    move-result-wide v1
    invoke-static v1, v2, Landroidx/compose/ui/graphics/Color;->hashCode-impl(J)I
    move-result v2
    add-int/2addr v0, v2
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "TraeContextMenuItem(key="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;->key Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", text="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;->text Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", onClick="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;->onClick Lkotlin/jvm/functions/Function0;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", icon="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;->icon Lorg/jetbrains/compose/resources/DrawableResource;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", textColor="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;->textColor Landroidx/compose/ui/graphics/Color;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", iconTint="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;->iconTint Landroidx/compose/ui/graphics/Color;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", trailingIcon="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;->trailingIcon Lorg/jetbrains/compose/resources/DrawableResource;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", trailingIconTint="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;->trailingIconTint Landroidx/compose/ui/graphics/Color;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
