package com.bytedance.geckox;

import android.content.Context;
import android.net.Uri;
import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.utils.ChannelState;
import com.bytedance.geckox.utils.FileUtils;
import com.bytedance.geckox.utils.SPManager;
import com.bytedance.geckox.utils.UnZipUtils;
import com.bytedance.iesgurd.core.CacheManager;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: GeckoBuildInManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001:\u00019B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004H\u0002J\u0018\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004H\u0002J \u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004H\u0002J(\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u001f\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0002\u0010 J0\u0010!\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u00040\"2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004H\u0002J\u001e\u0010#\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004J \u0010$\u001a\u00020%2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004H\u0002J$\u0010'\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u00042\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00040*J\u0018\u0010+\u001a\u00020%2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010,\u001a\u00020\u0004H\u0002J&\u0010-\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004J\u0017\u0010.\u001a\u0004\u0018\u00010\u001c2\u0006\u0010/\u001a\u000200H\u0002¢\u0006\u0002\u00101J\u0018\u00102\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004H\u0002J(\u00103\u001a\u00020%2\u0006\u00104\u001a\u00020%2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004H\u0002J\u0016\u00105\u001a\u00020\u001e2\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004J\u0010\u00106\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u0004H\u0002J\u0010\u00108\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/bytedance/geckox/GeckoBuildInManager;", "", "()V", "ASSETS_FILE", "", "ASSETS_ROOT_DIR_OLD", "CHANNEL_TEMP_FILE", "DELETED_BUILD_IN_CHANNEL_PATH", "EMPTY_BUILD_IN_PATH", "KEY_BUILD_IN_APP_VERSION", "ROOT_DIR", "channelCache", "", "Lcom/bytedance/geckox/GeckoBuildInManager$GeckoBuildInPath;", "isReinstall", "Ljava/util/concurrent/atomic/AtomicBoolean;", "lockMap", "buildInAccessKeyPath", "accessKey", "buildInBundlePath", "channelPath", "bundle", "buildInChannelPath", "channel", "context", "Landroid/content/Context;", "channelResPath", "version", "", "clean", "", "newVersion", "(Ljava/lang/String;Ljava/lang/Long;)V", "decompressAssets2Storage", "Lkotlin/Pair;", "decompressChannel", "dirExistInAssets", "", "internalDir", "disableOfflineChannels", "appVersion", "accessKeys", "", "fileExistInAssets", "bundlePath", "getBuildInPath", "getChannelVersion", "channelDir", "Ljava/io/File;", "(Ljava/io/File;)Ljava/lang/Long;", "getLock", "offlineChannel", "isRemove", "removeCache", "wrapAsset", "path", "wrapFile", "GeckoBuildInPath", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class GeckoBuildInManager {
    private static final String ASSETS_FILE = "res.zst";
    private static final String ASSETS_ROOT_DIR_OLD = "offline";
    private static final String CHANNEL_TEMP_FILE = "res_temp";
    private static final String DELETED_BUILD_IN_CHANNEL_PATH = "deleted_path";
    private static final String EMPTY_BUILD_IN_PATH = "empty_path";
    private static final String KEY_BUILD_IN_APP_VERSION = "build_in_app_version";
    private static final String ROOT_DIR = "gecko_build_in";
    public static final GeckoBuildInManager INSTANCE = new GeckoBuildInManager();
    private static final Map<String, Object> lockMap = new LinkedHashMap();
    private static final AtomicBoolean isReinstall = new AtomicBoolean(false);
    private static final Map<String, GeckoBuildInPath> channelCache = new ConcurrentHashMap();

    private GeckoBuildInManager() {
    }

    /* compiled from: GeckoBuildInManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J2\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/geckox/GeckoBuildInManager$GeckoBuildInPath;", "", "path", "", "version", "", "failMsg", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V", "getFailMsg", "()Ljava/lang/String;", "getPath", "getVersion", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)Lcom/bytedance/geckox/GeckoBuildInManager$GeckoBuildInPath;", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final /* data */ class GeckoBuildInPath {
        private final String failMsg;
        private final String path;
        private final Long version;

        public static /* synthetic */ GeckoBuildInPath copy$default(GeckoBuildInPath geckoBuildInPath, String str, Long l, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = geckoBuildInPath.path;
            }
            if ((i & 2) != 0) {
                l = geckoBuildInPath.version;
            }
            if ((i & 4) != 0) {
                str2 = geckoBuildInPath.failMsg;
            }
            return geckoBuildInPath.copy(str, l, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getPath() {
            return this.path;
        }

        /* renamed from: component2, reason: from getter */
        public final Long getVersion() {
            return this.version;
        }

        /* renamed from: component3, reason: from getter */
        public final String getFailMsg() {
            return this.failMsg;
        }

        public final GeckoBuildInPath copy(String path, Long version, String failMsg) {
            return new GeckoBuildInPath(path, version, failMsg);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GeckoBuildInPath)) {
                return false;
            }
            GeckoBuildInPath geckoBuildInPath = (GeckoBuildInPath) other;
            return Intrinsics.areEqual(this.path, geckoBuildInPath.path) && Intrinsics.areEqual(this.version, geckoBuildInPath.version) && Intrinsics.areEqual(this.failMsg, geckoBuildInPath.failMsg);
        }

        public int hashCode() {
            String str = this.path;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            Long l = this.version;
            int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 31;
            String str2 = this.failMsg;
            return hashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "GeckoBuildInPath(path=" + this.path + ", version=" + this.version + ", failMsg=" + this.failMsg + ")";
        }

        public GeckoBuildInPath(String str, Long l, String str2) {
            this.path = str;
            this.version = l;
            this.failMsg = str2;
        }

        public final String getPath() {
            return this.path;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public /* synthetic */ GeckoBuildInPath(String str, Long l, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, l, str2);
            if ((i & 2) != 0) {
                l = null;
            }
            if ((i & 4) != 0) {
                str2 = null;
            }
        }

        public final Long getVersion() {
            return this.version;
        }

        public final String getFailMsg() {
            return this.failMsg;
        }
    }

    public final GeckoBuildInPath getBuildInPath(Context context, String accessKey, String channel, String bundle) {
        String str;
        Map<String, GeckoBuildInPath> map;
        Long l;
        String str2;
        String str3;
        String failMsg;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        Intrinsics.checkParameterIsNotNull(channel, "channel");
        Intrinsics.checkParameterIsNotNull(bundle, "bundle");
        String str9 = File.separator;
        Intrinsics.checkExpressionValueIsNotNull(str9, "File.separator");
        String str10 = StringsKt.startsWith$default(bundle, str9, false, 2, (Object) null) ? bundle : File.separator + bundle;
        Map<String, GeckoBuildInPath> map2 = channelCache;
        if (map2.containsKey(accessKey + channel)) {
            GeckoBuildInPath geckoBuildInPath = map2.get(accessKey + channel);
            if (!Intrinsics.areEqual(geckoBuildInPath != null ? geckoBuildInPath.getPath() : null, DELETED_BUILD_IN_CHANNEL_PATH)) {
                if (!Intrinsics.areEqual(geckoBuildInPath != null ? geckoBuildInPath.getPath() : null, EMPTY_BUILD_IN_PATH)) {
                    StringBuilder sb = new StringBuilder();
                    if (geckoBuildInPath == null) {
                        Intrinsics.throwNpe();
                    }
                    str2 = EMPTY_BUILD_IN_PATH;
                    Uri parse = Uri.parse(sb.append(geckoBuildInPath.getPath()).append(str10).toString());
                    Intrinsics.checkExpressionValueIsNotNull(parse, "Uri.parse(\"${channelData!!.path}$newBundle\")");
                    String path = parse.getPath();
                    if (path != null) {
                        str3 = DELETED_BUILD_IN_CHANNEL_PATH;
                        String scheme = parse.getScheme();
                        if (scheme == null) {
                            str = str10;
                            map = map2;
                        } else {
                            map = map2;
                            int hashCode = scheme.hashCode();
                            str = str10;
                            if (hashCode == 3143036) {
                                if (scheme.equals("file")) {
                                    if (new File(parse.getPath()).exists()) {
                                        return new GeckoBuildInPath(parse.toString(), geckoBuildInPath.getVersion(), null, 4, null);
                                    }
                                    return new GeckoBuildInPath(null, null, "build-in bundle does not exist in file path:" + geckoBuildInPath.getPath() + ",accessKey:" + accessKey + ",channel:" + channel + ",bundle:" + bundle);
                                }
                            } else if (hashCode == 93121264 && scheme.equals("asset")) {
                                if (INSTANCE.fileExistInAssets(context, path)) {
                                    return new GeckoBuildInPath(parse.toString(), geckoBuildInPath.getVersion(), null, 4, null);
                                }
                                return new GeckoBuildInPath(null, null, "build-in bundle does not exist in assets path:" + geckoBuildInPath.getPath() + ",accessKey:" + accessKey + ",channel:" + channel + ",bundle:" + bundle);
                            }
                        }
                        GeckoLogger.m296d("build-in cached channel path:" + geckoBuildInPath.getPath() + " is incorrect,accessKey:" + accessKey + ",channel:" + channel + ",bundle:" + bundle);
                    } else {
                        str = str10;
                        map = map2;
                        str3 = DELETED_BUILD_IN_CHANNEL_PATH;
                    }
                    l = null;
                }
            }
            String failMsg2 = geckoBuildInPath.getFailMsg();
            if (failMsg2 == null) {
                failMsg2 = "";
            }
            GeckoLogger.m296d(failMsg2);
            return new GeckoBuildInPath(null, null, geckoBuildInPath.getFailMsg());
        }
        str = str10;
        map = map2;
        l = null;
        str2 = EMPTY_BUILD_IN_PATH;
        str3 = DELETED_BUILD_IN_CHANNEL_PATH;
        String str11 = "offline" + File.separator + channel;
        if (dirExistInAssets(context, "offline", channel)) {
            String str12 = str;
            if (fileExistInAssets(context, str11 + str12)) {
                str4 = wrapAsset(str11 + str12);
                str5 = str11;
                failMsg = l;
            } else {
                str7 = "build-in bundle does not exist in assets path:" + str11 + ",accessKey:" + accessKey + ",channel:" + channel;
                str5 = str11;
                failMsg = str7;
                str4 = l;
            }
        } else {
            String str13 = str;
            String buildInChannelPath = buildInChannelPath(accessKey, channel);
            String str14 = buildInChannelPath + File.separator + "res";
            if (dirExistInAssets(context, buildInChannelPath, "res")) {
                str11 = wrapAsset(str14);
                if (fileExistInAssets(context, str14 + str13)) {
                    str4 = wrapAsset(buildInBundlePath(str14, str13));
                    str5 = str11;
                    failMsg = l;
                } else {
                    str7 = "build-in bundle does not exist in assets path:" + str14 + ",accessKey:" + accessKey + ",channel:" + channel;
                    str5 = str11;
                    failMsg = str7;
                    str4 = l;
                }
            } else if (offlineChannel(false, context, accessKey, channel)) {
                failMsg = "build-in channel is offline in current App version,accessKey:" + accessKey + ",channel:" + channel;
                str4 = l;
                str5 = str3;
            } else {
                GeckoBuildInPath decompressChannel = decompressChannel(context, accessKey, channel);
                failMsg = decompressChannel.getFailMsg();
                String path2 = decompressChannel.getPath();
                if (path2 != null) {
                    Long version = decompressChannel.getVersion();
                    Uri parse2 = Uri.parse(path2);
                    Intrinsics.checkExpressionValueIsNotNull(parse2, "Uri.parse(it)");
                    File file = new File(parse2.getPath(), str13);
                    if (file.exists()) {
                        GeckoBuildInManager geckoBuildInManager = INSTANCE;
                        String absolutePath = file.getAbsolutePath();
                        Intrinsics.checkExpressionValueIsNotNull(absolutePath, "file.absolutePath");
                        str6 = geckoBuildInManager.wrapFile(absolutePath);
                    } else {
                        failMsg = "build-in bundle does not exist in file path:" + path2 + ",accessKey:" + accessKey + ",channel:" + channel + ",bundle:" + str13;
                        str6 = l;
                    }
                    l = version;
                    str4 = str6;
                    str5 = path2;
                } else {
                    str4 = l;
                    str5 = str4;
                }
            }
        }
        String str15 = accessKey + channel;
        if (str5 == null) {
            str8 = str2;
        } else {
            if (str5 == null) {
                Intrinsics.throwNpe();
            }
            str8 = str5;
        }
        map.put(str15, new GeckoBuildInPath(str8, l, failMsg));
        return new GeckoBuildInPath(str4, l, failMsg);
    }

    public final GeckoBuildInPath decompressChannel(Context context, String accessKey, String channel) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        Intrinsics.checkParameterIsNotNull(channel, "channel");
        Map<String, GeckoBuildInPath> map = channelCache;
        if (map.get(accessKey + channel) == null) {
            synchronized (getLock(accessKey, channel)) {
                if (map.get(accessKey + channel) == null) {
                    GeckoBuildInManager geckoBuildInManager = INSTANCE;
                    Pair<Long, String> decompressAssets2Storage = geckoBuildInManager.decompressAssets2Storage(context, accessKey, channel);
                    Long l = (Long) decompressAssets2Storage.getFirst();
                    if (l != null) {
                        map.put(accessKey + channel, new GeckoBuildInPath(geckoBuildInManager.wrapFile(geckoBuildInManager.channelResPath(context, accessKey, channel, l.longValue())), (Long) decompressAssets2Storage.getFirst(), (String) decompressAssets2Storage.getSecond()));
                        GeckoBuildInPath geckoBuildInPath = map.get(accessKey + channel);
                        if (geckoBuildInPath == null) {
                            Intrinsics.throwNpe();
                        }
                        return geckoBuildInPath;
                    }
                    return new GeckoBuildInPath(null, null, (String) decompressAssets2Storage.getSecond());
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        GeckoBuildInPath geckoBuildInPath2 = map.get(accessKey + channel);
        if (geckoBuildInPath2 == null) {
            Intrinsics.throwNpe();
        }
        if (!Intrinsics.areEqual(geckoBuildInPath2.getPath(), EMPTY_BUILD_IN_PATH)) {
            GeckoBuildInPath geckoBuildInPath3 = map.get(accessKey + channel);
            if (geckoBuildInPath3 == null) {
                Intrinsics.throwNpe();
            }
            if (!Intrinsics.areEqual(geckoBuildInPath3.getPath(), DELETED_BUILD_IN_CHANNEL_PATH)) {
                GeckoBuildInPath geckoBuildInPath4 = map.get(accessKey + channel);
                if (geckoBuildInPath4 == null) {
                    Intrinsics.throwNpe();
                }
                return geckoBuildInPath4;
            }
        }
        GeckoBuildInPath geckoBuildInPath5 = map.get(accessKey + channel);
        if (geckoBuildInPath5 == null) {
            Intrinsics.throwNpe();
        }
        return new GeckoBuildInPath(null, null, geckoBuildInPath5.getFailMsg());
    }

    public final void disableOfflineChannels(Context context, String appVersion, List<String> accessKeys) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(appVersion, "appVersion");
        Intrinsics.checkParameterIsNotNull(accessKeys, "accessKeys");
        String string = SPManager.inst().getString(context.getApplicationContext(), KEY_BUILD_IN_APP_VERSION, null);
        if (Intrinsics.areEqual(string, appVersion)) {
            return;
        }
        GeckoLogger.m296d("build-in reinstall app,disable offline channels,app version:" + appVersion + ",cache app version:" + string + ",accessKeys:" + accessKeys);
        isReinstall.set(true);
        for (String str : accessKeys) {
            File[] listFiles = new File(context.getFilesDir(), ROOT_DIR + File.separator + str).listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    Intrinsics.checkExpressionValueIsNotNull(file, "it");
                    if (file.isDirectory()) {
                        String name = file.getName();
                        GeckoBuildInManager geckoBuildInManager = INSTANCE;
                        String buildInAccessKeyPath = geckoBuildInManager.buildInAccessKeyPath(str);
                        Intrinsics.checkExpressionValueIsNotNull(name, "channel");
                        if (!geckoBuildInManager.dirExistInAssets(context, buildInAccessKeyPath, name)) {
                            geckoBuildInManager.offlineChannel(true, context, str, name);
                        }
                    }
                }
            }
        }
        SPManager.inst().putString(context.getApplicationContext(), KEY_BUILD_IN_APP_VERSION, appVersion);
    }

    public final void removeCache(String accessKey, String channel) {
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        Intrinsics.checkParameterIsNotNull(channel, "channel");
        channelCache.remove(accessKey + channel);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x008f A[Catch: all -> 0x01c9, TryCatch #0 {all -> 0x01c9, blocks: (B:3:0x0007, B:5:0x0029, B:8:0x0047, B:19:0x0089, B:21:0x008f, B:23:0x00cb, B:25:0x00dd, B:27:0x00e5, B:30:0x00ed, B:32:0x013f, B:33:0x0142, B:35:0x0189, B:36:0x01bd, B:38:0x01c3, B:18:0x007f), top: B:2:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00cb A[Catch: all -> 0x01c9, TryCatch #0 {all -> 0x01c9, blocks: (B:3:0x0007, B:5:0x0029, B:8:0x0047, B:19:0x0089, B:21:0x008f, B:23:0x00cb, B:25:0x00dd, B:27:0x00e5, B:30:0x00ed, B:32:0x013f, B:33:0x0142, B:35:0x0189, B:36:0x01bd, B:38:0x01c3, B:18:0x007f), top: B:2:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Pair<Long, String> decompressAssets2Storage(Context context, String accessKey, String channel) {
        Long l;
        Object obj;
        Throwable th;
        Unit unit;
        try {
            GeckoLogger.m296d("build-in decompress channel,accessKey:" + accessKey + ",channel:" + channel);
            if (!dirExistInAssets(context, buildInAccessKeyPath(accessKey), channel)) {
                String str = "build-in channel does not exist in assets dir,accessKey:" + accessKey + ",channel:" + channel;
                GeckoLogger.m296d(str);
                return new Pair<>((Object) null, str);
            }
            String buildInChannelPath = buildInChannelPath(accessKey, channel);
            try {
                Result.Companion companion = Result.Companion;
                String[] list = context.getAssets().list(buildInChannelPath);
                if (list != null) {
                    l = null;
                    for (String str2 : list) {
                        try {
                            Intrinsics.checkExpressionValueIsNotNull(str2, "it");
                            l = Long.valueOf(Long.parseLong(str2));
                        } catch (Throwable th2) {
                            th = th2;
                            Result.Companion companion2 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                            th = Result.exceptionOrNull-impl(obj);
                            if (th == null) {
                            }
                        }
                    }
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                    l = null;
                }
                obj = Result.constructor-impl(unit);
            } catch (Throwable th3) {
                th = th3;
                l = null;
            }
            th = Result.exceptionOrNull-impl(obj);
            if (th == null) {
                String str3 = "build-in get channel version failed,accessKey:" + accessKey + ",channel:" + channel + ",path:" + buildInChannelPath + ",error:" + th.getMessage();
                GeckoLogger.m296d(str3);
                return new Pair<>((Object) null, str3);
            }
            File file = new File(channelPath(context, accessKey, channel));
            Long channelVersion = file.exists() ? getChannelVersion(file) : null;
            if (l != null && !Intrinsics.areEqual(channelVersion, l)) {
                InputStream open = context.getAssets().open(buildInChannelPath + File.separator + l + File.separator + ASSETS_FILE);
                Intrinsics.checkExpressionValueIsNotNull(open, "context.assets.open(\n   …S_FILE\"\n                )");
                File file2 = new File(file, l + ChannelState.UPDATING);
                FileUtils.delete(file2);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                File file3 = new File(file2, CHANNEL_TEMP_FILE);
                file3.createNewFile();
                UnZipUtils.INSTANCE.decompressZstd(open, file3);
                UnZipUtils unZipUtils = UnZipUtils.INSTANCE;
                FileInputStream fileInputStream = new FileInputStream(file3);
                String absolutePath = file2.getAbsolutePath();
                Intrinsics.checkExpressionValueIsNotNull(absolutePath, "versionDirUpdating.absolutePath");
                unZipUtils.unzip(fileInputStream, absolutePath, channel);
                new File(file2, channel).renameTo(new File(file2, "res"));
                file2.renameTo(new File(file, String.valueOf(l)));
                file3.delete();
                if (channelVersion != null) {
                    GeckoLogger.m296d("build-in remove old version in storage,accessKey:" + accessKey + ",channel:" + channel + ",old version:" + channelVersion);
                    String absolutePath2 = file.getAbsolutePath();
                    Intrinsics.checkExpressionValueIsNotNull(absolutePath2, "channelDir.absolutePath");
                    clean(absolutePath2, l);
                }
                return new Pair<>(l, (Object) null);
            }
            return new Pair<>(channelVersion, (Object) null);
        } catch (Throwable th4) {
            String str4 = "decompress build-in resource failed:" + th4.getMessage() + ",accessKey:" + accessKey + ",channel:" + channel;
            GeckoLogger.m300w(str4);
            return new Pair<>((Object) null, str4);
        }
    }

    private final boolean offlineChannel(boolean isRemove, Context context, String accessKey, String channel) {
        if (isReinstall.get()) {
            return false;
        }
        File file = new File(channelPath(context, accessKey, channel));
        if (!file.exists()) {
            return false;
        }
        Map<String, GeckoBuildInPath> map = channelCache;
        GeckoBuildInPath geckoBuildInPath = map.get(accessKey + channel);
        if (Intrinsics.areEqual(geckoBuildInPath != null ? geckoBuildInPath.getPath() : null, DELETED_BUILD_IN_CHANNEL_PATH)) {
            GeckoLogger.m296d("build-in channel is offline return,accessKey:" + accessKey + ",channel:" + channel);
            if (isRemove) {
                FileUtils.delete(file);
                GeckoLogger.m296d("build-in offline channel is deleted,accessKey:" + accessKey + ",channel:" + channel);
            }
            return true;
        }
        Long channelVersion = getChannelVersion(file);
        if (channelVersion != null) {
            channelVersion.longValue();
            GeckoBuildInManager geckoBuildInManager = INSTANCE;
            if (!geckoBuildInManager.dirExistInAssets(context, geckoBuildInManager.buildInAccessKeyPath(accessKey), channel)) {
                GeckoLogger.m296d("build-in channel is offline check,accessKey:" + accessKey + ",channel:" + channel);
                map.put(accessKey + channel, new GeckoBuildInPath(DELETED_BUILD_IN_CHANNEL_PATH, null, "build-in channel is offline in current App version,accessKey:" + accessKey + ",channel:" + channel));
                if (isRemove) {
                    FileUtils.delete(file);
                    GeckoLogger.m296d("build-in offline channel is deleted,accessKey:" + accessKey + ",channel:" + channel + ",storage dir:" + file);
                }
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0088  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Long getChannelVersion(File channelDir) {
        boolean z;
        Long l = null;
        File[] listFiles = channelDir.listFiles();
        boolean z2 = false;
        if (listFiles != null) {
            z = listFiles.length > 1;
            if (listFiles != null) {
                Long l2 = null;
                Long l3 = null;
                for (File file : listFiles) {
                    Intrinsics.checkExpressionValueIsNotNull(file, "it");
                    if (file.isDirectory()) {
                        String name = file.getName();
                        Intrinsics.checkExpressionValueIsNotNull(name, "it.name");
                        if (!StringsKt.endsWith$default(name, ChannelState.PENDING_DELETE, false, 2, (Object) null)) {
                            String name2 = file.getName();
                            Intrinsics.checkExpressionValueIsNotNull(name2, "it.name");
                            if (!StringsKt.endsWith$default(name2, ChannelState.UPDATING, false, 2, (Object) null)) {
                                if (l3 != null) {
                                    if (l3 == null) {
                                        Intrinsics.throwNpe();
                                    }
                                    if (l3.longValue() >= file.lastModified()) {
                                    }
                                }
                                l3 = Long.valueOf(file.lastModified());
                                String name3 = file.getName();
                                Intrinsics.checkExpressionValueIsNotNull(name3, "it.name");
                                l2 = Long.valueOf(Long.parseLong(name3));
                            }
                        }
                    }
                }
                l = l2;
                if (!z) {
                    String absolutePath = channelDir.getAbsolutePath();
                    Intrinsics.checkExpressionValueIsNotNull(absolutePath, "channelDir.absolutePath");
                    clean(absolutePath, l);
                }
                return l;
            }
            z2 = z;
        }
        z = z2;
        if (!z) {
        }
        return l;
    }

    private final boolean dirExistInAssets(Context context, String internalDir, String channel) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl(context.getAssets().list(internalDir));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        String[] strArr = (String[]) obj;
        return strArr != null && ArraysKt.contains(strArr, channel);
    }

    private final boolean fileExistInAssets(Context context, String bundlePath) {
        String str = File.separator;
        Intrinsics.checkExpressionValueIsNotNull(str, "File.separator");
        if (StringsKt.startsWith$default(bundlePath, str, false, 2, (Object) null)) {
            if (bundlePath == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            bundlePath = bundlePath.substring(1);
            Intrinsics.checkExpressionValueIsNotNull(bundlePath, "(this as java.lang.String).substring(startIndex)");
        }
        try {
            InputStream open = context.getAssets().open(bundlePath);
            try {
                InputStream inputStream = open;
                CloseableKt.closeFinally(open, (Throwable) null);
                return true;
            } finally {
            }
        } catch (IOException unused) {
            return false;
        }
    }

    private final String wrapAsset(String path) {
        String uri = new Uri.Builder().scheme("asset").authority("").path(path).build().toString();
        Intrinsics.checkExpressionValueIsNotNull(uri, "Uri.Builder().scheme(\"as…(path).build().toString()");
        return uri;
    }

    private final String wrapFile(String path) {
        if (!StringsKt.contains$default(path, "@", false, 2, (Object) null)) {
            String uri = Uri.fromFile(new File(path)).toString();
            Intrinsics.checkExpressionValueIsNotNull(uri, "Uri.fromFile(File(path)).toString()");
            return uri;
        }
        return "file:///" + path;
    }

    private final String channelPath(Context context, String accessKey, String channel) {
        return context.getFilesDir() + File.separator + ROOT_DIR + File.separator + accessKey + File.separator + channel;
    }

    private final String channelResPath(Context context, String accessKey, String channel, long version) {
        return channelPath(context, accessKey, channel) + File.separator + version + File.separator + "res";
    }

    private final String buildInBundlePath(String channelPath, String bundle) {
        return channelPath + bundle;
    }

    private final String buildInChannelPath(String accessKey, String channel) {
        return buildInAccessKeyPath(accessKey) + File.separator + channel;
    }

    private final String buildInAccessKeyPath(String accessKey) {
        return ROOT_DIR + File.separator + accessKey;
    }

    private final Object getLock(String accessKey, String channel) {
        Object obj;
        Map<String, Object> map = lockMap;
        synchronized (map) {
            obj = map.get(accessKey + channel);
            if (obj == null) {
                obj = new Object();
                map.put(accessKey + channel, obj);
            }
        }
        return obj;
    }

    private final void clean(String channelPath, Long newVersion) {
        String valueOf = String.valueOf(newVersion);
        File[] listFiles = new File(channelPath).listFiles(new FileFilter() { // from class: com.bytedance.geckox.GeckoBuildInManager$clean$subFiles$1
            @Override // java.io.FileFilter
            public final boolean accept(File file) {
                Intrinsics.checkExpressionValueIsNotNull(file, "pathname");
                return file.isDirectory();
            }
        });
        int i = 0;
        if (listFiles != null) {
            int length = listFiles.length;
            int i2 = 0;
            while (i < length) {
                File file = listFiles[i];
                Intrinsics.checkExpressionValueIsNotNull(file, "it");
                if (!Intrinsics.areEqual(file.getName(), valueOf)) {
                    GeckoLogger.m296d("delete buildin file: " + file.getAbsolutePath());
                    CacheManager.INSTANCE.renameFileToPending(file);
                    i2 = 1;
                }
                i++;
            }
            i = i2;
        }
        if (i != 0) {
            CacheManager.INSTANCE.deletePendingFiles();
        }
    }
}
