package com.ss.android.socialbase.downloader.service;

import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.MultiProcCreater;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DownloadMultiProcService implements IDownloadMultiProcService {
    @Override // com.ss.android.socialbase.downloader.service.IDownloadMultiProcService
    public void registerIndependentServiceCreator() {
        DownloadComponentManager.setIndependentServiceCreator(new MultiProcCreater());
    }
}
