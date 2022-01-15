package rmit.rmitsb.model;

import lombok.*;
import javax.persistence.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "category", uniqueConstraints = {@UniqueConstraint(columnNames = {"cateId"})})
public class Category {
    @SequenceGenerator(
            name = "category_sequence_generator",
            sequenceName = "category_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "category_sequence"
    )
    private Long cateId;
    @Column
    private String cateType;

}
