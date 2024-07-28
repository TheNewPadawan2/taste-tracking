package it.uniecampus.lfulgione.tastetracking.ttbe.login.mapper;

import it.uniecampus.lfulgione.tastetracking.ttbe.login.dto.LoginResponseDTO;
import it.uniecampus.lfulgione.tastetracking.ttbe.login.dto.SignupRequestDTO;
import it.uniecampus.lfulgione.tastetracking.ttbe.login.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    @Mapping(source = "taxId", target = "tax")
    UserEntity entity(SignupRequestDTO dto);

    @Mapping(source = "tax", target = "taxId")
    SignupRequestDTO dto(UserEntity entity);

    LoginResponseDTO loginResponseDTO(UserEntity entity);
}
