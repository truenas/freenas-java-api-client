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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAlias;

public class Disk {

    @JsonAlias("disk_acousticlevel")
    @JsonProperty("acousticlevel")
    private String diskAcousticLevel; //DISALBED, MINIMUM, MEDIUM, or MAXIMUM
    @JsonAlias("disk_advpowermgmt")
    @JsonProperty("advpowermgmt")
    private String diskAdvPowerMgmt; //ENUM
    @JsonAlias("disk_serial")
    @JsonProperty("serial")
    private String diskSerial;
    @JsonAlias("disk_size")
    @JsonProperty("size")
    private Long diskSize;
    @JsonAlias("disk_multipath_name")
    @JsonProperty("multipath_name")
    private String diskMultiPathName;
    @JsonAlias("disk_identifier")
    @JsonProperty("identifier")
    private String diskIdentifier;
    @JsonAlias("disk_togglesmart")
    @JsonProperty("togglesmart")
    private Boolean diskToggleSmart;
    @JsonAlias("disk_hddstandby")
    @JsonProperty("hddstandby")
    private String diskHddStandBy; //ENUM
    @JsonAlias("disk_transfermode")
    @JsonProperty("transfermode")
    private String diskTransferMode;
    @JsonAlias("disk_multipath_member")
    @JsonProperty("multipath_member")
    private String multiPathMember;
    @JsonAlias("disk_description")
    @JsonProperty("description")
    private String diskDescription;
    @JsonAlias("disk_smartoptions")
    @JsonProperty("smartoptions")
    private String diskSmartOptions;
    @JsonAlias("disk_expiretime")
    @JsonProperty("expiretime")
    private String diskExpireTime;
    @JsonAlias("disk_name")
    @JsonProperty("name")
    private String diskName;
    /*
     * Other fields
     *  rotationrate
     *  type
     *  devname
     *  enclosure
     *  model
     *  informational
     *  difference
     *  critical
     *  hddstandby_force
     *  number
     *  subsystem
    */

    public String getDiskAcousticLevel() {
        return diskAcousticLevel;
    }

    public void setDiskAcousticLevel(String diskAcousticLevel) {
        this.diskAcousticLevel = diskAcousticLevel;
    }

    public String getDiskAdvPowerMgmt() {
        return diskAdvPowerMgmt;
    }

    public void setDiskAdvPowerMgmt(String diskAdvPowerMgmt) {
        this.diskAdvPowerMgmt = diskAdvPowerMgmt;
    }

    public String getDiskSerial() {
        return diskSerial;
    }

    public void setDiskSerial(String diskSerial) {
        this.diskSerial = diskSerial;
    }

    public Long getSize() {
        return diskSize;
    }

    public void setSize(Long diskSize) {
        this.diskSize = diskSize;
    }

    public String getDiskMultiPathName() {
        return diskMultiPathName;
    }

    public void setDiskMultiPathName(String diskMultiPathName) {
        this.diskMultiPathName = diskMultiPathName;
    }

    public String getDiskIdentifier() {
        return diskIdentifier;
    }

    public void setDiskIdentifier(String diskIdentifier) {
        this.diskIdentifier = diskIdentifier;
    }

    public Boolean getDiskToggleSmart() {
        return diskToggleSmart;
    }

    public void setDiskToggleSmart(Boolean diskToggleSmart) {
        this.diskToggleSmart = diskToggleSmart;
    }

    public String getDiskHddStandBy() {
        return diskHddStandBy;
    }

    public void setDiskHddStandBy(String diskHddStandBy) {
        this.diskHddStandBy = diskHddStandBy;
    }

    public String getDiskTransferMode() {
        return diskTransferMode;
    }

    public void setDiskTransferMode(String diskTransferMode) {
        this.diskTransferMode = diskTransferMode;
    }

    public String getMultiPathMember() {
        return multiPathMember;
    }

    public void setMultiPathMember(String multiPathMember) {
        this.multiPathMember = multiPathMember;
    }

