package com.bytedance.ies.bullet.web.pia;

import com.bytedance.ies.argus.api.ArgusGlobalDelegate;
import com.bytedance.ies.argus.api.params.InjectLoginStateParams;
import com.bytedance.pia.core.api.security.ISecurityDelegate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PiaSecurityDelegate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ies/bullet/web/pia/PiaSecurityDelegate;", "Lcom/bytedance/pia/core/api/security/ISecurityDelegate;", "()V", "isAccessTokenAllowed", "", "url", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PiaSecurityDelegate implements ISecurityDelegate {
    @Override // com.bytedance.pia.core.api.security.ISecurityDelegate
    public boolean isAccessTokenAllowed(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return ArgusGlobalDelegate.Companion.getInstance().verifyInjectLoginState(new InjectLoginStateParams(url, InjectLoginStateParams.SceneType.PIA)).isPass();
    }
}
