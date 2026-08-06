package com.bytedance.ies.bullet.kit.web;

import android.webkit.WebView;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;

/* compiled from: IWebKitDelegatesProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0088\u0001\u0010\u0002\u001a\u0081\u0001\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0006\u0012&\u0012$\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0006\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003j&\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0006\u0018\u0001`\t¢\u0006\u0002\b\nH&¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ies/bullet/kit/web/IWebViewLoadUrlInterceptorDelegate;", "", "provideWebViewLoadUrlInterceptor", "Lkotlin/Function4;", "Landroid/webkit/WebView;", "", "", "Lkotlin/Function2;", "", "Lcom/bytedance/ies/bullet/kit/web/TwistInterceptor;", "Lkotlin/ExtensionFunctionType;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IWebViewLoadUrlInterceptorDelegate {
    Function4<WebView, String, Map<String, String>, Function2<? super String, ? super Map<String, String>, Unit>, Unit> provideWebViewLoadUrlInterceptor();
}
