package com.bytedance.vmsdk.inspector_new.server;

import android.net.LocalServerSocket;
import android.net.LocalSocket;
import android.util.Log;
import com.bytedance.vmsdk.inspector_new.ChromeDiscoveryHandler;
import com.bytedance.vmsdk.inspector_new.InspectorClientNew;
import com.bytedance.vmsdk.inspector_new.server.http.HandlerRegistry;
import com.bytedance.vmsdk.inspector_new.server.http.LightHttpServer;
import com.bytedance.vmsdk.utils.ThreadUtils;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class LocalSocketServer {
    private static final int SENSING_BUFFER_SIZE = 1024;
    private static final String TAG = "LocalSocketServer";
    private LightHttpServer mLightHttpServer;
    private LocalServerSocket mServerSocket;
    private final AtomicInteger mThreadId = new AtomicInteger();
    private final HandlerRegistry mHandlerRegistry = new HandlerRegistry();
    private final ChromeDiscoveryHandler mChromeDiscoveryHandler = new ChromeDiscoveryHandler();

    public void addInspectorClient(InspectorClientNew inspectorClientNew) {
        this.mChromeDiscoveryHandler.addInspectorClient(inspectorClientNew);
        this.mHandlerRegistry.register(inspectorClientNew.getExactPathMatcher(), inspectorClientNew.getWebSocketHandler());
    }

    public void removeInspect(InspectorClientNew inspectorClientNew) {
        this.mChromeDiscoveryHandler.removeInspectorClient(inspectorClientNew);
        this.mHandlerRegistry.unregister(inspectorClientNew.getExactPathMatcher(), inspectorClientNew.getWebSocketHandler());
    }

    public void onRelease() {
        LocalServerSocket localServerSocket = this.mServerSocket;
        if (localServerSocket != null) {
            try {
                localServerSocket.close();
            } catch (IOException e) {
                Log.e(TAG, "IOException", e);
            }
        }
    }

    private LightHttpServer createServer() {
        this.mChromeDiscoveryHandler.register(this.mHandlerRegistry);
        return new LightHttpServer(this.mHandlerRegistry);
    }

    public void start() {
        new Thread(new Runnable() { // from class: com.bytedance.vmsdk.inspector_new.server.LocalSocketServer$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                LocalSocketServer.this.m12xddf816d7();
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$start$0$com-bytedance-vmsdk-inspector_new-server-LocalSocketServer */
    public /* synthetic */ void m12xddf816d7() {
        try {
            this.mServerSocket = new LocalServerSocket("JsEngine_" + ThreadUtils.getProcessName() + "_devtools_remote");
            this.mLightHttpServer = createServer();
            while (!Thread.interrupted()) {
                WorkerThread workerThread = new WorkerThread(this.mServerSocket.accept());
                workerThread.setName("LocalSocketServer_WorkerThread_" + this.mThreadId.incrementAndGet());
                workerThread.setDaemon(true);
                workerThread.start();
            }
        } catch (IOException e) {
            Log.e(TAG, e.getMessage());
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    private class WorkerThread extends Thread {
        private final LocalSocket mSocket;

        public WorkerThread(LocalSocket localSocket) {
            this.mSocket = localSocket;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                LocalSocketServer.this.mLightHttpServer.serve(new SocketLike(this.mSocket, new LeakyBufferedInputStream(this.mSocket.getInputStream(), 1024)));
            } catch (Exception e) {
                Log.e(LocalSocketServer.TAG, e.getMessage());
            }
        }
    }
}
