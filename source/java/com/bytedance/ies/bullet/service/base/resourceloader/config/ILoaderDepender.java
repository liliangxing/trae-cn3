package com.bytedance.ies.bullet.service.base.resourceloader.config;

import android.net.Uri;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceLoaderService;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResourceLoaderConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH&J(\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H&J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&J\"\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016J$\u0010\u0019\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u001b\u001a\u00020\u000bH&J$\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u001d2\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH&J\b\u0010\u001e\u001a\u00020\u000bH\u0016J\u0018\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0010\u001a\u00020\u0011H&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\""}, d2 = {"Lcom/bytedance/ies/bullet/service/base/resourceloader/config/ILoaderDepender;", "", "service", "Lcom/bytedance/ies/bullet/kit/resourceloader/ResourceLoaderService;", "getService", "()Lcom/bytedance/ies/bullet/kit/resourceloader/ResourceLoaderService;", "setService", "(Lcom/bytedance/ies/bullet/kit/resourceloader/ResourceLoaderService;)V", "checkIsExists", "", "rootDir", "", "accessKey", "channel", "checkUpdate", "", "config", "Lcom/bytedance/ies/bullet/service/base/resourceloader/config/TaskConfig;", "channelList", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/bytedance/ies/bullet/service/base/resourceloader/config/OnUpdateListener;", "deleteChannel", "getChannelVersion", "", "getGeckoOfflineDir", "offlineDir", "relativePath", "getPreloadConfigs", "", "getSdkVersion", "mergeConfig", "uri", "Landroid/net/Uri;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface ILoaderDepender {
    boolean checkIsExists(String rootDir, String accessKey, String channel);

    void checkUpdate(TaskConfig config, List<String> channelList, OnUpdateListener listener);

    void deleteChannel(TaskConfig config);

    long getChannelVersion(String rootDir, String accessKey, String channel);

    String getGeckoOfflineDir(String offlineDir, String accessKey, String relativePath);

    Map<String, String> getPreloadConfigs(String offlineDir, String accessKey);

    String getSdkVersion();

    ResourceLoaderService getService();

    TaskConfig mergeConfig(Uri uri, TaskConfig config);

    void setService(ResourceLoaderService resourceLoaderService);

    /* compiled from: ResourceLoaderConfig.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static long getChannelVersion(ILoaderDepender iLoaderDepender, String rootDir, String accessKey, String channel) {
            Intrinsics.checkNotNullParameter(rootDir, "rootDir");
            Intrinsics.checkNotNullParameter(accessKey, "accessKey");
            Intrinsics.checkNotNullParameter(channel, "channel");
            return 0L;
        }

        public static String getSdkVersion(ILoaderDepender iLoaderDepender) {
            return "";
        }

        public static /* synthetic */ boolean checkIsExists$default(ILoaderDepender iLoaderDepender, String str, String str2, String str3, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: checkIsExists");
            }
            if ((i & 1) != 0) {
                str = "";
            }
            return iLoaderDepender.checkIsExists(str, str2, str3);
        }

        public static /* synthetic */ String getGeckoOfflineDir$default(ILoaderDepender iLoaderDepender, String str, String str2, String str3, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getGeckoOfflineDir");
            }
            if ((i & 4) != 0) {
                str3 = "";
            }
            return iLoaderDepender.getGeckoOfflineDir(str, str2, str3);
        }

        public static /* synthetic */ long getChannelVersion$default(ILoaderDepender iLoaderDepender, String str, String str2, String str3, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getChannelVersion");
            }
            if ((i & 1) != 0) {
                str = "";
            }
            return iLoaderDepender.getChannelVersion(str, str2, str3);
        }
    }
}
