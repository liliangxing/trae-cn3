package com.bytedance.ies.bullet.service.prefetch;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: LocalStorageService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\fJ\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H&J\"\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0007H&¨\u0006\r"}, d2 = {"Lcom/bytedance/ies/bullet/service/prefetch/LocalStorageService;", "", "getCacheForUrl", "Lorg/json/JSONObject;", "url", "", "clearOnRead", "", "setCacheForUrl", "", "data", "override", "Base", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface LocalStorageService {
    JSONObject getCacheForUrl(String url, boolean clearOnRead);

    void setCacheForUrl(String url, JSONObject data, boolean override);

    /* compiled from: LocalStorageService.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void setCacheForUrl$default(LocalStorageService localStorageService, String str, JSONObject jSONObject, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setCacheForUrl");
            }
            if ((i & 4) != 0) {
                z = true;
            }
            localStorageService.setCacheForUrl(str, jSONObject, z);
        }

        public static /* synthetic */ JSONObject getCacheForUrl$default(LocalStorageService localStorageService, String str, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCacheForUrl");
            }
            if ((i & 2) != 0) {
                z = false;
            }
            return localStorageService.getCacheForUrl(str, z);
        }
    }

    /* compiled from: LocalStorageService.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u000eH\u0016R'\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ies/bullet/service/prefetch/LocalStorageService$Base;", "Lcom/bytedance/ies/bullet/service/prefetch/LocalStorageService;", "()V", "localData", "", "", "Lorg/json/JSONObject;", "getLocalData", "()Ljava/util/Map;", "localData$delegate", "Lkotlin/Lazy;", "getCacheForUrl", "url", "clearOnRead", "", "setCacheForUrl", "", "data", "override", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class Base implements LocalStorageService {

        /* renamed from: localData$delegate, reason: from kotlin metadata */
        private final Lazy localData = LazyKt.lazy(new Function0<Map<String, JSONObject>>() { // from class: com.bytedance.ies.bullet.service.prefetch.LocalStorageService$Base$localData$2
            public final Map<String, JSONObject> invoke() {
                return new LinkedHashMap();
            }
        });

        @Override // com.bytedance.ies.bullet.service.prefetch.LocalStorageService
        public void setCacheForUrl(String url, JSONObject data, boolean override) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(data, "data");
            getLocalData().put(url, data);
        }

        @Override // com.bytedance.ies.bullet.service.prefetch.LocalStorageService
        public JSONObject getCacheForUrl(String url, boolean clearOnRead) {
            Intrinsics.checkNotNullParameter(url, "url");
            JSONObject jSONObject = getLocalData().get(url);
            if (jSONObject == null) {
                return null;
            }
            if (!clearOnRead) {
                return jSONObject;
            }
            getLocalData().remove(url);
            return jSONObject;
        }

        public final Map<String, JSONObject> getLocalData() {
            return (Map) this.localData.getValue();
        }
    }
}
