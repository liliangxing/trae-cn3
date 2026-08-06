package com.bytedance.ies.bullet;

import com.bytedance.ies.bullet.core.IBulletLifeCycle;
import com.bytedance.ies.bullet.service.base.IKitViewService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IBulletKitViewService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\"\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0005H&¨\u0006\f"}, d2 = {"Lcom/bytedance/ies/bullet/IBulletKitViewService;", "Lcom/bytedance/ies/bullet/service/base/IKitViewService;", "ensureViewCreated", "", "schemaUrl", "", "loadUri", "", "url", "lifeCycle", "Lcom/bytedance/ies/bullet/core/IBulletLifeCycle;", "sessionId", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IBulletKitViewService extends IKitViewService {
    @Override // com.bytedance.ies.bullet.service.base.IKitViewService
    boolean ensureViewCreated(String schemaUrl);

    void loadUri(String url, IBulletLifeCycle lifeCycle, String sessionId);

    /* compiled from: IBulletKitViewService.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static boolean ensureViewCreated(IBulletKitViewService iBulletKitViewService, String schemaUrl) {
            Intrinsics.checkNotNullParameter(schemaUrl, "schemaUrl");
            return true;
        }

        public static /* synthetic */ void loadUri$default(IBulletKitViewService iBulletKitViewService, String str, IBulletLifeCycle iBulletLifeCycle, String str2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadUri");
            }
            if ((i & 4) != 0) {
                str2 = "";
            }
            iBulletKitViewService.loadUri(str, iBulletLifeCycle, str2);
        }
    }
}
