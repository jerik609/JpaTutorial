package com.jerikthedog.SpringDataJpaTutorial.entity;


// we want the guardian data to be in the same table as student
// but we want this data to be in a separate class

// basically our model is better off with this data separated,
// while the database is better off with this data in the same table

// so we'll embed this guys

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@AttributeOverrides({
        @AttributeOverride(
                name = "name",
                column = @Column(name = "guardian_name")
        ),
        @AttributeOverride(
                name = "email",
                column = @Column(name = "guardian_email")
        ),
        @AttributeOverride(
                name = "mobile",
                column = @Column(name = "guardian_mobile")
        )
})
public class Guardian {

    // but now the column name in the tbl_student (guardian name) differs from the property
    // so we must map it (and the others too), this is done by attribute override ^^^
    private String name;
    private String email;
    private String mobile;
}
