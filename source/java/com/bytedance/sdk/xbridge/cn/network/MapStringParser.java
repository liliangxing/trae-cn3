package com.bytedance.sdk.xbridge.cn.network;

import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: StringParser.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001b\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u0014\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\u0016R\u001f\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/network/MapStringParser;", "Lcom/bytedance/sdk/xbridge/cn/network/StringParser;", "map", "", "", "", "(Ljava/util/Map;)V", "getMap", "()Ljava/util/Map;", "convert", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public final class MapStringParser implements StringParser {
    private final Map<String, Object> map;

    public MapStringParser(Map<String, ? extends Object> map) {
        this.map = map;
    }

    public final Map<String, Object> getMap() {
        return this.map;
    }

    @Override // com.bytedance.sdk.xbridge.cn.network.StringParser
    public Map<String, String> convert() {
        HashMap hashMap = new HashMap();
        Map<String, Object> map = this.map;
        if (map != null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue().toString());
            }
        }
        return hashMap;
    }
}
