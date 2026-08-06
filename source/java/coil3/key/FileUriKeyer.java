package coil3.key;

import coil3.Uri;
import coil3.UriKt;
import coil3.request.Options;
import coil3.util.Utils_commonKt;
import com.bytedance.framwork.core.sdklib.apm6.Constants;
import kotlin.Metadata;
import okio.Path;

/* compiled from: FileUriKeyer.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcoil3/key/FileUriKeyer;", "Lcoil3/key/Keyer;", "Lcoil3/Uri;", "addLastModifiedToFileCacheKey", "", "<init>", "(Z)V", "key", "", Constants.KEY_DATA, "options", "Lcoil3/request/Options;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class FileUriKeyer implements Keyer<Uri> {
    private final boolean addLastModifiedToFileCacheKey;

    public FileUriKeyer(boolean z) {
        this.addLastModifiedToFileCacheKey = z;
    }

    @Override // coil3.key.Keyer
    public String key(Uri data, Options options) {
        String filePath;
        if (this.addLastModifiedToFileCacheKey && Utils_commonKt.isFileUri(data) && (filePath = UriKt.getFilePath(data)) != null) {
            return new StringBuilder().append(data).append('-').append(options.getFileSystem().metadata(Path.Companion.get$default(Path.Companion, filePath, false, 1, (Object) null)).getLastModifiedAtMillis()).toString();
        }
        return null;
    }
}
