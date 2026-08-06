package com.bytedance.pia.snapshot;

import android.content.Context;
import android.net.Uri;
import android.webkit.WebResourceResponse;
import com.bytedance.pia.core.PiaContext;
import com.bytedance.pia.core.PiaManifest;
import com.bytedance.pia.core.api.resource.IResourceRequest;
import com.bytedance.pia.core.api.resource.IResourceResponse;
import com.bytedance.pia.core.api.resource.LoadFrom;
import com.bytedance.pia.core.cache.IPiaCacheProvider;
import com.bytedance.pia.core.metrics.ErrorCode;
import com.bytedance.pia.core.metrics.ErrorType;
import com.bytedance.pia.core.metrics.PvEventType;
import com.bytedance.pia.core.setting.Settings;
import com.bytedance.pia.core.utils.Logger;
import com.bytedance.pia.core.utils.ResourceConverterKt;
import com.bytedance.pia.core.utils.ThreadUtil;
import com.bytedance.pia.snapshot.storage.SnapshotEntity;
import com.bytedance.pia.snapshot.storage.SnapshotStore;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: SnapShotManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0002J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0002J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u0018\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u001b\u001a\u00020\u0016H\u0002J\u001e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\"JH\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u00042\b\u0010%\u001a\u0004\u0018\u00010\u00042\u0006\u0010&\u001a\u00020'2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"2\u0006\u0010(\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u001dJ8\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010\u0017\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0014\u0010/\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u00010+R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/bytedance/pia/snapshot/SnapShotManager;", "", "()V", "END_TAG", "", "PIA_META_PATTERN", "SNAPSHOT_HEAD_TAG", "SNAPSHOT_TAG", "START_TAG", "isInitialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "metaPattern", "Ljava/util/regex/Pattern;", "dealWithString", "html", "getSnapshotVersion", "rawHtml", "handleStreamWithSnapshot", "Ljava/io/InputStream;", ErrorType.SNAPSHOT, "Lcom/bytedance/pia/snapshot/storage/SnapshotEntity;", "initialize", "", "context", "Landroid/content/Context;", "parseSnapshotHtml", "origin", "postRemoveExpires", "removeSnapShot", "", "query", "Lorg/json/JSONObject;", "url", "sdk", "", "saveSnapShot", "content", "head", "expires", "", IPiaCacheProvider.CacheConfig.FIELD_VERSION, "enforce", "shouldInterceptRequest", "Landroid/webkit/WebResourceResponse;", "Lcom/bytedance/pia/core/PiaContext;", "uri", "Landroid/net/Uri;", "headers", "", "superResponse", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class SnapShotManager {
    private static final String END_TAG = "<!-- PIA_SNAPSHOT_HIDDEN_END -->";
    private static final String PIA_META_PATTERN = "<meta name=\"pia-snapshot\" content=\"(.*?)\">";
    private static final String SNAPSHOT_HEAD_TAG = "<!-- __PIA__SNAPSHOT__HEAD__ -->";
    private static final String SNAPSHOT_TAG = "<!-- __PIA__SNAPSHOT__ -->";
    private static final String START_TAG = "<!-- PIA_SNAPSHOT_HIDDEN_START -->";
    private static Pattern metaPattern;
    public static final SnapShotManager INSTANCE = new SnapShotManager();
    private static AtomicBoolean isInitialized = new AtomicBoolean(false);

    private SnapShotManager() {
    }

    public final void initialize(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ThreadUtil.INSTANCE.getPiaHandler().post(new Runnable() { // from class: com.bytedance.pia.snapshot.SnapShotManager$initialize$1
            @Override // java.lang.Runnable
            public final void run() {
                AtomicBoolean atomicBoolean;
                atomicBoolean = SnapShotManager.isInitialized;
                if (atomicBoolean.compareAndSet(false, true)) {
                    SnapShotManager snapShotManager = SnapShotManager.INSTANCE;
                    Pattern compile = Pattern.compile("<meta name=\"pia-snapshot\" content=\"(.*?)\">", 0);
                    Intrinsics.checkNotNullExpressionValue(compile, "java.util.regex.Pattern.compile(this, flags)");
                    SnapShotManager.metaPattern = compile;
                }
            }
        });
    }

    public final boolean saveSnapShot(String content, String head, long expires, JSONObject query, int sdk, String version, String url, boolean enforce) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(query, "query");
        Intrinsics.checkNotNullParameter(version, IPiaCacheProvider.CacheConfig.FIELD_VERSION);
        Intrinsics.checkNotNullParameter(url, "url");
        if (!Settings.Companion.get$default(Settings.INSTANCE, false, 1, null).getIsSnapshotV1Enabled()) {
            return false;
        }
        Logger.i$default("[SnapShot] Save a snapshot (URL: " + url + ", Query: " + query + ')', null, null, 6, null);
        postRemoveExpires();
        return SnapshotStore.INSTANCE.save(dealWithString(content), head, expires, query, sdk, version, url, enforce);
    }

    public final boolean removeSnapShot(JSONObject query, String url, int sdk) {
        Intrinsics.checkNotNullParameter(query, "query");
        Intrinsics.checkNotNullParameter(url, "url");
        Logger.i$default("[SnapShot] Remove a snapshot (URL: " + url + ", Query: " + query + ')', null, null, 6, null);
        postRemoveExpires();
        return SnapshotStore.INSTANCE.remove(url, query, sdk);
    }

    private final void postRemoveExpires() {
        ThreadUtil.INSTANCE.getPiaHandler().post(new Runnable() { // from class: com.bytedance.pia.snapshot.SnapShotManager$postRemoveExpires$1
            @Override // java.lang.Runnable
            public final void run() {
                SnapshotStore.INSTANCE.removeExpires();
            }
        });
    }

    public final WebResourceResponse shouldInterceptRequest(PiaContext context, final Uri uri, final Map<String, String> headers, WebResourceResponse superResponse) {
        Object obj;
        Object obj2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        if (!isInitialized.get()) {
            return superResponse;
        }
        PiaManifest create = PiaManifest.INSTANCE.create(uri.toString(), context);
        if (!(create != null && create.getEnableSnapshot())) {
            return superResponse;
        }
        context.getMetrics().onPvEvent(PvEventType.SNAPSHOT_HIT, 0);
        if (!Settings.Companion.get$default(Settings.INSTANCE, false, 1, null).getIsSnapshotV1Enabled()) {
            context.getMetrics().onError(ErrorType.SNAPSHOT, 1010);
            return superResponse;
        }
        if (superResponse == null) {
            try {
                Result.Companion companion = Result.Companion;
                IResourceResponse load = context.getResource().load(LoadFrom.Online, new IResourceRequest() { // from class: com.bytedance.pia.snapshot.SnapShotManager$shouldInterceptRequest$1$1
                    @Override // com.bytedance.pia.core.api.resource.IResourceRequest
                    /* renamed from: getUrl, reason: from getter */
                    public Uri get$uri() {
                        return uri;
                    }

                    @Override // com.bytedance.pia.core.api.resource.IResourceRequest
                    public Map<String, String> getRequestHeaders() {
                        HashMap hashMap = new HashMap();
                        Map<String, String> map = headers;
                        if (map != null) {
                            for (Map.Entry<String, String> entry : map.entrySet()) {
                                hashMap.put(entry.getKey(), entry.getValue());
                            }
                        }
                        return hashMap;
                    }
                });
                obj = Result.constructor-impl(load != null ? ResourceConverterKt.toWebResourceResponse(load) : null);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            if (Result.isFailure-impl(obj)) {
                obj = null;
            }
        } else {
            obj = superResponse;
        }
        if (obj == null) {
            Logger.i$default("[SnapShot] SnapShot response is null, return super response", null, null, 6, null);
            context.getMetrics().onError(ErrorType.SNAPSHOT, 1012);
            return superResponse;
        }
        SnapshotEntity query = SnapshotStore.INSTANCE.query(uri);
        if (query == null) {
            context.getMetrics().onError(ErrorType.SNAPSHOT, 1013);
            return superResponse;
        }
        WebResourceResponse webResourceResponse = (WebResourceResponse) obj;
        InputStream data = webResourceResponse.getData();
        BufferedReader bufferedReader = new BufferedReader(data != null ? new InputStreamReader(data, Charsets.UTF_8) : null);
        try {
            String readText = TextStreamsKt.readText(bufferedReader);
            CloseableKt.closeFinally(bufferedReader, (Throwable) null);
            String snapshotVersion = getSnapshotVersion(readText);
            long currentTimeMillis = System.currentTimeMillis();
            try {
                Result.Companion companion3 = Result.Companion;
                if (!Intrinsics.areEqual(query.getVersion(), String.valueOf(snapshotVersion)) || query.getExpireTime() <= currentTimeMillis) {
                    query = null;
                }
                obj2 = Result.constructor-impl(query);
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.Companion;
                obj2 = Result.constructor-impl(ResultKt.createFailure(th2));
            }
            SnapshotEntity snapshotEntity = (SnapshotEntity) (Result.isFailure-impl(obj2) ? null : obj2);
            if (snapshotEntity == null) {
                context.getMetrics().onError(ErrorType.SNAPSHOT, ErrorCode.READ_SNAPSHOT_STR_FAILED);
                return webResourceResponse;
            }
            webResourceResponse.setData(handleStreamWithSnapshot(readText, snapshotEntity));
            postRemoveExpires();
            context.getMetrics().onPvEvent(PvEventType.SNAPSHOT_HIT, 1);
            return webResourceResponse;
        } finally {
        }
    }

    private final InputStream handleStreamWithSnapshot(String html, SnapshotEntity snapshot) {
        Logger.i$default("[SnapShot] snapshot match,snapshot=" + snapshot, null, null, 6, null);
        String parseSnapshotHtml = parseSnapshotHtml(html, snapshot);
        Charset charset = Charsets.UTF_8;
        if (parseSnapshotHtml == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        byte[] bytes = parseSnapshotHtml.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        return new ByteArrayInputStream(bytes);
    }

    private final String getSnapshotVersion(String rawHtml) {
        Pattern compile = Pattern.compile(PIA_META_PATTERN, 0);
        Intrinsics.checkNotNullExpressionValue(compile, "java.util.regex.Pattern.compile(this, flags)");
        try {
            Result.Companion companion = Result.Companion;
            Matcher matcher = compile.matcher(rawHtml);
            if (matcher.find()) {
                return new JSONObject(URLDecoder.decode(matcher.group(1))).get("v").toString();
            }
            return null;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Object obj = Result.constructor-impl(ResultKt.createFailure(th));
            return (String) (Result.isFailure-impl(obj) ? null : obj);
        }
    }

    private final String parseSnapshotHtml(String origin, SnapshotEntity snapshot) {
        return StringsKt.replaceFirst$default(StringsKt.replaceFirst$default(origin, SNAPSHOT_TAG, snapshot.getContent(), false, 4, (Object) null), SNAPSHOT_HEAD_TAG, snapshot.getHead(), false, 4, (Object) null);
    }

    private final String dealWithString(String html) {
        Stack stack = new Stack();
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (i < html.length()) {
            char charAt = html.charAt(i);
            if (charAt == '<') {
                int i2 = i + 34;
                if (i2 <= html.length()) {
                    if (html == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                    String substring = html.substring(i, i2);
                    Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    if (Intrinsics.areEqual(substring, START_TAG)) {
                        stack.push(0);
                        i = i2;
                    }
                }
                i2 = i + 32;
                if (i2 <= html.length()) {
                    if (html == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                    String substring2 = html.substring(i, i2);
                    Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    if (Intrinsics.areEqual(substring2, END_TAG)) {
                        stack.pop();
                        i = i2;
                    }
                }
            }
            if (stack.empty() && charAt != '\n') {
                stringBuffer.append(charAt);
            }
            i++;
        }
        String stringBuffer2 = stringBuffer.toString();
        Intrinsics.checkNotNullExpressionValue(stringBuffer2, "ret.toString()");
        return stringBuffer2;
    }
}
