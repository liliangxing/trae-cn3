package com.bytedance.trae.conversation.chat.block.renderer;

import java.util.HashMap;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QueuingManager.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u0006RM\u0010\u0004\u001a>\u0012\u0004\u0012\u00020\u0006\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00060\u0007j\b\u0012\u0004\u0012\u00020\u0006`\b0\u0005j\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00060\u0007j\b\u0012\u0004\u0012\u00020\u0006`\b`\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingManager;", "", "<init>", "()V", "manager", "Ljava/util/HashMap;", "", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "Lkotlin/collections/HashMap;", "getManager", "()Ljava/util/HashMap;", "usePayRight", "", "messageId", "uuid", "hasUsedPayRight", "", "hasMessageId", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class QueuingManager {
    public static final QueuingManager INSTANCE = new QueuingManager();
    private static final HashMap<String, HashSet<String>> manager = new HashMap<>();

    private QueuingManager() {
    }

    public final HashMap<String, HashSet<String>> getManager() {
        return manager;
    }

    public final void usePayRight(String messageId, String uuid) {
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        if (uuid == null) {
            return;
        }
        HashMap<String, HashSet<String>> hashMap = manager;
        HashSet<String> hashSet = hashMap.get(messageId);
        if (hashSet == null) {
            hashSet = new HashSet<>();
            hashMap.put(messageId, hashSet);
        }
        hashSet.add(uuid);
    }

    public final boolean hasUsedPayRight(String messageId, String uuid) {
        HashSet<String> hashSet;
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        return (uuid == null || (hashSet = manager.get(messageId)) == null || !hashSet.contains(uuid)) ? false : true;
    }

    public final boolean hasMessageId(String messageId) {
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        return manager.containsKey(messageId);
    }
}
