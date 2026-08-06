package com.lynx.animax.loader;

import com.lynx.animax.base.Status;
import com.lynx.animax.util.UnzipUtil;

/* loaded from: classes6.dex */
public class AnimaXUnzipLoader {

    /* loaded from: classes6.dex */
    public static class UnzipResult {
        private String error;
        private String path;

        public UnzipResult(String str, String str2) {
            this.error = str;
            this.path = str2;
        }

        public String getError() {
            return this.error;
        }

        public String getPath() {
            return this.path;
        }

        public void setError(String str) {
            this.error = str;
        }

        public void setPath(String str) {
            this.path = str;
        }
    }

    public static String getError(UnzipResult unzipResult) {
        return unzipResult.getError();
    }

    public static String getPath(UnzipResult unzipResult) {
        return unzipResult.getPath();
    }

    public static UnzipResult unzip(String str, String str2) {
        if (str == null || str.isEmpty()) {
            return new UnzipResult("ZippedFilePath is null.", null);
        }
        if (str2 == null || str2.isEmpty()) {
            return new UnzipResult("UnzippedFilePath is null.", null);
        }
        Status unzip = UnzipUtil.unzip(str, str2);
        if (!unzip.mSuccess) {
            return new UnzipResult(unzip.mErrMsg, null);
        }
        return new UnzipResult(null, str2);
    }
}
