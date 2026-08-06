package com.bytedance.trae.conversation.chat.detail;

import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.trae.conversation.chat.block.AgentContentBlock;
import com.bytedance.trae.utils.logger.FLogger;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: DetailBlockStore.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\nJ\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\nJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0014\u001a\u00020\u0007J$\u0010\u0016\u001a\u0004\u0018\u0001H\u0017\"\n\b\u0000\u0010\u0017\u0018\u0001*\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0007H\u0086\b¢\u0006\u0002\u0010\u0018J\u000e\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0007J\u0006\u0010\u001a\u001a\u00020\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R8\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n`\u000b8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\u0003\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/bytedance/trae/conversation/chat/detail/DetailBlockStore;", "", "<init>", "()V", "MAX_ENTRIES", "", "BLOCK_TAG", "", "cache", "Ljava/util/LinkedHashMap;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;", "Lkotlin/collections/LinkedHashMap;", "getCache$annotations", "getCache", "()Ljava/util/LinkedHashMap;", "lock", "put", "block", "putOrUpdate", "", "key", ApiRequest.METHOD_GET, "getAs", "T", "(Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;", "remove", "clear", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DetailBlockStore {
    private static final String BLOCK_TAG = "AgentBlock";
    private static final int MAX_ENTRIES = 20;
    public static final DetailBlockStore INSTANCE = new DetailBlockStore();
    private static final LinkedHashMap<String, AgentContentBlock> cache = new LinkedHashMap<String, AgentContentBlock>() { // from class: com.bytedance.trae.conversation.chat.detail.DetailBlockStore$cache$1
        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsKey(Object obj) {
            if (obj instanceof String) {
                return containsKey((String) obj);
            }
            return false;
        }

        public /* bridge */ boolean containsKey(String str) {
            return super.containsKey((Object) str);
        }

        public /* bridge */ boolean containsValue(AgentContentBlock agentContentBlock) {
            return super.containsValue((Object) agentContentBlock);
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsValue(Object obj) {
            if (obj instanceof AgentContentBlock) {
                return containsValue((AgentContentBlock) obj);
            }
            return false;
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<Map.Entry<String, AgentContentBlock>> entrySet() {
            return getEntries();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ AgentContentBlock get(Object obj) {
            if (obj instanceof String) {
                return get((String) obj);
            }
            return null;
        }

        public /* bridge */ AgentContentBlock get(String str) {
            return (AgentContentBlock) super.get((Object) str);
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            if (obj instanceof String) {
                return get((String) obj);
            }
            return null;
        }

        public /* bridge */ Set<Map.Entry<String, AgentContentBlock>> getEntries() {
            return super.entrySet();
        }

        public /* bridge */ Set<String> getKeys() {
            return super.keySet();
        }

        public final /* bridge */ AgentContentBlock getOrDefault(Object obj, AgentContentBlock agentContentBlock) {
            return !(obj instanceof String) ? agentContentBlock : getOrDefault((String) obj, agentContentBlock);
        }

        public /* bridge */ AgentContentBlock getOrDefault(String str, AgentContentBlock agentContentBlock) {
            return (AgentContentBlock) super.getOrDefault((Object) str, (String) agentContentBlock);
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
            return !(obj instanceof String) ? obj2 : getOrDefault((String) obj, (AgentContentBlock) obj2);
        }

        public /* bridge */ int getSize() {
            return super.size();
        }

        public /* bridge */ Collection<AgentContentBlock> getValues() {
            return super.values();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<String> keySet() {
            return getKeys();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ AgentContentBlock remove(Object obj) {
            if (obj instanceof String) {
                return remove((String) obj);
            }
            return null;
        }

        public /* bridge */ AgentContentBlock remove(String str) {
            return (AgentContentBlock) super.remove((Object) str);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object remove(Object obj) {
            if (obj instanceof String) {
                return remove((String) obj);
            }
            return null;
        }

        @Override // java.util.HashMap, java.util.Map
        public final /* bridge */ boolean remove(Object obj, Object obj2) {
            if ((obj instanceof String) && (obj2 instanceof AgentContentBlock)) {
                return remove((String) obj, (AgentContentBlock) obj2);
            }
            return false;
        }

        public /* bridge */ boolean remove(String str, AgentContentBlock agentContentBlock) {
            return super.remove((Object) str, (Object) agentContentBlock);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Collection<AgentContentBlock> values() {
            return getValues();
        }

        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<String, AgentContentBlock> eldest) {
            return size() > 20;
        }
    };
    private static final Object lock = new Object();

    public static /* synthetic */ void getCache$annotations() {
    }

    private DetailBlockStore() {
    }

    public final LinkedHashMap<String, AgentContentBlock> getCache() {
        return cache;
    }

    public final String put(AgentContentBlock block) {
        LinkedHashMap<String, AgentContentBlock> linkedHashMap;
        Intrinsics.checkNotNullParameter(block, "block");
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
        synchronized (lock) {
            linkedHashMap = cache;
            linkedHashMap.put(uuid, block);
            Unit unit = Unit.INSTANCE;
        }
        FLogger.INSTANCE.i("AgentBlock", "[BlockStore] put: key=" + uuid + ", type=" + Reflection.getOrCreateKotlinClass(block.getClass()).getSimpleName() + ", cacheSize=" + linkedHashMap.size());
        return uuid;
    }

    public final void putOrUpdate(String key, AgentContentBlock block) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(block, "block");
        synchronized (lock) {
            cache.put(key, block);
            Unit unit = Unit.INSTANCE;
        }
        FLogger.INSTANCE.d("AgentBlock", "[BlockStore] putOrUpdate: key=" + key + ", type=" + Reflection.getOrCreateKotlinClass(block.getClass()).getSimpleName());
    }

    public final AgentContentBlock get(String key) {
        AgentContentBlock agentContentBlock;
        Intrinsics.checkNotNullParameter(key, "key");
        synchronized (lock) {
            agentContentBlock = cache.get(key);
        }
        return agentContentBlock;
    }

    public final /* synthetic */ <T extends AgentContentBlock> T getAs(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        T t = (T) get(key);
        Intrinsics.reifiedOperationMarker(2, "T");
        return t;
    }

    public final void remove(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        synchronized (lock) {
            cache.remove(key);
        }
        FLogger.INSTANCE.i("AgentBlock", "[BlockStore] remove: key=" + key);
    }

    public final void clear() {
        int size;
        synchronized (lock) {
            LinkedHashMap<String, AgentContentBlock> linkedHashMap = cache;
            size = linkedHashMap.size();
            linkedHashMap.clear();
        }
        FLogger.INSTANCE.i("AgentBlock", "[BlockStore] clear: removed " + size + " entries");
    }
}
