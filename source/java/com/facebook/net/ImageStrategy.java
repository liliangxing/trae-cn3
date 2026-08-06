package com.facebook.net;

import android.net.Uri;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.ttnet.config.ImageStrategyController;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class ImageStrategy {
    private static final String DEFAULT_COUNT_KEY = "p.pstap.com";
    private static final int DEFAULT_ERROR_TIMES = 5;
    private static final int DEFAULT_LIMIT_IMAGES = 50;
    private static final long DEFAULT_LIMIT_INTERVAL = 600000;
    private static final long DEFAULT_UPLOAD_COUNT_INTERVAL = 300000;
    private static final String IMAGE_COUNT_SERVICE = "image_opt_monitor";
    private static final Object mLock = new Object();
    private static volatile ImageStrategy sIns;
    private final ConcurrentHashMap<String, Long> mBlockHost = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, ImageRequestInfo> mImageRequestInfo = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, RequestCountInfo> mRequestCountInfo = new ConcurrentHashMap<>();
    private boolean mLocalSwitch = true;

    private ImageStrategy() {
    }

    public static ImageStrategy getInstance() {
        if (sIns == null) {
            synchronized (mLock) {
                if (sIns == null) {
                    sIns = new ImageStrategy();
                }
            }
        }
        return sIns;
    }

    public void setLocalSwitch(boolean z) {
        this.mLocalSwitch = z;
    }

    public void handleImageRequest(String str, boolean z, long j, boolean z2) {
        if (this.mLocalSwitch && !StringUtils.isEmpty(str) && isMatchNetState()) {
            handleCount(str, z, j, z2);
            if (getImageStrategySwitch()) {
                try {
                    String host = Uri.parse(str).getHost();
                    if (this.mImageRequestInfo.containsKey(host)) {
                        ImageRequestInfo imageRequestInfo = this.mImageRequestInfo.get(host);
                        if (imageRequestInfo == null || imageRequestInfo.mHasInBlackList) {
                            return;
                        }
                        if (!z) {
                            imageRequestInfo.mErrorRequest++;
                        }
                        imageRequestInfo.mTotalRequest++;
                        if (imageRequestInfo.mErrorRequest >= getErrorTimes() && (imageRequestInfo.mErrorRequest * 100) / imageRequestInfo.mTotalRequest >= 10) {
                            imageRequestInfo.mHasInBlackList = true;
                            imageRequestInfo.mTotalRequest = 0;
                            imageRequestInfo.mErrorRequest = 0;
                            this.mBlockHost.put(host, Long.valueOf(System.currentTimeMillis()));
                            return;
                        }
                        if (imageRequestInfo.mTotalRequest > imageRequestInfo.mLimitTotalRequest) {
                            imageRequestInfo.mTotalRequest = 0;
                            imageRequestInfo.mErrorRequest = 0;
                            imageRequestInfo.mHasInBlackList = false;
                            return;
                        }
                        return;
                    }
                    this.mImageRequestInfo.put(host, new ImageRequestInfo(z ? 0 : 1, 1, false, 0L, getImageLimitNumber()));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    private boolean isMatchNetState() {
        int value = ImageStrategyController.getInstance() != null ? ImageStrategyController.getInstance().getNetWorkType().getValue() : 0;
        return value == NetworkUtils.NetworkType.WIFI.getValue() || value == NetworkUtils.NetworkType.MOBILE_4G.getValue() || value == NetworkUtils.NetworkType.MOBILE_3G.getValue() || value == NetworkUtils.NetworkType.MOBILE_3G_H.getValue() || value == NetworkUtils.NetworkType.MOBILE_3G_HP.getValue() || value == NetworkUtils.NetworkType.MOBILE_5G.getValue();
    }

    private boolean getHostInBlack(Uri uri) {
        ImageRequestInfo imageRequestInfo;
        if (uri != null) {
            try {
                if (getImageStrategySwitch()) {
                    String host = uri.getHost();
                    if (StringUtils.isEmpty(host) || !this.mBlockHost.containsKey(host)) {
                        return false;
                    }
                    if (System.currentTimeMillis() - this.mBlockHost.get(host).longValue() <= getBlackInterval()) {
                        return true;
                    }
                    if (this.mImageRequestInfo.containsKey(host) && (imageRequestInfo = this.mImageRequestInfo.get(host)) != null) {
                        imageRequestInfo.mHasInBlackList = false;
                    }
                    this.mBlockHost.remove(host);
                    return false;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public List<String> getUrlList(String str) {
        if (ImageStrategyController.getInstance() != null) {
            return ImageStrategyController.getInstance().getUrlListForUrl(str);
        }
        return null;
    }

    public void sortImageRequests(ImageRequest[] imageRequestArr) {
        if (this.mLocalSwitch && imageRequestArr != null && imageRequestArr.length > 1 && getImageStrategySwitch() && !this.mBlockHost.isEmpty()) {
            int length = imageRequestArr.length - 1;
            int i = 0;
            while (i < length) {
                while (i < length && !getHostInBlack(imageRequestArr[i].getSourceUri())) {
                    i++;
                }
                while (i < length && getHostInBlack(imageRequestArr[length].getSourceUri())) {
                    length--;
                }
                if (i < length) {
                    ImageRequest imageRequest = imageRequestArr[i];
                    imageRequestArr[i] = imageRequestArr[length];
                    imageRequestArr[length] = imageRequest;
                    i++;
                    length--;
                }
            }
        }
    }

    public boolean getImageStrategySwitch() {
        return ImageStrategyController.getInstance() != null && ImageStrategyController.getInstance().getSwitch() == 1;
    }

    private int getErrorTimes() {
        if (ImageStrategyController.getInstance() == null || ImageStrategyController.getInstance().getFailedTimes() <= 0) {
            return 5;
        }
        return ImageStrategyController.getInstance().getFailedTimes();
    }

    private long getBlackInterval() {
        if (ImageStrategyController.getInstance() == null || ImageStrategyController.getInstance().getHostInBlackInterval() <= 0) {
            return 600000L;
        }
        return ImageStrategyController.getInstance().getHostInBlackInterval() * 1000;
    }

    private int getImageLimitNumber() {
        if (ImageStrategyController.getInstance() == null || ImageStrategyController.getInstance().getLimitImageNumbers() <= 0) {
            return 50;
        }
        return ImageStrategyController.getInstance().getLimitImageNumbers();
    }

    private void handleCount(String str, boolean z, long j, boolean z2) {
        try {
            if ((ImageStrategyController.getInstance() == null || ImageStrategyController.getInstance().getSwitch() != 2) && z2) {
                if (this.mRequestCountInfo.containsKey(DEFAULT_COUNT_KEY)) {
                    RequestCountInfo requestCountInfo = this.mRequestCountInfo.get(DEFAULT_COUNT_KEY);
                    if (z && j > 0) {
                        requestCountInfo.mSuccessTimes++;
                        requestCountInfo.mTotalDuration += j;
                    } else {
                        requestCountInfo.mErrorTimes++;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - requestCountInfo.mStartCountTime > 300000) {
                        long j2 = requestCountInfo.mSuccessTimes > 0 ? requestCountInfo.mTotalDuration / requestCountInfo.mSuccessTimes : 0L;
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("error", requestCountInfo.mErrorTimes);
                        jSONObject.put("success", requestCountInfo.mSuccessTimes);
                        jSONObject.put("average_duration", j2);
                        if (getImageStrategySwitch()) {
                            jSONObject.put("has_opt", 1);
                        }
                        requestCountInfo.mErrorTimes = 0;
                        requestCountInfo.mSuccessTimes = 0;
                        requestCountInfo.mTotalDuration = 0L;
                        requestCountInfo.mStartCountTime = currentTimeMillis;
                        return;
                    }
                    return;
                }
                this.mRequestCountInfo.put(DEFAULT_COUNT_KEY, new RequestCountInfo(z ? 1 : 0, z ? 0 : 1, j));
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class ImageRequestInfo {
        long mEnterBlackListTime;
        int mErrorRequest;
        boolean mHasInBlackList;
        int mLimitTotalRequest;
        int mTotalRequest;

        public ImageRequestInfo(int i, int i2, boolean z, long j, int i3) {
            this.mErrorRequest = i;
            this.mTotalRequest = i2;
            this.mHasInBlackList = z;
            this.mEnterBlackListTime = j;
            this.mLimitTotalRequest = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class RequestCountInfo {
        int mErrorTimes;
        long mStartCountTime = System.currentTimeMillis();
        int mSuccessTimes;
        long mTotalDuration;

        public RequestCountInfo(int i, int i2, long j) {
            this.mSuccessTimes = i;
            this.mErrorTimes = i2;
            this.mTotalDuration = j;
        }
    }
}
