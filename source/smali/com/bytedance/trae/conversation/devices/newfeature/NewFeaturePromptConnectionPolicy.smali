# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConnectionPolicy;
.super Ljava/lang/Object;
.source "NewFeaturePromptConnectionPolicy.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConnectionPolicy;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConnectionPolicy;
    invoke-direct v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConnectionPolicy;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConnectionPolicy;->INSTANCE Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConnectionPolicy;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final actionFor(com.bytedance.trae.conversation.devices.DeviceProductType)com.bytedance.trae.conversation.devices.newfeature.NewFeaturePromptConnectionAction
    .registers 5
    # ins_size=2
    const-string v0, "productType"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConnectionPolicy$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v4, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->ordinal()I
    move-result v4
    aget v4, v0, v4
    const/4 v0, 1
    if-eq v4, v0, +015h
    const/4 v1, 2
    if-ne v4, v1, +00ch
    new-instance v4, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConnectionAction;
    sget-object v1, Lcom/bytedance/trae/conversation/widget/ChatMode;->CODE Lcom/bytedance/trae/conversation/widget/ChatMode;
    sget-object v2, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    invoke-direct v4, v1, v2, v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConnectionAction;-><init>(Lcom/bytedance/trae/conversation/widget/ChatMode; Lcom/bytedance/trae/im/service/CliType; Z)V
    goto +10h
    new-instance v4, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v4, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v4
    new-instance v4, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConnectionAction;
    sget-object v1, Lcom/bytedance/trae/conversation/widget/ChatMode;->MTC Lcom/bytedance/trae/conversation/widget/ChatMode;
    sget-object v2, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    invoke-direct v4, v1, v2, v0, Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConnectionAction;-><init>(Lcom/bytedance/trae/conversation/widget/ChatMode; Lcom/bytedance/trae/im/service/CliType; Z)V
    return-object v4
.end method
