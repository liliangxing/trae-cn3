package com.facebook.soloader;

import android.content.Context;
import android.os.Parcel;
import android.util.Log;
import com.facebook.soloader.ExtractFromZipSoSource;
import com.facebook.soloader.UnpackingSoSource;
import java.io.File;
import java.io.IOException;
import java.util.zip.ZipEntry;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class ApkSoSource extends ExtractFromZipSoSource {
    private static final byte APK_SO_SOURCE_SIGNATURE_VERSION = 2;
    private static final byte LIBS_DIR_DOESNT_EXIST = 1;
    private static final byte LIBS_DIR_DONT_CARE = 0;
    private static final byte LIBS_DIR_SNAPSHOT = 2;
    public static final int PREFER_ANDROID_LIBS_DIRECTORY = 1;
    private static final String TAG = "ApkSoSource";
    private final int mFlags;

    public ApkSoSource(Context context, String str, int i) {
        this(context, new File(context.getApplicationInfo().sourceDir), str, i);
    }

    public ApkSoSource(Context context, File file, String str, int i) {
        super(context, str, file, "^lib/([^/]+)/([^/]+\\.so)$");
        this.mFlags = i;
    }

    @Override // com.facebook.soloader.ExtractFromZipSoSource, com.facebook.soloader.UnpackingSoSource
    protected UnpackingSoSource.Unpacker makeUnpacker(byte b) throws IOException {
        return new ApkUnpacker(this);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    protected class ApkUnpacker extends ExtractFromZipSoSource.ZipUnpacker {
        private final int mFlags;
        private final File mLibDir;

        ApkUnpacker(ExtractFromZipSoSource extractFromZipSoSource) throws IOException {
            super(extractFromZipSoSource);
            this.mLibDir = new File(ApkSoSource.this.mContext.getApplicationInfo().nativeLibraryDir);
            this.mFlags = ApkSoSource.this.mFlags;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x007d  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x00ca  */
        @Override // com.facebook.soloader.ExtractFromZipSoSource.ZipUnpacker
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        protected boolean shouldExtract(ZipEntry zipEntry, String str) {
            String format;
            boolean z;
            String str2;
            String name = zipEntry.getName();
            boolean z2 = false;
            if (str.equals(ApkSoSource.this.mCorruptedLib)) {
                ApkSoSource.this.mCorruptedLib = null;
                str2 = String.format("allowing consideration of corrupted lib %s", str);
            } else if ((this.mFlags & 1) == 0) {
                str2 = "allowing consideration of " + name + ": self-extraction preferred";
            } else {
                File file = new File(this.mLibDir, str);
                try {
                } catch (IOException e) {
                    format = String.format("not allowing consideration of %s: %s, IOException when constructing path: %s", name, str, e.toString());
                }
                if (!file.getCanonicalPath().startsWith(this.mLibDir.getCanonicalPath())) {
                    format = String.format("not allowing consideration of %s: %s not in lib dir", name, str);
                    z = false;
                    if (z) {
                        str2 = format;
                    } else if (!file.isFile()) {
                        str2 = String.format("allowing consideration of %s: %s not in system lib dir", name, str);
                    } else {
                        long length = file.length();
                        long size = zipEntry.getSize();
                        if (length != size) {
                            str2 = String.format("allowing consideration of %s: sysdir file length is %s, but the file is %s bytes long in the APK", file, Long.valueOf(length), Long.valueOf(size));
                        } else {
                            str2 = "not allowing consideration of " + name + ": deferring to libdir";
                        }
                    }
                    Log.d(ApkSoSource.TAG, str2);
                    return z2;
                }
                format = "";
                z = true;
                if (z) {
                }
                Log.d(ApkSoSource.TAG, str2);
                return z2;
            }
            z2 = true;
            Log.d(ApkSoSource.TAG, str2);
            return z2;
        }
    }

    @Override // com.facebook.soloader.UnpackingSoSource
    protected byte[] getDepsBlock() throws IOException {
        File canonicalFile = this.mZipFileName.getCanonicalFile();
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeByte((byte) 2);
            obtain.writeString(canonicalFile.getPath());
            obtain.writeLong(canonicalFile.lastModified());
            obtain.writeInt(SysUtil.getAppVersionCode(this.mContext));
            if ((this.mFlags & 1) == 0) {
                obtain.writeByte(LIBS_DIR_DONT_CARE);
                return obtain.marshall();
            }
            String str = this.mContext.getApplicationInfo().nativeLibraryDir;
            if (str == null) {
                obtain.writeByte((byte) 1);
                return obtain.marshall();
            }
            File canonicalFile2 = new File(str).getCanonicalFile();
            if (!canonicalFile2.exists()) {
                obtain.writeByte((byte) 1);
                return obtain.marshall();
            }
            obtain.writeByte((byte) 2);
            obtain.writeString(canonicalFile2.getPath());
            obtain.writeLong(canonicalFile2.lastModified());
            return obtain.marshall();
        } finally {
            obtain.recycle();
        }
    }
}
