package com.bytedance.trae.kmp.network;

import com.bytedance.trae.network.DebugSettings;
import com.bytedance.trae.network.TraeHttpConnection;
import com.bytedance.trae.platform.api.ISdkCommonHttp;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.text.StringsKt;

/* compiled from: AndroidKmpHttpClientFactory.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u008e\u0001\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012e\b\u0002\u0010\u0007\u001a_\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\r0\b¢\u0006\u0004\b\u0010\u0010\u0011J0\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\r2\u0006\u0010\f\u001a\u00020\t2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\rH\u0016J,\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\r*\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\r2\u0006\u0010\f\u001a\u00020\tH\u0002J,\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\r*\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\r2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003X\u0082\u0004¢\u0006\u0002\n\u0000Rk\u0010\u0007\u001a_\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\r0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/bytedance/trae/kmp/network/NativeKmpHttpHeaderProvider;", "Lcom/bytedance/trae/kmp/network/KmpHttpHeaderProvider;", "notificationBoeEnabled", "Lkotlin/Function0;", "", "envLaneProvider", "", "serviceHeadersProvider", "Lkotlin/Function3;", "Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;", "Lkotlin/ParameterName;", "name", "options", "", "requestHeaders", "envLane", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;)V", "headers", "withNotificationBoe", "withAuth", "auth", "Lcom/bytedance/trae/kmp/network/KmpRequestAuth;", "base_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class NativeKmpHttpHeaderProvider implements KmpHttpHeaderProvider {
    public static final int $stable = 0;
    private final Function0<String> envLaneProvider;
    private final Function0<Boolean> notificationBoeEnabled;
    private final Function3<KmpHttpRequestOptions, Map<String, String>, String, Map<String, String>> serviceHeadersProvider;

    public NativeKmpHttpHeaderProvider() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NativeKmpHttpHeaderProvider(Function0<Boolean> function0, Function0<String> function02, Function3<? super KmpHttpRequestOptions, ? super Map<String, String>, ? super String, ? extends Map<String, String>> function3) {
        Intrinsics.checkNotNullParameter(function0, "notificationBoeEnabled");
        Intrinsics.checkNotNullParameter(function02, "envLaneProvider");
        Intrinsics.checkNotNullParameter(function3, "serviceHeadersProvider");
        this.notificationBoeEnabled = function0;
        this.envLaneProvider = function02;
        this.serviceHeadersProvider = function3;
    }

    public /* synthetic */ NativeKmpHttpHeaderProvider(Function0 function0, Function0 function02, Function3 function3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? (Function0) new MutablePropertyReference0Impl(DebugSettings.INSTANCE) { // from class: com.bytedance.trae.kmp.network.NativeKmpHttpHeaderProvider.1
            public Object get() {
                return Boolean.valueOf(((DebugSettings) this.receiver).getNotificationBoe());
            }

            public void set(Object obj) {
                ((DebugSettings) this.receiver).setNotificationBoe(((Boolean) obj).booleanValue());
            }
        } : function0, (i & 2) != 0 ? new Function0() { // from class: com.bytedance.trae.kmp.network.NativeKmpHttpHeaderProvider$$ExternalSyntheticLambda0
            public final Object invoke() {
                String _init_$lambda$0;
                _init_$lambda$0 = NativeKmpHttpHeaderProvider._init_$lambda$0();
                return _init_$lambda$0;
            }
        } : function02, (i & 4) != 0 ? new Function3() { // from class: com.bytedance.trae.kmp.network.NativeKmpHttpHeaderProvider$$ExternalSyntheticLambda1
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Map _init_$lambda$1;
                _init_$lambda$1 = NativeKmpHttpHeaderProvider._init_$lambda$1((KmpHttpRequestOptions) obj, (Map) obj2, (String) obj3);
                return _init_$lambda$1;
            }
        } : function3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String _init_$lambda$0() {
        return DebugSettings.INSTANCE.getEnvLane();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map _init_$lambda$1(KmpHttpRequestOptions kmpHttpRequestOptions, Map map, String str) {
        Intrinsics.checkNotNullParameter(kmpHttpRequestOptions, "options");
        Intrinsics.checkNotNullParameter(map, "requestHeaders");
        Intrinsics.checkNotNullParameter(str, "envLane");
        return TraeHttpConnection.buildServiceHeaders$default(TraeHttpConnection.INSTANCE, kmpHttpRequestOptions.getTag(), map, kmpHttpRequestOptions.getAddPpeHeaders(), kmpHttpRequestOptions.getAddCommonHeaders(), null, null, str, null, null, 432, null);
    }

    @Override // com.bytedance.trae.kmp.network.KmpHttpHeaderProvider
    public Map<String, String> headers(KmpHttpRequestOptions options, Map<String, String> requestHeaders) {
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
        return (Map) this.serviceHeadersProvider.invoke(options, withAuth(withNotificationBoe(requestHeaders, options), options.getAuth()), this.envLaneProvider.invoke());
    }

    private final Map<String, String> withNotificationBoe(Map<String, String> map, KmpHttpRequestOptions kmpHttpRequestOptions) {
        return (kmpHttpRequestOptions.getHostType() == KmpHostType.Notification && ((Boolean) this.notificationBoeEnabled.invoke()).booleanValue()) ? MapsKt.plus(map, MapsKt.mapOf(new Pair[]{TuplesKt.to("x-tt-env", "boe_notification"), TuplesKt.to("x-use-boe", "1")})) : map;
    }

    private final Map<String, String> withAuth(Map<String, String> map, KmpRequestAuth kmpRequestAuth) {
        if (kmpRequestAuth != KmpRequestAuth.CloudIdeJwtAuthorization) {
            return map;
        }
        Set<String> keySet = map.keySet();
        boolean z = false;
        if (!(keySet instanceof Collection) || !keySet.isEmpty()) {
            Iterator<T> it = keySet.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (StringsKt.equals((String) it.next(), "Authorization", true)) {
                    z = true;
                    break;
                }
            }
        }
        if (z) {
            return map;
        }
        String token = ISdkCommonHttp.INSTANCE.getToken();
        return StringsKt.isBlank(token) ? map : MapsKt.plus(map, TuplesKt.to("Authorization", "Cloud-IDE-JWT " + token));
    }
}
