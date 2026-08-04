# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/widget/TaskTemplateDeviceSelectionPolicy;
.super Ljava/lang/Object;
.source "TaskTemplateDeviceSelectionPolicy.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/widget/TaskTemplateDeviceSelectionPolicy;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/widget/TaskTemplateDeviceSelectionPolicy;
    invoke-direct v0, Lcom/bytedance/trae/conversation/widget/TaskTemplateDeviceSelectionPolicy;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/widget/TaskTemplateDeviceSelectionPolicy;->INSTANCE Lcom/bytedance/trae/conversation/widget/TaskTemplateDeviceSelectionPolicy;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final actionForDeviceChange(boolean  com.bytedance.trae.im.service.CliType  com.bytedance.trae.im.service.CliType)com.bytedance.trae.conversation.widget.TaskTemplateDeviceSelectionPolicy$Action
    .registers 5
    # ins_size=4
    const-string/jumbo v0, selectedDeviceType
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    if-nez v2, +005h
    sget-object v2, Lcom/bytedance/trae/conversation/widget/TaskTemplateDeviceSelectionPolicy$Action;->KEEP Lcom/bytedance/trae/conversation/widget/TaskTemplateDeviceSelectionPolicy$Action;
    return-object v2
    sget-object v2, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    if-ne v4, v2, +005h
    sget-object v2, Lcom/bytedance/trae/conversation/widget/TaskTemplateDeviceSelectionPolicy$Action;->HIDE Lcom/bytedance/trae/conversation/widget/TaskTemplateDeviceSelectionPolicy$Action;
    return-object v2
    sget-object v2, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    if-ne v3, v2, +005h
    sget-object v2, Lcom/bytedance/trae/conversation/widget/TaskTemplateDeviceSelectionPolicy$Action;->REFRESH Lcom/bytedance/trae/conversation/widget/TaskTemplateDeviceSelectionPolicy$Action;
    return-object v2
    sget-object v2, Lcom/bytedance/trae/conversation/widget/TaskTemplateDeviceSelectionPolicy$Action;->KEEP Lcom/bytedance/trae/conversation/widget/TaskTemplateDeviceSelectionPolicy$Action;
    return-object v2
.end method

.method public final actionForModeChange(boolean  com.bytedance.trae.im.service.CliType)com.bytedance.trae.conversation.widget.TaskTemplateDeviceSelectionPolicy$Action
    .registers 4
    # ins_size=3
    const-string/jumbo v0, selectedDeviceType
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    if-nez v2, +005h
    sget-object v2, Lcom/bytedance/trae/conversation/widget/TaskTemplateDeviceSelectionPolicy$Action;->KEEP Lcom/bytedance/trae/conversation/widget/TaskTemplateDeviceSelectionPolicy$Action;
    return-object v2
    sget-object v2, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    if-ne v3, v2, +005h
    sget-object v2, Lcom/bytedance/trae/conversation/widget/TaskTemplateDeviceSelectionPolicy$Action;->HIDE Lcom/bytedance/trae/conversation/widget/TaskTemplateDeviceSelectionPolicy$Action;
    return-object v2
    sget-object v2, Lcom/bytedance/trae/conversation/widget/TaskTemplateDeviceSelectionPolicy$Action;->REFRESH Lcom/bytedance/trae/conversation/widget/TaskTemplateDeviceSelectionPolicy$Action;
    return-object v2
.end method
