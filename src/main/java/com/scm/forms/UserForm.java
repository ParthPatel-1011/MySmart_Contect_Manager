package com.scm.forms;

import org.springframework.format.annotation.NumberFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserForm {

    @NotBlank(message = "Username is required")
    @Size(min = 3,message = "Min 3 characters required in UserName")
    private String name;

    // @Pattern(
    //     regexp = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$",
    //     message = "Invalid email format. Example: user@example.com"
    // )
    @NotBlank(message = "Email is required")
    @Email(message = "Invalide Email Address")
    private String email;

    // @Pattern(
    //     regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,20}$",
    //     message = "Password must contain at least one digit, one lowercase letter, one uppercase letter, one special character, and no whitespace"
    // )
    @NotBlank(message = "Password is required")
    @Size(min = 6,message = "Min 6 characters required in Password")
    private String password;

    @NotBlank(message = "About is required")
    @Size(max = 1000, message = "About must be less than 1000 characters")
    private String about;

    @Size(max = 1000, message = "About must be less than 1000 characters")
    @Pattern(regexp = "^[0-9]+$", message = "Invalid Phone Number: Must contain only digits")
    @Size(min = 8, max = 12, message = "Invalide Phone Number")
    private String phoneNumber;

}
