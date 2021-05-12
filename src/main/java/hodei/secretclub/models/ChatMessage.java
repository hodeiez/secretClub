package hodei.secretclub.models;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Hodei Eceiza
 * Date: 5/9/2021
 * Time: 23:02
 * Project: secretClub
 * Copyright: MIT
 */
@Getter
@Setter
public class ChatMessage {
    private MessageType type;
    private String content;
    private String sender;

    public enum MessageType{
        CHAT,JOIN,LEAVE;
    }


}
