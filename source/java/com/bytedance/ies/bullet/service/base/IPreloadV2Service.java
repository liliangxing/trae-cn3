package com.bytedance.ies.bullet.service.base;

import android.graphics.Typeface;
import kotlin.Metadata;

/* compiled from: IPreloadV2Service.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\b"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/IPreloadV2Service;", "", "getCacheFont", "Landroid/graphics/Typeface;", "bid", "", "url", "getCacheImage", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IPreloadV2Service {
    Typeface getCacheFont(String bid, String url);

    Object getCacheImage(String bid, String url);
}
