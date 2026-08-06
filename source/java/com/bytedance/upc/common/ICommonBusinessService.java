package com.bytedance.upc.common;

import android.content.Context;
import com.bytedance.upc.Configuration;
import com.bytedance.upc.IUpcBusinessService;
import kotlin.Metadata;

/* compiled from: ICommonBusinessService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/upc/common/ICommonBusinessService;", "Lcom/bytedance/upc/IUpcBusinessService;", "getConfiguration", "Lcom/bytedance/upc/Configuration;", "getContext", "Landroid/content/Context;", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public interface ICommonBusinessService extends IUpcBusinessService {
    Configuration getConfiguration();

    Context getContext();
}
