package com.bytedance.trae.home.zlink;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PendingDeepLinkRoutePolicy.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/home/zlink/PendingDeepLinkRoute;", "", "Conversation", "RoutedByZlink", "Lcom/bytedance/trae/home/zlink/PendingDeepLinkRoute$Conversation;", "Lcom/bytedance/trae/home/zlink/PendingDeepLinkRoute$RoutedByZlink;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface PendingDeepLinkRoute {

    /* compiled from: PendingDeepLinkRoutePolicy.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÇ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH×\u0003J\t\u0010\u000e\u001a\u00020\u000fH×\u0001J\t\u0010\u0010\u001a\u00020\u0003H×\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/home/zlink/PendingDeepLinkRoute$Conversation;", "Lcom/bytedance/trae/home/zlink/PendingDeepLinkRoute;", "conversationId", "", "<init>", "(Ljava/lang/String;)V", "getConversationId", "()Ljava/lang/String;", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class Conversation implements PendingDeepLinkRoute {
        public static final int $stable = 0;
        private final String conversationId;

        public static /* synthetic */ Conversation copy$default(Conversation conversation, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = conversation.conversationId;
            }
            return conversation.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getConversationId() {
            return this.conversationId;
        }

        public final Conversation copy(String conversationId) {
            return new Conversation(conversationId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Conversation) && Intrinsics.areEqual(this.conversationId, ((Conversation) other).conversationId);
        }

        public int hashCode() {
            String str = this.conversationId;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "Conversation(conversationId=" + this.conversationId + ')';
        }

        public Conversation(String str) {
            this.conversationId = str;
        }

        public final String getConversationId() {
            return this.conversationId;
        }
    }

    /* compiled from: PendingDeepLinkRoutePolicy.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H×\u0003J\t\u0010\b\u001a\u00020\tH×\u0001J\t\u0010\n\u001a\u00020\u000bH×\u0001¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/home/zlink/PendingDeepLinkRoute$RoutedByZlink;", "Lcom/bytedance/trae/home/zlink/PendingDeepLinkRoute;", "<init>", "()V", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class RoutedByZlink implements PendingDeepLinkRoute {
        public static final int $stable = 0;
        public static final RoutedByZlink INSTANCE = new RoutedByZlink();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RoutedByZlink)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1333492045;
        }

        public String toString() {
            return "RoutedByZlink";
        }

        private RoutedByZlink() {
        }
    }
}
