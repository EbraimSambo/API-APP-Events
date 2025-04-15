package application.features.auth.adapters.out.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SignInDto {
    @NotNull(message = "O email nao pode esrar vazio e nem nullo")
    @Email(message = "Formato de email invalido")
    private String email;

    @NotNull(message = "A password nao pode esrar vazio e nem nullo")
    private String password;
}
