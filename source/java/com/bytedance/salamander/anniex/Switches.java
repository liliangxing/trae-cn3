package com.bytedance.salamander.anniex;

import com.bytedance.rts.foundation.Int32;
import com.bytedance.rts.foundation.RTSMapKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnniexMonitorSettingsSwitches.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0016\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/salamander/anniex/Switches;", "", "()V", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class Switches {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static Map<Integer, Switch> INDEXES;
    private static int MAX_INDEX;
    private static Switch appSettings;
    private static Switch blankBitmap;
    private static Switch checkSelf;
    private static Switch eventStream;
    private static Switch logType;
    private static Switch lynxBlank;
    private static Switch lynxFetch;
    private static Switch lynxJsb;
    private static Switch lynxMonitor;
    private static Switch lynxPerf;
    private static Switch lynxResourceLoader;
    private static Switch monitor;
    private static Switch teaReport;
    private static Switch webAutoReport;
    private static Switch webBlank;
    private static Switch webDomainWhiteList;
    private static Switch webFetch;
    private static Switch webInject;
    private static Switch webJSB;
    private static Switch webMonitor;
    private static Switch webResourceLoader;
    private static Switch webTTWebDelegate;
    private static Switch webUpdatePageData;

    /* compiled from: AnniexMonitorSettingsSwitches.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\bR\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010X\u001a\u00020\u00062\u0006\u0010Y\u001a\u00020Z2\u0006\u0010[\u001a\u00020\u0005H\u0002J\u0010\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020_H\u0016R6\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001a\u0010\u0019\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001a\u0010\u001c\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015R\u001a\u0010\u001f\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0013\"\u0004\b!\u0010\u0015R\u001a\u0010\"\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0013\"\u0004\b$\u0010\u0015R\u001a\u0010%\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0013\"\u0004\b'\u0010\u0015R\u001a\u0010(\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0013\"\u0004\b*\u0010\u0015R\u001a\u0010+\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0013\"\u0004\b-\u0010\u0015R\u001a\u0010.\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0013\"\u0004\b0\u0010\u0015R\u001a\u00101\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0013\"\u0004\b3\u0010\u0015R\u001a\u00104\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0013\"\u0004\b6\u0010\u0015R\u001a\u00107\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0013\"\u0004\b9\u0010\u0015R\u001a\u0010:\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0013\"\u0004\b<\u0010\u0015R\u001a\u0010=\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0013\"\u0004\b?\u0010\u0015R\u001a\u0010@\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u0013\"\u0004\bB\u0010\u0015R\u001a\u0010C\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u0013\"\u0004\bE\u0010\u0015R\u001a\u0010F\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u0013\"\u0004\bH\u0010\u0015R\u001a\u0010I\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u0013\"\u0004\bK\u0010\u0015R\u001a\u0010L\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u0013\"\u0004\bN\u0010\u0015R\u001a\u0010O\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u0013\"\u0004\bQ\u0010\u0015R\u001a\u0010R\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\u0013\"\u0004\bT\u0010\u0015R\u001a\u0010U\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\u0013\"\u0004\bW\u0010\u0015¨\u0006`"}, d2 = {"Lcom/bytedance/salamander/anniex/Switches$Companion;", "", "()V", "INDEXES", "", "", "Lcom/bytedance/salamander/anniex/Switch;", "Lcom/bytedance/rts/foundation/RTSMap;", "getINDEXES", "()Ljava/util/Map;", "setINDEXES", "(Ljava/util/Map;)V", "MAX_INDEX", "getMAX_INDEX", "()I", "setMAX_INDEX", "(I)V", "appSettings", "getAppSettings", "()Lcom/bytedance/salamander/anniex/Switch;", "setAppSettings", "(Lcom/bytedance/salamander/anniex/Switch;)V", "blankBitmap", "getBlankBitmap", "setBlankBitmap", "checkSelf", "getCheckSelf", "setCheckSelf", "eventStream", "getEventStream", "setEventStream", "logType", "getLogType", "setLogType", "lynxBlank", "getLynxBlank", "setLynxBlank", "lynxFetch", "getLynxFetch", "setLynxFetch", "lynxJsb", "getLynxJsb", "setLynxJsb", "lynxMonitor", "getLynxMonitor", "setLynxMonitor", "lynxPerf", "getLynxPerf", "setLynxPerf", "lynxResourceLoader", "getLynxResourceLoader", "setLynxResourceLoader", "monitor", "getMonitor", "setMonitor", "teaReport", "getTeaReport", "setTeaReport", "webAutoReport", "getWebAutoReport", "setWebAutoReport", "webBlank", "getWebBlank", "setWebBlank", "webDomainWhiteList", "getWebDomainWhiteList", "setWebDomainWhiteList", "webFetch", "getWebFetch", "setWebFetch", "webInject", "getWebInject", "setWebInject", "webJSB", "getWebJSB", "setWebJSB", "webMonitor", "getWebMonitor", "setWebMonitor", "webResourceLoader", "getWebResourceLoader", "setWebResourceLoader", "webTTWebDelegate", "getWebTTWebDelegate", "setWebTTWebDelegate", "webUpdatePageData", "getWebUpdatePageData", "setWebUpdatePageData", "createSwitch", "defaultEnabled", "", "index", "resetAll", "", "variable0", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Switch createSwitch(boolean defaultEnabled, int index) {
            Switch r0 = new Switch(defaultEnabled, index);
            RTSMapKt.set(Switches.INSTANCE.getINDEXES(), Integer.valueOf(index), r0);
            if (index > Switches.INSTANCE.getMAX_INDEX()) {
                Switches.INSTANCE.setMAX_INDEX(index);
            }
            return r0;
        }

        public Map<Integer, Switch> getINDEXES() {
            return Switches.INDEXES;
        }

        public void setINDEXES(Map<Integer, Switch> map) {
            Intrinsics.checkNotNullParameter(map, "<set-?>");
            Switches.INDEXES = map;
        }

        public int getMAX_INDEX() {
            return Switches.MAX_INDEX;
        }

        public void setMAX_INDEX(int i) {
            Switches.MAX_INDEX = i;
        }

        public Switch getMonitor() {
            return Switches.monitor;
        }

        public void setMonitor(Switch r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            Switches.monitor = r2;
        }

        public Switch getWebMonitor() {
            return Switches.webMonitor;
        }

        public void setWebMonitor(Switch r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            Switches.webMonitor = r2;
        }

        public Switch getWebBlank() {
            return Switches.webBlank;
        }

        public void setWebBlank(Switch r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            Switches.webBlank = r2;
        }

        public Switch getWebFetch() {
            return Switches.webFetch;
        }

        public void setWebFetch(Switch r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            Switches.webFetch = r2;
        }

        public Switch getWebJSB() {
            return Switches.webJSB;
        }

        public void setWebJSB(Switch r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            Switches.webJSB = r2;
        }

        public Switch getWebInject() {
            return Switches.webInject;
        }

        public void setWebInject(Switch r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            Switches.webInject = r2;
        }

        public Switch getLynxMonitor() {
            return Switches.lynxMonitor;
        }

        public void setLynxMonitor(Switch r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            Switches.lynxMonitor = r2;
        }

        public Switch getLynxPerf() {
            return Switches.lynxPerf;
        }

        public void setLynxPerf(Switch r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            Switches.lynxPerf = r2;
        }

        public Switch getLynxBlank() {
            return Switches.lynxBlank;
        }

        public void setLynxBlank(Switch r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            Switches.lynxBlank = r2;
        }

        public Switch getLynxFetch() {
            return Switches.lynxFetch;
        }

        public void setLynxFetch(Switch r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            Switches.lynxFetch = r2;
        }

        public Switch getLynxJsb() {
            return Switches.lynxJsb;
        }

        public void setLynxJsb(Switch r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            Switches.lynxJsb = r2;
        }

        public Switch getWebAutoReport() {
            return Switches.webAutoReport;
        }

        public void setWebAutoReport(Switch r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            Switches.webAutoReport = r2;
        }

        public Switch getWebUpdatePageData() {
            return Switches.webUpdatePageData;
        }

        public void setWebUpdatePageData(Switch r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            Switches.webUpdatePageData = r2;
        }

        public Switch getWebTTWebDelegate() {
            return Switches.webTTWebDelegate;
        }

        public void setWebTTWebDelegate(Switch r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            Switches.webTTWebDelegate = r2;
        }

        public Switch getTeaReport() {
            return Switches.teaReport;
        }

        public void setTeaReport(Switch r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            Switches.teaReport = r2;
        }

        public Switch getWebResourceLoader() {
            return Switches.webResourceLoader;
        }

        public void setWebResourceLoader(Switch r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            Switches.webResourceLoader = r2;
        }

        public Switch getLynxResourceLoader() {
            return Switches.lynxResourceLoader;
        }

        public void setLynxResourceLoader(Switch r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            Switches.lynxResourceLoader = r2;
        }

        public Switch getCheckSelf() {
            return Switches.checkSelf;
        }

        public void setCheckSelf(Switch r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            Switches.checkSelf = r2;
        }

        public Switch getEventStream() {
            return Switches.eventStream;
        }

        public void setEventStream(Switch r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            Switches.eventStream = r2;
        }

        public Switch getBlankBitmap() {
            return Switches.blankBitmap;
        }

        public void setBlankBitmap(Switch r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            Switches.blankBitmap = r2;
        }

        public Switch getWebDomainWhiteList() {
            return Switches.webDomainWhiteList;
        }

        public void setWebDomainWhiteList(Switch r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            Switches.webDomainWhiteList = r2;
        }

        public Switch getLogType() {
            return Switches.logType;
        }

        public void setLogType(Switch r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            Switches.logType = r2;
        }

        public Switch getAppSettings() {
            return Switches.appSettings;
        }

        public void setAppSettings(Switch r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            Switches.appSettings = r2;
        }

        public void resetAll(long variable0) {
            for (int i = 0; i <= Switches.INSTANCE.getMAX_INDEX(); i++) {
                if (i != 0) {
                    variable0 >>= 1;
                }
                Switch r3 = Switches.INSTANCE.getINDEXES().get(Integer.valueOf(i));
                if (r3 != null) {
                    r3.setEnabled(variable0 % 2 != Int32.INSTANCE.toInt64(0));
                }
            }
        }
    }

    static {
        Companion companion = new Companion(null);
        INSTANCE = companion;
        INDEXES = RTSMapKt.RTSMap();
        monitor = companion.createSwitch(true, 0);
        webMonitor = companion.createSwitch(true, 1);
        webBlank = companion.createSwitch(true, 2);
        webFetch = companion.createSwitch(true, 3);
        webJSB = companion.createSwitch(true, 4);
        webInject = companion.createSwitch(true, 5);
        lynxMonitor = companion.createSwitch(true, 6);
        lynxPerf = companion.createSwitch(true, 7);
        lynxBlank = companion.createSwitch(true, 8);
        lynxFetch = companion.createSwitch(true, 9);
        lynxJsb = companion.createSwitch(true, 10);
        webAutoReport = companion.createSwitch(true, 11);
        webUpdatePageData = companion.createSwitch(true, 12);
        webTTWebDelegate = companion.createSwitch(true, 24);
        teaReport = companion.createSwitch(true, 25);
        webResourceLoader = companion.createSwitch(true, 26);
        lynxResourceLoader = companion.createSwitch(true, 27);
        checkSelf = companion.createSwitch(true, 28);
        eventStream = companion.createSwitch(true, 29);
        blankBitmap = companion.createSwitch(true, 30);
        webDomainWhiteList = companion.createSwitch(false, 31);
        logType = companion.createSwitch(false, 32);
        appSettings = companion.createSwitch(false, 35);
    }
}
