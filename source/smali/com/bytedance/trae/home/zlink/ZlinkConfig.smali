# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/zlink/ZlinkConfig;
.super Ljava/lang/Object;
.source "ZlinkConfig.kt"

.field public static final $stable:I
.field public static final CLIPBOARD_DELAY_MS:J
.field public static final ENABLE_CLIPBOARD:Z
.field public static final INSTANCE:Lcom/bytedance/trae/home/zlink/ZlinkConfig;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/zlink/ZlinkConfig;
    invoke-direct v0, Lcom/bytedance/trae/home/zlink/ZlinkConfig;-><init>()V
    sput-object v0, Lcom/bytedance/trae/home/zlink/ZlinkConfig;->INSTANCE Lcom/bytedance/trae/home/zlink/ZlinkConfig;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final getAPPLINK_HOST()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v0
    if-eqz v0, +005h
    const-string v0, ""
    goto +4h
    const-string/jumbo v0, traeapp.zlinkurl.cn
    return-object v0
.end method

.method public final getAPP_ID()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getAppId()I
    move-result v0
    invoke-static v0, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public final getSCHEME()java.lang.String
    .registers 2
    # ins_size=1
    const-string/jumbo v0, traemobile
    return-object v0
.end method
