package com.bytedance.ies.bullet.service.base;

import android.net.Uri;
import android.webkit.WebResourceResponse;
import com.bytedance.ies.argus.api.ArgusResourceType;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceInputStream;
import com.bytedance.ies.bullet.kit.resourceloader.loggger.RLLogger;
import com.bytedance.ies.bullet.kit.resourceloader.model.RLChannelBundleModel;
import com.bytedance.ies.bullet.kit.resourceloader.monitor.RLMonitorReporter;
import com.bytedance.ies.bullet.kit.resourceloader.monitor.RLReportInfo;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.memory.shrink.HprofMemoryConstants;
import com.bytedance.pia.core.cache.IPiaCacheProvider;
import com.bytedance.praisedialoglib.PraiseDialogConstant;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* compiled from: ResourceInfo.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0012\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000  \u00012\u00020\u0001:\u0002 \u0001B\u0087\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0014\u001a\u00020\r\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0016J\u0007\u0010\u0098\u0001\u001a\u00020\u0005J\u000b\u0010\u0099\u0001\u001a\u0004\u0018\u00010)H\u0016J\u0016\u0010\u009a\u0001\u001a\u00030\u009b\u00012\f\b\u0002\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u009b\u0001J\t\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u0010J\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u0010J\t\u0010\u009f\u0001\u001a\u00020\u0005H\u0016R\u001a\u0010\u0017\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0019\"\u0004\b$\u0010\u001bR\u001a\u0010%\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0019\"\u0004\b'\u0010\u001bR\u001c\u0010(\u001a\u0004\u0018\u00010)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u0010.\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0019\"\u0004\b0\u0010\u001bR\u001a\u00101\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0019\"\u0004\b3\u0010\u001bR\u001c\u00104\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0019\"\u0004\b6\u0010\u001bR\u001a\u00107\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0019\"\u0004\b9\u0010\u001bR\u001a\u0010:\u001a\u00020;X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001a\u0010@\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u0019\"\u0004\bF\u0010\u001bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u001c\u0010O\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u0019\"\u0004\bQ\u0010\u001bR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010B\"\u0004\bR\u0010DR\u001a\u0010S\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010B\"\u0004\bT\u0010DR\u001a\u0010U\u001a\u00020VX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR \u0010[\u001a\b\u0012\u0004\u0012\u00020\u00050\\X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\u001c\u0010a\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010\u0019\"\u0004\bc\u0010\u001bR\u001a\u0010d\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010\u0019\"\u0004\bf\u0010\u001bR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR\u001a\u0010k\u001a\u00020;X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010=\"\u0004\bm\u0010?R\u001a\u0010n\u001a\u00020oX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR\u001a\u0010t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010\u0019\"\u0004\bv\u0010\u001bR\u001a\u0010w\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010\u0019\"\u0004\by\u0010\u001bR\u001a\u0010z\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010\u0019\"\u0004\b|\u0010\u001bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b}\u0010\u0019\"\u0004\b~\u0010\u001bR\u0012\u0010\u0002\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u007f\u0010\u0080\u0001R\u001e\u0010\u0014\u001a\u00020\rX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001\"\u0006\b\u0083\u0001\u0010\u0084\u0001R\u001c\u0010\u000e\u001a\u00020\u000bX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0085\u0001\u0010B\"\u0005\b\u0086\u0001\u0010DR\u001c\u0010\u0013\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0087\u0001\u0010\u0019\"\u0005\b\u0088\u0001\u0010\u001bR \u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001\"\u0006\b\u008b\u0001\u0010\u008c\u0001R\u001d\u0010\u008d\u0001\u001a\u00020\u000bX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008e\u0001\u0010B\"\u0005\b\u008f\u0001\u0010DR\u001e\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0090\u0001\u0010\u0082\u0001\"\u0006\b\u0091\u0001\u0010\u0084\u0001R\"\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0093\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001\"\u0006\b\u0096\u0001\u0010\u0097\u0001¨\u0006¡\u0001"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/ResourceInfo;", "", "srcUri", "Landroid/net/Uri;", "filePath", "", "type", "Lcom/bytedance/ies/bullet/service/base/ResourceType;", PraiseDialogConstant.FROM, "Lcom/bytedance/ies/bullet/service/base/ResourceFrom;", "isCache", "", IPiaCacheProvider.CacheConfig.FIELD_VERSION, "", "statisic", "fileStream", "Ljava/io/InputStream;", "model", "Lcom/bytedance/ies/bullet/kit/resourceloader/model/RLChannelBundleModel;", "successLoader", "startLoadTime", "sessionId", "(Landroid/net/Uri;Ljava/lang/String;Lcom/bytedance/ies/bullet/service/base/ResourceType;Lcom/bytedance/ies/bullet/service/base/ResourceFrom;ZJZLjava/io/InputStream;Lcom/bytedance/ies/bullet/kit/resourceloader/model/RLChannelBundleModel;Ljava/lang/String;JLjava/lang/String;)V", "accessKey", "getAccessKey", "()Ljava/lang/String;", "setAccessKey", "(Ljava/lang/String;)V", "argusResourceType", "Lcom/bytedance/ies/argus/api/ArgusResourceType;", "getArgusResourceType", "()Lcom/bytedance/ies/argus/api/ArgusResourceType;", "setArgusResourceType", "(Lcom/bytedance/ies/argus/api/ArgusResourceType;)V", "buldinFailedMessage", "getBuldinFailedMessage", "setBuldinFailedMessage", SchemaConstants.QUERY_KEY_BUNDLE, "getBundle", "setBundle", "byteArray", "", "getByteArray", "()[B", "setByteArray", "([B)V", "cacheKey", "getCacheKey", "setCacheKey", "cdnFailedMessage", "getCdnFailedMessage", "setCdnFailedMessage", "cdnSafeUrl", "getCdnSafeUrl", "setCdnSafeUrl", "channel", "getChannel", "setChannel", "commonReportInfo", "Lcom/bytedance/ies/bullet/kit/resourceloader/monitor/RLReportInfo;", "getCommonReportInfo", "()Lcom/bytedance/ies/bullet/kit/resourceloader/monitor/RLReportInfo;", "setCommonReportInfo", "(Lcom/bytedance/ies/bullet/kit/resourceloader/monitor/RLReportInfo;)V", "enableMemory", "getEnableMemory", "()Z", "setEnableMemory", "(Z)V", "getFilePath", "setFilePath", "getFileStream", "()Ljava/io/InputStream;", "setFileStream", "(Ljava/io/InputStream;)V", "getFrom", "()Lcom/bytedance/ies/bullet/service/base/ResourceFrom;", "setFrom", "(Lcom/bytedance/ies/bullet/service/base/ResourceFrom;)V", "geckoFailMessage", "getGeckoFailMessage", "setGeckoFailMessage", "setCache", "isFromMemory", "setFromMemory", "loaderName", "Lcom/bytedance/ies/bullet/service/base/LoaderName;", "getLoaderName", "()Lcom/bytedance/ies/bullet/service/base/LoaderName;", "setLoaderName", "(Lcom/bytedance/ies/bullet/service/base/LoaderName;)V", "loaders", "", "getLoaders", "()Ljava/util/List;", "setLoaders", "(Ljava/util/List;)V", "memoryCachePriority", "getMemoryCachePriority", "setMemoryCachePriority", "memoryMessage", "getMemoryMessage", "setMemoryMessage", "getModel", "()Lcom/bytedance/ies/bullet/kit/resourceloader/model/RLChannelBundleModel;", "setModel", "(Lcom/bytedance/ies/bullet/kit/resourceloader/model/RLChannelBundleModel;)V", "performanceInfo", "getPerformanceInfo", "setPerformanceInfo", "pipelineStatus", "Lorg/json/JSONArray;", "getPipelineStatus", "()Lorg/json/JSONArray;", "setPipelineStatus", "(Lorg/json/JSONArray;)V", "preloadFailMessage", "getPreloadFailMessage", "setPreloadFailMessage", "resTag", "getResTag", "setResTag", "sdkVersion", "getSdkVersion", "setSdkVersion", "getSessionId", "setSessionId", "getSrcUri", "()Landroid/net/Uri;", "getStartLoadTime", "()J", "setStartLoadTime", "(J)V", "getStatisic", "setStatisic", "getSuccessLoader", "setSuccessLoader", "getType", "()Lcom/bytedance/ies/bullet/service/base/ResourceType;", "setType", "(Lcom/bytedance/ies/bullet/service/base/ResourceType;)V", "usePreloadCache", "getUsePreloadCache", "setUsePreloadCache", "getVersion", "setVersion", "webResourceResponse", "Landroid/webkit/WebResourceResponse;", "getWebResourceResponse", "()Landroid/webkit/WebResourceResponse;", "setWebResourceResponse", "(Landroid/webkit/WebResourceResponse;)V", "getStatisticFrom", "provideByteArray", "provideFile", "Ljava/io/File;", "rootFile", "provideInputStream", "provideResourceInputStream", "toString", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ResourceInfo {
    public static final String RESOURCE_FROM_ASSET = "buildIn";
    public static final String RESOURCE_FROM_CDN = "cdn";
    public static final String RESOURCE_FROM_CDN_CACHE = "cdnCache";
    public static final String RESOURCE_FROM_CUSTOM = "custom";
    public static final String RESOURCE_FROM_EXTERNAL_TEMPLATE_BUNDLE = "externalTemplateBundle";
    public static final String RESOURCE_FROM_GECKO = "gecko";
    public static final String RESOURCE_FROM_GECKO_UPDATE = "geckoUpdate";
    public static final String RESOURCE_FROM_INTERNAL_TEMPLATE_BUNDLE = "internalTemplateBundle";
    public static final String RESOURCE_FROM_OFFLINE = "offline";
    public static final String RESOURCE_FROM_PRELOAD = "preload";
    public static final String RESOURCE_FROM_UNKNOWN = "unknown";
    private String accessKey;
    private ArgusResourceType argusResourceType;
    private String buldinFailedMessage;
    private String bundle;
    private byte[] byteArray;
    private String cacheKey;
    private String cdnFailedMessage;
    private String cdnSafeUrl;
    private String channel;
    private RLReportInfo commonReportInfo;
    private boolean enableMemory;
    private String filePath;
    private InputStream fileStream;
    private ResourceFrom from;
    private String geckoFailMessage;
    private boolean isCache;
    private boolean isFromMemory;
    private LoaderName loaderName;
    private List<String> loaders;
    private String memoryCachePriority;
    private String memoryMessage;
    private RLChannelBundleModel model;
    private RLReportInfo performanceInfo;
    private JSONArray pipelineStatus;
    private String preloadFailMessage;
    private String resTag;
    private String sdkVersion;
    private String sessionId;
    private final Uri srcUri;
    private long startLoadTime;
    private boolean statisic;
    private String successLoader;
    private ResourceType type;
    private boolean usePreloadCache;
    private long version;
    private WebResourceResponse webResourceResponse;

    /* compiled from: ResourceInfo.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[ResourceType.values().length];
            try {
                iArr[ResourceType.ASSET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ResourceFrom.values().length];
            try {
                iArr2[ResourceFrom.GECKO.ordinal()] = 1;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr2[ResourceFrom.BUILTIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[ResourceFrom.CDN.ordinal()] = 3;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[ResourceFrom.LOCAL_FILE.ordinal()] = 4;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[ResourceFrom.PRELOAD.ordinal()] = 5;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public ResourceInfo(Uri uri, String str, ResourceType resourceType, ResourceFrom resourceFrom, boolean z, long j, boolean z2, InputStream inputStream, RLChannelBundleModel rLChannelBundleModel, String str2, long j2, String str3) {
        Intrinsics.checkNotNullParameter(uri, "srcUri");
        Intrinsics.checkNotNullParameter(str2, "successLoader");
        this.srcUri = uri;
        this.filePath = str;
        this.type = resourceType;
        this.from = resourceFrom;
        this.isCache = z;
        this.version = j;
        this.statisic = z2;
        this.fileStream = inputStream;
        this.model = rLChannelBundleModel;
        this.successLoader = str2;
        this.startLoadTime = j2;
        this.sessionId = str3;
        this.buldinFailedMessage = "";
        this.cdnFailedMessage = "";
        this.preloadFailMessage = "";
        this.memoryMessage = "";
        this.resTag = "";
        this.channel = "";
        this.bundle = "";
        this.accessKey = "";
        this.sdkVersion = "";
        this.commonReportInfo = new RLReportInfo(RLMonitorReporter.EVENT_FETCH, null, null, null, null, null, null, null, HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_HEAP_DUMP_INFO, null);
        this.performanceInfo = new RLReportInfo(RLMonitorReporter.EVENT_PERFORMANCE, null, null, null, null, null, null, null, HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_HEAP_DUMP_INFO, null);
        this.pipelineStatus = new JSONArray() { // from class: com.bytedance.ies.bullet.service.base.ResourceInfo$pipelineStatus$1
            @Override // org.json.JSONArray
            public String toString() {
                try {
                    String jSONArray = super.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONArray, "{\n                super.toString()\n            }");
                    return jSONArray;
                } catch (Throwable unused) {
                    return "";
                }
            }
        };
        this.loaders = new ArrayList();
        this.loaderName = LoaderName.ResourceLoader;
        this.argusResourceType = ArgusResourceType.UNKNOWN;
    }

    public /* synthetic */ ResourceInfo(Uri uri, String str, ResourceType resourceType, ResourceFrom resourceFrom, boolean z, long j, boolean z2, InputStream inputStream, RLChannelBundleModel rLChannelBundleModel, String str2, long j2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(uri, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : resourceType, (i & 8) != 0 ? null : resourceFrom, (i & 16) != 0 ? false : z, (i & 32) != 0 ? 0L : j, (i & 64) != 0 ? true : z2, (i & 128) != 0 ? null : inputStream, (i & 256) != 0 ? null : rLChannelBundleModel, (i & 512) != 0 ? "" : str2, (i & 1024) == 0 ? j2 : 0L, (i & 2048) == 0 ? str3 : null);
    }

    public final Uri getSrcUri() {
        return this.srcUri;
    }

    public final String getFilePath() {
        return this.filePath;
    }

    public final void setFilePath(String str) {
        this.filePath = str;
    }

    public final ResourceType getType() {
        return this.type;
    }

    public final void setType(ResourceType resourceType) {
        this.type = resourceType;
    }

    public final ResourceFrom getFrom() {
        return this.from;
    }

    public final void setFrom(ResourceFrom resourceFrom) {
        this.from = resourceFrom;
    }

    /* renamed from: isCache, reason: from getter */
    public final boolean getIsCache() {
        return this.isCache;
    }

    public final void setCache(boolean z) {
        this.isCache = z;
    }

    public final long getVersion() {
        return this.version;
    }

    public final void setVersion(long j) {
        this.version = j;
    }

    public final boolean getStatisic() {
        return this.statisic;
    }

    public final void setStatisic(boolean z) {
        this.statisic = z;
    }

    public final InputStream getFileStream() {
        return this.fileStream;
    }

    public final void setFileStream(InputStream inputStream) {
        this.fileStream = inputStream;
    }

    public final RLChannelBundleModel getModel() {
        return this.model;
    }

    public final void setModel(RLChannelBundleModel rLChannelBundleModel) {
        this.model = rLChannelBundleModel;
    }

    public final String getSuccessLoader() {
        return this.successLoader;
    }

    public final void setSuccessLoader(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.successLoader = str;
    }

    public final long getStartLoadTime() {
        return this.startLoadTime;
    }

    public final void setStartLoadTime(long j) {
        this.startLoadTime = j;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final void setSessionId(String str) {
        this.sessionId = str;
    }

    public final String getGeckoFailMessage() {
        return this.geckoFailMessage;
    }

    public final void setGeckoFailMessage(String str) {
        this.geckoFailMessage = str;
    }

    public final String getCacheKey() {
        return this.cacheKey;
    }

    public final void setCacheKey(String str) {
        this.cacheKey = str;
    }

    /* renamed from: isFromMemory, reason: from getter */
    public final boolean getIsFromMemory() {
        return this.isFromMemory;
    }

    public final void setFromMemory(boolean z) {
        this.isFromMemory = z;
    }

    public final String getBuldinFailedMessage() {
        return this.buldinFailedMessage;
    }

    public final void setBuldinFailedMessage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.buldinFailedMessage = str;
    }

    public final String getCdnFailedMessage() {
        return this.cdnFailedMessage;
    }

    public final void setCdnFailedMessage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cdnFailedMessage = str;
    }

    public final boolean getUsePreloadCache() {
        return this.usePreloadCache;
    }

    public final void setUsePreloadCache(boolean z) {
        this.usePreloadCache = z;
    }

    public final String getPreloadFailMessage() {
        return this.preloadFailMessage;
    }

    public final void setPreloadFailMessage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.preloadFailMessage = str;
    }

    public final String getMemoryMessage() {
        return this.memoryMessage;
    }

    public final void setMemoryMessage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.memoryMessage = str;
    }

    public final String getResTag() {
        return this.resTag;
    }

    public final void setResTag(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.resTag = str;
    }

    public final String getChannel() {
        return this.channel;
    }

    public final void setChannel(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.channel = str;
    }

    public final String getBundle() {
        return this.bundle;
    }

    public final void setBundle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.bundle = str;
    }

    public final String getAccessKey() {
        return this.accessKey;
    }

    public final void setAccessKey(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.accessKey = str;
    }

    public final boolean getEnableMemory() {
        return this.enableMemory;
    }

    public final void setEnableMemory(boolean z) {
        this.enableMemory = z;
    }

    public final String getMemoryCachePriority() {
        return this.memoryCachePriority;
    }

    public final void setMemoryCachePriority(String str) {
        this.memoryCachePriority = str;
    }

    public final String getSdkVersion() {
        return this.sdkVersion;
    }

    public final void setSdkVersion(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sdkVersion = str;
    }

    public final WebResourceResponse getWebResourceResponse() {
        return this.webResourceResponse;
    }

    public final void setWebResourceResponse(WebResourceResponse webResourceResponse) {
        this.webResourceResponse = webResourceResponse;
    }

    public final RLReportInfo getCommonReportInfo() {
        return this.commonReportInfo;
    }

    public final void setCommonReportInfo(RLReportInfo rLReportInfo) {
        Intrinsics.checkNotNullParameter(rLReportInfo, "<set-?>");
        this.commonReportInfo = rLReportInfo;
    }

    public final RLReportInfo getPerformanceInfo() {
        return this.performanceInfo;
    }

    public final void setPerformanceInfo(RLReportInfo rLReportInfo) {
        Intrinsics.checkNotNullParameter(rLReportInfo, "<set-?>");
        this.performanceInfo = rLReportInfo;
    }

    public final JSONArray getPipelineStatus() {
        return this.pipelineStatus;
    }

    public final void setPipelineStatus(JSONArray jSONArray) {
        Intrinsics.checkNotNullParameter(jSONArray, "<set-?>");
        this.pipelineStatus = jSONArray;
    }

    public final List<String> getLoaders() {
        return this.loaders;
    }

    public final void setLoaders(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.loaders = list;
    }

    public final byte[] getByteArray() {
        return this.byteArray;
    }

    public final void setByteArray(byte[] bArr) {
        this.byteArray = bArr;
    }

    public final String getCdnSafeUrl() {
        return this.cdnSafeUrl;
    }

    public final void setCdnSafeUrl(String str) {
        this.cdnSafeUrl = str;
    }

    public final LoaderName getLoaderName() {
        return this.loaderName;
    }

    public final void setLoaderName(LoaderName loaderName) {
        Intrinsics.checkNotNullParameter(loaderName, "<set-?>");
        this.loaderName = loaderName;
    }

    public final ArgusResourceType getArgusResourceType() {
        return this.argusResourceType;
    }

    public final void setArgusResourceType(ArgusResourceType argusResourceType) {
        Intrinsics.checkNotNullParameter(argusResourceType, "<set-?>");
        this.argusResourceType = argusResourceType;
    }

    public byte[] provideByteArray() {
        if (this.byteArray != null) {
            RLLogger.INSTANCE.preloadInfo("命中内存缓存 ByteArray, " + this.resTag + ", " + this.srcUri + ", " + this.filePath);
            return this.byteArray;
        }
        InputStream provideInputStream = provideInputStream();
        if (provideInputStream != null) {
            return ByteStreamsKt.readBytes(provideInputStream);
        }
        return null;
    }

    public final InputStream provideResourceInputStream() {
        InputStream provideInputStream = provideInputStream();
        if (provideInputStream == null) {
            return null;
        }
        return provideInputStream instanceof ResourceInputStream ? provideInputStream : new ResourceInputStream(this, provideInputStream);
    }

    public final InputStream provideInputStream() {
        String str = this.filePath;
        if (str == null) {
            str = "";
        }
        File file = new File(str);
        InputStream inputStream = this.fileStream;
        if (inputStream != null) {
            return inputStream;
        }
        if (!file.exists() || file.isDirectory()) {
            return null;
        }
        return new FileInputStream(file);
    }

    public static /* synthetic */ File provideFile$default(ResourceInfo resourceInfo, File file, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: provideFile");
        }
        if ((i & 1) != 0) {
            file = null;
        }
        return resourceInfo.provideFile(file);
    }

    public final File provideFile(File rootFile) {
        String str = this.filePath;
        if (str == null) {
            str = "";
        }
        ResourceType resourceType = this.type;
        if ((resourceType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[resourceType.ordinal()]) != 1) {
            return new File(str);
        }
        if (rootFile != null) {
            return new File(rootFile, str);
        }
        return new File(str);
    }

    public String toString() {
        return "[srcUri=" + this.srcUri + ", filePath=" + this.filePath + ", type=" + this.type + ",from=" + this.from + ", fileStream=" + this.fileStream + ", model=" + this.model + ", accessKey=" + this.accessKey + "}]";
    }

    public final String getStatisticFrom() {
        if (this.usePreloadCache) {
            return RESOURCE_FROM_PRELOAD;
        }
        ResourceFrom resourceFrom = this.from;
        int i = resourceFrom == null ? -1 : WhenMappings.$EnumSwitchMapping$1[resourceFrom.ordinal()];
        if (i == 1) {
            return this.isCache ? RESOURCE_FROM_GECKO : RESOURCE_FROM_GECKO_UPDATE;
        }
        if (i != 2) {
            if (i == 3) {
                return this.isCache ? RESOURCE_FROM_CDN_CACHE : RESOURCE_FROM_CDN;
            }
            if (i != 4) {
                return i != 5 ? "custom" : RESOURCE_FROM_PRELOAD;
            }
        } else if (this.type == ResourceType.ASSET) {
            return RESOURCE_FROM_ASSET;
        }
        return RESOURCE_FROM_OFFLINE;
    }
}
