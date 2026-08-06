package com.bytedance.ies.bullet.p003ui.common.init;

import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.service.base.impl.BaseBulletService;
import com.bytedance.ies.bullet.service.base.init.AbsLoaderTask;
import com.bytedance.ies.bullet.service.base.init.ILoaderInitService;
import com.bytedance.ies.bullet.service.base.init.ILoaderTasksCallBack;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseTaskInitService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/ies/bullet/ui/common/init/BaseTaskInitService;", "Lcom/bytedance/ies/bullet/service/base/impl/BaseBulletService;", "Lcom/bytedance/ies/bullet/service/base/init/ILoaderInitService;", "()V", "getLoaderTasks", "", "Lcom/bytedance/ies/bullet/service/base/init/AbsLoaderTask;", "context", "Lcom/bytedance/ies/bullet/core/BulletContext;", "startTask", "", "callBack", "Lcom/bytedance/ies/bullet/service/base/init/ILoaderTasksCallBack;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class BaseTaskInitService extends BaseBulletService implements ILoaderInitService {
    @Override // com.bytedance.ies.bullet.service.base.init.ILoaderInitService
    public List<AbsLoaderTask> getLoaderTasks(BulletContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ArrayList();
    }

    @Override // com.bytedance.ies.bullet.service.base.init.ILoaderInitService
    public void startTask(BulletContext context, ILoaderTasksCallBack callBack) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callBack, "callBack");
        new WaitTaskQueue(getLoaderTasks(context)).initTasks(context, callBack);
    }
}
