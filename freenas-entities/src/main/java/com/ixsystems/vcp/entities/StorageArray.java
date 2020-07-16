/**
 * Copyright (C) 2018 iXsystems
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * * Neither the name of freenas-java-api-client nor the names of its
 *   contributors may be used to endorse or promote products derived from
 *   this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.ixsystems.vcp.entities;

import java.net.MalformedURLException;
import java.net.URL;

public class StorageArray {
	private long id;
	private String ip;
	private String port;
	private String username;
	private String password;
	private String version;

	private String protocol;
	
	private String apiVersion = "v2.0";
	
	private long totalSize;
	
	private long usedSize;
	
	private long freeSize;
	
	private String status = "";
	
	private boolean authenticated = false;
	
	private long lastAlertTimestamp = 0L;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	protected String getApiVersion() {
		return apiVersion;
	}

	protected void setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
	}
	
	public long getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(long totalSize) {
		this.totalSize = totalSize;
	}

	public long getUsedSize() {
		return usedSize;
	}

	public void setUsedSize(long usedSize) {
		this.usedSize = usedSize;
	}

	public long getFreeSize() {
		return freeSize;
	}

	public void setFreeSize(long freeSize) {
		this.freeSize = freeSize;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isAuthenticated() {
		return authenticated;
	}

	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}

	public URL getUrl() throws MalformedURLException {

		StringBuffer urlString = new StringBuffer();
		urlString.append(getProtocol());
		urlString.append("://");
		urlString.append(getIp());
		urlString.append(":");
		urlString.append(getPort() + "/");
		urlString.append("api" + "/");
		urlString.append(getApiVersion());
		URL url = new URL(urlString.toString());
		return url;
	}
	
	public long getLastAlertTimestamp() {
		return lastAlertTimestamp;
	}

	public void setLastAlertTimestamp(long lastAlertTimestamp) {
		this.lastAlertTimestamp = lastAlertTimestamp;
	}

	@Override
	public String toString() {
		return "StorageArray [id=" + id + ", ip=" + ip + ", port=" + port
				+ ", version=" + version + ", protocol=" + protocol
				+ ", totalSize=" + totalSize + ", usedSize=" + usedSize
				+ ", freeSize=" + freeSize + ", status=" + status
				+ ", authenticated=" + authenticated + "]";
	}
}
