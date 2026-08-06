package com.bytedance.ies.bullet.service.base.web;

import android.content.Intent;
import android.net.Uri;
import android.webkit.PermissionRequest;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WebCompatDelegate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0001\u001a\f\u0010\u0000\u001a\u00020\u0003*\u00020\u0004H\u0001\u001a\f\u0010\u0000\u001a\u00020\u0005*\u00020\u0006H\u0001\u001a\f\u0010\u0000\u001a\u00020\u0007*\u00020\bH\u0001\u001a\f\u0010\u0000\u001a\u00020\t*\u00020\nH\u0001¨\u0006\u000b"}, d2 = {"transform", "Lcom/bytedance/ies/bullet/service/base/web/IPermissionRequest;", "Landroid/webkit/PermissionRequest;", "Lcom/bytedance/ies/bullet/service/base/web/IRenderProcessGoneDetail;", "Landroid/webkit/RenderProcessGoneDetail;", "Lcom/bytedance/ies/bullet/service/base/web/IFileChooserParams;", "Landroid/webkit/WebChromeClient$FileChooserParams;", "Lcom/bytedance/ies/bullet/service/base/web/IWebResourceError;", "Landroid/webkit/WebResourceError;", "Lcom/bytedance/ies/bullet/service/base/web/IWebResourceRequest;", "Landroid/webkit/WebResourceRequest;", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class WebCompatDelegateKt {
    public static final IWebResourceRequest transform(final WebResourceRequest webResourceRequest) {
        Intrinsics.checkNotNullParameter(webResourceRequest, "<this>");
        return new IWebResourceRequest() { // from class: com.bytedance.ies.bullet.service.base.web.WebCompatDelegateKt$transform$1
            @Override // com.bytedance.ies.bullet.service.base.web.IWebResourceRequest
            public Uri getUrl() {
                Uri url = webResourceRequest.getUrl();
                Intrinsics.checkNotNullExpressionValue(url, "getUrl()");
                return url;
            }

            @Override // com.bytedance.ies.bullet.service.base.web.IWebResourceRequest
            public boolean isForMainFrame() {
                return webResourceRequest.isForMainFrame();
            }

            @Override // com.bytedance.ies.bullet.service.base.web.IWebResourceRequest
            public boolean isRedirect() {
                return webResourceRequest.isRedirect();
            }

            @Override // com.bytedance.ies.bullet.service.base.web.IWebResourceRequest
            public boolean getHasGesture() {
                return webResourceRequest.hasGesture();
            }

            @Override // com.bytedance.ies.bullet.service.base.web.IWebResourceRequest
            public CharSequence getMethod() {
                return webResourceRequest.getMethod();
            }

            @Override // com.bytedance.ies.bullet.service.base.web.IWebResourceRequest
            public Map<String, String> getRequestHeaders() {
                Map<String, String> requestHeaders = webResourceRequest.getRequestHeaders();
                return requestHeaders == null ? MapsKt.emptyMap() : requestHeaders;
            }
        };
    }

    public static final IWebResourceError transform(final WebResourceError webResourceError) {
        Intrinsics.checkNotNullParameter(webResourceError, "<this>");
        return new IWebResourceError() { // from class: com.bytedance.ies.bullet.service.base.web.WebCompatDelegateKt$transform$2
            @Override // com.bytedance.ies.bullet.service.base.web.IWebResourceError
            public int getErrorCode() {
                return webResourceError.getErrorCode();
            }

            @Override // com.bytedance.ies.bullet.service.base.web.IWebResourceError
            public CharSequence getDescription() {
                return webResourceError.getDescription();
            }
        };
    }

    public static final IRenderProcessGoneDetail transform(final RenderProcessGoneDetail renderProcessGoneDetail) {
        Intrinsics.checkNotNullParameter(renderProcessGoneDetail, "<this>");
        return new IRenderProcessGoneDetail() { // from class: com.bytedance.ies.bullet.service.base.web.WebCompatDelegateKt$transform$3
            @Override // com.bytedance.ies.bullet.service.base.web.IRenderProcessGoneDetail
            public boolean didCrash() {
                return renderProcessGoneDetail.didCrash();
            }

            @Override // com.bytedance.ies.bullet.service.base.web.IRenderProcessGoneDetail
            public int rendererPriorityAtExit() {
                return renderProcessGoneDetail.rendererPriorityAtExit();
            }
        };
    }

    public static final IPermissionRequest transform(final PermissionRequest permissionRequest) {
        Intrinsics.checkNotNullParameter(permissionRequest, "<this>");
        return new IPermissionRequest() { // from class: com.bytedance.ies.bullet.service.base.web.WebCompatDelegateKt$transform$4
            @Override // com.bytedance.ies.bullet.service.base.web.IPermissionRequest
            public Uri getOrigin() {
                return permissionRequest.getOrigin();
            }

            @Override // com.bytedance.ies.bullet.service.base.web.IPermissionRequest
            public String[] getResources() {
                String[] resources = permissionRequest.getResources();
                return resources == null ? new String[0] : resources;
            }

            @Override // com.bytedance.ies.bullet.service.base.web.IPermissionRequest
            public void grant(String[] resources) {
                Intrinsics.checkNotNullParameter(resources, "resources");
                permissionRequest.grant(resources);
            }

            @Override // com.bytedance.ies.bullet.service.base.web.IPermissionRequest
            public void deny() {
                permissionRequest.deny();
            }
        };
    }

    public static final IFileChooserParams transform(final WebChromeClient.FileChooserParams fileChooserParams) {
        Intrinsics.checkNotNullParameter(fileChooserParams, "<this>");
        return new IFileChooserParams() { // from class: com.bytedance.ies.bullet.service.base.web.WebCompatDelegateKt$transform$5
            @Override // com.bytedance.ies.bullet.service.base.web.IFileChooserParams
            public int getMode() {
                return fileChooserParams.getMode();
            }

            @Override // com.bytedance.ies.bullet.service.base.web.IFileChooserParams
            public String[] getAcceptTypes() {
                return fileChooserParams.getAcceptTypes();
            }

            @Override // com.bytedance.ies.bullet.service.base.web.IFileChooserParams
            public CharSequence getFilenameHint() {
                return fileChooserParams.getFilenameHint();
            }

            @Override // com.bytedance.ies.bullet.service.base.web.IFileChooserParams
            public boolean isCaptureEnabled() {
                return fileChooserParams.isCaptureEnabled();
            }

            @Override // com.bytedance.ies.bullet.service.base.web.IFileChooserParams
            public CharSequence getTitle() {
                return fileChooserParams.getTitle();
            }

            @Override // com.bytedance.ies.bullet.service.base.web.IFileChooserParams
            public boolean isMultiple() {
                return fileChooserParams.getMode() == 1;
            }

            @Override // com.bytedance.ies.bullet.service.base.web.IFileChooserParams
            public Intent createIntent() {
                return fileChooserParams.createIntent();
            }
        };
    }
}
