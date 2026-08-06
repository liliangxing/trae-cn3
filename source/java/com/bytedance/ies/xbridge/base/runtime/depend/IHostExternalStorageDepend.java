package com.bytedance.ies.xbridge.base.runtime.depend;

import kotlin.Metadata;

/* compiled from: IHostExternalStorageDepend.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H&J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004H&J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0001H&¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostExternalStorageDepend;", "", "readStorageValue", "key", "", "removeStorageValue", "", "setStorageValue", "value", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IHostExternalStorageDepend {
    Object readStorageValue(String key);

    boolean removeStorageValue(String key);

    boolean setStorageValue(String key, Object value);
}
