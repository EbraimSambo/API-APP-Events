package application.features.user.adapters.out.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserDto {
    @NotNull(message = "O name nao pode esrar vazio e nem nullo")
    private String name;

    @NotNull(message = "O email nao pode esrar vazio e nem nullo")
    @Email(message = "Formato de email invalido")
    private String email;

    @NotNull(message = "A password nao pode esrar vazio e nem nullo")
    private String password;
}
