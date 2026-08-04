# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory;
.super Ljava/lang/Object;
.source "BlockRendererFactory.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory$Companion;
.field private static final TAG:Ljava/lang/String;
.field private static bridge instance:Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory;
.field private final renderers:Ljava/util/Map;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory;->Companion Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    new-instance v0, Ljava/util/LinkedHashMap;
    invoke-direct v0, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v0, Ljava/util/Map;
    iput-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory;->renderers Ljava/util/Map;
    return-void 
.end method

.method public static final synthetic access$getInstance$cp()com.bytedance.trae.conversation.chat.block.renderer.BlockRendererFactory
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory;->instance Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory;
    return-object v0
.end method

.method public static final synthetic access$registerDefaults(com.bytedance.trae.conversation.chat.block.renderer.BlockRendererFactory)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory;->registerDefaults()V
    return-void 
.end method

.method public static final synthetic access$setInstance$cp(com.bytedance.trae.conversation.chat.block.renderer.BlockRendererFactory)void
    .registers 1
    # ins_size=1
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory;->instance Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory;
    return-void 
.end method

.method private final registerDefaults()void
    .registers 3
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;
    invoke-static v0, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer;
    invoke-direct v1, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer;-><init>()V
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;
    invoke-virtual v2, v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory;->register(Lkotlin/reflect/KClass; Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;)V
    const-class v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$References;
    invoke-static v0, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ReferencesRenderer;
    invoke-direct v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ReferencesRenderer;-><init>()V
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;
    invoke-virtual v2, v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory;->register(Lkotlin/reflect/KClass; Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;)V
    const-class v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thinking;
    invoke-static v0, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ThinkingRenderer;
    invoke-direct v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ThinkingRenderer;-><init>()V
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;
    invoke-virtual v2, v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory;->register(Lkotlin/reflect/KClass; Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;)V
    const-class v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thought;
    invoke-static v0, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ThoughtRenderer;
    invoke-direct v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ThoughtRenderer;-><init>()V
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;
    invoke-virtual v2, v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory;->register(Lkotlin/reflect/KClass; Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;)V
    const-class v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;
    invoke-static v0, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ToolcallGroupRenderer;
    invoke-direct v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ToolcallGroupRenderer;-><init>()V
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;
    invoke-virtual v2, v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory;->register(Lkotlin/reflect/KClass; Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;)V
    const-class v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PureShowWidgetToolcallGroup;
    invoke-static v0, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetToolcallGroupRenderer;
    invoke-direct v1, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetToolcallGroupRenderer;-><init>()V
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;
    invoke-virtual v2, v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory;->register(Lkotlin/reflect/KClass; Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;)V
    const-class v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;
    invoke-static v0, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer;
    invoke-direct v1, Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer;-><init>()V
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;
    invoke-virtual v2, v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory;->register(Lkotlin/reflect/KClass; Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;)V
    const-class v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;
    invoke-static v0, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/conversation/chat/block/renderer/SubAgentGroupRenderer;
    invoke-direct v1, Lcom/bytedance/trae/conversation/chat/block/renderer/SubAgentGroupRenderer;-><init>()V
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;
    invoke-virtual v2, v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory;->register(Lkotlin/reflect/KClass; Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;)V
    const-class v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Summary;
    invoke-static v0, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer;
    invoke-direct v1, Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer;-><init>()V
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;
    invoke-virtual v2, v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory;->register(Lkotlin/reflect/KClass; Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;)V
    const-class v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$VoiceSummary;
    invoke-static v0, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer;
    invoke-direct v1, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer;-><init>()V
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;
    invoke-virtual v2, v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory;->register(Lkotlin/reflect/KClass; Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;)V
    const-class v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;
    invoke-static v0, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;
    invoke-direct v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;-><init>()V
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;
    invoke-virtual v2, v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory;->register(Lkotlin/reflect/KClass; Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;)V
    const-class v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;
    invoke-static v0, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ActionBarRenderer;
    invoke-direct v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ActionBarRenderer;-><init>()V
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;
    invoke-virtual v2, v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory;->register(Lkotlin/reflect/KClass; Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;)V
    const-class v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$UpgradeReminder;
    invoke-static v0, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/conversation/chat/block/renderer/UpgradeReminderRenderer;
    invoke-direct v1, Lcom/bytedance/trae/conversation/chat/block/renderer/UpgradeReminderRenderer;-><init>()V
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;
    invoke-virtual v2, v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory;->register(Lkotlin/reflect/KClass; Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;)V
    const-class v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$CancelBanner;
    invoke-static v0, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/conversation/chat/block/renderer/CancelBannerRenderer;
    invoke-direct v1, Lcom/bytedance/trae/conversation/chat/block/renderer/CancelBannerRenderer;-><init>()V
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;
    invoke-virtual v2, v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory;->register(Lkotlin/reflect/KClass; Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;)V
    const-class v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;
    invoke-static v0, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingRenderer;
    invoke-direct v1, Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingRenderer;-><init>()V
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;
    invoke-virtual v2, v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory;->register(Lkotlin/reflect/KClass; Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;)V
    const-class v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Error;
    invoke-static v0, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ErrorRenderer;
    invoke-direct v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ErrorRenderer;-><init>()V
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;
    invoke-virtual v2, v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory;->register(Lkotlin/reflect/KClass; Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;)V
    const-class v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FreeActivityQuotaError;
    invoke-static v0, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/conversation/chat/block/renderer/FreeActivityQuotaErrorRenderer;
    invoke-direct v1, Lcom/bytedance/trae/conversation/chat/block/renderer/FreeActivityQuotaErrorRenderer;-><init>()V
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;
    invoke-virtual v2, v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory;->register(Lkotlin/reflect/KClass; Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;)V
    const-class v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Loading;
    invoke-static v0, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/conversation/chat/block/renderer/LoadingRenderer;
    invoke-direct v1, Lcom/bytedance/trae/conversation/chat/block/renderer/LoadingRenderer;-><init>()V
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;
    invoke-virtual v2, v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory;->register(Lkotlin/reflect/KClass; Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;)V
    const-class v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$InitialLoading;
    invoke-static v0, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/conversation/chat/block/renderer/InitialLoadingRenderer;
    invoke-direct v1, Lcom/bytedance/trae/conversation/chat/block/renderer/InitialLoadingRenderer;-><init>()V
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;
    invoke-virtual v2, v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory;->register(Lkotlin/reflect/KClass; Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;)V
    const-class v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$VoiceSummaryLoading;
    invoke-static v0, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryLoadingRenderer;
    invoke-direct v1, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryLoadingRenderer;-><init>()V
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;
    invoke-virtual v2, v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory;->register(Lkotlin/reflect/KClass; Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;)V
    const-class v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ViewVoiceHistory;
    invoke-static v0, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ViewVoiceHistoryRenderer;
    invoke-direct v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ViewVoiceHistoryRenderer;-><init>()V
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;
    invoke-virtual v2, v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory;->register(Lkotlin/reflect/KClass; Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;)V
    return-void 
