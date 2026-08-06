package com.lynx.jsbridge.network;

import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.tasm.gesture.handler.GestureConstants;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes6.dex */
public class HttpStreamingDelegate {
    static final String ERROR_STREAMING_MALFORMED_RESPONSE = "errorStreamingMalformedResponse";
    private final LynxFetchModuleEventSender mSender;
    private final String mStringId;

    public HttpStreamingDelegate(String str, LynxFetchModuleEventSender lynxFetchModuleEventSender) {
        this.mStringId = str;
        this.mSender = lynxFetchModuleEventSender;
    }

    public void onData(byte[] bArr) {
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        javaOnlyMap.putString("event", "onData");
        javaOnlyMap.putByteArray("data", bArr);
        JavaOnlyArray javaOnlyArray = new JavaOnlyArray();
        javaOnlyArray.pushMap(javaOnlyMap);
        this.mSender.sendGlobalEvent(this.mStringId, javaOnlyArray);
    }

    public void onEnd() {
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        javaOnlyMap.putString("event", GestureConstants.ON_END);
        JavaOnlyArray javaOnlyArray = new JavaOnlyArray();
        javaOnlyArray.pushMap(javaOnlyMap);
        this.mSender.sendGlobalEvent(this.mStringId, javaOnlyArray);
    }

    public void onError(String str) {
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        javaOnlyMap.putString("event", "onError");
        javaOnlyMap.putString("error", str);
        JavaOnlyArray javaOnlyArray = new JavaOnlyArray();
        javaOnlyArray.pushMap(javaOnlyMap);
        this.mSender.sendGlobalEvent(this.mStringId, javaOnlyArray);
    }

    int getStreamingBytesToRead(BufferedInputStream bufferedInputStream, StringBuilder sb) throws IOException {
        int read;
        while (true) {
            read = bufferedInputStream.read();
            if (read == -1 || read == 13) {
                break;
            }
            sb.append((char) read);
        }
        if (read != 13 || bufferedInputStream.read() != 10) {
            onError(ERROR_STREAMING_MALFORMED_RESPONSE);
            return -1;
        }
        String sb2 = sb.toString();
        sb.setLength(0);
        return Integer.parseInt(sb2, 16);
    }

    byte[] getStreamingChunk(int i, BufferedInputStream bufferedInputStream) throws IOException {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int read = bufferedInputStream.read(bArr, i2, i - i2);
            if (read == -1) {
                break;
            }
            i2 += read;
        }
        if (i2 == i && bufferedInputStream.read() == 13 && bufferedInputStream.read() == 10) {
            return bArr;
        }
        onError(ERROR_STREAMING_MALFORMED_RESPONSE);
        return new byte[0];
    }

    public void streamingBodySSE(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int i = -1;
            while (true) {
                int read = inputStream.read();
                if (read == -1) {
                    return;
                }
                byteArrayOutputStream.write(read);
                if (i != 10 || read != 10) {
                    i = read;
                }
            }
            onData(byteArrayOutputStream.toByteArray());
            byteArrayOutputStream.reset();
        }
    }

    public void streamingBody(InputStream inputStream) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        StringBuilder sb = new StringBuilder();
        while (true) {
            int streamingBytesToRead = getStreamingBytesToRead(bufferedInputStream, sb);
            if (streamingBytesToRead <= 0) {
                break;
            }
            byte[] streamingChunk = getStreamingChunk(streamingBytesToRead, bufferedInputStream);
            if (streamingChunk.length == 0) {
                break;
            } else {
                onData(streamingChunk);
            }
        }
        bufferedInputStream.close();
    }
}
