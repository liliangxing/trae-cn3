package com.bytedance.ies.bullet.service.base.api;

import com.bytedance.ies.xbridge.XBridge;
import kotlin.Metadata;

/* compiled from: IServiceCenter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/api/BidConstants;", "", "()V", XBridge.DEFAULT_NAMESPACE, "", "LIVE_SAAS", "LIVE_SDK_REGISTER_BID", "LOKI", "LUCKY", "WEBCAST", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class BidConstants {
    public static final String DEFAULT = "default_bid";
    public static final BidConstants INSTANCE = new BidConstants();
    public static final String LIVE_SAAS = "liveSaaS";
    public static final String LIVE_SDK_REGISTER_BID = "live";
    public static final String LOKI = "Loki";
    public static final String LUCKY = "BDUG_BID";
    public static final String WEBCAST = "webcast";

    private BidConstants() {
    }
}
