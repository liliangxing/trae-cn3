package com.bytedance.ies.xbridge.event;

import android.webkit.WebView;
import com.bytedance.ies.xbridge.IDLXBridgeMethod;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.perf.monitor.ReportConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Subscriber.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ies/xbridge/event/Subscriber;", "", "containerID", "", ReportConst.KEY_TIMESTAMP, "", "jsEventDelegate", "Lcom/bytedance/ies/xbridge/XBridgeMethod$JsEventDelegate;", "webView", "Landroid/webkit/WebView;", "(Ljava/lang/String;JLcom/bytedance/ies/xbridge/XBridgeMethod$JsEventDelegate;Landroid/webkit/WebView;)V", "getContainerID", "()Ljava/lang/String;", "idlJsEventDelegate", "Lcom/bytedance/ies/xbridge/IDLXBridgeMethod$JSEventDelegate;", "getIdlJsEventDelegate", "()Lcom/bytedance/ies/xbridge/IDLXBridgeMethod$JSEventDelegate;", "setIdlJsEventDelegate", "(Lcom/bytedance/ies/xbridge/IDLXBridgeMethod$JSEventDelegate;)V", "getJsEventDelegate", "()Lcom/bytedance/ies/xbridge/XBridgeMethod$JsEventDelegate;", "getTimestamp", "()J", "getWebView", "()Landroid/webkit/WebView;", "equals", "", "other", "hashCode", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class Subscriber {
    private final String containerID;
    private IDLXBridgeMethod.JSEventDelegate idlJsEventDelegate;
    private final XBridgeMethod.JsEventDelegate jsEventDelegate;
    private final long timestamp;
    private final WebView webView;

    public Subscriber(String str, long j, XBridgeMethod.JsEventDelegate jsEventDelegate, WebView webView) {
        Intrinsics.checkNotNullParameter(str, "containerID");
        this.containerID = str;
        this.timestamp = j;
        this.jsEventDelegate = jsEventDelegate;
        this.webView = webView;
    }

    public final String getContainerID() {
        return this.containerID;
    }

    public final XBridgeMethod.JsEventDelegate getJsEventDelegate() {
        return this.jsEventDelegate;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final WebView getWebView() {
        return this.webView;
    }

    public final IDLXBridgeMethod.JSEventDelegate getIdlJsEventDelegate() {
        return this.idlJsEventDelegate;
    }

    public final void setIdlJsEventDelegate(IDLXBridgeMethod.JSEventDelegate jSEventDelegate) {
        this.idlJsEventDelegate = jSEventDelegate;
    }

    public boolean equals(Object other) {
        if (other == null || !(other instanceof Subscriber)) {
            return false;
        }
        Subscriber subscriber = (Subscriber) other;
        if (Intrinsics.areEqual(this.containerID, subscriber.containerID)) {
            if (this.containerID.length() > 0) {
                return true;
            }
        }
        return Intrinsics.areEqual(this.containerID, subscriber.containerID) && Intrinsics.areEqual(this.webView, subscriber.webView) && this.webView != null;
    }

    public int hashCode() {
        return this.containerID.hashCode();
    }
}
