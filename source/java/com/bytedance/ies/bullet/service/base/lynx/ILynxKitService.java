package com.bytedance.ies.bullet.service.base.lynx;

import com.bytedance.ies.bullet.service.base.IKitService;
import com.bytedance.ies.bullet.service.base.IKitViewService;
import com.bytedance.ies.bullet.service.base.api.IServiceToken;
import kotlin.Metadata;

/* compiled from: ILynxKitService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u000eH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/lynx/ILynxKitService;", "Lcom/bytedance/ies/bullet/service/base/IKitService;", "sdkVersion", "", "getSdkVersion", "()Ljava/lang/String;", "createKitViewWithSessionId", "Lcom/bytedance/ies/bullet/service/base/IKitViewService;", "sessionId", "context", "Lcom/bytedance/ies/bullet/service/base/api/IServiceToken;", "initVmSdk", "", "isVmSdkReady", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface ILynxKitService extends IKitService {
    IKitViewService createKitViewWithSessionId(String sessionId, IServiceToken context);

    String getSdkVersion();

    void initVmSdk();

    boolean isVmSdkReady();
}
