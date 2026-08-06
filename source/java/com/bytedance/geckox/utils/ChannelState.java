package com.bytedance.geckox.utils;

import com.bytedance.geckox.GeckoGlobalManager;
import com.bytedance.geckox.logger.GeckoLogger;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChannelState.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004J \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0002J\u0018\u0010\u0011\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u0004J\u0016\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004J\u0006\u0010\u0013\u001a\u00020\u000bJ\u0016\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/geckox/utils/ChannelState;", "", "()V", "CONSUMED", "", "PENDING_DELETE", "UPDATING", "lazyChannelAccess", "", "", "channelAccessed", "", "accessKey", "channel", "channelHasBeenConsumed", "", "rootDir", "isChannelAccessed", "isChannelUsed", "resetForTest", "setChannelConsumed", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ChannelState {
    private static final String CONSUMED = ".consumed";
    public static final String PENDING_DELETE = "--pending-delete";
    public static final String UPDATING = "--updating";
    public static final ChannelState INSTANCE = new ChannelState();
    private static final Map<String, List<String>> lazyChannelAccess = new ConcurrentHashMap();

    private ChannelState() {
    }

    private final boolean channelHasBeenConsumed(String rootDir, String accessKey, String channel) {
        return new File(rootDir, accessKey + File.separator + channel + File.separator + CONSUMED).exists();
    }

    public final void setChannelConsumed(String accessKey, String channel) {
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        Intrinsics.checkParameterIsNotNull(channel, "channel");
        GeckoGlobalManager inst = GeckoGlobalManager.inst();
        Intrinsics.checkExpressionValueIsNotNull(inst, "GeckoGlobalManager.inst()");
        String str = inst.getAccessKeyDirs().get(accessKey);
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            return;
        }
        File file = new File(str, accessKey + File.separator + channel + File.separator + CONSUMED);
        if (file.exists()) {
            return;
        }
        try {
            file.createNewFile();
        } catch (Exception e) {
            GeckoLogger.m303w("set channel consumed failed", e);
        }
    }

    public final void channelAccessed(String accessKey, String channel) {
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        Intrinsics.checkParameterIsNotNull(channel, "channel");
        Map<String, List<String>> map = lazyChannelAccess;
        ArrayList arrayList = map.get(accessKey);
        if (arrayList == null) {
            arrayList = new ArrayList();
            map.put(accessKey, arrayList);
        }
        if (arrayList.contains(channel)) {
            return;
        }
        arrayList.add(channel);
    }

    public final boolean isChannelAccessed(String accessKey, String channel) {
        Intrinsics.checkParameterIsNotNull(channel, "channel");
        Map<String, List<String>> map = lazyChannelAccess;
        if (map.isEmpty()) {
            return false;
        }
        List<String> list = map.get(accessKey);
        List<String> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return false;
        }
        return list.contains(channel);
    }

    public final boolean isChannelUsed(String accessKey, String channel) {
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        Intrinsics.checkParameterIsNotNull(channel, "channel");
        if (isChannelAccessed(accessKey, channel)) {
            return true;
        }
        GeckoGlobalManager inst = GeckoGlobalManager.inst();
        Intrinsics.checkExpressionValueIsNotNull(inst, "GeckoGlobalManager.inst()");
        String str = inst.getAccessKeyDirs().get(accessKey);
        if (str != null) {
            return channelHasBeenConsumed(str, accessKey, channel);
        }
        return false;
    }

    public final void resetForTest() {
        lazyChannelAccess.clear();
    }
}
