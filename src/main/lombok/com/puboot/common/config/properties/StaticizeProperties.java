// Generated by delombok at Wed Apr 13 12:12:31 CST 2022
package com.puboot.common.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "static")
public class StaticizeProperties {
    private String accessPathPattern = "/html/**";
    private String folder;

    @java.lang.SuppressWarnings("all")
    public StaticizeProperties() {
    }

    @java.lang.SuppressWarnings("all")
    public String getAccessPathPattern() {
        return this.accessPathPattern;
    }

    @java.lang.SuppressWarnings("all")
    public String getFolder() {
        return this.folder;
    }

    @java.lang.SuppressWarnings("all")
    public void setAccessPathPattern(final String accessPathPattern) {
        this.accessPathPattern = accessPathPattern;
    }

    @java.lang.SuppressWarnings("all")
    public void setFolder(final String folder) {
        this.folder = folder;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    public boolean equals(final java.lang.Object o) {
        if (o == this) return true;
        if (!(o instanceof StaticizeProperties)) return false;
        final StaticizeProperties other = (StaticizeProperties) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
        final java.lang.Object this$accessPathPattern = this.getAccessPathPattern();
        final java.lang.Object other$accessPathPattern = other.getAccessPathPattern();
        if (this$accessPathPattern == null ? other$accessPathPattern != null : !this$accessPathPattern.equals(other$accessPathPattern)) return false;
        final java.lang.Object this$folder = this.getFolder();
        final java.lang.Object other$folder = other.getFolder();
        if (this$folder == null ? other$folder != null : !this$folder.equals(other$folder)) return false;
        return true;
    }

    @java.lang.SuppressWarnings("all")
    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof StaticizeProperties;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final java.lang.Object $accessPathPattern = this.getAccessPathPattern();
        result = result * PRIME + ($accessPathPattern == null ? 43 : $accessPathPattern.hashCode());
        final java.lang.Object $folder = this.getFolder();
        result = result * PRIME + ($folder == null ? 43 : $folder.hashCode());
        return result;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    public java.lang.String toString() {
        return "StaticizeProperties(accessPathPattern=" + this.getAccessPathPattern() + ", folder=" + this.getFolder() + ")";
    }
}