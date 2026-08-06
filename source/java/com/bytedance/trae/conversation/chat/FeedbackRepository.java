package com.bytedance.trae.conversation.chat;

import com.bytedance.keva.Keva;
import com.bytedance.trae.conversation.chat.block.AgentContentBlock;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FeedbackRepository.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/trae/conversation/chat/FeedbackRepository;", "", "<init>", "()V", "REPO_NAME", "", "getKeva", "Lcom/bytedance/keva/Keva;", "getFeedbackState", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState;", "messageId", "saveFeedbackState", "", "state", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class FeedbackRepository {
    public static final FeedbackRepository INSTANCE = new FeedbackRepository();
    private static final String REPO_NAME = "message_feedback";

    /* compiled from: FeedbackRepository.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AgentContentBlock.FeedbackState.values().length];
            try {
                iArr[AgentContentBlock.FeedbackState.THUMBS_UP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AgentContentBlock.FeedbackState.THUMBS_DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AgentContentBlock.FeedbackState.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private FeedbackRepository() {
    }

    private final Keva getKeva() {
        Keva repo = Keva.getRepo(REPO_NAME);
        Intrinsics.checkNotNullExpressionValue(repo, "getRepo(...)");
        return repo;
    }

    public final AgentContentBlock.FeedbackState getFeedbackState(String messageId) {
        String string;
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        if (!(messageId.length() == 0) && (string = getKeva().getString(messageId, (String) null)) != null) {
            return Intrinsics.areEqual(string, "thumbs_up") ? AgentContentBlock.FeedbackState.THUMBS_UP : Intrinsics.areEqual(string, "thumbs_down") ? AgentContentBlock.FeedbackState.THUMBS_DOWN : AgentContentBlock.FeedbackState.NONE;
        }
        return AgentContentBlock.FeedbackState.NONE;
    }

    public final void saveFeedbackState(String messageId, AgentContentBlock.FeedbackState state) {
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        Intrinsics.checkNotNullParameter(state, "state");
        if (messageId.length() == 0) {
            return;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
        if (i == 1) {
            getKeva().storeString(messageId, "thumbs_up");
        } else if (i == 2) {
            getKeva().storeString(messageId, "thumbs_down");
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            getKeva().storeString(messageId, (String) null);
        }
    }
}
