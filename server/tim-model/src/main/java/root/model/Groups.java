package root.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Groups {
    private String id;

    private String groupNumber;

    private String groupFaceimageBig;

    private String groupName;

    private String groupDescription;

    private String qrcode;

    private Integer usersNum;

    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber == null ? null : groupNumber.trim();
    }

    public String getGroupFaceimageBig() {
        return groupFaceimageBig;
    }

    public void setGroupFaceimageBig(String groupFaceimageBig) {
        this.groupFaceimageBig = groupFaceimageBig == null ? null : groupFaceimageBig.trim();
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    public String getGroupDescription() {
        return groupDescription;
    }

    public void setGroupDescription(String groupDescription) {
        this.groupDescription = groupDescription == null ? null : groupDescription.trim();
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode == null ? null : qrcode.trim();
    }

    public Integer getUsersNum() {
        return usersNum;
    }

    public void setUsersNum(Integer usersNum) {
        this.usersNum = usersNum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}