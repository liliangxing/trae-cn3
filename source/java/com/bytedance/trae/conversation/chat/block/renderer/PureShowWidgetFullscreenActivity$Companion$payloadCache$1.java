package com.bytedance.trae.conversation.chat.block.renderer;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

/* compiled from: PureShowWidgetFullscreenActivity.kt */
@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010'\n\u0000*\u0001\u0000\b\n\u0018\u00002\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0004J\u001e\u0010\u0005\u001a\u00020\u00062\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bH\u0014¨\u0006\t"}, d2 = {"com/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity$Companion$payloadCache$1", "Ljava/util/LinkedHashMap;", "", "Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenPayload;", "Lkotlin/collections/LinkedHashMap;", "removeEldestEntry", "", "eldest", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PureShowWidgetFullscreenActivity$Companion$payloadCache$1 extends LinkedHashMap<String, PureShowWidgetFullscreenPayload> {
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

    public /* bridge */ boolean containsValue(PureShowWidgetFullscreenPayload pureShowWidgetFullscreenPayload) {
        return super.containsValue((Object) pureShowWidgetFullscreenPayload);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsValue(Object obj) {
        if (obj instanceof PureShowWidgetFullscreenPayload) {
            return containsValue((PureShowWidgetFullscreenPayload) obj);
        }
        return false;
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<String, PureShowWidgetFullscreenPayload>> entrySet() {
        return getEntries();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ PureShowWidgetFullscreenPayload get(Object obj) {
        if (obj instanceof String) {
            return get((String) obj);
        }
        return null;
    }

    public /* bridge */ PureShowWidgetFullscreenPayload get(String str) {
        return (PureShowWidgetFullscreenPayload) super.get((Object) str);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object get(Object obj) {
        if (obj instanceof String) {
            return get((String) obj);
        }
        return null;
    }

    public /* bridge */ Set<Map.Entry<String, PureShowWidgetFullscreenPayload>> getEntries() {
        return super.entrySet();
    }

    public /* bridge */ Set<String> getKeys() {
        return super.keySet();
    }

    public final /* bridge */ PureShowWidgetFullscreenPayload getOrDefault(Object obj, PureShowWidgetFullscreenPayload pureShowWidgetFullscreenPayload) {
        return !(obj instanceof String) ? pureShowWidgetFullscreenPayload : getOrDefault((String) obj, pureShowWidgetFullscreenPayload);
    }

    public /* bridge */ PureShowWidgetFullscreenPayload getOrDefault(String str, PureShowWidgetFullscreenPayload pureShowWidgetFullscreenPayload) {
        return (PureShowWidgetFullscreenPayload) super.getOrDefault((Object) str, (String) pureShowWidgetFullscreenPayload);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
        return !(obj instanceof String) ? obj2 : getOrDefault((String) obj, (PureShowWidgetFullscreenPayload) obj2);
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ Collection<PureShowWidgetFullscreenPayload> getValues() {
        return super.values();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<String> keySet() {
        return getKeys();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ PureShowWidgetFullscreenPayload remove(Object obj) {
        if (obj instanceof String) {
            return remove((String) obj);
        }
        return null;
    }

    public /* bridge */ PureShowWidgetFullscreenPayload remove(String str) {
        return (PureShowWidgetFullscreenPayload) super.remove((Object) str);
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
        if ((obj instanceof String) && (obj2 instanceof PureShowWidgetFullscreenPayload)) {
            return remove((String) obj, (PureShowWidgetFullscreenPayload) obj2);
        }
        return false;
    }

    public /* bridge */ boolean remove(String str, PureShowWidgetFullscreenPayload pureShowWidgetFullscreenPayload) {
        return super.remove((Object) str, (Object) pureShowWidgetFullscreenPayload);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Collection<PureShowWidgetFullscreenPayload> values() {
        return getValues();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PureShowWidgetFullscreenActivity$Companion$payloadCache$1() {
        super(5, 0.75f, true);
    }

    @Override // java.util.LinkedHashMap
    protected boolean removeEldestEntry(Map.Entry<String, PureShowWidgetFullscreenPayload> eldest) {
        return size() > 5;
    }
}
