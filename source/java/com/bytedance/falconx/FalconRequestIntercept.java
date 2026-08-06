package com.bytedance.falconx;

import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.falconx.debug.WebOfflineAnalyze;
import com.bytedance.falconx.loader.AssetResLoader;
import com.bytedance.falconx.loader.GeckoResLoader;
import com.bytedance.falconx.loader.ILoader;
import com.bytedance.falconx.statistic.InputStreamProxy;
import com.bytedance.falconx.statistic.InterceptorModel;
import com.bytedance.falconx.statistic.StatisticData;
import com.bytedance.falconx.statistic.StatisticThread;
import com.bytedance.falconx.utils.MimeUtils;
import com.bytedance.falconx.utils.WebResourceUtils;
import com.bytedance.geckox.logger.GeckoLogger;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
class FalconRequestIntercept implements IRequestIntercept {
    private WebOfflineConfig mConfig;
    private Handler mHandler;
    private List<ILoader> mResLoaders = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    public FalconRequestIntercept(WebOfflineConfig webOfflineConfig) {
        this.mConfig = webOfflineConfig;
        this.mHandler = new Handler(this.mConfig.getContext().getMainLooper());
        for (Uri uri : this.mConfig.getCacheDir()) {
            String scheme = uri.getScheme();
            String lowerCase = scheme == null ? "" : scheme.toLowerCase();
            if ("".equals(lowerCase) || "file".equals(lowerCase)) {
                this.mResLoaders.add(new GeckoResLoader(webOfflineConfig.getContext(), webOfflineConfig.getAccessKey(), new File(uri.getPath())));
            } else if ("asset".equals(lowerCase)) {
                String path = uri.getPath();
                this.mResLoaders.add(new AssetResLoader(webOfflineConfig.getContext(), new File(path.startsWith("/") ? path.substring(1) : path)));
            } else {
                GeckoLogger.m301w(WebOffline.TAG, "unknown scheme:" + uri);
            }
        }
    }

