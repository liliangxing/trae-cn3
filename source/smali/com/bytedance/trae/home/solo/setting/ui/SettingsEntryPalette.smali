# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;
.super Ljava/lang/Object;
.source "SettingsScaffold.kt"

.field public static final $stable:I
.field private final background:J
.field private final badgeBackground:J
.field private final badgeText:J
.field private final divider:J
.field private final editButtonBackground:J
.field private final enterpriseBadgeBackground:J
.field private final enterpriseBadgeText:J
.field private final freeBadgeBackground:J
.field private final freeBadgeText:J
.field private final iconDefault:J
.field private final iconTertiary:J
.field private final logoBackground:J
.field private final primaryText:J
.field private final surface:J
.field private final tertiaryText:J
.field private final unreadBadgeBackground:J
.field private final unreadBadgeText:J
.field private final upgradeButtonBackground:J
.field private final upgradeButtonText:J


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method private constructor <init>(long  long  long  long  long  long  long  long  long  long  long  long  long  long  long  long  long  long  long)void
    .registers 42
    # ins_size=39
    move-object v0, v3
    invoke-direct v3, Ljava/lang/Object;-><init>()V
    move-wide v1, v4
    iput-wide v1, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->background J
    move-wide v1, v6
    iput-wide v1, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->surface J
    move-wide v1, v8
    iput-wide v1, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->primaryText J
    move-wide v1, v10
    iput-wide v1, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->tertiaryText J
    move-wide v1, v12
    iput-wide v1, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->badgeBackground J
    move-wide v1, v14
    iput-wide v1, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->badgeText J
    move-wide/from16 v1, v16
    iput-wide v1, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->freeBadgeBackground J
    move-wide/from16 v1, v18
    iput-wide v1, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->freeBadgeText J
    move-wide/from16 v1, v20
    iput-wide v1, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->enterpriseBadgeBackground J
    move-wide/from16 v1, v22
    iput-wide v1, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->enterpriseBadgeText J
    move-wide/from16 v1, v24
    iput-wide v1, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->upgradeButtonBackground J
    move-wide/from16 v1, v26
    iput-wide v1, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->upgradeButtonText J
    move-wide/from16 v1, v28
    iput-wide v1, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->unreadBadgeBackground J
    move-wide/from16 v1, v30
    iput-wide v1, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->unreadBadgeText J
    move-wide/from16 v1, v32
    iput-wide v1, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->editButtonBackground J
    move-wide/from16 v1, v34
    iput-wide v1, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->iconDefault J
    move-wide/from16 v1, v36
    iput-wide v1, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->iconTertiary J
    move-wide/from16 v1, v38
    iput-wide v1, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->divider J
    move-wide/from16 v1, v40
    iput-wide v1, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->logoBackground J
    return-void 
.end method

