package application.features.user.domain.dto;


import java.time.LocalDateTime;
import java.util.UUID;

public class ResponseUserDto {
    private Long id;
    private UUID uuid;
    private String name;
    private String email;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
