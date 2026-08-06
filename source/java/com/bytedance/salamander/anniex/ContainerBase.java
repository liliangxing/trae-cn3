package com.bytedance.salamander.anniex;

import com.bytedance.ies.bullet.service.monitor.MetricConstant;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.bytedance.ug.sdk.deeplink.CommonConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnniexMonitorEventTypingsBaseContainerBase.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\f\"\u0004\b)\u0010\u000eR\u001c\u0010*\u001a\u0004\u0018\u00010\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\f\"\u0004\b,\u0010\u000eR\u001a\u0010-\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\f\"\u0004\b/\u0010\u000eR\u001a\u00100\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\f\"\u0004\b2\u0010\u000eR\u001a\u00103\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\f\"\u0004\b5\u0010\u000eR\u001c\u00106\u001a\u0004\u0018\u00010\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\f\"\u0004\b8\u0010\u000eR\u001a\u00109\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\f\"\u0004\b;\u0010\u000eR\u001a\u0010<\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\f\"\u0004\b>\u0010\u000eR\u001a\u0010?\u001a\u00020@X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001c\u0010E\u001a\u0004\u0018\u00010\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\f\"\u0004\bG\u0010\u000eR\u001a\u0010H\u001a\u00020IX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u001c\u0010N\u001a\u0004\u0018\u00010\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\f\"\u0004\bP\u0010\u000eR\u001c\u0010Q\u001a\u0004\u0018\u00010RX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010T\"\u0004\bU\u0010V¨\u0006W"}, d2 = {"Lcom/bytedance/salamander/anniex/ContainerBase;", "", "()V", "__internal", "Lcom/bytedance/salamander/anniex/Internal;", "get__internal", "()Lcom/bytedance/salamander/anniex/Internal;", "set__internal", "(Lcom/bytedance/salamander/anniex/Internal;)V", "bid", "", "getBid", "()Ljava/lang/String;", "setBid", "(Ljava/lang/String;)V", "bid_source", "Lcom/bytedance/salamander/anniex/BidSource;", "getBid_source", "()Lcom/bytedance/salamander/anniex/BidSource;", "setBid_source", "(Lcom/bytedance/salamander/anniex/BidSource;)V", MetricConstant.CONTAINER_NAME, "Lcom/bytedance/salamander/anniex/ContainerName;", "getContainer_name", "()Lcom/bytedance/salamander/anniex/ContainerName;", "setContainer_name", "(Lcom/bytedance/salamander/anniex/ContainerName;)V", "container_reuse", "", "getContainer_reuse", "()Z", "setContainer_reuse", "(Z)V", "container_type", "Lcom/bytedance/salamander/anniex/ContainerType;", "getContainer_type", "()Lcom/bytedance/salamander/anniex/ContainerType;", "setContainer_type", "(Lcom/bytedance/salamander/anniex/ContainerType;)V", "gecko_id", "getGecko_id", "setGecko_id", "lynx_version", "getLynx_version", "setLynx_version", "monitor_metric_version", "getMonitor_metric_version", "setMonitor_metric_version", "native_page", "getNative_page", "setNative_page", "navigation_id", "getNavigation_id", "setNavigation_id", LynxMonitorService.KEY_PID, "getPid", "setPid", "schema", "getSchema", "setSchema", CommonConstants.SDK_VERSION, "getSdk_version", "setSdk_version", "template_res_type", "Lcom/bytedance/salamander/anniex/TemplateResType;", "getTemplate_res_type", "()Lcom/bytedance/salamander/anniex/TemplateResType;", "setTemplate_res_type", "(Lcom/bytedance/salamander/anniex/TemplateResType;)V", "url", "getUrl", "setUrl", "view_type", "Lcom/bytedance/salamander/anniex/ViewType;", "getView_type", "()Lcom/bytedance/salamander/anniex/ViewType;", "setView_type", "(Lcom/bytedance/salamander/anniex/ViewType;)V", "web_engine_version", "getWeb_engine_version", "setWeb_engine_version", "webview_type", "Lcom/bytedance/salamander/anniex/WebviewType;", "getWebview_type", "()Lcom/bytedance/salamander/anniex/WebviewType;", "setWebview_type", "(Lcom/bytedance/salamander/anniex/WebviewType;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ContainerBase {
    private boolean container_reuse;
    private String gecko_id;
    private String lynx_version;
    private String pid;
    private String url;
    private String web_engine_version;
    private WebviewType webview_type;
    private String monitor_metric_version = "3.0";
    private ContainerName container_name = ContainerName.AnnieX;
    private String schema = "";
    private TemplateResType template_res_type = TemplateResType.Unknown;
    private ViewType view_type = ViewType.Card;
    private String navigation_id = "";
    private ContainerType container_type = ContainerType.Lynx;
    private String sdk_version = "1.0.0";
    private String native_page = "";
    private String bid = AnniexMonitorEventTypingsBaseContainerBaseKt.getMonitorDefaultBid();
    private BidSource bid_source = BidSource.Default;
    private Internal __internal = new Internal();

    public String getMonitor_metric_version() {
        return this.monitor_metric_version;
    }

    public void setMonitor_metric_version(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.monitor_metric_version = str;
    }

    public ContainerName getContainer_name() {
        return this.container_name;
    }

    public void setContainer_name(ContainerName containerName) {
        Intrinsics.checkNotNullParameter(containerName, "<set-?>");
        this.container_name = containerName;
    }

    public String getSchema() {
        return this.schema;
    }

    public void setSchema(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.schema = str;
    }

    public TemplateResType getTemplate_res_type() {
        return this.template_res_type;
    }

    public void setTemplate_res_type(TemplateResType templateResType) {
        Intrinsics.checkNotNullParameter(templateResType, "<set-?>");
        this.template_res_type = templateResType;
    }

    public ViewType getView_type() {
        return this.view_type;
    }

    public void setView_type(ViewType viewType) {
        Intrinsics.checkNotNullParameter(viewType, "<set-?>");
        this.view_type = viewType;
    }

    public String getNavigation_id() {
        return this.navigation_id;
    }

    public void setNavigation_id(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.navigation_id = str;
    }

    public String getGecko_id() {
        return this.gecko_id;
    }

    public void setGecko_id(String str) {
        this.gecko_id = str;
    }

    public ContainerType getContainer_type() {
        return this.container_type;
    }

    public void setContainer_type(ContainerType containerType) {
        Intrinsics.checkNotNullParameter(containerType, "<set-?>");
        this.container_type = containerType;
    }

    public boolean getContainer_reuse() {
        return this.container_reuse;
    }

    public void setContainer_reuse(boolean z) {
        this.container_reuse = z;
    }

    public String getSdk_version() {
        return this.sdk_version;
    }

    public void setSdk_version(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sdk_version = str;
    }

    public String getNative_page() {
        return this.native_page;
    }

    public void setNative_page(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.native_page = str;
    }

    public String getLynx_version() {
        return this.lynx_version;
    }

    public void setLynx_version(String str) {
        this.lynx_version = str;
    }

    public WebviewType getWebview_type() {
        return this.webview_type;
    }

    public void setWebview_type(WebviewType webviewType) {
        this.webview_type = webviewType;
    }

    public String getWeb_engine_version() {
        return this.web_engine_version;
    }

    public void setWeb_engine_version(String str) {
        this.web_engine_version = str;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String getBid() {
        return this.bid;
    }

    public void setBid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.bid = str;
    }

    public BidSource getBid_source() {
        return this.bid_source;
    }

    public void setBid_source(BidSource bidSource) {
        Intrinsics.checkNotNullParameter(bidSource, "<set-?>");
        this.bid_source = bidSource;
    }

    public String getPid() {
        return this.pid;
    }

    public void setPid(String str) {
        this.pid = str;
    }

    public Internal get__internal() {
        return this.__internal;
    }

    public void set__internal(Internal internal) {
        Intrinsics.checkNotNullParameter(internal, "<set-?>");
        this.__internal = internal;
    }
}
