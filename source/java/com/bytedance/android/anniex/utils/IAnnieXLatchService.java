package com.bytedance.android.anniex.utils;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.bytedance.android.anniex.base.service.IAnnieXService;
import com.bytedance.pia.core.metrics.ErrorType;
import com.bytedance.webx.core.webview.WebViewContainer;
import com.lynx.devtoolwrapper.ScreenshotMode;
import com.lynx.jsbridge.LynxModule;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.TimingHandler;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IAnnieXLatchService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\bf\u0018\u00002\u00020\u0001:\u0004$%&'J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007H&J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u0007H&J\u0014\u0010\r\u001a\u0004\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J$\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00070\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0007H&J,\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\u0019\u001a\u00020\u001aH&J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0014H&J4\u0010\u001d\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u001e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0007H&J\u0010\u0010 \u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u0007H&J\u0010\u0010!\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u0007H&J\u0018\u0010\"\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u001aH&¨\u0006("}, d2 = {"Lcom/bytedance/android/anniex/utils/IAnnieXLatchService;", "Lcom/bytedance/android/anniex/base/service/IAnnieXService;", "createLatchProcessOptions", "Lcom/bytedance/android/anniex/utils/IAnnieXLatchService$AnnieXLatchProcessOptions;", TimingHandler.OPEN_TIME, "", "display", "", "errMsg", "url", "getLatchProcess", "Lcom/bytedance/android/anniex/utils/IAnnieXLatchService$Process;", "sessionId", "getLatchViewUrlOrNull", "view", "Landroid/view/View;", "getPrefetchStrategyAndReport", "Lkotlin/Pair;", "Lcom/bytedance/android/anniex/utils/IAnnieXLatchService$PrefetchStrategy;", "uri", "Landroid/net/Uri;", "handlePrefetch", "", "context", "Landroid/content/Context;", "enablePrefetch", "", "isEnableLatch", "schema", ErrorType.PREFETCH, "pageUrl", "latchProcessOptions", "releaseLatchProcess", "reportComponentDuration", "reportComponentStart", "isLatch", "AnnieXLatchProcessOptions", "LynxModuleCreation", "PrefetchStrategy", "Process", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public interface IAnnieXLatchService extends IAnnieXService {

    /* compiled from: IAnnieXLatchService.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001R\u001a\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\u0001X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/anniex/utils/IAnnieXLatchService$LynxModuleCreation;", "", "moduleType", "Ljava/lang/Class;", "Lcom/lynx/jsbridge/LynxModule;", "getModuleType", "()Ljava/lang/Class;", "name", "", "getName", "()Ljava/lang/String;", "params", "getParams", "()Ljava/lang/Object;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes2.dex */
    public interface LynxModuleCreation {
        Class<? extends LynxModule> getModuleType();

        String getName();

        Object getParams();
    }

    /* compiled from: IAnnieXLatchService.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/anniex/utils/IAnnieXLatchService$PrefetchStrategy;", "", "(Ljava/lang/String;I)V", "Latch", "Nothing", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes2.dex */
    public enum PrefetchStrategy {
        Latch,
        Nothing
    }

    /* compiled from: IAnnieXLatchService.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\r"}, d2 = {"Lcom/bytedance/android/anniex/utils/IAnnieXLatchService$Process;", "Lio/reactivex/disposables/Disposable;", "id", "", "getId", "()I", "attachToLynxView", "", "view", "Lcom/lynx/tasm/LynxView;", "createOrGetLynxModule", "", "Lcom/bytedance/android/anniex/utils/IAnnieXLatchService$LynxModuleCreation;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes2.dex */
    public interface Process extends Disposable {
        void attachToLynxView(LynxView view);

        List<LynxModuleCreation> createOrGetLynxModule();

        int getId();
    }

    AnnieXLatchProcessOptions createLatchProcessOptions(long openTime, String display, String errMsg, String url);

    Process getLatchProcess(String sessionId);

    String getLatchViewUrlOrNull(View view);

    Pair<PrefetchStrategy, String> getPrefetchStrategyAndReport(Uri uri, String url);

    void handlePrefetch(Context context, Uri uri, String sessionId, boolean enablePrefetch);

    boolean isEnableLatch(Uri schema);

    String prefetch(Context context, String pageUrl, Uri schema, AnnieXLatchProcessOptions latchProcessOptions, String sessionId);

    void releaseLatchProcess(String sessionId);

    void reportComponentDuration(String url);

    void reportComponentStart(String url, boolean isLatch);

    /* compiled from: IAnnieXLatchService.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void handlePrefetch$default(IAnnieXLatchService iAnnieXLatchService, Context context, Uri uri, String str, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: handlePrefetch");
            }
            if ((i & 8) != 0) {
                z = true;
            }
            iAnnieXLatchService.handlePrefetch(context, uri, str, z);
        }
    }

    /* compiled from: IAnnieXLatchService.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R&\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001a\u0010\u001e\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\b¨\u0006!"}, d2 = {"Lcom/bytedance/android/anniex/utils/IAnnieXLatchService$AnnieXLatchProcessOptions;", "", "()V", "bid", "", "getBid", "()Ljava/lang/String;", "setBid", "(Ljava/lang/String;)V", "customErrorMessage", "getCustomErrorMessage", "setCustomErrorMessage", "displayType", "getDisplayType", "setDisplayType", "handleSchemeInit", "", "getHandleSchemeInit", "()J", "setHandleSchemeInit", "(J)V", "settings", "", WebViewContainer.EVENT_getSettings, "()Ljava/util/Map;", "setSettings", "(Ljava/util/Map;)V", "url", "getUrl", "setUrl", "uuid", "getUuid", "setUuid", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class AnnieXLatchProcessOptions {
        private long handleSchemeInit;
        private String url;
        private String customErrorMessage = "";
        private String displayType = ScreenshotMode.SCREEN_SHOT_MODE_FULL_SCREEN;
        private String uuid = "";
        private String bid = "";
        private Map<String, String> settings = new LinkedHashMap();

        public final String getCustomErrorMessage() {
            return this.customErrorMessage;
        }

        public final void setCustomErrorMessage(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.customErrorMessage = str;
        }

        public final long getHandleSchemeInit() {
            return this.handleSchemeInit;
        }

        public final void setHandleSchemeInit(long j) {
            this.handleSchemeInit = j;
        }

        public final String getDisplayType() {
            return this.displayType;
        }

        public final void setDisplayType(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.displayType = str;
        }

        public final String getUuid() {
            return this.uuid;
        }

        public final void setUuid(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.uuid = str;
        }

        public final String getUrl() {
            return this.url;
        }

        public final void setUrl(String str) {
            this.url = str;
        }

        public final String getBid() {
            return this.bid;
        }

        public final void setBid(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.bid = str;
        }

        public final Map<String, String> getSettings() {
            return this.settings;
        }

        public final void setSettings(Map<String, String> map) {
            Intrinsics.checkNotNullParameter(map, "<set-?>");
            this.settings = map;
        }
    }
}
