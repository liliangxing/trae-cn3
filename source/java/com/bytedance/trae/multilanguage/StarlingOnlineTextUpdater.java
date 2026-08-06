package com.bytedance.trae.multilanguage;

import android.content.Context;
import android.net.Uri;
import com.bytedance.common.utility.NetworkClient;
import com.bytedance.pia.core.cache.IPiaCacheProvider;
import com.bytedance.push.utils.RomVersionParamHelper;
import com.bytedance.trae.utils.logger.TraeLogUtil;
import com.bytedance.ug.sdk.deeplink.CommonConstants;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: StarlingOnlineTextUpdater.kt */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\"\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001=B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\\\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\t\u0018\u00010\u00122\u001c\b\u0002\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\u0015JT\u0010\u0017\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00102\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\t\u0018\u00010\u00122\u001c\b\u0002\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\u0015J\u0018\u0010\u0019\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0010H\u0002J\u0018\u0010\u001a\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0010H\u0002J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005H\u0002J\"\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0010H\u0002J(\u0010\u001f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u001eH\u0002J\u0010\u0010!\u001a\u00020\"2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0018\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020\u0005H\u0002J\u0018\u0010&\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0010H\u0002J\u0018\u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0010H\u0002J&\u0010)\u001a\u00020\t2\u0006\u0010*\u001a\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020+0-2\u0006\u0010\u0018\u001a\u00020\u0010H\u0002J\"\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050/*\u00020+2\b\b\u0002\u00100\u001a\u000201H\u0002J\u000e\u00102\u001a\u0004\u0018\u00010\u0005*\u00020+H\u0002J\u000e\u00103\u001a\u0004\u0018\u00010\u0005*\u00020+H\u0002J\u0014\u00104\u001a\u00020\t*\u00020+2\u0006\u00105\u001a\u00020\u0005H\u0002J\f\u00106\u001a\u00020\u0005*\u00020\u0005H\u0002J\f\u00107\u001a\u00020\u0005*\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00108\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00050<X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;", "", "<init>", "()V", "TAG", "", "executor", "Ljava/util/concurrent/ExecutorService;", "refreshAll", "", "context", "Landroid/content/Context;", "config", "Lcom/bytedance/trae/multilanguage/StarlingOnlineTextConfig;", "languages", "", "Lcom/bytedance/trae/multilanguage/I18nLanguage;", "onSuccess", "Lkotlin/Function1;", "Lcom/bytedance/trae/multilanguage/StarlingOnlineTextResult;", "onError", "Lkotlin/Function2;", "", "refresh", "language", "buildUrl", "buildLanguagesParam", "request", "url", "loadCachedPayload", "Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater$StarlingPayload;", "saveCachedPayload", "payload", "cacheDir", "Ljava/io/File;", "cacheFile", "dir", "key", "cacheKey", "parsePayload", "body", "addCandidateObjects", "json", "Lorg/json/JSONObject;", "candidates", "", "toStringMap", "", "skipMetaKeys", "", "firstStringValue", "optVersion", "checkStatus", EventConstants.PARAM_SOURCE, "redactAppKey", "toCacheFilePart", "DATA_KEYS", "CACHE_DIR_NAME", "CACHE_FILE_SUFFIX", "META_KEYS", "", "StarlingPayload", "multilanguage_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class StarlingOnlineTextUpdater {
    private static final String CACHE_DIR_NAME = "starling_online_text";
    private static final String CACHE_FILE_SUFFIX = ".json";
    private static final List<String> DATA_KEYS;
    public static final StarlingOnlineTextUpdater INSTANCE = new StarlingOnlineTextUpdater();
    private static final Set<String> META_KEYS;
    private static final String TAG = "StarlingOnlineText";
    private static final ExecutorService executor;

    private StarlingOnlineTextUpdater() {
    }

    static {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.bytedance.trae.multilanguage.StarlingOnlineTextUpdater$$ExternalSyntheticLambda3
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread executor$lambda$1;
                executor$lambda$1 = StarlingOnlineTextUpdater.executor$lambda$1(runnable);
                return executor$lambda$1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(newSingleThreadExecutor, "newSingleThreadExecutor(...)");
        executor = newSingleThreadExecutor;
        DATA_KEYS = CollectionsKt.listOf(new String[]{"Data", "data"});
        META_KEYS = SetsKt.setOf(new String[]{"code", "data", "error", "err_msg", CommonConstants.KEY_ERROR_NO, "lang", "language", "locale", "log_id", "message", "msg", "namespace", "result", "status", "success", IPiaCacheProvider.CacheConfig.FIELD_VERSION});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Thread executor$lambda$1(Runnable runnable) {
        Thread thread = new Thread(runnable, "starling-online-text");
        thread.setDaemon(true);
        return thread;
    }

    public static /* synthetic */ void refreshAll$default(StarlingOnlineTextUpdater starlingOnlineTextUpdater, Context context, StarlingOnlineTextConfig starlingOnlineTextConfig, List list, Function1 function1, Function2 function2, int i, Object obj) {
        if ((i & 4) != 0) {
            list = CollectionsKt.listOf(new I18nLanguage[]{I18nLanguage.f137EN, I18nLanguage.f139ZH, I18nLanguage.f138JA});
        }
        starlingOnlineTextUpdater.refreshAll(context, starlingOnlineTextConfig, list, (i & 8) != 0 ? null : function1, (i & 16) != 0 ? null : function2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence refreshAll$lambda$2(I18nLanguage i18nLanguage) {
        Intrinsics.checkNotNullParameter(i18nLanguage, "it");
        return i18nLanguage.getCode();
    }

    public final void refreshAll(Context context, StarlingOnlineTextConfig config, List<? extends I18nLanguage> languages, Function1<? super StarlingOnlineTextResult, Unit> onSuccess, Function2<? super I18nLanguage, ? super Throwable, Unit> onError) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(languages, "languages");
        List<? extends I18nLanguage> list = languages;
        TraeLogUtil.INSTANCE.m437i(TAG, "refreshAll scheduled: languages=" + CollectionsKt.joinToString$default(list, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.bytedance.trae.multilanguage.StarlingOnlineTextUpdater$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                CharSequence refreshAll$lambda$2;
                refreshAll$lambda$2 = StarlingOnlineTextUpdater.refreshAll$lambda$2((I18nLanguage) obj);
                return refreshAll$lambda$2;
            }
        }, 31, (Object) null));
        for (I18nLanguage i18nLanguage : list) {
            StarlingOnlineTextUpdater starlingOnlineTextUpdater = INSTANCE;
            Context applicationContext = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            starlingOnlineTextUpdater.refresh(applicationContext, config, i18nLanguage, onSuccess, onError);
        }
    }

    public final void refresh(final Context context, final StarlingOnlineTextConfig config, final I18nLanguage language, final Function1<? super StarlingOnlineTextResult, Unit> onSuccess, final Function2<? super I18nLanguage, ? super Throwable, Unit> onError) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(language, "language");
        executor.execute(new Runnable() { // from class: com.bytedance.trae.multilanguage.StarlingOnlineTextUpdater$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                StarlingOnlineTextUpdater.refresh$lambda$8(StarlingOnlineTextConfig.this, language, context, onSuccess, onError);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void refresh$lambda$8(StarlingOnlineTextConfig starlingOnlineTextConfig, I18nLanguage i18nLanguage, Context context, Function1 function1, Function2 function2) {
        String str;
        String str2;
        Object obj;
        Throwable th;
        StarlingOnlineTextUpdater starlingOnlineTextUpdater = INSTANCE;
        try {
            Result.Companion companion = Result.Companion;
            str2 = starlingOnlineTextUpdater.buildUrl(starlingOnlineTextConfig, i18nLanguage);
            try {
                StarlingPayload loadCachedPayload = starlingOnlineTextUpdater.loadCachedPayload(context, starlingOnlineTextConfig, i18nLanguage);
                if (loadCachedPayload != null) {
                    str = "";
                    try {
                        I18nTextProvider.INSTANCE.updateStrings(i18nLanguage, loadCachedPayload.getStrings());
                        TraeLogUtil traeLogUtil = TraeLogUtil.INSTANCE;
                        StringBuilder append = new StringBuilder("cache hit: key=").append(starlingOnlineTextUpdater.cacheKey(starlingOnlineTextConfig, i18nLanguage)).append(", count=").append(loadCachedPayload.getStrings().size()).append(", version=");
                        String version = loadCachedPayload.getVersion();
                        if (version == null) {
                            version = str;
                        }
                        traeLogUtil.m437i(TAG, append.append(version).toString());
                    } catch (Throwable th2) {
                        th = th2;
                        Result.Companion companion2 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.createFailure(th));
                        if (Result.isSuccess-impl(obj)) {
                        }
                        th = Result.exceptionOrNull-impl(obj);
                        if (th == null) {
                        }
                    }
                } else {
                    str = "";
                }
                TraeLogUtil.INSTANCE.m437i(TAG, "refresh start: language=" + i18nLanguage.getCode() + ", url=" + starlingOnlineTextUpdater.redactAppKey(str2));
                StarlingPayload parsePayload = starlingOnlineTextUpdater.parsePayload(starlingOnlineTextUpdater.request(str2), i18nLanguage);
                if (!parsePayload.getStrings().isEmpty()) {
                    I18nTextProvider.INSTANCE.updateStrings(i18nLanguage, parsePayload.getStrings());
                    starlingOnlineTextUpdater.saveCachedPayload(context, starlingOnlineTextConfig, i18nLanguage, parsePayload);
                }
                obj = Result.constructor-impl(new StarlingOnlineTextResult(i18nLanguage, parsePayload.getStrings().size(), str2, parsePayload.getVersion()));
            } catch (Throwable th3) {
                th = th3;
                str = "";
            }
        } catch (Throwable th4) {
            th = th4;
            str = "";
            str2 = str;
        }
        if (Result.isSuccess-impl(obj)) {
            StarlingOnlineTextResult starlingOnlineTextResult = (StarlingOnlineTextResult) obj;
            TraeLogUtil traeLogUtil2 = TraeLogUtil.INSTANCE;
            StringBuilder append2 = new StringBuilder("refresh success: language=").append(starlingOnlineTextResult.getLanguage().getCode()).append(", count=").append(starlingOnlineTextResult.getStringCount()).append(", version=");
            String version2 = starlingOnlineTextResult.getVersion();
            traeLogUtil2.m437i(TAG, append2.append(version2 == null ? str : version2).toString());
            if (function1 != null) {
                function1.invoke(starlingOnlineTextResult);
            }
        }
        th = Result.exceptionOrNull-impl(obj);
        if (th == null) {
            TraeLogUtil.INSTANCE.m442w(TAG, "refresh failed: language=" + i18nLanguage.getCode() + ", url=" + INSTANCE.redactAppKey(str2) + ", error=" + th.getClass().getSimpleName() + ": " + th.getMessage(), th);
            if (function2 != null) {
                function2.invoke(i18nLanguage, th);
            }
        }
    }

    private final String buildUrl(StarlingOnlineTextConfig config, I18nLanguage language) {
        return StringsKt.trimEnd(config.getZoneHost(), new char[]{'/'}) + "/check_and_get_text/" + Uri.encode(config.getApiKey()) + '/' + Uri.encode(config.getMode()) + '/' + Uri.encode(config.getNamespace()) + "?lang=" + Uri.encode(buildLanguagesParam(config, language), ",");
    }

    private final String buildLanguagesParam(StarlingOnlineTextConfig config, I18nLanguage language) {
        List plus = CollectionsKt.plus(CollectionsKt.listOf(language.getCode()), config.getFallbackLanguages());
        ArrayList arrayList = new ArrayList();
        for (Object obj : plus) {
            if (!StringsKt.isBlank((String) obj)) {
                arrayList.add(obj);
            }
        }
        return CollectionsKt.joinToString$default(CollectionsKt.distinct(arrayList), ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    private final String request(String url) {
        NetworkClient.ReqContext reqContext = new NetworkClient.ReqContext();
        reqContext.addCommonParams = false;
        String str = NetworkClient.getDefault().get(url, MapsKt.emptyMap(), reqContext);
        Intrinsics.checkNotNullExpressionValue(str, "get(...)");
        return str;
    }

    private final StarlingPayload loadCachedPayload(Context context, StarlingOnlineTextConfig config, I18nLanguage language) {
        Object obj;
        File cacheFile;
        StarlingPayload starlingPayload;
        try {
            Result.Companion companion = Result.Companion;
            StarlingOnlineTextUpdater starlingOnlineTextUpdater = this;
            cacheFile = cacheFile(cacheDir(context), cacheKey(config, language));
            if (!cacheFile.isFile()) {
                cacheFile = null;
            }
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (cacheFile == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(FilesKt.readText$default(cacheFile, (Charset) null, 1, (Object) null));
        JSONObject optJSONObject = jSONObject.optJSONObject("strings");
        Map<String, String> stringMap = optJSONObject != null ? toStringMap(optJSONObject, false) : null;
        if (stringMap == null) {
            stringMap = MapsKt.emptyMap();
        }
        if (stringMap.isEmpty()) {
            starlingPayload = null;
        } else {
            String optString = jSONObject.optString(IPiaCacheProvider.CacheConfig.FIELD_VERSION);
            Intrinsics.checkNotNull(optString);
            if (!(true ^ StringsKt.isBlank(optString))) {
                optString = null;
            }
            starlingPayload = new StarlingPayload(stringMap, optString);
        }
        obj = Result.constructor-impl(starlingPayload);
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            TraeLogUtil.INSTANCE.m442w(TAG, "cache load failed: language=" + language.getCode() + ", error=" + th2.getMessage(), th2);
        }
        return (StarlingPayload) (Result.isFailure-impl(obj) ? null : obj);
    }

    private final void saveCachedPayload(Context context, StarlingOnlineTextConfig config, I18nLanguage language, StarlingPayload payload) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            StarlingOnlineTextUpdater starlingOnlineTextUpdater = this;
            String cacheKey = cacheKey(config, language);
            File cacheDir = cacheDir(context);
            cacheDir.mkdirs();
            File cacheFile = cacheFile(cacheDir, cacheKey);
            JSONObject jSONObject = new JSONObject();
            String version = payload.getVersion();
            String str = "";
            if (version == null) {
                version = "";
            }
            String jSONObject2 = jSONObject.put(IPiaCacheProvider.CacheConfig.FIELD_VERSION, version).put("strings", new JSONObject(payload.getStrings())).toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "toString(...)");
            File file = new File(cacheDir, cacheFile.getName() + ".tmp");
            FilesKt.writeText$default(file, jSONObject2, (Charset) null, 2, (Object) null);
            if (!file.renameTo(cacheFile)) {
                FilesKt.writeText$default(cacheFile, jSONObject2, (Charset) null, 2, (Object) null);
                file.delete();
            }
            TraeLogUtil traeLogUtil = TraeLogUtil.INSTANCE;
            StringBuilder append = new StringBuilder("cache saved: key=").append(cacheKey).append(", count=").append(payload.getStrings().size()).append(", version=");
            String version2 = payload.getVersion();
            if (version2 != null) {
                str = version2;
            }
            traeLogUtil.m437i(TAG, append.append(str).toString());
            obj = Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            TraeLogUtil.INSTANCE.m442w(TAG, "cache save failed: language=" + language.getCode() + ", error=" + th2.getMessage(), th2);
        }
    }

    private final File cacheDir(Context context) {
        return new File(context.getFilesDir(), CACHE_DIR_NAME);
    }

    private final File cacheFile(File dir, String key) {
        return new File(dir, key + CACHE_FILE_SUFFIX);
    }

    private final String cacheKey(StarlingOnlineTextConfig config, I18nLanguage language) {
        return toCacheFilePart(CollectionsKt.joinToString$default(CollectionsKt.listOf(new String[]{config.getMode(), config.getNamespace(), language.getCode()}), RomVersionParamHelper.SEPARATOR, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
    }

    private final StarlingPayload parsePayload(String body, I18nLanguage language) {
        JSONObject optJSONObject;
        Map stringMap$default;
        Object obj;
        JSONObject jSONObject = new JSONObject(body);
        checkStatus(jSONObject, "Starling response");
        final JSONObject optJSONObject2 = jSONObject.optJSONObject("message");
        Object obj2 = null;
        if (optJSONObject2 != null) {
            StarlingOnlineTextUpdater starlingOnlineTextUpdater = INSTANCE;
            starlingOnlineTextUpdater.checkStatus(optJSONObject2, "Starling message");
            String optVersion = starlingOnlineTextUpdater.optVersion(optJSONObject2);
            Iterator it = SequencesKt.map(SequencesKt.mapNotNull(CollectionsKt.asSequence(DATA_KEYS), new Function1() { // from class: com.bytedance.trae.multilanguage.StarlingOnlineTextUpdater$$ExternalSyntheticLambda4
                public final Object invoke(Object obj3) {
                    JSONObject parsePayload$lambda$22$lambda$18;
                    parsePayload$lambda$22$lambda$18 = StarlingOnlineTextUpdater.parsePayload$lambda$22$lambda$18(optJSONObject2, (String) obj3);
                    return parsePayload$lambda$22$lambda$18;
                }
            }), new Function1() { // from class: com.bytedance.trae.multilanguage.StarlingOnlineTextUpdater$$ExternalSyntheticLambda5
                public final Object invoke(Object obj3) {
                    Map parsePayload$lambda$22$lambda$19;
                    parsePayload$lambda$22$lambda$19 = StarlingOnlineTextUpdater.parsePayload$lambda$22$lambda$19((JSONObject) obj3);
                    return parsePayload$lambda$22$lambda$19;
                }
            }).iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (!((Map) obj).isEmpty()) {
                    break;
                }
            }
            Map map = (Map) obj;
            if (map != null) {
                return new StarlingPayload(map, optVersion);
            }
            if (optJSONObject2.has("Data") && optJSONObject2.isNull("Data")) {
                return new StarlingPayload(MapsKt.emptyMap(), optVersion);
            }
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("data");
        if (optJSONObject3 != null) {
            StarlingOnlineTextUpdater starlingOnlineTextUpdater2 = INSTANCE;
            starlingOnlineTextUpdater2.checkStatus(optJSONObject3, "Starling data");
            String optVersion2 = starlingOnlineTextUpdater2.optVersion(optJSONObject3);
            if (optVersion2 == null) {
                JSONObject optJSONObject4 = optJSONObject3.optJSONObject("message");
                optVersion2 = optJSONObject4 != null ? starlingOnlineTextUpdater2.optVersion(optJSONObject4) : null;
            }
            JSONObject optJSONObject5 = optJSONObject3.optJSONObject("message");
            if (optJSONObject5 != null && (optJSONObject = optJSONObject5.optJSONObject("data")) != null && (stringMap$default = toStringMap$default(starlingOnlineTextUpdater2, optJSONObject, false, 1, null)) != null) {
                if (!(!stringMap$default.isEmpty())) {
                    stringMap$default = null;
                }
                if (stringMap$default != null) {
                    return new StarlingPayload(stringMap$default, optVersion2);
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        addCandidateObjects(jSONObject, arrayList, language);
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            arrayList3.add(toStringMap$default(INSTANCE, (JSONObject) it2.next(), false, 1, null));
        }
        ArrayList arrayList4 = new ArrayList();
        for (Object obj3 : arrayList3) {
            if (!((Map) obj3).isEmpty()) {
                arrayList4.add(obj3);
            }
        }
        Iterator it3 = arrayList4.iterator();
        if (it3.hasNext()) {
            obj2 = it3.next();
            if (it3.hasNext()) {
                int size = ((Map) obj2).size();
                do {
                    Object next = it3.next();
                    int size2 = ((Map) next).size();
                    if (size < size2) {
                        obj2 = next;
                        size = size2;
                    }
                } while (it3.hasNext());
            }
        }
        Map map2 = (Map) obj2;
        if (map2 == null) {
            map2 = MapsKt.emptyMap();
        }
        return new StarlingPayload(map2, optVersion(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JSONObject parsePayload$lambda$22$lambda$18(JSONObject jSONObject, String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return jSONObject.optJSONObject(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map parsePayload$lambda$22$lambda$19(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "it");
        return toStringMap$default(INSTANCE, jSONObject, false, 1, null);
    }

    private final void addCandidateObjects(JSONObject json, List<JSONObject> candidates, I18nLanguage language) {
        candidates.add(json);
        Iterator it = CollectionsKt.listOf(new String[]{"data", "result", "text", "texts", "values", "content", "translations", "message", "Data", language.getCode()}).iterator();
        while (it.hasNext()) {
            JSONObject optJSONObject = json.optJSONObject((String) it.next());
            if (optJSONObject != null) {
                INSTANCE.addCandidateObjects(optJSONObject, candidates, language);
            }
        }
    }

    static /* synthetic */ Map toStringMap$default(StarlingOnlineTextUpdater starlingOnlineTextUpdater, JSONObject jSONObject, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return starlingOnlineTextUpdater.toStringMap(jSONObject, z);
    }

    private final Map<String, String> toStringMap(JSONObject jSONObject, boolean z) {
        String firstStringValue;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (z) {
                Set<String> set = META_KEYS;
                Intrinsics.checkNotNull(next);
                String lowerCase = next.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                if (set.contains(lowerCase)) {
                }
            }
            Object opt = jSONObject.opt(next);
            if (opt instanceof String) {
                linkedHashMap.put(next, opt);
            } else if ((opt instanceof JSONObject) && (firstStringValue = firstStringValue((JSONObject) opt)) != null) {
                linkedHashMap.put(next, firstStringValue);
            }
        }
        return linkedHashMap;
    }

    private final String firstStringValue(JSONObject jSONObject) {
        Iterator it = CollectionsKt.listOf(new String[]{"value", "text", "message", "defaultMessage"}).iterator();
        while (it.hasNext()) {
            Object opt = jSONObject.opt((String) it.next());
            if (opt instanceof String) {
                if (((CharSequence) opt).length() > 0) {
                    return (String) opt;
                }
            }
        }
        return null;
    }

    private final String optVersion(final JSONObject jSONObject) {
        Object obj;
        Iterator it = SequencesKt.map(CollectionsKt.asSequence(CollectionsKt.listOf(new String[]{"Version", IPiaCacheProvider.CacheConfig.FIELD_VERSION})), new Function1() { // from class: com.bytedance.trae.multilanguage.StarlingOnlineTextUpdater$$ExternalSyntheticLambda1
            public final Object invoke(Object obj2) {
                String optVersion$lambda$33;
                optVersion$lambda$33 = StarlingOnlineTextUpdater.optVersion$lambda$33(jSONObject, (String) obj2);
                return optVersion$lambda$33;
            }
        }).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            Intrinsics.checkNotNull((String) obj);
            if (!StringsKt.isBlank(r1)) {
                break;
            }
        }
        return (String) obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String optVersion$lambda$33(JSONObject jSONObject, String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return jSONObject.optString(str);
    }

    private final void checkStatus(JSONObject jSONObject, String str) {
        int optInt;
        if (jSONObject.has("status") && (optInt = jSONObject.optInt("status", 200)) != 200) {
            throw new IllegalStateException(str + " status=" + optInt + ", message=" + jSONObject.opt("message"));
        }
    }

    private final String redactAppKey(String str) {
        return new Regex("/check_and_get_text/[^/]+/").replace(str, "/check_and_get_text/***/");
    }

    private final String toCacheFilePart(String str) {
        return new Regex("[^A-Za-z0-9._-]").replace(str, RomVersionParamHelper.SEPARATOR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: StarlingOnlineTextUpdater.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B%\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0004HÆ\u0003J+\u0010\u000e\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0004HÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater$StarlingPayload;", "", "strings", "", "", IPiaCacheProvider.CacheConfig.FIELD_VERSION, "<init>", "(Ljava/util/Map;Ljava/lang/String;)V", "getStrings", "()Ljava/util/Map;", "getVersion", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "multilanguage_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final /* data */ class StarlingPayload {
        private final Map<String, String> strings;
        private final String version;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StarlingPayload copy$default(StarlingPayload starlingPayload, Map map, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                map = starlingPayload.strings;
            }
            if ((i & 2) != 0) {
                str = starlingPayload.version;
            }
            return starlingPayload.copy(map, str);
        }

        public final Map<String, String> component1() {
            return this.strings;
        }

        /* renamed from: component2, reason: from getter */
        public final String getVersion() {
            return this.version;
        }

        public final StarlingPayload copy(Map<String, String> strings, String version) {
            Intrinsics.checkNotNullParameter(strings, "strings");
            return new StarlingPayload(strings, version);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StarlingPayload)) {
                return false;
            }
            StarlingPayload starlingPayload = (StarlingPayload) other;
            return Intrinsics.areEqual(this.strings, starlingPayload.strings) && Intrinsics.areEqual(this.version, starlingPayload.version);
        }

        public int hashCode() {
            int hashCode = this.strings.hashCode() * 31;
            String str = this.version;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "StarlingPayload(strings=" + this.strings + ", version=" + this.version + ')';
        }

        public StarlingPayload(Map<String, String> map, String str) {
            Intrinsics.checkNotNullParameter(map, "strings");
            this.strings = map;
            this.version = str;
        }

        public final Map<String, String> getStrings() {
            return this.strings;
        }

        public final String getVersion() {
            return this.version;
        }
    }
}
