package com.bytedance.forest.model;

import android.content.res.AssetManager;
import android.net.Uri;
import android.webkit.WebResourceResponse;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.forest.Forest;
import com.bytedance.forest.chain.fetchers.CDNFetcher;
import com.bytedance.forest.model.ErrorInfo;
import com.bytedance.forest.pollyfill.ForestNetAPI;
import com.bytedance.forest.utils.ForestLogger;
import com.bytedance.forest.utils.LoaderUtils;
import com.bytedance.forest.utils.MemoryCacheItem;
import com.bytedance.forest.utils.OfflineUtil;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.CloseableBitmap;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: Response.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0019\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010%\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0016\u0018\u00002\u00020\u0001B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0000\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005B\u007f\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\t\u0012\b\b\u0002\u0010\u0012\u001a\u00020\t\u0012\b\b\u0002\u0010\u0013\u001a\u00020\t\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0017J\u000f\u0010o\u001a\u0004\u0018\u000105H\u0000¢\u0006\u0002\bpJ\u000f\u0010q\u001a\u0004\u0018\u00010\rH\u0000¢\u0006\u0002\brJ\u000e\u0010s\u001a\n\u0012\u0004\u0012\u00020=\u0018\u00010<J\u000f\u0010t\u001a\u0004\u0018\u00010CH\u0010¢\u0006\u0002\buJ\u0012\u0010v\u001a\u00020\r2\n\b\u0002\u0010w\u001a\u0004\u0018\u00010\u000fJ\u0006\u0010x\u001a\u00020\tJ\r\u0010y\u001a\u00020\tH\u0000¢\u0006\u0002\bzJ\b\u0010{\u001a\u00020|H\u0016J\n\u0010}\u001a\u0004\u0018\u00010~H\u0016J\u0017\u0010\u007f\u001a\u00030\u0080\u00012\f\b\u0002\u0010\u0081\u0001\u001a\u0005\u0018\u00010\u0080\u0001H\u0007J\f\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0083\u0001H\u0016J\t\u0010\u0084\u0001\u001a\u0004\u0018\u00010jJ\u0016\u0010\u0085\u0001\u001a\u0004\u0018\u00010j2\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010\rH\u0002J\u001a\u0010\u0087\u0001\u001a\u00020|2\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010CH\u0000¢\u0006\u0003\b\u0089\u0001J\u0011\u0010\u008a\u0001\u001a\u00020|2\b\u0010\u0002\u001a\u0004\u0018\u00010jJ\u000f\u0010\u008b\u0001\u001a\u00020\tH\u0000¢\u0006\u0003\b\u008c\u0001J\t\u0010\u008d\u0001\u001a\u00020\rH\u0016J\u000f\u0010\u008e\u0001\u001a\u00020\rH\u0000¢\u0006\u0003\b\u008f\u0001R*\u0010\u0019\u001a\u0004\u0018\u00010\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\r8F@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR*\u0010\u001e\u001a\u0004\u0018\u00010\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\r8F@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001b\"\u0004\b$\u0010\u001dR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R(\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001c\u00104\u001a\u0004\u0018\u000105X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R(\u0010:\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020=0<\u0018\u00010;X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u0010\u0010B\u001a\u0004\u0018\u00010CX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010+\"\u0004\bD\u0010-R\u001a\u0010E\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010+\"\u0004\bF\u0010-R\u001a\u0010G\u001a\u00020\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010+\"\u0004\bI\u0010-R\u001a\u0010\u0012\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010+\"\u0004\bJ\u0010-R\u001a\u0010K\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010+\"\u0004\bL\u0010-R\u001a\u0010\u0013\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010+\"\u0004\bM\u0010-R\u001a\u0010N\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010+\"\u0004\bO\u0010-R\u001a\u0010P\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010+\"\u0004\bQ\u0010-R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010+\"\u0004\bR\u0010-R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bS\u0010TR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010&\"\u0004\bV\u0010(R\u001d\u0010W\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00150X¢\u0006\b\n\u0000\u001a\u0004\bY\u00101R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u001a\u0010\u0016\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010\u001b\"\u0004\b_\u0010\u001dR\u001a\u0010`\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010+\"\u0004\bb\u0010-R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR\u0016\u0010g\u001a\n\u0012\u0004\u0012\u00020C\u0018\u00010hX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010i\u001a\u0004\u0018\u00010jX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010l\"\u0004\bm\u0010n¨\u0006\u0090\u0001"}, d2 = {"Lcom/bytedance/forest/model/Response;", "", ApmTrafficStats.TTNET_RESPONSE, "logger", "Lcom/bytedance/forest/utils/ForestLogger;", "(Lcom/bytedance/forest/model/Response;Lcom/bytedance/forest/utils/ForestLogger;)V", "request", "Lcom/bytedance/forest/model/Request;", "isSucceed", "", "errorInfo", "Lcom/bytedance/forest/model/ErrorInfo;", "filePath", "", "from", "Lcom/bytedance/forest/model/ResourceFrom;", "originFrom", "isCache", "isNegotiation", "isRedirection", "version", "", "successFetcher", "(Lcom/bytedance/forest/model/Request;ZLcom/bytedance/forest/model/ErrorInfo;Ljava/lang/String;Lcom/bytedance/forest/model/ResourceFrom;Lcom/bytedance/forest/model/ResourceFrom;ZZZJLjava/lang/String;Lcom/bytedance/forest/utils/ForestLogger;)V", "<set-?>", "charset", "getCharset", "()Ljava/lang/String;", "setCharset$forest_release", "(Ljava/lang/String;)V", "dataType", "getDataType", "setDataType$forest_release", "getErrorInfo", "()Lcom/bytedance/forest/model/ErrorInfo;", "getFilePath", "setFilePath", "getFrom", "()Lcom/bytedance/forest/model/ResourceFrom;", "setFrom", "(Lcom/bytedance/forest/model/ResourceFrom;)V", "hasBeenPaused", "getHasBeenPaused", "()Z", "setHasBeenPaused", "(Z)V", "httpHeader", "", "getHttpHeader", "()Ljava/util/Map;", "setHttpHeader", "(Ljava/util/Map;)V", "httpResponse", "Lcom/bytedance/forest/pollyfill/ForestNetAPI$HttpResponse;", "getHttpResponse", "()Lcom/bytedance/forest/pollyfill/ForestNetAPI$HttpResponse;", "setHttpResponse", "(Lcom/bytedance/forest/pollyfill/ForestNetAPI$HttpResponse;)V", "imageReference", "Ljava/lang/ref/SoftReference;", "Lcom/facebook/common/references/CloseableReference;", "Lcom/facebook/imagepipeline/image/CloseableBitmap;", "getImageReference$forest_release", "()Ljava/lang/ref/SoftReference;", "setImageReference$forest_release", "(Ljava/lang/ref/SoftReference;)V", "inMemoryBuffer", "Lcom/bytedance/forest/model/InMemoryBuffer;", "setCache", "isCanceled", "setCanceled", "isGeckoOfflineFromCDN", "isGeckoOfflineFromCDN$forest_release", "setGeckoOfflineFromCDN$forest_release", "setNegotiation", "isPreloaded", "setPreloaded", "setRedirection", "isRequestReused", "setRequestReused", "isStreamLoaded", "setStreamLoaded", "setSucceed", "getLogger$forest_release", "()Lcom/bytedance/forest/utils/ForestLogger;", "getOriginFrom", "setOriginFrom", "performanceInfo", "", "getPerformanceInfo", "getRequest", "()Lcom/bytedance/forest/model/Request;", "setRequest", "(Lcom/bytedance/forest/model/Request;)V", "getSuccessFetcher", "setSuccessFetcher", "useGkFS", "getUseGkFS", "setUseGkFS", "getVersion", "()J", "setVersion", "(J)V", "weakReferredBuffer", "Ljava/lang/ref/WeakReference;", "webResourceResponseFromTTNet", "Landroid/webkit/WebResourceResponse;", "getWebResourceResponseFromTTNet$forest_release", "()Landroid/webkit/WebResourceResponse;", "setWebResourceResponseFromTTNet$forest_release", "(Landroid/webkit/WebResourceResponse;)V", "getAssembleHttpResponseIf304", "getAssembleHttpResponseIf304$forest_release", "getExtension", "getExtension$forest_release", "getImage", "getInMemoryBuffer", "getInMemoryBuffer$forest_release", "getSourceType", "theFrom", "isDataTypeEmpty", "isDiskFileAvailable", "isDiskFileAvailable$forest_release", "loadToMemory", "", "provideBytes", "", "provideFile", "Ljava/io/File;", "rootFile", "provideInputStream", "Ljava/io/InputStream;", "provideWebResourceResponse", "provideWebResponseFromFile", "path", "setInMemoryBuffer", "buffer", "setInMemoryBuffer$forest_release", "setWebResourceResponseFromTTNet", "supportCache", "supportCache$forest_release", "toString", "toStringVM", "toStringVM$forest_release", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class Response {
    private String charset;
    private String dataType;
    private final ErrorInfo errorInfo;
    private String filePath;
    private ResourceFrom from;
    private boolean hasBeenPaused;
    private Map<String, String> httpHeader;
    private ForestNetAPI.HttpResponse httpResponse;
    private volatile transient SoftReference<CloseableReference<CloseableBitmap>> imageReference;
    private InMemoryBuffer inMemoryBuffer;
    private boolean isCache;
    private boolean isCanceled;
    private boolean isGeckoOfflineFromCDN;
    private boolean isNegotiation;
    private boolean isPreloaded;
    private boolean isRedirection;
    private boolean isRequestReused;
    private boolean isStreamLoaded;
    private volatile boolean isSucceed;
    private final ForestLogger logger;
    private ResourceFrom originFrom;
    private final Map<String, Long> performanceInfo;
    private Request request;
    private String successFetcher;
    private boolean useGkFS;
    private long version;
    private WeakReference<InMemoryBuffer> weakReferredBuffer;
    private volatile WebResourceResponse webResourceResponseFromTTNet;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[ResourceFrom.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[ResourceFrom.BUILTIN.ordinal()] = 1;
            int[] iArr2 = new int[ResourceFrom.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[ResourceFrom.BUILTIN.ordinal()] = 1;
            iArr2[ResourceFrom.GECKO.ordinal()] = 2;
            iArr2[ResourceFrom.CDN.ordinal()] = 3;
            iArr2[ResourceFrom.MEMORY.ordinal()] = 4;
            int[] iArr3 = new int[ResourceFrom.values().length];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[ResourceFrom.MEMORY.ordinal()] = 1;
            iArr3[ResourceFrom.GECKO.ordinal()] = 2;
            iArr3[ResourceFrom.BUILTIN.ordinal()] = 3;
            iArr3[ResourceFrom.CDN.ordinal()] = 4;
        }
    }

    public Response(Request request, boolean z, ErrorInfo errorInfo, String str, ResourceFrom resourceFrom, ResourceFrom resourceFrom2, boolean z2, boolean z3, boolean z4, long j, String str2, ForestLogger forestLogger) {
        Intrinsics.checkParameterIsNotNull(request, "request");
        Intrinsics.checkParameterIsNotNull(errorInfo, "errorInfo");
        Intrinsics.checkParameterIsNotNull(str2, "successFetcher");
        Intrinsics.checkParameterIsNotNull(forestLogger, "logger");
        this.request = request;
        this.isSucceed = z;
        this.errorInfo = errorInfo;
        this.filePath = str;
        this.from = resourceFrom;
        this.originFrom = resourceFrom2;
        this.isCache = z2;
        this.isNegotiation = z3;
        this.isRedirection = z4;
        this.version = j;
        this.successFetcher = str2;
        this.logger = forestLogger;
        this.performanceInfo = new ConcurrentHashMap();
    }

    public final Request getRequest() {
        return this.request;
    }

    public final void setRequest(Request request) {
        Intrinsics.checkParameterIsNotNull(request, "<set-?>");
        this.request = request;
    }

    /* renamed from: isSucceed, reason: from getter */
    public final boolean getIsSucceed() {
        return this.isSucceed;
    }

    public final void setSucceed(boolean z) {
        this.isSucceed = z;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ Response(Request request, boolean z, ErrorInfo errorInfo, String str, ResourceFrom resourceFrom, ResourceFrom resourceFrom2, boolean z2, boolean z3, boolean z4, long j, String str2, ForestLogger forestLogger, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(request, r5, r6, r7, r8, r9, (i & 64) != 0 ? false : z2, (i & 128) != 0 ? false : z3, (i & 256) != 0 ? false : z4, (i & 512) != 0 ? 0L : j, (i & 1024) != 0 ? "" : str2, forestLogger);
        String str3;
        ResourceFrom resourceFrom3;
        ResourceFrom resourceFrom4;
        boolean z5 = (i & 2) != 0 ? false : z;
        ErrorInfo errorInfo2 = (i & 4) != 0 ? new ErrorInfo(null, null, null, null, null, null, 63, null) : errorInfo;
        if ((i & 8) != 0) {
            str3 = null;
        } else {
            str3 = str;
        }
        if ((i & 16) != 0) {
            resourceFrom3 = null;
        } else {
            resourceFrom3 = resourceFrom;
        }
        if ((i & 32) != 0) {
            resourceFrom4 = null;
        } else {
            resourceFrom4 = resourceFrom2;
        }
    }

    public final ErrorInfo getErrorInfo() {
        return this.errorInfo;
    }

    public final String getFilePath() {
        return this.filePath;
    }

    public final void setFilePath(String str) {
        this.filePath = str;
    }

    public final ResourceFrom getFrom() {
        return this.from;
    }

    public final void setFrom(ResourceFrom resourceFrom) {
        this.from = resourceFrom;
    }

    public final ResourceFrom getOriginFrom() {
        return this.originFrom;
    }

    public final void setOriginFrom(ResourceFrom resourceFrom) {
        this.originFrom = resourceFrom;
    }

    /* renamed from: isCache, reason: from getter */
    public final boolean getIsCache() {
        return this.isCache;
    }

    public final void setCache(boolean z) {
        this.isCache = z;
    }

    /* renamed from: isNegotiation, reason: from getter */
    public final boolean getIsNegotiation() {
        return this.isNegotiation;
    }

    public final void setNegotiation(boolean z) {
        this.isNegotiation = z;
    }

    /* renamed from: isRedirection, reason: from getter */
    public final boolean getIsRedirection() {
        return this.isRedirection;
    }

    public final void setRedirection(boolean z) {
        this.isRedirection = z;
    }

    public final long getVersion() {
        return this.version;
    }

    public final void setVersion(long j) {
        this.version = j;
    }

    public final String getSuccessFetcher() {
        return this.successFetcher;
    }

    public final void setSuccessFetcher(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.successFetcher = str;
    }

    /* renamed from: getLogger$forest_release, reason: from getter */
    public final ForestLogger getLogger() {
        return this.logger;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ Response(Response response, ForestLogger forestLogger, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(response, forestLogger);
        if ((i & 2) != 0) {
            forestLogger = null;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Response(Response response, ForestLogger forestLogger) {
        this(new Request(response.request), response.isSucceed, response.errorInfo, response.filePath, response.from, response.originFrom, response.isCache, response.isNegotiation, response.isRedirection, response.version, response.successFetcher, forestLogger != null ? forestLogger : response.logger);
        Intrinsics.checkParameterIsNotNull(response, ApmTrafficStats.TTNET_RESPONSE);
        this.isCanceled = response.isCanceled;
        this.hasBeenPaused = response.hasBeenPaused;
        this.performanceInfo.putAll(response.performanceInfo);
        this.webResourceResponseFromTTNet = response.webResourceResponseFromTTNet;
        this.httpResponse = response.httpResponse;
        this.httpHeader = response.httpHeader;
        this.dataType = response.getDataType();
        this.inMemoryBuffer = response.inMemoryBuffer;
        this.weakReferredBuffer = response.weakReferredBuffer;
        this.charset = response.getCharset();
        this.imageReference = response.imageReference;
        this.isPreloaded = response.isPreloaded;
        this.isRequestReused = response.isRequestReused;
        this.useGkFS = response.useGkFS;
        this.isGeckoOfflineFromCDN = response.isGeckoOfflineFromCDN;
    }

    /* renamed from: isCanceled, reason: from getter */
    public final boolean getIsCanceled() {
        return this.isCanceled;
    }

    public final void setCanceled(boolean z) {
        this.isCanceled = z;
    }

    public final boolean getHasBeenPaused() {
        return this.hasBeenPaused;
    }

    public final void setHasBeenPaused(boolean z) {
        this.hasBeenPaused = z;
    }

    public final Map<String, Long> getPerformanceInfo() {
        return this.performanceInfo;
    }

    /* renamed from: getWebResourceResponseFromTTNet$forest_release, reason: from getter */
    public final WebResourceResponse getWebResourceResponseFromTTNet() {
        return this.webResourceResponseFromTTNet;
    }

    public final void setWebResourceResponseFromTTNet$forest_release(WebResourceResponse webResourceResponse) {
        this.webResourceResponseFromTTNet = webResourceResponse;
    }

    public final void setWebResourceResponseFromTTNet(WebResourceResponse response) {
        this.webResourceResponseFromTTNet = response;
    }

    public final ForestNetAPI.HttpResponse getHttpResponse() {
        return this.httpResponse;
    }

    public final void setHttpResponse(ForestNetAPI.HttpResponse httpResponse) {
        this.httpResponse = httpResponse;
    }

    public final Map<String, String> getHttpHeader() {
        return this.httpHeader;
    }

    public final void setHttpHeader(Map<String, String> map) {
        this.httpHeader = map;
    }

    public final void setDataType$forest_release(String str) {
        this.dataType = str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0016, code lost:
    
        if ((r0.length() == 0) == true) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String getDataType() {
        if (!this.isSucceed) {
            return null;
        }
        String str = this.dataType;
        if (str != null) {
            if (str != null) {
            }
            return this.dataType;
        }
        String mimeTypeFromExtension = OfflineUtil.INSTANCE.getMimeTypeFromExtension(getExtension$forest_release());
        if (mimeTypeFromExtension == null) {
            mimeTypeFromExtension = "unknown";
        }
        this.dataType = mimeTypeFromExtension;
        return this.dataType;
    }

    public final void setCharset$forest_release(String str) {
        this.charset = str;
    }

    public final String getCharset() {
        if (this.isSucceed) {
            return this.charset;
        }
        return null;
    }

    public final SoftReference<CloseableReference<CloseableBitmap>> getImageReference$forest_release() {
        return this.imageReference;
    }

    public final void setImageReference$forest_release(SoftReference<CloseableReference<CloseableBitmap>> softReference) {
        this.imageReference = softReference;
    }

    public final CloseableReference<CloseableBitmap> getImage() {
        SoftReference<CloseableReference<CloseableBitmap>> softReference = this.imageReference;
        if (softReference != null) {
            return softReference.get();
        }
        return null;
    }

    /* renamed from: isPreloaded, reason: from getter */
    public final boolean getIsPreloaded() {
        return this.isPreloaded;
    }

    public final void setPreloaded(boolean z) {
        this.isPreloaded = z;
    }

    /* renamed from: isRequestReused, reason: from getter */
    public final boolean getIsRequestReused() {
        return this.isRequestReused;
    }

    public final void setRequestReused(boolean z) {
        this.isRequestReused = z;
    }

    /* renamed from: isStreamLoaded, reason: from getter */
    public final boolean getIsStreamLoaded() {
        return this.isStreamLoaded;
    }

    public final void setStreamLoaded(boolean z) {
        this.isStreamLoaded = z;
    }

    public final boolean getUseGkFS() {
        return this.useGkFS;
    }

    public final void setUseGkFS(boolean z) {
        this.useGkFS = z;
    }

    /* renamed from: isGeckoOfflineFromCDN$forest_release, reason: from getter */
    public final boolean getIsGeckoOfflineFromCDN() {
        return this.isGeckoOfflineFromCDN;
    }

    public final void setGeckoOfflineFromCDN$forest_release(boolean z) {
        this.isGeckoOfflineFromCDN = z;
    }

    public final String getExtension$forest_release() {
        if (this.filePath != null) {
            OfflineUtil offlineUtil = OfflineUtil.INSTANCE;
            String str = this.filePath;
            if (str == null) {
                Intrinsics.throwNpe();
            }
            String extractExtension = offlineUtil.extractExtension(str, true);
            return (extractExtension == null || !StringsKt.contains$default(extractExtension, CDNFetcher.DIR_NAME, false, 2, (Object) null)) ? extractExtension : OfflineUtil.INSTANCE.extractExtension(this.request.getOriginUrl(), false);
        }
        return OfflineUtil.INSTANCE.extractExtension(this.request.getOriginUrl(), false);
    }

    public final void setInMemoryBuffer$forest_release(final InMemoryBuffer buffer) {
        Object obj;
        Unit unit;
        if (buffer == null) {
            InMemoryBuffer inMemoryBuffer = this.inMemoryBuffer;
            if (inMemoryBuffer != null) {
                this.weakReferredBuffer = new WeakReference<>(inMemoryBuffer);
            }
            this.inMemoryBuffer = null;
            return;
        }
        if (this.inMemoryBuffer == buffer) {
            return;
        }
        MemoryCacheItem cache = this.request.getForest().getMemoryManager$forest_release().getCache(this.request.getCacheKey$forest_release(), this.request.getIsPreload());
        if ((cache != null ? cache.getBuffer() : null) != this.inMemoryBuffer) {
            ForestLogger.printOptimize$default(this.logger, 4, "setInMemoryBuffer", true, null, null, new Function0<String>() { // from class: com.bytedance.forest.model.Response$setInMemoryBuffer$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                public final String invoke() {
                    InMemoryBuffer inMemoryBuffer2;
                    StringBuilder sb = new StringBuilder("close in-memory buffer ");
                    inMemoryBuffer2 = Response.this.inMemoryBuffer;
                    return sb.append(inMemoryBuffer2).toString();
                }
            }, 24, null);
            try {
                Result.Companion companion = Result.Companion;
                InMemoryBuffer inMemoryBuffer2 = this.inMemoryBuffer;
                if (inMemoryBuffer2 != null) {
                    inMemoryBuffer2.close();
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                obj = Result.constructor-impl(unit);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            Throwable th2 = Result.exceptionOrNull-impl(obj);
            if (th2 != null) {
                ForestLogger.printOptimize$default(this.logger, 6, "setInMemoryBuffer", false, th2, null, new Function0<String>() { // from class: com.bytedance.forest.model.Response$setInMemoryBuffer$$inlined$onFailure$lambda$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    public final String invoke() {
                        InMemoryBuffer inMemoryBuffer3;
                        StringBuilder sb = new StringBuilder("error on close ");
                        inMemoryBuffer3 = Response.this.inMemoryBuffer;
                        return sb.append(inMemoryBuffer3).toString();
                    }
                }, 20, null);
            }
        }
        ForestLogger.printOptimize$default(this.logger, 4, "setInMemoryBuffer", true, null, null, new Function0<String>() { // from class: com.bytedance.forest.model.Response$setInMemoryBuffer$5
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public final String invoke() {
                InMemoryBuffer inMemoryBuffer3;
                StringBuilder sb = new StringBuilder("replace in-memory buffer from ");
                inMemoryBuffer3 = Response.this.inMemoryBuffer;
                return sb.append(inMemoryBuffer3).append(" to ").append(buffer).toString();
            }
        }, 24, null);
        this.inMemoryBuffer = buffer;
        this.weakReferredBuffer = null;
    }

    public byte[] provideBytes() {
        byte[] provideBytes;
        InMemoryBuffer buffer;
        byte[] provideBytes2;
        Object obj;
        byte[] provideBytes3;
        byte[] provideBytes4;
        if (!this.isSucceed) {
            return null;
        }
        InMemoryBuffer inMemoryBuffer$forest_release = getInMemoryBuffer$forest_release();
        if (inMemoryBuffer$forest_release != null && (provideBytes4 = inMemoryBuffer$forest_release.provideBytes()) != null) {
            return provideBytes4;
        }
        if (this.from == ResourceFrom.MEMORY || this.request.getEnableRequestReuse() || this.request.getEnableMemoryCache()) {
            MemoryCacheItem cache = this.request.getForest().getMemoryManager$forest_release().getCache(this.request.getCacheKey$forest_release(), this.request.getEnableRequestReuse());
            if (cache != null && (buffer = cache.getBuffer()) != null) {
                this.inMemoryBuffer = buffer;
                if (buffer != null && (provideBytes2 = buffer.provideBytes()) != null) {
                    if (this.request.getEnableRequestReuse()) {
                        this.isPreloaded = true;
                    }
                    return provideBytes2;
                }
            }
            InMemoryBuffer inMemoryBuffer$forest_release2 = getInMemoryBuffer$forest_release();
            if (inMemoryBuffer$forest_release2 != null) {
                this.inMemoryBuffer = inMemoryBuffer$forest_release2;
                if (inMemoryBuffer$forest_release2 != null && (provideBytes = inMemoryBuffer$forest_release2.provideBytes()) != null) {
                    return provideBytes;
                }
            }
        }
        InMemoryBuffer inMemoryBuffer$forest_release3 = getInMemoryBuffer$forest_release();
        if (inMemoryBuffer$forest_release3 != null) {
            try {
                Result.Companion companion = Result.Companion;
                inMemoryBuffer$forest_release3.tryLoadToMemory$forest_release(this);
                provideBytes3 = inMemoryBuffer$forest_release3.provideBytes();
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            if (provideBytes3 != null) {
                return provideBytes3;
            }
            obj = Result.constructor-impl((Object) null);
            Throwable th2 = Result.exceptionOrNull-impl(obj);
            if (th2 != null) {
                ForestLogger.print$default(this.logger, 6, "provideBytes", "error occurred when provide bytes from buffer", true, th2, null, 32, null);
            }
        }
        return LoaderUtils.INSTANCE.loadInputStreamAsByteArray$forest_release(this);
    }

    public void loadToMemory() {
        try {
            InMemoryBuffer inMemoryBuffer$forest_release = getInMemoryBuffer$forest_release();
            if (inMemoryBuffer$forest_release != null) {
                inMemoryBuffer$forest_release.tryLoadToMemory$forest_release(this);
            }
            if (inMemoryBuffer$forest_release == null || inMemoryBuffer$forest_release.isCacheClear$forest_release()) {
                this.isSucceed = false;
                this.errorInfo.setError(ErrorInfo.Type.Pipeline, 4, "fetch succeeded but IO failed, cache cleared, inMemoryBuffer=" + this.inMemoryBuffer);
            }
        } catch (Throwable th) {
            this.isSucceed = false;
            this.errorInfo.setError(ErrorInfo.Type.Pipeline, 4, "fetch succeeded but IO failed, occurred by " + th);
        }
    }

    public synchronized InputStream provideInputStream() {
        MemoryCacheItem cache;
        InMemoryBuffer buffer;
        FileInputStream fileInputStream;
        if (!this.isSucceed) {
            return null;
        }
        Forest forest = this.request.getForest();
        InMemoryBuffer inMemoryBuffer$forest_release = getInMemoryBuffer$forest_release();
        if (inMemoryBuffer$forest_release != null) {
            byte[] provideBytes = inMemoryBuffer$forest_release.provideBytes();
            if (provideBytes != null) {
                return new ByteArrayInputStream(provideBytes);
            }
            return inMemoryBuffer$forest_release.provideInputStream(this);
        }
        if ((this.request.getEnableMemoryCache() || this.request.getEnableRequestReuse()) && (cache = forest.getMemoryManager$forest_release().getCache(this.request.getCacheKey$forest_release(), this.request.getEnableRequestReuse())) != null && (buffer = cache.getBuffer()) != null) {
            InputStream provideInputStream = buffer.provideInputStream(this);
            if (provideInputStream == null) {
            } else {
                this.inMemoryBuffer = buffer;
                return provideInputStream;
            }
        }
        forest.getMemoryManager$forest_release().removeCache(this.request.getCacheKey$forest_release());
        String str = this.filePath;
        if (str != null) {
            try {
                if (this.from == ResourceFrom.BUILTIN) {
                    Uri parse = Uri.parse(str);
                    Intrinsics.checkExpressionValueIsNotNull(parse, "uri");
                    if (Intrinsics.areEqual(parse.getScheme(), "file")) {
                        fileInputStream = new FileInputStream(new File(parse.getPath()));
                    } else {
                        AssetManager assets = Forest.Companion.getApp().getAssets();
                        String path = parse.getPath();
                        Intrinsics.checkExpressionValueIsNotNull(path, "uri.path");
                        fileInputStream = assets.open(StringsKt.removePrefix(path, "/"));
                    }
                } else {
                    fileInputStream = new FileInputStream(new File(str));
                }
                return fileInputStream;
            } catch (Exception e) {
                ForestLogger.print$default(this.logger, 6, "provideInputStream", "error occurs when getting input stream from response, file: " + str, true, e, null, 32, null);
            }
        }
        this.inMemoryBuffer = null;
        ForestLogger.print$default(this.logger, 6, "provideInputStream", "fetch succeeded but IO failed", true, null, null, 48, null);
        return null;
    }

    public static /* synthetic */ File provideFile$default(Response response, File file, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: provideFile");
        }
        if ((i & 1) != 0) {
            file = null;
        }
        return response.provideFile(file);
    }

    @Deprecated(message = "do NOT use it")
    public final File provideFile(File rootFile) {
        String str = this.filePath;
        if (str == null) {
            str = "";
        }
        ResourceFrom resourceFrom = this.from;
        if (resourceFrom == null || WhenMappings.$EnumSwitchMapping$0[resourceFrom.ordinal()] != 1) {
            return new File(str);
        }
        if (rootFile != null) {
            return new File(rootFile, str);
        }
        return new File(str);
    }

    public final boolean isDataTypeEmpty() {
        String dataType = getDataType();
        return dataType == null || dataType.length() == 0;
    }

    private final WebResourceResponse provideWebResponseFromFile(String path) {
        InputStream provideInputStream = provideInputStream();
        if (provideInputStream != null) {
            return OfflineUtil.INSTANCE.loadLocalResponse(path, provideInputStream, getDataType(), getCharset());
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0072 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final WebResourceResponse provideWebResourceResponse() {
        WebResourceResponse webResourceResponse;
        if (this.isSucceed) {
            webResourceResponse = this.webResourceResponseFromTTNet;
            if (webResourceResponse == null) {
                ResourceFrom resourceFrom = this.from;
                if (resourceFrom != null) {
                    int i = WhenMappings.$EnumSwitchMapping$1[resourceFrom.ordinal()];
                    if (i == 1) {
                        Uri parse = Uri.parse(this.filePath);
                        Intrinsics.checkExpressionValueIsNotNull(parse, "uri");
                        if (Intrinsics.areEqual(parse.getScheme(), "file")) {
                            webResourceResponse = provideWebResponseFromFile(parse.getPath());
                        } else {
                            OfflineUtil offlineUtil = OfflineUtil.INSTANCE;
                            AssetManager assets = Forest.Companion.getApp().getAssets();
                            String path = parse.getPath();
                            Intrinsics.checkExpressionValueIsNotNull(path, "uri.path");
                            webResourceResponse = offlineUtil.loadAssetResponse(assets, StringsKt.removePrefix(path, "/"));
                        }
                    } else if (i == 2 || i == 3 || i == 4) {
                        webResourceResponse = provideWebResponseFromFile(this.filePath);
                    }
                }
            }
            if (webResourceResponse != null) {
                try {
                    if (webResourceResponse.getResponseHeaders() == null) {
                        webResourceResponse.setResponseHeaders(new LinkedHashMap());
                    }
                    Map<String, String> responseHeaders = webResourceResponse.getResponseHeaders();
                    Intrinsics.checkExpressionValueIsNotNull(responseHeaders, "headers");
                    responseHeaders.put("forest_res_load_start", String.valueOf(this.performanceInfo.get(Timing.RES_LOAD_START)));
                    responseHeaders.put("forest_res_load_finish", String.valueOf(this.performanceInfo.get(Timing.RES_LOAD_FINISH)));
                    responseHeaders.put("forest_res_from", getSourceType$default(this, null, 1, null));
                } catch (Throwable th) {
                    ForestLogger.print$default(this.logger, 6, "provideWebResourceResponse", "error occur cause by " + th.getMessage(), false, null, null, 56, null);
                }
            }
            return webResourceResponse;
        }
        webResourceResponse = null;
        if (webResourceResponse != null) {
        }
        return webResourceResponse;
    }

    public static /* synthetic */ String getSourceType$default(Response response, ResourceFrom resourceFrom, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getSourceType");
        }
        if ((i & 1) != 0) {
            resourceFrom = response.from;
        }
        return response.getSourceType(resourceFrom);
    }

    public final String getSourceType(ResourceFrom theFrom) {
        if (theFrom != null) {
            int i = WhenMappings.$EnumSwitchMapping$2[theFrom.ordinal()];
            if (i == 1) {
                return "memory";
            }
            if (i == 2) {
                return this.isGeckoOfflineFromCDN ? SourceType.GECKO_OFFINLE_CDN : this.isCache ? "gecko" : "gecko_update";
            }
            if (i == 3) {
                return SourceType.BUILTIN;
            }
            if (i == 4) {
                return this.isCache ? SourceType.CDN_CACHE : "cdn";
            }
        }
        return "unknown";
    }

    public InMemoryBuffer getInMemoryBuffer$forest_release() {
        InMemoryBuffer inMemoryBuffer = this.inMemoryBuffer;
        if (inMemoryBuffer != null) {
            return inMemoryBuffer;
        }
        WeakReference<InMemoryBuffer> weakReference = this.weakReferredBuffer;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public final boolean isDiskFileAvailable$forest_release() {
        String str = this.filePath;
        if (!LoaderUtils.INSTANCE.isNotNullOrEmpty(str)) {
            str = null;
        }
        return str != null && new File(str).isFile();
    }

    public String toString() {
        Object message;
        InputStream data;
        try {
            StringBuilder append = new StringBuilder().append(super.toString()).append("(request=").append(this.request).append(", isSucceed=").append(this.isSucceed).append(", errorInfo=").append(this.errorInfo).append(", filePath=").append(this.filePath).append(", from=").append(this.from).append(", originFrom=").append(this.originFrom).append(", isCache=").append(this.isCache).append(", version=").append(this.version).append(", successFetcher=").append(this.successFetcher).append(", isCanceled=").append(this.isCanceled).append(", isRedirection=").append(this.isRedirection).append(", isNegotiation=").append(this.isNegotiation).append(", httpCode=");
            ForestNetAPI.HttpResponse httpResponse = this.httpResponse;
            StringBuilder append2 = append.append(httpResponse != null ? Integer.valueOf(httpResponse.getResponseHttpCode()) : null).append(", webResourceResponse=").append(this.webResourceResponseFromTTNet).append("(data=");
            WebResourceResponse webResourceResponse = this.webResourceResponseFromTTNet;
            StringBuilder append3 = append2.append(webResourceResponse != null ? webResourceResponse.getData() : null).append(", size=");
            try {
                WebResourceResponse webResourceResponse2 = this.webResourceResponseFromTTNet;
                message = (webResourceResponse2 == null || (data = webResourceResponse2.getData()) == null) ? null : Integer.valueOf(data.available());
            } catch (Throwable th) {
                message = th.getMessage();
            }
            StringBuilder append4 = append3.append(message).append("), image=").append(getImage()).append(", inMemoryBuffer=").append(this.inMemoryBuffer).append(", weakReferredBuffer=(").append(this.weakReferredBuffer).append(", ");
            WeakReference<InMemoryBuffer> weakReference = this.weakReferredBuffer;
            return append4.append(weakReference != null ? weakReference.get() : null).append("), dataType=").append(getDataType()).append(", charset=").append(getCharset()).append(", isPreloaded=").append(this.isPreloaded).append(", isRequestReused=").append(this.isRequestReused).append(", isStreamLoaded=").append(this.isStreamLoaded).append(')').toString();
        } catch (Throwable th2) {
            ForestLogger.print$default(this.logger, 6, "resp", "Response toString error", true, th2, null, 32, null);
            return super.toString();
        }
    }

    public final boolean supportCache$forest_release() {
        ForestNetAPI.HttpResponse assembleHttpResponseIf304$forest_release = getAssembleHttpResponseIf304$forest_release();
        if (assembleHttpResponseIf304$forest_release != null) {
            return OfflineUtil.INSTANCE.supportCache$forest_release(assembleHttpResponseIf304$forest_release);
        }
        return false;
    }

    public final ForestNetAPI.HttpResponse getAssembleHttpResponseIf304$forest_release() {
        LinkedHashMap linkedHashMap;
        final ForestNetAPI.HttpResponse httpResponse = this.httpResponse;
        if (httpResponse == null) {
            return null;
        }
        if (httpResponse.getResponseHttpCode() != 304) {
            return this.httpResponse;
        }
        final int responseHttpCode = httpResponse.getResponseHttpCode();
        final String errorMsg = httpResponse.getErrorMsg();
        Map<String, String> map = this.httpHeader;
        if (map == null || (linkedHashMap = MapsKt.toMutableMap(map)) == null) {
            linkedHashMap = new LinkedHashMap();
        }
        final Map map2 = linkedHashMap;
        final ForestNetAPI.HttpRequest request = httpResponse.getRequest();
        final long generatedTime = httpResponse.getGeneratedTime();
        return new ForestNetAPI.HttpResponse(responseHttpCode, errorMsg, map2, request, generatedTime) { // from class: com.bytedance.forest.model.Response$getAssembleHttpResponseIf304$1
            @Override // com.bytedance.forest.pollyfill.ForestNetAPI.HttpResponse
            public InputStream provideInputStream() {
                return null;
            }
        };
    }

    public final String toStringVM$forest_release() {
        return super.toString();
    }
}
