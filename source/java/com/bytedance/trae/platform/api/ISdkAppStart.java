package com.bytedance.trae.platform.api;

import kotlin.Metadata;

/* compiled from: ISdkAppStart.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/platform/api/ISdkAppStart;", "", "getLastStartState", "", "isColdLaunch", "", "platform_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface ISdkAppStart {
    int getLastStartState();

    boolean isColdLaunch();

    /* compiled from: ISdkAppStart.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static int getLastStartState(ISdkAppStart iSdkAppStart) {
            return -1;
        }

        public static boolean isColdLaunch(ISdkAppStart iSdkAppStart) {
            return iSdkAppStart.getLastStartState() == 0;
        }
    }
}