    @Override // com.bytedance.falconx.IRequestIntercept
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        try {
            List<Pattern> cachePrefix = this.mConfig.getCachePrefix();
            if (cachePrefix != null && !cachePrefix.isEmpty() && !TextUtils.isEmpty(str)) {
                InterceptorModel interceptorModel = new InterceptorModel();
                interceptorModel.url = str;
                WebResourceResponse tryLoadLocalResource = tryLoadLocalResource(webView, str, interceptorModel);
                if (tryLoadLocalResource == null && interceptorModel.offlineRule != null) {
                    tryGetOnLineLoadDuration(webView, interceptorModel);
                }
                return tryLoadLocalResource;
            }
            return null;
        } catch (Exception e) {
            GeckoLogger.m302w(WebOffline.TAG, "shouldInterceptRequest:", e);
            return null;
        }
    }

    private WebResourceResponse tryLoadLocalResource(final WebView webView, String str, final InterceptorModel interceptorModel) throws Exception {
        String str2 = WebOffline.TAG;
        interceptorModel.accessKey = this.mConfig.getAccessKey();
        if (webView != null) {
            webView.post(new Runnable() { // from class: com.bytedance.falconx.FalconRequestIntercept.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        interceptorModel.pageUrl = webView.getUrl();
                    } catch (Exception e) {
                        GeckoLogger.m302w(WebOffline.TAG, "getUrl:", e);
                    }
                }
            });
        }
        for (Pattern pattern : this.mConfig.getCachePrefix()) {
            if (pattern != null) {
                WebResourceResponse handleCombo = handleCombo(pattern, str, interceptorModel);
                if (handleCombo != null) {
                    proxyInputStream(webView, interceptorModel, handleCombo);
                    return handleCombo;
                }
                Matcher matcher = pattern.matcher(str);
                if (matcher.find()) {
                    interceptorModel.offlineRule = pattern.pattern();
                    String path = getPath(str, matcher);
                    for (ILoader iLoader : this.mResLoaders) {
                        String mimeType = MimeUtils.getMimeType(path);
                        try {
                            interceptorModel.resRootDir = iLoader.getResRootDir();
                            Map<String, Long> channelVersion = iLoader.getChannelVersion();
                            String substring = path.substring(0, path.indexOf("/"));
                            interceptorModel.channel = substring;
                            interceptorModel.pkgVersion = channelVersion.get(substring);
                            interceptorModel.mimeType = mimeType;
                            WebResourceResponse response = WebResourceUtils.getResponse(mimeType, "", iLoader.getInputStream(path));
                            if (response != null) {
                                WebOfflineAnalyze.matchSuccess(str, "path:" + path, getPkgVersion(interceptorModel));
                                proxyInputStream(webView, interceptorModel, response);
                            } else {
                                WebOfflineAnalyze.matchFailed(str, "not found local resource", getPkgVersion(interceptorModel));
                            }
                            return response;
                        } catch (FileNotFoundException e) {
                            WebOfflineAnalyze.matchFailed(str, "not found local resource", getPkgVersion(interceptorModel));
                            GeckoLogger.m302w(str2, "tryLoadLocalResource:not found local resource: path:" + path, e);
                        } catch (Throwable th) {
                            WebOfflineAnalyze.matchFailed(str, "not found local resource" + th, getPkgVersion(interceptorModel));
                            GeckoLogger.m302w(str2, "tryLoadLocalResource:", th);
                        }
                    }
                } else {
                    continue;
                }
            }
        }
        interceptorModel.setErrorCode(StatisticData.ERROR_CODE_NOT_FOUND);
        interceptorModel.setErrorMsg("not found");
        interceptorModel.loadFinish(false);
        return null;
    }

    private long getPkgVersion(InterceptorModel interceptorModel) {
        if (interceptorModel != null) {
            return interceptorModel.getVersion();
        }
        return -1L;
    }

    private WebResourceResponse handleCombo(Pattern pattern, String str, InterceptorModel interceptorModel) {
        InputStream inputStream;
        Matcher matcher = Pattern.compile(pattern.pattern() + "??").matcher(str);
        if (!matcher.find()) {
            return null;
        }
        interceptorModel.offlineRule = pattern.pattern();
        int indexOf = str.indexOf("??");
        if (indexOf <= 0) {
            return null;
        }
        String substring = str.substring(matcher.end() + 1, indexOf);
        String[] split = str.substring(indexOf + 2).split(",");
        if (split.length <= 1) {
            return null;
        }
        String str2 = substring + split[0];
        split[0] = str2;
        String mimeType = MimeUtils.getMimeType(str2);
        for (int i = 1; i < split.length; i++) {
            String str3 = substring + split[i];
            split[i] = str3;
            if (!TextUtils.equals(MimeUtils.getMimeType(str3), mimeType)) {
                return null;
            }
        }
        ArrayList arrayList = new ArrayList();
        int length = split.length;
        for (int i2 = 0; i2 < length; i2++) {
            String str4 = split[i2];
            Iterator<ILoader> it = this.mResLoaders.iterator();
            while (true) {
                if (!it.hasNext()) {
                    inputStream = null;
                    break;
                }
                ILoader next = it.next();
                try {
                    interceptorModel.resRootDir = next.getResRootDir();
                    Map<String, Long> channelVersion = next.getChannelVersion();
                    interceptorModel.channel = substring;
                    interceptorModel.mimeType = mimeType;
                    interceptorModel.pkgVersion = channelVersion.get(substring);
                    interceptorModel.isCombo = true;
                    inputStream = next.getInputStream(str4);
                    break;
                } catch (Throwable th) {
                    GeckoLogger.m302w(WebOffline.TAG, "handleCombo:", th);
                }
            }
            if (inputStream == null) {
                return null;
            }
            arrayList.add(inputStream);
        }
        return WebResourceUtils.getResponse(mimeType, "", new SequenceInputStream(Collections.enumeration(arrayList)));
    }

    private String getPath(String str, Matcher matcher) {
        String substring;
        int indexOf = str.indexOf("?");
        int indexOf2 = str.indexOf("#");
        int min = Math.min(indexOf, indexOf2);
        if (min == -1) {
            min = Math.max(indexOf, indexOf2);
        }
        if (min != -1) {
            substring = str.substring(matcher.end(), min);
        } else {
            substring = str.substring(matcher.end());
        }
        if (substring.endsWith("/")) {
            substring = substring.substring(0, substring.length() - 1);
        }
        return substring.startsWith("/") ? substring.substring(1) : substring;
    }

    private void proxyInputStream(final WebView webView, final InterceptorModel interceptorModel, WebResourceResponse webResourceResponse) {
        InputStream data = webResourceResponse.getData();
        if (data == null) {
            return;
        }
        webResourceResponse.setData(new InputStreamProxy(data) { // from class: com.bytedance.falconx.FalconRequestIntercept.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.bytedance.falconx.statistic.InputStreamProxy
            public void onReadException(IOException iOException) {
                super.onReadException(iOException);
                interceptorModel.setErrorCode(StatisticData.ERROR_CODE_IO_ERROR);
                interceptorModel.setErrorMsg(iOException.getMessage());
                interceptorModel.loadFinish(false);
                FalconRequestIntercept.this.insertStatisticData(webView, interceptorModel);
            }

            @Override // com.bytedance.falconx.statistic.InputStreamProxy, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                super.close();
                interceptorModel.loadFinish(true);
                FalconRequestIntercept.this.insertStatisticData(webView, interceptorModel);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void insertStatisticData(final WebView webView, final InterceptorModel interceptorModel) {
        this.mHandler.post(new Runnable() { // from class: com.bytedance.falconx.FalconRequestIntercept.3
            @Override // java.lang.Runnable
            public void run() {
                StatisticThread.getInstance().save(webView, interceptorModel);
            }
        });
    }

    private void tryGetOnLineLoadDuration(WebView webView, InterceptorModel interceptorModel) {
        insertStatisticData(webView, interceptorModel);
    }

    public void release() throws Throwable {
        Iterator<ILoader> it = this.mResLoaders.iterator();
        while (it.hasNext()) {
            it.next().release();
        }
    }
}
