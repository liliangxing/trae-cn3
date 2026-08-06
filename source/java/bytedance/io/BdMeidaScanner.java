package bytedance.io;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import bytedance.util.FsLogger;
import java.io.File;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes2.dex */
public class BdMeidaScanner implements MediaScannerConnection.MediaScannerConnectionClient {
    private File mFile;
    private MediaScannerConnection mMs;
    private LinkedBlockingQueue<Uri> mQueue = new LinkedBlockingQueue<>(1);

    public BdMeidaScanner(Context context, File file) {
        this.mFile = file;
        MediaScannerConnection mediaScannerConnection = new MediaScannerConnection(context, this);
        this.mMs = mediaScannerConnection;
        mediaScannerConnection.connect();
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        this.mMs.scanFile(this.mFile.getAbsolutePath(), null);
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        this.mMs.disconnect();
        if (uri == null) {
            return;
        }
        try {
            this.mQueue.put(uri);
        } catch (InterruptedException e) {
            FsLogger.e("Unable to put new ringtone Uri in queue" + e.getMessage());
        }
    }

    public Uri get() throws InterruptedException {
        return this.mQueue.take();
    }
}
