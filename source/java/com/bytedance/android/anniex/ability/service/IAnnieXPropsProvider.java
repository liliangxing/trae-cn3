package com.bytedance.android.anniex.ability.service;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.anniex.base.service.IAnnieXService;
import com.bytedance.ies.bullet.service.base.api.IBulletService;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IAnnieXPropsProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u0002J&\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH&J&\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH&J8\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005H&J0\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/anniex/ability/service/IAnnieXPropsProvider;", "Lcom/bytedance/ies/bullet/service/base/api/IBulletService;", "Lcom/bytedance/android/anniex/base/service/IAnnieXService;", "getAppCommonProps", "", "", "", "bid", "kitType", "Lcom/bytedance/ies/bullet/service/base/utils/KitType;", "getPageCommonProps", "getPageDynamicProps", "uri", "Landroid/net/Uri;", "sessionId", "getPropsByActivity", "context", "Landroid/content/Context;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public interface IAnnieXPropsProvider extends IBulletService, IAnnieXService {

    /* compiled from: IAnnieXPropsProvider.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static Map<String, Object> getPropsByActivity(IAnnieXPropsProvider iAnnieXPropsProvider, String bid, KitType kitType, Context context) {
            Intrinsics.checkNotNullParameter(bid, "bid");
            Intrinsics.checkNotNullParameter(kitType, "kitType");
            return null;
        }
    }

    Map<String, Object> getAppCommonProps(String bid, KitType kitType);

    Map<String, Object> getPageCommonProps(String bid, KitType kitType);

    Map<String, Object> getPageDynamicProps(String bid, KitType kitType, Uri uri, String sessionId);

    Map<String, Object> getPropsByActivity(String bid, KitType kitType, Context context);
}
