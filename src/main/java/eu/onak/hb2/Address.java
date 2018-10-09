package eu.onak.hb2;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Address {
    @Id
    @GeneratedValue()
    private Long id;
    private String street;
    private String number;
    private String code;
}
