package com.ss.android.socialbase.downloader.downloader;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadTTNetException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.xiaomi.mipush.sdk.Constants;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class NetworkFailoverStrategy {
    private static final String FALLBACK_ERROR_IP = "0.0.0.0";
    private static final String TAG = "NetworkFailoverStrategy";
    private static final int TTNET_HTTP_PROTO_TYPE_HTTP1 = 1;
    private static final int TTNET_HTTP_PROTO_TYPE_HTTP2 = 2;
    private static final int TTNET_HTTP_PROTO_TYPE_QUIC = 3;
    private static final String TTNET_ISOLATION_HEADER_KEY = "x-ttnet-isolation-info";
    private static final String TTNET_ISOLATION_HEADER_VALUE = "https://dl";
    private String mDownloadHost;
    private Set<Integer> mIsolationErrorCodeSet = new HashSet();
    private int mIsolationCount = 0;
    private int mIsolationHttpProtoType = 0;
    private Set<Integer> mTimeoutErrorCodeSet = new HashSet();
    private List<Long> mConnectTimeoutList = new ArrayList();
    private List<Long> mIoTimeoutList = new ArrayList();
    private Set<Integer> mIpChangeErrorCodeSet = new HashSet();
    private int mIpChangeCountLimit = 0;
    private List<String> mBackHostList = new ArrayList();
    private Set<Integer> mBackHostErrorCodeSet = new HashSet();
    private int mBackHostCountLimit = 0;
    private List<FailoverStrategy> mFailoverStrategyList = new ArrayList();
    private int mDownloadId = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface FailoverStrategy {
        boolean handleError(BaseException baseException);

        void handleHeader(List<HttpHeader> list);

        boolean isFailoverOnly();
    }

    public NetworkFailoverStrategy(DownloadInfo downloadInfo) {
        String str;
        DownloadInfo downloadInfo2;
        try {
            initInternal(downloadInfo);
            if (Logger.debugScene(downloadInfo)) {
                Logger.taskDebug(TAG, downloadInfo, TAG, "Init ttnetIsolationCount:" + this.mIsolationCount + " mIsolationErrorCodeSet:" + this.mIsolationErrorCodeSet.toString() + " mIsolationHttpProtoType:" + this.mIsolationHttpProtoType + " ttnetTimeoutErrorCodes:" + this.mTimeoutErrorCodeSet.toString() + " ttnetConnectTimeout:" + this.mConnectTimeoutList.toString() + " ttnetIoTimeout:" + this.mIoTimeoutList.toString() + " ipChangeCountLimit:" + this.mIpChangeCountLimit + " ipChangeErrorCodeSet:" + this.mIpChangeErrorCodeSet + " host:" + this.mDownloadHost + " backHostList:" + this.mBackHostList.toString() + " backHostCountLimit:" + this.mBackHostCountLimit + " backHostErrorCodeSet:" + this.mBackHostErrorCodeSet);
            }
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                try {
                    Logger.taskError(TAG, this.mDownloadId, TAG, "Init Error" + th.toString());
                    if (Logger.debugScene(downloadInfo)) {
                        Logger.taskDebug(TAG, downloadInfo, TAG, "Init ttnetIsolationCount:" + this.mIsolationCount + " mIsolationErrorCodeSet:" + this.mIsolationErrorCodeSet.toString() + " mIsolationHttpProtoType:" + this.mIsolationHttpProtoType + " ttnetTimeoutErrorCodes:" + this.mTimeoutErrorCodeSet.toString() + " ttnetConnectTimeout:" + this.mConnectTimeoutList.toString() + " ttnetIoTimeout:" + this.mIoTimeoutList.toString() + " ipChangeCountLimit:" + this.mIpChangeCountLimit + " ipChangeErrorCodeSet:" + this.mIpChangeErrorCodeSet + " host:" + this.mDownloadHost + " backHostList:" + this.mBackHostList.toString() + " backHostCountLimit:" + this.mBackHostCountLimit + " backHostErrorCodeSet:" + this.mBackHostErrorCodeSet);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    downloadInfo2 = downloadInfo;
                    str = " backHostErrorCodeSet:";
                    if (!Logger.debugScene(downloadInfo)) {
                        throw th;
                    }
                    Throwable th3 = th;
                    Logger.taskDebug(TAG, downloadInfo2, TAG, "Init ttnetIsolationCount:" + this.mIsolationCount + " mIsolationErrorCodeSet:" + this.mIsolationErrorCodeSet.toString() + " mIsolationHttpProtoType:" + this.mIsolationHttpProtoType + " ttnetTimeoutErrorCodes:" + this.mTimeoutErrorCodeSet.toString() + " ttnetConnectTimeout:" + this.mConnectTimeoutList.toString() + " ttnetIoTimeout:" + this.mIoTimeoutList.toString() + " ipChangeCountLimit:" + this.mIpChangeCountLimit + " ipChangeErrorCodeSet:" + this.mIpChangeErrorCodeSet + " host:" + this.mDownloadHost + " backHostList:" + this.mBackHostList.toString() + " backHostCountLimit:" + this.mBackHostCountLimit + str + this.mBackHostErrorCodeSet);
                    throw th3;
                }
            } catch (Throwable th4) {
                th = th4;
                str = " backHostErrorCodeSet:";
                downloadInfo2 = downloadInfo;
            }
        }
        this.mFailoverStrategyList.add(new TimeoutStrategyImpl());
        this.mFailoverStrategyList.add(new DefaultIpChangeStrategyImpl());
        this.mFailoverStrategyList.add(new IsolationIpChangeStrategyImpl());
        this.mFailoverStrategyList.add(new BackHostStrategyImpl());
        this.mFailoverStrategyList.add(new TimeoutStrategyImpl());
    }

    private void initInternal(DownloadInfo downloadInfo) throws Throwable {
        JSONObject optJSONObject;
        String[] split;
        if (downloadInfo != null) {
            this.mDownloadId = downloadInfo.getId();
            this.mDownloadHost = new URL(downloadInfo.getUrl()).getHost();
            optJSONObject = DownloadSetting.obtain(this.mDownloadId).optJSONObject(DownloadSettingKeys.NETWORK_FAILOVER_STRATEGY);
        } else {
            optJSONObject = DownloadSetting.obtainGlobal().optJSONObject(DownloadSettingKeys.NETWORK_FAILOVER_STRATEGY);
        }
        if (optJSONObject == null) {
            return;
        }
        int optInt = optJSONObject.optInt(DownloadSettingKeys.NetworkFailoverStrategy.KEY_TTNET_BACK_HOST_COUNT_LIMIT);
        if (optInt > 0) {
            this.mBackHostCountLimit = optInt;
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray(DownloadSettingKeys.NetworkFailoverStrategy.KEY_TTNET_BACK_HOST);
        if (!TextUtils.isEmpty(this.mDownloadHost) && optJSONArray != null && optJSONArray.length() > 0) {
            int i = 0;
            while (true) {
                if (i >= optJSONArray.length()) {
                    break;
                }
                String optString = optJSONArray.optString(i);
                if (TextUtils.isEmpty(optString) || (split = optString.split(Constants.COLON_SEPARATOR)) == null || split.length != 2 || !this.mDownloadHost.equals(split[0]) || TextUtils.isEmpty(split[1])) {
                    i++;
                } else {
                    String[] split2 = split[1].split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    if (split2 != null && split2.length > 0) {
                        for (String str : split2) {
                            if (!TextUtils.isEmpty(str)) {
                                this.mBackHostList.add(str);
                            }
                        }
                    }
                }
            }
        }
        JSONArray optJSONArray2 = optJSONObject.optJSONArray(DownloadSettingKeys.NetworkFailoverStrategy.KEY_TTNET_BACK_HOST_ERROR_CODE);
        if (optJSONArray2 != null && optJSONArray2.length() > 0) {
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                int optInt2 = optJSONArray2.optInt(i2);
                if (optInt2 > 0) {
                    this.mBackHostErrorCodeSet.add(Integer.valueOf(optInt2));
                }
            }
        }
        int optInt3 = optJSONObject.optInt(DownloadSettingKeys.NetworkFailoverStrategy.KEY_TTNET_ISOLATION_COUNT);
        if (optInt3 > 0) {
            this.mIsolationCount = optInt3;
        }
        JSONArray optJSONArray3 = optJSONObject.optJSONArray(DownloadSettingKeys.NetworkFailoverStrategy.KEY_TTNET_ISOLATION_ERROR_CODE);
        if (optJSONArray3 != null && optJSONArray3.length() > 0) {
            for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                int optInt4 = optJSONArray3.optInt(i3);
                if (optInt4 > 0) {
                    this.mIsolationErrorCodeSet.add(Integer.valueOf(optInt4));
                }
            }
        }
        int optInt5 = optJSONObject.optInt(DownloadSettingKeys.NetworkFailoverStrategy.KEY_TTNET_ISOLATION_HTTP_PROTO_TYPE);
        if (1 == optInt5 || 2 == optInt5 || 3 == optInt5) {
            this.mIsolationHttpProtoType = optInt5;
        }
        JSONArray optJSONArray4 = optJSONObject.optJSONArray(DownloadSettingKeys.NetworkFailoverStrategy.KEY_TTNET_TIMEOUT_ERROR_CODE);
        if (optJSONArray4 != null && optJSONArray4.length() > 0) {
            for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                int optInt6 = optJSONArray4.optInt(i4);
                if (optInt6 > 0) {
                    this.mTimeoutErrorCodeSet.add(Integer.valueOf(optInt6));
                }
            }
        }
        JSONArray optJSONArray5 = optJSONObject.optJSONArray(DownloadSettingKeys.NetworkFailoverStrategy.KEY_TTNET_TIMEOUT_CONNECT);
        if (optJSONArray5 != null && optJSONArray5.length() > 0) {
            for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                long optLong = optJSONArray5.optLong(i5);
                if (optLong > 0) {
                    this.mConnectTimeoutList.add(Long.valueOf(optLong));
                }
            }
        }
        JSONArray optJSONArray6 = optJSONObject.optJSONArray(DownloadSettingKeys.NetworkFailoverStrategy.KEY_TTNET_TIMEOUT_IO);
        if (optJSONArray6 != null && optJSONArray6.length() > 0) {
            for (int i6 = 0; i6 < optJSONArray6.length(); i6++) {
                long optLong2 = optJSONArray6.optLong(i6);
                if (optLong2 > 0) {
                    this.mIoTimeoutList.add(Long.valueOf(optLong2));
                }
            }
        }
        JSONArray optJSONArray7 = optJSONObject.optJSONArray(DownloadSettingKeys.NetworkFailoverStrategy.KEY_TTNET_IP_CHANGE_ERROR_CODE);
        if (optJSONArray7 != null && optJSONArray7.length() > 0) {
            for (int i7 = 0; i7 < optJSONArray7.length(); i7++) {
                int optInt7 = optJSONArray7.optInt(i7);
                if (optInt7 > 0) {
                    this.mIpChangeErrorCodeSet.add(Integer.valueOf(optInt7));
                }
            }
        }
        int optInt8 = optJSONObject.optInt(DownloadSettingKeys.NetworkFailoverStrategy.KEY_TTNET_IP_CHANGE_COUNT_LIMIT);
        if (optInt8 > 0) {
            this.mIpChangeCountLimit = optInt8;
        }
    }

    public void handleError(BaseException baseException) {
        if (baseException == null) {
            return;
        }
        for (FailoverStrategy failoverStrategy : this.mFailoverStrategyList) {
            boolean handleError = failoverStrategy.handleError(baseException);
            if (failoverStrategy.isFailoverOnly() && handleError) {
                return;
            }
        }
    }

    public void handleHeader(List<HttpHeader> list) {
        if (list == null) {
            return;
        }
        Iterator<FailoverStrategy> it = this.mFailoverStrategyList.iterator();
        while (it.hasNext()) {
            it.next().handleHeader(list);
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    private class DefaultIpChangeStrategyImpl implements FailoverStrategy {
        private boolean mIpChangeEnable;
        private boolean mHandleCurrentIpChangeHeader = false;
        private int mCurrentIpChangeCount = -1;
        private Set<String> mIpChangeErrorIps = new HashSet();

        @Override // com.ss.android.socialbase.downloader.downloader.NetworkFailoverStrategy.FailoverStrategy
        public boolean isFailoverOnly() {
            return true;
        }

        DefaultIpChangeStrategyImpl() {
            this.mIpChangeEnable = false;
            if (NetworkFailoverStrategy.this.mIpChangeCountLimit <= 0 || NetworkFailoverStrategy.this.mIpChangeErrorCodeSet.isEmpty()) {
                return;
            }
            this.mIpChangeEnable = true;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.NetworkFailoverStrategy.FailoverStrategy
        public boolean handleError(BaseException baseException) {
            boolean handleIpChangeError = handleIpChangeError(baseException);
            this.mHandleCurrentIpChangeHeader = handleIpChangeError;
            return handleIpChangeError;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.NetworkFailoverStrategy.FailoverStrategy
        public void handleHeader(List<HttpHeader> list) {
            handleIpChangeHeader(list);
        }

        private boolean handleIpChangeError(BaseException baseException) {
            if (!this.mIpChangeEnable || !(baseException instanceof DownloadTTNetException) || this.mCurrentIpChangeCount >= NetworkFailoverStrategy.this.mIpChangeCountLimit || !NetworkFailoverStrategy.this.mIpChangeErrorCodeSet.contains(Integer.valueOf(baseException.getErrorCode()))) {
                return false;
            }
            String remoteIp = ((DownloadTTNetException) baseException).getRemoteIp();
            if (this.mCurrentIpChangeCount < NetworkFailoverStrategy.this.mIpChangeCountLimit) {
                int i = this.mCurrentIpChangeCount + 1;
                this.mCurrentIpChangeCount = i;
                if (i == NetworkFailoverStrategy.this.mIpChangeCountLimit) {
                    if (Logger.debug()) {
                        Logger.taskDebug(NetworkFailoverStrategy.TAG, NetworkFailoverStrategy.this.mDownloadId, "handleIpChangeError", "CurrentIpChangeCount:" + this.mCurrentIpChangeCount + " mIpChangeCountLimit:" + NetworkFailoverStrategy.this.mIpChangeCountLimit);
                    }
                    return false;
                }
                if (!TextUtils.isEmpty(remoteIp)) {
                    this.mIpChangeErrorIps.add(remoteIp);
                    return true;
                }
                this.mIpChangeErrorIps.add(NetworkFailoverStrategy.FALLBACK_ERROR_IP);
                return true;
            }
            if (Logger.debug()) {
                Logger.taskDebug(NetworkFailoverStrategy.TAG, NetworkFailoverStrategy.this.mDownloadId, "handleIpChangeError", " RemoteIp:" + remoteIp + " currentIpChangeCount:" + this.mCurrentIpChangeCount + " errorCode:" + baseException.getErrorCode() + " mIpChangeErrorIps:" + this.mIpChangeErrorIps.toString());
            }
            return false;
        }

        private void handleIpChangeHeader(List<HttpHeader> list) {
            int i;
            if (!this.mIpChangeEnable || !this.mHandleCurrentIpChangeHeader || (i = this.mCurrentIpChangeCount) < 0 || i >= NetworkFailoverStrategy.this.mIpChangeCountLimit) {
                return;
            }
            this.mHandleCurrentIpChangeHeader = false;
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.mIpChangeErrorIps.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            if (Logger.debug()) {
                Logger.taskDebug(NetworkFailoverStrategy.TAG, NetworkFailoverStrategy.this.mDownloadId, "handleIpChangeHeader", "Add extra_ttnet_change_ip:" + sb.toString());
            }
            list.add(new HttpHeader(DownloadConstants.EXTRA_TTNET_CHANGE_IP, sb.toString()));
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    private class IsolationIpChangeStrategyImpl extends DefaultIpChangeStrategyImpl {
        private boolean mHandleCurrentIsolationHeader;
        private boolean mIsolationEnable;
        private int mIsolationIndex;

        IsolationIpChangeStrategyImpl() {
            super();
            this.mIsolationEnable = false;
            this.mHandleCurrentIsolationHeader = false;
            this.mIsolationIndex = -1;
            if (NetworkFailoverStrategy.this.mIsolationCount <= 0 || NetworkFailoverStrategy.this.mIsolationErrorCodeSet.isEmpty()) {
                return;
            }
            this.mIsolationEnable = true;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.NetworkFailoverStrategy.DefaultIpChangeStrategyImpl, com.ss.android.socialbase.downloader.downloader.NetworkFailoverStrategy.FailoverStrategy
        public boolean handleError(BaseException baseException) {
            boolean handleIsolationError = handleIsolationError(baseException);
            this.mHandleCurrentIsolationHeader = handleIsolationError;
            if (handleIsolationError) {
                super.handleError(baseException);
            }
            return this.mHandleCurrentIsolationHeader;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.NetworkFailoverStrategy.DefaultIpChangeStrategyImpl, com.ss.android.socialbase.downloader.downloader.NetworkFailoverStrategy.FailoverStrategy
        public void handleHeader(List<HttpHeader> list) {
            if (handleIsolationHeader(list)) {
                super.handleHeader(list);
            }
        }

        private boolean handleIsolationError(BaseException baseException) {
            if (this.mIsolationEnable && this.mIsolationIndex < NetworkFailoverStrategy.this.mIsolationCount) {
                boolean contains = NetworkFailoverStrategy.this.mIsolationErrorCodeSet.contains(Integer.valueOf(baseException.getErrorCode()));
                if (contains) {
                    int i = this.mIsolationIndex + 1;
                    this.mIsolationIndex = i;
                    if (i != NetworkFailoverStrategy.this.mIsolationCount) {
                        return true;
                    }
                    if (Logger.debug()) {
                        Logger.taskDebug(NetworkFailoverStrategy.TAG, NetworkFailoverStrategy.this.mDownloadId, "handleIsolationError", "IsolationCount" + NetworkFailoverStrategy.this.mIsolationCount + " ttnetIsolationIndex:" + this.mIsolationIndex + " errorCode:" + baseException.getErrorCode());
                    }
                    return false;
                }
                if (Logger.debug()) {
                    Logger.taskDebug(NetworkFailoverStrategy.TAG, NetworkFailoverStrategy.this.mDownloadId, "handleIsolationError", "IsMatch" + contains + " ttnetIsolationIndex:" + this.mIsolationIndex + " errorCode:" + baseException.getErrorCode());
                }
            }
            return false;
        }

        private boolean handleIsolationHeader(List<HttpHeader> list) {
            int i;
            if (!this.mIsolationEnable || !this.mHandleCurrentIsolationHeader || (i = this.mIsolationIndex) < 0 || i >= NetworkFailoverStrategy.this.mIsolationCount) {
                return false;
            }
            this.mHandleCurrentIsolationHeader = false;
            if (Logger.debug()) {
                Logger.taskDebug(NetworkFailoverStrategy.TAG, NetworkFailoverStrategy.this.mDownloadId, "handleIsolationHeader", "Add handleIsolationHeader: https://dl");
            }
            list.add(new HttpHeader(NetworkFailoverStrategy.TTNET_ISOLATION_HEADER_KEY, NetworkFailoverStrategy.TTNET_ISOLATION_HEADER_VALUE));
            if (NetworkFailoverStrategy.this.mIsolationHttpProtoType <= 0) {
                return true;
            }
            if (Logger.debug()) {
                Logger.taskDebug(NetworkFailoverStrategy.TAG, NetworkFailoverStrategy.this.mDownloadId, "handleIsolationHeader", "Add x-ttnet-http-proto-type: " + NetworkFailoverStrategy.this.mIsolationHttpProtoType);
            }
            DownloadHelper.removeHeaderKey(list, DownloadHelper.TTNET_PROTO_TYPE);
            list.add(new HttpHeader(DownloadHelper.TTNET_PROTO_TYPE, String.valueOf(NetworkFailoverStrategy.this.mIsolationHttpProtoType)));
            return true;
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    private class BackHostStrategyImpl implements FailoverStrategy {
        private boolean mBackHostEnable;
        private boolean mHandleCurrentBackHostHeader = false;
        private int mCurrentBackHostCount = -1;

        @Override // com.ss.android.socialbase.downloader.downloader.NetworkFailoverStrategy.FailoverStrategy
        public boolean isFailoverOnly() {
            return true;
        }

        BackHostStrategyImpl() {
            this.mBackHostEnable = false;
            if (NetworkFailoverStrategy.this.mBackHostCountLimit <= 0 || NetworkFailoverStrategy.this.mBackHostList.isEmpty()) {
                return;
            }
            this.mBackHostEnable = true;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.NetworkFailoverStrategy.FailoverStrategy
        public boolean handleError(BaseException baseException) {
            boolean handleBackHostError = handleBackHostError(baseException);
            this.mHandleCurrentBackHostHeader = handleBackHostError;
            return handleBackHostError;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.NetworkFailoverStrategy.FailoverStrategy
        public void handleHeader(List<HttpHeader> list) {
            handleBackHostHeader(list);
        }

        private boolean handleBackHostError(BaseException baseException) {
            if (this.mBackHostEnable && this.mCurrentBackHostCount < NetworkFailoverStrategy.this.mBackHostCountLimit) {
                boolean z = NetworkFailoverStrategy.this.mBackHostErrorCodeSet.isEmpty() || NetworkFailoverStrategy.this.mBackHostErrorCodeSet.contains(Integer.valueOf(baseException.getErrorCode()));
                if (z) {
                    int i = this.mCurrentBackHostCount + 1;
                    this.mCurrentBackHostCount = i;
                    if (i != NetworkFailoverStrategy.this.mBackHostCountLimit) {
                        return true;
                    }
                    if (Logger.debug()) {
                        Logger.taskDebug(NetworkFailoverStrategy.TAG, NetworkFailoverStrategy.this.mDownloadId, "handleBackHostError", "BackHostCountLimit" + NetworkFailoverStrategy.this.mBackHostCountLimit + " currentBackHostCount:" + this.mCurrentBackHostCount + " errorCode:" + baseException.getErrorCode());
                    }
                    return false;
                }
                if (Logger.debug()) {
                    Logger.taskDebug(NetworkFailoverStrategy.TAG, NetworkFailoverStrategy.this.mDownloadId, "handleBackHostError", "IsMatch" + z + " BackHostCountLimit:" + NetworkFailoverStrategy.this.mBackHostCountLimit + " errorCode:" + baseException.getErrorCode());
                }
            }
            return false;
        }

        private void handleBackHostHeader(List<HttpHeader> list) {
            int i;
            if (!this.mBackHostEnable || !this.mHandleCurrentBackHostHeader || (i = this.mCurrentBackHostCount) < 0 || i >= NetworkFailoverStrategy.this.mBackHostCountLimit) {
                return;
            }
            this.mHandleCurrentBackHostHeader = false;
            String str = (String) NetworkFailoverStrategy.this.mBackHostList.get(this.mCurrentBackHostCount % NetworkFailoverStrategy.this.mBackHostList.size());
            if (Logger.debug()) {
                Logger.taskDebug(NetworkFailoverStrategy.TAG, NetworkFailoverStrategy.this.mDownloadId, "handleBackHostHeader", "Add BackHost Header: " + str);
            }
            list.add(new HttpHeader(DownloadConstants.EXTRA_TTNET_BACK_HOST, str));
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    private class TimeoutStrategyImpl implements FailoverStrategy {
        private boolean mTimeoutEnable;
        private int mTimeoutIndex = -1;

        @Override // com.ss.android.socialbase.downloader.downloader.NetworkFailoverStrategy.FailoverStrategy
        public boolean isFailoverOnly() {
            return false;
        }

        TimeoutStrategyImpl() {
            this.mTimeoutEnable = false;
            if (NetworkFailoverStrategy.this.mTimeoutErrorCodeSet.isEmpty()) {
                return;
            }
            if (NetworkFailoverStrategy.this.mIoTimeoutList.isEmpty() && NetworkFailoverStrategy.this.mConnectTimeoutList.isEmpty()) {
                return;
            }
            this.mTimeoutEnable = true;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.NetworkFailoverStrategy.FailoverStrategy
        public boolean handleError(BaseException baseException) {
            return handleTimeoutError(baseException);
        }

        @Override // com.ss.android.socialbase.downloader.downloader.NetworkFailoverStrategy.FailoverStrategy
        public void handleHeader(List<HttpHeader> list) {
            handleTimeoutHeader(list);
        }

        private boolean handleTimeoutError(BaseException baseException) {
            if (!this.mTimeoutEnable) {
                return false;
            }
            boolean contains = NetworkFailoverStrategy.this.mTimeoutErrorCodeSet.contains(Integer.valueOf(baseException.getErrorCode()));
            if (contains) {
                this.mTimeoutIndex++;
                return true;
            }
            if (Logger.debug()) {
                Logger.taskDebug(NetworkFailoverStrategy.TAG, NetworkFailoverStrategy.this.mDownloadId, "handleTimeoutError", "IsMatch:" + contains + " ttnetTimeoutIndex:" + this.mTimeoutIndex + " errorCode:" + baseException.getErrorCode());
            }
            return false;
        }

        private void handleTimeoutHeader(List<HttpHeader> list) {
            int size;
            int size2;
            if (!this.mTimeoutEnable || this.mTimeoutIndex < 0) {
                return;
            }
            if (!NetworkFailoverStrategy.this.mConnectTimeoutList.isEmpty()) {
                if (this.mTimeoutIndex >= NetworkFailoverStrategy.this.mConnectTimeoutList.size()) {
                    size2 = NetworkFailoverStrategy.this.mConnectTimeoutList.size() - 1;
                } else {
                    size2 = this.mTimeoutIndex;
                }
                String valueOf = String.valueOf(NetworkFailoverStrategy.this.mConnectTimeoutList.get(size2));
                if (Logger.debug()) {
                    Logger.taskDebug(NetworkFailoverStrategy.TAG, NetworkFailoverStrategy.this.mDownloadId, "handleTimeoutHeader", "Add ConnectTimeout:" + valueOf);
                }
                list.add(new HttpHeader(DownloadConstants.EXTRA_TTNET_CONNECT_TIMEOUT, valueOf));
            }
            if (NetworkFailoverStrategy.this.mIoTimeoutList.isEmpty()) {
                return;
            }
            if (this.mTimeoutIndex >= NetworkFailoverStrategy.this.mIoTimeoutList.size()) {
                size = NetworkFailoverStrategy.this.mIoTimeoutList.size() - 1;
            } else {
                size = this.mTimeoutIndex;
            }
            String valueOf2 = String.valueOf(NetworkFailoverStrategy.this.mIoTimeoutList.get(size));
            if (Logger.debug()) {
                Logger.taskDebug(NetworkFailoverStrategy.TAG, NetworkFailoverStrategy.this.mDownloadId, "handleTimeoutHeader", "Add IoTimeout:" + valueOf2);
            }
            list.add(new HttpHeader(DownloadConstants.EXTRA_TTNET_IO_TIMEOUT, valueOf2));
        }
    }
}
