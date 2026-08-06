package com.bytedance.android.anniex.ability.service;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.anniex.base.service.IAnnieXService;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IAnnieXBizPropsProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J4\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0016J.\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0016J(\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0012\u001a\u00020\u0007H\u0016J0\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/anniex/ability/service/IAnnieXBizPropsProvider;", "Lcom/bytedance/android/anniex/base/service/IAnnieXService;", "()V", "assembleBizProps", "", "originProps", "", "", "", "kitType", "Lcom/bytedance/ies/bullet/service/base/utils/KitType;", "bid", "uri", "Landroid/net/Uri;", "getAnniXConstants", "", "getCacheParams", "originSchema", "url", "getCommonExtByContext", "context", "Landroid/content/Context;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public abstract class IAnnieXBizPropsProvider implements IAnnieXService {
    public void assembleBizProps(Map<String, Object> originProps, KitType kitType, String bid, Uri uri) {
        Intrinsics.checkNotNullParameter(originProps, "originProps");
        Intrinsics.checkNotNullParameter(kitType, "kitType");
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(uri, "uri");
    }

    public Map<String, Object> getAnniXConstants(KitType kitType, String bid, Uri uri) {
        Intrinsics.checkNotNullParameter(kitType, "kitType");
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(uri, "uri");
        return null;
    }

    public Map<String, Object> getCacheParams(String originSchema, String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return null;
    }

    public Map<String, Object> getCommonExtByContext(String bid, KitType kitType, Context context) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(kitType, "kitType");
        return null;
    }
}
