package com.bytedance.ies.bullet.service.base;

import com.bytedance.ies.bullet.service.base.api.IBulletService;
import com.bytedance.ies.bullet.service.base.api.IServiceToken;
import kotlin.Metadata;

/* compiled from: IKitService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0012\u001a\u00020\u0013H&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/IKitService;", "Lcom/bytedance/ies/bullet/service/base/api/IBulletService;", "kitConfig", "Lcom/bytedance/ies/bullet/service/base/IKitConfig;", "getKitConfig", "()Lcom/bytedance/ies/bullet/service/base/IKitConfig;", "setKitConfig", "(Lcom/bytedance/ies/bullet/service/base/IKitConfig;)V", "beginSection", "", "sectionName", "", "createKitView", "Lcom/bytedance/ies/bullet/service/base/IKitViewService;", "context", "Lcom/bytedance/ies/bullet/service/base/api/IServiceToken;", "endSection", "initKit", "ready", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface IKitService extends IBulletService {
    void beginSection(String sectionName);

    IKitViewService createKitView(IServiceToken context);

    void endSection(String sectionName);

    IKitConfig getKitConfig();

    void initKit(IServiceToken context);

    boolean ready();

    void setKitConfig(IKitConfig iKitConfig);
}
