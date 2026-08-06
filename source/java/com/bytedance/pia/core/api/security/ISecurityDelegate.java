package com.bytedance.pia.core.api.security;

import kotlin.Metadata;

/* compiled from: ISecurityDelegate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/pia/core/api/security/ISecurityDelegate;", "", "isAccessTokenAllowed", "", "url", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface ISecurityDelegate {
    boolean isAccessTokenAllowed(String url);
}
