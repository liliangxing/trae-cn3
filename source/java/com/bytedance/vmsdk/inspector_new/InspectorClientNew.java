package com.bytedance.vmsdk.inspector_new;

import com.bytedance.vmsdk.inspector_new.server.LocalSocketServer;
import com.bytedance.vmsdk.inspector_new.server.http.ExactPathMatcher;
import com.bytedance.vmsdk.inspector_new.server.websocket.SimpleSession;
import com.bytedance.vmsdk.inspector_new.server.websocket.WebSocketHandler;
import com.bytedance.vmsdk.worker.JsWorker;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class InspectorClientNew implements IInspectorSession {
    public static final String INSPECTOR_PATH = "/inspector";
    private static final String TAG = "Inspector";
    private static volatile LocalSocketServer sSocketServer;
    private String mDisplayName;
    private final ExactPathMatcher mExactPathMatcher;
    private final String mInspectorPath;
    private JsWorker mJSWorker;
    private volatile SimpleSession mSession;
    private final List<IInspectorSession> mSessions;
    private final WebSocketHandler mWebSocketHandler;

    public InspectorClientNew(JsWorker jsWorker) {
        if (sSocketServer == null) {
            sSocketServer = new LocalSocketServer();
            sSocketServer.start();
        }
        this.mSessions = new LinkedList();
        this.mDisplayName = "VMSDK_JSWorker_".concat(jsWorker.EngineType() == JsWorker.EngineType.V8 ? "V8" : "QuickJS");
        String str = "/inspector/" + jsWorker.getNativePtr();
        this.mInspectorPath = str;
        this.mJSWorker = jsWorker;
        this.mExactPathMatcher = new ExactPathMatcher(str);
        this.mWebSocketHandler = new WebSocketHandler(new ChromeDevtoolsServer(this));
        sSocketServer.addInspectorClient(this);
    }

    public void setShellHolder(JsWorker jsWorker) {
        this.mJSWorker = jsWorker;
    }

    public void addSession(IInspectorSession iInspectorSession) {
        this.mSessions.add(iInspectorSession);
    }

    public void updateDisplayName(String str) {
        this.mDisplayName = str;
    }

    public String getDisplayName() {
        return this.mDisplayName;
    }

    public String getInspectorPath() {
        return this.mInspectorPath;
    }

    public ExactPathMatcher getExactPathMatcher() {
        return this.mExactPathMatcher;
    }

    public WebSocketHandler getWebSocketHandler() {
        return this.mWebSocketHandler;
    }

    @Override // com.bytedance.vmsdk.inspector_new.IInspectorSession
    public void onOpen(SimpleSession simpleSession) {
        this.mSession = simpleSession;
        Iterator<IInspectorSession> it = this.mSessions.iterator();
        while (it.hasNext()) {
            it.next().onOpen(simpleSession);
        }
        this.mJSWorker.onOpenInspectorSession();
    }

    @Override // com.bytedance.vmsdk.inspector_new.IInspectorSession
    public boolean onProtocolMessage(SimpleSession simpleSession, String str) {
        Iterator<IInspectorSession> it = this.mSessions.iterator();
        while (it.hasNext()) {
            if (it.next().onProtocolMessage(simpleSession, str)) {
                return true;
            }
        }
        this.mJSWorker.onInspectorMessage(str);
        return false;
    }

    @Override // com.bytedance.vmsdk.inspector_new.IInspectorSession
    public void onClose(SimpleSession simpleSession) {
        this.mSession = null;
        this.mJSWorker.onCloseInspectorSession();
        Iterator<IInspectorSession> it = this.mSessions.iterator();
        while (it.hasNext()) {
            it.next().onClose(simpleSession);
        }
    }

    public void sendResponse(String str) {
        if (this.mSession == null) {
            return;
        }
        this.mSession.sendText(str);
    }

    public void release() {
        sSocketServer.removeInspect(this);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        InspectorClientNew inspectorClientNew = (InspectorClientNew) obj;
        return Objects.equals(this.mDisplayName, inspectorClientNew.mDisplayName) && Objects.equals(this.mInspectorPath, inspectorClientNew.mInspectorPath);
    }

    public int hashCode() {
        return Objects.hash(this.mDisplayName, this.mInspectorPath);
    }
}
