package com.ss.android.socialbase.downloader.service;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHttpService;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DownloadNetworkService implements IDownloadNetworkService {
    @Override // com.ss.android.socialbase.downloader.service.IDownloadNetworkService
    public IDownloadHttpConnection downloadWithConnection(boolean z, int i, String str, List<HttpHeader> list) throws Exception {
        return downloadWithConnection(z, i, str, null, list, 0, false, null);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNetworkService
    public IDownloadHttpConnection downloadWithConnection(boolean z, int i, String str, String str2, List<HttpHeader> list, int i2, boolean z2, DownloadInfo downloadInfo) throws Exception {
        List<HttpHeader> list2;
        int i3;
        IDownloadHttpConnection downloadWithConnectionImpl;
        if (!TextUtils.isEmpty(str2)) {
            List<HttpHeader> arrayList = list == null ? new ArrayList<>() : list;
            arrayList.add(new HttpHeader(DownloadConstants.EXTRA_REQUEST_HOST_IP, str2));
            if (enableTTNetIpRequest(downloadInfo)) {
                list2 = arrayList;
                i3 = i2;
            } else {
                list2 = arrayList;
                i3 = 1;
            }
        } else if (z) {
            list2 = list;
            i3 = i2;
        } else {
            i3 = 2;
            list2 = list;
        }
        int[] downloadNetLibs = getDownloadNetLibs(i3);
        int length = downloadNetLibs.length;
        int i4 = 0;
        Exception exc = null;
        while (i4 < length) {
            int i5 = i4;
            try {
                downloadWithConnectionImpl = downloadWithConnectionImpl(i, str, str2, list2, downloadNetLibs[i4], z2, downloadInfo);
            } catch (Exception e) {
                if (downloadInfo != null && downloadInfo.isExpiredRedownload() && DownloadUtils.isResponseCode304Error(e) && DownloadUtils.hasDownloadCacheHeader(list2)) {
                    throw e;
                }
                exc = e;
            }
            if (downloadWithConnectionImpl != null) {
                return downloadWithConnectionImpl;
            }
            i4 = i5 + 1;
        }
        if (exc == null) {
            return null;
        }
        throw exc;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private IDownloadHttpConnection downloadWithConnectionImpl(int i, String str, String str2, List<HttpHeader> list, int i2, boolean z, DownloadInfo downloadInfo) throws BaseException, IOException {
        IOException iOException;
        IDownloadHttpService httpServiceInternal = getHttpServiceInternal(i2);
        if (httpServiceInternal == null) {
            throw new BaseException(1022, new IOException("httpService not exist, netLib = " + i2));
        }
        IOException iOException2 = null;
        long j = 0;
        if (z) {
            try {
                j = System.currentTimeMillis();
            } catch (IOException e) {
                e = e;
                iOException = e;
                try {
                    throw iOException;
                } catch (Throwable th) {
                    th = th;
                    iOException2 = iOException;
                    if (z) {
                        DownloadMonitorHelper.monitorDownloadConnect(null, str, str2, System.currentTimeMillis() - j, MonitorConstants.CONNECT_TYPE_GET, i2, iOException2, downloadInfo);
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                if (z) {
                }
                throw th;
            }
        }
        try {
            IDownloadHttpConnection downloadWithConnection = httpServiceInternal.downloadWithConnection(i, str, list);
            if (z) {
                DownloadMonitorHelper.monitorDownloadConnect(downloadWithConnection, str, str2, System.currentTimeMillis() - j, MonitorConstants.CONNECT_TYPE_GET, i2, null, downloadInfo);
            }
            return downloadWithConnection;
        } catch (IOException e2) {
            e = e2;
            iOException = e;
            throw iOException;
        } catch (Throwable th3) {
            th = th3;
            if (z) {
            }
            throw th;
        }
    }

    private IDownloadHttpService getHttpServiceInternal(int i) {
        if (2 == i) {
            IDownloadHttpService httpService = DownloadComponentManager.getHttpService();
            return httpService != null ? httpService : DownloadComponentManager.getDefaultHttpService();
        }
        if (i == 1) {
            return DownloadComponentManager.getHttpService();
        }
        return DownloadComponentManager.getDefaultHttpService();
    }

    private int[] getDownloadNetLibs(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 5 ? new int[]{1, 0} : new int[]{2} : new int[]{0, 1} : new int[]{1} : new int[]{0};
    }

    private boolean enableTTNetIpRequest(DownloadInfo downloadInfo) {
        JSONObject optJSONObject;
        return (downloadInfo == null || (optJSONObject = DownloadSetting.obtain(downloadInfo.getId()).optJSONObject(DownloadSettingKeys.SEGMENT_CONFIG)) == null || optJSONObject.optInt(DownloadSettingKeys.SegmentConfig.ENABLE_TTNET_IP_REQUEST, 0) <= 0) ? false : true;
    }
}
