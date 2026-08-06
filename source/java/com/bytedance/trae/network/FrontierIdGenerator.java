package com.bytedance.trae.network;

import com.heytap.mcssdk.constant.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* compiled from: FrontierIdGenerator.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/trae/network/FrontierIdGenerator;", "", "<init>", "()V", "APP_RUNTIME_TYPE_ANDROID", "", "APP_RUNTIME_TYPE_TRAE", "generateFrontierId", "", "userID", b.u, "", "appRuntimeType", "processID", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FrontierIdGenerator {
    public static final String APP_RUNTIME_TYPE_ANDROID = "Android";
    public static final String APP_RUNTIME_TYPE_TRAE = "Trae";
    public static final FrontierIdGenerator INSTANCE = new FrontierIdGenerator();

    private FrontierIdGenerator() {
    }

    public final long generateFrontierId(String userID, int appID, String appRuntimeType, int processID) {
        Intrinsics.checkNotNullParameter(userID, "userID");
        Intrinsics.checkNotNullParameter(appRuntimeType, "appRuntimeType");
        byte[] bytes = (userID + '_' + appID + '_' + appRuntimeType + '_' + processID).getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        long j = -3750763034362895579L;
        for (byte b : bytes) {
            j = (j ^ (b & 255)) * 1099511628211L;
        }
        return Long.MAX_VALUE & j;
    }
}
