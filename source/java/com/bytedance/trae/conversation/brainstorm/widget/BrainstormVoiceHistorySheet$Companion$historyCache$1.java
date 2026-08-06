package com.bytedance.trae.conversation.brainstorm.widget;

import com.bytedance.trae.conversation.brainstorm.widget.BrainstormVoiceHistorySheet;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

/* compiled from: BrainstormVoiceHistorySheet.kt */
@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010'\n\u0000*\u0001\u0000\b\n\u0018\u00002\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0004J\u001e\u0010\u0005\u001a\u00020\u00062\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bH\u0014¨\u0006\t"}, d2 = {"com/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$Companion$historyCache$1", "Ljava/util/LinkedHashMap;", "", "Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$VoiceHistorySnapshot;", "Lkotlin/collections/LinkedHashMap;", "removeEldestEntry", "", "eldest", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BrainstormVoiceHistorySheet$Companion$historyCache$1 extends LinkedHashMap<String, BrainstormVoiceHistorySheet.VoiceHistorySnapshot> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public BrainstormVoiceHistorySheet$Companion$historyCache$1() {
        super(16, 0.75f, true);
    }

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

    public /* bridge */ boolean containsValue(BrainstormVoiceHistorySheet.VoiceHistorySnapshot voiceHistorySnapshot) {
        return super.containsValue((Object) voiceHistorySnapshot);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsValue(Object obj) {
        if (obj instanceof BrainstormVoiceHistorySheet.VoiceHistorySnapshot) {
            return containsValue((BrainstormVoiceHistorySheet.VoiceHistorySnapshot) obj);
        }
        return false;
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<String, BrainstormVoiceHistorySheet.VoiceHistorySnapshot>> entrySet() {
        return getEntries();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ BrainstormVoiceHistorySheet.VoiceHistorySnapshot get(Object obj) {
        if (obj instanceof String) {
            return get((String) obj);
        }
        return null;
    }

    public /* bridge */ BrainstormVoiceHistorySheet.VoiceHistorySnapshot get(String str) {
        return (BrainstormVoiceHistorySheet.VoiceHistorySnapshot) super.get((Object) str);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object get(Object obj) {
        if (obj instanceof String) {
            return get((String) obj);
        }
        return null;
    }

    public /* bridge */ Set<Map.Entry<String, BrainstormVoiceHistorySheet.VoiceHistorySnapshot>> getEntries() {
        return super.entrySet();
    }

    public /* bridge */ Set<String> getKeys() {
        return super.keySet();
    }

    public final /* bridge */ BrainstormVoiceHistorySheet.VoiceHistorySnapshot getOrDefault(Object obj, BrainstormVoiceHistorySheet.VoiceHistorySnapshot voiceHistorySnapshot) {
        return !(obj instanceof String) ? voiceHistorySnapshot : getOrDefault((String) obj, voiceHistorySnapshot);
    }

    public /* bridge */ BrainstormVoiceHistorySheet.VoiceHistorySnapshot getOrDefault(String str, BrainstormVoiceHistorySheet.VoiceHistorySnapshot voiceHistorySnapshot) {
        return (BrainstormVoiceHistorySheet.VoiceHistorySnapshot) super.getOrDefault((Object) str, (String) voiceHistorySnapshot);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
        return !(obj instanceof String) ? obj2 : getOrDefault((String) obj, (BrainstormVoiceHistorySheet.VoiceHistorySnapshot) obj2);
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ Collection<BrainstormVoiceHistorySheet.VoiceHistorySnapshot> getValues() {
        return super.values();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<String> keySet() {
        return getKeys();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ BrainstormVoiceHistorySheet.VoiceHistorySnapshot remove(Object obj) {
        if (obj instanceof String) {
            return remove((String) obj);
        }
        return null;
    }

    public /* bridge */ BrainstormVoiceHistorySheet.VoiceHistorySnapshot remove(String str) {
        return (BrainstormVoiceHistorySheet.VoiceHistorySnapshot) super.remove((Object) str);
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
        if ((obj instanceof String) && (obj2 instanceof BrainstormVoiceHistorySheet.VoiceHistorySnapshot)) {
            return remove((String) obj, (BrainstormVoiceHistorySheet.VoiceHistorySnapshot) obj2);
        }
        return false;
    }

    public /* bridge */ boolean remove(String str, BrainstormVoiceHistorySheet.VoiceHistorySnapshot voiceHistorySnapshot) {
        return super.remove((Object) str, (Object) voiceHistorySnapshot);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Collection<BrainstormVoiceHistorySheet.VoiceHistorySnapshot> values() {
        return getValues();
    }

    @Override // java.util.LinkedHashMap
    protected boolean removeEldestEntry(Map.Entry<String, BrainstormVoiceHistorySheet.VoiceHistorySnapshot> eldest) {
        return size() > 16;
    }
}
