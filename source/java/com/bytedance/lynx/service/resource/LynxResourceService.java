package com.bytedance.lynx.service.resource;

import android.net.Uri;
import com.bytedance.geckox.GeckoGlobalManager;
import com.bytedance.geckox.settings.model.GlobalConfigSettings;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.lynx.service.model.LynxServiceConfig;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.service.ILynxResourceService;
import com.lynx.tasm.service.ILynxResourceServiceRequestOperation;
import com.lynx.tasm.service.ILynxResourceServiceResponse;
import com.lynx.tasm.service.LynxResourceServiceCallback;
import com.lynx.tasm.service.LynxResourceServiceRequestParams;
import com.ss.ttvideoengine.PreloaderURLItem;
import com.ss.ttvideoengine.TTVideoEngine;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: LynxResourceService.kt */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0006H\u0016J\u001a\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010\u0006H\u0016J$\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010\u00062\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0016J\u001c\u0010(\u001a\u0004\u0018\u00010)2\b\u0010#\u001a\u0004\u0018\u00010\u00062\u0006\u0010$\u001a\u00020%H\u0016J\u0012\u0010*\u001a\u0004\u0018\u00010\u00062\u0006\u0010#\u001a\u00020\u0006H\u0002J\u0012\u0010+\u001a\u0004\u0018\u00010\u00062\u0006\u0010,\u001a\u00020\u0006H\u0002J\u0016\u0010-\u001a\u00020\u001a2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010.\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u0006H\u0002J\u0010\u0010/\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u0006H\u0002J\b\u00100\u001a\u00020\u0017H\u0002J\u0012\u00101\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u00102\u001a\u00020\u0017H\u0016J\u001a\u00103\u001a\u0004\u0018\u00010\u00062\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u0006H\u0002J*\u00107\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010\u00062\u0006\u00108\u001a\u000209H\u0016J\u0018\u0010:\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u0006H\u0002J\u0018\u0010;\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R.\u0010\u0013\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0014j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/bytedance/lynx/service/resource/LynxResourceService;", "Lcom/lynx/tasm/service/ILynxResourceService;", "()V", "MAX_SIZE", "", "TAG", "", "TRACE_RESOURCE_PROXY_ADD_RESOURCE_LOADER", "TRACE_RESOURCE_PROXY_FETCH_RESOURCE_ASYNC", "TRACE_RESOURCE_PROXY_FETCH_RESOURCE_SYNC", "TRACE_RESOURCE_PROXY_IS_LOCAL_RESOURCE", "TRACE_RESOURCE_PROXY_PRELOAD", "TRACE_RESOURCE_PROXY_PRELOAD_MEDIA", "adapter", "Lcom/bytedance/lynx/service/resource/ILynxResourceServiceAdapter;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "lynxServiceConfig", "Lcom/bytedance/lynx/service/model/LynxServiceConfig;", "prefixMap", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "shouldLogConfigError", "", "shouldLogResourceMetaError", "addResourceLoader", "", "loader", "", "templateUrl", "cancelPreloadMedia", "preloadKey", "videoID", "fetchResourceAsync", "Lcom/lynx/tasm/service/ILynxResourceServiceRequestOperation;", "url", "lynxResourceRequestParams", "Lcom/lynx/tasm/service/LynxResourceServiceRequestParams;", "callback", "Lcom/lynx/tasm/service/LynxResourceServiceCallback;", "fetchResourceSync", "Lcom/lynx/tasm/service/ILynxResourceServiceResponse;", "getPath", "getPrefix", "path", "initialize", "isContainerGeckoResource", "isFrescoLocalResource", "isInitial", "isLocalResource", "isReady", "prefix2AccessKey", "resourceMeta", "Lcom/bytedance/geckox/settings/model/GlobalConfigSettings$ResourceMeta;", SchemaConstants.QUERY_KEY_PREFIX, "preloadMedia", "size", "", "queryPrefixFromUrl", "setPrefix", "LynxService_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class LynxResourceService implements ILynxResourceService {
    private static final int MAX_SIZE = 16;
    private static final String TAG = "LynxResourceService";
    public static final String TRACE_RESOURCE_PROXY_ADD_RESOURCE_LOADER = "LynxServiceResourceProxy.addResourceLoader";
    public static final String TRACE_RESOURCE_PROXY_FETCH_RESOURCE_ASYNC = "LynxServiceResourceProxy.fetchResourceAsync";
    public static final String TRACE_RESOURCE_PROXY_FETCH_RESOURCE_SYNC = "LynxServiceResourceProxy.fetchResourceSync";
    public static final String TRACE_RESOURCE_PROXY_IS_LOCAL_RESOURCE = "LynxServiceResourceProxy.isLocalResource";
    public static final String TRACE_RESOURCE_PROXY_PRELOAD = "LynxServiceResourceProxy.preload";
    public static final String TRACE_RESOURCE_PROXY_PRELOAD_MEDIA = "LynxServiceResourceProxy.preloadMedia";
    private static ILynxResourceServiceAdapter adapter;
    private static LynxServiceConfig lynxServiceConfig;
    private static LinkedHashMap<String, String> prefixMap;
    public static final LynxResourceService INSTANCE = new LynxResourceService();
    private static boolean shouldLogResourceMetaError = true;
    private static boolean shouldLogConfigError = true;
    private static final ReentrantLock lock = new ReentrantLock();

    private LynxResourceService() {
    }

    public final void initialize(LynxServiceConfig lynxServiceConfig2, ILynxResourceServiceAdapter adapter2) {
        Intrinsics.checkNotNullParameter(lynxServiceConfig2, "lynxServiceConfig");
        Intrinsics.checkNotNullParameter(adapter2, "adapter");
        lynxServiceConfig = lynxServiceConfig2;
        adapter = adapter2;
        adapter2.initLynxResourceServiceAdapter(lynxServiceConfig2);
        final int i = 8;
        prefixMap = new LinkedHashMap<String, String>(i) { // from class: com.bytedance.lynx.service.resource.LynxResourceService$initialize$1
            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ boolean containsKey(Object obj) {
                if (obj instanceof String) {
                    return containsKey((String) obj);
                }
                return false;
            }

            public /* bridge */ boolean containsKey(String str) {
                return super.containsKey((Object) str);
            }

            @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ boolean containsValue(Object obj) {
                if (obj instanceof String) {
                    return containsValue((String) obj);
                }
                return false;
            }

            public /* bridge */ boolean containsValue(String str) {
                return super.containsValue((Object) str);
            }

            @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ Set<Map.Entry<String, String>> entrySet() {
                return getEntries();
            }

            @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ /* synthetic */ Object get(Object obj) {
                if (obj instanceof String) {
                    return get((String) obj);
                }
                return null;
            }

            @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ String get(Object obj) {
                if (obj instanceof String) {
                    return get((String) obj);
                }
                return null;
            }

            public /* bridge */ String get(String str) {
                return (String) super.get((Object) str);
            }

            public /* bridge */ Set<Map.Entry<String, String>> getEntries() {
                return super.entrySet();
            }

            public /* bridge */ Set<String> getKeys() {
                return super.keySet();
            }

            @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
            public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
                return !(obj instanceof String) ? obj2 : getOrDefault((String) obj, (String) obj2);
            }

            public final /* bridge */ String getOrDefault(Object obj, String str) {
                return !(obj instanceof String) ? str : getOrDefault((String) obj, str);
            }

            public /* bridge */ String getOrDefault(String str, String str2) {
                return (String) super.getOrDefault((Object) str, str2);
            }

            public /* bridge */ int getSize() {
                return super.size();
            }

            public /* bridge */ Collection<String> getValues() {
                return super.values();
            }

            @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ Set<String> keySet() {
                return getKeys();
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ /* synthetic */ Object remove(Object obj) {
                if (obj instanceof String) {
                    return remove((String) obj);
                }
                return null;
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ String remove(Object obj) {
                if (obj instanceof String) {
                    return remove((String) obj);
                }
                return null;
            }

            public /* bridge */ String remove(String str) {
                return (String) super.remove((Object) str);
            }

            @Override // java.util.HashMap, java.util.Map
            public final /* bridge */ boolean remove(Object obj, Object obj2) {
                if ((obj instanceof String) && (obj2 instanceof String)) {
                    return remove((String) obj, (String) obj2);
                }
                return false;
            }

            public /* bridge */ boolean remove(String str, String str2) {
                return super.remove((Object) str, (Object) str2);
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ int size() {
                return getSize();
            }

            @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ Collection<String> values() {
                return getValues();
            }

            @Override // java.util.LinkedHashMap
            protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
                return size() > 16;
            }
        };
    }

    public boolean isReady() {
        return isInitial();
    }

    public int isLocalResource(String url) {
        String prefix;
        if (!isInitial()) {
            return -1;
        }
        LynxServiceConfig lynxServiceConfig2 = lynxServiceConfig;
        Intrinsics.checkNotNull(lynxServiceConfig2);
        if (lynxServiceConfig2.getDisableGeckoResourceCheck()) {
            return -1;
        }
        String str = url;
        if ((str == null || str.length() == 0) || isFrescoLocalResource(url)) {
            return 0;
        }
        ILynxResourceServiceAdapter iLynxResourceServiceAdapter = null;
        if (!StringsKt.startsWith$default(url, "http", false, 2, (Object) null)) {
            return -1;
        }
        GlobalConfigSettings globalSettings = GeckoGlobalManager.inst().getGlobalSettings();
        GlobalConfigSettings.ResourceMeta resourceMeta = globalSettings != null ? globalSettings.getResourceMeta() : null;
        if (resourceMeta == null) {
            if (shouldLogResourceMetaError) {
                LLog.e(TAG, "could not get any valid resource meta");
                shouldLogResourceMetaError = false;
            }
            return 0;
        }
        String path = getPath(url);
        String str2 = path;
        if (str2 == null || str2.length() == 0) {
            return 0;
        }
        LinkedHashMap<String, String> linkedHashMap = prefixMap;
        Intrinsics.checkNotNull(linkedHashMap);
        String str3 = "";
        if (linkedHashMap.containsKey(path) && (prefix = getPrefix(path)) != null) {
            str3 = prefix;
        }
        if (str3.length() == 0) {
            str3 = queryPrefixFromUrl(url, path);
        }
        String str4 = str3;
        if (str4 == null || str4.length() == 0) {
            ILynxResourceServiceAdapter iLynxResourceServiceAdapter2 = adapter;
            if (iLynxResourceServiceAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            } else {
                iLynxResourceServiceAdapter = iLynxResourceServiceAdapter2;
            }
            str3 = iLynxResourceServiceAdapter.getPrefixAsGeckoCDN(path);
        }
        if (str3.length() == 0) {
            return isContainerGeckoResource(url) ? -1 : 0;
        }
        setPrefix(path, str3);
        String prefix2AccessKey = prefix2AccessKey(resourceMeta, str3);
        if (prefix2AccessKey == null || prefix2AccessKey.length() == 0) {
            return isContainerGeckoResource(url) ? -1 : 0;
        }
        return 1;
    }

    public void preloadMedia(String url, String preloadKey, String videoID, long size) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(preloadKey, "preloadKey");
        TTVideoEngine.addTask(new PreloaderURLItem(preloadKey, videoID, size, new String[]{url}));
    }

    public void cancelPreloadMedia(String preloadKey, String videoID) {
        Intrinsics.checkNotNullParameter(preloadKey, "preloadKey");
        TTVideoEngine.cancelPreloadTask(preloadKey);
        if (videoID != null) {
            TTVideoEngine.cancelPreloadTaskByVideoId(videoID);
        }
    }

    public void addResourceLoader(Object loader, String templateUrl) {
        Intrinsics.checkNotNullParameter(loader, "loader");
        Intrinsics.checkNotNullParameter(templateUrl, "templateUrl");
        if (isInitial()) {
            ILynxResourceServiceAdapter iLynxResourceServiceAdapter = adapter;
            if (iLynxResourceServiceAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                iLynxResourceServiceAdapter = null;
            }
            iLynxResourceServiceAdapter.addResourceLoader(loader, templateUrl);
        }
    }

    public ILynxResourceServiceRequestOperation fetchResourceAsync(String url, LynxResourceServiceRequestParams lynxResourceRequestParams, LynxResourceServiceCallback callback) {
        Intrinsics.checkNotNullParameter(lynxResourceRequestParams, "lynxResourceRequestParams");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ILynxResourceServiceAdapter iLynxResourceServiceAdapter = null;
        if (!isInitial()) {
            LLog.e(TAG, "Please initialize before call fetchResourceAsync.");
            callback.onResponse(new LynxResourceServiceErrorResponse(-1, "LynxResourceService is Not initialized"));
            return null;
        }
        String str = url;
        if (str == null || str.length() == 0) {
            callback.onResponse(new LynxResourceServiceErrorResponse(2, "empty url"));
            return null;
        }
        String path = getPath(url);
        if (path == null || path.length() == 0) {
            callback.onResponse(new LynxResourceServiceErrorResponse(3, "invalid url"));
            return null;
        }
        ILynxResourceServiceAdapter iLynxResourceServiceAdapter2 = adapter;
        if (iLynxResourceServiceAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            iLynxResourceServiceAdapter = iLynxResourceServiceAdapter2;
        }
        return iLynxResourceServiceAdapter.fetchResourceAsync(url, lynxResourceRequestParams, callback);
    }

    public ILynxResourceServiceResponse fetchResourceSync(String url, LynxResourceServiceRequestParams lynxResourceRequestParams) {
        Intrinsics.checkNotNullParameter(lynxResourceRequestParams, "lynxResourceRequestParams");
        if (!isInitial()) {
            LLog.e(TAG, "Please initialize before call fetchResourceSync.");
            return new LynxResourceServiceErrorResponse(-1, "LynxResourceService is Not initialized");
        }
        String str = url;
        if (str == null || str.length() == 0) {
            return new LynxResourceServiceErrorResponse(2, "empty url");
        }
        String path = getPath(url);
        if (path == null || path.length() == 0) {
            return new LynxResourceServiceErrorResponse(3, "invalid url");
        }
        ILynxResourceServiceAdapter iLynxResourceServiceAdapter = adapter;
        if (iLynxResourceServiceAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            iLynxResourceServiceAdapter = null;
        }
        return iLynxResourceServiceAdapter.fetchResourceSync(url, lynxResourceRequestParams);
    }

    private final boolean isInitial() {
        ILynxResourceServiceAdapter iLynxResourceServiceAdapter;
        if (lynxServiceConfig != null && prefixMap != null && (iLynxResourceServiceAdapter = adapter) != null) {
            if (iLynxResourceServiceAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                iLynxResourceServiceAdapter = null;
            }
            if (iLynxResourceServiceAdapter.isInitial()) {
                return true;
            }
        }
        return false;
    }

    private final String prefix2AccessKey(GlobalConfigSettings.ResourceMeta resourceMeta, String prefix) {
        GlobalConfigSettings.CurrentLevelConfig config = resourceMeta.getConfig();
        if (config == null) {
            if (shouldLogConfigError) {
                LLog.e(TAG, "could not get any valid config");
                shouldLogConfigError = false;
            }
            return null;
        }
        Map prefix2AccessKey = config.getPrefix2AccessKey();
        if (prefix2AccessKey != null) {
            return (String) prefix2AccessKey.get(prefix);
        }
        return null;
    }

    private final boolean isFrescoLocalResource(String url) {
        return StringsKt.startsWith$default(url, "file://", false, 2, (Object) null) || StringsKt.startsWith$default(url, "content://", false, 2, (Object) null) || StringsKt.startsWith$default(url, "asset://", false, 2, (Object) null) || StringsKt.startsWith$default(url, "data:", false, 2, (Object) null);
    }

    private final String queryPrefixFromUrl(String url, String path) {
        String queryParameter = Uri.parse(url).getQueryParameter(SchemaConstants.QUERY_KEY_PREFIX);
        String str = queryParameter;
        if (str == null || str.length() == 0) {
            return "";
        }
        Integer valueOf = Integer.valueOf(StringsKt.indexOf$default(path, queryParameter, 0, false, 6, (Object) null));
        if (!(valueOf.intValue() != -1)) {
            valueOf = null;
        }
        if (valueOf == null) {
            return "";
        }
        String substring = path.substring(0, valueOf.intValue() + queryParameter.length());
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0030, code lost:
    
        if ((r0 == null || r0.length() == 0) == false) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean isContainerGeckoResource(String url) {
        Uri parse = Uri.parse(url);
        String queryParameter = parse.getQueryParameter(SchemaConstants.QUERY_KEY_BUNDLE);
        if (!(queryParameter == null || queryParameter.length() == 0)) {
            String queryParameter2 = parse.getQueryParameter("channel");
        }
        String queryParameter3 = parse.getQueryParameter(SchemaConstants.QUERY_KEY_PREFIX);
        if (queryParameter3 == null || queryParameter3.length() == 0) {
            return false;
        }
        return true;
    }

    private final String getPath(String url) {
        String str = url;
        if (str == null || StringsKt.isBlank(str)) {
            return null;
        }
        Uri parse = Uri.parse(url);
        if (parse.getScheme() != null) {
            String scheme = parse.getScheme();
            Intrinsics.checkNotNull(scheme);
            if (StringsKt.startsWith$default(scheme, "http", false, 2, (Object) null)) {
                return parse.getPath();
            }
        }
        return null;
    }

    private final String getPrefix(String path) {
        ReentrantLock reentrantLock = lock;
        reentrantLock.lock();
        try {
            LinkedHashMap<String, String> linkedHashMap = prefixMap;
            Intrinsics.checkNotNull(linkedHashMap);
            String str = linkedHashMap.get(path);
            reentrantLock.unlock();
            return str;
        } catch (Throwable th) {
            lock.unlock();
            throw th;
        }
    }

    private final void setPrefix(String path, String prefix) {
        ReentrantLock reentrantLock = lock;
        reentrantLock.lock();
        try {
            LinkedHashMap<String, String> linkedHashMap = prefixMap;
            Intrinsics.checkNotNull(linkedHashMap);
            linkedHashMap.put(path, prefix);
            reentrantLock.unlock();
        } catch (Throwable th) {
            lock.unlock();
            throw th;
        }
    }
}
