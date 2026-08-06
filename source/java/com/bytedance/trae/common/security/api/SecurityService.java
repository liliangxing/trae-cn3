package com.bytedance.trae.common.security.api;

import android.content.Context;
import com.bytedance.retrofit2.intercept.Interceptor;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: SecurityService.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH&J \u0010\n\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000b2\u0006\u0010\f\u001a\u00020\tH&J\b\u0010\r\u001a\u00020\u0003H&J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&J\b\u0010\u0011\u001a\u00020\u0012H&J\u0014\u0010\u0013\u001a\u0004\u0018\u00010\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\tH&J\u0012\u0010\u0015\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\tH&J*\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\t2\u000e\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0018H&J\b\u0010\u0019\u001a\u00020\u0012H&¨\u0006\u001a"}, d2 = {"Lcom/bytedance/trae/common/security/api/SecurityService;", "", "msInit", "", "appContext", "Landroid/content/Context;", "msReport", "context", "scene", "", "msFrameSign", "", "rawStr", "initBdInstall", "createBdInterceptor", "Lcom/bytedance/retrofit2/intercept/Interceptor;", "initAOPEnvironment", "enableTTNetEncrypt", "", "getTTNetEncryptScene", "requestUrl", "shouldAddTTNetEncryptHeader", "tryMobTTNetEncryptResult", "responseHeaders", "", "forceTTNetRetry", "api_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface SecurityService {
    Interceptor createBdInterceptor();

    boolean enableTTNetEncrypt();

    boolean forceTTNetRetry();

    String getTTNetEncryptScene(String requestUrl);

    void initAOPEnvironment(Context context);

    void initBdInstall();

    Map<String, String> msFrameSign(String rawStr);

    void msInit(Context appContext);

    void msReport(Context context, String scene);

    boolean shouldAddTTNetEncryptHeader(String requestUrl);

    void tryMobTTNetEncryptResult(String requestUrl, String scene, List<Object> responseHeaders);
}
