package com.monitor.cloudmessage.upload.entity;

import com.monitor.cloudmessage.upload.callback.IFileUploadCallback;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes7.dex */
public class FileUploadInfo extends UploadInfo {
    protected IFileUploadCallback callback;
    protected String fileType;
    protected boolean forceUseState;
    protected boolean isCompress;
    protected boolean isDelSourceFile;
    protected boolean isMultiFileInOneZip;
    protected boolean isSkipUploadInternal;
    private List<String> mUploadFileAbsluteNames;

    public FileUploadInfo(String str, long j, boolean z, String str2, IFileUploadCallback iFileUploadCallback, HashMap<String, String> hashMap) {
        super(j, z, str2, hashMap);
        this.isSkipUploadInternal = true;
        this.isCompress = true;
        this.isMultiFileInOneZip = true;
        this.isDelSourceFile = false;
        this.forceUseState = false;
        this.fileType = str;
        this.callback = iFileUploadCallback;
    }

    public String getFileType() {
        return this.fileType;
    }

    public void setFileType(String str) {
        this.fileType = str;
    }

    public IFileUploadCallback getCallback() {
        return this.callback;
    }

    public void setCallback(IFileUploadCallback iFileUploadCallback) {
        this.callback = iFileUploadCallback;
    }

    public boolean isSkipUploadInternal() {
        return this.isSkipUploadInternal;
    }

    public void setSkipUploadInternal(boolean z) {
        this.isSkipUploadInternal = z;
    }

    public boolean isCompress() {
        return this.isCompress;
    }

    public void setCompress(boolean z) {
        this.isCompress = z;
    }

    public boolean isMultiFileInOneZip() {
        return this.isMultiFileInOneZip;
    }

    public void setMultiFileInOneZip(boolean z) {
        this.isMultiFileInOneZip = z;
    }

    public boolean isDelSourceFile() {
        return this.isDelSourceFile;
    }

    public void setDelSourceFile(boolean z) {
        this.isDelSourceFile = z;
    }

    public List<String> getUploadFileAbsluteNames() {
        return this.mUploadFileAbsluteNames;
    }

    public void setUploadFileAbsluteNames(List<String> list) {
        this.mUploadFileAbsluteNames = list;
    }

    public boolean isForceUseState() {
        return this.forceUseState;
    }

    public void setForceUseState(boolean z) {
        this.forceUseState = z;
    }
}
