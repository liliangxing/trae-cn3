package com.bytedance.ies.bullet.service.base.init;

import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.service.base.api.IBulletService;
import java.util.List;
import kotlin.Metadata;

/* compiled from: ILoaderInitService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/init/ILoaderInitService;", "Lcom/bytedance/ies/bullet/service/base/api/IBulletService;", "getLoaderTasks", "", "Lcom/bytedance/ies/bullet/service/base/init/AbsLoaderTask;", "context", "Lcom/bytedance/ies/bullet/core/BulletContext;", "startTask", "", "callBack", "Lcom/bytedance/ies/bullet/service/base/init/ILoaderTasksCallBack;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface ILoaderInitService extends IBulletService {
    List<AbsLoaderTask> getLoaderTasks(BulletContext context);

    void startTask(BulletContext context, ILoaderTasksCallBack callBack);
}
