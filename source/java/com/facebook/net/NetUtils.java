package com.facebook.net;

import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import com.facebook.imagepipeline.exception.BDErrorCodeConst;
import com.facebook.imagepipeline.exception.BDException;
import com.facebook.imagepipeline.net.ExpiredUrlException;
import com.ttnet.org.chromium.net.impl.NetworkExceptionImpl;
import java.io.IOException;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class NetUtils {
    public static final int SC_BIND_EXCEPTION = 7;
    public static final int SC_CANCEL = 40;
    public static final int SC_CLIENT_PROTOCOL_EXCEPTION = 19;
    public static final int SC_CONNECT_EXCEPTION = 8;
    public static final int SC_CONNECT_TIMEOUT = 2;
    public static final int SC_EACCES = 36;
    public static final int SC_EADDRINUSE = 17;
    public static final int SC_EADDRNOTAVAIL = 16;
    public static final int SC_ECONNREFUSED = 13;
    public static final int SC_ECONNRESET = 12;
    public static final int SC_EDQUOT = 34;
    public static final int SC_EHOSTUNREACH = 14;
    public static final int SC_EIO = 37;
    public static final int SC_ENETUNREACH = 15;
    public static final int SC_ENOENT = 33;
    public static final int SC_EROFS = 35;
    public static final int SC_EXPIRED_URL_EXCEPTION = 43;
    public static final int SC_FILE_TOO_LARGE = 20;
    public static final int SC_IO_EXCEPTION = 4;
    public static final int SC_NO_HTTP_RESPONSE = 18;
    public static final int SC_NO_NETWORK = 41;
    public static final int SC_NO_REOUTE_TO_HOST = 9;
    public static final int SC_NO_SPACE = 32;
    public static final int SC_PORT_UNREACHABLE = 10;
    public static final int SC_RESET_BY_PEER = 6;
    public static final int SC_SOCKET_EXCEPTION = 5;
    public static final int SC_SOCKET_TIMEOUT = 3;
    public static final int SC_UNKNOWN = 1;
    public static final int SC_UNKNOWN_HOST = 11;
    public static final String TAG = "NetUtils";

    private NetUtils() {
    }

    public static int checkHttpRequestException(Throwable th, String[] strArr) {
        return checkHttpRequestException(th);
    }

    public static int checkHttpRequestException(Throwable th) {
        if (th instanceof ExpiredUrlException) {
            return 43;
        }
        if ((th instanceof IOException) && th.getMessage() != null && th.getMessage().contains(BDErrorCodeConst.BD_ERROR_MSG_REQUEST_CANCELED)) {
            return BDErrorCodeConst.BD_ERROR_CODE_REQUEST_CANCELED;
        }
        if (th instanceof HttpResponseException) {
            return BDErrorCodeConst.BD_ERROR_CODE_SERVER_RESPONSE_ERROR;
        }
        if (th instanceof NetworkExceptionImpl) {
            return ((NetworkExceptionImpl) th).getCronetInternalErrorCode();
        }
        if (th instanceof CronetIOException) {
            CronetIOException cronetIOException = (CronetIOException) th;
            return cronetIOException.getStatusCode() != 0 ? BDErrorCodeConst.BD_ERROR_CODE_SERVER_RESPONSE_ERROR : cronetIOException.getCronetInternalErrorCode();
        }
        if (th instanceof NetworkNotAvailabeException) {
            return ((NetworkNotAvailabeException) th).getCronetInternalErrorCode();
        }
        if (th instanceof BDException) {
            return ((BDException) th).getErrorCode();
        }
        return 1;
    }
}
