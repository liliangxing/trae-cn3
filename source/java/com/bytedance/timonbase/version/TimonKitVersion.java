package com.bytedance.timonbase.version;

import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TimonKitVersion.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\bH\u0007J\b\u0010\t\u001a\u00020\nH\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0007R*\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/timonbase/version/TimonKitVersion;", "", "()V", "timonKitVersion", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getKitVersions", "", "insertTransformedVersion", "", "putKitVersion", "kitName", "kitVersion", "timonbase_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes5.dex */
public final class TimonKitVersion {
    public static final TimonKitVersion INSTANCE;
    private static final HashMap<String, String> timonKitVersion;

    private final void insertTransformedVersion() {
        putKitVersion("timonbase", "4.0.0");
        putKitVersion("upc", "4.0.0");
        putKitVersion("clipboard", "4.0.2");
    }

    static {
        TimonKitVersion timonKitVersion2 = new TimonKitVersion();
        INSTANCE = timonKitVersion2;
        timonKitVersion = new HashMap<>();
        timonKitVersion2.insertTransformedVersion();
    }

    private TimonKitVersion() {
    }

    @JvmStatic
    public static final void putKitVersion(String kitName, String kitVersion) {
        Intrinsics.checkParameterIsNotNull(kitName, "kitName");
        Intrinsics.checkParameterIsNotNull(kitVersion, "kitVersion");
        timonKitVersion.put(kitName, kitVersion);
    }

    @JvmStatic
    public static final Map<String, String> getKitVersions() {
        return timonKitVersion;
    }
}
