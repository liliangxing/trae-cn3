package com.bytedance.common.wschannel.channel.impl.p007ok.ws;

import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsChannelSettings;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.channel.impl.p007ok.ws.WebSocketReader;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.ws.RealWebSocket;
import okio.BufferedSink;
import okio.ByteString;
import okio.Okio;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class CustomHeartBeatRealWebSocket implements CustomHeartBeatWebSocket, WebSocketReader.FrameCallback {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long CANCEL_AFTER_CLOSE_MILLIS = 60000;
    private static final long MAX_QUEUE_SIZE = 16777216;
    private static final List<Protocol> ONLY_HTTP1 = Collections.singletonList(Protocol.HTTP_1_1);
    private boolean awaitingPong;
    private Call call;
    private ScheduledFuture<?> cancelFuture;
    private boolean enqueuedClose;
    private ScheduledExecutorService executor;
    private boolean failed;
    private final long ioLimitLength;
    private final String key;
    private WebSocketListener listener;
    private final Request originalRequest;
    private long queueSize;
    private final Random random;
    private WebSocketReader reader;
    private String receivedCloseReason;
    private int receivedPingCount;
    private int receivedPongCount;
    private int sentPingCount;
    private RealWebSocket.Streams streams;
    private WebSocketWriter writer;
    private final Runnable writerRunnable;
    private final ArrayDeque<ByteString> pongQueue = new ArrayDeque<>();
    private final ArrayDeque<Object> messageAndCloseQueue = new ArrayDeque<>();
    private int receivedCloseCode = -1;

    public CustomHeartBeatRealWebSocket(Request request, long j, WebSocketListener webSocketListener, Random random) {
        if (!"GET".equals(request.method())) {
            throw new IllegalArgumentException("Request must be GET: " + request.method());
        }
        this.originalRequest = request;
        this.listener = webSocketListener;
        this.random = random;
        this.ioLimitLength = j;
        byte[] bArr = new byte[16];
        random.nextBytes(bArr);
        this.key = ByteString.of(bArr).base64();
        this.writerRunnable = new Runnable() { // from class: com.bytedance.common.wschannel.channel.impl.ok.ws.CustomHeartBeatRealWebSocket.1
            @Override // java.lang.Runnable
            public void run() {
                do {
                    try {
                    } catch (IOException e) {
                        CustomHeartBeatRealWebSocket.this.failWebSocket(e, null);
                        return;
                    }
                } while (CustomHeartBeatRealWebSocket.this.writeOneFrame());
            }
        };
    }

    public static CustomHeartBeatRealWebSocket create(Request request, long j, WebSocketListener webSocketListener) {
        return new CustomHeartBeatRealWebSocket(request, j, webSocketListener, new Random());
    }

    public Request request() {
        return this.originalRequest;
    }

    public synchronized long queueSize() {
        return this.queueSize;
    }

    public void cancel() {
        this.call.cancel();
    }

    private Request tryAddOkWsRequestOpaque(Request request) {
        WsChannelSettings.OkOpaqueCallback okOpaqueCallback = WsChannelSettings.getOkOpaqueCallback();
        if (okOpaqueCallback == null) {
            return request;
        }
        try {
            Map<String, String> onCallToWsRequestOpaque = okOpaqueCallback.onCallToWsRequestOpaque(request.url().toString(), request.headers().toMultimap());
            if (onCallToWsRequestOpaque == null) {
                return request;
            }
            Request.Builder newBuilder = request.newBuilder();
            for (Map.Entry<String, String> entry : onCallToWsRequestOpaque.entrySet()) {
                newBuilder.addHeader(entry.getKey(), entry.getValue());
            }
            return newBuilder.build();
        } catch (Exception e) {
            Logger.m204w("tryAddOkWsRequestOpaque failed with exception" + e);
            return request;
        }
    }

    public void connect(OkHttpClient okHttpClient) {
        final Request tryAddOkWsRequestOpaque = tryAddOkWsRequestOpaque(this.originalRequest.newBuilder().header("Upgrade", "websocket").header("Connection", "Upgrade").header("Sec-WebSocket-Key", this.key).header("Sec-WebSocket-Version", "13").build());
        Call newWebSocketCall = Internal.instance.newWebSocketCall(okHttpClient, tryAddOkWsRequestOpaque);
        this.call = newWebSocketCall;
        newWebSocketCall.enqueue(new Callback() { // from class: com.bytedance.common.wschannel.channel.impl.ok.ws.CustomHeartBeatRealWebSocket.2
            public void onResponse(Call call, Response response) {
                try {
                    CustomHeartBeatRealWebSocket.this.checkResponse(response);
                    StreamAllocation streamAllocation = Internal.instance.streamAllocation(call);
                    streamAllocation.noNewStreams();
                    RealWebSocket.Streams newWebSocketStreams = streamAllocation.connection().newWebSocketStreams(streamAllocation);
                    try {
                        if (CustomHeartBeatRealWebSocket.this.listener != null) {
                            CustomHeartBeatRealWebSocket.this.listener.onOpen(CustomHeartBeatRealWebSocket.this, response);
                        }
                        CustomHeartBeatRealWebSocket.this.initReaderAndWriter("OkHttp WebSocket " + tryAddOkWsRequestOpaque.url().redact(), newWebSocketStreams);
                        streamAllocation.connection().socket().setSoTimeout(0);
                        CustomHeartBeatRealWebSocket.this.loopReader();
                    } catch (Exception e) {
                        CustomHeartBeatRealWebSocket.this.failWebSocket(e, null);
                    }
                } catch (ProtocolException e2) {
                    CustomHeartBeatRealWebSocket.this.failWebSocket(e2, response);
                    Util.closeQuietly(response);
                }
            }

            public void onFailure(Call call, IOException iOException) {
                CustomHeartBeatRealWebSocket.this.failWebSocket(iOException, null);
            }
        });
    }

    void checkResponse(Response response) throws ProtocolException {
        if (response.code() != 101) {
            throw new ProtocolException("Expected HTTP 101 response but was '" + response.code() + " " + response.message() + "'");
        }
        String header = response.header("Connection");
        if (!"Upgrade".equalsIgnoreCase(header)) {
            throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + header + "'");
        }
        String header2 = response.header("Upgrade");
        if (!"websocket".equalsIgnoreCase(header2)) {
            throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + header2 + "'");
        }
        String header3 = response.header("Sec-WebSocket-Accept");
        String base64 = ByteString.encodeUtf8(this.key + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").sha1().base64();
        if (!base64.equals(header3)) {
            throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + base64 + "' but was '" + header3 + "'");
        }
    }

    public void initReaderAndWriter(String str, RealWebSocket.Streams streams) throws IOException {
        synchronized (this) {
            this.streams = streams;
            this.writer = new WebSocketWriter(streams.client, streams.sink, this.random);
            this.executor = new ScheduledThreadPoolExecutor(1, Util.threadFactory(str, false));
            if (!this.messageAndCloseQueue.isEmpty()) {
                runWriter();
            }
        }
        this.reader = new WebSocketReader(streams.client, streams.source, this, this.ioLimitLength);
    }

    public void loopReader() throws IOException {
        while (this.receivedCloseCode == -1) {
            this.reader.processNextFrame();
        }
    }

    boolean processNextFrame() throws IOException {
        try {
            this.reader.processNextFrame();
            return this.receivedCloseCode == -1;
        } catch (Exception e) {
            failWebSocket(e, null);
            return false;
        }
    }

    void awaitTermination(int i, TimeUnit timeUnit) throws InterruptedException {
        this.executor.awaitTermination(i, timeUnit);
    }

    void tearDown() throws InterruptedException {
        ScheduledFuture<?> scheduledFuture = this.cancelFuture;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.executor.shutdown();
        this.executor.awaitTermination(10L, TimeUnit.SECONDS);
    }

    synchronized int sentPingCount() {
        return this.sentPingCount;
    }

    synchronized int receivedPingCount() {
        return this.receivedPingCount;
    }

    synchronized int receivedPongCount() {
        return this.receivedPongCount;
    }

    @Override // com.bytedance.common.wschannel.channel.impl.ok.ws.WebSocketReader.FrameCallback
    public void onReadMessage(String str) throws IOException {
        WebSocketListener webSocketListener = this.listener;
        if (webSocketListener != null) {
            webSocketListener.onMessage(this, str);
        }
    }

    @Override // com.bytedance.common.wschannel.channel.impl.ok.ws.WebSocketReader.FrameCallback
    public void onReadMessage(ByteString byteString) throws IOException {
        WebSocketListener webSocketListener = this.listener;
        if (webSocketListener != null) {
            webSocketListener.onMessage(this, byteString);
        }
    }

    @Override // com.bytedance.common.wschannel.channel.impl.ok.ws.WebSocketReader.FrameCallback
    public synchronized void onReadPing(ByteString byteString) {
        if (!this.failed && (!this.enqueuedClose || !this.messageAndCloseQueue.isEmpty())) {
            this.pongQueue.add(byteString);
            runWriter();
            this.receivedPingCount++;
        }
    }

    @Override // com.bytedance.common.wschannel.channel.impl.ok.ws.WebSocketReader.FrameCallback
    public synchronized void onReadPong(ByteString byteString) {
        this.receivedPongCount++;
        this.awaitingPong = false;
        WebSocketListener webSocketListener = this.listener;
        if (webSocketListener != null) {
            webSocketListener.onPong(this, byteString);
        }
    }

    @Override // com.bytedance.common.wschannel.channel.impl.ok.ws.WebSocketReader.FrameCallback
    public void onReadClose(int i, String str) {
        Closeable closeable;
        if (i == -1) {
            throw new IllegalArgumentException();
        }
        synchronized (this) {
            if (this.receivedCloseCode != -1) {
                throw new IllegalStateException("already closed");
            }
            this.receivedCloseCode = i;
            this.receivedCloseReason = str;
            closeable = null;
            if (this.enqueuedClose && this.messageAndCloseQueue.isEmpty()) {
                Closeable closeable2 = this.streams;
                this.streams = null;
                ScheduledFuture<?> scheduledFuture = this.cancelFuture;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                }
                this.executor.shutdown();
                closeable = closeable2;
            }
        }
        try {
            WebSocketListener webSocketListener = this.listener;
            if (webSocketListener != null) {
                webSocketListener.onClosing(this, i, str);
                if (closeable != null) {
                    this.listener.onClosed(this, i, str);
                }
            }
        } finally {
            Util.closeQuietly(closeable);
        }
    }

    public boolean send(String str) {
        if (str == null) {
            throw new NullPointerException("text == null");
        }
        return send(ByteString.encodeUtf8(str), 1);
    }

    public boolean send(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException("bytes == null");
        }
        return send(byteString, 2);
    }

    private synchronized boolean send(ByteString byteString, int i) {
        if (!this.failed && !this.enqueuedClose) {
            if (this.queueSize + byteString.size() > MAX_QUEUE_SIZE) {
                close(1001, null);
                return false;
            }
            this.queueSize += byteString.size();
            this.messageAndCloseQueue.add(new Message(i, byteString));
            runWriter();
            return true;
        }
        return false;
    }

    public boolean close(int i, String str) {
        return close(i, str, 60000L);
    }

    synchronized boolean close(int i, String str, long j) {
        ByteString byteString;
        WebSocketProtocol.validateCloseCode(i);
        if (str != null) {
            byteString = ByteString.encodeUtf8(str);
            if (byteString.size() > 123) {
                throw new IllegalArgumentException("reason.size() > 123: " + str);
            }
        } else {
            byteString = null;
        }
        if (!this.failed && !this.enqueuedClose) {
            this.enqueuedClose = true;
            this.messageAndCloseQueue.add(new Close(i, byteString, j));
            runWriter();
            return true;
        }
        return false;
    }

    private void runWriter() {
        ScheduledExecutorService scheduledExecutorService = this.executor;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.execute(this.writerRunnable);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v6 */
    boolean writeOneFrame() throws IOException {
        String str;
        int i;
        RealWebSocket.Streams streams;
        WebSocketListener webSocketListener;
        synchronized (this) {
            if (this.failed) {
                return false;
            }
            WebSocketWriter webSocketWriter = this.writer;
            ByteString poll = this.pongQueue.poll();
            Message message = 0;
            if (poll == null) {
                Object poll2 = this.messageAndCloseQueue.poll();
                if (poll2 instanceof Close) {
                    i = this.receivedCloseCode;
                    str = this.receivedCloseReason;
                    if (i != -1) {
                        streams = this.streams;
                        this.streams = null;
                        this.executor.shutdown();
                    } else {
                        this.cancelFuture = this.executor.schedule(new CancelRunnable(), ((Close) poll2).cancelAfterCloseMillis, TimeUnit.MILLISECONDS);
                        streams = null;
                    }
                } else {
                    if (poll2 == null) {
                        return false;
                    }
                    str = null;
                    i = -1;
                    streams = null;
                }
                message = poll2;
            } else {
                str = null;
                i = -1;
                streams = null;
            }
            try {
                if (poll != null) {
                    webSocketWriter.writePong(poll);
                } else if (message instanceof Message) {
                    ByteString byteString = message.data;
                    BufferedSink buffer = Okio.buffer(webSocketWriter.newMessageSink(message.formatOpcode, byteString.size()));
                    buffer.write(byteString);
                    buffer.close();
                    synchronized (this) {
                        this.queueSize -= byteString.size();
                    }
                } else if (message instanceof Close) {
                    Close close = (Close) message;
                    webSocketWriter.writeClose(close.code, close.reason);
                    if (streams != null && (webSocketListener = this.listener) != null) {
                        webSocketListener.onClosed(this, i, str);
                    }
                } else {
                    throw new AssertionError();
                }
                Util.closeQuietly(streams);
                return true;
            } catch (Throwable th) {
                Util.closeQuietly(streams);
                throw th;
            }
        }
    }

    @Override // com.bytedance.common.wschannel.channel.impl.p007ok.ws.CustomHeartBeatWebSocket
    public void sendPing() {
        ScheduledExecutorService scheduledExecutorService = this.executor;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.execute(new PingRunnable());
        }
    }

    void writePingFrame(ByteString byteString) {
        synchronized (this) {
            if (this.failed) {
                return;
            }
            WebSocketWriter webSocketWriter = this.writer;
            int i = this.awaitingPong ? this.sentPingCount : -1;
            this.sentPingCount++;
            this.awaitingPong = true;
            if (i != -1) {
                failWebSocket(new SocketTimeoutException(WsConstants.PING_NOT_RECEIVE_PONG_MSG), null);
            } else if (webSocketWriter != null) {
                try {
                    webSocketWriter.writePing(byteString);
                } catch (IOException e) {
                    failWebSocket(e, null);
                }
            }
        }
    }

    public void failWebSocket(Exception exc, Response response) {
        synchronized (this) {
            if (this.failed) {
                return;
            }
            this.failed = true;
            RealWebSocket.Streams streams = this.streams;
            this.streams = null;
            ScheduledFuture<?> scheduledFuture = this.cancelFuture;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            ScheduledExecutorService scheduledExecutorService = this.executor;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdown();
            }
            try {
                WebSocketListener webSocketListener = this.listener;
                if (webSocketListener != null) {
                    webSocketListener.onFailure(this, exc, response);
                }
            } finally {
                Util.closeQuietly(streams);
            }
        }
    }

    public void closeQuietly(int i, String str) {
        this.listener = null;
        try {
            close(i, str);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class Message {
        final ByteString data;
        final int formatOpcode;

        Message(int i, ByteString byteString) {
            this.formatOpcode = i;
            this.data = byteString;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class Close {
        final long cancelAfterCloseMillis;
        final int code;
        final ByteString reason;

        Close(int i, ByteString byteString, long j) {
            this.code = i;
            this.reason = byteString;
            this.cancelAfterCloseMillis = j;
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    private final class PingRunnable implements Runnable {
        PingRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CustomHeartBeatRealWebSocket.this.writePingFrame(ByteString.EMPTY);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public final class CancelRunnable implements Runnable {
        CancelRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CustomHeartBeatRealWebSocket.this.cancel();
        }
    }
}
