package eu.onak.hb2;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Person {
    @Id
    @GeneratedValue()
    private Long id;
    private String name;
    @JoinColumn(name = "address" )
    private Address address;

}
