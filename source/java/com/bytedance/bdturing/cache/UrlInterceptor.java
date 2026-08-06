package com.bytedance.bdturing.cache;

import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import com.bytedance.bdturing.EventReport;
import com.bytedance.bdturing.LogUtil;
import com.bytedance.bdturing.utils.FileUtil;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class UrlInterceptor {
    private static final String INDEX_CACHE_FILE_NAME = "turing_latest_index";
    private static final String TAG = "UrlInterceptor";
    private final String mIndexUrl;
    private final int mResourceType;

    private boolean matchUrl(String str) {
        return true;
    }

    public UrlInterceptor(int i, String str) {
        this.mResourceType = i;
        this.mIndexUrl = str;
    }

    public void loadUrl(String str) {
        try {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.mIndexUrl) || !this.mIndexUrl.equals(str)) {
                return;
            }
            checkLocalCache(this.mIndexUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void checkLocalCache(final String str) {
        if (isCacheAvailable()) {
            TuringThreadPool.getInstance().execute(new Runnable() { // from class: com.bytedance.bdturing.cache.UrlInterceptor.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        String rootPath = ResourceManager.getInstance().getRootPath();
                        if (TextUtils.isEmpty(rootPath)) {
                            return;
                        }
                        String str2 = rootPath + File.separator + "turing_latest_index_" + UrlInterceptor.this.mResourceType;
                        File file = new File(str2);
                        if (file.exists()) {
                            String str3 = str2 + "_temp";
                            FileUtil.deleteFile(str3);
                            File loadFile = ResourceManager.getInstance().loadFile(str, str3);
                            if (loadFile == null || !loadFile.exists()) {
                                return;
                            }
                            String fileMd5Hex = FileUtil.fileMd5Hex(file);
                            String fileMd5Hex2 = FileUtil.fileMd5Hex(loadFile);
                            boolean equals = fileMd5Hex.equals(fileMd5Hex2);
                            LogUtil.m160d(UrlInterceptor.TAG, "===>checkLocalCache:localIndexFileMd5Hex=" + fileMd5Hex + ":remoteIndexFileMd5Hex=" + fileMd5Hex2 + ":cacheAvailable=" + equals);
                            if (!equals) {
                                FileUtil.deleteFile(str2);
                                WebResource webResource = new WebResource();
                                webResource.name = ResourceManager.CAPTCHA_RES;
                                ResourceManager.getInstance().clearCache(webResource);
                                EventReport.localCacheState(2, "url=" + str);
                            }
                            ResourceManager.getInstance().updateCacheSate(UrlInterceptor.this.mResourceType, equals);
                            FileUtil.deleteFile(str3);
                            return;
                        }
                        ResourceManager.getInstance().loadFile(str, str2);
                        LogUtil.m160d(UrlInterceptor.TAG, "===>checkLocalCache:saveRemoteIndex");
                    } catch (Exception e) {
                        e.printStackTrace();
                        LogUtil.m160d(UrlInterceptor.TAG, "===>checkLocalCache:exception");
                        EventReport.localCacheState(4, "url=" + str);
                    }
                }
            });
        }
    }

    public WebResourceResponse intercept(String str) {
        InputStream loadResource;
        try {
            if (!TextUtils.isEmpty(str) && isCacheAvailable() && matchUrl(str)) {
                String resourceName = getResourceName(str);
                String mimeType = str.equals(this.mIndexUrl) ? "text/html" : getMimeType(resourceName);
                if (TextUtils.isEmpty(mimeType) || (loadResource = ResourceManager.getInstance().loadResource(resourceName, this.mResourceType)) == null) {
                    return null;
                }
                WebResourceResponse buildLocalResponse = buildLocalResponse(mimeType, loadResource);
                LogUtil.m160d(TAG, "load " + resourceName + " result:" + buildLocalResponse);
                return buildLocalResponse;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean isCacheAvailable() {
        return ResourceManager.getInstance().isCacheAvailable(this.mResourceType);
    }

    private String getResourceName(String str) {
        try {
            String path = new URL(str).getPath();
            if (TextUtils.isEmpty(path)) {
                return null;
            }
            int lastIndexOf = path.lastIndexOf("/");
            if (lastIndexOf >= 0) {
                path = path.substring(lastIndexOf + 1);
            }
            return path;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private WebResourceResponse buildLocalResponse(String str, InputStream inputStream) {
        WebResourceResponse webResourceResponse;
        try {
            if (TextUtils.isEmpty(str) || inputStream == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("Access-Control-Allow-Origin", "*");
            if ("font/ttf".equals(str)) {
                webResourceResponse = new WebResourceResponse(str, "", 200, "OK", hashMap, inputStream);
            } else {
                webResourceResponse = new WebResourceResponse(str, "", inputStream);
                webResourceResponse.setResponseHeaders(hashMap);
            }
            return webResourceResponse;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private String getMimeType(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.endsWith(".js") ? "application/javascript" : str.endsWith(".css") ? "text/css" : str.endsWith(".html") ? "text/html" : str.endsWith(".ico") ? "image/x-icon" : (str.endsWith(".jpeg") || str.endsWith(".jpg")) ? "image/jpeg" : str.endsWith(".png") ? "image/png" : str.endsWith(".gif") ? "image/gif" : str.endsWith(".woff") ? "font/woff" : str.endsWith(".svg") ? "image/svg+xml" : str.endsWith(".ttf") ? "font/ttf" : "";
    }
}
