package kth.chem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kth.chem.models.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
}
