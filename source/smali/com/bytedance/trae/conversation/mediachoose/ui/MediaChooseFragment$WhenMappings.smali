# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$WhenMappings;
.super Ljava/lang/Object;
.source "MediaChooseFragment.kt"

.field public static final synthetic $EnumSwitchMapping$0:[I
.field public static final synthetic $EnumSwitchMapping$1:[I


.method static constructor <clinit>()void
    .registers 6
    # ins_size=0
    invoke-static Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection$ToggleResult;->values()[Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection$ToggleResult;
    move-result-object v0
    array-length v0, v0
    new-array v0, v0, [I
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection$ToggleResult;->ReachMax Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection$ToggleResult;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection$ToggleResult;->ordinal()I
    move-result v2
    aput v1, v0, v2
    const/4 v2, 2
    sget-object v3, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection$ToggleResult;->BlockedByExclusive Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection$ToggleResult;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection$ToggleResult;->ordinal()I
    move-result v3
    aput v2, v0, v3
    const/4 v3, 3
    sget-object v4, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection$ToggleResult;->Added Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection$ToggleResult;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection$ToggleResult;->ordinal()I
    move-result v4
    aput v3, v0, v4
    const/4 v4, 4
    sget-object v5, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection$ToggleResult;->Removed Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection$ToggleResult;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection$ToggleResult;->ordinal()I
    move-result v5
    aput v4, v0, v5
    sput-object v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-static Lcom/bytedance/trae/conversation/mediachoose/model/MediaType;->values()[Lcom/bytedance/trae/conversation/mediachoose/model/MediaType;
    move-result-object v0
    array-length v0, v0
    new-array v0, v0, [I
    sget-object v5, Lcom/bytedance/trae/conversation/mediachoose/model/MediaType;->IMAGE Lcom/bytedance/trae/conversation/mediachoose/model/MediaType;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/mediachoose/model/MediaType;->ordinal()I
    move-result v5
    aput v1, v0, v5
    sget-object v1, Lcom/bytedance/trae/conversation/mediachoose/model/MediaType;->VIDEO Lcom/bytedance/trae/conversation/mediachoose/model/MediaType;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/mediachoose/model/MediaType;->ordinal()I
    move-result v1
    aput v2, v0, v1
    sget-object v1, Lcom/bytedance/trae/conversation/mediachoose/model/MediaType;->ALL Lcom/bytedance/trae/conversation/mediachoose/model/MediaType;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/mediachoose/model/MediaType;->ordinal()I
    move-result v1
    aput v3, v0, v1
    sget-object v1, Lcom/bytedance/trae/conversation/mediachoose/model/MediaType;->ALL_EXCLUSIVE Lcom/bytedance/trae/conversation/mediachoose/model/MediaType;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/mediachoose/model/MediaType;->ordinal()I
    move-result v1
    aput v4, v0, v1
    sput-object v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$WhenMappings;->$EnumSwitchMapping$1 [I
    return-void 
    :try_start_0x8
    :try_start_0x11
    :try_start_0x1a
    :try_start_0x23
    :try_start_0x34
    :try_start_0x3c
    :try_start_0x44
    :try_start_0x4c
.end method
