package okhttp3.ttnet;

import android.text.TextUtils;
import com.ttnet.org.chromium.net.NetError;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.BindException;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;

/* loaded from: classes8.dex */
public class TTNetUtils {
    public static int convertExceptionToErrorCode(IOException iOException) {
        if (iOException instanceof SSLHandshakeException) {
            return NetError.ERR_SSL_HANDSHAKE_NOT_COMPLETED;
        }
        if (iOException instanceof SSLKeyException) {
            return NetError.ERR_SSL_BAD_PEER_PUBLIC_KEY;
        }
        if (iOException instanceof SSLProtocolException) {
            return NetError.ERR_SSL_PROTOCOL_ERROR;
        }
        if (iOException instanceof SSLPeerUnverifiedException) {
            return NetError.ERR_SSL_DECRYPT_ERROR_ALERT;
        }
        if (iOException instanceof UnknownHostException) {
            return NetError.ERR_NAME_NOT_RESOLVED;
        }
        if (iOException instanceof ConnectException) {
            return convertConnectException(iOException, NetError.ERR_CONNECTION_FAILED);
        }
        if (iOException instanceof PortUnreachableException) {
            return NetError.ERR_ADDRESS_INVALID;
        }
        if (iOException instanceof NoRouteToHostException) {
            return NetError.ERR_ADDRESS_UNREACHABLE;
        }
        if (iOException instanceof BindException) {
            return NetError.ERR_ADDRESS_IN_USE;
        }
        if (iOException instanceof SocketException) {
            return convertConnectException(iOException, -15);
        }
        if (iOException instanceof MalformedURLException) {
            return -300;
        }
        if (iOException instanceof SocketTimeoutException) {
            return NetError.ERR_CONNECTION_TIMED_OUT;
        }
        if (iOException instanceof ProtocolException) {
            return -901;
        }
        if (iOException instanceof HttpRetryException) {
            String message = iOException.getMessage();
            return (TextUtils.isEmpty(message) || !message.contains("Too many follow-up requests")) ? NetError.ERR_TTNET_UNSUPPORTED_REDIRECT : NetError.ERR_TOO_MANY_REDIRECTS;
        }
        if (iOException instanceof UnknownServiceException) {
            return -902;
        }
        if (iOException != null && "Canceled#Reason=-199".equals(iOException.getMessage())) {
            return TTOkHttpConstants.ERR_TTNET_APP_TIMED_OUT;
        }
        if (isRequestTimeout(iOException)) {
            return TTOkHttpConstants.ERR_TTNET_REQUEST_TIMED_OUT;
        }
        return -1;
    }

    private static int convertConnectException(IOException iOException, int i) {
        if (iOException == null) {
            return i;
        }
        try {
            int convertConnectionExceptionInternal = convertConnectionExceptionInternal(iOException.getMessage(), i);
            if (convertConnectionExceptionInternal != i) {
                return convertConnectionExceptionInternal;
            }
            try {
                Throwable cause = iOException.getCause();
                if (cause == null) {
                    return convertConnectionExceptionInternal;
                }
                String message = cause.getMessage();
                return TextUtils.isEmpty(message) ? convertConnectionExceptionInternal : convertConnectionExceptionInternal(message, i);
            } catch (Throwable unused) {
                i = convertConnectionExceptionInternal;
                return i;
            }
        } catch (Throwable unused2) {
        }
    }

    private static int convertConnectionExceptionInternal(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        if (str.contains("ECONNRESET") || str.contains("Connection reset") || str.contains("reset by peer")) {
            return -101;
        }
        if (str.contains("ECONNREFUSED")) {
            return -102;
        }
        if (str.contains("CONNECTION_ABORTED") || str.contains("connection abort")) {
            return -103;
        }
        return (str.contains("ENETDOWN") || str.contains("Network is unreachable")) ? NetError.ERR_INTERNET_DISCONNECTED : (str.contains("EHOSTUNREACH") || str.contains("ENETUNREACH")) ? NetError.ERR_ADDRESS_UNREACHABLE : str.contains("EADDRNOTAVAIL") ? NetError.ERR_ADDRESS_INVALID : str.contains("EADDRINUSE") ? NetError.ERR_ADDRESS_IN_USE : i;
    }

    public static boolean isRequestTimeout(IOException iOException) {
        Throwable cause;
        if (iOException == null) {
            return false;
        }
        if ("Canceled#Reason=-192".equals(iOException.getMessage())) {
            return true;
        }
        return (iOException instanceof InterruptedIOException) && (cause = iOException.getCause()) != null && !TextUtils.isEmpty(cause.getMessage()) && "Canceled#Reason=-192".equals(cause.getMessage());
    }
}
