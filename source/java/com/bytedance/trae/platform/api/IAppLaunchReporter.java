package com.bytedance.trae.platform.api;

import java.util.Map;
import kotlin.Metadata;

/* compiled from: IAppLaunchReporter.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005H&J \u0010\u0007\u001a\u00020\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005H&J4\u0010\b\u001a\u00020\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0006H&J(\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00062\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005H&J(\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00062\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005H&J<\u0010\u000f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00062\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0006H&J(\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00062\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005H&¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/platform/api/IAppLaunchReporter;", "", "reportSenseStart", "", "extraMap", "", "", "reportSenseSuccess", "reportSenseFail", "errCode", "", "errMsg", "reportStepStart", "step", "reportStepSuccess", "reportStepFail", "reportEvent", "event", "platform_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface IAppLaunchReporter {
    void reportEvent(String event, Map<String, ? extends Object> extraMap);

    void reportSenseFail(Map<String, ? extends Object> extraMap, int errCode, String errMsg);

    void reportSenseStart(Map<String, ? extends Object> extraMap);

    void reportSenseSuccess(Map<String, ? extends Object> extraMap);

    void reportStepFail(String step, Map<String, ? extends Object> extraMap, int errCode, String errMsg);

    void reportStepStart(String step, Map<String, ? extends Object> extraMap);

    void reportStepSuccess(String step, Map<String, ? extends Object> extraMap);

    /* compiled from: IAppLaunchReporter.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void reportSenseStart$default(IAppLaunchReporter iAppLaunchReporter, Map map, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportSenseStart");
            }
            if ((i & 1) != 0) {
                map = null;
            }
            iAppLaunchReporter.reportSenseStart(map);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void reportSenseSuccess$default(IAppLaunchReporter iAppLaunchReporter, Map map, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportSenseSuccess");
            }
            if ((i & 1) != 0) {
                map = null;
            }
            iAppLaunchReporter.reportSenseSuccess(map);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void reportSenseFail$default(IAppLaunchReporter iAppLaunchReporter, Map map, int i, String str, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportSenseFail");
            }
            if ((i2 & 1) != 0) {
                map = null;
            }
            if ((i2 & 2) != 0) {
                i = -1;
            }
            if ((i2 & 4) != 0) {
                str = "";
            }
            iAppLaunchReporter.reportSenseFail(map, i, str);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void reportStepStart$default(IAppLaunchReporter iAppLaunchReporter, String str, Map map, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportStepStart");
            }
            if ((i & 2) != 0) {
                map = null;
            }
            iAppLaunchReporter.reportStepStart(str, map);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void reportStepSuccess$default(IAppLaunchReporter iAppLaunchReporter, String str, Map map, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportStepSuccess");
            }
            if ((i & 2) != 0) {
                map = null;
            }
            iAppLaunchReporter.reportStepSuccess(str, map);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void reportStepFail$default(IAppLaunchReporter iAppLaunchReporter, String str, Map map, int i, String str2, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportStepFail");
            }
            if ((i2 & 2) != 0) {
                map = null;
            }
            if ((i2 & 4) != 0) {
                i = -1;
            }
            if ((i2 & 8) != 0) {
                str2 = "";
            }
            iAppLaunchReporter.reportStepFail(str, map, i, str2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void reportEvent$default(IAppLaunchReporter iAppLaunchReporter, String str, Map map, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportEvent");
            }
            if ((i & 2) != 0) {
                map = null;
            }
            iAppLaunchReporter.reportEvent(str, map);
        }
    }
}
