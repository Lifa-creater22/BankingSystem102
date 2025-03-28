package za.ac.cput;

import za.ac.cput.Domain.Address;
import za.ac.cput.Domain.Contact;
import za.ac.cput.Domain.Customer;

public class Main {
    public static void main(String[] args) {
        Address add = new Address.Builder().setHouseNumber("10").build();
        System.out.println(add);
        Contact contact = new Contact.Builder().setEmail("ttt").build();
        System.out.println(contact);

        Customer cus1 = new Customer.Builder().setCustomerName("Thabiso").setCustomerSurname("Mbatha").setCustomerAddress(new Address.Builder().setHouseNumber("10").setStreetName("Dorset").setSuburb("Woodstock").setCity("Cape Town").setPostalCode(1234).setCountry("Mzansi").build()).setCustomerContact(new Contact.Builder().setPhoneNumber("0761234567").setEmail("222222222@mycput.ac.za").build()).build();

        System.out.println(cus1);
        System.out.println(cus1);
    }
}
