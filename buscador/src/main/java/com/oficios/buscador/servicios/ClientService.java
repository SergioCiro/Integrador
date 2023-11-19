package com.oficios.buscador.servicios;

import com.oficios.buscador.entidades.Client;
import com.oficios.buscador.enumeraciones.Roll;
import com.oficios.buscador.excepciones.MyException;
import com.oficios.buscador.repositorios.ClientRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ClientService implements UserDetailsService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional
    public void CreateClient(String name, String email, String password, String password2, Date registerDate, Roll roll) throws MyException {

        validate(name, email, password, password2, registerDate, roll);

        Client client = new Client();
        client.setClientName(name);
        client.setClientEmail(email);
        client.setPassword(new BCryptPasswordEncoder().encode(password));
        client.setRegistrerDate(registerDate);
        client.setRoll(roll.USER);
        clientRepository.save(client);

    }
     @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Client client = clientRepository.findByEmail(email);

        if (client != null) {

            List<GrantedAuthority> permissions = new ArrayList();

            GrantedAuthority p = new SimpleGrantedAuthority("ROLE_" + client.getRoll().toString());

            permissions.add(p);

           return new User(client.getClientEmail(), client.getPassword(), permissions);

        } else {

            return null;
        }
    

}

    public void validate(String nombre, String email, String password, String password2, Date registerDate, Roll roll) throws MyException {

        if (nombre == null || nombre.isEmpty()) {
            throw new MyException("Nombre es un campo requerido");
        }

        if (email == null || email.isEmpty()) {
            throw new MyException("Email es un campo requerido");
        }

        if (password == null || password.length() <= 5) {
            throw new MyException("La contraseña debe tener al menos 6 caracteres");
        }

        if (!password.equals(password2)) {
            throw new MyException("Las contraseñas no coinciden");
        }

        if (registerDate == null) {
            throw new MyException("La fecha de registro es un campo requerido");
        }

        if (roll == null) {
            throw new MyException("El rol es un campo requerido");
        }

    }

   
}
