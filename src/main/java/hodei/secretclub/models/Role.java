package hodei.secretclub.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by Hodei Eceiza
 * Date: 4/17/2021
 * Time: 22:29
 * Project: secretClub
 * Copyright: MIT
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="roles")
public class Role {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="role_id")
    private int id;
    @Column(name="role")
    private String role;
}
