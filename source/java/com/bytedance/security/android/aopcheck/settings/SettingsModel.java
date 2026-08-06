package com.bytedance.security.android.aopcheck.settings;

import com.google.gson.annotations.SerializedName;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes5.dex */
public class SettingsModel {

    @SerializedName("version")
    private String version = "";

    @SerializedName("name")
    private String name = "";

    @SerializedName("path_traversal_intercept_enabled")
    private Boolean pathTraversalInterceptEnabled = false;

    @SerializedName("path_traversal_file_intercept_enabled")
    private Boolean enableFileIntercept = false;

    @SerializedName("path_traversal_file_input_stream_intercept_enabled")
    private Boolean enableFileInputStreamIntercept = false;

    @SerializedName("path_traversal_file_output_stream_intercept_enabled")
    private Boolean enableFileOutputStreamIntercept = false;

    @SerializedName("path_traversal_file_reader_intercept_enabled")
    private Boolean enableFileReaderIntercept = false;

    @SerializedName("path_traversal_file_writer_intercept_enabled")
    private Boolean enableFileWriterIntercept = false;

    @SerializedName("path_traversal_zip_file_intercept_enabled")
    private Boolean enableZipFileIntercept = false;

    @SerializedName("path_traversal_content_resolver_intercept_enabled")
    private Boolean enableContentResolverIntercept = false;

    @SerializedName("path_traversal_enabled")
    private Boolean pathTraversalEnabled = true;

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public Boolean getPathTraversalEnabled() {
        return this.pathTraversalEnabled;
    }

    public void setPathTraversalEnabled(Boolean bool) {
        this.pathTraversalEnabled = bool;
    }

    public Boolean getEnableFileIntercept() {
        return this.enableFileIntercept;
    }

    public void setEnableFileIntercept(Boolean bool) {
        this.enableFileIntercept = bool;
    }

    public Boolean getEnableFileInputStreamIntercept() {
        return this.enableFileInputStreamIntercept;
    }

    public void setEnableFileInputStreamIntercept(Boolean bool) {
        this.enableFileInputStreamIntercept = bool;
    }

    public Boolean getEnableFileOutputStreamIntercept() {
        return this.enableFileOutputStreamIntercept;
    }

    public void setEnableFileOutputStreamIntercept(Boolean bool) {
        this.enableFileOutputStreamIntercept = bool;
    }

    public Boolean getEnableFileReaderIntercept() {
        return this.enableFileReaderIntercept;
    }

    public void setEnableFileReaderIntercept(Boolean bool) {
        this.enableFileReaderIntercept = bool;
    }

    public Boolean getEnableFileWriterIntercept() {
        return this.enableFileWriterIntercept;
    }

    public void setEnableFileWriterIntercept(Boolean bool) {
        this.enableFileWriterIntercept = bool;
    }

    public Boolean getEnableZipFileIntercept() {
        return this.enableZipFileIntercept;
    }

    public void setEnableZipFileIntercept(Boolean bool) {
        this.enableZipFileIntercept = bool;
    }

    public Boolean getEnableContentResolverIntercept() {
        return this.enableContentResolverIntercept;
    }

    public void setEnableContentResolverIntercept(Boolean bool) {
        this.enableContentResolverIntercept = bool;
    }

    public String toString() {
        return "SettingsModel{pathTraversalInterceptEnabled=" + this.pathTraversalInterceptEnabled + ", enableFileIntercept=" + this.enableFileIntercept + ", enableFileInputStreamIntercept=" + this.enableFileInputStreamIntercept + ", enableFileOutputStreamIntercept=" + this.enableFileOutputStreamIntercept + ", enableFileReaderIntercept=" + this.enableFileReaderIntercept + ", enableFileWriterIntercept=" + this.enableFileWriterIntercept + ", pathTraversalInterceptEnabled=" + this.pathTraversalInterceptEnabled + ", enableZipFileIntercept=" + this.enableZipFileIntercept + ", enableContentResolverIntercept=" + this.enableContentResolverIntercept + AbstractJsonLexerKt.END_OBJ;
    }

    public Boolean getPathTraversalInterceptEnabled() {
        return this.pathTraversalInterceptEnabled;
    }

    public void setPathTraversalInterceptEnabled(Boolean bool) {
        this.pathTraversalInterceptEnabled = bool;
    }
}
