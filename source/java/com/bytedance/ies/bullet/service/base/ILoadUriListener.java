package com.bytedance.ies.bullet.service.base;

import kotlin.Metadata;

/* compiled from: IKitViewService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/ILoadUriListener;", "", "onLoadFailed", "", "uri", "", "kitView", "Lcom/bytedance/ies/bullet/service/base/IKitViewService;", "reason", "", "onLoadSuccess", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface ILoadUriListener {
    void onLoadFailed(String uri, IKitViewService kitView, Throwable reason);

    void onLoadSuccess(String uri, IKitViewService kitView);
}
