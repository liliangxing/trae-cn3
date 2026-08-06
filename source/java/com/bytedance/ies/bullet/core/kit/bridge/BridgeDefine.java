package com.bytedance.ies.bullet.core.kit.bridge;

import kotlin.Metadata;

/* compiled from: BridgeMethod.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/bullet/core/kit/bridge/BridgeDefine;", "", "()V", "FAIL", "", "getFAIL", "()I", "SUCCESS", "getSUCCESS", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class BridgeDefine {
    public static final BridgeDefine INSTANCE = new BridgeDefine();
    private static final int SUCCESS = 1;
    private static final int FAIL = -1;

    private BridgeDefine() {
    }

    public final int getSUCCESS() {
        return SUCCESS;
    }

    public final int getFAIL() {
        return FAIL;
    }
}
