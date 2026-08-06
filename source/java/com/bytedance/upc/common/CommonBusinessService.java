package com.bytedance.upc.common;

import android.content.Context;
import com.bytedance.upc.Configuration;
import kotlin.Metadata;

/* compiled from: CommonBusinessService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/upc/common/CommonBusinessService;", "Lcom/bytedance/upc/common/ICommonBusinessService;", "()V", "getConfiguration", "Lcom/bytedance/upc/Configuration;", "getContext", "Landroid/content/Context;", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class CommonBusinessService implements ICommonBusinessService {
    @Override // com.bytedance.upc.common.ICommonBusinessService
    public Configuration getConfiguration() {
        return CommonManager.INSTANCE.getConfiguration();
    }

    @Override // com.bytedance.upc.common.ICommonBusinessService
    public Context getContext() {
        return CommonManager.INSTANCE.getContext();
    }
}
