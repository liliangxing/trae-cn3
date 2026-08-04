# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3$WhenMappings;
.super Ljava/lang/Object;
.source "SettingsEntry.kt"

.field public static final synthetic $EnumSwitchMapping$0:[I
.field public static final synthetic $EnumSwitchMapping$1:[I


.method static constructor <clinit>()void
    .registers 5
    # ins_size=0
    invoke-static Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->values()[Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    move-result-object v0
    array-length v0, v0
    new-array v0, v0, [I
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->Theme Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->ordinal()I
    move-result v2
    aput v1, v0, v2
    const/4 v2, 2
    sget-object v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->Language Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->ordinal()I
    move-result v3
    aput v2, v0, v3
    sget-object v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->About Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->ordinal()I
    move-result v3
    const/4 v4, 3
    aput v4, v0, v3
    sget-object v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->DeviceManagement Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->ordinal()I
    move-result v3
    const/4 v4, 4
    aput v4, v0, v3
    sget-object v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->Logout Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->ordinal()I
    move-result v3
    const/4 v4, 5
    aput v4, v0, v3
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-static Lcom/bytedance/trae/home/solo/setting/ui/SettingsPopupType;->values()[Lcom/bytedance/trae/home/solo/setting/ui/SettingsPopupType;
    move-result-object v0
    array-length v0, v0
    new-array v0, v0, [I
    sget-object v3, Lcom/bytedance/trae/home/solo/setting/ui/SettingsPopupType;->Theme Lcom/bytedance/trae/home/solo/setting/ui/SettingsPopupType;
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/ui/SettingsPopupType;->ordinal()I
    move-result v3
    aput v1, v0, v3
    sget-object v1, Lcom/bytedance/trae/home/solo/setting/ui/SettingsPopupType;->Language Lcom/bytedance/trae/home/solo/setting/ui/SettingsPopupType;
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/ui/SettingsPopupType;->ordinal()I
    move-result v1
    aput v2, v0, v1
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3$WhenMappings;->$EnumSwitchMapping$1 [I
    return-void 
    :try_start_0x8
    :try_start_0x11
    :try_start_0x19
    :try_start_0x22
    :try_start_0x2b
    :try_start_0x3d
    :try_start_0x45
.end method
