package com.bytedance.bdturing.ttnet;

import com.bytedance.android.monitorV2.constant.ReportConst;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: HttpClient.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007H&J0\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u0003H&¨\u0006\n"}, d2 = {"Lcom/bytedance/bdturing/ttnet/HttpClient;", "", "get", "", "url", "", "headers", "", "post", ReportConst.ValidationReport.BODY, "setting_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface HttpClient {
    byte[] get(String url, Map<String, String> headers);

    byte[] post(String url, Map<String, String> headers, byte[] body);

    /* compiled from: HttpClient.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ byte[] get$default(HttpClient httpClient, String str, Map map, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: get");
            }
            if ((i & 2) != 0) {
                map = null;
            }
            return httpClient.get(str, map);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ byte[] post$default(HttpClient httpClient, String str, Map map, byte[] bArr, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: post");
            }
            if ((i & 2) != 0) {
                map = null;
            }
            return httpClient.post(str, map, bArr);
        }
    }
}
