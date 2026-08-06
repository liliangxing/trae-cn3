package com.bytedance.vcloud.uniplayer;

import com.bytedance.vcloud.impl.PlayRequestJsonBuilder;
import com.bytedance.vcloud.impl.UniVideoModel_androidKt;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VideoModel.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eJ\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H'J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\b\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0007H&J\b\u0010\f\u001a\u00020\rH&¨\u0006\u000f"}, d2 = {"Lcom/bytedance/vcloud/uniplayer/VideoModel;", "Ljava/lang/AutoCloseable;", "close", "", "dispose", "getAllGears", "", "", "isValid", "", "setUniqueId", "uniqueId", "uniqueIdLength", "", "Companion", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes6.dex */
public interface VideoModel extends AutoCloseable {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Override // java.lang.AutoCloseable
    void close();

    @Deprecated(message = "Use close() or a use{} block instead.", replaceWith = @ReplaceWith(expression = "close()", imports = {}))
    void dispose();

    List<String> getAllGears();

    boolean isValid();

    void setUniqueId(String uniqueId);

    int uniqueIdLength();

    /* compiled from: VideoModel.kt */
    @Metadata(k = 3, mv = {1, 7, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class DefaultImpls {
        public static List<String> getAllGears(VideoModel videoModel) {
            return CollectionsKt.emptyList();
        }
    }

    /* compiled from: VideoModel.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bJN\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0014J\"\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0006JP\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u001a"}, d2 = {"Lcom/bytedance/vcloud/uniplayer/VideoModel$Companion;", "", "()V", "fromJson", "Lcom/bytedance/vcloud/uniplayer/VideoModel;", "json", "", "version", "Lcom/bytedance/vcloud/uniplayer/VideoModelVersion;", "fromKeyUrl", "key", "url", "headers", "", "needSetToken", "", "decryptionKey", "decryptionKeyNotEncoded", "fromPlayRequest", "playRequest", "Lcom/bytedance/vcloud/uniplayer/IPlayRequest;", "fromVidQuery", "vid", "query", "apiHost", "fromVidUrl", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public static /* synthetic */ VideoModel fromJson$default(Companion companion, String str, VideoModelVersion videoModelVersion, int i, Object obj) {
            if ((i & 2) != 0) {
                videoModelVersion = VideoModelVersion.V3;
            }
            return companion.fromJson(str, videoModelVersion);
        }

        public final VideoModel fromJson(String json, VideoModelVersion version) {
            Intrinsics.checkNotNullParameter(json, "json");
            Intrinsics.checkNotNullParameter(version, "version");
            return UniVideoModel_androidKt.createVideoModelFromJson(json, version);
        }

        public static /* synthetic */ VideoModel fromKeyUrl$default(Companion companion, String str, String str2, Map map, boolean z, String str3, String str4, int i, Object obj) {
            if ((i & 4) != 0) {
                map = MapsKt.emptyMap();
            }
            Map map2 = map;
            if ((i & 8) != 0) {
                z = false;
            }
            return companion.fromKeyUrl(str, str2, map2, z, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4);
        }

        public final VideoModel fromKeyUrl(String key, String url, Map<String, String> headers, boolean needSetToken, String decryptionKey, String decryptionKeyNotEncoded) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(headers, "headers");
            if (key.length() == 0) {
                if (url.length() > 0) {
                    key = String.valueOf(url.hashCode());
                }
            }
            return UniVideoModel_androidKt.createVideoModelFromVidUrl(key, url, headers, needSetToken, decryptionKey, decryptionKeyNotEncoded);
        }

        public static /* synthetic */ VideoModel fromVidUrl$default(Companion companion, String str, String str2, Map map, boolean z, String str3, String str4, int i, Object obj) {
            if ((i & 4) != 0) {
                map = MapsKt.emptyMap();
            }
            Map map2 = map;
            if ((i & 8) != 0) {
                z = false;
            }
            return companion.fromVidUrl(str, str2, map2, z, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4);
        }

        @Deprecated(message = "Use fromKeyUrl instead.", replaceWith = @ReplaceWith(expression = "fromKeyUrl(vid, url, headers, needSetToken, decryptionKey, decryptionKeyNotEncoded)", imports = {}))
        public final VideoModel fromVidUrl(String vid, String url, Map<String, String> headers, boolean needSetToken, String decryptionKey, String decryptionKeyNotEncoded) {
            Intrinsics.checkNotNullParameter(vid, "vid");
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(headers, "headers");
            return fromKeyUrl(vid, url, headers, needSetToken, decryptionKey, decryptionKeyNotEncoded);
        }

        public static /* synthetic */ VideoModel fromVidQuery$default(Companion companion, String str, String str2, String str3, int i, Object obj) {
            if ((i & 4) != 0) {
                str3 = null;
            }
            return companion.fromVidQuery(str, str2, str3);
        }

        public final VideoModel fromVidQuery(String vid, String query, String apiHost) {
            Intrinsics.checkNotNullParameter(vid, "vid");
            Intrinsics.checkNotNullParameter(query, "query");
            return UniVideoModel_androidKt.createVideoModelFromVidQuery(vid, query, apiHost);
        }

        public final VideoModel fromPlayRequest(IPlayRequest playRequest) {
            Intrinsics.checkNotNullParameter(playRequest, "playRequest");
            return UniVideoModel_androidKt.createVideoModelFromJson(PlayRequestJsonBuilder.INSTANCE.build(playRequest), VideoModelVersion.V3);
        }
    }
}
