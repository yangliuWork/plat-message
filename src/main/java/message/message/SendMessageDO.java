package message.message;

/**
 * 发送消息
 */
public class SendMessageDO {

    /**
     * 聊天内容
     */
    private String message;

    /**
     * 发送用户
     */
    private String sendUser;

    /**
     * 接收用户
     */
    private String toUser;





    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSendUser() {
        return sendUser;
    }

    public void setSendUser(String sendUser) {
        this.sendUser = sendUser;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }
}
