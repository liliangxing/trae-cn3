package com.ss.android.socialbase.downloader.core.module;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.core.AbsDownloadModule;
import com.ss.android.socialbase.downloader.core.IDownloadModule;
import com.ss.android.socialbase.downloader.core.IDownloadModuleChain;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DownloadUrlInterceptModule extends AbsDownloadModule {
    private static final String TAG = "DownloadUrlInterceptModule";
    private JSONArray mHosts;
    private JSONArray mPaths;
    private JSONArray mPatterns;

    @Override // com.ss.android.socialbase.downloader.core.AbsDownloadModule, com.ss.android.socialbase.downloader.core.IDownloadModule
    public IDownloadModule init(DownloadCommonParams downloadCommonParams) {
        JSONObject optJSONObject = downloadCommonParams.mSetting.optJSONObject(DownloadSettingKeys.URL_INTERCEPT_CONFIG);
        if (optJSONObject == null) {
            return null;
        }
        this.mHosts = optJSONObject.optJSONArray(DownloadSettingKeys.UrlInterceptConfig.HOST_LIST);
        this.mPaths = optJSONObject.optJSONArray(DownloadSettingKeys.UrlInterceptConfig.PATH_LIST);
        JSONArray optJSONArray = optJSONObject.optJSONArray(DownloadSettingKeys.UrlInterceptConfig.PATTERN_LIST);
        this.mPatterns = optJSONArray;
        if (this.mHosts == null && this.mPaths == null && optJSONArray == null) {
            return null;
        }
        return super.init(downloadCommonParams);
    }

    @Override // com.ss.android.socialbase.downloader.core.IDownloadModule
    public void proceed(IDownloadModuleChain iDownloadModuleChain) throws BaseException {
        if (checkUrlIntercept()) {
            throw new BaseException(1083, "download url intercept");
        }
        iDownloadModuleChain.proceed();
    }

    private boolean checkUrlIntercept() {
        String url = this.mDownloadInfo.getUrl();
        try {
            URL url2 = new URL(url);
            String host = url2.getHost();
            String path = url2.getPath();
            if (this.mHosts != null) {
                for (int i = 0; i < this.mHosts.length(); i++) {
                    String optString = this.mHosts.optString(i);
                    if (!TextUtils.isEmpty(optString) && host.equals(optString)) {
                        return true;
                    }
                }
            }
            if (this.mPaths != null) {
                for (int i2 = 0; i2 < this.mPaths.length(); i2++) {
                    String optString2 = this.mPaths.optString(i2);
                    if (!TextUtils.isEmpty(optString2) && path.equals(optString2)) {
                        return true;
                    }
                }
            }
            if (this.mPatterns != null) {
                for (int i3 = 0; i3 < this.mPatterns.length(); i3++) {
                    String optString3 = this.mPatterns.optString(i3);
                    if (!TextUtils.isEmpty(optString3)) {
                        try {
                            if (Pattern.matches(optString3, url)) {
                                return true;
                            }
                        } catch (Throwable th) {
                            Logger.taskError(TAG, this.mDownloadInfo.getId(), "checkUrlIntercept", "Error:" + th);
                        }
                    }
                }
            }
            return false;
        } catch (MalformedURLException e) {
            Logger.taskError(TAG, this.mDownloadInfo.getId(), "checkUrlIntercept", "Error:" + e);
            return false;
        }
    }
}
