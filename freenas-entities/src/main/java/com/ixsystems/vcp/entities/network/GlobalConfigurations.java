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
 * * Neither the name of py-bsd nor the names of its
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
package com.ixsystems.vcp.entities.network;

public class GlobalConfigurations {

    private String gcHostnameVirtual;
    private String gcHosts;
    private String gcDomains;
    private String gcHostname;
    private String gcNameservers1;
    private String gcNameservers2;
    private String gcHttpProxy;
    private String domains;
    private Boolean gcNetwaitEnabled;
    private String gcIpv4Gateway;
    private String id;
    private String gcHostnameB;
    private String gcIpv6Gateway;
    private String gcNetwaitIp;

    public String getGcDomain() {
        return gcDomain;
    }

    public void setGcDomain(String gcDomain) {
        this.gcDomain = gcDomain;
    }

    private String gcDomain;

    public String getGcHostnameVirtual() {
        return gcHostnameVirtual;
    }

    public void setGcHostnameVirtual(String gcHostnameVirtual) {
        this.gcHostnameVirtual = gcHostnameVirtual;
    }

    public String getGcHosts() {
        return gcHosts;
    }

    public void setGcHosts(String gcHosts) {
        this.gcHosts = gcHosts;
    }

    public String getGcDomains() {
        return gcDomains;
    }

    public void setGcDomains(String gcDomains) {
        this.gcDomains = gcDomains;
    }

    public String getGcHostname() {
        return gcHostname;
    }

    public void setGcHostname(String gcHostname) {
        this.gcHostname = gcHostname;
    }

    public String getGcNameservers1() {
        return gcNameservers1;
    }

    public void setGcNameservers1(String gcNameservers1) {
        this.gcNameservers1 = gcNameservers1;
    }

    public String getGcNameservers2() {
        return gcNameservers2;
    }

    public void setGcNameservers2(String gcNameservers2) {
        this.gcNameservers2 = gcNameservers2;
    }

    public String getGcHttpProxy() {
        return gcHttpProxy;
    }

    public void setGcHttpProxy(String gcHttpProxy) {
        this.gcHttpProxy = gcHttpProxy;
    }

    public String getDomains() {
        return domains;
    }

    public void setDomains(String domains) {
        this.domains = domains;
    }

    public Boolean getGcNetwaitEnabled() {
        return gcNetwaitEnabled;
    }

    public void setGcNetwaitEnabled(Boolean gcNetwaitEnabled) {
        this.gcNetwaitEnabled = gcNetwaitEnabled;
    }

    public String getGcIpv4Gateway() {
        return gcIpv4Gateway;
    }

    public void setGcIpv4Gateway(String gcIpv4Gateway) {
        this.gcIpv4Gateway = gcIpv4Gateway;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGcHostnameB() {
        return gcHostnameB;
    }

    public void setGcHostnameB(String gcHostnameB) {
        this.gcHostnameB = gcHostnameB;
    }

    public String getGcIpv6Gateway() {
        return gcIpv6Gateway;
    }

    public void setGcIpv6Gateway(String gcIpv6Gateway) {
        this.gcIpv6Gateway = gcIpv6Gateway;
    }

    public String getGcNetwaitIp() {
        return gcNetwaitIp;
    }

    public void setGcNetwaitIp(String gcNetwaitIp) {
        this.gcNetwaitIp = gcNetwaitIp;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GlobalConfigurations that = (GlobalConfigurations) o;

        if (gcHostnameVirtual != null ? !gcHostnameVirtual.equals(that.gcHostnameVirtual) : that.gcHostnameVirtual != null)
            return false;
        if (gcHosts != null ? !gcHosts.equals(that.gcHosts) : that.gcHosts != null) return false;
        if (gcDomains != null ? !gcDomains.equals(that.gcDomains) : that.gcDomains != null) return false;
        if (gcHostname != null ? !gcHostname.equals(that.gcHostname) : that.gcHostname != null) return false;
        if (gcNameservers1 != null ? !gcNameservers1.equals(that.gcNameservers1) : that.gcNameservers1 != null)
            return false;
        if (gcNameservers2 != null ? !gcNameservers2.equals(that.gcNameservers2) : that.gcNameservers2 != null)
            return false;
        if (gcHttpProxy != null ? !gcHttpProxy.equals(that.gcHttpProxy) : that.gcHttpProxy != null) return false;
        if (domains != null ? !domains.equals(that.domains) : that.domains != null) return false;
        if (gcNetwaitEnabled != null ? !gcNetwaitEnabled.equals(that.gcNetwaitEnabled) : that.gcNetwaitEnabled != null)
            return false;
        if (gcIpv4Gateway != null ? !gcIpv4Gateway.equals(that.gcIpv4Gateway) : that.gcIpv4Gateway != null)
            return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (gcHostnameB != null ? !gcHostnameB.equals(that.gcHostnameB) : that.gcHostnameB != null) return false;
        if (gcIpv6Gateway != null ? !gcIpv6Gateway.equals(that.gcIpv6Gateway) : that.gcIpv6Gateway != null)
            return false;
        return gcNetwaitIp != null ? gcNetwaitIp.equals(that.gcNetwaitIp) : that.gcNetwaitIp == null;
    }

    @Override
    public int hashCode() {
        int result = gcHostnameVirtual != null ? gcHostnameVirtual.hashCode() : 0;
        result = 31 * result + (gcHosts != null ? gcHosts.hashCode() : 0);
        result = 31 * result + (gcDomains != null ? gcDomains.hashCode() : 0);
        result = 31 * result + (gcHostname != null ? gcHostname.hashCode() : 0);
        result = 31 * result + (gcNameservers1 != null ? gcNameservers1.hashCode() : 0);
        result = 31 * result + (gcNameservers2 != null ? gcNameservers2.hashCode() : 0);
        result = 31 * result + (gcHttpProxy != null ? gcHttpProxy.hashCode() : 0);
        result = 31 * result + (domains != null ? domains.hashCode() : 0);
        result = 31 * result + (gcNetwaitEnabled != null ? gcNetwaitEnabled.hashCode() : 0);
        result = 31 * result + (gcIpv4Gateway != null ? gcIpv4Gateway.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (gcHostnameB != null ? gcHostnameB.hashCode() : 0);
        result = 31 * result + (gcIpv6Gateway != null ? gcIpv6Gateway.hashCode() : 0);
        result = 31 * result + (gcNetwaitIp != null ? gcNetwaitIp.hashCode() : 0);
        return result;
    }
}
