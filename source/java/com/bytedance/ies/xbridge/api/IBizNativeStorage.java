package com.bytedance.ies.xbridge.api;

import java.util.Set;
import kotlin.Metadata;

/* compiled from: IBizNativeStorage.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0004H&J\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0004H&J\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0004H&J$\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0007H&¨\u0006\r"}, d2 = {"Lcom/bytedance/ies/xbridge/api/IBizNativeStorage;", "Lcom/bytedance/ies/xbridge/api/INativeStorage;", "getBizStorageInfo", "", "", "biz", "getBizStorageItem", "", "key", "removeBizStorageItem", "", "setBizStorageItem", "data", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IBizNativeStorage extends INativeStorage {
    Set<String> getBizStorageInfo(String biz);

    Object getBizStorageItem(String biz, String key);

    boolean removeBizStorageItem(String biz, String key);

    boolean setBizStorageItem(String biz, String key, Object data);
}
