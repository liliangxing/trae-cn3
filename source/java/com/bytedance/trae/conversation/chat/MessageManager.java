package com.bytedance.trae.conversation.chat;

import com.bytedance.trae.im.model.ParsedChatMessage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MessageManager.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003\u001b\u001c\u001dB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006J\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006J\u0016\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bJ\u000e\u0010\u0014\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bJ\u000e\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0016\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nJ\u000e\u0010\u0017\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nJ \u0010\u0018\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/bytedance/trae/conversation/chat/MessageManager;", "", "<init>", "()V", "listeners", "", "Lcom/bytedance/trae/conversation/chat/MessageManager$IDeleteMessage;", "conversationListeners", "Lcom/bytedance/trae/conversation/chat/MessageManager$IDeleteConversation;", "revertListeners", "Lcom/bytedance/trae/conversation/chat/MessageManager$IRevertMessage;", "addDeleteMessageListener", "", "listener", "removeDeleteMessageListener", "notifyMessageDeleted", "conversationId", "", "messageId", "addDeleteConversationListener", "removeDeleteConversationListener", "notifyConversationDeleted", "addRevertMessageListener", "removeRevertMessageListener", "notifyMessageReverted", "message", "Lcom/bytedance/trae/im/model/ParsedChatMessage;", "IDeleteMessage", "IDeleteConversation", "IRevertMessage", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class MessageManager {
    public static final MessageManager INSTANCE = new MessageManager();
    private static final List<IDeleteMessage> listeners = new ArrayList();
    private static final List<IDeleteConversation> conversationListeners = new ArrayList();
    private static final List<IRevertMessage> revertListeners = new ArrayList();

    /* compiled from: MessageManager.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/conversation/chat/MessageManager$IDeleteConversation;", "", "onMessageDeleted", "", "conversationId", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface IDeleteConversation {
        void onMessageDeleted(String conversationId);
    }

    /* compiled from: MessageManager.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/bytedance/trae/conversation/chat/MessageManager$IDeleteMessage;", "", "onMessageDeleted", "", "conversationId", "", "messageId", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface IDeleteMessage {
        void onMessageDeleted(String conversationId, String messageId);
    }

    /* compiled from: MessageManager.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&¨\u0006\t"}, d2 = {"Lcom/bytedance/trae/conversation/chat/MessageManager$IRevertMessage;", "", "onMessageReverted", "", "conversationId", "", "messageId", "message", "Lcom/bytedance/trae/im/model/ParsedChatMessage;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface IRevertMessage {
        void onMessageReverted(String conversationId, String messageId, ParsedChatMessage message);
    }

    private MessageManager() {
    }

    public final void addDeleteMessageListener(IDeleteMessage listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        List<IDeleteMessage> list = listeners;
        if (list.contains(listener)) {
            return;
        }
        list.add(listener);
    }

    public final void removeDeleteMessageListener(IDeleteMessage listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        listeners.remove(listener);
    }

    public final void notifyMessageDeleted(String conversationId, String messageId) {
        Intrinsics.checkNotNullParameter(conversationId, "conversationId");
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        Iterator<T> it = listeners.iterator();
        while (it.hasNext()) {
            ((IDeleteMessage) it.next()).onMessageDeleted(conversationId, messageId);
        }
    }

    public final void addDeleteConversationListener(IDeleteConversation listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        List<IDeleteConversation> list = conversationListeners;
        if (list.contains(listener)) {
            return;
        }
        list.add(listener);
    }

    public final void removeDeleteConversationListener(IDeleteConversation listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        conversationListeners.remove(listener);
    }

    public final void notifyConversationDeleted(String conversationId) {
        Intrinsics.checkNotNullParameter(conversationId, "conversationId");
        Iterator<T> it = conversationListeners.iterator();
        while (it.hasNext()) {
            ((IDeleteConversation) it.next()).onMessageDeleted(conversationId);
        }
    }

    public final void addRevertMessageListener(IRevertMessage listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        List<IRevertMessage> list = revertListeners;
        if (list.contains(listener)) {
            return;
        }
        list.add(listener);
    }

    public final void removeRevertMessageListener(IRevertMessage listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        revertListeners.remove(listener);
    }

    public final void notifyMessageReverted(String conversationId, String messageId, ParsedChatMessage message) {
        Intrinsics.checkNotNullParameter(conversationId, "conversationId");
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        Iterator<T> it = revertListeners.iterator();
        while (it.hasNext()) {
            ((IRevertMessage) it.next()).onMessageReverted(conversationId, messageId, message);
        }
    }
}
