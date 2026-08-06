package com.bytedance.pia.core.setting;

import android.net.Uri;
import com.bytedance.iesgurd.exception.BytePatchException;
import com.bytedance.keva.Keva;
import com.bytedance.pia.core.api.PiaAppInfo;
import com.bytedance.pia.core.api.PiaEnv;
import com.bytedance.pia.core.api.bridge.PiaMethod;
import com.bytedance.pia.core.api.resource.IResourceLoader;
import com.bytedance.pia.core.api.resource.IResourceRequest;
import com.bytedance.pia.core.api.resource.IResourceResponse;
import com.bytedance.pia.core.api.resource.LoadFrom;
import com.bytedance.pia.core.api.utils.IConsumer;
import com.bytedance.pia.core.api.utils.IFactory;
import com.bytedance.pia.core.bridge.methods.ErrorCode;
import com.bytedance.pia.core.cache.IPiaCacheProvider;
import com.bytedance.pia.core.metrics.ErrorType;
import com.bytedance.pia.core.setting.Config;
import com.bytedance.pia.core.utils.DefaultResourceLoader;
import com.bytedance.pia.core.utils.GsonUtils;
import com.bytedance.pia.core.utils.Logger;
import com.bytedance.pia.core.utils.UrlUtils;
import com.bytedance.trae.network.FrontierIdGenerator;
import com.bytedance.ug.sdk.deeplink.CommonConstants;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: SettingService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u001c\u001a\u00020\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0015H\u0016J\u000e\u0010\u000b\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\fJ\n\u0010 \u001a\u0004\u0018\u00010\u0015H\u0002J\b\u0010!\u001a\u0004\u0018\u00010\nJ\u0010\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020$H\u0002J&\u0010%\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\u00042\u0006\u0010#\u001a\u00020$2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00040\u0013H\u0002J\u0010\u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020*H\u0002J\b\u0010+\u001a\u00020\u001eH\u0002J\u0016\u0010,\u001a\u00020\u001e2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0004J\u0010\u0010-\u001a\u00020\f2\u0006\u0010&\u001a\u00020\u0004H\u0002J\u0012\u0010.\u001a\u00020\u001e2\b\u0010/\u001a\u0004\u0018\u000100H\u0002J\u0014\u00101\u001a\u0004\u0018\u0001022\b\u0010\u001d\u001a\u0004\u0018\u00010\u0015H\u0016J\u000e\u00103\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\fJ\u0006\u00104\u001a\u00020\u001eJ2\u00104\u001a\u00020\u001e2\b\u00105\u001a\u0004\u0018\u00010\u00152\u0010\u00106\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0018\u0001072\u000e\u00108\u001a\n\u0012\u0004\u0012\u000209\u0018\u000107J\u001e\u0010:\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020$2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00040\u0013H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u001aj\b\u0012\u0004\u0012\u00020\u0004`\u001bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/bytedance/pia/core/setting/SettingService;", "Lcom/bytedance/pia/core/setting/Config$IProvider;", "()V", "PAGE_SETTING_PREFIX", "", "SDK_APP_ID", "SETTINGS_REPO_NAME", "TAG", "apiHost", "appInfo", "Lcom/bytedance/pia/core/api/PiaAppInfo;", "enableSetting", "", "hasUpdate", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isUpdating", "lastUpdatedTime", "", "pageNamesV2", "", "requestAPI", "Landroid/net/Uri;", ErrorType.SETTINGS, "Lcom/bytedance/keva/Keva;", IPiaCacheProvider.CacheConfig.FIELD_VERSION, "whiteList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "contains", "uri", "", "enable", "generateRequestUri", "getAppInfo", "handleDataReader", "reader", "Lcom/google/gson/stream/JsonReader;", "handleSettingsV2", "key", "pageName", "handleStream", "input", "Ljava/io/InputStream;", "initDebugConfig", "initialize", "matchFeatureV2", "onUpdateError", "e", "", "provide", "Lcom/bytedance/pia/core/setting/Config;", "realEnableSetting", "updateAsync", "url", "success", "Lcom/bytedance/pia/core/api/utils/IConsumer;", "error", "Lcom/bytedance/pia/core/api/bridge/PiaMethod$Error;", "updateSettings2Page", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class SettingService implements Config.IProvider {
    private static final String PAGE_SETTING_PREFIX = "page/";
    private static final String SDK_APP_ID = "349653";
    private static final String SETTINGS_REPO_NAME = "pia_settings";
    private static final String TAG = "PIASettings";
    private static String apiHost;
    private static PiaAppInfo appInfo;
    private static long lastUpdatedTime;
    private static Uri requestAPI;
    private static Keva settings;
    private static String version;
    public static final SettingService INSTANCE = new SettingService();
    private static AtomicBoolean isUpdating = new AtomicBoolean(false);
    private static AtomicBoolean hasUpdate = new AtomicBoolean(false);
    private static boolean enableSetting = true;
    private static final Set<String> pageNamesV2 = new LinkedHashSet();
    private static final ArrayList<String> whiteList = new ArrayList<>();

    private SettingService() {
    }

    public final void enableSetting(boolean enable) {
        PiaAppInfo piaAppInfo = appInfo;
        if (piaAppInfo != null) {
            if (piaAppInfo == null) {
                Intrinsics.throwUninitializedPropertyAccessException("appInfo");
                piaAppInfo = null;
            }
            if (piaAppInfo.isDebuggable) {
                realEnableSetting(enable);
            }
        }
    }

    public final void realEnableSetting(boolean enable) {
        Settings.INSTANCE.enableSettings(enable);
        enableSetting = enable;
    }

    public final PiaAppInfo getAppInfo() {
        PiaAppInfo piaAppInfo = appInfo;
        if (piaAppInfo == null) {
            return null;
        }
        if (piaAppInfo != null) {
            return piaAppInfo;
        }
        Intrinsics.throwUninitializedPropertyAccessException("appInfo");
        return null;
    }

    public final void initialize(PiaAppInfo appInfo2, String apiHost2) {
        Intrinsics.checkNotNullParameter(appInfo2, "appInfo");
        Intrinsics.checkNotNullParameter(apiHost2, "apiHost");
        if (settings != null) {
            return;
        }
        appInfo = appInfo2;
        apiHost = apiHost2;
        Keva repo = Keva.getRepo(SETTINGS_REPO_NAME);
        Intrinsics.checkNotNullExpressionValue(repo, "getRepo(SETTINGS_REPO_NAME)");
        settings = repo;
        initDebugConfig();
        updateAsync();
    }

    private final void initDebugConfig() {
        PiaAppInfo piaAppInfo = appInfo;
        if (piaAppInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appInfo");
            piaAppInfo = null;
        }
        if (piaAppInfo.isDebuggable) {
            PiaAppInfo piaAppInfo2 = appInfo;
            if (piaAppInfo2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("appInfo");
                piaAppInfo2 = null;
            }
            List<String> list = piaAppInfo2.whiteList;
            if (list != null) {
                for (String str : list) {
                    try {
                        Result.Companion companion = Result.Companion;
                        String normalizeUrl$default = UrlUtils.normalizeUrl$default(Uri.parse(str), null, 2, null);
                        Result.constructor-impl(normalizeUrl$default != null ? Boolean.valueOf(whiteList.add(normalizeUrl$default)) : null);
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.Companion;
                        Result.constructor-impl(ResultKt.createFailure(th));
                    }
                }
            }
            Logger.d$default("[PIASettings] init whiteList: " + whiteList, null, null, 6, null);
        }
    }

    public final void updateAsync() {
        updateAsync(null, null, null);
    }

    public final void updateAsync(final Uri url, final IConsumer<Unit> success, final IConsumer<PiaMethod.Error> error) {
        if (appInfo == null) {
            return;
        }
        int i = 1;
        if (isUpdating.compareAndSet(false, true)) {
            PiaAppInfo piaAppInfo = appInfo;
            IResourceLoader iResourceLoader = null;
            if (piaAppInfo == null) {
                Intrinsics.throwUninitializedPropertyAccessException("appInfo");
                piaAppInfo = null;
            }
            if (!piaAppInfo.isDebuggable && hasUpdate.get()) {
                PiaAppInfo piaAppInfo2 = appInfo;
                if (piaAppInfo2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("appInfo");
                    piaAppInfo2 = null;
                }
                long j = piaAppInfo2.settingFrequency;
                if (j <= 0 || System.currentTimeMillis() - lastUpdatedTime < j * 60 * BytePatchException.ErrorCode.paramsError) {
                    return;
                }
            }
            PiaAppInfo piaAppInfo3 = appInfo;
            if (piaAppInfo3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("appInfo");
                piaAppInfo3 = null;
            }
            if (!piaAppInfo3.isDebuggable || url == null) {
                url = generateRequestUri();
            }
            if (url == null) {
                return;
            }
            IFactory<IResourceLoader> resourceLoaderFactory = PiaEnv.Default.getResourceLoaderFactory();
            DefaultResourceLoader create = resourceLoaderFactory != null ? resourceLoaderFactory.create() : null;
            if (create == null) {
                create = new DefaultResourceLoader(iResourceLoader, i, iResourceLoader);
            }
            Logger.i$default("[PIASettings] start fetching settings, URL: " + url, null, null, 6, null);
            create.loadAsync(LoadFrom.Online, new IResourceRequest() { // from class: com.bytedance.pia.core.setting.SettingService$updateAsync$2
                @Override // com.bytedance.pia.core.api.resource.IResourceRequest
                public final Uri getUrl() {
                    return url;
                }
            }, new IConsumer() { // from class: com.bytedance.pia.core.setting.SettingService$updateAsync$3
                @Override // com.bytedance.pia.core.api.utils.IConsumer
                public final void accept(IResourceResponse iResourceResponse) {
                    AtomicBoolean atomicBoolean;
                    AtomicBoolean atomicBoolean2;
                    InputStream data;
                    Object obj;
                    atomicBoolean = SettingService.isUpdating;
                    atomicBoolean.set(false);
                    atomicBoolean2 = SettingService.hasUpdate;
                    atomicBoolean2.set(true);
                    SettingService settingService = SettingService.INSTANCE;
                    SettingService.lastUpdatedTime = System.currentTimeMillis();
                    if (iResourceResponse == null || (data = iResourceResponse.getData()) == null) {
                        return;
                    }
                    IConsumer<PiaMethod.Error> iConsumer = error;
                    IConsumer<Unit> iConsumer2 = success;
                    try {
                        Result.Companion companion = Result.Companion;
                        SettingService.INSTANCE.handleStream(data);
                        obj = Result.constructor-impl(Unit.INSTANCE);
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.createFailure(th));
                    }
                    Throwable th2 = Result.exceptionOrNull-impl(obj);
                    if (th2 != null) {
                        if (iConsumer != null) {
                            iConsumer.accept(new PiaMethod.Error(ErrorCode.WORKER_NO_JS_RUNTIME_ERROR, th2.getMessage()));
                        }
                        Logger.e$default("[PIASettings] Exception happened when handling settings stream. Error: " + th2, null, null, 6, null);
                    }
                    if (Result.isSuccess-impl(obj)) {
                        if (iConsumer2 != null) {
                            iConsumer2.accept(null);
                        }
                        Logger.i$default("[PIASettings] Update Async settings success.", null, null, 6, null);
                    }
                }
            }, new IConsumer() { // from class: com.bytedance.pia.core.setting.SettingService$updateAsync$4
                @Override // com.bytedance.pia.core.api.utils.IConsumer
                public final void accept(Throwable th) {
                    SettingService settingService = SettingService.INSTANCE;
                    IConsumer<PiaMethod.Error> iConsumer = error;
                    if (iConsumer != null) {
                        iConsumer.accept(new PiaMethod.Error(ErrorCode.WORKER_SYNTAX_ERROR, th.getMessage()));
                    }
                    settingService.onUpdateError(th);
                    Logger.i$default("[PIASettings] Update Async settings failed. Error: " + th.getMessage(), null, null, 6, null);
                }
            });
        }
    }

    @Override // com.bytedance.pia.core.setting.Config.IProvider
    public boolean contains(Uri uri) {
        if (uri == null) {
            return false;
        }
        if (!enableSetting) {
            return true;
        }
        String normalizeUrl$default = UrlUtils.normalizeUrl$default(uri, null, 2, null);
        if (normalizeUrl$default == null) {
            return false;
        }
        return pageNamesV2.contains(normalizeUrl$default) || whiteList.contains(normalizeUrl$default);
    }

    @Override // com.bytedance.pia.core.setting.Config.IProvider
    public Config provide(Uri uri) {
        Object obj;
        String str;
        long currentTimeMillis = System.currentTimeMillis();
        if (uri == null) {
            return null;
        }
        if (!uri.getBooleanQueryParameter("_pia_", false)) {
            return null;
        }
        String normalizeUrl$default = UrlUtils.normalizeUrl$default(uri, null, 2, null);
        if (CollectionsKt.contains(whiteList, normalizeUrl$default)) {
            return new Config(SetsKt.setOf(new String[]{"nsr", ErrorType.PREFETCH, ErrorType.SNAPSHOT, "cache"}), null, null, false, 14, null);
        }
        Keva keva = settings;
        if (keva == null) {
            return null;
        }
        if (keva == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ErrorType.SETTINGS);
            keva = null;
        }
        if (!keva.contains(normalizeUrl$default)) {
            return null;
        }
        Keva keva2 = settings;
        if (keva2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ErrorType.SETTINGS);
            keva2 = null;
        }
        String string = keva2.getString(normalizeUrl$default, "");
        String str2 = string;
        if (str2 == null || str2.length() == 0) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            SettingService settingService = this;
            JsonObject asJsonObject = GsonUtils.getParser().parse(string).getAsJsonObject();
            Set set = (Set) GsonUtils.getGson().fromJson(asJsonObject.get("features"), Set.class);
            String asString = asJsonObject.get(IPiaCacheProvider.CacheConfig.FIELD_VERSION).getAsString();
            String str3 = version;
            if (str3 != null) {
                if (str3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(IPiaCacheProvider.CacheConfig.FIELD_VERSION);
                    str3 = null;
                }
                if (!Intrinsics.areEqual(str3, asString)) {
                    return null;
                }
            }
            JsonElement jsonElement = asJsonObject.get("manifestVersion");
            if (jsonElement != null) {
                Intrinsics.checkNotNullExpressionValue(jsonElement, "get(\"manifestVersion\")");
                str = (jsonElement.isJsonPrimitive() && jsonElement.getAsJsonPrimitive().isString()) ? jsonElement.getAsString() : "";
            } else {
                str = null;
            }
            String str4 = str == null ? "" : str;
            Intrinsics.checkNotNull(set, "null cannot be cast to non-null type kotlin.collections.Set<kotlin.String>");
            obj = Result.constructor-impl(new Config(set, str4, null, false, 12, null));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.exceptionOrNull-impl(obj) != null) {
            return null;
        }
        Config config = (Config) obj;
        Logger.i$default("[PIASettings] Finish create setting. Cost Time: " + (System.currentTimeMillis() - currentTimeMillis) + ". (URL: " + uri + ", pageSetting: " + config + ')', null, null, 6, null);
        return config;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleStream(InputStream input) throws IOException {
        JsonReader jsonReader = (Closeable) new JsonReader(new InputStreamReader(input));
        try {
            JsonReader jsonReader2 = jsonReader;
            jsonReader2.beginObject();
            while (jsonReader2.hasNext()) {
                if (Intrinsics.areEqual(jsonReader2.nextName(), "data")) {
                    SettingService settingService = INSTANCE;
                    version = "" + jsonReader2.hashCode() + settingService.hashCode();
                    settingService.handleDataReader(jsonReader2);
                } else {
                    jsonReader2.skipValue();
                }
            }
            jsonReader2.endObject();
            CloseableKt.closeFinally(jsonReader, (Throwable) null);
        } finally {
        }
    }

    private final void handleDataReader(JsonReader reader) {
        if (reader.peek() == JsonToken.BEGIN_OBJECT) {
            reader.beginObject();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            while (reader.hasNext()) {
                String nextName = reader.nextName();
                Intrinsics.checkNotNullExpressionValue(nextName, "name");
                if (matchFeatureV2(nextName)) {
                    try {
                        Result.Companion companion = Result.Companion;
                        INSTANCE.handleSettingsV2(nextName, reader, linkedHashSet);
                        Result.constructor-impl(Unit.INSTANCE);
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.Companion;
                        Result.constructor-impl(ResultKt.createFailure(th));
                    }
                } else {
                    reader.skipValue();
                }
            }
            reader.endObject();
            Set<String> set = pageNamesV2;
            set.clear();
            set.addAll(linkedHashSet);
            return;
        }
        reader.skipValue();
    }

    private final boolean matchFeatureV2(String key) {
        return StringsKt.startsWith$default(key, PAGE_SETTING_PREFIX, false, 2, (Object) null);
    }

    private final void handleSettingsV2(String key, JsonReader reader, Set<String> pageName) {
        if (reader.peek() != JsonToken.BEGIN_OBJECT) {
            reader.skipValue();
            return;
        }
        reader.beginObject();
        while (reader.hasNext()) {
            if (Intrinsics.areEqual(reader.nextName(), "val")) {
                if (StringsKt.startsWith$default(key, PAGE_SETTING_PREFIX, false, 2, (Object) null)) {
                    updateSettings2Page(reader, pageName);
                } else {
                    reader.skipValue();
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
    }

    private final void updateSettings2Page(JsonReader reader, Set<String> pageName) {
        Object obj;
        if (reader.peek() == JsonToken.BEGIN_OBJECT) {
            reader.beginObject();
            JsonElement jsonArray = new JsonArray();
            Keva keva = null;
            String str = null;
            String str2 = null;
            while (reader.hasNext()) {
                String nextName = reader.nextName();
                if (nextName != null) {
                    int hashCode = nextName.hashCode();
                    if (hashCode != -290659267) {
                        if (hashCode != 116079) {
                            if (hashCode == 351608024 && nextName.equals(IPiaCacheProvider.CacheConfig.FIELD_VERSION)) {
                                if (reader.peek() == JsonToken.STRING) {
                                    str2 = reader.nextString();
                                } else {
                                    reader.skipValue();
                                }
                            }
                        } else if (nextName.equals("url")) {
                            if (reader.peek() == JsonToken.STRING) {
                                str = reader.nextString();
                            } else {
                                reader.skipValue();
                            }
                        }
                    } else if (nextName.equals("features")) {
                        if (reader.peek() == JsonToken.BEGIN_ARRAY) {
                            reader.beginArray();
                            while (reader.hasNext()) {
                                if (reader.peek() == JsonToken.STRING) {
                                    jsonArray.add(reader.nextString());
                                } else {
                                    reader.skipValue();
                                }
                            }
                            reader.endArray();
                        } else {
                            reader.skipValue();
                        }
                    }
                }
                reader.skipValue();
            }
            reader.endObject();
            String str3 = str;
            if (str3 == null || str3.length() == 0) {
                return;
            }
            try {
                Result.Companion companion = Result.Companion;
                obj = Result.constructor-impl(UrlUtils.normalizeUrl$default(Uri.parse(str), null, 2, null));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            if (Result.isFailure-impl(obj)) {
                obj = null;
            }
            String str4 = (String) obj;
            String str5 = str4;
            if (str5 == null || str5.length() == 0) {
                return;
            }
            JsonObject jsonObject = new JsonObject();
            String str6 = version;
            if (str6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(IPiaCacheProvider.CacheConfig.FIELD_VERSION);
                str6 = null;
            }
            jsonObject.addProperty(IPiaCacheProvider.CacheConfig.FIELD_VERSION, str6);
            jsonObject.addProperty("url", str);
            jsonObject.addProperty("manifestVersion", str2);
            jsonObject.add("features", jsonArray);
            Keva keva2 = settings;
            if (keva2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ErrorType.SETTINGS);
            } else {
                keva = keva2;
            }
            keva.storeString(str4, jsonObject.toString());
            pageName.add(str4);
            return;
        }
        reader.skipValue();
    }

    private final Uri generateRequestUri() {
        Uri uri = requestAPI;
        if (uri != null) {
            if (uri != null) {
                return uri;
            }
            Intrinsics.throwUninitializedPropertyAccessException("requestAPI");
            return null;
        }
        if (appInfo == null || apiHost == null) {
            return null;
        }
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https");
        String str = apiHost;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("apiHost");
            str = null;
        }
        builder.authority(str);
        builder.appendPath("common");
        builder.appendQueryParameter("app_id", SDK_APP_ID);
        PiaAppInfo piaAppInfo = appInfo;
        if (piaAppInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appInfo");
            piaAppInfo = null;
        }
        builder.appendQueryParameter(CommonConstants.KEY_DID, piaAppInfo.deviceID);
        PiaAppInfo piaAppInfo2 = appInfo;
        if (piaAppInfo2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appInfo");
            piaAppInfo2 = null;
        }
        builder.appendQueryParameter("user_id", piaAppInfo2.userID);
        PiaAppInfo piaAppInfo3 = appInfo;
        if (piaAppInfo3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appInfo");
            piaAppInfo3 = null;
        }
        builder.appendQueryParameter("channel", piaAppInfo3.channel);
        PiaAppInfo piaAppInfo4 = appInfo;
        if (piaAppInfo4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appInfo");
            piaAppInfo4 = null;
        }
        builder.appendQueryParameter("device_type", piaAppInfo4.deviceType);
        builder.appendQueryParameter(CommonConstants.KEY_DEVICE_PLATFORM, FrontierIdGenerator.APP_RUNTIME_TYPE_ANDROID);
        PiaAppInfo piaAppInfo5 = appInfo;
        if (piaAppInfo5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appInfo");
            piaAppInfo5 = null;
        }
        builder.appendQueryParameter(CommonConstants.KEY_OS_VERSION, piaAppInfo5.osVersion);
        PiaAppInfo piaAppInfo6 = appInfo;
        if (piaAppInfo6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appInfo");
            piaAppInfo6 = null;
        }
        builder.appendQueryParameter("host_app_id", String.valueOf(piaAppInfo6.appID));
        PiaAppInfo piaAppInfo7 = appInfo;
        if (piaAppInfo7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appInfo");
            piaAppInfo7 = null;
        }
        builder.appendQueryParameter("host_app_name", piaAppInfo7.appName);
        PiaAppInfo piaAppInfo8 = appInfo;
        if (piaAppInfo8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appInfo");
            piaAppInfo8 = null;
        }
        builder.appendQueryParameter("host_version", piaAppInfo8.appVersion);
        builder.appendQueryParameter(CommonConstants.SDK_VERSION, "2.0.0");
        Uri build = builder.build();
        Logger.i$default("PIA Settings Url: " + build, null, null, 6, null);
        Intrinsics.checkNotNullExpressionValue(build, "it");
        requestAPI = build;
        return build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onUpdateError(Throwable e) {
        isUpdating.set(false);
        Logger.e$default("Update settings error:", e, null, 4, null);
    }
}
