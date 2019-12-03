package spring.hibernate.hsqldb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring.hibernate.hsqldb.domain.Profile;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, Long> {
}
