package com.lynx.animax.util;

import com.bytedance.forest.utils.OfflineUtil;
import com.lynx.tasm.provider.LynxResResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class LynxResourceUtil {
    private static final String TAG = "LynxResourceUtil";

    public static int getLynxResResponseContentLength(LynxResResponse lynxResResponse) {
        List<String> list;
        Map<String, List<String>> responseHeaders = lynxResResponse.getResponseHeaders();
        if (responseHeaders == null || (list = responseHeaders.get(OfflineUtil.CONTENT_LENGTH_HEADER)) == null || list.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(list.get(0));
    }

    public static int getTotalLengthForLynxResResponse(LynxResResponse lynxResResponse) {
        InputStream inputStream = lynxResResponse.getInputStream();
        int i = 0;
        if (inputStream == null) {
            return 0;
        }
        try {
            i = inputStream.available();
        } catch (IOException unused) {
        }
        int lynxResResponseContentLength = getLynxResResponseContentLength(lynxResResponse);
        if (i > 0) {
            return i;
        }
        AnimaXLog.i(TAG, "no length from stream, responseContentLength = " + lynxResResponseContentLength);
        return lynxResResponseContentLength > 0 ? lynxResResponseContentLength : i;
    }

    public static boolean saveFileFromLynxResResponse(LynxResResponse lynxResResponse, String str) {
        return StreamUtil.saveFileFromInputStream(lynxResResponse.getInputStream(), getTotalLengthForLynxResResponse(lynxResResponse), str);
    }

    public static byte[] getByteArrayFromLynxResResponse(LynxResResponse lynxResResponse) {
        return StreamUtil.getByteArrayFromInputStream(lynxResResponse.getInputStream(), getTotalLengthForLynxResResponse(lynxResResponse));
    }
}
