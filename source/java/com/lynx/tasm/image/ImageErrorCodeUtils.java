package com.lynx.tasm.image;

import com.bytedance.trae.im.model.ConfirmInfo;
import com.lynx.tasm.LynxSubErrorCode;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.BindException;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import org.apache.http.conn.ConnectTimeoutException;

/* loaded from: classes7.dex */
public class ImageErrorCodeUtils {
    public static final int LYNX_IMAGE_BIND_EXCEPTION = 1104;
    public static final String LYNX_IMAGE_CATEGORIZED_CODE_KEY = "lynx_categorized_code";
    public static final int LYNX_IMAGE_CONNECT_EXCEPTION = 1103;
    public static final int LYNX_IMAGE_CONNECT_TIMEOUT_EXCEPTION = 1101;
    public static final int LYNX_IMAGE_DECODE_ARGUMENT_EXCEPTION = 1201;
    public static final int LYNX_IMAGE_DECODE_RUNTIME_EXCEPTION = 1203;
    public static final int LYNX_IMAGE_DECODE_STATE_EXCEPTION = 1202;
    public static final String LYNX_IMAGE_ERROR_CODE_KEY = "error_code";
    public static final int LYNX_IMAGE_FILE_NOT_FOUND_EXCEPTION = 1205;
    public static final int LYNX_IMAGE_IO_EXCEPTION = 1206;
    public static final int LYNX_IMAGE_NETWORK_NOT_AVAILABLE = 1002;
    public static final int LYNX_IMAGE_NO_ROUTE_TO_HOST_EXCEPTION = 1105;
    public static final int LYNX_IMAGE_PIC_SOURCE_INTERVAL_END = 1300;
    public static final int LYNX_IMAGE_PIC_SOURCE_INTERVAL_START = 1200;
    public static final int LYNX_IMAGE_PORT_UNREACHABLE_EXCEPTION = 1106;
    public static final int LYNX_IMAGE_SOCKET_EXCEPTION = 1108;
    public static final int LYNX_IMAGE_SOCKET_TIMEOUT_EXCEPTION = 1102;
    public static final int LYNX_IMAGE_STATUS_CANCEL = 1001;
    public static final int LYNX_IMAGE_THREAD_INTERRUPTED_EXCEPTION = 1204;
    public static final int LYNX_IMAGE_TTNET_INTERVAL_END = 1200;
    public static final int LYNX_IMAGE_TTNET_INTERVAL_START = 1100;
    public static final int LYNX_IMAGE_UNKNOWN_EXCEPTION = -1;
    public static final int LYNX_IMAGE_UNKNOWN_HOST_EXCEPTION = 1107;
    public static final int LYNX_IMAGE_USER_OR_DESIGN_INTERVAL_END = 1100;
    public static final int LYNX_IMAGE_USER_OR_DESIGN_INTERVAL_START = 1000;

    public static int checkImageExceptionCategory(int i) {
        return (i < 1000 || i >= 1100) ? ((i < 1100 || i >= 1200) && i >= 1200 && i < 1300) ? LynxSubErrorCode.E_RESOURCE_IMAGE_PIC_SOURCE : LynxSubErrorCode.E_RESOURCE_IMAGE_FROM_NETWORK_OR_OTHERS : LynxSubErrorCode.E_RESOURCE_IMAGE_FROM_USER_OR_DESIGN;
    }

    public static int checkImageException(Throwable th) {
        if (th == null) {
            return -1;
        }
        if (th instanceof ConnectTimeoutException) {
            return 1101;
        }
        if (th instanceof SocketTimeoutException) {
            return 1102;
        }
        if (th instanceof ConnectException) {
            return 1103;
        }
        if (th instanceof BindException) {
            return 1104;
        }
        if (th instanceof NoRouteToHostException) {
            return 1105;
        }
        if (th instanceof PortUnreachableException) {
            return 1106;
        }
        if (th instanceof UnknownHostException) {
            return 1107;
        }
        if (th instanceof SocketException) {
            return 1108;
        }
        if (th instanceof IllegalArgumentException) {
            return 1201;
        }
        if (th instanceof IllegalStateException) {
            return 1202;
        }
        if (th instanceof RuntimeException) {
            return 1203;
        }
        if (th instanceof InterruptedException) {
            return 1204;
        }
        if (th instanceof FileNotFoundException) {
            return 1205;
        }
        if (!(th instanceof IOException)) {
            return -1;
        }
        String message = th.getMessage();
        if (message != null && message.length() != 0) {
            if (message.contains(ConfirmInfo.STATUS_CANCELED) || message.contains("Canceled")) {
                return 1001;
            }
            if (message.contains("network not available")) {
                return 1002;
            }
        }
        return 1206;
    }
}