    public String getDiskDescription() {
        return diskDescription;
    }

    public void setDiskDescription(String diskDescription) {
        this.diskDescription = diskDescription;
    }

    public String getDiskSmartOptions() {
        return diskSmartOptions;
    }

    public void setDiskSmartOptions(String diskSmartOptions) {
        this.diskSmartOptions = diskSmartOptions;
    }

    public String getDiskExpireTime() {
        return diskExpireTime;
    }

    public void setDiskExpireTime(String diskExpireTime) {
        this.diskExpireTime = diskExpireTime;
    }

    public String getDiskName() {
        return diskName;
    }

    public void setDiskName(String diskName) {
        this.diskName = diskName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Disk disk = (Disk) o;

        if (diskAcousticLevel != null ? !diskAcousticLevel.equals(disk.diskAcousticLevel) : disk.diskAcousticLevel != null)
            return false;
        if (diskAdvPowerMgmt != null ? !diskAdvPowerMgmt.equals(disk.diskAdvPowerMgmt) : disk.diskAdvPowerMgmt != null)
            return false;
        if (diskSerial != null ? !diskSerial.equals(disk.diskSerial) : disk.diskSerial != null) return false;
        if (diskMultiPathName != null ? !diskMultiPathName.equals(disk.diskMultiPathName) : disk.diskMultiPathName != null)
            return false;
        if (diskIdentifier != null ? !diskIdentifier.equals(disk.diskIdentifier) : disk.diskIdentifier != null)
            return false;
        if (diskToggleSmart != null ? !diskToggleSmart.equals(disk.diskToggleSmart) : disk.diskToggleSmart != null)
            return false;
        if (diskHddStandBy != null ? !diskHddStandBy.equals(disk.diskHddStandBy) : disk.diskHddStandBy != null)
            return false;
        if (diskTransferMode != null ? !diskTransferMode.equals(disk.diskTransferMode) : disk.diskTransferMode != null)
            return false;
        if (multiPathMember != null ? !multiPathMember.equals(disk.multiPathMember) : disk.multiPathMember != null)
            return false;
        if (diskDescription != null ? !diskDescription.equals(disk.diskDescription) : disk.diskDescription != null)
            return false;
        if (diskSmartOptions != null ? !diskSmartOptions.equals(disk.diskSmartOptions) : disk.diskSmartOptions != null)
            return false;
        if (diskExpireTime != null ? !diskExpireTime.equals(disk.diskExpireTime) : disk.diskExpireTime != null)
            return false;
        return diskName != null ? diskName.equals(disk.diskName) : disk.diskName == null;
    }

    @Override
    public int hashCode() {
        int result = diskAcousticLevel != null ? diskAcousticLevel.hashCode() : 0;
        result = 31 * result + (diskAdvPowerMgmt != null ? diskAdvPowerMgmt.hashCode() : 0);
        result = 31 * result + (diskSerial != null ? diskSerial.hashCode() : 0);
        result = 31 * result + (diskMultiPathName != null ? diskMultiPathName.hashCode() : 0);
        result = 31 * result + (diskIdentifier != null ? diskIdentifier.hashCode() : 0);
        result = 31 * result + (diskToggleSmart != null ? diskToggleSmart.hashCode() : 0);
        result = 31 * result + (diskHddStandBy != null ? diskHddStandBy.hashCode() : 0);
        result = 31 * result + (diskTransferMode != null ? diskTransferMode.hashCode() : 0);
        result = 31 * result + (multiPathMember != null ? multiPathMember.hashCode() : 0);
        result = 31 * result + (diskDescription != null ? diskDescription.hashCode() : 0);
        result = 31 * result + (diskSmartOptions != null ? diskSmartOptions.hashCode() : 0);
        result = 31 * result + (diskExpireTime != null ? diskExpireTime.hashCode() : 0);
        result = 31 * result + (diskName != null ? diskName.hashCode() : 0);
        return result;
    }
}
