package com.bytedance.ug.sdk.share.impl.ui.utils;

import android.os.Handler;
import android.os.Looper;
import android.view.View;

/* loaded from: classes4.dex */
public abstract class DebouncingOnClickListener implements View.OnClickListener {
    private static final long DEFAULT_INTERVAL = 500;
    private static final Handler HANDLER = new Handler(Looper.getMainLooper());
    private final Runnable ENABLE_AGAIN;
    private boolean enabled;
    private long interval;

    public abstract void doClick(View view);

    public DebouncingOnClickListener() {
        this(500L);
    }

    public DebouncingOnClickListener(long j) {
        this.enabled = true;
        this.ENABLE_AGAIN = new Runnable() { // from class: com.bytedance.ug.sdk.share.impl.ui.utils.DebouncingOnClickListener.1
            @Override // java.lang.Runnable
            public void run() {
                DebouncingOnClickListener.this.enabled = true;
            }
        };
        this.interval = j;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.enabled) {
            this.enabled = false;
            HANDLER.postDelayed(this.ENABLE_AGAIN, this.interval);
            doClick(view);
        }
    }

    public long getInterval() {
        return this.interval;
    }

    public void setInterval(long j) {
        this.interval = j;
    }
}
