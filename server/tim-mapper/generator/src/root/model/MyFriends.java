package root.model;

import java.util.Date;

public class MyFriends {
    private String id;

    private Integer myId;

    private Integer myFriendId;

    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getMyId() {
        return myId;
    }

    public void setMyId(Integer myId) {
        this.myId = myId;
    }

    public Integer getMyFriendId() {
        return myFriendId;
    }

    public void setMyFriendId(Integer myFriendId) {
        this.myFriendId = myFriendId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}