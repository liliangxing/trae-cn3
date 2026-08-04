# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/design/compose/TraeContextMenuShadowPadding;
.super Ljava/lang/Object;
.source "TraeContextMenuPopup.kt"

.field public static final $stable:I
.field private final bottom:F
.field private final end:F
.field private final start:F
.field private final top:F


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method private constructor <init>(float  float  float  float)void
    .registers 5
    # ins_size=5
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuShadowPadding;->start F
    iput v2, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuShadowPadding;->top F
    iput v3, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuShadowPadding;->end F
    iput v4, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuShadowPadding;->bottom F
    return-void 
.end method

.method public synthetic constructor <init>(float  float  float  float  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 14
    # ins_size=7
    and-int/lit8 v13, v12, 1
    const/4 v0, 0
    if-eqz v13, +007h
    int-to-float v8, v0
    invoke-static v8, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v8
    move v2, v8
    and-int/lit8 v8, v12, 2
    if-eqz v8, +007h
    int-to-float v8, v0
    invoke-static v8, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v9
    move v3, v9
    and-int/lit8 v8, v12, 4
    if-eqz v8, +007h
    int-to-float v8, v0
    invoke-static v8, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v10
    move v4, v10
    and-int/lit8 v8, v12, 8
    if-eqz v8, +007h
    int-to-float v8, v0
    invoke-static v8, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v11
    move v5, v11
    const/4 v6, 0
    move-object v1, v7
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/design/compose/TraeContextMenuShadowPadding;-><init>(F F F F Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public synthetic constructor <init>(float  float  float  float  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 6
    # ins_size=6
    invoke-direct v0, v1, v2, v3, v4, Lcom/bytedance/trae/design/compose/TraeContextMenuShadowPadding;-><init>(F F F F)V
    return-void 
.end method

.method public static synthetic copy-a9UjIt4$default(com.bytedance.trae.design.compose.TraeContextMenuShadowPadding  float  float  float  float  int  java.lang.Object)com.bytedance.trae.design.compose.TraeContextMenuShadowPadding
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 1
    if-eqz v6, +004h
    iget v1, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuShadowPadding;->start F
    and-int/lit8 v6, v5, 2
    if-eqz v6, +004h
    iget v2, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuShadowPadding;->top F
    and-int/lit8 v6, v5, 4
    if-eqz v6, +004h
    iget v3, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuShadowPadding;->end F
    and-int/lit8 v5, v5, 8
    if-eqz v5, +004h
    iget v4, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuShadowPadding;->bottom F
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/design/compose/TraeContextMenuShadowPadding;->copy-a9UjIt4(F F F F)Lcom/bytedance/trae/design/compose/TraeContextMenuShadowPadding;
    move-result-object v0
    return-object v0
.end method

.method public final component1-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeContextMenuShadowPadding;->start F
    return v0
.end method

.method public final component2-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeContextMenuShadowPadding;->top F
    return v0
.end method

.method public final component3-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeContextMenuShadowPadding;->end F
    return v0
.end method

.method public final component4-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeContextMenuShadowPadding;->bottom F
    return v0
.end method

.method public final copy-a9UjIt4(float  float  float  float)com.bytedance.trae.design.compose.TraeContextMenuShadowPadding
    .registers 12
    # ins_size=5
    new-instance v6, Lcom/bytedance/trae/design/compose/TraeContextMenuShadowPadding;
    const/4 v5, 0
    move-object v0, v6
    move v1, v8
    move v2, v9
    move v3, v10
    move v4, v11
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/design/compose/TraeContextMenuShadowPadding;-><init>(F F F F Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v6
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/design/compose/TraeContextMenuShadowPadding;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/design/compose/TraeContextMenuShadowPadding;
    iget v1, v4, Lcom/bytedance/trae/design/compose/TraeContextMenuShadowPadding;->start F
    iget v3, v5, Lcom/bytedance/trae/design/compose/TraeContextMenuShadowPadding;->start F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/design/compose/TraeContextMenuShadowPadding;->top F
    iget v3, v5, Lcom/bytedance/trae/design/compose/TraeContextMenuShadowPadding;->top F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/design/compose/TraeContextMenuShadowPadding;->end F
    iget v3, v5, Lcom/bytedance/trae/design/compose/TraeContextMenuShadowPadding;->end F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/design/compose/TraeContextMenuShadowPadding;->bottom F
    iget v5, v5, Lcom/bytedance/trae/design/compose/TraeContextMenuShadowPadding;->bottom F
    invoke-static v1, v5, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getBottom-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeContextMenuShadowPadding;->bottom F
    return v0
.end method

.method public final getEnd-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeContextMenuShadowPadding;->end F
    return v0
.end method

.method public final getStart-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeContextMenuShadowPadding;->start F
    return v0
.end method

.method public final getTop-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeContextMenuShadowPadding;->top F
    return v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget v0, v2, Lcom/bytedance/trae/design/compose/TraeContextMenuShadowPadding;->start F
    invoke-static v0, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/design/compose/TraeContextMenuShadowPadding;->top F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/design/compose/TraeContextMenuShadowPadding;->end F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/design/compose/TraeContextMenuShadowPadding;->bottom F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "TraeContextMenuShadowPadding(start="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget v1, v2, Lcom/bytedance/trae/design/compose/TraeContextMenuShadowPadding;->start F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", top="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/design/compose/TraeContextMenuShadowPadding;->top F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", end="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/design/compose/TraeContextMenuShadowPadding;->end F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", bottom="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/design/compose/TraeContextMenuShadowPadding;->bottom F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