.end method

.method public final getRenderer(com.bytedance.trae.conversation.chat.block.AgentContentBlock)com.bytedance.trae.conversation.chat.block.renderer.IBlockRenderer
    .registers 6
    # ins_size=2
    const-string v0, "block"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory;->renderers Ljava/util/Map;
    invoke-virtual v5, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v1
    invoke-static v1, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;
    move-result-object v1
    invoke-interface v0, v1, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    instance-of v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;
    if-eqz v1, +005h
    check-cast v0, Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;
    goto +2h
    const/4 v0, 0
    if-nez v0, +024h
    sget-object v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "No renderer registered for "
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v5, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v5
    invoke-static v5, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;
    move-result-object v5
    invoke-interface v5, Lkotlin/reflect/KClass;->getSimpleName()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    const-string v2, "BlockRendererFactory"
    invoke-virtual v1, v2, v5, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->e(Ljava/lang/String; Ljava/lang/String;)V
    return-object v0
.end method

.method public final register(kotlin.reflect.KClass  com.bytedance.trae.conversation.chat.block.renderer.IBlockRenderer)void
    .registers 4
    # ins_size=3
    const-string v0, "blockClass"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, renderer
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory;->renderers Ljava/util/Map;
    invoke-interface v0, v2, v3, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method
