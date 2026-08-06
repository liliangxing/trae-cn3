package com.bytedance.trae.conversation.chat;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;

/* compiled from: SharedViewPool.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/trae/conversation/chat/SharedViewPool;", "", "<init>", "()V", "conversationPool", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "getConversationPool", "()Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "toolListPool", "getToolListPool", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SharedViewPool {
    public static final SharedViewPool INSTANCE = new SharedViewPool();
    private static final RecyclerView.RecycledViewPool conversationPool = new RecyclerView.RecycledViewPool();
    private static final RecyclerView.RecycledViewPool toolListPool = new RecyclerView.RecycledViewPool();

    private SharedViewPool() {
    }

    public final RecyclerView.RecycledViewPool getConversationPool() {
        return conversationPool;
    }

    public final RecyclerView.RecycledViewPool getToolListPool() {
        return toolListPool;
    }
}
