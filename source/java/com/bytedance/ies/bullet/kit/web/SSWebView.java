package com.bytedance.ies.bullet.kit.web;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bytedance.android.anniex.base.monitor.IMonitorCenter;
import com.bytedance.android.anniex.base.monitor.MonitorCenter;
import com.bytedance.android.anniex.monitor.MonitorManager;
import com.bytedance.android.monitorV2.webview.WebViewMonitorHelper;
import com.bytedance.ies.argus.api.ArgusWebDelegate;
import com.bytedance.ies.argus.api.params.ArgusMotionEventParams;
import com.bytedance.ies.argus.api.params.IFePageInfo;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.core.container.IActionModeProvider;
import com.bytedance.ies.bullet.kit.web.SSWebView;
import com.bytedance.ies.bullet.secure.ArgusWebDelegateAdapter;
import com.bytedance.ies.bullet.service.base.YieldError;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.bullet.web.pia.PiaLifeCycle;
import com.bytedance.ies.bullet.web.scc.SccDelegate;
import com.bytedance.ies.web.jsbridge2.ISafeWebView;
import com.bytedance.perf.monitor.ReportConst;
import com.bytedance.push.interfaze.ISignalReportService;
import com.bytedance.sdk.xbridge.cn.protocol.auth.AuthUrlSourceType;
import com.bytedance.sdk.xbridge.cn.protocol.auth.ISafeAuthWebView;
import com.bytedance.webx.core.webview.WebViewContainer;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: SSWebView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ø\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010$\n\u0002\b\u0018\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 ´\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\f³\u0001´\u0001µ\u0001¶\u0001·\u0001¸\u0001B%\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020BH\u0002J\u000e\u0010C\u001a\u00020@2\u0006\u0010;\u001a\u00020!J\b\u0010D\u001a\u00020\u0018H\u0016J\u0010\u0010E\u001a\u00020\u00182\u0006\u0010F\u001a\u00020\tH\u0016J\b\u0010G\u001a\u00020\u0018H\u0016J\u0010\u0010H\u001a\u00020\u00182\u0006\u0010I\u001a\u00020\tH\u0016J\u0010\u0010J\u001a\u00020@2\u0006\u0010K\u001a\u00020\u0018H\u0016J\b\u0010L\u001a\u00020@H\u0016J\b\u0010M\u001a\u00020@H\u0016J\b\u0010N\u001a\u00020@H\u0016J\b\u0010O\u001a\u00020@H\u0016J\u000e\u0010\u0019\u001a\u00020@2\u0006\u0010\u0019\u001a\u00020\u0018J\u0010\u0010P\u001a\u00020@2\u0006\u0010Q\u001a\u00020RH\u0002J\u000e\u0010\u001a\u001a\u00020@2\u0006\u0010S\u001a\u00020\u0018J \u0010T\u001a\u00020@2\u0006\u0010U\u001a\u00020!2\u000e\u0010V\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010WH\u0016J\b\u0010X\u001a\u00020\u0016H\u0016J\b\u0010Y\u001a\u00020\tH\u0016J\u0006\u0010Z\u001a\u00020\u001fJ\n\u0010[\u001a\u0004\u0018\u00010!H\u0016J\b\u0010\\\u001a\u00020\tH\u0016J\n\u0010]\u001a\u0004\u0018\u00010!H\u0016J\b\u0010^\u001a\u0004\u0018\u00010\u000eJ\b\u0010_\u001a\u0004\u0018\u00010!J\u0006\u0010`\u001a\u00020\tJ\n\u0010a\u001a\u0004\u0018\u00010!H\u0016J\n\u0010b\u001a\u0004\u0018\u00010!H\u0016J\b\u0010c\u001a\u00020@H\u0016J\u0010\u0010d\u001a\u00020@2\u0006\u0010F\u001a\u00020\tH\u0016J\b\u0010e\u001a\u00020@H\u0016J\u0006\u0010f\u001a\u00020\u0018J\u0006\u0010g\u001a\u00020\u0018J\b\u0010h\u001a\u00020\u0018H\u0016J\u0006\u0010i\u001a\u00020\u0018J$\u0010j\u001a\u00020@2\u0006\u0010k\u001a\u00020!2\b\u0010l\u001a\u0004\u0018\u00010!2\b\u0010m\u001a\u0004\u0018\u00010!H\u0016J8\u0010n\u001a\u00020@2\b\u0010o\u001a\u0004\u0018\u00010!2\u0006\u0010k\u001a\u00020!2\b\u0010l\u001a\u0004\u0018\u00010!2\b\u0010m\u001a\u0004\u0018\u00010!2\b\u0010p\u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010 \u001a\u00020@2\u0006\u0010q\u001a\u00020!H\u0016J$\u0010 \u001a\u00020@2\u0006\u0010q\u001a\u00020!2\u0012\u0010r\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020!0sH\u0017J\b\u0010t\u001a\u00020@H\u0014J(\u0010u\u001a\u00020@2\u0006\u0010v\u001a\u00020\t2\u0006\u0010w\u001a\u00020\t2\u0006\u0010x\u001a\u00020\u00182\u0006\u0010y\u001a\u00020\u0018H\u0014J\b\u0010z\u001a\u00020@H\u0016J\b\u0010{\u001a\u00020@H\u0016J)\u0010|\u001a\u00020@2\u0006\u0010}\u001a\u00020\t2\u0006\u0010~\u001a\u00020\t2\u0006\u0010\u007f\u001a\u00020\t2\u0007\u0010\u0080\u0001\u001a\u00020\tH\u0014J\u0011\u0010\u0081\u0001\u001a\u00020\u00182\u0006\u0010Q\u001a\u00020RH\u0017JX\u0010\u0082\u0001\u001a\u00020\u00182\u0007\u0010\u0083\u0001\u001a\u00020\t2\u0007\u0010\u0084\u0001\u001a\u00020\t2\u0006\u0010v\u001a\u00020\t2\u0006\u0010w\u001a\u00020\t2\u0007\u0010\u0085\u0001\u001a\u00020\t2\u0007\u0010\u0086\u0001\u001a\u00020\t2\u0007\u0010\u0087\u0001\u001a\u00020\t2\u0007\u0010\u0088\u0001\u001a\u00020\t2\u0007\u0010\u0089\u0001\u001a\u00020\u0018H\u0014J\u001b\u0010\u008a\u0001\u001a\u00020@2\u0006\u0010q\u001a\u00020!2\b\u0010\u008b\u0001\u001a\u00030\u008c\u0001H\u0016J\t\u0010\u008d\u0001\u001a\u00020@H\u0016J\u0012\u0010\u008e\u0001\u001a\u00020@2\u0007\u0010\u008f\u0001\u001a\u00020\tH\u0016J\u000f\u0010\u0090\u0001\u001a\u00020@2\u0006\u0010\u0017\u001a\u00020\u0018J\u0015\u0010\u0091\u0001\u001a\u00020@2\n\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0093\u0001H\u0016J\u0018\u0010\u0094\u0001\u001a\u00020@2\t\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u0018¢\u0006\u0003\u0010\u0096\u0001J\u0012\u0010\u0097\u0001\u001a\u00020@2\u0007\u0010\u0098\u0001\u001a\u00020\u0018H\u0016J\u0012\u0010\u0099\u0001\u001a\u00020@2\u0007\u0010\u009a\u0001\u001a\u00020\tH\u0016J\u0011\u0010\u009b\u0001\u001a\u00020@2\b\u0010q\u001a\u0004\u0018\u00010!J\u0011\u0010\u009c\u0001\u001a\u00020@2\b\u0010q\u001a\u0004\u0018\u00010!J\u0017\u0010\u009d\u0001\u001a\u00020@2\u0006\u0010&\u001a\u00020'H\u0000¢\u0006\u0003\b\u009e\u0001J\u0017\u0010\u009f\u0001\u001a\u00020@2\u0006\u0010(\u001a\u00020)H\u0000¢\u0006\u0003\b \u0001J\u000f\u0010¡\u0001\u001a\u00020@2\u0006\u0010>\u001a\u00020\tJ\u0015\u0010¢\u0001\u001a\u00020@2\n\u0010£\u0001\u001a\u0005\u0018\u00010¤\u0001H\u0016J\u0012\u0010¥\u0001\u001a\u00020@2\t\u0010\u0092\u0001\u001a\u0004\u0018\u00010#J\u0012\u0010¦\u0001\u001a\u00020@2\t\u0010\u0092\u0001\u001a\u0004\u0018\u00010-J\u0013\u0010§\u0001\u001a\u00020@2\b\u0010£\u0001\u001a\u00030¨\u0001H\u0016J\u0010\u0010©\u0001\u001a\u00020@2\u0007\u0010ª\u0001\u001a\u00020\u001dJ\u0010\u0010«\u0001\u001a\u00020@2\u0007\u0010ª\u0001\u001a\u00020+J\u0010\u0010<\u001a\u00020@2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0018\u0010<\u001a\u00020@2\u0006\u0010<\u001a\u00020\u00182\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0015\u0010¬\u0001\u001a\u00020B2\n\u0010\u00ad\u0001\u001a\u0005\u0018\u00010®\u0001H\u0016J \u0010¬\u0001\u001a\u0004\u0018\u00010B2\n\u0010\u00ad\u0001\u001a\u0005\u0018\u00010®\u00012\u0007\u0010¯\u0001\u001a\u00020\tH\u0016J\t\u0010°\u0001\u001a\u00020@H\u0016J\u0011\u0010±\u0001\u001a\u00020!2\u0006\u0010q\u001a\u00020!H\u0002J>\u0010±\u0001\u001a\u001b\u0012\u0004\u0012\u00020!\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020!0s0²\u00012\u0006\u0010q\u001a\u00020!2\u0012\u0010r\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020!0sH\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010.\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001c\u00106\u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u000e\u0010;\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006¹\u0001"}, d2 = {"Lcom/bytedance/ies/bullet/kit/web/SSWebView;", "Lcom/bytedance/webx/core/webview/WebViewContainer;", "Lcom/bytedance/ies/web/jsbridge2/ISafeWebView;", "Lcom/bytedance/sdk/xbridge/cn/protocol/auth/ISafeAuthWebView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "actionModeHelper", "Lcom/bytedance/ies/bullet/kit/web/SSWebView$ActionModeHelper;", "actionModeProvider", "Lcom/bytedance/ies/bullet/core/container/IActionModeProvider;", "argusAdapter", "Lcom/bytedance/ies/bullet/secure/ArgusWebDelegateAdapter;", "getArgusAdapter$anniex_release", "()Lcom/bytedance/ies/bullet/secure/ArgusWebDelegateAdapter;", "setArgusAdapter$anniex_release", "(Lcom/bytedance/ies/bullet/secure/ArgusWebDelegateAdapter;)V", "authUrlSource", "Lcom/bytedance/sdk/xbridge/cn/protocol/auth/AuthUrlSourceType;", "canTouch", "", "disableShowSelectMenus", "enableNewCustomSelectMenu", "enableSafeWebJSBAuth", "eventDelegate", "Lcom/bytedance/ies/bullet/kit/web/SSWebView$WebViewEventDelegate;", "lastClickTime", "", "loadUrl", "", "overScrollByListener", "Lcom/bytedance/ies/bullet/kit/web/SSWebView$WebOverScrollByListener;", "pageCommitVisibleUrl", "pageStartUrl", "piaLifeCycle", "Lcom/bytedance/ies/bullet/web/pia/PiaLifeCycle;", "sccDelegate", "Lcom/bytedance/ies/bullet/web/scc/SccDelegate;", "scrollDelegate", "Lcom/bytedance/ies/bullet/kit/web/SSWebView$WebViewScrollDelegate;", "scrollListener", "Lcom/bytedance/ies/bullet/kit/web/SSWebView$WebScrollListener;", "secureDelegate", "Lcom/bytedance/ies/bullet/kit/web/IWebSecureDelegate;", "getSecureDelegate$annotations", "()V", "getSecureDelegate", "()Lcom/bytedance/ies/bullet/kit/web/IWebSecureDelegate;", "setSecureDelegate", "(Lcom/bytedance/ies/bullet/kit/web/IWebSecureDelegate;)V", "secureLinkScene", "getSecureLinkScene", "()Ljava/lang/String;", "setSecureLinkScene", "(Ljava/lang/String;)V", "sessionId", "showSearchMode", "startClickTime", "timeInterval", "addActionModeOld", "", "actionMode", "Landroid/view/ActionMode;", "attachSessionId", "canGoBack", "canGoBackOrForward", "steps", "canGoForward", "canScrollVertically", "direction", "clearCache", "includeDiskFiles", "clearFormData", "clearHistory", "computeScroll", "destroy", "dispatchTouchEventToSecure", ISignalReportService.BODY_KEY_EVENT, "Landroid/view/MotionEvent;", "enableCustomSelectMenu", "evaluateJavascript", "script", "resultCallback", "Landroid/webkit/ValueCallback;", "getAuthUrlSourceType", "getContentHeight", "getLastClickTime", "getOriginalUrl", "getProgress", "getSafeUrl", "getSearchMode", "getSecLinkScene", "getTimeInterval", "getUrl", "getXSafeUrl", "goBack", "goBackOrForward", "goForward", "hasClickInTimeInterval", "isCanTouch", "isEnableSafeAuth", "isGoBack", "loadData", "data", "mimeType", "encoding", "loadDataWithBaseURL", "baseUrl", "historyUrl", "url", "additionalHttpHeaders", "", "onAttachedToWindow", "onOverScrolled", "scrollX", "scrollY", "clampedX", "clampedY", "onPause", "onResume", "onScrollChanged", "l", "t", "oldl", "oldt", "onTouchEvent", "overScrollBy", "deltaX", "deltaY", "scrollRangeX", "scrollRangeY", "maxOverScrollX", "maxOverScrollY", "isTouchEvent", "postUrl", "postData", "", "reload", "setBackgroundColor", "color", "setCanTouch", "setDownloadListener", "listener", "Landroid/webkit/DownloadListener;", "setEnableSafeWebJSBAuth", "enable", "(Ljava/lang/Boolean;)V", "setNetworkAvailable", "networkUp", "setOverScrollMode", "mode", "setPageCommitVisibleUrl", "setPageStartUrl", "setPiaLifeCycle", "setPiaLifeCycle$anniex_release", "setSccDelegate", "setSccDelegate$anniex_release", "setTimeInterval", "setWebChromeClient", "client", "Landroid/webkit/WebChromeClient;", "setWebOverScrollByListener", "setWebScrollListener", "setWebViewClient", "Landroid/webkit/WebViewClient;", "setWebViewEventDelegate", "delegate", "setWebViewScrollDelegate", "startActionMode", "callback", "Landroid/view/ActionMode$Callback;", "type", "stopLoading", "verifyLoadUrl", "Lkotlin/Pair;", "ActionModeHelper", "Companion", "WebOverScrollByListener", "WebScrollListener", "WebViewEventDelegate", "WebViewScrollDelegate", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class SSWebView extends WebViewContainer implements ISafeWebView, ISafeAuthWebView {
    private static final int MAX_CLICK_DURATION = 100;
    private static final String TAG = "SSWebView";
    private static final int TIME_INTERVAL = 500;
    private final ActionModeHelper actionModeHelper;
    private IActionModeProvider actionModeProvider;
    private ArgusWebDelegateAdapter argusAdapter;
    private AuthUrlSourceType authUrlSource;
    private boolean canTouch;
    private boolean disableShowSelectMenus;
    private boolean enableNewCustomSelectMenu;
    private boolean enableSafeWebJSBAuth;
    private WebViewEventDelegate eventDelegate;
    private long lastClickTime;
    private String loadUrl;
    private WebOverScrollByListener overScrollByListener;
    private String pageCommitVisibleUrl;
    private String pageStartUrl;
    private PiaLifeCycle piaLifeCycle;
    private SccDelegate sccDelegate;
    private WebViewScrollDelegate scrollDelegate;
    private WebScrollListener scrollListener;
    private IWebSecureDelegate secureDelegate;
    private String secureLinkScene;
    private String sessionId;
    private boolean showSearchMode;
    private long startClickTime;
    private int timeInterval;

    /* compiled from: SSWebView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001JP\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH&¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ies/bullet/kit/web/SSWebView$WebOverScrollByListener;", "", "overScrollBy", "", "deltaX", "", "deltaY", "scrollX", "scrollY", "scrollRangeX", "scrollRangeY", "maxOverScrollX", "maxOverScrollY", "isTouchEvent", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface WebOverScrollByListener {
        void overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX, int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent);
    }

    /* compiled from: SSWebView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H&¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/bullet/kit/web/SSWebView$WebScrollListener;", "", "onScrollChanged", "", "l", "", "t", "oldl", "oldt", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface WebScrollListener {
        void onScrollChanged(int l, int t, int oldl, int oldt);
    }

    /* compiled from: SSWebView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/ies/bullet/kit/web/SSWebView$WebViewScrollDelegate;", "", "onOverScrolled", "", "scrollX", "", "scrollY", "clampedX", "", "clampedY", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface WebViewScrollDelegate {

        /* compiled from: SSWebView.kt */
        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
        public static final class DefaultImpls {
            public static void onOverScrolled(WebViewScrollDelegate webViewScrollDelegate, int i, int i2, boolean z, boolean z2) {
            }
        }

        void onOverScrolled(int scrollX, int scrollY, boolean clampedX, boolean clampedY);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SSWebView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SSWebView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Deprecated(message = "废弃，内部收敛统一到internal argusAdapter避免外部随意修改，请不要主动调用")
    public static /* synthetic */ void getSecureDelegate$annotations() {
    }

    public /* synthetic */ SSWebView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SSWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.timeInterval = TIME_INTERVAL;
        this.canTouch = true;
        this.sessionId = "";
        this.actionModeHelper = new ActionModeHelper();
        this.authUrlSource = AuthUrlSourceType.Unset;
    }

    public final IWebSecureDelegate getSecureDelegate() {
        return this.secureDelegate;
    }

    public final void setSecureDelegate(IWebSecureDelegate iWebSecureDelegate) {
        this.secureDelegate = iWebSecureDelegate;
    }

    public final String getSecureLinkScene() {
        return this.secureLinkScene;
    }

    public final void setSecureLinkScene(String str) {
        this.secureLinkScene = str;
    }

    /* renamed from: getArgusAdapter$anniex_release, reason: from getter */
    public final ArgusWebDelegateAdapter getArgusAdapter() {
        return this.argusAdapter;
    }

    public final void setArgusAdapter$anniex_release(ArgusWebDelegateAdapter argusWebDelegateAdapter) {
        this.argusAdapter = argusWebDelegateAdapter;
    }

    public void onResume() {
        try {
            super.onResume();
        } catch (Exception unused) {
        }
    }

    public void onPause() {
        try {
            super.onPause();
        } catch (Exception unused) {
        }
    }

    /* renamed from: isEnableSafeAuth, reason: from getter */
    public boolean getEnableSafeWebJSBAuth() {
        return this.enableSafeWebJSBAuth;
    }

    @Override // com.bytedance.ies.web.jsbridge2.ISafeWebView
    public String getSafeUrl() {
        if (getEnableSafeWebJSBAuth()) {
            return getXSafeUrl();
        }
        this.authUrlSource = AuthUrlSourceType.DisableSafeAuthInXBridge2;
        return this.pageStartUrl;
    }

    public String getXSafeUrl() {
        String str;
        if (!TextUtils.isEmpty(this.pageCommitVisibleUrl)) {
            this.authUrlSource = AuthUrlSourceType.PageCommitVisibleUrl;
            str = this.pageCommitVisibleUrl;
        } else if (!TextUtils.isEmpty(this.pageStartUrl)) {
            this.authUrlSource = AuthUrlSourceType.PageStartedUrl;
            str = this.pageStartUrl;
        } else if (!TextUtils.isEmpty(getUrl())) {
            this.authUrlSource = AuthUrlSourceType.WebViewUrl;
            str = getUrl();
        } else {
            this.authUrlSource = AuthUrlSourceType.AbnormalUrl;
            str = null;
        }
        HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "GetXSafeUrl: return " + str + ", type is " + this.authUrlSource, null, null, 12, null);
        return str;
    }

    /* renamed from: getAuthUrlSourceType, reason: from getter */
    public AuthUrlSourceType getAuthUrlSource() {
        return this.authUrlSource;
    }

    public final void setEnableSafeWebJSBAuth(Boolean enable) {
        this.enableSafeWebJSBAuth = enable != null ? enable.booleanValue() : false;
    }

    public final void setPageCommitVisibleUrl(String url) {
        this.pageCommitVisibleUrl = url;
    }

    public final void setPageStartUrl(String url) {
        this.pageStartUrl = url;
    }

    public void setOverScrollMode(int mode) {
        try {
            super.setOverScrollMode(mode);
        } catch (Throwable unused) {
        }
    }

    public void setNetworkAvailable(boolean networkUp) {
        try {
            super.setNetworkAvailable(networkUp);
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void loadUrl(String url, Map<String, String> additionalHttpHeaders) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(additionalHttpHeaders, "additionalHttpHeaders");
        try {
            WebViewMonitorHelper.getInstance().onLoadUrl((WebView) this, url);
            PiaLifeCycle piaLifeCycle = this.piaLifeCycle;
            if (piaLifeCycle != null) {
                piaLifeCycle.loadUrl(url);
            }
            SccDelegate sccDelegate = this.sccDelegate;
            if (sccDelegate != null) {
                sccDelegate.doCheck(url);
            }
            this.loadUrl = url;
            Pair<String, Map<String, String>> verifyLoadUrl = verifyLoadUrl(url, additionalHttpHeaders);
            super.loadUrl((String) verifyLoadUrl.component1(), (Map) verifyLoadUrl.component2());
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void loadUrl(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        try {
            WebViewMonitorHelper.getInstance().onLoadUrl((WebView) this, url);
            PiaLifeCycle piaLifeCycle = this.piaLifeCycle;
            if (piaLifeCycle != null) {
                piaLifeCycle.loadUrl(url);
            }
            SccDelegate sccDelegate = this.sccDelegate;
            if (sccDelegate != null) {
                sccDelegate.doCheck(url);
            }
            this.loadUrl = url;
            super.loadUrl(verifyLoadUrl(url));
        } catch (Exception unused) {
        }
    }

    public void postUrl(String url, byte[] postData) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(postData, "postData");
        try {
            super.postUrl(verifyLoadUrl(url), postData);
        } catch (Exception unused) {
        }
    }

    public void loadData(String data, String mimeType, String encoding) {
        Intrinsics.checkNotNullParameter(data, "data");
        try {
            super.loadData(data, mimeType, encoding);
        } catch (Exception unused) {
        }
    }

    public void evaluateJavascript(String script, ValueCallback<String> resultCallback) {
        Intrinsics.checkNotNullParameter(script, "script");
        super.evaluateJavascript(script, resultCallback);
        PiaLifeCycle piaLifeCycle = this.piaLifeCycle;
        if (piaLifeCycle != null) {
            piaLifeCycle.evaluateJavascript(script);
        }
    }

    public void loadDataWithBaseURL(String baseUrl, String data, String mimeType, String encoding, String historyUrl) {
        Intrinsics.checkNotNullParameter(data, "data");
        try {
            super.loadDataWithBaseURL(baseUrl, data, mimeType, encoding, historyUrl);
        } catch (Exception unused) {
        }
    }

    public ActionMode startActionMode(ActionMode.Callback callback) {
        this.actionModeHelper.onStartActionMode(this.enableNewCustomSelectMenu);
        ActionMode startActionMode = super.startActionMode(this.actionModeHelper.createCustomActionModeCallback(callback, this, this.actionModeProvider, this.disableShowSelectMenus, this.enableNewCustomSelectMenu));
        if (this.showSearchMode && !this.disableShowSelectMenus && !this.enableNewCustomSelectMenu) {
            Intrinsics.checkNotNullExpressionValue(startActionMode, "actionMode");
            addActionModeOld(startActionMode);
        }
        Intrinsics.checkNotNullExpressionValue(startActionMode, "actionMode");
        return startActionMode;
    }

    public ActionMode startActionMode(ActionMode.Callback callback, int type) {
        this.actionModeHelper.onStartActionMode(this.enableNewCustomSelectMenu);
        ActionMode startActionMode = super.startActionMode(this.actionModeHelper.createCustomActionModeCallback(callback, this, this.actionModeProvider, this.disableShowSelectMenus, this.enableNewCustomSelectMenu), type);
        if (this.showSearchMode && !this.disableShowSelectMenus && !this.enableNewCustomSelectMenu) {
            Intrinsics.checkNotNullExpressionValue(startActionMode, "actionMode");
            addActionModeOld(startActionMode);
        }
        return startActionMode;
    }

    private final void addActionModeOld(final ActionMode actionMode) {
        try {
            Result.Companion companion = Result.Companion;
            for (int size = actionMode.getMenu().size() - 1; -1 < size; size--) {
                CharSequence title = actionMode.getMenu().getItem(size).getTitle();
                boolean z = false;
                if (title != null) {
                    Intrinsics.checkNotNullExpressionValue(title, SchemaConstants.QUERY_KEY_TITLE);
                    if (StringsKt.contains$default(title, "搜索", false, 2, (Object) null)) {
                        z = true;
                    }
                }
                if (z) {
                    actionMode.getMenu().removeItem(actionMode.getMenu().getItem(size).getItemId());
                }
            }
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
        actionMode.getMenu().add("搜索").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() { // from class: com.bytedance.ies.bullet.kit.web.SSWebView$addActionModeOld$2
            @Override // android.view.MenuItem.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                Intrinsics.checkNotNullParameter(menuItem, "it");
                SSWebView sSWebView = SSWebView.this;
                final SSWebView sSWebView2 = SSWebView.this;
                final ActionMode actionMode2 = actionMode;
                sSWebView.evaluateJavascript("javascript:(function getSelectedText() {return window.getSelection().toString();})()", new ValueCallback() { // from class: com.bytedance.ies.bullet.kit.web.SSWebView$addActionModeOld$2.1
                    @Override // android.webkit.ValueCallback
                    public final void onReceiveValue(final String str) {
                        SSWebView sSWebView3 = SSWebView.this;
                        final ActionMode actionMode3 = actionMode2;
                        final SSWebView sSWebView4 = SSWebView.this;
                        sSWebView3.post(new Runnable() { // from class: com.bytedance.ies.bullet.kit.web.SSWebView.addActionModeOld.2.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                IActionModeProvider iActionModeProvider;
                                actionMode3.finish();
                                iActionModeProvider = sSWebView4.actionModeProvider;
                                if (iActionModeProvider != null) {
                                    String str2 = str;
                                    Intrinsics.checkNotNullExpressionValue(str2, "it");
                                    iActionModeProvider.callAction(1, StringsKt.replace$default(str2, "\"", "", false, 4, (Object) null));
                                }
                            }
                        });
                    }
                });
                return true;
            }
        });
    }

    public void stopLoading() {
        try {
            super.stopLoading();
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void reload() {
        String url;
        try {
            WebViewMonitorHelper.getInstance().reload((WebView) this);
            SccDelegate sccDelegate = this.sccDelegate;
            if (sccDelegate != null && (url = getUrl()) != null) {
                sccDelegate.doCheck(url);
            }
            super.reload();
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean canGoBack() {
        boolean z = false;
        try {
            ArgusWebDelegateAdapter argusWebDelegateAdapter = this.argusAdapter;
            if (argusWebDelegateAdapter != null) {
                if (argusWebDelegateAdapter.canGoBack((WebView) this) && super.canGoBack()) {
                    z = true;
                }
            } else {
                z = super.canGoBack();
            }
        } catch (Exception unused) {
        }
        return z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void goBack() {
        try {
            WebViewMonitorHelper.getInstance().goBack((WebView) this);
            ArgusWebDelegateAdapter argusWebDelegateAdapter = this.argusAdapter;
            if (argusWebDelegateAdapter == null || !argusWebDelegateAdapter.handleGoBack((WebView) this)) {
                super.goBack();
            }
        } catch (Exception unused) {
        }
    }

    public boolean canGoForward() {
        try {
            return super.canGoForward();
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onAttachedToWindow() {
        try {
            WebViewMonitorHelper.getInstance().onAttachedToWindow((WebView) this);
            MonitorManager.INSTANCE.onAttachToWindow(this.sessionId, getUrl());
            super.onAttachedToWindow();
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void destroy() {
        try {
            WebViewMonitorHelper.getInstance().destroy((WebView) this);
            this.actionModeProvider = null;
            this.actionModeHelper.destroy();
            PiaLifeCycle piaLifeCycle = this.piaLifeCycle;
            if (piaLifeCycle != null) {
                piaLifeCycle.destroy();
            }
            this.sccDelegate = null;
            this.secureDelegate = null;
            this.argusAdapter = null;
            super.destroy();
        } catch (Throwable unused) {
        }
    }

    public void goForward() {
        try {
            super.goForward();
        } catch (Exception unused) {
        }
    }

    public boolean canGoBackOrForward(int steps) {
        try {
            return super.canGoBackOrForward(steps);
        } catch (Exception unused) {
            return false;
        }
    }

    public void goBackOrForward(int steps) {
        try {
            super.goBackOrForward(steps);
        } catch (Exception unused) {
        }
    }

    public String getUrl() {
        try {
            return super.getUrl();
        } catch (Exception unused) {
            return null;
        }
    }

    public String getOriginalUrl() {
        try {
            return super.getOriginalUrl();
        } catch (Exception unused) {
            return null;
        }
    }

    public int getProgress() {
        try {
            return super.getProgress();
        } catch (Exception unused) {
            return 100;
        }
    }

    public int getContentHeight() {
        try {
            return super.getContentHeight();
        } catch (Exception unused) {
            return 1;
        }
    }

    public void clearCache(boolean includeDiskFiles) {
        try {
            super.clearCache(includeDiskFiles);
        } catch (Exception unused) {
        }
    }

    public void clearFormData() {
        try {
            super.clearFormData();
        } catch (Exception unused) {
        }
    }

    public void clearHistory() {
        try {
            super.clearHistory();
        } catch (Exception unused) {
        }
    }

    public void setWebViewClient(WebViewClient client) {
        Intrinsics.checkNotNullParameter(client, "client");
        try {
            super.setWebViewClient(client);
        } catch (Exception unused) {
        }
    }

    public void setDownloadListener(DownloadListener listener) {
        try {
            super.setDownloadListener(listener);
        } catch (Exception unused) {
        }
    }

    public void setWebChromeClient(WebChromeClient client) {
        try {
            super.setWebChromeClient(client);
        } catch (Exception unused) {
        }
    }

    public void setBackgroundColor(int color) {
        try {
            super.setBackgroundColor(color);
        } catch (Exception unused) {
        }
    }

    public void computeScroll() {
        try {
            super.computeScroll();
        } catch (Exception unused) {
        }
    }

    public final void setWebViewEventDelegate(WebViewEventDelegate delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.eventDelegate = delegate;
    }

    public boolean canScrollVertically(int direction) {
        WebViewEventDelegate webViewEventDelegate = this.eventDelegate;
        if (webViewEventDelegate != null) {
            try {
                return webViewEventDelegate.canScrollVertically(direction, super.canScrollVertically(direction));
            } catch (YieldError unused) {
            }
        }
        return super.canScrollVertically(direction);
    }

    private final void dispatchTouchEventToSecure(MotionEvent event) {
        ArgusWebDelegate innerDelegate;
        ArgusWebDelegateAdapter argusWebDelegateAdapter = this.argusAdapter;
        if (argusWebDelegateAdapter == null || (innerDelegate = argusWebDelegateAdapter.getInnerDelegate()) == null) {
            return;
        }
        innerDelegate.monitorOnMotionEvent(new ArgusMotionEventParams(event, (IFePageInfo) null, getUrl(), 2, (DefaultConstructorMarker) null));
    }

    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, ISignalReportService.BODY_KEY_EVENT);
        dispatchTouchEventToSecure(event);
        WebViewEventDelegate webViewEventDelegate = this.eventDelegate;
        if (webViewEventDelegate != null) {
            try {
                return webViewEventDelegate.onTouchEvent(event);
            } catch (YieldError unused) {
            }
        }
        if (!this.canTouch) {
            return false;
        }
        int action = event.getAction();
        if (action == 0) {
            this.startClickTime = System.currentTimeMillis();
            Log.i(TAG, "startClickTime" + this.startClickTime);
        } else if (action == 1) {
            long currentTimeMillis = System.currentTimeMillis() - this.startClickTime;
            Log.i(TAG, "clickDuration" + currentTimeMillis);
            if (currentTimeMillis < 100) {
                this.lastClickTime = System.currentTimeMillis();
                Log.i(TAG, "lastClickTime:" + this.lastClickTime + "TapTimeout():" + ViewConfiguration.getTapTimeout());
            }
        }
        try {
            return super.onTouchEvent(event);
        } catch (Throwable unused2) {
            return false;
        }
    }

    public final void setWebViewScrollDelegate(WebViewScrollDelegate delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.scrollDelegate = delegate;
    }

    protected void onOverScrolled(int scrollX, int scrollY, boolean clampedX, boolean clampedY) {
        WebViewScrollDelegate webViewScrollDelegate = this.scrollDelegate;
        if (webViewScrollDelegate != null) {
            try {
                webViewScrollDelegate.onOverScrolled(scrollX, scrollY, clampedX, clampedY);
            } catch (YieldError unused) {
            }
        }
        super.onOverScrolled(scrollX, scrollY, clampedX, clampedY);
    }

    public final void setWebScrollListener(WebScrollListener listener) {
        this.scrollListener = listener;
    }

    public final void setWebOverScrollByListener(WebOverScrollByListener listener) {
        this.overScrollByListener = listener;
    }

    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        WebScrollListener webScrollListener = this.scrollListener;
        if (webScrollListener != null) {
            webScrollListener.onScrollChanged(l, t, oldl, oldt);
        }
    }

    protected boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX, int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {
        WebOverScrollByListener webOverScrollByListener = this.overScrollByListener;
        if (webOverScrollByListener != null) {
            webOverScrollByListener.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX, scrollRangeY, maxOverScrollX, maxOverScrollY, isTouchEvent);
        }
        return super.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX, scrollRangeY, maxOverScrollX, maxOverScrollY, isTouchEvent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final String verifyLoadUrl(String url) {
        String verifyLoadUrl;
        ArgusWebDelegateAdapter argusWebDelegateAdapter = this.argusAdapter;
        return (argusWebDelegateAdapter == null || (verifyLoadUrl = argusWebDelegateAdapter.verifyLoadUrl((WebView) this, url)) == null) ? url : verifyLoadUrl;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Pair<String, Map<String, String>> verifyLoadUrl(String url, Map<String, String> additionalHttpHeaders) {
        Pair<String, Map<String, String>> verifyLoadUrl;
        ArgusWebDelegateAdapter argusWebDelegateAdapter = this.argusAdapter;
        return (argusWebDelegateAdapter == null || (verifyLoadUrl = argusWebDelegateAdapter.verifyLoadUrl((WebView) this, url, additionalHttpHeaders)) == null) ? new Pair<>(url, additionalHttpHeaders) : verifyLoadUrl;
    }

    /* renamed from: getSecLinkScene, reason: from getter */
    public final String getSecureLinkScene() {
        return this.secureLinkScene;
    }

    public final boolean hasClickInTimeInterval() {
        WebViewEventDelegate webViewEventDelegate = this.eventDelegate;
        if (webViewEventDelegate != null) {
            try {
                return webViewEventDelegate.hasClickInTimeInterval();
            } catch (YieldError unused) {
            }
        }
        long currentTimeMillis = System.currentTimeMillis() - this.lastClickTime;
        Log.i(TAG, "interval:" + currentTimeMillis);
        return currentTimeMillis < ((long) getTimeInterval());
    }

    public final long getLastClickTime() {
        return this.lastClickTime;
    }

    public final int getTimeInterval() {
        int i = this.timeInterval;
        return i > 0 ? i : TIME_INTERVAL;
    }

    public final void setTimeInterval(int timeInterval) {
        this.timeInterval = timeInterval;
    }

    /* renamed from: isCanTouch, reason: from getter */
    public final boolean getCanTouch() {
        return this.canTouch;
    }

    public final void setCanTouch(boolean canTouch) {
        this.canTouch = canTouch;
    }

    public final void setPiaLifeCycle$anniex_release(PiaLifeCycle piaLifeCycle) {
        Intrinsics.checkNotNullParameter(piaLifeCycle, "piaLifeCycle");
        this.piaLifeCycle = piaLifeCycle;
    }

    public final void setSccDelegate$anniex_release(SccDelegate sccDelegate) {
        Intrinsics.checkNotNullParameter(sccDelegate, "sccDelegate");
        this.sccDelegate = sccDelegate;
    }

    public final void showSearchMode(boolean showSearchMode, IActionModeProvider actionModeProvider) {
        this.showSearchMode = showSearchMode;
        this.actionModeProvider = actionModeProvider;
    }

    public final void attachSessionId(String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        this.sessionId = sessionId;
        this.actionModeHelper.setSessionId(sessionId);
    }

    public final void disableShowSelectMenus(boolean disableShowSelectMenus) {
        this.disableShowSelectMenus = disableShowSelectMenus;
    }

    public final void enableNewCustomSelectMenu(boolean enableCustomSelectMenu) {
        this.enableNewCustomSelectMenu = enableCustomSelectMenu;
    }

    public final void showSearchMode(IActionModeProvider actionModeProvider) {
        this.actionModeProvider = actionModeProvider;
    }

    /* renamed from: getSearchMode, reason: from getter */
    public final IActionModeProvider getActionModeProvider() {
        return this.actionModeProvider;
    }

    public final boolean isGoBack() {
        return copyBackForwardList().getCurrentIndex() >= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SSWebView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001:\u0001$B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J4\u0010\u0017\u001a\u0004\u0018\u00010\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u00142\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cJ\u0006\u0010\u001e\u001a\u00020\fJ&\u0010\u001f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00120!H\u0002J\b\u0010\"\u001a\u00020\u0014H\u0002J\u000e\u0010#\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001cR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006%"}, d2 = {"Lcom/bytedance/ies/bullet/kit/web/SSWebView$ActionModeHelper;", "", "()V", "mainHandler", "Landroid/os/Handler;", "sessionId", "", "getSessionId", "()Ljava/lang/String;", "setSessionId", "(Ljava/lang/String;)V", "addCustomSelectMenuItem", "", "webView", "Lcom/bytedance/ies/bullet/kit/web/SSWebView;", "actionMode", "Landroid/view/ActionMode;", "item", "Lcom/bytedance/ies/bullet/core/container/IActionModeProvider$CustomSelectMenuItem;", "createActionModeCallback", "Landroid/view/ActionMode$Callback;", "delegate", "Lcom/bytedance/ies/bullet/kit/web/SSWebView$ActionModeHelper$IActionModeCallbackDelegate;", "createCustomActionModeCallback", "origin", "provider", "Lcom/bytedance/ies/bullet/core/container/IActionModeProvider;", "disableShowSelectMenus", "", "enableNewCustomSelectMenu", "destroy", "handleCustomSelectMenu", "customSelectMenuItemList", "", "makeDisableSelectMenuActionModeCallback", "onStartActionMode", "IActionModeCallbackDelegate", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class ActionModeHelper {
        private String sessionId = "";
        private final Handler mainHandler = new Handler(Looper.getMainLooper());

        /* compiled from: SSWebView.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u001c\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH&J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J&\u0010\r\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H'J\u001c\u0010\u0012\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH&¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ies/bullet/kit/web/SSWebView$ActionModeHelper$IActionModeCallbackDelegate;", "", "onActionItemClicked", "", "mode", "Landroid/view/ActionMode;", "item", "Landroid/view/MenuItem;", "onCreateActionMode", "menu", "Landroid/view/Menu;", "onDestroyActionMode", "", "onGetContentRect", "view", "Landroid/view/View;", "outRect", "Landroid/graphics/Rect;", "onPrepareActionMode", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
        public interface IActionModeCallbackDelegate {
            boolean onActionItemClicked(ActionMode mode, MenuItem item);

            boolean onCreateActionMode(ActionMode mode, Menu menu);

            void onDestroyActionMode(ActionMode mode);

            boolean onGetContentRect(ActionMode mode, View view, Rect outRect);

            boolean onPrepareActionMode(ActionMode mode, Menu menu);
        }

        public final String getSessionId() {
            return this.sessionId;
        }

        public final void setSessionId(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.sessionId = str;
        }

        public final void onStartActionMode(boolean enableNewCustomSelectMenu) {
            if (enableNewCustomSelectMenu) {
                IMonitorCenter.DefaultImpls.onEvent$default(MonitorCenter.Companion.instance(), this.sessionId, MapsKt.mapOf(new Pair[]{TuplesKt.to(ReportConst.KEY_EVENT_TYPE, "event_type_press"), TuplesKt.to("event_source", "event_source_press_text_panel")}), (Map) null, 4, (Object) null);
            }
        }

        public final ActionMode.Callback createCustomActionModeCallback(final ActionMode.Callback origin, final SSWebView webView, final IActionModeProvider provider, boolean disableShowSelectMenus, final boolean enableNewCustomSelectMenu) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            if (disableShowSelectMenus) {
                return makeDisableSelectMenuActionModeCallback();
            }
            if (origin == null) {
                return null;
            }
            return createActionModeCallback(new IActionModeCallbackDelegate() { // from class: com.bytedance.ies.bullet.kit.web.SSWebView$ActionModeHelper$createCustomActionModeCallback$1
                @Override // com.bytedance.ies.bullet.kit.web.SSWebView.ActionModeHelper.IActionModeCallbackDelegate
                public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                    return origin.onCreateActionMode(mode, menu);
                }

                @Override // com.bytedance.ies.bullet.kit.web.SSWebView.ActionModeHelper.IActionModeCallbackDelegate
                public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                    boolean onPrepareActionMode = origin.onPrepareActionMode(mode, menu);
                    if (enableNewCustomSelectMenu && menu != null) {
                        IActionModeProvider iActionModeProvider = provider;
                        List<IActionModeProvider.CustomSelectMenuItem> provideSelectMenuItemList = iActionModeProvider != null ? iActionModeProvider.provideSelectMenuItemList(menu) : null;
                        List<IActionModeProvider.CustomSelectMenuItem> list = provideSelectMenuItemList;
                        if (!(list == null || list.isEmpty()) && mode != null) {
                            this.handleCustomSelectMenu(webView, mode, provideSelectMenuItemList);
                        }
                    }
                    return onPrepareActionMode;
                }

                @Override // com.bytedance.ies.bullet.kit.web.SSWebView.ActionModeHelper.IActionModeCallbackDelegate
                public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                    return origin.onActionItemClicked(mode, item);
                }

                @Override // com.bytedance.ies.bullet.kit.web.SSWebView.ActionModeHelper.IActionModeCallbackDelegate
                public void onDestroyActionMode(ActionMode mode) {
                    origin.onDestroyActionMode(mode);
                }

                @Override // com.bytedance.ies.bullet.kit.web.SSWebView.ActionModeHelper.IActionModeCallbackDelegate
                public boolean onGetContentRect(ActionMode mode, View view, Rect outRect) {
                    ActionMode.Callback callback = origin;
                    if (!(callback instanceof ActionMode.Callback2)) {
                        return false;
                    }
                    ((ActionMode.Callback2) callback).onGetContentRect(mode, view, outRect);
                    return true;
                }
            });
        }

        private final ActionMode.Callback makeDisableSelectMenuActionModeCallback() {
            return new ActionMode.Callback() { // from class: com.bytedance.ies.bullet.kit.web.SSWebView$ActionModeHelper$makeDisableSelectMenuActionModeCallback$1
                @Override // android.view.ActionMode.Callback
                public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                    return false;
                }

                @Override // android.view.ActionMode.Callback
                public void onDestroyActionMode(ActionMode mode) {
                }

                @Override // android.view.ActionMode.Callback
                public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                    return false;
                }

                @Override // android.view.ActionMode.Callback
                public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                    if (mode == null) {
                        return true;
                    }
                    mode.setTitle((CharSequence) null);
                    mode.setSubtitle((CharSequence) null);
                    mode.getMenu().clear();
                    return true;
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void handleCustomSelectMenu(SSWebView webView, ActionMode actionMode, List<IActionModeProvider.CustomSelectMenuItem> customSelectMenuItemList) {
            IMonitorCenter.DefaultImpls.onEvent$default(MonitorCenter.Companion.instance(), this.sessionId, MapsKt.mapOf(new Pair[]{TuplesKt.to(ReportConst.KEY_EVENT_TYPE, "event_type_ui"), TuplesKt.to("event_source", "event_source_press_text_panel")}), (Map) null, 4, (Object) null);
            Menu menu = actionMode.getMenu();
            if (menu != null) {
                menu.clear();
            }
            Iterator<T> it = customSelectMenuItemList.iterator();
            while (it.hasNext()) {
                addCustomSelectMenuItem(webView, actionMode, (IActionModeProvider.CustomSelectMenuItem) it.next());
            }
        }

        private final void addCustomSelectMenuItem(final SSWebView webView, final ActionMode actionMode, final IActionModeProvider.CustomSelectMenuItem item) {
            MenuItem add;
            Menu menu = actionMode.getMenu();
            if (menu == null || (add = menu.add(item.getTitle())) == null) {
                return;
            }
            add.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() { // from class: com.bytedance.ies.bullet.kit.web.SSWebView$ActionModeHelper$addCustomSelectMenuItem$1
                @Override // android.view.MenuItem.OnMenuItemClickListener
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    Intrinsics.checkNotNullParameter(menuItem, "it");
                    SSWebView sSWebView = SSWebView.this;
                    final SSWebView.ActionModeHelper actionModeHelper = this;
                    final ActionMode actionMode2 = actionMode;
                    final IActionModeProvider.CustomSelectMenuItem customSelectMenuItem = item;
                    sSWebView.evaluateJavascript("javascript:(function getSelectedText() {return window.getSelection().toString();})()", new ValueCallback() { // from class: com.bytedance.ies.bullet.kit.web.SSWebView$ActionModeHelper$addCustomSelectMenuItem$1.1
                        @Override // android.webkit.ValueCallback
                        public final void onReceiveValue(final String str) {
                            Handler handler;
                            handler = SSWebView.ActionModeHelper.this.mainHandler;
                            final ActionMode actionMode3 = actionMode2;
                            final IActionModeProvider.CustomSelectMenuItem customSelectMenuItem2 = customSelectMenuItem;
                            handler.post(new Runnable() { // from class: com.bytedance.ies.bullet.kit.web.SSWebView.ActionModeHelper.addCustomSelectMenuItem.1.1.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    actionMode3.finish();
                                    Function1<String, Unit> clickListener = customSelectMenuItem2.getClickListener();
                                    String str2 = str;
                                    Intrinsics.checkNotNullExpressionValue(str2, "text");
                                    clickListener.invoke(StringsKt.removeSurrounding(str2, "\""));
                                }
                            });
                        }
                    });
                    return true;
                }
            });
        }

        private final ActionMode.Callback createActionModeCallback(final IActionModeCallbackDelegate delegate) {
            return new ActionMode.Callback2() { // from class: com.bytedance.ies.bullet.kit.web.SSWebView$ActionModeHelper$createActionModeCallback$1
                @Override // android.view.ActionMode.Callback
                public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                    return SSWebView.ActionModeHelper.IActionModeCallbackDelegate.this.onCreateActionMode(mode, menu);
                }

                @Override // android.view.ActionMode.Callback
                public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                    return SSWebView.ActionModeHelper.IActionModeCallbackDelegate.this.onPrepareActionMode(mode, menu);
                }

                @Override // android.view.ActionMode.Callback
                public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                    return SSWebView.ActionModeHelper.IActionModeCallbackDelegate.this.onActionItemClicked(mode, item);
                }

                @Override // android.view.ActionMode.Callback
                public void onDestroyActionMode(ActionMode mode) {
                    SSWebView.ActionModeHelper.IActionModeCallbackDelegate.this.onDestroyActionMode(mode);
                }

                @Override // android.view.ActionMode.Callback2
                public void onGetContentRect(ActionMode mode, View view, Rect outRect) {
                    if (SSWebView.ActionModeHelper.IActionModeCallbackDelegate.this.onGetContentRect(mode, view, outRect)) {
                        return;
                    }
                    super.onGetContentRect(mode, view, outRect);
                }
            };
        }

        public final void destroy() {
            this.sessionId = "";
            this.mainHandler.removeCallbacksAndMessages(null);
        }
    }

    /* compiled from: SSWebView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ies/bullet/kit/web/SSWebView$WebViewEventDelegate;", "", "canScrollVertically", "", "direction", "", "enable", "hasClickInTimeInterval", "onTouchEvent", ISignalReportService.BODY_KEY_EVENT, "Landroid/view/MotionEvent;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface WebViewEventDelegate {
        boolean canScrollVertically(int direction, boolean enable);

        boolean hasClickInTimeInterval();

        boolean onTouchEvent(MotionEvent event);

        /* compiled from: SSWebView.kt */
        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
        public static final class DefaultImpls {
            public static boolean onTouchEvent(WebViewEventDelegate webViewEventDelegate, MotionEvent motionEvent) {
                Intrinsics.checkNotNullParameter(motionEvent, ISignalReportService.BODY_KEY_EVENT);
                throw new YieldError("An operation is not implemented");
            }

            public static boolean canScrollVertically(WebViewEventDelegate webViewEventDelegate, int i, boolean z) {
                throw new YieldError("An operation is not implemented");
            }

            public static boolean hasClickInTimeInterval(WebViewEventDelegate webViewEventDelegate) {
                throw new YieldError("An operation is not implemented");
            }
        }
    }
}
