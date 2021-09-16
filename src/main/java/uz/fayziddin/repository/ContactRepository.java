package uz.fayziddin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import uz.fayziddin.entity.Contact;

public interface ContactRepository extends MongoRepository<Contact, String> {
    
}
