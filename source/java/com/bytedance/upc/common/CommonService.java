package com.bytedance.upc.common;

import android.content.Context;
import com.bytedance.upc.Configuration;
import com.bytedance.upc.IUpcLifecycleService;
import com.bytedance.webx.seclink.util.ReportUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CommonService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\u001c\u0010\u000b\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/upc/common/CommonService;", "Lcom/bytedance/upc/IUpcLifecycleService;", "()V", ReportUtil.Event.EVENT_INIT, "", "context", "Landroid/content/Context;", "configuration", "Lcom/bytedance/upc/Configuration;", "priority", "", "start", "did", "", "uid", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class CommonService implements IUpcLifecycleService {
    public int priority() {
        return 0;
    }

    public void start(String did, String uid) {
    }

    public void init(Context context, Configuration configuration) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(configuration, "configuration");
        CommonManager.INSTANCE.init(context, configuration);
    }
}
