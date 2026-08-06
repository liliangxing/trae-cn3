package com.bytedance.reparo.core.parse;

import android.text.TextUtils;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedance.reparo.core.Options;
import com.bytedance.reparo.core.common.utils.FileUtils;
import com.bytedance.reparo.core.exception.PatchException;
import com.bytedance.reparo.core.exception.PatchParseException;
import com.bytedance.reparo.core.parse.SoInfoParser;
import com.bytedance.reparo.core.utils.Predicate;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class PatchFileParser {
    public static final String FILE_ADDED_CLASSES = "added_classes.txt";
    public static final String FILE_DEOPTIMIZE_METHODS = "deoptimize_methods.txt";
    public static final String FILE_DEOPTIMIZE_METHODS_L = "deoptimize_methods_l.txt";
    public static final String FILE_DEOPTIMIZE_METHODS_MN = "deoptimize_methods_mn.txt";
    public static final String FILE_DEOPTIMIZE_METHODS_OS = "deoptimize_methods_os.txt";
    public static final String FILE_DEOPTIMIZE_METHODS_PREFIX = "deoptimize_methods";
    public static final String FILE_PATCH_CLASSES_METHODS = "patch_classes_methods.txt";
    public static final String JAVA_PATCH_ROOT_DIR_NAME = "java";
    public static final String SO_INFO_FILE_NAME = "so-info.txt";
    private static final String TAG = "PatchFileParser";
    private AbiHelper abiHelper;
    private File javaPatchRootDir;
    private Options options;
    private File patchFile;
    private Map<String, SoFileList> soFiles = new HashMap();
    private File soInfoFile;
    private File unzipDir;

    public PatchFileParser(File file, AbiHelper abiHelper, File file2, Options options) {
        this.patchFile = file;
        this.abiHelper = abiHelper;
        this.unzipDir = file2;
        this.options = options;
        this.soInfoFile = new File(file2, SO_INFO_FILE_NAME);
        this.javaPatchRootDir = new File(file2, JAVA_PATCH_ROOT_DIR_NAME);
    }

    public String getHostAbi() {
        return this.abiHelper.getHostAbi();
    }

    public void parse() {
        try {
            ZipFile zipFile = new ZipFile(this.patchFile);
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry nextElement = entries.nextElement();
                if (!nextElement.getName().contains("..")) {
                    parseEntry(zipFile, nextElement);
                }
            }
            zipFile.close();
            configSoLibraries();
        } catch (IOException e) {
            throw new PatchParseException(e.getMessage(), e, PatchException.ERR_INSTALL_PARSE_IO);
        }
    }

    private void configSoLibraries() {
        SoFile findSoFile;
        List<SoInfoParser.SoInfo> parse = SoInfoParser.parse(this.soInfoFile);
        if (parse == null || parse.size() == 0) {
            return;
        }
        for (final SoInfoParser.SoInfo soInfo : parse) {
            Iterator<String> it = this.soFiles.keySet().iterator();
            while (it.hasNext()) {
                SoFileList soFileList = this.soFiles.get(it.next());
                if (soFileList != null && (findSoFile = soFileList.findSoFile(new Predicate<SoFile>() { // from class: com.bytedance.reparo.core.parse.PatchFileParser.1
                    @Override // com.bytedance.reparo.core.utils.Predicate
                    public boolean apply(SoFile soFile) {
                        return TextUtils.equals(soFile.name, soInfo.name);
                    }
                })) != null) {
                    findSoFile.isDiff = soInfo.isDiff;
                }
            }
        }
    }

    private void parseEntry(ZipFile zipFile, ZipEntry zipEntry) {
        if (this.options.enableSoFix) {
            if (zipEntry.getName().endsWith(LibrarianImpl.Constants.SO_SUFFIX)) {
                parseSoEntry(zipFile, zipEntry);
                return;
            } else if (TextUtils.equals(zipEntry.getName(), SO_INFO_FILE_NAME)) {
                parseSoInfoFile(zipFile, zipEntry);
                return;
            }
        }
        if (TextUtils.equals(zipEntry.getName(), FILE_PATCH_CLASSES_METHODS) || TextUtils.equals(zipEntry.getName(), FILE_ADDED_CLASSES) || zipEntry.getName().startsWith(FILE_DEOPTIMIZE_METHODS_PREFIX) || zipEntry.getName().endsWith(".dex")) {
            parseJavaPatchFile(zipFile, zipEntry);
        }
    }

    private void parseSoInfoFile(ZipFile zipFile, ZipEntry zipEntry) {
        try {
            FileUtils.write(zipFile.getInputStream(zipEntry), this.soInfoFile);
        } catch (IOException e) {
            throw new PatchParseException("parse so-info.txt failed. ", e, 401);
        }
    }

    private void parseJavaPatchFile(ZipFile zipFile, ZipEntry zipEntry) {
        if (zipEntry.getSize() <= 0) {
            return;
        }
        try {
            FileUtils.write(zipFile.getInputStream(zipEntry), new File(this.javaPatchRootDir, zipEntry.getName()));
        } catch (IOException e) {
            throw new PatchParseException("parse " + zipEntry.getName() + " failed.", e, PatchException.ERR_INSTALL_PARSE_JAVA_FILE);
        }
    }

    private void parseSoEntry(ZipFile zipFile, ZipEntry zipEntry) {
        String hostAbi = this.abiHelper.getHostAbi();
        SoFile parse = SoFileList.parse(zipEntry.getName());
        parse.crc = zipEntry.getCrc();
        try {
            if (TextUtils.equals(hostAbi, parse.cpuAbi)) {
                parse.outputFile = FileUtils.write(zipFile.getInputStream(zipEntry), new File(this.unzipDir, zipEntry.getName()));
            }
            SoFileList soFileList = this.soFiles.get(parse.cpuAbi);
            if (soFileList == null) {
                soFileList = new SoFileList(parse.cpuAbi);
                this.soFiles.put(parse.cpuAbi, soFileList);
            }
            soFileList.addSoFile(parse);
        } catch (IOException e) {
            throw new PatchParseException("parse patch so entry failed. ", e, PatchException.ERR_INSTALL_PARSE_SO);
        }
    }

    public File getSoInfoFile() {
        return this.soInfoFile;
    }

    public SoFileList getTargetAbiSoList() {
        return this.soFiles.get(this.abiHelper.getHostAbi());
    }

    public boolean hasSoLibraries() {
        return !this.soFiles.isEmpty();
    }

    public boolean hasJavaPatchFile() {
        return !FileUtils.isEmpty(this.javaPatchRootDir);
    }

    public File getJavaPatchRootDir() {
        return this.javaPatchRootDir;
    }
}
