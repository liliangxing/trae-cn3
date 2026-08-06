package com.facebook.soloader;

import android.content.Context;
import android.os.Parcel;
import android.os.StrictMode;
import android.util.Log;
import java.io.Closeable;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.SyncFailedException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* loaded from: classes6.dex */
public abstract class UnpackingSoSource extends DirectorySoSource {
    private static final String DEPS_FILE_NAME = "dso_deps";
    private static final String INSTANCE_LOCK_FILE_NAME = "dso_instance_lock";
    private static final String LOCK_FILE_NAME = "dso_lock";
    private static final String MANIFEST_FILE_NAME = "dso_manifest";
    private static final byte MANIFEST_VERSION = 1;
    protected static final byte STATE_CLEAN = 1;
    protected static final byte STATE_DIRTY = 0;
    private static final String STATE_FILE_NAME = "dso_state";
    private static final String TAG = "fb-UnpackingSoSource";

    @Nullable
    private String[] mAbis;
    protected final Context mContext;

    @Nullable
    protected String mCorruptedLib;

    @Nullable
    protected FileLocker mInstanceLock;
    private final Map<String, Object> mLibsBeingLoaded;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes6.dex */
    public interface InputDso extends Closeable {
        int available() throws IOException;

        Dso getDso();

        String getFileName();

        InputStream getStream();

        void write(DataOutput dataOutput, byte[] bArr) throws IOException;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes6.dex */
    public static abstract class InputDsoIterator implements Closeable {
        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        public abstract boolean hasNext();

        @Nullable
        public abstract InputDso next() throws IOException;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes6.dex */
    public static abstract class Unpacker implements Closeable {
        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        public abstract DsoManifest getDsoManifest() throws IOException;

        public abstract InputDsoIterator openDsoIterator() throws IOException;
    }

    protected String getSoNameFromFileName(String str) {
        return str;
    }

    protected abstract Unpacker makeUnpacker(byte b) throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public UnpackingSoSource(Context context, String str) {
        super(getSoStorePath(context, str), 1);
        this.mLibsBeingLoaded = new HashMap();
        this.mContext = context;
    }

    protected UnpackingSoSource(Context context, File file) {
        super(file, 1);
        this.mLibsBeingLoaded = new HashMap();
        this.mContext = context;
    }

    public static File getSoStorePath(Context context, String str) {
        return new File(context.getApplicationInfo().dataDir + "/" + str);
    }

    @Override // com.facebook.soloader.SoSource
    public String[] getSoSourceAbis() {
        String[] strArr = this.mAbis;
        return strArr == null ? super.getSoSourceAbis() : strArr;
    }

    public void setSoSourceAbis(String[] strArr) {
        this.mAbis = strArr;
    }

    /* loaded from: classes6.dex */
    public static class Dso {
        public final String hash;
        public final String name;

        public Dso(String str, String str2) {
            this.name = str;
            this.hash = str2;
        }
    }

    /* loaded from: classes6.dex */
    public static final class DsoManifest {
        public final Dso[] dsos;

        public DsoManifest(Dso[] dsoArr) {
            this.dsos = dsoArr;
        }

        static final DsoManifest read(DataInput dataInput) throws IOException {
            if (dataInput.readByte() != 1) {
                throw new RuntimeException("wrong dso manifest version");
            }
            int readInt = dataInput.readInt();
            if (readInt < 0) {
                throw new RuntimeException("illegal number of shared libraries");
            }
            Dso[] dsoArr = new Dso[readInt];
            for (int i = 0; i < readInt; i++) {
                dsoArr[i] = new Dso(dataInput.readUTF(), dataInput.readUTF());
            }
            return new DsoManifest(dsoArr);
        }

