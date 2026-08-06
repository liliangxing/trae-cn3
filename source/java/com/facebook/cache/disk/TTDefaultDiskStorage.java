package com.facebook.cache.disk;

import android.os.Environment;
import com.facebook.binaryresource.BinaryResource;
import com.facebook.binaryresource.FileBinaryResource;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.WriterCallback;
import com.facebook.cache.disk.DiskStorage;
import com.facebook.common.file.FileTree;
import com.facebook.common.file.FileTreeVisitor;
import com.facebook.common.file.FileUtils;
import com.facebook.common.internal.CountingOutputStream;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClock;
import com.huawei.hms.framework.common.BundleUtil;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class TTDefaultDiskStorage implements TTDiskStorage {
    private static final String CONTENT_FILE_EXTENSION = ".cnt";
    private static final String DEFAULT_DISK_STORAGE_VERSION_PREFIX = "v2";
    private static final int SHARDING_BUCKET_COUNT = 100;
    private static final String TEMP_FILE_EXTENSION = ".tmp";
    private final CacheErrorLogger mCacheErrorLogger;
    private final Clock mClock;
    private final File mConfigRootDirectory;
    private final File mConfigVersionDirectory;
    private final boolean mIsExternal;
    private final File mOldConfigVersionDirectory;
    private final File mRootDirectory;
    private final File mVersionDirectory;
    private static final Class<?> TAG = DefaultDiskStorage.class;
    static final long TEMP_FILE_LIFETIME_MS = TimeUnit.MINUTES.toMillis(30);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public enum FileCategory {
        IMAGE_CACHE_FILE,
        CONFIG_FILE
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public boolean isEnabled() {
        return true;
    }

    public TTDefaultDiskStorage(File file, File file2, int i, CacheErrorLogger cacheErrorLogger) {
        Preconditions.checkNotNull(file);
        this.mRootDirectory = file;
        this.mConfigRootDirectory = file2;
        this.mIsExternal = isExternal(file, cacheErrorLogger);
        this.mVersionDirectory = new File(file, getVersionSubdirectoryName(i));
        this.mOldConfigVersionDirectory = new File(file, getVersionSubdirectoryName(i) + "-config");
        this.mConfigVersionDirectory = new File(file2, getVersionSubdirectoryName(i) + "-config2.0");
        this.mCacheErrorLogger = cacheErrorLogger;
        recreateDirectoryIfVersionChanges();
        recreateConfigDirectoryIfVersionChanges();
        this.mClock = SystemClock.get();
    }

    private static boolean isExternal(File file, CacheErrorLogger cacheErrorLogger) {
        String str;
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory != null) {
            String file2 = externalStorageDirectory.toString();
            try {
                str = file.getCanonicalPath();
            } catch (IOException e) {
                e = e;
                str = null;
            }
            try {
                return str.contains(file2);
            } catch (IOException e2) {
                e = e2;
                cacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.OTHER, TAG, "failed to read folder to check if external: " + str, e);
                return false;
            }
        }
        return false;
    }

    static String getVersionSubdirectoryName(int i) {
        return String.format(null, "%s.ols%d.%d", DEFAULT_DISK_STORAGE_VERSION_PREFIX, 100, Integer.valueOf(i));
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public boolean isExternal() {
        return this.mIsExternal;
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public String getStorageName() {
        String absolutePath = this.mRootDirectory.getAbsolutePath();
        return BundleUtil.UNDERLINE_TAG + absolutePath.substring(absolutePath.lastIndexOf(47) + 1, absolutePath.length()) + BundleUtil.UNDERLINE_TAG + absolutePath.hashCode();
    }

    private void recreateDirectoryIfVersionChanges() {
        boolean z = true;
        if (this.mRootDirectory.exists()) {
            if (this.mVersionDirectory.exists()) {
                z = false;
            } else {
                FileTree.deleteRecursively(this.mRootDirectory);
            }
        }
        if (z) {
            try {
                FileUtils.mkdirs(this.mVersionDirectory);
            } catch (FileUtils.CreateDirectoryException unused) {
                this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, TAG, "version directory could not be created: " + this.mVersionDirectory, null);
            }
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    private static class IncompleteFileException extends IOException {
        public final long actual;
        public final long expected;

        public IncompleteFileException(long j, long j2) {
            super("File was not written completely. Expected: " + j + ", found: " + j2);
            this.expected = j;
            this.actual = j2;
        }
    }

    File getContentFileFor(String str) {
        return new File(getFilename(str));
    }

    private String getSubdirectoryPath(String str) {
        return this.mVersionDirectory + File.separator + String.valueOf(Math.abs(str.hashCode() % 100));
    }

    private File getSubdirectory(String str) {
        return new File(getSubdirectoryPath(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class EntriesCollector implements FileTreeVisitor {
        private final List<DiskStorage.Entry> result;

        @Override // com.facebook.common.file.FileTreeVisitor
        public void postVisitDirectory(File file) {
        }

        @Override // com.facebook.common.file.FileTreeVisitor
        public void preVisitDirectory(File file) {
        }

        private EntriesCollector() {
            this.result = new ArrayList();
        }

        @Override // com.facebook.common.file.FileTreeVisitor
        public void visitFile(File file) {
            FileInfo shardFileInfo = TTDefaultDiskStorage.this.getShardFileInfo(file);
            if (shardFileInfo == null || shardFileInfo.type != FileType.CONTENT) {
                return;
            }
            this.result.add(new EntryImpl(shardFileInfo.resourceId, file));
        }

        public List<DiskStorage.Entry> getEntries() {
            return Collections.unmodifiableList(this.result);
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    private class PurgingVisitor implements FileTreeVisitor {
        private boolean insideBaseDirectory;

        private PurgingVisitor() {
        }

        @Override // com.facebook.common.file.FileTreeVisitor
        public void preVisitDirectory(File file) {
            if (this.insideBaseDirectory || !file.equals(TTDefaultDiskStorage.this.mVersionDirectory)) {
                return;
            }
            this.insideBaseDirectory = true;
        }

        @Override // com.facebook.common.file.FileTreeVisitor
        public void visitFile(File file) {
            if (this.insideBaseDirectory && isExpectedFile(file)) {
                return;
            }
            file.delete();
        }

        @Override // com.facebook.common.file.FileTreeVisitor
        public void postVisitDirectory(File file) {
            if (!TTDefaultDiskStorage.this.mRootDirectory.equals(file) && !this.insideBaseDirectory) {
                file.delete();
            }
            if (this.insideBaseDirectory && file.equals(TTDefaultDiskStorage.this.mVersionDirectory)) {
                this.insideBaseDirectory = false;
            }
        }

        private boolean isExpectedFile(File file) {
            FileInfo shardFileInfo = TTDefaultDiskStorage.this.getShardFileInfo(file);
            if (shardFileInfo == null) {
                return false;
            }
            if (shardFileInfo.type == FileType.TEMP) {
                return isRecentFile(file);
            }
            Preconditions.checkState(shardFileInfo.type == FileType.CONTENT);
            return true;
        }

        private boolean isRecentFile(File file) {
            return file.lastModified() > TTDefaultDiskStorage.this.mClock.now() - TTDefaultDiskStorage.TEMP_FILE_LIFETIME_MS;
        }
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public void purgeUnexpectedResources() {
        FileTree.walkFileTree(this.mRootDirectory, new PurgingVisitor());
    }

    private void mkdirs(File file, String str) throws IOException {
        try {
            FileUtils.mkdirs(file);
        } catch (FileUtils.CreateDirectoryException e) {
            this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, TAG, str, e);
            throw e;
        }
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public DiskStorage.Inserter insert(String str, Object obj) throws IOException {
        FileInfo fileInfo = new FileInfo(FileType.TEMP, str);
        File subdirectory = getSubdirectory(fileInfo.resourceId);
        if (!subdirectory.exists()) {
            mkdirs(subdirectory, "insert");
        }
        try {
            File createTempFile = fileInfo.createTempFile(subdirectory);
            insertConfigFile(str, obj);
            return new InserterImpl(str, createTempFile);
        } catch (IOException e) {
            this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_TEMPFILE, TAG, "insert", e);
            throw e;
        }
    }

    @Override // com.facebook.cache.disk.TTDiskStorage
    public DiskStorage.Inserter insertTemp(String str, int i, Object obj) throws IOException {
        FileInfo fileInfo = new FileInfo(FileType.TEMP, str);
        File subdirectory = getSubdirectory(fileInfo.resourceId);
        if (!subdirectory.exists()) {
            mkdirs(subdirectory, "insert");
        }
        try {
            return new TempInserterImpl(str, i, fileInfo.createTempFile(subdirectory));
        } catch (IOException e) {
            this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_TEMPFILE, TAG, "insert", e);
            throw e;
        }
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public BinaryResource getResource(String str, Object obj) {
        File contentFileFor = getContentFileFor(str);
        if (!contentFileFor.exists()) {
            return null;
        }
        contentFileFor.setLastModified(this.mClock.now());
        return FileBinaryResource.createOrNull(contentFileFor);
    }

    @Override // com.facebook.cache.disk.TTDiskStorage
    public BinaryResource getTempResource(String str, Object obj) {
        File file = new File(getTempFileName(str));
        if (!file.exists()) {
            return null;
        }
        file.setLastModified(this.mClock.now());
        return FileBinaryResource.createOrNull(file);
    }

    private String getTempFileName(String str) {
        FileInfo fileInfo = new FileInfo(FileType.TEMP, str);
        return fileInfo.toPath(getSubdirectoryPath(fileInfo.resourceId));
    }

    private String getFilename(String str) {
        FileInfo fileInfo = new FileInfo(FileType.CONTENT, str);
        return fileInfo.toPath(getSubdirectoryPath(fileInfo.resourceId));
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public boolean contains(String str, Object obj) {
        return query(str, false);
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public boolean touch(String str, Object obj) {
        return query(str, true);
    }

    private boolean query(String str, boolean z) {
        File contentFileFor = getContentFileFor(str);
        boolean exists = contentFileFor.exists();
        if (z && exists) {
            contentFileFor.setLastModified(this.mClock.now());
        }
        return exists;
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public long remove(DiskStorage.Entry entry) {
        return doRemove(((EntryImpl) entry).getResource().getFile());
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public long remove(String str) {
        return doRemove(getContentFileFor(str));
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public long removeConfig(String str) {
        doRemove(new File((this.mOldConfigVersionDirectory + File.separator + String.valueOf(Math.abs(str.hashCode() % 100))) + File.separator + str + ".cnt"));
        return doRemove(getConfigFileFor(str));
    }

    private long doRemove(File file) {
        if (!file.exists()) {
            return 0L;
        }
        long length = file.length();
        if (file.delete()) {
            return length;
        }
        return -1L;
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public void clearAll() {
        FileTree.deleteContents(this.mRootDirectory);
        FileTree.deleteContents(this.mConfigRootDirectory);
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public DiskStorage.DiskDumpInfo getDumpInfo() throws IOException {
        List<DiskStorage.Entry> entries = getEntries();
        DiskStorage.DiskDumpInfo diskDumpInfo = new DiskStorage.DiskDumpInfo();
        Iterator<DiskStorage.Entry> it = entries.iterator();
        while (it.hasNext()) {
            DiskStorage.DiskDumpInfoEntry dumpCacheEntry = dumpCacheEntry(it.next());
            String str = dumpCacheEntry.type;
            if (!diskDumpInfo.typeCounts.containsKey(str)) {
                diskDumpInfo.typeCounts.put(str, 0);
            }
            diskDumpInfo.typeCounts.put(str, Integer.valueOf(diskDumpInfo.typeCounts.get(str).intValue() + 1));
            diskDumpInfo.entries.add(dumpCacheEntry);
        }
        return diskDumpInfo;
    }

    private DiskStorage.DiskDumpInfoEntry dumpCacheEntry(DiskStorage.Entry entry) throws IOException {
        String str;
        EntryImpl entryImpl = (EntryImpl) entry;
        byte[] read = entryImpl.getResource().read();
        String typeOfBytes = typeOfBytes(read);
        if (!typeOfBytes.equals("undefined") || read.length < 4) {
            str = "";
        } else {
            str = String.format(null, "0x%02X 0x%02X 0x%02X 0x%02X", Byte.valueOf(read[0]), Byte.valueOf(read[1]), Byte.valueOf(read[2]), Byte.valueOf(read[3]));
        }
        return new DiskStorage.DiskDumpInfoEntry(entryImpl.getResource().getFile().getPath(), typeOfBytes, (float) entryImpl.getSize(), str);
    }

    private String typeOfBytes(byte[] bArr) {
        if (bArr.length < 2) {
            return "undefined";
        }
        byte b = bArr[0];
        return (b == -1 && bArr[1] == -40) ? "jpg" : (b == -119 && bArr[1] == 80) ? "png" : (b == 82 && bArr[1] == 73) ? "webp" : (b == 71 && bArr[1] == 73) ? "gif" : "undefined";
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public List<DiskStorage.Entry> getEntries() throws IOException {
        EntriesCollector entriesCollector = new EntriesCollector();
        FileTree.walkFileTree(this.mVersionDirectory, entriesCollector);
        return entriesCollector.getEntries();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class EntryImpl implements DiskStorage.Entry {

        /* renamed from: id */
        private final String f352id;
        private final FileBinaryResource resource;
        private long size;
        private long timestamp;

        private EntryImpl(String str, File file) {
            Preconditions.checkNotNull(file);
            this.f352id = (String) Preconditions.checkNotNull(str);
            this.resource = FileBinaryResource.createOrNull(file);
            this.size = -1L;
            this.timestamp = -1L;
        }

        @Override // com.facebook.cache.disk.DiskStorage.Entry
        public String getId() {
            return this.f352id;
        }

        @Override // com.facebook.cache.disk.DiskStorage.Entry
        public long getTimestamp() {
            if (this.timestamp < 0) {
                this.timestamp = this.resource.getFile().lastModified();
            }
            return this.timestamp;
        }

        @Override // com.facebook.cache.disk.DiskStorage.Entry
        public FileBinaryResource getResource() {
            return this.resource;
        }

        @Override // com.facebook.cache.disk.DiskStorage.Entry
        public long getSize() {
            if (this.size < 0) {
                this.size = this.resource.size();
            }
            return this.size;
        }

        @Override // com.facebook.cache.disk.DiskStorage.Entry
        public int getVisitCount() {
            return DiskCacheUtil.getVisitCount(this.f352id);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FileInfo getShardFileInfo(File file) {
        FileInfo fromFile = FileInfo.fromFile(file);
        if (fromFile != null && getSubdirectory(fromFile.resourceId).equals(file.getParentFile())) {
            return fromFile;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public enum FileType {
        CONTENT(".cnt"),
        TEMP(".tmp");

        public final String extension;

        FileType(String str) {
            this.extension = str;
        }

        public static FileType fromExtension(String str) {
            if (".cnt".equals(str)) {
                return CONTENT;
            }
            if (".tmp".equals(str)) {
                return TEMP;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class FileInfo {
        public final String resourceId;
        public final FileType type;

        private FileInfo(FileType fileType, String str) {
            this.type = fileType;
            this.resourceId = str;
        }

        public String toString() {
            return this.type + "(" + this.resourceId + ")";
        }

        public String toPath(String str) {
            return str + File.separator + this.resourceId + this.type.extension;
        }

        public File createTempFile(File file) throws IOException {
            File file2 = new File(file, this.resourceId + ".tmp");
            if (!file2.exists()) {
                file2.createNewFile();
            }
            return file2;
        }

        public static FileInfo fromFile(File file) {
            FileType fromExtension;
            String name = file.getName();
            int lastIndexOf = name.lastIndexOf(46);
            if (lastIndexOf <= 0 || (fromExtension = FileType.fromExtension(name.substring(lastIndexOf))) == null) {
                return null;
            }
            String substring = name.substring(0, lastIndexOf);
            if (fromExtension.equals(FileType.TEMP)) {
                int lastIndexOf2 = substring.lastIndexOf(46);
                if (lastIndexOf2 <= 0) {
                    return null;
                }
                substring = substring.substring(0, lastIndexOf2);
            }
            return new FileInfo(fromExtension, substring);
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class TempInserterImpl extends InserterImpl {
        private CountingOutputStream countingStream;
        private FileOutputStream fileStream;
        private boolean isFinal;
        private int offset;

        @Override // com.facebook.cache.disk.TTDefaultDiskStorage.InserterImpl, com.facebook.cache.disk.DiskStorage.Inserter
        public /* bridge */ /* synthetic */ boolean cleanUp() {
            return super.cleanUp();
        }

        @Override // com.facebook.cache.disk.TTDefaultDiskStorage.InserterImpl, com.facebook.cache.disk.DiskStorage.Inserter
        public /* bridge */ /* synthetic */ BinaryResource commit(Object obj) throws IOException {
            return super.commit(obj);
        }

        public TempInserterImpl(String str, int i, File file) {
            super(str, file);
            this.isFinal = false;
            this.offset = i;
        }

        public CountingOutputStream getCountingStream() {
            return this.countingStream;
        }

        public void setFinal(boolean z) {
            this.isFinal = z;
        }

        @Override // com.facebook.cache.disk.TTDefaultDiskStorage.InserterImpl, com.facebook.cache.disk.DiskStorage.Inserter
        public void writeData(WriterCallback writerCallback, Object obj) throws IOException {
            try {
                if (this.mTemporaryFile != null) {
                    long length = this.mTemporaryFile.length();
                    int i = this.offset;
                    if (length != i && i > 0) {
                        return;
                    }
                }
                if (this.fileStream == null) {
                    this.fileStream = new FileOutputStream(this.mTemporaryFile, this.offset > 0);
                }
                try {
                    if (this.countingStream == null) {
                        this.countingStream = new CountingOutputStream(this.fileStream);
                    }
                    writerCallback.write(this.countingStream);
                    this.countingStream.flush();
                } finally {
                    if (this.isFinal) {
                        this.fileStream.close();
                    }
                }
            } catch (FileNotFoundException e) {
                TTDefaultDiskStorage.this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.WRITE_UPDATE_FILE_NOT_FOUND, TTDefaultDiskStorage.TAG, "updateResource", e);
                throw e;
            }
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    class InserterImpl implements DiskStorage.Inserter {
        private final String mResourceId;
        final File mTemporaryFile;

        public InserterImpl(String str, File file) {
            this.mResourceId = str;
            this.mTemporaryFile = file;
        }

        @Override // com.facebook.cache.disk.DiskStorage.Inserter
        public void writeData(WriterCallback writerCallback, Object obj) throws IOException {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.mTemporaryFile);
                try {
                    CountingOutputStream countingOutputStream = new CountingOutputStream(fileOutputStream);
                    writerCallback.write(countingOutputStream);
                    countingOutputStream.flush();
                    long count = countingOutputStream.getCount();
                    fileOutputStream.close();
                    if (this.mTemporaryFile.length() != count) {
                        throw new IncompleteFileException(count, this.mTemporaryFile.length());
                    }
                } catch (Throwable th) {
                    fileOutputStream.close();
                    throw th;
                }
            } catch (FileNotFoundException e) {
                TTDefaultDiskStorage.this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.WRITE_UPDATE_FILE_NOT_FOUND, TTDefaultDiskStorage.TAG, "updateResource", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.DiskStorage.Inserter
        public BinaryResource commit(Object obj) throws IOException {
            CacheErrorLogger.CacheErrorCategory cacheErrorCategory;
            File contentFileFor = TTDefaultDiskStorage.this.getContentFileFor(this.mResourceId);
            try {
                FileUtils.rename(this.mTemporaryFile, contentFileFor);
                if (contentFileFor.exists()) {
                    contentFileFor.setLastModified(TTDefaultDiskStorage.this.mClock.now());
                }
                return FileBinaryResource.createOrNull(contentFileFor);
            } catch (FileUtils.RenameException e) {
                Throwable cause = e.getCause();
                if (cause == null) {
                    cacheErrorCategory = CacheErrorLogger.CacheErrorCategory.WRITE_RENAME_FILE_OTHER;
                } else if (cause instanceof FileUtils.ParentDirNotFoundException) {
                    cacheErrorCategory = CacheErrorLogger.CacheErrorCategory.WRITE_RENAME_FILE_TEMPFILE_PARENT_NOT_FOUND;
                } else if (cause instanceof FileNotFoundException) {
                    cacheErrorCategory = CacheErrorLogger.CacheErrorCategory.WRITE_RENAME_FILE_TEMPFILE_NOT_FOUND;
                } else {
                    cacheErrorCategory = CacheErrorLogger.CacheErrorCategory.WRITE_RENAME_FILE_OTHER;
                }
                TTDefaultDiskStorage.this.mCacheErrorLogger.logError(cacheErrorCategory, TTDefaultDiskStorage.TAG, "commit", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.DiskStorage.Inserter
        public boolean cleanUp() {
            return !this.mTemporaryFile.exists() || this.mTemporaryFile.delete();
        }
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public Map<String, String> getResourceConfig(String str, Object obj) throws IOException {
        Map<String, String> fileToMap = fileToMap(new File((this.mOldConfigVersionDirectory + File.separator + String.valueOf(Math.abs(str.hashCode() % 100))) + File.separator + str + ".cnt"));
        fileToMap.putAll(fileToMap(getConfigFileFor(str)));
        return fileToMap;
    }

    private File getConfigFileFor(String str) {
        return new File(getConfigSubdirectoryPath(str));
    }

    private void recreateConfigDirectoryIfVersionChanges() {
        boolean z = true;
        if (this.mRootDirectory.exists()) {
            if (this.mVersionDirectory.exists()) {
                z = false;
            } else {
                FileTree.deleteRecursively(this.mRootDirectory);
            }
        }
        if (z) {
            try {
                FileUtils.mkdirs(this.mVersionDirectory);
            } catch (FileUtils.CreateDirectoryException unused) {
                this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, TAG, "version directory could not be created: " + this.mVersionDirectory, null);
            }
        }
    }

    private String getConfigSubdirectoryPath(String str) {
        return this.mConfigVersionDirectory + File.separator + String.valueOf(Math.abs(str.hashCode() % 100));
    }

    private void insertConfigFile(String str, Object obj) throws IOException {
        if (obj instanceof DiskWrapperCacheKey) {
            DiskWrapperCacheKey diskWrapperCacheKey = (DiskWrapperCacheKey) obj;
            File subdirectory = getSubdirectory(str);
            if (!subdirectory.exists()) {
                mkdirs(subdirectory, "insert");
            }
            mapToFile(diskWrapperCacheKey.getExtraInfo(), File.createTempFile(str + ".", ".cnt", subdirectory));
        }
    }

    private File mapToFile(Map<String, String> map, File file) throws IOException {
        StringBuilder sb = new StringBuilder();
        FileWriter fileWriter = new FileWriter(file, false);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            sb.append(key).append(ContainerUtils.KEY_VALUE_DELIMITER).append(entry.getValue()).append(System.lineSeparator());
        }
        fileWriter.write(sb.toString());
        fileWriter.close();
        return file;
    }

    private Map<String, String> fileToMap(File file) {
        HashMap hashMap = new HashMap();
        BufferedReader bufferedReader = null;
        String str = null;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                try {
                    BufferedReader bufferedReader3 = new BufferedReader(new FileReader(file));
                    while (true) {
                        try {
                            String readLine = bufferedReader3.readLine();
                            if (readLine == null) {
                                break;
                            }
                            String[] split = readLine.split(ContainerUtils.KEY_VALUE_DELIMITER);
                            String str2 = split[0];
                            hashMap.put(str2, split[1]);
                            str = str2;
                        } catch (IOException e) {
                            e = e;
                            bufferedReader2 = bufferedReader3;
                            e.printStackTrace();
                            bufferedReader = bufferedReader2;
                            if (bufferedReader2 != null) {
                                bufferedReader2.close();
                                bufferedReader = bufferedReader2;
                            }
                            return hashMap;
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = bufferedReader3;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException unused) {
                                }
                            }
                            throw th;
                        }
                    }
                    bufferedReader3.close();
                    bufferedReader3.close();
                    bufferedReader = str;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e2) {
                e = e2;
            }
        } catch (IOException unused2) {
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class ConfigEntriesCollector implements FileTreeVisitor {
        private FileCategory mFileCategory;
        private final List<DiskStorage.Entry> result = new ArrayList();

        @Override // com.facebook.common.file.FileTreeVisitor
        public void postVisitDirectory(File file) {
        }

        @Override // com.facebook.common.file.FileTreeVisitor
        public void preVisitDirectory(File file) {
        }

        public ConfigEntriesCollector(FileCategory fileCategory) {
            this.mFileCategory = fileCategory;
        }

        @Override // com.facebook.common.file.FileTreeVisitor
        public void visitFile(File file) {
            if (this.mFileCategory == FileCategory.CONFIG_FILE) {
                FileInfo configShardFileInfo = TTDefaultDiskStorage.this.getConfigShardFileInfo(file);
                if (configShardFileInfo == null || configShardFileInfo.type != FileType.CONTENT) {
                    return;
                }
                this.result.add(new EntryImpl(configShardFileInfo.resourceId, file));
                return;
            }
            FileInfo shardFileInfo = TTDefaultDiskStorage.this.getShardFileInfo(file);
            if (shardFileInfo != null) {
                if (shardFileInfo.type == FileType.CONTENT || shardFileInfo.type == FileType.TEMP) {
                    this.result.add(new EntryImpl(shardFileInfo.resourceId, file));
                }
            }
        }

        public List<DiskStorage.Entry> getEntries() {
            return Collections.unmodifiableList(this.result);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FileInfo getConfigShardFileInfo(File file) {
        FileInfo fromFile = FileInfo.fromFile(file);
        if (fromFile != null && new File(getConfigSubdirectoryPath(fromFile.resourceId)).equals(file.getParentFile())) {
            return fromFile;
        }
        return null;
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public List<DiskStorage.Entry> getConfigEntries() throws IOException {
        ConfigEntriesCollector configEntriesCollector = new ConfigEntriesCollector(FileCategory.CONFIG_FILE);
        FileTree.walkFileTree(this.mConfigVersionDirectory, configEntriesCollector);
        return configEntriesCollector.getEntries();
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public List<DiskStorage.Entry> getDiskCacheEntries() throws IOException {
        ConfigEntriesCollector configEntriesCollector = new ConfigEntriesCollector(FileCategory.IMAGE_CACHE_FILE);
        FileTree.walkFileTree(this.mVersionDirectory, configEntriesCollector);
        return configEntriesCollector.getEntries();
    }
}
