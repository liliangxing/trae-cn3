package com.bytedance.trae.conversation.chat.block.renderer;

import com.bytedance.trae.conversation.chat.block.AgentContentBlock;
import com.bytedance.trae.utils.logger.TraeLogUtil;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: BlockRendererFactory.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\b\u001a\u00020\t\"\b\b\u0000\u0010\n*\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\n0\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\n0\u0007J%\u0010\u000e\u001a\n\u0012\u0004\u0012\u0002H\n\u0018\u00010\u0007\"\b\b\u0000\u0010\n*\u00020\u000b2\u0006\u0010\u000f\u001a\u0002H\n¢\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u00020\tH\u0002R\"\u0010\u0004\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory;", "", "<init>", "()V", "renderers", "", "Lkotlin/reflect/KClass;", "Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;", "register", "", "T", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;", "blockClass", "renderer", "getRenderer", "block", "(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;)Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;", "registerDefaults", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BlockRendererFactory {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "BlockRendererFactory";
    private static volatile BlockRendererFactory instance;
    private final Map<KClass<?>, IBlockRenderer<?>> renderers = new LinkedHashMap();

    public final <T extends AgentContentBlock> void register(KClass<T> blockClass, IBlockRenderer<T> renderer) {
        Intrinsics.checkNotNullParameter(blockClass, "blockClass");
        Intrinsics.checkNotNullParameter(renderer, "renderer");
        this.renderers.put(blockClass, renderer);
    }

    public final <T extends AgentContentBlock> IBlockRenderer<T> getRenderer(T block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Object obj = this.renderers.get(Reflection.getOrCreateKotlinClass(block.getClass()));
        IBlockRenderer<T> iBlockRenderer = obj instanceof IBlockRenderer ? (IBlockRenderer) obj : null;
        if (iBlockRenderer == null) {
            TraeLogUtil.INSTANCE.e(TAG, "No renderer registered for " + Reflection.getOrCreateKotlinClass(block.getClass()).getSimpleName());
        }
        return iBlockRenderer;
    }

    /* compiled from: BlockRendererFactory.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory$Companion;", "", "<init>", "()V", "TAG", "", "instance", "Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory;", "getInstance", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BlockRendererFactory getInstance() {
            BlockRendererFactory blockRendererFactory = BlockRendererFactory.instance;
            if (blockRendererFactory == null) {
                synchronized (this) {
                    blockRendererFactory = BlockRendererFactory.instance;
                    if (blockRendererFactory == null) {
                        blockRendererFactory = new BlockRendererFactory();
                        blockRendererFactory.registerDefaults();
                        Companion companion = BlockRendererFactory.INSTANCE;
                        BlockRendererFactory.instance = blockRendererFactory;
                    }
                }
            }
            return blockRendererFactory;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void registerDefaults() {
        register(Reflection.getOrCreateKotlinClass(AgentContentBlock.Avatar.class), new AvatarRenderer());
        register(Reflection.getOrCreateKotlinClass(AgentContentBlock.References.class), new ReferencesRenderer());
        register(Reflection.getOrCreateKotlinClass(AgentContentBlock.Thinking.class), new ThinkingRenderer());
        register(Reflection.getOrCreateKotlinClass(AgentContentBlock.Thought.class), new ThoughtRenderer());
        register(Reflection.getOrCreateKotlinClass(AgentContentBlock.ToolcallGroup.class), new ToolcallGroupRenderer());
        register(Reflection.getOrCreateKotlinClass(AgentContentBlock.PureShowWidgetToolcallGroup.class), new PureShowWidgetToolcallGroupRenderer());
        register(Reflection.getOrCreateKotlinClass(AgentContentBlock.TodoGroup.class), new TodoGroupRenderer());
        register(Reflection.getOrCreateKotlinClass(AgentContentBlock.SubAgentGroup.class), new SubAgentGroupRenderer());
        register(Reflection.getOrCreateKotlinClass(AgentContentBlock.Summary.class), new SummaryRenderer());
        register(Reflection.getOrCreateKotlinClass(AgentContentBlock.VoiceSummary.class), new VoiceSummaryRenderer());
        register(Reflection.getOrCreateKotlinClass(AgentContentBlock.Artifacts.class), new ArtifactsRenderer());
        register(Reflection.getOrCreateKotlinClass(AgentContentBlock.ActionBar.class), new ActionBarRenderer());
        register(Reflection.getOrCreateKotlinClass(AgentContentBlock.UpgradeReminder.class), new UpgradeReminderRenderer());
        register(Reflection.getOrCreateKotlinClass(AgentContentBlock.CancelBanner.class), new CancelBannerRenderer());
        register(Reflection.getOrCreateKotlinClass(AgentContentBlock.Queuing.class), new QueuingRenderer());
        register(Reflection.getOrCreateKotlinClass(AgentContentBlock.Error.class), new ErrorRenderer());
        register(Reflection.getOrCreateKotlinClass(AgentContentBlock.FreeActivityQuotaError.class), new FreeActivityQuotaErrorRenderer());
        register(Reflection.getOrCreateKotlinClass(AgentContentBlock.Loading.class), new LoadingRenderer());
        register(Reflection.getOrCreateKotlinClass(AgentContentBlock.InitialLoading.class), new InitialLoadingRenderer());
        register(Reflection.getOrCreateKotlinClass(AgentContentBlock.VoiceSummaryLoading.class), new VoiceSummaryLoadingRenderer());
        register(Reflection.getOrCreateKotlinClass(AgentContentBlock.ViewVoiceHistory.class), new ViewVoiceHistoryRenderer());
    }
}