.method public synthetic constructor <init>(long  long  long  long  long  long  long  long  long  long  long  long  long  long  long  long  long  long  long  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 40
    # ins_size=40
    invoke-direct/range v0 ... v38, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;-><init>(J J J J J J J J J J J J J J J J J J J)V
    return-void 
.end method

.method public static synthetic copy-USMLqHw$default(com.bytedance.trae.home.solo.setting.ui.SettingsEntryPalette  long  long  long  long  long  long  long  long  long  long  long  long  long  long  long  long  long  long  long  int  java.lang.Object)com.bytedance.trae.home.solo.setting.ui.SettingsEntryPalette
    .registers 58
    # ins_size=41
    move-object/from16 v0, v17
    move/from16 v1, v56
    and-int/lit8 v2, v1, 1
    if-eqz v2, +005h
    iget-wide v2, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->background J
    goto +3h
    move-wide/from16 v2, v18
    and-int/lit8 v4, v1, 2
    if-eqz v4, +005h
    iget-wide v4, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->surface J
    goto +3h
    move-wide/from16 v4, v20
    and-int/lit8 v6, v1, 4
    if-eqz v6, +005h
    iget-wide v6, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->primaryText J
    goto +3h
    move-wide/from16 v6, v22
    and-int/lit8 v8, v1, 8
    if-eqz v8, +005h
    iget-wide v8, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->tertiaryText J
    goto +3h
    move-wide/from16 v8, v24
    and-int/lit8 v10, v1, 16
    if-eqz v10, +005h
    iget-wide v10, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->badgeBackground J
    goto +3h
    move-wide/from16 v10, v26
    and-int/lit8 v12, v1, 32
    if-eqz v12, +005h
    iget-wide v12, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->badgeText J
    goto +3h
    move-wide/from16 v12, v28
    and-int/lit8 v14, v1, 64
    if-eqz v14, +005h
    iget-wide v14, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->freeBadgeBackground J
    goto +3h
    move-wide/from16 v14, v30
    move-wide/from16 v30, v14
    and-int/lit16 v14, v1, 128
    if-eqz v14, +005h
    iget-wide v14, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->freeBadgeText J
    goto +3h
    move-wide/from16 v14, v32
    move-wide/from16 v32, v14
    and-int/lit16 v14, v1, 256
    if-eqz v14, +005h
    iget-wide v14, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->enterpriseBadgeBackground J
    goto +3h
    move-wide/from16 v14, v34
    move-wide/from16 v34, v14
    and-int/lit16 v14, v1, 512
    if-eqz v14, +005h
    iget-wide v14, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->enterpriseBadgeText J
    goto +3h
    move-wide/from16 v14, v36
    move-wide/from16 v36, v14
    and-int/lit16 v14, v1, 1024
    if-eqz v14, +005h
    iget-wide v14, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->upgradeButtonBackground J
    goto +3h
    move-wide/from16 v14, v38
    move-wide/from16 v38, v14
    and-int/lit16 v14, v1, 2048
    if-eqz v14, +005h
    iget-wide v14, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->upgradeButtonText J
    goto +3h
    move-wide/from16 v14, v40
    move-wide/from16 v40, v14
    and-int/lit16 v14, v1, 4096
    if-eqz v14, +005h
    iget-wide v14, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->unreadBadgeBackground J
    goto +3h
    move-wide/from16 v14, v42
    move-wide/from16 v42, v14
    and-int/lit16 v14, v1, 8192
    if-eqz v14, +005h
    iget-wide v14, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->unreadBadgeText J
    goto +3h
    move-wide/from16 v14, v44
    move-wide/from16 v44, v14
    and-int/lit16 v14, v1, 16384
    if-eqz v14, +005h
    iget-wide v14, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->editButtonBackground J
    goto +3h
    move-wide/from16 v14, v46
    const v16, 32768
    and-int v16, v1, v16
    move-wide/from16 v46, v14
    if-eqz v16, +005h
    iget-wide v14, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->iconDefault J
    goto +3h
    move-wide/from16 v14, v48
    const/high16 v16, 65536
    and-int v16, v1, v16
    move-wide/from16 v48, v14
    if-eqz v16, +005h
    iget-wide v14, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->iconTertiary J
    goto +3h
    move-wide/from16 v14, v50
    const/high16 v16, 131072
    and-int v16, v1, v16
    move-wide/from16 v50, v14
    if-eqz v16, +005h
    iget-wide v14, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->divider J
    goto +3h
    move-wide/from16 v14, v52
    const/high16 v16, 262144
    and-int v1, v1, v16
    move-wide/from16 v52, v14
    if-eqz v1, +005h
    iget-wide v14, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->logoBackground J
    goto +3h
    move-wide/from16 v14, v54
    move-wide/from16 v18, v2
    move-wide/from16 v20, v4
    move-wide/from16 v22, v6
    move-wide/from16 v24, v8
    move-wide/from16 v26, v10
    move-wide/from16 v28, v12
    move-wide/from16 v54, v14
    invoke-virtual/range v17 ... v55, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->copy-USMLqHw(J J J J J J J J J J J J J J J J J J J)Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;
    move-result-object v0
    return-object v0
.end method

.method public final component1-0d7_KjU()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->background J
    return-wide v0
.end method

.method public final component10-0d7_KjU()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->enterpriseBadgeText J
    return-wide v0
.end method

.method public final component11-0d7_KjU()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->upgradeButtonBackground J
    return-wide v0
.end method

.method public final component12-0d7_KjU()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->upgradeButtonText J
    return-wide v0
.end method

.method public final component13-0d7_KjU()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->unreadBadgeBackground J
    return-wide v0
.end method

.method public final component14-0d7_KjU()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->unreadBadgeText J
    return-wide v0
.end method

.method public final component15-0d7_KjU()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->editButtonBackground J
    return-wide v0
.end method

.method public final component16-0d7_KjU()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->iconDefault J
    return-wide v0
.end method

.method public final component17-0d7_KjU()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->iconTertiary J
    return-wide v0
.end method

.method public final component18-0d7_KjU()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->divider J
    return-wide v0
.end method

.method public final component19-0d7_KjU()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->logoBackground J
    return-wide v0
.end method

.method public final component2-0d7_KjU()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->surface J
    return-wide v0
.end method

.method public final component3-0d7_KjU()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->primaryText J
    return-wide v0
.end method

.method public final component4-0d7_KjU()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->tertiaryText J
    return-wide v0
.end method

.method public final component5-0d7_KjU()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->badgeBackground J
    return-wide v0
.end method

.method public final component6-0d7_KjU()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->badgeText J
    return-wide v0
.end method

.method public final component7-0d7_KjU()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->freeBadgeBackground J
    return-wide v0
.end method

.method public final component8-0d7_KjU()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->freeBadgeText J
    return-wide v0
.end method

.method public final component9-0d7_KjU()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->enterpriseBadgeBackground J
    return-wide v0
.end method

.method public final copy-USMLqHw(long  long  long  long  long  long  long  long  long  long  long  long  long  long  long  long  long  long  long)com.bytedance.trae.home.solo.setting.ui.SettingsEntryPalette
    .registers 80
    # ins_size=39
    move-wide/from16 v1, v42
    move-wide/from16 v3, v44
    move-wide/from16 v5, v46
    move-wide/from16 v7, v48
    move-wide/from16 v9, v50
    move-wide/from16 v11, v52
    move-wide/from16 v13, v54
    move-wide/from16 v15, v56
    move-wide/from16 v17, v58
    move-wide/from16 v19, v60
    move-wide/from16 v21, v62
    move-wide/from16 v23, v64
    move-wide/from16 v25, v66
    move-wide/from16 v27, v68
    move-wide/from16 v29, v70
    move-wide/from16 v31, v72
    move-wide/from16 v33, v74
    move-wide/from16 v35, v76
    move-wide/from16 v37, v78
    new-instance v40, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;
    move-object/from16 v0, v40
    const/16 v39, 0
    invoke-direct/range v0 ... v39, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;-><init>(J J J J J J J J J J J J J J J J J J J Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v40
.end method

.method public equals(java.lang.Object)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 1
    if-ne v7, v8, +003h
    return v0
    instance-of v1, v8, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v8, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;
    iget-wide v3, v7, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->background J
    iget-wide v5, v8, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->background J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/graphics/Color;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->surface J
    iget-wide v5, v8, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->surface J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/graphics/Color;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->primaryText J
    iget-wide v5, v8, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->primaryText J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/graphics/Color;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->tertiaryText J
    iget-wide v5, v8, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->tertiaryText J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/graphics/Color;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->badgeBackground J
    iget-wide v5, v8, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->badgeBackground J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/graphics/Color;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->badgeText J
    iget-wide v5, v8, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->badgeText J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/graphics/Color;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->freeBadgeBackground J
    iget-wide v5, v8, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->freeBadgeBackground J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/graphics/Color;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->freeBadgeText J
    iget-wide v5, v8, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->freeBadgeText J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/graphics/Color;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->enterpriseBadgeBackground J
    iget-wide v5, v8, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->enterpriseBadgeBackground J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/graphics/Color;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->enterpriseBadgeText J
    iget-wide v5, v8, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->enterpriseBadgeText J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/graphics/Color;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->upgradeButtonBackground J
    iget-wide v5, v8, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->upgradeButtonBackground J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/graphics/Color;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->upgradeButtonText J
    iget-wide v5, v8, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->upgradeButtonText J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/graphics/Color;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->unreadBadgeBackground J
    iget-wide v5, v8, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->unreadBadgeBackground J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/graphics/Color;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->unreadBadgeText J
    iget-wide v5, v8, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->unreadBadgeText J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/graphics/Color;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->editButtonBackground J
    iget-wide v5, v8, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->editButtonBackground J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/graphics/Color;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->iconDefault J
    iget-wide v5, v8, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->iconDefault J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/graphics/Color;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->iconTertiary J
    iget-wide v5, v8, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->iconTertiary J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/graphics/Color;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->divider J
    iget-wide v5, v8, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->divider J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/graphics/Color;->equals-impl0(J J)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->logoBackground J
    iget-wide v5, v8, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->logoBackground J
    invoke-static v3, v4, v5, v6, Landroidx/compose/ui/graphics/Color;->equals-impl0(J J)Z
    move-result v8
    if-nez v8, +003h
    return v2
    return v0
.end method

.method public final getBackground-0d7_KjU()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->background J
    return-wide v0
.end method

.method public final getBadgeBackground-0d7_KjU()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->badgeBackground J
    return-wide v0
.end method

.method public final getBadgeText-0d7_KjU()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->badgeText J
    return-wide v0
.end method

.method public final getDivider-0d7_KjU()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->divider J
    return-wide v0
.end method

.method public final getEditButtonBackground-0d7_KjU()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->editButtonBackground J
    return-wide v0
.end method

.method public final getEnterpriseBadgeBackground-0d7_KjU()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->enterpriseBadgeBackground J
    return-wide v0
.end method

.method public final getEnterpriseBadgeText-0d7_KjU()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->enterpriseBadgeText J
    return-wide v0
.end method

.method public final getFreeBadgeBackground-0d7_KjU()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->freeBadgeBackground J
    return-wide v0
.end method

.method public final getFreeBadgeText-0d7_KjU()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->freeBadgeText J
    return-wide v0
.end method

.method public final getIconDefault-0d7_KjU()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->iconDefault J
    return-wide v0
.end method

.method public final getIconTertiary-0d7_KjU()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->iconTertiary J
    return-wide v0
.end method

.method public final getLogoBackground-0d7_KjU()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->logoBackground J
    return-wide v0
.end method

.method public final getPrimaryText-0d7_KjU()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->primaryText J
    return-wide v0
.end method

.method public final getSurface-0d7_KjU()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->surface J
    return-wide v0
.end method

.method public final getTertiaryText-0d7_KjU()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->tertiaryText J
    return-wide v0
.end method

.method public final getUnreadBadgeBackground-0d7_KjU()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->unreadBadgeBackground J
    return-wide v0
.end method

.method public final getUnreadBadgeText-0d7_KjU()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->unreadBadgeText J
    return-wide v0
.end method

.method public final getUpgradeButtonBackground-0d7_KjU()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->upgradeButtonBackground J
    return-wide v0
.end method

.method public final getUpgradeButtonText-0d7_KjU()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->upgradeButtonText J
    return-wide v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-wide v0, v3, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->background J
    invoke-static v0, v1, Landroidx/compose/ui/graphics/Color;->hashCode-impl(J)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->surface J
    invoke-static v1, v2, Landroidx/compose/ui/graphics/Color;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->primaryText J
    invoke-static v1, v2, Landroidx/compose/ui/graphics/Color;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->tertiaryText J
    invoke-static v1, v2, Landroidx/compose/ui/graphics/Color;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->badgeBackground J
    invoke-static v1, v2, Landroidx/compose/ui/graphics/Color;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->badgeText J
    invoke-static v1, v2, Landroidx/compose/ui/graphics/Color;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->freeBadgeBackground J
    invoke-static v1, v2, Landroidx/compose/ui/graphics/Color;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->freeBadgeText J
    invoke-static v1, v2, Landroidx/compose/ui/graphics/Color;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->enterpriseBadgeBackground J
    invoke-static v1, v2, Landroidx/compose/ui/graphics/Color;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->enterpriseBadgeText J
    invoke-static v1, v2, Landroidx/compose/ui/graphics/Color;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->upgradeButtonBackground J
    invoke-static v1, v2, Landroidx/compose/ui/graphics/Color;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->upgradeButtonText J
    invoke-static v1, v2, Landroidx/compose/ui/graphics/Color;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->unreadBadgeBackground J
    invoke-static v1, v2, Landroidx/compose/ui/graphics/Color;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->unreadBadgeText J
    invoke-static v1, v2, Landroidx/compose/ui/graphics/Color;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->editButtonBackground J
    invoke-static v1, v2, Landroidx/compose/ui/graphics/Color;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->iconDefault J
    invoke-static v1, v2, Landroidx/compose/ui/graphics/Color;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->iconTertiary J
    invoke-static v1, v2, Landroidx/compose/ui/graphics/Color;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->divider J
    invoke-static v1, v2, Landroidx/compose/ui/graphics/Color;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->logoBackground J
    invoke-static v1, v2, Landroidx/compose/ui/graphics/Color;->hashCode-impl(J)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 5
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "SettingsEntryPalette(background="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-wide v1, v4, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->background J
    invoke-static v1, v2, Landroidx/compose/ui/graphics/Color;->toString-impl(J)Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", surface="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->surface J
    invoke-static v2, v3, Landroidx/compose/ui/graphics/Color;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", primaryText="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->primaryText J
    invoke-static v2, v3, Landroidx/compose/ui/graphics/Color;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", tertiaryText="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->tertiaryText J
    invoke-static v2, v3, Landroidx/compose/ui/graphics/Color;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", badgeBackground="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->badgeBackground J
    invoke-static v2, v3, Landroidx/compose/ui/graphics/Color;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", badgeText="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->badgeText J
    invoke-static v2, v3, Landroidx/compose/ui/graphics/Color;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", freeBadgeBackground="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->freeBadgeBackground J
    invoke-static v2, v3, Landroidx/compose/ui/graphics/Color;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", freeBadgeText="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->freeBadgeText J
    invoke-static v2, v3, Landroidx/compose/ui/graphics/Color;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", enterpriseBadgeBackground="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->enterpriseBadgeBackground J
    invoke-static v2, v3, Landroidx/compose/ui/graphics/Color;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", enterpriseBadgeText="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->enterpriseBadgeText J
    invoke-static v2, v3, Landroidx/compose/ui/graphics/Color;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", upgradeButtonBackground="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->upgradeButtonBackground J
    invoke-static v2, v3, Landroidx/compose/ui/graphics/Color;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", upgradeButtonText="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    iget-wide v1, v4, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->upgradeButtonText J
    invoke-static v1, v2, Landroidx/compose/ui/graphics/Color;->toString-impl(J)Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", unreadBadgeBackground="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->unreadBadgeBackground J
    invoke-static v2, v3, Landroidx/compose/ui/graphics/Color;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", unreadBadgeText="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->unreadBadgeText J
    invoke-static v2, v3, Landroidx/compose/ui/graphics/Color;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", editButtonBackground="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->editButtonBackground J
    invoke-static v2, v3, Landroidx/compose/ui/graphics/Color;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", iconDefault="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->iconDefault J
    invoke-static v2, v3, Landroidx/compose/ui/graphics/Color;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", iconTertiary="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->iconTertiary J
    invoke-static v2, v3, Landroidx/compose/ui/graphics/Color;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", divider="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->divider J
    invoke-static v2, v3, Landroidx/compose/ui/graphics/Color;->toString-impl(J)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", logoBackground="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-wide v2, v4, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->logoBackground J
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
