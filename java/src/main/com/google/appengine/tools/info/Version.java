// Copyright 2009 Google Inc. All Rights Reserved.

package com.google.appengine.tools.info;

import java.util.Collections;
import java.util.Date;
import java.util.Set;

/**
 * {@code Version} supplies information about Google App Engine
 * versions.
 *
 */
public class Version {
  public static final Version UNKNOWN = new Version(null, null, null);

  private final String release;
  private final Date timestamp;
  private final Set<String> apiVersions;

  Version(String release, Date timestamp, Set<String> apiVersions) {
    this.release = release;
    this.timestamp = timestamp;

    if (apiVersions == null) {
      this.apiVersions = null;
    } else {
      this.apiVersions = Collections.unmodifiableSet(apiVersions);
    }
  }

  /**
   * Returns the logical release name (e.g. 1.0.0), or {@code null} if
   * no release information is available.
   */
  public String getRelease() {
    return release;
  }

  /**
   * Returns the {@link Date} that the build was done, or {@code null}
   * if no timestamp is available.
   */
  public Date getTimestamp() {
    return timestamp;
  }

  /**
   * Returns a {@link Set} of all support API versions, or {@code null} if no
   * timestamp is available.
   */
  public Set<String> getApiVersions() {
    return apiVersions;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    if (release == null) {
      builder.append("Release: (unknown)\n");
    } else {
      builder.append("Release: " + release + "\n");
    }
    if (timestamp == null) {
      builder.append("Timestamp: (unknown)\n");
    } else {
      builder.append("Timestamp: " + timestamp + "\n");
    }
    if (apiVersions != null) {
      builder.append("API versions: " + apiVersions + "\n");
    } else {
      builder.append("API versions: (unknown)\n");
    }
    return builder.toString();
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((apiVersions == null) ? 0 : apiVersions.hashCode());
    result = prime * result + ((release == null) ? 0 : release.hashCode());
    result = prime * result + ((timestamp == null) ? 0 : timestamp.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof Version)) {
      return false;
    }
    Version other = (Version) obj;
    if (apiVersions == null) {
      if (other.apiVersions != null) {
        return false;
      }
    } else if (!apiVersions.equals(other.apiVersions)) {
      return false;
    }
    if (release == null) {
      if (other.release != null) {
        return false;
      }
    } else if (!release.equals(other.release)) {
      return false;
    }
    if (timestamp == null) {
      if (other.timestamp != null) {
        return false;
      }
    } else if (!timestamp.equals(other.timestamp)) {
      return false;
    }
    return true;
  }
}
