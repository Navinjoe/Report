package jasper.repo.userrepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jasper.entity.user.User;
@Repository
public interface userrepo extends JpaRepository <User,Long> {

}
