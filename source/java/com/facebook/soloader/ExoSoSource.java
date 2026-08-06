package com.facebook.soloader;

import android.content.Context;
import com.bytedance.librarian.LibrarianImpl;
import com.facebook.soloader.UnpackingSoSource;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;

/* loaded from: classes6.dex */
public final class ExoSoSource extends UnpackingSoSource {
    public ExoSoSource(Context context, String str) {
        super(context, str);
    }

    @Override // com.facebook.soloader.UnpackingSoSource
    protected UnpackingSoSource.Unpacker makeUnpacker(byte b) throws IOException {
        return new ExoUnpacker(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public final class ExoUnpacker extends UnpackingSoSource.Unpacker {
        private final FileDso[] mDsos;

        /* JADX WARN: Code restructure failed: missing block: B:34:0x00e8, code lost:
        
            throw new java.lang.RuntimeException("illegal line in exopackage metadata: [" + r11 + "]");
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        ExoUnpacker(UnpackingSoSource unpackingSoSource) throws IOException {
            boolean z;
            File file = new File("/data/local/tmp/exopackage/" + ExoSoSource.this.mContext.getPackageName() + "/native-libs/");
            ArrayList arrayList = new ArrayList();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            String[] supportedAbis = SysUtil.getSupportedAbis();
            int length = supportedAbis.length;
            int i = 0;
            int i2 = 0;
            loop0: while (i2 < length) {
                String str = supportedAbis[i2];
                File file2 = new File(file, str);
                if (file2.isDirectory()) {
                    linkedHashSet.add(str);
                    File file3 = new File(file2, "metadata.txt");
                    if (file3.isFile()) {
                        FileReader fileReader = new FileReader(file3);
                        try {
                            BufferedReader bufferedReader = new BufferedReader(fileReader);
                            while (true) {
                                try {
                                    String readLine = bufferedReader.readLine();
                                    if (readLine != null) {
                                        if (readLine.length() != 0) {
                                            int indexOf = readLine.indexOf(32);
                                            if (indexOf == -1) {
                                                break loop0;
                                            }
                                            String str2 = readLine.substring(i, indexOf) + LibrarianImpl.Constants.SO_SUFFIX;
                                            int size = arrayList.size();
                                            int i3 = i;
                                            while (true) {
                                                if (i3 >= size) {
                                                    z = false;
                                                    break;
                                                } else {
                                                    if (((FileDso) arrayList.get(i3)).name.equals(str2)) {
                                                        z = true;
                                                        break;
                                                    }
                                                    i3++;
                                                }
                                            }
                                            if (!z) {
                                                String substring = readLine.substring(indexOf + 1);
                                                arrayList.add(new FileDso(str2, substring, new File(file2, substring)));
                                            }
                                            i = 0;
                                        }
                                    } else {
                                        bufferedReader.close();
                                        fileReader.close();
                                        break;
                                    }
                                } finally {
                                }
                            }
                        } finally {
                        }
                    } else {
                        continue;
                    }
                }
                i2++;
                i = 0;
            }
            unpackingSoSource.setSoSourceAbis((String[]) linkedHashSet.toArray(new String[linkedHashSet.size()]));
            this.mDsos = (FileDso[]) arrayList.toArray(new FileDso[arrayList.size()]);
        }

        @Override // com.facebook.soloader.UnpackingSoSource.Unpacker
        public UnpackingSoSource.DsoManifest getDsoManifest() throws IOException {
            return new UnpackingSoSource.DsoManifest(this.mDsos);
        }

        @Override // com.facebook.soloader.UnpackingSoSource.Unpacker
        public UnpackingSoSource.InputDsoIterator openDsoIterator() throws IOException {
            return new FileBackedInputDsoIterator();
        }

        /* loaded from: classes6.dex */
        private final class FileBackedInputDsoIterator extends UnpackingSoSource.InputDsoIterator {
            private int mCurrentDso;

            private FileBackedInputDsoIterator() {
            }

            @Override // com.facebook.soloader.UnpackingSoSource.InputDsoIterator
            public boolean hasNext() {
                return this.mCurrentDso < ExoUnpacker.this.mDsos.length;
            }

            @Override // com.facebook.soloader.UnpackingSoSource.InputDsoIterator
            public UnpackingSoSource.InputDso next() throws IOException {
                FileDso[] fileDsoArr = ExoUnpacker.this.mDsos;
                int i = this.mCurrentDso;
                this.mCurrentDso = i + 1;
                FileDso fileDso = fileDsoArr[i];
                FileInputStream fileInputStream = new FileInputStream(fileDso.backingFile);
                try {
                    return new UnpackingSoSource.InputDsoStream(fileDso, fileInputStream);
                } catch (Throwable th) {
                    fileInputStream.close();
                    throw th;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    private static final class FileDso extends UnpackingSoSource.Dso {
        final File backingFile;

        FileDso(String str, String str2, File file) {
            super(str, str2);
            this.backingFile = file;
        }
    }
}
