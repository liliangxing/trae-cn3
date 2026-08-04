# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideContentPolicy;
.super Ljava/lang/Object;
.source "ConnectComputerGuideContentPolicy.kt"

.field private static final DOWNLOAD_UTM:Ljava/lang/String;
.field public static final INSTANCE:Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideContentPolicy;
.field private static final MAINLAND_DISPLAY_URL:Ljava/lang/String;
.field private static final MAINLAND_IDE_DOWNLOAD_URL:Ljava/lang/String;
.field private static final OVERSEA_DISPLAY_URL:Ljava/lang/String;
.field private static final OVERSEA_DOWNLOAD_URL:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideContentPolicy;
    invoke-direct v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideContentPolicy;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideContentPolicy;->INSTANCE Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideContentPolicy;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final content(com.bytedance.trae.conversation.devices.DeviceProductType)com.bytedance.trae.conversation.devices.ConnectComputerGuideContent
    .registers 5
    # ins_size=2
    const-string v0, "productType"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideContentPolicy$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v4, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->ordinal()I
    move-result v4
    aget v4, v0, v4
    const/4 v0, 1
    if-eq v4, v0, +017h
    const/4 v0, 2
    if-ne v4, v0, +00eh
    new-instance v4, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideContent;
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_connect_guide_ide_hero I
    sget v1, Lcom/bytedance/trae/conversation/R$string;->trae_device_connect_ide_step1 I
    sget v2, Lcom/bytedance/trae/conversation/R$string;->trae_device_connect_ide_step2 I
    invoke-direct v4, v0, v1, v2, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideContent;-><init>(I I I)V
    goto +12h
    new-instance v4, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v4, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v4
    new-instance v4, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideContent;
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_connect_guide_work_hero I
    sget v1, Lcom/bytedance/trae/conversation/R$string;->trae_device_connect_work_step1 I
    sget v2, Lcom/bytedance/trae/conversation/R$string;->trae_device_connect_work_step2 I
    invoke-direct v4, v0, v1, v2, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideContent;-><init>(I I I)V
    return-object v4
.end method

.method public final displayUrl(boolean)java.lang.String
    .registers 2
    # ins_size=2
    if-eqz v1, +006h
    const-string/jumbo v1, trae.ai
    goto +4h
    const-string/jumbo v1, trae.cn
    return-object v1
.end method

.method public final downloadUrl(boolean)java.lang.String
    .registers 2
    # ins_size=2
    if-eqz v1, +005h
    const-string v1, "https://www.trae.ai/download?utm_source=content&utm_medium=mobile_download"
    goto +3h
    const-string v1, "https://www.trae.cn/ide/download?utm_source=content&utm_medium=mobile_download"
    return-object v1
.end method
