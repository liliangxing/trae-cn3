package okhttp3.internal;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public abstract class NamedRunnable implements Runnable {
    protected final String name;

    protected abstract void execute();

    public NamedRunnable(String str, Object... objArr) {
        this.name = Util.format(str, objArr);
    }

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.name);
        try {
            execute();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
