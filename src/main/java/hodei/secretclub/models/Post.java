package hodei.secretclub.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

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
@Table(name="post")
public class Post {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="post_id")
    private int id;
    @Column(name="post_title")
   // @NotEmpty(message="write a title")
    private String postTitle;
    @Column(name="post_text")
   // @NotEmpty(message="write something")
    @Lob
    private String postText;
    @OneToMany(mappedBy="post")
    @JsonManagedReference
    private List<Message> message;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="post_created")
    private Date postCreated;
    @ManyToOne
    @JoinColumn (name="FKuser_id",referencedColumnName = "user_id")
    @JsonBackReference
    private User user;



}
