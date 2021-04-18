package hodei.secretclub.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

/**
 * Created by Hodei Eceiza
 * Date: 4/18/2021
 * Time: 22:04
 * Project: secretClub
 * Copyright: MIT
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="message")
public class Message {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="message_id")
    private int id;
    @Column(name="message_text")
    @NotEmpty(message="write something")
    @Lob
    private String messageText;
    @ManyToOne
    @JoinColumn(name="FKpost",referencedColumnName = "post_id")
    @JsonBackReference
    private Post post;

    @ManyToOne
    @JoinColumn(name="FKuser_id",referencedColumnName="user_id")
    @JsonBackReference
    private User user;


}
