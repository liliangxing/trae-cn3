package com.ss.android.socialbase.downloader.service;

import com.ss.android.socialbase.downloader.downloader.IDownloadIdGenerator;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public interface IDownloadIdGeneratorService extends IDownloadIdGenerator {

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class DefaultDownloadIdGeneratorService implements IDownloadIdGeneratorService {
        @Override // com.ss.android.socialbase.downloader.service.IDownloadIdGeneratorService
        public int generate(DownloadInfo downloadInfo) {
            return 0;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadIdGenerator
        public int generate(String str, String str2) {
            return 0;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadIdGeneratorService, com.ss.android.socialbase.downloader.downloader.IDownloadIdGenerator
        public boolean isDefaultIdGenerator() {
            return true;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadIdGeneratorService
        public void setDownloadIdGenerator(IDownloadIdGenerator iDownloadIdGenerator) {
        }
    }

    int generate(DownloadInfo downloadInfo);

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadIdGenerator
    boolean isDefaultIdGenerator();

    void setDownloadIdGenerator(IDownloadIdGenerator iDownloadIdGenerator);
}
