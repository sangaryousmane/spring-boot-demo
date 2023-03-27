package com.dailycodebuffer.springbootdemo.entities.jpa;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
@Embeddable
@AttributeOverrides({
        @AttributeOverride(
                name = "name",
                column = @Column(name = "guardian_name")),
        @AttributeOverride(
                name = "email",
                column = @Column(name = "guardian_email")),
        @AttributeOverride(
                name = "mobile",
                column = @Column(name = "guardian_mobile"))
})
public class Guardian {

    private String guardian_name;
    private String guardian_email;
    private String guardian_mobile;
}
