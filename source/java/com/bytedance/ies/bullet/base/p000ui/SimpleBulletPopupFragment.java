package com.bytedance.ies.bullet.base.p000ui;

import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.service.popup.p002ui.AbsPopupFragment;
import kotlin.Metadata;

/* compiled from: SimpleBulletPopupFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ies/bullet/base/ui/SimpleBulletPopupFragment;", "Lcom/bytedance/ies/bullet/service/popup/ui/AbsPopupFragment;", "()V", "getBid", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class SimpleBulletPopupFragment extends AbsPopupFragment {
    @Override // com.bytedance.ies.bullet.service.popup.p002ui.AbsPopupFragment, com.bytedance.ies.bullet.service.base.IRouterAbilityProvider
    public String getBid() {
        String bid;
        BulletContext bulletContext = getBulletContext();
        return (bulletContext == null || (bid = bulletContext.getBid()) == null) ? super.getBid() : bid;
    }
}
