package com.bytedance.sdk.xbridge.cn.network;

import com.bytedance.ies.bullet.kit.resourceloader.monitor.RLMonitorReporter;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: StringParser.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/network/StringParserManager;", "", "()V", RLMonitorReporter.PARSE, "Lcom/bytedance/sdk/xbridge/cn/network/StringParser;", "data", "", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public final class StringParserManager {
    public static final StringParserManager INSTANCE = new StringParserManager();

    private StringParserManager() {
    }

    public final StringParser parse(Map<String, ? extends Object> data) {
        return new MapStringParser(data);
    }
}
