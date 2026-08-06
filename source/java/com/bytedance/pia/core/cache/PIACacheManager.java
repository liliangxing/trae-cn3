package com.bytedance.pia.core.cache;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.ies.bullet.service.monitor.MetricConstant;
import com.bytedance.iesgurd.exception.BytePatchException;
import com.bytedance.keva.Keva;
import com.bytedance.pia.core.cache.IPiaCacheProvider;
import com.bytedance.pia.core.metrics.ErrorType;
import com.bytedance.pia.core.setting.Settings;
import com.bytedance.pia.core.utils.CollectionUtils;
import com.bytedance.pia.core.utils.GsonUtils;
import com.bytedance.pia.core.utils.Logger;
import com.bytedance.pia.core.utils.ManifestUtils;
import com.bytedance.pia.core.utils.ThreadUtil;
import com.bytedance.pia.core.utils.UrlUtils;
import com.bytedance.platform.thread.Constants;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: PIACacheManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0007J\u001c\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0004H\u0007J\u0018\u0010\u0014\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\bH\u0007J\u0014\u0010\u001a\u001a\u0004\u0018\u00010\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0007J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001b\u001a\u00020\u0004H\u0007J\b\u0010\u001c\u001a\u00020\u0013H\u0007J \u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u00042\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001fH\u0002J\"\u0010 \u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020\u0018H\u0002J0\u0010$\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\u00042\u0006\u0010&\u001a\u00020'2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001fH\u0002J\u0018\u0010(\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\bH\u0002J\u001a\u0010)\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010!\u001a\u0004\u0018\u00010\"H\u0007J\u0014\u0010*\u001a\u0004\u0018\u00010'2\b\u0010+\u001a\u0004\u0018\u00010\u0004H\u0002J\u0014\u0010,\u001a\u0004\u0018\u00010'2\b\u0010-\u001a\u0004\u0018\u00010.H\u0007J\b\u0010/\u001a\u00020\u0013H\u0002J\u0012\u00100\u001a\u0004\u0018\u00010\"2\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u0012\u00101\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0017\u001a\u00020\u0004H\u0007J\u001e\u00102\u001a\u0004\u0018\u00010'2\u0006\u0010\u0017\u001a\u00020\u00042\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\bH\u0007J\u001a\u00103\u001a\u0004\u0018\u00010\"2\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\bH\u0007J\u0012\u00104\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0007J\u0010\u00104\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0004H\u0002J\b\u00105\u001a\u00020\u0013H\u0002J\u0010\u00106\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0004H\u0002J2\u00107\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\u00042\b\u0010-\u001a\u0004\u0018\u00010.2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001fH\u0007J(\u00108\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u00109\u001a\u00020.2\u0006\u0010%\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\bH\u0002J\u001a\u0010:\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010!\u001a\u0004\u0018\u00010\"H\u0002J.\u0010;\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010+\u001a\u0004\u0018\u00010\u00042\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010<\u001a\u0004\u0018\u00010\"H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/bytedance/pia/core/cache/PIACacheManager;", "", "()V", "TAG", "", "TAG_EXTRA_VARY", "TAG_HEADERS", "contentRepo", "Lcom/bytedance/keva/Keva;", "gson", "Lcom/google/gson/Gson;", "hasInit", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getHasInit", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "indexRepo", "lastRemoveTime", "", "clearAll", "", "deleteWithNormalizeUrl", "uri", "Landroid/net/Uri;", "normalizeUrl", "", "configRepo", "getConfigRepo", "url", EventConstants.PARAM_SOURCE_INIT, "initIndexRepo", "extraVary", "", "innerMark", "cache", "Lcom/bytedance/pia/core/cache/IPiaCacheProvider;", IPiaCacheProvider.CacheConfig.FIELD_MARK, "innerSave", "content", "config", "Lcom/bytedance/pia/core/cache/IPiaCacheProvider$CacheConfig;", "isExist", "mark", "parseHeadersFromHTML", "html", "parseHeadersFromManifest", ErrorType.MANIFEST, "Lcom/google/gson/JsonObject;", "postRemoveExpires", "query4Intercept", "queryContent", "queryHeaders", "queryWithNormalizeUrl", "removeAllCache", "removeExpires", "removeIndexRepo", "save", "saveWithNormalizeUrl", "headers", "unMark", MetricConstant.MONITOR_STAGE_UPDATE, "curCache", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PIACacheManager {
    private static final String TAG = "PIACacheManager";
    private static final String TAG_EXTRA_VARY = "_extraVary";
    private static final String TAG_HEADERS = "_headers";
    private static Keva contentRepo;
    private static Keva indexRepo;
    private static long lastRemoveTime;
    public static final PIACacheManager INSTANCE = new PIACacheManager();
    private static final Gson gson = GsonUtils.getGson();
    private static final AtomicBoolean hasInit = new AtomicBoolean(false);

    @JvmStatic
    public static final IPiaCacheProvider.CacheConfig queryHeaders(String str) {
        Intrinsics.checkNotNullParameter(str, "normalizeUrl");
        return queryHeaders$default(str, null, 2, null);
    }

    private PIACacheManager() {
    }

    public final AtomicBoolean getHasInit() {
        return hasInit;
    }

    @JvmStatic
    public static final void init() {
        if (Settings.Companion.get$default(Settings.INSTANCE, false, 1, null).getIsCacheEnabled() && hasInit.compareAndSet(false, true)) {
            Keva repo = Keva.getRepo("pia_cache_index_repo");
            Intrinsics.checkNotNullExpressionValue(repo, "getRepo(\"pia_cache_index_repo\")");
            indexRepo = repo;
            Keva repo2 = Keva.getRepo("pia_cache_content_repo");
            Intrinsics.checkNotNullExpressionValue(repo2, "getRepo(\"pia_cache_content_repo\")");
            contentRepo = repo2;
            Logger.i$default("[PIACacheManager]: Finish Init PIA Cache Pool.", null, null, 6, null);
        }
    }

    @JvmStatic
    public static final void clearAll() {
        init();
        Keva keva = indexRepo;
        Keva keva2 = null;
        if (keva == null) {
            Intrinsics.throwUninitializedPropertyAccessException("indexRepo");
            keva = null;
        }
        keva.clear();
        Keva keva3 = contentRepo;
        if (keva3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentRepo");
        } else {
            keva2 = keva3;
        }
        keva2.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0085, code lost:
    
        if (r0.isExist(r8, r5) != false) goto L90;
     */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final IPiaCacheProvider query4Intercept(Uri uri) {
        String str;
        Intrinsics.checkNotNullParameter(uri, "uri");
        if (!Settings.Companion.get$default(Settings.INSTANCE, false, 1, null).getIsCacheEnabled()) {
            return null;
        }
        PIACacheManager pIACacheManager = INSTANCE;
        if (!hasInit.get()) {
            return null;
        }
        pIACacheManager.postRemoveExpires();
        String normalizeUrl$default = UrlUtils.normalizeUrl$default(uri, null, 2, null);
        if (normalizeUrl$default == null) {
            return null;
        }
        Keva configRepo = getConfigRepo(normalizeUrl$default);
        if (configRepo != null) {
            Keva keva = indexRepo;
            if (keva == null) {
                Intrinsics.throwUninitializedPropertyAccessException("indexRepo");
                keva = null;
            }
            String[] stringArray = keva.getStringArray(normalizeUrl$default + TAG_EXTRA_VARY, null);
            List list = stringArray != null ? ArraysKt.toList(stringArray) : null;
            List list2 = list;
            if (!(list2 == null || list2.isEmpty())) {
                str = UrlUtils.normalizeUrl(uri, list);
                String str2 = str;
                if (!(str2 == null || str2.length() == 0)) {
                }
            }
            str = normalizeUrl$default;
            IPiaCacheProvider queryWithNormalizeUrl = queryWithNormalizeUrl(str, configRepo);
            if ((queryWithNormalizeUrl == null || !IPiaCacheProviderKt.isValid(queryWithNormalizeUrl)) && !Intrinsics.areEqual(str, normalizeUrl$default)) {
                queryWithNormalizeUrl = queryWithNormalizeUrl(normalizeUrl$default, configRepo);
            }
            if (queryWithNormalizeUrl != null && IPiaCacheProviderKt.isValid(queryWithNormalizeUrl)) {
                Logger.i$default("[PIACacheManager][Query] Find Matched PIA Cache. (URL = " + uri + ", CacheConfig = " + queryWithNormalizeUrl.get$config() + ')', null, null, 6, null);
                return queryWithNormalizeUrl;
            }
        }
        Logger.i$default("[PIACacheManager][Query] Find No Matched PIA Cache. (URL = " + uri + ')', null, null, 6, null);
        return null;
    }

    @JvmStatic
    public static final void update(final Uri uri, final String str, final JsonObject jsonObject, final IPiaCacheProvider iPiaCacheProvider) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        if (Settings.Companion.get$default(Settings.INSTANCE, false, 1, null).getIsCacheEnabled() && hasInit.get()) {
            Logger.i$default("[PIACacheManager] Begin to Validate Cache. (URL: " + uri + ')', null, null, 6, null);
            ThreadUtil.runOnPia(new Runnable() { // from class: com.bytedance.pia.core.cache.PIACacheManager$update$1
                /* JADX WARN: Removed duplicated region for block: B:24:0x0051 A[Catch: all -> 0x00b9, TryCatch #0 {all -> 0x00b9, blocks: (B:3:0x0010, B:5:0x0019, B:12:0x0026, B:16:0x0030, B:19:0x0037, B:22:0x0045, B:24:0x0051, B:28:0x005a, B:30:0x0060, B:32:0x0066, B:34:0x006c, B:36:0x0072, B:38:0x007b, B:39:0x00b2, B:46:0x009e), top: B:2:0x0010 }] */
                /* JADX WARN: Removed duplicated region for block: B:38:0x007b A[Catch: all -> 0x00b9, TryCatch #0 {all -> 0x00b9, blocks: (B:3:0x0010, B:5:0x0019, B:12:0x0026, B:16:0x0030, B:19:0x0037, B:22:0x0045, B:24:0x0051, B:28:0x005a, B:30:0x0060, B:32:0x0066, B:34:0x006c, B:36:0x0072, B:38:0x007b, B:39:0x00b2, B:46:0x009e), top: B:2:0x0010 }] */
                /* JADX WARN: Removed duplicated region for block: B:42:0x00cc  */
                /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:46:0x009e A[Catch: all -> 0x00b9, TryCatch #0 {all -> 0x00b9, blocks: (B:3:0x0010, B:5:0x0019, B:12:0x0026, B:16:0x0030, B:19:0x0037, B:22:0x0045, B:24:0x0051, B:28:0x005a, B:30:0x0060, B:32:0x0066, B:34:0x006c, B:36:0x0072, B:38:0x007b, B:39:0x00b2, B:46:0x009e), top: B:2:0x0010 }] */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final void run() {
                    Object obj;
                    Throwable th;
                    String str2;
                    boolean z;
                    boolean z2;
                    boolean z3;
                    String normalizeUrl$default;
                    String asString;
                    Keva configRepo;
                    IPiaCacheProvider.CacheConfig cacheConfig;
                    String version;
                    String str3 = str;
                    Uri uri2 = uri;
                    JsonObject jsonObject2 = jsonObject;
                    IPiaCacheProvider iPiaCacheProvider2 = iPiaCacheProvider;
                    try {
                        Result.Companion companion = Result.Companion;
                        str2 = str3;
                        z = false;
                        z2 = true;
                    } catch (Throwable th2) {
                        Result.Companion companion2 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.createFailure(th2));
                    }
                    if (str2 != null && str2.length() != 0) {
                        z3 = false;
                        if (z3 && (normalizeUrl$default = UrlUtils.normalizeUrl$default(uri2, null, 2, null)) != null) {
                            if ((jsonObject2 == null || (jsonObject2 = ManifestUtils.parseManifest(str3)) != null) && (asString = jsonObject2.get(IPiaCacheProvider.CacheConfig.FIELD_VERSION).getAsString()) != null) {
                                Intrinsics.checkNotNullExpressionValue(asString, "realManifest.get(\"versio…String ?: return@Runnable");
                                configRepo = PIACacheManager.getConfigRepo(normalizeUrl$default);
                                if (configRepo != null) {
                                    IPiaCacheProvider queryWithNormalizeUrl = PIACacheManager.queryWithNormalizeUrl(normalizeUrl$default, configRepo);
                                    if (queryWithNormalizeUrl == null) {
                                        queryWithNormalizeUrl = iPiaCacheProvider2;
                                    }
                                    if (queryWithNormalizeUrl != null && (cacheConfig = queryWithNormalizeUrl.get$config()) != null && (version = cacheConfig.getVersion()) != null) {
                                        if (Intrinsics.areEqual(version, asString)) {
                                            PIACacheManager.INSTANCE.unMark(uri2, iPiaCacheProvider2);
                                        } else {
                                            PIACacheManager.INSTANCE.removeAllCache(normalizeUrl$default);
                                            z = true;
                                        }
                                        z2 = z;
                                    }
                                }
                                if (!z2) {
                                    Logger.i$default("[PIACacheManager] Validate Cache Finish. (URL: " + uri2 + " , isUpdate: " + PIACacheManager.save(uri2, str3, jsonObject2, null) + ')', null, null, 6, null);
                                } else {
                                    Logger.i$default("[PIACacheManager] No Need to validate Cache Finish. (URL: " + uri2 + ')', null, null, 6, null);
                                }
                                obj = Result.constructor-impl(Unit.INSTANCE);
                                Uri uri3 = uri;
                                th = Result.exceptionOrNull-impl(obj);
                                if (th == null) {
                                    Logger.e$default("[PIACacheManager] Validate Cache Exception. (URL: " + uri3 + " , Error: " + th + ')', null, null, 6, null);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    z3 = true;
                    if (z3) {
                        return;
                    }
                    if (jsonObject2 == null) {
                    }
                    Intrinsics.checkNotNullExpressionValue(asString, "realManifest.get(\"versio…String ?: return@Runnable");
                    configRepo = PIACacheManager.getConfigRepo(normalizeUrl$default);
                    if (configRepo != null) {
                    }
                    if (!z2) {
                    }
                    obj = Result.constructor-impl(Unit.INSTANCE);
                    Uri uri32 = uri;
                    th = Result.exceptionOrNull-impl(obj);
                    if (th == null) {
                    }
                }
            });
        }
    }

    @JvmStatic
    public static final void deleteWithNormalizeUrl(Uri uri, String normalizeUrl) {
        Keva configRepo;
        if (!Settings.Companion.get$default(Settings.INSTANCE, false, 1, null).getIsCacheEnabled() || !hasInit.get() || uri == null || normalizeUrl == null || (configRepo = getConfigRepo(uri)) == null) {
            return;
        }
        deleteWithNormalizeUrl(normalizeUrl, configRepo);
    }

    @JvmStatic
    public static final void removeAllCache(final Uri uri) {
        if (Settings.Companion.get$default(Settings.INSTANCE, false, 1, null).getIsCacheEnabled() && hasInit.get()) {
            ThreadUtil.runOnPia(new Runnable() { // from class: com.bytedance.pia.core.cache.PIACacheManager$removeAllCache$1
                @Override // java.lang.Runnable
                public final void run() {
                    String normalizeUrl$default;
                    Uri uri2 = uri;
                    if (uri2 == null || (normalizeUrl$default = UrlUtils.normalizeUrl$default(uri2, null, 2, null)) == null) {
                        return;
                    }
                    PIACacheManager.INSTANCE.removeAllCache(normalizeUrl$default);
                }
            });
        }
    }

    @JvmStatic
    public static final void mark(Uri uri, IPiaCacheProvider cache) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        if (Settings.Companion.get$default(Settings.INSTANCE, false, 1, null).getIsCacheEnabled()) {
            PIACacheManager pIACacheManager = INSTANCE;
            if (hasInit.get()) {
                pIACacheManager.innerMark(uri, cache, true);
            }
        }
    }

    @JvmStatic
    public static final boolean save(Uri uri, String content, JsonObject r8, List<String> extraVary) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(content, "content");
        if (!Settings.Companion.get$default(Settings.INSTANCE, false, 1, null).getIsCacheEnabled()) {
            return false;
        }
        PIACacheManager pIACacheManager = INSTANCE;
        if (!hasInit.get()) {
            return false;
        }
        IPiaCacheProvider.CacheConfig parseHeadersFromManifest = parseHeadersFromManifest(r8);
        if (parseHeadersFromManifest == null && (parseHeadersFromManifest = pIACacheManager.parseHeadersFromHTML(content)) == null) {
            return false;
        }
        Number maxAge = parseHeadersFromManifest.getMaxAge();
        parseHeadersFromManifest.setExpire(Long.valueOf(((maxAge != null ? maxAge.longValue() : 600) * BytePatchException.ErrorCode.paramsError) + System.currentTimeMillis()));
        parseHeadersFromManifest.setMarked(false);
        return pIACacheManager.innerSave(uri, content, parseHeadersFromManifest, extraVary);
    }

    @JvmStatic
    public static final IPiaCacheProvider queryWithNormalizeUrl(final String normalizeUrl, Keva configRepo) {
        final IPiaCacheProvider.CacheConfig queryHeaders;
        final String queryContent;
        Intrinsics.checkNotNullParameter(normalizeUrl, "normalizeUrl");
        Intrinsics.checkNotNullParameter(configRepo, "configRepo");
        if (!Settings.Companion.get$default(Settings.INSTANCE, false, 1, null).getIsCacheEnabled()) {
            return null;
        }
        PIACacheManager pIACacheManager = INSTANCE;
        if (hasInit.get() && pIACacheManager.isExist(normalizeUrl, configRepo) && (queryHeaders = queryHeaders(normalizeUrl, configRepo)) != null && (queryContent = queryContent(normalizeUrl)) != null) {
            return new IPiaCacheProvider() { // from class: com.bytedance.pia.core.cache.PIACacheManager$queryWithNormalizeUrl$1
                @Override // com.bytedance.pia.core.cache.IPiaCacheProvider
                /* renamed from: getNormalizeUrl, reason: from getter */
                public String get$normalizeUrl() {
                    return normalizeUrl;
                }

                @Override // com.bytedance.pia.core.cache.IPiaCacheProvider
                /* renamed from: getCacheContent, reason: from getter */
                public String get$html() {
                    return queryContent;
                }

                @Override // com.bytedance.pia.core.cache.IPiaCacheProvider
                /* renamed from: getCacheConfig, reason: from getter */
                public IPiaCacheProvider.CacheConfig get$config() {
                    return queryHeaders;
                }
            };
        }
        return null;
    }

    public static /* synthetic */ IPiaCacheProvider.CacheConfig queryHeaders$default(String str, Keva keva, int i, Object obj) {
        if ((i & 2) != 0) {
            keva = null;
        }
        return queryHeaders(str, keva);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x006e, code lost:
    
        if (kotlin.Result.isFailure-impl(r6) != false) goto L110;
     */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final IPiaCacheProvider.CacheConfig queryHeaders(String normalizeUrl, Keva configRepo) {
        Object obj;
        Intrinsics.checkNotNullParameter(normalizeUrl, "normalizeUrl");
        Object obj2 = null;
        if (!Settings.Companion.get$default(Settings.INSTANCE, false, 1, null).getIsCacheEnabled() || !hasInit.get()) {
            return null;
        }
        Keva keva = contentRepo;
        if (keva == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentRepo");
            keva = null;
        }
        if (!keva.contains(normalizeUrl)) {
            return null;
        }
        if (configRepo != null) {
            if (!configRepo.contains(normalizeUrl)) {
                return null;
            }
            String string = configRepo.getString(normalizeUrl, "");
            String str = string;
            if (str == null || str.length() == 0) {
                return null;
            }
            try {
                Result.Companion companion = Result.Companion;
                obj = Result.constructor-impl((IPiaCacheProvider.CacheConfig) gson.fromJson(string, IPiaCacheProvider.CacheConfig.class));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
        } else {
            Keva keva2 = contentRepo;
            if (keva2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentRepo");
                keva2 = null;
            }
            String string2 = keva2.getString(normalizeUrl + TAG_HEADERS, "");
            try {
                Result.Companion companion3 = Result.Companion;
                JsonObject parse = GsonUtils.getParser().parse(string2);
                JsonObject jsonObject = parse instanceof JsonObject ? parse : null;
                if (jsonObject != null) {
                    obj2 = gson.fromJson((JsonElement) jsonObject, IPiaCacheProvider.CacheConfig.class);
                    obj2 = Unit.INSTANCE;
                    obj = obj2;
                } else {
                    obj = null;
                }
                try {
                    Result.constructor-impl(obj2);
                    obj2 = obj;
                } catch (Throwable th2) {
                    obj2 = obj;
                    th = th2;
                    Result.Companion companion4 = Result.Companion;
                    Result.constructor-impl(ResultKt.createFailure(th));
                    return (IPiaCacheProvider.CacheConfig) obj2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
            return (IPiaCacheProvider.CacheConfig) obj2;
        }
    }

    @JvmStatic
    public static final String queryContent(String normalizeUrl) {
        Intrinsics.checkNotNullParameter(normalizeUrl, "normalizeUrl");
        if (!Settings.Companion.get$default(Settings.INSTANCE, false, 1, null).getIsCacheEnabled() || !hasInit.get()) {
            return null;
        }
        Keva keva = contentRepo;
        if (keva == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentRepo");
            keva = null;
        }
        if (!keva.contains(normalizeUrl)) {
            return null;
        }
        Keva keva2 = contentRepo;
        if (keva2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentRepo");
            keva2 = null;
        }
        String string = keva2.getString(normalizeUrl, "");
        String str = string;
        if (str == null || str.length() == 0) {
            return null;
        }
        return string;
    }

    @JvmStatic
    public static final boolean deleteWithNormalizeUrl(String normalizeUrl, Keva configRepo) {
        Intrinsics.checkNotNullParameter(normalizeUrl, "normalizeUrl");
        Intrinsics.checkNotNullParameter(configRepo, "configRepo");
        Keva keva = null;
        if (!Settings.Companion.get$default(Settings.INSTANCE, false, 1, null).getIsCacheEnabled()) {
            return false;
        }
        PIACacheManager pIACacheManager = INSTANCE;
        if (!hasInit.get() || !pIACacheManager.isExist(normalizeUrl, configRepo)) {
            return false;
        }
        configRepo.erase(normalizeUrl);
        Keva keva2 = contentRepo;
        if (keva2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentRepo");
            keva2 = null;
        }
        keva2.erase(normalizeUrl);
        Keva keva3 = contentRepo;
        if (keva3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentRepo");
        } else {
            keva = keva3;
        }
        keva.erase(normalizeUrl + TAG_HEADERS);
        return true;
    }

    @JvmStatic
    public static final Keva getConfigRepo(Uri uri) {
        if (!Settings.Companion.get$default(Settings.INSTANCE, false, 1, null).getIsCacheEnabled() || uri == null) {
            return null;
        }
        String normalizeUrl$default = UrlUtils.normalizeUrl$default(uri, null, 2, null);
        String str = normalizeUrl$default;
        if (str == null || str.length() == 0) {
            return null;
        }
        return getConfigRepo(normalizeUrl$default);
    }

    @JvmStatic
    public static final Keva getConfigRepo(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (!Settings.Companion.get$default(Settings.INSTANCE, false, 1, null).getIsCacheEnabled() || !hasInit.get()) {
            return null;
        }
        Keva keva = indexRepo;
        if (keva == null) {
            Intrinsics.throwUninitializedPropertyAccessException("indexRepo");
            keva = null;
        }
        if (keva.contains(url)) {
            Keva keva2 = indexRepo;
            if (keva2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("indexRepo");
                keva2 = null;
            }
            String string = keva2.getString(url, "");
            Intrinsics.checkNotNullExpressionValue(string, "uuid");
            if (string.length() > 0) {
                return Keva.getRepo(string);
            }
        }
        return null;
    }

    private final boolean isExist(String normalizeUrl, Keva configRepo) {
        if (!configRepo.contains(normalizeUrl)) {
            return false;
        }
        Keva keva = contentRepo;
        if (keva == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentRepo");
            keva = null;
        }
        return keva.contains(normalizeUrl);
    }

    public final void unMark(Uri uri, IPiaCacheProvider cache) {
        innerMark(uri, cache, false);
    }

    private final void innerMark(Uri uri, IPiaCacheProvider cache, boolean r6) {
        Keva configRepo;
        if (cache == null || (configRepo = getConfigRepo(uri)) == null) {
            return;
        }
        PIACacheManager pIACacheManager = INSTANCE;
        if (pIACacheManager.isExist(cache.get$normalizeUrl(), configRepo)) {
            cache.get$config().setMarked(Boolean.valueOf(r6));
            pIACacheManager.saveWithNormalizeUrl(cache.get$normalizeUrl(), cache.get$config().toJsonObject(), cache.get$html(), configRepo);
            Logger.i$default("[PIACacheManager] Finish Cache Mark. (URL: " + cache.get$normalizeUrl() + ", CacheConfig: " + cache.get$config() + ')', null, null, 6, null);
        }
    }

    private final boolean innerSave(Uri uri, String content, IPiaCacheProvider.CacheConfig config, List<String> extraVary) {
        String normalizeUrl;
        Keva keva = null;
        String normalizeUrl$default = UrlUtils.normalizeUrl$default(uri, null, 2, null);
        boolean z = false;
        if (normalizeUrl$default == null || (normalizeUrl = UrlUtils.normalizeUrl(uri, extraVary)) == null) {
            return false;
        }
        Keva keva2 = indexRepo;
        if (keva2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("indexRepo");
            keva2 = null;
        }
        if (!keva2.contains(normalizeUrl$default)) {
            initIndexRepo(normalizeUrl$default, extraVary);
        } else if (extraVary != null) {
            Keva keva3 = indexRepo;
            if (keva3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("indexRepo");
                keva3 = null;
            }
            if (keva3.contains(normalizeUrl$default + TAG_EXTRA_VARY)) {
                Keva keva4 = indexRepo;
                if (keva4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("indexRepo");
                    keva4 = null;
                }
                String[] stringArray = keva4.getStringArray(normalizeUrl$default + TAG_EXTRA_VARY, null);
                if (stringArray == null || !CollectionUtils.equal(extraVary, ArraysKt.toList(stringArray))) {
                    removeAllCache(normalizeUrl$default);
                    initIndexRepo(normalizeUrl$default, extraVary);
                }
            } else {
                Keva keva5 = indexRepo;
                if (keva5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("indexRepo");
                } else {
                    keva = keva5;
                }
                String str = normalizeUrl$default + TAG_EXTRA_VARY;
                Object[] array = extraVary.toArray(new String[0]);
                if (array != null) {
                    keva.storeStringArray(str, (String[]) array);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
            }
        }
        Keva configRepo = getConfigRepo(normalizeUrl$default);
        if (configRepo != null) {
            PIACacheManager pIACacheManager = INSTANCE;
            if (pIACacheManager.isExist(normalizeUrl, configRepo)) {
                deleteWithNormalizeUrl(normalizeUrl, configRepo);
                z = true;
            }
            pIACacheManager.saveWithNormalizeUrl(normalizeUrl, config.toJsonObject(), content, configRepo);
        }
        return z;
    }

    private final void saveWithNormalizeUrl(String normalizeUrl, JsonObject headers, String content, Keva configRepo) {
        Keva keva = contentRepo;
        if (keva == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentRepo");
            keva = null;
        }
        synchronized (keva) {
            configRepo.storeString(normalizeUrl, headers.toString());
            Keva keva2 = contentRepo;
            if (keva2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentRepo");
                keva2 = null;
            }
            keva2.storeString(normalizeUrl + TAG_HEADERS, headers.toString());
            Keva keva3 = contentRepo;
            if (keva3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentRepo");
                keva3 = null;
            }
            keva3.storeString(normalizeUrl, content);
            Logger.i$default("[PIACacheManager] Save Cache Success. (URL = " + normalizeUrl + ", CacheConfig: " + headers + ')', null, null, 6, null);
            Unit unit = Unit.INSTANCE;
        }
    }

    @JvmStatic
    public static final IPiaCacheProvider.CacheConfig parseHeadersFromManifest(JsonObject r3) {
        Object obj;
        if (r3 == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl((IPiaCacheProvider.CacheConfig) GsonUtils.getGson().fromJson(r3.getAsJsonObject("cache").toString(), IPiaCacheProvider.CacheConfig.class));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        IPiaCacheProvider.CacheConfig cacheConfig = (IPiaCacheProvider.CacheConfig) obj;
        if (cacheConfig == null || TextUtils.isEmpty(cacheConfig.getVersion())) {
            return null;
        }
        return cacheConfig;
    }

    private final IPiaCacheProvider.CacheConfig parseHeadersFromHTML(String html) {
        JsonObject parseManifest = ManifestUtils.parseManifest(html);
        if (parseManifest == null) {
            return null;
        }
        return parseHeadersFromManifest(parseManifest);
    }

    private final void initIndexRepo(String url, List<String> extraVary) {
        Keva keva = indexRepo;
        Keva keva2 = null;
        if (keva == null) {
            Intrinsics.throwUninitializedPropertyAccessException("indexRepo");
            keva = null;
        }
        keva.storeString(url, UUID.randomUUID().toString());
        if (extraVary != null) {
            Keva keva3 = indexRepo;
            if (keva3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("indexRepo");
            } else {
                keva2 = keva3;
            }
            String str = url + TAG_EXTRA_VARY;
            Object[] array = extraVary.toArray(new String[0]);
            if (array != null) {
                keva2.storeStringArray(str, (String[]) array);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
    }

    public final void removeAllCache(String normalizeUrl) {
        Logger.i$default("[PIACacheManager] Remove ALL Cache. (URL: " + normalizeUrl + ')', null, null, 6, null);
        Keva configRepo = getConfigRepo(normalizeUrl);
        if (configRepo != null) {
            Map<String, ?> all = configRepo.getAll();
            Intrinsics.checkNotNull(all, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, *>");
            Iterator<Map.Entry<String, ?>> it = all.entrySet().iterator();
            while (it.hasNext()) {
                deleteWithNormalizeUrl(it.next().getKey(), configRepo);
            }
            configRepo.clear();
        }
        removeIndexRepo(normalizeUrl);
    }

    private final void removeIndexRepo(String url) {
        Keva keva = indexRepo;
        Keva keva2 = null;
        if (keva == null) {
            Intrinsics.throwUninitializedPropertyAccessException("indexRepo");
            keva = null;
        }
        keva.erase(url);
        Keva keva3 = indexRepo;
        if (keva3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("indexRepo");
        } else {
            keva2 = keva3;
        }
        keva2.erase(url + TAG_EXTRA_VARY);
    }

    private final void postRemoveExpires() {
        if (lastRemoveTime == 0 || System.currentTimeMillis() - lastRemoveTime > 60000) {
            ThreadUtil.INSTANCE.getPiaHandler().postDelayed(new Runnable() { // from class: com.bytedance.pia.core.cache.PIACacheManager$postRemoveExpires$1
                @Override // java.lang.Runnable
                public final void run() {
                    PIACacheManager pIACacheManager = PIACacheManager.INSTANCE;
                    PIACacheManager.lastRemoveTime = System.currentTimeMillis();
                    PIACacheManager.INSTANCE.removeExpires();
                }
            }, Constants.TASK_RUN_THRESHOLD);
        }
    }

    public final void removeExpires() {
        Unit unit;
        Object obj;
        Number expire;
        if (Settings.Companion.get$default(Settings.INSTANCE, false, 1, null).getIsCacheEnabled() && hasInit.get()) {
            long currentTimeMillis = System.currentTimeMillis();
            Keva keva = indexRepo;
            if (keva == null) {
                Intrinsics.throwUninitializedPropertyAccessException("indexRepo");
                keva = null;
            }
            Map<String, ?> all = keva.getAll();
            Intrinsics.checkNotNullExpressionValue(all, "indexRepo.all");
            Iterator<Map.Entry<String, ?>> it = all.entrySet().iterator();
            while (it.hasNext()) {
                String key = it.next().getKey();
                Intrinsics.checkNotNullExpressionValue(key, "key");
                if (!StringsKt.endsWith$default(key, TAG_EXTRA_VARY, false, 2, (Object) null)) {
                    Keva configRepo = getConfigRepo(key);
                    if (configRepo != null) {
                        Map<String, ?> all2 = configRepo.getAll();
                        Intrinsics.checkNotNullExpressionValue(all2, "configRepo.all");
                        for (Map.Entry<String, ?> entry : all2.entrySet()) {
                            String key2 = entry.getKey();
                            Object value = entry.getValue();
                            String str = value instanceof String ? (String) value : null;
                            if (str != null) {
                                try {
                                    Result.Companion companion = Result.Companion;
                                    obj = Result.constructor-impl((IPiaCacheProvider.CacheConfig) gson.fromJson(str, IPiaCacheProvider.CacheConfig.class));
                                } catch (Throwable th) {
                                    Result.Companion companion2 = Result.Companion;
                                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                                }
                                if (Result.isFailure-impl(obj)) {
                                    obj = null;
                                }
                                IPiaCacheProvider.CacheConfig cacheConfig = (IPiaCacheProvider.CacheConfig) obj;
                                if (cacheConfig == null || (expire = cacheConfig.getExpire()) == null) {
                                    Intrinsics.checkNotNullExpressionValue(key2, "url");
                                    deleteWithNormalizeUrl(key2, configRepo);
                                } else if (expire.longValue() <= currentTimeMillis) {
                                    Intrinsics.checkNotNullExpressionValue(key2, "url");
                                    deleteWithNormalizeUrl(key2, configRepo);
                                    Logger.i$default("[PIACacheManager] Remove Stale Cache Success. (URL: " + key2 + ", config = " + cacheConfig + ')', null, null, 6, null);
                                }
                            } else {
                                Intrinsics.checkNotNullExpressionValue(key2, "url");
                                deleteWithNormalizeUrl(key2, configRepo);
                            }
                        }
                        unit = Unit.INSTANCE;
                    } else {
                        unit = null;
                    }
                    if (unit == null) {
                        removeIndexRepo(key);
                    }
                }
            }
        }
    }
}
