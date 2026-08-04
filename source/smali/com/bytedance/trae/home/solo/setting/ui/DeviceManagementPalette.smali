# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;
.super Ljava/lang/Object;
.source "DeviceManagement.kt"

.field public static final $stable:I
.field private final background:J
.field private final deleteActionBackground:J
.field private final deleteText:J
.field private final divider:J
.field private final iconContainerBorder:J
.field private final iconDefault:J
.field private final offlineBackground:J
.field private final offlineText:J
.field private final onlineBackground:J
.field private final onlineText:J
.field private final primaryButtonBackground:J
.field private final primaryButtonText:J
.field private final primaryText:J
.field private final renameActionBackground:J
.field private final surface:J
.field private final tertiaryText:J


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method private constructor <init>(long  long  long  long  long  long  long  long  long  long  long  long  long  long  long  long)void
    .registers 36
    # ins_size=33
    move-object v0, v3
    invoke-direct v3, Ljava/lang/Object;-><init>()V
    move-wide v1, v4
    iput-wide v1, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->background J
    move-wide v1, v6
    iput-wide v1, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->surface J
    move-wide v1, v8
    iput-wide v1, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->primaryText J
    move-wide v1, v10
    iput-wide v1, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->tertiaryText J
    move-wide v1, v12
    iput-wide v1, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->divider J
    move-wide v1, v14
    iput-wide v1, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->iconDefault J
    move-wide/from16 v1, v16
    iput-wide v1, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->iconContainerBorder J
    move-wide/from16 v1, v18
    iput-wide v1, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->onlineBackground J
    move-wide/from16 v1, v20
    iput-wide v1, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->onlineText J
    move-wide/from16 v1, v22
    iput-wide v1, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->offlineBackground J
    move-wide/from16 v1, v24
    iput-wide v1, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->offlineText J
    move-wide/from16 v1, v26
    iput-wide v1, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->primaryButtonBackground J
    move-wide/from16 v1, v28
    iput-wide v1, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->primaryButtonText J
    move-wide/from16 v1, v30
    iput-wide v1, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->renameActionBackground J
    move-wide/from16 v1, v32
    iput-wide v1, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->deleteActionBackground J
    move-wide/from16 v1, v34
    iput-wide v1, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->deleteText J
    return-void 
.end method

