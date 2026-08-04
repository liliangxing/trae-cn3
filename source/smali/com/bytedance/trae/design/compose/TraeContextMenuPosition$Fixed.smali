# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/design/compose/TraeContextMenuPosition$Fixed;
.super Ljava/lang/Object;
.source "TraeContextMenuPopup.kt"

.implements Lcom/bytedance/trae/design/compose/TraeContextMenuPosition;

.field public static final $stable:I
.field private final x:F
.field private final y:F


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method private constructor <init>(float  float)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput v1, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuPosition$Fixed;->x F
    iput v2, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuPosition$Fixed;->y F
    return-void 
.end method

.method public synthetic constructor <init>(float  float  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 4
    # ins_size=4
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/design/compose/TraeContextMenuPosition$Fixed;-><init>(F F)V
    return-void 
.end method

.method public static synthetic copy-YgX7TsA$default(com.bytedance.trae.design.compose.TraeContextMenuPosition$Fixed  float  float  int  java.lang.Object)com.bytedance.trae.design.compose.TraeContextMenuPosition$Fixed
    .registers 5
    # ins_size=5
    and-int/lit8 v4, v3, 1
    if-eqz v4, +004h
    iget v1, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuPosition$Fixed;->x F
    and-int/lit8 v3, v3, 2
    if-eqz v3, +004h
    iget v2, v0, Lcom/bytedance/trae/design/compose/TraeContextMenuPosition$Fixed;->y F
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/design/compose/TraeContextMenuPosition$Fixed;->copy-YgX7TsA(F F)Lcom/bytedance/trae/design/compose/TraeContextMenuPosition$Fixed;
    move-result-object v0
    return-object v0
.end method

.method public final component1-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeContextMenuPosition$Fixed;->x F
    return v0
.end method

.method public final component2-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeContextMenuPosition$Fixed;->y F
    return v0
.end method

.method public final copy-YgX7TsA(float  float)com.bytedance.trae.design.compose.TraeContextMenuPosition$Fixed
    .registers 5
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/design/compose/TraeContextMenuPosition$Fixed;
    const/4 v1, 0
    invoke-direct v0, v3, v4, v1, Lcom/bytedance/trae/design/compose/TraeContextMenuPosition$Fixed;-><init>(F F Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/design/compose/TraeContextMenuPosition$Fixed;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/design/compose/TraeContextMenuPosition$Fixed;
    iget v1, v4, Lcom/bytedance/trae/design/compose/TraeContextMenuPosition$Fixed;->x F
    iget v3, v5, Lcom/bytedance/trae/design/compose/TraeContextMenuPosition$Fixed;->x F
    invoke-static v1, v3, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/design/compose/TraeContextMenuPosition$Fixed;->y F
    iget v5, v5, Lcom/bytedance/trae/design/compose/TraeContextMenuPosition$Fixed;->y F
    invoke-static v1, v5, Landroidx/compose/ui/unit/Dp;->equals-impl0(F F)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getX-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeContextMenuPosition$Fixed;->x F
    return v0
.end method

.method public final getY-D9Ej5fM()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/design/compose/TraeContextMenuPosition$Fixed;->y F
    return v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget v0, v2, Lcom/bytedance/trae/design/compose/TraeContextMenuPosition$Fixed;->x F
    invoke-static v0, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/design/compose/TraeContextMenuPosition$Fixed;->y F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->hashCode-impl(F)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "Fixed(x="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget v1, v2, Lcom/bytedance/trae/design/compose/TraeContextMenuPosition$Fixed;->x F
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->toString-impl(F)Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", y="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/design/compose/TraeContextMenuPosition$Fixed;->y F
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
