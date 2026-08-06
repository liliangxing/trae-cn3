package com.bytedance.vcloud.impl;

import com.bytedance.vcloud.uniplayer.VideoModel;
import com.bytedance.vcloud.uniplayer.VideoModelVersion;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UniVideoModel.android.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\"\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0003H\u0000\u001aH\u0010\n\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003H\u0000\u001a\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u0003*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\rH\u0002¨\u0006\u0013"}, d2 = {"createVideoModelFromJson", "Lcom/bytedance/vcloud/uniplayer/VideoModel;", "json", "", "version", "Lcom/bytedance/vcloud/uniplayer/VideoModelVersion;", "createVideoModelFromVidQuery", "vid", "query", "apiHost", "createVideoModelFromVidUrl", "url", "headers", "", "needSetToken", "", "decryptionKey", "decryptionKeyNotEncoded", "toHeadersCrlfString", "uniplayer_release"}, k = 2, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class UniVideoModel_androidKt {
    public static final VideoModel createVideoModelFromJson(String str, VideoModelVersion videoModelVersion) {
        Intrinsics.checkNotNullParameter(str, "json");
        Intrinsics.checkNotNullParameter(videoModelVersion, "version");
        return new UniVideoModelImpl(UniVideoModelImpl.INSTANCE.createJson(str, videoModelVersion.ordinal()));
    }

    public static final VideoModel createVideoModelFromVidUrl(String str, String str2, Map<String, String> map, boolean z, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "vid");
        Intrinsics.checkNotNullParameter(str2, "url");
        Intrinsics.checkNotNullParameter(map, "headers");
        return new UniVideoModelImpl(UniVideoModelImpl.INSTANCE.createVidUrl(str, str2, toHeadersCrlfString(map), z, str3, str4));
    }

    public static final VideoModel createVideoModelFromVidQuery(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "vid");
        Intrinsics.checkNotNullParameter(str2, "query");
        return new UniVideoModelImpl(UniVideoModelImpl.INSTANCE.createVidQuery(str, str2, str3));
    }

    private static final String toHeadersCrlfString(Map<String, String> map) {
        if (map.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            sb.append(key).append(": ").append(entry.getValue()).append("\r\n");
        }
        return sb.toString();
    }
}
