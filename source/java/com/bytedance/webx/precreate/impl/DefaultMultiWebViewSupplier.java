package com.bytedance.webx.precreate.impl;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.SystemClock;
import android.webkit.WebView;
import com.bytedance.webx.precreate.api.IMultiWebViewSupplier;
import com.bytedance.webx.precreate.api.IPreCreateMonitor;
import com.bytedance.webx.precreate.model.PreCreateInfo;
import com.bytedance.webx.precreate.util.PreCreateUtil;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class DefaultMultiWebViewSupplier implements IMultiWebViewSupplier {
    private static boolean mFirstCreate = true;
    private final Context mApplicationContext;
    private MessageQueue mMainMessageQueue;
    private IPreCreateMonitor mPreCreateMonitor;
    private boolean mActivePreCreate = true;
    private PreCreateInfo mPreCreateInfo = null;
    private final Object lock = new Object();
    private final Object mLock = new Object();
    private final Map<String, PreCreateInfo> mInfos = new HashMap();

    public DefaultMultiWebViewSupplier(Context context) {
        this.mApplicationContext = context;
    }

    @Override // com.bytedance.webx.precreate.api.IMultiWebViewSupplier
    public IMultiWebViewSupplier registerWebView(String str, PreCreateInfo preCreateInfo) {
        if (!this.mInfos.containsKey(str) && preCreateInfo != null) {
            preCreateInfo.type = str;
            this.mInfos.put(str, preCreateInfo);
            if (preCreateInfo.preCreateWebViewWhenRegister) {
                resize(str, preCreateInfo.size);
            }
        }
        return this;
    }

    @Override // com.bytedance.webx.precreate.api.IMultiWebViewSupplier
    public IMultiWebViewSupplier registerMonitorCallback(IPreCreateMonitor iPreCreateMonitor) {
        this.mPreCreateMonitor = iPreCreateMonitor;
        return this;
    }

    @Override // com.bytedance.webx.precreate.api.IMultiWebViewSupplier
    public WebView get(Context context, String str) {
        WebView webView;
        boolean z;
        IPreCreateMonitor iPreCreateMonitor;
        boolean z2;
        long uptimeMillis = SystemClock.uptimeMillis();
        PreCreateInfo preCreateInfo = this.mInfos.get(str);
        if (preCreateInfo == null) {
            webView = null;
        } else {
            if (!preCreateInfo.webViews.isEmpty()) {
                synchronized (this.mLock) {
                    webView = preCreateInfo.webViews.remove(0).get();
                    if (webView != null) {
                        PreCreateUtil.replaceContext(webView, context);
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (preCreateInfo.webViews.size() < preCreateInfo.size) {
                        submitPreCreateWebView(preCreateInfo);
                    }
                }
                z = z2;
                if (preCreateInfo != null && (iPreCreateMonitor = this.mPreCreateMonitor) != null) {
                    iPreCreateMonitor.monitorGetWebViewCache(mFirstCreate, z, SystemClock.uptimeMillis() - uptimeMillis, preCreateInfo);
                    mFirstCreate = false;
                }
                return webView;
            }
            WebView create = preCreateInfo.webViewFactory.create(new MutableContextWrapper(context), false);
            PreCreateUtil.markIsPreCreate(create, false);
            resize(str, preCreateInfo.size);
            webView = create;
        }
        z = false;
        if (preCreateInfo != null) {
            iPreCreateMonitor.monitorGetWebViewCache(mFirstCreate, z, SystemClock.uptimeMillis() - uptimeMillis, preCreateInfo);
            mFirstCreate = false;
        }
        return webView;
    }

    @Override // com.bytedance.webx.precreate.api.IMultiWebViewSupplier
    public void resize(String str, int i) {
        synchronized (this.mLock) {
            PreCreateInfo preCreateInfo = this.mInfos.get(str);
            if (preCreateInfo == null) {
                return;
            }
            int size = preCreateInfo.webViews.size();
            preCreateInfo.size = i;
            int i2 = 0;
            if (size < i) {
                while (i2 < i - size) {
                    submitPreCreateWebView(preCreateInfo);
                    i2++;
                }
            } else {
                while (i2 < size - i) {
                    PreCreateUtil.destroyWebView(preCreateInfo.webViews.remove((size - 1) - i2).get(), this.mApplicationContext);
                    i2++;
                }
            }
        }
    }

    @Override // com.bytedance.webx.precreate.api.IMultiWebViewSupplier
    public void preCreate(String str) {
        PreCreateInfo preCreateInfo = this.mInfos.get(str);
        if (preCreateInfo == null) {
            return;
        }
        synchronized (this.mLock) {
            if (preCreateInfo.webViews.size() < preCreateInfo.size) {
                WebView create = preCreateInfo.webViewFactory.create(new MutableContextWrapper(this.mApplicationContext), true);
                preCreateInfo.webViews.add(new SoftReference<>(create));
                PreCreateUtil.markIsPreCreate(create, true);
            }
        }
    }

    @Override // com.bytedance.webx.precreate.api.IMultiWebViewSupplier
    public WebView fetchCachedWebView(String str, int i) {
        WebView webView;
        PreCreateInfo preCreateInfo = this.mInfos.get(str);
        if (preCreateInfo == null || preCreateInfo.webViews.isEmpty()) {
            return null;
        }
        synchronized (this.mLock) {
            if (i >= 0) {
                try {
                    if (i >= preCreateInfo.webViews.size()) {
                    }
                    webView = preCreateInfo.webViews.get(i).get();
                } finally {
                }
            }
            i = 0;
            webView = preCreateInfo.webViews.get(i).get();
        }
        return webView;
    }

    @Override // com.bytedance.webx.precreate.api.IMultiWebViewSupplier
    public boolean remove(String str, WebView webView, boolean z) {
        PreCreateInfo preCreateInfo;
        if (webView == null || (preCreateInfo = this.mInfos.get(str)) == null) {
            return false;
        }
        boolean removeSpecificWebView = removeSpecificWebView(preCreateInfo.webViews, webView);
        if (z) {
            resize(str, preCreateInfo.size);
        }
        return removeSpecificWebView;
    }

    @Override // com.bytedance.webx.precreate.api.IMultiWebViewSupplier
    public void setPreCreatActive(boolean z) {
        PreCreateInfo preCreateInfo;
        PreCreateInfo preCreateInfo2;
        synchronized (this.lock) {
            this.mActivePreCreate = z;
            preCreateInfo = null;
            if (z && (preCreateInfo2 = this.mPreCreateInfo) != null) {
                this.mPreCreateInfo = null;
                preCreateInfo = preCreateInfo2;
            }
        }
        if (preCreateInfo != null) {
            submitPreCreateWebView(preCreateInfo);
        }
    }

    private boolean removeSpecificWebView(List<SoftReference<WebView>> list, WebView webView) {
        synchronized (this.mLock) {
            Iterator<SoftReference<WebView>> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().get() == webView) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitPreCreateWebView(final PreCreateInfo preCreateInfo) {
        if (this.mMainMessageQueue != null) {
            synchronized (this.lock) {
                if (!this.mActivePreCreate) {
                    this.mPreCreateInfo = preCreateInfo;
                    return;
                } else {
                    this.mMainMessageQueue.addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.bytedance.webx.precreate.impl.DefaultMultiWebViewSupplier.1
                        @Override // android.os.MessageQueue.IdleHandler
                        public final boolean queueIdle() {
                            synchronized (DefaultMultiWebViewSupplier.this.mLock) {
                                if (preCreateInfo.webViews.size() < preCreateInfo.size) {
                                    WebView create = preCreateInfo.webViewFactory.create(new MutableContextWrapper(DefaultMultiWebViewSupplier.this.mApplicationContext), true);
                                    preCreateInfo.webViews.add(new SoftReference<>(create));
                                    PreCreateUtil.markIsPreCreate(create, true);
                                }
                            }
                            return false;
                        }
                    });
                    return;
                }
            }
        }
        initMainQueueAndCacheWebView(preCreateInfo);
    }

    private void initMainQueueAndCacheWebView(PreCreateInfo preCreateInfo) {
        this.mMainMessageQueue = Looper.getMainLooper().getQueue();
        submitPreCreateWebView(preCreateInfo);
    }

    /* renamed from: com.bytedance.webx.precreate.impl.DefaultMultiWebViewSupplier$2, reason: invalid class name */
    /* loaded from: classes6.dex */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ PreCreateInfo val$info;

        AnonymousClass2(PreCreateInfo preCreateInfo) {
            this.val$info = preCreateInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            DefaultMultiWebViewSupplier.this.mMainMessageQueue = Looper.myQueue();
            DefaultMultiWebViewSupplier.this.submitPreCreateWebView(this.val$info);
        }
    }
}