.method public synthetic constructor <init>(long  long  long  long  long  long  long  long  long  long  long  long  long  long  long  long  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 34
    # ins_size=34
    invoke-direct/range v0 ... v32, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;-><init>(J J J J J J J J J J J J J J J J)V
    return-void 
.end method

.method public static synthetic copy-Q_H9qLU$default(com.bytedance.trae.home.solo.setting.ui.DeviceManagementPalette  long  long  long  long  long  long  long  long  long  long  long  long  long  long  long  long  int  java.lang.Object)com.bytedance.trae.home.solo.setting.ui.DeviceManagementPalette
    .registers 52
    # ins_size=35
    move-object/from16 v0, v17
    move/from16 v1, v50
    and-int/lit8 v2, v1, 1
    if-eqz v2, +005h
    iget-wide v2, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->background J
    goto +3h
    move-wide/from16 v2, v18
    and-int/lit8 v4, v1, 2
    if-eqz v4, +005h
    iget-wide v4, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->surface J
    goto +3h
    move-wide/from16 v4, v20
    and-int/lit8 v6, v1, 4
    if-eqz v6, +005h
    iget-wide v6, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->primaryText J
    goto +3h
    move-wide/from16 v6, v22
    and-int/lit8 v8, v1, 8
    if-eqz v8, +005h
    iget-wide v8, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->tertiaryText J
    goto +3h
    move-wide/from16 v8, v24
    and-int/lit8 v10, v1, 16
    if-eqz v10, +005h
    iget-wide v10, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->divider J
    goto +3h
    move-wide/from16 v10, v26
    and-int/lit8 v12, v1, 32
    if-eqz v12, +005h
    iget-wide v12, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->iconDefault J
    goto +3h
    move-wide/from16 v12, v28
    and-int/lit8 v14, v1, 64
    if-eqz v14, +005h
    iget-wide v14, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->iconContainerBorder J
    goto +3h
    move-wide/from16 v14, v30
    move-wide/from16 v30, v14
    and-int/lit16 v14, v1, 128
    if-eqz v14, +005h
    iget-wide v14, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->onlineBackground J
    goto +3h
    move-wide/from16 v14, v32
    move-wide/from16 v32, v14
    and-int/lit16 v14, v1, 256
    if-eqz v14, +005h
    iget-wide v14, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->onlineText J
    goto +3h
    move-wide/from16 v14, v34
    move-wide/from16 v34, v14
    and-int/lit16 v14, v1, 512
    if-eqz v14, +005h
    iget-wide v14, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->offlineBackground J
    goto +3h
    move-wide/from16 v14, v36
    move-wide/from16 v36, v14
    and-int/lit16 v14, v1, 1024
    if-eqz v14, +005h
    iget-wide v14, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->offlineText J
    goto +3h
    move-wide/from16 v14, v38
    move-wide/from16 v38, v14
    and-int/lit16 v14, v1, 2048
    if-eqz v14, +005h
    iget-wide v14, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->primaryButtonBackground J
    goto +3h
    move-wide/from16 v14, v40
    move-wide/from16 v40, v14
    and-int/lit16 v14, v1, 4096
    if-eqz v14, +005h
    iget-wide v14, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->primaryButtonText J
    goto +3h
    move-wide/from16 v14, v42
    move-wide/from16 v42, v14
    and-int/lit16 v14, v1, 8192
    if-eqz v14, +005h
    iget-wide v14, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->renameActionBackground J
    goto +3h
    move-wide/from16 v14, v44
    move-wide/from16 v44, v14
    and-int/lit16 v14, v1, 16384
    if-eqz v14, +005h
    iget-wide v14, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->deleteActionBackground J
    goto +3h
    move-wide/from16 v14, v46
    const v16, 32768
    and-int v1, v1, v16
    move-wide/from16 v46, v14
    if-eqz v1, +005h
    iget-wide v14, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->deleteText J
    goto +3h
    move-wide/from16 v14, v48
    move-wide/from16 v18, v2
    move-wide/from16 v20, v4
    move-wide/from16 v22, v6
    move-wide/from16 v24, v8
    move-wide/from16 v26, v10
    move-wide/from16 v28, v12
    move-wide/from16 v48, v14
    invoke-virtual/range v17 ... v49, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->copy-Q_H9qLU(J J J J J J J J J J J J J J J J)Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;
    move-result-object v0
    return-object v0
.end method

.method public final component1-0d7_KjU()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->background J
    return-wide v0
.end method

.method public final component10-0d7_KjU()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->offlineBackground J
    return-wide v0
.end method

.method public final component11-0d7_KjU()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->offlineText J
    return-wide v0
.end method

.method public final component12-0d7_KjU()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->primaryButtonBackground J
    return-wide v0
.end method

.method public final component13-0d7_KjU()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->primaryButtonText J
    return-wide v0
.end method

.method public final component14-0d7_KjU()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->renameActionBackground J
    return-wide v0
.end method

.method public final component15-0d7_KjU()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->deleteActionBackground J
    return-wide v0
.end method

.method public final component16-0d7_KjU()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->deleteText J
    return-wide v0
.end method

.method public final component2-0d7_KjU()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->surface J
    return-wide v0
.end method

.method public final component3-0d7_KjU()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->primaryText J
    return-wide v0
.end method

.method public final component4-0d7_KjU()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->tertiaryText J
    return-wide v0
.end method

.method public final component5-0d7_KjU()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->divider J
    return-wide v0
.end method

.method public final component6-0d7_KjU()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->iconDefault J
    return-wide v0
.end method

.method public final component7-0d7_KjU()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->iconContainerBorder J
    return-wide v0
.end method

.method public final component8-0d7_KjU()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->onlineBackground J
    return-wide v0
.end method

.method public final component9-0d7_KjU()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->onlineText J
    return-wide v0
.end method

.method public final copy-Q_H9qLU(long  long  long  long  long  long  long  long  long  long  long  long  long  long  long  long)com.bytedance.trae.home.solo.setting.ui.DeviceManagementPalette
    .registers 68
    # ins_size=33
    move-wide/from16 v1, v36
    move-wide/from16 v3, v38
    move-wide/from16 v5, v40
    move-wide/from16 v7, v42
    move-wide/from16 v9, v44
    move-wide/from16 v11, v46
    move-wide/from16 v13, v48
    move-wide/from16 v15, v50
    move-wide/from16 v17, v52
    move-wide/from16 v19, v54
    move-wide/from16 v21, v56
    move-wide/from16 v23, v58
    move-wide/from16 v25, v60
    move-wide/from16 v27, v62
    move-wide/from16 v29, v64
    move-wide/from16 v31, v66
    new-instance v34, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;
    move-object/from16 v0, v34
    const/16 v33, 0
    invoke-direct/range v0 ... v33, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;-><init>(J J J J J J J J J J J J J J J J Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v34
.end method

.method public equals(java.lang.Object)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 1
    if-ne v7, v8, +003h
    return v0
    instance-of v1, v8, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v8, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;
    iget-wide v3, v7, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->background J
    iget-wide v5, v8, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->background J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/graphics/Color;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->surface J
    iget-wide v5, v8, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->surface J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/graphics/Color;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->primaryText J
    iget-wide v5, v8, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->primaryText J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/graphics/Color;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->tertiaryText J
    iget-wide v5, v8, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->tertiaryText J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/graphics/Color;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->divider J
    iget-wide v5, v8, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->divider J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/graphics/Color;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->iconDefault J
    iget-wide v5, v8, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->iconDefault J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/graphics/Color;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->iconContainerBorder J
    iget-wide v5, v8, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->iconContainerBorder J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/graphics/Color;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->onlineBackground J
    iget-wide v5, v8, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->onlineBackground J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/graphics/Color;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->onlineText J
    iget-wide v5, v8, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->onlineText J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/graphics/Color;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->offlineBackground J
    iget-wide v5, v8, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->offlineBackground J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/graphics/Color;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->offlineText J
    iget-wide v5, v8, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->offlineText J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/graphics/Color;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->primaryButtonBackground J
    iget-wide v5, v8, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->primaryButtonBackground J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/graphics/Color;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->primaryButtonText J
    iget-wide v5, v8, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->primaryButtonText J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/graphics/Color;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->renameActionBackground J
    iget-wide v5, v8, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->renameActionBackground J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/graphics/Color;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->deleteActionBackground J
    iget-wide v5, v8, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->deleteActionBackground J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/graphics/Color;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->deleteText J
    iget-wide v5, v8, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->deleteText J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/graphics/Color;->equals-impl0(J J)Z
    move-result v8
    if-nez v8, +003h
    return v2
    return v0
.end method

.method public final getBackground-0d7_KjU()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->background J
    return-wide v0
.end method

.method public final getDeleteActionBackground-0d7_KjU()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->deleteActionBackground J
    return-wide v0
.end method

.method public final getDeleteText-0d7_KjU()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->deleteText J
    return-wide v0
.end method

.method public final getDivider-0d7_KjU()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->divider J
    return-wide v0
.end method

.method public final getIconContainerBorder-0d7_KjU()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->iconContainerBorder J
    return-wide v0
.end method

.method public final getIconDefault-0d7_KjU()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->iconDefault J
    return-wide v0
.end method

.method public final getOfflineBackground-0d7_KjU()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->offlineBackground J
    return-wide v0
.end method

.method public final getOfflineText-0d7_KjU()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->offlineText J
    return-wide v0
.end method

.method public final getOnlineBackground-0d7_KjU()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->onlineBackground J
    return-wide v0
.end method

.method public final getOnlineText-0d7_KjU()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->onlineText J
    return-wide v0
.end method

.method public final getPrimaryButtonBackground-0d7_KjU()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->primaryButtonBackground J
    return-wide v0
.end method

.method public final getPrimaryButtonText-0d7_KjU()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->primaryButtonText J
    return-wide v0
.end method

.method public final getPrimaryText-0d7_KjU()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->primaryText J
    return-wide v0
.end method

.method public final getRenameActionBackground-0d7_KjU()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->renameActionBackground J
    return-wide v0
.end method

.method public final getSurface-0d7_KjU()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->surface J
    return-wide v0
.end method

.method public final getTertiaryText-0d7_KjU()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->tertiaryText J
    return-wide v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-wide v0, v3, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->background J
    invoke-static v0, v1, Landroidx/compose/ui/graphics/Color;->hashCode-impl(J)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->surface J
    invoke-static v1, v2, Landroidx/compose/ui/graphics/Color;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->primaryText J
    invoke-static v1, v2, Landroidx/compose/ui/graphics/Color;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->tertiaryText J
    invoke-static v1, v2, Landroidx/compose/ui/graphics/Color;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->divider J
    invoke-static v1, v2, Landroidx/compose/ui/graphics/Color;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->iconDefault J
    invoke-static v1, v2, Landroidx/compose/ui/graphics/Color;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->iconContainerBorder J
    invoke-static v1, v2, Landroidx/compose/ui/graphics/Color;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->onlineBackground J
    invoke-static v1, v2, Landroidx/compose/ui/graphics/Color;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->onlineText J
    invoke-static v1, v2, Landroidx/compose/ui/graphics/Color;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->offlineBackground J
    invoke-static v1, v2, Landroidx/compose/ui/graphics/Color;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->offlineText J
    invoke-static v1, v2, Landroidx/compose/ui/graphics/Color;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->primaryButtonBackground J
    invoke-static v1, v2, Landroidx/compose/ui/graphics/Color;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->primaryButtonText J
    invoke-static v1, v2, Landroidx/compose/ui/graphics/Color;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->renameActionBackground J
    invoke-static v1, v2, Landroidx/compose/ui/graphics/Color;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->deleteActionBackground J
    invoke-static v1, v2, Landroidx/compose/ui/graphics/Color;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->deleteText J
    invoke-static v1, v2, Landroidx/compose/ui/graphics/Color;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 5
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "DeviceManagementPalette(background="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-wide v1, v4, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->background J
    invoke-static v1, v2, Landroidx/compose/ui/graphics/Color;->toString-impl(J)Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", surface="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->surface J
    invoke-static v2, v3, Landroidx/compose/ui/graphics/Color;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", primaryText="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->primaryText J
    invoke-static v2, v3, Landroidx/compose/ui/graphics/Color;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", tertiaryText="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->tertiaryText J
    invoke-static v2, v3, Landroidx/compose/ui/graphics/Color;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", divider="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->divider J
    invoke-static v2, v3, Landroidx/compose/ui/graphics/Color;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", iconDefault="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->iconDefault J
    invoke-static v2, v3, Landroidx/compose/ui/graphics/Color;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", iconContainerBorder="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->iconContainerBorder J
    invoke-static v2, v3, Landroidx/compose/ui/graphics/Color;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", onlineBackground="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->onlineBackground J
    invoke-static v2, v3, Landroidx/compose/ui/graphics/Color;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", onlineText="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->onlineText J
    invoke-static v2, v3, Landroidx/compose/ui/graphics/Color;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", offlineBackground="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->offlineBackground J
    invoke-static v2, v3, Landroidx/compose/ui/graphics/Color;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", offlineText="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->offlineText J
    invoke-static v2, v3, Landroidx/compose/ui/graphics/Color;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", primaryButtonBackground="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    iget-wide v1, v4, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->primaryButtonBackground J
    invoke-static v1, v2, Landroidx/compose/ui/graphics/Color;->toString-impl(J)Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", primaryButtonText="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->primaryButtonText J
    invoke-static v2, v3, Landroidx/compose/ui/graphics/Color;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", renameActionBackground="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->renameActionBackground J
    invoke-static v2, v3, Landroidx/compose/ui/graphics/Color;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", deleteActionBackground="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->deleteActionBackground J
    invoke-static v2, v3, Landroidx/compose/ui/graphics/Color;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", deleteText="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->deleteText J
    invoke-static v2, v3, Landroidx/compose/ui/graphics/Color;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const/16 v2, 41
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
