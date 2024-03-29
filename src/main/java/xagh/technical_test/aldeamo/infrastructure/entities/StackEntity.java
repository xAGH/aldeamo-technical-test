package xagh.technical_test.aldeamo.infrastructure.entities;

import java.io.Serial;
import java.io.Serializable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// Entity used to relation 'arrays' table on the database usign JPA.
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "arrays")
public class StackEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "input_array", nullable = false, length = 20)
    private String inputArray;
}
