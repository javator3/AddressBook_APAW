package pl.sda.addressbook.model;

import lombok.*;

import java.util.Objects;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class AddressJson {

    private String name;
    private String lastName;
    private String street;
    private String city;
    private String postalCode;
    private String telephone;





}
