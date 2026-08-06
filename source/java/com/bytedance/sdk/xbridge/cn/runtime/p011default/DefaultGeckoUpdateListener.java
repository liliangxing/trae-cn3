package com.bytedance.sdk.xbridge.cn.runtime.p011default;

import android.util.Pair;
import bolts.Task;
import com.bytedance.geckox.listener.GeckoUpdateListener;
import com.bytedance.geckox.model.LocalPackageModel;
import com.bytedance.geckox.model.UpdatePackage;
import com.bytedance.ies.xbridge.event.Event;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.bytedance.ies.xbridge.model.collections.defaultimpl.DefaultXReadableMapImpl;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IUpdateGeckoCallback;
import com.bytedance.security.android.aopcheck.reporter.Constant;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: DefaultHostGeckoDepend.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J:\u0010\r\u001a\u00020\u000e2&\u0010\u000f\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00130\u00120\u0011\u0018\u00010\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016JL\u0010\u0016\u001a\u00020\u000e2&\u0010\u000f\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00130\u00120\u0011\u0018\u00010\u00102\u001a\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u0011\u0018\u00010\u0010H\u0016J\"\u0010\u0019\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u0013H\u0016J\u0012\u0010\u001d\u001a\u00020\u000e2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u001c\u0010 \u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00182\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010!\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00182\u0006\u0010\"\u001a\u00020\u0013H\u0016J,\u0010#\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00182\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006'"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/default/DefaultGeckoUpdateListener;", "Lcom/bytedance/geckox/listener/GeckoUpdateListener;", "callback", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IUpdateGeckoCallback;", Constant.KEY_CHANNEL, "", "accessKey", "(Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IUpdateGeckoCallback;Ljava/lang/String;Ljava/lang/String;)V", "getAccessKey", "()Ljava/lang/String;", "getCallback", "()Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IUpdateGeckoCallback;", "getChannel", "onCheckServerVersionFail", "", "requestMap", "", "", "Landroid/util/Pair;", "", "e", "", "onCheckServerVersionSuccess", "responseMap", "Lcom/bytedance/geckox/model/UpdatePackage;", "onDownloadProgress", "updatePackage", "totalSize", "currentSize", "onLocalNewestVersion", "localPackage", "Lcom/bytedance/geckox/model/LocalPackageModel;", "onUpdateFailed", "onUpdateSuccess", "version", "sendUpdateResultEvent", "failed", "", "message", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DefaultGeckoUpdateListener extends GeckoUpdateListener {
    private final String accessKey;
    private final IUpdateGeckoCallback callback;
    private final String channel;

    public final IUpdateGeckoCallback getCallback() {
        return this.callback;
    }

    public final String getChannel() {
        return this.channel;
    }

    public final String getAccessKey() {
        return this.accessKey;
    }

    public DefaultGeckoUpdateListener(IUpdateGeckoCallback iUpdateGeckoCallback, String str, String str2) {
        Intrinsics.checkNotNullParameter(iUpdateGeckoCallback, "callback");
        Intrinsics.checkNotNullParameter(str, Constant.KEY_CHANNEL);
        Intrinsics.checkNotNullParameter(str2, "accessKey");
        this.callback = iUpdateGeckoCallback;
        this.channel = str;
        this.accessKey = str2;
    }

    public void onCheckServerVersionSuccess(Map<String, List<Pair<String, Long>>> requestMap, final Map<String, List<UpdatePackage>> responseMap) {
        super.onCheckServerVersionSuccess(requestMap, responseMap);
        Task.call(new Callable() { // from class: com.bytedance.sdk.xbridge.cn.runtime.default.DefaultGeckoUpdateListener$onCheckServerVersionSuccess$1
            @Override // java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ Object call() {
                call();
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:8:0x0027, code lost:
            
                if (r0.isEmpty() == true) goto L13;
             */
            @Override // java.util.concurrent.Callable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void call() {
                boolean z;
                Map<String, List<UpdatePackage>> map = responseMap;
                if (map == null || !map.containsKey(this.getAccessKey())) {
                    this.getCallback().onAbortUpdate();
                    return;
                }
                List<UpdatePackage> list = responseMap.get(this.getAccessKey());
                if (list != null) {
                    z = true;
                }
                z = false;
                UpdatePackage updatePackage = (z || list == null) ? null : list.get(0);
                if ((updatePackage != null ? updatePackage.getFullPackage() : null) != null) {
                    this.getCallback().onNeedUpdate();
                } else {
                    this.getCallback().onAbortUpdate();
                }
            }
        }, Task.UI_THREAD_EXECUTOR);
    }

    public void onLocalNewestVersion(LocalPackageModel localPackage) {
        Task.call(new Callable() { // from class: com.bytedance.sdk.xbridge.cn.runtime.default.DefaultGeckoUpdateListener$onLocalNewestVersion$1
            @Override // java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ Object call() {
                call();
                return Unit.INSTANCE;
            }

            @Override // java.util.concurrent.Callable
            public final void call() {
                DefaultGeckoUpdateListener.this.getCallback().onSkipUpdate();
            }
        }, Task.UI_THREAD_EXECUTOR);
    }

    public void onCheckServerVersionFail(Map<String, List<Pair<String, Long>>> requestMap, Throwable e) {
        super.onCheckServerVersionFail(requestMap, e);
        Task.call(new Callable() { // from class: com.bytedance.sdk.xbridge.cn.runtime.default.DefaultGeckoUpdateListener$onCheckServerVersionFail$1
            @Override // java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ Object call() {
                call();
                return Unit.INSTANCE;
            }

            @Override // java.util.concurrent.Callable
            public final void call() {
                DefaultGeckoUpdateListener.this.getCallback().onAbortUpdate();
            }
        }, Task.UI_THREAD_EXECUTOR);
    }

    public void onUpdateFailed(UpdatePackage updatePackage, Throwable e) {
        super.onUpdateFailed(updatePackage, e);
        sendUpdateResultEvent(updatePackage, true, "gecko update failed", e);
    }

    private final void sendUpdateResultEvent(final UpdatePackage updatePackage, final boolean failed, String message, final Throwable e) {
        Task.call(new Callable() { // from class: com.bytedance.sdk.xbridge.cn.runtime.default.DefaultGeckoUpdateListener$sendUpdateResultEvent$1
            @Override // java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ Object call() {
                call();
                return Unit.INSTANCE;
            }

            @Override // java.util.concurrent.Callable
            public final void call() {
                String channel;
                String str;
                JSONObject jSONObject = new JSONObject();
                UpdatePackage updatePackage2 = updatePackage;
                DefaultGeckoUpdateListener defaultGeckoUpdateListener = DefaultGeckoUpdateListener.this;
                boolean z = failed;
                Throwable th = e;
                if (updatePackage2 == null || (channel = updatePackage2.getChannel()) == null) {
                    channel = defaultGeckoUpdateListener.getChannel();
                }
                jSONObject.put(Constant.KEY_CHANNEL, channel);
                jSONObject.put("failed", z);
                if (th == null || (str = th.getMessage()) == null) {
                    str = "";
                }
                jSONObject.put("failedMsg", str);
                EventCenter.enqueueEvent(new Event(DefaultGeckoUpdateListener.this.getChannel() + "_getGeckoUpdateResult", System.currentTimeMillis(), new DefaultXReadableMapImpl(jSONObject)));
            }
        }, Task.UI_THREAD_EXECUTOR);
    }

    public void onUpdateSuccess(UpdatePackage updatePackage, long version) {
        super.onUpdateSuccess(updatePackage, version);
        sendUpdateResultEvent(updatePackage, false, "gecko update success", null);
    }

    public void onDownloadProgress(final UpdatePackage updatePackage, final long totalSize, final long currentSize) {
        super.onDownloadProgress(updatePackage, totalSize, currentSize);
        Task.call(new Callable() { // from class: com.bytedance.sdk.xbridge.cn.runtime.default.DefaultGeckoUpdateListener$onDownloadProgress$1
            @Override // java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ Object call() {
                call();
                return Unit.INSTANCE;
            }

            @Override // java.util.concurrent.Callable
            public final void call() {
                String channel;
                JSONObject jSONObject = new JSONObject();
                UpdatePackage updatePackage2 = updatePackage;
                DefaultGeckoUpdateListener defaultGeckoUpdateListener = DefaultGeckoUpdateListener.this;
                long j = totalSize;
                long j2 = currentSize;
                if (updatePackage2 == null || (channel = updatePackage2.getChannel()) == null) {
                    channel = defaultGeckoUpdateListener.getChannel();
                }
                jSONObject.put(Constant.KEY_CHANNEL, channel);
                jSONObject.put("totalResources", j);
                jSONObject.put("loadedResources", j2);
                EventCenter.enqueueEvent(new Event(DefaultGeckoUpdateListener.this.getChannel() + "_getGeckoUpdateProgress", System.currentTimeMillis(), new DefaultXReadableMapImpl(jSONObject)));
            }
        }, Task.UI_THREAD_EXECUTOR);
    }
}
