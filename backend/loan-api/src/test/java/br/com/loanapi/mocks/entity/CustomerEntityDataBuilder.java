package br.com.loanapi.mocks.entity;

import br.com.loanapi.mocks.dto.AddressDTODataBuilder;
import br.com.loanapi.mocks.dto.CustomerDTODataBuilder;
import br.com.loanapi.models.entities.CustomerEntity;
import br.com.loanapi.models.entities.PhoneEntity;
import br.com.loanapi.models.entities.ScoreEntity;

import java.util.ArrayList;
import java.util.List;

public class CustomerEntityDataBuilder {

    CustomerEntity customer;
    CustomerEntityDataBuilder(){}

    public static CustomerEntityDataBuilder builder(){

        CustomerEntityDataBuilder builder = new CustomerEntityDataBuilder();
        builder.customer = new CustomerEntity();

        ScoreEntity score = new ScoreEntity(1L, 50.0, null);

        builder.customer.setId(1L);
        builder.customer.setName("João");
        builder.customer.setLastName("da Silva");
        builder.customer.setBirthDate("11-11-2011");
        builder.customer.setSignUpDate("11-11-2021");
        builder.customer.setRg("55.626.926-4");
        builder.customer.setCpf("391.534.277-44");
        builder.customer.setEmail("joao@email.com");
        builder.customer.setAddress(AddressEntityDataBuilder.builder().build());
        builder.customer.setScore(score);
        builder.customer.setPhones(null);
        builder.customer.setLoans(null);

        return builder;
    }

    public CustomerEntityDataBuilder withPhoneList() {
        List<PhoneEntity> phones = new ArrayList<>();
        phones.add(PhoneEntityDataBuilder.builder().build());
        customer.setPhones(phones);
        return this;
    }

    public CustomerEntityDataBuilder withAddresssWithCustomers() {
        customer.setAddress(AddressEntityDataBuilder.builder().withCustomersList().build());
        return this;
    }

    public CustomerEntity build(){
        return customer;
    }

}
