package com.bytedance.trae.conversation.chat.toolcall;

import android.content.Context;
import com.bytedance.trae.im.model.ParsedToolCallInfo;
import com.bytedance.trae.utils.logger.FLogger;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseToolDetailCardCreator.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J,\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\"\u0010\u0012\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH$J*\u0010\u0013\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014R \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/bytedance/trae/conversation/chat/toolcall/BaseToolDetailCardCreator;", "Lcom/bytedance/trae/conversation/chat/toolcall/IToolDetailCardCreator;", "<init>", "()V", "cardRefs", "", "", "Ljava/lang/ref/WeakReference;", "Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;", "createDetail", "context", "Landroid/content/Context;", "toolCallInfo", "Lcom/bytedance/trae/im/model/ParsedToolCallInfo;", "planItemContext", "Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;", "updateCard", "id", "onCreateDetail", "onUpdateCard", "", "card", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public abstract class BaseToolDetailCardCreator implements IToolDetailCardCreator {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String TOOL_TAG = "AgentTool";
    private final Map<String, WeakReference<ToolDetailCard>> cardRefs = new LinkedHashMap();

    protected abstract ToolDetailCard onCreateDetail(Context context, ParsedToolCallInfo toolCallInfo, PlanItemContext planItemContext);

    /* compiled from: BaseToolDetailCardCreator.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/conversation/chat/toolcall/BaseToolDetailCardCreator$Companion;", "", "<init>", "()V", "TOOL_TAG", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // com.bytedance.trae.conversation.chat.toolcall.IToolDetailCardCreator
    public ToolDetailCard createDetail(Context context, ParsedToolCallInfo toolCallInfo, PlanItemContext planItemContext) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(toolCallInfo, "toolCallInfo");
        ToolDetailCard onCreateDetail = onCreateDetail(context, toolCallInfo, planItemContext);
        String id = toolCallInfo.getId();
        if (id == null) {
            id = planItemContext != null ? planItemContext.getPlanItemId() : null;
            if (id == null) {
                return onCreateDetail;
            }
        }
        if (!(id.length() == 0)) {
            this.cardRefs.put(id, new WeakReference<>(onCreateDetail));
        }
        return onCreateDetail;
    }

    public static /* synthetic */ ToolDetailCard updateCard$default(BaseToolDetailCardCreator baseToolDetailCardCreator, Context context, String str, ParsedToolCallInfo parsedToolCallInfo, PlanItemContext planItemContext, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateCard");
        }
        if ((i & 8) != 0) {
            planItemContext = null;
        }
        return baseToolDetailCardCreator.updateCard(context, str, parsedToolCallInfo, planItemContext);
    }

    public final ToolDetailCard updateCard(Context context, String id, ParsedToolCallInfo toolCallInfo, PlanItemContext planItemContext) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(toolCallInfo, "toolCallInfo");
        WeakReference<ToolDetailCard> weakReference = this.cardRefs.get(id);
        if (weakReference == null) {
            FLogger.INSTANCE.d("AgentTool", "[CardCreator] updateCard: no ref for id=" + id + ", name=" + toolCallInfo.getName());
            return null;
        }
        ToolDetailCard toolDetailCard = weakReference.get();
        if (toolDetailCard == null) {
            this.cardRefs.remove(id);
            FLogger.INSTANCE.d("AgentTool", "[CardCreator] updateCard: ref GC'd for id=" + id + ", name=" + toolCallInfo.getName());
            return null;
        }
        onUpdateCard(context, toolDetailCard, toolCallInfo, planItemContext);
        FLogger.INSTANCE.d("AgentTool", "[CardCreator] updateCard: id=" + id + ", name=" + toolCallInfo.getName() + ", title=" + toolDetailCard.getTitle());
        return toolDetailCard;
    }

    protected void onUpdateCard(Context context, ToolDetailCard card, ParsedToolCallInfo toolCallInfo, PlanItemContext planItemContext) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(card, "card");
        Intrinsics.checkNotNullParameter(toolCallInfo, "toolCallInfo");
        ToolDetailCard onCreateDetail = onCreateDetail(context, toolCallInfo, planItemContext);
        card.setIconEmoji(onCreateDetail.getIconEmoji());
        card.setIconResId(onCreateDetail.getIconResId());
        card.setIconTintColorRes(onCreateDetail.getIconTintColorRes());
        card.setTitle(onCreateDetail.getTitle());
        card.setSubtitle(onCreateDetail.getSubtitle());
        card.setBadgeText(onCreateDetail.getBadgeText());
        card.setStatus(onCreateDetail.getStatus());
        card.setShimmerTitle(onCreateDetail.getShimmerTitle());
        card.setOnDetailClick(onCreateDetail.getOnDetailClick());
    }
}
