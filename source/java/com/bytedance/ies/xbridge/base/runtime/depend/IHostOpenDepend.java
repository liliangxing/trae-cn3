package com.bytedance.ies.xbridge.base.runtime.depend;

import com.bytedance.ies.xbridge.model.context.XContextProviderFactory;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IHostOpenDepend.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\u00020\u0001:\u0005\u001b\u001c\u001d\u001e\u001fJ'\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016¢\u0006\u0002\u0010\tJ\u001a\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\rH\u0016J\"\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H&J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0005H\u0016J/\u0010\u0016\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0012H\u0016¢\u0006\u0002\u0010\u001a¨\u0006 "}, d2 = {"Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostOpenDepend;", "", "getGeckoInfo", "", "accessKey", "", "channel", "getGeckoInfoCallback", "Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostOpenDepend$IGetGeckoInfoCallback;", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostOpenDepend$IGetGeckoInfoCallback;)Lkotlin/Unit;", "registerGeckoUpdateListener", "containerId", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostOpenDepend$IGeckoUpdateListener;", "scanCode", "contextProviderFactory", "Lcom/bytedance/ies/xbridge/model/context/XContextProviderFactory;", "cameraOnly", "", "scanResultCallback", "Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostOpenDepend$IScanResultCallback;", "unRegisterGeckoUpdateListener", "updateGecko", "updateGeckoCallback", "Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostOpenDepend$IUpdateGeckoCallback;", "enableDownloadAutoRetry", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostOpenDepend$IUpdateGeckoCallback;Z)Lkotlin/Unit;", "GeckoInfoBean", "IGeckoUpdateListener", "IGetGeckoInfoCallback", "IScanResultCallback", "IUpdateGeckoCallback", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IHostOpenDepend {

    /* compiled from: IHostOpenDepend.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static Unit getGeckoInfo(IHostOpenDepend iHostOpenDepend, String accessKey, String channel, IGetGeckoInfoCallback getGeckoInfoCallback) {
            Intrinsics.checkNotNullParameter(accessKey, "accessKey");
            Intrinsics.checkNotNullParameter(channel, "channel");
            Intrinsics.checkNotNullParameter(getGeckoInfoCallback, "getGeckoInfoCallback");
            return null;
        }

        public static void registerGeckoUpdateListener(IHostOpenDepend iHostOpenDepend, String str, IGeckoUpdateListener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
        }

        public static void unRegisterGeckoUpdateListener(IHostOpenDepend iHostOpenDepend, String containerId) {
            Intrinsics.checkNotNullParameter(containerId, "containerId");
        }

        public static Unit updateGecko(IHostOpenDepend iHostOpenDepend, String accessKey, String channel, IUpdateGeckoCallback updateGeckoCallback, boolean z) {
            Intrinsics.checkNotNullParameter(accessKey, "accessKey");
            Intrinsics.checkNotNullParameter(channel, "channel");
            Intrinsics.checkNotNullParameter(updateGeckoCallback, "updateGeckoCallback");
            return null;
        }
    }

    /* compiled from: IHostOpenDepend.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H&¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostOpenDepend$IGeckoUpdateListener;", "", "onGeckoUpdateSuccess", "", "params", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public interface IGeckoUpdateListener {
        void onGeckoUpdateSuccess(Object params);
    }

    /* compiled from: IHostOpenDepend.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostOpenDepend$IGetGeckoInfoCallback;", "", "onResult", "", "result", "Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostOpenDepend$GeckoInfoBean;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public interface IGetGeckoInfoCallback {
        void onResult(GeckoInfoBean result);
    }

    /* compiled from: IHostOpenDepend.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostOpenDepend$IUpdateGeckoCallback;", "", "onAbortUpdate", "", "onNeedUpdate", "onSkipUpdate", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public interface IUpdateGeckoCallback {
        void onAbortUpdate();

        void onNeedUpdate();

        void onSkipUpdate();
    }

    Unit getGeckoInfo(String accessKey, String channel, IGetGeckoInfoCallback getGeckoInfoCallback);

    void registerGeckoUpdateListener(String containerId, IGeckoUpdateListener listener);

    void scanCode(XContextProviderFactory contextProviderFactory, boolean cameraOnly, IScanResultCallback scanResultCallback);

    void unRegisterGeckoUpdateListener(String containerId);

    Unit updateGecko(String accessKey, String channel, IUpdateGeckoCallback updateGeckoCallback, boolean enableDownloadAutoRetry);

    /* compiled from: IHostOpenDepend.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&¨\u0006\b"}, d2 = {"Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostOpenDepend$IScanResultCallback;", "", "onFailure", "", "msg", "", "onSuccess", "result", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public interface IScanResultCallback {
        void onFailure(String msg);

        void onSuccess(String result);

        /* compiled from: IHostOpenDepend.kt */
        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class DefaultImpls {
            public static /* synthetic */ void onFailure$default(IScanResultCallback iScanResultCallback, String str, int i, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onFailure");
                }
                if ((i & 1) != 0) {
                    str = "";
                }
                iScanResultCallback.onFailure(str);
            }
        }
    }

    /* compiled from: IHostOpenDepend.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostOpenDepend$GeckoInfoBean;", "", "needUpdata", "", "(Z)V", "getNeedUpdata", "()Z", "totalSize", "", "getTotalSize", "()Ljava/lang/Long;", "setTotalSize", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "version", "", "getVersion", "()Ljava/lang/String;", "setVersion", "(Ljava/lang/String;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class GeckoInfoBean {
        private final boolean needUpdata;
        private Long totalSize;
        private String version;

        public GeckoInfoBean(boolean z) {
            this.needUpdata = z;
        }

        public final boolean getNeedUpdata() {
            return this.needUpdata;
        }

        public final Long getTotalSize() {
            return this.totalSize;
        }

        public final void setTotalSize(Long l) {
            this.totalSize = l;
        }

        public final String getVersion() {
            return this.version;
        }

        public final void setVersion(String str) {
            this.version = str;
        }
    }
}
