package com.bytedance.webx.core.webview;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.os.Bundle;
import android.os.Message;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ViewStructure;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebMessage;
import android.webkit.WebMessagePort;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebViewRenderProcess;
import android.webkit.WebViewRenderProcessClient;
import com.bytedance.webx.IContainer;
import java.util.Map;
import java.util.concurrent.Executor;

/* loaded from: classes6.dex */
public interface IWebViewContainer extends IContainer {
    void addJavascriptInterface(Object obj, String str);

    boolean canGoBack();

    boolean canGoBackOrForward(int i);

    boolean canGoForward();

    WebMessagePort[] createWebMessageChannel();

    void destroy();

    boolean dispatchKeyEvent(KeyEvent keyEvent);

    boolean dispatchTouchEvent(MotionEvent motionEvent);

    void documentHasImages(Message message);

    void draw(Canvas canvas);

    void evaluateJavascript(String str, ValueCallback<String> valueCallback);

    void flingScroll(int i, int i2);

    SslCertificate getCertificate();

    @Deprecated
    String[] getHttpAuthUsernamePassword(String str, String str2);

    WebSettings getSettings();

    WebChromeClient getWebChromeClient();

    WebViewClient getWebViewClient();

    WebViewRenderProcess getWebViewRenderProcess();

    WebViewRenderProcessClient getWebViewRenderProcessClient();

    void goBack();

    void goBackOrForward(int i);

    void goForward();

    void loadData(String str, String str2, String str3);

    void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5);

    void loadUrl(String str);

    void loadUrl(String str, Map<String, String> map);

    boolean onCheckIsTextEditor();

    InputConnection onCreateInputConnection(EditorInfo editorInfo);

    boolean onDragEvent(DragEvent dragEvent);

    void onFinishTemporaryDetach();

    boolean onGenericMotionEvent(MotionEvent motionEvent);

    boolean onHoverEvent(MotionEvent motionEvent);

    boolean onInterceptTouchEvent(MotionEvent motionEvent);

    boolean onKeyDown(int i, KeyEvent keyEvent);

    boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent);

    boolean onKeyUp(int i, KeyEvent keyEvent);

    void onPause();

    void onProvideAutofillVirtualStructure(ViewStructure viewStructure, int i);

    void onProvideVirtualStructure(ViewStructure viewStructure);

    void onResume();

    void onStartTemporaryDetach();

    boolean onTouchEvent(MotionEvent motionEvent);

    boolean onTrackballEvent(MotionEvent motionEvent);

    void onWindowFocusChanged(boolean z);

    boolean pageDown(boolean z);

    boolean pageUp(boolean z);

    void postUrl(String str, byte[] bArr);

    void postWebMessage(WebMessage webMessage, Uri uri);

    void reload();

    void removeJavascriptInterface(String str);

    boolean requestFocus(int i, Rect rect);

    WebBackForwardList restoreState(Bundle bundle);

    @Deprecated
    void savePassword(String str, String str2, String str3);

    WebBackForwardList saveState(Bundle bundle);

    void saveWebArchive(String str);

    void saveWebArchive(String str, boolean z, ValueCallback<String> valueCallback);

    @Deprecated
    void setCertificate(SslCertificate sslCertificate);

    void setDownloadListener(DownloadListener downloadListener);

    void setFindListener(WebView.FindListener findListener);

    @Deprecated
    void setHttpAuthUsernamePassword(String str, String str2, String str3, String str4);

    void setWebChromeClient(WebChromeClient webChromeClient);

    void setWebViewClient(WebViewClient webViewClient);

    void setWebViewRenderProcessClient(WebViewRenderProcessClient webViewRenderProcessClient);

    void setWebViewRenderProcessClient(Executor executor, WebViewRenderProcessClient webViewRenderProcessClient);

    void stopLoading();

    void zoomBy(float f);

    boolean zoomIn();

    boolean zoomOut();
}
