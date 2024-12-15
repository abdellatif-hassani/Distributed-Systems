//package ma.enset.customerservice.mappers;
//
//import ma.enset.customerservice.dtos.CustomerDTO;
//import ma.enset.customerservice.entities.Customer;
//
//public interface CustomerMapper {
//    CustomerDTO entityToDTO(Customer customer);
//    Customer dtoToEntity(CustomerDTO customerDTO);
//}

package ma.enset.customerservice.mappers;

import ma.enset.customerservice.dtos.CustomerDTO;
import ma.enset.customerservice.entities.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerDTO toCustomerDTO(Customer customer);

    Customer toCustomer(CustomerDTO customerDTO);
}