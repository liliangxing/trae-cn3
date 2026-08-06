package com.bytedance.trae.platform;

import com.bytedance.trae.platform.api.ISdkApm;
import com.bytedance.trae.platform.api.ISdkApplog;
import com.bytedance.trae.platform.api.ISdkCommonHttp;
import kotlin.Metadata;

/* compiled from: ITraeSdkCommonDepend.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/platform/ITraeSdkCommonDepend;", "", "getApplogService", "Lcom/bytedance/trae/platform/api/ISdkApplog;", "getApmService", "Lcom/bytedance/trae/platform/api/ISdkApm;", "getCommonHttpService", "Lcom/bytedance/trae/platform/api/ISdkCommonHttp;", "platform_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface ITraeSdkCommonDepend {
    ISdkApm getApmService();

    ISdkApplog getApplogService();

    ISdkCommonHttp getCommonHttpService();
}
