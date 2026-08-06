package com.bytedance.webx.context;

import com.bytedance.webx.WebXEnv;
import com.bytedance.webx.event.AbsListenerStub;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes6.dex */
public interface IContext {
    WebXEnv getEnv();

    IContextItem getExtension(Class cls);

    Map<String, TreeMap<Integer, AbsListenerStub>> getListenerMap();

    IContextItem getOrigin();

    Iterator<IContextItem> itContextItems();

    void setListenerMap(Map<String, TreeMap<Integer, AbsListenerStub>> map);
}
