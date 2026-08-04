# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/IDEProjectAvailabilityPolicy;
.super Ljava/lang/Object;
.source "IDEProjectAvailabilityPolicy.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/IDEProjectAvailabilityPolicy;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/IDEProjectAvailabilityPolicy;
    invoke-direct v0, Lcom/bytedance/trae/conversation/IDEProjectAvailabilityPolicy;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/IDEProjectAvailabilityPolicy;->INSTANCE Lcom/bytedance/trae/conversation/IDEProjectAvailabilityPolicy;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final applyCreateTaskCheck(com.bytedance.trae.conversation.devices.SelectedDeviceItem  com.bytedance.trae.im.service.CreateTaskCheckResponse)com.bytedance.trae.conversation.devices.SelectedDeviceItem
    .registers 16
    # ins_size=3
    const-string v0, "device"
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, response
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v15, Lcom/bytedance/trae/im/service/CreateTaskCheckResponse;->getProjectId()Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationProjectContextKt;->takeNotBlank(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v7
    const/4 v2, 0
    const/4 v3, 0
    sget-object v4, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    const/4 v5, 0
    const/4 v6, 0
    invoke-virtual v15, Lcom/bytedance/trae/im/service/CreateTaskCheckResponse;->getAvailable()Z
    move-result v15
    if-eqz v15, +006h
    if-eqz v7, +004h
    const/4 v15, 1
    goto +2h
    const/4 v15, 0
    move v8, v15
    const/4 v9, 0
    const/4 v10, 0
    const/16 v11, 411
    const/4 v12, 0
    move-object v1, v14
    invoke-static/range v1 ... v12, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->copy$default(Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/CliType; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/String; Z I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    move-result-object v14
    return-object v14
.end method

.method public final isUnavailable(com.bytedance.trae.conversation.devices.SelectedDeviceItem)boolean
    .registers 5
    # ins_size=2
    const-string v0, "device"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v4, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    const/4 v2, 0
    if-ne v0, v1, +01eh
    invoke-virtual v4, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->isProjectAvailable()Z
    move-result v0
    const/4 v1, 1
    if-eqz v0, +016h
    invoke-virtual v4, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;->getProjectId()Ljava/lang/String;
    move-result-object v4
    check-cast v4, Ljava/lang/CharSequence;
    if-eqz v4, +00bh
    invoke-static v4, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v4
    if-eqz v4, +003h
    goto +3h
    move v4, v2
    goto +2h
    move v4, v1
    if-eqz v4, +003h
    move v2, v1
    return v2
.end method
