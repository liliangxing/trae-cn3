package com.bytedance.kmp.network.bridge;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.monitorV2.constant.ReportConst;
import com.bytedance.kmp.spi.IKmpService;
import java.lang.reflect.Type;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* compiled from: IKmpNetworkBridge.android.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001Jz\u0010\u0002\u001a\n\u0012\u0004\u0012\u0002H\u0004\u0018\u00010\u0003\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\n2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096@¢\u0006\u0002\u0010\u0012J\b\u0010\u0013\u001a\u00020\u0006H&J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0006H&¨\u0006\u0017"}, d2 = {"Lcom/bytedance/kmp/network/bridge/IKmpNetworkBridge;", "Lcom/bytedance/kmp/spi/IKmpService;", "executeForKmpResponse", "Lcom/bytedance/kmp/network/bridge/KmpResponse;", ExifInterface.GPS_DIRECTION_TRUE, "host", "", "path", "method", "headers", "", "queries", ReportConst.ValidationReport.BODY, "", "responseBodyType", "Ljava/lang/reflect/Type;", "config", "Lcom/bytedance/kmp/network/bridge/KmpRequestConfig;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/lang/Object;Ljava/lang/reflect/Type;Lcom/bytedance/kmp/network/bridge/KmpRequestConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDefaultHost", "printNetworkLog", "", "log", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface IKmpNetworkBridge extends IKmpService {
    <T> Object executeForKmpResponse(String str, String str2, String str3, Map<String, String> map, Map<String, String> map2, Object obj, Type type, KmpRequestConfig kmpRequestConfig, Continuation<? super KmpResponse<T>> continuation);

    String getDefaultHost();

    void printNetworkLog(String log);

    /* compiled from: IKmpNetworkBridge.android.kt */
    @Metadata(k = 3, mv = {1, 7, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static <T> Object executeForKmpResponse(IKmpNetworkBridge iKmpNetworkBridge, String str, String str2, String str3, Map<String, String> map, Map<String, String> map2, Object obj, Type type, KmpRequestConfig kmpRequestConfig, Continuation<? super KmpResponse<T>> continuation) {
            return null;
        }

        public static /* synthetic */ Object executeForKmpResponse$default(IKmpNetworkBridge iKmpNetworkBridge, String str, String str2, String str3, Map map, Map map2, Object obj, Type type, KmpRequestConfig kmpRequestConfig, Continuation continuation, int i, Object obj2) {
            if (obj2 == null) {
                return iKmpNetworkBridge.executeForKmpResponse(str, str2, str3, map, map2, obj, type, (i & 128) != 0 ? null : kmpRequestConfig, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: executeForKmpResponse");
        }
    }
}