        public final void write(DataOutput dataOutput) throws IOException {
            dataOutput.writeByte(1);
            dataOutput.writeInt(this.dsos.length);
            int i = 0;
            while (true) {
                Dso[] dsoArr = this.dsos;
                if (i >= dsoArr.length) {
                    return;
                }
                dataOutput.writeUTF(dsoArr[i].name);
                dataOutput.writeUTF(this.dsos[i].hash);
                i++;
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class InputDsoStream implements InputDso {
        private final InputStream content;
        private final Dso dso;

        public InputDsoStream(Dso dso, InputStream inputStream) {
            this.dso = dso;
            this.content = inputStream;
        }

        @Override // com.facebook.soloader.UnpackingSoSource.InputDso
        public void write(DataOutput dataOutput, byte[] bArr) throws IOException {
            SysUtil.copyBytes(dataOutput, this.content, Integer.MAX_VALUE, bArr);
        }

        @Override // com.facebook.soloader.UnpackingSoSource.InputDso
        public Dso getDso() {
            return this.dso;
        }

        @Override // com.facebook.soloader.UnpackingSoSource.InputDso
        public String getFileName() {
            return this.dso.name;
        }

        @Override // com.facebook.soloader.UnpackingSoSource.InputDso
        public int available() throws IOException {
            return this.content.available();
        }

        @Override // com.facebook.soloader.UnpackingSoSource.InputDso
        public InputStream getStream() {
            return this.content;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.content.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void writeState(File file, byte b) throws IOException {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                randomAccessFile.seek(0L);
                randomAccessFile.write(b);
                randomAccessFile.setLength(randomAccessFile.getFilePointer());
                randomAccessFile.getFD().sync();
                randomAccessFile.close();
            } finally {
            }
        } catch (SyncFailedException e) {
            Log.w(TAG, "state file sync failed", e);
        }
    }

    private void deleteUnmentionedFiles(Dso[] dsoArr) throws IOException {
        String[] list = this.soDirectory.list();
        if (list == null) {
            throw new IOException("unable to list directory " + this.soDirectory);
        }
        for (String str : list) {
            if (!str.equals(STATE_FILE_NAME) && !str.equals(LOCK_FILE_NAME) && !str.equals(INSTANCE_LOCK_FILE_NAME) && !str.equals(DEPS_FILE_NAME) && !str.equals(MANIFEST_FILE_NAME)) {
                boolean z = false;
                for (int i = 0; !z && i < dsoArr.length; i++) {
                    if (dsoArr[i].name.equals(getSoNameFromFileName(str))) {
                        z = true;
                    }
                }
                if (!z) {
                    File file = new File(this.soDirectory, str);
                    Log.v(TAG, "deleting unaccounted-for file " + file);
                    SysUtil.dumbDeleteRecursive(file);
                }
            }
        }
    }

    private void extractDso(InputDso inputDso, byte[] bArr) throws IOException {
        Log.i(TAG, "extracting DSO " + inputDso.getDso().name);
        try {
            if (!this.soDirectory.setWritable(true)) {
                throw new IOException("cannot make directory writable for us: " + this.soDirectory);
            }
            extractDsoImpl(inputDso, bArr);
        } finally {
            if (!this.soDirectory.setWritable(false)) {
                Log.w(TAG, "error removing " + this.soDirectory.getCanonicalPath() + " write permission");
            }
        }
    }

    private void extractDsoImpl(InputDso inputDso, byte[] bArr) throws IOException {
        RandomAccessFile randomAccessFile;
        File file = new File(this.soDirectory, inputDso.getFileName());
        RandomAccessFile randomAccessFile2 = null;
        try {
            try {
                if (file.exists() && !file.setWritable(true)) {
                    Log.w(TAG, "error adding write permission to: " + file);
                }
                try {
                    randomAccessFile = new RandomAccessFile(file, "rw");
                } catch (IOException e) {
                    Log.w(TAG, "error overwriting " + file + " trying to delete and start over", e);
                    SysUtil.dumbDeleteRecursive(file);
                    randomAccessFile = new RandomAccessFile(file, "rw");
                }
                randomAccessFile2 = randomAccessFile;
                int available = inputDso.available();
                if (available > 1) {
                    SysUtil.fallocateIfSupported(randomAccessFile2.getFD(), available);
                }
                inputDso.write(randomAccessFile2, bArr);
                randomAccessFile2.setLength(randomAccessFile2.getFilePointer());
                if (!file.setExecutable(true, false)) {
                    throw new IOException("cannot make file executable: " + file);
                }
                if (!file.setWritable(false)) {
                    Log.w(TAG, "error removing " + file + " write permission");
                }
                randomAccessFile2.close();
            } catch (IOException e2) {
                SysUtil.dumbDeleteRecursive(file);
                throw e2;
            }
        } catch (Throwable th) {
            if (!file.setWritable(false)) {
                Log.w(TAG, "error removing " + file + " write permission");
            }
            if (randomAccessFile2 != null) {
                randomAccessFile2.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0058 A[Catch: all -> 0x0034, TRY_LEAVE, TryCatch #1 {all -> 0x0034, blocks: (B:54:0x002f, B:7:0x0041, B:8:0x0048, B:9:0x0052, B:11:0x0058, B:34:0x00a6, B:41:0x00b5, B:48:0x00b2, B:57:0x0038, B:45:0x00ad, B:15:0x0060, B:17:0x0065, B:19:0x0077, B:23:0x008a, B:27:0x008d, B:31:0x00a1), top: B:2:0x002d, inners: #0, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0041 A[Catch: all -> 0x0034, TryCatch #1 {all -> 0x0034, blocks: (B:54:0x002f, B:7:0x0041, B:8:0x0048, B:9:0x0052, B:11:0x0058, B:34:0x00a6, B:41:0x00b5, B:48:0x00b2, B:57:0x0038, B:45:0x00ad, B:15:0x0060, B:17:0x0065, B:19:0x0077, B:23:0x008a, B:27:0x008d, B:31:0x00a1), top: B:2:0x002d, inners: #0, #3, #4 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void regenerate(byte b, DsoManifest dsoManifest, InputDsoIterator inputDsoIterator) throws IOException {
        DsoManifest read;
        Log.v(TAG, "regenerating DSO store " + getClass().getName());
        RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.soDirectory, MANIFEST_FILE_NAME), "rw");
        try {
            if (b == 1) {
                try {
                    read = DsoManifest.read(randomAccessFile);
                } catch (Exception e) {
                    Log.i(TAG, "error reading existing DSO manifest", e);
                }
                if (read == null) {
                    read = new DsoManifest(new Dso[0]);
                }
                deleteUnmentionedFiles(dsoManifest.dsos);
                byte[] bArr = new byte[32768];
                while (inputDsoIterator.hasNext()) {
                    InputDso next = inputDsoIterator.next();
                    boolean z = true;
                    int i = 0;
                    while (z) {
                        try {
                            if (i >= read.dsos.length) {
                                break;
                            }
                            if (read.dsos[i].name.equals(next.getDso().name) && read.dsos[i].hash.equals(next.getDso().hash)) {
                                z = false;
                            }
                            i++;
                        } finally {
                        }
                    }
                    if (!new File(this.soDirectory, next.getFileName()).exists()) {
                        z = true;
                    }
                    if (z) {
                        extractDso(next, bArr);
                    }
                    if (next != null) {
                        next.close();
                    }
                }
                randomAccessFile.close();
                Log.v(TAG, "Finished regenerating DSO store " + getClass().getName());
            }
            read = null;
            if (read == null) {
            }
            deleteUnmentionedFiles(dsoManifest.dsos);
            byte[] bArr2 = new byte[32768];
            while (inputDsoIterator.hasNext()) {
            }
            randomAccessFile.close();
            Log.v(TAG, "Finished regenerating DSO store " + getClass().getName());
        } catch (Throwable th) {
            try {
                randomAccessFile.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    protected boolean depsChanged(byte[] bArr, byte[] bArr2) {
        return !Arrays.equals(bArr, bArr2);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00a1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected boolean refreshLocked(FileLocker fileLocker, int i, byte[] bArr) throws IOException {
        byte b;
        Unpacker makeUnpacker;
        DsoManifest dsoManifest;
        InputDsoIterator openDsoIterator;
        DsoManifest dsoManifest2;
        File file = new File(this.soDirectory, STATE_FILE_NAME);
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        try {
            b = randomAccessFile.readByte();
        } catch (EOFException unused) {
        } catch (Throwable th) {
            throw th;
        }
        if (b != 1) {
            Log.v(TAG, "dso store " + this.soDirectory + " regeneration interrupted: wiping clean");
            b = 0;
        }
        randomAccessFile.close();
        File file2 = new File(this.soDirectory, DEPS_FILE_NAME);
        randomAccessFile = new RandomAccessFile(file2, "rw");
        try {
            int length = (int) randomAccessFile.length();
            byte[] bArr2 = new byte[length];
            if (randomAccessFile.read(bArr2) != length) {
                Log.v(TAG, "short read of so store deps file: marking unclean");
                b = 0;
            }
            if (depsChanged(bArr2, bArr)) {
                Log.v(TAG, "deps mismatch on deps store: regenerating");
                b = 0;
            }
            try {
                try {
                    if (b != 0 && (i & 2) == 0) {
                        dsoManifest2 = null;
                        randomAccessFile.close();
                        if (dsoManifest2 != null) {
                            return false;
                        }
                        Runnable createSyncer = createSyncer(fileLocker, bArr, file, file2, dsoManifest2, false);
                        if ((i & 1) != 0) {
                            new Thread(createSyncer, "SoSync:" + this.soDirectory.getName()).start();
                        } else {
                            createSyncer.run();
                        }
                        return true;
                    }
                    regenerate(b, dsoManifest, openDsoIterator);
                    if (openDsoIterator != null) {
                        openDsoIterator.close();
                    }
                    if (makeUnpacker != null) {
                        makeUnpacker.close();
                    }
                    dsoManifest2 = dsoManifest;
                    randomAccessFile.close();
                    if (dsoManifest2 != null) {
                    }
                } finally {
                }
                dsoManifest = makeUnpacker.getDsoManifest();
                openDsoIterator = makeUnpacker.openDsoIterator();
            } finally {
            }
            Log.v(TAG, "so store dirty: regenerating");
            writeState(file, (byte) 0);
            makeUnpacker = makeUnpacker(b);
        } finally {
            try {
                randomAccessFile.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
        }
    }

    private Runnable createSyncer(final FileLocker fileLocker, final byte[] bArr, final File file, final File file2, final DsoManifest dsoManifest, final Boolean bool) {
        return new Runnable() { // from class: com.facebook.soloader.UnpackingSoSource.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    try {
                        Log.v(UnpackingSoSource.TAG, "starting syncer worker");
                        RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
                        try {
                            randomAccessFile.write(bArr);
                            randomAccessFile.setLength(randomAccessFile.getFilePointer());
                            randomAccessFile.close();
                            randomAccessFile = new RandomAccessFile(new File(UnpackingSoSource.this.soDirectory, UnpackingSoSource.MANIFEST_FILE_NAME), "rw");
                            try {
                                dsoManifest.write(randomAccessFile);
                                randomAccessFile.close();
                                SysUtil.fsyncRecursive(UnpackingSoSource.this.soDirectory);
                                UnpackingSoSource.writeState(file, (byte) 1);
                            } finally {
                                try {
                                    randomAccessFile.close();
                                } catch (Throwable th) {
                                    th.addSuppressed(th);
                                }
                            }
                        } finally {
                        }
                    } catch (IOException e) {
                        if (!bool.booleanValue()) {
                            throw new RuntimeException(e);
                        }
                    }
                } finally {
                    Log.v(UnpackingSoSource.TAG, "releasing dso store lock for " + UnpackingSoSource.this.soDirectory + " (from syncer thread)");
                    fileLocker.close();
                }
            }
        };
    }

    protected byte[] getDepsBlock() throws IOException {
        Parcel obtain = Parcel.obtain();
        Unpacker makeUnpacker = makeUnpacker((byte) 1);
        try {
            Dso[] dsoArr = makeUnpacker.getDsoManifest().dsos;
            obtain.writeByte((byte) 1);
            obtain.writeInt(dsoArr.length);
            for (int i = 0; i < dsoArr.length; i++) {
                obtain.writeString(dsoArr[i].name);
                obtain.writeString(dsoArr[i].hash);
            }
            if (makeUnpacker != null) {
                makeUnpacker.close();
            }
            byte[] marshall = obtain.marshall();
            obtain.recycle();
            return marshall;
        } catch (Throwable th) {
            if (makeUnpacker != null) {
                try {
                    makeUnpacker.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Nullable
    protected FileLocker getOrCreateLock(File file, boolean z) throws IOException {
        return SysUtil.getOrCreateLockOnDir(this.soDirectory, file, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.soloader.SoSource
    public void prepare(int i) throws IOException {
        SysUtil.mkdirOrThrow(this.soDirectory);
        FileLocker orCreateLock = getOrCreateLock(new File(this.soDirectory, LOCK_FILE_NAME), true);
        if (this.mInstanceLock == null) {
            this.mInstanceLock = getOrCreateLock(new File(this.soDirectory, INSTANCE_LOCK_FILE_NAME), false);
        }
        boolean canWrite = this.soDirectory.canWrite();
        try {
            Log.v(TAG, "locked dso store " + this.soDirectory);
            if (!canWrite) {
                this.soDirectory.setWritable(true);
            }
            if (refreshLocked(orCreateLock, i, getDepsBlock())) {
                orCreateLock = null;
            } else {
                Log.i(TAG, "dso store is up-to-date: " + this.soDirectory);
            }
        } finally {
            if (!canWrite) {
                this.soDirectory.setWritable(false);
            }
            if (orCreateLock != null) {
                Log.v(TAG, "releasing dso store lock for " + this.soDirectory);
                orCreateLock.close();
            } else {
                Log.v(TAG, "not releasing dso store lock for " + this.soDirectory + " (syncer thread started)");
            }
        }
    }

    private Object getLibraryLock(String str) {
        Object obj;
        synchronized (this.mLibsBeingLoaded) {
            obj = this.mLibsBeingLoaded.get(str);
            if (obj == null) {
                obj = new Object();
                this.mLibsBeingLoaded.put(str, obj);
            }
        }
        return obj;
    }

    @Override // com.facebook.soloader.DirectorySoSource, com.facebook.soloader.SoSource
    @Nullable
    public String getLibraryPath(String str) throws IOException {
        File soFileByName = getSoFileByName(str);
        if (soFileByName == null) {
            return null;
        }
        return soFileByName.getCanonicalPath();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void prepare(String str) throws IOException {
        synchronized (getLibraryLock(str)) {
            this.mCorruptedLib = str;
            prepare(2);
        }
    }

    @Override // com.facebook.soloader.DirectorySoSource, com.facebook.soloader.SoSource
    public int loadLibrary(String str, int i, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        int loadLibraryFrom;
        synchronized (getLibraryLock(str)) {
            loadLibraryFrom = loadLibraryFrom(str, i, this.soDirectory, threadPolicy);
        }
        return loadLibraryFrom;
    }
}
